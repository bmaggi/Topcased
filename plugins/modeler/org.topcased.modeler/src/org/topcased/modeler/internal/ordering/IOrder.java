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

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Defines object able to save and retrieve order for an element
 * instance shall implement the canOrder() method to determine if it can be used
 * @author tfaure
 *
 */
public interface IOrder
{
    /**
     * Save an order for an eobject
     * The instance is responsible of the integrity of the order
     * @param context
     * @param elementsOrdered
     * @throws OrderException, if the instance of iorder can not manage this context
     */
    Command save (EObject context, List<EObject> elementsOrdered, EditingDomain domain) throws OrderException;;
    
    /**
     * Get the order elements for an eobject
     * @param context
     * @return null if no orders have been found
     * @throws OrderException, if the instance of iorder can not manage this context
     */
    List<EObject> getOrderedElements (EObject context) throws OrderException;
    
    /**
     * Determines if the context is recognized by the instance
     * @param context
     * @return true if it can be recognized
     */
    boolean canOrder (EObject context);
        
    /**
     * Exception when ordering fails
     * @author tfaure
     *
     */
    public static class OrderException extends Exception
    {
        private static final long serialVersionUID = 1579660096359036403L;

        public OrderException(String string)
        {
            super(string);
        }
    }
}
