/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    Nicolas Lalev�e (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.commands;

/**
 * This type of command is typically used by creation tools. Before the effective
 * creation of a graph object, some information to complete the operation can be
 * retreived by a dialog. This dialog can have a cancel button which will cancel
 * the entire command. For this type of command, before execute them, the openDialog
 * have to be called, and then do the execute if the dialog returned true.
 * 
 * @see org.topcased.modeler.editor.palette.ModelerCreationTool#executeCurrentCommand()
 */
public interface IDialogCommand
{

    /**
     * Function called just before the execution of the command to open a dialog
     * 
     * @return false if the execution of this command is canceled
     */
    boolean openDialog();
    
}
