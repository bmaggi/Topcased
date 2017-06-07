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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section with a enumeration field using a
 * combo box (pulldown).
 * 
 * @author Jacques LESCOT
 */
public abstract class AbstractEnumerationPropertySection extends AbstractModelerPropertySection {

	/**
	 * The combo box control for the section.
	 */
	protected CCombo combo;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
	{
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		combo = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER); 
		data = new FormData();
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

		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event)
			{
				handleComboModified();
			}
		});
	}

	/**
	 * Handle the combo modified event.
	 */
	protected void handleComboModified() {

		int index = combo.getSelectionIndex();
		boolean equals = isEqual(index);
		if (!equals)
		{
			EditingDomain editingDomain = (EditingDomain) getPart().getAdapter(EditingDomain.class);
			Object value = getFeatureValue(index);
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
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh()
	{
	    super.refresh();
		combo.setItems(getEnumerationFeatureValues());
		combo.setText(getFeatureAsText());
	}
	
	

	@Override
    protected void setEnabled(boolean isEnabled)
    {
        super.setEnabled(isEnabled);
        if (combo != null)
        {
            combo.setEnabled(isEnabled);
        }
    }

    /**
	 * Determine if the provided index of the enumeration is equal to the
	 * current setting of the enumeration property.
	 * 
	 * @param index
	 *            the new index in the enumeration.
	 * @return <code>true</code> if the new index value is equal to the
	 *         current property setting.
	 */
	protected abstract boolean isEqual(int index);

	/**
	 * Get the feature for the combo field for the section.
	 * 
	 * @return the feature for the text.
	 */
	protected abstract EStructuralFeature getFeature();

	/**
	 * Get the enumeration values of the feature for the combo field for the
	 * section.
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
	 * @param index
	 *            the new index in the enumeration.
	 * @return the new value of the feature.
	 */
	protected abstract Object getFeatureValue(int index);

	/**
	 * Get the label for the combo field for the section.
	 * 
	 * @return the label for the text field.
	 */
	protected abstract String getLabelText();
}