/*****************************************************************************
 * 
 * NewFilterDialog.java
 * 
 * Copyright (c) 2008 Atos Origin.
 *
 * Contributors:
 *  Thibault Landr� (Atos Origin) thibault.landre@atosorigin.com
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.editor.outline.filters.dialogs;

import java.io.File;
import java.util.Arrays;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.topcased.modeler.editor.outline.filters.files.UserFilterFile;
import org.topcased.modeler.l10n.Messages;

/**
 * The Class NewFilterDialog. This dialog creates a new UserFilterFile on a given metamodel. The UserFilterFile contains
 * the metamodel elements on which the filter will occurs. The result is the UserFilterFile created.
 * 
 * This dialog is also used to update an existing UserFilterFile. In this case, filename and directory can't be
 * modified.
 * 
 */
public class NewFilterDialog extends SelectionDialog
{

    /** The parent composite. */
    private Composite parentComposite;

    /** The message area. */
    private Label messageArea;

    /** The new filter filename text. */
    private Text newFilterFilenameText;

    /** The new filter location text. */
    private Text newFilterLocationText;

    /** The new filter location button. */
    private Button newFilterLocationButton;

    /** The metamodel list viewer. */
    private CheckboxTableViewer metamodelListViewer;

    /** The select all button. */
    private Button selectAllButton;

    /** The deselect all button. */
    private Button deselectAllButton;

    /** The metamodel list label provider. */
    private ILabelProvider metamodelListLabelProvider;

    /** The metamodel list content provider. */
    private IContentProvider metamodelListContentProvider;

    /** The metamodel list input. */
    private Object[] metamodelListInput;

    /** The user filter file. */
    private UserFilterFile userFilterFile;

    /**
     * Instantiates a new new filter dialog.
     * 
     * @param parentShell the parent shell
     * @param metamodelListInput the metamodel list input
     * @param metamodelListContentProvider the metamodel list content provider
     * @param metamodelListLabelProvider the metamodel list label provider
     * @param userFilterFile the user filter file to edit
     */
    protected NewFilterDialog(Shell parentShell, Object[] metamodelListInput, IContentProvider metamodelListContentProvider, ILabelProvider metamodelListLabelProvider, UserFilterFile userFilterFile)
    {
        super(parentShell);
        this.metamodelListInput = metamodelListInput;
        this.metamodelListContentProvider = metamodelListContentProvider;
        this.metamodelListLabelProvider = metamodelListLabelProvider;
        this.userFilterFile = userFilterFile;
    }
    
    /**
     * @see org.eclipse.ui.dialogs.SelectionDialog#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell shell)
    {
        super.configureShell(shell);
        shell.setMinimumSize(400, 500);
        shell.setSize(400, 500);
    }

    /**
     * @see org.eclipse.ui.dialogs.SelectionDialog#isResizable()
     */
    @Override
    protected boolean isResizable()
    {
        return true;
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent)
    {
        parentComposite = (Composite) super.createDialogArea(parent);
        parentComposite.setLayout(new GridLayout(2, false));

        messageArea = createMessageArea(parentComposite);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 2;
        messageArea.setLayoutData(gridData);

        Label labelFilterName = new Label(parentComposite, SWT.NONE);
        labelFilterName.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        labelFilterName.setText(Messages.getString("NewFilterDialog.FilterNameLabel"));

        Composite compoFilenameText = new Composite(parentComposite, SWT.NONE);
        compoFilenameText.setLayout(new GridLayout(1, false));
        compoFilenameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        newFilterFilenameText = new Text(compoFilenameText, SWT.BORDER);
        newFilterFilenameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Label directory = new Label(parentComposite, SWT.NONE);
        directory.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        directory.setText(Messages.getString("NewFilterDialog.DirectoryLabel"));

        Composite compoLocation = new Composite(parentComposite, SWT.NONE);
        compoLocation.setLayout(new GridLayout(2, false));
        compoLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        newFilterLocationText = new Text(compoLocation, SWT.FLAT | SWT.BORDER | SWT.READ_ONLY);
        newFilterLocationText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        newFilterLocationButton = new Button(compoLocation, SWT.PUSH);
        newFilterLocationButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
        newFilterLocationButton.setText(Messages.getString("NewFilterDialog.DirectoryButton"));
        newFilterLocationButton.setToolTipText(Messages.getString("NewFilterDialog.DirectoryButtonTooltip"));

        Group metamodelListViewerGroup = new Group(parentComposite, SWT.NONE);
        metamodelListViewerGroup.setText(Messages.getString("NewFilterDialog.ListViewerGroup"));
        metamodelListViewerGroup.setLayout(new GridLayout(2, false));
        gridData = new GridData(GridData.FILL_BOTH);
        gridData.horizontalSpan = 2;
        gridData.heightHint = 200;
        metamodelListViewerGroup.setLayoutData(gridData);
        createMetamodelListViewerGroup(metamodelListViewerGroup);

        createButtonsListener();

        initializeWidgets();
        return parentComposite;
    }

    /**
     * Creates the metamodel list viewer group.
     * 
     * @param composite the parent composite
     */
    private void createMetamodelListViewerGroup(Composite composite)
    {
        metamodelListViewer = CheckboxTableViewer.newCheckList(composite, SWT.BORDER);
        metamodelListViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

        Composite menuCompo = new Composite(composite, SWT.NONE);
        menuCompo.setLayout(new GridLayout(1, false));
        menuCompo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

        selectAllButton = new Button(menuCompo, SWT.PUSH);
        selectAllButton.setText(Messages.getString("NewFilterDialog.SelectAllButton"));
        selectAllButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        deselectAllButton = new Button(menuCompo, SWT.PUSH);
        deselectAllButton.setText(Messages.getString("NewFilterDialog.DeselectAllButton"));
        deselectAllButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }

    /**
     * Initialize the widgets.
     */
    private void initializeWidgets()
    {
        metamodelListViewer.setLabelProvider(metamodelListLabelProvider);
        metamodelListViewer.setContentProvider(metamodelListContentProvider);
        metamodelListViewer.setInput(metamodelListInput);

        // If userFilterFile exist (ie : update mode), initialize filename text and directory text and disable them.
        if (userFilterFile != null && userFilterFile.exists())
        {
            newFilterFilenameText.setText(userFilterFile.getName());
            newFilterFilenameText.setEnabled(false);

            newFilterLocationText.setText(userFilterFile.getParentFile().getAbsolutePath());
            newFilterLocationText.setEnabled(false);
            newFilterLocationButton.setEnabled(false);
        }

        if (!getInitialElementSelections().isEmpty())
        {
            for (Object element : metamodelListInput)
            {
                if (getInitialElementSelections().contains(element))
                {
                    metamodelListViewer.setChecked(element, true);
                }
            }
        }
    }

    /**
     * Create the button's listeners.
     */
    private void createButtonsListener()
    {

        selectAllButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                metamodelListViewer.setAllChecked(true);
            }
        });

        deselectAllButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                metamodelListViewer.setAllChecked(false);
            }
        });

        newFilterLocationButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                DirectoryDialog directoryDialog = new DirectoryDialog(getShell());
                String path = directoryDialog.open();
                if (path != null && path.length() != 0)
                {
                    newFilterLocationText.setText(path);
                }
            }
        });
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed()
    {
        if (isValid())
        {
            if (userFilterFile == null)
            {
                userFilterFile = new UserFilterFile(newFilterLocationText.getText() + File.separator + newFilterFilenameText.getText() + userFilterFile.EXTENSION);
            }
            userFilterFile.writeElements(Arrays.asList(metamodelListViewer.getCheckedElements()));
            super.okPressed();
        }
    }

    /**
     * @see org.eclipse.ui.dialogs.SelectionDialog#getResult()
     */
    @Override
    public Object[] getResult()
    {
        if (userFilterFile != null && userFilterFile.exists())
        {
            return new Object[] {userFilterFile};
        }
        return null;
    }

    /**
     * Check if the filter is valid. To be valid, the filename and the directory must be set.
     * 
     * @return true if it is valid, false otherwise
     */
    private boolean isValid()
    {
        if (newFilterFilenameText.getText().length() == 0)
        {
            messageArea.setText(Messages.getString("NewFilterDialog.EmptyFilenameMessageArea"));
            messageArea.setForeground(new Color(getShell().getDisplay(), 255, 0, 0));
            return false;
        }
        if (newFilterLocationText.getText().length() == 0)
        {
            messageArea.setText(Messages.getString("NewFilterDialog.EmptyDirectoryMessageArea"));
            messageArea.setForeground(new Color(getShell().getDisplay(), 255, 0, 0));
            return false;
        }
        return true;
    }

}
