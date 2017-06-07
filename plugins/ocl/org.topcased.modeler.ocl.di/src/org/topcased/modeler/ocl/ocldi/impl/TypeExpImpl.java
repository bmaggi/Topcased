/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.TypeExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.TypeExpImpl#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TypeExpImpl extends OCLExpressionImpl implements TypeExp
{
    /**
     * The cached value of the '{@link #getReferredType() <em>Referred Type</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getReferredType()
     * @generated
     * @ordered
     */
    protected BusinessType referredType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypeExpImpl()
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
        return OcldiPackage.Literals.TYPE_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType getReferredType()
    {
        if (referredType != null && ((EObject) referredType).eIsProxy())
        {
            InternalEObject oldReferredType = (InternalEObject) referredType;
            referredType = (BusinessType) eResolveProxy(oldReferredType);
            if (referredType != oldReferredType)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiPackage.TYPE_EXP__REFERRED_TYPE, oldReferredType, referredType));
            }
        }
        return referredType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType basicGetReferredType()
    {
        return referredType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredType(BusinessType newReferredType)
    {
        BusinessType oldReferredType = referredType;
        referredType = newReferredType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.TYPE_EXP__REFERRED_TYPE, oldReferredType, referredType));
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
            case OcldiPackage.TYPE_EXP__REFERRED_TYPE:
                if (resolve)
                    return getReferredType();
                return basicGetReferredType();
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
            case OcldiPackage.TYPE_EXP__REFERRED_TYPE:
                setReferredType((BusinessType) newValue);
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
            case OcldiPackage.TYPE_EXP__REFERRED_TYPE:
                setReferredType((BusinessType) null);
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
            case OcldiPackage.TYPE_EXP__REFERRED_TYPE:
                return referredType != null;
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
        if (baseClass == org.eclipse.ocl.expressions.TypeExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.TYPE_EXP__REFERRED_TYPE:
                    return ExpressionsPackage.TYPE_EXP__REFERRED_TYPE;
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
        if (baseClass == org.eclipse.ocl.expressions.TypeExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.TYPE_EXP__REFERRED_TYPE:
                    return OcldiPackage.TYPE_EXP__REFERRED_TYPE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // TypeExpImpl
