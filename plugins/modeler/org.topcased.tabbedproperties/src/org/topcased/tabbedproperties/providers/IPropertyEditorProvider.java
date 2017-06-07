/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  eperico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.tabbedproperties.providers;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * IPropertyEditorProvider provides a specified property editor for a custom advanced property.
 */
public interface IPropertyEditorProvider
{
    
    /**
     * Gets the property editor.
     * 
     * @param composite the composite
     * @param labelProvider the label provider
     * @param object the object for which the class is a property source
     * @param createdBySuper the cellEditor created by super class
     * @param itemPropertyDescriptor the item property descriptor
     * 
     * @return the property editor
     */
    CellEditor getPropertyEditor(Composite composite, ILabelProvider labelProvider, IItemPropertyDescriptor itemPropertyDescriptor, Object object, CellEditor createdBySuper);
}
