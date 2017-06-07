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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * An abstract implementation of a section with a check button. It represents a boolean field.
 * 
 * Creation 5 apr. 2006 Updated 7 aug. 2006
 * 
 * @author Jacques LESCOT
 * @author Alfredo SERRANO
 */
public abstract class AbstractBooleanPropertySection extends AbstractTabbedPropertySection
{

    /**
     * The checkButton control for the section.
     */
    private Button checkButton;

    /**
     * Listen events when the check box is selected
     */
    private SelectionListener listener = new SelectionAdapter()
    {
        public void widgetSelected(SelectionEvent e)
        {
            handleCheckButtonModified();
        }
    };

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    protected void createWidgets(Composite composite)
    {
        checkButton = getWidgetFactory().createButton(composite, getLabelText(), SWT.CHECK);

        if (getFeature() != null)
        {
            checkButton.setEnabled(getFeature().isChangeable());
        }
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        checkButton.setLayoutData(data);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
     */
    protected void hookListeners()
    {
        checkButton.addSelectionListener(listener);
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        checkButton.setSelection(getFeatureValue());
    }

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (checkButton != null)
        {
            checkButton.setEnabled(enabled);
        }
    }

    /**
     * Handle the checkbutton modified event.
     */
    protected void handleCheckButtonModified()
    {
        createCommand(Boolean.valueOf(getFeatureValue()), Boolean.valueOf(checkButton.getSelection()));
    }

    /**
     * @return the checkButton
     */
    protected Button getCheckButton()
    {
        return checkButton;
    }

    /**
     * Get the new value of the feature for the text field for the section.
     * 
     * @return the boolean value of the feature.
     */
    protected boolean getFeatureValue()
    {
        Object bool = getEObject().eGet(getFeature());
        if (bool == null || !(bool instanceof Boolean))
        {
            return false;
        }
        return ((Boolean) bool).booleanValue();
    }

    /**
     * By default, return the name of the Feature
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     */
    protected String getLabelText()
    {
        return getFeature().getName();
    }
}