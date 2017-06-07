/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.draw2d.anchors;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * This anchor allows to stick the connection to the top or the bottom of the figure
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class TopBottomAnchor extends AbstractConnectionAnchor
{
    /**
     * Constructor
     * @param source the source figure
     */
    public TopBottomAnchor (IFigure source) {
        super(source);
    }

    /**
     * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
     */
    public Point getLocation(Point reference) {
        Rectangle r = getOwner().getBounds().getCopy();
        getOwner().translateToAbsolute(r);
        int off = r.width / 2;
        if (r.y + r.height / 2 > reference.y)
        {
            return r.getTopLeft().translate(off, 1);
        }
        else
        {
            return r.getBottomLeft().translate(off, -1);
        }
    }

}
