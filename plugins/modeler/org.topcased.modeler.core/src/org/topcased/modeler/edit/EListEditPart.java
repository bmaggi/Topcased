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
package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.commands.DeleteGraphElementCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.edit.policies.DeleteModelObjectEditPolicy;
import org.topcased.modeler.edit.policies.EListLayoutEditPolicy;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.figures.EListFigure;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.listeners.DiagramElementListener;
import org.topcased.modeler.listeners.GraphNodeListener;
import org.topcased.modeler.tools.Importer;
import org.topcased.modeler.utils.Utils;

/**
 * This edit part adds abilities for model objects linked with the EStructuralFeature of an EMF object.<br>
 * 
 * Creation : 09 jan. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EListEditPart extends BaseEditPart implements IModelElementEditPart
{

    /**
     * Typed listener for a GraphNode
     * 
     * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
     */
    protected class EListEditPartListener extends GraphNodeListener
    {
        protected void handleSizeChanged()
        {
            // Do nothing
        }

        protected void handlePositionChanged()
        {
            // Do nothing
        }

        protected void handleContainmentChanged()
        {
            refreshChildren();
        }

        protected void handleConnectorChanged()
        {
            // Do nothing
        }

        protected void handleVisibilityChanged()
        {
            // Do nothing
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handlePresentationChanged()
         */
        protected void handlePresentationChanged()
        {
            // Do nothing
        }

        protected void handlePropertyChanged(Property oldProperty, Property newProperty)
        {
            // Handle specific properties
        }
    }

    private EStructuralFeature[] eStructuralFeature;

    private DiagramElementListener diagramListener = new EListEditPartListener();

    private boolean isSynchronized = false;

    /**
     * Constructor
     * 
     * @param obj
     * @param feature the list of EStructuralFeature available for thie elisteditpart
     */
    public EListEditPart(GraphNode obj, EStructuralFeature... feature)
    {
        super(obj);
        eStructuralFeature = feature;
    }

    /**
     * @see org.topcased.modeler.edit.BaseEditPart#getDiagramElementListener()
     */
    protected DiagramElementListener getDiagramElementListener()
    {
        return diagramListener;
    }

    /**
     * @see org.eclipse.gef.EditPart#activate()
     */
    public void activate()
    {
        super.activate();

        getDiagramElementListener().activate(getGraphNode());

        if (getEObject() != null && !getEObject().eAdapters().contains(getModelListener()))
        {
            getEObject().eAdapters().add(getModelListener());
        }
    }

    /**
     * @see org.eclipse.gef.EditPart#deactivate()
     */
    public void deactivate()
    {
        if (getEObject() != null)
        {
            getEObject().eAdapters().remove(getModelListener());
        }
        getDiagramElementListener().deactivate(getGraphNode());

        super.deactivate();
    }

    /**
     * Returns <code>true</code> if this editpart is synchronized with the model content
     * 
     * @return the synchronization state
     */
    public boolean isSynchronized()
    {
        return isSynchronized;
    }

    /**
     * Set the synchronization state of this editpart
     * 
     * @param isSynchro if <code>true</code> the content of the list is synchronized with the model content.
     */
    public void setSynchronized(boolean isSynchro)
    {
        this.isSynchronized = isSynchro;
    }

    /**
     * Creates edit policies and associates these with roles <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void createEditPolicies()
    {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.LAYOUT_ROLE, new EListLayoutEditPolicy(isSynchronized,getEStructuralFeatures()));

        // Provide the Policy to delete the model object associated with the
        // EMFGraphNode
        installEditPolicy(ModelerEditPolicyConstants.DELETE_MODEL_OBJECT_EDITPOLICY, new DeleteModelObjectEditPolicy(this));
    }

    /**
     * Get the EStructuralFeature that contains the objects that are associated with the list
     * 
     * @return EStructuralFeature
     * @deprecated use {@link #getEStructuralFeatures()} instead
     */
    public EStructuralFeature getEStructuralFeature()
    {
        return eStructuralFeature[0];
    }

    /**
     * Get the EStructuralFeature features that contains the objects that are associated with the list
     * 
     * @return array of EStructuralFeature features
     */
    public EStructuralFeature[] getEStructuralFeatures()
    {
        return eStructuralFeature;
    }
    
    /**
     * Get the graphNode model object (DI) associated with the EditPart
     * 
     * @return GraphNode
     */
    protected GraphNode getGraphNode()
    {
        return (GraphNode) getModel();
    }

    /**
     * Retrieve the model object
     * 
     * @return the EObject associated with the EMFGraphNodeEditPart
     */
    public EObject getEObject()
    {
        return Utils.getElement((GraphElement) getModel());
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure()
    {
        return new EListFigure();
    }

    /**
     * @see org.eclipse.gef.EditPart#isSelectable()
     */
    public boolean isSelectable()
    {
        return false;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
     */
    protected List getModelChildren()
    {
        if (isSynchronized)
        {
            for (EStructuralFeature structuralFeature : getEStructuralFeatures())
            {
                Object featureObj = getEObject().eGet(structuralFeature);
                if (featureObj instanceof List)
                {
                    List modelChildren = (List) featureObj;
                    // update the graphnode children
                    // 1- Iterates on children and remove the ones without an
                    // existing
                    // eobject in the given EList
                    // 2- Iterates on EList and add the ones without an associated
                    // graphnode
                    // 3- Returns the graphnode children

                    // 1-
                    removeUnusedNodes(modelChildren);

                    // 2-
                    createNewNodes(modelChildren);
                }
            }
        }

        // 3-
        List graphNodeChildren = new ArrayList();
        Iterator it = getGraphNode().getContained().iterator();
        while (it.hasNext())
        {
            DiagramElement elt = (DiagramElement) it.next();
            if (elt instanceof GraphNode)
            {
                graphNodeChildren.add(elt);
            }
        }
        return graphNodeChildren;
    }

    /**
     * This method synchronizes the graphical objects with the model children
     * 
     * @param modelChildren the model children to display
     */
    protected void createNewNodes(List<EObject> modelChildren)
    {
        List<EObject> unknownObjects = new ArrayList<EObject>();
        for (EObject eObject : modelChildren)
        {
            if (Utils.getGraphElements(getGraphNode(), eObject, false).isEmpty())
            {
                unknownObjects.add(eObject);
            }
        }
        if (!unknownObjects.isEmpty())
        {
            Modeler editor = ((ModelerGraphicalViewer) getViewer()).getModelerEditor();
            Importer importer = new Importer(editor, unknownObjects);
            try
            {
                CommandStack tmpStack = new CommandStack();
                importer.setCommandStack(tmpStack);
                importer.setTargetEditPart(this);
                Dimension insets = new Dimension(1, 1);
                getContentPane().translateToAbsolute(insets);
                importer.setLocation(getContentPane().getBounds().getTopLeft().translate(insets));
                importer.run(new NullProgressMonitor());
            }
            catch (BoundsFormatException bfe)
            {
                ModelerPlugin.log("An error occurred during the graphical synchronization", bfe);
            }
            catch (IllegalArgumentException iae)
            {
                ModelerPlugin.log("An error occurred during the graphical synchronization", iae);
            }
            catch (InterruptedException ie)
            {
                ModelerPlugin.log("An error occurred during the graphical synchronization", ie);
            }
        }
    }

    /**
     * emoves the contained graphnodes that do not reference a valid child
     * 
     * @param modelChildren the list of valid children
     */
    protected void removeUnusedNodes(List<EObject> modelChildren)
    {
        CommandStack stack = new CommandStack();
        List<DiagramElement> removedNodes = new ArrayList<DiagramElement>();
        for (DiagramElement elt : getGraphNode().getContained())
        {
            if (elt instanceof GraphNode)
            {
                GraphNode node = (GraphNode) elt;
                EObject obj = Utils.getElement(node);
                if (obj == null || !modelChildren.contains(obj))
                {
                    removedNodes.add(elt);
                }
            }
        }
        if (!removedNodes.isEmpty())
        {
            CompoundCommand cmd = new CompoundCommand();
            for (DiagramElement elt : removedNodes)
            {
                cmd.add(new DeleteGraphElementCommand((GraphElement) elt, true));
            }

            stack.execute(cmd);
        }
    }

    /**
     * @see org.topcased.modeler.edit.BaseEditPart#handleModelChanged(Notification)
     */
    protected void handleModelChanged(Notification msg)
    {
        if (getEObject().eClass().isInstance(msg.getNotifier()))
        {
            for (EStructuralFeature handledFeature : getEStructuralFeatures())
            {
                if (handledFeature.getFeatureID() == msg.getFeatureID(getEObject().getClass()))
                {
                    refreshChildren();
                    return;
                }
            }
        }
    }

    /**
     * @see org.eclipse.gef.EditPart#getChildren()
     */
    public List getChildren()
    {
        if (children == null)
        {
            children = new ArrayList(2);
        }
        return children;
    }
}
