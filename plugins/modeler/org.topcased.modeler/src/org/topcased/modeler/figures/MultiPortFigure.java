/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.figures;

import java.util.Iterator;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.topcased.draw2d.figures.EditableLabel;
import org.topcased.draw2d.figures.IContainerFigure;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.draw2d.figures.ILabelFigure;
import org.topcased.draw2d.figures.IPortFigure;
import org.topcased.draw2d.figures.Label;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * 
 * Creation : 19 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class MultiPortFigure extends Figure implements IPortFigure, IContainerFigure, ILabelFigure
{

    private int main_inset = 3;

    private int port_width = 16;

    private int bottom_right_space = 1;

    private int position = PositionConstants.NONE;
    
    /** Store the multiport state (OPENED or CLOSED) */
    private boolean isClosed = false;

    /** A Figure that display the label and the icon of the multiPort */
    private IFigure multiPortHeader;

    /** The icon associated with the MultiPort */
    private Label multiPortIcon;

    /** A name to associate with the multiPort */
    private EditableLabel multiPortLabel;

    /** The figure that contains all the Port figures */
    private IFigure containerPortFigure;

    /**
     * The Constructor
     */
    public MultiPortFigure()
    {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setStretchMinorAxis(false);
        layout.setSpacing(1);
        setLayoutManager(layout);

        // -------------------------
        // Create the Header Figure
        ToolbarLayout headerLayout = new ToolbarLayout(true);
        headerLayout.setSpacing(5);
        headerLayout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        multiPortHeader = new Figure();
        multiPortHeader.setLayoutManager(headerLayout);

        multiPortIcon = getMultiPortIcon();

        multiPortLabel = new EditableLabel();

        multiPortHeader.add(multiPortIcon);
        multiPortHeader.add(multiPortLabel);
        // -------------------------

        // -------------------------
        // Create the Header Figure
        containerPortFigure = new Figure();
        ToolbarLayout containerLayout = new ToolbarLayout();
        containerLayout.setStretchMinorAxis(false);
        containerLayout.setSpacing(1);
        containerPortFigure.setLayoutManager(containerLayout);

        if (position == PositionConstants.LEFT || position == PositionConstants.RIGHT)
        {
            containerPortFigure.setBorder(new MarginBorder(new Insets(0, main_inset, 0, 0)));
        }
        else
        {
            containerPortFigure.setBorder(new MarginBorder(new Insets(main_inset, 0, 0, 0)));
        }
        // -------------------------

        add(multiPortHeader);
        add(containerPortFigure);
    }

    /**
     * Get the MultiPort name
     * 
     * @return the string
     */
    public String getMultiPortName()
    {
        return multiPortLabel.getText();
    }

    /**
     * Set the string of the Label
     * 
     * @param newName the new value
     */
    public void setMultiPortName(String newName)
    {
        multiPortLabel.setText(newName);
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return multiPortLabel;
    }
    
    /**
     * Return the Header Figure
     * 
     * @return the header Figure
     */
    public IFigure getMultiPortHeader()
    {
        return multiPortHeader;
    }

    /**
     * The Figure that contains all the children ports
     * 
     * @return the contentPanre figure
     */
    public IFigure getContentPane()
    {
        return containerPortFigure;
    }

    /**
     * @see org.topcased.draw2d.figures.IPortFigure#getPosition()
     */
    public int getPosition()
    {
        return position;
    }

    /**
     * Get the current state of the multiport
     * 
     * @return the current state
     */
    public boolean isClosed()
    {
        return isClosed;
    }
    
    /**
     * Set the new State of the multiport
     * 
     * @param newState the new State
     */
    public void setClosed(boolean newState)
    {
        this.isClosed = newState;
        if (isClosed)
        {
            setSize(getMultiPortHeader().getPreferredSize());
        }
        else
        {
            setSize(new Dimension(-1, -1));
        }
    }
    
    /**
     * @see org.topcased.draw2d.figures.IPortFigure#setPosition(int)
     */
    public void setPosition(int pos)
    {
        position = pos;

        ToolbarLayout headerLayout = (ToolbarLayout) multiPortHeader.getLayoutManager();
        ToolbarLayout childrenLayout = (ToolbarLayout) getContentPane().getLayoutManager();

        // Refresh the layout of the MultiPortFigure
        switch (pos)
        {
            case PositionConstants.LEFT:
                headerLayout.setVertical(false);
                multiPortHeader.remove(multiPortLabel);
                multiPortHeader.add(multiPortLabel);

                childrenLayout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
                childrenLayout.setVertical(true);

                containerPortFigure.getBorder().getInsets(containerPortFigure).top = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).left = main_inset;
                containerPortFigure.getBorder().getInsets(containerPortFigure).bottom = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).right = 0;
                break;
            case PositionConstants.RIGHT:
                headerLayout.setVertical(false);
                multiPortHeader.remove(multiPortIcon);
                multiPortHeader.add(multiPortIcon);

                childrenLayout.setMinorAlignment(ToolbarLayout.ALIGN_BOTTOMRIGHT);
                childrenLayout.setVertical(true);

                containerPortFigure.getBorder().getInsets(containerPortFigure).top = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).left = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).bottom = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).right = main_inset;
                break;
            case PositionConstants.BOTTOM:
                headerLayout.setVertical(true);
                multiPortHeader.remove(multiPortIcon);
                multiPortHeader.add(multiPortIcon);

                childrenLayout.setMinorAlignment(ToolbarLayout.ALIGN_BOTTOMRIGHT);
                childrenLayout.setVertical(false);
                containerPortFigure.getBorder().getInsets(containerPortFigure).top = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).left = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).bottom = main_inset;
                containerPortFigure.getBorder().getInsets(containerPortFigure).right = 0;
                break;
            case PositionConstants.TOP:
                headerLayout.setVertical(true);
                multiPortHeader.remove(multiPortLabel);
                multiPortHeader.add(multiPortLabel);

                childrenLayout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
                childrenLayout.setVertical(false);
                containerPortFigure.getBorder().getInsets(containerPortFigure).top = main_inset;
                containerPortFigure.getBorder().getInsets(containerPortFigure).left = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).bottom = 0;
                containerPortFigure.getBorder().getInsets(containerPortFigure).right = 0;
                break;

            default:
                break;
        }

        // Refresh the layout of the children
        for (Iterator iter = getChildren().iterator(); iter.hasNext();)
        {
            IFigure childFigure = (IFigure) iter.next();
            if (childFigure instanceof ModelerLabelledPortFigure)
            {
                ToolbarLayout childLayout = new ToolbarLayout();
                childLayout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

                IFigure labelFigure = ((ModelerLabelledPortFigure) childFigure).getLabel();
                IFigure portFigure = ((ModelerLabelledPortFigure) childFigure).getPortFigure();

                switch (pos)
                {
                    case PositionConstants.LEFT:
                        childLayout.setVertical(false);
                        childFigure.remove(labelFigure);
                        childFigure.add(labelFigure);
                        break;
                    case PositionConstants.RIGHT:
                        childLayout.setVertical(false);
                        childFigure.remove(portFigure);
                        childFigure.add(portFigure);
                        break;
                    case PositionConstants.BOTTOM:
                        childLayout.setVertical(true);
                        childFigure.remove(portFigure);
                        childFigure.add(portFigure);
                        break;
                    case PositionConstants.TOP:
                        childLayout.setVertical(true);
                        childFigure.remove(labelFigure);
                        childFigure.add(labelFigure);
                        break;
                    default:
                        break;
                }
                childFigure.setLayoutManager(childLayout);
            }
        }

        setLayoutManager(childrenLayout);
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics)
    {
        switch (position)
        {
            case PositionConstants.LEFT:
                // Fill the area where are displayed the ports
                // graphics.setBackgroundColor(ModelerColorConstants.lightGray);
                graphics.fillRectangle(new Rectangle(bounds.getLocation(), new Dimension(port_width, bounds.height)));
                break;
            case PositionConstants.RIGHT:
                // Fill the area where are displayed the ports
                // graphics.setBackgroundColor(ModelerColorConstants.lightGray);
                graphics.fillRectangle(new Rectangle(bounds.getTopRight().translate(-port_width, 0), new Dimension(
                        port_width, bounds.height)));
                break;
            case PositionConstants.TOP:
                // Fill the area where are displayed the ports
                // graphics.setBackgroundColor(ModelerColorConstants.lightGray);
                graphics.fillRectangle(new Rectangle(bounds.getLocation(), new Dimension(bounds.width, port_width)));
                break;
            case PositionConstants.BOTTOM:
                // Fill the area where are displayed the ports
                // graphics.setBackgroundColor(ModelerColorConstants.lightGray);
                graphics.fillRectangle(new Rectangle(bounds.getBottomLeft().translate(0, -port_width), new Dimension(
                        bounds.width, port_width)));
                break;

            default:
                break;
        }
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
     */
    protected void paintBorder(Graphics graphics)
    {
        if (!isClosed)
        {
            switch (position)
            {
                case PositionConstants.LEFT:
                    graphics.drawRectangle(new Rectangle(bounds.getLocation(), new Dimension(port_width
                            - bottom_right_space, bounds.height - bottom_right_space)));
                    break;
                case PositionConstants.RIGHT:
                    graphics.drawRectangle(new Rectangle(bounds.getTopRight().translate(-port_width, 0), new Dimension(
                            port_width - bottom_right_space, bounds.height - bottom_right_space)));
                    break;
                case PositionConstants.TOP:
                    graphics.drawRectangle(new Rectangle(bounds.getLocation(), new Dimension(bounds.width
                            - bottom_right_space, port_width - bottom_right_space)));
                    break;
                case PositionConstants.BOTTOM:
                    graphics.drawRectangle(new Rectangle(bounds.getBottomLeft().translate(0, -port_width), new Dimension(
                            bounds.width - bottom_right_space, port_width - bottom_right_space)));
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Get the icon of the multiPort to display in the graphic. Subclasses
     * should override this to provide their own icon.
     * 
     * @return the Label that contain the icon
     */
    protected Label getMultiPortIcon()
    {
        Label icon = new Label(ModelerImageRegistry.getImage("MULTIPORT"));
        return icon;
    }

    /**
     * @param width The port width to set.
     */
    protected void setPortWidth(int width)
    {
        this.port_width = width;
    }

}
