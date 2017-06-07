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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Object Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.SimpleObjectConfiguration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSimpleObjectConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A SimpleObjectConfiguration is not linked with a model object. It has an attribute name that gives the string that will be used to reference the graphical object.'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204128999'"
 * @generated
 */
public interface SimpleObjectConfiguration extends ObjectConfiguration{
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
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSimpleObjectConfiguration_Name()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='1131982041291102'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SimpleObjectConfiguration#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // SimpleObjectConfiguration
