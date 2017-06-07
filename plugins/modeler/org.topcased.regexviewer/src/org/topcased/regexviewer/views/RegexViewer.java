/*****************************************************************************
 * Copyright (c) 2008 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.regexviewer.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class RegexViewer extends ViewPart {

	private RegexViewerComposite regexViewerComposite;

	/**
	 * The constructor.
	 */
	public RegexViewer() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 * 
	 * @param parent
	 *            the parent
	 */
	public void createPartControl(Composite parent) {
		regexViewerComposite = new RegexViewerComposite(parent, SWT.NONE,
				RegexViewerComposite.MATCH | RegexViewerComposite.SPLIT
						| RegexViewerComposite.GROUP);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		if (regexViewerComposite != null) {
			regexViewerComposite.setFocus();
		}
	}
}