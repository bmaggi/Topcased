/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.topcased.modeler.configurator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.EdgeObject#getType <em>Type</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgeObject#getEStructuralFeature <em>EStructural Feature</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EdgeObject#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgeObject()
 * @model annotation="http://www.topcased.org/uuid uuid='113198204123769'"
 * @generated
 */
public interface EdgeObject extends EObject{
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.EdgeObjectType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.topcased.modeler.configurator.EdgeObjectType
     * @see #setType(EdgeObjectType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgeObject_Type()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204123770'"
     * @generated
     */
    EdgeObjectType getType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgeObject#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.topcased.modeler.configurator.EdgeObjectType
     * @see #getType()
     * @generated
     */
    void setType(EdgeObjectType value);

    /**
     * Returns the value of the '<em><b>EStructural Feature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>EStructural Feature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>EStructural Feature</em>' reference.
     * @see #setEStructuralFeature(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgeObject_EStructuralFeature()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204123871'"
     * @generated
     */
    EStructuralFeature getEStructuralFeature();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgeObject#getEStructuralFeature <em>EStructural Feature</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>EStructural Feature</em>' reference.
     * @see #getEStructuralFeature()
     * @generated
     */
    void setEStructuralFeature(EStructuralFeature value);

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
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEdgeObject_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EdgeObject#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // EdgeObject
