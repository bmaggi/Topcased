/**
 * <copyright>
 * </copyright>
 *
 * $Id: IntegerLiteralExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.topcased.modeler.ocl.ocldiagrams.IntegerLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Integer Literal Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.IntegerLiteralExpImpl#getIntegerSymbol <em>Integer Symbol</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IntegerLiteralExpImpl extends NumericLiteralExpImpl implements IntegerLiteralExp
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IntegerLiteralExpImpl()
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
        return OcldiagramsPackage.Literals.INTEGER_LITERAL_EXP;
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
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL, oldIntegerSymbol, integerSymbol));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean checkIntegerType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExpressionsValidator.DIAGNOSTIC_SOURCE, ExpressionsValidator.INTEGER_LITERAL_EXP__INTEGER_TYPE, EcorePlugin.INSTANCE.getString(
                        "_UI_GenericInvariant_diagnostic", new Object[] {"checkIntegerType", EObjectValidator.getObjectLabel(this, context)}), new Object[] {this}));
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
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
                return getIntegerSymbol();
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
            case OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
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
            case OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
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
            case OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
                return INTEGER_SYMBOL_EDEFAULT == null ? integerSymbol != null : !INTEGER_SYMBOL_EDEFAULT.equals(integerSymbol);
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
        if (baseClass == org.eclipse.ocl.expressions.IntegerLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
                    return ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL;
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
        if (baseClass == org.eclipse.ocl.expressions.IntegerLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL:
                    return OcldiagramsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL;
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

} // IntegerLiteralExpImpl
