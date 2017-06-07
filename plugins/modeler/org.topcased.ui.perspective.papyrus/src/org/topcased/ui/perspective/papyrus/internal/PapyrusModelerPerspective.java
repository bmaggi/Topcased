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

package org.topcased.ui.perspective.papyrus.internal;

import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.papyrus.wizards.NewPapyrusProjectWizard;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.topcased.ui.perspective.papyrus.utils.PapyrusPerspectiveConstants;


/**
 * Papyrus Modeler Perspective
 */
public class PapyrusModelerPerspective implements IPerspectiveFactory {

	

	/**
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		addPerspectiveShortcuts(layout);
		defineActions(layout);
		defineLayout(layout);
	}

	/**
	 * Defines the initial actions for a page.
	 * 
	 * @param layout
	 *        the initial page layout
	 */
	public void defineActions(IPageLayout layout) {
		addNewWizardsShortcuts(layout);
	}

	/**
	 * Changes the page layout
	 * 
	 * @param layout
	 *        the initial page layout
	 */
	public void defineLayout(IPageLayout layout) {
		// Editors are placed for free.
		String editorArea = layout.getEditorArea();

		// Top Left
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, (float)0.26, editorArea); //$NON-NLS-1$
		topLeft.addView(PapyrusPerspectiveConstants.PROJECT_EXPLORER_VIEW_ID);
		topLeft.addView(PapyrusPerspectiveConstants.UPSTREAM_VIEW_ID);
		IViewLayout navigator = layout.getViewLayout(IPageLayout.ID_RES_NAV);
		navigator.setCloseable(false);
		{
			IFolderLayout folderLayout = layout.createFolder("folder", IPageLayout.BOTTOM, 0.5f, "topLeft"); //$NON-NLS-1$ //$NON-NLS-2$
			folderLayout.addView(PapyrusPerspectiveConstants.MODELEXPLORER_VIEW_ID);
			folderLayout.addView(PapyrusPerspectiveConstants.CURRENT_VIEW_ID);
		}
		IViewLayout outline = layout.getViewLayout(IPageLayout.ID_OUTLINE);
		outline.setCloseable(false);

		// Bottom
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float)0.66, editorArea); //$NON-NLS-1$
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(PapyrusPerspectiveConstants.DOC_VIEW_ID);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		IViewLayout properties = layout.getViewLayout(IPageLayout.ID_PROP_SHEET);
		properties.setCloseable(false);

	}

	/**
	 * add Shortcuts in New menu
	 * 
	 * @param layout
	 *        the initial page layout
	 */
	private void addNewWizardsShortcuts(IPageLayout layout) {
		layout.addNewWizardShortcut(PapyrusPerspectiveConstants.WIZARDS_CREATESYSMLPROJECT_ID);
		layout.addNewWizardShortcut(NewPapyrusProjectWizard.WIZARD_ID);
		layout.addNewWizardShortcut(PapyrusPerspectiveConstants.WIZARDS_CREATESYSMLMODEL_ID);
		layout.addNewWizardShortcut(CreateModelWizard.WIZARD_ID);

	}

	/**
	 * add shortcuts to the other topcased perspectives
	 * 
	 * @param layout
	 *        the initial page layout
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
		layout.addPerspectiveShortcut(PapyrusPerspectiveConstants.TOPCASED_MODELER_PERSPECTIVE_ID);
		layout.addPerspectiveShortcut(PapyrusPerspectiveConstants.TOPCASED_AUI_PERSPECTIVE_ID);
		layout.addPerspectiveShortcut(PapyrusPerspectiveConstants.TOPCASED_SAM_PERSPECTIVE_ID);
	}
}
