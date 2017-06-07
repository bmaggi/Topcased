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

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.jaxen.JaxenConstants;
import org.jaxen.emf.EMFXPath;
import org.jaxen.util.SingleObjectIterator;

public class ResourceAdapter extends ModelAdapter {
	
	private Map resourceToURIAttribute;
	
	public ResourceAdapter(EMFModelNavigator navigator) {
		super(navigator);
	}
	
	public boolean isElement(Object object) {
		return !isDocument(object);
	}
	
	public boolean isDocument(Object object) {
		return ((Resource) object).getResourceSet() == null;
	}

	public String getName(Object object) {
		return EMFXPath.RESOURCES_ELEMENT_NAME;
	}
	
	public Object getParentNode(Object object) {
		return ((Resource) object).getResourceSet();
	}
	
	public Iterator getAttributeAxisIterator(Object object) {
		Object uriAttribute = getURIAttribute(object);
		return uriAttribute == null ? JaxenConstants.EMPTY_ITERATOR : new SingleObjectIterator(uriAttribute);
	}
	
	public Iterator getAttributeAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		if (EMFXPath.RESOURCE_URI_ATTR_NAME.equals(localName) && (namespaceURI == null || namespaceURI.length() == 0))
			return getAttributeAxisIterator(object);
		
		return JaxenConstants.EMPTY_ITERATOR;
	}
	
	private Object getURIAttribute(Object object) {
		if (resourceToURIAttribute == null)
			resourceToURIAttribute = new IdentityHashMap();
		
		if (resourceToURIAttribute.containsKey(object))
			return resourceToURIAttribute.get(object);

		Object uriAttribute = createURIAttribute((Resource) object);
		resourceToURIAttribute.put(object, uriAttribute);
		return uriAttribute;
	}
	
	private Object createURIAttribute(Resource resource) {
		if (resource.getURI() == null)
			return null;
		
		return new URIAttribute(resource);
	}
	
	public Iterator getChildAxisIterator(Object object) {
		return ((Resource) object).getContents().iterator();
	}
	
	public Iterator getChildAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		if (EMFXPath.RESOURCE_CONTENTS_ELEMENT_NAME.equals(localName) && (namespaceURI == null || namespaceURI.length() == 0))
			return getChildAxisIterator(object);

		return JaxenConstants.EMPTY_ITERATOR;
	}
	
	public Object getElementById(Object context, String elementId) {
		Resource resource = (Resource) context;
		Object object = null;
		try {
			URI uri = URI.createURI(elementId);
			if (uri.hasPath()) {
				if (uri.trimFragment().equals(resource.getURI())) {
					if (uri.hasFragment())
						object = resource.getEObject(uri.fragment());
					else
						object = resource;
				}
			} else if (uri.hasFragment()) {
				object = resource.getEObject(uri.fragment());
			}
		} catch (IllegalArgumentException e) {
			// ignore
		}
		
		return object;
	}
	
	private class URIAttribute extends Attribute {

		private final Resource resource;
		
		public URIAttribute(Resource resource) {
			this.resource = resource;
		}
		
		public String getName() {
			return EMFXPath.RESOURCE_URI_ATTR_NAME;
		}
		
		public Object getParentNode() {
			return resource;
		}
		
		public Object getWrappedObject() {
			return resource.getURI();
		}
	}
}
