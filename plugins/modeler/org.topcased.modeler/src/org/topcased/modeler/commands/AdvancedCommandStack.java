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

/**
 * This command stack adds specific behavior for the modelers
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AdvancedCommandStack extends CommandStack
{
    /**
     * @see org.eclipse.gef.commands.CommandStack#isDirty()
     */
    public boolean isDirty()
    {
        if (getSaveLocation() < -1)
        {
            return true;
        }

        if (getUndoable().size() > getSaveLocation())
        {
            // Check executed commands (in Undo stack)
            for (int i = getUndoable().size(); i > getSaveLocation(); i--)
            {
                if (!(getUndoable().get(i - 1) instanceof INonDirtyingCommand))
                {
                    return true;
                }
            }
        }
        else
        {
            // Check undoed commands (in redo stack)
            int delta = getSaveLocation() - getUndoable().size();
            for (int i = getRedoable().size(); i > getRedoable().size() - delta; i--)
            {
                if (!(getRedoable().get(i - 1) instanceof INonDirtyingCommand))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
