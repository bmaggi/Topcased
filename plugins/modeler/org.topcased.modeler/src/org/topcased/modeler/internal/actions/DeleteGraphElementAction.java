/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.ui.actions.DeleteAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.precondition.ActionPreconditionHandler;
import org.topcased.modeler.l10n.Messages;

/**
 * Redefines the GEF delete action to prompt a confirmation dialog.<br>
 * 
 * Creation : 12 dec. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class DeleteGraphElementAction extends DeleteAction
{

    /**
     * Constructor
     * 
     * @param part
     */
    public DeleteGraphElementAction(IWorkbenchPart part)
    {
        super(part);
    }

    /**
     * @see org.eclipse.gef.ui.actions.DeleteAction#run()
     */
    public void run()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        IStructuredSelection structSelection = null;
        if (getSelection() instanceof IStructuredSelection)
        {
            structSelection = (IStructuredSelection) getSelection();
        }
        else
        {
            structSelection = new StructuredSelection(getSelectedObjects());
        }
        boolean conditionsChecked = ActionPreconditionHandler.getInstance().executePreconditions(this, modeler, structSelection);
        if (conditionsChecked)
        {
            super.run();
        }
    }

    /**
     * @see org.eclipse.gef.ui.actions.DeleteAction#init()
     */
    protected void init()
    {
        super.init();
        setText(Messages.getString("DeleteGraphElementAction.CmdLabel"));
        setImageDescriptor(ModelerPlugin.getImageDescriptor("icons/deleteFromDiagram.gif"));
    }
}
