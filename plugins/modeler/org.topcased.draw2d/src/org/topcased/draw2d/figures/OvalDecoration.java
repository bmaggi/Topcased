package org.topcased.draw2d.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transform;

/**
 * A Decoration used to render a filled Oval at the end of a Connection.
 * 
 * Creation 12 juin 06
 * 
 * @author jlescot
 */
public class OvalDecoration extends Figure implements RotatableDecoration
{
    /** The default size of the oval decoration */
    private static final Dimension OVAL_SIZE = new Dimension(10, 10);

    private static final int LINE_WIDTH = 1;

    private Point location;

    private Transform transform;

    private Point ovalCenter;

    private Dimension ovalSize;

    private double xScale = 1;

    private double yScale = 1;

    /**
     * Constructor
     */
    public OvalDecoration()
    {
        location = new Point();
        transform = new Transform();
    }

    /**
     * @see org.eclipse.draw2d.Figure#getBounds()
     */
    public Rectangle getBounds()
    {
        if (bounds == null)
        {
            updatePoints();

            bounds = new Rectangle(location, new Dimension(0, 0));

            Point p = Point.SINGLETON;
            p.setLocation(ovalCenter);
            p.x += ovalSize.width / 2;
            p.y += ovalSize.height / 2;
            bounds.union(p);
            p.x -= ovalSize.width;
            p.y -= ovalSize.height;
            bounds.union(p);

            bounds.expand(LINE_WIDTH / 2, LINE_WIDTH / 2);
        }
        return bounds;
    }

    /**
     * Set the sacle of the Oval. By default, the oval has a size of 10 per 10 :
     * that is a circle !
     * 
     * @param x the x-scale value
     * @param y the y-scale value
     */
    public void setScale(double x, double y)
    {
        ovalCenter = null;
        ovalSize = null;
        bounds = null;
        transform.setScale(x, y);
        xScale = x;
        yScale = y;
    }

    /**
     * @see org.eclipse.draw2d.Figure#setLocation(org.eclipse.draw2d.geometry.Point)
     */
    public void setLocation(Point p)
    {
        ovalCenter = null;
        ovalSize = null;
        bounds = null;
        location.setLocation(p);
        transform.setTranslation(p.x, p.y);
        super.setLocation(p);
    }

    /**
     * @see org.eclipse.draw2d.RotatableDecoration#setReferencePoint(org.eclipse.draw2d.geometry.Point)
     */
    public void setReferencePoint(Point p)
    {
        ovalCenter = null;
        ovalSize = null;
        bounds = null;
        Point pt = Point.SINGLETON;
        pt.setLocation(p);
        pt.negate().translate(location);
        setRotation(Math.atan2(pt.y, pt.x));
    }

    /**
     * Set the rotation parameter
     * 
     * @param angle set the angle of the oval
     */
    public void setRotation(double angle)
    {
        ovalCenter = null;
        ovalSize = null;
        bounds = null;
        transform.setRotation(angle);
    }

    /**
     * Update the points of the Circle
     */
    protected void updatePoints()
    {
        if (ovalCenter == null)
        {
            ovalCenter = new Point(transform.getTransformed(new Point(0, 0)));
        }
        if (ovalSize == null)
        {
            ovalSize = new Dimension((int) xScale * OVAL_SIZE.width, (int) yScale * OVAL_SIZE.height);
        }
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics)
    {
        updatePoints();

        graphics.pushState();
        graphics.setBackgroundColor(graphics.getForegroundColor());

        graphics.fillOval(ovalCenter.x - ovalSize.width / 2, ovalCenter.y - ovalSize.height / 2, ovalSize.width,
                ovalSize.height);

        graphics.popState();
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
     */
    protected void paintBorder(Graphics graphics)
    {
        updatePoints();

        graphics.pushState();

        graphics.drawOval(ovalCenter.x - ovalSize.width / 2, ovalCenter.y - ovalSize.height / 2, ovalSize.width,
                ovalSize.height);

        graphics.popState();
    }

}
