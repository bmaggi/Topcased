/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies), Nicolas Lalev�e (Anyware
 *    Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.editor.palette;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.swt.SWT;
import org.topcased.modeler.commands.IDialogCommand;

/**
 * A ConnectionCreationTool that support dialog commands.
 * 
 */
public class ModelerConnectionCreationTool extends ConnectionCreationTool
{
    /** Does the user have the ctrl key pressed? */
    private boolean isCtrlKeyDown;

    /**
     * Constructor
     */
    public ModelerConnectionCreationTool()
    {
        setUnloadWhenFinished(true);
    }
    
    /**
     * @see org.eclipse.gef.tools.AbstractTool#executeCurrentCommand()
     */
    @Override
    protected void executeCurrentCommand() {
        boolean ok = true;
        
        Command curCommand = getCurrentCommand();
        if (curCommand instanceof IDialogCommand)
        {
            ok = ((IDialogCommand) curCommand).openDialog();
        }
        if (ok && curCommand != null && curCommand.canExecute())
        {
            executeCommand(curCommand);
        }
        setCurrentCommand(null);
    }

    /**
     * Overridden so that the current tool will remain active (locked) if the
     * user is pressing the ctrl key.
     *
     * @see org.eclipse.gef.tools.AbstractTool#handleFinished() Called when the
     *      current tool operation is complete.
     */
    @Override
    protected void handleFinished() {
        if (!isCtrlKeyDown()) {
            super.handleFinished();
        } else {
            reactivate();
        }
    }
    
    /**
     * @see org.eclipse.gef.tools.AbstractConnectionCreationTool#handleButtonUp(int)
     */
    @Override
    protected boolean handleButtonUp(int button) {
        // SWT.COMMAND is used as a convenient Mac OS X binding
        if (isInState(STATE_TERMINAL | STATE_INVALID)) {
            setCtrlKeyDown(getCurrentInput().isModKeyDown(SWT.CONTROL | SWT.COMMAND));
            handleFinished();
        }
        return true;
    }
    
    /**
     * @param isCtrlKeyDown
     *            The isCtrlKeyDown to set.
     */
    protected void setCtrlKeyDown(boolean isCtrlKeyDown) {
        this.isCtrlKeyDown = isCtrlKeyDown;
    }
    
    /**
     * @return Returns the isCtrlKeyDown.
     */
    protected boolean isCtrlKeyDown() {
        return isCtrlKeyDown;
    }
}
