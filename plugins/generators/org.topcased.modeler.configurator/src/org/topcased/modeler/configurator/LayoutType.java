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
 * A representation of the literals of the enumeration '<em><b>Layout Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getLayoutType()
 * @model
 * @generated
 */
public final class LayoutType extends AbstractEnumerator
{
    /**
     * The '<em><b>XY Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>XY Layout</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #XY_LAYOUT_LITERAL
     * @model name="XYLayout"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041308139'" 
     * @generated
     * @ordered
     */
    public static final int XY_LAYOUT = 0;

    /**
     * The '<em><b>Class Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Class Layout</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CLASS_LAYOUT_LITERAL
     * @model name="ClassLayout"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041309140'" 
     * @generated
     * @ordered
     */
    public static final int CLASS_LAYOUT = 1;

    /**
     * The '<em><b>Toolbar Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Toolbar Layout</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TOOLBAR_LAYOUT_LITERAL
     * @model name="ToolbarLayout"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041309141'" 
     * @generated
     * @ordered
     */
    public static final int TOOLBAR_LAYOUT = 2;

    /**
     * The '<em><b>Port Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Port Layout</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PORT_LAYOUT_LITERAL
     * @model name="PortLayout"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041314142'" 
     * @generated
     * @ordered
     */
    public static final int PORT_LAYOUT = 3;

    /**
     * The '<em><b>Multi Port Layout</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Multi Port Layout</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MULTI_PORT_LAYOUT_LITERAL
     * @model name="MultiPortLayout"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041315143'" 
     * @generated
     * @ordered
     */
    public static final int MULTI_PORT_LAYOUT = 4;

    /**
     * The '<em><b>XY Layout</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #XY_LAYOUT
     * @generated
     * @ordered
     */
    public static final LayoutType XY_LAYOUT_LITERAL = new LayoutType(XY_LAYOUT, "XYLayout");

    /**
     * The '<em><b>Class Layout</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLASS_LAYOUT
     * @generated
     * @ordered
     */
    public static final LayoutType CLASS_LAYOUT_LITERAL = new LayoutType(CLASS_LAYOUT, "ClassLayout");

    /**
     * The '<em><b>Toolbar Layout</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TOOLBAR_LAYOUT
     * @generated
     * @ordered
     */
    public static final LayoutType TOOLBAR_LAYOUT_LITERAL = new LayoutType(TOOLBAR_LAYOUT, "ToolbarLayout");

    /**
     * The '<em><b>Port Layout</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PORT_LAYOUT
     * @generated
     * @ordered
     */
    public static final LayoutType PORT_LAYOUT_LITERAL = new LayoutType(PORT_LAYOUT, "PortLayout");

    /**
     * The '<em><b>Multi Port Layout</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MULTI_PORT_LAYOUT
     * @generated
     * @ordered
     */
    public static final LayoutType MULTI_PORT_LAYOUT_LITERAL = new LayoutType(MULTI_PORT_LAYOUT, "MultiPortLayout"); //$NON-NLS-1$

    /**
     * An array of all the '<em><b>Layout Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final LayoutType[] VALUES_ARRAY =
        new LayoutType[]
        {
            XY_LAYOUT_LITERAL,
            CLASS_LAYOUT_LITERAL,
            TOOLBAR_LAYOUT_LITERAL,
            PORT_LAYOUT_LITERAL,
            MULTI_PORT_LAYOUT_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Layout Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Layout Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static LayoutType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            LayoutType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Layout Type</b></em>' literal with the specified value.
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
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private LayoutType(int value, String name)
    {
        super(value, name);
    }

} //LayoutType
