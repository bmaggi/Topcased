/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.topcased.modeler.configurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Edge Object Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgeObjectType()
 * @model
 * @generated
 */
public final class EdgeObjectType extends AbstractEnumerator
{
    /**
     * The '<em><b>Source</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Source</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SOURCE_LITERAL
     * @model name="Source"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041325160'" 
     * @generated
     * @ordered
     */
    public static final int SOURCE = 0;

    /**
     * The '<em><b>Middle</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Middle</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MIDDLE_LITERAL
     * @model name="Middle"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041326161'" 
     * @generated
     * @ordered
     */
    public static final int MIDDLE = 1;

    /**
     * The '<em><b>Target</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Target</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TARGET_LITERAL
     * @model name="Target"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041327162'" 
     * @generated
     * @ordered
     */
    public static final int TARGET = 2;

    /**
     * The '<em><b>Source</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SOURCE
     * @generated
     * @ordered
     */
    public static final EdgeObjectType SOURCE_LITERAL = new EdgeObjectType(SOURCE, "Source"); //$NON-NLS-1$

    /**
     * The '<em><b>Middle</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MIDDLE
     * @generated
     * @ordered
     */
    public static final EdgeObjectType MIDDLE_LITERAL = new EdgeObjectType(MIDDLE, "Middle"); //$NON-NLS-1$

    /**
     * The '<em><b>Target</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TARGET
     * @generated
     * @ordered
     */
    public static final EdgeObjectType TARGET_LITERAL = new EdgeObjectType(TARGET, "Target"); //$NON-NLS-1$

    /**
     * An array of all the '<em><b>Edge Object Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final EdgeObjectType[] VALUES_ARRAY =
        new EdgeObjectType[]
        {
            SOURCE_LITERAL,
            MIDDLE_LITERAL,
            TARGET_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Edge Object Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Edge Object Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EdgeObjectType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            EdgeObjectType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Edge Object Type</b></em>' literal with the specified value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EdgeObjectType get(int value)
    {
        switch (value)
        {
            case SOURCE: return SOURCE_LITERAL;
            case MIDDLE: return MIDDLE_LITERAL;
            case TARGET: return TARGET_LITERAL;
        }
        return null;	
    }

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EdgeObjectType(int value, String name)
    {
        super(value, name);
    }

} //EdgeObjectType
