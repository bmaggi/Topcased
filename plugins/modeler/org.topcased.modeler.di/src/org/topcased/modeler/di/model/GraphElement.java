/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphElement.java,v 1.14 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Graph Element</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.GraphElement#getPosition <em>Position</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.GraphElement#getAnchorage <em>Anchorage</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.GraphElement#getSemanticModel <em>Semantic Model</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.GraphElement#getContained <em>Contained</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.GraphElement#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphElement()
 * @model abstract="true"
 * @generated
 */
public interface GraphElement extends DiagramElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Position</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Position</em>' attribute.
     * @see #setPosition(Point)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphElement_Position()
     * @model dataType="org.topcased.modeler.di.model.Point"
     * @generated
     */
    Point getPosition();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.GraphElement#getPosition <em>Position</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Position</em>' attribute.
     * @see #getPosition()
     * @generated
     */
    void setPosition(Point value);

    /**
     * Returns the value of the '<em><b>Anchorage</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.GraphConnector}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.GraphConnector#getGraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Anchorage</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Anchorage</em>' containment reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphElement_Anchorage()
     * @see org.topcased.modeler.di.model.GraphConnector#getGraphElement
     * @model opposite="graphElement" containment="true"
     * @generated
     */
    EList<GraphConnector> getAnchorage();

    /**
     * Returns the value of the '<em><b>Semantic Model</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.SemanticModelBridge#getGraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Semantic Model</em>' containment reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Semantic Model</em>' containment reference.
     * @see #setSemanticModel(SemanticModelBridge)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphElement_SemanticModel()
     * @see org.topcased.modeler.di.model.SemanticModelBridge#getGraphElement
     * @model opposite="graphElement" containment="true" required="true"
     * @generated
     */
    SemanticModelBridge getSemanticModel();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.GraphElement#getSemanticModel <em>Semantic Model</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Semantic Model</em>' containment reference.
     * @see #getSemanticModel()
     * @generated
     */
    void setSemanticModel(SemanticModelBridge value);

    /**
     * Returns the value of the '<em><b>Contained</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.DiagramElement}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.DiagramElement#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contained</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Contained</em>' containment reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphElement_Contained()
     * @see org.topcased.modeler.di.model.DiagramElement#getContainer
     * @model opposite="container" containment="true"
     * @generated
     */
    EList<DiagramElement> getContained();

    /**
     * Returns the value of the '<em><b>Link</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.DiagramLink}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.DiagramLink#getGraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Link</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Link</em>' containment reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphElement_Link()
     * @see org.topcased.modeler.di.model.DiagramLink#getGraphElement
     * @model opposite="graphElement" containment="true"
     * @generated
     */
    EList<DiagramLink> getLink();

} // GraphElement
