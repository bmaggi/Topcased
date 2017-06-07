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
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;

/**
 * The figure to display a Comment. A Figure with a bent corner and an embedded
 * TextFlow within a FlowPage that contains text.
 * 
 * Created 21 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CommentFigure extends Figure implements ILabelFigure, ILabel
{
    /**
     * The default amount of pixels subtracted from the figure's height and
     * width to determine the size of the corner.
     */
    private static final int DEFAULT_CORNER_SIZE = 10;

    /** The inset so that the text is not on the borders */
    private static final int BORDER_INSET = 3;

    private TextFlow textFlow;

    /**
     * Constructor
     */
    public CommentFigure()
    {
    	drawFigure();
    }
    
    /**
     * Creates a new CommentFigure with a MarginBorder that is the given
     * size and a FlowPage containing a TextFlow with the style WORD_WRAP_SOFT.
     */
    protected void drawFigure()
    {
        setBorder(new MarginBorder(BORDER_INSET, BORDER_INSET, BORDER_INSET, BORDER_INSET + DEFAULT_CORNER_SIZE));
        setLayoutManager(getNewLayoutManager());
        
        textFlow = new TextFlow();
        textFlow.setLayoutManager(new ParagraphTextLayout(getTextFlow(), ParagraphTextLayout.WORD_WRAP_TRUNCATE));

        FlowPage flowPage = new EllipsisFlowPage();
        flowPage.add(textFlow);

        add(flowPage);
    }

    /**
     * This method is defined in order to be redefined in
     * inherited methods in order to specialize the layout
     * @return the new LayoutManager
     */
	protected LayoutManager getNewLayoutManager() {
		return new StackLayout();
	}
    
    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return this;
    }

    /**
     * Draw the figure that represent the Comment figure
     * 
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics)
    {
        Rectangle rect = getBounds().getCopy();

        graphics.translate(getLocation());

        // fill the note
        PointList outline = new PointList();

        outline.addPoint(0, 0);
        outline.addPoint(rect.width - DEFAULT_CORNER_SIZE, 0);
        outline.addPoint(rect.width - 1, DEFAULT_CORNER_SIZE);
        outline.addPoint(rect.width - 1, rect.height - 1);
        outline.addPoint(0, rect.height - 1);

        graphics.fillPolygon(outline);

        // draw the inner outline
        PointList innerLine = new PointList();

        innerLine.addPoint(rect.width - DEFAULT_CORNER_SIZE - 1, 0);
        innerLine.addPoint(rect.width - DEFAULT_CORNER_SIZE - 1, DEFAULT_CORNER_SIZE);
        innerLine.addPoint(rect.width - 1, DEFAULT_CORNER_SIZE);
        innerLine.addPoint(rect.width - DEFAULT_CORNER_SIZE - 1, 0);
        innerLine.addPoint(0, 0);
        innerLine.addPoint(0, rect.height - 1);
        innerLine.addPoint(rect.width - 1, rect.height - 1);
        innerLine.addPoint(rect.width - 1, DEFAULT_CORNER_SIZE);

        graphics.drawPolygon(innerLine);

        graphics.translate(getLocation().getNegated());
    }

    /**
     * Returns the text inside the TextFlow.
     * 
     * @return the text flow inside the text.
     */
    public String getText()
    {
        return textFlow.getText();
    }

    /**
     * Sets the text of the TextFlow to the given value.
     * 
     * @param newText the new text value.
     */
    public void setText(String newText)
    {
    	textFlow.setText(newText);
    }

	public static int getBorderInset() {
		return BORDER_INSET;
	}

	public static int getDefaultCornerSize() {
		return DEFAULT_CORNER_SIZE;
	}

	public void setTextFlow(TextFlow textFlow) {
		this.textFlow = textFlow;
	}

	public TextFlow getTextFlow() {
		return textFlow;
	}



}
