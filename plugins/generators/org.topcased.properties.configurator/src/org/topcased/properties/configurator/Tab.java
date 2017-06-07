/**
 * <copyright>
 * </copyright>
 *
 * $Id: Tab.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tab</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.Tab#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Tab#getLabel <em>Label</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Tab#getSections <em>Sections</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Tab#getCategory <em>Category</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Tab#getAfterTab <em>After Tab</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Tab#isIndented <em>Indented</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab()
 * @model
 * @generated
 */
public interface Tab extends EObject
{
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. The default value is <code>""</code>. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab_Id()
     * @model default="" required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getId();

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab_Label()
     * @model required="true"
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.Tab#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Sections</b></em>' containment reference list. The list contents are of
     * type {@link org.topcased.properties.configurator.AbstractSection}. It is bidirectional and its opposite is '{@link org.topcased.properties.configurator.AbstractSection#getTab <em>Tab</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sections</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Sections</em>' containment reference list.
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab_Sections()
     * @see org.topcased.properties.configurator.AbstractSection#getTab
     * @model type="org.topcased.properties.configurator.AbstractSection" opposite="tab" containment="true"
     * @generated
     */
    EList getSections();

    /**
     * Returns the value of the '<em><b>Category</b></em>' container reference. It is bidirectional and its
     * opposite is '{@link org.topcased.properties.configurator.Category#getTabs <em>Tabs</em>}'. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Category</em>' container reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Category</em>' container reference.
     * @see #setCategory(Category)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab_Category()
     * @see org.topcased.properties.configurator.Category#getTabs
     * @model opposite="tabs" required="true"
     * @generated
     */
    Category getCategory();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.Tab#getCategory <em>Category</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Category</em>' container reference.
     * @see #getCategory()
     * @generated
     */
    void setCategory(Category value);

    /**
     * Returns the value of the '<em><b>After Tab</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>After Tab</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>After Tab</em>' reference.
     * @see #setAfterTab(Tab)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab_AfterTab()
     * @model
     * @generated
     */
    Tab getAfterTab();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.Tab#getAfterTab <em>After Tab</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>After Tab</em>' reference.
     * @see #getAfterTab()
     * @generated
     */
    void setAfterTab(Tab value);

    /**
     * Returns the value of the '<em><b>Indented</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Indented</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Indented</em>' attribute.
     * @see #setIndented(boolean)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getTab_Indented()
     * @model required="true"
     * @generated
     */
    boolean isIndented();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.Tab#isIndented <em>Indented</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Indented</em>' attribute.
     * @see #isIndented()
     * @generated
     */
    void setIndented(boolean value);

} // Tab
