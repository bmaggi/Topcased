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
 * A representation of the literals of the enumeration '<em><b>Tool Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getToolType()
 * @model
 * @generated
 */
public final class ToolType extends AbstractEnumerator
{
    /**
     * The '<em><b>NODE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Node</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NODE_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041302127'" 
     * @generated
     * @ordered
     */
    public static final int NODE = 0;

    /**
     * The '<em><b>EDGE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Edge</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #EDGE_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041302128'" 
     * @generated
     * @ordered
     */
    public static final int EDGE = 1;

    /**
     * The '<em><b>NODE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NODE
     * @generated
     * @ordered
     */
    public static final ToolType NODE_LITERAL = new ToolType(NODE, "NODE"); //$NON-NLS-1$

    /**
     * The '<em><b>EDGE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EDGE
     * @generated
     * @ordered
     */
    public static final ToolType EDGE_LITERAL = new ToolType(EDGE, "EDGE"); //$NON-NLS-1$

    /**
     * An array of all the '<em><b>Tool Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ToolType[] VALUES_ARRAY =
        new ToolType[]
        {
            NODE_LITERAL,
            EDGE_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Tool Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Tool Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ToolType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ToolType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tool Type</b></em>' literal with the specified value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ToolType get(int value)
    {
        switch (value)
        {
            case NODE: return NODE_LITERAL;
            case EDGE: return EDGE_LITERAL;
        }
        return null;	
    }

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private ToolType(int value, String name)
    {
        super(value, name);
    }

} //ToolType
