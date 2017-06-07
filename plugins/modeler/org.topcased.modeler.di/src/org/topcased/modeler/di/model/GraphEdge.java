/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphEdge.java,v 1.16 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Graph Edge</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.GraphEdge#getWaypoints <em>Waypoints</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.GraphEdge#getAnchor <em>Anchor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphEdge()
 * @model
 * @generated
 */
public interface GraphEdge extends GraphElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Waypoints</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Waypoints</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Waypoints</em>' attribute list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphEdge_Waypoints()
     * @model dataType="org.topcased.modeler.di.model.RelativeBendpoint"
     * @generated
     */
    EList<RelativeBendpoint> getWaypoints();

    /**
     * Returns the value of the '<em><b>Anchor</b></em>' reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.GraphConnector}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.GraphConnector#getGraphEdge <em>Graph Edge</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Anchor</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Anchor</em>' reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphEdge_Anchor()
     * @see org.topcased.modeler.di.model.GraphConnector#getGraphEdge
     * @model opposite="graphEdge" lower="2" upper="2"
     * @generated
     */
    EList<GraphConnector> getAnchor();

} // GraphEdge
