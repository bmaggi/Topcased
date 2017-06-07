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

package org.topcased.draw2d.layout;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * This class implements the {@link org.eclipse.draw2d.LayoutManager} interface
 * using the BorderAttachedLayout algorithm. This lays out the components using
 * the layout constraints as defined by each component. Components may be
 * attached to a border or not.
 * 
 * Creation : 13 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class BorderAttachedLayout extends XYLayout
{
    private static final int BORDER_SPACE = 1;

    /**
     * The Constructor
     */
    public BorderAttachedLayout()
    {
        super();
    }

    /**
     * Calculates and returns the preferred size of the input figure. Since in
     * BorderAttachedLayout the location of the child should be changed, the
     * preferred size would be the dimension of the clientArea.
     * 
     * @see XYLayout#calculatePreferredSize(IFigure, int, int)
     * @since 2.0
     */
    protected Dimension calculatePreferredSize(IFigure f, int wHint, int hHint)
    {
        Rectangle rect = new Rectangle();
        ListIterator children = f.getChildren().listIterator();
        while (children.hasNext()) {
            IFigure child = (IFigure)children.next();
            
            Object currentConstraint = constraints.get(child);

            Rectangle r;

            if (currentConstraint instanceof PortConstraint)
            {
                PortConstraint portConstraint = (PortConstraint) currentConstraint;
                r = portConstraint.getRectConstraints().getCopy();
                switch (portConstraint.getAttachment())
                {
                    case PositionConstants.LEFT:
                    case PositionConstants.RIGHT:
                        r.x = BORDER_SPACE;
                        r.y = Math.min(r.y, f.getClientArea().height - r.height - BORDER_SPACE);
                        break;
                    case PositionConstants.TOP:
                    case PositionConstants.BOTTOM:
                        r.x = Math.min(r.x, f.getClientArea().width - r.width - BORDER_SPACE);
                        r.y = BORDER_SPACE;
                        break;
                    default:
                        break;
                }
            }
            else
            {
                r = (Rectangle) currentConstraint;
            }
            
            if (r == null)
            {
                continue;
            }
            
            if (r.width < 0 || r.height < 0) {
                Dimension prefSize = child.getPreferredSize(r.width, r.height);
                r = r.getCopy();
                if (r.width < 0)
                {
                    r.width = prefSize.width;
                }
                if (r.height < 0)
                {
                    r.height = prefSize.height;
                }
            }
            rect.union(r);
        }
        Dimension d = rect.getSize();
        Insets insets = f.getInsets();
        return new Dimension(d.width + insets.getWidth(), d.height + insets.getHeight()).
            union(getBorderPreferredSize(f));
    }

    /**
     * Implements the algorithm to layout the components of the given container
     * figure. Each component is laid out using its own layout constraint
     * specifying its size and position and eventually its attachment to a
     * border.
     * 
     * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
     */
    public void layout(IFigure container)
    {
        Iterator children = container.getChildren().iterator();
        Point offset = getOrigin(container);
        IFigure f;

        // Iterate on all the children and place them
        while (children.hasNext())
        {
            f = (IFigure) children.next();
            // get the rectangle constraints of the figure
            Object currentConstraint = constraints.get(f);

            Rectangle bounds;

            if (currentConstraint instanceof PortConstraint)
            {
                bounds = ((PortConstraint) currentConstraint).getRectConstraints();
            }
            else
            {
                bounds = (Rectangle) currentConstraint;
            }

            if (bounds == null)
            {
                continue;
            }

            if (bounds.width < 0 || bounds.height < 0)
            {
                Dimension prefSize = f.getPreferredSize(bounds.width, bounds.height);
                bounds = bounds.getCopy();
                if (bounds.width < 0)
                {
                    bounds.width = prefSize.width;
                }
                if (bounds.height < 0)
                {
                    bounds.height = prefSize.height;
                }
            }

            if (currentConstraint instanceof PortConstraint)
            {
                // calculate and update the new constraints of the figure
                // according to the attachment constraint
                switch (((PortConstraint) currentConstraint).getAttachment())
                {
                    case PositionConstants.LEFT:
                        bounds.x = BORDER_SPACE;
                        bounds.y = Math.min(bounds.y, container.getClientArea().height - bounds.height - BORDER_SPACE);
                        break;
                    case PositionConstants.TOP:
                        bounds.x = Math.min(bounds.x, container.getClientArea().width - bounds.width - BORDER_SPACE);
                        bounds.y = BORDER_SPACE;
                        break;
                    case PositionConstants.RIGHT:
                        bounds.x = container.getClientArea().width - bounds.width - BORDER_SPACE;
                        bounds.y = Math.min(bounds.y, container.getClientArea().height - bounds.height - BORDER_SPACE);
                        break;
                    case PositionConstants.BOTTOM:
                        bounds.x = Math.min(bounds.x, container.getClientArea().width - bounds.width - BORDER_SPACE);
                        bounds.y = container.getClientArea().height - bounds.height - BORDER_SPACE;
                        break;

                    default:
                        break;
                }
            }

            bounds = bounds.getTranslated(offset);
            f.setBounds(bounds);
        }
    }

    /**
     * @see org.eclipse.draw2d.XYLayout#getConstraint(org.eclipse.draw2d.IFigure)
     */
    public Object getConstraint(IFigure figure)
    {
        return constraints.get(figure);
    }

}
