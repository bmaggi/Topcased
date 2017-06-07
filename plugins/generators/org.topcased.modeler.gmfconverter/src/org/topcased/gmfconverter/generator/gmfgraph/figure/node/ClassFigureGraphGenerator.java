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

import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.topcased.gmfconverter.generator.GMFElementNames;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfgraph.ColorGraphGenerator;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;

/**
 * A Generator for Class-type figures
 */
public class ClassFigureGraphGenerator extends NodeFiguresGraphGenerator
{
    /**
     * @see org.topcased.gmfconverter.generator.gmfgraph.figure.node.NodeFiguresGraphGenerator#createFigureDescriptor(org.topcased.modeler.diagramconfigurator.NodePartConfiguration)
     */
    public FigureDescriptor createFigureDescriptor(NodePartConfiguration nodePartConfiguration) throws GeneratorException
    {
        // Create Figure Descriptor
        FigureDescriptor figureDescriptor = createEmptyFigureDescriptor(nodePartConfiguration);

        // Create rectangle
        Rectangle rectangle = GMFGraphFactory.eINSTANCE.createRectangle();
        figureDescriptor.setActualFigure(rectangle);
        rectangle.setName(nodePartConfiguration.getPrefix() + GMFElementNames.FIGURE_SUFFIX);
        rectangle.setFill(true);
        rectangle.setLineKind(LineKind.LINE_SOLID_LITERAL);
        rectangle.setLineWidth(1);
        rectangle.setOutline(true);
        rectangle.setXorFill(false);
        rectangle.setXorOutline(false);

        // Create Flow Layout
        FlowLayout flowLayout = GMFGraphFactory.eINSTANCE.createFlowLayout();
        rectangle.setLayout(flowLayout);
        flowLayout.setForceSingleLine(true);
        flowLayout.setMajorAlignment(Alignment.CENTER_LITERAL);
        flowLayout.setMajorSpacing(0);
        flowLayout.setMatchMinorSize(true);
        flowLayout.setMinorAlignment(Alignment.CENTER_LITERAL);
        flowLayout.setMinorSpacing(0);
        flowLayout.setVertical(true);

        // Set BackgroundColor
        Color backgroundColor = ObjectGenerator.getInstance(ColorGraphGenerator.class).createGMFObject(nodePartConfiguration.getDefaultBackgroundColor(), Color.class);
        rectangle.setBackgroundColor(backgroundColor);

        // Set Label
        Label label = GMFGraphFactory.eINSTANCE.createLabel();
        rectangle.getChildren().add(label);
        label.setName(nodePartConfiguration.getPrefix() + GMFElementNames.LABEL_SUFFIX);
        label.setText("<...>");
        // Set corresponding childAccess
        ChildAccess childAccess = GMFGraphFactory.eINSTANCE.createChildAccess();
        figureDescriptor.getAccessors().add(childAccess);
        childAccess.setFigure(label);
        childAccess.setAccessor(GMFElementNames.ACCESSOR_PREFIX + label.getName());

        return figureDescriptor;
    }

}
