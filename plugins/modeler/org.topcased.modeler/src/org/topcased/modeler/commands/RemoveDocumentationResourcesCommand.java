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

import java.util.Map;

import org.eclipse.emf.ecore.EModelElement;

/**
 * A class defining a command to add resources to an EModelElement documentation.<br>
 * 
 * Creation : 10 October 2005 Updated : 16 October 2008
 * 
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 */
public class RemoveDocumentationResourcesCommand extends AbstractDocumentationResourcesCommand
{
    /**
     * Constructor
     * 
     * @param resource The resource to modify
     * @param newResourceValue The new value to affect
     */
    public RemoveDocumentationResourcesCommand(EModelElement element, Map<String, String> resources)
    {
        super(element, resources);
        setLabel("Remove resources from EModelElement documentation");
    }

    /**
     * @see org.eclipse.emf.common.command.Command#execute()
     */
    public void execute()
    {
        redo();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#redo()
     */
    public void redo()
    {
        removeResources();
    }

    /**
     * @see org.eclipse.emf.common.command.AbstractCommand#undo()
     */
    @Override
    public void undo()
    {
        addResources();
    }

}
