/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.draw2d.layout;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The RegionLayout behaves like the ToolbarLayout. Its characteristics are that
 * all the children completely covered the parent Figure and they all have the
 * same dimensions. This layout can be displayed horizontally or vertically.
 * 
 * Creation 21 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RegionLayout extends ToolbarLayout
{

    /**
     * The constructor.
     */
    public RegionLayout()
    {
        super();
    }

    /**
     * Constructs a RegionLayout with a specified orientation.
     * 
     * @param isHorizontal whether the children are oriented horizontally
     */
    public RegionLayout(boolean isHorizontal)
    {
        super(isHorizontal);
    }

    /**
     * @see org.eclipse.draw2d.ToolbarLayout#layout(org.eclipse.draw2d.IFigure)
     */
    public void layout(IFigure parent)
    {
        List children = parent.getChildren();
        int numChildren = children.size();

        Rectangle clientArea = parent.getClientArea();

        int wHint;
        int hHint;
        int xDist;
        int yDist;

        // The layout is done only when at least one child is present
        if (numChildren > 0)
        {
            // Depending on the orientation of the layout, calculate the width and
            // height of each child Figure
            if (isHorizontal())
            {
                xDist = parent.getClientArea(Rectangle.SINGLETON).width / numChildren;
                yDist = 0;
                wHint = parent.getClientArea(Rectangle.SINGLETON).width / numChildren;
                hHint = parent.getClientArea(Rectangle.SINGLETON).height;
            }
            else
            {
                xDist = 0;
                yDist = parent.getClientArea(Rectangle.SINGLETON).height / numChildren;
                wHint = parent.getClientArea(Rectangle.SINGLETON).width;
                hHint = parent.getClientArea(Rectangle.SINGLETON).height / numChildren;
            }
    
            // Iterates on all the children Figures and update their bounds
            for (int i = 0; i < numChildren; i++)
            {
                IFigure child = (IFigure) children.get(i);
                Rectangle newBounds = new Rectangle(clientArea.x + i * xDist, clientArea.y + i * yDist, wHint, hHint);
                child.setBounds(newBounds);
            }
        }
    }
}
