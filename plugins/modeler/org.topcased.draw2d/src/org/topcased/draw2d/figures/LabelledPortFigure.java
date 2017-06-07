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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;

/**
 * The figure that display an ILabel associated with an IPortFigure. The ILabel
 * and the IPortFigure are
 * 
 * Creation 12 juil. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class LabelledPortFigure extends Figure implements ILabelFigure, IPortFigure
{
    /** A name to associate with the port */
    private ILabel portName;

    /** The triangle that represent the port */
    private IPortFigure portFigure;

    /** Position of the port among LEFT, TOP, RIGHT, BOTTOM */
    private int portPosition;

    /**
     * The Constructor
     * 
     * @param portFig the figure that represent the port
     */
    public LabelledPortFigure(IPortFigure portFig)
    {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setStretchMinorAxis(false);
        layout.setSpacing(5);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        setLayoutManager(layout);

        portFigure = portFig;
        portName = createPortLabel();
        add(portName);
        add(portFigure);
    }

    /**
     * Create the ILabel to associate with the Figure. By default, an
     * EditableLabel is created. Subclasses should override this method to
     * provide their own ILabel.
     * 
     * @return ILabel
     */
    protected ILabel createPortLabel()
    {
        return new EditableLabel();
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return portName;
    }

    /**
     * Get the figure that represent the port figure
     * 
     * @return the portFigure
     */
    public IPortFigure getPortFigure()
    {
        return portFigure;
    }

    /**
     * Set the new figure that represent the port
     * 
     * @param fig the new portFigure
     */
    public void setPortFigure(IPortFigure fig)
    {
        portFigure = fig;
    }

    /**
     * Override the method to set also the position of the IPortFigure
     * 
     * @see org.topcased.draw2d.figures.IPortFigure#setPosition(int)
     */
    public void setPosition(int pos)
    {
        portPosition = pos;
        portFigure.setPosition(pos);

        ToolbarLayout layout = (ToolbarLayout) getLayoutManager();

        switch (portPosition)
        {
            case PositionConstants.LEFT:
                layout.setVertical(false);
                remove(portName);
                add(portName);
                break;
            case PositionConstants.RIGHT:
                layout.setVertical(false);
                remove(portFigure);
                add(portFigure);
                break;
            case PositionConstants.BOTTOM:
                layout.setVertical(true);
                remove(portFigure);
                add(portFigure);
                break;
            case PositionConstants.TOP:
                layout.setVertical(true);
                remove(portName);
                add(portName);
                break;

            default:
                break;
        }

        setLayoutManager(layout);
        invalidateTree();
        revalidate();
    }

    /**
     * @see org.topcased.draw2d.figures.IPortFigure#getPosition()
     */
    public int getPosition()
    {
        return portPosition;
    }
}
