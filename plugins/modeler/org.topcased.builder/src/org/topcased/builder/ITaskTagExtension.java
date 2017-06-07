/*****************************************************************************
 * Copyright (c) 2012 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  N. PERANSIN (AtoS) nicolas.peransin@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;

/**
 * The contract to extract tags from model element.
 * 
 * @author Atos (npn)
 */
public interface ITaskTagExtension
{

    /**
     * Determine if the extension can manage the file in parameter.
     * 
     * @param file
     * @return true if managed
     */
    boolean accept(IFile file);

    /**
     * Analyse this eobject and if it recognized returns the string to parse
     * 
     * @param eobject
     * @return the string of tagged object or null
     */
    String analyse(EObject eobject);

    IFile getEditingWrapper(IFile file);

    void addMarkerAttributes(IMarker marker, EObject context);

}
