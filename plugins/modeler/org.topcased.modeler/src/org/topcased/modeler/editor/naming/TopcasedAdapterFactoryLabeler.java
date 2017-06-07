/***********************************************************************
 * Copyright (c) 2008 Obeo and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Laurent Redor (Obeo) - initial API and implementation
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    David Sciamma (Anyware Technologies) - Workaround for an EMF bug with EFS URI
 *    Gilles Cannenterre (Anyware Technologies) - provide a shared Clipboard
 **********************************************************************/
package org.topcased.modeler.editor.naming;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Class TopcasedAdapterFactoryLabeler. This class is set 'public' but should be accessed outside the
 * TopcasedAdapterFactoryEditingDomain.
 * It has been extracted from {@link TopcasedAdapterFactoryEditingDomain}.
 */
public class TopcasedAdapterFactoryLabeler
{

    /** The uris map. */
    private final Map<String, String> urisMap = new HashMap<String, String>();

    /** The instance. */
    private static TopcasedAdapterFactoryLabeler instance;

    /**
     * Instantiates a new topcased adapter factory labeler.
     */
    private TopcasedAdapterFactoryLabeler()
    {
        readExtensionPoint();
    }

    /**
     * Gets the single instance of TopcasedAdapterFactoryLabeler.
     * 
     * @return single instance of TopcasedAdapterFactoryLabeler
     */
    public static TopcasedAdapterFactoryLabeler getInstance()
    {
        if (instance == null)
        {
            instance = new TopcasedAdapterFactoryLabeler();
        }
        return instance;
    }

    /**
     * Gets the label attribute.
     * 
     * @param uri the uri
     * 
     * @return the label attribute
     */
    public String getLabelAttribute(String uri)
    {
        return urisMap.containsKey(uri) ? urisMap.get(uri) : "";
    }

    /**
     * Gets the label feature.
     * 
     * @param object the object
     * 
     * @return the label feature
     */
    public EStructuralFeature getLabelFeature(EObject object)
    {
        String labelField = getLabelAttribute(object.eClass().getEPackage().getNsURI());
        for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures())
        {
            if (!feature.isMany() && feature.getEType().getInstanceClass().equals(String.class) && labelField.equals(feature.getName()))
            {
                return feature;
            }
        }
        return null;
    }

    /**
     * Read the extension point 'defaultName'.
     */
    private void readExtensionPoint()
    {
        final String extPointName = "defaultName";
        final String uri = "URI";
        final String label = "label";
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ModelerPlugin.getId(), extPointName);
        for (IConfigurationElement element : elements)
        {
            String declaredUri = element.getAttribute(uri);
            String declaredLabel = element.getAttribute(label);
            if (!isStringEmpty(declaredUri) && !isStringEmpty(declaredLabel))
            {
                urisMap.put(declaredUri, declaredLabel);
            }
        }
    }

    /**
     * Checks if is string empty.
     * 
     * @param theString the the string
     * 
     * @return true, if is string empty
     */
    private boolean isStringEmpty(String theString)
    {
        return theString == null || theString.length() == 0;
    }
}