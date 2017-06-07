/***********************************************************************************************************************
 * Copyright (c) 2010 Communication & Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.utils.Utils;

/**
 * Abstract command handling deletion of non semantic graph edge. During this operation, it is possible to update
 * semantic reference of the source or target model object.<br>
 * 
 * Creation : 14 june 2010<br>
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 4.0.0
 */
public abstract class DeleteNonSemanticGraphEdgeCommand extends DeleteGraphElementCommand
{
    /** The source model element of the graph edge */
    private EObject source;

    /** The target model element of the graph edge */
    private EObject target;

    /**
     * Constructor
     * 
     * @param elt the GraphElement to delete
     * @param deleteEdge specify whether connections to or from the elt should be deleted too
     */
    public DeleteNonSemanticGraphEdgeCommand(GraphElement elt, boolean deleteEdge)
    {
        super(elt, deleteEdge);
        source = Utils.getElement(Utils.getSource((GraphEdge) elt));
        target = Utils.getElement(Utils.getTarget((GraphEdge) elt));
    }

    /**
     * Gets the source model object of this non semantic connection
     * 
     * @return The source model object of this non semantic connection
     */
    public EObject getSource()
    {
        return source;
    }

    /**
     * The target model object of this non semantic connection
     * 
     * @return The target model object of this non semantic connection
     */
    public EObject getTarget()
    {
        return target;
    }

    /**
     * @see org.eclipse.gef.commands.CompoundCommand#undo()
     */
    @Override
    public void undo()
    {
        setReference();
        super.undo();
    }

    /**
     * @see org.eclipse.gef.commands.CompoundCommand#redo()
     */
    @Override
    public void redo()
    {
        unsetReference();
        super.redo();
    }

    /**
     * @see org.eclipse.gef.commands.CompoundCommand#execute()
     */
    @Override
    public void execute()
    {
        unsetReference();
        super.execute();
    }

    /**
     * Update a given reference either from the source model object or the target model object.
     */
    protected abstract void setReference();

    /**
     * Update a given reference either from the source model object or the target model object.
     */
    protected abstract void unsetReference();

}