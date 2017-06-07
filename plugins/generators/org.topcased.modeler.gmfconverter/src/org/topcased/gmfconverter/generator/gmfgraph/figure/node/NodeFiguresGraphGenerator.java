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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.topcased.gmfconverter.generator.GMFElementNames;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.gmfmap.MapRegistry;
import org.topcased.gmfconverter.internal.Activator;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * A Generator for Node-type figures
 */
public abstract class NodeFiguresGraphGenerator
{

    private static final Map<String, NodeFiguresGraphGenerator> generatorInstances = new HashMap<String, NodeFiguresGraphGenerator>();

    private static final Map<String, Class< ? extends NodeFiguresGraphGenerator>> generatorMapping = new HashMap<String, Class< ? extends NodeFiguresGraphGenerator>>();

    private static final String UNKNOWN_FIGURE = "unknown";

    static
    {
        // GMF version of the topcased figure.
        generatorMapping.put("Class", ClassFigureGraphGenerator.class);
        generatorMapping.put("Label", LabelFigureGraphGenerator.class);

        // TODO : create GMF figures for theses Topcased figures
        // generatorMapping.put("Figure", FigureFigureGraphGenerator.class);
        // generatorMapping.put("Shape", ShapeFigureGraphGenerator.class);
        // generatorMapping.put("Port", PortFigureGraphGenerator.class);
        // generatorMapping.put("OrientedPort", OrientedPortFigureGraphGenerator.class);
        // generatorMapping.put("LabelledPort", LabelledPortFigureGraphGenerator.class);
        // generatorMapping.put("Container", ContainerFigureGraphGenerator.class);
        // generatorMapping.put("State", StateFigureGraphGenerator.class);
        // generatorMapping.put("Comment", CommentFigureGraphGenerator.class);
        // generatorMapping.put("Package", PackageFigureGraphGenerator.class);
        // generatorMapping.put("Man", ManFigureGraphGenerator.class);
        // generatorMapping.put("Woman", WomanFigureGraphGenerator.class);
        // generatorMapping.put("Graphic With Bottom Label", GraphicWithBottomLabelFigureGraphGenerator.class);
        // generatorMapping.put("Computer", ComputerFigureGraphGenerator.class);
        // generatorMapping.put("Cloud", CloudFigureGraphGenerator.class);
        // generatorMapping.put("BorderedLabel", BorderedLabelFigureGraphGenerator.class);
        // generatorMapping.put("RectangleFigure", RectangleFigureFigureGraphGenerator.class);
        // generatorMapping.put("RoundedRectangle", RoundedRectangleFigureGraphGenerator.class);
        // generatorMapping.put("Ellipse", EllipseFigureGraphGenerator.class);
        // generatorMapping.put("Container With Inner Label", ContainerWithInnerLabelFigureGraphGenerator.class);
        // generatorMapping.put("Graphic With Label Figure", GraphicWithLabelFigureFigureGraphGenerator.class);

        // Default custom figure.
        generatorMapping.put(UNKNOWN_FIGURE, CustomFigureGraphGenerator.class);
    }

    /**
     * @param topcasedFigureName 
     * @return NodeFiguresGraphGenerator
     * @throws GeneratorException 
     */
    protected final static NodeFiguresGraphGenerator getInstance(String topcasedFigureName) throws GeneratorException
    {
        NodeFiguresGraphGenerator instance = null;
        try
        {
            instance = generatorInstances.get(topcasedFigureName);
            if (instance == null)
            {
                Class< ? extends NodeFiguresGraphGenerator> c = generatorMapping.get(topcasedFigureName);
                if (c == null)
                {
                    return getInstance(UNKNOWN_FIGURE);
                }
                instance = c.newInstance();
                generatorInstances.put(topcasedFigureName, instance);
            }
        }
        catch (Exception e)
        {
            throw new GeneratorException("Impossible to found or instanciate the generator for figure " + topcasedFigureName, e);
        }
        return instance;
    }

    /**
     * Return the FigureDescriptor associated with the given Node
     * @param nodePartConfiguration 
     * @return FigureDescriptor
     * @throws GeneratorException 
     */
    public static FigureDescriptor getFigureDescriptor(NodePartConfiguration nodePartConfiguration) throws GeneratorException
    {
        try
        {
            FigureDescriptor figureDescriptor = getInstance(nodePartConfiguration.getType()).createFigureDescriptor(nodePartConfiguration);
            MapRegistry.registerFigureDescriptor(nodePartConfiguration, figureDescriptor);
            return figureDescriptor;
        }
        catch (GeneratorException e)
        {
            Activator.log(e);
            Activator.log("The figure type '" + nodePartConfiguration.getType() + "' will be not generated.", IStatus.WARNING);
            return createEmptyFigureDescriptor(nodePartConfiguration);
        }
    }

    /**
     * Create a new empty FigureDescriptor to be associated with the given Node
     * 
     * @param partConfiguration 
     * @return FigureDescriptor
     * @throws GeneratorException 
     */
    protected static FigureDescriptor createEmptyFigureDescriptor(PartConfiguration partConfiguration) throws GeneratorException
    {
        FigureDescriptor figureDescriptor = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
        figureDescriptor.setName(partConfiguration.getPrefix() + GMFElementNames.FIGURE_DESCRIPTOR_SUFFIX);
        return figureDescriptor;
    }

    /**
     * Create a new FigureDescriptor to be associated with the given Node
     * 
     * @param nodePartConfiguration 
     * @return FigureDescriptor
     * @throws GeneratorException
     */
    protected abstract FigureDescriptor createFigureDescriptor(NodePartConfiguration nodePartConfiguration) throws GeneratorException;
}
