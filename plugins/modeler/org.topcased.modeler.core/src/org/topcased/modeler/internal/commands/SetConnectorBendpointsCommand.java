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
package org.topcased.modeler.internal.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.topcased.modeler.di.model.GraphEdge;

/**
 * @author melaasar
 */
public class SetConnectorBendpointsCommand extends Command
{
    private GraphEdge edge;

    private PointList newPointList;

    private Point sourceRefPoint;

    private Point targetRefPoint;

    private List<RelativeBendpoint> oldBendpoints;

    private List<RelativeBendpoint> newBendpoints;

    /**
     * @see java.lang.Object#Object()
     */
    public SetConnectorBendpointsCommand()
    {
        super("Change bendpoint");
    }

    /**
     * Returns the targetRefPoint.
     * 
     * @return Point
     */
    public Point getTargetRefPoint()
    {
        return targetRefPoint;
    }

    /**
     * Returns the newPointList.
     * 
     * @return PointList
     */
    public PointList getNewPointList()
    {
        return newPointList;
    }

    /**
     * Returns the sourceRefPoint.
     * 
     * @return Point
     */
    public Point getSourceRefPoint()
    {
        return sourceRefPoint;
    }

    /**
     * Sets the connectorAdaptor.
     * 
     * @param edge The connectorAdaptor to set
     */
    public void setGraphEdge(GraphEdge edge)
    {
        this.edge = edge;
    }

    /**
     * Method setNewPointList.
     * 
     * @param newPointList
     * @param sourceRefPoint
     * @param targetRefPoint
     */
    public void setNewPointList(PointList newPointList, Point sourceRefPoint, Point targetRefPoint)
    {
        this.newPointList = new PointList(newPointList.size());
        for (int i = 0; i < newPointList.size(); i++)
        {
            this.newPointList.addPoint(newPointList.getPoint(i));
        }
        this.sourceRefPoint = sourceRefPoint;
        this.targetRefPoint = targetRefPoint;
    }

    /**
     * set a new point list
     * 
     * @param newPointList the new point list to set
     * @param sourceAnchor
     * @param targetAnchor
     */
    public void setNewPointList(PointList newPointList, ConnectionAnchor sourceAnchor, ConnectionAnchor targetAnchor)
    {
        Point sourcePoint = null;
        if (sourceAnchor != null)
        {
            sourcePoint = sourceAnchor.getReferencePoint();
            sourceAnchor.getOwner().translateToRelative(sourcePoint);
        }
        Point targetPoint = null;
        if (targetAnchor != null)
        {
            targetPoint = targetAnchor.getReferencePoint();
            targetAnchor.getOwner().translateToRelative(targetPoint);
        }
        setNewPointList(newPointList, sourcePoint, targetPoint);
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    @Override
    public void execute()
    {
        // Check values
        Assert.isNotNull(newPointList);
        Assert.isNotNull(sourceRefPoint);
        Assert.isNotNull(targetRefPoint);
        Assert.isNotNull(edge);

        // Save previous values
        oldBendpoints = new ArrayList<RelativeBendpoint>(edge.getWaypoints());

        // Compute new values
        newBendpoints = new ArrayList<RelativeBendpoint>();
        int numOfPoints = newPointList.size();
        for (short i = 0; i < numOfPoints; i++)
        {
            Dimension s = newPointList.getPoint(i).getDifference(sourceRefPoint);
            Dimension t = newPointList.getPoint(i).getDifference(targetRefPoint);
            newBendpoints.add(new RelativeBendpoint(s.width, s.height, t.width, t.height));
        }

        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    @Override
    public void redo()
    {
        edge.getWaypoints().clear();
        edge.getWaypoints().addAll(newBendpoints);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    @Override
    public void undo()
    {
        edge.getWaypoints().clear();
        edge.getWaypoints().addAll(oldBendpoints);
    }
}
