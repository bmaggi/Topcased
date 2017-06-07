/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.handles.ConnectionEndHandle;
import org.eclipse.gef.handles.ConnectionStartHandle;

/**
 * Allow the selection feedback for the GraphEdge connections
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class GraphEdgeSelectionEditPolicy extends ConnectionEndpointEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#createSelectionHandles()
     */
    protected List createSelectionHandles() {
        List list = new ArrayList();
        list.add(new ConnectionEndHandle((ConnectionEditPart)getHost(), true));
        list.add(new ConnectionStartHandle((ConnectionEditPart)getHost(), true));
        return list;
    }
}
