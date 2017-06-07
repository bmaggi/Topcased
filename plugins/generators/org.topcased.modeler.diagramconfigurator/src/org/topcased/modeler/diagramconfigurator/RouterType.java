/**
 * <copyright>
 * </copyright>
 *
 * $Id: RouterType.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Router Type</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getRouterType()
 * @model annotation="http://www.topcased.org/documentation documentation='The type of Layout that it will be used to display children DiagramElement'"
 * @generated
 */
public enum RouterType implements Enumerator {
    /**
     * The '<em><b>Oblique Router</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #OBLIQUE_ROUTER
     * @generated
     * @ordered
     */
    OBLIQUE_ROUTER_LITERAL(0, "ObliqueRouter", "ObliqueRouter"),
    /**
     * The '<em><b>Rectilinear Router</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #RECTILINEAR_ROUTER
     * @generated
     * @ordered
     */
    RECTILINEAR_ROUTER_LITERAL(1, "RectilinearRouter", "RectilinearRouter"),
    /**
     * The '<em><b>Tree Router</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #TREE_ROUTER
     * @generated
     * @ordered
     */
    TREE_ROUTER_LITERAL(2, "TreeRouter", "TreeRouter");
    /**
     * The '<em><b>Oblique Router</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Oblique Router</b></em>' literal object isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #OBLIQUE_ROUTER_LITERAL
     * @model name="ObliqueRouter"
     * @generated
     * @ordered
     */
    public static final int OBLIQUE_ROUTER = 0;

    /**
     * The '<em><b>Rectilinear Router</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Rectilinear Router</b></em>' literal object isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RECTILINEAR_ROUTER_LITERAL
     * @model name="RectilinearRouter"
     * @generated
     * @ordered
     */
    public static final int RECTILINEAR_ROUTER = 1;

    /**
     * The '<em><b>Tree Router</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Tree Router</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TREE_ROUTER_LITERAL
     * @model name="TreeRouter"
     * @generated
     * @ordered
     */
    public static final int TREE_ROUTER = 2;

    /**
     * An array of all the '<em><b>Router Type</b></em>' enumerators.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static final RouterType[] VALUES_ARRAY = new RouterType[]
        {
            OBLIQUE_ROUTER_LITERAL,
            RECTILINEAR_ROUTER_LITERAL,
            TREE_ROUTER_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Router Type</b></em>' enumerators.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static final List<RouterType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Router Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RouterType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            RouterType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Router Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static RouterType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            RouterType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Router Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RouterType get(int value)
    {
        switch (value)
        {
            case OBLIQUE_ROUTER: return OBLIQUE_ROUTER_LITERAL;
            case RECTILINEAR_ROUTER: return RECTILINEAR_ROUTER_LITERAL;
            case TREE_ROUTER: return TREE_ROUTER_LITERAL;
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
    private RouterType(int value, String name, String literal)
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
