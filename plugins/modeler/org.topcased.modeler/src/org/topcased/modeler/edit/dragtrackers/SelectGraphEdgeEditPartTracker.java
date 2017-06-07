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
package org.topcased.modeler.edit.dragtrackers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.gef.ui.internal.l10n.Cursors;
import org.eclipse.swt.graphics.Cursor;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.requests.MoveEdgeObjectRequest;
import org.topcased.modeler.figures.IEdgeObjectFigure;
import org.topcased.modeler.figures.IEdgeObjectOffsetFigure;

/**
 * Specialized <code>SelectEditPartTracker</code> that allows for a request
 * action to be taken on a <code>Connection</code> shapes anywhere along the
 * extent of the line. Depending on whether the user clicks on a bendpoint along
 * a line or on the line itself, this is interpreted as either a
 * <code>RequestConstants.REQ_MOVE_BENDPOINT</code> request or a
 * <code>RequestConstants.REQ_CREATE_BENDPOINT</code> request respectively.<br>
 * It also allows for a request action to be taken on a <code>Connection</code>
 * edge object figures. Depending on whether the user clicks on a edge object
 * figure on a edge object offset figure, this is interpreted as either a
 * <code>ModelerRequestConstatns.REQ_CHANGE_EO_UV</code> request or a
 * <code>ModelerRequestConstants.REQ_CHANGE_EO_OFFSET</code> request
 * respectively.
 * 
 * <br>
 * Creation : 28 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class SelectGraphEdgeEditPartTracker extends SelectEditPartTracker
{
    private Request sourceRequest;

    private int index = -1;

    private String type;

    private boolean bSourceFeedback = false;

    private EdgeObject edgeObject;

    /**
     * Constructor.
     * 
     * @param owner
     */
    public SelectGraphEdgeEditPartTracker(GraphEdgeEditPart owner)
    {
        super(owner);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#handleButtonDown(int)
     */
    protected boolean handleButtonDown(int button)
    {
        if (!super.handleButtonDown(button))
        {
            return false;
        }

        Point p = getLocation();
        getConnection().translateToRelative(p);

        // Look first if the button down event has been performed on an edge
        // object
        boolean contained = false;
        IFigure child = null;
        Iterator it = getConnection().getChildren().iterator();
        while (it.hasNext() && !contained)
        {
            child = (IFigure) it.next();
            contained = contained || child.containsPoint(p);
        }

        if (contained)
        {
            if (child instanceof IEdgeObjectOffsetFigure)
            {
                setType(ModelerRequestConstants.REQ_CHANGE_EO_OFFSET);
            }
            else if (child instanceof IEdgeObjectFigure)
            {
                setType(ModelerRequestConstants.REQ_CHANGE_EO_UV);
            }
            GraphEdgeEditPart editPart = (GraphEdgeEditPart) getSourceEditPart();
            for (Iterator<EdgeObject> it2 = editPart.getEdgeObjects().iterator(); it2.hasNext();)
            {
                EdgeObject eObject = (EdgeObject) it2.next();
                if (editPart.getEdgeObjectFigure(eObject) == child)
                {
                    setEdgeObject(eObject);
                }
            }
        }
        // The button down event has been performed on the connection itself
        else
        {
            PointList points = getConnection().getPoints();
            Dimension size = new Dimension(7, 7);
            for (int i = 1; i < points.size() - 1; i++)
            {
                Point ptCenter = points.getPoint(i);
                Rectangle rect = new Rectangle(ptCenter.x - size.width / 2, ptCenter.y - size.height / 2, size.width,
                        size.height);

                if (rect.contains(p))
                {
                    setType(RequestConstants.REQ_MOVE_BENDPOINT);
                    setIndex(i);
                }
            }

            if (getIndex() == -1)
            {
                setIndex(PointListUtilities.findNearestLineSegIndexOfPoint(getConnection().getPoints(), new Point(p.x,
                        p.y)));

                setIndex(getIndex() - 1);
                setType(RequestConstants.REQ_CREATE_BENDPOINT);
            }
        }

        return true;
    }

    /**
     * Determines if the the connector should be dragged or not.
     * 
     * @return <code>boolean</code> <code>true</code> if dragging can occur,
     *         <code>false</code> otherwise.
     */
    protected boolean shouldAllowDrag()
    {
        return (getIndex() != -1) || (getEdgeObject() != null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#handleButtonUp(int)
     */
    protected boolean handleButtonUp(int button)
    {
        boolean bExecuteDrag = isInState(STATE_DRAG_IN_PROGRESS) && shouldAllowDrag();

        boolean bRet = super.handleButtonUp(button);

        if (bExecuteDrag)
        {
            eraseSourceFeedback();
            setCurrentCommand(getCommand());
            executeCurrentCommand();
        }

        return bRet;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#handleDragInProgress()
     */
    protected boolean handleDragInProgress()
    {
        if (isInState(STATE_DRAG_IN_PROGRESS) && shouldAllowDrag())
        {
            updateSourceRequest();
            showSourceFeedback();
            setCurrentCommand(getCommand());
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#handleDragStarted()
     */
    protected boolean handleDragStarted()
    {
        return stateTransition(STATE_DRAG, STATE_DRAG_IN_PROGRESS);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#calculateCursor()
     */
    protected Cursor calculateCursor()
    {
        if (getType() == RequestConstants.REQ_MOVE_BENDPOINT)
        {
            return Cursors.CURSOR_SEG_MOVE;
        }

        return getConnection().getCursor();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.Tool#deactivate()
     */
    public void deactivate()
    {
        if (!isInState(STATE_TERMINAL))
        {
            eraseSourceFeedback();
        }
        sourceRequest = null;
        super.deactivate();
    }

    /**
     * @return boolean true if feedback is being displayed, false otherwise.
     */
    private boolean isShowingFeedback()
    {
        return bSourceFeedback;
    }

    /**
     * Method setShowingFeedback.
     * 
     * @param bSet boolean to set the feedback flag on or off.
     */
    private void setShowingFeedback(boolean bSet)
    {
        bSourceFeedback = bSet;
    }

    /**
     * Method showSourceFeedback. Show the source drag feedback for the drag
     * occurring within the viewer.
     */
    private void showSourceFeedback()
    {
        List editParts = getOperationSet();
        for (int i = 0; i < editParts.size(); i++)
        {
            EditPart editPart = (EditPart) editParts.get(i);
            editPart.showSourceFeedback(getSourceRequest());
        }
        setShowingFeedback(true);
    }

    /**
     * Method eraseSourceFeedback. Show the source drag feedback for the drag
     * occurring within the viewer.
     */
    private void eraseSourceFeedback()
    {
        if (!isShowingFeedback())
        {
            return;
        }
        setShowingFeedback(false);
        List editParts = getOperationSet();

        for (int i = 0; i < editParts.size(); i++)
        {
            EditPart editPart = (EditPart) editParts.get(i);
            editPart.eraseSourceFeedback(getSourceRequest());
        }
    }

    /**
     * Method getSourceRequest.
     * 
     * @return Request
     */
    private Request getSourceRequest()
    {
        if (sourceRequest == null)
        {
            sourceRequest = createSourceRequest();
        }
        return sourceRequest;
    }

    /**
     * Determines the type of request that will be created for the drag
     * operation.
     * 
     * @return Object
     */
    protected Object getType()
    {
        return type;
    }

    /**
     * Sets the type of request that will be created for the drag operation.
     * 
     * @param type the <code>String</code> that represents the type of
     *            request.
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Creates the source request that is activated when the drag operation
     * occurs.
     * 
     * @return a <code>Request</code> that is the newly created source request
     */
    protected Request createSourceRequest()
    {
        if (getType() == ModelerRequestConstants.REQ_CHANGE_EO_OFFSET
                || getType() == ModelerRequestConstants.REQ_CHANGE_EO_UV)
        {
            MoveEdgeObjectRequest request = new MoveEdgeObjectRequest();
            request.setEdgeObject(getEdgeObject());
            request.setType(getType());

            return request;
        }
        else
        {
            BendpointRequest request = new BendpointRequest();
            request.setType(getType());
            request.setIndex(getIndex());
            request.setSource((ConnectionEditPart) getSourceEditPart());
            return request;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#getCommand()
     */
    protected Command getCommand()
    {
        return getSourceEditPart().getCommand(getSourceRequest());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#getCommandName()
     */
    protected String getCommandName()
    {
        return getType().toString();
    }

    /**
     * @return the <code>Connection</code> that is referenced by the
     *         connection edit part.
     */
    private Connection getConnection()
    {
        return (Connection) getConnectionEditPart().getFigure();
    }

    /**
     * Method getConnectionEditPart.
     * 
     * @return ConnectionEditPart
     */
    private ConnectionEditPart getConnectionEditPart()
    {
        return (ConnectionEditPart) getSourceEditPart();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.tools.AbstractTool#getDebugName()
     */
    protected String getDebugName()
    {
        return "Bendpoint Handle Tracker " + getCommandName(); //$NON-NLS-1$
    }

    /**
     * Gets the current line segment index that the user clicked on to activate
     * the drag tracker.
     * 
     * @return int
     */
    protected int getIndex()
    {
        return index;
    }

    /**
     * Method setIndex. Sets the current line segment index based on the
     * location the user clicked on the connection.
     * 
     * @param i int representing the line segment index in the connection.
     */
    public void setIndex(int i)
    {
        index = i;
    }

    /**
     * Updates the source request to reflect the current location.
     */
    protected void updateSourceRequest()
    {
        Request request = getSourceRequest();
        if (request instanceof LocationRequest)
        {
            ((LocationRequest) request).setLocation(getLocation());
        }
        if (request instanceof MoveEdgeObjectRequest)
        {
            Dimension delta = getDragMoveDelta();
            ((MoveEdgeObjectRequest) request).setMoveDelta(delta);
        }
    }

    public void setEdgeObject(EdgeObject edgeObject)
    {
        this.edgeObject = edgeObject;
    }

    public EdgeObject getEdgeObject()
    {
        return edgeObject;
    }
}
