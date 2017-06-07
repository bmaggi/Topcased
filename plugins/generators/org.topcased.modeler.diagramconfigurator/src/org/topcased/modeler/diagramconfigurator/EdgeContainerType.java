/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeContainerType.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Edge Container Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgeContainerType()
 * @model annotation="http://www.topcased.org/documentation documentation='The different ways where to add the Edge to the model'"
 * @generated
 */
public enum EdgeContainerType implements Enumerator {
    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
    NONE_LITERAL(0, "NONE", "NONE"),
    /**
     * The '<em><b>SOURCE</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #SOURCE
     * @generated
     * @ordered
     */
    SOURCE_LITERAL(1, "SOURCE", "SOURCE"),
    /**
     * The '<em><b>SOURCE CONTAINER</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #SOURCE_CONTAINER
     * @generated
     * @ordered
     */
    SOURCE_CONTAINER_LITERAL(2, "SOURCE_CONTAINER", "SOURCE_CONTAINER"),
    /**
     * The '<em><b>DIAGRAM</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #DIAGRAM
     * @generated
     * @ordered
     */
    DIAGRAM_LITERAL(3, "DIAGRAM", "DIAGRAM"),
    /**
     * The '<em><b>TARGET</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #TARGET
     * @generated
     * @ordered
     */
    TARGET_LITERAL(4, "TARGET", "TARGET"),
    /**
     * The '<em><b>TARGET CONTAINER</b></em>' literal object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #TARGET_CONTAINER
     * @generated
     * @ordered
     */
    TARGET_CONTAINER_LITERAL(5, "TARGET_CONTAINER", "TARGET_CONTAINER");
    /**
     * The '<em><b>NONE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NONE_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Edge has no model association'"
     * @generated
     * @ordered
     */
    public static final int NONE = 0;

    /**
     * The '<em><b>SOURCE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SOURCE</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SOURCE_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Source Node is the container of the Edge'"
     * @generated
     * @ordered
     */
    public static final int SOURCE = 1;

    /**
     * The '<em><b>SOURCE CONTAINER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SOURCE CONTAINER</b></em>' literal object isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SOURCE_CONTAINER_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Source Container Node is the container of the Edge'"
     * @generated
     * @ordered
     */
    public static final int SOURCE_CONTAINER = 2;

    /**
     * The '<em><b>DIAGRAM</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DIAGRAM</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DIAGRAM_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Model object associated with the current Diagram is the container of the Edge'"
     * @generated
     * @ordered
     */
    public static final int DIAGRAM = 3;

    /**
     * The '<em><b>TARGET</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TARGET</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TARGET_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Target Node is the container of the Edge'"
     * @generated
     * @ordered
     */
    public static final int TARGET = 4;

    /**
     * The '<em><b>TARGET CONTAINER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TARGET CONTAINER</b></em>' literal object isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TARGET_CONTAINER_LITERAL
     * @model annotation="http://www.topcased.org/documentation documentation='The Target Container Node is the container of the Edge'"
     * @generated
     * @ordered
     */
    public static final int TARGET_CONTAINER = 5;

    /**
     * An array of all the '<em><b>Edge Container Type</b></em>' enumerators.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    private static final EdgeContainerType[] VALUES_ARRAY = new EdgeContainerType[]
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
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    public static final List<EdgeContainerType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Edge Container Type</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static EdgeContainerType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            EdgeContainerType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Edge Container Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EdgeContainerType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            EdgeContainerType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Edge Container Type</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
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
    private EdgeContainerType(int value, String name, String literal)
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
