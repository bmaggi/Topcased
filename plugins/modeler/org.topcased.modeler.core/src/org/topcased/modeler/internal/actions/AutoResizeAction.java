/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.tools.AutoResizer;

/**
 * Action that send an AutoResize request to a set of GraphNode.<br>
 * Creation : 21 mars 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT </a>
 */
public class AutoResizeAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    /** The selected EditPart object */
    private List editParts;

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public AutoResizeAction(IWorkbenchPart part)
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
        AutoResizer resizer = new AutoResizer();
        Command actionCommand = resizer.getCommand(editParts);

        // execute the command
        getCommandStack().execute(actionCommand);
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

        // construct the Resize Request
        ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);

        // return true if all the selected EditParts can understand the Request
        for (Iterator iter = editParts.iterator(); iter.hasNext();)
        {
            AbstractGraphicalEditPart editPart = (AbstractGraphicalEditPart) iter.next();
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
        setId(ModelerActionConstants.AUTO_RESIZE);
        setText("Auto Resize");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("AUTO_RESIZE"));
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
            editParts = new ArrayList();

            for (Iterator iter = selection.iterator(); iter.hasNext();)
            {
                Object obj = iter.next();
                if (obj instanceof AbstractGraphicalEditPart)
                {
                    editParts.add(obj);
                }
            }
        }

        refresh();
    }

}
