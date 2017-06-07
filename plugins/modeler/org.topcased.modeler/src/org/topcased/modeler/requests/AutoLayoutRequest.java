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
package org.topcased.modeler.requests;

import java.util.List;

import org.eclipse.gef.Request;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.di.model.DiagramElement;

/**
 * This request asks the auto layout of the given elements. <br>
 * creation : 4 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AutoLayoutRequest extends Request
{

    private List<DiagramElement> objects;

    /**
     * Constructor
     */
    public AutoLayoutRequest()
    {
        super();
        setType(ModelerRequestConstants.REQ_AUTOLAYOUT);
    }

    /**
     * Defines the list of objects to automatically layout
     * 
     * @param objects the objects list
     */
    public void setObjects(List<DiagramElement> objects)
    {
        this.objects = objects;
    }

    /**
     * Returns the list of objects to automatically layout
     * 
     * @return the list of objects to automatically layout
     */
    public List<DiagramElement> getObjects()
    {
        return objects;
    }
}
