/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (ATOS ORIGIN INTEGRATION) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.dialogs;

import org.eclipse.emf.common.ui.DiagnosticComposite;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * This dialog adds a cancel button to the original Diagnostic Dialog
 * @author mvelten
 *
 */
public class DiagnosticCancelDialog extends DiagnosticDialog {

	/**
	 * {@link org.eclipse.emf.common.ui.dialogs.DiagnosticDialog#open(Shell parentShell, String title, String message, Diagnostic diagnostic, int displayMask)}
	 */
	public static int open(Shell parentShell, String title, String message, Diagnostic diagnostic, int displayMask)
	{
		DiagnosticCancelDialog dialog = new DiagnosticCancelDialog(parentShell, title, message, diagnostic, displayMask);
		return dialog.open();
	}

	/**
	 * {@link org.eclipse.emf.common.ui.dialogs.DiagnosticDialog#open(Shell parent, String dialogTitle, String message, Diagnostic diagnostic)}
	 */
	public static int open(Shell parent, String dialogTitle, String message, Diagnostic diagnostic)
	{
		return open(parent, dialogTitle, message, diagnostic, Diagnostic.OK | Diagnostic.INFO | Diagnostic.WARNING | Diagnostic.ERROR);
	}

	/**
	 * {@link org.eclipse.emf.common.ui.dialogs.DiagnosticDialog#openProblem(Shell parent, String dialogTitle, String message, Diagnostic diagnostic)}
	 */
	public static int openProblem(Shell parent, String dialogTitle, String message, Diagnostic diagnostic)
	{
		return open(parent, dialogTitle, message, diagnostic, DiagnosticComposite.ERROR_WARNING_MASK);
	}

	/**
	 * {@link org.eclipse.emf.common.ui.dialogs.DiagnosticDialog#DiagnosticDialog(Shell parentShell, String dialogTitle, String message, Diagnostic diagnostic, int severityMask)}
	 */
	public DiagnosticCancelDialog(Shell parentShell, String dialogTitle,
			String message, Diagnostic diagnostic, int severityMask) {
		super(parentShell, dialogTitle, message, diagnostic, severityMask);

	}

	/**
	 * {@link org.eclipse.emf.common.ui.dialogs.DiagnosticDialog#createButtonsForButtonBar(Composite parent)}
	 */
	protected void createButtonsForButtonBar(Composite parent)
	{
		// create OK, Details and Cancel buttons
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		createDetailsButton(parent);
	}
}
