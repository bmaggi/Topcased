/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.configurator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.PaletteCategory;
import org.topcased.modeler.configurator.PaletteConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Palette Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.PaletteConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.PaletteConfigurationImpl#getPaletteCategories <em>Palette Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaletteConfigurationImpl extends EObjectImpl implements PaletteConfiguration
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getPaletteCategories() <em>Palette Categories</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPaletteCategories()
     * @generated
     * @ordered
     */
    protected EList paletteCategories = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PaletteConfigurationImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass()
    {
        return ConfiguratorPackage.eINSTANCE.getPaletteConfiguration();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PALETTE_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getPaletteCategories()
    {
        if (paletteCategories == null)
        {
            paletteCategories = new EObjectContainmentEList(PaletteCategory.class, this, ConfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES);
        }
        return paletteCategories;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
    {
        if (featureID >= 0)
        {
            switch (eDerivedStructuralFeatureID(featureID, baseClass))
            {
                case ConfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                    return ((InternalEList)getPaletteCategories()).basicRemove(otherEnd, msgs);
                default:
                    return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
            }
        }
        return eBasicSetContainer(null, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                return getName();
            case ConfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                return getPaletteCategories();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                setName((String)newValue);
                return;
            case ConfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                getPaletteCategories().clear();
                getPaletteCategories().addAll((Collection)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ConfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                getPaletteCategories().clear();
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ConfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                return paletteCategories != null && !paletteCategories.isEmpty();
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //PaletteConfigurationImpl
