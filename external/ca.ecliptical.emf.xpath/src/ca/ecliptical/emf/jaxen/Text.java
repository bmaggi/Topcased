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

public class Text extends ModelWrapper {
	
	private final Object parentNode;
	
	private final Object value;

	public Text(Object parentNode, Object value) {
		this.parentNode = parentNode;
		this.value = value;
	}

	public Object getWrappedObject() {
		return value;
	}
	
	public Object getParentNode() {
		return parentNode;
	}
	
	public String toString() {
		return parentNode.toString();
	}
}
