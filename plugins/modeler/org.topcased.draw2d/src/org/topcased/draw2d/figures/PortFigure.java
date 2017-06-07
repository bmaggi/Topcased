/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A basic implementation of the IPortFigure interface. Here the port is just a
 * rectangle.
 * 
 * Creation 11 juil. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PortFigure extends Shape implements IPortFigure
{
    /**
     * Position of the port. This is a PositionConstants among LEFT, TOP, RIGHT,
     * BOTTOM.
     */
    private int portPosition;

    /**
     * The Constructor
     */
    public PortFigure()
    {
        super();
    }

    /**
     * Outline the port according its position. By default the rectangle bounds
     * of the shape is drawn. Subclasses should draw a different shape depending
     * on the attachment of the figure.<br>
     * <code>
     * switch (getPosition())
     * {
     *     case PositionConstants.LEFT:
     *         // draw the port when it is attached to the left side
     *         break;
     *     case PositionConstants.TOP:
     *         // draw the port when it is attached to the top side
     *         break;
     *     case PositionConstants.RIGHT:
     *         // draw the port when it is attached to the right side
     *         break;
     *     case PositionConstants.BOTTOM:
     *         // draw the port when it is attached to the bottom side
     *         break;
     *     default:
     *         break;
     * }
     * </code>
     * 
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        Rectangle r = getBounds();
        int x = r.x + lineWidth / 2;
        int y = r.y + lineWidth / 2;
        int w = r.width - Math.max(1, lineWidth);
        int h = r.height - Math.max(1, lineWidth);
        graphics.drawRectangle(x, y, w, h);
    }

    /**
     * Fill the port according its position. By default the rectangle bounds of
     * the shape are filled. Subclasses should draw a different shape depending
     * on the attachment of the figure.
     * 
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        graphics.fillRectangle(getBounds());
    }

    /**
     * Returns the current position of the port figure
     * 
     * @see org.topcased.draw2d.figures.IPortFigure#getPosition()
     */
    public int getPosition()
    {
        return portPosition;
    }

    /**
     * Set the direction
     * 
     * @see org.topcased.draw2d.figures.IPortFigure#setPosition(int)
     */
    public void setPosition(int position)
    {
        portPosition = position;
    }

}
