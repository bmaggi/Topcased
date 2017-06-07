/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.GraphNodeEditPart;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * A class defining an action to move forward a graph element.<br/> Creation :
 * 11 oct. 2005
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class MoveForwardAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    AbstractGraphicalEditPart graphElement;

    public MoveForwardAction(IWorkbenchPart part)
    {
        super(part);
        setActionDefinitionId("org.topcased.modeler.moveForward");
        part.getSite().getKeyBindingService().registerAction(this);
    }
    
    @Override
	public void dispose() {
		super.dispose();
		graphElement = null ;
	}

	public void selectionChanged(SelectionChangedEvent event)
    {
        ISelection s = event.getSelection();
        if (!(s instanceof IStructuredSelection))
        {
            return;
        }
        IStructuredSelection selection = (IStructuredSelection) s;
        graphElement = null;

        if (selection != null && selection.size() == 1)
        {
            Object obj = selection.getFirstElement();
            if (obj instanceof GraphNodeEditPart)
            {
                GraphNodeEditPart ed = ((GraphNodeEditPart) obj);
                graphElement = ed;
            }
            if (obj instanceof GraphEdgeEditPart)
            {
                GraphEdgeEditPart ed = ((GraphEdgeEditPart) obj);
                graphElement = ed;
            }
        }

        refresh();
    }

    protected boolean calculateEnabled()
    {
        if (graphElement == null)
        {
            return false;
        }

        // Construct the MoveForward request
        Request request = new Request(ModelerRequestConstants.REQ_MOVE_FORWARD);

        // Return true if the EditPart can understand the Request
        return graphElement.understandsRequest(request);
    }

    protected void init()
    {
        setId(ModelerActionConstants.MOVE_FORWARD);
        setText("Move forward");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("MOVE_FORWARD"));
    }

    public void run()
    {
        // Construct the MoveForward request
        Request request = new Request(ModelerRequestConstants.REQ_MOVE_FORWARD);

        // Get the Command
        Command actionCommand = graphElement.getCommand(request);

        // Execute the command
        getCommandStack().execute(actionCommand);
    }
}
