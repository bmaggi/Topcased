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
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfmap.MapRegistry;
import org.topcased.modeler.diagramconfigurator.PaletteItem;

/**
 * @author Nicolas
 */
public class PaletteItemToolGenerator extends ObjectGenerator<PaletteItem>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(PaletteItem paletteItem, Class<G> gmfClass) throws GeneratorException
    {
        if (!CreationTool.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a CreationTool");
        }
        if (isGenerable(paletteItem.getPart()))
        {
            CreationTool creationTool = GMFToolFactory.eINSTANCE.createCreationTool();
            creationTool.setTitle(paletteItem.getName());
            creationTool.setSmallIcon(GMFToolFactory.eINSTANCE.createDefaultImage());
            creationTool.setLargeIcon(GMFToolFactory.eINSTANCE.createDefaultImage());
            MapRegistry.registerAbstractTool(paletteItem.getPart(), creationTool);
            return (G) creationTool;
        }
        return null;
    }

}
