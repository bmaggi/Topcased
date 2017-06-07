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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Palette Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.PaletteConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.PaletteConfiguration#getPaletteCategories <em>Palette Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='This object groups all the PaletteCategories'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204120829'"
 * @generated
 */
public interface PaletteConfiguration extends EObject{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteConfiguration_Name()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204120932'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PaletteConfiguration#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Palette Categories</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.PaletteCategory}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Palette Categories</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Palette Categories</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteConfiguration_PaletteCategories()
     * @model type="org.topcased.modeler.configurator.PaletteCategory" containment="true" required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204121033'"
     * @generated
     */
    EList getPaletteCategories();

} // PaletteConfiguration
