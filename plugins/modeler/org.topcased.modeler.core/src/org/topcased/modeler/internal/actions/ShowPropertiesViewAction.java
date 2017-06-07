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
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This action bring the properties view to the top. <br>
 * creation : 3 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ShowPropertiesViewAction extends WorkbenchPartAction
{

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public ShowPropertiesViewAction(IWorkbenchPart part)
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
        setId(ModelerActionConstants.SHOW_PROPERTIES);
        setText("Show Properties");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("EDIT"));
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        try
        {
            getWorkbenchPart().getSite().getPage().showView(IPageLayout.ID_PROP_SHEET);
        }
        catch (PartInitException exception)
        {
            ModelerPlugin.log(exception);
        }
    }
}
