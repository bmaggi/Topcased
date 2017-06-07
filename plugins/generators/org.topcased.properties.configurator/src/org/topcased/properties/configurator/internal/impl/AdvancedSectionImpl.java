/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdvancedSectionImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.topcased.properties.configurator.AdvancedSection;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Advanced Section</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.AdvancedSectionImpl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AdvancedSectionImpl extends AbstractSectionImpl implements AdvancedSection
{
    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected EList input = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AdvancedSectionImpl()
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
        return PropertiesConfiguratorPackage.Literals.ADVANCED_SECTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getInput()
    {
        if (input == null)
        {
            input = new EObjectResolvingEList(GenClass.class, this, PropertiesConfiguratorPackage.ADVANCED_SECTION__INPUT);
        }
        return input;
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
            case PropertiesConfiguratorPackage.ADVANCED_SECTION__INPUT:
                return getInput();
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
            case PropertiesConfiguratorPackage.ADVANCED_SECTION__INPUT:
                getInput().clear();
                getInput().addAll((Collection) newValue);
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
            case PropertiesConfiguratorPackage.ADVANCED_SECTION__INPUT:
                getInput().clear();
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
            case PropertiesConfiguratorPackage.ADVANCED_SECTION__INPUT:
                return input != null && !input.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // AdvancedSectionImpl
