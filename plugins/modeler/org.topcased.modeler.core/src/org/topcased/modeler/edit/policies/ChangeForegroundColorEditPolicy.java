/***********************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.GraphElement;

/**
 * The EditPolicy that handle the Change Foreground Color command
 * 
 * Creation : 3 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangeForegroundColorEditPolicy extends AbstractEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_FOREGROUND_COLOR.equals(request.getType()))
        {
            GraphElement elt = (GraphElement) getHost().getModel();
            RGB newColor = (RGB) request.getExtendedData().get(ModelerPropertyConstants.FOREGROUND_COLOR);
            if (elt != null && newColor != null)
            {
                // create the command with the new color
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(elt,
                        ModelerPropertyConstants.FOREGROUND_COLOR, StringConverter.asString(newColor));
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
        return ModelerRequestConstants.REQ_CHANGE_FOREGROUND_COLOR.equals(req.getType());
    }
}
