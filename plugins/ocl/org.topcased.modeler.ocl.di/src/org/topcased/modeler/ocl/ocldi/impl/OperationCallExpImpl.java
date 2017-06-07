/**
 * <copyright>
 * </copyright>
 *
 * $Id: OperationCallExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.OperationCallExpOperations;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.OperationCallExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Operation Call Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.OperationCallExpImpl#getArgument <em>Argument</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation</em>}
 * </li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.OperationCallExpImpl#getOperationCode <em>Operation Code</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OperationCallExpImpl extends FeatureCallExpImpl implements OperationCallExp
{

    private int operationCode = -1;

    /**
     * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArgument()
     * @generated
     * @ordered
     */
    protected EList<OCLExpression<BusinessType>> argument;

    /**
     * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReferredOperation()
     * @generated
     * @ordered
     */
    protected EOperation referredOperation;

    /**
     * The default value of the '{@link #getOperationCode() <em>Operation Code</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOperationCode()
     * @generated
     * @ordered
     */
    protected static final int OPERATION_CODE_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OperationCallExpImpl()
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
        return OcldiPackage.Literals.OPERATION_CALL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<OCLExpression<BusinessType>> getArgument()
    {
        if (argument == null)
        {
            argument = new EObjectContainmentEList<OCLExpression<BusinessType>>(OCLExpression.class, this, OcldiPackage.OPERATION_CALL_EXP__ARGUMENT);
        }
        return argument;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EOperation getReferredOperation()
    {
        if (referredOperation != null && ((EObject) referredOperation).eIsProxy())
        {
            InternalEObject oldReferredOperation = (InternalEObject) referredOperation;
            referredOperation = (EOperation) eResolveProxy(oldReferredOperation);
            if (referredOperation != oldReferredOperation)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
            }
        }
        return referredOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EOperation basicGetReferredOperation()
    {
        return referredOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredOperation(EOperation newReferredOperation)
    {
        EOperation oldReferredOperation = referredOperation;
        referredOperation = newReferredOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getOperationCode()
    {
        // TODO: implement this method to return the 'Operation Code' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOperationCode(int newOperationCode)
    {
        // TODO: implement this method to set the 'Operation Code' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkArgumentsConform(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return OperationCallExpOperations.checkArgumentsConform(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean checkArgumentCount(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExpressionsValidator.DIAGNOSTIC_SOURCE, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT, EcorePlugin.INSTANCE.getString(
                        "_UI_GenericInvariant_diagnostic", new Object[] {"checkArgumentCount", EObjectValidator.getObjectLabel(this, context)}), new Object[] {this}));
            }
            return false;
        }
        return true;
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
            case OcldiPackage.OPERATION_CALL_EXP__ARGUMENT:
                return ((InternalEList< ? >) getArgument()).basicRemove(otherEnd, msgs);
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
            case OcldiPackage.OPERATION_CALL_EXP__ARGUMENT:
                return getArgument();
            case OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                if (resolve)
                    return getReferredOperation();
                return basicGetReferredOperation();
            case OcldiPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                return new Integer(getOperationCode());
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
            case OcldiPackage.OPERATION_CALL_EXP__ARGUMENT:
                getArgument().clear();
                getArgument().addAll((Collection< ? extends OCLExpression<BusinessType>>) newValue);
                return;
            case OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                setReferredOperation((EOperation) newValue);
                return;
            case OcldiPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                setOperationCode(((Integer) newValue).intValue());
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
            case OcldiPackage.OPERATION_CALL_EXP__ARGUMENT:
                getArgument().clear();
                return;
            case OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                setReferredOperation((EOperation) null);
                return;
            case OcldiPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                setOperationCode(OPERATION_CODE_EDEFAULT);
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
            case OcldiPackage.OPERATION_CALL_EXP__ARGUMENT:
                return argument != null && !argument.isEmpty();
            case OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                return referredOperation != null;
            case OcldiPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                return getOperationCode() != OPERATION_CODE_EDEFAULT;
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
        if (baseClass == org.eclipse.ocl.expressions.OperationCallExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.OPERATION_CALL_EXP__ARGUMENT:
                    return ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT;
                case OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                    return ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
                case OcldiPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                    return ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE;
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
        if (baseClass == org.eclipse.ocl.expressions.OperationCallExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT:
                    return OcldiPackage.OPERATION_CALL_EXP__ARGUMENT;
                case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                    return OcldiPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
                case ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                    return OcldiPackage.OPERATION_CALL_EXP__OPERATION_CODE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // OperationCallExpImpl
