/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.draw2d.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.topcased.draw2d.layout.CenterLayout;

/**
 * This figure creates a container with a background figure (a rectangle figure
 * by default) and a label in this figure. The position of the label can be
 * defined (TOP, LEFT, BOTTOM, RIGHT or CENTER) and the background figure
 * customized overriding the <code>createBackgroungFigure()</code> method.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ContainerWithInnerLabel extends Figure implements IContainerFigure, ILabelFigure
{
    private ILabel label;

    private IFigure contentPane;
    
    private IFigure bgdFigure;

    /**
     * Constructor
     */
    public ContainerWithInnerLabel()
    {
        this(PositionConstants.CENTER);
    }

    /**
     * Constructor
     * 
     * @param labelPosition the label position (from {@link PositionConstants} :
     *        PositionConstants.CENTER, PositionConstants.TOP,
     *        PositionConstants.BOTTOM, PositionConstants.LEFT or
     *        PositionConstants.RIGHT)
     */
    public ContainerWithInnerLabel(int labelPosition)
    {
        createContents(labelPosition);
    }

    /**
     * Creates the contents of the figure : by defauft, it creates a layout
     * manager, a header and a container
     * 
     * @param labelPosition the label position (from {@link PositionConstants})
     */
    protected void createContents(int labelPosition)
    {
        LayoutManager layout = new StackLayout();
        setLayoutManager(layout);

        bgdFigure = createBackgroundFigure();
        add(bgdFigure);

        label = createLabel();
        IFigure lblContainer = createLabelContainer(label, labelPosition);
        add(lblContainer);

        contentPane = new Figure();
        contentPane.setLayoutManager(createContainerLayout());
        add(contentPane);
    }

    /**
     * Initialize the label container at the right position
     * 
     * @param lbl the label
     * @param labelPosition the label position ({@link PositionConstants})
     * @return the label container
     */
    private IFigure createLabelContainer(ILabel lbl, int labelPosition)
    {
        Figure lblContainer = new Figure();

        switch (labelPosition)
        {
            case PositionConstants.CENTER:
                lblContainer.setLayoutManager(new CenterLayout());
                lblContainer.add(lbl);
                break;
            default:
                lblContainer.setLayoutManager(new BorderLayout());
                // Add margin
                lblContainer.setBorder(new MarginBorder(5));
                // Add a subcontainer with centerlayout to fit the label size
                Figure subContainer = new Figure();
                subContainer.setLayoutManager(new CenterLayout());
                subContainer.add(lbl);
                lblContainer.add(subContainer, new Integer(labelPosition));
                break;
        }

        return lblContainer;
    }

    /**
     * Create the figure displayed behind the label. It is a RectangleFigure by
     * default.<br>
     * <b>Subclasses can override this method to customize the appearance of the
     * container</b>
     * 
     * @return the figure
     */
    protected IFigure createBackgroundFigure()
    {
        RectangleFigure rectangle = new RectangleFigure();
        rectangle.setOpaque(true);

        return rectangle;
    }

    /**
     * Create the layout used by the container figure (XYLayout by default).<br>
     * <b>Subclasses can override this method to customize the layout of the
     * container</b>
     * 
     * @return the container's layout
     */
    protected LayoutManager createContainerLayout()
    {
        return new XYLayout();
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
        EditableLabel lbl = new EditableLabel();
        lbl.setAlignment(PositionConstants.LEFT);
        return lbl;
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return label;
    }

    /**
     * @see org.topcased.draw2d.figures.IContainerFigure#getContentPane()
     */
    public IFigure getContentPane()
    {
        return contentPane;
    }
    
    /**
     * Returns the figure drawn behind the label
     * @return the background figure
     */
    public IFigure getBackgroundFigure()
    {
        return bgdFigure;
    }
}