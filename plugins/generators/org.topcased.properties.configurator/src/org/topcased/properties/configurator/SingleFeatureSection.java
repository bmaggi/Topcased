/**
 * <copyright>
 * </copyright>
 *
 * $Id: SingleFeatureSection.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Single Feature Section</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.SingleFeatureSection#getFeature <em>Feature</em>}</li>
 * <li>{@link org.topcased.properties.configurator.SingleFeatureSection#isMultiline <em>Multiline</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getSingleFeatureSection()
 * @model
 * @generated
 */
public interface SingleFeatureSection extends AbstractSection
{
    /**
     * Returns the value of the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Feature</em>' reference.
     * @see #setFeature(GenFeature)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getSingleFeatureSection_Feature()
     * @model required="true"
     * @generated
     */
    GenFeature getFeature();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.SingleFeatureSection#getFeature <em>Feature</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Feature</em>' reference.
     * @see #getFeature()
     * @generated
     */
    void setFeature(GenFeature value);

    /**
     * Returns the value of the '<em><b>Multiline</b></em>' attribute. The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Multiline</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Multiline</em>' attribute.
     * @see #setMultiline(boolean)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getSingleFeatureSection_Multiline()
     * @model default="false"
     * @generated
     */
    boolean isMultiline();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.SingleFeatureSection#isMultiline <em>Multiline</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Multiline</em>' attribute.
     * @see #isMultiline()
     * @generated
     */
    void setMultiline(boolean value);

} // SingleFeatureSection
