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
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Insets;

/**
 * creation : 09 fev. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot </a>
 * @deprecated will be removed in the next version
 */
public class ContentFigure extends Figure
{

    /**
     * The Constructor
     */
    public ContentFigure()
    {
        setLayoutManager(new XYLayout());
        setOpaque(true);
        setBorder(new ContentFigureBorder());
    }

    /**
     * Inner class that draw the Border of the Figure
     * 
     * @author jako
     * 
     */
    public static class ContentFigureBorder extends AbstractBorder
    {
        private static final Insets INSETS = new Insets(3);

        /**
         * Get the Insets of the Borders
         * 
         * @see org.eclipse.draw2d.Border#getInsets(org.eclipse.draw2d.IFigure)
         */
        public Insets getInsets(IFigure figure)
        {
            return INSETS;
        }

        /**
         * Draw the Borders
         * 
         * @see org.eclipse.draw2d.Border#paint(org.eclipse.draw2d.IFigure,
         *      org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Insets)
         */
        public void paint(IFigure figure, Graphics graphics, Insets insets)
        {
            graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(), tempRect.getTopRight());
        }
    }
}
