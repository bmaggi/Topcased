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

import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.ToolGroup;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteItem;

/**
 * @author Nicolas
 */
public class PaletteCategoryToolGenerator extends ObjectGenerator<PaletteCategory>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(PaletteCategory paletteCategory, Class<G> gmfClass) throws GeneratorException
    {
        if (!ToolGroup.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a ToolGroup");
        }
        ToolGroup toolGroup = GMFToolFactory.eINSTANCE.createToolGroup();
        toolGroup.setTitle(paletteCategory.getName());
        for (PaletteItem item : paletteCategory.getItems())
        {
            CreationTool creationTool = getInstance(PaletteItemToolGenerator.class).createGMFObject(item, CreationTool.class);
            toolGroup.getTools().add(creationTool);
        }
        return (G) toolGroup;
    }

}
