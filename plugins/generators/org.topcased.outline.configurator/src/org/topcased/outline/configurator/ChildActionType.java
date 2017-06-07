/**
 * <copyright>
 * </copyright>
 *
 * $Id: ChildActionType.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Child Action Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getChildActionType()
 * @model
 * @generated
 */
public final class ChildActionType extends AbstractEnumerator
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * The '<em><b>Exact</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Exact</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #EXACT_LITERAL
     * @model name="Exact"
     * @generated
     * @ordered
     */
    public static final int EXACT = 1;

    /**
     * The '<em><b>Hierachical</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Hierachical</b></em>' literal object isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #HIERACHICAL_LITERAL
     * @model name="Hierachical"
     * @generated
     * @ordered
     */
    public static final int HIERACHICAL = 0;

    /**
     * The '<em><b>Exact</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #EXACT
     * @generated
     * @ordered
     */
    public static final ChildActionType EXACT_LITERAL = new ChildActionType(EXACT, "Exact", "Exact"); //$NON-NLS-1$

    /**
     * The '<em><b>Hierachical</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #HIERACHICAL
     * @generated
     * @ordered
     */
    public static final ChildActionType HIERACHICAL_LITERAL = new ChildActionType(HIERACHICAL, "Hierachical", "Hierachical"); //$NON-NLS-1$

    /**
     * An array of all the '<em><b>Child Action Type</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final ChildActionType[] VALUES_ARRAY = new ChildActionType[] {EXACT_LITERAL, HIERACHICAL_LITERAL,};

    /**
     * A public read-only list of all the '<em><b>Child Action Type</b></em>' enumerators. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Child Action Type</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static ChildActionType get(String literal)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ChildActionType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Child Action Type</b></em>' literal with the specified name. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static ChildActionType getByName(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            ChildActionType result = VALUES_ARRAY[i];
            if (result.getName().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Child Action Type</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static ChildActionType get(int value)
    {
        switch (value)
        {
            case EXACT:
                return EXACT_LITERAL;
            case HIERACHICAL:
                return HIERACHICAL_LITERAL;
        }
        return null;
    }

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private ChildActionType(int value, String name, String literal)
    {
        super(value, name, literal);
    }

} // ChildActionType
