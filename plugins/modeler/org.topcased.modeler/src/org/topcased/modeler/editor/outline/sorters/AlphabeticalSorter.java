/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.outline.sorters;

import org.eclipse.jface.viewers.ViewerSorter;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.outline.AdditionalResources;

/**
 * A sorter that simply sort outline elements in an alphabetical order but the
 * 'Additionnal resources' and the 'Diagram' elements are always at the end.
 * <br>
 * Creation : 8 déc. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class AlphabeticalSorter extends ViewerSorter
{

    /**
     * @see org.eclipse.jface.viewers.ViewerSorter#category(java.lang.Object)
     */
    public int category(Object element)
    {
        if (element instanceof Diagram)
        {
            return 1;
        }
        if (element instanceof AdditionalResources)
        {
            return 2;
        }

        return 0;
    }

}
