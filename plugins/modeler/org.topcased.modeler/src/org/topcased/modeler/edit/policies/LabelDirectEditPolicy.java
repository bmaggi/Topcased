/***********************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.edit.policies;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.jface.viewers.CellEditor;
import org.topcased.modeler.commands.ChangeLabelTextCommand;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.edit.GraphNodeEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.providers.ILabelFeatureProvider;
import org.topcased.modeler.utils.Utils;

/**
 * Manage the DirectEditPolicy for a Label in the Editing Window
 * 
 * @author Jacques Lescot
 */
public class LabelDirectEditPolicy extends DirectEditPolicy
{
    private String oldValue;

    private EObject modelObject = null;

    /**
     * Getter on the old value
     */
    public String getOldValue()
    {
        return oldValue;
    }

    /**
     * @see org.eclipse.gef.editpolicies.DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
     */
    protected Command getDirectEditCommand(DirectEditRequest request)
    {
        modelObject = initModelObject();

        if (modelObject == null)
        {
            ModelerPlugin.log("Current model object is null. Unable to create command.", IStatus.ERROR);
            return UnexecutableCommand.INSTANCE;
        }

        CellEditor cellEditor = request.getCellEditor();
        ChangeLabelTextCommand command = new ChangeLabelTextCommand(modelObject, getLabelTextFeature());
        command.setOldName(oldValue);
        command.setName((String) cellEditor.getValue());
        return command;
    }

    /**
     * @see org.eclipse.gef.editpolicies.DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
     */
    protected void showCurrentEditValue(DirectEditRequest request)
    {
        String value = (String) request.getCellEditor().getValue();
        if (getHost() instanceof GraphNodeEditPart)
        {
            GraphNodeEditPart graphNodeEditPart = (GraphNodeEditPart) getHost();
            graphNodeEditPart.handleNameChange(value);
        }
    }

    /**
     * Saves the initial text value so that if the user's changes are not committed then
     * 
     * @param request
     */
    protected void storeOldEditValue(DirectEditRequest request)
    {
        oldValue = (String) request.getCellEditor().getValue();
    }

    /**
     * Initialize the model object used to support the label feature.
     * 
     * @return an EObject that will support the label value
     */
    protected EObject initModelObject()
    {
        EObject domainElement = null;
        if (getHost().getModel() instanceof GraphElement)
        {
            return Utils.getElement((GraphElement) getHost().getModel());
        }
        return domainElement;
    }

    /**
     * By default, we retrieve the labelFeature : this is the feature configured in the GenModel file.
     * 
     * @return an EStructuralFeature used to support the text value
     */
    protected EStructuralFeature getLabelTextFeature()
    {
        EStructuralFeature labelFeature = null;

        EditDomain domain = getHost().getViewer().getEditDomain();
        IMixedEditDomain mixedDom = null;
        if (domain instanceof IMixedEditDomain)
        {
            mixedDom = (IMixedEditDomain) domain;
        }
        else if (domain instanceof Adaptable)
        {
            mixedDom = ((Adaptable) domain).getAdapter(IMixedEditDomain.class);
        }
        if (mixedDom != null)
        {
            ILabelFeatureProvider featureProvider = (ILabelFeatureProvider) mixedDom.getAdapterFactory().adapt(modelObject, ILabelFeatureProvider.class);
            if (featureProvider != null)
            {
                labelFeature = featureProvider.getLabelFeature(modelObject);
            }
        }
        return labelFeature;
    }

}
