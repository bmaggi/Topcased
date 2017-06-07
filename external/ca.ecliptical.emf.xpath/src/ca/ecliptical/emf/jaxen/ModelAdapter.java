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

import org.jaxen.JaxenConstants;

public abstract class ModelAdapter {
	
	protected final EMFModelNavigator navigator;
	
	public ModelAdapter(EMFModelNavigator navigator) {
		this.navigator = navigator;
	}

	public String getName(Object object) {
		return null;
	}
	
	public String getNamespaceURI(Object object) {
		return null;
	}
	
	public String getNamespacePrefix(Object object) {
		return null;
	}

	public boolean isDocument(Object object) {
		return false;
	}

	public boolean isElement(Object object) {
		return false;
	}

	public boolean isAttribute(Object object) {
		return false;
	}
	
	public boolean isText(Object object) {
		return false;
	}

	public Object getElementById(Object context, String elementId) {
		return null;
	}

	public Object getParentNode(Object object) {
		return null;
	}

	public Iterator getChildAxisIterator(Object object) {
		return JaxenConstants.EMPTY_ITERATOR;
	}

	public Iterator getAttributeAxisIterator(Object object) {
		return JaxenConstants.EMPTY_ITERATOR;
	}

	public Iterator getChildAxisIterator(Object object, String localName,
			String namespacePrefix, String namespaceURI) {
		return JaxenConstants.EMPTY_ITERATOR;
	}

	public Iterator getAttributeAxisIterator(Object object, String localName,
			String namespacePrefix, String namespaceURI) {
		return JaxenConstants.EMPTY_ITERATOR;
	}

	public String stringValueOf(Object object) {
		return object.toString();
	}
}
