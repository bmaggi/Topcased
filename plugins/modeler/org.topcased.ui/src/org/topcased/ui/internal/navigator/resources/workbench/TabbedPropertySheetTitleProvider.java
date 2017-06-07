/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.topcased.ui.internal.navigator.resources.workbench;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.topcased.ui.internal.Activator;

/**
 * Code copied from org.eclipse.ui.navigator.resources plugin
 * 
 * Defines a label provider for the title bar in the tabbed properties view.
 * 
 * @since 3.2
 */
public class TabbedPropertySheetTitleProvider extends LabelProvider
{

    private ILabelProvider labelProvider;

    private IDescriptionProvider descriptionProvider;

    /**
     * Constructor for CommonNavigatorTitleProvider.
     */
    public TabbedPropertySheetTitleProvider()
    {
        super();
        IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();

        INavigatorContentService contentService = (INavigatorContentService) part.getAdapter(INavigatorContentService.class);

        if (contentService != null)
        {
            labelProvider = contentService.createCommonLabelProvider();
            descriptionProvider = contentService.createCommonDescriptionProvider();
        }
        else
        {
            Activator.log("Could not acquire INavigatorContentService from part (\"" //$NON-NLS-1$
                    + part.getTitle() + "\").", null); //$NON-NLS-1$
        }
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
     */
    @Override
    public Image getImage(Object object)
    {
        return labelProvider != null ? labelProvider.getImage(object) : null;
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object object)
    {
        return descriptionProvider != null ? descriptionProvider.getDescription(object) : null;
    }
}
