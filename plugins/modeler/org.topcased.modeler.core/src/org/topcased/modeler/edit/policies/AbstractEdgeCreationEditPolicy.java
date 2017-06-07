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
package org.topcased.modeler.edit.policies;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.topcased.modeler.commands.CreateTypedEdgeCommand;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.utils.SourceTargetData;

/**
 * <br>
 * creation : 15 juin 2005 Edge creation policy template
 * 
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu Garcia</a>
 */
public abstract class AbstractEdgeCreationEditPolicy extends NodeEditPolicy
{

    /**
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
     */
    protected Command getConnectionCreateCommand(CreateConnectionRequest request)
    {
        Object newObject = request.getNewObject();
        if (newObject instanceof GraphEdge)
        {
            GraphEdge edge = (GraphEdge) newObject;
            GraphElement sourceElt = (GraphElement) getHost().getModel();
            if (edge != null && sourceElt != null && checkEdge(edge) && checkSource(sourceElt))
            {
                CreateTypedEdgeCommand command = createCommand(getHost().getViewer().getEditDomain(), edge, sourceElt);
                request.setStartCommand(command);
                return command;
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
     */
    protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
    {
        if (checkCommand(request.getStartCommand()))
        {
            GraphElement targetNode = (GraphElement) getHost().getModel();
            GraphElement sourceNode = (GraphElement) request.getSourceEditPart().getModel();
            if (targetNode != null && sourceNode != null && checkTargetForSource(sourceNode, targetNode))
            {
                CreateTypedEdgeCommand command = (CreateTypedEdgeCommand) request.getStartCommand();
                if (command != null)
                {
                    command.setTarget(targetNode);
                    command.setSourceTargetData(getSourceTargetData(sourceNode, targetNode));
                    return command;
                }
            }
        }
        return null;
    }

    /**
     * Avoid duplicate feedbacks when several edge policies are available
     * 
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#showCreationFeedback(org.eclipse.gef.requests.CreateConnectionRequest)
     */
    protected void showCreationFeedback(CreateConnectionRequest request)
    {
        Object newObject = request.getNewObject();
        if (newObject != null && newObject instanceof GraphEdge && checkEdge((GraphEdge) newObject))
        {
            super.showCreationFeedback(request);
        }
    }
    
    /**
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
     */
    protected Command getReconnectTargetCommand(ReconnectRequest request)
    {
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
     */
    protected Command getReconnectSourceCommand(ReconnectRequest request)
    {
        return null;
    }

    /**
     * Get new edge creation command
     * 
     * @param domain the current edit domain
     * @param edge the current edge
     * @param source the graphElement source
     * @return a typed command for create an edge
     */
    protected abstract CreateTypedEdgeCommand createCommand(EditDomain domain, GraphEdge edge, GraphElement source);

    /**
     * Check that current edge is complient with the model object that is
     * represented here
     * 
     * @param edge the current edge
     * @return true if the edge is complient
     */
    protected abstract boolean checkEdge(GraphEdge edge);

    /**
     * Check that source object supports the current edge
     * 
     * @param source the graphnode source
     * @return true if the source supports the current edge
     */
    protected abstract boolean checkSource(GraphElement source);

    /**
     * Check that source and target are available for this type of edge
     * 
     * @param source the graphnode source
     * @param target the graphnode target
     * @return true if the "source target" couple is available for this edge
     */
    protected abstract boolean checkTargetForSource(GraphElement source, GraphElement target);

    /**
     * Check that the given command type is correct
     * 
     * @param command the command
     * @return true if command is ok
     */
    protected abstract boolean checkCommand(Command command);

    /**
     * Build a SourceTargetData structure for a given source and a given target
     * 
     * @param source the graphnode source
     * @param target the graphnode target
     * @return a new structure that stores data about the "source target" couple
     */
    protected abstract SourceTargetData getSourceTargetData(GraphElement source, GraphElement target);

}
