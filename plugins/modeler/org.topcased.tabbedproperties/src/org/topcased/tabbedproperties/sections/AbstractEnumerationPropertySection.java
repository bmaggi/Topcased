/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 *               implementation
 *               Jose Alfredo Serrano (Anyware Technologies) - updated API
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * An abstract implementation of a section with a enumeration field using a combo box (pulldown).
 * 
 * Creation 5 apr. 2006 Updated 7 aug. 2006
 * 
 * @author Jacques LESCOT
 * @author alfredo SERRANO
 */
public abstract class AbstractEnumerationPropertySection extends AbstractTabbedPropertySection
{

    /**
     * The combo box control for the section.
     */
    private CCombo combo;

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createWidgets(Composite composite)
    {
        combo = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);
        if (getFeature() != null)
        {
            boolean isChangeable = getFeature().isChangeable();
            combo.setEditable(false);
            combo.setEnabled(isChangeable);
        }
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        combo.setLayoutData(data);

        CLabel nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(combo, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(combo, 0, SWT.CENTER);
        nameLabel.setLayoutData(data);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
     */
    @Override
    protected void hookListeners()
    {
        combo.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent event)
            {
                handleComboModified();
            }
        });
    }

    /**
     * Handle the combo modified event.
     */
    protected void handleComboModified()
    {
        int index = combo.getSelectionIndex();
        createCommand(getOldFeatureValue(), getFeatureValue(index));
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
    @Override
    public void refresh()
    {
        super.refresh();
        combo.setItems(getEnumerationFeatureValues());
        combo.setText(getFeatureAsText());
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setEnabled(boolean)
     */
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (combo != null)
        {
            combo.setEnabled(enabled);
        }
    }

    /**
     * @return the combo
     */
    protected CCombo getCombo()
    {
        return combo;
    }

    /**
     * Get the enumeration values of the feature for the combo field for the section.
     * 
     * @return the list of values of the feature as text.
     */
    protected abstract String[] getEnumerationFeatureValues();

    /**
     * Get the value of the feature as text for the combo field for the section.
     * 
     * @return the value of the feature as text.
     */
    protected abstract String getFeatureAsText();

    /**
     * Get the new value of the feature for the text field for the section.
     * 
     * @param index the new index in the enumeration.
     * @return the new value of the feature.
     */
    protected abstract Object getFeatureValue(int index);

    /**
     * Get the old value of the feature
     * 
     * @return The current value which is going to be modified
     */
    protected abstract Object getOldFeatureValue();
}