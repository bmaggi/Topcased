/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
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

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.topcased.modeler.commands.DeleteGraphElementCommand;
import org.topcased.modeler.di.model.GraphElement;

/**
 * Handles the deletion of the connection instance (removing the edge instances
 * from the source and target node instances)
 * 
 * @author jako
 */
public class EdgeEditPolicy extends ConnectionEditPolicy
{
    /**
     * Deletion of the connection
     * 
     * @see org.eclipse.gef.editpolicies.ConnectionEditPolicy#getDeleteCommand(org.eclipse.gef.requests.GroupRequest)
     */
    protected Command getDeleteCommand(GroupRequest request)
    {
        Object model = getHost().getModel();
        if (model instanceof GraphElement)
        {
            return new DeleteGraphElementCommand((GraphElement) model, true);
        }
        return null;
    }
}
