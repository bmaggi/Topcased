/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (Atos Origin) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.editor.properties.filters;

import org.topcased.modeler.di.model.Diagram;

public class DiagramOutlineFilter extends DiagramFilter
{
    
    /**
     * Select.
     * 
     * @param toTest the to test
     * 
     * @return true, if select
     * 
     * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
     */
    @Override
    public boolean select(Object toTest)
    {
        return super.select(toTest) || toTest instanceof Diagram;
    }
}
