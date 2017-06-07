/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;

/**
 * <b>Bug GEF 73968 : </b> This class helps to resolve this bug temporarily.
 * <br>
 * creation : 10 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 * @deprecated Use {@link ChopboxAnchor} instead (Bug GEF 73968 is now fixed).
 */
public class NodeAnchor extends ChopboxAnchor
{

    /**
     * Constructor
     */
    public NodeAnchor()
    {
        super();
    }

    /**
     * Constructor
     * 
     * @param owner
     */
    public NodeAnchor(IFigure owner)
    {
        super(owner);
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        return this == obj;
    }
}
