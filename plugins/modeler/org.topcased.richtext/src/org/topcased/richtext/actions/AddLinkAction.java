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
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextResources;
import org.topcased.richtext.dialogs.AddLinkDialog;

/**
 * Adds a link to a rich text control.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public class AddLinkAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public AddLinkAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_DESC_ADD_LINK);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_ADD_LINK);
		setToolTipText(RichTextResources.addLinkAction_toolTipText); 
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText) {
		if (richText != null) {
			AddLinkDialog dialog = new AddLinkDialog(Display.getCurrent()
					.getActiveShell(), richText.getBasePath());
			dialog.open();
			if (dialog.getReturnCode() == Window.OK) {
				String linkURL = dialog.getLink().getURL();
				if (linkURL.length() > 0) {
					richText.executeCommand(RichTextCommand.ADD_LINK, linkURL);
				}
			}
		}
	}
	
	public boolean disableInSourceMode() {
		return false;
	}

}