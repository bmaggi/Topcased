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

import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.Modeler;

/**
 * This GEF command is used to switch and focus on a specified diagram.<br>
 * The older displayed diagram is kept (undo support).
 * 
 * Creation 04 november 2008
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 2.3.0
 */
public class SwitchDiagramCommand extends Command
{
    private Diagram oldDiagram;

    private Diagram newDiagram;

    private Modeler modeler;

    /**
     * Constructor
     * 
     * @param modeler A reference to the modeler
     * @param diagram the diagram to activate
     */
    public SwitchDiagramCommand(Modeler modeler, Diagram diagram)
    {
        super("Change Diagram");
        this.modeler = modeler;
        newDiagram = diagram;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return newDiagram != null && modeler != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        oldDiagram = modeler.getActiveDiagram();
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        modeler.setActiveDiagram(newDiagram);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        modeler.setActiveDiagram(oldDiagram);
    }

}
