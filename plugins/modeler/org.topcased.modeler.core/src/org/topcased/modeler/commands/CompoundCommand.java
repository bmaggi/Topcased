/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies), Nicolas Lalevée (Anyware
 *    Technologies)  - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.commands.Command;

/**
 * This command just act like the GEF CompoundCommand.
 * 
 * The difference is that you can add already executed command, so they will not be executed a second time.
 * 
 * @see org.eclipse.gef.commands.CompoundCommand
 */
public class CompoundCommand extends org.eclipse.gef.commands.CompoundCommand
{
    private ArrayList<Command> unexecutedCommands;

    /**
     * Empty constructor
     */
    public CompoundCommand()
    {
        unexecutedCommands = new ArrayList<Command>();
    }

    /**
     * Empty constructor
     * 
     * @param label Command label
     */
    public CompoundCommand(String label)
    {
        super(label);
        unexecutedCommands = new ArrayList<Command>();
    }

    /**
     * @see org.eclipse.gef.commands.CompoundCommand#add(org.eclipse.gef.commands.Command)
     */
    public void add(Command command)
    {
        super.add(command);
        unexecutedCommands.add(command);
    }
    
    /**
     * Before adding a command, the canExecute() method is called. 
     * 
     * @param command A command to execute
     */
    public void addIfCanExecute(Command command)
    {
        if (command.canExecute())
        {
            add(command);
        }
    }

    /**
     * Add an already executed command to the list of commands
     * 
     * @param command the executed command
     */
    public void addExecuted(Command command)
    {
        super.add(command);
    }

    /**
     * Add and execute a command.
     * 
     * @param command the executed command
     * @return <code>true</code> if the command have been executed, <code>false</code>otherwise.
     */
    public boolean addAndExecute(Command command)
    {
        // the command is added only if marked as executable.
        if (command != null && command.canExecute())
        {
            super.add(command);
            command.execute();
            return true;
        }
        return false;
    }

    /**
     * @see org.eclipse.gef.commands.CompoundCommand#canExecute()
     */
    public boolean canExecute()
    {
        if (getCommands().size() == 0 && unexecutedCommands.size() == 0)
        {
            return false;
        }
        for (int i = 0; i < unexecutedCommands.size(); i++)
        {
            Command cmd = unexecutedCommands.get(i);
            if (cmd == null || !cmd.canExecute())
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Only execute commands that were not executed yet
     * 
     * @see org.eclipse.gef.commands.CompoundCommand#execute()
     */
    public void execute()
    {
        for (int i = 0; i < unexecutedCommands.size(); i++)
        {
            Command cmd = unexecutedCommands.get(i);
            cmd.execute();
        }
    }
    
    /**
     * Undo only executed commands.
     */
    @SuppressWarnings("unchecked")
    public void undoExecuted()
    {
        getCommands().removeAll(unexecutedCommands);
        Collections.reverse(getCommands());
        for (Command command : (List<Command>) getCommands())
        {
           command.undo(); 
        }
    }

}
