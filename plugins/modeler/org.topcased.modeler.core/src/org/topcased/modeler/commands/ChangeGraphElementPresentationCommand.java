/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.GraphElement;

/**
 * That command is used to change the presentation field of a GraphElement<br>
 * 
 * Creation 5 mars 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangeGraphElementPresentationCommand extends Command
{
    private GraphElement graphElement;

    private String oldPresentation;

    private String newPresentation;

    /**
     * Constructor
     * 
     * @param graphElt the GraphElement
     * @param newPres the new presentation value
     */
    public ChangeGraphElementPresentationCommand(GraphElement graphElt, String newPres)
    {
        super("Change the Presentation");
        this.graphElement = graphElt;
        this.newPresentation = newPres;

    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return graphElement != null && graphElement.getSemanticModel() != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        oldPresentation = graphElement.getSemanticModel().getPresentation();

        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        graphElement.getSemanticModel().setPresentation(newPresentation);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        graphElement.getSemanticModel().setPresentation(oldPresentation);
    }

}
