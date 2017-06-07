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

import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.topcased.gmfconverter.generator.GMFElementNames;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfgraph.figure.node.NodeFiguresGraphGenerator;
import org.topcased.gmfconverter.generator.gmfmap.MapRegistry;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;

/**
 * @author Nicolas
 */
public class NodePartConfigurationGraphGenerator extends ObjectGenerator<NodePartConfiguration>
{

    private FigureDescriptor defaultCompartmentFigure = null;

    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(NodePartConfiguration nodePartConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (FigureDescriptor.class.equals(gmfClass))
        {
            return (G) NodeFiguresGraphGenerator.getFigureDescriptor(nodePartConfiguration);
        }
        else if (Node.class.equals(gmfClass))
        {
            return (G) getNode(nodePartConfiguration);
        }
        else if (Compartment.class.equals(gmfClass))
        {
            return (G) getCompartment(nodePartConfiguration);
        }
        else
        {
            throw new GeneratorException("gmfClass must be a Node or a FigureDescriptor or Compartment.");
        }
    }

    private Compartment getCompartment(NodePartConfiguration nodePartConfiguration)
    {
        Compartment compartment = GMFGraphFactory.eINSTANCE.createCompartment();
        compartment.setName(nodePartConfiguration.getPrefix() + GMFElementNames.CONTAINER_SUFFIX);
        compartment.setCollapsible(false);
        compartment.setNeedsTitle(false);
        compartment.setFigure(getDefaultCompartmentFigure());
        MapRegistry.registerCompartment(nodePartConfiguration, compartment);
        return compartment;
    }

    private FigureDescriptor getDefaultCompartmentFigure()
    {
        if (defaultCompartmentFigure == null)
        {
            defaultCompartmentFigure = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
            defaultCompartmentFigure.setName(GMFElementNames.CONTAINER_SUFFIX + GMFElementNames.FIGURE_DESCRIPTOR_SUFFIX);
            Rectangle rectangle = GMFGraphFactory.eINSTANCE.createRectangle();
            rectangle.setFill(false);
            rectangle.setOutline(false);
            defaultCompartmentFigure.setActualFigure(rectangle);
        }
        return defaultCompartmentFigure;
    }

    private Node getNode(NodePartConfiguration partConfiguration)
    {
        Node node = null;
        if ("Label".equals(partConfiguration.getType()))
        {
            node = GMFGraphFactory.eINSTANCE.createDiagramLabel();
            node.setName(partConfiguration.getPrefix() + GMFElementNames.DIAGRAMLABEL_SUFFIX);
        }
        else
        {
            node = GMFGraphFactory.eINSTANCE.createNode();
            node.setName(partConfiguration.getPrefix() + GMFElementNames.NODE_SUFFIX);
        }
        MapRegistry.registerNode(partConfiguration, node);
        return node;
    }
}
