/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * A JFace dialog used to ask a confirmation to the end user.<br>
 * This dialog is able to store the user choice into a preference store.<br>
 * 
 * Creation : 12 déc. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 * @author <a href="mailto:maxime.leray@anyware-tech.com">Maxime Leray</a>
 */
public class ConfirmationDialog extends MessageDialog
{
    private static final int WINDOW_HEIGHT = 300;
    
    protected IPreferenceStore ps;

    protected String preference;

    protected Button rememberChoice;

    /**
     * @param parentShell
     * @param dialogTitle
     * @param message
     * @param ps
     * @param preference
     */
    public ConfirmationDialog(Shell parentShell, String dialogTitle, String message, IPreferenceStore ps, String preference)
    {
        super(parentShell, dialogTitle, null, message, MessageDialog.QUESTION, new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}, Window.OK);

        this.ps = ps;
        this.preference = preference;
    }

    /**
     * @see org.eclipse.jface.dialogs.MessageDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite) getContainer(parent);

        createRememberButton(container);

        return container;
    }

    protected Control getContainer(Composite parent)
    {
        return super.createDialogArea(parent);
    }

    protected void createRememberButton(Composite parent)
    {
        if (ps != null && preference != null && preference.length() > 0)
        {
            rememberChoice = new Button(parent, SWT.CHECK);
            rememberChoice.setText("Do not ask again");
        }
    }
    
    /**
     * @see org.eclipse.jface.dialogs.IconAndMessageDialog#createMessageArea(org.eclipse.swt.widgets.Composite)
     * Add Scrollbar on message label if necessary
     */
    @Override
    protected Control createMessageArea(Composite composite)
    {
        super.createMessageArea(composite);
        int width = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
        int currentHeight = messageLabel.computeSize(width, SWT.DEFAULT).y;
        if (message != null && messageLabel != null && currentHeight > WINDOW_HEIGHT)
        {
            messageLabel.dispose();
            ScrolledComposite sc = new ScrolledComposite(composite, SWT.V_SCROLL);
            sc.setAlwaysShowScrollBars(false);
            sc.setExpandHorizontal(true);
            sc.setExpandVertical(true);
            GridData gd = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
            gd.widthHint = width;
            gd.heightHint = WINDOW_HEIGHT;
            // create message
            messageLabel = new Label(sc, getMessageLabelStyle());
            messageLabel.setText(message);
            GridData gd2 = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
            gd2.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
            messageLabel.setLayoutData(gd2);
            sc.setContent(messageLabel);
            Point size = messageLabel.computeSize(width, SWT.DEFAULT);
            sc.setMinSize(size);
            sc.setLayoutData(gd);
        }
        return composite;
    }

    /**
     * @see org.eclipse.jface.window.Window#open()
     */
    public int open()
    {
        // Do not open the dialog if the preference is true
        if (ps != null && preference != null && preference.length() > 0)
        {
            if (ps.getBoolean(preference))
            {
                return Window.OK;
            }
        }

        return super.open();
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
     */
    protected void buttonPressed(int buttonId)
    {
        // OK pressed
        if (buttonId == Window.OK && rememberChoice.getSelection())
        {
            if (ps != null && preference != null && preference.length() > 0)
            {
                // Store the preference
                ps.setValue(preference, true);
            }
        }
        super.buttonPressed(buttonId);
    }
}
