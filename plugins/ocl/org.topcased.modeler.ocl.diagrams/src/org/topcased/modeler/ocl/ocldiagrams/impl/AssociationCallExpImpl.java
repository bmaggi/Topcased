/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationCallExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.topcased.modeler.ocl.ocldiagrams.AssociationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Association Call Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.AssociationCallExpImpl#getReferredAssociationClass <em>Referred
 * Association Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AssociationCallExpImpl extends NavigationCallExpImpl implements AssociationCallExp
{
    /**
     * The cached value of the '{@link #getReferredAssociationClass() <em>Referred Association Class</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReferredAssociationClass()
     * @generated
     * @ordered
     */
    protected BusinessType referredAssociationClass;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AssociationCallExpImpl()
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
        return OcldiagramsPackage.Literals.ASSOCIATION_CALL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType getReferredAssociationClass()
    {
        if (referredAssociationClass != null && ((EObject) referredAssociationClass).eIsProxy())
        {
            InternalEObject oldReferredAssociationClass = (InternalEObject) referredAssociationClass;
            referredAssociationClass = (BusinessType) eResolveProxy(oldReferredAssociationClass);
            if (referredAssociationClass != oldReferredAssociationClass)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS, oldReferredAssociationClass,
                            referredAssociationClass));
            }
        }
        return referredAssociationClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType basicGetReferredAssociationClass()
    {
        return referredAssociationClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredAssociationClass(BusinessType newReferredAssociationClass)
    {
        BusinessType oldReferredAssociationClass = referredAssociationClass;
        referredAssociationClass = newReferredAssociationClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS, oldReferredAssociationClass, referredAssociationClass));
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
            case OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
                if (resolve)
                    return getReferredAssociationClass();
                return basicGetReferredAssociationClass();
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
            case OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
                setReferredAssociationClass((BusinessType) newValue);
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
            case OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
                setReferredAssociationClass((BusinessType) null);
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
            case OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
                return referredAssociationClass != null;
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
        if (baseClass == AssociationClassCallExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
                    return ExpressionsPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS;
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
        if (baseClass == AssociationClassCallExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS:
                    return OcldiagramsPackage.ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // AssociationCallExpImpl
