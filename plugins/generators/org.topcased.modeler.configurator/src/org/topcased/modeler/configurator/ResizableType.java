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
 * A representation of the literals of the enumeration '<em><b>Resizable Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getResizableType()
 * @model
 * @generated
 */
public final class ResizableType extends AbstractEnumerator
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
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041304132'" 
     * @generated
     * @ordered
     */
    public static final int NONE = 0;

    /**
     * The '<em><b>WIDTH</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WIDTH</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #WIDTH_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041305133'" 
     * @generated
     * @ordered
     */
    public static final int WIDTH = 1;

    /**
     * The '<em><b>HEIGHT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>HEIGHT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #HEIGHT_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041305134'" 
     * @generated
     * @ordered
     */
    public static final int HEIGHT = 2;

    /**
     * The '<em><b>ALL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ALL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ALL_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041306135'" 
     * @generated
     * @ordered
     */
    public static final int ALL = 3;

    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
    public static final ResizableType NONE_LITERAL = new ResizableType(NONE, "NONE");

    /**
     * The '<em><b>WIDTH</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #WIDTH
     * @generated
     * @ordered
     */
    public static final ResizableType WIDTH_LITERAL = new ResizableType(WIDTH, "WIDTH");

    /**
     * The '<em><b>HEIGHT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HEIGHT
     * @generated
     * @ordered
     */
    public static final ResizableType HEIGHT_LITERAL = new ResizableType(HEIGHT, "HEIGHT");

    /**
     * The '<em><b>ALL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ALL
     * @generated
     * @ordered
     */
    public static final ResizableType ALL_LITERAL = new ResizableType(ALL, "ALL");

    /**
     * An array of all the '<em><b>Resizable Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ResizableType[] VALUES_ARRAY =
        new ResizableType[]
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
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Resizable Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ResizableType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ResizableType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Resizable Type</b></em>' literal with the specified value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private ResizableType(int value, String name)
    {
        super(value, name);
    }

} //ResizableType
