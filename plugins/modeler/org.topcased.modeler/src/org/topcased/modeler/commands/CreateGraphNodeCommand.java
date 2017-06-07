/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.commands;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.editor.IConfiguration;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.utils.LabelHelper;
import org.topcased.modeler.utils.Utils;

/**
 * <b>Node creation </b> <br>
 * This command just add a graphNode into another. It also add the contained element to the element of the parentNode
 * graph node if needed. <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class CreateGraphNodeCommand extends Command
{
    private Point newPosition;

    private Dimension newSize;

    private int newAttachment = PositionConstants.NONE;

    // The old position and size are stored for restore the GraphNode in the
    // case of a DND Command
    private Point oldPosition;

    private Dimension oldSize;

    private int oldAttachment = PositionConstants.NONE;

    private EditDomain editDomain;

    private GraphNode childNode;

    private GraphNode parentNode;

    private EObject oldParentModel;

    private EObject parentModel;

    private EObject childModel;

    private List<? extends EStructuralFeature> features;

    private EStructuralFeature selectedFeature;

    private boolean updateModel = true;

    /**
     * Constructor
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObject the node to create
     * @param newParent the parentNode node
     * @param location the location of the created node
     * @param dimension the size of the created node
     * @param featuresList the available model element feature of the parentNode node where the model element of the
     *        childNode node can be added
     * @param needModelUpdate <code>true</code> if the model must be modified during this command, <code>false</code> if
     *        objects already exist in the mode.
     */
    public CreateGraphNodeCommand(EditDomain domain, GraphNode newObject, GraphNode newParent, Point location, Dimension dimension, List<EStructuralFeature> featuresList, boolean needModelUpdate)
    {
        this(domain, newObject, newParent, Utils.getElement(newParent), location, dimension, PositionConstants.NONE, featuresList, needModelUpdate);
    }

    /**
     * Constructor
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObject the node to create
     * @param newParent the parentNode node
     * @param newContainerParent the model object that should contain the new childNode object
     * @param location the location of the created node
     * @param dimension the size of the created node
     * @param attach the newAttachment of the created node
     * @param featuresList the available model element feature of the parentNode node where the model element of the
     *        childNode node can be added
     * @param needModelUpdate <code>true</code> if the model must be modified during this command, <code>false</code> if
     *        objects already exist in the mode.
     */
    public CreateGraphNodeCommand(EditDomain domain, GraphNode newObject, GraphNode newParent, EObject newContainerParent, Point location, Dimension dimension, int attach,
            List<? extends EStructuralFeature> featuresList, boolean needModelUpdate)
    {
        super(Messages.getString("CreateGraphNodeCommand.CmdLabel")); //$NON-NLS-1$
        editDomain = domain;

        childNode = newObject;
        parentNode = newParent;

        childModel = Utils.getElement(childNode);
        parentModel = newContainerParent;

        newPosition = location;
        newSize = dimension;
        newAttachment = attach;

        features = featuresList;
        updateModel = needModelUpdate;

        // TODO allow the user to choose the Feature he wants to work with
        if (features != null)
        {
            selectedFeature = features.get(0);
            if (!parentModel.eClass().getEAllStructuralFeatures().contains(selectedFeature))
            {
                selectedFeature = null;
            }
        }
    }

    /**
     * Constructor - Add simply a graphNode to its container Node without updating the model
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObject the node to create
     * @param newParent the parentNode node
     * @param location the location of the created node
     * @param dimension the size of the created node
     * @param attach the newAttachment of the created node
     */
    public CreateGraphNodeCommand(EditDomain domain, GraphNode newObject, GraphNode newParent, Point location, Dimension dimension, int attach)
    {
        super(Messages.getString("CreateGraphNodeCommand.CmdLabel")); //$NON-NLS-1$
        editDomain = domain;

        childNode = newObject;
        parentNode = newParent;

        newPosition = location;
        newSize = dimension;
        newAttachment = attach;

        updateModel = false;
    }

    /**
     * Check if the object that we try to add to the model is not already set (because the cardinality is 1)
     * 
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    @Override
    public boolean canExecute()
    {
        // the drag'n'drop is always authorized
        if (updateModel && selectedFeature != null && parentModel != null)
        {
            // command cannot be executed if the parent model object is in read-only
            IMixedEditDomain mixedDom = null;
            if (editDomain instanceof IMixedEditDomain)
            {
                mixedDom = (IMixedEditDomain) editDomain;
            }
            else if (editDomain instanceof Adaptable)
            {
                mixedDom = ((Adaptable) editDomain).getAdapter(IMixedEditDomain.class);
            }
            if (mixedDom !=null)
            {
                EditingDomain emfDomain = mixedDom.getEMFEditingDomain();
                if (emfDomain.isReadOnly(parentModel.eResource()))
                {
                    return false;
                }
            }

            // Check whether the cardinality is 1 and the object is already set
            if (selectedFeature.isMany())
            {
                EList<EObject> ownerList = Utils.getOwnerList(parentModel, selectedFeature);
                return !ownerList.contains(childModel);
            }
            else
            {
                return !parentModel.eIsSet(selectedFeature);
            }
        }
        return !EditingDomainHelper.isEObjectReadOnly(parentNode);
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    @Override
    public void execute()
    {
        IConfiguration configuration = null;
        try
        {
            configuration = DiagramsManager.getInstance().getConfiguration(Utils.getDiagram(parentNode).getSemanticModel().getPresentation());
        }
        catch (CoreException ce)
        {
            ModelerPlugin.log(ce);
        }

        NodeGraphConf nodeGraphConf = null;
        if (Utils.getElement(childNode) != null)
        {
            nodeGraphConf = Utils.getNodeGraphConf(configuration.getDiagramGraphConf(), Utils.getElement(childNode), childNode.getSemanticModel().getPresentation());
        }
        else
        {
            nodeGraphConf = configuration.getDiagramGraphConf().getNodeGraphConf(((SimpleSemanticModelElement) childNode.getSemanticModel()).getTypeInfo(),
                    childNode.getSemanticModel().getPresentation());
        }

        if (nodeGraphConf != null)
        {
            updateConstrainedSize(nodeGraphConf);
        }

        oldPosition = childNode.getPosition();
        oldSize = childNode.getSize();
        oldParentModel = childModel != null ? childModel.eContainer() : null;
        if (DIUtils.getProperty(childNode, ModelerPropertyConstants.PORT_POSITION) != null)
        {
            oldAttachment = StringConverter.asInt(DIUtils.getPropertyValue(childNode, ModelerPropertyConstants.PORT_POSITION));
        }

        redo();
    }

    private void updateConstrainedSize(NodeGraphConf nodeGraphConf)
    {
        // When the size has not been set yet, initialize it with the default
        // values
        if (newSize == null)
        {
            newSize = new Dimension(nodeGraphConf.getDefaultWidth(), nodeGraphConf.getDefaultHeight());
        }

        // Check whether the dimension is not smaller than the minimum size
        newSize.width = Math.max(newSize.width, nodeGraphConf.getMinimumWidth());
        newSize.height = Math.max(newSize.height, nodeGraphConf.getMinimumHeight());

        // Check whether the dimension is not larger than the maximum size
        if (nodeGraphConf.getMaximumWidth() != 0)
        {
            newSize.width = Math.min(newSize.width, nodeGraphConf.getMaximumWidth());
        }
        if (nodeGraphConf.getMaximumHeight() != 0)
        {
            newSize.height = Math.min(newSize.height, nodeGraphConf.getMaximumHeight());
        }

        // Initialize with the default size when the figure has not a resizable
        // width
        if (!nodeGraphConf.isIsWidthResizable())
        {
            newSize.width = nodeGraphConf.getDefaultWidth();
        }

        // Initialize with the default size when the figure has not a resizable
        // height
        if (!nodeGraphConf.isIsHeightResizable())
        {
            newSize.height = nodeGraphConf.getDefaultHeight();
        }
    }

    /**
     * Update the model after at the end of the redo() method. This method should be overriden by subclasses when
     * additionnal model changes are needed.
     */
    protected void redoModel()
    {
        if (selectedFeature != null && parentModel != null && childModel != null)
        {
            if (!selectedFeature.isMany())
            {
                parentModel.eSet(selectedFeature, childModel);
            }
            else
            {
                // Initialize the name of the model object
                String curName = LabelHelper.INSTANCE.getName(editDomain, childModel);
                if (curName == null || "".equals(curName)) //$NON-NLS-1$
                {
                    LabelHelper.INSTANCE.initName(editDomain, parentModel, childModel);
                }

                // Add the child model object to the list
                Utils.getOwnerList(parentModel, selectedFeature).add(childModel);
            }
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    @Override
    public void redo()
    {
        childNode.setPosition(newPosition);
        childNode.setSize(newSize);
        if (newAttachment != PositionConstants.NONE)
        {
            DIUtils.setProperty(childNode, ModelerPropertyConstants.PORT_POSITION, StringConverter.asString(newAttachment));
        }

        parentNode.getContained().add(childNode);

        if (updateModel)
        {
            redoModel();
        }
    }

    /**
     * Update the model at the end of the undo() method. This method should be overriden by subclasses.
     */
    protected void undoModel()
    {
        if (selectedFeature != null && parentModel != null && childModel != null)
        {
            EList<EObject> ownerList = Utils.getOwnerList(parentModel, selectedFeature);

            if (ownerList != null)
            {
                ownerList.remove(childModel);
            }
            else
            {
                parentModel.eUnset(selectedFeature);
            }

            if (oldParentModel != null)
            {
                EList<EObject> parentOwnerList = Utils.getOwnerList(oldParentModel, selectedFeature);

                if (parentOwnerList != null)
                {
                    parentOwnerList.add(childModel);
                }
                else
                {
                    oldParentModel.eSet(selectedFeature, childModel);
                }
            }
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    @Override
    public void undo()
    {
        parentNode.getContained().remove(childNode);

        // restore the initial position and size (useful for DND)
        childNode.setPosition(oldPosition);
        childNode.setSize(oldSize);
        if (oldAttachment != PositionConstants.NONE)
        {
            DIUtils.setProperty(childNode, ModelerPropertyConstants.PORT_POSITION, StringConverter.asString(oldAttachment));
        }

        if (updateModel)
        {
            undoModel();
        }
    }

    /**
     * Return the EditDomain associated with the command
     * 
     * @return the EditDomain
     */
    protected EditDomain getEditDomain()
    {
        return editDomain;
    }

    /**
     * Return the childNode EObject to create
     * 
     * @return the childNode EObject
     */
    public EObject getChildEObject()
    {
        return childModel;
    }

    /**
     * Return the childNode to create
     * 
     * @return the childNode
     */
    public GraphNode getChildNode()
    {
        return childNode;
    }

    /**
     * Return the parentNode EObject that will contain the childEObject
     * 
     * @return the parentNode EObject
     */
    protected EObject getParentEObject()
    {
        return parentModel;
    }

    /**
     * Return the parentNode that will contain the childNode
     * 
     * @return the parentNode
     */
    protected GraphNode getParentNode()
    {
        return parentNode;
    }

    /**
     * Return the EStructuralFeature where to add the childNode
     * 
     * @return the EStructuralFeature
     */
    protected EStructuralFeature getSelectedFeature()
    {
        return selectedFeature;
    }

    /**
     * Return a boolean value used to update or not the model
     * 
     * @return false if the command is coming from a DND request
     */
    protected boolean isUpdateModel()
    {
        return updateModel;
    }

    /**
     * @return the newPosition
     */
    public Point getNewPosition()
    {
        return newPosition;
    }

    /**
     * Does the model need to be updated?
     */
    protected boolean getUpdateModel()
    {
        return updateModel;
    }
}
