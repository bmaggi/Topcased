/**
 * <copyright>
 * </copyright>
 *
 * $Id: SendSignalActionImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.SendSignalAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Send Signal Action</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.SendSignalActionImpl#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SendSignalActionImpl extends EObjectImpl implements SendSignalAction
{
    /**
     * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSignal()
     * @generated
     * @ordered
     */
    protected BusinessType signal;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SendSignalActionImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return OcldiPackage.Literals.SEND_SIGNAL_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType getSignal()
    {
        if (signal != null && signal.eIsProxy())
        {
            InternalEObject oldSignal = (InternalEObject) signal;
            signal = (BusinessType) eResolveProxy(oldSignal);
            if (signal != oldSignal)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiPackage.SEND_SIGNAL_ACTION__SIGNAL, oldSignal, signal));
            }
        }
        return signal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType basicGetSignal()
    {
        return signal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSignal(BusinessType newSignal)
    {
        BusinessType oldSignal = signal;
        signal = newSignal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.SEND_SIGNAL_ACTION__SIGNAL, oldSignal, signal));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case OcldiPackage.SEND_SIGNAL_ACTION__SIGNAL:
                if (resolve)
                    return getSignal();
                return basicGetSignal();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case OcldiPackage.SEND_SIGNAL_ACTION__SIGNAL:
                setSignal((BusinessType) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case OcldiPackage.SEND_SIGNAL_ACTION__SIGNAL:
                setSignal((BusinessType) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case OcldiPackage.SEND_SIGNAL_ACTION__SIGNAL:
                return signal != null;
        }
        return super.eIsSet(featureID);
    }

} // SendSignalActionImpl
