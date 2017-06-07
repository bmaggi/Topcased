/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.editor.palette;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * A ConnectionCreationToolEntry proper to our Editors. It is associated with a custom
 * ConnectionCreationTool.
 */
public class ModelerConnectionCreationToolEntry extends ConnectionCreationToolEntry
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
    public ModelerConnectionCreationToolEntry(String label, String shortDesc, CreationFactory factory, ImageDescriptor iconSmall,
            ImageDescriptor iconLarge)
    {
        super(label, shortDesc, factory, iconSmall, iconLarge);
    }

    public Tool createTool()
    {
        Tool tool = new ModelerConnectionCreationTool();
        tool.setProperties(getToolProperties());
        return tool;
    }
}
