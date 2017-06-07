/**
 * <copyright>
 * </copyright>
 *
 * $Id: MenuItemImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.MenuItem;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Menu Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.internal.impl.MenuItemImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class MenuItemImpl extends EObjectImpl implements MenuItem
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MenuItemImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass()
    {
        return OutlineConfiguratorPackage.Literals.MENU_ITEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MenuGroup getParent()
    {
        if (eContainerFeatureID != OutlineConfiguratorPackage.MENU_ITEM__PARENT)
            return null;
        return (MenuGroup) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_ITEM__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return eBasicSetContainer(otherEnd, OutlineConfiguratorPackage.MENU_ITEM__PARENT, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_ITEM__PARENT:
                return eBasicSetContainer(null, OutlineConfiguratorPackage.MENU_ITEM__PARENT, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
    {
        switch (eContainerFeatureID)
        {
            case OutlineConfiguratorPackage.MENU_ITEM__PARENT:
                return eInternalContainer().eInverseRemove(this, OutlineConfiguratorPackage.MENU_GROUP__ITEMS, MenuGroup.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_ITEM__PARENT:
                return getParent();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_ITEM__PARENT:
                return getParent() != null;
        }
        return super.eIsSet(featureID);
    }

} // MenuItemImpl
