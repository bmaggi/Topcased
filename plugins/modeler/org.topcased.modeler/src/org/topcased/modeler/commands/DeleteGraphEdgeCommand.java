/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.editor.resource.EditingDomainHelper;

/**
 * The command to delete a connection
 * 
 * @author jako
 */
class DeleteGraphEdgeCommand extends Command
{

    private static final int SOURCE_ANCHOR = 0;

    private static final int TARGET_ANCHOR = 1;

    private GraphEdge deletedEdge;

    private GraphElement source;

    private GraphElement target;

    private GraphElement parent;

    private GraphConnector sourceConnector;

    private GraphConnector targetConnector;

    private boolean sourceremoved;

    private boolean targetremoved;

    /**
     * The Constructor
     */
    public DeleteGraphEdgeCommand()
    {
        super("Delete Edge");
    }

    /**
     * Check if the command can be executed
     * 
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
            EList<GraphConnector> anchors = deletedEdge.getAnchor();
            if (anchors.size() > SOURCE_ANCHOR)
            {
                sourceConnector = (GraphConnector) anchors.get(SOURCE_ANCHOR);
            }
            else
            {
                sourceConnector = null;
            }

            if (anchors.size() > TARGET_ANCHOR)
            {
                targetConnector = (GraphConnector) anchors.get(TARGET_ANCHOR);
            }
            else
            {
                targetConnector = null;
            }

            // remove the connection from the parent element
            parent.getContained().remove(deletedEdge);

            // remove the connection from its different Connectors
            if (targetConnector != null)
            {
                deletedEdge.getAnchor().remove(targetConnector);
                targetremoved = (targetConnector.getGraphEdge().size() == 0);
                if (targetremoved)
                {
                    // the connector is useless : remove it
                    target.getAnchorage().remove(targetConnector);
                }
            }

            if (sourceConnector != null)
            {
                deletedEdge.getAnchor().remove(sourceConnector);
                sourceremoved = (sourceConnector.getGraphEdge().size() == 0);
                if (sourceremoved)
                {
                    // the connector is useless : remove it
                    source.getAnchorage().remove(sourceConnector);
                }
            }

        }
    }

    /**
     * Removes the connection
     * 
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        parent = deletedEdge.getContainer();
        redo();
    }

    /**
     * Restores the connection
     * 
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if (parent != null)
        {
            if (sourceremoved && (sourceConnector != null))
            {
                source.getAnchorage().add(sourceConnector);
            }

            if (targetremoved && (targetConnector != null))
            {
                target.getAnchorage().add(targetConnector);
            }

            if (source == target)
            {
                // Creates anchor if needed
                if (source.getAnchorage().isEmpty())
                {
                    GraphConnector connector1 = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                    source.getAnchorage().add(connector1);
                }
                if (source.getAnchorage().size() < 2)
                {
                    GraphConnector connector2 = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                    source.getAnchorage().add(connector2);
                }
                GraphConnector srcConnector = (GraphConnector) source.getAnchorage().get(SOURCE_ANCHOR);
                GraphConnector tgtConnector = (GraphConnector) source.getAnchorage().get(TARGET_ANCHOR);

                srcConnector.getGraphEdge().add(deletedEdge);
                tgtConnector.getGraphEdge().add(deletedEdge);
            }
            else
            {
                // Creates anchor if needed
                if (source.getAnchorage().isEmpty())
                {
                    GraphConnector connector = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                    source.getAnchorage().add(connector);
                }

                if (target.getAnchorage().isEmpty())
                {
                    GraphConnector connector = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                    target.getAnchorage().add(connector);
                }
                if (deletedEdge.getPosition() == null && sourceConnector != null && targetConnector != null)
                {
                    deletedEdge.getAnchor().add(SOURCE_ANCHOR, sourceConnector);
                    deletedEdge.getAnchor().add(TARGET_ANCHOR, targetConnector);
                }
            }

            // add the edge to the graphical view
            parent.getContained().add(deletedEdge);
        }
    }

    /**
     * Set the edit part that must be deleted
     * 
     * @param model the graph object to be deleted
     * @return the delete command
     */
    public Command setPartToBeDeleted(Object model)
    {
        if (model instanceof GraphEdge)
        {
            deletedEdge = (GraphEdge) model;
            setSource(deletedEdge);
            setTarget(deletedEdge);
            return this;
        }

        return null;
    }

    /**
     * Retrieve the source Node from the given edge
     * 
     * @param edge the GraphEdge concerned by the Command
     */
    private void setSource(GraphEdge edge)
    {
        if (edge.getAnchor().size() > SOURCE_ANCHOR)
        {
            this.source = (GraphElement) ((GraphConnector) edge.getAnchor().get(SOURCE_ANCHOR)).eContainer();
        }
    }

    /**
     * Retrieve the target Node from the given edge
     * 
     * @param edge the GraphEdge concerned by the Command
     */
    private void setTarget(GraphEdge edge)
    {
        if (edge.getAnchor().size() == 1)
        {
            // the target Node is the same as source Node
            this.target = (GraphElement) ((GraphConnector) edge.getAnchor().get(SOURCE_ANCHOR)).eContainer();
        }
        else if (edge.getAnchor().size() > TARGET_ANCHOR)
        {
            this.target = (GraphElement) ((GraphConnector) edge.getAnchor().get(TARGET_ANCHOR)).eContainer();
        }

    }
}
