/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.exceptions.EditingDomainReadOnlyException;

/**
 * Copy of the GEF command stack with some bug fixes. Waiting the bug #39386 will be fixed.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class CommandStack extends org.eclipse.gef.commands.CommandStack
{

    private int undoLimit = 0;

    private int saveLocation = 0;

    private int state = UNDEFINED;

    private Stack<Command> undoable = new Stack<Command>();

    private Stack<Command> redoable = new Stack<Command>();

    /**
     * The list of {@link CommandStackListener}s.
     * 
     * @deprecated This field should not be referenced, use {@link #notifyListeners()}
     */
    protected List<CommandStackListener> listeners = new ArrayList<CommandStackListener>();

    private List<CommandStackEventListener> eventListeners = new ArrayList<CommandStackEventListener>();

    /**
     * Constant indicating command stack in undefiend state
     */
    public static final int UNDEFINED = -1;

    /**
     * Constant indicating notification prior to executing a command (value is 1).
     */
    public static final int PRE_EXECUTE = 1;

    /**
     * Constant indicating notification prior to redoing a command (value is 2).
     */
    public static final int PRE_REDO = 2;

    /**
     * Constant indicating notification prior to undoing a command (value is 4).
     */
    public static final int PRE_UNDO = 4;

    /**
     * Constant indicating notification after a command has been executed (value is 8).
     */
    public static final int POST_EXECUTE = 8;

    /**
     * Constant indicating notification after a command has been redone (value is 16).
     */
    public static final int POST_REDO = 16;

    /**
     * Constant indicating notification after a command has been undone (value is 32).
     */
    public static final int POST_UNDO = 32;

    /**
     * Constructs a new command stack. By default, there is no undo limit, and isDirty() will return <code>false</code>.
     */
    public CommandStack()
    {
        // DO nothing
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.topcased.modeler.commandsStackListeners");
        for (IConfigurationElement e : elements)
        {
            try
            {
                CommandStackEventListener listener = (CommandStackEventListener) e.createExecutableExtension("commandStackListener");
                eventListeners.add(listener);

            }
            catch (CoreException e1)
            {
                e1.printStackTrace();
            }

        }
    }

    /**
     * Return the command of class given in parameter
     * 
     * @param command
     * @param clazz
     * @return
     */
    public static List<Object> getCommands(Command command, Class< ? > clazz, boolean instanceOK)
    {
        List<Object> result = new LinkedList<Object>();
        if (clazz == null)
        {
            return result;
        }
        if (clazz.equals(command.getClass()) || (instanceOK && clazz.isAssignableFrom(command.getClass())))
        {
            result.add(command);
        }
        else if (command instanceof EMFtoGEFCommandWrapper)
        {
            if (((EMFtoGEFCommandWrapper) command).getEMFCommand().getClass().equals(clazz) || (instanceOK && clazz.isAssignableFrom(((EMFtoGEFCommandWrapper) command).getEMFCommand().getClass())))
            {
                result.add(((EMFtoGEFCommandWrapper) command).getEMFCommand());
            }
        }
        else if (command instanceof CompoundCommand)
        {
            CompoundCommand compound = (CompoundCommand) command;
            List commands = compound.getCommands();
            for (Object o : commands)
            {
                if (o instanceof Command)
                {
                    List<Object> tmp = getCommands((Command) o, clazz, instanceOK);
                    if (!(tmp.isEmpty()))
                    {
                        result.addAll(tmp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Return the command of class given in parameter
     * 
     * @param command
     * @param clazz
     * @return
     */
    public static List<Object> getCommands(Command command, Class< ? > clazz)
    {
        return getCommands(command, clazz, false);
    }

    /**
     * Appends the listener to the list of command stack listeners. Multiple adds will result in multiple notifications.
     * 
     * @param listener the listener
     */
    public void addCommandStackListener(CommandStackListener listener)
    {
        listeners.add(listener);
    }

    /**
     * Appends the listener to the list of command stack listeners. Multiple adds result in multiple notifications.
     * 
     * @since 3.1
     * @param listener the event listener
     */
    public void addCommandStackEventListener(CommandStackEventListener listener)
    {
        eventListeners.add(listener);
    }

    /**
     * @return <code>true</code> if it is appropriate to call {@link #redo()}.
     */
    public boolean canRedo()
    {
        return !redoable.isEmpty();
    }

    /**
     * @return <code>true</code> if {@link #undo()} can be called
     */
    public boolean canUndo()
    {
        if (undoable.size() == 0)
        {
            return false;
        }
        return ((Command) undoable.lastElement()).canUndo();
    }

    /**
     * Executes the specified Command if possible. Prior to executing the command, a CommandStackEvent for
     * {@link #PRE_EXECUTE} will be fired to event listeners. Similarly, after attempting to execute the command, an
     * event for {@link #POST_EXECUTE} will be fired. If the execution of the command completely normally, stack
     * listeners will receive {@link CommandStackListener#commandStackChanged(EventObject) stackChanged} notification.
     * <P>
     * If the command is <code>null</code> or cannot be executed, nothing happens.
     * 
     * @param command the Command to execute
     * @see CommandStackEventListener
     */
    public void execute(Command command)
    {
        if (command == null || !command.canExecute())
        {
            return;
        }
        flushRedo();
        notifyListeners(command, PRE_EXECUTE);
        try
        {
            command.execute();
            if (getUndoLimit() > 0)
            {
                while (undoable.size() >= getUndoLimit())
                {
                    Command remove = (Command) undoable.remove(0);
                    remove.dispose();
                    if (saveLocation > -1)
                    {
                        saveLocation--;
                    }
                }
            }
            if (saveLocation > undoable.size())
            {
                saveLocation = -1; // The save point was somewhere in the redo
            }
            // stack
            undoable.push(command);
            notifyListeners();
        }
        catch (EditingDomainReadOnlyException ex)
        {
            String message = "The action can not be performed.\nA resource modified by this action is read-only";
            Resource r = ex.getReadOnlyResource();
            if (r != null)
            {
                message += " : " + r.getURI().toString() + " ";
            }
            message += ".";
            MessageDialog.openError(Display.getDefault().getActiveShell(), "Read-Only resource", message);
        }
        finally
        {
            notifyListeners(command, POST_EXECUTE);
            // all is done we go back to undefined
            state = UNDEFINED;
        }
    }

    /**
     * @since 3.1
     * @param command
     * @param post_execute2
     */
    protected void notifyListeners(final Command command, final int newState)
    {

        this.state = newState;
        if (Display.getCurrent() != Display.getDefault())
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    safeNotifyListeners(command, newState);
                }
            });
        }
        else
        {
            safeNotifyListeners(command, state);
        }
    }

    /**
     * Sends dispose event
     */
    protected void safeDisposeNotifyListeners()
    {
        for (int i = 0; i < eventListeners.size(); i++)
        {
            if (eventListeners.get(i) instanceof IDisposableCommandStackEventListener)
            {
                IDisposableCommandStackEventListener listener = (IDisposableCommandStackEventListener) eventListeners.get(i);
                listener.dipose();
            }
        }
    }

    /**
     * Send the event in the UI thread
     * 
     * @param command
     * @param state
     */
    private void safeNotifyListeners(Command command, int state)
    {
        CommandStackEvent event = new CommandStackEvent(this, command, state);
        for (int i = 0; i < eventListeners.size(); i++)
        {
            ((CommandStackEventListener) eventListeners.get(i)).stackChanged(event);
        }
    }

    /**
     * This will <code>dispose()</code> all the commands in both the undo and redo stack. Both stacks will be empty
     * afterwards.
     */
    public void dispose()
    {
        flushUndo();
        flushRedo();
    }

    /**
     * Flushes the entire stack and resets the save location to zero. This method might be called when performing
     * "revert to saved".
     */
    public void flush()
    {
        flushRedo();
        flushUndo();
        saveLocation = 0;
        notifyListeners();
    }

    private void flushRedo()
    {
        while (!redoable.isEmpty())
        {
            Command pop = (Command) redoable.pop();
            pop.dispose();
            notifyDisposeListeners();
        }
    }

    private void flushUndo()
    {
        while (!undoable.isEmpty())
        {
            Command pop = (Command) undoable.pop();
            pop.dispose();
            notifyDisposeListeners();
        }
    }

    protected void notifyDisposeListeners()
    {
        if (Display.getCurrent() != Display.getDefault())
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    safeDisposeNotifyListeners();
                }
            });
        }
        else
        {
            safeDisposeNotifyListeners();
        }
    }

    /**
     * @return an array containing all commands in the order they were executed
     */
    public Object[] getCommands()
    {
        List<Command> commands = new ArrayList<Command>(undoable);
        for (int i = redoable.size() - 1; i >= 0; i--)
        {
            commands.add(redoable.get(i));
        }
        return commands.toArray();
    }

    /**
     * Peeks at the top of the <i>redo</i> stack. This is useful for describing to the User what will be redone. The
     * returned <code>Command</code> has a label describing it.
     * 
     * @return the top of the <i>redo</i> stack, which may be <code>null</code>
     */
    public Command getRedoCommand()
    {
        return redoable.isEmpty() ? null : (Command) redoable.peek();
    }

    /**
     * Peeks at the top of the <i>undo</i> stack. This is useful for describing to the User what will be undone. The
     * returned <code>Command</code> has a label describing it.
     * 
     * @return the top of the <i>undo</i> stack, which may be <code>null</code>
     */
    public Command getUndoCommand()
    {
        return undoable.isEmpty() ? null : (Command) undoable.peek();
    }

    /**
     * Returns the undo limit. The undo limit is the maximum number of atomic operations that the User can undo.
     * <code>-1</code> is used to indicate no limit.
     * 
     * @return the undo limit
     */
    public int getUndoLimit()
    {
        return undoLimit;
    }

    /**
     * Returns true if the stack is dirty. The stack is dirty whenever the last executed or redone command is different
     * than the command that was at the top of the undo stack when {@link #markSaveLocation()} was last called.
     * 
     * @return <code>true</code> if the stack is dirty
     */
    public boolean isDirty()
    {
        return undoable.size() != saveLocation;
    }

    /**
     * Marks the last executed or redone Command as the point at which the changes were saved. Calculation of
     * {@link #isDirty()} will be based on this checkpoint.
     */
    public void markSaveLocation()
    {
        saveLocation = undoable.size();
        notifyListeners();
    }

    /**
     * Sends notification to all {@link CommandStackListener}s.
     * 
     * @deprecated
     */
    protected void notifyListeners()
    {

        if (Display.getCurrent() != Display.getDefault())
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    safeNotifyListeners();
                }
            });
        }
        else
        {
            safeNotifyListeners();
        }
    }

    /**
     * Send the event in the UI thread
     * 
     * @deprecated
     */
    private void safeNotifyListeners()
    {
        EventObject event = new EventObject(this);
        for (int i = 0; i < listeners.size(); i++)
        {
            ((CommandStackListener) listeners.get(i)).commandStackChanged(event);
        }
    }

    /**
     * Calls redo on the Command at the top of the <i>redo</i> stack, and pushes that Command onto the <i>undo</i>
     * stack. This method should only be called when {@link #canUndo()} returns <code>true</code>.
     */
    public void redo()
    {
        // Assert.isTrue(canRedo())
        if (!canRedo())
        {
            return;
        }
        Command command = (Command) redoable.pop();
        notifyListeners(command, PRE_REDO);
        try
        {
            command.redo();
            undoable.push(command);
            notifyListeners();
        }
        finally
        {
            notifyListeners(command, POST_REDO);
        }
    }

    /**
     * Removes the first occurrence of the specified listener.
     * 
     * @param listener the listener
     */
    public void removeCommandStackListener(CommandStackListener listener)
    {
        listeners.remove(listener);
    }

    /**
     * Removes the first occurrence of the specified listener.
     * 
     * @param listener the listener
     */
    public void removeCommandStackEventListener(CommandStackEventListener listener)
    {
        eventListeners.remove(listener);
    }

    /**
     * Sets the undo limit. The undo limit is the maximum number of atomic operations that the User can undo.
     * <code>-1</code> is used to indicate no limit.
     * 
     * @param undoLimit the undo limit
     */
    public void setUndoLimit(int undoLimit)
    {
        this.undoLimit = undoLimit;
    }

    /**
     * Undoes the most recently executed (or redone) Command. The Command is popped from the undo stack to and pushed
     * onto the redo stack. This method should only be called when {@link #canUndo()} returns <code>true</code>.
     */
    public void undo()
    {
        // Assert.isTrue(canUndo());
        Command command = (Command) undoable.pop();
        notifyListeners(command, PRE_UNDO);
        try
        {
            command.undo();
            redoable.push(command);
            notifyListeners();
        }
        finally
        {
            notifyListeners(command, POST_UNDO);
        }
    }

    // ---------------------------------------
    // Added method
    // ---------------------------------------
    /**
     * Returns the undoable commands
     * 
     * @return the list of commands
     */
    protected Stack<Command> getUndoable()
    {
        return undoable;
    }

    /**
     * Returns the redoable commands
     * 
     * @return the list of commands
     */
    protected Stack<Command> getRedoable()
    {
        return redoable;
    }

    /**
     * Returns the save location
     * 
     * @return the save index
     */
    protected int getSaveLocation()
    {
        return saveLocation;
    }

    public int getState()
    {
        return state;
    }
}
