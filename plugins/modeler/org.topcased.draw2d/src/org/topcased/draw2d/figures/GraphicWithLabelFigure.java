/*******************************************************************************
 * Copyright (c) 2006, 2008 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;

/**
 * This figure creates a bodyFigure (a rectangle figure by default) and a label associated with the body figure. The
 * position of the label can be defined (TOP, LEFT, BOTTOM or RIGHT) and the body figure customized overriding the
 * <code>createBodyFigure()</code> method.
 * 
 * Creation 20 juil. 06<br>
 * Updated 17 June 08
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class GraphicWithLabelFigure extends Figure implements ILabelFigure
{
    private ILabel label;

    private IFigure bodyFigure;

    /**
     * Constructor - Create the label at the bottom of the body figure.
     */
    public GraphicWithLabelFigure()
    {
        this(PositionConstants.BOTTOM);
    }

    /**
     * Constructor
     * 
     * @param labelPosition the label position (from {@link PositionConstants} : PositionConstants.TOP,
     *  PositionConstants.BOTTOM, PositionConstants.LEFT or PositionConstants.RIGHT)
     */
    public GraphicWithLabelFigure(int labelPosition)
    {
        createContents(labelPosition);
    }

    /**
     * Creates the contents of the figure : by default, it creates a layout manager, a label and a body
     * 
     * @param labelPosition the label position (from {@link PositionConstants})
     */
    protected void createContents(int labelPosition)
    {
        GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.horizontalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;

        // Create the label and the body figures
        label = createLabel();
        bodyFigure = createBodyFigure();

        switch (labelPosition)
        {
            case PositionConstants.LEFT:
                gridLayout.numColumns = 2;
                setLayoutManager(gridLayout);
                add(label, new GridData(getDefaultLabelStyle(labelPosition)));
                add(bodyFigure, new GridData(getDefaultBodyFigureStyle(labelPosition)));
                break;
            case PositionConstants.TOP:
                setLayoutManager(gridLayout);
                add(label, new GridData(getDefaultLabelStyle(labelPosition)));
                add(bodyFigure, new GridData(getDefaultBodyFigureStyle(labelPosition)));
                break;
            case PositionConstants.RIGHT:
                gridLayout.numColumns = 2;
                setLayoutManager(gridLayout);
                add(bodyFigure, new GridData(getDefaultBodyFigureStyle(labelPosition)));
                add(label, new GridData(getDefaultLabelStyle(labelPosition)));
                break;
            case PositionConstants.BOTTOM:
            default:
                setLayoutManager(gridLayout);
                add(bodyFigure, new GridData(getDefaultBodyFigureStyle(labelPosition)));
                add(label, new GridData(getDefaultLabelStyle(labelPosition)));
                break;
        }
    }

    /**
     * Define the GridData style to be used for the body figure. This method should be overridden when a other style is
     * necessary.
     * 
     * @param labelPosition the label position (from {@link PositionConstants})
     * @return a GridData style
     */
    protected int getDefaultBodyFigureStyle(int labelPosition)
    {
        return GridData.FILL_BOTH;
    }

    /**
     * Define the GridData style to be used for the Label. This method should be overridden when a other style is
     * necessary.
     * 
     * @param labelPosition the label position (from {@link PositionConstants})
     * @return a GridData style
     */
    protected int getDefaultLabelStyle(int labelPosition)
    {
        switch (labelPosition)
        {
            case PositionConstants.LEFT:
            case PositionConstants.RIGHT:
                return GridData.VERTICAL_ALIGN_CENTER;
            case PositionConstants.TOP:
            case PositionConstants.BOTTOM:
                return GridData.HORIZONTAL_ALIGN_CENTER;
            default:
                break;
        }
        return GridData.CENTER;
    }

    /**
     * Creates the label of the figure.<br>
     * <b>Subclasses can override this method to customize the appearance of the label (for example you can return a
     * {@link ComposedLabel} instead)</b>
     * 
     * @return the label of the figure
     */
    protected ILabel createLabel()
    {
        EditableLabel lbl = new EditableLabel();
        lbl.setAlignment(PositionConstants.LEFT);
        lbl.setBorder(new MarginBorder(5));
        return lbl;
    }

    /**
     * Create the figure displayed beside the label. It is a RectangleFigure by default.<br>
     * <b>Subclasses can override this method to customize the appearance of the body</b>
     * 
     * @return the figure
     */
    protected IFigure createBodyFigure()
    {
        return new RectangleFigure();
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return label;
    }

    /**
     * Return the body figure.
     * 
     * @return IFigure the body figure
     */
    public IFigure getBodyFigure()
    {
        return bodyFigure;
    }

}
