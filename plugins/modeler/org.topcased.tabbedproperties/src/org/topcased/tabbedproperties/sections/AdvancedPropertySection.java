/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Alfredo Serrano (Anyware Technologies) - updated API and implementation
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.SubActionBars;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesContentProvider;

/**
 * An implementation of the old PropertyView as a new tab in the Eclipse Tabbed Properties View
 * 
 * Creation 5 april 2006 Last Modified 17 august 06
 * 
 * @author jlescot
 * @author <a href="alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 */
public class AdvancedPropertySection extends org.eclipse.ui.views.properties.tabbed.AdvancedPropertySection
{
    private SubActionBars subActionBars;

    private AbstractTabbedPropertySheetPage propertySheetPage;

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        propertySheetPage = (AbstractTabbedPropertySheetPage) tabbedPropertySheetPage;
        page.setPropertySourceProvider(new TabbedPropertiesContentProvider(propertySheetPage.getAdapterFactory()));

        subActionBars = new SubActionBars(tabbedPropertySheetPage.getSite().getActionBars());

        setActionBars(subActionBars);
    }

    /**
     * Sets and prepares the actionBars for this section
     * 
     * @param actionBars the action bars for this page
     */
    protected void setActionBars(IActionBars actionBars)
    {
        page.makeContributions(actionBars.getMenuManager(), actionBars.getToolBarManager(), actionBars.getStatusLineManager());
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeHidden()
     */
    public void aboutToBeHidden()
    {
        super.aboutToBeHidden();
        subActionBars.deactivate();
        subActionBars.updateActionBars();
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeShown()
     */
    public void aboutToBeShown()
    {
        super.aboutToBeShown();
        subActionBars.activate();
        subActionBars.updateActionBars();
    }

    /**
     * Returns the propertySheetPage
     * 
     * @return The PropertySheetPage
     */
    public AbstractTabbedPropertySheetPage getPropertySheetPage()
    {
        return propertySheetPage;
    }
}
