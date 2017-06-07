/*******************************************************************************
 * Copyright (c) 2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vincent Hemery (Atos Origin) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.resize;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.topcased.modeler.di.model.GraphNode;

/**
 * This abstract class must be extended to use the extension point org.topcased.modeler.optimizedResize. It allows to
 * define a class which will resize edit parts of a given type at there best size before exporting diagrams to images or
 * for optimizing the diagram's page.
 * 
 * @author vhemery
 */
public abstract class OptimizedResizer
{
    /**
     * Get the optimized dimension which this part should be resized to.<br/>
     * Subclasses must implement this method, taking in account necessary extra margins.
     * 
     * @param partToResize part to resize (supposed to be of the type "resizedPart" in the extension).
     * @return the optimized dimension to use for this edit part
     */
    public abstract Dimension getOptimizedDimension(GraphicalEditPart partToResize);

    /**
     * Get command to resize an edit part to the most optimized dimension.<br/>
     * This method is not intended to be overridden. If you do so, return the call to super.
     * 
     * @param partToResize part to resize (supposed to be of the type "resizedPart" in the extension).
     * @param stack
     */
    public void resize(GraphicalEditPart partToResize, CommandStack stack)
    {
        Dimension currentDim = partToResize.getFigure().getBounds().getSize();
        Dimension dim = getOptimizedDimension(partToResize);
        if (dim != null && providesMaxDimension())
        {
            dim.intersect(currentDim);
        }
        else if (dim != null)
        {
            dim.union(currentDim);
        }
        if (dim != null && !dim.equals(currentDim))
        {
            if (partToResize.getModel() instanceof GraphNode)
            {
                // Create the command to change the property of the view
                SetSizeCommand cmd = new SetSizeCommand((GraphNode) partToResize.getModel(), dim);
                stack.execute(cmd);
                partToResize.getFigure().getBounds().setSize(dim);
            }
        }
    }

    /**
     * Get whether the dimension provided by this resizer is a maximum dimension or a minimum dimension.<br/>
     * You may override this method if you want to provide a minimum dimension instead.
     * 
     * @return true if the final dimension must be smaller than the computed dimension, false if it must be bigger
     */
    protected boolean providesMaxDimension()
    {
        return true;
    }

    /**
     * A command to update the node's size
     * 
     * @author vhemery
     */
    public class SetSizeCommand extends Command
    {
        /** new size of node */
        private Dimension newSize;

        /** node to resize */
        private GraphNode node;

        /** old size of node */
        private Dimension oldSize;

        /**
         * Construct a command to update a node's size
         * 
         * @param graphNode the node to update the size
         * @param dim new dimension
         */
        public SetSizeCommand(GraphNode graphNode, Dimension dim)
        {
            node = graphNode;
            oldSize = graphNode.getSize();
            newSize = dim;
        }

        /**
         * Update the size
         */
        @Override
        public void redo()
        {
            node.setSize(newSize);
        }

        /***
         * Reset the size
         */
        @Override
        public void undo()
        {
            node.setSize(oldSize);
        }

        /**
         * Update the size
         */
        @Override
        public void execute()
        {
            redo();
        }

        /**
         * Check if size can be updated.
         * 
         * @see org.eclipse.gef.commands.Command#canExecute()
         */
        public boolean canExecute()
        {
            return node != null && newSize != null;
        }
    }
}
