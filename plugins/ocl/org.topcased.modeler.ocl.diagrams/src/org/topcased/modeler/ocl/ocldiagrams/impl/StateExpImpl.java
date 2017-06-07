/**
 * <copyright>
 * </copyright>
 *
 * $Id: StateExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.StateExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>State Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.StateExpImpl#getReferredState <em>Referred State</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StateExpImpl extends OCLExpressionImpl implements StateExp
{
    /**
     * The cached value of the '{@link #getReferredState() <em>Referred State</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getReferredState()
     * @generated
     * @ordered
     */
    protected EObject referredState;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StateExpImpl()
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
        return OcldiagramsPackage.Literals.STATE_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EObject getReferredState()
    {
        if (referredState != null && ((EObject) referredState).eIsProxy())
        {
            InternalEObject oldReferredState = (InternalEObject) referredState;
            referredState = (EObject) eResolveProxy(oldReferredState);
            if (referredState != oldReferredState)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.STATE_EXP__REFERRED_STATE, oldReferredState, referredState));
            }
        }
        return referredState;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EObject basicGetReferredState()
    {
        return referredState;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredState(EObject newReferredState)
    {
        EObject oldReferredState = referredState;
        referredState = newReferredState;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.STATE_EXP__REFERRED_STATE, oldReferredState, referredState));
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
            case OcldiagramsPackage.STATE_EXP__REFERRED_STATE:
                if (resolve)
                    return getReferredState();
                return basicGetReferredState();
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
            case OcldiagramsPackage.STATE_EXP__REFERRED_STATE:
                setReferredState((EObject) newValue);
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
            case OcldiagramsPackage.STATE_EXP__REFERRED_STATE:
                setReferredState((EObject) null);
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
            case OcldiagramsPackage.STATE_EXP__REFERRED_STATE:
                return referredState != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class< ? > baseClass)
    {
        if (baseClass == org.eclipse.ocl.expressions.StateExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.STATE_EXP__REFERRED_STATE:
                    return ExpressionsPackage.STATE_EXP__REFERRED_STATE;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class< ? > baseClass)
    {
        if (baseClass == org.eclipse.ocl.expressions.StateExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.STATE_EXP__REFERRED_STATE:
                    return OcldiagramsPackage.STATE_EXP__REFERRED_STATE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // StateExpImpl
