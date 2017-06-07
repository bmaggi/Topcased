/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdvancedSection.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Advanced Section</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.AdvancedSection#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAdvancedSection()
 * @model
 * @generated
 */
public interface AdvancedSection extends AbstractSection
{
    /**
     * Returns the value of the '<em><b>Input</b></em>' reference list. The list contents are of type
     * {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Input</em>' reference list.
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getAdvancedSection_Input()
     * @model type="org.eclipse.emf.codegen.ecore.genmodel.GenClass" required="true"
     * @generated
     */
    EList getInput();

} // AdvancedSection
