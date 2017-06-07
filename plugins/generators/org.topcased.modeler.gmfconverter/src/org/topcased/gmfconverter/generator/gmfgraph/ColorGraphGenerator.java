/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter.generator.gmfgraph;

import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.swt.graphics.Color;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;

/**
 * @author Nicolas
 */
public class ColorGraphGenerator extends ObjectGenerator<Color>
{

    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    public <G> G createGMFObject(Color topCasedObject, Class<G> gmfClass) throws GeneratorException
    {
        if (!gmfClass.equals(org.eclipse.gmf.gmfgraph.Color.class))
        {
            throw new GeneratorException("gmfClass must be a org.eclipse.gmf.gmfgraph.Color.");
        }
        RGBColor rgbColor = GMFGraphFactory.eINSTANCE.createRGBColor();
        rgbColor.setBlue(topCasedObject.getBlue());
        rgbColor.setRed(topCasedObject.getRed());
        rgbColor.setGreen(topCasedObject.getGreen());
        return (G) rgbColor;
    }

}
