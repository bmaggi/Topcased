//------------------------------------------------------------------------------
// Copyright (c) 2009 Anyware Technologies and others
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// 		Anyware Technologies - implementation
//------------------------------------------------------------------------------
package org.topcased.richtext.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextResources;

/**
 * Set the color attribute of the selected text in a rich text control.
 * 
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo Serrano</a>
 */
public class TextColorAction extends RichTextAction
{

	private String command = RichTextCommand.FORGROUND_COLOR;
	
	/**
	 * Creates a new instance.
	 */
	public TextColorAction(final IRichText richText)
	{
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_DESC_TEXTCOLOR);
		setToolTipText(RichTextResources.textColorAction_toolTipText); 
	}
	
	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText)
	{
		if (richText != null)
		{
			ColorDialog dialog = new ColorDialog(Display.getCurrent().getActiveShell());
			RGB color = dialog.open();
			if (color != null)
			{
				String rgb = "RGB(" + color.red + "," + color.green + "," + color.blue + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				richText.executeCommand(command, rgb);
			}
		}
	}
}
