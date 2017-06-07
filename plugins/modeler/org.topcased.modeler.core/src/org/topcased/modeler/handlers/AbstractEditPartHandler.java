/***********************************************************************************************************************
 * Copyright (c) 2010 Communication & Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.modeler.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.editor.Modeler;

/**
 * Abstract edit part handler ables to trigger and execute GEF commands into the right command stack conformely to a
 * provided request applied to a set of edit parts. This class is intended to be subclassed by clients.<br>
 * 
 * Creation : 13 october 2010<br>
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 4.2.0
 */
public abstract class AbstractEditPartHandler extends AbstractHandler
{
    /**
     * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);
        if (selection instanceof IStructuredSelection)
        {
            CompoundCommand cc = new CompoundCommand();
            Request request = new Request(getRequestConstant());
            for (Object selected : ((IStructuredSelection) selection).toList())
            {
                if (selected instanceof EditPart)
                {
                    EditPart editPart = (EditPart) selected;
                    if (editPart.understandsRequest(request))
                    {
                        cc.add(editPart.getCommand(request));
                    }
                }
            }

            // execute the compound command
            getCommandStack(event).execute(cc);
        }
        return null;
    }

    /**
     * Gets the editor's command stack according to the execution event.
     * 
     * @param event the execution event.
     * @return the command stack of the current modeler or null if the active editor is not a modeler.
     */
    protected CommandStack getCommandStack(ExecutionEvent event)
    {
        IEditorPart editor = HandlerUtil.getActiveEditor(event);
        if (editor instanceof Modeler)
        {
            return (CommandStack) editor.getAdapter(CommandStack.class);
        }
        return null;
    }

    /**
     * Gets the resquest constant
     * 
     * @return The request constant
     */
    public abstract String getRequestConstant();

}
