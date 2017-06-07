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

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

/**
 * A Figure that will arrange children with a ToolbarLayout.
 * 
 * Creation : 17 jan. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EListFigure extends Figure
{
    /**
     * The Constructor
     */
    public EListFigure()
    {
        ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
        layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
        layout.setStretchMinorAxis(true);
        layout.setSpacing(2);
        layout.setIgnoreInvisibleChildren(true);
        setLayoutManager(layout);
        setOpaque(false);
        drawBorder();
    }
    
    /**
     * Draw the border of the Figure
     */
    protected void drawBorder()
    {
        setBorder(new CompoundBorder(new EListFigureBorder(), new MarginBorder(1)));
    }

    /**
     * Set the preferred size. The height is at least 10.
     * 
     * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
     */
    public Dimension getPreferredSize(int wHint, int hHint)
    {
        Dimension size = super.getPreferredSize(wHint, hHint);
        size.height = Math.max(size.height, 10);
        return size;

    }
    
    
    /**
     * The Border that apply to the figure : only at the top.
     * 
     * Creation : 17 janv. 2006
     * 
     * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
     */
    public static class EListFigureBorder extends AbstractBorder
    {
        private static final Insets INSETS = new Insets(2, 0, 0, 1);

        /**
         * @see org.eclipse.draw2d.Border#getInsets(org.eclipse.draw2d.IFigure)
         */
        public Insets getInsets(IFigure figure)
        {
            return INSETS;
        }

        /**
         * @see org.eclipse.draw2d.Border#paint(org.eclipse.draw2d.IFigure, org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Insets)
         */
        public void paint(IFigure figure, Graphics graphics, Insets insets)
        {
            graphics.pushState();
            
            // Get the parent foreground color
            graphics.setForegroundColor(figure.getParent().getForegroundColor());
            graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(), tempRect.getTopRight());
            
            graphics.popState();
        }
    }
}
