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
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.editor.resource.EditingDomainHelper;

/**
 * Default delete command. Just erase the graph element from the diagram, it do
 * not delete the model element. <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
class DeleteGraphNodeCommand extends Command
{
    private GraphNode deletedNode;

    private GraphElement parent;

    /**
     * Constructor
     */
    public DeleteGraphNodeCommand()
    {
        super("Delete Node");
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return !EditingDomainHelper.isEObjectReadOnly(parent);
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        if (parent != null)
        {
            parent.getContained().remove(deletedNode);
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        parent = deletedNode.getContainer();
        redo();
    }

    /**
     * Set the edit part that must be deleted
     * 
     * @param model the graph object to be deleted
     * @return the delete command
     */
    public Command setPartToBeDeleted(Object model)
    {
        if (model instanceof GraphNode)
        {
            deletedNode = (GraphNode) model;
            return this;
        }

        return null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if (parent != null)
        {
            parent.getContained().add(deletedNode);
        }
    }

}
