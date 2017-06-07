/*****************************************************************************
 * Copyright (c) 2009 atos origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  eperico (atos origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * A JFace dialog used to ask a question to the user with yes/no answer<br>
 * This dialog is able to store the user choice into a preference store.<br>
 * 
 * @author eperico
 *
 */
public class QuestionDialog extends MessageDialog
{
    private IPreferenceStore ps;

    private String dialogPreference;
    
    private String dropPreference;

    private Button rememberChoice;

    /**
     * @param parentShell
     * @param dialogTitle 
     * @param message 
     * @param ps 
     * @param dialogPreference 
     */
    public QuestionDialog(Shell parentShell, String dialogTitle, String message, IPreferenceStore ps,
            String dialogPreference, String dropPreference)
    {
        super(parentShell, dialogTitle, null, message, MessageDialog.QUESTION, new String[] {IDialogConstants.YES_LABEL,
                IDialogConstants.NO_LABEL}, IDialogConstants.YES_ID);

        this.ps = ps;
        this.dialogPreference = dialogPreference;
        this.dropPreference = dropPreference;
    }

    /**
     * @see org.eclipse.jface.dialogs.MessageDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite) super.createDialogArea(parent);

        if (ps != null && dialogPreference != null && dialogPreference.length() > 0)
        {
            rememberChoice = new Button(container, SWT.CHECK);
            rememberChoice.setText("Do not ask again");
        }

        return container;
    }

    /**
     * @see org.eclipse.jface.window.Window#open()
     */
    public int open()
    {
        // Do not open the dialog if the preference is true
        if (ps != null && dialogPreference != null && dialogPreference.length() > 0 && ps.getBoolean(dialogPreference))
        {
            // and get the value from the dropPreference
            if (ps.getBoolean(dropPreference))
            {
                return Window.OK;
            }
            else
            {
                return Window.CANCEL;
            }
        }
        return super.open();
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
     */
    protected void buttonPressed(int buttonId)
    {
        // check box pressed
        if (rememberChoice.getSelection())
        {
            if (ps != null && dialogPreference != null && dialogPreference.length() > 0 
                    && dropPreference != null && dropPreference.length() > 0)
            {
                // Store both preferences
                ps.setValue(dialogPreference, true);
                ps.setValue(dropPreference, buttonId == Window.OK);
            }
        }
        super.buttonPressed(buttonId);
    }
}
