/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionItemImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
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
import org.topcased.modeler.ocl.ocldiagrams.CollectionItem;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Collection Item</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionItemImpl#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CollectionItemImpl extends CollectionLiteralPartImpl implements CollectionItem
{
    /**
     * The cached value of the '{@link #getItem() <em>Item</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getItem()
     * @generated
     * @ordered
     */
    protected OCLExpression<BusinessType> item;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CollectionItemImpl()
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
        return OcldiagramsPackage.Literals.COLLECTION_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OCLExpression<BusinessType> getItem()
    {
        return item;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetItem(OCLExpression<BusinessType> newItem, NotificationChain msgs)
    {
        OCLExpression<BusinessType> oldItem = item;
        item = newItem;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.COLLECTION_ITEM__ITEM, oldItem, newItem);
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
    public void setItem(OCLExpression<BusinessType> newItem)
    {
        if (newItem != item)
        {
            NotificationChain msgs = null;
            if (item != null)
                msgs = ((InternalEObject) item).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.COLLECTION_ITEM__ITEM, null, msgs);
            if (newItem != null)
                msgs = ((InternalEObject) newItem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.COLLECTION_ITEM__ITEM, null, msgs);
            msgs = basicSetItem(newItem, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.COLLECTION_ITEM__ITEM, newItem, newItem));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean checkItemType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExpressionsValidator.DIAGNOSTIC_SOURCE, ExpressionsValidator.COLLECTION_ITEM__ITEM_TYPE, EcorePlugin.INSTANCE.getString(
                        "_UI_GenericInvariant_diagnostic", new Object[] {"checkItemType", EObjectValidator.getObjectLabel(this, context)}), new Object[] {this}));
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
            case OcldiagramsPackage.COLLECTION_ITEM__ITEM:
                return basicSetItem(null, msgs);
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
            case OcldiagramsPackage.COLLECTION_ITEM__ITEM:
                return getItem();
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
            case OcldiagramsPackage.COLLECTION_ITEM__ITEM:
                setItem((OCLExpression<BusinessType>) newValue);
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
            case OcldiagramsPackage.COLLECTION_ITEM__ITEM:
                setItem((OCLExpression<BusinessType>) null);
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
            case OcldiagramsPackage.COLLECTION_ITEM__ITEM:
                return item != null;
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
        if (baseClass == org.eclipse.ocl.expressions.CollectionItem.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.COLLECTION_ITEM__ITEM:
                    return ExpressionsPackage.COLLECTION_ITEM__ITEM;
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
        if (baseClass == org.eclipse.ocl.expressions.CollectionItem.class)
        {
            switch (baseFeatureID)
            {
                case ExpressionsPackage.COLLECTION_ITEM__ITEM:
                    return OcldiagramsPackage.COLLECTION_ITEM__ITEM;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // CollectionItemImpl
