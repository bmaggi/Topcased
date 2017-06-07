/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/

package org.topcased.tabbedproperties.sections.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * The Composite Tree Choser
 * <p>
 * This composite allows the user to select an EObject from an EMF Resource given as input. <br/>
 * It creates an unique ID of the EObject selected to store the selection, and displays a text for the users.
 * </p>
 * <p>
 * Clients must set an input as an EMF Resource using <code>setInput(Resource resource)</code>
 * <p>
 * <p>
 * Clients may also select an initial selection using <code>setSelection(String selection, boolean updateField)</code>.<br/>
 * The selection must be an URIFragment
 * </p>
 * 
 * @see org.eclipse.emf.ecore.resource.Resource#getURIFragment(EObject)
 */
public class TreeChooser extends Composite
{

    private static final Class< ? > ITEM_LABEL_PROVIDER_CLASS = IItemLabelProvider.class;

    /** The field. */
    private Text field;

    /** The choose bt. */
    private Button chooseBt;

    /** The widget factory. */
    private TabbedPropertySheetWidgetFactory widgetFactory;

    /** The selected EObject. */
    private String selectedEObject;

    private Resource resource;

    /**
     * Constructor.
     * 
     * @param parent the parent Composite
     * @param factory the factory necessary to create the widget
     * @param style the style
     */
    public TreeChooser(Composite parent, TabbedPropertySheetWidgetFactory factory, int style)
    {
        super(parent, style);

        this.widgetFactory = factory;
        // default no filter
        createContents(this);
        widgetFactory.adapt(this);
        hookListeners();
    }

    /**
     * Creates the UI. User must call the super method to create the main widgets (buttons) to this composite.
     * 
     * @param parent this widget
     */
    protected void createContents(Composite parent)
    {
        setLayout(parent);

        field = widgetFactory.createText(parent, "", SWT.FLAT | SWT.BORDER | SWT.READ_ONLY);
        field.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        chooseBt = widgetFactory.createButton(parent, "...", SWT.PUSH);
    }

    /**
     * This method sets a gridlayout to the composite. The number of columns is determined by the getNumberOfColumns
     * method. The minimum number of columns is 2.
     * 
     * @param parent the composite featuring a gridlayout
     */
    private void setLayout(Composite parent)
    {
        int numColumns = getNumberOfColumns();
        if (numColumns < 2)
        {
            numColumns = 2;
        }
        GridLayout layout = new GridLayout(numColumns, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        parent.setLayout(layout);
    }

    /**
     * Returns the number of columns in this composite. The default object is 2 because the main composite have 2
     * widgets.
     * 
     * Returning a number less than 2 will be ignored.
     * 
     * @return The number of columns to set in this composite. It must be greater or equals than 2
     */
    protected int getNumberOfColumns()
    {
        return 2;
    }

    /**
     * Adds the listeners on the choose button. If user overrides this method, he must call the super method to add the
     * corresponding selection listener, otherwise disfunctions may occur
     */
    protected void hookListeners()
    {
        chooseBt.addSelectionListener(new SelectionAdapter()
        {
            /**
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                handleChoose();
            }
        });
    }

    /**
     * Open a tree dialog to select an unique EObject into the resource set as input.
     */
    private void handleChoose()
    {
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new AdapterFactoryLabelProvider(adapterFactory), new AdapterFactoryContentProvider(adapterFactory));
        dialog.setTitle("Root Container");
        dialog.setMessage("Select the root container of the template :");
        dialog.setInput(resource);
        dialog.setDoubleClickSelects(true);
        dialog.setAllowMultiple(false);
        dialog.setHelpAvailable(false);
        if (!"".equals(getSelection()))
        {
            dialog.setInitialSelection(resource.getEObject(getSelection()));
        }

        int dialogClose = dialog.open();
        if (ElementTreeSelectionDialog.OK == dialogClose)
        {
            Object[] object = dialog.getResult();
            if (object[0] instanceof EObject)
            {
                handleResult((EObject) object[0]);
            }
        }
    }

    private void handleResult(EObject eObject)
    {
        String oldUriFragment = getSelection();
        String uriFragment = eObject.eResource().getURIFragment(eObject);
        setSelection(uriFragment);
        handleEObjectChange(uriFragment, oldUriFragment);
    }

    /**
     * Notify listeners when Path has changed.
     * 
     * @param newEObjectID the new EObject ID
     * @param oldEObjectID the old EObject ID
     */
    private void handleEObjectChange(String newEObjectID, String oldEObjectID)
    {
        if (eObjectHasChanged(oldEObjectID, newEObjectID))
        {
            // to trigger handler on Modification
            Event e = new Event();
            notifyListeners(SWT.Modify, e);
        }
    }

    /**
     * Set whether the Choose button is enabled.
     * 
     * @param isChangeable the is changeable
     */
    public void setChangeable(boolean isChangeable)
    {
        chooseBt.setEnabled(isChangeable);
    }

    /**
     * Returns the selected object.
     * 
     * @return the selection
     */
    public String getSelection()
    {
        return selectedEObject;
    }

    /**
     * Set the selection of the comboViewer.
     * 
     * @param selection the selected object
     */
    public void setSelection(String selection)
    {
        setSelection(selection, true);
    }

    /**
     * Set the selection of the TreeChoseer.
     * 
     * @param selection the selection. It must be an URI Fragment.
     * @param updateField boolean update text field if true
     * 
     * @see org.eclipse.emf.ecore.resource.Resource#getURIFragment(EObject)
     * @see org.eclipse.emf.ecore.resource.Resource#getEObject(String)
     */
    public void setSelection(String selection, boolean updateField)
    {
        String name = "";
        if (selection != null)
        {
            name = selection;
        }
        selectedEObject = name;
        if (updateField)
        {
            String text = getTextBeautifier();
            field.setText(text);
        }
    }

    /**
     * Add a SelectionListener on the Button.
     * 
     * @param listener the listener
     */
    public void addModifyListener(ModifyListener listener)
    {
        if (listener == null)
        {
            SWT.error(SWT.ERROR_NULL_ARGUMENT);
        }
        TypedListener typedListener = new TypedListener(listener);
        addListener(SWT.Modify, typedListener);
    }

    /**
     * Remove the SelectionListener of the CCombo and the Button.
     * 
     * @param listener the listener
     */
    public void removeModifyListener(SelectionListener listener)
    {
        if (listener == null)
        {
            SWT.error(SWT.ERROR_NULL_ARGUMENT);
        }
        removeListener(SWT.Modify, listener);
    }

    /**
     * Gets the widget factory.
     * 
     * @return the widgetFactory
     */
    protected TabbedPropertySheetWidgetFactory getWidgetFactory()
    {
        return widgetFactory;
    }

    /**
     * Return true if newEObjectID and oldEObjectID are different.
     * 
     * @param oldEObjectID the old EObject ID
     * @param newEObjectID the new EObject ID
     * 
     * @return true, if directory has changed
     */
    private boolean eObjectHasChanged(String oldEObjectID, String newEObjectID)
    {
        boolean change = true;

        if (oldEObjectID == null && newEObjectID == null || oldEObjectID != null && oldEObjectID.equals(newEObjectID))
        {
            change = false;
        }

        return change;
    }

    /**
     * Set the resource of the treeChooser.
     * <p>
     * This resource must be an EMF Resource
     * </p>
     * 
     * @param resource the resource to use as input of this TreeChoser
     */
    public void setInput(Resource resource)
    {
        this.resource = resource;
    }

    /**
     * Retrieve the text to present to the user according to the selection made.
     * 
     * @return
     */
    private String getTextBeautifier()
    {
        if (resource != null && getSelection() != null)
        {
            ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
            EObject eObject = resource.getEObject(getSelection());
            if (eObject != null)
            {

                IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, ITEM_LABEL_PROVIDER_CLASS);

                return itemLabelProvider != null ? itemLabelProvider.getText(eObject) : eObject.toString();
            }
        }
        return "";
    }

}