/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractSectionImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.properties.configurator.AbstractSection;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.util.GeneratorUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Section</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.AbstractSectionImpl#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.AbstractSectionImpl#getTab <em>Tab</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.AbstractSectionImpl#getAfterSection <em>After Section</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.AbstractSectionImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractSectionImpl extends EObjectImpl implements AbstractSection
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
     * The cached value of the '{@link #getAfterSection() <em>After Section</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getAfterSection()
     * @generated
     * @ordered
     */
    protected AbstractSection afterSection = null;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractSectionImpl()
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
        return PropertiesConfiguratorPackage.Literals.ABSTRACT_SECTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getId()
    {
        // The ID of the Tab is the concatenation of the Tab Id and its Label.
        return GeneratorUtils.formatId(getTab().getId() + "." + getClassName() + "." + getLabel());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Tab getTab()
    {
        if (eContainerFeatureID != PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB)
            return null;
        return (Tab) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTab(Tab newTab, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject) newTab, PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTab(Tab newTab)
    {
        if (newTab != eInternalContainer() || (eContainerFeatureID != PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB && newTab != null))
        {
            if (EcoreUtil.isAncestor(this, newTab))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTab != null)
                msgs = ((InternalEObject) newTab).eInverseAdd(this, PropertiesConfiguratorPackage.TAB__SECTIONS, Tab.class, msgs);
            msgs = basicSetTab(newTab, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB, newTab, newTab));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractSection getAfterSection()
    {
        if (afterSection != null && afterSection.eIsProxy())
        {
            InternalEObject oldAfterSection = (InternalEObject) afterSection;
            afterSection = (AbstractSection) eResolveProxy(oldAfterSection);
            if (afterSection != oldAfterSection)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesConfiguratorPackage.ABSTRACT_SECTION__AFTER_SECTION, oldAfterSection, afterSection));
            }
        }
        return afterSection;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractSection basicGetAfterSection()
    {
        return afterSection;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAfterSection(AbstractSection newAfterSection)
    {
        AbstractSection oldAfterSection = afterSection;
        afterSection = newAfterSection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.ABSTRACT_SECTION__AFTER_SECTION, oldAfterSection, afterSection));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.ABSTRACT_SECTION__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getClassName()
    {
        return "FeatureSection";
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTab((Tab) otherEnd, msgs);
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                return basicSetTab(null, msgs);
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                return eInternalContainer().eInverseRemove(this, PropertiesConfiguratorPackage.TAB__SECTIONS, Tab.class, msgs);
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__ID:
                return getId();
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                return getTab();
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__AFTER_SECTION:
                if (resolve)
                    return getAfterSection();
                return basicGetAfterSection();
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__LABEL:
                return getLabel();
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                setTab((Tab) newValue);
                return;
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__AFTER_SECTION:
                setAfterSection((AbstractSection) newValue);
                return;
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__LABEL:
                setLabel((String) newValue);
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                setTab((Tab) null);
                return;
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__AFTER_SECTION:
                setAfterSection((AbstractSection) null);
                return;
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__LABEL:
                setLabel(LABEL_EDEFAULT);
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
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__ID:
                return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__TAB:
                return getTab() != null;
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__AFTER_SECTION:
                return afterSection != null;
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
        result.append(')');
        return result.toString();
    }

} // AbstractSectionImpl
