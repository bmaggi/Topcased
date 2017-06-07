/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertyCallExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.operations.PropertyCallExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.PropertyCallExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property Call Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PropertyCallExpImpl extends NavigationCallExpImpl implements PropertyCallExp
{
    /**
     * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReferredProperty()
     * @generated
     * @ordered
     */
    protected EStructuralFeature referredProperty;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PropertyCallExpImpl()
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
        return OcldiagramsPackage.Literals.PROPERTY_CALL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getReferredProperty()
    {
        if (referredProperty != null && ((EObject) referredProperty).eIsProxy())
        {
            InternalEObject oldReferredProperty = (InternalEObject) referredProperty;
            referredProperty = (EStructuralFeature) eResolveProxy(oldReferredProperty);
            if (referredProperty != oldReferredProperty)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
            }
        }
        return referredProperty;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetReferredProperty()
    {
        return referredProperty;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredProperty(EStructuralFeature newReferredProperty)
    {
        EStructuralFeature oldReferredProperty = referredProperty;
        referredProperty = newReferredProperty;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkPropertyType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return PropertyCallExpOperations.checkPropertyType(this, diagnostics, context);
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
            case OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                if (resolve)
                    return getReferredProperty();
                return basicGetReferredProperty();
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
            case OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                setReferredProperty((EStructuralFeature) newValue);
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
            case OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                setReferredProperty((EStructuralFeature) null);
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
            case OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                return referredProperty != null;
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
        if (baseClass == org.eclipse.ocl.expressions.PropertyCallExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                    return ExpressionsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY;
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
        if (baseClass == org.eclipse.ocl.expressions.PropertyCallExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
                    return OcldiagramsPackage.PROPERTY_CALL_EXP__REFERRED_PROPERTY;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // PropertyCallExpImpl
