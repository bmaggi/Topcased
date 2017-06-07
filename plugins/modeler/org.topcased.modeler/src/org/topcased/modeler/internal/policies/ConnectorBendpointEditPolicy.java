/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.policies;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.internal.commands.SetConnectorBendpointsCommand;
import org.topcased.modeler.internal.requests.SetAllBendpointRequest;
import org.topcased.modeler.utils.Utils;

/**
 * This EditPolicy defines the behavior of Bendpoints on a Connection.
 */
/*
 * @canBeSeenBy %partners
 */
public class ConnectorBendpointEditPolicy extends ConnectionBendpointEditPolicy
{

    /**
     * @param lineSegMode
     */
    protected ConnectorBendpointEditPolicy(LineMode lineSegMode)
    {
        super(lineSegMode);
    }

    /**
     * 
     */
    public ConnectorBendpointEditPolicy()
    {
        super(LineMode.OBLIQUE);
    }

    /**
     * Returns the appropriate Command for the request type given. Handles
     * creating, moving and deleting bendpoints. The actual creation of the
     * command is taken care of by subclasses implementing the appropriate
     * methods.
     * 
     * @see #getCreateBendpointCommand(BendpointRequest)
     * @see #getMoveBendpointCommand(BendpointRequest)
     * @see #getDeleteBendpointCommand(BendpointRequest)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_SET_ALL_BENDPOINT.equals(request.getType()))
        {
            return getSetBendpointCommand((SetAllBendpointRequest) request);
        }

        return super.getCommand(request);
    }

    /**
     * Method getBendpointsChangedCommand. This method will return a
     * SetBendpointsCommand with the points retrieved from the user feedback in
     * the figure.
     * 
     * @param request BendpointRequest from the user gesture for moving /
     *            creating a bendpoint
     * @return Command SetBendpointsCommand that contains the point changes for
     *         the connector.
     */
    protected Command getBendpointsChangedCommand(BendpointRequest request)
    {
        if ((getHost().getViewer() instanceof ScrollingGraphicalViewer)
                && (getHost().getViewer().getControl() instanceof FigureCanvas))
        {
            Utils.exposeLocation((FigureCanvas) getHost().getViewer().getControl(), request.getLocation().getCopy());
        }
        Connection connection = getConnection();
        GraphEdge edge = (GraphEdge) request.getSource().getModel();

        return getBendpointsChangedCommand(connection, edge, request.getLocation());
    }

    /**
     * Method getBendpointsChangedCommand Different signature method that allows
     * a command to constructed for changing the bendpoints without requiring
     * the original Request.
     * 
     * @param connection Connection to generate the bendpoints changed command
     *            from
     * @param edge IConnectorView notation element that the command will operate
     *            on.
     * @return Command SetBendpointsCommand that contains the point changes for
     *         the connector.
     */
    protected Command getBendpointsChangedCommand(Connection connection, GraphEdge edge)
    {
        return getBendpointsChangedCommand(connection, edge, null);
    }

    /**
     * Method getBendpointsChangedCommand Different signature method that allows
     * a command to constructed for changing the bendpoints without requiring
     * the original Request.
     * 
     * @param connection Connection to generate the bendpoints changed command
     *            from
     * @param edge IConnectorView notation element that the command will operate
     *            on.
     * @param location Default bendpoint (usually mouse location) used for single segment connections
     * @return Command SetBendpointsCommand that contains the point changes for
     *         the connector.
     */
    protected Command getBendpointsChangedCommand(Connection connection, GraphEdge edge, Point location)
    {
        Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
        getConnection().translateToRelative(ptRef1);

        Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
        getConnection().translateToRelative(ptRef2);
        
        PointList newPoints = connection.getPoints().getCopy();
        newPoints.removePoint(0);
        newPoints.removePoint(newPoints.size() - 1);
        
        // Set a bendpoint to location (usually mouse location) to fix the position of single segment connections
        if(newPoints.size() == 0 && location != null)
        {
        	Point rLocation = location.getCopy();
            getConnection().translateToRelative(rLocation);
            newPoints.addPoint(rLocation);
        }

        SetConnectorBendpointsCommand sbbCommand = new SetConnectorBendpointsCommand();
        sbbCommand.setGraphEdge(edge);
        sbbCommand.setNewPointList(newPoints, ptRef1, ptRef2);

        return sbbCommand;
    }

    /**
     * Method getSetBendpointCommand. This method returns a command that
     * executes the REQ_SET_ALL_BENDPOINT request
     * 
     * @param request SetAllBendpointRequest that stores the points to be set by
     *            the command.
     * @return Command to be executed.
     */
    protected Command getSetBendpointCommand(SetAllBendpointRequest request)
    {
        Connection connection = getConnection();
        PointList newPoints = request.getPoints();
        newPoints.removePoint(0);
        newPoints.removePoint(newPoints.size() - 1);

        SetConnectorBendpointsCommand sbbCommand = new SetConnectorBendpointsCommand();
        sbbCommand.setGraphEdge((GraphEdge) getHost().getModel());

        if (request.getSourceReference() != null && request.getTargetReference() != null)
        {
            sbbCommand.setNewPointList(newPoints, request.getSourceReference(), request.getTargetReference());
        }
        else
        {
            sbbCommand.setNewPointList(newPoints, connection.getSourceAnchor(), connection.getTargetAnchor());
        }

        return sbbCommand;
    }
}
