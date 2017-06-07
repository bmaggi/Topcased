/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectUVImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.EdgeObjectUV;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge Object UV</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectUVImpl#getUDistance <em>UDistance</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectUVImpl#getVDistance <em>VDistance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeObjectUVImpl extends EdgeObjectImpl implements EdgeObjectUV
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getUDistance() <em>UDistance</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getUDistance()
     * @generated
     * @ordered
     */
    protected static final int UDISTANCE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getUDistance() <em>UDistance</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getUDistance()
     * @generated
     * @ordered
     */
    protected int uDistance = UDISTANCE_EDEFAULT;

    /**
     * The default value of the '{@link #getVDistance() <em>VDistance</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getVDistance()
     * @generated
     * @ordered
     */
    protected static final int VDISTANCE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getVDistance() <em>VDistance</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getVDistance()
     * @generated
     * @ordered
     */
    protected int vDistance = VDISTANCE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EdgeObjectUVImpl()
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
        return DiagramInterchangePackage.Literals.EDGE_OBJECT_UV;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public int getUDistance()
    {
        return uDistance;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setUDistance(int newUDistance)
    {
        int oldUDistance = uDistance;
        uDistance = newUDistance;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.EDGE_OBJECT_UV__UDISTANCE, oldUDistance, uDistance));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public int getVDistance()
    {
        return vDistance;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setVDistance(int newVDistance)
    {
        int oldVDistance = vDistance;
        vDistance = newVDistance;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.EDGE_OBJECT_UV__VDISTANCE, oldVDistance, vDistance));
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
            case DiagramInterchangePackage.EDGE_OBJECT_UV__UDISTANCE:
                return getUDistance();
            case DiagramInterchangePackage.EDGE_OBJECT_UV__VDISTANCE:
                return getVDistance();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.EDGE_OBJECT_UV__UDISTANCE:
                setUDistance((Integer) newValue);
                return;
            case DiagramInterchangePackage.EDGE_OBJECT_UV__VDISTANCE:
                setVDistance((Integer) newValue);
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
            case DiagramInterchangePackage.EDGE_OBJECT_UV__UDISTANCE:
                setUDistance(UDISTANCE_EDEFAULT);
                return;
            case DiagramInterchangePackage.EDGE_OBJECT_UV__VDISTANCE:
                setVDistance(VDISTANCE_EDEFAULT);
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
            case DiagramInterchangePackage.EDGE_OBJECT_UV__UDISTANCE:
                return uDistance != UDISTANCE_EDEFAULT;
            case DiagramInterchangePackage.EDGE_OBJECT_UV__VDISTANCE:
                return vDistance != VDISTANCE_EDEFAULT;
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
        result.append(" (uDistance: "); //$NON-NLS-1$
        result.append(uDistance);
        result.append(", vDistance: "); //$NON-NLS-1$
        result.append(vDistance);
        result.append(')');
        return result.toString();
    }

} // EdgeObjectUVImpl
