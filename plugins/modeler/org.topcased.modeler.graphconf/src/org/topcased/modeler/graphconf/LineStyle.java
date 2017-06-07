/**
 * <copyright>
 * </copyright>
 *
 * $Id: LineStyle.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Line Style</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getLineStyle()
 * @model
 * @generated
 */
public final class LineStyle extends AbstractEnumerator
{
    /**
     * The '<em><b>SOLID</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SOLID</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SOLID_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int SOLID = 1;

    /**
     * The '<em><b>DASH</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DASH</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DASH_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int DASH = 2;

    /**
     * The '<em><b>DOT</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DOT</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DOT_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int DOT = 3;

    /**
     * The '<em><b>DASHDOT</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DASHDOT</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DASHDOT_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int DASHDOT = 4;

    /**
     * The '<em><b>DASHDOTDOT</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DASHDOTDOT</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DASHDOTDOT_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int DASHDOTDOT = 5;

    /**
     * The '<em><b>CUSTOM</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CUSTOM</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #CUSTOM_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int CUSTOM = 6;

    /**
     * The '<em><b>SOLID</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SOLID
     * @generated
     * @ordered
     */
    public static final LineStyle SOLID_LITERAL = new LineStyle(SOLID, "SOLID", "SOLID");

    /**
     * The '<em><b>DASH</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DASH
     * @generated
     * @ordered
     */
    public static final LineStyle DASH_LITERAL = new LineStyle(DASH, "DASH", "DASH");

    /**
     * The '<em><b>DOT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DOT
     * @generated
     * @ordered
     */
    public static final LineStyle DOT_LITERAL = new LineStyle(DOT, "DOT", "DOT");

    /**
     * The '<em><b>DASHDOT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DASHDOT
     * @generated
     * @ordered
     */
    public static final LineStyle DASHDOT_LITERAL = new LineStyle(DASHDOT, "DASHDOT", "DASHDOT");

    /**
     * The '<em><b>DASHDOTDOT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DASHDOTDOT
     * @generated
     * @ordered
     */
    public static final LineStyle DASHDOTDOT_LITERAL = new LineStyle(DASHDOTDOT, "DASHDOTDOT", "DASHDOTDOT");

    /**
     * The '<em><b>CUSTOM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #CUSTOM
     * @generated
     * @ordered
     */
    public static final LineStyle CUSTOM_LITERAL = new LineStyle(CUSTOM, "CUSTOM", "CUSTOM");

    /**
     * An array of all the '<em><b>Line Style</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final LineStyle[] VALUES_ARRAY = new LineStyle[] {SOLID_LITERAL, DASH_LITERAL, DOT_LITERAL, DASHDOT_LITERAL, DASHDOTDOT_LITERAL, CUSTOM_LITERAL,};

    /**
     * A public read-only list of all the '<em><b>Line Style</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Line Style</b></em>' literal with the specified literal value. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static LineStyle get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            LineStyle result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Line Style</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static LineStyle getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            LineStyle result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Line Style</b></em>' literal with the specified integer value. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static LineStyle get(int value)
    {
        switch (value)
        {
            case SOLID:
                return SOLID_LITERAL;
            case DASH:
                return DASH_LITERAL;
            case DOT:
                return DOT_LITERAL;
            case DASHDOT:
                return DASHDOT_LITERAL;
            case DASHDOTDOT:
                return DASHDOTDOT_LITERAL;
            case CUSTOM:
                return CUSTOM_LITERAL;
        }
        return null;
    }

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private LineStyle(int value, String name, String literal)
    {
        super(value, name, literal);
    }

} // LineStyle
