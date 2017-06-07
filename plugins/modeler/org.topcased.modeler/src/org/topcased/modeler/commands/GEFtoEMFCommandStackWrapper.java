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
package org.topcased.modeler.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;

/**
 * Wrapper that adapts a {@link org.eclipse.gef.commands.CommandStack GEF 
 * Command Stack} to an {@link org.eclipse.emf.common.command.CommandStack EMF
 * Command Stack}.
 * 
 * Creation : 21 fev. 2006
 * 
 * @author aarong, <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
 *         LESCOT</a>
 */
public final class GEFtoEMFCommandStackWrapper implements CommandStack
{
    /** The wrapped GEF Command Stack */
    private final org.eclipse.gef.commands.CommandStack gefCommandStack;

    /** Map of converted command stack listeners */
    private final Map<CommandStackListener, org.eclipse.gef.commands.CommandStackListener> convertedListeners;

    /**
     * Constructor
     * 
     * @param commandStack the CommandStack to wrap
     */
    public GEFtoEMFCommandStackWrapper(final org.eclipse.gef.commands.CommandStack commandStack)
    {
        gefCommandStack = commandStack;
        convertedListeners = new HashMap<CommandStackListener, org.eclipse.gef.commands.CommandStackListener>();
    }

    /**
     * Return the EMF Command associated with a GEF Command
     * 
     * @param gefCommand the GEF Command
     * @return the EMF Command
     */
    private static Command convertToEMFCommand(final org.eclipse.gef.commands.Command gefCommand)
    {
        if (gefCommand == null)
        {
            return null;
        }
        else if (gefCommand instanceof EMFtoGEFCommandWrapper)
        {
            return ((EMFtoGEFCommandWrapper) gefCommand).getEMFCommand();
        }
        else
        {
            return new GEFtoEMFCommandWrapper(gefCommand);
        }
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#execute(org.eclipse.emf.common.command.Command)
     */
    public void execute(final Command command)
    {
        gefCommandStack.execute(new EMFtoGEFCommandWrapper(command));
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#canUndo()
     */
    public boolean canUndo()
    {
        return gefCommandStack.canUndo();
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#undo()
     */
    public void undo()
    {
        gefCommandStack.undo();
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#canRedo()
     */
    public boolean canRedo()
    {
        return gefCommandStack.canRedo();
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#getUndoCommand()
     */
    public Command getUndoCommand()
    {
        final org.eclipse.gef.commands.Command undoCommand = gefCommandStack.getUndoCommand();

        return convertToEMFCommand(undoCommand);
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#getRedoCommand()
     */
    public Command getRedoCommand()
    {
        final org.eclipse.gef.commands.Command redoCommand = gefCommandStack.getUndoCommand();

        return convertToEMFCommand(redoCommand);
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#getMostRecentCommand()
     */
    public Command getMostRecentCommand()
    {
        final org.eclipse.gef.commands.Command recentCommand = gefCommandStack.getUndoCommand();

        return convertToEMFCommand(recentCommand);
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#redo()
     */
    public void redo()
    {
        gefCommandStack.redo();
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#flush()
     */
    public void flush()
    {
        gefCommandStack.flush();
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#addCommandStackListener(org.eclipse.emf.common.command.CommandStackListener)
     */
    public void addCommandStackListener(final CommandStackListener listener)
    {
        final org.eclipse.gef.commands.CommandStackListener wrapped = new EMFtoGEFCommandStackListenerWrapper(listener);

        convertedListeners.put(listener, wrapped);
        gefCommandStack.addCommandStackListener(wrapped);
    }

    /**
     * @see org.eclipse.emf.common.command.CommandStack#removeCommandStackListener(org.eclipse.emf.common.command.CommandStackListener)
     */
    public void removeCommandStackListener(final CommandStackListener listener)
    {
        final org.eclipse.gef.commands.CommandStackListener wrapped = (org.eclipse.gef.commands.CommandStackListener) convertedListeners.get(listener);

        if (wrapped != null)
        {
            gefCommandStack.removeCommandStackListener(wrapped);
            convertedListeners.remove(listener);
        }
    }
    
    public org.eclipse.gef.commands.CommandStack getGEFCommandStack()
    {
        return gefCommandStack ;
    }

}
