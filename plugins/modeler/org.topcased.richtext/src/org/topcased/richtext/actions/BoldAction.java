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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextResources;

/**
 * Toggles the 'bold' attribute of the selected text in a rich text control.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public class BoldAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public BoldAction(final IRichText richText) {
		super(richText, IAction.AS_CHECK_BOX);
		setImageDescriptor(RichTextImages.IMG_DESC_BOLD);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_BOLD);
		setToolTipText(RichTextResources.boldAction_toolTipText); 
		// add listener
		richText.addListener(SWT.SELECTED, new Listener() {
			public void handleEvent(Event event) {
				setChecked(richText.getSelected().isBold());
			}
		});
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText) {
		if (richText != null) {
			richText.executeCommand(RichTextCommand.BOLD);
		}
	}
}
