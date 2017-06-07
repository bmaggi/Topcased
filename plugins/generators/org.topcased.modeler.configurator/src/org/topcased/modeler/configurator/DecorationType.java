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
 * A representation of the literals of the enumeration '<em><b>Decoration Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDecorationType()
 * @model
 * @generated
 */
public final class DecorationType extends AbstractEnumerator
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
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041317147'" 
     * @generated
     * @ordered
     */
    public static final int NONE = 0;

    /**
     * The '<em><b>ARROW</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ARROW</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ARROW_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041318148'" 
     * @generated
     * @ordered
     */
    public static final int ARROW = 1;

    /**
     * The '<em><b>TRIANGLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TRIANGLE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TRIANGLE_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041319149'" 
     * @generated
     * @ordered
     */
    public static final int TRIANGLE = 2;

    /**
     * The '<em><b>DIAMOND</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DIAMOND</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DIAMOND_LITERAL
     * @model annotation="http://www.topcased.org/uuid uuid='1131982041320150'" 
     * @generated
     * @ordered
     */
    public static final int DIAMOND = 3;

    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
    public static final DecorationType NONE_LITERAL = new DecorationType(NONE, "NONE");

    /**
     * The '<em><b>ARROW</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ARROW
     * @generated
     * @ordered
     */
    public static final DecorationType ARROW_LITERAL = new DecorationType(ARROW, "ARROW");

    /**
     * The '<em><b>TRIANGLE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TRIANGLE
     * @generated
     * @ordered
     */
    public static final DecorationType TRIANGLE_LITERAL = new DecorationType(TRIANGLE, "TRIANGLE");

    /**
     * The '<em><b>DIAMOND</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DIAMOND
     * @generated
     * @ordered
     */
    public static final DecorationType DIAMOND_LITERAL = new DecorationType(DIAMOND, "DIAMOND");

    /**
     * An array of all the '<em><b>Decoration Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final DecorationType[] VALUES_ARRAY =
        new DecorationType[]
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
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Decoration Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DecorationType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            DecorationType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Decoration Type</b></em>' literal with the specified value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private DecorationType(int value, String name)
    {
        super(value, name);
    }

} //DecorationType
