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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.MoveEdgeObjectOffsetCommand;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.di.model.EdgeObjectOffset;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.handles.EdgeObjectOffsetHandle;
import org.topcased.modeler.edit.requests.MoveEdgeObjectRequest;
import org.topcased.modeler.figures.IEdgeObjectFigure;
import org.topcased.modeler.figures.IEdgeObjectOffsetFigure;

/**
 * An edit policy to select and move
 * {@link org.topcased.modeler.di.model.EdgeObjectOffset} relative to their
 * owning edge. Must be used only with
 * {@link org.topcased.modeler.edit.GraphEdgeEditPart}. <br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class EdgeObjectOffsetEditPolicy extends EdgeObjectEditPolicy
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
        if (figure != null && !figure.isEmpty() && edgeObject.isVisible() && edgeObject instanceof EdgeObjectOffset)
        {
            return new EdgeObjectOffsetHandle((GraphicalEditPart) getHost(), (EdgeObjectOffset) edgeObject,
                    (IEdgeObjectOffsetFigure) figure);
        }
        return null;
    }

    /**
     * Compute the new edge object offset depending on the move delta.
     * 
     * @param moveDelta the move delta
     * @param edgeObject the edge object for the one the offset must be computed
     * @return a new edje object offset
     */
    private Dimension computeNewOffset(Dimension moveDelta, EdgeObjectOffset edgeObject)
    {
        Connection connection = ((GraphEdgeEditPart) getHost()).getConnectionFigure();
        Dimension delta = moveDelta.getCopy();
        connection.translateToRelative(delta);

        Dimension initialOffset = edgeObject.getOffset().getCopy();
        initialOffset.width += delta.width;
        initialOffset.height += delta.height;
        return initialOffset;
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#showSourceFeedback(org.eclipse.gef.Request)
     */
    public void showSourceFeedback(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_EO_OFFSET.equals(request.getType()))
        {
            MoveEdgeObjectRequest moveRequest = (MoveEdgeObjectRequest) request;
            Dimension newOffset = computeNewOffset(moveRequest.getMoveDelta(),
                    (EdgeObjectOffset) moveRequest.getEdgeObject());
            showSourceFeedBack(newOffset, (EdgeObjectOffset) moveRequest.getEdgeObject());
        }
    }

    /**
     * Shows or updates <i>source feedback</i> for the specified new offset and
     * edge object.<br/> Subclass must reimplement this method to customize the
     * feedback.<br/> Default implementation makes the edge object figure
     * follow the mouse.
     * 
     * @param newOffset the new offset
     * @param edgeObject an edge object
     */
    protected void showSourceFeedBack(Dimension newOffset, EdgeObjectOffset edgeObject)
    {
        IEdgeObjectOffsetFigure figure = (IEdgeObjectOffsetFigure) ((GraphEdgeEditPart) getHost()).getEdgeObjectFigure(edgeObject);
        if (figure != null)
        {
            figure.setOffset(newOffset);
        }
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#eraseSourceFeedback(org.eclipse.gef.Request)
     */
    public void eraseSourceFeedback(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_EO_OFFSET.equals(request.getType()))
        {
            MoveEdgeObjectRequest moveRequest = (MoveEdgeObjectRequest) request;
            eraseSourceFeedBack(((EdgeObjectOffset) moveRequest.getEdgeObject()).getOffset(),
                    (EdgeObjectOffset) moveRequest.getEdgeObject());
        }
    }

    /**
     * Erases <i>source feedback</i> based on the given oldOffset and edge
     * object.<br/> Subclass must reimplement this method to customize the
     * feedback.<br/> Default implementation reinitialize the edge object
     * figure with the initial edge object offset.
     * 
     * @param oldOffset the old offset. It is the edge object offset here
     * @param edgeObject an edge object
     */
    protected void eraseSourceFeedBack(Dimension oldOffset, EdgeObjectOffset edgeObject)
    {
        IEdgeObjectOffsetFigure figure = (IEdgeObjectOffsetFigure) ((GraphEdgeEditPart) getHost()).getEdgeObjectFigure(edgeObject);
        if (figure != null)
        {
            figure.setOffset(oldOffset);
        }
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_EO_OFFSET.equals(request.getType()))
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
        EdgeObjectOffset edgeObject = (EdgeObjectOffset) request.getEdgeObject();
        Dimension newOffset = computeNewOffset(request.getMoveDelta(), edgeObject);
        return new MoveEdgeObjectOffsetCommand(edgeObject, newOffset);
    }
}
