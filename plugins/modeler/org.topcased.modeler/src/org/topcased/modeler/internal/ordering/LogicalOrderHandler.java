/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * Tristan FAURE 
 ******************************************************************************/
package org.topcased.modeler.internal.ordering;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.utils.Utils;

public class LogicalOrderHandler extends AbstractHandler
{

    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        Command command = event.getCommand();
        HandlerUtil.toggleCommandState(command);
        Modeler m = Utils.getCurrentModeler();
        if (m != null)
        {
            m.refreshOutline();
        }
        return null;
    }

   

}
