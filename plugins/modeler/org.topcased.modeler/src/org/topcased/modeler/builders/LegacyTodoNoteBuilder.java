/*****************************************************************************
 * Copyright (c) 2012 AtoS.
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
package org.topcased.modeler.builders;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.topcased.builder.ITaskTagExtension;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.Property;

/**
 * Identify element containing tag from Topcased diagram files.
 * 
 * @author AtoS (npn)
 */
public class LegacyTodoNoteBuilder implements ITaskTagExtension
{

    public static final String PROPERTY_KEY = ModelerPropertyConstants.NOTE_VALUE;

    private final List<String> DI_EXTS = Arrays.asList("umldi", "sysmldi", "samdi");
    
    public boolean accept(IFile file) {
    	if (file == null) {
    		return false;
    	}
    	String ext = file.getFileExtension();
    	if (ext == null) {
    		return false;
    	}
    	return DI_EXTS.contains(ext.toLowerCase());
    }

    public String analyse(EObject eobject) {
        if (eobject instanceof Property) {
            Property property = (Property) eobject;
            if (property.getKey().equals(PROPERTY_KEY) && property.getValue() != null) {
                return property.getValue();
            }
        }
        return null;
    }

	public IFile getEditingWrapper(IFile file) {
		return file;
	}
    
    public void addMarkerAttributes(IMarker marker, EObject context) {
    	// No specific data for the context
    }

    
    public static EObject getMarkedObject(IMarker marker, ResourceSet context) {
	    String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
	    if (uriAttribute == null) {
	    	return null;
	    }
        URI uri = URI.createURI(uriAttribute);
        Resource r = context.getResource(URI.createURI(uri.trimFragment().toString().replace(" ", "%20")), false);
        if (r == null) {
        	return null;
        }
        EObject eObject = r.getEObject(uri.fragment());
        if (eObject == null) {
        	return null;
        }
        		
        if (eObject instanceof Property) {
            EObject container = ((Property) eObject).eContainer();
            if (container instanceof GraphElement) {
                return((GraphElement) container);
            }
        }
        return eObject;


    }
    
}
