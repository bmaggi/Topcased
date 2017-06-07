/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.figures;

import org.eclipse.draw2d.geometry.Dimension;

/**
 * An interface defining the structure of an
 * {@link org.topcased.modeler.di.model.EdgeObjectOffset} figure.<br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public interface IEdgeObjectOffsetFigure extends IEdgeObjectFigure
{
    /**
     * Get this figure offset.
     * 
     * @return this figure offset
     */
    public Dimension getOffset();

    /**
     * Set this figure offset.
     * 
     * @param offset an offset
     */
    public void setOffset(Dimension offset);
}
