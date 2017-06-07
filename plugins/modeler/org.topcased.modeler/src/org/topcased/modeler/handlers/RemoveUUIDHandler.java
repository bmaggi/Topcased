/*****************************************************************************
 * Copyright (c) 2010 Communication & Systems
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors : Maxime AUDRAIN (CS) - initial API and implementation
 * 
 *****************************************************************************/
package org.topcased.modeler.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.IAnnotationConstants;

/**
 * An handler used to remove UUID Annotations that may have been added after a save with the TOPCASED graphical editor.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:maxime.audrain@c-s.fr">Maxime AUDRAIN</a>
 */
public class RemoveUUIDHandler extends AbstractHandler
{
    private EditingDomain editingDomain;

    /**
     * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        editingDomain = getEditingDomain(event);

        if (((EvaluationContext) event.getApplicationContext()).getDefaultVariable() instanceof List< ? >)
        {
            // Get the current selection
            List< ? > elements = ((List< ? >) ((EvaluationContext) event.getApplicationContext()).getDefaultVariable());
            if (elements.get(0) != null && editingDomain != null)
            {
                // The CompoundCommand where are added all the RemoveCommand commands
                CompoundCommand compoundCommand = new CompoundCommand();

                // Remove UUID on this object
                removeUUIDForEObject((EObject) elements.get(0), compoundCommand);

                // Remove UUID on children
                Iterator<EObject> itChildren = ((EObject) elements.get(0)).eAllContents();
                while (itChildren.hasNext())
                {
                    removeUUIDForEObject(itChildren.next(), compoundCommand);
                }

                // Execute the global command
                editingDomain.getCommandStack().execute(compoundCommand);
            }
        }
        return null;
    }

    /**
     * Remove UUID on elements : elements can only be modified if the class inherits from EModelElement
     * 
     * @param modelObject the model to modify
     * @param compoundCommand The CompoundCommand where the currentCommand should be appended
     */
    private void removeUUIDForEObject(EObject modelObject, CompoundCommand compoundCommand)
    {
        if (modelObject instanceof EModelElement)
        {
            if (((EModelElement) modelObject).getEAnnotation(IAnnotationConstants.UUID_SOURCE) != null)
            {
                compoundCommand.append(new RemoveCommand(editingDomain, modelObject, EcorePackage.eINSTANCE.getEModelElement_EAnnotations(),
                        ((EModelElement) modelObject).getEAnnotation(IAnnotationConstants.UUID_SOURCE)));
            }
        }
    }

    /**
     * This returns the editing domain associated with an IWorkbenchPart.
     * 
     * @param targetPart The IWorkbenchPart that is linked with the current selected EObject
     * @return The required editing domain or null when the part cannot be adapted in any EditingDomain.
     */
    private EditingDomain getEditingDomain(ExecutionEvent event)
    {
        // Get the IWorkbenchPart
        IWorkbenchPart targetPart = HandlerUtil.getActivePart(event);
        IEditorPart editorPart = HandlerUtil.getActiveEditor(event);

        if (targetPart.getAdapter(EditingDomain.class) != null)
        {
            return (EditingDomain) targetPart.getAdapter(EditingDomain.class);
        }

        if (editorPart instanceof IEditingDomainProvider)
        {
            return ((IEditingDomainProvider) editorPart).getEditingDomain();
        }

        return null;
    }
}
