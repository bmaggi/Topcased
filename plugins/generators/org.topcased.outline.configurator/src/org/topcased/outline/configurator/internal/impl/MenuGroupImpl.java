/**
 * <copyright>
 * </copyright>
 *
 * $Id: MenuGroupImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.outline.configurator.ChildActionType;
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.MenuItem;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Menu Group</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.internal.impl.MenuGroupImpl#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.MenuGroupImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MenuGroupImpl extends MenuItemImpl implements MenuGroup
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

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
     * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList items = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MenuGroupImpl()
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
        return OutlineConfiguratorPackage.Literals.MENU_GROUP;
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
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.MENU_GROUP__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getItems()
    {
        if (items == null)
        {
            items = new EObjectContainmentWithInverseEList(MenuItem.class, this, OutlineConfiguratorPackage.MENU_GROUP__ITEMS, OutlineConfiguratorPackage.MENU_ITEM__PARENT);
        }
        return items;
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
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
                return ((InternalEList) getItems()).basicAdd(otherEnd, msgs);
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
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
                return ((InternalEList) getItems()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case OutlineConfiguratorPackage.MENU_GROUP__ID:
                return getId();
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
                return getItems();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_GROUP__ID:
                setId((String) newValue);
                return;
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
                getItems().clear();
                getItems().addAll((Collection) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_GROUP__ID:
                setId(ID_EDEFAULT);
                return;
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
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
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case OutlineConfiguratorPackage.MENU_GROUP__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
                return items != null && !items.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (id: "); //$NON-NLS-1$
        result.append(id);
        result.append(')');
        return result.toString();
    }


	//---
	//------
	//---------
	//------------
	// CODE CUSTOM
	//------------
	//---------
	//------
	//---

    public boolean hasHierarchicalCreateChildActions()
    {
        for (Iterator it = getItems().iterator(); it.hasNext();)
        {
            MenuItem item = (MenuItem) it.next();
            if (item instanceof CreateChildAction && ((CreateChildAction) item).getType() == ChildActionType.HIERACHICAL_LITERAL)
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasExactCreateChildActions()
    {
        for (Iterator it = getItems().iterator(); it.hasNext();)
        {
            MenuItem item = (MenuItem) it.next();
            if (item instanceof CreateChildAction && ((CreateChildAction) item).getType() == ChildActionType.EXACT_LITERAL)
            {
                return true;
            }
        }

        return false;
    }

} // MenuGroupImpl
