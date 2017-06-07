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
import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.jaxen.JaxenConstants;
import org.jaxen.emf.EMFXPath;
import org.jaxen.util.SingleObjectIterator;

public class FeatureValueElement extends ModelWrapper {

	private final FeatureValue featureValue;
	
	private URIAttribute uriAttribute;
	
	private FeatureAttribute featureAttribute;
	
	private Text text;

	public FeatureValueElement(FeatureValue featureValue) {
		this.featureValue = featureValue;
	}

	public FeatureValue getFeatureValue() {
		return featureValue;
	}
	
	public Object getWrappedObject() {
		Object value = featureValue.getValue();
		return value instanceof FeatureMap.Entry ? ((FeatureMap.Entry) value).getValue() : value;
	}
	
	public Text getText() {
		if (text == null)
			text = new Text(this, getWrappedObject());

		return text;
	}
	
	public Iterator getAttributeAxisIterator(Object object) {
		FeatureValueElement wrapper = (FeatureValueElement) object;
		FeatureValue featureValue = wrapper.getFeatureValue();
		ArrayList attrs = new ArrayList(1);
		if (featureValue.getFeature() instanceof EReference) {
			if (uriAttribute == null)
				uriAttribute = new URIAttribute();
			
			attrs.add(uriAttribute);
			
			if (FeatureMapUtil.isFeatureMap(featureValue.getFeature())) {
				if (featureAttribute == null)
					featureAttribute = new FeatureAttribute();
				
				attrs.add(featureAttribute);
			}
		}

		return attrs.iterator();
	}
	
	public Iterator getAttributeAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		if (EMFXPath.EOBJECT_URI_ATTR_NAME.equals(localName) && EMFXPath.EMF_XPATH_NAMESPACE_URI.equals(namespaceURI))
			return new SingleObjectIterator(uriAttribute == null ? uriAttribute = new URIAttribute() : uriAttribute);

		if (EMFXPath.FEATURE_MAP_ENTRY_FEATURE_ATTR_NAME.equals(localName)
				&& EMFXPath.EMF_XPATH_NAMESPACE_URI.equals(namespaceURI)
				&& FeatureMapUtil.isFeatureMap(featureValue.getFeature()))
			return new SingleObjectIterator(featureAttribute == null ? featureAttribute = new FeatureAttribute() : featureAttribute);
		
		return JaxenConstants.EMPTY_ITERATOR;
	}

	public String toString() {
		if (featureValue.getFeature() instanceof EReference)
			return super.toString();

		Object value = featureValue.getValue();
		EStructuralFeature feature = featureValue.getFeature();
		if (value instanceof FeatureMap.Entry) {
			FeatureMap.Entry entry = (FeatureMap.Entry) value;
			feature = entry.getEStructuralFeature();
			value = entry.getValue();
		}
		
		if (feature instanceof EAttribute) {
			EDataType dataType = ((EAttribute) feature).getEAttributeType();
			return EcoreUtil.convertToString(dataType, value);
		}
		
		return super.toString();
	}
	
	private class URIAttribute extends Attribute {
		
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
			return FeatureValueElement.this;
		}
		
		public Object getWrappedObject() {
			return EcoreUtil.getURI((EObject) featureValue.getValue());
		}
	}

	private class FeatureAttribute extends Attribute {
		
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
			return FeatureValueElement.this;
		}
		
		public Object getWrappedObject() {
			return ((FeatureMap.Entry) featureValue.getValue()).getEStructuralFeature();
		}
		
		public String toString() {
			return ((FeatureMap.Entry) featureValue.getValue()).getEStructuralFeature().getName();
		}
	}
}
