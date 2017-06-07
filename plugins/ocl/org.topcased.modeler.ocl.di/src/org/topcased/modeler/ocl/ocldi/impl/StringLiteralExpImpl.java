/**
 * <copyright>
 * </copyright>
 *
 * $Id: StringLiteralExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.operations.StringLiteralExpOperations;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.StringLiteralExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>String Literal Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.StringLiteralExpImpl#getStringSymbol <em>String Symbol</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StringLiteralExpImpl extends PrimitiveLiteralExpImpl implements StringLiteralExp
{
    /**
     * The default value of the '{@link #getStringSymbol() <em>String Symbol</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getStringSymbol()
     * @generated
     * @ordered
     */
    protected static final String STRING_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStringSymbol() <em>String Symbol</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getStringSymbol()
     * @generated
     * @ordered
     */
    protected String stringSymbol = STRING_SYMBOL_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StringLiteralExpImpl()
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
        return OcldiPackage.Literals.STRING_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getStringSymbol()
    {
        return stringSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setStringSymbol(String newStringSymbol)
    {
        String oldStringSymbol = stringSymbol;
        stringSymbol = newStringSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL, oldStringSymbol, stringSymbol));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkStringType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return StringLiteralExpOperations.checkStringType(this, diagnostics, context);
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
            case OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL:
                return getStringSymbol();
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
            case OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL:
                setStringSymbol((String) newValue);
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
            case OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL:
                setStringSymbol(STRING_SYMBOL_EDEFAULT);
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
            case OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL:
                return STRING_SYMBOL_EDEFAULT == null ? stringSymbol != null : !STRING_SYMBOL_EDEFAULT.equals(stringSymbol);
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
        if (baseClass == org.eclipse.ocl.expressions.StringLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL:
                    return ExpressionsPackage.STRING_LITERAL_EXP__STRING_SYMBOL;
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
        if (baseClass == org.eclipse.ocl.expressions.StringLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.STRING_LITERAL_EXP__STRING_SYMBOL:
                    return OcldiPackage.STRING_LITERAL_EXP__STRING_SYMBOL;
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
        result.append(" (stringSymbol: ");
        result.append(stringSymbol);
        result.append(')');
        return result.toString();
    }

} // StringLiteralExpImpl
