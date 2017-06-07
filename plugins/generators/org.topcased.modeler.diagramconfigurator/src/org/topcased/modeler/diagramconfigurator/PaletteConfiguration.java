/**
 * <copyright>
 * </copyright>
 *
 * $Id: PaletteConfiguration.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Palette Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getPaletteCategories <em>Palette Categories</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='This object groups all the
 *        PaletteCategories'"
 * @generated
 */
public interface PaletteConfiguration extends EObject
{
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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteConfiguration_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Palette Categories</b></em>' containment reference list. The list contents
     * are of type {@link org.topcased.modeler.diagramconfigurator.PaletteCategory}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Palette Categories</em>' containment reference list isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Palette Categories</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPaletteConfiguration_PaletteCategories()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PaletteCategory> getPaletteCategories();

} // PaletteConfiguration
