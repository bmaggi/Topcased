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

import org.eclipse.gef.SharedImages;
import org.eclipse.gef.palette.ToolEntry;

/**
 * Tool that does not select objects contained in already selected objects
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ExtMarqueeToolEntry extends ToolEntry
{

    /**
     * Creates a new MarqueeToolEntry that can select nodes
     */
    public ExtMarqueeToolEntry()
    {
        this(null, null);
    }

    /**
     * Constructor for MarqueeToolEntry.
     * 
     * @param label the label
     */
    public ExtMarqueeToolEntry(String label)
    {
        this(label, null);
    }

    /**
     * Constructor for MarqueeToolEntry.
     * 
     * @param label the label; can be <code>null</code>
     * @param description the description (can be <code>null</code>)
     */
    public ExtMarqueeToolEntry(String label, String description)
    {
        super(label, description, SharedImages.DESC_MARQUEE_TOOL_16, SharedImages.DESC_MARQUEE_TOOL_24,
                ExtMarqueeSelectionTool.class);
        if (label == null || label.length() == 0)
        {
            setLabel("Inner Marquee");
        }
        setUserModificationPermission(PERMISSION_NO_MODIFICATION);
    }

    /**
     * @see org.eclipse.gef.palette.PaletteEntry#getDescription()
     */
    public String getDescription()
    {
        return "Marquee that selects direct child objects";
    }

}
