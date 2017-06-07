/*******************************************************************************
 * Copyright (c) 2005,2010 AIRBUS FRANCE.
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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.dialogs.ChooseGraphElementDialog;
import org.topcased.modeler.dialogs.DiagramSelectionDialog;
import org.topcased.modeler.edit.policies.DeleteModelObjectEditPolicy;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.ChangeActiveDiagramAction;
import org.topcased.modeler.internal.actions.CreateDiagramAction;
import org.topcased.modeler.providers.ILabelFeatureProvider;
import org.topcased.modeler.utils.Utils;

/**
 * This edit part adds abilities for model objects linked with EMF objects : listening... <br>
 * 
 * Creation : 6 December 2004<br>
 * Updated : 11 February 2010<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class EMFGraphNodeEditPart extends GraphNodeEditPart implements IModelElementEditPart
{
    /**
     * Constructor
     * 
     * @param obj
     */
    public EMFGraphNodeEditPart(GraphNode obj)
    {
        super(obj);
    }

    /**
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class key)
    {
        if (key.isInstance(getEObject()))
        {
            return getEObject();
        }

        return super.getAdapter(key);
    }

    /**
     * @see org.eclipse.gef.EditPart#activate()
     */
    public void activate()
    {
        super.activate();

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

        super.deactivate();
    }

    /**
     * This method is called when an event occured on the model objects
     * 
     * @param msg the event notification
     */
    protected void handleModelChanged(Notification msg)
    {
        refreshVisuals();
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies()
    {
        super.createEditPolicies();

        // Provide the Policy to delete the model object associated with the EMFGraphNode
        installEditPolicy(ModelerEditPolicyConstants.DELETE_MODEL_OBJECT_EDITPOLICY, new DeleteModelObjectEditPolicy(this));
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#registerVisuals()
     */
    protected void refreshVisuals()
    {
        super.refreshVisuals();

        refreshHeaderLabel();
    }

    /**
     * Update the outline with this element.
     */
    protected void refreshOutline()
    {
        if (getViewer() instanceof ModelerGraphicalViewer)
        {
            ModelerGraphicalViewer viewer = ((ModelerGraphicalViewer) getViewer());
            Modeler modeler = viewer.getModelerEditor();
            if (modeler != null)
            {
                modeler.updateOutlineElement(getEObject());
            }
        }
    }

    /**
     * Refresh the text to display with the content of the LabelFeatureProvider
     */
    protected void refreshHeaderLabel()
    {
        if (getEditableLabel() != null && getEObject() != null && getViewer() != null)
        {
            EditDomain domain = getViewer().getEditDomain();
            IMixedEditDomain mixedEditDomain = null;
            if (domain instanceof IMixedEditDomain)
            {
                mixedEditDomain = (IMixedEditDomain) domain;
            }
            else if (domain instanceof Adaptable)
            {
                mixedEditDomain = ((Adaptable) domain).getAdapter(IMixedEditDomain.class);
            }
            if (mixedEditDomain != null)
            {
                ILabelFeatureProvider featureProvider = (ILabelFeatureProvider) mixedEditDomain.getAdapterFactory().adapt(getEObject(), ILabelFeatureProvider.class);
                EAttribute eAttribute = null;
                if (featureProvider != null)
                {
                    eAttribute = featureProvider.getLabelFeature(getEObject());

                    if (eAttribute != null)
                    {
                        Object eAttributeValue = getEObject().eGet(eAttribute);

                        if (eAttributeValue != null)
                        {
                            if (eAttributeValue instanceof String)
                            {
                                getEditableLabel().setText((String) eAttributeValue);
                            }
                            else
                            {
                                ModelerPlugin.log("The LabelFeature of this object is not a String.", IStatus.WARNING);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Handles the double-click request. Used to open a new diagram from a Node of the current Diagram
     * 
     * @see org.eclipse.gef.EditPart#performRequest(org.eclipse.gef.Request)
     */
    public void performRequest(Request request)
    {
        if (request.getType() == RequestConstants.REQ_OPEN)
        {
            if (getViewer() instanceof ModelerGraphicalViewer)
            {

                // save the active tool
                Tool activeTool = getViewer().getEditDomain().getActiveTool();

                // deactivate the active tool
                getViewer().getEditDomain().setActiveTool(null);
                getViewer().getEditDomain().getPaletteViewer().setActiveTool(null);

                // The action to execute if a the active diagram must change
                IAction action = createChangeDiagramAction(getEObject());

                if (action != null)
                {
                    action.run();
                }
                else
                {
                    // restore the active tool
                    getViewer().getEditDomain().setActiveTool(activeTool);
                }
            }
        }
        else
        {
            super.performRequest(request);
        }
    }

    /**
     * Create the action to change the active diagram for the given model object.<br>
     * <ul>
     * <li>If there is no diagram, the user can choose the one to create.</li>
     * <li>If several diagrams already exist, a dialog is displayed to choose the target one.</li>
     * <li>If one diagram already exists, it is the target.</li>
     * </ul>
     * 
     * @param modelObject the model in which the user wants to go
     * @return the action that creates or changes the diagram
     */
    protected IAction createChangeDiagramAction(EObject modelObject)
    {
        Modeler editor = ((ModelerGraphicalViewer) getViewer()).getModelerEditor();

        IAction action = null;
        // We search if a diagram already exists and let the user choose if at
        // least two exist.
        List<Diagram> existingDiagramList = DiagramsUtils.findAllExistingDiagram(editor.getDiagrams(), modelObject);
        if (existingDiagramList != null && existingDiagramList.size() > 0)
        {
            Diagram selectedDiagram = (Diagram) chooseGraphElement(existingDiagramList.toArray(new Diagram[existingDiagramList.size()]));
            if (selectedDiagram != null)
            {
                action = new ChangeActiveDiagramAction(editor, selectedDiagram);
            }
        }
        // else we first check whether the node is in the current edited model and whether it can be associated with a
        // diagram
        else if (EcoreUtil.isAncestor(editor.getDiagrams().getModel(), getEObject()))
        {
            action = createNewDiagram(editor, modelObject);
        }

        return action;
    }

    /**
     * Returns the destination GraphElement from a choices list
     * 
     * @param elements the list of available GraphElements
     * @return the selected GraphElement
     */
    private GraphElement chooseGraphElement(GraphElement[] elements)
    {
        GraphElement chosenElt = null;
        if (elements.length == 1)
        {
            chosenElt = elements[0];
        }
        else
        {
            ChooseGraphElementDialog dialog = new ChooseGraphElementDialog(getViewer().getControl().getShell(), getViewer().getEditDomain(), elements);

            if (dialog.open() == Window.OK)
            {
                Object[] selection = dialog.getResult();

                if (selection != null && selection.length > 0)
                {
                    chosenElt = (GraphElement) selection[0];
                }
            }
        }

        return chosenElt;
    }

    /**
     * Create a New Diagram for the current EMFGraphNode. Check first if a diagram can be created. If it is OK, display
     * a Dialog window to give the user choosing the type of Diagram he wants to create
     * 
     * @param editor the Modeler
     * @param modelObject the modelObject on which the diagram should be created
     * @return action the action to execute
     */
    private IAction createNewDiagram(Modeler editor, EObject modelObject)
    {
        List<DiagramDescriptor> diagramDescriptorsList = new ArrayList<DiagramDescriptor>();

        // Retrieve the DiagramDescriptors that can be created into this EObject
        DiagramDescriptor[] diagramDescriptors = DiagramsManager.getInstance().getDiagrams();
        for (int i = 0; i < diagramDescriptors.length; i++)
        {
            if (diagramDescriptors[i].canCreateDiagramOn(modelObject, ((ModelerGraphicalViewer) getViewer()).getModelerEditor().getId()))
            {
                diagramDescriptorsList.add(diagramDescriptors[i]);
            }
        }

        // at least one Diagram is available
        if (diagramDescriptorsList.size() > 0)
        {
            if (EditingDomainHelper.isEObjectReadOnly(modelObject))
            {
                MessageDialog.openWarning(ModelerPlugin.getActiveWorkbenchShell(), "Warning", "your element is read only you can't create diagrams");
            }
            else
            {
                // display the dialog window to let the user choose
                DiagramSelectionDialog diagramsDlg = new DiagramSelectionDialog(diagramDescriptorsList, ModelerPlugin.getActiveWorkbenchShell());
                if (diagramsDlg.open() == Window.OK)
                {
                    // create the associated Action
                    return new CreateDiagramAction(editor, modelObject, (DiagramDescriptor) diagramsDlg.getResult()[0], diagramsDlg.isInitialized());
                }
            }
        }
        return null;
    }

    /**
     * @see org.topcased.modeler.edit.IModelElementEditPart#getEObject()
     */
    public EObject getEObject()
    {
        return Utils.getElement((GraphElement) getModel());
    }

}
