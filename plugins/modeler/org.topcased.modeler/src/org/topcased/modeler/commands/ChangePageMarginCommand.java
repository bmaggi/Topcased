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
import org.topcased.modeler.preferences.PageMargin;

/**
 * The command used to change the pageMargin of a diagram
 * 
 * Creation 27 avr. 2006
 *
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangePageMarginCommand extends Command
{

    private Diagram diagram;

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

    /**
     * Constructor
     * 
     * @param diag the Diagram
     * @param newPageMargin the new pageMargin
     */
    public ChangePageMarginCommand(Diagram diag, PageMargin newPageMargin)
    {
        super("Change PageMargin");
        this.diagram = diag;
        this.newPageMarginName = newPageMargin.getName();
        this.newTopMargin = StringConverter.asString(newPageMargin.getTop());
        this.newBottomMargin = StringConverter.asString(newPageMargin.getBottom());
        this.newLeftMargin = StringConverter.asString(newPageMargin.getLeft());
        this.newRightMargin = StringConverter.asString(newPageMargin.getRight());

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
        oldPageMarginName = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME);
        oldTopMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.TOP_MARGIN);
        oldBottomMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.BOTTOM_MARGIN);
        oldLeftMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.LEFT_MARGIN);
        oldRightMargin = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.RIGHT_MARGIN);

        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME, newPageMarginName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.TOP_MARGIN, newTopMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.BOTTOM_MARGIN, newBottomMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.LEFT_MARGIN, newLeftMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.RIGHT_MARGIN, newRightMargin);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        DIUtils.setProperty(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME, oldPageMarginName);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.TOP_MARGIN, oldTopMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.BOTTOM_MARGIN, oldBottomMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.LEFT_MARGIN, oldLeftMargin);
        DIUtils.setProperty(diagram, ModelerPropertyConstants.RIGHT_MARGIN, oldRightMargin);
    }

}
