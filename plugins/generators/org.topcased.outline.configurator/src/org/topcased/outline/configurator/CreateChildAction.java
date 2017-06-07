/**
 * <copyright> </copyright>
 * 
 * $Id: CreateChildAction.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Create Child Action</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.CreateChildAction#getClass_ <em>Class</em>}</li>
 * <li>{@link org.topcased.outline.configurator.CreateChildAction#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getCreateChildAction()
 * @model annotation="http://www.topcased.org/documentation documentation='A CreateChildAction represents an action to
 *        create a given typed child.'"
 * @generated
 */
public interface CreateChildAction extends MenuItem
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Class</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Class</em>' reference.
     * @see #setClass(GenClass)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getCreateChildAction_Class()
     * @model required="true" annotation="http://www.topcased.org/uuid uuid='113196157870342'"
     * @generated
     */
    GenClass getClass_();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.CreateChildAction#getClass_ <em>Class</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Class</em>' reference.
     * @see #getClass_()
     * @generated
     */
    void setClass(GenClass value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are from the enumeration
     * {@link org.topcased.outline.configurator.ChildActionType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.topcased.outline.configurator.ChildActionType
     * @see #setType(ChildActionType)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getCreateChildAction_Type()
     * @model annotation="http://www.topcased.org/uuid uuid='113196157870443'"
     * @generated
     */
    ChildActionType getType();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.CreateChildAction#getType <em>Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.topcased.outline.configurator.ChildActionType
     * @see #getType()
     * @generated
     */
    void setType(ChildActionType value);

} // CreateChildAction
