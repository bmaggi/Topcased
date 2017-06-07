 /*******************************************************************************
  * Copyright (c) 2008 TOPCASED. All rights reserved. This program
  * and the accompanying materials are made available under the terms of the
  * Eclipse Public License v1.0 which accompanies this distribution, and is
  * available at http://www.eclipse.org/legal/epl-v10.html
  *
  * Contributors: Topcased contributors and others - initial API and implementation
  *******************************************************************************/
package org.topcased.ui.refactoring;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.topcased.core.refactoring.RenameModelFileInfo;
import org.topcased.ui.internal.Activator;
import org.topcased.ui.refactoring.wizards.RenameModelFileInputPage;

/**
 * <br>Creation : 3 juin 2008
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class MessageDialogRefactorRange extends MessageDialog
{
    private static final String DS_KEY = RenameModelFileInputPage.class.getName();

    private static final String DS_REFERENCES_TYPE_UPDATE = "REFERENCES_TYPE_UPDATE"; //$NON-NLS-1$

    private final RenameModelFileInfo info;

    private IDialogSettings dialogSettings;

    private Button noneBtn;

    private Button updateCurrentProjectBtn;

    private Button allProjectsBtn;

    /**
     * The constructor
     * @see org.eclipse.jface.dialogs.MessageDialog#MessageDialog(Shell, String, Image, String, int, String[], int)
     * @param parentShell
     *            the parent shell
     * @param dialogTitle
     *            the dialog title, or <code>null</code> if none
     * @param dialogTitleImage
     *            the dialog title image, or <code>null</code> if none
     * @param dialogMessage
     *            the dialog message
     * @param dialogImageType
     *            one of the following values:
     *            <ul>
     *            <li><code>MessageDialog.NONE</code> for a dialog with no
     *            image</li>
     *            <li><code>MessageDialog.ERROR</code> for a dialog with an
     *            error image</li>
     *            <li><code>MessageDialog.INFORMATION</code> for a dialog
     *            with an information image</li>
     *            <li><code>MessageDialog.QUESTION </code> for a dialog with a
     *            question image</li>
     *            <li><code>MessageDialog.WARNING</code> for a dialog with a
     *            warning image</li>
     *            </ul>
     * @param dialogButtonLabels
     *            an array of labels for the buttons in the button bar
     * @param defaultIndex
     *            the index in the button label array of the default button
     * @param info
     *            The rename model file information
     */
    public MessageDialogRefactorRange(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage, int dialogImageType, String[] dialogButtonLabels, int defaultIndex, final RenameModelFileInfo info)
    {
        super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, dialogButtonLabels, defaultIndex);
        this.info = info;
        initDialogSettings();
     }

    /**
     * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createCustomArea(Composite parent)
    {
        Composite composite = createRootComposite(parent);
        createRadioGroup(composite);
        return composite;
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
}
