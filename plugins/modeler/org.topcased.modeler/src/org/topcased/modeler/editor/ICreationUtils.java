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
package org.topcased.modeler.editor;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.GraphElement;

/**
 * This interface offers CreationUtils methods for the currently edited diagram
 * <br>
 * created 19 avr. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * 
 */
public interface ICreationUtils
{

    /**
     * Create the GraphElement with its initial children and a given presentation
     * 
     * @param obj the model object
     * @return the GraphElement
     */
    public GraphElement createGraphElement(EObject obj);
    
    /**
     * Create the GraphElement with its initial children and a given presentation
     * 
     * @param obj the model object
     * @param presentation the presentation of the graphical element
     * @return the GraphElement
     */
    public GraphElement createGraphElement(EObject obj, String presentation);

    /**
     * Create the ModelObject with its initial children
     * 
     * @param obj the model object
     * @return the model object with its children
     * @deprecated should be removed in the next major release
     */
    public EObject createModelObject(EObject obj);

}
