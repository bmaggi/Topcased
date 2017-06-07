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
package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.RouterConstants;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.dialogs.RouterDialog;

/**
 * 
 * Creation : 21 mars 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT </a>
 */
public class ChangeRouterAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    /** The selected EditPart object */
    private List<AbstractGraphicalEditPart> editParts;

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public ChangeRouterAction(IWorkbenchPart part)
    {
        super(part);
    }

    /**
     * Add a new diagram
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        GraphEdgeEditPart edgePart = (GraphEdgeEditPart) editParts.get(0);
        String routingType = null;
        if (edgePart != null)
        {
            ConnectionRouter router = edgePart.getConnectionFigure().getConnectionRouter();
            routingType = RouterConstants.getRouterName(router);
        }
        RouterDialog routerDialog = new RouterDialog(ModelerPlugin.getActiveWorkbenchShell(), routingType);

        int result = routerDialog.open();
        if (result == Window.OK)
        {
            String routerName = routerDialog.getRouter();

            // construct the ChangeRouter Request
            Request request = new Request(ModelerRequestConstants.REQ_CHANGE_ROUTER);
            Map<String,String> params = new HashMap<String, String>();
            params.put(ModelerPropertyConstants.ROUTER, routerName);
            request.setExtendedData(params);

            // get the Command
            CompoundCommand actionCommand = new CompoundCommand();
            for (Iterator<AbstractGraphicalEditPart> iter = editParts.iterator(); iter.hasNext();)
            {
                AbstractGraphicalEditPart editPart = iter.next();
                actionCommand.add(editPart.getCommand(request));
            }

            // execute the command
            getCommandStack().execute(actionCommand);
        }
    }

    /**
     * Determine if the action must appear in the context menu
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    protected boolean calculateEnabled()
    {
        if (editParts == null)
        {
            return false;
        }

        // construct the ChangeColorRequest
        Request request = new Request(ModelerRequestConstants.REQ_CHANGE_ROUTER);

        // return true if all the selected EditParts can understand the Request
        for (Iterator<AbstractGraphicalEditPart> iter = editParts.iterator(); iter.hasNext();)
        {
            AbstractGraphicalEditPart editPart = iter.next();
            if (!editPart.understandsRequest(request))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Initializes the paste action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.CHANGE_ROUTER);
        setText("Change Router");
    }

    /**
     * Sets the selected EditParts and refreshes the enabled state of this
     * action.
     * 
     * @see ISelectionChangedListener#selectionChanged(SelectionChangedEvent)
     */
    public void selectionChanged(SelectionChangedEvent event)
    {
        ISelection s = event.getSelection();
        if (!(s instanceof IStructuredSelection))
        {
            return;
        }
        IStructuredSelection selection = (IStructuredSelection) s;

        if (selection != null)
        {
            editParts = new ArrayList<AbstractGraphicalEditPart>();

            for (Iterator iter = selection.iterator(); iter.hasNext();)
            {
                Object obj = iter.next();
                if (obj instanceof AbstractGraphicalEditPart)
                {
                    editParts.add((AbstractGraphicalEditPart) obj);
                }
            }
        }

        refresh();
    }

}
