/*****************************************************************************
 * 
 * ChangeGraphElementCommand - Command for updating the operation of e CallOperationAction.
 * 
 * Copyright (c) 2009 TOPCASED consortium.
 *
 * Contributors:
 * Thomas Szadel [(Atos Origin)] [thomas.szadel@atosorigin.com]
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;

/**
 * That command is used to change the element of a GraphElement<br>
 * 
 * @author tszadel
 */
public class ChangeGraphElementCommand extends Command
{
    private GraphElement graphElement;

    private EObject oldElement;

    private EObject newElement;

    /**
     * Constructor
     * 
     * @param graphElt the GraphElement
     * @param newElement the new element
     */
    public ChangeGraphElementCommand(GraphElement graphElt, EObject newElement)
    {
        super("Change the Element");
        this.graphElement = graphElt;
        this.newElement = newElement;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    @Override
    public boolean canExecute()
    {
        return graphElement != null && graphElement.getSemanticModel() != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    @Override
    public void execute()
    {
        oldElement = ((EMFSemanticModelBridge) graphElement.getSemanticModel()).getElement();
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    @Override
    public void redo()
    {
        ((EMFSemanticModelBridge) graphElement.getSemanticModel()).setElement(newElement);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    @Override
    public void undo()
    {
        ((EMFSemanticModelBridge) graphElement.getSemanticModel()).setElement(oldElement);
    }

}
