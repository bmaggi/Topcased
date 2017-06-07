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
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;

/**
 * The figure to display a Graphic with a Label at the Bottom.
 * 
 * Created 24 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot </a>
 * @deprecated Use the GraphicWithLabelFigure instead and set the labelPosition
 *             as PositionConstants.BOTTOM
 */
public class GraphicWithBottomLabelFigure extends Figure implements ILabelFigure
{

    private ILabel header;

    private IFigure contentPane;

    /**
     * Constructor
     */
    public GraphicWithBottomLabelFigure()
    {
        drawFigure();
    }

    /**
     * Initialize the figure
     */
    protected void drawFigure()
    {
        GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.horizontalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        setLayoutManager(gridLayout);

        // create the contentPane Figure
        contentPane = createBody();
        add(contentPane, new GridData(GridData.FILL_BOTH));

        header = createLabel();
        add(header, new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
    }

    /**
     * Creates the header figure
     * 
     * @return the header figure
     */
    protected ILabel createLabel()
    {
        return new EditableLabel();
    }

    /**
     * Creates the contentPane object. Subclasses should override this to
     * provide their own Customized Figure
     * 
     * @return the container figure
     */
    protected IFigure createBody()
    {
        return new BodyFigure();
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return header;
    }

    /**
     * The Graphic to display. By default a cross is drawn.
     */
    protected class BodyFigure extends Figure
    {
        /**
         * Refresh the figure
         * 
         * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
         */
        protected void paintFigure(Graphics graphics)
        {
            super.paintFigure(graphics);

            graphics.pushState();

            graphics.drawLine(contentPane.getBounds().getTopLeft(), contentPane.getBounds().getBottomRight());
            graphics.drawLine(contentPane.getBounds().getBottomLeft(), contentPane.getBounds().getTopRight());

            graphics.popState();
        }
    }

}
