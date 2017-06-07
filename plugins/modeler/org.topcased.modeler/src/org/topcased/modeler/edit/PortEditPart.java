/***********************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Gilles Cannenterre (Anyware Technologies) - fix bug 1397
 **********************************************************************/
package org.topcased.modeler.edit;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.topcased.draw2d.figures.LabelledPortFigure;
import org.topcased.draw2d.figures.PortFigure;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.edit.policies.LabelDirectEditPolicy;
import org.topcased.modeler.figures.ModelerLabelledPortFigure;
import org.topcased.modeler.figures.PortAnchor;

/**
 * This class groups common functions for Port model objects
 * 
 * Created 6 juin 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * 
 */
public class PortEditPart extends EMFGraphNodeEditPart implements IPortEditPart
{
    /**
     * The Constructor
     * 
     * @param obj the GraphNode
     */
    public PortEditPart(GraphNode obj)
    {
        super(obj);
    }

    /**
     * Creates edit policies and associates these with roles
     */
    protected void createEditPolicies()
    {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure()
    {
        return new LabelledPortFigure(new PortFigure());
    }

    /**
     * This method return the Figure that correspond to the graphical representation of the port
     * 
     * @return the Figure that represent the port
     */
    protected IFigure getPortFigure()
    {
        if (getFigure() instanceof ModelerLabelledPortFigure)
        {
            return ((ModelerLabelledPortFigure) getFigure()).getPortFigure();
        }
        else if (getFigure() instanceof LabelledPortFigure)
        {
            return ((LabelledPortFigure) getFigure()).getPortFigure();
        }

        return getFigure();
    }

    // -----------------------
    // GESTION DES ANCHORS
    // -----------------------

    /**
     * Returns a new Anchor for the Figure
     * 
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
    {
        return getPortConnectionAnchor();
    }

    /**
     * Returns a new Anchor for the Figure
     * 
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getSourceConnectionAnchor(Request request)
    {
        return getPortConnectionAnchor();
    }

    /**
     * Returns a new Anchor for the Figure
     * 
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
    {
        return getPortConnectionAnchor();
    }

    /**
     * Returns a new Anchor for the Figure
     * 
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getTargetConnectionAnchor(Request request)
    {
        return getPortConnectionAnchor();
    }

    /**
     * Return the connection Anchor depending on the container of the Port
     * 
     * @return the ConnectionAnchor
     */
    protected ConnectionAnchor getPortConnectionAnchor()
    {
        boolean isDiagram = getParent().getModel() instanceof Diagram;
        return new PortAnchor(getPortFigure(), !isDiagram);
    }

}
