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
import org.topcased.modeler.configurator.PartConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Part Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.PartConfigurationImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.PartConfigurationImpl#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.PartConfigurationImpl#isForegroundColorChangeable <em>Foreground Color Changeable</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.PartConfigurationImpl#isFontChangeable <em>Font Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PartConfigurationImpl extends EObjectImpl implements PartConfiguration
{
    /**
     * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObject()
     * @generated
     * @ordered
     */
    protected ObjectConfiguration object = null;

    /**
     * The default value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_FOREGROUND_COLOR_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected String defaultForegroundColor = DEFAULT_FOREGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #isForegroundColorChangeable() <em>Foreground Color Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForegroundColorChangeable()
     * @generated
     * @ordered
     */
    protected static final boolean FOREGROUND_COLOR_CHANGEABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isForegroundColorChangeable() <em>Foreground Color Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForegroundColorChangeable()
     * @generated
     * @ordered
     */
    protected boolean foregroundColorChangeable = FOREGROUND_COLOR_CHANGEABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isFontChangeable() <em>Font Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFontChangeable()
     * @generated
     * @ordered
     */
    protected static final boolean FONT_CHANGEABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isFontChangeable() <em>Font Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFontChangeable()
     * @generated
     * @ordered
     */
    protected boolean fontChangeable = FONT_CHANGEABLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PartConfigurationImpl()
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
        return ConfiguratorPackage.eINSTANCE.getPartConfiguration();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ObjectConfiguration getObject()
    {
        if (object != null && object.eIsProxy())
        {
            ObjectConfiguration oldObject = object;
            object = (ObjectConfiguration)eResolveProxy((InternalEObject)object);
            if (object != oldObject)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.PART_CONFIGURATION__OBJECT, oldObject, object));
            }
        }
        return object;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ObjectConfiguration basicGetObject()
    {
        return object;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setObject(ObjectConfiguration newObject)
    {
        ObjectConfiguration oldObject = object;
        object = newObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PART_CONFIGURATION__OBJECT, oldObject, object));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDefaultForegroundColor()
    {
        return defaultForegroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultForegroundColor(String newDefaultForegroundColor)
    {
        String oldDefaultForegroundColor = defaultForegroundColor;
        defaultForegroundColor = newDefaultForegroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR, oldDefaultForegroundColor, defaultForegroundColor));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForegroundColorChangeable()
    {
        return foregroundColorChangeable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForegroundColorChangeable(boolean newForegroundColorChangeable)
    {
        boolean oldForegroundColorChangeable = foregroundColorChangeable;
        foregroundColorChangeable = newForegroundColorChangeable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE, oldForegroundColorChangeable, foregroundColorChangeable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFontChangeable()
    {
        return fontChangeable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFontChangeable(boolean newFontChangeable)
    {
        boolean oldFontChangeable = fontChangeable;
        fontChangeable = newFontChangeable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE, oldFontChangeable, fontChangeable));
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
            case ConfiguratorPackage.PART_CONFIGURATION__OBJECT:
                if (resolve) return getObject();
                return basicGetObject();
            case ConfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case ConfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return isForegroundColorChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                return isFontChangeable() ? Boolean.TRUE : Boolean.FALSE;
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
            case ConfiguratorPackage.PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration)newValue);
                return;
            case ConfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((String)newValue);
                return;
            case ConfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(((Boolean)newValue).booleanValue());
                return;
            case ConfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(((Boolean)newValue).booleanValue());
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
            case ConfiguratorPackage.PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration)null);
                return;
            case ConfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case ConfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(FOREGROUND_COLOR_CHANGEABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(FONT_CHANGEABLE_EDEFAULT);
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
            case ConfiguratorPackage.PART_CONFIGURATION__OBJECT:
                return object != null;
            case ConfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case ConfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return foregroundColorChangeable != FOREGROUND_COLOR_CHANGEABLE_EDEFAULT;
            case ConfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                return fontChangeable != FONT_CHANGEABLE_EDEFAULT;
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
        result.append(" (defaultForegroundColor: "); //$NON-NLS-1$
        result.append(defaultForegroundColor);
        result.append(", foregroundColorChangeable: "); //$NON-NLS-1$
        result.append(foregroundColorChangeable);
        result.append(", fontChangeable: "); //$NON-NLS-1$
        result.append(fontChangeable);
        result.append(')');
        return result.toString();
    }

} //PartConfigurationImpl
