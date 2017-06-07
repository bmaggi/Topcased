/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.outline.filters.actions;

import org.eclipse.jface.viewers.LabelProvider;
import org.topcased.modeler.extensions.OutlineManager.FilterConfiguration;

/**
 * A label provider for outline filters. <br>
 * Creation : 2 déc. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class FiltersLabelProvider extends LabelProvider
{
    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    public String getText(Object element)
    {
        if (element instanceof FilterConfiguration)
        {
            return ((FilterConfiguration) element).getName();
        }

        return super.getText(element);
    }
}
