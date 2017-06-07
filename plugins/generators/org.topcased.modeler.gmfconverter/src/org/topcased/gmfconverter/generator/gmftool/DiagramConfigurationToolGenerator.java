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
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfmap.MapRegistry;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;

/**
 * 
 */
public class DiagramConfigurationToolGenerator extends ObjectGenerator<DiagramConfiguration>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(DiagramConfiguration diagramConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (!ToolRegistry.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a ToolRegistry.");
        }
        ToolRegistry toolRegistry = GMFToolFactory.eINSTANCE.createToolRegistry();
        Palette palette = getInstance(PaletteConfigurationToolGenerator.class).createGMFObject(diagramConfiguration.getPalette(), Palette.class);
        toolRegistry.setPalette(palette);
        MapRegistry.setToolRegistry(toolRegistry);
        return (G) toolRegistry;
    }
}
