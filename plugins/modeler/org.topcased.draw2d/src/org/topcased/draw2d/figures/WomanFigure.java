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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;


/**
 * Basic figure that display a woman.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot </a>
 */
public class WomanFigure extends Figure
{
    /**
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics)
    {
        int width = getBounds().width;
        int height = getBounds().height;
        int x = getBounds().x;
        int y = getBounds().y;
        
        if (width > (4 * height) / 8)
        {
            int newWidth = (4 * height) / 8;
            x += (width - newWidth) / 2;
            width = newWidth;
        }
        
        if (height > (8 * width) / 4)
        {
            int newHeight = (8 * width) / 4;
            y += (height - newHeight) / 2;
            height = newHeight;
        }
        
        double unit = ((double) height) / 8;

        graphics.pushState();

        graphics.setLineWidth(1);
        
        //the head
        graphics.drawOval(x + (int) (1 * unit), y, (int) (2 * unit), (int) (2 * unit));
        //the body
        graphics.drawLine(x + (int) (2 * unit), y + (int) (2 * unit), x + (int) (2 * unit), y + (int) (4.5 * unit));
        //the arms
        graphics.drawLine(x, y + (int) (3 * unit), x + (int) (4 * unit), y + (int) (3 * unit));
        //right side of the dress
        graphics.drawLine(x + (int) (2 * unit), y + (int) (4.5 * unit), x + (int) (4 * unit), y + (int) (6.5 * unit));
        //bottom side of the dress
        graphics.drawLine(x + (int) (4 * unit), y + (int) (6.5 * unit), x, y + (int) (6.5 * unit));
        //left side of the dress
        graphics.drawLine(x, y + (int) (6.5 * unit), x + (int) (2 * unit), y + (int) (4.5 * unit));
        //right leg
        graphics.drawLine(x + (int) (3 * unit), y + (int) (6.5 * unit), x + (int) (3 * unit), y + (int) (8 * unit));
        //left leg
        graphics.drawLine(x + (int) (1 * unit), y + (int) (6.5 * unit), x + (int) (1 * unit), y + (int) (8 * unit));

        graphics.popState();
    }

}
