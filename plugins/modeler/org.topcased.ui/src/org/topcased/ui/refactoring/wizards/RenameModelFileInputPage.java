/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.refactoring.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.topcased.core.refactoring.RenameModelFileInfo;
import org.topcased.ui.internal.Activator;

/**
 * <p>
 * The input page for the Rename Model/Diagram refactoring, where users can control the effects of the refactoring; to
 * be shown in the wizard.
 * </p>
 * 
 * <p>
 * We let the user enter the new name for the file(s), and we let her decide whether other model/diagram files in the
 * same project should be affected, and whether the operation is supposed to span the entire workspace.
 * </p>
 * 
 * Creation 10 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameModelFileInputPage extends UserInputWizardPage
{

    private static final String DS_KEY = RenameModelFileInputPage.class.getName();

    private static final String DS_REFERENCES_TYPE_UPDATE = "REFERENCES_TYPE_UPDATE"; //$NON-NLS-1$

    private final RenameModelFileInfo info;

    private IDialogSettings dialogSettings;

    private Text txtNewName;

    private Button noneBtn;

    private Button updateCurrentProjectBtn;

    private Button allProjectsBtn;

    /**
     * The constructor
     * 
     * @param info an Object that contains informations about the refactoring
     */
    public RenameModelFileInputPage(final RenameModelFileInfo info)
    {
        super(RenameModelFileInputPage.class.getName());
        this.info = info;
        initDialogSettings();
    }

    /**
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(final Composite parent)
    {
        Composite composite = createRootComposite(parent);
        setControl(composite);

        createRadioGroup(composite);
        createLblNewName(composite);
        createTxtNewName(composite);

        validate();
    }

    private Composite createRootComposite(final Composite parent)
    {
        Composite result = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 10;
        gridLayout.marginHeight = 10;
        result.setLayout(gridLayout);
        initializeDialogUnits(result);
        Dialog.applyDialogFont(result);
        return result;
    }

    private void createLblNewName(final Composite composite)
    {
        Label lblNewName = new Label(composite, SWT.NONE);
        lblNewName.setText("New name :");
    }

    private void createTxtNewName(Composite composite)
    {
        txtNewName = new Text(composite, SWT.BORDER);
        txtNewName.setText(info.getOldName());
        txtNewName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtNewName.selectAll();
        txtNewName.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(final KeyEvent e)
            {
                info.setNewName(txtNewName.getText());
                //TODO : See if it is used
                info.setNewExtension(txtNewName.getText());
                validate();
            }
        });
    }

    private void createRadioGroup(final Composite composite)
    {
        // Create the Group that contains the three radio buttons
        Group radioGroup = new Group(composite, SWT.NONE);
        radioGroup.setText("Refactoring range");
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.horizontalSpan = 2;
        radioGroup.setLayoutData(gridData);
        radioGroup.setLayout(new GridLayout());

        noneBtn = createRadioButton(radioGroup, "No reference update");
        noneBtn.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(final SelectionEvent event)
            {
                if (noneBtn.getSelection())
                {
                    dialogSettings.put(DS_REFERENCES_TYPE_UPDATE, RenameModelFileInfo.NONE);
                    info.setReferencesTypeUpdate(RenameModelFileInfo.NONE);
                }
            }
        });

        updateCurrentProjectBtn = createRadioButton(radioGroup, "Search for references only in the current project");
        updateCurrentProjectBtn.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(final SelectionEvent event)
            {
                if (updateCurrentProjectBtn.getSelection())
                {
                    dialogSettings.put(DS_REFERENCES_TYPE_UPDATE, RenameModelFileInfo.ONLY_CURRENT_PROJECT);
                    info.setReferencesTypeUpdate(RenameModelFileInfo.ONLY_CURRENT_PROJECT);
                }
            }
        });

        allProjectsBtn = createRadioButton(radioGroup, "Search for references in all the projects of the workspace");
        allProjectsBtn.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(final SelectionEvent event)
            {
                if (allProjectsBtn.getSelection())
                {
                    dialogSettings.put(DS_REFERENCES_TYPE_UPDATE, RenameModelFileInfo.ALL_PROJECTS);
                    info.setReferencesTypeUpdate(RenameModelFileInfo.ALL_PROJECTS);
                }
                // getRefactoringWizard().setForcePreviewReview(selected);
            }
        });

        // Initialize the radio buttons selection
        int updateRefs = dialogSettings.getInt(DS_REFERENCES_TYPE_UPDATE);
        noneBtn.setSelection(updateRefs == RenameModelFileInfo.NONE);
        updateCurrentProjectBtn.setSelection(updateRefs == RenameModelFileInfo.ONLY_CURRENT_PROJECT);
        allProjectsBtn.setSelection(updateRefs == RenameModelFileInfo.ALL_PROJECTS);
        info.setReferencesTypeUpdate(updateRefs);
    }

    private Button createRadioButton(final Composite composite, final String text)
    {
        Button result = new Button(composite, SWT.RADIO);
        result.setText(text);
        result.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        return result;
    }

    private void initDialogSettings()
    {
        IDialogSettings ds = Activator.getDefault().getDialogSettings();
        dialogSettings = ds.getSection(DS_KEY);
        if (dialogSettings == null)
        {
            dialogSettings = ds.addNewSection(DS_KEY);
            // init default values
            dialogSettings.put(DS_REFERENCES_TYPE_UPDATE, RenameModelFileInfo.ONLY_CURRENT_PROJECT);
        }
        else if (dialogSettings.get(DS_REFERENCES_TYPE_UPDATE) == null)
        {
            // init default values
            dialogSettings.put(DS_REFERENCES_TYPE_UPDATE, RenameModelFileInfo.ONLY_CURRENT_PROJECT);
        }
    }

    private void validate()
    {
        String txt = txtNewName.getText();
        boolean isValid = true;

        // Check whether the files that will be renamed does not already exist in the current project.
        for (IFile fileToRename : info.getFilesToRename())
        {
            IPath newPath = fileToRename.getFullPath().removeLastSegments(1).append(txt.concat(".").concat(fileToRename.getFileExtension()));
            if (ResourcesPlugin.getWorkspace().getRoot().getFile(newPath).exists())
            {
                isValid = false;
            }

        }

        setErrorMessage(isValid ? null : "A file with the same name already exists. Please, choose another one.");
        setPageComplete(isValid);
    }

}
