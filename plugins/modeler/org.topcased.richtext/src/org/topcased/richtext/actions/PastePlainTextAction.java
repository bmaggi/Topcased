package org.topcased.richtext.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextEditor;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextResources;
import org.topcased.richtext.common.utils.StrUtil;

public class PastePlainTextAction extends RichTextAction {
	
	/**
	 * Creates a new instance.
	 */
	public PastePlainTextAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(RichTextImages.IMG_DESC_PASTE_PLAIN_TEXT);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_PASTE_PLAIN_TEXT);
		setToolTipText(RichTextResources.pastePlainTextAction_toolTipText);
		setEnabled(true);
	}
	
	/**
	 * Returns <code>true</code> if this action should be disabled when the
	 * rich text editor is in source edit mode.
	 */
	public boolean disableInSourceMode() {
		return false;
	}
	
	public void execute(IRichText richText) {
		if (richText != null) {
			// get text from clipboard
			Clipboard clipboard = new Clipboard(Display.getCurrent());
			String text = (String) clipboard.getContents(TextTransfer
					.getInstance());
			if (text != null && text.length() > 0) {
				text = StrUtil.convertNewlinesToHTML(text);
				if (richText instanceof RichTextEditor) {
					((RichTextEditor)richText).addHTML(text);
				} else {
					richText.executeCommand(RichTextCommand.ADD_HTML, text);
				}
			}
		}
	}

}
