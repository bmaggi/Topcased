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

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section with a check button.
 * 
 * @author Jacques LESCOT
 */
public abstract class AbstractBooleanPropertySection extends AbstractModelerPropertySection
{

    /**
     * The checkButton control for the section.
     */
    protected Button checkButton;

    private SelectionListener listener = new SelectionListener()
    {
        public void widgetSelected(SelectionEvent e)
        {
            handleCheckButtonModified();
        }

        public void widgetDefaultSelected(SelectionEvent e)
        {
        }
    };

    /**
     * @see org.topcased.modeler.editor.properties.sections.AbstractModelerPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        checkButton = getWidgetFactory().createButton(composite, getCheckButtonText(), SWT.CHECK);
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        checkButton.setLayoutData(data);

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
    protected void setEnabled(boolean isEnabled)
    {
        super.setEnabled(isEnabled);
        if (checkButton != null)
        {
            checkButton.setEnabled(isEnabled);
        }
    }

    /**
     * Handle the checkbutton modified event.
     */
    protected void handleCheckButtonModified()
    {
        EditingDomain editingDomain = (EditingDomain) getPart().getAdapter(EditingDomain.class);
        Object value = Boolean.valueOf(checkButton.getSelection());
        if (eObjectList.size() == 1)
        {
            /* apply the property change to single selected object */
            editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, eObject, getFeature(), value));
        }
        else
        {
            CompoundCommand compoundCommand = new CompoundCommand();
            /* apply the property change to all selected elements */
            for (Iterator i = eObjectList.iterator(); i.hasNext();)
            {
                EObject nextObject = (EObject) i.next();
                compoundCommand.append(SetCommand.create(editingDomain, nextObject, getFeature(), value));
            }
            editingDomain.getCommandStack().execute(compoundCommand);
        }
    }
    
    /**
     * Get the feature for the text field for the section.
     * 
     * @return the feature for the text.
     */
    protected abstract EAttribute getFeature();

    /**
     * Get the new value of the feature for the text field for the section.
     * 
     * @return the boolean value of the feature.
     */
    protected abstract boolean getFeatureValue();

    /**
     * Get the label for the button for the section.
     * 
     * @return the label for the button.
     */
    protected abstract String getCheckButtonText();
}