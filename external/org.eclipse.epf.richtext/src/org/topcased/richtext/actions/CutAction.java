//------------------------------------------------------------------------------
// Copyright (c) 2005, 2006 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.topcased.richtext.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.StyledText;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextEditor;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextResources;

/**
 * Cuts the selected text in the rich text control to the clipboard.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public class CutAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public CutAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_DESC_CUT);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_CUT);
		setToolTipText(RichTextResources.cutAction_toolTipText); 
	}

	/**
	 * Returns <code>true</code> if this action should be disabled when the
	 * rich text editor is in source edit mode.
	 */
	public boolean disableInSourceMode() {
		return false;
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText) {
		if (richText != null) {
			if (richText instanceof RichTextEditor
					&& ((RichTextEditor) richText).isHTMLTabSelected()) {
				StyledText styledText = ((RichTextEditor) richText)
						.getSourceEdit();
				styledText.cut();
			} else {
				richText.setCopyURL();
				richText.executeCommand(RichTextCommand.CUT);
			}
		}
	}
}