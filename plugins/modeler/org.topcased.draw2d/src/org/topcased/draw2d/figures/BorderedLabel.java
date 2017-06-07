/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.topcased.draw2d.layout.CenterLayout;

/**
 * A Shape that will represent a Rectangle shape with an EditableLabel inside.
 * 
 * Creation 29 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class BorderedLabel extends Shape implements ILabelFigure
{
    private ILabel header;

    /**
     * Constructor
     */
    public BorderedLabel()
    {
        setLayoutManager(new CenterLayout());

        header = createLabel();
        add(header);
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
     * 
     * @param newLabel the new object
     */
    public void setLabel(ILabel newLabel)
    {
        header = newLabel;
    }

    /**
     * Creates the label of the figure.<br>
     * <b>Subclasses can override this method to customize the appearance of the
     * label (for example you can return a {@link ComposedLabel} instead)</b>
     * 
     * @return the label of the figure
     */
    protected ILabel createLabel()
    {
        return new EditableLabel(true);
    }

    /**
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        graphics.fillRectangle(getBounds());
    }

    /**
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        Rectangle f = Rectangle.SINGLETON;
        Rectangle r = getBounds();
        f.x = r.x + lineWidth / 2;
        f.y = r.y + lineWidth / 2;
        f.width = r.width - lineWidth;
        f.height = r.height - lineWidth;
        graphics.drawRectangle(f);
    }
}
