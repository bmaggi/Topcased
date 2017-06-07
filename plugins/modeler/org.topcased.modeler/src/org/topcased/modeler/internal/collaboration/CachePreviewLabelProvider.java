/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * A custom label provider to use with {@link CachePreviewContentProvider}, adding appropriate labels and icons for the
 * different cache elements categories.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class CachePreviewLabelProvider implements ILabelProvider
{
    private static final Image CATEGORY_USER_ICON = ModelerImageRegistry.getImage("USER_ELEMENTS");

    private static final Image CATEGORY_SEMANTIC_ICON = ModelerImageRegistry.getImage("SEMANTIC_DEPENDENCIES");

    private static final Image CATEGORY_STRICT_ICON = ModelerImageRegistry.getImage("STRICT_DEPENDENCIES");

    private final ILabelProvider wrappedProvider;

    public CachePreviewLabelProvider(ILabelProvider wrappedProvider)
    {
        this.wrappedProvider = wrappedProvider;
    }

    public void addListener(ILabelProviderListener listener)
    {
        wrappedProvider.addListener(listener);
    }

    public void dispose()
    {
        wrappedProvider.dispose();
    }

    public boolean isLabelProperty(Object element, String property)
    {
        return wrappedProvider.isLabelProperty(element, property);
    }

    public void removeListener(ILabelProviderListener listener)
    {
        wrappedProvider.removeListener(listener);
    }

    public Image getImage(Object element)
    {
        if (element == CachePreviewContentProvider.CATEGORY_STRICT)
        {
            return CATEGORY_STRICT_ICON;
        }
        else if (element == CachePreviewContentProvider.CATEGORY_SEMANTIC)
        {
            return CATEGORY_SEMANTIC_ICON;
        }
        else if (element == CachePreviewContentProvider.CATEGORY_USER)
        {
            return CATEGORY_USER_ICON;
        }
        else
        {
            return wrappedProvider.getImage(element);
        }
    }

    public String getText(Object element)
    {
        if (element == CachePreviewContentProvider.CATEGORY_STRICT)
        {
            return "Strict dependencies";
        }
        else if (element == CachePreviewContentProvider.CATEGORY_SEMANTIC)
        {
            return "Semantic dependencies";
        }
        else if (element == CachePreviewContentProvider.CATEGORY_USER)
        {
            return "User elements";
        }
        else
        {
            return wrappedProvider.getText(element);
        }
    }
}
