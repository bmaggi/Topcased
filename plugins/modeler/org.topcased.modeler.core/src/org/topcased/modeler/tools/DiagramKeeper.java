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
 *  Maxime Leray (Atos Origin) maxime.leray@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.tools;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.GraphElement;

/**
 * The Interface DiagramKeeper.
 * This interface shouldn't be implemented directly. You should extend {@link DiagramKeeperImpl} instead.
 */
public interface DiagramKeeper
{

    /**
     * This method define the condition so that the graphical element shall be kept in the diagram.
     * 
     * @param movedElement the moved element
     * 
     * @return true, if the graphical element shall be kept
     */
    boolean keep(GraphElement movedElement);
    
    /**
     * This method returns the eObject associated with the graphElement
     * 
     * @param movedElement the movedElement
     * 
     * @return the EObject associated with the movedElement
     */
    EObject getEObject(GraphElement movedElement);
}
