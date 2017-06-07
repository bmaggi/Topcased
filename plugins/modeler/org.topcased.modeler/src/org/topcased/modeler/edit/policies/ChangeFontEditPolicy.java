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
import org.eclipse.swt.graphics.FontData;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.GraphElement;

/**
 * The EditPolicy that handle the Change Font command
 * 
 * Creation : 4 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangeFontEditPolicy extends AbstractEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_CHANGE_FONT.equals(request.getType()))
        {
            GraphElement elt = (GraphElement) getHost().getModel();
            FontData newFontData = (FontData) request.getExtendedData().get(ModelerPropertyConstants.FONT);
            if (elt != null && newFontData != null)
            {
                // create the command with the new fontData
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(elt,
                        ModelerPropertyConstants.FONT, StringConverter.asString(newFontData));
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
        return ModelerRequestConstants.REQ_CHANGE_FONT.equals(req.getType());
    }

}
