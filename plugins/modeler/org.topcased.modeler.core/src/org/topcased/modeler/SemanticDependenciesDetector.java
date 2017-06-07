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

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.internal.actions.ExportSubmodelAction;

/**
 * An interface that extensions can implement to contribute additional elements to the cache resource exported with
 * sub-models.
 * <p>
 * By default, when a controlled sub-model is exported using the {@link ExportSubmodelAction}, the cache resource
 * created to make it autonomous only contains strict dependencies required by EMF to load the model. Depending on the
 * meta-model, there may be other important semantic dependencies which are not directly connected to the exported
 * elements at the EMF level. A typical example is UML stereotypes and profile applications, which are not reference
 * from the target element they apply to, and thus can not be detected by the meta-model-agnostic algorithm.
 * <p>
 * Concrete implementations of this interface for a specific meta-model (identified by its nsURI) can be registered
 * using the <code>org.topcased.modeler.semanticDependencies</code> extension point. If several detectors are registered
 * for a given meta-model, the set of semantic dependencies put in the cache will be the union of their individual
 * contributions.
 * 
 * @see ExportSubmodelAction
 * @see SemanticDependenciesHandler
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public interface SemanticDependenciesDetector
{
    /**
     * Find all the direct semantic dependencies of model element <code>obj</code>.
     * 
     * @param obj a model element
     * @return the set of all the elements on which <code>obj</code> directly depends on semantically but for which it
     *         has no references at the EMF/Ecore level.
     */
    Set<EObject> getSemanticDependencies(EObject obj);
}
