/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Rapha�l Faudou (Atos Origin) <a href="mailto:raphael.faudou@atosorigin.com">Raphael Faudou</a>,
 *  Thibault Landre (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramPropertiesCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.utils.Utils;

/**
 * This class represents the action to resize diagram page format.
 */
public class AutoResizePageAction extends WorkbenchPartAction implements ISelectionChangedListener
{

    /** The part. */
    private IWorkbenchPart part;

    /** The current diagram */
    private Diagram currentDiagram;

    /**
     * Instantiates a new select all connections action.
     * 
     * @param part the part
     */
    public AutoResizePageAction(IWorkbenchPart part)
    {
        super(part);
        this.part = part;
    }

    /**
     * Selection changed.
     * 
     * @param event the event
     * 
     * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
     */
    public void selectionChanged(SelectionChangedEvent event)
    {
        // do nothing
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    @Override
    protected boolean calculateEnabled()
    {
        return false;
    }

    /**
     * Initializes the paste action.
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.AUTO_RESIZE_PAGE);
        setText("Auto Resize Page");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("AUTO_RESIZE_PAGE"));
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#isEnabled()
     */
    @Override
    public boolean isEnabled()
    {
        return true;
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run()
    {
        Modeler modeler = (Modeler) part.getAdapter(Modeler.class);

        // Get the current diagram
        currentDiagram = modeler.getActiveDiagram();

        // Execute necessary resize on children nodes
        Utils.optimizelyResizeChildren(modeler.getRootEditPart(), getCommandStack());

        // Get the optimized dimension
        Dimension dim = Utils.getDiagramOptimizedDimension(modeler);

        // Create the map of properties for the diagram.
        Map<String, String> newProperties = new HashMap<String, String>();
        newProperties.put(ModelerPropertyConstants.PAGE_FORMAT_NAME, "");
        newProperties.put(ModelerPropertyConstants.PAGE_MARGIN_NAME, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.PAGE_FORMAT_NAME));
        newProperties.put(ModelerPropertyConstants.TOP_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.TOP_MARGIN));
        newProperties.put(ModelerPropertyConstants.BOTTOM_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.BOTTOM_MARGIN));
        newProperties.put(ModelerPropertyConstants.LEFT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.LEFT_MARGIN));
        newProperties.put(ModelerPropertyConstants.RIGHT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.RIGHT_MARGIN));
        newProperties.put(ModelerPropertyConstants.ORIENTATION, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.ORIENTATION));
        newProperties.put(ModelerPropertyConstants.PAGE_WIDTH, String.valueOf(dim.width));
        newProperties.put(ModelerPropertyConstants.PAGE_HEIGHT, String.valueOf(dim.height));

        // Create the command to change the property of the diagram
        ChangeDiagramPropertiesCommand changeDiagramPropertiesCommand = new ChangeDiagramPropertiesCommand(currentDiagram, newProperties);
        // execute it
        getCommandStack().execute(changeDiagramPropertiesCommand);

    }

}
