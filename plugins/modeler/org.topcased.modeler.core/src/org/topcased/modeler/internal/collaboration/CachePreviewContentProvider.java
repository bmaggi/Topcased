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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A content provider for the cache preview page shown on model export, which distinguishes the different categories of
 * elements put in the cache.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class CachePreviewContentProvider implements ITreeContentProvider
{
    public static final Object CATEGORY_STRICT = new Object();

    public static final Object CATEGORY_SEMANTIC = new Object();

    public static final Object CATEGORY_USER = new Object();

    private final ITreeContentProvider wrappedProvider;

    private CacheContentsSpecification input;

    public CachePreviewContentProvider(ITreeContentProvider wrappedProvider)
    {
        super();
        this.wrappedProvider = wrappedProvider;
    }

    public void dispose()
    {
        wrappedProvider.dispose();
    }

    public Object[] getChildren(Object parentElement)
    {
        if (input != null && parentElement == CATEGORY_STRICT)
        {
            return input.getStrictDependencies().toArray();
        }
        else if (input != null && parentElement == CATEGORY_SEMANTIC)
        {
            return input.getSemanticDependencies().toArray();
        }
        else if (input != null && parentElement == CATEGORY_USER)
        {
            return input.getUserElements().toArray();
        }
        else
        {
            return wrappedProvider.getChildren(parentElement);
        }
    }

    public Object[] getElements(Object inputElement)
    {
        if (inputElement instanceof CacheContentsSpecification)
        {
            return new Object[] {CATEGORY_STRICT, CATEGORY_SEMANTIC, CATEGORY_USER};
        }
        else
        {
            // return new Object[0];
            return wrappedProvider.getElements(inputElement);
        }
    }

    public Object getParent(Object element)
    {
        if (input != null && input.getStrictDependencies().contains(element))
        {
            return CATEGORY_STRICT;
        }
        else if (input != null && input.getSemanticDependencies().contains(element))
        {
            return CATEGORY_SEMANTIC;
        }
        else if (input != null && input.getUserElements().contains(element))
        {
            return CATEGORY_USER;
        }
        else
        {
            return wrappedProvider.getParent(element);
        }
    }

    public boolean hasChildren(Object element)
    {
        if (element == input)
        {
            return true;
        }
        else if (input != null && element == CATEGORY_STRICT)
        {
            return !input.getStrictDependencies().isEmpty();
        }
        else if (input != null && element == CATEGORY_SEMANTIC)
        {
            return !input.getSemanticDependencies().isEmpty();
        }
        else if (input != null && element == CATEGORY_USER)
        {
            return !input.getUserElements().isEmpty();
        }
        return wrappedProvider.hasChildren(element);
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
        if (newInput instanceof CacheContentsSpecification)
        {
            input = (CacheContentsSpecification) newInput;
        }
        else
        {
            input = null;
        }
        wrappedProvider.inputChanged(viewer, oldInput, newInput);
    }
}
