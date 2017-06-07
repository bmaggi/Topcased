/**
 * <copyright>
 * </copyright>
 *
 * $Id: IterateExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.operations.IterateExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.IterateExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Iterate Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.IterateExpImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IterateExpImpl extends LoopExpImpl implements IterateExp
{
    /**
     * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getResult()
     * @generated
     * @ordered
     */
    protected Variable<BusinessType, EParameter> result;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IterateExpImpl()
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
        return OcldiagramsPackage.Literals.ITERATE_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Variable<BusinessType, EParameter> getResult()
    {
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResult(Variable<BusinessType, EParameter> newResult, NotificationChain msgs)
    {
        Variable<BusinessType, EParameter> oldResult = result;
        result = newResult;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.ITERATE_EXP__RESULT, oldResult, newResult);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setResult(Variable<BusinessType, EParameter> newResult)
    {
        if (newResult != result)
        {
            NotificationChain msgs = null;
            if (result != null)
                msgs = ((InternalEObject) result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.ITERATE_EXP__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject) newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.ITERATE_EXP__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.ITERATE_EXP__RESULT, newResult, newResult));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkIterateType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IterateExpOperations.checkIterateType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkBodyType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IterateExpOperations.checkBodyType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkResultInit(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IterateExpOperations.checkResultInit(this, diagnostics, context);
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
            case OcldiagramsPackage.ITERATE_EXP__RESULT:
                return basicSetResult(null, msgs);
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
            case OcldiagramsPackage.ITERATE_EXP__RESULT:
                return getResult();
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
            case OcldiagramsPackage.ITERATE_EXP__RESULT:
                setResult((Variable<BusinessType, EParameter>) newValue);
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
            case OcldiagramsPackage.ITERATE_EXP__RESULT:
                setResult((Variable<BusinessType, EParameter>) null);
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
            case OcldiagramsPackage.ITERATE_EXP__RESULT:
                return result != null;
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
        if (baseClass == org.eclipse.ocl.expressions.IterateExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.ITERATE_EXP__RESULT:
                    return ExpressionsPackage.ITERATE_EXP__RESULT;
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
        if (baseClass == org.eclipse.ocl.expressions.IterateExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.ITERATE_EXP__RESULT:
                    return OcldiagramsPackage.ITERATE_EXP__RESULT;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // IterateExpImpl
