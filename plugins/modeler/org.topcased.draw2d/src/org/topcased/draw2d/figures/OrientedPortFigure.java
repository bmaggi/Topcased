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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Provide management for the Figure that are drawn differently depending on the
 * border on which it is attached.
 * 
 * These figures are mainly figures that behaves as Ports. They are attached to
 * a border and depending on their type (IN, OUT or INOUT) they have a specific
 * graphical representation.
 * 
 * Creation 11 juil. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class OrientedPortFigure extends PortFigure
{
    /**
     * The Constructor
     */
    public OrientedPortFigure()
    {
        // Do nothing
    }

    /**
     * Draw the figure that should represent the Port depending on its position.
     * 
     * @see org.topcased.draw2d.figures.PortFigure#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        switch (getPosition())
        {
            case PositionConstants.LEFT:
                // draw the port when it is attached to the left side
                outlineLeftPort(graphics);
                break;
            case PositionConstants.TOP:
                // draw the port when it is attached to the top side
                outlineTopPort(graphics);
                break;
            case PositionConstants.RIGHT:
                // draw the port when it is attached to the right side
                outlineRightPort(graphics);
                break;
            case PositionConstants.BOTTOM:
                // draw the port when it is attached to the bottom side
                outlineBottomPort(graphics);
                break;
            default:
                break;
        }
    }

    /**
     * Fill the figure that should represent the Port depending on its position.
     * 
     * @see org.topcased.draw2d.figures.PortFigure#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        switch (getPosition())
        {
            case PositionConstants.LEFT:
                // fill the port when it is attached to the left side
                fillLeftPort(graphics);
                break;
            case PositionConstants.TOP:
                // fill the port when it is attached to the top side
                fillTopPort(graphics);
                break;
            case PositionConstants.RIGHT:
                // fill the port when it is attached to the right side
                fillRightPort(graphics);
                break;
            case PositionConstants.BOTTOM:
                // fill the port when it is attached to the bottom side
                fillBottomPort(graphics);
                break;
            default:
                break;
        }
    }

    /**
     * Draw a port attached to the left border
     * 
     * @param graphics
     */
    protected void outlineLeftPort(Graphics graphics)
    {
        Rectangle r = Rectangle.SINGLETON;
        r.setBounds(getBounds());
        r.x = r.x + lineWidth / 2;
        r.y = r.y + lineWidth / 2;
        r.width = r.width - Math.max(1, lineWidth);
        r.height = r.height - Math.max(1, lineWidth);

        graphics.drawLine(r.getTopLeft(), r.getRight());
        graphics.drawLine(r.getRight(), r.getBottomLeft());
        graphics.drawLine(r.getBottomLeft(), r.getTopLeft());
    }

    /**
     * Draw a port attached to the top border
     * 
     * @param graphics
     */
    protected void outlineTopPort(Graphics graphics)
    {
        Rectangle r = Rectangle.SINGLETON;
        r.setBounds(getBounds());
        r.x = r.x + lineWidth / 2;
        r.y = r.y + lineWidth / 2;
        r.width = r.width - Math.max(1, lineWidth);
        r.height = r.height - Math.max(1, lineWidth);

        graphics.drawLine(r.getTopLeft(), r.getTopRight());
        graphics.drawLine(r.getTopRight(), r.getBottom());
        graphics.drawLine(r.getBottom(), r.getTopLeft());
    }

    /**
     * Draw a port attached to the right border
     * 
     * @param graphics
     */
    protected void outlineRightPort(Graphics graphics)
    {
        Rectangle r = Rectangle.SINGLETON;
        r.setBounds(getBounds());
        r.x = r.x + lineWidth / 2;
        r.y = r.y + lineWidth / 2;
        r.width = r.width - Math.max(1, lineWidth);
        r.height = r.height - Math.max(1, lineWidth);

        graphics.drawLine(r.getTopRight(), r.getBottomRight());
        graphics.drawLine(r.getBottomRight(), r.getLeft());
        graphics.drawLine(r.getLeft(), r.getTopRight());
    }

    /**
     * Draw a port attached to the bottom border
     * 
     * @param graphics
     */
    protected void outlineBottomPort(Graphics graphics)
    {
        Rectangle r = Rectangle.SINGLETON;
        r.setBounds(getBounds());
        r.x = r.x + lineWidth / 2;
        r.y = r.y + lineWidth / 2;
        r.width = r.width - Math.max(1, lineWidth);
        r.height = r.height - Math.max(1, lineWidth);

        graphics.drawLine(r.getBottomLeft(), r.getTop());
        graphics.drawLine(r.getTop(), r.getBottomRight());
        graphics.drawLine(r.getBottomRight(), r.getBottomLeft());
    }

    /**
     * Fill a port attached to the left border
     * 
     * @param graphics
     */
    protected void fillLeftPort(Graphics graphics)
    {
        PointList pl = new PointList();
        pl.addPoint(getBounds().getTopLeft());
        pl.addPoint(getBounds().getRight());
        pl.addPoint(getBounds().getBottomLeft());
        graphics.fillPolygon(pl);
    }

    /**
     * Fill a port attached to the top border
     * 
     * @param graphics
     */
    protected void fillTopPort(Graphics graphics)
    {
        PointList pl = new PointList();
        pl.addPoint(getBounds().getTopLeft());
        pl.addPoint(getBounds().getBottom());
        pl.addPoint(getBounds().getTopRight());
        graphics.fillPolygon(pl);
    }

    /**
     * Fill a port attached to the right border
     * 
     * @param graphics
     */
    protected void fillRightPort(Graphics graphics)
    {
        PointList pl = new PointList();
        pl.addPoint(getBounds().getTopRight());
        pl.addPoint(getBounds().getLeft());
        pl.addPoint(getBounds().getBottomRight());
        graphics.fillPolygon(pl);
    }

    /**
     * Fill a port attached to the bottom border
     * 
     * @param graphics
     */
    protected void fillBottomPort(Graphics graphics)
    {
        PointList pl = new PointList();
        pl.addPoint(getBounds().getBottomLeft());
        pl.addPoint(getBounds().getTop());
        pl.addPoint(getBounds().getBottomRight());
        graphics.fillPolygon(pl);
    }

}
