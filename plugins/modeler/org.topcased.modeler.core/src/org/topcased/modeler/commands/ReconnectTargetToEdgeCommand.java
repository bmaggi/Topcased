/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.gef.ConnectionEditPart;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphElement;

/**
 * Command which reconnect the target of a Typed link
 * This class tries to make modifications at a model level
 *
 * @Created 19 janv. 07
 *
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 *
 */
public abstract class ReconnectTargetToEdgeCommand extends ReconnectNodeToEdgeCommand 
{
	/**
	 * @param domain
	 * @param connection
	 */
	public ReconnectTargetToEdgeCommand(ConnectionEditPart connection, String featureName) 
	{
		super(connection, featureName);
	}

	/**
	 * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#getOldGraphElement(org.eclipse.gef.ConnectionEditPart)
	 */
	protected GraphElement getOldGraphElement(ConnectionEditPart connection) 
	{
		return (GraphElement) connection.getTarget().getModel();
	}

	/**
	 * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#updateConnectors(org.topcased.modeler.di.model.GraphConnector, org.topcased.modeler.di.model.GraphConnector, org.topcased.modeler.di.model.GraphConnector)
	 */
	protected void updateConnectors(GraphConnector newConnector, GraphConnector oldConnector, GraphConnector attachedConnector) 
	{
		oldConnector.getGraphEdge().remove(getEdge());
        newConnector.getGraphEdge().add(getEdge());
	}
}
