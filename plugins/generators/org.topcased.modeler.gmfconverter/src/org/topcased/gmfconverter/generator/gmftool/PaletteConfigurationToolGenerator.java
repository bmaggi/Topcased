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

package org.topcased.gmfconverter.generator.gmftool;

import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.Palette;
import org.eclipse.gmf.tooldef.ToolGroup;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteConfiguration;

/**
 * @author Nicolas
 */
public class PaletteConfigurationToolGenerator extends ObjectGenerator<PaletteConfiguration>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(PaletteConfiguration paletteConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (!Palette.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a Palette");
        }
        Palette palette = GMFToolFactory.eINSTANCE.createPalette();
        palette.setTitle(paletteConfiguration.getName());
        for (PaletteCategory paletteCat : paletteConfiguration.getPaletteCategories())
        {
            ToolGroup toolGroup = getInstance(PaletteCategoryToolGenerator.class).createGMFObject(paletteCat, ToolGroup.class);
            toolGroup.setTitle(paletteCat.getName());
            palette.getTools().add(toolGroup);
        }

        return (G) palette;
    }

}
