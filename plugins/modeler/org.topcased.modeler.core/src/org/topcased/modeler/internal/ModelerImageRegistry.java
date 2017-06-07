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
package org.topcased.modeler.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.topcased.modeler.ImageRegistry;



/**
 * Handle images
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public final class ModelerImageRegistry
{

    private static final String BUNDLE = "org.topcased.modeler.images";

    /**
     * The constructor
     */
    private ModelerImageRegistry()
    {
        // Do nothing
    }

    /**
     * Clients should not dispose the Image returned. 
     * 
     * @param key the key (one of the constants defined in this class)
     * @return the Image associated with the given key
     */
    public static Image getImage(String key)
    {
        return ImageRegistry.getInstance().get(ModelerPlugin.getDefault().getBundle(), getImageLocation(key));
    }

    /**
     * Return the image location
     * 
     * @param key the key
     * @return the Image location associated with the given key
     */
    private static String getImageLocation(String key)
    {
        return ResourceBundle.getBundle(BUNDLE).getString(key);
    }

    /**
     * Build an image descriptor for the given key
     * 
     * @param key the key
     * @return the ImageDescriptor associated with the given key
     */
    public static ImageDescriptor getImageDescriptor(String key)
    {
        try
        {
            return ImageRegistry.getInstance().getDescriptor(ModelerPlugin.getDefault().getBundle(),
                    getImageLocation(key));
        }
        catch (MissingResourceException mre)
        {
            return null;
        }
    }

}
