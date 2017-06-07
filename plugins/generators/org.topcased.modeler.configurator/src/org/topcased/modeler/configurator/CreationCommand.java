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
 * A representation of the model object '<em><b>Creation Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.CreationCommand#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getCreationCommand()
 * @model
 * @generated
 */
public interface CreationCommand extends PaletteCommand
{
    /**
     * Returns the value of the '<em><b>Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Element</em>' reference.
     * @see #setElement(ObjectConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getCreationCommand_Element()
     * @model
     * @generated
     */
    ObjectConfiguration getElement();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.CreationCommand#getElement <em>Element</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element</em>' reference.
     * @see #getElement()
     * @generated
     */
    void setElement(ObjectConfiguration value);

} // CreationCommand
