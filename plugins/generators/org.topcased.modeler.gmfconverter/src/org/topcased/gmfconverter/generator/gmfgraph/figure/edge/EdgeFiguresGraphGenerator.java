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

package org.topcased.gmfconverter.generator.gmfgraph.figure.edge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.PolylineDecoration;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.modeler.diagramconfigurator.DecorationType;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;

/**
 * A generator for Edge-type figures
 */
public abstract class EdgeFiguresGraphGenerator
{

    private static PolylineDecoration ARROW_DECORATION = null;

    private static PolygonDecoration TRIANGLE_DECORATION = null;

    private static FigureGallery figureGallery = null;

    /**
     * @param partConfiguration 
     * @param polylineConnection 
     * @throws GeneratorException 
     * 
     */
    public static void decorateConnection(EdgePartConfiguration partConfiguration, PolylineConnection polylineConnection) throws GeneratorException
    {
        DecorationFigure sourceDecoration = getDecoration(partConfiguration.getSourceDecoration());
        polylineConnection.setSourceDecoration(sourceDecoration);
        DecorationFigure targetDecoration = getDecoration(partConfiguration.getTargetDecoration());
        polylineConnection.setTargetDecoration(targetDecoration);
    }

    private static DecorationFigure getDecoration(DecorationType decorationType)
    {
        switch (decorationType.getValue())
        {
            case DecorationType.ARROW:
                if (ARROW_DECORATION == null)
                {
                    ARROW_DECORATION = GMFGraphFactory.eINSTANCE.createPolylineDecoration();
                    ARROW_DECORATION.getTemplate().addAll(getArrowPoint());
                    figureGallery.getFigures().add(ARROW_DECORATION);
                }
                return ARROW_DECORATION;
            case DecorationType.TRIANGLE:
                if (ARROW_DECORATION == null)
                {
                    TRIANGLE_DECORATION = GMFGraphFactory.eINSTANCE.createPolygonDecoration();
                    TRIANGLE_DECORATION.getTemplate().addAll(getArrowPoint());
                    ConstantColor whiteColor = GMFGraphFactory.eINSTANCE.createConstantColor();
                    whiteColor.setValue(ColorConstants.WHITE_LITERAL);
                    TRIANGLE_DECORATION.setBackgroundColor(whiteColor);
                    figureGallery.getFigures().add(TRIANGLE_DECORATION);
                }
                return TRIANGLE_DECORATION;
            default:
                return null;
        }
    }

    private static List<Point> getArrowPoint()
    {
        List<Point> points = new ArrayList<Point>();
        points.add(createPoint(-2, -2));
        points.add(createPoint(0, 0));
        points.add(createPoint(-2, 2));
        return points;
    }

    private static Point createPoint(int x, int y)
    {
        Point point = GMFGraphFactory.eINSTANCE.createPoint();
        point.setX(x);
        point.setY(y);
        return point;
    }

    /**
     * @param figureGal 
     */
    public static void initDecoration(FigureGallery figureGal)
    {
        ARROW_DECORATION = null;
        TRIANGLE_DECORATION = null;
        EdgeFiguresGraphGenerator.figureGallery = figureGal;
    }

}
