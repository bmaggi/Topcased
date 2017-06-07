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

import org.eclipse.emf.common.command.AbstractCommand;

/**
 * An EMF Command that wraps a GEF command. Each method is redirected to the GEF
 * one. <br>
 * Adapts an {@link org.eclipse.gef.commands.Command GEF Command} to be a
 * {@link org.eclipse.emf.common.command.Command EMF Command}.
 * 
 * Creation : 21 fev. 2006
 * 
 * @author aarong, <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
 *         LESCOT</a>
 * 
 */
public class GEFtoEMFCommandWrapper extends AbstractCommand
{

    /** The wrapped GEF Command */
    private final org.eclipse.gef.commands.Command gefCommand;

    /**
     * Constructor
     * 
     * @param command the wrapped GEF command
     */
    public GEFtoEMFCommandWrapper(final org.eclipse.gef.commands.Command command)
    {
        gefCommand = command;
    }

    /**
     * @see org.eclipse.emf.common.command.Command#canExecute()
     */
    public boolean canExecute()
    {
        return gefCommand.canExecute();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#execute()
     */
    public void execute()
    {
        gefCommand.execute();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#canUndo()
     */
    public boolean canUndo()
    {
        return gefCommand.canUndo();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#undo()
     */
    public void undo()
    {
        gefCommand.undo();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#redo()
     */
    public void redo()
    {
        gefCommand.redo();
    }

    /**
     * @see org.eclipse.emf.common.command.Command#getLabel()
     */
    public String getLabel()
    {
        return gefCommand.getLabel();
    }

    /**
     * @return the gefCommand
     */
    public org.eclipse.gef.commands.Command getGefCommand()
    {
        return gefCommand;
    }

    /**
     * @see org.eclipse.emf.common.command.Command#dispose()
     */
    public void dispose()
    {
        gefCommand.dispose();
    }
}
