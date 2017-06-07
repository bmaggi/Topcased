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

import org.eclipse.gef.commands.Command;

/**
 * A GEF Command that wraps an EMF command. Each method is redirected to the EMF
 * one. <br>
 * Adapts an {@link org.eclipse.emf.common.command.Command EMF Command} to be a
 * {@link org.eclipse.gef.commands.Command GEF Command}.
 * 
 * Creation : 21 fev. 2006
 * 
 * @author aarong, <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
 *         LESCOT</a>
 */
public class EMFtoGEFCommandWrapper extends Command
{
    /**
     * The wrapped EMF Command. Package-level visibility so that the command
     * stack wrapper can access the field.
     */
    private org.eclipse.emf.common.command.Command emfCommand;
    
    /**
     * Constructor
     * 
     * @param command the wrapped EMF command
     */
    public EMFtoGEFCommandWrapper(final org.eclipse.emf.common.command.Command command)
    {
        super(command.getLabel());
        emfCommand = command;
    }

    /**
     * Returns the wrapped EMF command
     * 
     * @return the EMF command
     */
    public org.eclipse.emf.common.command.Command getEMFCommand()
    {
        return emfCommand;
    }

    /**
     * @see org.eclipse.gef.commands.Command#dispose()
     */
    public void dispose()
    {
        emfCommand.dispose();
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return emfCommand.canExecute();
    }

    /**
     * @see org.eclipse.gef.commands.Command#canUndo()
     */
    public boolean canUndo()
    {
        return emfCommand.canUndo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        emfCommand.execute();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        emfCommand.redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        emfCommand.undo();
    }

}
