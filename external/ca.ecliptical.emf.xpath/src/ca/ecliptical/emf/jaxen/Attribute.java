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

public abstract class Attribute extends ModelWrapper {
	
	public abstract String getName();
	
	public String getNamespaceURI() {
		return null;
	}
	
	public String getNamespacePrefix() {
		return null;
	}
	
	public abstract Object getParentNode();
}
