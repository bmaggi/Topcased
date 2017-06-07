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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.draw2d.figures.ILabelFigure;
import org.topcased.draw2d.figures.IPortFigure;

/**
 * The figure that display a Label associated with a PortFigure
 * 
 * Creation : 5 aout 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @deprecated Use the LabelledPortFigure of the org.topcased.draw2d plugin.
 */
public class ModelerLabelledPortFigure extends Figure implements ILabelFigure, IPortFigure
{
    /** A name to associate with the port */
    private RotatableEditableLabel portName;

    /** The triangle that represent the port */
    private ModelerPortFigure portFigure;

    /** Position of the port among LEFT, TOP, RIGHT, BOTTOM */
    private int portPosition;

    /**
     * The Constructor
     * 
     * @param portFig the figure that represent the port
     * @param portAlignment the alignement of the figure
     */
    public ModelerLabelledPortFigure(ModelerPortFigure portFig, int portAlignment)
    {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setStretchMinorAxis(false);
        layout.setMinorAlignment(portAlignment);
        setLayoutManager(layout);

        portFigure = portFig;
        portName = new RotatableEditableLabel();
        add(portName);
        add(portFigure);
    }

    /**
     * Get the figure that represent the port figure
     * 
     * @return the portFigure
     */
    public ModelerPortFigure getPortFigure()
    {
        return portFigure;
    }

    /**
     * Set the new figure that represent the port
     * 
     * @param fig the new portFigure
     */
    public void setPortFigure(ModelerPortFigure fig)
    {
        portFigure = fig;
    }

    /**
     * Get the port name
     * 
     * @return the string
     */
    public String getPortName()
    {
        return portName.getText();
    }

    /**
     * Set the string of the Label
     * 
     * @param newName the new value
     */
    public void setPortName(String newName)
    {
        portName.setText(newName);
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return portName;
    }

    /**
     * @see org.topcased.draw2d.figures.IPortFigure#getPosition()
     */
    public int getPosition()
    {
        return portPosition;
    }

    /**
     * @see org.topcased.draw2d.figures.IPortFigure#setPosition(int)
     */
    public void setPosition(int pos)
    {
        portPosition = pos;
        portFigure.setPosition(pos);

        ToolbarLayout layout = (ToolbarLayout) getLayoutManager();
        layout.setStretchMinorAxis(false);
        layout.setSpacing(5);

        if (getParent().getParent() instanceof DiagramFigure)
        {
            switch (portPosition)
            {
                case PositionConstants.LEFT:
                    layout.setVertical(true);
                    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
                    remove(portFigure);
                    add(portFigure);
                    break;
                case PositionConstants.RIGHT:
                    layout.setVertical(true);
                    layout.setMinorAlignment(ToolbarLayout.ALIGN_BOTTOMRIGHT);
                    remove(portFigure);
                    add(portFigure);
                    break;
                case PositionConstants.BOTTOM:
                    layout.setVertical(false);
                    layout.setMinorAlignment(ToolbarLayout.ALIGN_BOTTOMRIGHT);
                    remove(portFigure);
                    add(portFigure);
                    break;
                case PositionConstants.TOP:
                    layout.setVertical(false);
                    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
                    remove(portFigure);
                    add(portFigure);
                    break;

                default:
                    break;
            }
        }
        else
        {
            layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

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
        }

        setLayoutManager(layout);
        invalidateTree();
        revalidate();
    }
}
