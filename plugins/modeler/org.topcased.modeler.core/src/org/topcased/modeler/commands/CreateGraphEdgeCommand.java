/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.commands;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.utils.LabelHelper;
import org.topcased.modeler.utils.Utils;

/**
 * <b>Creation command for association </b> <br>
 * This command just add a graphEdge into a graphNode. It also add the contained element to the element of the parent
 * graph node if needed. <br>
 * <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class CreateGraphEdgeCommand extends Command
{
    /** The connection that the user creates */
    private GraphEdge edge;

    /** The source GraphElement */
    private GraphElement source;

    /** The target GraphElement */
    private GraphElement target;

    /** The GraphNode that will contains the connection */
    private GraphElement container;

    /** The EditDomain (used to init the name) */
    private EditDomain editDomain;

    /** A list of available features that could contains the Edge model object */
    private List<EStructuralFeature> features;

    /** The selected feature to store the Edge model object */
    private EStructuralFeature selectedFeature;

    private boolean updateModel = true;

    private EObject oldContainerModel;

    /**
     * Constructor. Call the super constructor with : - the container for the edge = the container of the source node -
     * the features list = null
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObj the edge to create
     * @param src the source node
     * @param needModelUpdate <code>true</code> if the model must be modified during this command, <code>false</code> if
     *        objects already exist in the mode.
     */
    public CreateGraphEdgeCommand(EditDomain domain, GraphEdge newObj, GraphElement src, boolean needModelUpdate)
    {
        this(domain, newObj, src, null, needModelUpdate);
    }

    /**
     * Constructor
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObj the edge to create
     * @param src the source node
     * @param featuresList to be define
     * @param needModelUpdate <code>true</code> if the model must be modified during this command, <code>false</code> if
     *        objects already exist in the mode.
     */
    public CreateGraphEdgeCommand(EditDomain domain, GraphEdge newObj, GraphElement src, List<EStructuralFeature> featuresList, boolean needModelUpdate)
    {
        super(Messages.getString("CreateGraphEdgeCommand.CmdLabel")); //$NON-NLS-1$
        editDomain = domain;
        edge = newObj;
        source = src;
        features = featuresList;
        updateModel = needModelUpdate;
        oldContainerModel = Utils.getElement(edge) != null ? Utils.getElement(edge).eContainer() : null;
    }

    /**
     * Set the target node
     * 
     * @param target the target node
     */
    public void setTarget(GraphElement target)
    {
        this.target = target;
        container = DiagramsUtils.getNearestCommonParentGraphElement(source, target);
    }

    /**
     * Set the container element
     * 
     * @param element The element to set
     */
    public void setContainer(GraphElement element)
    {
        container = element;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        boolean result = !TopcasedAdapterFactoryEditingDomain.isEObjectReadOnly(this.source) && !TopcasedAdapterFactoryEditingDomain.isEObjectReadOnly(this.target);
        return result && (source != null && target != null && container != null && edge != null);
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        // TODO allow the user to choose the Feature he wants to work with
        if (selectedFeature == null && features != null)
        {
            selectedFeature = (EStructuralFeature) features.get(0);
        }

        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        if (source == target)
        {

            // Creates anchor if needed
            if (source.getAnchorage().isEmpty())
            {
                GraphConnector connector1 = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                source.getAnchorage().add(connector1);
            }
            if (source.getAnchorage().size() < 2)
            {
                GraphConnector connector2 = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                source.getAnchorage().add(connector2);
            }
            GraphConnector srcConnector = (GraphConnector) source.getAnchorage().get(0);
            GraphConnector targetConnector = (GraphConnector) source.getAnchorage().get(1);

            // add the edge to the graphical view
            srcConnector.getGraphEdge().add(edge);
            targetConnector.getGraphEdge().add(edge);
        }
        else
        {
            // Creates anchor if needed
            if (source.getAnchorage().isEmpty())
            {
                GraphConnector connector = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                source.getAnchorage().add(connector);
            }
            if (target.getAnchorage().isEmpty())
            {
                GraphConnector connector = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                target.getAnchorage().add(connector);
            }
            
            GraphConnector srcConnector = (GraphConnector) source.getAnchorage().get(0);
            GraphConnector targetConnector = (GraphConnector) target.getAnchorage().get(0);

            // add the edge to the graphical view
            srcConnector.getGraphEdge().add(edge);
            targetConnector.getGraphEdge().add(edge);
        }

        if (container != null)
        {
            // add the edge to the graphical view
            container.getContained().add(edge);
        }

        if (updateModel)
        {
            redoModel();
        }
    }

    /**
     * Update the model after at the end of the redo() method. This method should be overriden by subclasses.
     */
    protected void redoModel()
    {
        if (selectedFeature != null)
        {
            if (Utils.getElement(container) != null && Utils.getElement(edge) != null)
            {
                EList<EObject> ownerList = Utils.getOwnerList(Utils.getElement(container), selectedFeature);
                // add the edge to the model
                ownerList.add(Utils.getElement(edge));

                initName();
            }
        }
    }

    /**
     * Give a unique name to the model object inside the current diagram
     */
    protected void initName()
    {
        initName(Utils.getElement(container));
    }

    /**
     * Give a unique name to the model object inside the current diagram
     * 
     * @param cont The container model object of the connection
     */
    protected void initName(EObject cont)
    {
        // init the name of the model object
        String curName = LabelHelper.INSTANCE.getName(editDomain, Utils.getElement(edge));
        if (curName == null || "".equals(curName)) //$NON-NLS-1$
        {
            LabelHelper.INSTANCE.initName(editDomain, cont, Utils.getElement(edge));
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if (source == target)
        {
            edge.getWaypoints().clear();
            GraphConnector srcConnector = (GraphConnector) source.getAnchorage().get(0);
            GraphConnector targetConnector = (GraphConnector) source.getAnchorage().get(1);

            srcConnector.getGraphEdge().remove(edge);
            targetConnector.getGraphEdge().remove(edge);

            if (srcConnector.getGraphEdge().isEmpty())
            {
                source.getAnchorage().remove(srcConnector);
            }
            
            if (targetConnector.getGraphEdge().isEmpty())
            {
                source.getAnchorage().remove(targetConnector);
            }
        }
        else
        {
            GraphConnector srcConnector = (GraphConnector) source.getAnchorage().get(0);
            GraphConnector targetConnector = (GraphConnector) target.getAnchorage().get(0);

            srcConnector.getGraphEdge().remove(edge);
            targetConnector.getGraphEdge().remove(edge);
            
            if (srcConnector.getGraphEdge().isEmpty())
            {
                source.getAnchorage().remove(srcConnector);
            }
            
            if (targetConnector.getGraphEdge().isEmpty())
            {
                target.getAnchorage().remove(targetConnector);
            }
        }
        
        container.getContained().remove(edge);

        if (updateModel)
        {
            undoModel();
        }
    }

    /**
     * Update the model at the end of the undo() method. This method should be overriden by subclasses.
     */
    protected void undoModel()
    {
        if (selectedFeature != null)
        {
            if (Utils.getElement(container) != null && Utils.getElement(edge) != null)
            {
                EList<EObject> ownerList = Utils.getOwnerList(Utils.getElement(container), selectedFeature);
                ownerList.remove(Utils.getElement(edge));
            }

            if (oldContainerModel != null)
            {
                EList<EObject> ownerList = Utils.getOwnerList(oldContainerModel, selectedFeature);
                ownerList.add(Utils.getElement(edge));
            }
        }
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
     * Get the GraphEdge
     * 
     * @return GraphEdge
     */
    public GraphEdge getEdge()
    {
        return edge;
    }

    /**
     * Get the source GraphNode
     * 
     * @return GraphElement
     */
    public GraphElement getSource()
    {
        return source;
    }

    /**
     * Get the target GraphNode
     * 
     * @return GraphElement
     */
    public GraphElement getTarget()
    {
        return target;
    }

    /**
     * Get the container GraphElement
     * 
     * @return GraphElement
     */
    public GraphElement getContainer()
    {
        return container;
    }

    /**
     * Get the EditDomain
     * 
     * @return EditDomain
     */
    public EditDomain getEditDomain()
    {
        return editDomain;
    }

}
