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
 * $Id: REPRESENTATION_KIND.java,v 1.1 2013/01/18 11:03:47 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>REPRESENTATION KIND</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getREPRESENTATION_KIND()
 * @model
 * @generated
 */
public enum REPRESENTATION_KIND implements Enumerator {
	/**
	 * The '<em><b>STATE WISE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATE_WISE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_WISE(0, "STATE_WISE", "STATE_WISE"),

	/**
	 * The '<em><b>TRANSITION WISE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #TRANSITION_WISE_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSITION_WISE(1, "TRANSITION_WISE", "TRANSITION_WISE");

	/**
	 * The '<em><b>STATE WISE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATE WISE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATE_WISE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATE_WISE_VALUE = 0;

	/**
	 * The '<em><b>TRANSITION WISE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSITION WISE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #TRANSITION_WISE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION_WISE_VALUE = 1;

	/**
	 * An array of all the '<em><b>REPRESENTATION KIND</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final REPRESENTATION_KIND[] VALUES_ARRAY = new REPRESENTATION_KIND[]{ STATE_WISE, TRANSITION_WISE, };

	/**
	 * A public read-only list of all the '<em><b>REPRESENTATION KIND</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<REPRESENTATION_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>REPRESENTATION KIND</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static REPRESENTATION_KIND get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			REPRESENTATION_KIND result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>REPRESENTATION KIND</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static REPRESENTATION_KIND getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			REPRESENTATION_KIND result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>REPRESENTATION KIND</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static REPRESENTATION_KIND get(int value) {
		switch(value) {
		case STATE_WISE_VALUE:
			return STATE_WISE;
		case TRANSITION_WISE_VALUE:
			return TRANSITION_WISE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private REPRESENTATION_KIND(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //REPRESENTATION_KIND
