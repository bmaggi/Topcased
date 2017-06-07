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
package org.topcased.generator.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * This class is used to retrieve the root model object of a configurator file (an EMF model)
 * 
 * Creation 19 déc. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ConfiguratorObjectManager
{

    /**
     * In EMF, a resource provides the way to have access to the genModel content.
     */
    private Resource resource = null;

    /**
     * Gives access to the top level object contained in the resource.
     */
    private EObject rootModelObject = null;

    /**
     * Returns the resource containing the network. Uses lazy initialization.
     * 
     * @param path
     * @return the associated resource
     */
    public Resource getResource(IPath path)
    {
        if (resource == null)
        {
            ResourceSet resSet = getResourceSet();
            resource = resSet.getResource(URI.createPlatformResourceURI(path.toString(), true), true);
        }
        return resource;
    }

    /**
     * Returns the resource set.
     * 
     * @return a new ResourceSet
     */
    private ResourceSet getResourceSet()
    {
        // Obtain a new resource set
        return new ResourceSetImpl();
    }

    /**
     * Loads the content of the model from the file.
     * 
     * @param path
     * @throws IOException
     */
    public void load(IPath path) throws IOException
    {
        getResource(path);
        Map<Object,Object> options = new HashMap<Object,Object>();
        resource.load(options);
    }

    /**
     * Gets the top level object.
     * 
     * @return the rootModelObject
     */
    public EObject getRootModelObject()
    {
        if (rootModelObject == null)
        {
            for (EObject o : resource.getContents()) {
                rootModelObject = o;
            }
        }
        return rootModelObject;
    }

}
