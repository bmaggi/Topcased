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
 *  Maxime Leray (Atos Origin) maxime.leray@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.widgets;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.utils.Utils;
import org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser;

/**
 * The Class CSingleObjectChooserOrDisplay. Provides a "display" button that shows out the item in the outline and
 * displays the associated property section.
 */
public class CSingleObjectChooserOrDisplay extends CSingleObjectChooser
{

    /** The display btn. */
    private Button displayBtn;

    /**
     * Instantiates a new c single object chooser or locator.
     * 
     * @param parent the parent
     * @param factory the factory
     * @param style the style
     */
    public CSingleObjectChooserOrDisplay(Composite parent, TabbedPropertySheetWidgetFactory factory, int style)
    {
        super(parent, factory, style);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#getNumberOfColumns()
     */
    @Override
    protected int getNumberOfColumns()
    {
        return 3;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#hookListeners()
     */
    @Override
    protected void hookListeners()
    {
        super.hookListeners();
        displayBtn.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                handleLocate();
            }
        });
    }

    /**
     * Handle locate.
     */
    private void handleLocate()
    {
        StructuredSelection selec = new StructuredSelection(getSelection());
        Modeler modeler = Utils.getCurrentModeler();
        if (modeler != null)
        {
            modeler.setOutlineSelection(selec);
            modeler.setPropertySelection(selec);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#setEnabled(boolean)
     */
    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        displayBtn.setEnabled(enabled);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#createContents(org.eclipse.swt.widgets.Composite
     * )
     */
    @Override
    protected void createContents(Composite parent)
    {
        super.createContents(parent);
        displayBtn = widgetFactory.createButton(parent, "Display", SWT.PUSH);
    }

}
