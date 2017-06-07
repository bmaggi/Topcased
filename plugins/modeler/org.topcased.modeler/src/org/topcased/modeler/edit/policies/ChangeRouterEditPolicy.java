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
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.ChangeRouterCommand;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.util.DIUtils;

/**
 * This EditPolicy handles the Change Router request
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ChangeRouterEditPolicy extends AbstractEditPolicy
{

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_ROUTER.equals(request.getType()))
        {
            GraphEdge elt = (GraphEdge) getHost().getModel();
            String newRouter = (String) request.getExtendedData().get(ModelerPropertyConstants.ROUTER);
            String oldRouter = DIUtils.getPropertyValue(elt, ModelerPropertyConstants.ROUTER);
            if (elt != null && newRouter != null && !newRouter.equals(oldRouter))
            {
                // create the command with the new router
                ChangeRouterCommand command = new ChangeRouterCommand(elt, newRouter);
                return command;
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
     */
    public boolean understandsRequest(Request req)
    {
        if (ModelerRequestConstants.REQ_CHANGE_ROUTER.equals(req.getType()))
        {
            return true;
        }

        return false;
    }

}
