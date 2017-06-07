/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleLiteralExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.operations.TupleLiteralExpOperations;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.TupleLiteralExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tuple Literal Exp</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.TupleLiteralExpImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TupleLiteralExpImpl extends LiteralExpImpl implements TupleLiteralExp
{
    /**
     * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPart()
     * @generated
     * @ordered
     */
    protected EList<TupleLiteralPart<BusinessType, EStructuralFeature>> part;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TupleLiteralExpImpl()
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
        return OcldiPackage.Literals.TUPLE_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<TupleLiteralPart<BusinessType, EStructuralFeature>> getPart()
    {
        if (part == null)
        {
            part = new EObjectContainmentEList<TupleLiteralPart<BusinessType, EStructuralFeature>>(TupleLiteralPart.class, this, OcldiPackage.TUPLE_LITERAL_EXP__PART);
        }
        return part;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkTupleType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return TupleLiteralExpOperations.checkTupleType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkPartsUnique(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return TupleLiteralExpOperations.checkPartsUnique(this, diagnostics, context);
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
            case OcldiPackage.TUPLE_LITERAL_EXP__PART:
                return ((InternalEList< ? >) getPart()).basicRemove(otherEnd, msgs);
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
            case OcldiPackage.TUPLE_LITERAL_EXP__PART:
                return getPart();
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
            case OcldiPackage.TUPLE_LITERAL_EXP__PART:
                getPart().clear();
                getPart().addAll((Collection< ? extends TupleLiteralPart<BusinessType, EStructuralFeature>>) newValue);
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
            case OcldiPackage.TUPLE_LITERAL_EXP__PART:
                getPart().clear();
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
            case OcldiPackage.TUPLE_LITERAL_EXP__PART:
                return part != null && !part.isEmpty();
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
        if (baseClass == org.eclipse.ocl.expressions.TupleLiteralExp.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.TUPLE_LITERAL_EXP__PART:
                    return ExpressionsPackage.TUPLE_LITERAL_EXP__PART;
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
        if (baseClass == org.eclipse.ocl.expressions.TupleLiteralExp.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.TUPLE_LITERAL_EXP__PART:
                    return OcldiPackage.TUPLE_LITERAL_EXP__PART;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // TupleLiteralExpImpl
