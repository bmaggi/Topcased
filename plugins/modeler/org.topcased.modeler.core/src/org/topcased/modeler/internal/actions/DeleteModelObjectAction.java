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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.DeleteModelCommand;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.precondition.ActionPreconditionHandler;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.utils.Utils;

/**
 * 
 * Creation : 09 may 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT </a>
 */
public class DeleteModelObjectAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    /**
     * The selected EditPart objects
     */
    private List<AbstractGraphicalEditPart> templates;

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public DeleteModelObjectAction(IWorkbenchPart part)
    {
        super(part);
        setActionDefinitionId("org.topcased.modeler.deleteModelObject");
        part.getSite().getKeyBindingService().registerAction(this);
        templates = new ArrayList<AbstractGraphicalEditPart>();
    }

    /**
     * Add a new diagram
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        boolean conditionsChecked = ActionPreconditionHandler.getInstance().executePreconditions(this, modeler, new StructuredSelection(templates));
        if (conditionsChecked)
        {
            // construct the DeleteModelObjectRequest
            Request request = new Request(ModelerRequestConstants.REQ_DELETE_MODEL_OBJECT);
            CompoundCommand ccommand = new CompoundCommand();
            // get the Command
            try
            {
                DeleteModelCommand.initListening();
                // sort elements with connections deletion in first
                Collections.sort(templates, new Utils.EditPartComparator());
                for (Iterator<AbstractGraphicalEditPart> iter = templates.iterator(); iter.hasNext();)
                {
                    ccommand.add((iter.next()).getCommand(request));
                }
            }
            finally
            {
                DeleteModelCommand.stopListening();
            }

            // execute the command
            getCommandStack().execute(ccommand);
        }
    }

    /**
     * Determine if the action must appear in the context menu
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    protected boolean calculateEnabled()
    {
        boolean enable = false;

        // construct the ChangeColorRequest
        Request request = new Request(ModelerRequestConstants.REQ_DELETE_MODEL_OBJECT);

        for (Iterator<AbstractGraphicalEditPart> iter = templates.iterator(); iter.hasNext();)
        {
            AbstractGraphicalEditPart element = iter.next();
            enable = element.understandsRequest(request);
            if (!enable)
            {
                break;
            }
        }
        // return true if the EditPart can understand the Request
        return enable;
    }

    /**
     * Initializes the delete from model action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.DELETE_MODEL_OBJECT);
        setText(Messages.getString("DeleteModelObjectAction.CmdLabel"));
        setImageDescriptor(ModelerPlugin.getImageDescriptor("icons/deleteFromModel.gif"));
    }

    /**
     * Sets the selected EditPart and refreshes the enabled state of this action.
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
        templates.clear();
        if (selection != null)
        {
            for (Iterator< ? > iter = selection.iterator(); iter.hasNext();)
            {
                Object obj = iter.next();
                if (obj instanceof EMFGraphNodeEditPart || obj instanceof EMFGraphEdgeEditPart)
                {
                    templates.add((AbstractGraphicalEditPart) obj);
                }

            }
        }

        refresh();
    }

}
