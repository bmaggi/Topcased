/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.configurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Edge Container Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgeContainerType()
 * @model
 * @generated
 */
public final class EdgeContainerType extends AbstractEnumerator
{
    /**
     * The '<em><b>NONE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NONE_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Edge has no model association'"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041293106'" 
     * @generated
     * @ordered
     */
    public static final int NONE = 0;

    /**
     * The '<em><b>SOURCE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SOURCE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SOURCE_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Source Node is the container of the Edge'"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041294109'" 
     * @generated
     * @ordered
     */
    public static final int SOURCE = 1;

    /**
     * The '<em><b>SOURCE CONTAINER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SOURCE CONTAINER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SOURCE_CONTAINER_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Source Container Node is the container of the Edge'"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041296112'" 
     * @generated
     * @ordered
     */
    public static final int SOURCE_CONTAINER = 2;

    /**
     * The '<em><b>DIAGRAM</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DIAGRAM</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DIAGRAM_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Model object associated with the current Diagram is the container of the Edge'"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041297115'" 
     * @generated
     * @ordered
     */
    public static final int DIAGRAM = 3;

    /**
     * The '<em><b>TARGET</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TARGET</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TARGET_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Target Node is the container of the Edge'"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041298118'" 
     * @generated
     * @ordered
     */
    public static final int TARGET = 4;

    /**
     * The '<em><b>TARGET CONTAINER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TARGET CONTAINER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TARGET_CONTAINER_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Target Container Node is the container of the Edge'"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041299121'" 
     * @generated
     * @ordered
     */
    public static final int TARGET_CONTAINER = 5;

    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
    public static final EdgeContainerType NONE_LITERAL = new EdgeContainerType(NONE, "NONE"); //$NON-NLS-1$

    /**
     * The '<em><b>SOURCE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SOURCE
     * @generated
     * @ordered
     */
    public static final EdgeContainerType SOURCE_LITERAL = new EdgeContainerType(SOURCE, "SOURCE"); //$NON-NLS-1$

    /**
     * The '<em><b>SOURCE CONTAINER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SOURCE_CONTAINER
     * @generated
     * @ordered
     */
    public static final EdgeContainerType SOURCE_CONTAINER_LITERAL = new EdgeContainerType(SOURCE_CONTAINER, "SOURCE_CONTAINER"); //$NON-NLS-1$

    /**
     * The '<em><b>DIAGRAM</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DIAGRAM
     * @generated
     * @ordered
     */
    public static final EdgeContainerType DIAGRAM_LITERAL = new EdgeContainerType(DIAGRAM, "DIAGRAM"); //$NON-NLS-1$

    /**
     * The '<em><b>TARGET</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TARGET
     * @generated
     * @ordered
     */
    public static final EdgeContainerType TARGET_LITERAL = new EdgeContainerType(TARGET, "TARGET"); //$NON-NLS-1$

    /**
     * The '<em><b>TARGET CONTAINER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TARGET_CONTAINER
     * @generated
     * @ordered
     */
    public static final EdgeContainerType TARGET_CONTAINER_LITERAL = new EdgeContainerType(TARGET_CONTAINER, "TARGET_CONTAINER"); //$NON-NLS-1$

    /**
     * An array of all the '<em><b>Edge Container Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final EdgeContainerType[] VALUES_ARRAY =
        new EdgeContainerType[]
        {
            NONE_LITERAL,
            SOURCE_LITERAL,
            SOURCE_CONTAINER_LITERAL,
            DIAGRAM_LITERAL,
            TARGET_LITERAL,
            TARGET_CONTAINER_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Edge Container Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Edge Container Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EdgeContainerType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            EdgeContainerType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Edge Container Type</b></em>' literal with the specified value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EdgeContainerType get(int value)
    {
        switch (value)
        {
            case NONE: return NONE_LITERAL;
            case SOURCE: return SOURCE_LITERAL;
            case SOURCE_CONTAINER: return SOURCE_CONTAINER_LITERAL;
            case DIAGRAM: return DIAGRAM_LITERAL;
            case TARGET: return TARGET_LITERAL;
            case TARGET_CONTAINER: return TARGET_CONTAINER_LITERAL;
        }
        return null;	
    }

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EdgeContainerType(int value, String name)
    {
        super(value, name);
    }

} //EdgeContainerType
