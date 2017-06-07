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
package org.topcased.modeler.edit.policies;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.MoveBackwardCommand;
import org.topcased.modeler.commands.MoveForwardCommand;
import org.topcased.modeler.commands.MoveToBackCommand;
import org.topcased.modeler.commands.MoveToFrontCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.GraphNodeEditPart;

/**
 * The EditPolicy that handle the different 'Move Plans' commands <br/>
 * 
 * Creation : 11 October 2005<br>
 * Updated : 28 July 2010<br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class MovePlansEditPolicy extends AbstractEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    @Override
    public Command getCommand(Request request)
    {
        GraphElement element = getGraphElement();
        if (ModelerRequestConstants.REQ_MOVE_FORWARD.equals(request.getType()))
        {
            if (element != null)
            {
                return new MoveForwardCommand(element);
            }
        }
        else if (ModelerRequestConstants.REQ_MOVE_BACKWARD.equals(request.getType()))
        {

            if (element != null)
            {
                return new MoveBackwardCommand(element);
            }
        }
        else if (ModelerRequestConstants.REQ_MOVE_TO_FRONT.equals(request.getType()))
        {
            if (element != null)
            {
                return new MoveToFrontCommand(element);
            }
        }
        else if (ModelerRequestConstants.REQ_MOVE_TO_BACK.equals(request.getType()))
        {
            if (element != null)
            {
                return new MoveToBackCommand(element);
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
     */
    @Override
    public boolean understandsRequest(Request req)
    {
        GraphElement element = getGraphElement();
        if (element != null && element.getContainer() != null)
        {
            if (ModelerRequestConstants.REQ_MOVE_FORWARD.equals(req.getType()) || ModelerRequestConstants.REQ_MOVE_TO_FRONT.equals(req.getType()))
            {
                return !isToTheFront(element);
            }

            if (ModelerRequestConstants.REQ_MOVE_BACKWARD.equals(req.getType()) || ModelerRequestConstants.REQ_MOVE_TO_BACK.equals(req.getType()))
            {
                return !isToTheBack(element);
            }
        }
        return false;
    }

    /**
     * Gets the {@link GraphElement} from an {@link EditPart}
     * 
     * @return The GraphElement encapsulated into the EditPart
     */
    protected GraphElement getGraphElement()
    {
        if (getHost() instanceof GraphNodeEditPart || getHost() instanceof GraphEdgeEditPart)
        {
            return (GraphElement) getHost().getModel();
        }

        return null;
    }

    /**
     * Tests whether the given element is already presented in front plan.
     * 
     * @param element A {@link GraphElement}
     * @return <code>true</code> if the element is in the front, <code>false</code> otherwise.
     */
    protected boolean isToTheFront(GraphElement element)
    {
        EList<DiagramElement> list = element.getContainer().getContained();
        int position = list.indexOf(element);
        return position == list.size() - 1;
    }

    /**
     * Tests whether the given element is already presented in the back plan.
     * 
     * @param element A {@link GraphElement}
     * @return <code>true</code> if the element is in the back, <code>false</code> otherwise.
     */
    protected boolean isToTheBack(GraphElement element)
    {
        EList<DiagramElement> list = element.getContainer().getContained();
        int position = list.indexOf(element);
        return position == 0;
    }
}
