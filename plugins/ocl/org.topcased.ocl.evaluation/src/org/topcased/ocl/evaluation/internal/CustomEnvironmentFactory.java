/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos - initial API and implementation
 ******************************************************************************/
package org.topcased.ocl.evaluation.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;

public class CustomEnvironmentFactory extends EcoreEnvironmentFactory {

	public static CustomEnvironmentFactory INSTANCE = new CustomEnvironmentFactory();
	
	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
		EcoreEvaluationEnvironment coreEvaluationEnvironment = (EcoreEvaluationEnvironment) super.createEvaluationEnvironment();
		CustomEvaluationEnvironment customEvaluationEnvironment = new CustomEvaluationEnvironment();
		customEvaluationEnvironment.setBaseEvaluationEnvironment(coreEvaluationEnvironment);
		return customEvaluationEnvironment;
	}
	
}
