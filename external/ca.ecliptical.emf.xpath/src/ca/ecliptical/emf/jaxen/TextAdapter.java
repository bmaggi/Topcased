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

public class TextAdapter extends ModelAdapter {

	public TextAdapter(EMFModelNavigator navigator) {
		super(navigator);
	}
	
	public boolean isText(Object object) {
		return true;
	}

	public Object getParentNode(Object object) {
		return ((Text) object).getParentNode();
	}
}
