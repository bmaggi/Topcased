/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResizableType.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Resizable Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getResizableType()
 * @model annotation="http://www.topcased.org/documentation documentation='The type of the Resizable EditPolicy'"
 * @generated
 */
public enum ResizableType implements Enumerator {
    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
    NONE_LITERAL(0, "NONE", "NONE"),
    /**
     * The '<em><b>WIDTH</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #WIDTH
     * @generated
     * @ordered
     */
    WIDTH_LITERAL(1, "WIDTH", "WIDTH"),
    /**
     * The '<em><b>HEIGHT</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #HEIGHT
     * @generated
     * @ordered
     */
    HEIGHT_LITERAL(2, "HEIGHT", "HEIGHT"),
    /**
     * The '<em><b>ALL</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #ALL
     * @generated
     * @ordered
     */
    ALL_LITERAL(3, "ALL", "ALL");
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
     * The '<em><b>WIDTH</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WIDTH</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #WIDTH_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int WIDTH = 1;

    /**
     * The '<em><b>HEIGHT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>HEIGHT</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #HEIGHT_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int HEIGHT = 2;

    /**
     * The '<em><b>ALL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ALL</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ALL_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int ALL = 3;

    /**
     * An array of all the '<em><b>Resizable Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    private static final ResizableType[] VALUES_ARRAY = new ResizableType[]
        {
            NONE_LITERAL,
            WIDTH_LITERAL,
            HEIGHT_LITERAL,
            ALL_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Resizable Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ResizableType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Resizable Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static ResizableType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ResizableType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Resizable Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static ResizableType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ResizableType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Resizable Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static ResizableType get(int value)
    {
        switch (value)
        {
            case NONE: return NONE_LITERAL;
            case WIDTH: return WIDTH_LITERAL;
            case HEIGHT: return HEIGHT_LITERAL;
            case ALL: return ALL_LITERAL;
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
    private ResizableType(int value, String name, String literal)
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
