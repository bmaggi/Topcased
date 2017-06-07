/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.topcased.modeler.editor.Modeler;

/**
 * This object computes all the loaded resources from a resource set. <br>
 * Creation : 8 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AdditionalResources
{
    private Modeler modeler;

    /**
     * Constructor
     * 
     * @param editor the graphical model editor
     */
    public AdditionalResources(Modeler editor)
    {
        super();

        this.modeler = editor;
    }

    /**
     * Returns all the resources without the DI and the domain resources
     * 
     * @return the list of additional resources
     */
    public List<Resource> getResources()
    {
        List<Resource> res = new ArrayList<Resource>(modeler.getResourceSet().getResources());

        // remove DI and domain resources
        res.remove(modeler.getDiagrams().eResource());
        res.remove(modeler.getDiagrams().getModel().eResource());

        return res;
    }
}
