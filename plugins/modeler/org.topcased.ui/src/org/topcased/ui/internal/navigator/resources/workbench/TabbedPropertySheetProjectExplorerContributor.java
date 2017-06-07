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

package org.topcased.ui.internal.navigator.resources.workbench;

import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * Code copied from org.eclipse.ui.navigator.resources plugin
 * 
 * A tabbed property view contributor for the Project Explorer.
 */
public class TabbedPropertySheetProjectExplorerContributor implements ITabbedPropertySheetPageContributor
{

    private final String contributorId;

    protected TabbedPropertySheetProjectExplorerContributor(CommonNavigator aCommonNavigator)
    {
        contributorId = aCommonNavigator.getViewSite().getId();
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
     */
    public String getContributorId()
    {
        return contributorId;
    }

}
