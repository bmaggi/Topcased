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
/**
 * <copyright>
 * </copyright>
 *
 * $Id: IteratorSwitch.java,v 1.1 2013/01/18 11:03:56 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.topcased.iterators.configurations.iterator.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage
 * @generated
 */
public class IteratorSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static IteratorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorSwitch() {
		if(modelPackage == null) {
			modelPackage = IteratorPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case IteratorPackage.EPICKER_SET:
		{
			EPickerSet ePickerSet = (EPickerSet)theEObject;
			T result = caseEPickerSet(ePickerSet);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.QUERY:
		{
			Query query = (Query)theEObject;
			T result = caseQuery(query);
			if(result == null)
				result = caseNamedElement(query);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.OCL_QUERY:
		{
			OCLQuery oclQuery = (OCLQuery)theEObject;
			T result = caseOCLQuery(oclQuery);
			if(result == null)
				result = caseQuery(oclQuery);
			if(result == null)
				result = caseNamedElement(oclQuery);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.JAVA_QUERY:
		{
			JavaQuery javaQuery = (JavaQuery)theEObject;
			T result = caseJavaQuery(javaQuery);
			if(result == null)
				result = caseQuery(javaQuery);
			if(result == null)
				result = caseNamedElement(javaQuery);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.NAMED_ELEMENT:
		{
			NamedElement namedElement = (NamedElement)theEObject;
			T result = caseNamedElement(namedElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.EPICKER:
		{
			EPicker ePicker = (EPicker)theEObject;
			T result = caseEPicker(ePicker);
			if(result == null)
				result = caseNamedElement(ePicker);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.OPERATION_SET:
		{
			OperationSet operationSet = (OperationSet)theEObject;
			T result = caseOperationSet(operationSet);
			if(result == null)
				result = caseNamedElement(operationSet);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.OCL_OPERATION:
		{
			OCLOperation oclOperation = (OCLOperation)theEObject;
			T result = caseOCLOperation(oclOperation);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.ITERATOR:
		{
			Iterator iterator = (Iterator)theEObject;
			T result = caseIterator(iterator);
			if(result == null)
				result = caseNamedElement(iterator);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.CONFIGURATION_MODEL:
		{
			ConfigurationModel configurationModel = (ConfigurationModel)theEObject;
			T result = caseConfigurationModel(configurationModel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case IteratorPackage.QUERY_PARAM:
		{
			QueryParam queryParam = (QueryParam)theEObject;
			T result = caseQueryParam(queryParam);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPicker Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPicker Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPickerSet(EPickerSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuery(Query object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLQuery(OCLQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaQuery(JavaQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPicker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPicker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPicker(EPicker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationSet(OperationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLOperation(OCLOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterator(Iterator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationModel(ConfigurationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryParam(QueryParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //IteratorSwitch
