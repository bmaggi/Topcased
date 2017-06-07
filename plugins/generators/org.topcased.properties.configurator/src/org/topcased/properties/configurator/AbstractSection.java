/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractSection.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Section</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.AbstractSection#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.properties.configurator.AbstractSection#getTab <em>Tab</em>}</li>
 * <li>{@link org.topcased.properties.configurator.AbstractSection#getAfterSection <em>After Section</em>}</li>
 * <li>{@link org.topcased.properties.configurator.AbstractSection#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAbstractSection()
 * @model abstract="true"
 * @generated
 */
public interface AbstractSection extends EObject
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
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAbstractSection_Id()
     * @model default="" required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getId();

    /**
     * Returns the value of the '<em><b>Tab</b></em>' container reference. It is bidirectional and its opposite is '{@link org.topcased.properties.configurator.Tab#getSections <em>Sections</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tab</em>' container reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Tab</em>' container reference.
     * @see #setTab(Tab)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAbstractSection_Tab()
     * @see org.topcased.properties.configurator.Tab#getSections
     * @model opposite="sections" required="true"
     * @generated
     */
    Tab getTab();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.AbstractSection#getTab <em>Tab</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Tab</em>' container reference.
     * @see #getTab()
     * @generated
     */
    void setTab(Tab value);

    /**
     * Returns the value of the '<em><b>After Section</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>After Section</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>After Section</em>' reference.
     * @see #setAfterSection(AbstractSection)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAbstractSection_AfterSection()
     * @model
     * @generated
     */
    AbstractSection getAfterSection();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.AbstractSection#getAfterSection <em>After Section</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>After Section</em>' reference.
     * @see #getAfterSection()
     * @generated
     */
    void setAfterSection(AbstractSection value);

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
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAbstractSection_Label()
     * @model
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.AbstractSection#getLabel <em>Label</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    String getClassName();

} // AbstractSection
