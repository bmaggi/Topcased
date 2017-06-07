/*******************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Tristan FAURE - ATOS ORIGIN
 *******************************************************************************/
package org.topcased.modeler.documentation;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Interface to Implement to retrieve documentation
 * @author tfaure
 *
 */
public interface IDocumentable
{
    /**
     * Return the documentation for an eobject
     * @param eobject
     * @return the documentation value
     */
    String getDocumentation (EObject eobject);
    
    /**
     * Get the command able to set the documentation
     * @param domain, the editing domain
     * @param eobject, the selection
     * @param documentation, the text to set
     * @return
     */
    Command setDocumentation(EditingDomain domain, EObject eobject, String documentation);
    
    /**
     * Returns true if the instance can handle the documentation
     * @param eobject
     * @return true if it can maange
     */
    boolean canManage (EObject eobject);
}
