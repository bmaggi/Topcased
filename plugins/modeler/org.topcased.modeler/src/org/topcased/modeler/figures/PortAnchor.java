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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.topcased.draw2d.figures.IPortFigure;

/**
 * Provides Anchor for Ports figure.
 * 
 * Created 3 juin 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PortAnchor extends ChopboxAnchor
{
    private boolean external = true;

    /**
     * The Constructor
     * 
     * @param owner the Figure that will handle the Anchor
     */
    public PortAnchor(IFigure owner)
    {
        super(owner);
    }

    /**
     * The Constructor
     * 
     * @param owner the Figure that will handle the Anchor
     * @param isExternal true if the anchor should be external
     */
    public PortAnchor(IFigure owner, boolean isExternal)
    {
        super(owner);
        this.external = isExternal;
    }

    /**
     * Indicates if the anchor will be externally connected
     * 
     * @param isExternal true if the anchor should be external
     */
    public void setExternal(boolean isExternal)
    {
        external = isExternal;
    }

    /**
     * The type of the port and its direction indicates the Location of the
     * Anchor
     * 
     * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
     */
    public Point getLocation(Point reference)
    {
        if (getOwner() instanceof IPortFigure)
        {
            Point p;
            if (external)
            {
                switch (((IPortFigure) getOwner()).getPosition())
                {
                    case PositionConstants.BOTTOM:
                        p = getOwner().getBounds().getBottom();
                        break;
                    case PositionConstants.RIGHT:
                        p = getOwner().getBounds().getRight();
                        break;
                    case PositionConstants.TOP:
                        p = getOwner().getBounds().getTop();
                        break;
                    default:
                        p = getOwner().getBounds().getLeft();
                        break;
                }
            }
            else
            {
                switch (((IPortFigure) getOwner()).getPosition())
                {
                    case PositionConstants.BOTTOM:
                        p = getOwner().getBounds().getTop();
                        break;
                    case PositionConstants.RIGHT:
                        p = getOwner().getBounds().getLeft();
                        break;
                    case PositionConstants.TOP:
                        p = getOwner().getBounds().getBottom();
                        break;
                    default:
                        p = getOwner().getBounds().getRight();
                        break;
                }
            }
            getOwner().translateToAbsolute(p);
            return p;
        }

        return super.getLocation(reference);
    }
}
