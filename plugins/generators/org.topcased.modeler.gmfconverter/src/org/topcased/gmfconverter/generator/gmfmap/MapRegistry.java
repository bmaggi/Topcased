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

package org.topcased.gmfconverter.generator.gmfmap;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * @author Nicolas
 */
public class MapRegistry
{
    private static Map<NodePartConfiguration, Node> nodeMapper = new HashMap<NodePartConfiguration, Node>();

    private static Map<EdgePartConfiguration, Connection> connectionMapper = new HashMap<EdgePartConfiguration, Connection>();

    private static Map<PartConfiguration, DiagramLabel> diagramLabelMapper = new HashMap<PartConfiguration, DiagramLabel>();

    private static Map<FigureDescriptor, PartConfiguration> figureDescriptorMapper = new HashMap<FigureDescriptor, PartConfiguration>();

    private static Map<PartConfiguration, Compartment> compartmentMapper = new HashMap<PartConfiguration, Compartment>();

    private static Map<PartConfiguration, AbstractTool> toolMapper = new HashMap<PartConfiguration, AbstractTool>();

    private static ToolRegistry toolRegistry = null;

    private static Canvas canvas = null;

    private static EClass rootEClass = null;

    public static EClass getRootEClass()
    {
        return rootEClass;
    }

    public static void setRootEClass(EClass rootEClass)
    {
        MapRegistry.rootEClass = rootEClass;
    }

    public static ToolRegistry getToolRegistry()
    {
        return toolRegistry;
    }

    public static void setToolRegistry(ToolRegistry toolRegistry)
    {
        MapRegistry.toolRegistry = toolRegistry;
    }

    public static Canvas getCanvas()
    {
        return canvas;
    }

    public static void setCanvas(Canvas canvas)
    {
        MapRegistry.canvas = canvas;
    }

    public static void registerNode(NodePartConfiguration nodePartConfiguration, Node node)
    {
        nodeMapper.put(nodePartConfiguration, node);
        if (node instanceof DiagramLabel)
        {
            diagramLabelMapper.put(nodePartConfiguration, (DiagramLabel) node);
        }
    }

    public static void registerConnection(EdgePartConfiguration edgePartConfiguration, Connection connection)
    {
        connectionMapper.put(edgePartConfiguration, connection);
    }

    public static void registerDiagramLabel(FigureDescriptor figureDescriptor, DiagramLabel diagramLabel)
    {
        diagramLabelMapper.put(figureDescriptorMapper.get(figureDescriptor), diagramLabel);
    }

    public static void registerFigureDescriptor(PartConfiguration partConfiguration, FigureDescriptor figureDescriptor)
    {
        figureDescriptorMapper.put(figureDescriptor, partConfiguration);
    }

    public static void registerCompartment(NodePartConfiguration nodePartConfiguration, Compartment compartment)
    {
        compartmentMapper.put(nodePartConfiguration, compartment);
    }

    public static void registerAbstractTool(PartConfiguration partConfiguration, AbstractTool abstractTool)
    {
        toolMapper.put(partConfiguration, abstractTool);
    }

    public static Node getNode(NodePartConfiguration nodePartConfiguration)
    {
        return nodeMapper.get(nodePartConfiguration);
    }

    public static AbstractTool getAbstractTool(PartConfiguration partConfiguration)
    {
        return toolMapper.get(partConfiguration);
    }

    public static Compartment getCompartment(NodePartConfiguration nodePartConfiguration)
    {
        return compartmentMapper.get(nodePartConfiguration);
    }

    public static Connection getConnection(EdgePartConfiguration edgePartConfiguration)
    {
        return connectionMapper.get(edgePartConfiguration);
    }

    public static DiagramLabel getDiagramLabel(NodePartConfiguration nodePartConfiguration)
    {
        return diagramLabelMapper.get(nodePartConfiguration);
    }

    public static void resetMap()
    {
        nodeMapper.clear();
        connectionMapper.clear();
        diagramLabelMapper.clear();
        figureDescriptorMapper.clear();
        compartmentMapper.clear();
        toolMapper.clear();
        canvas = null;
        toolRegistry = null;
    }
}
