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

import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.requests.RestoreConnectionsRequest;

/**
 * Provides support to restore connections of the children of the EditPart<br>
 * 
 * Creation : 23 fev. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ForwardRestoreEditPolicy extends AbstractEditPolicy
{

    /**
     * Returns the <code>Command</code> to restore all the incoming/outgoing
     * connections of the children of the EditPart.
     * 
     * @param request the RestoreConnectionsRequest
     * @return a Command to restore connections
     */
    protected Command getRestoreConnectionsCommand(RestoreConnectionsRequest request)
    {
        CompoundCommand compCmd = new CompoundCommand();
        for (Iterator iter = getHost().getChildren().iterator(); iter.hasNext();)
        {
            EditPart editPart = (EditPart) iter.next();
            Command cmd = editPart.getCommand(request);
            if (cmd != null && cmd.canExecute())
            {
                compCmd.add(cmd);
            }
        }
        return compCmd;
    }

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
