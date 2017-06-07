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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PaletteItem;
import org.topcased.modeler.configurator.PartConfiguration;

import org.topcased.modeler.configurator.ToolType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Palette Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.PaletteItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.PaletteItemImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaletteItemImpl extends EObjectImpl implements PaletteItem
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
     * The cached value of the '{@link #getPart() <em>Part</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPart()
     * @generated
     * @ordered
     */
    protected PartConfiguration part = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PaletteItemImpl()
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
        return ConfiguratorPackage.eINSTANCE.getPaletteItem();
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
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PALETTE_ITEM__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PartConfiguration getPart()
    {
        if (part != null && part.eIsProxy())
        {
            PartConfiguration oldPart = part;
            part = (PartConfiguration)eResolveProxy((InternalEObject)part);
            if (part != oldPart)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.PALETTE_ITEM__PART, oldPart, part));
            }
        }
        return part;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PartConfiguration basicGetPart()
    {
        return part;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPart(PartConfiguration newPart)
    {
        PartConfiguration oldPart = part;
        part = newPart;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PALETTE_ITEM__PART, oldPart, part));
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
            case ConfiguratorPackage.PALETTE_ITEM__NAME:
                return getName();
            case ConfiguratorPackage.PALETTE_ITEM__PART:
                if (resolve) return getPart();
                return basicGetPart();
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
            case ConfiguratorPackage.PALETTE_ITEM__NAME:
                setName((String)newValue);
                return;
            case ConfiguratorPackage.PALETTE_ITEM__PART:
                setPart((PartConfiguration)newValue);
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
            case ConfiguratorPackage.PALETTE_ITEM__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ConfiguratorPackage.PALETTE_ITEM__PART:
                setPart((PartConfiguration)null);
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
            case ConfiguratorPackage.PALETTE_ITEM__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ConfiguratorPackage.PALETTE_ITEM__PART:
                return part != null;
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

} //PaletteItemImpl
