/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.topcased.ui.navigator.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

/**
 * 
 * Creation 3 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DiagramActionProvider extends CommonActionProvider
{

    private OpenDiagramAction openAction;

    /**
     * Construct Property Action provider.
     */
    public DiagramActionProvider()
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
     */
    @Override
    public void init(ICommonActionExtensionSite aSite)
    {

        ICommonViewerSite viewSite = aSite.getViewSite();
        if (viewSite instanceof ICommonViewerWorkbenchSite)
        {
            ICommonViewerWorkbenchSite workbenchSite = (ICommonViewerWorkbenchSite) viewSite;
            openAction = new OpenDiagramAction(workbenchSite.getPage(), workbenchSite.getSelectionProvider());
        }
    }

    /**
     * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
     */
    @Override
    public void fillActionBars(IActionBars actionBars)
    {
        /* Set up the property open action when enabled. */
        if (openAction.isEnabled())
        {
            actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openAction);
        }
    }

    /**
     * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
     */
    @Override
    public void fillContextMenu(IMenuManager menu)
    {
        if (openAction.isEnabled())
        {
            menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openAction);
        }
    }

}
