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

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.preferences.PageFormat;

/**
 * The command used to change the pageFormat of a diagram
 * 
 * Creation 27 avr. 2006
 *
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangePageFormatCommand extends Command
{

    private Diagram diagram;

    private String oldPageFormatName;

    private String newPageFormatName;

    private String oldPageWidth;

    private String newPageWidth;

    private String oldPageHeight;

    private String newPageHeight;

    /**
     * Constructor
     * 
     * @param diag the Diagram
     * @param newPageFormat the new pageFormat
     */
    public ChangePageFormatCommand(Diagram diag, PageFormat newPageFormat)
    {
        super("Change PageFormat");
        this.diagram = diag;
        this.newPageFormatName = newPageFormat.getName();
        this.newPageWidth = StringConverter.asString(newPageFormat.getWidth());
        this.newPageHeight = StringConverter.asString(newPageFormat.getHeight());

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
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_FORMAT_NAME, oldPageFormatName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_WIDTH, oldPageWidth);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_HEIGHT, oldPageHeight);
    }

}
