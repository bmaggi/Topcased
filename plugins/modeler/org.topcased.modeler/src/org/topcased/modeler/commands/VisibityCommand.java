/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.commands;

import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.DiagramElement;

/**
 * This command switch on/off the visibility of a graphical element
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class VisibityCommand extends Command
{

    private final DiagramElement element;
    private final boolean show;

    /**
     * Constructor
     * @param element The graphical element to show/hide
     * @param show define if the element must be shown or hidden
     */
    public VisibityCommand(DiagramElement element, boolean show)
    {
        super("Visibility");
        this.element = element;
        this.show = show;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        redo();
    }
    
    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        element.setVisible(show);
    }
    
    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        element.setVisible(!show);
    }
}
