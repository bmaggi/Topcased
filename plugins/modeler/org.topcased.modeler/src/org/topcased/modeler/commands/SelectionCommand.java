/***********************************************************************************************************************
 * Copyright (c) 2008 TOPCASED consortium.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.modeler.commands;

import java.util.Collection;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.topcased.modeler.editor.Modeler;

/**
 * Command for selecting {@link EditPart} in the modeler.
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 *
 */
public class SelectionCommand extends Command
{
    /** Collection of parts processed */
    private Collection<EditPart> parts;
    
    /** Strore the potential previous selection */
    private ISelection oldSelection;
    
    /** Reference to the current modeler */
    private Modeler modeler;
    
    /**
     * Constructor
     * 
     * @param modeler The {@link Modeler} in which we are
     * @param parts The {@link EditPart} to select
     */
    public SelectionCommand(Modeler modeler, Collection<EditPart> parts)
    {
        this.modeler = modeler;
        this.parts = parts;
    }
    
    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    @Override
    public void execute()
    {
        // gets the old selection
        oldSelection = modeler.getSelection();
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    @Override
    public void redo()
    {
        ISelection newSelection = new StructuredSelection(parts.toArray());
        modeler.setSelection(newSelection);
    }
    
    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    @Override
    public void undo()
    {
        modeler.setSelection(oldSelection);
    }

}
