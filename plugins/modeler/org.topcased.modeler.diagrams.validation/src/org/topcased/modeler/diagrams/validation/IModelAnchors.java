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
 *  Thibault Landré (ATOS ORIGIN INTEGRATION) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.diagrams.validation;

import org.eclipse.emf.ecore.EObject;

/**
 * An interface to be able to retrieve the source and target of an edge in the model in the MissingAnchors script 
 * 
 */
public interface IModelAnchors
{
    /**
     * Get the element in the model that is the source of the edge
     * @param edgeEObject the edgeObject
     * @return the source model element of the eObject
     */
    public EObject getSourceEObject(EObject edgeEObject);
    
    /**
     * Get the element in the model that is the target of the edge
     * @param edgeEObject
     * @return the target model element of the edge
     */
    public EObject getTargetEObject(EObject edgeEObject);
}
