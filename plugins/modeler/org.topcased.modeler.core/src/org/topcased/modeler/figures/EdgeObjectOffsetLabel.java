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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * A figure to represent a label edge object offset. <br>
 * <br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class EdgeObjectOffsetLabel extends EdgeObjectLabel implements IEdgeObjectOffsetFigure
{
    /* This label figure offset */
    private Dimension offset;

    /**
     * Constructor.
     * 
     * @param connection
     */
    public EdgeObjectOffsetLabel(Connection connection)
    {
        super(connection);
    }

    /**
     * @see org.topcased.modeler.figures.IEdgeObjectFigure#getOffset()
     */
    public Dimension getOffset()
    {
        return offset;
    }

    /**
     * @see org.topcased.modeler.figures.IEdgeObjectFigure#setOffset(org.eclipse.draw2d.geometry.Dimension)
     */
    public void setOffset(Dimension offset)
    {
        this.offset = offset;
        revalidate();
    }
}
