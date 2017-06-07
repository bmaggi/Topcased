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

package org.topcased.gmfconverter.generator.gmfgraph.figure.node;

import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.extension.FigureDeclarationsManager;

/**
 * A Generator for custom-type figures
 */
public class CustomFigureGraphGenerator extends NodeFiguresGraphGenerator
{

    /**
     * @see org.topcased.gmfconverter.generator.gmfgraph.figure.node.NodeFiguresGraphGenerator#createFigureDescriptor(org.topcased.modeler.diagramconfigurator.NodePartConfiguration)
     */
    protected FigureDescriptor createFigureDescriptor(NodePartConfiguration nodePartConfiguration) throws GeneratorException
    {
        // Create Figure Descriptor
        FigureDescriptor figureDescriptor = createEmptyFigureDescriptor(nodePartConfiguration);

        // Use draw2D class of topcased figure extension point
        CustomFigure customFigure = GMFGraphFactory.eINSTANCE.createCustomFigure();
        String className = FigureDeclarationsManager.getInstance().find(nodePartConfiguration.getType()).getQualifiedFigureClassName();
        customFigure.setQualifiedClassName(className);
        customFigure.setName(nodePartConfiguration.getType());

        figureDescriptor.setActualFigure(customFigure);
        return figureDescriptor;
    }

}
