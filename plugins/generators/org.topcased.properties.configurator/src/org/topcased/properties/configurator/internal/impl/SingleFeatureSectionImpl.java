/**
 * <copyright>
 * </copyright>
 *
 * $Id: SingleFeatureSectionImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.properties.configurator.util.GeneratorUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Single Feature Section</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.SingleFeatureSectionImpl#getFeature <em>Feature</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.SingleFeatureSectionImpl#isMultiline <em>Multiline</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SingleFeatureSectionImpl extends AbstractSectionImpl implements SingleFeatureSection
{
    /**
     * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getFeature()
     * @generated
     * @ordered
     */
    protected GenFeature feature = null;

    /**
     * The default value of the '{@link #isMultiline() <em>Multiline</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isMultiline()
     * @generated
     * @ordered
     */
    protected static final boolean MULTILINE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isMultiline() <em>Multiline</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isMultiline()
     * @generated
     * @ordered
     */
    protected boolean multiline = MULTILINE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SingleFeatureSectionImpl()
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
        return PropertiesConfiguratorPackage.Literals.SINGLE_FEATURE_SECTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenFeature getFeature()
    {
        if (feature != null && feature.eIsProxy())
        {
            InternalEObject oldFeature = (InternalEObject) feature;
            feature = (GenFeature) eResolveProxy(oldFeature);
            if (feature != oldFeature)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__FEATURE, oldFeature, feature));
            }
        }
        return feature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenFeature basicGetFeature()
    {
        return feature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFeature(GenFeature newFeature)
    {
        GenFeature oldFeature = feature;
        feature = newFeature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__FEATURE, oldFeature, feature));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isMultiline()
    {
        return multiline;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMultiline(boolean newMultiline)
    {
        boolean oldMultiline = multiline;
        multiline = newMultiline;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__MULTILINE, oldMultiline, multiline));
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
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__FEATURE:
                if (resolve)
                    return getFeature();
                return basicGetFeature();
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__MULTILINE:
                return isMultiline() ? Boolean.TRUE : Boolean.FALSE;
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
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__FEATURE:
                setFeature((GenFeature) newValue);
                return;
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__MULTILINE:
                setMultiline(((Boolean) newValue).booleanValue());
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
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__FEATURE:
                setFeature((GenFeature) null);
                return;
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__MULTILINE:
                setMultiline(MULTILINE_EDEFAULT);
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
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__FEATURE:
                return feature != null;
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION__MULTILINE:
                return multiline != MULTILINE_EDEFAULT;
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
        result.append(" (multiline: ");
        result.append(multiline);
        result.append(')');
        return result.toString();
    }

    // ---
    // ------
    // ---------
    // ------------
    // CODE CUSTOM
    // ------------
    // ---------
    // ------
    // ---

    /**
     * @see org.topcased.properties.configurator.impl.AbstractSectionImpl#getClassName()
     */
    public String getClassName()
    {
        String clazz = "Class";
        String feat = "Feature";
        if (getFeature() != null)
        {
            clazz = getFeature().getGenClass().getInterfaceName();
            feat = getFeature().getEcoreFeature().getName();
        }
        return GeneratorUtils.capName(clazz) + GeneratorUtils.capName(feat) + "Section";
    }

} // SingleFeatureSectionImpl
