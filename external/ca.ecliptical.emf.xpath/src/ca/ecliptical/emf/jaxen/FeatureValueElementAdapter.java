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

import org.eclipse.emf.ecore.EAttribute;
import org.jaxen.JaxenConstants;
import org.jaxen.util.SingleObjectIterator;

public class FeatureValueElementAdapter extends ModelAdapter {
	
	public FeatureValueElementAdapter(EMFModelNavigator navigator) {
		super(navigator);
	}

	public boolean isElement(Object object) {
		return true;
	}
	
	public Object getParentNode(Object object) {
		return ((FeatureValueElement) object).getFeatureValue().getParent();
	}
	
	public String getName(Object object) {
		return ((FeatureValueElement) object).getFeatureValue().getFeature().getName();
	}
	
	public Iterator getAttributeAxisIterator(Object object) {
		return ((FeatureValueElement) object).getAttributeAxisIterator(object);
	}
	
	public Iterator getAttributeAxisIterator(Object object, String localName, String namespacePrefix, String namespaceURI) {
		return ((FeatureValueElement) object).getAttributeAxisIterator(object, localName, namespacePrefix, namespaceURI);
	}
	
	public Iterator getChildAxisIterator(Object object) {
		FeatureValueElement wrapper = (FeatureValueElement) object;
		if (!(wrapper.getFeatureValue().getFeature() instanceof EAttribute))
			return JaxenConstants.EMPTY_ITERATOR;
		
		return new SingleObjectIterator(wrapper.getText());
	}
}
