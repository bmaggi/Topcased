/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.topcased.modeler.IAnnotationConstants;

/**
 * An EMF Command use to update documentation EAnnotation when an EModelElement is selected.
 * 
 * Updated : 16 October 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 */
public class ChangeDocumentationCommand extends AbstractCommand
{
    private EModelElement element;

    private String newComments;

    private String oldComments;

    /**
     * Constructor
     * 
     * @param element the EModelElement
     * @param newValue the new documentation as a String
     */
    public ChangeDocumentationCommand(EModelElement element, String newValue)
    {
        super("Change documentation of the selected EModelElement");

        this.element = element;
        this.newComments = newValue;
    }

    /**
     * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#execute()
     */
    public void execute()
    {
        // stores the previous doc
        oldComments = null;
        EAnnotation annotation = element.getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
        if (annotation != null)
        {
            oldComments = annotation.getDetails().get(IAnnotationConstants.DOCUMENTATION_KEY);
        }

        redo();
    }

    /**
     * Set the documentation for the given Model Element
     * 
     * @param elt the element to document
     * @param newDoc the documentation text
     */
    protected void changeDocumentation(EModelElement elt, String newDoc)
    {
        EAnnotation annotation = elt.getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
        if (newDoc != null && !"".equals(newDoc))
        {
            // creates EAnnotation if needed
            if (annotation == null)
            {
                annotation = EcoreFactory.eINSTANCE.createEAnnotation();
                annotation.setSource(IAnnotationConstants.DOCUMENTATION_SOURCE);
                elt.getEAnnotations().add(annotation);
            }

            annotation.getDetails().put(IAnnotationConstants.DOCUMENTATION_KEY, newDoc);
        }
        else
        {
            // remove the documentation
            if (annotation != null)
            {
                annotation.getDetails().remove(IAnnotationConstants.DOCUMENTATION_KEY);

                // remove the EAnnotation if empty
                if (annotation.getDetails().size() == 0)
                {
                    elt.getEAnnotations().remove(annotation);
                }
            }
        }
    }

    /**
     * @see org.eclipse.emf.common.command.Command#redo()
     */
    public void redo()
    {
        changeDocumentation(element, newComments);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    @Override
    public void undo()
    {
        changeDocumentation(element, oldComments);
    }

    /**
     * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
     */
    @Override
    public boolean canExecute()
    {
        return true;
    }
}
