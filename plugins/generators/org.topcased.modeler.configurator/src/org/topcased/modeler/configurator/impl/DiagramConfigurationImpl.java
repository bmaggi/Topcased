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
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.LayoutType;
import org.topcased.modeler.configurator.PaletteConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getPalette <em>Palette</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl#getLayout <em>Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramConfigurationImpl extends EObjectImpl implements DiagramConfiguration
{
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

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
     * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected String package_ = PACKAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The cached value of the '{@link #getPalette() <em>Palette</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPalette()
     * @generated
     * @ordered
     */
    protected PaletteConfiguration palette = null;

    /**
     * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParts()
     * @generated
     * @ordered
     */
    protected EList parts = null;

    /**
     * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected static final LayoutType LAYOUT_EDEFAULT = LayoutType.XY_LAYOUT_LITERAL;

    /**
     * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected LayoutType layout = LAYOUT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DiagramConfigurationImpl()
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
        return ConfiguratorPackage.eINSTANCE.getDiagramConfiguration();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId)
    {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__ID, oldId, id));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPackage()
    {
        return package_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPackage(String newPackage)
    {
        String oldPackage = package_;
        package_ = newPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE, oldPackage, package_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPrefix()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrefix(String newPrefix)
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX, oldPrefix, prefix));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PaletteConfiguration getPalette()
    {
        return palette;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPalette(PaletteConfiguration newPalette, NotificationChain msgs)
    {
        PaletteConfiguration oldPalette = palette;
        palette = newPalette;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, oldPalette, newPalette);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPalette(PaletteConfiguration newPalette)
    {
        if (newPalette != palette)
        {
            NotificationChain msgs = null;
            if (palette != null)
                msgs = ((InternalEObject)palette).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, null, msgs);
            if (newPalette != null)
                msgs = ((InternalEObject)newPalette).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, null, msgs);
            msgs = basicSetPalette(newPalette, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE, newPalette, newPalette));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getParts()
    {
        if (parts == null)
        {
            parts = new EObjectContainmentEList(PartConfiguration.class, this, ConfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS);
        }
        return parts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LayoutType getLayout()
    {
        return layout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLayout(LayoutType newLayout)
    {
        LayoutType oldLayout = layout;
        layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT, oldLayout, layout));
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
                case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                    return basicSetPalette(null, msgs);
                case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                    return ((InternalEList)getParts()).basicRemove(otherEnd, msgs);
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
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__ID:
                return getId();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                return getName();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                return getPackage();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                return getPrefix();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                return getPalette();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                return getParts();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                return getLayout();
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
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__ID:
                setId((String)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                setName((String)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                setPackage((String)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                setPrefix((String)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                setPalette((PaletteConfiguration)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                getParts().clear();
                getParts().addAll((Collection)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                setLayout((LayoutType)newValue);
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
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__ID:
                setId(ID_EDEFAULT);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                setPackage(PACKAGE_EDEFAULT);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                setPrefix(PREFIX_EDEFAULT);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                setPalette((PaletteConfiguration)null);
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                getParts().clear();
                return;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                setLayout(LAYOUT_EDEFAULT);
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
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
                return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
                return palette != null;
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
                return parts != null && !parts.isEmpty();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
                return layout != LAYOUT_EDEFAULT;
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
        result.append(" (id: "); //$NON-NLS-1$
        result.append(id);
        result.append(", name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", package: "); //$NON-NLS-1$
        result.append(package_);
        result.append(", prefix: "); //$NON-NLS-1$
        result.append(prefix);
        result.append(", layout: "); //$NON-NLS-1$
        result.append(layout);
        result.append(')');
        return result.toString();
    }

} //DiagramConfigurationImpl
