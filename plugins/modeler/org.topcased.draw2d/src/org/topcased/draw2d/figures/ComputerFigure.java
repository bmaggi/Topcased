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
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * A Figure that displays a computer
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ComputerFigure extends Figure
{

    private Rectangle outerScreen = new Rectangle();

    private Rectangle innerScreen = new Rectangle();

    private PointList keyboard1 = new PointList(4);

    private PointList keyboard2 = new PointList(4);

    private Rectangle keyboard3 = new Rectangle();

    private Color innerColor;

    /**
     * Constructor
     */
    public ComputerFigure()
    {
        drawFigure();
    }

    /**
     * Initialize the figure
     */
    protected void drawFigure()
    {
        setInnerColor(ColorConstants.gray);
        setBackgroundColor(ColorConstants.black);
        setForegroundColor(ColorConstants.black);

        setOpaque(true);
    }

    /**
     * Set the Inner Color of the figure
     * 
     * @param bg
     */
    public void setInnerColor(Color bg)
    {
        innerColor = bg;
        repaint();
    }

    /**
     * Return the innerColor of the Figure
     * 
     * @return Color
     */
    public Color getInnerColor()
    {
        return innerColor;
    }

    /**
     * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
     */
    public void paint(Graphics graphics)
    {
        calculateBounds();
        super.paint(graphics);
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
     */
    protected void paintBorder(Graphics graphics)
    {
        graphics.pushState();
        graphics.setForegroundColor(getForegroundColor());

        graphics.drawRectangle(outerScreen);
        graphics.drawRoundRectangle(innerScreen, innerScreen.width / 12, innerScreen.width / 12);

        graphics.drawPolygon(keyboard1);
        graphics.drawPolygon(keyboard2);
        graphics.drawRectangle(keyboard3);

        graphics.popState();
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics)
    {
        graphics.pushState();
        graphics.setBackgroundColor(getBackgroundColor());

        graphics.fillRectangle(outerScreen);
        graphics.pushState();
        graphics.setBackgroundColor(getInnerColor());
        graphics.fillRoundRectangle(innerScreen, innerScreen.width / 12, innerScreen.width / 12);
        graphics.popState();

        graphics.pushState();
        graphics.setBackgroundColor(getInnerColor());
        graphics.fillPolygon(keyboard1);
        graphics.popState();
        graphics.drawPolygon(keyboard1);
        graphics.fillPolygon(keyboard2);
        graphics.fillRectangle(keyboard3);

        graphics.popState();
    }

    private void calculateBounds()
    {
        Rectangle r = new Rectangle();
        r.setBounds(getBounds());
        r.crop(getInsets());
        r.resize(-1, -1);

        // Validate Screen
        outerScreen.x = r.x + (r.width * 18) / 100;
        outerScreen.y = r.y;
        outerScreen.width = (r.width * 64) / 100;
        outerScreen.height = (r.height * 59) / 100;

        innerScreen.x = r.x + (r.width * 23) / 100;
        innerScreen.y = r.y + (r.height * 6) / 100;
        innerScreen.width = (r.width * 54) / 100;
        innerScreen.height = (r.height * 47) / 100;

        // Validate Keyboard
        Point p1;
        Point p2;
        Point p3;
        Point p4;

        p1 = new Point(r.x, r.y + (r.height * 94) / 100);
        p2 = new Point(r.x + (r.width * 18) / 100, r.y + (r.height * 65) / 100);
        p3 = new Point(r.x + (r.width * 82) / 100, r.y + (r.height * 65) / 100);
        p4 = new Point(r.x + r.width, r.y + (r.height * 94) / 100);
        keyboard1.removeAllPoints();
        keyboard1.addPoint(p1);
        keyboard1.addPoint(p2);
        keyboard1.addPoint(p3);
        keyboard1.addPoint(p4);

        p1 = new Point(r.x + (r.width * 14) / 100, r.y + (r.height * 88) / 100);
        p2 = new Point(r.x + (r.width * 23) / 100, r.y + (r.height * 70) / 100);
        p3 = new Point(r.x + (r.width * 77) / 100, r.y + (r.height * 70) / 100);
        p4 = new Point(r.x + (r.width * 86) / 100, r.y + (r.height * 88) / 100);
        keyboard2.removeAllPoints();
        keyboard2.addPoint(p1);
        keyboard2.addPoint(p2);
        keyboard2.addPoint(p3);
        keyboard2.addPoint(p4);

        keyboard3.x = r.x;
        keyboard3.y = r.y + (r.height * 94) / 100;
        keyboard3.width = r.width;
        keyboard3.height = (r.height * 6) / 100;
    }
}