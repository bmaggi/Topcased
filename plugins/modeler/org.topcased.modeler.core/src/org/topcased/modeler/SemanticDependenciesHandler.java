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
package org.topcased.modeler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extension of the {@link SemanticDependenciesDetector} interface used by the
 * <code>org.topcased.modeler.semanticDependencies</code> extension point. Extensions which implement this interface
 * instead of the basic SemanticDependenciesDetector will get additional notifications after the export and before the
 * import so they can optionally adjust the models at these points.
 * <p>
 * A new instance of the implementation class will be created for each export and import operation. For the import
 * operation, it is guaranteed that the same instance will be used for both {@link #beforeImport(Resource, Resource)
 * before} and {@link #afterImport(EObject) after} hooks, so that object can store information gathered in the import
 * hook in instance variables and still have access to them in the post-import hook.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 * @since Topcased 2.1
 */
public interface SemanticDependenciesHandler extends SemanticDependenciesDetector
{
    /**
     * Called right after the sub-model and its dependencies have been exported in the two specified resources, but
     * before they are saved.
     * 
     * @param partResource the resource in which the exported sub-model copy has been put.
     * @param cacheResource the resource in which the dependencies of the exported sub-model has been put.
     */
    void afterExport(Resource partResource, Resource cacheResource);

    /**
     * Called right before a new version of a sub-model is imported to replace the locally controlled version.
     * 
     * @param controlledResource the current (local, controlled) version of the sub-model, as a part of the main model.
     * @param exportedResource the new (remote, exported) version of the sub-mode, which will replace the current one
     *        after the import.
     */
    void beforeImport(Resource controlledResource, Resource exportedResource);

    /**
     * Called right after a new version of a sub-model has been imported, replace the locally controlled version.
     * 
     * @param controlledResource the controlled resource containing the newly imported model.
     */
    void afterImport(Resource controlledResource);
}
