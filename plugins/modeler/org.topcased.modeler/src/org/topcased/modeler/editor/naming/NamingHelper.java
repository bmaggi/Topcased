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

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;

/**
 * This class helps finding a default name. It has been extracted from {@link TopcasedAdapterFactoryEditingDomain}.
 * 
 * @author vhemery
 */
public class NamingHelper
{

    /**
     * Gets the default name.
     * 
     * @param modelObject the model object
     * 
     * @return the default name
     */
    public static String getDefaultName(EObject modelObject)
    {
        String className = modelObject.eClass().getName();
        String defaultName = className + "1";
        // do the algorithm only if the container does not contain only
        // modelObject
        if (modelObject.eContainer() != null && modelObject.eContainer().eContents().size() > 1)
        {
            boolean nameAlreadyUsed = false;
            for (EObject object : modelObject.eContainer().eContents())
            {
                EStructuralFeature labelFeature = TopcasedAdapterFactoryLabeler.getInstance().getLabelFeature(object);
                if (labelFeature != null && String.class.equals(labelFeature.getEType().getInstanceClass()))
                {
                    String label = (String) object.eGet(labelFeature);
                    if (defaultName.equals(label))
                    {
                        nameAlreadyUsed = true;
                        break;
                    }
                }
            }
            if (nameAlreadyUsed)
            {
                Pattern pattern = Pattern.compile(className + "((\\d)*)");
                SortedSet<String> matchingNames = new TreeSet<String>(new EObjectNameComparator(pattern));
                for (EObject object : modelObject.eContainer().eContents())
                {
                    EStructuralFeature labelFeature = TopcasedAdapterFactoryLabeler.getInstance().getLabelFeature(object);
                    if (labelFeature != null && String.class.equals(labelFeature.getEType().getInstanceClass()))
                    {
                        String label = (String) object.eGet(labelFeature);
                        if (label != null && pattern.matcher(label).matches())
                        {
                            matchingNames.add(label);
                        }
                    }
                }
                if (!matchingNames.isEmpty())
                {
                    String lastName = matchingNames.last();
                    Matcher matcher = pattern.matcher(lastName);
                    matcher.matches();
                    String suffix = "1";
                    if (matcher.groupCount() > 1)
                    {
                        try
                        {
                            suffix = String.valueOf(Integer.parseInt(matcher.group(1)) + 1);
                        }
                        catch (NumberFormatException e)
                        {
                            // do nothing
                        }
                    }
                    defaultName = className + suffix;
                }
            }
        }
        return defaultName;
    }

}
