/**
 * <copyright>
 * </copyright>
 *
 * $Id: TabbedView.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tabbed View</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.TabbedView#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.properties.configurator.TabbedView#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.properties.configurator.TabbedView#getCategories <em>Categories</em>}</li>
 * <li>{@link org.topcased.properties.configurator.TabbedView#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.properties.configurator.TabbedView#getGenModel <em>Gen Model</em>}</li>
 * <li>{@link org.topcased.properties.configurator.TabbedView#getBasePackage <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView()
 * @model
 * @generated
 */
public interface TabbedView extends EObject
{
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
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView_ProjectName()
     * @model required="true"
     * @generated
     */
    String getProjectName();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.TabbedView#getProjectName <em>Project Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Project Name</em>' attribute.
     * @see #getProjectName()
     * @generated
     */
    void setProjectName(String value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.TabbedView#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Categories</b></em>' containment reference list. The list contents are of
     * type {@link org.topcased.properties.configurator.Category}. It is bidirectional and its opposite is '{@link org.topcased.properties.configurator.Category#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Categories</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Categories</em>' containment reference list.
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView_Categories()
     * @see org.topcased.properties.configurator.Category#getParent
     * @model type="org.topcased.properties.configurator.Category" opposite="parent" containment="true" required="true"
     * @generated
     */
    EList getCategories();

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
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.TabbedView#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Gen Model</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Model</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Gen Model</em>' reference.
     * @see #setGenModel(GenModel)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView_GenModel()
     * @model
     * @generated
     */
    GenModel getGenModel();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.TabbedView#getGenModel <em>Gen Model</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Gen Model</em>' reference.
     * @see #getGenModel()
     * @generated
     */
    void setGenModel(GenModel value);

    /**
     * Returns the value of the '<em><b>Base Package</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Package</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Base Package</em>' attribute.
     * @see #setBasePackage(String)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTabbedView_BasePackage()
     * @model
     * @generated
     */
    String getBasePackage();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.TabbedView#getBasePackage <em>Base Package</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Base Package</em>' attribute.
     * @see #getBasePackage()
     * @generated
     */
    void setBasePackage(String value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    String getProjectNameUnspaced();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    String getIdUnspaced();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model toReplaceRequired="true"
     * @generated
     */
    String replaceSpaces(String toReplace);

} // TabbedView
