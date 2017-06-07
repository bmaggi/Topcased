/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;

/**
 * An interface defining the structure of a graph edge figure which contains
 * edge object figures. <br/> Creation : 26 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public interface IGraphEdgeFigure extends IFigure
{
    /**
     * Get this graph edge locator for the given edje object figure.
     * 
     * @param edgeObjectFigure an edge object figure of this figure
     * @return a locator
     */
    Locator getLocator(IEdgeObjectFigure edgeObjectFigure);
}
