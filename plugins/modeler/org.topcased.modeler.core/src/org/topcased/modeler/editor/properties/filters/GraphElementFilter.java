/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.filters;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.IFilter;
import org.topcased.modeler.di.model.GraphElement;

/**
 * A Filter that check if the selected Element is a GraphElement
 * 
 * Creation 31 mars 2006
 * 
 * @author jlescot
 */
public class GraphElementFilter implements IFilter
{
    /**
     * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
     */
    public boolean select(Object toTest)
    {
        return toTest instanceof EditPart && ((EditPart) toTest).getModel() instanceof GraphElement;
    }

}
