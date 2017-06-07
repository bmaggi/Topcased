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
package org.topcased.modeler.edit.handles;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.SimpleDragTracker;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.edit.requests.MoveEdgeObjectRequest;

/**
 * An abstract drag tracker for {@link org.topcased.modeler.di.model.EdgeObject}.<br>
 * To define the type of the created move request, subclass must implement the
 * method <code>getCommandName()</code>.<br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public abstract class EdgeObjectDragTracker extends SimpleDragTracker
{
    private GraphicalEditPart editPart;

    private EdgeObject edgeObject;

    public EdgeObjectDragTracker(GraphicalEditPart editPart, EdgeObject edgeObject)
    {
        this.editPart = editPart;
        this.edgeObject = edgeObject;
        setDefaultCursor(Cursors.HAND);
    }

    /**
     * @see org.eclipse.gef.tools.SimpleDragTracker#createSourceRequest()
     */
    protected Request createSourceRequest()
    {
        MoveEdgeObjectRequest request = new MoveEdgeObjectRequest();
        request.setEdgeObject(edgeObject);
        return request;
    }

    /**
     * @see org.eclipse.gef.tools.SimpleDragTracker#updateSourceRequest()
     */
    protected void updateSourceRequest()
    {
        super.updateSourceRequest();
        Dimension delta = getDragMoveDelta();
        ((MoveEdgeObjectRequest) getSourceRequest()).setMoveDelta(delta);
        ((MoveEdgeObjectRequest) getSourceRequest()).setLocation(getLocation());
    }

    /**
     * @see org.eclipse.gef.tools.AbstractTool#getCommand()
     */
    protected Command getCommand()
    {
        return editPart.getCommand(getSourceRequest());
    }

    /**
     * @see org.eclipse.gef.tools.SimpleDragTracker#handleButtonUp(int)
     */
    protected boolean handleButtonUp(int button)
    {
        if (stateTransition(STATE_DRAG, STATE_TERMINAL))
        {
            DirectEditRequest request = new DirectEditRequest();
            request.setLocation(getLocation());
            editPart.performRequest(request);
            return true;
        }

        return super.handleButtonUp(button);
    }

    /**
     * @see org.eclipse.gef.tools.AbstractTool#handleDoubleClick(int)
     */
    protected boolean handleDoubleClick(int button)
    {
        SelectionRequest request = new SelectionRequest();
        request.setLocation(getLocation());
        request.setType(RequestConstants.REQ_OPEN);
        editPart.performRequest(request);

        return true;
    }
}
