/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anass Radouani (Atos)
 *
 *****************************************************************************/

package org.topcased.ui.perspective.papyrus.utils;

import java.util.Properties;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;

/**
 * Action to Switch to TOPCASED UML/SysML Perspective
 */
public class SwitchPerspectivePapyrus implements IIntroAction {

	public void run(IIntroSite site, Properties params) {
		IWorkbenchWindow dw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = dw.getActivePage();

		page.setPerspective(dw.getWorkbench().getPerspectiveRegistry().findPerspectiveWithId(PapyrusPerspectiveConstants.PAPYRUS_MODELER_PERSPECTIVE_ID));
	}

}
