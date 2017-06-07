/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultipleFeatureSectionImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.topcased.properties.configurator.MultipleFeatureSection;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Multiple Feature Section</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.MultipleFeatureSectionImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultipleFeatureSectionImpl extends AbstractSectionImpl implements MultipleFeatureSection
{
    /**
     * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getFeatures()
     * @generated
     * @ordered
     */
    protected EList features = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MultipleFeatureSectionImpl()
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
        return PropertiesConfiguratorPackage.Literals.MULTIPLE_FEATURE_SECTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getFeatures()
    {
        if (features == null)
        {
            features = new EObjectResolvingEList(GenFeature.class, this, PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION__FEATURES);
        }
        return features;
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
            case PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION__FEATURES:
                return getFeatures();
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
            case PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION__FEATURES:
                getFeatures().clear();
                getFeatures().addAll((Collection) newValue);
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
            case PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION__FEATURES:
                getFeatures().clear();
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
            case PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION__FEATURES:
                return features != null && !features.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // MultipleFeatureSectionImpl
