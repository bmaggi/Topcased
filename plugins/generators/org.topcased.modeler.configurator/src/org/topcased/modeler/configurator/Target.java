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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.Target#getObject <em>Object</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.Target#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends EObject
{
    /**
     * Returns the value of the '<em><b>Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Object</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Object</em>' reference.
     * @see #setObject(GenClass)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getTarget_Object()
     * @model
     * @generated
     */
    GenClass getObject();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.Target#getObject <em>Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object</em>' reference.
     * @see #getObject()
     * @generated
     */
    void setObject(GenClass value);

    /**
     * Returns the value of the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' reference.
     * @see #setReference(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getTarget_Reference()
     * @model
     * @generated
     */
    EStructuralFeature getReference();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.Target#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
    void setReference(EStructuralFeature value);

} // Target
