/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphConnector.java,v 1.13 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Graph Connector</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.GraphConnector#getPosition <em>Position</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.GraphConnector#getGraphEdge <em>Graph Edge</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.GraphConnector#getGraphElement <em>Graph Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphConnector()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface GraphConnector extends EModelElement
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
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphConnector_Position()
     * @model dataType="org.topcased.modeler.di.model.Point"
     * @generated
     */
    Point getPosition();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.GraphConnector#getPosition <em>Position</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Position</em>' attribute.
     * @see #getPosition()
     * @generated
     */
    void setPosition(Point value);

    /**
     * Returns the value of the '<em><b>Graph Edge</b></em>' reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.GraphEdge}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.GraphEdge#getAnchor <em>Anchor</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Graph Edge</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Graph Edge</em>' reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphConnector_GraphEdge()
     * @see org.topcased.modeler.di.model.GraphEdge#getAnchor
     * @model opposite="anchor"
     * @generated
     */
    EList<GraphEdge> getGraphEdge();

    /**
     * Returns the value of the '<em><b>Graph Element</b></em>' container reference. It is bidirectional and its
     * opposite is '{@link org.topcased.modeler.di.model.GraphElement#getAnchorage <em>Anchorage</em>}'. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Graph Element</em>' container reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Graph Element</em>' container reference.
     * @see #setGraphElement(GraphElement)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphConnector_GraphElement()
     * @see org.topcased.modeler.di.model.GraphElement#getAnchorage
     * @model opposite="anchorage" required="true"
     * @generated
     */
    GraphElement getGraphElement();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.GraphConnector#getGraphElement <em>Graph Element</em>}' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Graph Element</em>' container reference.
     * @see #getGraphElement()
     * @generated
     */
    void setGraphElement(GraphElement value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    boolean isVisible();

} // GraphConnector
