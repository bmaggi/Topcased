/**
 * <copyright> </copyright>
 * 
 * $Id: OutlineConfiguration.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Outline Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.OutlineConfiguration#getCreateChild <em>Create Child</em>}</li>
 * <li>{@link org.topcased.outline.configurator.OutlineConfiguration#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.outline.configurator.OutlineConfiguration#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.outline.configurator.OutlineConfiguration#getGenPackage <em>Gen Package</em>}</li>
 * <li>{@link org.topcased.outline.configurator.OutlineConfiguration#getPackage <em>Package</em>}</li>
 * <li>{@link org.topcased.outline.configurator.OutlineConfiguration#getPluginClassName <em>Plugin Class Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='The outline configuration contains all
 *        necessary information in order to generate customize outline code. This is the root model object.'"
 * @generated
 */
public interface OutlineConfiguration extends EObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Create Child</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Create Child</em>' containment reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Create Child</em>' containment reference.
     * @see #setCreateChild(CreateChildMenuConfiguration)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration_CreateChild()
     * @model containment="true"
     * @generated
     */
    CreateChildMenuConfiguration getCreateChild();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.OutlineConfiguration#getCreateChild <em>Create Child</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Create Child</em>' containment reference.
     * @see #getCreateChild()
     * @generated
     */
    void setCreateChild(CreateChildMenuConfiguration value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration_Name()
     * @model annotation="http://www.topcased.org/uuid uuid='11319564722945'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.OutlineConfiguration#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Project Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Project Name</em>' attribute.
     * @see #setProjectName(String)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration_ProjectName()
     * @model required="true"
     * @generated
     */
    String getProjectName();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.OutlineConfiguration#getProjectName <em>Project Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Project Name</em>' attribute.
     * @see #getProjectName()
     * @generated
     */
    void setProjectName(String value);

    /**
     * Returns the value of the '<em><b>Gen Package</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Package</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Gen Package</em>' reference.
     * @see #setGenPackage(GenPackage)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration_GenPackage()
     * @model required="true"
     * @generated
     */
    GenPackage getGenPackage();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.OutlineConfiguration#getGenPackage <em>Gen Package</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Gen Package</em>' reference.
     * @see #getGenPackage()
     * @generated
     */
    void setGenPackage(GenPackage value);

    /**
     * Returns the value of the '<em><b>Package</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Package</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Package</em>' attribute.
     * @see #setPackage(String)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration_Package()
     * @model annotation="http://www.topcased.org/uuid uuid='113196237518035'"
     *        annotation="http://www.topcased.org/documentation documentation='The package in which the \'Create child\'
     *        menu is generated. If empty, it is generated in the root package.'"
     * @generated
     */
    String getPackage();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.OutlineConfiguration#getPackage <em>Package</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Package</em>' attribute.
     * @see #getPackage()
     * @generated
     */
    void setPackage(String value);

    /**
     * Returns the value of the '<em><b>Plugin Class Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin Class Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Plugin Class Name</em>' attribute.
     * @see #setPluginClassName(String)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getOutlineConfiguration_PluginClassName()
     * @model
     * @generated
     */
    String getPluginClassName();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.OutlineConfiguration#getPluginClassName <em>Plugin Class Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Plugin Class Name</em>' attribute.
     * @see #getPluginClassName()
     * @generated
     */
    void setPluginClassName(String value);

    String getUtilitiesPackageName();

} // OutlineConfiguration
