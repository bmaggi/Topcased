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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Represents an EObject's feature setting.
 */
public class FeatureValue {
	
	private final Object parent;
	
	private final EStructuralFeature feature;
	
	private final int index;
	
	private final Object value;

	public FeatureValue(Object parent, EStructuralFeature feature, int index, Object value) {
		this.parent = parent;
		this.feature = feature;
		this.index = index;
		this.value = value;
	}

	public FeatureValue(Object parent, EStructuralFeature feature, Object value) {
		this(parent, feature, -1, value);
	}
	
	public Object getParent() {
		return parent;
	}
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getIndex() {
		return index;
	}
	
	public Object getValue() {
		return value;
	}
	
	public boolean equals(Object object) {
		if (object == this)
			return true;
		
		if (!(object instanceof FeatureValue))
			return false;
			
		FeatureValue other = (FeatureValue) object;
		return parent == other.parent
			&& feature == other.feature
			&& index == other.index;
	}
	
	public int hashCode() {
		int c = 17;
		c = 37 * c + parent.hashCode();
		c = 37 * c + feature.hashCode();
		c = 37 * c + index;
		return c;
	}
}
