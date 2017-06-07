/*******************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tristan FAURE - ATOS ORIGIN
 *******************************************************************************/
package org.topcased.modeler.documentation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.utils.PriorityUtils;

public class DocumentationManager
{
    private static List<IDocumentable> documentables = getDocumentables();

    private static List<IDocumentable> getDocumentables()
    {
        List<IDocumentable> result = new LinkedList<IDocumentable>();
        Map<IDocumentable, Integer> priorities = new HashMap<IDocumentable, Integer>();
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.topcased.modeler.documentable");
        for (IConfigurationElement e : elements)
        {
            try
            {
                IDocumentable createExecutableExtension = (IDocumentable) e.createExecutableExtension("instance");
                result.add(createExecutableExtension);
                priorities.put(createExecutableExtension, PriorityUtils.getPriority(e.getAttribute("priority")));
                
            }
            catch (InvalidRegistryObjectException e1)
            {
            }
            catch (CoreException e1)
            {
            }
        }
        PriorityUtils.sort(result, priorities);
        return result;
    }
    
    /**
     * Get the documentation for the given eobject.
     * @param eobject
     * @return the documentation
     */
    public static String getDocumentation (EObject eobject)
    {
        IDocumentable documentable = null;
        for (IDocumentable doc : documentables)
        {
            if (doc.canManage(eobject))
            {
                documentable = doc ;
                break ;
            }
        }
        if (documentable != null)
        {
            return documentable.getDocumentation(eobject);
        }
        return null ;
    }
    
    
}
