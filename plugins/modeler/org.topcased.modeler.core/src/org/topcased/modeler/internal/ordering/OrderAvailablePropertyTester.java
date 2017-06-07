/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.internal.ordering;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;

/**
 * Determines if the order menu shall be visible
 * The menu is visible if the receiver have an order register
 * @author tfaure
 *
 */
public class OrderAvailablePropertyTester extends PropertyTester
{


    /* (non-Javadoc)
     * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
     */
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue)
    {
        if (receiver instanceof EObject)
        {
            EObject eobject = (EObject) receiver;
            return OrderManager.getOrder(eobject) != null ;
        }
        return false;
    }

}
