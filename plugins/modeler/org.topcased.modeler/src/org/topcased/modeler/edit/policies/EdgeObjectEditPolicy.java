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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.edit.GraphEdgeEditPart;

/**
 * An abstract edit policy to select and move
 * {@link org.topcased.modeler.di.model.EdgeObject} relative to their owning
 * edge. Must be used only with
 * {@link org.topcased.modeler.edit.GraphEdgeEditPart}. <br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public abstract class EdgeObjectEditPolicy extends SelectionHandlesEditPolicy implements PropertyChangeListener
{
    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#createSelectionHandles()
     */
    protected List createSelectionHandles()
    {
        ArrayList handleList = new ArrayList();
        GraphEdgeEditPart editPart = (GraphEdgeEditPart) getHost();
        if (editPart != null)
        {
            for (Iterator it = editPart.getEdgeObjects().iterator(); it.hasNext();)
            {
                EdgeObject edgeObject = (EdgeObject) it.next();
                Handle handle = createSelectionHandle(edgeObject);
                if (handle != null)
                {
                    handleList.add(handle);
                }
            }
        }
        return handleList;
    }

    /**
     * Create a selection handle for the given edge object.<br>
     * Default implementation returns <code>null</code>.
     * 
     * @param edgeObject the edge object for the one the selection handle has to
     *            be created
     * @return an handle or <code>null</code> if the given edge object must
     *         not have selection handle
     */
    protected Handle createSelectionHandle(EdgeObject edgeObject)
    {
        return null;
    }

    /**
     * Returns the layer used for displaying feedback.
     * 
     * @return the feedback layer
     */
    protected IFigure getFeedbackLayer()
    {
        return getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
    }

    /**
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (getHost().getSelected() != EditPart.SELECTED_NONE)
        {
            addSelectionHandles();
        }
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#activate()
     */
    public void activate()
    {
        super.activate();
        Connection connection = (Connection) ((ConnectionEditPart) getHost()).getFigure();
        connection.addPropertyChangeListener(this);
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#deactivate()
     */
    public void deactivate()
    {
        Connection connection = (Connection) ((ConnectionEditPart) getHost()).getFigure();
        connection.removePropertyChangeListener(this);
        super.deactivate();
    }
}