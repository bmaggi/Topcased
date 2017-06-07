/**
 * <copyright>
 * </copyright>
 *
 * $Id: BooleanLiteralExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

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
import org.topcased.modeler.ocl.ocldi.BooleanLiteralExp;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Boolean Literal Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.BooleanLiteralExpImpl#getBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BooleanLiteralExpImpl extends PrimitiveLiteralExpImpl implements BooleanLiteralExp
{
    /**
     * The default value of the '{@link #getBooleanSymbol() <em>Boolean Symbol</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBooleanSymbol()
     * @generated
     * @ordered
     */
    protected static final Boolean BOOLEAN_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBooleanSymbol() <em>Boolean Symbol</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBooleanSymbol()
     * @generated
     * @ordered
     */
    protected Boolean booleanSymbol = BOOLEAN_SYMBOL_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BooleanLiteralExpImpl()
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
        return OcldiPackage.Literals.BOOLEAN_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Boolean getBooleanSymbol()
    {
        return booleanSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBooleanSymbol(Boolean newBooleanSymbol)
    {
        Boolean oldBooleanSymbol = booleanSymbol;
        booleanSymbol = newBooleanSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL, oldBooleanSymbol, booleanSymbol));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean checkBooleanType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExpressionsValidator.DIAGNOSTIC_SOURCE, ExpressionsValidator.BOOLEAN_LITERAL_EXP__BOOLEAN_TYPE, EcorePlugin.INSTANCE.getString(
                        "_UI_GenericInvariant_diagnostic", new Object[] {"checkBooleanType", EObjectValidator.getObjectLabel(this, context)}), new Object[] {this}));
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
            case OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
                return getBooleanSymbol();
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
            case OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
                setBooleanSymbol((Boolean) newValue);
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
            case OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
                setBooleanSymbol(BOOLEAN_SYMBOL_EDEFAULT);
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
            case OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
                return BOOLEAN_SYMBOL_EDEFAULT == null ? booleanSymbol != null : !BOOLEAN_SYMBOL_EDEFAULT.equals(booleanSymbol);
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
        if (baseClass == org.eclipse.ocl.expressions.BooleanLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
                    return ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL;
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
        if (baseClass == org.eclipse.ocl.expressions.BooleanLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
                    return OcldiPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL;
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
        result.append(" (booleanSymbol: ");
        result.append(booleanSymbol);
        result.append(')');
        return result.toString();
    }

} // BooleanLiteralExpImpl
