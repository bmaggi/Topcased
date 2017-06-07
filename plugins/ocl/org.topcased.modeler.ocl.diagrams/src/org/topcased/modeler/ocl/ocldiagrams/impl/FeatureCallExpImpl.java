/**
 * <copyright>
 * </copyright>
 *
 * $Id: FeatureCallExpImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.topcased.modeler.ocl.ocldiagrams.FeatureCallExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature Call Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.FeatureCallExpImpl#isMarkedPre <em>Marked Pre</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class FeatureCallExpImpl extends CallExpImpl implements FeatureCallExp
{
    /**
     * The default value of the '{@link #isMarkedPre() <em>Marked Pre</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isMarkedPre()
     * @generated
     * @ordered
     */
    protected static final boolean MARKED_PRE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isMarkedPre() <em>Marked Pre</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isMarkedPre()
     * @generated
     * @ordered
     */
    protected boolean markedPre = MARKED_PRE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FeatureCallExpImpl()
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
        return OcldiagramsPackage.Literals.FEATURE_CALL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isMarkedPre()
    {
        return markedPre;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMarkedPre(boolean newMarkedPre)
    {
        boolean oldMarkedPre = markedPre;
        markedPre = newMarkedPre;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE, oldMarkedPre, markedPre));
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
            case OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                return isMarkedPre() ? Boolean.TRUE : Boolean.FALSE;
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
            case OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                setMarkedPre(((Boolean) newValue).booleanValue());
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
            case OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                setMarkedPre(MARKED_PRE_EDEFAULT);
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
            case OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                return markedPre != MARKED_PRE_EDEFAULT;
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
        if (baseClass == org.eclipse.ocl.expressions.FeatureCallExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                    return ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE;
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
        if (baseClass == org.eclipse.ocl.expressions.FeatureCallExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                    return OcldiagramsPackage.FEATURE_CALL_EXP__MARKED_PRE;
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
        result.append(" (markedPre: ");
        result.append(markedPre);
        result.append(')');
        return result.toString();
    }

} // FeatureCallExpImpl
