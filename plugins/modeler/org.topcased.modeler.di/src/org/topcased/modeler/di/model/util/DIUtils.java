/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.di.model.util;

import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.Property;

/**
 * Helper class to manage the DI model. <br>
 * 
 * Creation : 3 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public final class DIUtils
{
    /** Private constructor so that the class could not be instantiated */
    private DIUtils()
    {
        // Do nothing
    }

    /**
     * Returns the Property (object model of the DI) associated with the passed key.
     * 
     * @param elt the DiagramElement
     * @param key the key of the Property
     * @return the Property (null if not found)
     */
    public static Property getProperty(DiagramElement elt, String key)
    {
        if (elt != null && elt.getProperty() != null && elt.getProperty().size() != 0)
        {
            for (Property property : elt.getProperty())
            {
                if (property.getKey().equals(key))
                {
                    return property;
                }
            }
        }
        return null;
    }

    /**
     * Returns the String value of a Property
     * 
     * @param elt the DiagramElement
     * @param key the key of the Property
     * @return String ("" if no Property associated)
     */
    public static String getPropertyValue(DiagramElement elt, String key)
    {
        Property property = getProperty(elt, key);
        if (property != null && property.getValue() != null)
        {
            return property.getValue();
        }
        return "";
    }

    /**
     * Change the value of a Property key of the selected GraphElement
     * 
     * @param elt the DiagramElement
     * @param key the identifier of the property to set
     * @param value the new value of the property
     */
    public static void setProperty(DiagramElement elt, String key, String value)
    {
        Property property = getProperty(elt, key);

        if (property == null && value != null)
        {
            // the property does not exist yet
            property = DiagramInterchangeFactory.eINSTANCE.createProperty();
            property.setKey(key);
            property.setValue(value);
            elt.getProperty().add(property);
        }
        else
        {
            if (value != null)
            {
                // check if the value has changed
                if (!value.equals(property.getValue()))
                {
                    // update the property
                    property.setValue(value);
                }
            }
            else
            {
                elt.getProperty().remove(property);
            }
        }
    }
}
