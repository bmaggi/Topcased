/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.utils.Utils;

/**
 * This class wraps an enable write action into a command handler.
 * 
 * @author mvelten
 * 
 */
public class EnableWriteHandler extends AbstractHandler
{

    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
        IAction enableWriteAction = getEnableWriteAction(editorPart);

        if (enableWriteAction != null && enableWriteAction.isEnabled())
        {
            enableWriteAction.run();
        }

        return null;
    }

    @Override
    public boolean isEnabled()
    {
        IEditorPart editorPart = Utils.getCurrentModeler();
        IAction enableWriteAction = getEnableWriteAction(editorPart);

        if (enableWriteAction != null)
        {
            return enableWriteAction.isEnabled();
        }
        return false;
    }

    private static IAction getEnableWriteAction(IEditorPart editorPart)
    {
        if (editorPart != null)
        {
            ActionRegistry actionRegistry = (ActionRegistry) editorPart.getAdapter(ActionRegistry.class);
            if (actionRegistry != null)
            {
                return actionRegistry.getAction(ModelerActionConstants.ENABLE_WRITE);
            }
        }
        return null;
    }
}
