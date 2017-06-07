/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.SubActionBars;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.editor.properties.ModelerPropertySheetPage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesContentProvider;

/**
 * An implementation of the old PropertyView as a new tab in the Eclipse Tabbed
 * Properties View
 * 
 * Creation 5 avr. 2006
 * 
 * @author jlescot
 */
public class AdvancedPropertySection extends org.eclipse.ui.views.properties.tabbed.AdvancedPropertySection
{
    private SubActionBars subActionBars;

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        ModelerPropertySheetPage modelerPropertySheetPage = (ModelerPropertySheetPage) tabbedPropertySheetPage;
        page.setPropertySourceProvider(new TabbedPropertiesContentProvider(modelerPropertySheetPage.getAdapterFactory()));

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
        page.makeContributions(actionBars.getMenuManager(), actionBars.getToolBarManager(),
                actionBars.getStatusLineManager());
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

}
