/**
 * <copyright>
 * </copyright>
 *
 * $Id: CreateChildMenuConfigurationImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

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
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.MenuItem;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Create Child Menu Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.internal.impl.CreateChildMenuConfigurationImpl#getItems <em>Items</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.CreateChildMenuConfigurationImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CreateChildMenuConfigurationImpl extends EObjectImpl implements CreateChildMenuConfiguration
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

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
     * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getClassName()
     * @generated
     * @ordered
     */
    protected static final String CLASS_NAME_EDEFAULT = "CreateChildMenu"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getClassName()
     * @generated
     * @ordered
     */
    protected String className = CLASS_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CreateChildMenuConfigurationImpl()
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
        return OutlineConfiguratorPackage.Literals.CREATE_CHILD_MENU_CONFIGURATION;
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
            items = new EObjectContainmentEList(MenuItem.class, this, OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__ITEMS);
        }
        return items;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setClassName(String newClassName)
    {
        String oldClassName = className;
        className = newClassName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME, oldClassName, className));
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
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__ITEMS:
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
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__ITEMS:
                return getItems();
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME:
                return getClassName();
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
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__ITEMS:
                getItems().clear();
                getItems().addAll((Collection) newValue);
                return;
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME:
                setClassName((String) newValue);
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
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__ITEMS:
                getItems().clear();
                return;
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME:
                setClassName(CLASS_NAME_EDEFAULT);
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
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__ITEMS:
                return items != null && !items.isEmpty();
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME:
                return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
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
        result.append(" (className: "); //$NON-NLS-1$
        result.append(className);
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
    public String getMenuPackageName()
    {
        return ((OutlineConfiguration) eContainer()).getPackage() + ".menus";
    }

} // CreateChildMenuConfigurationImpl
