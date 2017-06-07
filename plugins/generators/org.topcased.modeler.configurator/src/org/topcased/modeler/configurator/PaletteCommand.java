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
 * A representation of the model object '<em><b>Palette Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.PaletteCommand#getReturn <em>Return</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteCommand()
 * @model abstract="true"
 * @generated
 */
public interface PaletteCommand extends EObject
{
    /**
     * Returns the value of the '<em><b>Return</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Return</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Return</em>' attribute.
     * @see #setReturn(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPaletteCommand_Return()
     * @model
     * @generated
     */
    String getReturn();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PaletteCommand#getReturn <em>Return</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Return</em>' attribute.
     * @see #getReturn()
     * @generated
     */
    void setReturn(String value);

} // PaletteCommand
