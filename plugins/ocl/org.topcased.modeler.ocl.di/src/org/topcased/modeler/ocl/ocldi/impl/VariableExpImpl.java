/**
 * <copyright>
 * </copyright>
 *
 * $Id: VariableExpImpl.java,v 1.2 2009/04/20 08:10:34 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.operations.VariableExpOperations;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.VariableExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variable Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.VariableExpImpl#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VariableExpImpl extends OCLExpressionImpl implements VariableExp
{
    /**
     * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReferredVariable()
     * @generated
     * @ordered
     */
    protected Variable<BusinessType, EParameter> referredVariable;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected VariableExpImpl()
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
        return OcldiPackage.Literals.VARIABLE_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    public Variable<BusinessType, EParameter> getReferredVariable()
    {
        if (referredVariable != null && referredVariable.eIsProxy())
        {
            InternalEObject oldReferredVariable = (InternalEObject) referredVariable;
            referredVariable = (Variable<BusinessType, EParameter>) eResolveProxy(oldReferredVariable);
            if (referredVariable != oldReferredVariable)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
            }
        }
        return referredVariable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Variable<BusinessType, EParameter> basicGetReferredVariable()
    {
        return referredVariable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredVariable(Variable<BusinessType, EParameter> newReferredVariable)
    {
        Variable<BusinessType, EParameter> oldReferredVariable = referredVariable;
        referredVariable = newReferredVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkVarType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return VariableExpOperations.checkVarType(this, diagnostics, context);
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
            case OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE:
                if (resolve)
                    return getReferredVariable();
                return basicGetReferredVariable();
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
            case OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE:
                setReferredVariable((Variable<BusinessType, EParameter>) newValue);
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
            case OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE:
                setReferredVariable((Variable<BusinessType, EParameter>) null);
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
            case OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE:
                return referredVariable != null;
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
        if (baseClass == org.eclipse.ocl.expressions.VariableExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE:
                    return ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE;
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
        if (baseClass == org.eclipse.ocl.expressions.VariableExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE:
                    return OcldiPackage.VARIABLE_EXP__REFERRED_VARIABLE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // VariableExpImpl
