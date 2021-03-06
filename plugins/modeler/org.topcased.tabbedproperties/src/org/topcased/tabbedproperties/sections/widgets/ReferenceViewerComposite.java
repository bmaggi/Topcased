/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jse Alfredo SERRANO (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.tabbedproperties.sections.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * TODO Comment this class
 */
public class ReferenceViewerComposite extends TableViewerComposite
{
    /**
     * The button which displays a dialog box to select the pointed references
     */
    private Button selectButton;

    /**
     * Constructor
     * 
     * @param parent
     * @param columnNames
     * @param widgetFactory
     */
    public ReferenceViewerComposite(Composite parent, String[] columnNames, TabbedPropertySheetWidgetFactory widgetFactory)
    {
        super(parent, columnNames, widgetFactory);
    }

    /**
     * Only create a Button used to select References.
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.TableViewerComposite#createButtons(org.eclipse.swt.widgets.Composite)
     */
    protected void createButtons(Composite parent)
    {
        final Composite comp = getWidgetFactory().createComposite(parent);
        comp.setLayout(new GridLayout());

        selectButton = getWidgetFactory().createButton(comp, "Select...", SWT.NONE);
        selectButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        hookButtonListeners();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.widgets.TableViewerComposite#hookButtonListeners()
     */
    protected void hookButtonListeners()
    {
        selectButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                Object o = getObjectManager().chooseObjectsFromDialog();
                getObjectManager().updateElement(o);
            }
        });
    }

}
