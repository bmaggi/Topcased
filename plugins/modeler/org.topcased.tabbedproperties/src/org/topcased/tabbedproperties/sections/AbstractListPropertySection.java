/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.topcased.tabbedproperties.sections.widgets.TableViewerComposite;

/**
 * An abstract implementation of a section with a list. It represents a list field.
 * 
 * Creation 9 ags. 2006
 * 
 * @author alfredo SERRANO
 */
public abstract class AbstractListPropertySection extends AbstractTabbedPropertySection
{
    /**
     * The list control for the section
     */
    private TableViewerComposite table;

    /**
     * Create the TableViewer composite
     * 
     * @param composite the parent Composite
     */
    @Override
    protected void createWidgets(Composite composite)
    {
        table = new TableViewerComposite(composite, new String[] {getLabelText()}, getWidgetFactory())
        {
            @Override
            public void updateSelectedItem(Object data)
            {
                updateSelection(data);
            }
        };
        table.setLabelProvider(getLabelProvider());

        if (getFeature() != null)
        {
            table.setEnabled(getFeature().isChangeable());
        }
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void setSectionData(Composite composite)
    {
        FormData data;
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        table.setLayoutData(data);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
     */
    @Override
    protected void hookListeners()
    {
        table.setAddListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent event)
            {
                addElement();
            }
        });
    }

    /**
     * This method may be overridden if client want to implement their own add treatment
     * 
     */
    protected void addElement()
    {
        table.addElement();
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    @Override
    public void refresh()
    {
        super.refresh();
        table.setInput(getEObject(), getFeature());
        table.setEditingDomain(getEditingDomain());
        table.refresh();
    }

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (table != null)
        {
            table.setEnabled(enabled);
        }
    }

    /**
     * @return the table
     */
    public TableViewerComposite getTable()
    {
        return table;
    }

    /**
     * Set the table
     * 
     * @param table
     */
    protected void setTable(TableViewerComposite table)
    {
        this.table = table;
    }

    /**
     * This method may be overridden if client desire to listen the table selection
     * 
     * @param data the selected data from the listened table.
     */
    public void updateSelection(Object data)
    {
        // do nothing
    }

    /**
     * Returns the feature which is multiple
     * 
     * @return Object This object is an instance of a java.util.List
     */
    protected abstract Object getListValues();

    /**
     * Returns a label provider to be set for this table.
     * 
     * @return The Label provider. It may be null when client handles attributes.
     */
    protected abstract IBaseLabelProvider getLabelProvider();

}
