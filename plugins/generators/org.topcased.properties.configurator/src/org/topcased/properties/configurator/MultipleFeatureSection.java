/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultipleFeatureSection.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multiple Feature Section</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.MultipleFeatureSection#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getMultipleFeatureSection()
 * @model
 * @generated
 */
public interface MultipleFeatureSection extends AbstractSection
{
    /**
     * Returns the value of the '<em><b>Features</b></em>' reference list. The list contents are of type
     * {@link org.eclipse.emf.codegen.ecore.genmodel.GenFeature}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Features</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Features</em>' reference list.
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getMultipleFeatureSection_Features()
     * @model type="org.eclipse.emf.codegen.ecore.genmodel.GenFeature" required="true"
     * @generated
     */
    EList getFeatures();

} // MultipleFeatureSection
