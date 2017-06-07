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
package org.topcased.modeler;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.FanRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ForestRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;

/**
 * Constants that are used for the router management
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public final class RouterConstants
{
    
    /** Router usually for "inheritance-like" connections */
    public static final String FOREST = "Forest";

    /** Router with rectilinear segments that can be moved */
    public static final String RECTILINEAR = "Rectilinear";

    /** Direct connection that can be stick to vertical or horizontal  lines */
    public static final String OBLIQUE = "Oblique";
    
    /**
     * Constructor
     */
    private RouterConstants()
    {
        // Do nothing
    }

    /**
     * Create a router from its nam
     * @param layer the connection layer
     * @param name the router name
     * @return the router
     */
    public static ConnectionRouter getRouter(ConnectionLayerEx layer, String name)
    {
        ConnectionRouter router = layer.getObliqueRouter();
        if (FOREST.equals(name))
        {
            router = layer.getTreeRouter();
        }
        else if (RECTILINEAR.equals(name))
        {
            router = layer.getRectilinearRouter();
        }
        
        return router;
    }

    /**
     * Returns the router name for the given router
     * @param router the router
     * @return the router name
     */
    public static String getRouterName(ConnectionRouter router)
    {
        if (router instanceof ForestRouter)
        {
            return FOREST;
        }
        if (router instanceof FanRouter)
        {
            return OBLIQUE;
        }
        if (router instanceof RectilinearRouter)
        {
            return RECTILINEAR;
        }
        
        return null;
    }
}
