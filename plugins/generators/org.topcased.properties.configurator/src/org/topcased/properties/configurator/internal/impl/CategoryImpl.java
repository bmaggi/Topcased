/**
 * <copyright>
 * </copyright>
 *
 * $Id: CategoryImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.TabbedView;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Category</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.CategoryImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.CategoryImpl#getTabs <em>Tabs</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.CategoryImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CategoryImpl extends EObjectImpl implements Category
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
     * The cached value of the '{@link #getTabs() <em>Tabs</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getTabs()
     * @generated
     * @ordered
     */
    protected EList tabs = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CategoryImpl()
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
        return PropertiesConfiguratorPackage.Literals.CATEGORY;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.CATEGORY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getTabs()
    {
        if (tabs == null)
        {
            tabs = new EObjectContainmentWithInverseEList(Tab.class, this, PropertiesConfiguratorPackage.CATEGORY__TABS, PropertiesConfiguratorPackage.TAB__CATEGORY);
        }
        return tabs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TabbedView getParent()
    {
        if (eContainerFeatureID != PropertiesConfiguratorPackage.CATEGORY__PARENT)
            return null;
        return (TabbedView) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParent(TabbedView newParent, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject) newParent, PropertiesConfiguratorPackage.CATEGORY__PARENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParent(TabbedView newParent)
    {
        if (newParent != eInternalContainer() || (eContainerFeatureID != PropertiesConfiguratorPackage.CATEGORY__PARENT && newParent != null))
        {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject) newParent).eInverseAdd(this, PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES, TabbedView.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.CATEGORY__PARENT, newParent, newParent));
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
            case PropertiesConfiguratorPackage.CATEGORY__TABS:
                return ((InternalEList) getTabs()).basicAdd(otherEnd, msgs);
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((TabbedView) otherEnd, msgs);
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
            case PropertiesConfiguratorPackage.CATEGORY__TABS:
                return ((InternalEList) getTabs()).basicRemove(otherEnd, msgs);
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                return basicSetParent(null, msgs);
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
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                return eInternalContainer().eInverseRemove(this, PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES, TabbedView.class, msgs);
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
            case PropertiesConfiguratorPackage.CATEGORY__NAME:
                return getName();
            case PropertiesConfiguratorPackage.CATEGORY__TABS:
                return getTabs();
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                return getParent();
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
            case PropertiesConfiguratorPackage.CATEGORY__NAME:
                setName((String) newValue);
                return;
            case PropertiesConfiguratorPackage.CATEGORY__TABS:
                getTabs().clear();
                getTabs().addAll((Collection) newValue);
                return;
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                setParent((TabbedView) newValue);
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
            case PropertiesConfiguratorPackage.CATEGORY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PropertiesConfiguratorPackage.CATEGORY__TABS:
                getTabs().clear();
                return;
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                setParent((TabbedView) null);
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
            case PropertiesConfiguratorPackage.CATEGORY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PropertiesConfiguratorPackage.CATEGORY__TABS:
                return tabs != null && !tabs.isEmpty();
            case PropertiesConfiguratorPackage.CATEGORY__PARENT:
                return getParent() != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} // CategoryImpl
