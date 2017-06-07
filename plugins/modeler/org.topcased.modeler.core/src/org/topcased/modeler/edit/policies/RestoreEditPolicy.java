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

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.requests.RestoreConnectionsRequest;

/**
 * Provides support to restore graphical information for the EditPart :
 * connections, children... <br>
 * creation : 30 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class RestoreEditPolicy extends AbstractEditPolicy
{

    /**
     * Returns the <code>Command</code> to restore all the incoming/outgoing
     * connections of the EditPart.
     * 
     * @param request the RestoreConnectionsRequest
     * @return a Command to restore connections
     */
    protected abstract Command getRestoreConnectionsCommand(RestoreConnectionsRequest request);

    /**
     * Factors incoming requests into various specific methods.
     * 
     * @see org.eclipse.gef.EditPolicy#getCommand(Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_RESTORE_CONN.equals(request.getType()))
        {
            return getRestoreConnectionsCommand((RestoreConnectionsRequest) request);
        }

        return null;
    }
    
    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
     */
    public boolean understandsRequest(Request req)
    {
        if (ModelerRequestConstants.REQ_RESTORE_CONN.equals(req.getType()))
        {
            return true;
        }
        
        return false;
    }
}
