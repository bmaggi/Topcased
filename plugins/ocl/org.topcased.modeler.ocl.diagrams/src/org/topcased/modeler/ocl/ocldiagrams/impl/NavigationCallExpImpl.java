/**
 * <copyright>
 * </copyright>
 *
 * $Id: NavigationCallExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.NavigationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Navigation Call Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.NavigationCallExpImpl#getQualifier <em>Qualifier</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.NavigationCallExpImpl#getNavigationSource <em>Navigation Source
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class NavigationCallExpImpl extends FeatureCallExpImpl implements NavigationCallExp
{
    /**
     * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getQualifier()
     * @generated
     * @ordered
     */
    protected EList<OCLExpression<BusinessType>> qualifier;

    /**
     * The cached value of the '{@link #getNavigationSource() <em>Navigation Source</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNavigationSource()
     * @generated
     * @ordered
     */
    protected EStructuralFeature navigationSource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NavigationCallExpImpl()
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
        return OcldiagramsPackage.Literals.NAVIGATION_CALL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<OCLExpression<BusinessType>> getQualifier()
    {
        if (qualifier == null)
        {
            qualifier = new EObjectContainmentEList<OCLExpression<BusinessType>>(OCLExpression.class, this, OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER);
        }
        return qualifier;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getNavigationSource()
    {
        if (navigationSource != null && ((EObject) navigationSource).eIsProxy())
        {
            InternalEObject oldNavigationSource = (InternalEObject) navigationSource;
            navigationSource = (EStructuralFeature) eResolveProxy(oldNavigationSource);
            if (navigationSource != oldNavigationSource)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE, oldNavigationSource, navigationSource));
            }
        }
        return navigationSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetNavigationSource()
    {
        return navigationSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNavigationSource(EStructuralFeature newNavigationSource)
    {
        EStructuralFeature oldNavigationSource = navigationSource;
        navigationSource = newNavigationSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE, oldNavigationSource, navigationSource));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                return ((InternalEList< ? >) getQualifier()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                return getQualifier();
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                if (resolve)
                    return getNavigationSource();
                return basicGetNavigationSource();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                getQualifier().clear();
                getQualifier().addAll((Collection< ? extends OCLExpression<BusinessType>>) newValue);
                return;
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                setNavigationSource((EStructuralFeature) newValue);
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
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                getQualifier().clear();
                return;
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                setNavigationSource((EStructuralFeature) null);
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
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                return qualifier != null && !qualifier.isEmpty();
            case OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                return navigationSource != null;
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
        if (baseClass == org.eclipse.ocl.expressions.NavigationCallExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                    return ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER;
                case OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                    return ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;
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
        if (baseClass == org.eclipse.ocl.expressions.NavigationCallExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.NAVIGATION_CALL_EXP__QUALIFIER:
                    return OcldiagramsPackage.NAVIGATION_CALL_EXP__QUALIFIER;
                case ExpressionsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE:
                    return OcldiagramsPackage.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // NavigationCallExpImpl
