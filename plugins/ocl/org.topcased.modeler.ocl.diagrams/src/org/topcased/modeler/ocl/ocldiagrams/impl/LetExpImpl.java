/**
 * <copyright>
 * </copyright>
 *
 * $Id: LetExpImpl.java,v 1.2 2009/04/20 08:07:07 sgabel Exp $
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
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.operations.LetExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.LetExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Let Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.LetExpImpl#getIn <em>In</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.LetExpImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class LetExpImpl extends OCLExpressionImpl implements LetExp
{
    /**
     * The cached value of the '{@link #getIn() <em>In</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getIn()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> in;

    /**
     * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVariable()
     * @generated
     * @ordered
     */
    protected Variable<BusinessType, EParameter> variable;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LetExpImpl()
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
        return OcldiagramsPackage.Literals.LET_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getIn()
    {
        return in;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetIn(OCLExpression<BusinessType> newIn, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldIn = in;
        in = newIn;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.LET_EXP__IN, oldIn, newIn);
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
    public void setIn(OCLExpression<BusinessType> newIn)
    {
        if (newIn != in)
        {
            NotificationChain msgs = null;
            if (in != null)
                msgs = ((InternalEObject) in).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.LET_EXP__IN, null, msgs);
            if (newIn != null)
                msgs = ((InternalEObject) newIn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.LET_EXP__IN, null, msgs);
            msgs = basicSetIn(newIn, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.LET_EXP__IN, newIn, newIn));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Variable<BusinessType, EParameter> getVariable()
    {
        return variable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetVariable(Variable<BusinessType, EParameter> newVariable, NotificationChain msgs)
    {
        Variable<BusinessType, EParameter> oldVariable = variable;
        variable = newVariable;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.LET_EXP__VARIABLE, oldVariable, newVariable);
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
    public void setVariable(Variable<BusinessType, EParameter> newVariable)
    {
        if (newVariable != variable)
        {
            NotificationChain msgs = null;
            if (variable != null)
                msgs = ((InternalEObject) variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.LET_EXP__VARIABLE, null, msgs);
            if (newVariable != null)
                msgs = ((InternalEObject) newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.LET_EXP__VARIABLE, null, msgs);
            msgs = basicSetVariable(newVariable, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.LET_EXP__VARIABLE, newVariable, newVariable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkLetType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return LetExpOperations.checkLetType(this, diagnostics, context);
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
            case OcldiagramsPackage.LET_EXP__IN:
                return basicSetIn(null, msgs);
            case OcldiagramsPackage.LET_EXP__VARIABLE:
                return basicSetVariable(null, msgs);
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
            case OcldiagramsPackage.LET_EXP__IN:
                return getIn();
            case OcldiagramsPackage.LET_EXP__VARIABLE:
                return getVariable();
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
            case OcldiagramsPackage.LET_EXP__IN:
                setIn((OCLExpression<BusinessType>) newValue);
                return;
            case OcldiagramsPackage.LET_EXP__VARIABLE:
                setVariable((Variable<BusinessType, EParameter>) newValue);
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
            case OcldiagramsPackage.LET_EXP__IN:
                setIn((OCLExpression<BusinessType>) null);
                return;
            case OcldiagramsPackage.LET_EXP__VARIABLE:
                setVariable((Variable<BusinessType, EParameter>) null);
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
            case OcldiagramsPackage.LET_EXP__IN:
                return in != null;
            case OcldiagramsPackage.LET_EXP__VARIABLE:
                return variable != null;
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
        if (baseClass == org.eclipse.ocl.expressions.LetExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.LET_EXP__IN:
                    return ExpressionsPackage.LET_EXP__IN;
                case OcldiagramsPackage.LET_EXP__VARIABLE:
                    return ExpressionsPackage.LET_EXP__VARIABLE;
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
        if (baseClass == org.eclipse.ocl.expressions.LetExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.LET_EXP__IN:
                    return OcldiagramsPackage.LET_EXP__IN;
                case ExpressionsPackage.LET_EXP__VARIABLE:
                    return OcldiagramsPackage.LET_EXP__VARIABLE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // LetExpImpl
