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
 * A representation of the model object '<em><b>Part Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.PartConfiguration#getObject <em>Object</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.PartConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.PartConfiguration#isForegroundColorChangeable <em>Foreground Color Changeable</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.PartConfiguration#isFontChangeable <em>Font Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPartConfiguration()
 * @model abstract="true"
 *        annotation="http://www.topcased.org/documentation documentation='A PartConfiguration will be associated with an EditPart at the generation process.'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204121439'"
 * @generated
 */
public interface PartConfiguration extends EObject{
    /**
     * Returns the value of the '<em><b>Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Object</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Object</em>' reference.
     * @see #setObject(ObjectConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPartConfiguration_Object()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204121542'"
     * @generated
     */
    ObjectConfiguration getObject();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PartConfiguration#getObject <em>Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object</em>' reference.
     * @see #getObject()
     * @generated
     */
    void setObject(ObjectConfiguration value);

    /**
     * Returns the value of the '<em><b>Default Foreground Color</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Foreground Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Foreground Color</em>' attribute.
     * @see #setDefaultForegroundColor(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPartConfiguration_DefaultForegroundColor()
     * @model default=""
     *        annotation="http://www.topcased.org/uuid uuid='113198204121643'"
     * @generated
     */
    String getDefaultForegroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PartConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Foreground Color</em>' attribute.
     * @see #getDefaultForegroundColor()
     * @generated
     */
    void setDefaultForegroundColor(String value);

    /**
     * Returns the value of the '<em><b>Foreground Color Changeable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreground Color Changeable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreground Color Changeable</em>' attribute.
     * @see #setForegroundColorChangeable(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPartConfiguration_ForegroundColorChangeable()
     * @model default="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204121744'"
     * @generated
     */
    boolean isForegroundColorChangeable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PartConfiguration#isForegroundColorChangeable <em>Foreground Color Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreground Color Changeable</em>' attribute.
     * @see #isForegroundColorChangeable()
     * @generated
     */
    void setForegroundColorChangeable(boolean value);

    /**
     * Returns the value of the '<em><b>Font Changeable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Font Changeable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Font Changeable</em>' attribute.
     * @see #setFontChangeable(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getPartConfiguration_FontChangeable()
     * @model default="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204121945'"
     * @generated
     */
    boolean isFontChangeable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.PartConfiguration#isFontChangeable <em>Font Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Font Changeable</em>' attribute.
     * @see #isFontChangeable()
     * @generated
     */
    void setFontChangeable(boolean value);

} // PartConfiguration
