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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Palette Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.PaletteItem#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.PaletteItem#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteItem()
 * @model annotation="http://www.topcased.org/documentation documentation='A PaletteItem is necessary associated with an ObjectConfiguration. It will represent an item in a Palette of a given Diagram'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204123972'"
 * @generated
 */
public interface PaletteItem extends EObject{
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
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteItem_Name()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204124075'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PaletteItem#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Part</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Part</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Part</em>' reference.
     * @see #setPart(PartConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteItem_Part()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204124277'"
     * @generated
     */
    PartConfiguration getPart();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PaletteItem#getPart <em>Part</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Part</em>' reference.
     * @see #getPart()
     * @generated
     */
    void setPart(PartConfiguration value);

} // PaletteItem
