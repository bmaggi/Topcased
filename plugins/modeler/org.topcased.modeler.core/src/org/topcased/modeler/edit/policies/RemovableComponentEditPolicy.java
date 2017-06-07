/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.topcased.modeler.commands.DeleteGraphElementCommand;
import org.topcased.modeler.di.model.GraphElement;

/**
 * This EditPolicy allows to delete the GraphElement
 * 
 * Creation : 21 déc. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RemovableComponentEditPolicy extends ComponentEditPolicy
{

    /**
     * The constructor
     */
    public RemovableComponentEditPolicy()
    {
        super();
    }
    
    /**
     * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
     */
    protected Command createDeleteCommand(GroupRequest deleteRequest)
    {
        Object model = getHost().getModel();
        if (model instanceof GraphElement)
        {
            return new DeleteGraphElementCommand((GraphElement) model, true);
        }

        return UnexecutableCommand.INSTANCE;
    }

}
