/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.utils.Utils;

/**
 * TODO Comment this method
 *
 * @Created 23 janv. 07
 *
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 *
 */
public abstract class ReconnectSourceToTargetCommand extends ReconnectNodeToNodeCommand
{

    /**
     * @param domain
     * @param connection
     * @param featureName
     * @param direction
     */
    public ReconnectSourceToTargetCommand(ConnectionEditPart connection, String featureName, int direction)
    {
        super(connection, featureName, direction);
    }
    
    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#updateConnectors(org.topcased.modeler.di.model.GraphConnector, org.topcased.modeler.di.model.GraphConnector, org.topcased.modeler.di.model.GraphConnector)
     */
    protected void updateConnectors(GraphConnector newConnector, GraphConnector oldConnector, GraphConnector attachedConnector)
    {
        if (getReconnectionEndType() == TARGET)
        {
            oldConnector.getGraphEdge().remove(getEdge());
            newConnector.getGraphEdge().add(getEdge());
        }
        else if (getReconnectionEndType() == SOURCE)
        {
            GraphEdge edge = getEdge();
            
            oldConnector.getGraphEdge().remove(edge);
            attachedConnector.getGraphEdge().remove(edge);
            edge.getAnchor().clear();
            newConnector.getGraphEdge().add(edge);
            attachedConnector.getGraphEdge().add(edge);
        }
    }
    
    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#redoModel()
     */
    protected void redoModel()
    {
        EObject toUpdate = getFixedEnd();
        EObject newReference = Utils.getElement(getNewElement());
        EObject oldReference = Utils.getElement(getOldElement());
        if (getReconnectionEndType() == TARGET)
        {
            doDirectReference(toUpdate, newReference, oldReference);
        }
        else if (getReconnectionEndType() == SOURCE)
        {
            doInverseReference(toUpdate, newReference, oldReference);
        }
    }

    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#undoModel()
     */
    protected void undoModel()
    {
        EObject toUpdate = getFixedEnd();
        EObject newReference = Utils.getElement(getNewElement());
        EObject oldReference = Utils.getElement(getOldElement());
        if (getReconnectionEndType() == TARGET)
        {
            undoDirectReference(toUpdate, newReference, oldReference);
        }
        else if (getReconnectionEndType() == SOURCE)
        {
            undoInverseReference(toUpdate, newReference, oldReference);
        }
    }
}
