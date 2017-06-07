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

import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.topcased.gmfconverter.generator.GMFElementNames;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.gmfconverter.generator.gmfgraph.figure.edge.EdgeFiguresGraphGenerator;
import org.topcased.gmfconverter.generator.gmfmap.MapRegistry;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * The Generator for an EdgePartConfiguration element
 * 
 * @author Nicolas
 */
public class EdgePartConfigurationGraphGenerator extends ObjectGenerator<EdgePartConfiguration>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(EdgePartConfiguration edgePartConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (FigureDescriptor.class.equals(gmfClass))
        {
            return (G) getFigureDescriptor(edgePartConfiguration);
        }
        else if (Connection.class.equals(gmfClass))
        {
            return (G) getConnection(edgePartConfiguration);
        }
        else
        {
            throw new GeneratorException("gmfClass must be a Node or a FigureDescriptor or a Connection.");
        }
    }

    private Connection getConnection(PartConfiguration partConfiguration)
    {
        if (partConfiguration instanceof EdgePartConfiguration)
        {
            Connection connection = GMFGraphFactory.eINSTANCE.createConnection();
            connection.setName(partConfiguration.getPrefix() + GMFElementNames.CONNECTION_SUFFIX);
            MapRegistry.registerConnection((EdgePartConfiguration) partConfiguration, connection);
            return connection;
        }
        return null;
    }

    private Figure getFigure(EdgePartConfiguration edgePartConfiguration) throws GeneratorException
    {
        PolylineConnection polylineConnection = GMFGraphFactory.eINSTANCE.createPolylineConnection();

        // Set line king
        LineStyleGraphGenerator lineStyleGraphGenerator = getInstance(LineStyleGraphGenerator.class);
        LineKind lineKind = lineStyleGraphGenerator.createGMFObject(edgePartConfiguration.getLineStyle(), LineKind.class);
        polylineConnection.setLineKind(lineKind);

        // Set colors
        ColorGraphGenerator colorGraphGenerator = getInstance(ColorGraphGenerator.class);
        Color foregroundcolor = colorGraphGenerator.createGMFObject(edgePartConfiguration.getDefaultForegroundColor(), Color.class);
        polylineConnection.setForegroundColor(foregroundcolor);

        // Set line with
        polylineConnection.setLineWidth(edgePartConfiguration.getLineWidth());

        // set name
        polylineConnection.setName(edgePartConfiguration.getPrefix() + GMFElementNames.POLYLINE_CONNECTION_SUFFIX);

        // set decoration
        EdgeFiguresGraphGenerator.decorateConnection(edgePartConfiguration, polylineConnection);

        return polylineConnection;
    }

    private FigureDescriptor getFigureDescriptor(EdgePartConfiguration edgePartConfiguration) throws GeneratorException
    {
        FigureDescriptor figureDescriptor = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
        figureDescriptor.setName(edgePartConfiguration.getPrefix() + GMFElementNames.FIGURE_DESCRIPTOR_SUFFIX);
        figureDescriptor.setActualFigure(getFigure(edgePartConfiguration));
        return figureDescriptor;
    }
}
