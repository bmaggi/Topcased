/**
 * <copyright>
 * </copyright>
 *
 * $Id: LayoutType.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Layout Type</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getLayoutType()
 * @model annotation="http://www.topcased.org/documentation documentation='The type of Layout that it will be used to display children DiagramElement'"
 * @generated
 */
public enum LayoutType implements Enumerator {
    /**
     * The '<em><b>XY Layout</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #XY_LAYOUT
     * @generated
     * @ordered
     */
    XY_LAYOUT_LITERAL(0, "XYLayout", "XYLayout"),
    /**
     * The '<em><b>Class Layout</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #CLASS_LAYOUT
     * @generated
     * @ordered
     */
    CLASS_LAYOUT_LITERAL(1, "ClassLayout", "ClassLayout"),
    /**
     * The '<em><b>Toolbar Layout</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #TOOLBAR_LAYOUT
     * @generated
     * @ordered
     */
    TOOLBAR_LAYOUT_LITERAL(2, "ToolbarLayout", "ToolbarLayout"),
    /**
     * The '<em><b>Port Layout</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #PORT_LAYOUT
     * @generated
     * @ordered
     */
    PORT_LAYOUT_LITERAL(3, "PortLayout", "PortLayout"),
    /**
     * The '<em><b>Multi Port Layout</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #MULTI_PORT_LAYOUT
     * @generated
     * @ordered
     */
    MULTI_PORT_LAYOUT_LITERAL(4, "MultiPortLayout", "MultiPortLayout");
    /**
     * The '<em><b>XY Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>XY Layout</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #XY_LAYOUT_LITERAL
     * @model name="XYLayout"
     * @generated
     * @ordered
     */
    public static final int XY_LAYOUT = 0;

    /**
     * The '<em><b>Class Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Class Layout</b></em>' literal object isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CLASS_LAYOUT_LITERAL
     * @model name="ClassLayout"
     * @generated
     * @ordered
     */
    public static final int CLASS_LAYOUT = 1;

    /**
     * The '<em><b>Toolbar Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Toolbar Layout</b></em>' literal object isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TOOLBAR_LAYOUT_LITERAL
     * @model name="ToolbarLayout"
     * @generated
     * @ordered
     */
    public static final int TOOLBAR_LAYOUT = 2;

    /**
     * The '<em><b>Port Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Port Layout</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PORT_LAYOUT_LITERAL
     * @model name="PortLayout"
     * @generated
     * @ordered
     */
    public static final int PORT_LAYOUT = 3;

    /**
     * The '<em><b>Multi Port Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Multi Port Layout</b></em>' literal object isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MULTI_PORT_LAYOUT_LITERAL
     * @model name="MultiPortLayout"
     * @generated
     * @ordered
     */
    public static final int MULTI_PORT_LAYOUT = 4;

    /**
     * An array of all the '<em><b>Layout Type</b></em>' enumerators.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static final LayoutType[] VALUES_ARRAY = new LayoutType[]
        {
            XY_LAYOUT_LITERAL,
            CLASS_LAYOUT_LITERAL,
            TOOLBAR_LAYOUT_LITERAL,
            PORT_LAYOUT_LITERAL,
            MULTI_PORT_LAYOUT_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Layout Type</b></em>' enumerators.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static final List<LayoutType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Layout Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static LayoutType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            LayoutType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Layout Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public static LayoutType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            LayoutType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Layout Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static LayoutType get(int value)
    {
        switch (value)
        {
            case XY_LAYOUT: return XY_LAYOUT_LITERAL;
            case CLASS_LAYOUT: return CLASS_LAYOUT_LITERAL;
            case TOOLBAR_LAYOUT: return TOOLBAR_LAYOUT_LITERAL;
            case PORT_LAYOUT: return PORT_LAYOUT_LITERAL;
            case MULTI_PORT_LAYOUT: return MULTI_PORT_LAYOUT_LITERAL;
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
    private LayoutType(int value, String name, String literal)
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
