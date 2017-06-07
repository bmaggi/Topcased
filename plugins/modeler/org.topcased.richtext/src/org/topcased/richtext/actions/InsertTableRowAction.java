//------------------------------------------------------------------------------
// Copyright (c) 2009 Anyware Technologies and others
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
//      Anyware Technologies - initial API and implementation
//------------------------------------------------------------------------------
package org.topcased.richtext.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextResources;
import org.topcased.richtext.actions.RichTextAction;

/**
 * Insert a row to the selected table in the rich text control.
 * 
 * @author Jose Alfredo Serrano (Anyware Technologies)
 * @author Jacques LESCOT (Anyware Technologies)
 */
public class InsertTableRowAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public InsertTableRowAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_DESC_INSERT_TABLE_ROW);
		setToolTipText(RichTextResources.insertTableRowAction_toolTipText);
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText) {
		if (richText != null) {
			Shell parent = Display.getCurrent().getActiveShell();
			InputDialog dialog = new InputDialog(parent, RichTextResources.insertTableRow_title, RichTextResources.insertTableRow_text, "0", new NumberValidator()); //$NON-NLS-1$
			if (dialog.open() == Window.OK) {
				richText.executeCommand(RichTextCommand.INSERT_TABLE_ROW, dialog.getValue());
			}
		}
	}

}