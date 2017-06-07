/**
 * <copyright>
 * </copyright>
 *
 * $Id: IfExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.IfExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.IfExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>If Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl#getCondition <em>Condition</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl#getThenExpression <em>Then Expression</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IfExpImpl extends OCLExpressionImpl implements IfExp
{
    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> condition;

    /**
     * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getThenExpression()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> thenExpression;

    /**
     * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElseExpression()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> elseExpression;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IfExpImpl()
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
        return OcldiagramsPackage.Literals.IF_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getCondition()
    {
        return condition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCondition(OCLExpression<BusinessType> newCondition, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.IF_EXP__CONDITION, oldCondition, newCondition);
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
    public void setCondition(OCLExpression<BusinessType> newCondition)
    {
        if (newCondition != condition)
        {
            NotificationChain msgs = null;
            if (condition != null)
                msgs = ((InternalEObject) condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.IF_EXP__CONDITION, null, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject) newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.IF_EXP__CONDITION, null, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.IF_EXP__CONDITION, newCondition, newCondition));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getThenExpression()
    {
        return thenExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetThenExpression(OCLExpression<BusinessType> newThenExpression, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldThenExpression = thenExpression;
        thenExpression = newThenExpression;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.IF_EXP__THEN_EXPRESSION, oldThenExpression, newThenExpression);
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
    public void setThenExpression(OCLExpression<BusinessType> newThenExpression)
    {
        if (newThenExpression != thenExpression)
        {
            NotificationChain msgs = null;
            if (thenExpression != null)
                msgs = ((InternalEObject) thenExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.IF_EXP__THEN_EXPRESSION, null, msgs);
            if (newThenExpression != null)
                msgs = ((InternalEObject) newThenExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.IF_EXP__THEN_EXPRESSION, null, msgs);
            msgs = basicSetThenExpression(newThenExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.IF_EXP__THEN_EXPRESSION, newThenExpression, newThenExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getElseExpression()
    {
        return elseExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetElseExpression(OCLExpression<BusinessType> newElseExpression, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldElseExpression = elseExpression;
        elseExpression = newElseExpression;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
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
    public void setElseExpression(OCLExpression<BusinessType> newElseExpression)
    {
        if (newElseExpression != elseExpression)
        {
            NotificationChain msgs = null;
            if (elseExpression != null)
                msgs = ((InternalEObject) elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION, null, msgs);
            if (newElseExpression != null)
                msgs = ((InternalEObject) newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION, null, msgs);
            msgs = basicSetElseExpression(newElseExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION, newElseExpression, newElseExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkBooleanCondition(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IfExpOperations.checkBooleanCondition(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkIfType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IfExpOperations.checkIfType(this, diagnostics, context);
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
            case OcldiagramsPackage.IF_EXP__CONDITION:
                return basicSetCondition(null, msgs);
            case OcldiagramsPackage.IF_EXP__THEN_EXPRESSION:
                return basicSetThenExpression(null, msgs);
            case OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION:
                return basicSetElseExpression(null, msgs);
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
            case OcldiagramsPackage.IF_EXP__CONDITION:
                return getCondition();
            case OcldiagramsPackage.IF_EXP__THEN_EXPRESSION:
                return getThenExpression();
            case OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION:
                return getElseExpression();
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
            case OcldiagramsPackage.IF_EXP__CONDITION:
                setCondition((OCLExpression<BusinessType>) newValue);
                return;
            case OcldiagramsPackage.IF_EXP__THEN_EXPRESSION:
                setThenExpression((OCLExpression<BusinessType>) newValue);
                return;
            case OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION:
                setElseExpression((OCLExpression<BusinessType>) newValue);
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
            case OcldiagramsPackage.IF_EXP__CONDITION:
                setCondition((OCLExpression<BusinessType>) null);
                return;
            case OcldiagramsPackage.IF_EXP__THEN_EXPRESSION:
                setThenExpression((OCLExpression<BusinessType>) null);
                return;
            case OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION:
                setElseExpression((OCLExpression<BusinessType>) null);
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
            case OcldiagramsPackage.IF_EXP__CONDITION:
                return condition != null;
            case OcldiagramsPackage.IF_EXP__THEN_EXPRESSION:
                return thenExpression != null;
            case OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION:
                return elseExpression != null;
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
        if (baseClass == org.eclipse.ocl.expressions.IfExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.IF_EXP__CONDITION:
                    return ExpressionsPackage.IF_EXP__CONDITION;
                case OcldiagramsPackage.IF_EXP__THEN_EXPRESSION:
                    return ExpressionsPackage.IF_EXP__THEN_EXPRESSION;
                case OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION:
                    return ExpressionsPackage.IF_EXP__ELSE_EXPRESSION;
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
        if (baseClass == org.eclipse.ocl.expressions.IfExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.IF_EXP__CONDITION:
                    return OcldiagramsPackage.IF_EXP__CONDITION;
                case ExpressionsPackage.IF_EXP__THEN_EXPRESSION:
                    return OcldiagramsPackage.IF_EXP__THEN_EXPRESSION;
                case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION:
                    return OcldiagramsPackage.IF_EXP__ELSE_EXPRESSION;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // IfExpImpl
