/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.edit.policies;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.MoveEdgeObjectUVCommand;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.di.model.EdgeObjectUV;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.handles.EdgeObjectUVHandle;
import org.topcased.modeler.edit.requests.MoveEdgeObjectRequest;
import org.topcased.modeler.figures.IEdgeObjectFigure;
import org.topcased.modeler.figures.IGraphEdgeFigure;

/**
 * An abstract edit policy to select and move
 * {@link org.topcased.modeler.di.model.EdgeObjectUV} relative to their owning
 * edge. Must be used only with
 * {@link org.topcased.modeler.edit.GraphEdgeEditPart}. <br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public abstract class EdgeObjectUVEditPolicy extends EdgeObjectEditPolicy
{
    /**
     * Create a selection handle for the given edge object.
     * 
     * @param edgeObject the edge object for the one the selection handle has to
     *            be created
     * @return an handle or <code>null</code> if the given edge object must
     *         not have selection handle
     */
    protected Handle createSelectionHandle(EdgeObject edgeObject)
    {
        IEdgeObjectFigure figure = ((GraphEdgeEditPart) getHost()).getEdgeObjectFigure(edgeObject);
        if (figure != null && (!figure.isEmpty() || (figure.isEmpty() && figure.isEditable()))
                && edgeObject.isVisible() && edgeObject instanceof EdgeObjectUV)
        {
            return new EdgeObjectUVHandle((GraphicalEditPart) getHost(), (EdgeObjectUV) edgeObject, figure);
        }
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#showSourceFeedback(org.eclipse.gef.Request)
     */
    public void showSourceFeedback(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_EO_UV.equals(request.getType()))
        {
            MoveEdgeObjectRequest moveRequest = (MoveEdgeObjectRequest) request;
            int[] uv = computeUVDistance(moveRequest.getMoveDelta(), (EdgeObjectUV) moveRequest.getEdgeObject(),
                    moveRequest.getLocation());
            showSourceFeedBack(uv[0], uv[1], (EdgeObjectUV) moveRequest.getEdgeObject());
        }
    }

    /**
     * Shows or updates <i>source feedback</i> for the specified new uDistance,
     * vDistance and edge object.<br/> Subclass must reimplement this method to
     * customize the feedback.<br/> Default implementation makes the edge
     * object figure follow the mouse.
     * 
     * @param uDistance a new uDistance
     * @param vDistance a new vDistance
     * @param edgeObject an edge object
     */
    protected void showSourceFeedBack(int newUDistance, int newVDistance, EdgeObjectUV edgeObject)
    {
        GraphEdgeEditPart editPart = (GraphEdgeEditPart) getHost();
        IEdgeObjectFigure figure = editPart.getEdgeObjectFigure(edgeObject);
        Locator locator = ((IGraphEdgeFigure) editPart.getConnectionFigure()).getLocator(figure);
        if (locator instanceof ConnectionEndpointLocator)
        {
            ConnectionEndpointLocator cep = (ConnectionEndpointLocator) locator;
            cep.setUDistance(newUDistance);
            cep.setVDistance(newVDistance);
            figure.revalidate();
        }
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#eraseSourceFeedback(org.eclipse.gef.Request)
     */
    public void eraseSourceFeedback(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_EO_UV.equals(request.getType()))
        {
            MoveEdgeObjectRequest moveRequest = (MoveEdgeObjectRequest) request;
            EdgeObjectUV uv = (EdgeObjectUV) moveRequest.getEdgeObject();
            eraseSourceFeedBack(uv.getUDistance(), uv.getVDistance(), (EdgeObjectUV) moveRequest.getEdgeObject());
        }
    }

    /**
     * Erases <i>source feedback</i> based on the given oldUDistance,
     * oldVDistance and edge object.<br/> Subclass must reimplement this method
     * to customize the feedback.<br/> Default implementation reinitialize the
     * edge object figure with the initial edge object uDistance and vDistance.
     * 
     * @param uDistance the old uDistance. It is the edge object uDistance here
     * @param edgeObject an edge object
     */
    protected void eraseSourceFeedBack(int oldUDistance, int oldVDistance, EdgeObjectUV edgeObject)
    {
        GraphEdgeEditPart editPart = (GraphEdgeEditPart) getHost();
        IEdgeObjectFigure figure = editPart.getEdgeObjectFigure(edgeObject);
        Locator locator = ((IGraphEdgeFigure) editPart.getConnectionFigure()).getLocator(figure);
        if (locator instanceof ConnectionEndpointLocator)
        {
            ConnectionEndpointLocator cep = (ConnectionEndpointLocator) locator;
            cep.setUDistance(oldUDistance);
            cep.setVDistance(oldVDistance);
            figure.revalidate();
        }
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_EO_UV.equals(request.getType()))
        {
            MoveEdgeObjectRequest moveRequest = (MoveEdgeObjectRequest) request;
            return getMoveEdgeObjectCommand(moveRequest);
        }

        return null;
    }

    /**
     * Gets the command to move an edge object.
     * 
     * @param request the move edge object request
     * @return a comand to move an edge object
     */
    protected Command getMoveEdgeObjectCommand(MoveEdgeObjectRequest request)
    {
        EdgeObjectUV edgeObject = (EdgeObjectUV) request.getEdgeObject();
        int[] uv = computeUVDistance(request.getMoveDelta(), edgeObject, request.getLocation());
        return new MoveEdgeObjectUVCommand(edgeObject, uv[0], uv[1]);
    }

    /**
     * Transposes the location if the connection point is along the top or
     * bottom of its owner figure.
     */
    private Transposer transposer = new Transposer();

    /**
     * Returns <code>true</code> if the given edge ovject uv figure is located
     * at the end of the connection or <code>false</code> if it is located at
     * the start.
     * 
     * @return
     */
    protected abstract boolean isEnd(IEdgeObjectFigure figure);

    /**
     * Compute a new uDistance and vDistance depending on the move delta and the
     * edge object figure.
     * 
     * @param moveDelta the current move delta
     * @param edgeObject an edge object
     * @param mouseLocation the mouse location
     * @return an int array containing the uDistance and the vDistance
     */
    protected int[] computeUVDistance(Dimension moveDelta, EdgeObjectUV edgeObject, Point mouseLocation)
    {
        Connection conn = (Connection) getHostFigure();
        IEdgeObjectFigure figure = ((GraphEdgeEditPart) getHost()).getEdgeObjectFigure(edgeObject);
        Point mousePosition = mouseLocation.getCopy();
        conn.translateToRelative(mousePosition);
        conn.translateFromParent(mousePosition);

        Dimension delta = moveDelta.getCopy();
        conn.translateToRelative(delta);
        conn.translateFromParent(delta);

        Point startPoint = Point.SINGLETON;
        Point endPoint = new Point();

        int startPointPosition = 0;
        int endPointPosition = 1;
        if (isEnd(figure))
        {
            startPointPosition = conn.getPoints().size() - 1;
            endPointPosition = startPointPosition - 1;
        }

        conn.getPoints().getPoint(startPoint, startPointPosition);
        conn.getPoints().getPoint(endPoint, endPointPosition);

        IFigure connOwner = getConnectionOwner(figure);

        int quadrant;
        if (connOwner != null)
        {
            Rectangle connOwnerBounds = connOwner.getBounds();
            Point connOwnerCenter = connOwnerBounds.getCenter();
            Point connOwnerTL = connOwnerBounds.getTopLeft();
            quadrant = calculateConnectionLocation(startPoint, connOwnerTL, connOwnerCenter);
        }
        else
        {
            quadrant = calculateConnectionLocation(startPoint, endPoint);
        }

        int cos = 1;
        transposer.setEnabled(false);

        /*
         * Label placement calculations are done as if the connection point is
         * along the left or right side of the figure. If the connection point
         * is along the top or bottom, values are transposed.
         */
        if (quadrant == 1 || quadrant == 3)
        {
            transposer.setEnabled(true);
        }

        if (quadrant == 3 || quadrant == 4)
        {
            cos = -1;
        }

        Dimension figureSize = transposer.t(figure.getPreferredSize());
        startPoint = transposer.t(startPoint);
        endPoint = transposer.t(endPoint);
        delta = transposer.t(delta);
        mousePosition = transposer.t(mousePosition);
        double tan = calculateTan(startPoint, endPoint);

        Point initialLocation = getLocation(edgeObject.getUDistance(), edgeObject.getVDistance(), startPoint,
                figureSize, cos, tan);
        Point location = new Point(initialLocation.x + delta.width, initialLocation.y + delta.height);

        int[] uvDistance = getUVDistance(location, startPoint, figureSize, cos, tan);
        int uDistance = uvDistance[0];
        int vDistance = uvDistance[1];

        int[] mouseUVDistance = getUVDistance(mousePosition, startPoint, new Dimension(0, 0), cos, tan);
        int mouseV = mouseUVDistance[1];

        if ((mouseV >= 0 && vDistance <= 0) || (mouseV <= 0 && vDistance >= 0))
        {
            vDistance = 0;
        }
        else if ((mouseV > 0 && edgeObject.getVDistance() < 0) || (mouseV < 0 && edgeObject.getVDistance() > 0))
        {
            int sign = edgeObject.getVDistance() > 0 ? 1 : -1;
            location.y += figureSize.height * sign;
            uvDistance = getUVDistance(location, startPoint, figureSize, cos, tan);
            vDistance = uvDistance[1];
            if ((mouseV >= 0 && vDistance <= 0) || (mouseV <= 0 && vDistance >= 0))
            {
                vDistance = 0;
            }
        }
        else if (edgeObject.getVDistance() == 0)
        {
            if (Math.abs(delta.height) < figureSize.height / 2)
            {
                vDistance = 0;
            }
            else
            {
                int sign = vDistance < 0 ? 1 : -1;
                location.y += figureSize.height / 2 * sign;
                uvDistance = getUVDistance(location, startPoint, figureSize, cos, tan);
                vDistance = uvDistance[1];
            }
        }

        return new int[] {uDistance, vDistance};
    }

    private int[] getUVDistance(Point point, Point startPoint, Dimension figureSize, int cos, double tan)
    {
        int uDistance = (point.x - startPoint.x - (figureSize.width * (cos - 1) / 2)) / cos;
        int vDistance = (int) (point.y - startPoint.y - (cos * uDistance * tan));

        return new int[] {uDistance, vDistance};
    }

    private Point getLocation(int uDistance, int vDistance, Point startPoint, Dimension figureSize, int cos, double tan)
    {
        int x = (cos * uDistance) + startPoint.x + (figureSize.width * (cos - 1) / 2);
        int y = (int) (vDistance + startPoint.y + (cos * uDistance * tan));
        return new Point(x, y);
    }

    /*
     * Returns an integer representing the side of the passed Rectangle that a
     * point lies on. 1 == Top 2 == Right 3 == Bottom 4 == Left
     * 
     * @param loc The point that is to be located
     */
    private int calculateConnectionLocation(Point loc, Point topLeft, Point center)
    {
        double m1;
        double m2 = 0;
        m1 = (double) (topLeft.y - center.y) / (double) (topLeft.x - center.x);

        if (loc.x - center.x != 0)
        {
            m2 = (double) (loc.y - center.y) / (double) (loc.x - center.x);
        }

        if (loc.x == center.x)
        {
            // Case where m2 is vertical
            if (loc.y < center.y)
            {
                return 3;
            }
            else
            {
                return 1;
            }
        }
        else if (Math.abs(m2) <= Math.abs(m1))
        {
            // Connection start point along left or right side
            if (loc.x < center.x)
            {
                return 4;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            // Connection start point along top or bottom
            if (loc.y < center.y)
            {
                return 3;
            }
            else
            {
                return 1;
            }
        }
    }

    /*
     * This method is used to calculate the "quadrant" value of a connection
     * that does not have an owner on its starting point.
     * 
     * 1 == Top 2 == Right 3 == Bottom 4 == Left
     * 
     * @param startPoint The starting point of the connection. @param endPoint
     * The end point of the connection.
     */
    private int calculateConnectionLocation(Point startPoint, Point endPoint)
    {
        if (Math.abs(endPoint.x - startPoint.x) > Math.abs(endPoint.y - startPoint.y))
        {
            if (endPoint.x > startPoint.x)
            {
                return 2;
            }
            else
            {
                return 4;
            }
        }
        else
        {
            if (endPoint.y > startPoint.y)
            {
                return 1;
            }
            else
            {
                return 3;
            }
        }
    }

    /*
     * Calculates 'tan' which is used as a factor for y adjustment when placing
     * the connection label. 'tan' is capped at 1.0 in the positive direction
     * and -1.0 in the negative direction.
     * 
     * @param startPoint The starting point of the connection. @param endPoint
     * The end point of the connection.
     * 
     * @since 2.0
     */
    private double calculateTan(Point startPoint, Point endPoint)
    {
        double tan = 0;
        if (endPoint.x == startPoint.x)
        {
            tan = 1.0;
        }
        else
        {
            tan = (double) (endPoint.y - startPoint.y) / (double) (endPoint.x - startPoint.x);
        }
        if (tan > 1)
        {
            tan = 1.0;
        }
        else if (tan < -1)
        {
            tan = -1.0;
        }

        return tan;
    }

    private IFigure getConnectionOwner(IEdgeObjectFigure figure)
    {
        IFigure connOwner;
        if (isEnd(figure))
        {
            connOwner = figure.getConnection().getTargetAnchor().getOwner();
        }
        else
        {
            connOwner = figure.getConnection().getSourceAnchor().getOwner();
        }

        return connOwner;
    }
}
