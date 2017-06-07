/*******************************************************************************
* Copyright (c) 2005 AIRBUS FRANCE.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
*    Jacques Lescot (Anyware Technologies) - initial API and implementation
*******************************************************************************/ 
package org.topcased.modeler.configurator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Figure Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getFigureType()
 * @model
 * @generated
 */
public final class FigureType extends AbstractEnumerator
{
    /**
     * The '<em><b>Container</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Container</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CONTAINER_LITERAL
     * @model name="container"
     * @generated
     * @ordered
     */
    public static final int CONTAINER = 0;

    /**
     * The '<em><b>Figure1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Figure1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FIGURE1_LITERAL
     * @model name="figure1"
     * @generated
     * @ordered
     */
    public static final int FIGURE1 = 1;

    /**
     * The '<em><b>Figure2</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Figure2</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FIGURE2_LITERAL
     * @model name="figure2"
     * @generated
     * @ordered
     */
    public static final int FIGURE2 = 2;

    /**
     * The '<em><b>Port</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Port</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PORT_LITERAL
     * @model name="port"
     * @generated
     * @ordered
     */
    public static final int PORT = 3;

    /**
     * The '<em><b>Class</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Class</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CLASS_LITERAL
     * @model name="class"
     * @generated
     * @ordered
     */
    public static final int CLASS = 4;

    /**
     * The '<em><b>Label</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Label</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LABEL_LITERAL
     * @model name="label"
     * @generated
     * @ordered
     */
    public static final int LABEL = 5;

    /**
     * The '<em><b>Label Figure</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Label Figure</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LABEL_FIGURE_LITERAL
     * @model name="labelFigure"
     * @generated
     * @ordered
     */
    public static final int LABEL_FIGURE = 6;

    /**
     * The '<em><b>Container</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONTAINER
     * @generated
     * @ordered
     */
    public static final FigureType CONTAINER_LITERAL = new FigureType(CONTAINER, "container"); //$NON-NLS-1$

    /**
     * The '<em><b>Figure1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FIGURE1
     * @generated
     * @ordered
     */
    public static final FigureType FIGURE1_LITERAL = new FigureType(FIGURE1, "figure1"); //$NON-NLS-1$

    /**
     * The '<em><b>Figure2</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FIGURE2
     * @generated
     * @ordered
     */
    public static final FigureType FIGURE2_LITERAL = new FigureType(FIGURE2, "figure2"); //$NON-NLS-1$

    /**
     * The '<em><b>Port</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PORT
     * @generated
     * @ordered
     */
    public static final FigureType PORT_LITERAL = new FigureType(PORT, "port"); //$NON-NLS-1$

    /**
     * The '<em><b>Class</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLASS
     * @generated
     * @ordered
     */
    public static final FigureType CLASS_LITERAL = new FigureType(CLASS, "class"); //$NON-NLS-1$

    /**
     * The '<em><b>Label</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LABEL
     * @generated
     * @ordered
     */
    public static final FigureType LABEL_LITERAL = new FigureType(LABEL, "label"); //$NON-NLS-1$

    /**
     * The '<em><b>Label Figure</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LABEL_FIGURE
     * @generated
     * @ordered
     */
    public static final FigureType LABEL_FIGURE_LITERAL = new FigureType(LABEL_FIGURE, "labelFigure"); //$NON-NLS-1$

    /**
     * An array of all the '<em><b>Figure Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final FigureType[] VALUES_ARRAY = new FigureType[] {CONTAINER_LITERAL, FIGURE1_LITERAL,
            FIGURE2_LITERAL, PORT_LITERAL, CLASS_LITERAL, LABEL_LITERAL, LABEL_FIGURE_LITERAL,};

    /**
     * A public read-only list of all the '<em><b>Figure Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Figure Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FigureType get(String name)
    {
        for (int i = 0; i < VALUES_ARRAY.length; ++i)
        {
            FigureType result = VALUES_ARRAY[i];
            if (result.toString().equals(name))
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Figure Type</b></em>' literal with the specified value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FigureType get(int value)
    {
        switch (value)
        {
            case CONTAINER:
                return CONTAINER_LITERAL;
            case FIGURE1:
                return FIGURE1_LITERAL;
            case FIGURE2:
                return FIGURE2_LITERAL;
            case PORT:
                return PORT_LITERAL;
            case CLASS:
                return CLASS_LITERAL;
            case LABEL:
                return LABEL_LITERAL;
            case LABEL_FIGURE:
                return LABEL_FIGURE_LITERAL;
        }
        return null;
    }

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private FigureType(int value, String name)
    {
        super(value, name);
    }

} //FigureType
