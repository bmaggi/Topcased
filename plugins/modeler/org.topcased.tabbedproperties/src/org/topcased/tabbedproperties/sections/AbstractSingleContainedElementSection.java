/*******************************************************************************
 * Copyright (c) 2008 Topcased consortium. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 ******************************************************************************/

package org.topcased.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.topcased.facilities.dialogs.ChooseDialog;
import org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * An abstract section composed of both :
 * <ul>
 * <li>a CSingleObjectChooser for the selection of a feature</li>
 * <li>a "New" Button used to create the element to associate with the feature in the case it does not exist yet</li>
 * </ul>
 * This might be used when the feature to be specified is defined at the metamodel level using a containment reference
 * with a upper bound equal to 1
 * 
 * Creation 28 feb. 08<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractSingleContainedElementSection extends AbstractTabbedPropertySection
{
    /** A boolean that store if refreshing is happening and no model modifications should be performed */
    private boolean isRefreshing = false;

    /** The Label that identify the section Label */
    private CLabel eltToRefLbl;

    /** The combo box control for the section. */
    private CSingleObjectChooser cSingleObjectChooser;

    /** The button used to create a new Element to associate with the current selected one */
    private Button newButton;

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    protected void createWidgets(Composite composite)
    {
        eltToRefLbl = getWidgetFactory().createCLabel(composite, getLabelText(), SWT.NONE);

        cSingleObjectChooser = new CSingleObjectChooser(composite, getWidgetFactory(), SWT.NONE);
        cSingleObjectChooser.setLabelProvider(getLabelProvider());

        newButton = getWidgetFactory().createButton(composite, "New", SWT.NONE);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        eltToRefLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(eltToRefLbl, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(newButton, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(eltToRefLbl, 0, SWT.CENTER);
        cSingleObjectChooser.setLayoutData(data);

        data = new FormData();
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(eltToRefLbl, 0, SWT.CENTER);
        newButton.setLayoutData(data);
    }

    /**
     * Adds the listeners on the widgets
     */
    protected void hookListeners()
    {
        cSingleObjectChooser.addSelectionListener(new SelectionAdapter()
        {
            /**
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            public void widgetSelected(SelectionEvent e)
            {
                handleComboModified();
            }
        });

        newButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleButtonPressed();
            }
        });
    }

    /**
     * Handle the combo modified event.
     */
    protected void handleComboModified()
    {
        if (!isRefreshing && getFeatureValue() != cSingleObjectChooser.getSelection() && getEObjectList().size() == 1)
        {
            // Update the State with the corresponding Behavior
            getEditingDomain().getCommandStack().execute(new SetCommand(getEditingDomain(), getEObject(), getFeature(), cSingleObjectChooser.getSelection()));
        }
    }

    /**
     * Handle the button pressed event.
     */
    protected void handleButtonPressed()
    {
        Object selectedType = null;

        // Open the dialog used to choose the type of Constraint
        ChooseDialog dialog = new ChooseDialog(Display.getDefault().getActiveShell(), getAvailableTypes());
        dialog.setLabelProvider(getLabelProvider());
        if (dialog.open() == Window.OK && dialog.getResult().length > 0)
        {
            selectedType = dialog.getResult()[0];
            if (selectedType != null && getEObjectList().size() == 1)
            {
                // Update the State with the corresponding Behavior
                getEditingDomain().getCommandStack().execute(new SetCommand(getEditingDomain(), getEObject(), getFeature(), selectedType));

                // Refresh the combo so that the new Behavior is added and selected
                this.refresh();
            }
        }
    }

    private Object[] getAvailableTypes()
    {
        Collection< ? > allTypes = getEditingDomain().getNewChildDescriptors(getEObject(), null);
        List<Object> availableTypes = new ArrayList<Object>();

        for (Iterator< ? > itAllTypes = allTypes.iterator(); itAllTypes.hasNext();)
        {
            Object currentType = itAllTypes.next();
            if (currentType instanceof CommandParameter && getFeature().equals(((CommandParameter) currentType).getFeature()))
            {
                availableTypes.add(((CommandParameter) currentType).getEValue());
            }
        }
        return availableTypes.toArray();
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
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
        if (newButton != null)
        {
            newButton.setEnabled(enabled);
        }
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
        choices.addAll(TypeCacheAdapter.getExistingTypeCacheAdapter(getEObject()).getReachableObjectsOfType(getEObject(), type));

        return choices.toArray();
    }

    /**
     * Get the LabelProvider to use to display the Behavior element
     * 
     * @return ILabelProvider
     */
    protected abstract ILabelProvider getLabelProvider();

    /**
     * Get the enumeration values of the feature for the combo field for the section.
     * 
     * @return the list of values of the feature as text.
     */
    protected abstract Object[] getComboFeatureValues();

    /**
     * Get the current Feature Value
     * 
     * @return Type
     */
    protected abstract Object getFeatureValue();

}