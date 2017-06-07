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
 * $Id: ALGORITHM_KIND.java,v 1.1 2013/01/18 11:03:47 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ALGORITHM KIND</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getALGORITHM_KIND()
 * @model
 * @generated
 */
public enum ALGORITHM_KIND implements Enumerator {
	/**
	 * The '<em><b>DEPTH WISE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #DEPTH_WISE_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_WISE(0, "DEPTH_WISE", "DEPTH_WISE"),

	/**
	 * The '<em><b>WIDTH WISE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #WIDTH_WISE_VALUE
	 * @generated
	 * @ordered
	 */
	WIDTH_WISE(1, "WIDTH_WISE", "WIDTH_WISE");

	/**
	 * The '<em><b>DEPTH WISE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEPTH WISE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DEPTH_WISE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_WISE_VALUE = 0;

	/**
	 * The '<em><b>WIDTH WISE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WIDTH WISE</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WIDTH_WISE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIDTH_WISE_VALUE = 1;

	/**
	 * An array of all the '<em><b>ALGORITHM KIND</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ALGORITHM_KIND[] VALUES_ARRAY = new ALGORITHM_KIND[]{ DEPTH_WISE, WIDTH_WISE, };

	/**
	 * A public read-only list of all the '<em><b>ALGORITHM KIND</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<ALGORITHM_KIND> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>ALGORITHM KIND</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ALGORITHM_KIND get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			ALGORITHM_KIND result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ALGORITHM KIND</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ALGORITHM_KIND getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			ALGORITHM_KIND result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>ALGORITHM KIND</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ALGORITHM_KIND get(int value) {
		switch(value) {
		case DEPTH_WISE_VALUE:
			return DEPTH_WISE;
		case WIDTH_WISE_VALUE:
			return WIDTH_WISE;
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
	private ALGORITHM_KIND(int value, String name, String literal) {
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

} //ALGORITHM_KIND
