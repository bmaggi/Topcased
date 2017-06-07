/*****************************************************************************
 * 
 * MetamodelFiltersLabelProvider.java
 * 
 * Copyright (c) 2008 Atos Origin.
 *
 * Contributors:
 *  Thibault Landré (Atos Origin) thibault.landre@atosorigin.com
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
  *****************************************************************************/
package org.topcased.modeler.editor.outline.filters.actions;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * A label provider for metamodel filters
 */
public class MetamodelFiltersLabelProvider extends LabelProvider
{
    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    public String getText(Object element)
    {
        if (element instanceof String)
        {            
            String[] strings = ((String)element).split("\\."); //$NON-NLS-1$
            if(strings.length!=0)
            {
                return strings[strings.length-1];
            }
        }
        return super.getText(element);
    }
}
