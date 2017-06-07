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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Child Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.AddChildCommand#getTo <em>To</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.AddChildCommand#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.AddChildCommand#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getAddChildCommand()
 * @model
 * @generated
 */
public interface AddChildCommand extends PaletteCommand
{
    /**
     * Returns the value of the '<em><b>To</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' attribute.
     * @see #setTo(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getAddChildCommand_To()
     * @model
     * @generated
     */
    String getTo();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.AddChildCommand#getTo <em>To</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' attribute.
     * @see #getTo()
     * @generated
     */
    void setTo(String value);

    /**
     * Returns the value of the '<em><b>Feature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature</em>' reference.
     * @see #setFeature(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getAddChildCommand_Feature()
     * @model
     * @generated
     */
    EStructuralFeature getFeature();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.AddChildCommand#getFeature <em>Feature</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Feature</em>' reference.
     * @see #getFeature()
     * @generated
     */
    void setFeature(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Child</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child</em>' attribute.
     * @see #setChild(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getAddChildCommand_Child()
     * @model
     * @generated
     */
    String getChild();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.AddChildCommand#getChild <em>Child</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Child</em>' attribute.
     * @see #getChild()
     * @generated
     */
    void setChild(String value);

} // AddChildCommand
