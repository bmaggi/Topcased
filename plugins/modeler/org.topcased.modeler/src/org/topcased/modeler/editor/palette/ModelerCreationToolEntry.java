/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/

package org.topcased.modeler.editor.palette;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * A CreationToolEntry proper to our Editors. It is associated with a custom
 * CreationTool.
 * 
 * Creation : 13 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerCreationToolEntry extends CreationToolEntry
{
    /**
     * The Constructor
     * 
     * @param label
     * @param shortDesc
     * @param factory
     * @param iconSmall
     * @param iconLarge
     */
    public ModelerCreationToolEntry(String label, String shortDesc, CreationFactory factory, ImageDescriptor iconSmall,
            ImageDescriptor iconLarge)
    {
        super(label, shortDesc, factory, iconSmall, iconLarge);
    }

    /**
     * @see org.eclipse.gef.palette.ToolEntry#createTool()
     */
    public Tool createTool()
    {
        Tool tool = new ModelerCreationTool();
        tool.setProperties(getToolProperties());
        return tool;
    }
}
