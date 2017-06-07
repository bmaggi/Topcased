/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.commands;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.topcased.modeler.IAnnotationConstants;

/**
 * A class defining an abstract command for documentation resources. It offers methods to add and removes a map of
 * resources from an EAnnotation. Describe the class here <br>
 * 
 * Creation : 10 October. 2005<br>
 * Updated : 16 October 2008<br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 */
public abstract class AbstractDocumentationResourcesCommand extends AbstractCommand
{
    private EModelElement element;

    private Map<String, String> resources;

    /**
     * Constructor
     * 
     * @param element the modified model object
     * @param resources the list of annotated resources
     */
    protected AbstractDocumentationResourcesCommand(EModelElement element, Map<String, String> resources)
    {
        super();

        this.element = element;
        this.resources = resources;
    }

    /**
     * Adds the registered map of resources to the EModelElement
     */
    protected void addResources()
    {
        EAnnotation annotation = element.getEAnnotation(IAnnotationConstants.RESOURCES_SOURCE);
        if (resources != null && !resources.isEmpty())
        {
            // Creates EAnnotation if needed
            if (annotation == null)
            {
                annotation = EcoreFactory.eINSTANCE.createEAnnotation();
                annotation.setSource(IAnnotationConstants.RESOURCES_SOURCE);
                element.getEAnnotations().add(annotation);
            }

            // Add resources
            for (Iterator<Map.Entry<String, String>> it = resources.entrySet().iterator(); it.hasNext();)
            {
                Map.Entry<String, String> entry = it.next();
                annotation.getDetails().put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Removes the registered map of resources from the EModelElement
     */
    protected void removeResources()
    {
        EAnnotation annotation = element.getEAnnotation(IAnnotationConstants.RESOURCES_SOURCE);
        if (resources != null && !resources.isEmpty())
        {
            // Remove resources
            if (annotation != null)
            {
                for (Iterator<String> it = resources.keySet().iterator(); it.hasNext();)
                {
                    String key = it.next();
                    annotation.getDetails().removeKey(key);
                }

                // Remove the EAnnotation if empty
                if (annotation.getDetails().size() == 0)
                {
                    element.getEAnnotations().remove(annotation);
                }
            }
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    @Override
    public boolean canExecute()
    {
        return true;
    }
}
