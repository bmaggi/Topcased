/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectType.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Edge Object Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgeObjectType()
 * @model annotation="http://www.topcased.org/documentation documentation='The position that should be used to place the EdgeObject associated with the Edge'"
 * @generated
 */
public enum EdgeObjectType implements Enumerator {
    /**
     * The '<em><b>Source</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #SOURCE
     * @generated
     * @ordered
     */
    SOURCE_LITERAL(0, "Source", "Source"),
    /**
     * The '<em><b>Middle</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #MIDDLE
     * @generated
     * @ordered
     */
    MIDDLE_LITERAL(1, "Middle", "Middle"),
    /**
     * The '<em><b>Target</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #TARGET
     * @generated
     * @ordered
     */
    TARGET_LITERAL(2, "Target", "Target");
    /**
     * The '<em><b>Source</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Source</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SOURCE_LITERAL
     * @model name="Source"
     * @generated
     * @ordered
     */
    public static final int SOURCE = 0;

    /**
     * The '<em><b>Middle</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Middle</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MIDDLE_LITERAL
     * @model name="Middle"
     * @generated
     * @ordered
     */
    public static final int MIDDLE = 1;

    /**
     * The '<em><b>Target</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Target</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TARGET_LITERAL
     * @model name="Target"
     * @generated
     * @ordered
     */
    public static final int TARGET = 2;

    /**
     * An array of all the '<em><b>Edge Object Type</b></em>' enumerators.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    private static final EdgeObjectType[] VALUES_ARRAY = new EdgeObjectType[]
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
    public static final List<EdgeObjectType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Edge Object Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static EdgeObjectType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            EdgeObjectType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Edge Object Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static EdgeObjectType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            EdgeObjectType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Edge Object Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EdgeObjectType(int value, String name, String literal)
    {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public int getValue()
    {
      return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getName()
    {
      return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral()
    {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        return literal;
    }
}
