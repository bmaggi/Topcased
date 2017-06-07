/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Mathieu Velten (ATOS ORIGIN) 
 *
 *****************************************************************************/
package org.topcased.modeler.exceptions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An Exception to be catched by the command stack listener
 ** 
 * @author <a href="mathieu.velten@atosorigin.com">Mathieu Velten</a>
 * 
 */
public class EditingDomainReadOnlyException extends RuntimeException
{
    private static final long serialVersionUID = 8126419052671372151L;

    private final Resource resource;

    public EditingDomainReadOnlyException()
    {
        resource = null;
    }

    public EditingDomainReadOnlyException(Resource resource)
    {
        this.resource = resource;
    }

    /**
     * In your code if you don't want to write check for read only use this method to throw an exception catched by the
     * commad stack to notify the user the resource is read only
     * 
     * @param globalCmd, the global command where the command will be add
     * @param domain, the editing domain
     * @param toCheck, the concernced resource
     * @param com, the command to add in the compound
     */
    public static void appendIfCanExecute(CompoundCommand globalCmd, Resource toCheck, EditingDomain domain, Command com)
    {
        if (!globalCmd.appendIfCanExecute(com))
        {
            if (toCheck != null && domain != null && domain.isReadOnly(toCheck))
            {
                throw new EditingDomainReadOnlyException(toCheck);
            }
        }
    }

    /**
     * @return the read only resource, can be null
     */
    public Resource getReadOnlyResource()
    {
        return resource;
    }
}
