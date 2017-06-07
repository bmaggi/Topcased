/*****************************************************************************
 * Copyright (c) 2008 Anyware Technologies.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael Gerard (Anyware Technologies) - Initial API and implementation,
 *  Thomas Szadel (Atos Origin)
 *
 *****************************************************************************/
package org.topcased.tabbedproperties.sections.widgets;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.topcased.tabbedproperties.internal.utils.ColorRegistry;

/**
 * A field widget and a Button that allow you to retrieve an a file path from the filesystem <br>
 * creation : 3 avr. 07
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class FileChooser extends Composite
{

    /** The field. */
    private Text field;

    /** The choose bt. */
    private Button chooseBt;

    /** The widget factory. */
    private TabbedPropertySheetWidgetFactory widgetFactory;

    /** The selected file. */
    private String selectedFile;

    /** Holds the fileChooserExtensionFilter. */
    private String[] filterExtensions;

    /**
     * Constructor.
     * 
     * @param parent the parent Composite
     * @param factory the factory necessary to create the widget
     * @param style the style
     */
    public FileChooser(Composite parent, TabbedPropertySheetWidgetFactory factory, int style)
    {
        super(parent, style);

        this.widgetFactory = factory;
        // default no filter
        setFilterExtensions(new String[] {"*.*"});
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
     * Returning a number less than 2 will be ingnored.
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

        field.addModifyListener(new ModifyListener()
        {

            public void modifyText(ModifyEvent e)
            {
                String oldPath = getSelection();
                String newPath = field.getText();
                if (newPath != null)
                {
                    newPath = newPath.trim();
                }
                setSelection(newPath, false);
                handleFilePathChange(oldPath, newPath);
            }

        });

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
     * Sets the editable state of the text field. The default value is READ-ONLY. However clients may set this value as
     * true by calling this method
     * 
     * @param isEditable the is editable
     */
    public void setEditable(boolean isEditable)
    {
        if (field != null)
        {
            field.setEditable(isEditable);
        }
    }

    /**
     * Open the dialog to choose in the searchable list.
     */
    private void handleChoose()
    {
        FileDialog dialog = new FileDialog(getShell());
        dialog.setFilterExtensions(getFilterExtensions());
        String filePath = dialog.open();
        if (filePath != null)
        {
            String oldPath = getSelection();
            setSelection(filePath);
            handleFilePathChange(filePath, oldPath);
        }
    }

    /**
     * Notify listeners when filePath has changed.
     * 
     * @param filePath the file path
     * @param oldPath the old path
     */
    private void handleFilePathChange(String filePath, String oldPath)
    {
        if (fileHasChanged(oldPath, filePath))
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
        return selectedFile;
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
     * Set the selection of the FileChooser.
     * 
     * @param selection the selection
     * @param updateField boolean update text field if true
     */
    public void setSelection(String selection, boolean updateField)
    {
        String name = "";
        if (selection != null)
        {
            name = selection;
        }
        selectedFile = name;
        if (updateField)
        {
            field.setText(name);
            if (field.isFocusControl())
            {
                field.setSelection(selectedFile.length());
            }
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
     * Set the file extensions which the dialog will use to filter the files it shows to the argument, which may be
     * null.
     * <p>
     * The strings are platform specific. For example, on Windows, an extension filter string is typically of the form
     * "*.extension", where "*.*" matches all files.
     * </p>
     * 
     * @return the filter extensions
     * 
     * @see #setFilterNames to specify the user-friendly names corresponding to the extensions
     */
    public String[] getFilterExtensions()
    {
        return filterExtensions;
    }

    /**
     * Sets the filter extensions.
     * 
     * @param filterExtensions the new filter extensions
     */
    public void setFilterExtensions(String[] filterExtensions)
    {
        this.filterExtensions = filterExtensions;
    }

    /**
     * Return true if newFilePath and oldFilePath are different.
     * 
     * @param oldFilePath the old file path
     * @param newFilePath the new file path
     * 
     * @return true, if file has changed
     */
    private boolean fileHasChanged(String oldFilePath, String newFilePath)
    {
        boolean change = true;

        if (oldFilePath == null && newFilePath == null || oldFilePath != null && oldFilePath.equals(newFilePath))
        {
            change = false;
        }

        return change;
    }

    /**
     * Set widget status.
     * 
     * @param statusList the status list
     */
    public void setStatus(List<IStatus> statusList)
    {
        if (statusList != null && !statusList.isEmpty())
        {
            int severity = -1;
            String toolTip = "";
            for (IStatus status : statusList)
            {
                toolTip = "* " + status.getMessage() + "\n";
                if (severity != IStatus.ERROR)
                {
                    severity = status.getSeverity();
                }
            }
            field.setToolTipText(toolTip.substring(0, toolTip.length() - 2));
            if (severity == IStatus.ERROR)
            {
                field.setBackground(ColorRegistry.COLOR_ERROR);
            }
            else if (severity == IStatus.WARNING)
            {
                field.setBackground(ColorRegistry.COLOR_WARNING);
            }
        }
        else
        {
            field.setToolTipText("");
            field.setBackground(ColorRegistry.COLOR_WHITE);
        }
    }

}
