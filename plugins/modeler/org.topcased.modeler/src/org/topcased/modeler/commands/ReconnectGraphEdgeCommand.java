/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.topcased.modeler.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.l10n.Messages;

/**
 * Reconnects graphically a GraphEdge
 * 
 * @Created 15 janv. 07
 * 
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 * 
 */
public abstract class ReconnectGraphEdgeCommand extends Command
{
    /** The connection that the user creates */
    private GraphEdge edge;

    /** The old connector where the edge was attached */
    private GraphConnector oldConnector;

    /** The new connector where the edge is going to be attached */
    private GraphConnector newConnector;

    /** The non modified connector */
    private GraphConnector attachedConnector;

    /** The old GraphElement */
    private GraphElement oldGraphElement;

    /** The new GraphElement */
    private GraphElement newGraphElement;

    /** Flag indicating if the model needs to be updated */
    private boolean updateModel = true;

    /**
     * Constructor. Call the super constructor with : - the container for the edge = the container of the source node -
     * the features list = null. Model will be updated on each graphic reconnection
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObj the edge to create
     * @param old the source node
     */
    public ReconnectGraphEdgeCommand(ConnectionEditPart connection)
    {
        this(connection, true);
    }

    /**
     * Constructor
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObj the edge to create
     * @param oldElement the source node
     * @param featuresList to be define
     * @param needModelUpdate <code>true</code> if the model must be modified during this command, <code>false</code> if
     *        objects already exist in the mode.
     */
    public ReconnectGraphEdgeCommand(ConnectionEditPart connection, boolean needModelUpdate)
    {
        super(Messages.getString("ReconnectGraphEdgeCommand.CmdLabel")); //$NON-NLS-1$
        edge = (GraphEdge) connection.getModel();
        initializeConnectors(connection);
        updateModel = needModelUpdate;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return oldConnector != null && newConnector != null && edge != null;
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
        updateConnectors(newConnector, oldConnector, attachedConnector);

        if (updateModel)
        {
            redoModel();
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        updateConnectors(oldConnector, newConnector, attachedConnector);

        if (updateModel)
        {
            undoModel();
        }
    }

    /**
     * Get the GraphEdge
     * 
     * @return GraphEdge
     */
    public GraphEdge getEdge()
    {
        return edge;
    }

    /**
     * Get the source GraphNode
     * 
     * @return GraphElement
     */
    public GraphElement getOldElement()
    {
        return oldGraphElement;
    }

    /**
     * Get the target GraphNode
     * 
     * @return GraphElement
     */
    public GraphElement getNewElement()
    {
        return newGraphElement;
    }

    /**
     * Set the target node
     * 
     * @param newElement the target node
     */
    public void setNewElement(GraphElement newElement)
    {
        newGraphElement = newElement;
        List<GraphConnector> connectors = newElement.getAnchorage();
        if (connectors.isEmpty())
        {
            newConnector = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
            connectors.add(newConnector);
        }
        else
        {
            Iterator<GraphConnector> it = connectors.iterator();
            GraphConnector connector = it.next();
            if (attachedConnector != connector)
            {
                newConnector = connector;
            }
            else if (it.hasNext())
            {
                newConnector = it.next();
            }
            else
            {
                newConnector = DiagramInterchangeFactory.eINSTANCE.createGraphConnector();
                connectors.add(newConnector);
            }
        }
    }

    /**
     * Initializes the connectors before reconnection.
     * 
     * @param connection
     */
    protected void initializeConnectors(ConnectionEditPart connection)
    {
        oldGraphElement = getOldGraphElement(connection);
        if (oldGraphElement == null)
        {
            return;
        }
        List<GraphConnector> anchors = getEdge().getAnchor();
        List<GraphConnector> connectors = oldGraphElement.getAnchorage();
        Iterator<GraphConnector> it = connectors.iterator();
        while (it.hasNext())
        {
            Object connector = it.next();
            Object srcAnchor = anchors.get(0);
            Object tgtAnchor = anchors.get(1);

            if (connector == srcAnchor)
            {
                oldConnector = (GraphConnector) srcAnchor;
                attachedConnector = (GraphConnector) tgtAnchor;
            }
            else if (connector == anchors.get(1))
            {
                oldConnector = (GraphConnector) tgtAnchor;
                attachedConnector = (GraphConnector) srcAnchor;
            }
        }
    }

    /**
     * Update the model after at the end of the redo() method. This method should be overriden by subclasses.
     */
    protected abstract void redoModel();

    /**
     * Update the model at the end of the undo() method. This method should be overriden by subclasses.
     */
    protected abstract void undoModel();

    /**
     * @return Returns the current end element of the given edge
     */
    protected abstract GraphElement getOldGraphElement(ConnectionEditPart connection);

    /**
     * Updates anchors and edges within these connectors. Subclasses may remove and add elements depending usage
     * 
     * @param newConnector The connectors of the new element
     * @param oldConnector The connectors of the old element
     */
    protected abstract void updateConnectors(GraphConnector newConnector, GraphConnector oldConnector, GraphConnector attachedConnector);
}
