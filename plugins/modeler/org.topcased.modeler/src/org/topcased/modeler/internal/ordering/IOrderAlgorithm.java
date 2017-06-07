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

import org.eclipse.emf.ecore.EObject;

/**
 * Algorithm to order elements contained in one element
 * @author tfaure
 *
 */
public interface IOrderAlgorithm
{
    /**
     * Return a sorted list of elements contained in object sorted
     * @return a list of EObject
     */
    List<EObject> sortChildren(EObject eobject);
    
    /**
     * Determines if the algorithm can order the object
     * @return
     */
    boolean canOrder (EObject context);
    
}
