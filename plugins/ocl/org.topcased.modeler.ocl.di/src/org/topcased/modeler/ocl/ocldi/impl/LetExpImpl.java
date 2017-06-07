/**
 * <copyright>
 * </copyright>
 *
 * $Id: LetExpImpl.java,v 1.2 2009/04/20 08:10:34 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.LetExp;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Let Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.LetExpImpl#getIn <em>In</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.LetExpImpl#getVariable <em>Variable</em>}</li>
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
        return OcldiPackage.Literals.LET_EXP;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiPackage.LET_EXP__IN, oldIn, newIn);
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
                msgs = ((InternalEObject) in).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiPackage.LET_EXP__IN, null, msgs);
            if (newIn != null)
                msgs = ((InternalEObject) newIn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiPackage.LET_EXP__IN, null, msgs);
            msgs = basicSetIn(newIn, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.LET_EXP__IN, newIn, newIn));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiPackage.LET_EXP__VARIABLE, oldVariable, newVariable);
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
                msgs = ((InternalEObject) variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiPackage.LET_EXP__VARIABLE, null, msgs);
            if (newVariable != null)
                msgs = ((InternalEObject) newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiPackage.LET_EXP__VARIABLE, null, msgs);
            msgs = basicSetVariable(newVariable, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.LET_EXP__VARIABLE, newVariable, newVariable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean checkLetType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExpressionsValidator.DIAGNOSTIC_SOURCE, ExpressionsValidator.LET_EXP__LET_TYPE, EcorePlugin.INSTANCE.getString(
                        "_UI_GenericInvariant_diagnostic", new Object[] {"checkLetType", EObjectValidator.getObjectLabel(this, context)}), new Object[] {this}));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case OcldiPackage.LET_EXP__IN:
                return basicSetIn(null, msgs);
            case OcldiPackage.LET_EXP__VARIABLE:
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
            case OcldiPackage.LET_EXP__IN:
                return getIn();
            case OcldiPackage.LET_EXP__VARIABLE:
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
            case OcldiPackage.LET_EXP__IN:
                setIn((OCLExpression<BusinessType>) newValue);
                return;
            case OcldiPackage.LET_EXP__VARIABLE:
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
            case OcldiPackage.LET_EXP__IN:
                setIn((OCLExpression<BusinessType>) null);
                return;
            case OcldiPackage.LET_EXP__VARIABLE:
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
            case OcldiPackage.LET_EXP__IN:
                return in != null;
            case OcldiPackage.LET_EXP__VARIABLE:
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
                case OcldiPackage.LET_EXP__IN:
                    return ExpressionsPackage.LET_EXP__IN;
                case OcldiPackage.LET_EXP__VARIABLE:
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
                    return OcldiPackage.LET_EXP__IN;
                case ExpressionsPackage.LET_EXP__VARIABLE:
                    return OcldiPackage.LET_EXP__VARIABLE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // LetExpImpl
