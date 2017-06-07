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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Object Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.ModelObjectConfiguration#getGenClass <em>Gen Class</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.ModelObjectConfiguration#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getModelObjectConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A ModelObjectConfiguration is associated with a model object through the genClass reference. It is eventually linked to several DiagramReference.'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204128694'"
 * @generated
 */
public interface ModelObjectConfiguration extends ObjectConfiguration{
    /**
     * Returns the value of the '<em><b>Gen Class</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Class</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gen Class</em>' reference.
     * @see #setGenClass(GenClass)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getModelObjectConfiguration_GenClass()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204128897'"
     * @generated
     */
    GenClass getGenClass();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.ModelObjectConfiguration#getGenClass <em>Gen Class</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gen Class</em>' reference.
     * @see #getGenClass()
     * @generated
     */
    void setGenClass(GenClass value);

    /**
     * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.DiagramReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diagrams</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getModelObjectConfiguration_Diagrams()
     * @model type="org.topcased.modeler.configurator.DiagramReference" containment="true" ordered="false"
     *        annotation="http://www.topcased.org/uuid uuid='113198204128898'"
     * @generated
     */
    EList getDiagrams();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    String getName();

} // ModelObjectConfiguration
