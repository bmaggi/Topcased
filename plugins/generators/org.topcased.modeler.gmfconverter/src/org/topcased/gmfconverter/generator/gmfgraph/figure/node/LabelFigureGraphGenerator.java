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

import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.topcased.gmfconverter.generator.GMFElementNames;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfgraph.ColorGraphGenerator;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;

/**
 * A Generator for Label-type figures
 */
public class LabelFigureGraphGenerator extends NodeFiguresGraphGenerator
{

    /**
     * @see org.topcased.gmfconverter.generator.gmfgraph.figure.node.NodeFiguresGraphGenerator#createFigureDescriptor(org.topcased.modeler.diagramconfigurator.NodePartConfiguration)
     */
    public FigureDescriptor createFigureDescriptor(NodePartConfiguration nodePartConfiguration) throws GeneratorException
    {
        // Create Figure Descriptor
        FigureDescriptor figureDescriptor = createEmptyFigureDescriptor(nodePartConfiguration);

        // Create label
        Label label = GMFGraphFactory.eINSTANCE.createLabel();
        figureDescriptor.setActualFigure(label);
        label.setName(nodePartConfiguration.getPrefix() + GMFElementNames.FIGURE_SUFFIX);

        // Set BackgroundColor
        Color backgroundColor = ObjectGenerator.getInstance(ColorGraphGenerator.class).createGMFObject(nodePartConfiguration.getDefaultBackgroundColor(), Color.class);
        label.setBackgroundColor(backgroundColor);

        return figureDescriptor;
    }

}
