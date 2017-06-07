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
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.scripting.ISelectionGetter;

/**
 * Get the selected model element from a Topcased DiagramEditPart
 * 
 * @author vhemery
 */
public class GetSelectionFromDiagram implements ISelectionGetter
{

    /**
     * Returns the currently selected model element from a DiagramEditPart
     * 
     * @param element the first object in editor selection (DiagramEditPart expected)
     * @return the currently selected model element or null.
     */
    public EObject getSelection(Object element)
    {
        if (element instanceof DiagramEditPart)
        {
            return (EObject) ((DiagramEditPart) element).getModel();
        }
        return null;
    }

}
