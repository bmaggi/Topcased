/*****************************************************************************
 * 
 * EdgeObjectBehavior.java
 * 
 * Copyright (c) 2008 Atos Origin.
 *
 * Contributors:
 *  Maxime Nauleau (Atos Origin) maxime.nauleau@atosorigin.com
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
  *****************************************************************************/

package org.topcased.modeler.editor.properties.sections.graphics;

import org.topcased.modeler.di.model.EdgeObject;

/**
 * Factory that gives instance of a class, which permits to determine which behavior
 * to apply on an edgeEObject
 * 
 * @author maxime.nauleau
 *
 */
public class EdgeObjectBehavior
{

    private static Class theClass = EdgeObjectBehavior.class;

    private static EdgeObjectBehavior obj;

    public static void chooseBehavior(Class zclass)
    {
        theClass = zclass;
        obj = null;
    }

    /**
     * Simply return an instance of the class
     * @return
     */
    public static EdgeObjectBehavior getInstance()
    {
        if (obj == null)
        {
            try
            {
                return (EdgeObjectBehavior) theClass.newInstance();
            }
            catch (Exception e)
            {
                return null;
            }
        }
        else
        {
            return obj;
        }
    }
    
    /**
     * Gives the default behavior
     * @param obj
     * @return
     */
    public boolean edgeObjectsBehavior(EdgeObject obj)
    {
        return true;
    }
}
