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

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.BasicEMap;

/**
 * A class defining a command to edit a resource within an EModelElement documentation.<br>
 * 
 * Creation : 10 October 2005<br>
 * Updated : 16 October 2008<br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 */
public class EditDocumentationResourcesCommand extends AbstractCommand
{
    private BasicEMap.Entry<String, String> resource;

    private String newResourceValue;

    private String oldResourceValue;

    /**
     * Constructor
     * 
     * @param resource The resource to modify
     * @param newResourceValue The new value to affect
     */
    public EditDocumentationResourcesCommand(BasicEMap.Entry<String, String> resource, String newResourceValue)
    {
        super("Edit resource within EModelElement documentation");

        this.resource = resource;
        this.newResourceValue = newResourceValue;
    }

    /**
     * @see org.eclipse.emf.common.command.Command#execute()
     */
    public void execute()
    {
        oldResourceValue = (String) resource.getValue();
        redo();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#redo()
     */
    public void redo()
    {
        resource.setValue(newResourceValue);
    }

    /**
     * @see org.eclipse.emf.common.command.AbstractCommand#undo()
     */
    @Override
    public void undo()
    {
        resource.setValue(oldResourceValue);
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
