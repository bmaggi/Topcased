/**
 * <copyright>
 * </copyright>
 *
 * $Id: OperationCallExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.OperationCallExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.OperationCallExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Operation Call Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl#getArgument <em>Argument</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl#getReferredOperation <em>Referred Operation
 * </em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl#getOperationCode <em>Operation Code</em>}</li>
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
        return OcldiagramsPackage.Literals.OPERATION_CALL_EXP;
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
            argument = new EObjectContainmentEList<OCLExpression<BusinessType>>(OCLExpression.class, this, OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT);
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION, oldReferredOperation, referredOperation));
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
     * @generated NOT
     */
    public boolean checkArgumentCount(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return OperationCallExpOperations.checkArgumentCount(this, diagnostics, context);
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
            case OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT:
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
            case OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT:
                return getArgument();
            case OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                if (resolve)
                    return getReferredOperation();
                return basicGetReferredOperation();
            case OcldiagramsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
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
            case OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT:
                getArgument().clear();
                getArgument().addAll((Collection< ? extends OCLExpression<BusinessType>>) newValue);
                return;
            case OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                setReferredOperation((EOperation) newValue);
                return;
            case OcldiagramsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
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
            case OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT:
                getArgument().clear();
                return;
            case OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                setReferredOperation((EOperation) null);
                return;
            case OcldiagramsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
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
            case OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT:
                return argument != null && !argument.isEmpty();
            case OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                return referredOperation != null;
            case OcldiagramsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
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
                case OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT:
                    return ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENT;
                case OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                    return ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
                case OcldiagramsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
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
                    return OcldiagramsPackage.OPERATION_CALL_EXP__ARGUMENT;
                case ExpressionsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION:
                    return OcldiagramsPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;
                case ExpressionsPackage.OPERATION_CALL_EXP__OPERATION_CODE:
                    return OcldiagramsPackage.OPERATION_CALL_EXP__OPERATION_CODE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // OperationCallExpImpl
