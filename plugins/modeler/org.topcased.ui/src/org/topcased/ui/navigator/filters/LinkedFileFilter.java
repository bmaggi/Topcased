/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 **********************************************************************/
package org.topcased.ui.navigator.filters;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * A custom Filter used to hide Linked resources
 */
public class LinkedFileFilter extends ViewerFilter
{

    /**
     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element)
    {
        if (element instanceof IFile) {
            return !((IFile) element).isLinked();
        }
        return true;
    }

}
