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

import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.topcased.draw2d.figures.EditableLabel;
import org.topcased.draw2d.figures.IContainerFigure;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.draw2d.figures.ILabelFigure;

/**
 * A Figure that will represent a Class. The header is an EditableLabel, the
 * contentPane is a vertical ToolbarLayout
 * 
 * Created 21 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerFigure extends Figure implements IContainerFigure, ILabelFigure
{
    private ILabel header;

    private IFigure contentPane;

    /**
     * Constructor
     */
    public ModelerFigure()
    {
        drawFigure();
    }

    /**
     * Initialize ToolbarLayout and its children Figures Suclasses may overrides
     * this to provides their own background figure.
     */
    protected void drawFigure()
    {
        ToolbarLayout layout = new ToolbarLayout();
        setLayoutManager(layout);
        setBorder(new CompoundBorder(new LineBorder(), new MarginBorder(1)));
        setOpaque(true);

        header = new EditableLabel();
        ((EditableLabel) header).setAlignment(PositionConstants.LEFT);
        add(header);

        contentPane = new Figure();
        contentPane.setLayoutManager(new ToolbarLayout());
        add(contentPane);
    }

    /**
     * Return the Header figure
     * 
     * @return returns the label used to edit the name
     * @deprecated use getLabel() instead
     */
    public IFigure getHeader()
    {
        return header;
    }
    
    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return header;
    }

    /**
     * @see org.topcased.modeler.figures.IContainerFigure#getContentPane()
     */
    public IFigure getContentPane()
    {
        return contentPane;
    }

    /**
     * Set the Header figure
     * 
     * @param newHeader the new Header Figure
	 * @deprecated
     */
    public void setHeader(IFigure newHeader)
    {
        header = (ILabel) newHeader;
    }

    /**
     * Set the Header figure
     * 
     * @param newHeader the new Header Figure
     */
    public void setLabel(ILabel newHeader)
    {
        header = newHeader;
    }

    /**
     * Set the contentPane figure
     * 
     * @param newContentPane the new contentPane Figure
     */
    public void setContentPane(IFigure newContentPane)
    {
        contentPane = newContentPane;
    }

}
