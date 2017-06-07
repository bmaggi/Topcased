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

import java.util.Map;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.ChangeDiagramPropertiesCommand;
import org.topcased.modeler.di.model.Diagram;

/**
 * The EditPolicy that handle the Change Diagram Properties command
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * 
 */
public class ChangeDiagramPropertiesEditPolicy extends AbstractEditPolicy
{

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {

        if (ModelerRequestConstants.REQ_CHANGE_DIAGRAM_PROPERTIES.equals(request.getType()))
        {
            Diagram diagram = (Diagram) getHost().getModel();
            if (diagram != null)
            {
                Map properties = request.getExtendedData();
                // create the command with the diagram
                ChangeDiagramPropertiesCommand command = new ChangeDiagramPropertiesCommand(diagram, properties);
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
        if (ModelerRequestConstants.REQ_CHANGE_DIAGRAM_PROPERTIES.equals(req.getType()))
        {
            return true;
        }

        return false;
    }

}
