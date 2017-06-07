/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.topcased.modeler.SemanticDependenciesDetector;
import org.topcased.modeler.SemanticDependenciesHandler;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Utility to retrieve and load extensions which provide a {@link SemanticDependenciesDetector}, and give easy access to
 * them to clients.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class SemanticDependenciesManager
{
    private static SemanticDependenciesManager INSTANCE = new SemanticDependenciesManager();
    
    public static SemanticDependenciesManager getInstance()
    {
        return INSTANCE;
    }
    
    private static final String EXTENSION_POINT_NAMESPACE = "org.topcased.modeler";

    private static final String EXTENSION_POINT_NAME = "semanticDependencies";

    private static final String DETECTOR_ELEMENT_NAME = "detector";

    private static final String METAMODEL_ATTRIBUTE_NAME = "metamodel";

    private static final String IMPLEMENTATION_ATTRIBUTE_NAME = "class";

    private final Map<String, SemanticDependenciesDetector> allDetectors;

    private static final SemanticDependenciesDetector NULL_DETECTOR = new NullDetector();

    public SemanticDependenciesManager()
    {
        allDetectors = new HashMap<String, SemanticDependenciesDetector>();
        loadAllDetectors();
    }

    private void loadAllDetectors()
    {
        Map<String, Collection<SemanticDependenciesDetector>> detectors = new HashMap<String, Collection<SemanticDependenciesDetector>>();

        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EXTENSION_POINT_NAMESPACE, EXTENSION_POINT_NAME);
        for (IExtension extension : extensionPoint.getExtensions())
        {
            for (IConfigurationElement cfg : extension.getConfigurationElements())
            {
                if (DETECTOR_ELEMENT_NAME.equals(cfg.getName()))
                {
                    String metamodel = cfg.getAttribute(METAMODEL_ATTRIBUTE_NAME);
                    if (metamodel == null)
                    {
                        ModelerPlugin.log("Invalid configuration element: missing meta-model attribute.", IStatus.WARNING);
                        continue;
                    }
                    try
                    {
                        SemanticDependenciesDetector detector = (SemanticDependenciesDetector) cfg.createExecutableExtension(IMPLEMENTATION_ATTRIBUTE_NAME);
                        Collection<SemanticDependenciesDetector> implementers = detectors.get(metamodel);
                        if (implementers == null)
                        {
                            implementers = new ArrayList<SemanticDependenciesDetector>();
                            detectors.put(metamodel, implementers);
                        }
                        implementers.add(detector);
                    }
                    catch (CoreException e)
                    {
                        ModelerPlugin.log(e);
                    }
                }
            }
        }

        // If some meta-models have several detectors registered, merge them into a single
        // CombinedSemanticDependenciesDetector to provide a simpler interface to clients, with always exactly one
        // detector.
        for (Map.Entry<String, Collection<SemanticDependenciesDetector>> entry : detectors.entrySet())
        {
            String metamodel = entry.getKey();
            Collection<SemanticDependenciesDetector> dets = entry.getValue();
            if (dets.isEmpty())
            {
                continue;
            }
            else if (dets.size() == 1)
            {
                allDetectors.put(metamodel, dets.iterator().next());
            }
            else
            {
                allDetectors.put(metamodel, new CombinedSemanticDependenciesDetector(dets));
            }
        }
    }

    public SemanticDependenciesDetector getDetectorFor(EObject obj)
    {
        return getDetectorFor(obj.eClass().getEPackage().getNsURI());
    }

    public SemanticDependenciesDetector getDetectorFor(String metamodelId)
    {
        SemanticDependenciesDetector detector = allDetectors.get(metamodelId);
        if (detector != null)
        {
            return detector;
        }
        else
        {
            return NULL_DETECTOR;
        }
    }

    private static class NullDetector implements SemanticDependenciesHandler
    {
        public Set<EObject> getSemanticDependencies(EObject obj)
        {
            return Collections.emptySet();
        }
        
        public void afterExport(Resource partResource, Resource cacheResource)
        {
            // Do nothing.
        }

        public void beforeImport(Resource controlledResource, Resource exportedResource)
        {
            // Do nothing.
        }

        public void afterImport(Resource controlledResource)
        {
            // Do nothing.
        }
    }

    /**
     * A {@link SemanticDependenciesDetector} which combines the result of several other detectors. This class is used
     * to collect every {@link SemanticDependenciesDetector} associated to a given meta-model into a single detector.
     */
    private static class CombinedSemanticDependenciesDetector implements SemanticDependenciesHandler
    {
        private final Collection<SemanticDependenciesDetector> detectors;

        public CombinedSemanticDependenciesDetector(Collection<SemanticDependenciesDetector> detectors)
        {
            this.detectors = new ArrayList<SemanticDependenciesDetector>(detectors);
        }

        public Set<EObject> getSemanticDependencies(EObject obj)
        {
            Set<EObject> result = new HashSet<EObject>();
            for (SemanticDependenciesDetector detector : detectors)
            {
                result.addAll(detector.getSemanticDependencies(obj));
            }
            return result;
        }
        
        public void afterExport(Resource partResource, Resource cacheResource)
        {
            // Only call the hooks for the detectors which implement them.
            for (SemanticDependenciesDetector detector : detectors)
            {
                if (detector instanceof SemanticDependenciesHandler)
                {
                    ((SemanticDependenciesHandler) detector).afterExport(partResource, cacheResource);
                }
            }
        }

        public void beforeImport(Resource controlledResource, Resource exportedResource)
        {
            // Only call the hooks for the detectors which implement them.
            for (SemanticDependenciesDetector detector : detectors)
            {
                if (detector instanceof SemanticDependenciesHandler)
                {
                    ((SemanticDependenciesHandler) detector).beforeImport(controlledResource, exportedResource);
                }
            }
        }
        
        public void afterImport(Resource controlledResource)
        {
            // Only call the hooks for the detectors which implement them.
            for (SemanticDependenciesDetector detector : detectors)
            {
                if (detector instanceof SemanticDependenciesHandler)
                {
                    ((SemanticDependenciesHandler) detector).afterImport(controlledResource);
                }
            }
        }
    }
}
