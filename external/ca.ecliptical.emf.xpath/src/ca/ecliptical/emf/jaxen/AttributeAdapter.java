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

public class AttributeAdapter extends ModelAdapter {

	public AttributeAdapter(EMFModelNavigator navigator) {
		super(navigator);
	}

	public boolean isAttribute(Object object) {
		return true;
	}
	
	public String getName(Object object) {
		return ((Attribute) object).getName();
	}
	
	public String getNamespaceURI(Object object) {
		return ((Attribute) object).getNamespaceURI();
	}
	
	public String getNamespacePrefix(Object object) {
		return ((Attribute) object).getNamespacePrefix();
	}
	
	public Object getParentNode(Object object) {
		return ((Attribute) object).getParentNode();
	}
}
