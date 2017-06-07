/**
 * <copyright>
 * </copyright>
 *
 * $Id: RealLiteralExpImpl.java,v 1.2 2009/04/20 08:10:34 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.operations.RealLiteralExpOperations;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.RealLiteralExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Real Literal Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.RealLiteralExpImpl#getRealSymbol <em>Real Symbol</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RealLiteralExpImpl extends NumericLiteralExpImpl implements RealLiteralExp
{
    /**
     * The default value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getRealSymbol()
     * @generated
     * @ordered
     */
    protected static final Double REAL_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getRealSymbol()
     * @generated
     * @ordered
     */
    protected Double realSymbol = REAL_SYMBOL_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RealLiteralExpImpl()
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
        return OcldiPackage.Literals.REAL_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Double getRealSymbol()
    {
        return realSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRealSymbol(Double newRealSymbol)
    {
        Double oldRealSymbol = realSymbol;
        realSymbol = newRealSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL, oldRealSymbol, realSymbol));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkRealType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return RealLiteralExpOperations.checkRealType(this, diagnostics, context);
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
            case OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL:
                return getRealSymbol();
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
            case OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL:
                setRealSymbol((Double) newValue);
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
            case OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL:
                setRealSymbol(REAL_SYMBOL_EDEFAULT);
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
            case OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL:
                return REAL_SYMBOL_EDEFAULT == null ? realSymbol != null : !REAL_SYMBOL_EDEFAULT.equals(realSymbol);
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
        if (baseClass == org.eclipse.ocl.expressions.RealLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL:
                    return ExpressionsPackage.REAL_LITERAL_EXP__REAL_SYMBOL;
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
        if (baseClass == org.eclipse.ocl.expressions.RealLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.REAL_LITERAL_EXP__REAL_SYMBOL:
                    return OcldiPackage.REAL_LITERAL_EXP__REAL_SYMBOL;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (realSymbol: ");
        result.append(realSymbol);
        result.append(')');
        return result.toString();
    }

} // RealLiteralExpImpl
