/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  eperico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.emf.ecore.EObject;

/**
 * Specific behavior for the control mode that enables to load required resources
 */
public interface DiagramOutlinePageBehavior
{
    
    /**
     * Resolve required resources from the controlled model object
     * 
     * @param object the specified model object
     * @return a boolean, true if the diagram need to be refreshed
     */
    public boolean resolveEobject(EObject object); }
