/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A map assocating an eobject to its graphical properties
 * 
 * @author tfaure
 * 
 */
public class GraphicalPropertiesMap implements Cloneable
{
    private Map<EObject, GraphicalProperties> properties = new HashMap<EObject, GraphicalProperties>();

    public void put(EObject e, GraphicalProperties g)
    {
        properties.put(e, g);
    }

    public GraphicalProperties get(EObject e)
    {
        return properties.get(e);
    }

    public GraphicalProperties getEquivalent(EObject e)
    {
        EObject equals = getInKey(e);
        if (equals != null)
        {
            return properties.get(equals);
        }
        return null;
    }

    public boolean containsKey(EObject e)
    {
        return properties.containsKey(e);
    }

    /**
     * get in the map the element according to the current element
     * 
     * @param eobject
     * @return
     */
    private EObject getInKey(EObject eobject)
    {
        for (EObject e : properties.keySet())
        {
            if (EcoreUtil.equals(eobject, e))
            {
                return e;
            }
        }
        return null;
    }

    public void clear()
    {
        properties.clear();
    }
    
    @Override
    public Object clone() 
    {
        GraphicalPropertiesMap cloned = new GraphicalPropertiesMap();
        cloned.properties.putAll(this.properties);
        return cloned;
    }




    /**
     * This class is just here to embed graphical properties
     * 
     * @author tfaure
     * 
     */
    public static class GraphicalProperties
    {
        private String backGroundColor = null;

        private String foreGroundColor = null;

        private String font = null;

        private Dimension dimension = null;

        private Point position = null;

        public String getBackGroundColor()
        {
            return backGroundColor;
        }

        public void setBackGroundColor(String backGroundColor)
        {
            this.backGroundColor = backGroundColor;
        }

        public String getForeGroundColor()
        {
            return foreGroundColor;
        }

        public void setForeGroundColor(String foreGroundColor)
        {
            this.foreGroundColor = foreGroundColor;
        }

        public String getFont()
        {
            return font;
        }

        public void setFont(String font)
        {
            this.font = font;
        }

        public Dimension getDimension()
        {
            return dimension;
        }

        public void setDimension(Dimension dimension)
        {
            this.dimension = dimension;
        }

        public void setPosition(Point position)
        {
            this.position = position;
        }

        public Point getPosition()
        {
            return position;
        }
    }

}
