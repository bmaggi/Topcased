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
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;

/**
 * A Class that provide a container Figure implementation. A figure that could
 * display other figures in a XYLayout.<br>
 * <br>
 * Created 21 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ContainerFigure extends Figure implements IContainerFigure, ILabelFigure
{
    private ILabel header;

    private IFigure contentPane;

    private int headerStyle;
    
    /**
     * Constructor
     */
    public ContainerFigure()
    {
    	this(GridData.GRAB_HORIZONTAL);
    }
    
    /**
     * Constructor
     * 
     * @param style the alignment of the label
     */
    public ContainerFigure(int style)
    {
    	this.headerStyle = style;
    	createContents();
    }
    
    /**
     * Creates the contents of the figure : by defauft, it creates a layout
     * manager, a header and a container
     */
    protected void createContents()
    {
        LayoutManager layout = createLayout();
        setLayoutManager(layout);
    
        header = createLabel();
        add(header, new GridData(headerStyle));
    
        contentPane = createContainer();
        add(contentPane, new GridData(GridData.FILL_BOTH));
    }
    
    /**
     * Creates the layout manager
     * 
     * @return the layout manager
     */
    protected LayoutManager createLayout()
    {
        GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.horizontalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        return gridLayout;
    }
        
    /**
     * Creates the header figure
     * 
     * @return the header figure
     * @deprecated use createLabel instead
     */
    protected IFigure createHeader()
    {
        return null;
    }
    
    /**
     * Creates the header figure
     * 
     * @return the header figure
     */
    protected ILabel createLabel()
    {
    	ILabel label = (ILabel) createHeader();
    	if (label == null)
    	{
    		label = new EditableLabel();
    		((EditableLabel) label).setAlignment(PositionConstants.LEFT);
    	}
        return label;
    }
    
    /**
     * Creates the container figure
     * 
     * @return the container figure
     */
    protected IFigure createContainer()
    {        
        Figure container = new Figure();
        container.setLayoutManager(new XYLayout());
        container.setOpaque(true);
        container.setBorder(new LineBorder(1));
        return container;
    }
    

    /**
     * Return the Header figure
     * 
     * @return returns the figure used to edit the name
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
     * Return the contentPane figure
     * 
     * @return the Container Figure
     */
    public IFigure getContentPane()
    {
        return contentPane;
    }
    
    /**
     * Set the Header figure
     * 
     * @param h the figure used to edit the name
     * @deprecated use setLabel instead
     */
    public void setHeader(IFigure h)
    {
        header = (ILabel) h;
    }

    /**
     * Set the Header figure
     * 
     * @param h the figure used to edit the name
     */
    public void setLabel(ILabel h)
    {
        header = h;
    }

    /**
     * Set the contentPane figure
     * 
     * @param pane the Container Figure
     */
    public void setContentPane(IFigure pane)
    {
        contentPane = pane;
    }
    
    
}
