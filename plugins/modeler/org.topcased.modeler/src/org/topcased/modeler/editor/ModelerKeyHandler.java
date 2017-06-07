/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.editor;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;

/**
 * This class handles the key events that occurs in the editor
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ModelerKeyHandler extends GraphicalViewerKeyHandler
{
    private CommandStack commandStack;

    /**
     * Constructor
     * 
     * @param editor the modeler
     */
    public ModelerKeyHandler(Modeler editor)
    {
        super((GraphicalViewer) editor.getAdapter(GraphicalViewer.class));

        commandStack = (CommandStack) editor.getAdapter(CommandStack.class);
    }

    /**
     * @see org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler#keyPressed(org.eclipse.swt.events.KeyEvent)
     */
    public boolean keyPressed(KeyEvent event)
    {
        if (event.stateMask == SWT.CTRL && event.keyCode == SWT.DEL)
        {
            List objects = getViewer().getSelectedEditParts();
            if (objects != null && !objects.isEmpty())
            {
                GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
                CompoundCommand compoundCmd = new CompoundCommand("Delete From Model");
                for (int i = 0; i < objects.size(); i++)
                {
                    EditPart object = (EditPart) objects.get(i);
                    Command cmd = object.getCommand(deleteReq);
                    if (cmd != null)
                    {
                        compoundCmd.add(cmd);
                    }
                }
                getCommandStack().execute(compoundCmd);
            }
            return true;
        }

        return super.keyPressed(event);
    }

    /**
     * Returns the editor command stack
     * 
     * @return the command stack
     */
    protected CommandStack getCommandStack()
    {
        return commandStack;
    }
}
