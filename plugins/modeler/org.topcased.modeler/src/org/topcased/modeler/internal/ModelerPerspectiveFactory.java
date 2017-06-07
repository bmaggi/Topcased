/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal;

import org.eclipse.papyrus.documentation.view.DocView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;

/**
 * Creates the Topcased perspective
 * <br>
 * creation : 3 avr. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ModelerPerspectiveFactory implements IPerspectiveFactory
{

    /**
     * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
     */
    public void createInitialLayout(IPageLayout layout)
    {
        defineActions(layout);
        defineLayout(layout);
    }

    /**
     * Defines the initial actions for a page.
     * 
     * @param layout the initial page layout
     */
    public void defineActions(IPageLayout layout)
    {
        layout.addShowViewShortcut(DocView.VIEW_ID);
    }

    /**
     * Changes the page layout
     * 
     * @param layout the initial page layout
     */
    public void defineLayout(IPageLayout layout)
    {

        // Editors are placed for free.
        String editorArea = layout.getEditorArea();

        // Top Left
        IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, (float) 0.26, editorArea); //$NON-NLS-1$
        topLeft.addView(IPageLayout.ID_RES_NAV);
        topLeft.addView("org.topcased.ui.navigator.view"); //$NON-NLS-1$
        IViewLayout navigator = layout.getViewLayout(IPageLayout.ID_RES_NAV);
        navigator.setCloseable(false);

        // Bottom Left
        layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, (float) 0.50, "topLeft"); //$NON-NLS-1$
        IViewLayout outline = layout.getViewLayout(IPageLayout.ID_OUTLINE);
        outline.setCloseable(false);
        
        // Bottom
        IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.66, editorArea); //$NON-NLS-1$
        bottom.addView(IPageLayout.ID_PROP_SHEET);
        bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
        IViewLayout properties = layout.getViewLayout(IPageLayout.ID_PROP_SHEET);
        properties.setCloseable(false);

        // Bottom Right
        layout.addView(DocView.VIEW_ID, IPageLayout.RIGHT, (float) 0.50, "bottom"); //$NON-NLS-1$

    }

}
