/**
 * <copyright>
 * </copyright>
 *
 * $Id: Diagrams.java,v 1.11 2007/04/12 08:32:16 jako Exp $
 */
package org.topcased.modeler.diagrams.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.Diagram;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagrams</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.diagrams.model.Diagrams#getModel <em>Model</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.Diagrams#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.Diagrams#getActiveDiagram <em>Active Diagram</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.Diagrams#getSubdiagrams <em>Subdiagrams</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.Diagrams#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.diagrams.model.DiagramsPackage#getDiagrams()
 * @model
 * @generated
 */
public interface Diagrams extends EObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "";

    /**
     * Returns the value of the '<em><b>Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model</em>' reference.
     * @see #setModel(EObject)
     * @see org.topcased.modeler.diagrams.model.DiagramsPackage#getDiagrams_Model()
     * @model required="true"
     * @generated
     */
    EObject getModel();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagrams.model.Diagrams#getModel <em>Model</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Model</em>' reference.
     * @see #getModel()
     * @generated
     */
    void setModel(EObject value);

    /**
     * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.Diagram}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diagrams</em>' containment reference list.
     * @see org.topcased.modeler.diagrams.model.DiagramsPackage#getDiagrams_Diagrams()
     * @model type="org.topcased.modeler.di.model.Diagram" containment="true" ordered="false"
     * @generated
     */
    EList<Diagram> getDiagrams();

    /**
     * Returns the value of the '<em><b>Active Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active Diagram</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active Diagram</em>' reference.
     * @see #setActiveDiagram(Diagram)
     * @see org.topcased.modeler.diagrams.model.DiagramsPackage#getDiagrams_ActiveDiagram()
     * @model
     * @generated
     */
    Diagram getActiveDiagram();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagrams.model.Diagrams#getActiveDiagram <em>Active Diagram</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Active Diagram</em>' reference.
     * @see #getActiveDiagram()
     * @generated
     */
    void setActiveDiagram(Diagram value);

    /**
     * Returns the value of the '<em><b>Subdiagrams</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.diagrams.model.Diagrams}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.diagrams.model.Diagrams#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Subdiagrams</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Subdiagrams</em>' containment reference list.
     * @see org.topcased.modeler.diagrams.model.DiagramsPackage#getDiagrams_Subdiagrams()
     * @see org.topcased.modeler.diagrams.model.Diagrams#getParent
     * @model type="org.topcased.modeler.diagrams.model.Diagrams" opposite="parent" containment="true" resolveProxies="true" ordered="false"
     * @generated
     */
    EList<Diagrams> getSubdiagrams();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference. It is bidirectional and its opposite
     * is '{@link org.topcased.modeler.diagrams.model.Diagrams#getSubdiagrams <em>Subdiagrams</em>}'. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(Diagrams)
     * @see org.topcased.modeler.diagrams.model.DiagramsPackage#getDiagrams_Parent()
     * @see org.topcased.modeler.diagrams.model.Diagrams#getSubdiagrams
     * @model opposite="subdiagrams"
     * @generated
     */
    Diagrams getParent();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagrams.model.Diagrams#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(Diagrams value);

} // Diagrams
