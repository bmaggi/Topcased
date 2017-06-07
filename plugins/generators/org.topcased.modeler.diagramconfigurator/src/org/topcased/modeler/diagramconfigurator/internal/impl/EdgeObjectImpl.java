/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectImpl.java,v 1.4 2007/04/18 12:21:09 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.EdgeObjectType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge Object</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl#getType <em>Type</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl#getEStructuralFeature <em>EStructural Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EdgeObjectImpl extends EObjectImpl implements EdgeObject
{
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final EdgeObjectType TYPE_EDEFAULT = EdgeObjectType.SOURCE_LITERAL;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected EdgeObjectType type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getEStructuralFeature() <em>EStructural Feature</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEStructuralFeature()
     * @generated
     * @ordered
     */
    protected EStructuralFeature eStructuralFeature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EdgeObjectImpl()
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
        return DiagramconfiguratorPackage.Literals.EDGE_OBJECT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getId()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setId(String newId)
    {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_OBJECT__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeObjectType getType()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setType(EdgeObjectType newType)
    {
        EdgeObjectType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_OBJECT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getEStructuralFeature()
    {
        if (eStructuralFeature != null && eStructuralFeature.eIsProxy())
        {
            InternalEObject oldEStructuralFeature = (InternalEObject) eStructuralFeature;
            eStructuralFeature = (EStructuralFeature) eResolveProxy(oldEStructuralFeature);
            if (eStructuralFeature != oldEStructuralFeature)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE, oldEStructuralFeature, eStructuralFeature));
            }
        }
        return eStructuralFeature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetEStructuralFeature()
    {
        return eStructuralFeature;
    }

    /**
     * <!-- begin-user-doc --> When the eStructuralFeature is changed, the EdgeObjectID is changed too <!-- end-user-doc
     * -->
     * 
     * @generated NOT
     */
    public void setEStructuralFeature(EStructuralFeature newEStructuralFeature)
    {
        EStructuralFeature oldEStructuralFeature = eStructuralFeature;
        eStructuralFeature = newEStructuralFeature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE, oldEStructuralFeature, eStructuralFeature));
        if (eStructuralFeature != null && eStructuralFeature.getName() != null)
            setId(eStructuralFeature.getName());
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
            case DiagramconfiguratorPackage.EDGE_OBJECT__ID:
                return getId();
            case DiagramconfiguratorPackage.EDGE_OBJECT__TYPE:
                return getType();
            case DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                if (resolve)
                    return getEStructuralFeature();
                return basicGetEStructuralFeature();
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
            case DiagramconfiguratorPackage.EDGE_OBJECT__ID:
                setId((String) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_OBJECT__TYPE:
                setType((EdgeObjectType) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                setEStructuralFeature((EStructuralFeature) newValue);
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
            case DiagramconfiguratorPackage.EDGE_OBJECT__ID:
                setId(ID_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.EDGE_OBJECT__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                setEStructuralFeature((EStructuralFeature) null);
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
            case DiagramconfiguratorPackage.EDGE_OBJECT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case DiagramconfiguratorPackage.EDGE_OBJECT__TYPE:
                return type != TYPE_EDEFAULT;
            case DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
                return eStructuralFeature != null;
        }
        return super.eIsSet(featureID);
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
        result.append(" (id: ");
        result.append(id);
        result.append(", type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

} // EdgeObjectImpl
