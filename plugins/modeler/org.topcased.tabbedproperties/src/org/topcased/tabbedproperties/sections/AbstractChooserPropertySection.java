/*******************************************************************************
 * Copyright (c) 2006, 2008 ANYWARE TECHNOLOGIES. All rights reserved. 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Jacques Lescot (Anyware Technologies) - initial API and implementation
 *      Jose Alfredo Serrano (Anyware Technologies) - updated API
 *      Jacques Lescot (Anyware Technologies) - fix bug #1434
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.topcased.tabbedproperties.internal.utils.GenModelLabelSwitch;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser;
import org.topcased.tabbedproperties.utils.ITypeCacheAdapter;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * An abstract implementation of a section with a field using a CSingleObjectChooser composite (CCombo with a Button).
 * 
 * Creation 5 apr. 2006<br>
 * Updated 7 aug. 2006<br>
 * 
 * @author Jacques LESCOT
 * @author alfredo SERRANO
 */
public abstract class AbstractChooserPropertySection extends AbstractTabbedPropertySection
{
    /**
     * A boolean that store if refreshing is happening and no model modifications should be performed
     */
    private boolean isRefreshing = false;

    /**
     * The combo box control for the section.
     */
    protected CSingleObjectChooser cSingleObjectChooser;

    /**
     * The label for this section
     */
    protected CLabel labelCombo;

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createWidgets(Composite composite)
    {
        labelCombo = getWidgetFactory().createCLabel(composite, getLabelText());

        cSingleObjectChooser = createObjectChooser(composite, getWidgetFactory(), SWT.NONE);
        cSingleObjectChooser.setLabelProvider(getLabelProvider());
        cSingleObjectChooser.setAdvancedLabelProvider(getAdvancedLabeProvider());
        if (getFeature() != null)
        {
            cSingleObjectChooser.setChangeable(getFeature().isChangeable());
        }

    }

    protected CSingleObjectChooser createObjectChooser(Composite parent, TabbedPropertySheetWidgetFactory factory, int style)
    {
        return new CSingleObjectChooser(parent, factory, style);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(cSingleObjectChooser, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        labelCombo.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(labelCombo, 0, SWT.CENTER);
        cSingleObjectChooser.setLayoutData(data);

    }

    /**
     * Adds the listeners on the widgets
     */
    @Override
    protected void hookListeners()
    {
        cSingleObjectChooser.addSelectionListener(new SelectionAdapter()
        {
            /**
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e)
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
        if (!isRefreshing)
        {
        	createCommand(getFeatureValue(),cSingleObjectChooser.getSelection());
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
    @Override
    public void refresh()
    {
        super.refresh();
        isRefreshing = true;
        cSingleObjectChooser.setChoices(getComboFeatureValues());
        cSingleObjectChooser.setSelection(getFeatureValue());
        isRefreshing = false;
    }

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (cSingleObjectChooser != null)
        {
            cSingleObjectChooser.setEnabled(enabled);
        }
    }

    /**
     * @return the cSingleObjectChooser
     */
    protected CSingleObjectChooser getCSingleObjectChooser()
    {
        return cSingleObjectChooser;
    }

    /**
     * @return the isRefreshing
     */
    protected boolean isRefreshing()
    {
        return isRefreshing;
    }

    /**
     * Returns an array of all reachable objects of a given type from the current selection.
     * 
     * @param object current EObject selection
     * @param type Reachable object which have this type
     * @return An array of objects of the given type
     */
    protected Object[] getChoices(EObject object, EClassifier type)
    {
        List<Object> choices = new ArrayList<Object>();
        choices.add("");
        ITypeCacheAdapter typeCacheAdapter = TypeCacheAdapter.getExistingTypeCacheAdapter(getEObject());
        choices.addAll(typeCacheAdapter.getReachableObjectsOfType(object, type));
        return choices.toArray();
    }

    /**
     * Returns the lable text for the given item
     * 
     * @param object the item to find the name
     * @return The found name of the given item
     */
    protected String getItemLabelText(EObject object)
    {
        return new GenModelLabelSwitch().doSwitch(object);
    }

    /**
     * Get the LabelProvider to use to display the Object
     * 
     * @return ILabelProvider
     */
    protected ILabelProvider getLabelProvider()
    {
        return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
    }

    /**
     * Get the Advanced LabelProvider to use to display the Object. Return null by default : clients that wish to
     * provide an additional LabelProvider should override this method.
     * 
     * @return ILabelProvider. Return null by default
     */
    protected ILabelProvider getAdvancedLabeProvider()
    {
        return null;
    }

    /**
     * Get the current feature value of the selected model object.
     * 
     * @return the feature value to select in the ccombo.
     */
    protected abstract Object getFeatureValue();

    /**
     * Get the enumeration values of the feature for the combo field for the section.
     * 
     * @return the list of values of the feature as text.
     */
    protected abstract Object[] getComboFeatureValues();
}