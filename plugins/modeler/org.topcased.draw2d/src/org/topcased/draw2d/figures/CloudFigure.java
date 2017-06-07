/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A Figure that displays a cloud
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class CloudFigure extends Shape
{
    private Rectangle arc1 = new Rectangle();

    private Rectangle arc2 = new Rectangle();

    private Rectangle arc3 = new Rectangle();

    private Rectangle arc4 = new Rectangle();

    private Rectangle arc5 = new Rectangle();

    private Rectangle arc6 = new Rectangle();

    private Rectangle arc7 = new Rectangle();

    private PointList centerPoints = new PointList();

    /**
     * Constructor
     */
    public CloudFigure()
    {
        setOpaque(true);
    }

    /**
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        graphics.fillOval(arc1);
        graphics.fillOval(arc2);
        graphics.fillOval(arc3);
        graphics.fillOval(arc4);
        graphics.fillOval(arc5);
        graphics.fillOval(arc6);
        graphics.fillOval(arc7);
        graphics.fillPolygon(centerPoints);
    }

    /**
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        graphics.drawArc(arc1, -20, 180);
        graphics.drawArc(arc2, -90, 200);
        graphics.drawArc(arc3, -110, 110);
        graphics.drawArc(arc4, -190, 200);
        graphics.drawArc(arc5, 170, 90);
        graphics.drawArc(arc6, 80, 200);
        graphics.drawArc(arc7, 80, 120);
    }

    /**
     * @see org.eclipse.draw2d.IFigure#validate()
     */
    public void validate()
    {
        super.validate();
        Rectangle r = new Rectangle();
        r.setBounds(getBounds());
        r.crop(getInsets());
        r.resize(-1, -1);

        // Arc 1
        arc1.x = r.x + (r.width * 26) / 100;
        arc1.y = r.y;
        arc1.width = (r.width * 54) / 100;
        arc1.height = (r.height * 27) / 100;

        // Arc 2
        arc2.x = r.x + (r.width * 60) / 100;
        arc2.y = r.y + (r.height * 14) / 100;
        arc2.width = (r.width * 40) / 100;
        arc2.height = (r.height * 57) / 100;

        // Arc 3
        arc3.x = r.x + (r.width * 60) / 100;
        arc3.y = r.y + (r.height * 43) / 100;
        arc3.width = (r.width * 27) / 100;
        arc3.height = (r.height * 43) / 100;

        // Arc 4
        arc4.x = r.x + (r.width * 20) / 100;
        arc4.y = r.y + (r.height * 71) / 100;
        arc4.width = (r.width * 54) / 100;
        arc4.height = (r.height * 28) / 100;

        // Arc 5
        arc5.x = r.x + (r.width * 6) / 100;
        arc5.y = r.y + (r.height * 35) / 100;
        arc5.width = (r.width * 54) / 100;
        arc5.height = (r.height * 57) / 100;

        // Arc 6
        arc6.x = r.x;
        arc6.y = r.y + (r.height * 36) / 100;
        arc6.width = (r.width * 14) / 100;
        arc6.height = (r.height * 28) / 100;

        // Arc 7
        arc7.x = r.x + (r.width * 6) / 100;
        arc7.y = r.y + (r.height * 10) / 100;
        arc7.width = (r.width * 40) / 100;
        arc7.height = (r.height * 43) / 100;

        // Center Polygon
        centerPoints.removeAllPoints();
        centerPoints.addPoint(getPercentPoint(r, 27, 14));
        centerPoints.addPoint(getPercentPoint(r, 80, 14));
        centerPoints.addPoint(getPercentPoint(r, 86, 64));
        centerPoints.addPoint(getPercentPoint(r, 80, 71));
        centerPoints.addPoint(getPercentPoint(r, 73, 85));
        centerPoints.addPoint(getPercentPoint(r, 33, 92));
        centerPoints.addPoint(getPercentPoint(r, 20, 85));
        centerPoints.addPoint(getPercentPoint(r, 7, 64));
        centerPoints.addPoint(getPercentPoint(r, 7, 35));
    }

    private Point getPercentPoint(Rectangle r, int percentWidth, int percentHeight)
    {
        return new Point(r.x + (r.width * percentWidth) / 100, r.y + (r.height * percentHeight) / 100);
    }
}
