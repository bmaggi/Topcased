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
package org.topcased.modeler;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;


/**
 * This registry manages all the allocated colors and dispose its when the
 * current display is disposed. <br>
 * now process is delegated to JFace Color Registry
 * <br>
 * creation : 8 oct. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public final class ColorRegistry extends org.eclipse.jface.resource.ColorRegistry
{
    private static org.eclipse.jface.resource.ColorRegistry instance = JFaceResources.getColorRegistry();
    public static org.eclipse.jface.resource.ColorRegistry getInstance()
    {
        return instance;
    }



    /**
     * Returns the <code>color</code> associated with the given symbolic color
     * name, or <code>null</code> if no such definition exists.
     * 
     * @param symbolicName symbolic color name
     * @return the <code>Color</code> or <code>null</code>
     */
    public Color get(String symbolicName)
    {
        return super.get(symbolicName);
    }

    /**
     * Returns the <code>color</code> associated with the given RGB object, or
     * <code>null</code> if no such definition exists.
     * 
     * @param rgb the rgb color
     * @return the <code>Color</code> or <code>null</code>
     */
    public Color get(RGB rgb)
    {
        if (rgb == null)
        {
            return null;
        }

        String symbolicName = StringConverter.asString(rgb);
        Color color = super.get(symbolicName);

        return color;
    }
    
    public static Color getColor(RGB rgb)
    {
        String asString = StringConverter.asString(rgb);
        Color c = JFaceResources.getColorRegistry().get(asString);
        if (c == null)
        {
            JFaceResources.getColorRegistry().put(asString,rgb);
            c = JFaceResources.getColorRegistry().get(asString);
        }
        return c;
    }
}