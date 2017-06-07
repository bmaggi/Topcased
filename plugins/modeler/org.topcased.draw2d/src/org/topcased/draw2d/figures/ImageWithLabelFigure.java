/*******************************************************************************
 * Copyright (c) 2008 Topcased and others. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Image;

/**
 * This figure creates a Figure composed of an Image and a Label associated with this picture. The position of the Label
 * can be defined (TOP, LEFT, BOTTOM or RIGHT) and you also need to specify the appropriate Image.
 * 
 * Creation 13 feb. 08
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ImageWithLabelFigure extends Figure implements ILabelFigure
{
    private ILabel label;

    private ImageFigure imageFigure;

    /**
     * Empty constructor. Use a default Image and create the label at the bottom of the image
     */
    public ImageWithLabelFigure()
    {
        this(null, PositionConstants.BOTTOM);
    }

    /**
     * Constructor - Create the label at the bottom of the image figure.
     * 
     * @param image the Image to draw as the main figure
     */
    public ImageWithLabelFigure(Image image)
    {
        this(image, PositionConstants.BOTTOM);
    }

    /**
     * Constructor. Creates the contents of the figure : by defauft, it creates a layout manager, a label and an image
     * 
     * @param image the Image to draw as the main figure
     * @param labelPosition the label position (from {@link PositionConstants} : PositionConstants.TOP,
     *        PositionConstants.BOTTOM, PositionConstants.LEFT or PositionConstants.RIGHT)
     */
    public ImageWithLabelFigure(Image image, int labelPosition)
    {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setStretchMinorAxis(false);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

        // Create the label and the body Figures
        imageFigure = new ImageFigure(image);
        label = createLabel();

        switch (labelPosition)
        {
            case PositionConstants.LEFT:
                layout.setVertical(false);
                add(label);
                add(imageFigure);
                break;
            case PositionConstants.TOP:
                add(label);
                add(imageFigure);
                break;
            case PositionConstants.RIGHT:
                layout.setVertical(false);
                add(imageFigure);
                add(label);
                break;
            case PositionConstants.BOTTOM:
            default:
                add(imageFigure);
                add(label);
                break;
        }

        setLayoutManager(layout);
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
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return label;
    }

    /**
     * Return the image figure.
     * 
     * @return ImageFigure the image figure
     */
    public ImageFigure getImageFigure()
    {
        return imageFigure;
    }

}
