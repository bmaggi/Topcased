/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.draw2d.layout;

import java.util.List;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * TODO comment this class
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class CenterLayout extends AbstractHintLayout
{

    /**
     * @see org.eclipse.draw2d.AbstractHintLayout#calculateMinimumSize(org.eclipse.draw2d.IFigure,
     *      int, int)
     */
    protected Dimension calculateMinimumSize(IFigure figure, int wHint, int hHint)
    {
        int width = wHint;
        int height = hHint;
        if (width > -1)
        {
            width = Math.max(0, width - figure.getInsets().getWidth());
        }
        if (height > -1)
        {
            height = Math.max(0, height - figure.getInsets().getHeight());
        }
        Dimension d = new Dimension();
        List children = figure.getChildren();
        IFigure child;
        for (int i = 0; i < children.size(); i++)
        {
            child = (IFigure) children.get(i);
            if (!isObservingVisibility() || child.isVisible())
            {
                d.union(child.getMinimumSize(wHint, hHint));
            }
        }

        d.expand(figure.getInsets().getWidth(), figure.getInsets().getHeight());
        d.union(getBorderPreferredSize(figure));
        return d;

    }

    /**
     * @see org.eclipse.draw2d.AbstractLayout#calculatePreferredSize(org.eclipse.draw2d.IFigure,
     *      int, int)
     */
    protected Dimension calculatePreferredSize(IFigure figure, int wHint, int hHint)
    {
        int width = wHint;
        int height = hHint;
        if (width > -1)
        {
            width = Math.max(0, width - figure.getInsets().getWidth());
        }
        if (height > -1)
        {
            height = Math.max(0, height - figure.getInsets().getHeight());
        }
        Dimension d = new Dimension();
        List children = figure.getChildren();
        IFigure child;
        for (int i = 0; i < children.size(); i++)
        {
            child = (IFigure) children.get(i);
            if (!isObservingVisibility() || child.isVisible())
            {
                d.union(child.getPreferredSize(wHint, hHint));
            }
        }

        d.expand(figure.getInsets().getWidth(), figure.getInsets().getHeight());
        d.union(getBorderPreferredSize(figure));
        return d;
    }

    /**
     * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
     */
    public void layout(IFigure container)
    {
        Rectangle r = container.getClientArea();
        List children = container.getChildren();
        IFigure child;
        for (int i = 0; i < children.size(); i++)
        {
            child = (IFigure) children.get(i);
            
            // Initialize with r dimension
            Dimension size = child.getPreferredSize(r.width, r.height);

            int x = Math.max(r.x, r.x + r.width / 2 - size.width / 2);
            int y = Math.max(r.y, r.y + r.height / 2 - size.height / 2);
            int width = Math.min(r.width, size.width);
            int height = Math.min(r.height, size.height);            

            child.setBounds(new Rectangle(x, y, width, height));
        }
    }

}
