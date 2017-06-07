/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;

/**
 * This factory converts EditParts into model objects
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EditPart2ModelAdapterFactory implements IAdapterFactory
{
    private Class< ? > adaptable;

    private Class< ? > adapter;

    /**
     * Constructor
     * 
     * @param adaptableClass
     * @param adapterType
     */
    public EditPart2ModelAdapterFactory(Class< ? > adaptableClass, Class< ? > adapterType)
    {
        this.adaptable = adaptableClass;
        this.adapter = adapterType;
    }

    /**
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
     */
    public Object getAdapter(Object adaptableObject, Class adapterType)
    {
        if (adaptable.isInstance(adaptableObject) && adapterType == adapter)
        {
            if (adaptableObject instanceof EMFGraphNodeEditPart)
            {
                return ((EMFGraphNodeEditPart) adaptableObject).getEObject();
            }

            if (adaptableObject instanceof EMFGraphEdgeEditPart)
            {
                return ((EMFGraphEdgeEditPart) adaptableObject).getEObject();
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
     */
    public Class< ? >[] getAdapterList()
    {
        return new Class[] {adapter};
    }

}
