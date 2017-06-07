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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.topcased.draw2d.figures.IPortFigure;

/**
 * created 16 mai 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @deprecated Use the PortFigure or the OrientedPortFigure that are defined in
 *             the org.topcased.draw2d plugin
 */
public class ModelerPortFigure extends Figure implements IPortFigure
{

    /** Parameter value to represent an input port */
    public static final int IN_PORT = 0;

    /** Parameter value to represent an ouput port */
    public static final int OUT_PORT = 1;

    /** Parameter value to represent an input/ouput port */
    public static final int IN_OUT_PORT = 2;

    /** Type of the port (input, output, input/output */
    private int portType;

    /** Position of the port among LEFT, TOP, RIGHT, BOTTOM */
    private int portPosition;

    /**
     * The Constructor
     */
    public ModelerPortFigure()
    {
        // call the constructor with default IN_OUT type
        this(IN_OUT_PORT);
    }

    /**
     * The Constructor
     * 
     * @param t the type of the port
     */
    public ModelerPortFigure(int t)
    {
        portType = t;
    }

    /**
     * Draw the port according its type and its position on the border
     * 
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics)
    {
        super.paintFigure(graphics);
        paintContentPaneFigure(graphics);
    }

    /**
     * Draw the figure that should represent the Port. Subclasses may override
     * this to provide their own way to represent the port.
     * 
     * @param graphics
     */
    protected void paintContentPaneFigure(Graphics graphics)
    {
        switch (portType)
        {
            case IN_PORT:
                paintInPort(graphics);
                break;
            case OUT_PORT:
                paintOutPort(graphics);
                break;
            case IN_OUT_PORT:
                paintInOutPort(graphics);
                break;
        }
    }

    /**
     * Get the preferred size
     * 
     * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
     */
    public Dimension getPreferredSize(int wHint, int hHint)
    {
        // Dimension d = super.getPreferredSize(wHint, hHint).getCopy();
        // d.width = wHint;
        // d.height = getParent().getBounds().height;
        // return d;
        return new Dimension(10, 10);
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
        // figure moved event relocate the anchors
        // fireFigureMoved();
        // this.repaint();
    }

    /**
     * Draw an input port according its position
     * 
     * @param graphics
     */
    protected void paintInPort(Graphics graphics)
    {
        switch (portPosition)
        {
            case PositionConstants.LEFT:
                paintInPortAtLeft(graphics);
                break;
            case PositionConstants.TOP:
                paintInPortAtTop(graphics);
                break;
            case PositionConstants.RIGHT:
                paintInPortAtRight(graphics);
                break;
            case PositionConstants.BOTTOM:
                paintInPortAtBottom(graphics);
                break;
        }
    }

    /**
     * Draw an ouput port according its position
     * 
     * @param graphics
     */
    protected void paintOutPort(Graphics graphics)
    {
        switch (portPosition)
        {
            case PositionConstants.LEFT:
                paintOutPortAtLeft(graphics);
                break;
            case PositionConstants.TOP:
                paintOutPortAtTop(graphics);
                break;
            case PositionConstants.RIGHT:
                paintOutPortAtRight(graphics);
                break;
            case PositionConstants.BOTTOM:
                paintOutPortAtBottom(graphics);
                break;
        }
    }

    /**
     * Draw an input/output port according its position
     * 
     * @param graphics
     */
    protected void paintInOutPort(Graphics graphics)
    {
        switch (portPosition)
        {
            case PositionConstants.LEFT:
                paintInOutPortAtLeft(graphics);
                break;
            case PositionConstants.TOP:
                paintInOutPortAtTop(graphics);
                break;
            case PositionConstants.RIGHT:
                paintInOutPortAtRight(graphics);
                break;
            case PositionConstants.BOTTOM:
                paintInOutPortAtBottom(graphics);
                break;
        }
    }

    /**
     * Draw an input port when its position is on the left border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInPortAtLeft(Graphics graphics)
    {
        graphics.drawLine(bounds.getTopLeft(), bounds.getRight().translate(-1, 0));
        graphics.drawLine(bounds.getRight().translate(-1, 0), bounds.getBottomLeft().translate(0, -1));
        graphics.drawLine(bounds.getBottomLeft().translate(0, -1), bounds.getTopLeft());
    }

    /**
     * Draw an input port when its position is on the bottom border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInPortAtBottom(Graphics graphics)
    {
        graphics.drawLine(bounds.getBottomLeft().translate(0, -1), bounds.getTop());
        graphics.drawLine(bounds.getTop(), bounds.getBottomRight().translate(-1, -1));
        graphics.drawLine(bounds.getBottomRight().translate(-1, -1), bounds.getBottomLeft().translate(0, -1));
    }

    /**
     * Draw an input port when its position is on the right border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInPortAtRight(Graphics graphics)
    {
        graphics.drawLine(bounds.getTopRight().translate(-1, 0), bounds.getBottomRight().translate(-1, -1));
        graphics.drawLine(bounds.getBottomRight().translate(-1, -1), bounds.getLeft());
        graphics.drawLine(bounds.getLeft(), bounds.getTopRight().translate(-1, 0));
    }

    /**
     * Draw an input port when its position is on the top border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInPortAtTop(Graphics graphics)
    {
        graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight().translate(-1, 0));
        graphics.drawLine(bounds.getTopRight().translate(-1, 0), bounds.getBottom().translate(0, -1));
        graphics.drawLine(bounds.getBottom().translate(0, -1), bounds.getTopLeft());
    }

    /**
     * Draw an ouput port when its position is on the left border of the
     * container
     * 
     * @param graphics
     */
    protected void paintOutPortAtLeft(Graphics graphics)
    {
        // Actually, draw the same figure as an input port on the right border
        paintInPortAtRight(graphics);
    }

    /**
     * Draw an ouput port when its position is on the top border of the
     * container
     * 
     * @param graphics
     */
    protected void paintOutPortAtTop(Graphics graphics)
    {
        // Actually, draw the same figure as an input port on the bottom border
        paintInPortAtBottom(graphics);
    }

    /**
     * Draw an ouput port when its position is on the right border of the
     * container
     * 
     * @param graphics
     */
    protected void paintOutPortAtRight(Graphics graphics)
    {
        // Actually, draw the same figure as an input port on the left border
        paintInPortAtLeft(graphics);
    }

    /**
     * Draw an ouput port when its position is on the bottom border of the
     * container
     * 
     * @param graphics
     */
    protected void paintOutPortAtBottom(Graphics graphics)
    {
        // Actually, draw the same figure as an input port on the top border
        paintInPortAtTop(graphics);
    }

    /**
     * Draw an input/ouput port when its position is on the left border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInOutPortAtLeft(Graphics graphics)
    {
        graphics.drawRectangle(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
    }

    /**
     * Draw an input/ouput port when its position is on the top border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInOutPortAtTop(Graphics graphics)
    {
        // Actually, input/output port has only one representation
        paintInOutPortAtLeft(graphics);
    }

    /**
     * Draw an input/ouput port when its position is on the right border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInOutPortAtRight(Graphics graphics)
    {
        // Actually, input/output port has only one representation
        paintInOutPortAtLeft(graphics);
    }

    /**
     * Draw an input/ouput port when its position is on the bottom border of the
     * container
     * 
     * @param graphics
     */
    protected void paintInOutPortAtBottom(Graphics graphics)
    {
        // Actually, input/output port has only one representation
        paintInOutPortAtLeft(graphics);
    }

}
