/*******************************************************************************
 * Copyright (c) 2006 Ecliptical Software Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ecliptical Software Inc. - initial API and implementation
 *******************************************************************************/
package ca.ecliptical.emf.jaxen;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.jaxen.JaxenConstants;
import org.jaxen.emf.EMFXPath;

public class ResourceSetAdapter extends ModelAdapter {
	
	public ResourceSetAdapter(EMFModelNavigator navigator) {
		super(navigator);
	}

	public boolean isDocument(Object object) {
		return true;
	}
	
	public Iterator getChildAxisIterator(Object object) {
		return ((ResourceSet) object).getResources().iterator();
	}
	
	public Iterator getChildAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		if (EMFXPath.RESOURCES_ELEMENT_NAME.equals(localName) && (namespaceURI == null || namespaceURI.length() == 0))
			return getChildAxisIterator(object);
		
		return JaxenConstants.EMPTY_ITERATOR;
	}
	
	public Object getElementById(Object context, String elementId) {
		ResourceSet resourceSet = (ResourceSet) context;
		Object object = null;
		try {
			URI uri = URI.createURI(elementId);
			if (uri.hasFragment())
				object = resourceSet.getEObject(uri, true);
			else
				object = resourceSet.getResource(uri, true);
		} catch (IllegalArgumentException e) {
			// ignore
		}
		
		return object;
	}
}
