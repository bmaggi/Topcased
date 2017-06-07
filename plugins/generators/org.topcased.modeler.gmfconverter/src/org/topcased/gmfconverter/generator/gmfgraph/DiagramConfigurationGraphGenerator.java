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

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Node;
import org.topcased.gmfconverter.generator.GMFElementNames;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfgraph.figure.edge.EdgeFiguresGraphGenerator;
import org.topcased.gmfconverter.generator.gmfmap.MapRegistry;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * @author Nicolas
 */
public class DiagramConfigurationGraphGenerator extends ObjectGenerator<DiagramConfiguration>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(DiagramConfiguration diagramConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (!Canvas.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a Canvas.");
        }
        Canvas canvas = GMFGraphFactory.eINSTANCE.createCanvas();
        canvas.setName(diagramConfiguration.getName());
        EList<PartConfiguration> partConfigs = diagramConfiguration.getParts();
        if (partConfigs.size() > 0)
        {
            FigureGallery figureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
            figureGallery.setName(GMFElementNames.DEFAULT_GALLERY);
            canvas.getFigures().add(figureGallery);
            for (PartConfiguration partConfiguration : partConfigs)
            {
                if (isGenerable(partConfiguration))
                {
                    if (partConfiguration instanceof NodePartConfiguration)
                    {
                        createNodePart(canvas, figureGallery, diagramConfiguration, (NodePartConfiguration) partConfiguration);
                    }
                    else if (partConfiguration instanceof EdgePartConfiguration)
                    {
                        createEdgePart(canvas, figureGallery, (EdgePartConfiguration) partConfiguration);
                    }
                }
            }
            createDiagramLabels(canvas, figureGallery);
        }
        MapRegistry.setCanvas(canvas);
        return (G) canvas;
    }

    private void createDiagramLabels(Canvas canvas, FigureGallery figureGallery)
    {
        for (FigureDescriptor descriptor : figureGallery.getDescriptors())
        {
            for (ChildAccess childAccess : descriptor.getAccessors())
            {
                DiagramLabel diagramLabel = GMFGraphFactory.eINSTANCE.createDiagramLabel();
                diagramLabel.setFigure(descriptor);
                diagramLabel.setAccessor(childAccess);
                diagramLabel.setName(childAccess.getAccessor().substring(GMFElementNames.ACCESSOR_PREFIX.length(), childAccess.getAccessor().length() - GMFElementNames.LABEL_SUFFIX.length())
                        + GMFElementNames.DIAGRAMLABEL_SUFFIX);
                canvas.getLabels().add(diagramLabel);
                MapRegistry.registerDiagramLabel(descriptor, diagramLabel);
            }
        }

    }

    private void createEdgePart(Canvas canvas, FigureGallery figureGallery, EdgePartConfiguration edgePartConfiguration) throws GeneratorException
    {

        EdgeFiguresGraphGenerator.initDecoration(figureGallery);

        EdgePartConfigurationGraphGenerator edgeGenerator = getInstance(EdgePartConfigurationGraphGenerator.class);

        // Figure Descriptor
        FigureDescriptor figureDescriptor = edgeGenerator.createGMFObject(edgePartConfiguration, FigureDescriptor.class);
        if (figureDescriptor != null)
        {
            figureGallery.getDescriptors().add(figureDescriptor);
        }

        // Connection
        Connection connection = edgeGenerator.createGMFObject(edgePartConfiguration, Connection.class);
        if (connection != null)
        {
            canvas.getConnections().add(connection);
            if (figureDescriptor != null)
            {
                connection.setFigure(figureDescriptor);
            }
        }
    }

    private void createNodePart(Canvas canvas, FigureGallery figureGallery, DiagramConfiguration diagramConfiguration, NodePartConfiguration nodePartConfiguration) throws GeneratorException
    {

        NodePartConfigurationGraphGenerator nodeGenerator = getInstance(NodePartConfigurationGraphGenerator.class);

        // Figure Descriptor
        FigureDescriptor figureDescriptor = nodeGenerator.createGMFObject(nodePartConfiguration, FigureDescriptor.class);
        if (figureDescriptor != null)
        {
            figureGallery.getDescriptors().add(figureDescriptor);
        }

        // Node
        Node node = nodeGenerator.createGMFObject(nodePartConfiguration, Node.class);
        if (node != null)
        {
            if (node instanceof DiagramLabel)
            {
                canvas.getLabels().add((DiagramLabel) node);
            }
            else
            {
                canvas.getNodes().add(node);
            }
            if (figureDescriptor != null)
            {
                node.setFigure(figureDescriptor);
            }
        }

        // Compartment
        if (needCompartment(diagramConfiguration, nodePartConfiguration))
        {
            Compartment compartment = nodeGenerator.createGMFObject(nodePartConfiguration, Compartment.class);
            if (compartment != null)
            {
                canvas.getCompartments().add(compartment);
                if (!figureGallery.getDescriptors().contains(compartment.getFigure()))
                {
                    figureGallery.getDescriptors().add(compartment.getFigure());
                }
            }
        }
    }

    private boolean needCompartment(DiagramConfiguration diagramConfiguration, NodePartConfiguration nodePartConfiguration)
    {
        for (PartConfiguration partConfig : diagramConfiguration.getParts())
        {
            if (partConfig instanceof NodePartConfiguration)
            {
                for (PartConfiguration child : ((NodePartConfiguration) partConfig).getChildElements())
                {
                    if (child.equals(nodePartConfiguration))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
