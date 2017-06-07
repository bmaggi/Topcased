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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jaxen.DefaultNavigator;
import org.jaxen.JaxenConstants;
import org.jaxen.NamedAccessNavigator;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.XPath;
import org.jaxen.emf.EMFXPath;
import org.jaxen.saxpath.SAXPathException;
import org.jaxen.util.SingleObjectIterator;

/**
 * Implements XPath navigation for EMF models.
 */
public class EMFModelNavigator extends DefaultNavigator implements NamedAccessNavigator {
	
	private static final long serialVersionUID = -8999888935301181428L;
	
	private ModelAdapter attributeAdapter;
	
	private ModelAdapter eObjectAdapter;
	
	private ModelAdapter featureValueElementAdapter;
	
	private ModelAdapter resourceAdapter;
	
	private ModelAdapter resourceSetAdapter;
	
	private ModelAdapter textAdapter;
	
	private Map featureValueToElement;
	
	private Map featureValueToAttribute;
	
	protected Object getElementWrapper(FeatureValue featureValue) {
		if (featureValueToElement == null)
			featureValueToElement = new IdentityHashMap();
		
		Object wrapper = featureValueToElement.get(featureValue);
		if (wrapper == null) {
			wrapper = createElementWrapper(featureValue);
			featureValueToElement.put(featureValue, wrapper);
		}
		
		return wrapper;
	}
	
	protected Object createElementWrapper(FeatureValue featureValue) {
		return new FeatureValueElement(featureValue);
	}
	
	protected Object getAttributeWrapper(FeatureValue featureValue) {
		if (featureValueToAttribute == null)
			featureValueToAttribute = new IdentityHashMap();
		
		Object wrapper = featureValueToAttribute.get(featureValue);
		if (wrapper == null) {
			wrapper = createAttributeWrapper(featureValue);
			featureValueToAttribute.put(featureValue, wrapper);
		}
		
		return wrapper;
	}
	
	protected Object createAttributeWrapper(FeatureValue featureValue) {
		return new FeatureValueAttribute(featureValue);
	}
	
	public String getElementNamespaceUri(Object element) {
		ModelAdapter adapter = getAdapter(element);
		return adapter == null ? null : adapter.getNamespaceURI(element);
	}

	public String getElementName(Object element) {
		ModelAdapter adapter = getAdapter(element);
		return adapter == null ? null : adapter.getName(element);
	}

	public String getElementQName(Object element) {
		ModelAdapter adapter = getAdapter(element);
		if (adapter == null)
			return null;
		
		String prefix = adapter.getNamespacePrefix(element);
		String name = adapter.getName(element);
		return prefix == null ? name : prefix + ':' + name;
	}

	public String getAttributeNamespaceUri(Object attr) {
		ModelAdapter adapter = getAdapter(attr);
		return adapter == null ? null : adapter.getNamespaceURI(attr);
	}

	public String getAttributeName(Object attr) {
		ModelAdapter adapter = getAdapter(attr);
		return adapter == null ? null : adapter.getName(attr);
	}

	public String getAttributeQName(Object attr) {
		ModelAdapter adapter = getAdapter(attr);
		if (adapter == null)
			return null;
		
		String prefix = adapter.getNamespacePrefix(attr);
		String name = adapter.getName(attr);
		return prefix == null ? name : prefix + ':' + name;
	}

	public boolean isDocument(Object object) {
		ModelAdapter adapter = getAdapter(object);
		return adapter == null ? false : adapter.isDocument(object);
	}

	public boolean isElement(Object object) {
		ModelAdapter adapter = getAdapter(object);
		return adapter == null ? false : adapter.isElement(object);
	}

	public boolean isAttribute(Object object) {
		ModelAdapter adapter = getAdapter(object);
		return adapter == null ? false : adapter.isAttribute(object);
	}

	public boolean isNamespace(Object object) {
		// not supported
		return false;
	}

	public boolean isComment(Object object) {
		// not supported
		return false;
	}

	public boolean isText(Object object) {
		ModelAdapter adapter = getAdapter(object);
		return adapter == null ? false : adapter.isText(object);
	}

	public boolean isProcessingInstruction(Object object) {
		// not supported
		return false;
	}

	public String getCommentStringValue(Object comment) {
		// not supported
		return null;
	}

	public String getElementStringValue(Object element) {
		ModelAdapter adapter = getAdapter(element);
		return adapter == null ? null : adapter.stringValueOf(element);
	}

	public String getAttributeStringValue(Object attr) {
		ModelAdapter adapter = getAdapter(attr);
		return adapter == null ? null : adapter.stringValueOf(attr);
	}

	public String getNamespaceStringValue(Object ns) {
		// not supported
		return null;
	}

	public String getTextStringValue(Object text) {
		// not supported
		return null;
	}

	public String getNamespacePrefix(Object ns) {
		// not supported
		return null;
	}

	public XPath parseXPath(String xpath) throws SAXPathException {
		return new EMFXPath(xpath);
	}

	public Object getElementById(Object contextNode, String elementId) {
		Object document = getDocumentNode(contextNode);
		if (document == null)
			return null;
		
		ModelAdapter adapter = getAdapter(document);
		return adapter == null ? null : adapter.getElementById(document, elementId);
	}
	
	public Object getDocumentNode(Object contextNode) {
		if (contextNode instanceof Text)
			contextNode = ((Text) contextNode).getParentNode();
		
		if (contextNode instanceof Attribute)
			contextNode = ((Attribute) contextNode).getParentNode();
		
		while (contextNode instanceof FeatureValueElement)
			contextNode = ((FeatureValueElement) contextNode).getFeatureValue().getParent();
		
		if (contextNode instanceof EObject) {
			EObject eObject = (EObject) contextNode;
			contextNode = eObject.eResource();
			if (contextNode == null)
				return EcoreUtil.getRootContainer(eObject);
		}
		
		if (contextNode instanceof Resource) {
			Resource resource = (Resource) contextNode;
			contextNode = resource.getResourceSet();
			if (contextNode == null)
				return resource;
		}
		
		return contextNode;
	}
	
	public Object getParentNode(Object object) throws UnsupportedAxisException {
		ModelAdapter adapter = getAdapter(object);
		if (adapter == null)
			throw new UnsupportedAxisException("Invalid node type.");
		
		return adapter.getParentNode(object);
	}
	
	public Iterator getChildAxisIterator(Object object) throws UnsupportedAxisException {
		ModelAdapter adapter = getAdapter(object);
		if (adapter == null)
			throw new UnsupportedAxisException("Invalid node type.");
		
		return adapter.getChildAxisIterator(object);
	}
	
	public Iterator getParentAxisIterator(Object object) throws UnsupportedAxisException {
		Object parent = getParentNode(object);		
		if (parent != null)
			return new SingleObjectIterator(parent);
		
		return JaxenConstants.EMPTY_ITERATOR;
	}
	
	public Iterator getAttributeAxisIterator(Object object) throws UnsupportedAxisException {
		ModelAdapter adapter = getAdapter(object);
		if (adapter == null)
			throw new UnsupportedAxisException("Invalid node type.");
		
		return adapter.getAttributeAxisIterator(object);
	}

	public Iterator getChildAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) throws UnsupportedAxisException {
		ModelAdapter adapter = getAdapter(object);
		if (adapter == null)
			throw new UnsupportedAxisException("Invalid node type.");
		
		return adapter.getChildAxisIterator(object, localName, namespacePrefix, namespaceURI);
	}

	public Iterator getAttributeAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) throws UnsupportedAxisException {
		ModelAdapter adapter = getAdapter(object);
		if (adapter == null)
			throw new UnsupportedAxisException("Invalid node type.");
		
		return adapter.getAttributeAxisIterator(object, localName, namespacePrefix, namespaceURI);
	}
	
	protected ModelAdapter getAdapter(Object object) {
		if (object instanceof Attribute)
			return attributeAdapter == null ? attributeAdapter = createAttributeAdapter() : attributeAdapter;
			
		if (object instanceof EObject)
			return eObjectAdapter == null ? eObjectAdapter = createEObjectAdapter() : eObjectAdapter;
			
		if (object instanceof FeatureValueElement)
			return featureValueElementAdapter == null ? featureValueElementAdapter = createFeatureValueElementAdapter() : featureValueElementAdapter;
			
		if (object instanceof Resource)
			return resourceAdapter == null ? resourceAdapter = createResourceAdapter() : resourceAdapter;
			
		if (object instanceof ResourceSet)
			return resourceSetAdapter == null ? resourceSetAdapter = createResourceSetAdapter() : resourceSetAdapter;
			
		if (object instanceof Text)
			return textAdapter == null ? textAdapter = createTextAdapter() : textAdapter;
			
		return null;
	}
	
	protected ModelAdapter createAttributeAdapter() {
		return new AttributeAdapter(this);
	}
	
	protected ModelAdapter createEObjectAdapter() {
		return new EObjectAdapter(this);
	}
	
	protected ModelAdapter createFeatureValueElementAdapter() {
		return new FeatureValueElementAdapter(this);
	}
	
	protected ModelAdapter createResourceAdapter() {
		return new ResourceAdapter(this);
	}
	
	protected ModelAdapter createResourceSetAdapter() {
		return new ResourceSetAdapter(this);
	}
	
	protected ModelAdapter createTextAdapter() {
		return new TextAdapter(this);
	}
}
