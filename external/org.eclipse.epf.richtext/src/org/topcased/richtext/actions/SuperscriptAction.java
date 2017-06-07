//------------------------------------------------------------------------------
// Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * Toggles the superscript attribute of the selected text in a rich text
 * control.
 * 
 * @author Kelvin Low
 * @author Jeff Hardy
 * @since 1.0
 */
public class SuperscriptAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public SuperscriptAction(final IRichText richText) {
		super(richText, IAction.AS_CHECK_BOX);
		setImageDescriptor(RichTextImages.IMG_DESC_SUPERSCRIPT);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_SUPERSCRIPT);
		setToolTipText(RichTextResources.superscriptAction_toolTipText);
		// add listener
		richText.addListener(SWT.SELECTED, new Listener() {
			public void handleEvent(Event event) {
				setChecked(richText.getSelected().isSuperscript());
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
			richText.executeCommand(RichTextCommand.SUPERSCRIPT);
		}
	}
}
