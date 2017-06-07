/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
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

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

/**
 * Creation : 30 nov. 2004 Updated : 27 feb. 2008
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EdgeEndpointEditPolicy extends ConnectionEndpointEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#addSelectionHandles()
     */
    protected void addSelectionHandles()
    {
        super.addSelectionHandles();
        getConnectionFigure().setLineWidth(2);
    }

    /**
     * Return the connection figure
     * 
     * @return PolylineConnection
     */
    protected PolylineConnection getConnectionFigure()
    {
        return (PolylineConnection) getHostFigure();
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#hideSelection()
     */
    protected void hideSelection()
    {
        super.hideSelection();
        // Bug #1250 : Remove the following statement ... what is the initial need ??
// getHostFigure().setFont(null);
        getHostFigure().invalidateTree();
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#removeSelectionHandles()
     */
    protected void removeSelectionHandles()
    {
        super.removeSelectionHandles();
        getConnectionFigure().setLineWidth(0);
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#showSelection()
     */
    protected void showSelection()
    {
        super.showSelection();
        getHostFigure().validate();
        getHostFigure().invalidateTree();
    }

}
