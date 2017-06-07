/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.edit.GraphNodeEditPart;
import org.topcased.modeler.requests.AutoResizeRequest;

/**
 * This EditPolicy overrides the behavior of the
 * {@link org.eclipse.gef.editpolicies.ResizableEditPolicy} class and removes
 * the feedback drawing : this drawing is delegated to the layoutEditPolicy of
 * the container. It also handles the AutoLayout request.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ResizableEditPolicy extends org.eclipse.gef.editpolicies.ResizableEditPolicy
{

    /**
     * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#showChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest)
     */
    protected void showChangeBoundsFeedback(ChangeBoundsRequest request)
    {
        // Feedback is delegated to the container layout edit policy for all the
        // requests except the resize request
        if (REQ_RESIZE.equals(request.getType()))
        {
            super.showChangeBoundsFeedback(request);
        }
    }

    /**
     * Compute the optimized size for the given EditPart.<br>
     * It retrieves the preferred size of the current figure : it returns this
     * optimized size to show all the contained children.<br>
     * And it keeps the intersection with this optimal size and the minimum one.
     * 
     * @param ep the editpart
     * @param margin the margin to put around inner nodes
     * @return the optimal dimension
     */
    private Dimension computeNewSize(GraphicalEditPart ep, int margin)
    {
        Dimension optimizedDim = ep.getFigure().getPreferredSize();
        optimizedDim.expand(margin, margin);
        if (ep instanceof GraphNodeEditPart)
        {
            GraphNodeEditPart nodeEP = (GraphNodeEditPart) ep;
            Dimension minDim = new Dimension(nodeEP.getMinimumWidth(), nodeEP.getMinimumHeight());
            optimizedDim = optimizedDim.getUnioned(minDim);
        }

        return optimizedDim;
    }

    /**
     * Create the AutoLayout Command for the given request
     * 
     * @param request the autolayout request
     * @return the autolayout command
     */
    protected Command getAutoResizeCommand(AutoResizeRequest request)
    {
        getHostFigure().invalidateTree();
       
        Dimension delta = getDelta((GraphicalEditPart) getHost(), request);
        // Handle zoom
        getHostFigure().translateToAbsolute(delta);

        if (delta.width != 0 || delta.height != 0)
        {
            // construct the AutoResize Request
            ChangeBoundsRequest cbRequest = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
            cbRequest.setCenteredResize(true);
            cbRequest.setSizeDelta(delta);
            return getHost().getCommand(cbRequest);
        }

        return UnexecutableCommand.INSTANCE;
    }
    
    /**
     * Returns the resize delta from the EditPart and the request.
     * @param ep the edit part to resize
     * @param request the autosize request
     * @return the difference between old dimension and new dimension
     */
    private Dimension getDelta(GraphicalEditPart ep, AutoResizeRequest request)
    {
        Dimension contentDim = request.getContentPaneSize();
        if (contentDim != null)
        {
            Dimension newDim = contentDim.getExpanded(request.getMargin(), request.getMargin());
            IFigure contentPane = ep.getContentPane();
            return newDim.getDifference(contentPane.getSize());
        }
        else
        {
            Dimension newDim = computeNewSize(ep, request.getMargin());
            Dimension oldDim = ep.getFigure().getSize();
            return newDim.getDifference(oldDim);
        }
    }

    /**
     * Factors out AUTORESIZE, otherwise calls <code>super</code>.
     * 
     * @see org.eclipse.gef.EditPolicy#getCommand(Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_AUTORESIZE.equals(request.getType()))
        {
            return getAutoResizeCommand((AutoResizeRequest) request);
        }

        return super.getCommand(request);
    }
}
