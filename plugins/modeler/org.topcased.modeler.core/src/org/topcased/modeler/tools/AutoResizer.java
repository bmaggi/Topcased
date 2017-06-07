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

package org.topcased.modeler.tools;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.topcased.modeler.requests.AutoResizeRequest;

/**
 * This class tries to resize all the given EditParts.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AutoResizer
{

    private int margin = 10;

    /**
     * Defines the margin around the inner objects
     * 
     * @param m the margin to use
     */
    public void setMargin(int m)
    {
        this.margin = m;
    }

    /**
     * Returns the autoresize command.
     * 
     * @param editParts the list of the EditParts to autoresize
     * @return the autoresize command
     */
    public Command getCommand(List editParts)
    {
        if (editParts.size() != 0)
        {
            // Command creation
            CompoundCommand resizeCommand = new CompoundCommand();
            for (Iterator iter = editParts.iterator(); iter.hasNext();)
            {
                AbstractGraphicalEditPart editPart = (AbstractGraphicalEditPart) iter.next();

                AutoResizeRequest request = new AutoResizeRequest();
                request.setMargin(margin);
                Command partCmd = editPart.getCommand(request);
                if (partCmd != null && partCmd.canExecute())
                {
                    resizeCommand.add(partCmd);
                }
            }
            return resizeCommand;
        }

        return UnexecutableCommand.INSTANCE;
    }
}
