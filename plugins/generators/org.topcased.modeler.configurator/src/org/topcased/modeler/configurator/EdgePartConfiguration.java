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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Part Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.EdgePartConfiguration#getSourceTargetCouple <em>Source Target Couple</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgePartConfiguration#getEdgeObjects <em>Edge Objects</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgePartConfiguration#getSourceDecoration <em>Source Decoration</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgePartConfiguration#getTargetDecoration <em>Target Decoration</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgePartConfiguration#getDefaultRouter <em>Default Router</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgePartConfiguration#getDirectEditable <em>Direct Editable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A PartConfiguration will be associated with an EdgeEditPart at the generation process.'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204123160'"
 * @generated
 */
public interface EdgePartConfiguration extends PartConfiguration{
    /**
     * Returns the value of the '<em><b>Source Target Couple</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.SourceTargetCouple}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Target Couple</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Target Couple</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration_SourceTargetCouple()
     * @model type="org.topcased.modeler.configurator.SourceTargetCouple" containment="true" required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204123263'"
     * @generated
     */
    EList getSourceTargetCouple();

    /**
     * Returns the value of the '<em><b>Edge Objects</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.EdgeObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Edge Objects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Edge Objects</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration_EdgeObjects()
     * @model type="org.topcased.modeler.configurator.EdgeObject" containment="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204123364'"
     * @generated
     */
    EList getEdgeObjects();

    /**
     * Returns the value of the '<em><b>Source Decoration</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.DecorationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Decoration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Decoration</em>' attribute.
     * @see org.topcased.modeler.configurator.DecorationType
     * @see #setSourceDecoration(DecorationType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration_SourceDecoration()
     * @model default="NONE"
     *        annotation="http://www.topcased.org/uuid uuid='113198204123465'"
     * @generated
     */
    DecorationType getSourceDecoration();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getSourceDecoration <em>Source Decoration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Decoration</em>' attribute.
     * @see org.topcased.modeler.configurator.DecorationType
     * @see #getSourceDecoration()
     * @generated
     */
    void setSourceDecoration(DecorationType value);

    /**
     * Returns the value of the '<em><b>Target Decoration</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.DecorationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Decoration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Decoration</em>' attribute.
     * @see org.topcased.modeler.configurator.DecorationType
     * @see #setTargetDecoration(DecorationType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration_TargetDecoration()
     * @model default="NONE"
     *        annotation="http://www.topcased.org/uuid uuid='113198204123466'"
     * @generated
     */
    DecorationType getTargetDecoration();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getTargetDecoration <em>Target Decoration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Decoration</em>' attribute.
     * @see org.topcased.modeler.configurator.DecorationType
     * @see #getTargetDecoration()
     * @generated
     */
    void setTargetDecoration(DecorationType value);

    /**
     * Returns the value of the '<em><b>Default Router</b></em>' attribute.
     * The default value is <code>"ObliqueRouter"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.RouterType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Router</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Router</em>' attribute.
     * @see org.topcased.modeler.configurator.RouterType
     * @see #setDefaultRouter(RouterType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration_DefaultRouter()
     * @model default="ObliqueRouter"
     *        annotation="http://www.topcased.org/uuid uuid='113198204123567'"
     * @generated
     */
    RouterType getDefaultRouter();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getDefaultRouter <em>Default Router</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Router</em>' attribute.
     * @see org.topcased.modeler.configurator.RouterType
     * @see #getDefaultRouter()
     * @generated
     */
    void setDefaultRouter(RouterType value);

    /**
     * Returns the value of the '<em><b>Direct Editable</b></em>' reference.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Direct Editable</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Direct Editable</em>' reference.
     * @see #setDirectEditable(EdgeObject)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgePartConfiguration_DirectEditable()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204123668'"
     * @generated
     */
    EdgeObject getDirectEditable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getDirectEditable <em>Direct Editable</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Direct Editable</em>' reference.
     * @see #getDirectEditable()
     * @generated
     */
    void setDirectEditable(EdgeObject value);

} // EdgePartConfiguration
