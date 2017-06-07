/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumLiteralExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.impl.LiteralExpImpl;
import org.eclipse.ocl.expressions.operations.EnumLiteralExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.EnumLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Enum Literal Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.EnumLiteralExpImpl#getReferredEnumLiteral <em>Referred Enum
 * Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnumLiteralExpImpl extends LiteralExpImpl<BusinessType> implements EnumLiteralExp
{
    /**
     * The cached value of the '{@link #getReferredEnumLiteral() <em>Referred Enum Literal</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReferredEnumLiteral()
     * @generated
     * @ordered
     */
    protected EEnumLiteral referredEnumLiteral;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EnumLiteralExpImpl()
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
        return OcldiagramsPackage.Literals.ENUM_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnumLiteral getReferredEnumLiteral()
    {
        if (referredEnumLiteral != null && ((EObject) referredEnumLiteral).eIsProxy())
        {
            InternalEObject oldReferredEnumLiteral = (InternalEObject) referredEnumLiteral;
            referredEnumLiteral = (EEnumLiteral) eResolveProxy(oldReferredEnumLiteral);
            if (referredEnumLiteral != oldReferredEnumLiteral)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL, oldReferredEnumLiteral, referredEnumLiteral));
            }
        }
        return referredEnumLiteral;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnumLiteral basicGetReferredEnumLiteral()
    {
        return referredEnumLiteral;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredEnumLiteral(EEnumLiteral newReferredEnumLiteral)
    {
        EEnumLiteral oldReferredEnumLiteral = referredEnumLiteral;
        referredEnumLiteral = newReferredEnumLiteral;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL, oldReferredEnumLiteral, referredEnumLiteral));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkEnumType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return EnumLiteralExpOperations.checkEnumType(this, diagnostics, context);
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
            case OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                if (resolve)
                    return getReferredEnumLiteral();
                return basicGetReferredEnumLiteral();
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
            case OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                setReferredEnumLiteral((EEnumLiteral) newValue);
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
            case OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                setReferredEnumLiteral((EEnumLiteral) null);
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
            case OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                return referredEnumLiteral != null;
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
        if (baseClass == org.eclipse.ocl.expressions.EnumLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                    return ExpressionsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL;
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
        if (baseClass == org.eclipse.ocl.expressions.EnumLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                    return OcldiagramsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // EnumLiteralExpImpl
