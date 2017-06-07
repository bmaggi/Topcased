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
package org.topcased.modeler.commands;

import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.util.DIUtils;

/**
 * 
 * Creation : 22 mars 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangeDiagramPropertiesCommand extends Command
{

    private Diagram diagram;

    private String oldPageFormatName;

    private String newPageFormatName;

    private String oldPageWidth;

    private String newPageWidth;

    private String oldPageHeight;

    private String newPageHeight;

    private String oldPageMarginName;

    private String newPageMarginName;

    private String oldTopMargin;

    private String newTopMargin;

    private String oldBottomMargin;

    private String newBottomMargin;

    private String oldLeftMargin;

    private String newLeftMargin;

    private String oldRightMargin;

    private String newRightMargin;

    private String oldOrientation;

    private String newOrientation;

    /**
     * Constructor
     * 
     * @param diag the Diagram with new Properties
     * @param properties A map that contain the Diagram Properties
     */
    public ChangeDiagramPropertiesCommand(Diagram diag, Map<String, String> properties)
    {
        super("Change Diagram Properties");
       
        this.diagram = diag;
        this.newPageFormatName = (String) properties.get(ModelerPropertyConstants.PAGE_FORMAT_NAME);
        int width =  Integer.valueOf((String)properties.get(ModelerPropertyConstants.PAGE_WIDTH));
        int height = Integer.valueOf((String)properties.get(ModelerPropertyConstants.PAGE_HEIGHT));
        if(width <= 60 && height <= 60)
        {
            width = width * 6;
            height = height * 3;
        }
        this.newPageWidth = Integer.toString(width);
        this.newPageHeight = Integer.toString(height);
        this.newPageMarginName = (String) properties.get(ModelerPropertyConstants.PAGE_MARGIN_NAME);
        this.newTopMargin = (String) properties.get(ModelerPropertyConstants.TOP_MARGIN);
        this.newBottomMargin = (String) properties.get(ModelerPropertyConstants.BOTTOM_MARGIN);
        this.newLeftMargin = (String) properties.get(ModelerPropertyConstants.LEFT_MARGIN);
        this.newRightMargin = (String) properties.get(ModelerPropertyConstants.RIGHT_MARGIN);
        this.newOrientation = (String) properties.get(ModelerPropertyConstants.ORIENTATION);

    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return diagram != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        oldPageFormatName = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_FORMAT_NAME);
        oldPageWidth = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_WIDTH);
        oldPageHeight = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_HEIGHT);
        oldPageMarginName = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME);
        oldTopMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.TOP_MARGIN);
        oldBottomMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.BOTTOM_MARGIN);
        oldLeftMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.LEFT_MARGIN);
        oldRightMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.RIGHT_MARGIN);
        oldOrientation = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.ORIENTATION);

        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_FORMAT_NAME, newPageFormatName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_WIDTH, newPageWidth);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_HEIGHT, newPageHeight);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME, newPageMarginName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.TOP_MARGIN, newTopMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.BOTTOM_MARGIN, newBottomMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.LEFT_MARGIN, newLeftMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.RIGHT_MARGIN, newRightMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.ORIENTATION, newOrientation);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_FORMAT_NAME, oldPageFormatName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_WIDTH, oldPageWidth);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_HEIGHT, oldPageHeight);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME, oldPageMarginName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.TOP_MARGIN, oldTopMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.BOTTOM_MARGIN, oldBottomMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.LEFT_MARGIN, oldLeftMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.RIGHT_MARGIN, oldRightMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.ORIENTATION, oldOrientation);
    }

}
