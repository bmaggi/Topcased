/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     Alfredo Serrano (Anyware Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.providers;


/**
 * An model object verifier. The user of this interface determine
 * whether the model object can be deleted from the model or not.
 * 
 * created 24 august 2006
 * 
 * @author <a href="alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 */
public interface IDeleteObjectProvider
{
    /**
     * Verify if the given object can be deleted from the model.
     * 
     * @param object Object which tender to be deleted.
     * 
     * @return True it the given does be deleted.
     */
    public boolean canBeDeleted(Object object);
}
