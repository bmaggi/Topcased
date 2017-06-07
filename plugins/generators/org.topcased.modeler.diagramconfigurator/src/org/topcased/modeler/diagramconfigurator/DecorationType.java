/**
 * <copyright>
 * </copyright>
 *
 * $Id: DecorationType.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Decoration Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDecorationType()
 * @model annotation="http://www.topcased.org/documentation documentation='Define the type of decoration that are available for a connection EndPoint.'"
 * @generated
 */
public enum DecorationType implements Enumerator {
    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
    NONE_LITERAL(0, "NONE", "NONE"),
    /**
     * The '<em><b>ARROW</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #ARROW
     * @generated
     * @ordered
     */
    ARROW_LITERAL(1, "ARROW", "ARROW"),
    /**
     * The '<em><b>TRIANGLE</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #TRIANGLE
     * @generated
     * @ordered
     */
    TRIANGLE_LITERAL(2, "TRIANGLE", "TRIANGLE"),
    /**
     * The '<em><b>DIAMOND</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #DIAMOND
     * @generated
     * @ordered
     */
    DIAMOND_LITERAL(3, "DIAMOND", "DIAMOND");
    /**
     * The '<em><b>NONE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NONE_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int NONE = 0;

    /**
     * The '<em><b>ARROW</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ARROW</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ARROW_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int ARROW = 1;

    /**
     * The '<em><b>TRIANGLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TRIANGLE</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TRIANGLE_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int TRIANGLE = 2;

    /**
     * The '<em><b>DIAMOND</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DIAMOND</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DIAMOND_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int DIAMOND = 3;

    /**
     * An array of all the '<em><b>Decoration Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    private static final DecorationType[] VALUES_ARRAY = new DecorationType[]
        {
            NONE_LITERAL,
            ARROW_LITERAL,
            TRIANGLE_LITERAL,
            DIAMOND_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Decoration Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<DecorationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Decoration Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static DecorationType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            DecorationType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Decoration Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static DecorationType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            DecorationType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Decoration Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static DecorationType get(int value)
    {
        switch (value)
        {
            case NONE: return NONE_LITERAL;
            case ARROW: return ARROW_LITERAL;
            case TRIANGLE: return TRIANGLE_LITERAL;
            case DIAMOND: return DIAMOND_LITERAL;
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
    private DecorationType(int value, String name, String literal)
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
