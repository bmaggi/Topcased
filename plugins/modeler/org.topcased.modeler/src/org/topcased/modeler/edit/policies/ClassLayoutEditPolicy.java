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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

/**
 * The Policy for a Node that contains several EListEditPart as children.
 * The EditPolicy delegates the createRequest to these children.
 * 
 * Creation : 16 janv. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ClassLayoutEditPolicy extends LayoutEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
     */
    protected Command getCreateCommand(CreateRequest request)
    {
        Command result = null;

        // If only one EObject is added, we iterate on all the children
        // EListEditPart until we found a valid Command.
        if (request.getNewObject() instanceof EObject)
        {
            Iterator it = getHost().getChildren().iterator();
            while (it.hasNext())
            {
                EditPart ep = (EditPart) it.next();
                Command childCmd = ep.getCommand(request);
                if (childCmd != null && childCmd.canExecute())
                {
                    result = childCmd;
                }
            }
        }
        // If the request is about a List of objects, we create a
        // CompoundCommand and we send the CreateRequest to each EListEditPart
        else
        {
            result = new CompoundCommand();
            Iterator it = getHost().getChildren().iterator();
            while (it.hasNext())
            {
                EditPart ep = (EditPart) it.next();
                Command childCmd = ep.getCommand(request);
                if (childCmd != null && childCmd.canExecute())
                {
                    ((CompoundCommand) result).add(childCmd);
                }
            }
        }
        return result;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
     */
    protected EditPolicy createChildEditPolicy(EditPart child)
    {
        return null;
    }
    
    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
     */
    protected Command getDeleteDependantCommand(Request request)
    {
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(org.eclipse.gef.Request)
     */
    protected Command getMoveChildrenCommand(Request request)
    {
        return null;
    }

    protected Command getAddCommand(Request request)
    {
        Command result = null;

        // If only one EObject is added, we iterate on all the children
        // EListEditPart until we found a valid Command.
        if (((ChangeBoundsRequest) request).getEditParts().size() <= 1)
        {
            Iterator it = getHost().getChildren().iterator();
            while (it.hasNext())
            {
                EditPart ep = (EditPart) it.next();
                Command childCmd = ep.getCommand(request);
                if (childCmd != null && childCmd.canExecute())
                {
                    result = childCmd;
                }
            }
        }
        // If the request is about a List of objects, we create a
        // CompoundCommand and we send the CreateRequest to each EListEditPart
        else
        {
            result = new CompoundCommand();
            Iterator it = getHost().getChildren().iterator();
            while (it.hasNext())
            {
                EditPart ep = (EditPart) it.next();
                Command childCmd = ep.getCommand(request);
                if (childCmd != null && childCmd.canExecute())
                {
                    ((CompoundCommand) result).add(childCmd);
                }
            }
        }
        return result;
    }
}
