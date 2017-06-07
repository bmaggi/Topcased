/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * David Sciamma (Anyware Technologies)
 * - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.requests.RestoreConnectionsRequest;

/**
 * A class defining an action to call the restoration of all the connections
 * from and to this object.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RestoreConnectionsAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    private AbstractEditPart abstractEP;

    /**
     * Constructor
     * 
     * @param part the selected EditPart
     */
    public RestoreConnectionsAction(IWorkbenchPart part)
    {
        super(part);
        // setActionDefinitionId("org.topcased.modeler.restoreConnections");
        part.getSite().getKeyBindingService().registerAction(this);
    }

    /**
     * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
     */
    public void selectionChanged(SelectionChangedEvent event)
    {
        ISelection s = event.getSelection();
        if (!(s instanceof IStructuredSelection))
        {
            return;
        }
        IStructuredSelection selection = (IStructuredSelection) s;
        abstractEP = null;

        if (selection != null && selection.size() == 1)
        {
            Object obj = selection.getFirstElement();
            if (obj instanceof EMFGraphNodeEditPart || obj instanceof EMFGraphEdgeEditPart)
            {
                abstractEP = (AbstractEditPart) obj;
            }
        }

        refresh();
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    protected boolean calculateEnabled()
    {
        // Construct the Restore Connections request
        RestoreConnectionsRequest request = new RestoreConnectionsRequest();

        // Return true if the EditPart can understand the Request
        return abstractEP != null && abstractEP.understandsRequest(request);
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.RESTORE_CONNECTIONS);
        setText("Restore connections");
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run()
    {
        // Construct the RestoreConnections request
        RestoreConnectionsRequest request = new RestoreConnectionsRequest();

        // Get the Command
        Command actionCommand = abstractEP.getCommand(request);

        // Execute the command
        getCommandStack().execute(actionCommand);
    }
}
