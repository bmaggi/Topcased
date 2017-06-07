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
 *  Vincent Hemery (Atos Origin) {vincent.hemery@atosorigin.com} - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.scripting.topcased.getter;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.scripting.ISelectionGetter;

/**
 * Get the selected model element from a Topcased EMFGraphNodeEditPart
 * 
 * @author vhemery
 */
public class GetSelectionFromEMFGraphNode implements ISelectionGetter
{
    /**
     * Returns the currently selected model element from an EMFGraphNodeEditPart
     * 
     * @param element the first object in editor selection (EMFGraphNodeEditPart expected)
     * @return the currently selected model element or null.
     */
    public EObject getSelection(Object element)
    {
        if (element instanceof EMFGraphNodeEditPart)
        {
            return ((EMFGraphNodeEditPart) element).getEObject();
        }
        return null;
    }

}
