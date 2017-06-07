/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.topcased.modeler.configurator.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.EdgeObject;
import org.topcased.modeler.configurator.EdgeObjectType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgeObjectImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgeObjectImpl#getEStructuralFeature <em>EStructural Feature</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgeObjectImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeObjectImpl extends EObjectImpl implements EdgeObject
{
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final EdgeObjectType TYPE_EDEFAULT = EdgeObjectType.SOURCE_LITERAL;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected EdgeObjectType type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getEStructuralFeature() <em>EStructural Feature</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEStructuralFeature()
     * @generated
     * @ordered
     */
    protected EStructuralFeature eStructuralFeature = null;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EdgeObjectImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass()
    {
        return ConfiguratorPackage.eINSTANCE.getEdgeObject();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgeObjectType getType()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(EdgeObjectType newType)
    {
        EdgeObjectType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_OBJECT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getEStructuralFeature()
    {
        if (eStructuralFeature != null && eStructuralFeature.eIsProxy())
        {
            EStructuralFeature oldEStructuralFeature = eStructuralFeature;
            eStructuralFeature = (EStructuralFeature)eResolveProxy((InternalEObject)eStructuralFeature);
            if (eStructuralFeature != oldEStructuralFeature)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE, oldEStructuralFeature, eStructuralFeature));
            }
        }
        return eStructuralFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetEStructuralFeature()
    {
        return eStructuralFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * When the eStructuralFeature is changed, the EdgeObjectID is changed too
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setEStructuralFeature(EStructuralFeature newEStructuralFeature)
    {
        EStructuralFeature oldEStructuralFeature = eStructuralFeature;
        eStructuralFeature = newEStructuralFeature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE, oldEStructuralFeature, eStructuralFeature));
        if (eStructuralFeature != null && eStructuralFeature.getName() != null)
            setId(eStructuralFeature.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId)
    {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_OBJECT__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.EDGE_OBJECT__TYPE:
                return getType();
            case ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                if (resolve) return getEStructuralFeature();
                return basicGetEStructuralFeature();
            case ConfiguratorPackage.EDGE_OBJECT__ID:
                return getId();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.EDGE_OBJECT__TYPE:
                setType((EdgeObjectType)newValue);
                return;
            case ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                setEStructuralFeature((EStructuralFeature) newValue);
                return;
            case ConfiguratorPackage.EDGE_OBJECT__ID:
                setId((String)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.EDGE_OBJECT__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                setEStructuralFeature((EStructuralFeature)null);
                setId(ID_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_OBJECT__ID:
                setId(ID_EDEFAULT);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.EDGE_OBJECT__TYPE:
                return type != TYPE_EDEFAULT;
            case ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                return eStructuralFeature != null;
            case ConfiguratorPackage.EDGE_OBJECT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (type: "); //$NON-NLS-1$
        result.append(type);
        result.append(", id: "); //$NON-NLS-1$
        result.append(id);
        result.append(')');
        return result.toString();
    }

} //EdgeObjectImpl
