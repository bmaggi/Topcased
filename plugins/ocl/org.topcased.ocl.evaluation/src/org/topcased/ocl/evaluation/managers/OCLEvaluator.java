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
package org.topcased.ocl.evaluation.managers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EvaluationVisitorImpl;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.EvaluationOptions;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;
import org.topcased.ocl.evaluation.Activator;
import org.topcased.ocl.evaluation.exceptions.EvaluationException;
import org.topcased.ocl.evaluation.exceptions.NotAPredicateException;
import org.topcased.ocl.evaluation.exceptions.OperationParsingException;
import org.topcased.ocl.evaluation.interfaces.CustomOperation;
import org.topcased.ocl.evaluation.internal.CustomEnvironmentFactory;
import org.topcased.ocl.evaluation.internal.CustomEvaluationEnvironment;
import org.topcased.ocl.evaluation.util.OCLEvaluationUtil;
import org.topcased.ocl.evaluation.util.QueryTypeExtentMap;

/**
 * Utility class allowing ocl queries and operations to be evaluated.
 * 
 * @author omelois
 * 
 */
public class OCLEvaluator {

	private String storageMetamodel;

	protected OCL ocl;

	/**
	 * Operations that were loaded to the environment.
	 */
	private final Map<String, EOperation> loadedOperations = new HashMap<String, EOperation>();


	/**
	 * Map to keep the custom operations that were defined in the customization. The eOperations kept in this map cannot be executed, as
	 * the related code is implemented in java by a user, java a CustomOperation.
	 */
	private Map<String, EOperation> dummyCustomOperations = new HashMap<String, EOperation>();


	private boolean queriesShouldBeExtendedToResourceSet = false;
	
	public OCLEvaluator(String storageMetamodel, boolean extendQueriesToResourceSet) {
		this(storageMetamodel);
		queriesShouldBeExtendedToResourceSet = extendQueriesToResourceSet;
	}
	
	/**
	 * Constructor.
	 * 
	 * @param storageMetamodel
	 *        the storage metamodel to use
	 */
	public OCLEvaluator(String storageMetamodel) {
		this(new CustomEnvironmentFactory());
		this.storageMetamodel = storageMetamodel;
	}

	public OCLEvaluator(EcoreEnvironmentFactory factory) {
		ocl = OCL.newInstance(factory);
		//Parsing options for the OCL.
		ParsingOptions.setOption(ocl.getEnvironment(), ParsingOptions.implicitRootClass(ocl.getEnvironment()), EcorePackage.Literals.EOBJECT);
		ParsingOptions.setOption(ocl.getEnvironment(), ProblemOption.CLOSURE_ITERATOR, ProblemHandler.Severity.OK);
		EvaluationOptions.setOption(ocl.getEvaluationEnvironment(), EvaluationOptions.LAX_NULL_HANDLING, true);
	}

	public OCL getOCL() {
		return this.ocl;
	}
	
	/**
	 * Gets the current extent map.
	 * @return 
	 */
	public Map<EClass, ? extends Set<? extends EObject>> getOclExtentMap() {
		return ocl.getExtentMap();
	}
	
	/**
	 * Changes the extent map of the OCL, responsible for the result of the "allInstances"
	 * operation execution.
	 */
	public void setOclExtentMap(Map<EClass, ? extends Set<? extends EObject>> extentMap) {
		ocl.setExtentMap(extentMap);
	}

	/**
	 * Adds an operation to the custom evaluation environment..
	 */
	public void addOperationToEnvironment(CustomOperation operation) {
		if(operation != null && operation.getName() != null && !operation.getName().isEmpty()) {
			if (getOCL().getEvaluationEnvironment() instanceof CustomEvaluationEnvironment){
				CustomEvaluationEnvironment evaluationEnvironment = (CustomEvaluationEnvironment) getOCL().getEvaluationEnvironment();
				evaluationEnvironment.addCustomJavaOperation(operation);
				EOperation customOperation = getOCL().getEnvironment().defineOperation(operation.getEClassifier(), operation.getName(), operation.getType(), operation.getParameters(), org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createConstraint());
				dummyCustomOperations.put(operation.getName(), customOperation);
			}
		}
	}

	/**
	 * Gets the dummy custom operations that were implemented in java and added to the environment.
	 */
	public Map<String, EOperation> getDummyCustomOperations() {
		return dummyCustomOperations;
	}

	/**
	 * Computes a context classifier from a metamodel prefix and a context name.
	 */
	public EClassifier computeEClassifier(String metamodelPrefix, String eClassifierContext) {
		Helper oclHelper = getOCL().createOCLHelper();
		List<String> lookupParameters = Arrays.asList(metamodelPrefix, eClassifierContext);
		EClassifier eClassifier = oclHelper.getOCL().getEnvironment().lookupClassifier(lookupParameters);
		return eClassifier;
	}


	/**
	 * Evaluates an ocl query on the provided context
	 * 
	 * @param ocl
	 * @param queryBody
	 * @param context
	 * @param globalVars
	 * @return
	 * @throws EvaluationException
	 */
	public Object evaluateQuery(String queryBody, Object context) throws EvaluationException {
		return evaluateQuery(queryBody, context, null);
	}

	/**
	 * Evaluates an ocl query on the provided context
	 * 
	 * @param ocl
	 * @param queryBody
	 * @param context
	 * @param globalVars
	 * @return
	 * @throws EvaluationException
	 */
	public Object evaluateQuery(String queryBody, Object context, Map<String, ? extends Object> globalVars) throws EvaluationException {
		if(globalVars != null) {
			for(Entry<String, ?> entry : globalVars.entrySet()) {
				// create a variable declaring our global application context object
				Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
				var.setName(entry.getKey());


				var.setType(OCLEvaluationUtil.getClassifier(entry.getValue()));
				// add it to the global OCL environment
				getOCL().getEnvironment().addElement(var.getName(), var, true);
			}
		}

		//Changing the extent map if needed
		if (queriesShouldBeExtendedToResourceSet){
			if (context != null) {
				if (context instanceof EObject) {
					getOCL().setExtentMap(new QueryTypeExtentMap(((EObject)context).eResource().getResourceSet()));
				}
				else if (context instanceof List<?>) {
					getOCL().setExtentMap(new QueryTypeExtentMap(((EObject)((List<?>)context).get(0)).eResource().getResourceSet()));
				}
			}
		}
		
		Helper oclHelper = getOCL().createOCLHelper();
		oclHelper.setContext(OCLEvaluationUtil.getClassifier(context));
		Object evalResult = null;

		//Parsing the body of the query.
		OCLExpression oclExpression;
		try {
			oclExpression = oclHelper.createQuery(queryBody);
			if(globalVars != null) {
				for(Entry<String, ?> entry : globalVars.entrySet()) {
					getOCL().getEvaluationEnvironment().add(entry.getKey(), entry.getValue());
				}
			}
		} catch (ParserException e) {
			//Clearing the variables
			getOCL().getEnvironment().getVariables().clear();
			if(globalVars != null) {
				for(Entry<String, ?> entry : globalVars.entrySet()) {
					getOCL().getEvaluationEnvironment().remove(entry.getKey());
				}
			}
			throw new EvaluationException(e);
		}
		evalResult = getOCL().evaluate(context, oclExpression);
		//Clearing the variables
		getOCL().getEnvironment().getVariables().clear();
		if(globalVars != null) {
			for(Entry<String, ?> entry : globalVars.entrySet()) {
				getOCL().getEvaluationEnvironment().remove(entry.getKey());
			}
		}
		
		return evalResult;
	}

	/**
	 * Evaluates a predicate query in an OCL evaluation environment.
	 * 
	 * @throws NotAPredicateException
	 *         when the query does not return a boolean.
	 */
	public boolean evaluatePredicateQuery(String queryBody, EObject context) throws NotAPredicateException {
		Helper oclHelper = getOCL().createOCLHelper();
		oclHelper.setContext(context.eClass());
		boolean result = false;

		try {
			//Parsing the body of the query.
			OCLExpression oclExpression = oclHelper.createQuery(queryBody);
			if(getOCL().check(context, oclExpression)) {
				Object evalResult = getOCL().evaluate(context, oclExpression);
				if(evalResult instanceof Boolean) {
					result = (Boolean)evalResult;
				} else {
					throw new NotAPredicateException();
				}
			}
		} catch (SemanticException e) {
			Activator.logError(e);
		} catch (ParserException e) {
			Activator.logError(e);
		}
		return result;
	}

	/**
	 * Loads an OCLOperation into an OCL environment.
	 * 
	 * @throws OperationParsingException
	 */
	public EOperation loadOperation(String operationDef, EClassifier eClassifier) throws OperationParsingException {
		Helper oclHelper = getOCL().createOCLHelper();
		//adding the operation and its context to the environment.
		oclHelper.setContext(eClassifier);
		EOperation eOperation;
		try {
			eOperation = oclHelper.defineOperation(operationDef);
		} catch (ParserException e) {
			throw new OperationParsingException(operationDef, e);
		}
		oclHelper.setOperationContext(eClassifier, eOperation);
		setContextOperation(eClassifier, eOperation);
		/*
		 * Keeping a trace of the loaded operations.
		 */
		loadedOperations.put(eOperation.getName(), eOperation);
		return eOperation;
	}

	/**
	 * Loads an OCLOperation into an OCL environment.
	 */
	public EOperation loadOperation(String operationDef, String metaModelPrefix, String eClassifierContext) throws OperationParsingException {
		Helper oclHelper = getOCL().createOCLHelper();
		List<String> lookupParameters = Arrays.asList(metaModelPrefix, eClassifierContext);
		EClassifier eClassifier = oclHelper.getOCL().getEnvironment().lookupClassifier(lookupParameters);

		//adding the operation and its context to the environment.
		oclHelper.setContext(eClassifier);
		EOperation eOperation;
		try {
			eOperation = oclHelper.defineOperation(operationDef);
		} catch (ParserException e) {
			throw new OperationParsingException(operationDef, e);
		}
		oclHelper.setOperationContext(eClassifier, eOperation);
		setContextOperation(eClassifier, eOperation);
		/*
		 * Keeping a trace of the loaded operations.
		 */
		loadedOperations.put(eOperation.getName(), eOperation);
		return eOperation;
	}

	/**
	 * Used to store the context of an eOperation that is created by
	 * an operation definition in OCL.
	 */
	private void setContextOperation(EClassifier eclass, EOperation op) {
		EAnnotation annot = op.getEAnnotation(storageMetamodel);
		if(annot == null) {
			annot = EcoreFactory.eINSTANCE.createEAnnotation();
			annot.setSource(storageMetamodel);
			op.getEAnnotations().add(annot);
		}
		annot.getReferences().clear();
		annot.getReferences().add(eclass);
	}

	private EClassifier getContextOperation(EOperation op) {
		EAnnotation annot = op.getEAnnotation(storageMetamodel);
		return (EClassifier)annot.getReferences().get(0);
	}

	/**
	 * Checks whether a certain operation has already been loaded in the environment.
	 */
	public boolean isLoaded(String operationName) {
		return loadedOperations.get(operationName) != null;
	}

	/**
	 * Evaluates an eOperation that was loaded inside the environment.
	 */
	public Object evaluateLoadedOperation(String operationName, EObject context, Object[] args) {
		EOperation eOperation = loadedOperations.get(operationName);
		Object result = null;
		if(eOperation != null) {
			result = evaluateOperation(eOperation, context, args);
		}
		return result;
	}

	/**
	 * Evaluates an eOperation on a context, in a OCL, with arguments.
	 */
	public Object evaluateOperation(EOperation eOperation, EObject context, Object[] args) {
		EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evaluationEnvironment = getOCL().getEvaluationEnvironment();
		//Clearing the evaluation environment of remaining variables.
		evaluationEnvironment.clear();
		
		//Addition of the "self" parameter.
		evaluationEnvironment.add("self", context); //$NON-NLS-1$
		//Addition of other parameters.
		for(int i = 0; i < args.length; i++) {
			EParameter p = eOperation.getEParameters().get(i);
			evaluationEnvironment.add(p.getName(), args[i]);
		}
		//Creating an evaluation visitor, in charge of evaluating the expression.
		Map<EClass, ? extends Set<? extends EObject>> extentMap = getOCL().getExtentMap();
		if(extentMap == null) {
			//Retrieving the default dynamic extent map implementation
			extentMap = evaluationEnvironment.createExtentMap(context);
		}
		EvaluationVisitorImpl visitor = new EvaluationVisitorImpl(getOCL().getEnvironment(), evaluationEnvironment, extentMap);
		OperationCallExp<EClassifier, Object> expression = getExpression(eOperation);
		Object result = null;
		//Checking that the operation is applicable on the context object.
		if(getContextOperation(eOperation).isInstance(context)) {
			result = expression.accept(visitor);
		}
		//Clearing the evaluation environment of variables.
		evaluationEnvironment.clear();
		return result;
	}

	private static VariableExp<EClassifier, EParameter> getVariable(String name, EClassifier type) {
		Variable<EClassifier, EParameter> self = ExpressionsFactory.eINSTANCE.createVariable();
		self.setName(name);
		self.setType(type);
		VariableExp<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariableExp();
		var.setName(name);
		var.setReferredVariable(self);
		return var;
	}

	/**
	 * Gets an operation call out of an eOperation
	 * 
	 * @param eOperation
	 */
	private static OperationCallExp<EClassifier, Object> getExpression(EOperation eOperation) {
		OperationCallExp<EClassifier, Object> result = ExpressionsFactory.eINSTANCE.createOperationCallExp();
		result.setReferredOperation(eOperation);
		VariableExp<EClassifier, EParameter> var = getVariable(Environment.SELF_VARIABLE_NAME, eOperation.getEContainingClass());
		var.setType(eOperation.getEContainingClass());
		//Adding parameters to the operation call exp.
		for(EParameter arg : eOperation.getEParameters()) {
			VariableExp<EClassifier, EParameter> v = getVariable(arg.getName(), arg.getEType());
			result.getArgument().add(v);
		}
		result.setSource(var);
		result.setType(eOperation.getEType());
		return result;
	}

	/**
	 * Creates a new OCL from a list of additional packages, and the current ocl.
	 */
	public OCL createOCL(List<String> listPackages) {
		EcoreEnvironmentFactory factory = new EcoreEnvironmentFactory(EPackage.Registry.INSTANCE);
		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> pckContext = factory.createPackageContext(this.ocl.getEnvironment(), listPackages);
		OCL newOcl = OCL.newInstance(pckContext);
		return newOcl;
	}

}
