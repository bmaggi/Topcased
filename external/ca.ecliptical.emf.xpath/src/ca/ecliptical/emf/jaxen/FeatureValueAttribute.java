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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class FeatureValueAttribute extends Attribute {
	
	private final FeatureValue featureValue;

	public FeatureValueAttribute(FeatureValue featureValue) {
		this.featureValue = featureValue;
	}

	public String getName() {
		return featureValue.getFeature().getName();
	}

	public Object getParentNode() {
		return featureValue.getParent();
	}

	public Object getWrappedObject() {
		return featureValue.getValue();
	}
	
	public String toString() {
		EDataType dataType = ((EAttribute) featureValue.getFeature()).getEAttributeType();
		Object value = featureValue.getValue();
		return EcoreUtil.convertToString(dataType, value);
	}
}
