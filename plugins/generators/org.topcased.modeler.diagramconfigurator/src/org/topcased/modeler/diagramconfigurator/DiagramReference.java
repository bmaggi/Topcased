/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramReference.java,v 1.6 2007/04/18 12:20:58 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram Reference</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getDiagram <em>Diagram</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getLowerBound <em>Lower Bound</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramReference()
 * @model annotation="http://www.topcased.org/documentation documentation='A DiagramReference is linked with a
 *        DiagramConfiguration'"
 * @generated
 */
public interface DiagramReference extends EObject
{
    /**
     * Returns the value of the '<em><b>Diagram</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagram</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Diagram</em>' reference.
     * @see #setDiagram(DiagramConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramReference_Diagram()
     * @model required="true"
     * @generated
     */
    DiagramConfiguration getDiagram();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getDiagram <em>Diagram</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Diagram</em>' reference.
     * @see #getDiagram()
     * @generated
     */
    void setDiagram(DiagramConfiguration value);

    /**
     * Returns the value of the '<em><b>Lower Bound</b></em>' attribute. The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Lower Bound</em>' attribute.
     * @see #setLowerBound(int)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramReference_LowerBound()
     * @model default="0" ordered="false"
     * @generated
     */
    int getLowerBound();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getLowerBound <em>Lower Bound</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Lower Bound</em>' attribute.
     * @see #getLowerBound()
     * @generated
     */
    void setLowerBound(int value);

    /**
     * Returns the value of the '<em><b>Upper Bound</b></em>' attribute. The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Upper Bound</em>' attribute.
     * @see #setUpperBound(int)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramReference_UpperBound()
     * @model default="-1" ordered="false"
     * @generated
     */
    int getUpperBound();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getUpperBound <em>Upper Bound</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Upper Bound</em>' attribute.
     * @see #getUpperBound()
     * @generated
     */
    void setUpperBound(int value);

} // DiagramReference
