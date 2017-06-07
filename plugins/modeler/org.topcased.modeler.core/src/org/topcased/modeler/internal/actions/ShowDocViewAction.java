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
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.documentation.DocView;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;




/**
 * This action bring the Documentation view to the top.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ShowDocViewAction extends WorkbenchPartAction
{

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public ShowDocViewAction(IWorkbenchPart part)
    {
        super(part);
    }

    /**
     * Always return true
     * 
     * @return <code>true</code>
     */
    protected boolean calculateEnabled()
    {
        return true;
    }

    /**
     * Initializes the paste action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.SHOW_DOCUMENTATION);
        setText("Show Documentation");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("DOCUMENTATION"));
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        try
        {
            getWorkbenchPart().getSite().getPage().showView(DocView.VIEW_ID);
        }
        catch (PartInitException exception)
        {
            ModelerPlugin.log(exception);
        }
    }
}
