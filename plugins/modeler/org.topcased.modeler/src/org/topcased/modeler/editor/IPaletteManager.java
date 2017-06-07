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
package org.topcased.modeler.editor;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.palette.PaletteRoot;

/**
 * This interface offers palette management and updates its contents with the
 * currently edited diagram <br>
 * creation : 8 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public interface IPaletteManager
{

    /**
     * Returns the current palette root
     * 
     * @return the palette root
     */
    PaletteRoot getRoot();

    /**
     * Creates or updates the palette contents
     */
    void updatePalette();
    
    /**
     * Returns the current marquee to fit the selection to behavior
     * @return the current marquee
     */
    DragTracker getMarqueeDragTracker();
}
