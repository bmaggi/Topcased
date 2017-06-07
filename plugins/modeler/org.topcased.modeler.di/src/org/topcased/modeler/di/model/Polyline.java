/**
 * <copyright>
 * </copyright>
 *
 * $Id: Polyline.java,v 1.9 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Polyline</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.Polyline#getWaypoints <em>Waypoints</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Polyline#isClosed <em>Closed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getPolyline()
 * @model
 * @generated
 */
public interface Polyline extends GraphicPrimitive
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Waypoints</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.draw2d.geometry.Point}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Waypoints</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Waypoints</em>' attribute list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getPolyline_Waypoints()
     * @model dataType="org.topcased.modeler.di.model.Point" lower="2"
     * @generated
     */
    EList<Point> getWaypoints();

    /**
     * Returns the value of the '<em><b>Closed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Closed</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Closed</em>' attribute.
     * @see #setClosed(boolean)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getPolyline_Closed()
     * @model
     * @generated
     */
    boolean isClosed();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Polyline#isClosed <em>Closed</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Closed</em>' attribute.
     * @see #isClosed()
     * @generated
     */
    void setClosed(boolean value);

} // Polyline
