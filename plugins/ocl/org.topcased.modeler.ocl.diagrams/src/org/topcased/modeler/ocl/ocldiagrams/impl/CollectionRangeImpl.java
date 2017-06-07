/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionRangeImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.CollectionRange;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Collection Range</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionRangeImpl#getFirst <em>First</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionRangeImpl#getLast <em>Last</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CollectionRangeImpl extends CollectionLiteralPartImpl implements CollectionRange
{
    /**
     * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getFirst()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> first;

    /**
     * The cached value of the '{@link #getLast() <em>Last</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLast()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> last;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CollectionRangeImpl()
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
        return OcldiagramsPackage.Literals.COLLECTION_RANGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getFirst()
    {
        return first;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFirst(OCLExpression<BusinessType> newFirst, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldFirst = first;
        first = newFirst;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.COLLECTION_RANGE__FIRST, oldFirst, newFirst);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFirst(OCLExpression<BusinessType> newFirst)
    {
        if (newFirst != first)
        {
            NotificationChain msgs = null;
            if (first != null)
                msgs = ((InternalEObject) first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.COLLECTION_RANGE__FIRST, null, msgs);
            if (newFirst != null)
                msgs = ((InternalEObject) newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.COLLECTION_RANGE__FIRST, null, msgs);
            msgs = basicSetFirst(newFirst, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.COLLECTION_RANGE__FIRST, newFirst, newFirst));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getLast()
    {
        return last;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetLast(OCLExpression<BusinessType> newLast, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldLast = last;
        last = newLast;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.COLLECTION_RANGE__LAST, oldLast, newLast);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLast(OCLExpression<BusinessType> newLast)
    {
        if (newLast != last)
        {
            NotificationChain msgs = null;
            if (last != null)
                msgs = ((InternalEObject) last).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.COLLECTION_RANGE__LAST, null, msgs);
            if (newLast != null)
                msgs = ((InternalEObject) newLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.COLLECTION_RANGE__LAST, null, msgs);
            msgs = basicSetLast(newLast, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.COLLECTION_RANGE__LAST, newLast, newLast));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean checkRangeType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExpressionsValidator.DIAGNOSTIC_SOURCE, ExpressionsValidator.COLLECTION_RANGE__RANGE_TYPE, EcorePlugin.INSTANCE.getString(
                        "_UI_GenericInvariant_diagnostic", new Object[] {"checkRangeType", EObjectValidator.getObjectLabel(this, context)}), new Object[] {this}));
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
            case OcldiagramsPackage.COLLECTION_RANGE__FIRST:
                return basicSetFirst(null, msgs);
            case OcldiagramsPackage.COLLECTION_RANGE__LAST:
                return basicSetLast(null, msgs);
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
            case OcldiagramsPackage.COLLECTION_RANGE__FIRST:
                return getFirst();
            case OcldiagramsPackage.COLLECTION_RANGE__LAST:
                return getLast();
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
            case OcldiagramsPackage.COLLECTION_RANGE__FIRST:
                setFirst((OCLExpression<BusinessType>) newValue);
                return;
            case OcldiagramsPackage.COLLECTION_RANGE__LAST:
                setLast((OCLExpression<BusinessType>) newValue);
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
            case OcldiagramsPackage.COLLECTION_RANGE__FIRST:
                setFirst((OCLExpression<BusinessType>) null);
                return;
            case OcldiagramsPackage.COLLECTION_RANGE__LAST:
                setLast((OCLExpression<BusinessType>) null);
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
            case OcldiagramsPackage.COLLECTION_RANGE__FIRST:
                return first != null;
            case OcldiagramsPackage.COLLECTION_RANGE__LAST:
                return last != null;
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
        if (baseClass == org.eclipse.ocl.expressions.CollectionRange.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.COLLECTION_RANGE__FIRST:
                    return ExpressionsPackage.COLLECTION_RANGE__FIRST;
                case OcldiagramsPackage.COLLECTION_RANGE__LAST:
                    return ExpressionsPackage.COLLECTION_RANGE__LAST;
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
        if (baseClass == org.eclipse.ocl.expressions.CollectionRange.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.COLLECTION_RANGE__FIRST:
                    return OcldiagramsPackage.COLLECTION_RANGE__FIRST;
                case ExpressionsPackage.COLLECTION_RANGE__LAST:
                    return OcldiagramsPackage.COLLECTION_RANGE__LAST;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // CollectionRangeImpl
