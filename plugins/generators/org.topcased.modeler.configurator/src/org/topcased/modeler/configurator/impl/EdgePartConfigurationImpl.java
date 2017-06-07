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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.DecorationType;
import org.topcased.modeler.configurator.EdgeObject;
import org.topcased.modeler.configurator.EdgeContainerType;
import org.topcased.modeler.configurator.EdgePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;

import org.topcased.modeler.configurator.RouterType;
import org.topcased.modeler.configurator.SourceTargetCouple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Part Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl#getSourceTargetCouple <em>Source Target Couple</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl#getEdgeObjects <em>Edge Objects</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl#getSourceDecoration <em>Source Decoration</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl#getTargetDecoration <em>Target Decoration</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl#getDefaultRouter <em>Default Router</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl#getDirectEditable <em>Direct Editable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgePartConfigurationImpl extends PartConfigurationImpl implements EdgePartConfiguration
{
    /**
     * The cached value of the '{@link #getSourceTargetCouple() <em>Source Target Couple</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceTargetCouple()
     * @generated
     * @ordered
     */
    protected EList sourceTargetCouple = null;

    /**
     * The cached value of the '{@link #getEdgeObjects() <em>Edge Objects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEdgeObjects()
     * @generated
     * @ordered
     */
    protected EList edgeObjects = null;

    /**
     * The default value of the '{@link #getSourceDecoration() <em>Source Decoration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceDecoration()
     * @generated
     * @ordered
     */
    protected static final DecorationType SOURCE_DECORATION_EDEFAULT = DecorationType.NONE_LITERAL;

    /**
     * The cached value of the '{@link #getSourceDecoration() <em>Source Decoration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceDecoration()
     * @generated
     * @ordered
     */
    protected DecorationType sourceDecoration = SOURCE_DECORATION_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetDecoration() <em>Target Decoration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetDecoration()
     * @generated
     * @ordered
     */
    protected static final DecorationType TARGET_DECORATION_EDEFAULT = DecorationType.NONE_LITERAL;

    /**
     * The cached value of the '{@link #getTargetDecoration() <em>Target Decoration</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetDecoration()
     * @generated
     * @ordered
     */
    protected DecorationType targetDecoration = TARGET_DECORATION_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultRouter() <em>Default Router</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultRouter()
     * @generated
     * @ordered
     */
    protected static final RouterType DEFAULT_ROUTER_EDEFAULT = RouterType.OBLIQUE_ROUTER_LITERAL;

    /**
     * The cached value of the '{@link #getDefaultRouter() <em>Default Router</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultRouter()
     * @generated
     * @ordered
     */
    protected RouterType defaultRouter = DEFAULT_ROUTER_EDEFAULT;

    /**
     * The cached value of the '{@link #getDirectEditable() <em>Direct Editable</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDirectEditable()
     * @generated
     * @ordered
     */
    protected EdgeObject directEditable = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EdgePartConfigurationImpl()
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
        return ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getSourceTargetCouple()
    {
        if (sourceTargetCouple == null)
        {
            sourceTargetCouple = new EObjectContainmentEList(SourceTargetCouple.class, this, ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE);
        }
        return sourceTargetCouple;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getEdgeObjects()
    {
        if (edgeObjects == null)
        {
            edgeObjects = new EObjectContainmentEList(EdgeObject.class, this, ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS);
        }
        return edgeObjects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DecorationType getSourceDecoration()
    {
        return sourceDecoration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceDecoration(DecorationType newSourceDecoration)
    {
        DecorationType oldSourceDecoration = sourceDecoration;
        sourceDecoration = newSourceDecoration == null ? SOURCE_DECORATION_EDEFAULT : newSourceDecoration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION, oldSourceDecoration, sourceDecoration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DecorationType getTargetDecoration()
    {
        return targetDecoration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetDecoration(DecorationType newTargetDecoration)
    {
        DecorationType oldTargetDecoration = targetDecoration;
        targetDecoration = newTargetDecoration == null ? TARGET_DECORATION_EDEFAULT : newTargetDecoration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION, oldTargetDecoration, targetDecoration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RouterType getDefaultRouter()
    {
        return defaultRouter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultRouter(RouterType newDefaultRouter)
    {
        RouterType oldDefaultRouter = defaultRouter;
        defaultRouter = newDefaultRouter == null ? DEFAULT_ROUTER_EDEFAULT : newDefaultRouter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER, oldDefaultRouter, defaultRouter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgeObject getDirectEditable()
    {
        if (directEditable != null && directEditable.eIsProxy())
        {
            EdgeObject oldDirectEditable = directEditable;
            directEditable = (EdgeObject)eResolveProxy((InternalEObject)directEditable);
            if (directEditable != oldDirectEditable)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE, oldDirectEditable, directEditable));
            }
        }
        return directEditable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgeObject basicGetDirectEditable()
    {
        return directEditable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDirectEditable(EdgeObject newDirectEditable)
    {
        EdgeObject oldDirectEditable = directEditable;
        directEditable = newDirectEditable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE, oldDirectEditable, directEditable));
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
                case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                    return ((InternalEList)getSourceTargetCouple()).basicRemove(otherEnd, msgs);
                case ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                    return ((InternalEList)getEdgeObjects()).basicRemove(otherEnd, msgs);
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
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__OBJECT:
                if (resolve) return getObject();
                return basicGetObject();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return isForegroundColorChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FONT_CHANGEABLE:
                return isFontChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                return getSourceTargetCouple();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                return getEdgeObjects();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                return getSourceDecoration();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                return getTargetDecoration();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                return getDefaultRouter();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                if (resolve) return getDirectEditable();
                return basicGetDirectEditable();
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
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((String)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(((Boolean)newValue).booleanValue());
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(((Boolean)newValue).booleanValue());
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                getSourceTargetCouple().clear();
                getSourceTargetCouple().addAll((Collection)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                getEdgeObjects().clear();
                getEdgeObjects().addAll((Collection)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                setSourceDecoration((DecorationType)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                setTargetDecoration((DecorationType)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                setDefaultRouter((RouterType)newValue);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable((EdgeObject)newValue);
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
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration)null);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(FOREGROUND_COLOR_CHANGEABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(FONT_CHANGEABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                getSourceTargetCouple().clear();
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                getEdgeObjects().clear();
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                setSourceDecoration(SOURCE_DECORATION_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                setTargetDecoration(TARGET_DECORATION_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                setDefaultRouter(DEFAULT_ROUTER_EDEFAULT);
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable((EdgeObject)null);
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
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__OBJECT:
                return object != null;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return foregroundColorChangeable != FOREGROUND_COLOR_CHANGEABLE_EDEFAULT;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__FONT_CHANGEABLE:
                return fontChangeable != FONT_CHANGEABLE_EDEFAULT;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                return sourceTargetCouple != null && !sourceTargetCouple.isEmpty();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                return edgeObjects != null && !edgeObjects.isEmpty();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                return sourceDecoration != SOURCE_DECORATION_EDEFAULT;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                return targetDecoration != TARGET_DECORATION_EDEFAULT;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                return defaultRouter != DEFAULT_ROUTER_EDEFAULT;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                return directEditable != null;
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
        result.append(" (sourceDecoration: "); //$NON-NLS-1$
        result.append(sourceDecoration);
        result.append(", targetDecoration: "); //$NON-NLS-1$
        result.append(targetDecoration);
        result.append(", defaultRouter: "); //$NON-NLS-1$
        result.append(defaultRouter);
        result.append(')');
        return result.toString();
    }

} //EdgePartConfigurationImpl
