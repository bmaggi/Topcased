/**
 * <copyright>
 * </copyright>
 *
 * $Id: EMFBridgeImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.GraphconfPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EMF Bridge</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.EMFBridgeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EMFBridgeImpl extends BridgeImpl implements EMFBridge
{
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected EClass type = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EMFBridgeImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass()
    {
        return GraphconfPackage.Literals.EMF_BRIDGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getType()
    {
        if (type != null && type.eIsProxy())
        {
            InternalEObject oldType = (InternalEObject) type;
            type = (EClass) eResolveProxy(oldType);
            if (type != oldType)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphconfPackage.EMF_BRIDGE__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass basicGetType()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setType(EClass newType)
    {
        EClass oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.EMF_BRIDGE__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case GraphconfPackage.EMF_BRIDGE__TYPE:
                if (resolve)
                    return getType();
                return basicGetType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case GraphconfPackage.EMF_BRIDGE__TYPE:
                setType((EClass) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case GraphconfPackage.EMF_BRIDGE__TYPE:
                setType((EClass) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case GraphconfPackage.EMF_BRIDGE__TYPE:
                return type != null;
        }
        return super.eIsSet(featureID);
    }

} // EMFBridgeImpl
