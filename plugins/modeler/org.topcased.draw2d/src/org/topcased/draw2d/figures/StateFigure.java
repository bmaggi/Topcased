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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A Figure that will represent a State. This is a single Figure with an
 * EditableLabel inside.
 * 
 * Created 21 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @deprecated Use the BorderedLabel instead that extends a Shape
 */
public class StateFigure extends Figure implements ILabelFigure
{
    private static final int ROUND_CORNER = 10;

    private ILabel header;

    /**
     * Constructor
     */
    public StateFigure()
    {
    	drawFigure();
    }
    
    /**
     * Initialize the figure
     */
    protected void drawFigure()
    {
    	setLayoutManager(new BorderLayout());
        
        header = new EditableLabel();
        add(header, BorderLayout.CENTER);
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return header;
    }
    
    /**
     * Changes the label object
     * @param newLabel the new object
     */
    public void setLabel(ILabel newLabel)
    {
    	header = newLabel;
    }
    
    /**
     * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
     */
    protected void paintBorder(Graphics graphics)
    {
        super.paintBorder(graphics);

        graphics.pushState();
        Rectangle paintRect = getBounds().getCopy();
        graphics.drawRoundRectangle(paintRect, ROUND_CORNER, ROUND_CORNER);
        graphics.popState();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     * @generated NOT
     */
    protected void paintFigure(Graphics graphics)
    {
        super.paintFigure(graphics);

        graphics.pushState();

        Rectangle paintRect = getBounds().getCopy();
        paintRect.width = paintRect.width - 1;
        paintRect.height = paintRect.height - 1;
        graphics.fillRoundRectangle(paintRect, ROUND_CORNER, ROUND_CORNER);

        graphics.popState();
    }
}
