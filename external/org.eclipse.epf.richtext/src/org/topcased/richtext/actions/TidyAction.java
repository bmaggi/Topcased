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

import java.io.UnsupportedEncodingException;

import org.eclipse.jface.action.IAction;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextEditor;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.RichTextPlugin;
import org.topcased.richtext.common.html.HTMLFormatter;

/**
 * Runs JTidy on the HTML
 * 
 * @author Jeff Hardy
 * @since 1.2
 */
public class TidyAction extends RichTextAction {
	
	boolean forceOutput = false;
	boolean makeBare = false;
	boolean word2000 = false;
	
	// The HTML source formatter.
	protected HTMLFormatter htmlFormatter;

	

	/**
	 * Creates a new instance.
	 */
	public TidyAction(IRichText richText, boolean forceOutput, boolean makeBare, boolean word2000) {
		super(richText, IAction.AS_PUSH_BUTTON);
		this.forceOutput = forceOutput;
		this.makeBare = makeBare;
		this.word2000 = word2000;
		setImageDescriptor(RichTextImages.IMG_DESC_TIDY);
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_TIDY);
		htmlFormatter = new HTMLFormatter();
	}
	
	@Override
	public void execute(IRichText richText) {
		// get current text
		String html;
		if (richText instanceof RichTextEditor) {
			html = ((RichTextEditor)richText).getText();
		} else {
			html = richText.getText();
		}
		// call JTidy with the options
		try {
			html = htmlFormatter.formatHTML(html, false, forceOutput, makeBare, word2000);
		} catch (UnsupportedEncodingException e) {
			RichTextPlugin.getDefault().getLogger().logError(e);
		}
		// set text
		if (richText instanceof RichTextEditor) {
			((RichTextEditor)richText).setText(html);
		} else {
			richText.setText(html);
		}
		richText.checkModify();
		
	}
	
	@Override
	public boolean disableInSourceMode() {
		return false;
	}
}
