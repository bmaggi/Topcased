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
package org.topcased.modeler.editor.properties.filters;

import org.eclipse.jface.viewers.IFilter;
import org.topcased.modeler.edit.NoteEditPart;

/**
 * A filter which is only active when a NoteEditPart is selected
 * 
 * @author Jacques LESCOT
 */
public class NoteFilter implements IFilter
{
    /**
     * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
     */
    public boolean select(Object toTest)
    {
        return toTest instanceof NoteEditPart;
    }
}
