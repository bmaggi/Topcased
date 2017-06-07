/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.commands.CommandStackEvent;

/**
 * This class listens the TOPCASED and move the corresponding diagram 
 * if the resource of the element changes 
 * 
 * @see MoveDiagramCommandStackEvent
 */
public class MoveDiagramCommandStackListener implements IDisposableCommandStackEventListener
{

    /** The commands. */
    private Map<DragAndDropCommand, MoveDiagramCommand> commands = new HashMap<DragAndDropCommand, MoveDiagramCommand>();
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.commands.CommandStackEventListener#stackChanged(org.eclipse.gef.commands.CommandStackEvent)
     */
    public void stackChanged(CommandStackEvent event)
    {
        List<Object> commands = CommandStack.getCommands(event.getCommand(), DragAndDropCommand.class);
        for (Object o : commands)
        {
            if (o instanceof DragAndDropCommand)
            {
                DragAndDropCommand dragAndDrop = (DragAndDropCommand) o;
                switch (event.getDetail())
                {
                    // we perform before drag and drop because 
                    // we have to load the target corresponding diagram before the move 
                    case CommandStack.PRE_EXECUTE:
                        execute(dragAndDrop);
                        break;
                    case CommandStack.PRE_REDO:
                        redo(dragAndDrop);
                        break;
                    case CommandStack.POST_UNDO:
                        undo(dragAndDrop);
                        break;
                }

            }
        }
    }

    /**
     * Undo.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void undo(DragAndDropCommand dragAndDrop)
    {
        MoveDiagramCommand comm = commands.get(dragAndDrop);
        if (comm != null)
        {
            comm.undo();
        }
    }

    /**
     * Redo.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void redo(DragAndDropCommand dragAndDrop)
    {
        MoveDiagramCommand comm = commands.get(dragAndDrop);
        if (comm != null)
        {
            comm.redo();
        }
    }

    /**
     * Execute.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void execute(DragAndDropCommand dragAndDrop)
    {
        for (Object object : dragAndDrop.getCollection())
        {
            if (object instanceof EObject && dragAndDrop.getOwner() instanceof EObject)
            {
                EObject eobject = (EObject) object;
                if (eobject.eResource() != ((EObject)dragAndDrop.getOwner()).eResource())
                {
                    MoveDiagramCommand command = new MoveDiagramCommand(eobject,(EObject)dragAndDrop.getOwner(),AdapterFactoryEditingDomain.getEditingDomainFor(eobject));
                    command.execute();
                    commands.put(dragAndDrop, command);
                }
            }
        }
    }

    public void dipose()
    {
        commands.clear();
    }

}
