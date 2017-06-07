/**
 * <copyright>
 * </copyright>
 *
 * $Id: UnlimitedNaturalLiteralExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.operations.UnlimitedNaturalLiteralExpOperations;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.UnlimitedNaturalLiteralExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unlimited Natural Literal Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.UnlimitedNaturalLiteralExpImpl#getIntegerSymbol <em>Integer Symbol
 * </em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.UnlimitedNaturalLiteralExpImpl#isUnlimited <em>Unlimited</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UnlimitedNaturalLiteralExpImpl extends NumericLiteralExpImpl implements UnlimitedNaturalLiteralExp
{
    /**
     * The default value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIntegerSymbol()
     * @generated
     * @ordered
     */
    protected static final Integer INTEGER_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIntegerSymbol()
     * @generated
     * @ordered
     */
    protected Integer integerSymbol = INTEGER_SYMBOL_EDEFAULT;

    /**
     * The default value of the '{@link #isUnlimited() <em>Unlimited</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isUnlimited()
     * @generated
     * @ordered
     */
    protected static final boolean UNLIMITED_EDEFAULT = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UnlimitedNaturalLiteralExpImpl()
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
        return OcldiPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Integer getIntegerSymbol()
    {
        return integerSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIntegerSymbol(Integer newIntegerSymbol)
    {
        Integer oldIntegerSymbol = integerSymbol;
        integerSymbol = newIntegerSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL, oldIntegerSymbol, integerSymbol));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isUnlimited()
    {
        // TODO: implement this method to return the 'Unlimited' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkNaturalType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return UnlimitedNaturalLiteralExpOperations.checkNaturalType(this, diagnostics, context);
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
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL:
                return getIntegerSymbol();
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED:
                return isUnlimited() ? Boolean.TRUE : Boolean.FALSE;
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
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL:
                setIntegerSymbol((Integer) newValue);
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
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL:
                setIntegerSymbol(INTEGER_SYMBOL_EDEFAULT);
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
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL:
                return INTEGER_SYMBOL_EDEFAULT == null ? integerSymbol != null : !INTEGER_SYMBOL_EDEFAULT.equals(integerSymbol);
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED:
                return isUnlimited() != UNLIMITED_EDEFAULT;
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
        if (baseClass == org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL:
                    return ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL;
                case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED:
                    return ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED;
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
        if (baseClass == org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL:
                    return OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL;
                case ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED:
                    return OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED;
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
        result.append(" (integerSymbol: ");
        result.append(integerSymbol);
        result.append(')');
        return result.toString();
    }

} // UnlimitedNaturalLiteralExpImpl
