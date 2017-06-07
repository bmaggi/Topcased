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

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;

/**
 * A Figure that will represent a Package. The header is an EditableLabel
 * aligned to the left, the contentPane is an XYLayout
 * 
 * Created 21 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PackageFigure extends Figure implements IContainerFigure, ILabelFigure
{
    private static final int HORIZONTAL_MARGIN = 15;
    
    private ILabel label;

    private IFigure contentPane;

    /**
     * Constructor
     */
    public PackageFigure()
    {
        drawFigure();
    }
    
    /**
     * Initialize ToolbarLayout and its children Figures Suclasses may overrides
     * this to provides their own background figure.
     */
    protected void drawFigure()
    {
        GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.horizontalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        setLayoutManager(gridLayout);

        IFigure headerFigure = new Figure();
        ToolbarLayout toolbarLayout = new ToolbarLayout();
        toolbarLayout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
        toolbarLayout.setStretchMinorAxis(false);
        headerFigure.setLayoutManager(toolbarLayout);
        headerFigure.setOpaque(true);
        headerFigure.setBorder(new PackageHeaderFigureBorder());

        setLabel(createLabel());
        headerFigure.add(label);
        add(headerFigure, new GridData(GridData.GRAB_HORIZONTAL));

        setContentPane(createContainer());
        add(contentPane, new GridData(GridData.FILL_BOTH));
    }

    /**
     * Create the edited label
     * @return the edited label
     * @deprecated use createLabel instead
     */
    protected IFigure createHeader()
    {
        return null;
    }
    
    /**
     * Create the edited label
     * @return the edited label
     */
    protected ILabel createLabel()
    {
    	ILabel l = (ILabel) createHeader();
    	if (l == null)
    	{
    		l = new EditableLabel();
    		((EditableLabel) l).setAlignment(PositionConstants.LEFT);
    	}
        return l;
    }
    
    /**
     * Set the label. This function will only be used by extending classes.
     * 
     * @param l the new label figure
     */
    protected void setLabel(ILabel l)
    {
        label = l;
    }
    
    /**
     * Creates the container figure
     * @return the container figure
     */
    protected IFigure createContainer()
    {        
        Figure container = new Figure();
        container.setLayoutManager(new XYLayout());
        container.setOpaque(true);
        container.setBorder(new LineBorder(2));
        return container;
    }
    
    /**
     * Set the container. This function will only be used by extending classes.
     * 
     * @param c the new container figure
     */
    protected void setContentPane(IFigure c)
    {
        contentPane = c;
    }
    

    /**
     * Return the Header figure
     * 
     * @return returns the figure used to edit the name
     * @deprecated use getLabel() instead
     */
    public IFigure getHeader()
    {
        return label;
    }
    
    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return label;
    }

    /**
     * Return the contentPane figure
     * 
     * @return the Container Figure
     */
    public IFigure getContentPane()
    {
        return contentPane;
    }


    /**
     * A Border at the left, top and right of the label
     */
    public static class PackageHeaderFigureBorder extends AbstractBorder
    {

        private static final Insets INSETS = new Insets(3, 3, 1, 4);
        
        /**
         * The Constructor
         */
        public PackageHeaderFigureBorder()
        {
            // Do nothing
        }

        /**
         * @see org.eclipse.draw2d.Border#getInsets(org.eclipse.draw2d.IFigure)
         */
        public Insets getInsets(IFigure figure)
        {
            return INSETS;
        }

        /**
         * Draw the 3 borders
         * 
         * @see org.eclipse.draw2d.Border#paint(org.eclipse.draw2d.IFigure,
         *      org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Insets)
         */
        public void paint(IFigure figure, Graphics graphics, Insets insets)
        {
            graphics.pushState();

            graphics.setLineWidth(2);

            graphics.drawLine(getPaintRectangle(figure, insets).getBottomLeft().getTranslated(1, 0),
                    tempRect.getTopLeft().getTranslated(1, 0));
            graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft().getTranslated(0, 1),
                    tempRect.getTopRight().getTranslated(0, 1));
            graphics.drawLine(getPaintRectangle(figure, insets).getTopRight().getTranslated(-1, 0),
                    tempRect.getBottomRight().getTranslated(-1, 0));

            graphics.popState();
        }
    }
    
    /**
     * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
     */
    public Dimension getPreferredSize(int wHint, int hHint)
    {
        Dimension optimalDim = super.getPreferredSize(wHint, hHint);
        if (wHint == -1)
        {
            // Add a margin to the optimal width
            optimalDim.width = optimalDim.width + HORIZONTAL_MARGIN;
        }
        return optimalDim;
    }

}
