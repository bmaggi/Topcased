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
 * A representation of the model object '<em><b>Diagram Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getId <em>Id</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getPackage <em>Package</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getPalette <em>Palette</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getParts <em>Parts</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramConfiguration#getLayout <em>Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A DiagramConfiguration contains informations used to generate a Diagram'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204119012'"
 * @generated
 */
public interface DiagramConfiguration extends EObject{
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Id()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119215'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramConfiguration#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

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
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Name()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119316'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramConfiguration#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Package</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Package</em>' attribute.
     * @see #setPackage(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Package()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119317'"
     * @generated
     */
    String getPackage();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramConfiguration#getPackage <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package</em>' attribute.
     * @see #getPackage()
     * @generated
     */
    void setPackage(String value);

    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Prefix()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119418'"
     * @generated
     */
    String getPrefix();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramConfiguration#getPrefix <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix(String value);

    /**
     * Returns the value of the '<em><b>Palette</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Palette</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Palette</em>' containment reference.
     * @see #setPalette(PaletteConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Palette()
     * @model containment="true" required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119519'"
     * @generated
     */
    PaletteConfiguration getPalette();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramConfiguration#getPalette <em>Palette</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Palette</em>' containment reference.
     * @see #getPalette()
     * @generated
     */
    void setPalette(PaletteConfiguration value);

    /**
     * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.PartConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parts</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parts</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Parts()
     * @model type="org.topcased.modeler.configurator.PartConfiguration" containment="true" required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119620'"
     * @generated
     */
    EList getParts();

    /**
     * Returns the value of the '<em><b>Layout</b></em>' attribute.
     * The default value is <code>"XYLayout"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.LayoutType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Layout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Layout</em>' attribute.
     * @see org.topcased.modeler.configurator.LayoutType
     * @see #setLayout(LayoutType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramConfiguration_Layout()
     * @model default="XYLayout"
     *        annotation="http://www.topcased.org/uuid uuid='113198204120321'"
     * @generated
     */
    LayoutType getLayout();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramConfiguration#getLayout <em>Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layout</em>' attribute.
     * @see org.topcased.modeler.configurator.LayoutType
     * @see #getLayout()
     * @generated
     */
    void setLayout(LayoutType value);

} // DiagramConfiguration
