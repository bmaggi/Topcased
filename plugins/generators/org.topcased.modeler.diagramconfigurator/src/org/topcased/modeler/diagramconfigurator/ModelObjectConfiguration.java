/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelObjectConfiguration.java,v 1.7 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Object Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getGenClass <em>Gen Class</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getModelObjectConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A ModelObjectConfiguration is associated with
 *        a model object through the genClass reference. It is eventually linked to several DiagramReference.'"
 * @generated
 */
public interface ModelObjectConfiguration extends ObjectConfiguration
{
    /**
     * Returns the value of the '<em><b>Gen Class</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Class</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Gen Class</em>' reference.
     * @see #setGenClass(GenClass)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getModelObjectConfiguration_GenClass()
     * @model required="true"
     * @generated
     */
    GenClass getGenClass();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getGenClass <em>Gen Class</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Gen Class</em>' reference.
     * @see #getGenClass()
     * @generated
     */
    void setGenClass(GenClass value);

    /**
     * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list. The list contents are of
     * type {@link org.topcased.modeler.diagramconfigurator.DiagramReference}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Diagrams</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getModelObjectConfiguration_Diagrams()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<DiagramReference> getDiagrams();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    String getName();

} // ModelObjectConfiguration
