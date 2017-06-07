/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.extensions;

import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to create a model hierarchy before the creation of a Diagram
 * 
 * Creation 3 mai 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface ICreationDiagram
{
    /**
     * This method should be used to create the necessary model hierachy that should be created to create a new diagram
     * that is not directly linked with the given EObject.
     * 
     * @param initialObject the model object on which the creation has been requested
     * @return EObject the real model object linked with the Diagram
     */
    EObject getLinkedElementWithDiagram(EObject initialObject);
}
