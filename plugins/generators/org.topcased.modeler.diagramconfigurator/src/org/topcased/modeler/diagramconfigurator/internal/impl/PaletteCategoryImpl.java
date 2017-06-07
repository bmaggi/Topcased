/**
 * <copyright>
 * </copyright>
 *
 * $Id: PaletteCategoryImpl.java,v 1.4 2007/04/18 12:21:05 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteItem;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Palette Category</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteCategoryImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteCategoryImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PaletteCategoryImpl extends EObjectImpl implements PaletteCategory
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList<PaletteItem> items;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PaletteCategoryImpl()
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
        return DiagramconfiguratorPackage.Literals.PALETTE_CATEGORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PALETTE_CATEGORY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<PaletteItem> getItems()
    {
        if (items == null)
        {
            items = new EObjectContainmentEList<PaletteItem>(PaletteItem.class, this, DiagramconfiguratorPackage.PALETTE_CATEGORY__ITEMS);
        }
        return items;
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
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__ITEMS:
                return ((InternalEList< ? >) getItems()).basicRemove(otherEnd, msgs);
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
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__NAME:
                return getName();
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__ITEMS:
                return getItems();
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
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__NAME:
                setName((String) newValue);
                return;
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__ITEMS:
                getItems().clear();
                getItems().addAll((Collection< ? extends PaletteItem>) newValue);
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
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__ITEMS:
                getItems().clear();
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
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DiagramconfiguratorPackage.PALETTE_CATEGORY__ITEMS:
                return items != null && !items.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} // PaletteCategoryImpl
