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

import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.jaxen.JaxenConstants;
import org.jaxen.emf.EMFXPath;
import org.jaxen.util.SingleObjectIterator;

public class EObjectAdapter extends ModelAdapter {
	
	private Map eObjectToURIAttribute;
	
	private Map eObjectToFeatureAttribute;

	public EObjectAdapter(EMFModelNavigator navigator) {
		super(navigator);
	}
	
	public boolean isElement(Object object) {
		return !isDocument(object);
	}
	
	public boolean isDocument(Object object) {
		return ((EObject) object).eContainer() == null;
	}

	public String getName(Object object) {
		EStructuralFeature feature = ((EObject) object).eContainingFeature();
		return feature == null ? null : feature.getName();
	}
	
	public Object getParentNode(Object object) {
		EObject eObject = (EObject) object;
		Object container = eObject.eContainer();
		return container == null ? eObject.eResource() : container;
	}
	
	public Iterator getAttributeAxisIterator(Object object) {
		EObject eObject = (EObject) object;
		ArrayList children = new ArrayList();
		children.add(getURIAttribute(eObject));
		
		EStructuralFeature containingFeature = eObject.eContainingFeature();
		if (containingFeature != null && FeatureMapUtil.isFeatureMap(containingFeature))
			children.add(getFeatureAttribute(eObject));
		
		for (Iterator i = eObject.eClass().getEAllAttributes().iterator(); i.hasNext();) {
			EStructuralFeature feature = (EStructuralFeature) i.next();
			if (feature.isMany())
				continue;
			
			Object value = eObject.eGet(feature);
			if (value == null)
				continue;
			
			FeatureValue featureValue = new FeatureValue(eObject, feature, value);
			children.add(navigator.getAttributeWrapper(featureValue));
		}
		
		return children.iterator();
	}
	
	public Iterator getAttributeAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		EObject eObject = (EObject) object;
		if (EMFXPath.EOBJECT_URI_ATTR_NAME.equals(localName) && EMFXPath.EMF_XPATH_NAMESPACE_URI.equals(namespaceURI))
			return new SingleObjectIterator(getURIAttribute(eObject));

		EStructuralFeature containingFeature;
		if (EMFXPath.FEATURE_MAP_ENTRY_FEATURE_ATTR_NAME.equals(localName)
				&& EMFXPath.EMF_XPATH_NAMESPACE_URI.equals(namespaceURI)
				&& (containingFeature = eObject.eContainingFeature()) != null
				&& FeatureMapUtil.isFeatureMap(containingFeature))
			return new SingleObjectIterator(getFeatureAttribute(eObject));
		
		if (namespaceURI == null || namespaceURI.length() == 0) {
			EStructuralFeature feature = eObject.eClass().getEStructuralFeature(localName);
			if (feature instanceof EAttribute && !feature.isMany()) {
				Object value = eObject.eGet(feature);
				if (value != null) {
					FeatureValue featureValue = new FeatureValue(eObject, feature, value);
					return new SingleObjectIterator(navigator.getAttributeWrapper(featureValue));
				}
			}
		}
		
		return JaxenConstants.EMPTY_ITERATOR;
	}
	
	private Object getURIAttribute(EObject object) {
		if (eObjectToURIAttribute == null)
			eObjectToURIAttribute = new IdentityHashMap();
		
		Object uriAttribute = eObjectToURIAttribute.get(object);
		if (uriAttribute == null) {
			uriAttribute = new URIAttribute(object);
			eObjectToURIAttribute.put(object, uriAttribute);
		}
		
		return uriAttribute;
	}
	
	private Object getFeatureAttribute(EObject eObject) {
		if (eObjectToFeatureAttribute == null)
			eObjectToFeatureAttribute = new IdentityHashMap();
		
		Object featureAttribute = eObjectToFeatureAttribute.get(eObject);
		if (featureAttribute == null) {
			featureAttribute = new FeatureAttribute(eObject);
			eObjectToFeatureAttribute.put(eObject, featureAttribute);
		}
		
		return featureAttribute;
	}
	
	public Iterator getChildAxisIterator(Object object) {
		EObject eObject = (EObject) object;
		ArrayList children = new ArrayList();
		for (Iterator i = eObject.eClass().getEAllStructuralFeatures().iterator(); i.hasNext();) {
			EStructuralFeature feature = (EStructuralFeature) i.next();
			if (feature.isMany()) {
				collectChildren(eObject, feature, children);
			} else if (feature instanceof EReference) {
				Object value = getChild(eObject, feature);
				if (value != null)
					children.add(value);
			}
		}
		
		return children.iterator();
	}
	
	private Iterator getChildAxisIterator(EObject object, EStructuralFeature feature) {
		if (feature.isMany()) {
			ArrayList values = new ArrayList();
			collectChildren((EObject) object, feature, values);
			return values.iterator();
		}

		Object value = getChild((EObject) object, feature);
		return value == null ? JaxenConstants.EMPTY_ITERATOR : new SingleObjectIterator(value);
	}
	
	private void collectChildren(EObject eObject, EStructuralFeature feature, Collection children) {
		Collection values = (Collection) eObject.eGet(feature);
		if (values == null || values.isEmpty())
			return;
		
		if (feature instanceof EReference && ((EReference) feature).isContainment()) {
			children.addAll(values);
			return;
		}
		
		boolean isFeatureMap = FeatureMapUtil.isFeatureMap(feature);
		int index = 0;
		for (Iterator i = values.iterator(); i.hasNext(); ++index) {
			Object value = i.next();
			if (isFeatureMap) {
				FeatureMap.Entry entry = (FeatureMap.Entry) value;
				EStructuralFeature entryFeature = entry.getEStructuralFeature();
				if (entryFeature instanceof EReference
						&& ((EReference) entryFeature).isContainment()
						&& eObject.eClass().getFeatureID(entryFeature) < 0) {
					children.add(entry.getValue());
					continue;
				}
			}
			
			FeatureValue featureValue = new FeatureValue(eObject, feature, index, value);
			children.add(navigator.getElementWrapper(featureValue));
		}
	}
	
	private Object getChild(EObject eObject, EStructuralFeature feature) {
		Object value = eObject.eGet(feature);
		if (value == null)
			return null;
		
		if (feature instanceof EReference && ((EReference) feature).isContainment())
			return value;
		
		FeatureValue featureValue = new FeatureValue(eObject, feature, value);
		return navigator.getElementWrapper(featureValue);
	}
	
	public Iterator getChildAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		if (namespaceURI == null || namespaceURI.length() == 0) {
			EStructuralFeature feature = ((EObject) object).eClass().getEStructuralFeature(localName);
			if (feature != null)
				return getChildAxisIterator((EObject) object, feature);
		}
		
		return JaxenConstants.EMPTY_ITERATOR;
	}
	
	private class URIAttribute extends Attribute {
		
		private final EObject eObject;
		
		public URIAttribute(EObject eObject) {
			this.eObject = eObject;
		}
		
		public String getName() {
			return EMFXPath.EOBJECT_URI_ATTR_NAME;
		}
		
		public String getNamespaceURI() {
			return EMFXPath.EMF_XPATH_NAMESPACE_URI;
		}
		
		public String getNamespacePrefix() {
			return EMFXPath.EMF_XPATH_NAMESPACE_PREFIX;
		}
		
		public Object getParentNode() {
			return eObject;
		}
		
		public Object getWrappedObject() {
			return EcoreUtil.getURI(eObject);
		}
	}
	
	private class FeatureAttribute extends Attribute {
		
		private final EObject eObject;
		
		public FeatureAttribute(EObject eObject) {
			this.eObject = eObject;
		}
		
		public String getName() {
			return EMFXPath.FEATURE_MAP_ENTRY_FEATURE_ATTR_NAME;
		}
		
		public String getNamespaceURI() {
			return EMFXPath.EMF_XPATH_NAMESPACE_URI;
		}
		
		public String getNamespacePrefix() {
			return EMFXPath.EMF_XPATH_NAMESPACE_PREFIX;
		}
		
		public Object getParentNode() {
			return eObject;
		}
		
		public Object getWrappedObject() {
			return eObject.eContainmentFeature();
		}
		
		public String toString() {
			return eObject.eContainmentFeature().getName();
		}
	}
}
