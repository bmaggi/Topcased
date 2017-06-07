/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.topcased.facilities.dialogs.ChooseDialog;
import org.topcased.tabbedproperties.providers.AdvancedLabelProvider;
import org.topcased.tabbedproperties.providers.LabelProviderFactory;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * An abstract section used to create a model object inside the selected element. You can then, depending on the
 * selected model object edit its properties through a detailed Composite which is dynamically updated.
 * 
 * Creation 10 nov. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractDetailedObjectPropertySection extends AbstractTabbedPropertySection
{
    /** The message format for displaying the assignment message */
    protected static final String ASSIGN_MESSAGE = "Select %3$s to move as %2$s of %1$s.";

    /** The label used with to identify the Section */
    private CLabel nameLabel;

    /** The Text control for the section. */
    private Text text;

    /** The button used to assign an existing Element */
    private Button assignButton;

    /** The button used to create a new Element */
    private Button createButton;

    /**
     * The Group used to edit the Details of the selected property element. Its contents depends on the type of element
     * that is selected in the other widget.
     */
    private Group groupDetails;

    /** The Composite used to edit the selected element properties */
    private Composite detailsComposite;

    /** The listener to assign a new value to the property */
    private final SelectionListener assignButtonListener = new SelectionAdapter()
    {
        /** @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent) */
        public void widgetSelected(SelectionEvent e)
        {
            // Open the dialog used to choose the Element to assign
            ChooseDialog dialog = new ChooseDialog(Display.getDefault().getActiveShell(), getAssignmentChoices());
            dialog.setLabelProvider(getLabelProvider());
            LabelProviderFactory advancedLableProvider = AdvancedLabelProvider.getAdvancedLabelProviderFactory4CurrentEditor();
            if (advancedLableProvider != null)
            {
                dialog.setAdvancedLabelProvider(advancedLableProvider.createAdapterFactory());
            }
            dialog.setTitle(getAssignmentMessage());
            if (dialog.open() == Window.OK)
            {
                if (dialog.getResult().length > 0)
                {
                    Object selectedElement = dialog.getResult()[0];
                    assignCommand(getRelatedEObject(), selectedElement);
                    // Update the group contents when the type has changed
                    updateGroupContents();
                }
            }
        }
    };

    private final SelectionListener createButtonListener = new SelectionAdapter()
    {
        /** @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent) */
        public void widgetSelected(SelectionEvent e)
        {
            Object[] availableTypes = getAvailableTypes();
            Object selectedType = null;

            if (availableTypes.length == 1)
            {
                selectedType = availableTypes[0];
            }
            // When more than one concrete Types are available, a ChooseDialog is prompted
            else if (availableTypes.length > 1)
            {
                // Open the dialog used to choose the type of Constraint
                ChooseDialog dialog = new ChooseDialog(Display.getDefault().getActiveShell(), getAvailableTypes());
                dialog.setLabelProvider(getLabelProvider());
                if (dialog.open() == Window.OK)
                {
                    if (dialog.getResult().length > 0)
                    {
                        selectedType = dialog.getResult()[0];
                    }
                }
            }

            if (selectedType != null)
            {
                // Create the Command to add the selected Constraint
                createCommand(getRelatedEObject(), selectedType);

                // Update the group contents when the type has changed
                updateGroupContents();
            }
        }
    };

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
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    protected void createWidgets(Composite composite)
    {
        // The Widget used to select/create the corresponding Constraint
        nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());
        text = getWidgetFactory().createText(composite, "", SWT.READ_ONLY);
        if (isAssignmentEnabled())
        {
            assignButton = getWidgetFactory().createButton(composite, "...", SWT.NONE);
        }
        createButton = getWidgetFactory().createButton(composite, "Create ...", SWT.NONE);

        // The group that is used to edit the Details of the selected Constraint
        groupDetails = getWidgetFactory().createGroup(composite, "Details");
        groupDetails.setLayout(new GridLayout());

    }

    /**
     * Returns an array of all reachable objects from the current selection, which have the appropriate type for the
     * feature assignment.
     * 
     * @return An array of objects of the feature's type
     */
    protected Object[] getAssignmentChoices()
    {
        // we get the possible values from the property descriptor
        LinkedList<Object> choices = new LinkedList<Object>();
        choices.add("");
        if (getEObject() != null)
        {
            // do not use TypeCacheAdapter.getExistingTypeCacheAdapter(getEObject()) instead of ItemPropertyDescriptor,
            // since returned values are not up to date
            choices.addAll(TypeCacheAdapter.getExistingTypeCacheAdapter(getEObject()).getReachableObjectsOfType(getEObject(), getFeature().getEType()));
        }
        choices.remove(null);
        // remove parent containers, which can not be assigned
        EObject container = getEObject();
        while (container != null)
        {
            choices.remove(container);
            container = container.eContainer();
        }
        return choices.toArray();
    }

    /**
     * Get the message to display for the object assignment.
     * 
     * @return message
     */
    protected String getAssignmentMessage()
    {
        EClassifier targetedType = getFeature().getEType();
        return String.format(ASSIGN_MESSAGE, getLabelProvider().getText(getEObject()), getFeature().getName(), targetedType.getName());
    }

    /**
     * Create and execute the appropriated command to change the assigned value
     * 
     * @param oldValue the old value or null
     * @param newValue the new value or null or ""
     */
    protected void assignCommand(EObject oldValue, Object newValue)
    {
        EditingDomain editingDomain = getEditingDomain();
        if (editingDomain != null)
        {
            // apply the property change to single selected object
            CompoundCommand command = new CompoundCommand();
            if (newValue == null || "".equals(newValue))
            {
                if (oldValue != null)
                {
                    // apply the property change to single selected object
                    if (getFeature().isMany())
                    {
                        command.append(RemoveCommand.create(editingDomain, getEObject(), getFeature(), oldValue));
                    }
                    else
                    {
                        command.append(DeleteCommand.create(editingDomain, oldValue));
                    }
                }
            }
            else if (!newValue.equals(oldValue))
            {
                if (getFeature().isMany())
                {
                    command.append(RemoveCommand.create(editingDomain, newValue));
                }
                else
                {
                    command.append(DeleteCommand.create(editingDomain, newValue));
                }
                command.append(SetCommand.create(editingDomain, getEObject(), getFeature(), newValue));
            }
            if (!command.isEmpty())
            {
                editingDomain.getCommandStack().execute(command);
            }
        }
    }

    /**
     * Check whether this section displays a button to assign an existing element to the property. Default
     * implementation returns false. Subclasses may override to display the assignement button.
     * 
     * @return whether this section displays an assignment button
     */
    protected boolean isAssignmentEnabled()
    {
        return false;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(createButton, 0, SWT.CENTER);
        nameLabel.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(nameLabel, ITabbedPropertyConstants.HSPACE);
        if (isAssignmentEnabled())
        {
            data.right = new FormAttachment(assignButton, -ITabbedPropertyConstants.HSPACE);
        }
        else
        {
            data.right = new FormAttachment(createButton, -ITabbedPropertyConstants.HSPACE);
        }
        data.top = new FormAttachment(createButton, 0, SWT.CENTER);
        text.setLayoutData(data);

        if (isAssignmentEnabled())
        {
            data = new FormData();
            data.right = new FormAttachment(createButton, -ITabbedPropertyConstants.HSPACE);
            data.top = new FormAttachment(createButton, 0, SWT.CENTER);
            assignButton.setLayoutData(data);
        }

        data = new FormData();
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        createButton.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(nameLabel, ITabbedPropertyConstants.VSPACE);
        groupDetails.setLayoutData(data);

    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        text.setText(updateConstraintText());
        updateGroupContents();
    }
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (text != null)
        {
            text.setEnabled(enabled);
        }
        if (createButton != null)
        {
            createButton.setEnabled(enabled);
        }
        if (assignButton != null)
        {
            assignButton.setEnabled(enabled);
        }
        if (groupDetails != null)
        {
            groupDetails.setEnabled(enabled);
        }
    }

    private String updateConstraintText()
    {
        String name = "";
        if (getRelatedEObject() != null)
        {
            name = getLabelProvider().getText(getRelatedEObject());
            if (name == null)
            {
                name = "";
            }
        }
        return name;
    }

    /**
     * This method should be called when the contents of the groupDetails should be updated.
     */
    protected void updateGroupContents()
    {
        if (detailsComposite != null && !detailsComposite.isDisposed())
        {
            detailsComposite.dispose();
        }
        if (getRelatedEObject() != null)
        {
            // create the new Composite associated with the related model object
            detailsComposite = getDetailsComposite();
            if (detailsComposite != null)
            {
                getWidgetFactory().adapt(detailsComposite);
            }
        }
        // Update the groupDetails composite by forcing it to layout its children
        groupDetails.getParent().getParent().getParent().layout(true, true);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#aboutToBeShown()
     */
    public void aboutToBeShown()
    {
        super.aboutToBeShown();
        if (isAssignmentEnabled() && assignButton != null && !assignButton.isDisposed())
        {
            assignButton.addSelectionListener(assignButtonListener);
        }
        if (createButton != null && !createButton.isDisposed())
        {
            createButton.addSelectionListener(createButtonListener);
        }
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#aboutToBeHidden()
     */
    public void aboutToBeHidden()
    {
        if (isAssignmentEnabled() && assignButton != null && !assignButton.isDisposed())
        {
            assignButton.removeSelectionListener(assignButtonListener);
        }
        if (createButton != null && !createButton.isDisposed())
        {
            createButton.removeSelectionListener(createButtonListener);
        }
        super.aboutToBeHidden();
    }

    /**
     * Get the LabelProvider to use to display the Constraint element
     * 
     * @return ILabelProvider
     */
    protected ILabelProvider getLabelProvider()
    {
        return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
    }

    /**
     * This method returns the groupDetails composite. Subclasses should used it to retrieve that composite and add the
     * custom detailsComposite
     * 
     * @return Group the Group Composite used to display details informations about the relatedEObject
     */
    public Group getGroupDetails()
    {
        return groupDetails;
    }

    /**
     * Get the text value corresponding to the selected Constraint
     * 
     * @return String
     */
    protected abstract String getFeatureAsText();

    /**
     * Return the model object associated with the section. This is not the same model object returned by the
     * getEObject() method, but this is generally an internal model object that can be edited.
     * 
     * @return EObject model object
     */
    protected abstract EObject getRelatedEObject();

    /**
     * This method should return the Composite that should be associated with the details Group
     * 
     * @return the Composite used as children of the detailsGroup
     */
    protected abstract Composite getDetailsComposite();

}
