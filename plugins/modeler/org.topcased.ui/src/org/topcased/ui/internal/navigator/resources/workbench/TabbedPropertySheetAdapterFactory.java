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

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Code copied from org.eclipse.ui.navigator.resources plugin
 * 
 * An property sheet page adapter factory for the Project Explorer.
 */
public class TabbedPropertySheetAdapterFactory implements IAdapterFactory
{

    /**
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Object adaptableObject, Class adapterType)
    {

        if (adaptableObject instanceof CommonNavigator)
        {
            if (IPropertySheetPage.class == adapterType)
                return new TabbedPropertySheetPage(new TabbedPropertySheetProjectExplorerContributor((CommonNavigator) adaptableObject));
        }
        return null;
    }

    /**
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
     */
    @SuppressWarnings("rawtypes")
    public Class[] getAdapterList()
    {
        return new Class[] {IPropertySheetPage.class};
    }

}
