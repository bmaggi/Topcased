/**
 * <copyright>
 * </copyright>
 *
 * $Id: PolylineImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Polyline;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Polyline</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.PolylineImpl#getWaypoints <em>Waypoints</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.PolylineImpl#isClosed <em>Closed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PolylineImpl extends GraphicPrimitiveImpl implements Polyline
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getWaypoints() <em>Waypoints</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWaypoints()
     * @generated
     * @ordered
     */
    protected EList<Point> waypoints;

    /**
     * The default value of the '{@link #isClosed() <em>Closed</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isClosed()
     * @generated
     * @ordered
     */
    protected static final boolean CLOSED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isClosed() <em>Closed</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isClosed()
     * @generated
     * @ordered
     */
    protected boolean closed = CLOSED_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PolylineImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramInterchangePackage.Literals.POLYLINE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<Point> getWaypoints()
    {
        if (waypoints == null)
        {
            waypoints = new EDataTypeUniqueEList<Point>(Point.class, this, DiagramInterchangePackage.POLYLINE__WAYPOINTS);
        }
        return waypoints;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isClosed()
    {
        return closed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setClosed(boolean newClosed)
    {
        boolean oldClosed = closed;
        closed = newClosed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.POLYLINE__CLOSED, oldClosed, closed));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.POLYLINE__WAYPOINTS:
                return getWaypoints();
            case DiagramInterchangePackage.POLYLINE__CLOSED:
                return isClosed();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.POLYLINE__WAYPOINTS:
                getWaypoints().clear();
                getWaypoints().addAll((Collection< ? extends Point>) newValue);
                return;
            case DiagramInterchangePackage.POLYLINE__CLOSED:
                setClosed((Boolean) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.POLYLINE__WAYPOINTS:
                getWaypoints().clear();
                return;
            case DiagramInterchangePackage.POLYLINE__CLOSED:
                setClosed(CLOSED_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.POLYLINE__WAYPOINTS:
                return waypoints != null && !waypoints.isEmpty();
            case DiagramInterchangePackage.POLYLINE__CLOSED:
                return closed != CLOSED_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (waypoints: "); //$NON-NLS-1$
        result.append(waypoints);
        result.append(", closed: "); //$NON-NLS-1$
        result.append(closed);
        result.append(')');
        return result.toString();
    }

} // PolylineImpl
