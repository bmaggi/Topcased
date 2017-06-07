/**
 * <copyright>
 * </copyright>
 *
 * $Id: TabImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
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
import org.topcased.properties.configurator.AbstractSection;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.util.GeneratorUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tab</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabImpl#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabImpl#getLabel <em>Label</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabImpl#getSections <em>Sections</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabImpl#getCategory <em>Category</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabImpl#getAfterTab <em>After Tab</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabImpl#isIndented <em>Indented</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TabImpl extends EObjectImpl implements Tab
{
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = "";

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getSections() <em>Sections</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSections()
     * @generated
     * @ordered
     */
    protected EList sections = null;

    /**
     * The cached value of the '{@link #getAfterTab() <em>After Tab</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAfterTab()
     * @generated
     * @ordered
     */
    protected Tab afterTab = null;

    /**
     * The default value of the '{@link #isIndented() <em>Indented</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isIndented()
     * @generated
     * @ordered
     */
    protected static final boolean INDENTED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIndented() <em>Indented</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isIndented()
     * @generated
     * @ordered
     */
    protected boolean indented = INDENTED_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TabImpl()
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
        return PropertiesConfiguratorPackage.Literals.TAB;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getId()
    {
        // The ID of the Tab is the concatenation of the TabbedViewId and its Label.
        return GeneratorUtils.formatId(getCategory().getParent().getId() + "." + getLabel());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLabel(String newLabel)
    {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TAB__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getSections()
    {
        if (sections == null)
        {
            sections = new EObjectContainmentWithInverseEList(AbstractSection.class, this, PropertiesConfiguratorPackage.TAB__SECTIONS, PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB);
        }
        return sections;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Category getCategory()
    {
        if (eContainerFeatureID != PropertiesConfiguratorPackage.TAB__CATEGORY)
            return null;
        return (Category) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCategory(Category newCategory, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject) newCategory, PropertiesConfiguratorPackage.TAB__CATEGORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCategory(Category newCategory)
    {
        if (newCategory != eInternalContainer() || (eContainerFeatureID != PropertiesConfiguratorPackage.TAB__CATEGORY && newCategory != null))
        {
            if (EcoreUtil.isAncestor(this, newCategory))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCategory != null)
                msgs = ((InternalEObject) newCategory).eInverseAdd(this, PropertiesConfiguratorPackage.CATEGORY__TABS, Category.class, msgs);
            msgs = basicSetCategory(newCategory, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TAB__CATEGORY, newCategory, newCategory));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Tab getAfterTab()
    {
        if (afterTab != null && afterTab.eIsProxy())
        {
            InternalEObject oldAfterTab = (InternalEObject) afterTab;
            afterTab = (Tab) eResolveProxy(oldAfterTab);
            if (afterTab != oldAfterTab)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesConfiguratorPackage.TAB__AFTER_TAB, oldAfterTab, afterTab));
            }
        }
        return afterTab;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Tab basicGetAfterTab()
    {
        return afterTab;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAfterTab(Tab newAfterTab)
    {
        Tab oldAfterTab = afterTab;
        afterTab = newAfterTab;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TAB__AFTER_TAB, oldAfterTab, afterTab));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isIndented()
    {
        return indented;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIndented(boolean newIndented)
    {
        boolean oldIndented = indented;
        indented = newIndented;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TAB__INDENTED, oldIndented, indented));
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
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
                return ((InternalEList) getSections()).basicAdd(otherEnd, msgs);
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCategory((Category) otherEnd, msgs);
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
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
                return ((InternalEList) getSections()).basicRemove(otherEnd, msgs);
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                return basicSetCategory(null, msgs);
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
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                return eInternalContainer().eInverseRemove(this, PropertiesConfiguratorPackage.CATEGORY__TABS, Category.class, msgs);
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
            case PropertiesConfiguratorPackage.TAB__ID:
                return getId();
            case PropertiesConfiguratorPackage.TAB__LABEL:
                return getLabel();
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
                return getSections();
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                return getCategory();
            case PropertiesConfiguratorPackage.TAB__AFTER_TAB:
                if (resolve)
                    return getAfterTab();
                return basicGetAfterTab();
            case PropertiesConfiguratorPackage.TAB__INDENTED:
                return isIndented() ? Boolean.TRUE : Boolean.FALSE;
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
            case PropertiesConfiguratorPackage.TAB__LABEL:
                setLabel((String) newValue);
                return;
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
                getSections().clear();
                getSections().addAll((Collection) newValue);
                return;
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                setCategory((Category) newValue);
                return;
            case PropertiesConfiguratorPackage.TAB__AFTER_TAB:
                setAfterTab((Tab) newValue);
                return;
            case PropertiesConfiguratorPackage.TAB__INDENTED:
                setIndented(((Boolean) newValue).booleanValue());
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
            case PropertiesConfiguratorPackage.TAB__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
                getSections().clear();
                return;
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                setCategory((Category) null);
                return;
            case PropertiesConfiguratorPackage.TAB__AFTER_TAB:
                setAfterTab((Tab) null);
                return;
            case PropertiesConfiguratorPackage.TAB__INDENTED:
                setIndented(INDENTED_EDEFAULT);
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
            case PropertiesConfiguratorPackage.TAB__ID:
                return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
            case PropertiesConfiguratorPackage.TAB__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
                return sections != null && !sections.isEmpty();
            case PropertiesConfiguratorPackage.TAB__CATEGORY:
                return getCategory() != null;
            case PropertiesConfiguratorPackage.TAB__AFTER_TAB:
                return afterTab != null;
            case PropertiesConfiguratorPackage.TAB__INDENTED:
                return indented != INDENTED_EDEFAULT;
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
        result.append(" (label: ");
        result.append(label);
        result.append(", indented: ");
        result.append(indented);
        result.append(')');
        return result.toString();
    }

} // TabImpl
