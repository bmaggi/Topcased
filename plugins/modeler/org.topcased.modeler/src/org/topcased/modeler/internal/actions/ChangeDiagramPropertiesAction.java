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

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.internal.dialogs.DiagramPropertiesDialog;

/**
 * 
 * Creation : 29 april 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT </a>
 */
public class ChangeDiagramPropertiesAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    /**
     * The selected EditPart object
     */
    private DiagramEditPart template;

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public ChangeDiagramPropertiesAction(IWorkbenchPart part)
    {
        super(part);
    }
    
    @Override
	public void dispose() {
		super.dispose();
		template = null ;
	}

	/**
     * Add a new diagram
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        Diagram diagram = (Diagram) template.getModel();

        DiagramPropertiesDialog diagramPropertiesDialog = new DiagramPropertiesDialog(diagram,
                getWorkbenchPart().getSite().getShell());

        if (diagramPropertiesDialog.open() == Window.OK)
        {
            if (diagram != null)
            {
                // construct the ChangeDiagramPropertiesRequest
                Request request = new Request(ModelerRequestConstants.REQ_CHANGE_DIAGRAM_PROPERTIES);
                request.setExtendedData(diagramPropertiesDialog.getNewDiagramProperties());

                // get the Command
                Command actionCommand = template.getCommand(request);

                // execute the command
                getCommandStack().execute(actionCommand);
            }

        }
    }

    /**
     * Determine if the action must appear in the context menu
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    protected boolean calculateEnabled()
    {
        if (template == null)
        {
            return false;
        }

        // construct the ChangeDiagramPropertiesRequest
        Request request = new Request(ModelerRequestConstants.REQ_CHANGE_DIAGRAM_PROPERTIES);
        // return true if the EditPart can understand the Request
        return template.understandsRequest(request);
    }

    /**
     * Initializes the paste action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.CHANGE_DIAGRAM_PROPERTIES);
        setText("Change Diagram Properties");
    }

    /**
     * Sets the selected EditPart and refreshes the enabled state of this
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
        template = null;

        if (selection != null && selection.size() == 1)
        {
            Object obj = selection.getFirstElement();
            if (obj instanceof DiagramEditPart)
            {
                DiagramEditPart ed = (DiagramEditPart) obj;
                template = ed;

            }
        }

        refresh();
    }

}
