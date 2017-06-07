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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.util.Tuple;
import org.topcased.ocl.evaluation.Activator;
import org.topcased.ocl.evaluation.interfaces.CustomOperation;

/**
 * Decorator used to inject java method (as EOperations) directly in an ocl evaluation environment.
 * 
 * @author omelois
 * 
 */
public class CustomEvaluationEnvironment extends EcoreEvaluationEnvironment implements EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> {

	private Map<String, CustomOperation> customOperations = new HashMap<String, CustomOperation>();

	private EcoreEvaluationEnvironment baseEvaluationEnvironment;

	//The developer should not forget to set a base environment.
	@SuppressWarnings("deprecation")
	public CustomEvaluationEnvironment() {
	}


	protected CustomEvaluationEnvironment(EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		super(parent);
	}



	public void setBaseEvaluationEnvironment(EcoreEvaluationEnvironment baseEvaluationEnvironment) {
		this.baseEvaluationEnvironment = baseEvaluationEnvironment;
	}


	/**
	 * Adds a custom operation to this environment.
	 * 
	 * @param operation
	 */
	public void addCustomJavaOperation(CustomOperation operation) {
		customOperations.put(operation.getName(), operation);
	}

	@Override
	public Object callOperation(EOperation operation, int opcode, Object source, Object[] args) throws IllegalArgumentException {
		String operationName = operation.getName();
		CustomOperation customOperation = customOperations.get(operationName);
		if(customOperation != null && customOperation.check(source, args)) {
			return customOperation.execute(source, args);
		}
		for (int i = 0; i<args.length; i++){
			if (args[i] == null){
				StringBuilder message = new StringBuilder("NULL ARGUMENT WARNING : ");
				message.append(operationName);
				message.append(" on element ");
				message.append(source.toString());
				message.append(" with " + i + "th argument null");
				message.append(args.toString());
				Activator.logWarning(new IllegalArgumentException(message.toString()));
			}
		}
		
		//If the operation is not a custom one, calling the base eval environment method.
		return baseEvaluationEnvironment.callOperation(operation, opcode, source, args);
	}


	//DECORATION METHODS.

	@Override
	public Object getValueOf(String name) {
		return baseEvaluationEnvironment.getValueOf(name);
	}

	@Override
	public void replace(String name, Object value) {
		baseEvaluationEnvironment.replace(name, value);
	}

	@Override
	public void add(String name, Object value) {
		baseEvaluationEnvironment.add(name, value);
	}

	@Override
	public Object remove(String name) {
		return baseEvaluationEnvironment.remove(name);
	}

	@Override
	public void clear() {
		baseEvaluationEnvironment.clear();
	}

	@Override
	public boolean overrides(EOperation operation, int opcode) {
		return baseEvaluationEnvironment.overrides(operation, opcode);
	}

	@Override
	public Object navigateProperty(EStructuralFeature property, List<?> qualifiers, Object source) throws IllegalArgumentException {
		return baseEvaluationEnvironment.navigateProperty(property, qualifiers, source);
	}

	@Override
	public Object navigateAssociationClass(EClassifier associationClass, EStructuralFeature navigationSource, Object source) throws IllegalArgumentException {
		return baseEvaluationEnvironment.navigateAssociationClass(associationClass, navigationSource, source);
	}

	@Override
	public Map<EClass, Set<EObject>> createExtentMap(Object object) {
		return baseEvaluationEnvironment.createExtentMap(object);
	}

	@Override
	public boolean isKindOf(Object object, EClassifier classifier) {
		return baseEvaluationEnvironment.isKindOf(object, classifier);
	}

	@Override
	public boolean isTypeOf(Object object, EClassifier classifier) {
		return baseEvaluationEnvironment.isTypeOf(object, classifier);
	}

	@Override
	public EClassifier getType(Object object) {
		return baseEvaluationEnvironment.getType(object);
	}

	@Override
	public Tuple<EOperation, EStructuralFeature> createTuple(EClassifier type, Map<EStructuralFeature, Object> values) {
		return baseEvaluationEnvironment.createTuple(type, values);
	}


}
