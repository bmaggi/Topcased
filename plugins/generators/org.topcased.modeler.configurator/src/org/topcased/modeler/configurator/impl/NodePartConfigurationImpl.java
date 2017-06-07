/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.configurator.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.EdgePartConfiguration;
import org.topcased.modeler.configurator.LayoutType;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.SourceTargetCouple;

import org.topcased.modeler.configurator.ResizableType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node Part Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getType <em>Type</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getChildElements <em>Child Elements</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getSuperType <em>Super Type</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#isBackgroundColorChangeable <em>Background Color Changeable</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getResizing <em>Resizing</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#isContainer <em>Container</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getLayout <em>Layout</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#isDirectEditable <em>Direct Editable</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getDefaultWidth <em>Default Width</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getDefaultHeight <em>Default Height</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getMinimumWidth <em>Minimum Width</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getMinimumHeight <em>Minimum Height</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getMaximumWidth <em>Maximum Width</em>}</li>
 * <li>{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl#getMaximumHeight <em>Maximum Height</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NodePartConfigurationImpl extends PartConfigurationImpl implements NodePartConfiguration
{
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = "Figure";

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getChildElements() <em>Child Elements</em>}'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getChildElements()
     * @generated
     * @ordered
     */
    protected EList childElements = null;

    /**
     * The cached value of the '{@link #getSuperType() <em>Super Type</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSuperType()
     * @generated
     * @ordered
     */
    protected NodePartConfiguration superType = null;

    /**
     * The default value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final String DEFAULT_BACKGROUND_COLOR_EDEFAULT = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected String defaultBackgroundColor = DEFAULT_BACKGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #isBackgroundColorChangeable() <em>Background Color Changeable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isBackgroundColorChangeable()
     * @generated
     * @ordered
     */
    protected static final boolean BACKGROUND_COLOR_CHANGEABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isBackgroundColorChangeable() <em>Background Color Changeable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isBackgroundColorChangeable()
     * @generated
     * @ordered
     */
    protected boolean backgroundColorChangeable = BACKGROUND_COLOR_CHANGEABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getResizing() <em>Resizing</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResizing()
     * @generated
     * @ordered
     */
    protected static final ResizableType RESIZING_EDEFAULT = ResizableType.ALL_LITERAL;

    /**
     * The cached value of the '{@link #getResizing() <em>Resizing</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResizing()
     * @generated
     * @ordered
     */
    protected ResizableType resizing = RESIZING_EDEFAULT;

    /**
     * The default value of the '{@link #isContainer() <em>Container</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isContainer()
     * @generated
     * @ordered
     */
    protected static final boolean CONTAINER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isContainer() <em>Container</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isContainer()
     * @generated
     * @ordered
     */
    protected boolean container = CONTAINER_EDEFAULT;

    /**
     * The default value of the '{@link #getLayout() <em>Layout</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected static final LayoutType LAYOUT_EDEFAULT = LayoutType.XY_LAYOUT_LITERAL;

    /**
     * The cached value of the '{@link #getLayout() <em>Layout</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected LayoutType layout = LAYOUT_EDEFAULT;

    /**
     * The default value of the '{@link #isDirectEditable() <em>Direct Editable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isDirectEditable()
     * @generated
     * @ordered
     */
    protected static final boolean DIRECT_EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isDirectEditable() <em>Direct Editable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isDirectEditable()
     * @generated
     * @ordered
     */
    protected boolean directEditable = DIRECT_EDITABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultWidth() <em>Default Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultWidth()
     * @generated
     * @ordered
     */
    protected static final int DEFAULT_WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDefaultWidth() <em>Default Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultWidth()
     * @generated
     * @ordered
     */
    protected int defaultWidth = DEFAULT_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultHeight() <em>Default Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultHeight()
     * @generated
     * @ordered
     */
    protected static final int DEFAULT_HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDefaultHeight() <em>Default Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultHeight()
     * @generated
     * @ordered
     */
    protected int defaultHeight = DEFAULT_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getMinimumWidth() <em>Minimum Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMinimumWidth()
     * @generated
     * @ordered
     */
    protected static final int MINIMUM_WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMinimumWidth() <em>Minimum Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMinimumWidth()
     * @generated
     * @ordered
     */
    protected int minimumWidth = MINIMUM_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMinimumHeight() <em>Minimum Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMinimumHeight()
     * @generated
     * @ordered
     */
    protected static final int MINIMUM_HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMinimumHeight() <em>Minimum Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMinimumHeight()
     * @generated
     * @ordered
     */
    protected int minimumHeight = MINIMUM_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximumWidth() <em>Maximum Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaximumWidth()
     * @generated
     * @ordered
     */
    protected static final int MAXIMUM_WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaximumWidth() <em>Maximum Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaximumWidth()
     * @generated
     * @ordered
     */
    protected int maximumWidth = MAXIMUM_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximumHeight() <em>Maximum Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaximumHeight()
     * @generated
     * @ordered
     */
    protected static final int MAXIMUM_HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaximumHeight() <em>Maximum Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaximumHeight()
     * @generated
     * @ordered
     */
    protected int maximumHeight = MAXIMUM_HEIGHT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NodePartConfigurationImpl()
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
        return ConfiguratorPackage.eINSTANCE.getNodePartConfiguration();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getType()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setType(String newType)
    {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.NODE_PART_CONFIGURATION__TYPE,
                    oldType, type));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getChildElements()
    {
        if (childElements == null)
        {
            childElements = new EObjectResolvingEList(NodePartConfiguration.class, this,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS);
        }
        return childElements;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NodePartConfiguration getSuperType()
    {
        if (superType != null && superType.eIsProxy())
        {
            NodePartConfiguration oldSuperType = superType;
            superType = (NodePartConfiguration) eResolveProxy((InternalEObject) superType);
            if (superType != oldSuperType)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE, oldSuperType, superType));
            }
        }
        return superType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NodePartConfiguration basicGetSuperType()
    {
        return superType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSuperType(NodePartConfiguration newSuperType)
    {
        NodePartConfiguration oldSuperType = superType;
        superType = newSuperType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE, oldSuperType, superType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getDefaultWidth()
    {
        return defaultWidth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultWidth(int newDefaultWidth)
    {
        int oldDefaultWidth = defaultWidth;
        defaultWidth = newDefaultWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH, oldDefaultWidth, defaultWidth));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getDefaultHeight()
    {
        return defaultHeight;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultHeight(int newDefaultHeight)
    {
        int oldDefaultHeight = defaultHeight;
        defaultHeight = newDefaultHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT, oldDefaultHeight, defaultHeight));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getMinimumWidth()
    {
        return minimumWidth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMinimumWidth(int newMinimumWidth)
    {
        int oldMinimumWidth = minimumWidth;
        minimumWidth = newMinimumWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH, oldMinimumWidth, minimumWidth));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getMinimumHeight()
    {
        return minimumHeight;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMinimumHeight(int newMinimumHeight)
    {
        int oldMinimumHeight = minimumHeight;
        minimumHeight = newMinimumHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT, oldMinimumHeight, minimumHeight));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getMaximumWidth()
    {
        return maximumWidth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMaximumWidth(int newMaximumWidth)
    {
        int oldMaximumWidth = maximumWidth;
        maximumWidth = newMaximumWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH, oldMaximumWidth, maximumWidth));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getMaximumHeight()
    {
        return maximumHeight;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMaximumHeight(int newMaximumHeight)
    {
        int oldMaximumHeight = maximumHeight;
        maximumHeight = newMaximumHeight;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT, oldMaximumHeight, maximumHeight));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDefaultBackgroundColor()
    {
        return defaultBackgroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultBackgroundColor(String newDefaultBackgroundColor)
    {
        String oldDefaultBackgroundColor = defaultBackgroundColor;
        defaultBackgroundColor = newDefaultBackgroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR, oldDefaultBackgroundColor,
                    defaultBackgroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isBackgroundColorChangeable()
    {
        return backgroundColorChangeable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBackgroundColorChangeable(boolean newBackgroundColorChangeable)
    {
        boolean oldBackgroundColorChangeable = backgroundColorChangeable;
        backgroundColorChangeable = newBackgroundColorChangeable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE,
                    oldBackgroundColorChangeable, backgroundColorChangeable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResizableType getResizing()
    {
        return resizing;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setResizing(ResizableType newResizing)
    {
        ResizableType oldResizing = resizing;
        resizing = newResizing == null ? RESIZING_EDEFAULT : newResizing;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING, oldResizing, resizing));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isContainer()
    {
        return container;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setContainer(boolean newContainer)
    {
        boolean oldContainer = container;
        container = newContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER, oldContainer, container));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isDirectEditable()
    {
        return directEditable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDirectEditable(boolean newDirectEditable)
    {
        boolean oldDirectEditable = directEditable;
        directEditable = newDirectEditable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ConfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE, oldDirectEditable, directEditable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public LayoutType getLayout()
    {
        return layout;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLayout(LayoutType newLayout)
    {
        LayoutType oldLayout = layout;
        layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT,
                    oldLayout, layout));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__OBJECT:
                if (resolve)
                    return getObject();
                return basicGetObject();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return isForegroundColorChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FONT_CHANGEABLE:
                return isFontChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                return getType();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                return getChildElements();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                if (resolve)
                    return getSuperType();
                return basicGetSuperType();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                return getDefaultBackgroundColor();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                return isBackgroundColorChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                return getResizing();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                return isContainer() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                return getLayout();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                return isDirectEditable() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                return new Integer(getDefaultWidth());
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                return new Integer(getDefaultHeight());
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                return new Integer(getMinimumWidth());
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                return new Integer(getMinimumHeight());
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                return new Integer(getMaximumWidth());
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                return new Integer(getMaximumHeight());
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((String) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(((Boolean) newValue).booleanValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(((Boolean) newValue).booleanValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                setType((String) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                getChildElements().clear();
                getChildElements().addAll((Collection) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                setSuperType((NodePartConfiguration) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor((String) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                setBackgroundColorChangeable(((Boolean) newValue).booleanValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                setResizing((ResizableType) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                setContainer(((Boolean) newValue).booleanValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                setLayout((LayoutType) newValue);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable(((Boolean) newValue).booleanValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                setDefaultWidth(((Integer) newValue).intValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                setDefaultHeight(((Integer) newValue).intValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                setMinimumWidth(((Integer) newValue).intValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                setMinimumHeight(((Integer) newValue).intValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                setMaximumWidth(((Integer) newValue).intValue());
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                setMaximumHeight(((Integer) newValue).intValue());
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration) null);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(FOREGROUND_COLOR_CHANGEABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(FONT_CHANGEABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                getChildElements().clear();
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                setSuperType((NodePartConfiguration) null);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor(DEFAULT_BACKGROUND_COLOR_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                setBackgroundColorChangeable(BACKGROUND_COLOR_CHANGEABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                setResizing(RESIZING_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                setContainer(CONTAINER_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                setLayout(LAYOUT_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable(DIRECT_EDITABLE_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                setDefaultWidth(DEFAULT_WIDTH_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                setDefaultHeight(DEFAULT_HEIGHT_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                setMinimumWidth(MINIMUM_WIDTH_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                setMinimumHeight(MINIMUM_HEIGHT_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                setMaximumWidth(MAXIMUM_WIDTH_EDEFAULT);
                return;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                setMaximumHeight(MAXIMUM_HEIGHT_EDEFAULT);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__OBJECT:
                return object != null;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null
                        : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return foregroundColorChangeable != FOREGROUND_COLOR_CHANGEABLE_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__FONT_CHANGEABLE:
                return fontChangeable != FONT_CHANGEABLE_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                return childElements != null && !childElements.isEmpty();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                return superType != null;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                return DEFAULT_BACKGROUND_COLOR_EDEFAULT == null ? defaultBackgroundColor != null
                        : !DEFAULT_BACKGROUND_COLOR_EDEFAULT.equals(defaultBackgroundColor);
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                return backgroundColorChangeable != BACKGROUND_COLOR_CHANGEABLE_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                return resizing != RESIZING_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                return container != CONTAINER_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                return layout != LAYOUT_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                return directEditable != DIRECT_EDITABLE_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                return defaultWidth != DEFAULT_WIDTH_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                return defaultHeight != DEFAULT_HEIGHT_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                return minimumWidth != MINIMUM_WIDTH_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                return minimumHeight != MINIMUM_HEIGHT_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                return maximumWidth != MAXIMUM_WIDTH_EDEFAULT;
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                return maximumHeight != MAXIMUM_HEIGHT_EDEFAULT;
        }
        return eDynamicIsSet(eFeature);
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
        result.append(" (type: "); //$NON-NLS-1$
        result.append(type);
        result.append(", defaultBackgroundColor: "); //$NON-NLS-1$
        result.append(defaultBackgroundColor);
        result.append(", backgroundColorChangeable: "); //$NON-NLS-1$
        result.append(backgroundColorChangeable);
        result.append(", resizing: "); //$NON-NLS-1$
        result.append(resizing);
        result.append(", container: "); //$NON-NLS-1$
        result.append(container);
        result.append(", layout: "); //$NON-NLS-1$
        result.append(layout);
        result.append(", directEditable: "); //$NON-NLS-1$
        result.append(directEditable);
        result.append(", defaultWidth: "); //$NON-NLS-1$
        result.append(defaultWidth);
        result.append(", defaultHeight: "); //$NON-NLS-1$
        result.append(defaultHeight);
        result.append(", minimumWidth: "); //$NON-NLS-1$
        result.append(minimumWidth);
        result.append(", minimumHeight: "); //$NON-NLS-1$
        result.append(minimumHeight);
        result.append(", maximumWidth: "); //$NON-NLS-1$
        result.append(maximumWidth);
        result.append(", maximumHeight: "); //$NON-NLS-1$
        result.append(maximumHeight);
        result.append(')');
        return result.toString();
    }

    /**
     * Check if a nodePartConfiguration is connectable in a diagram
     * 
     * @return true if at least one edge may be connected to the
     *         nodePartConfiguration
     */
    public boolean isConnectable()
    {
        DiagramConfiguration diagramConfiguration = (DiagramConfiguration) this.eContainer();
        for (Iterator iterator = diagramConfiguration.getParts().iterator(); iterator.hasNext();)
        {
            PartConfiguration part = (PartConfiguration) iterator.next();
            if (part instanceof EdgePartConfiguration)
            {
                for (Iterator coupleIterator = ((EdgePartConfiguration) part).getSourceTargetCouple().iterator(); coupleIterator.hasNext();)
                {
                    SourceTargetCouple couple = (SourceTargetCouple) coupleIterator.next();

                    if (this.equals(couple.getSourceNode()) || this.equals(couple.getTargetNode()))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Get the FeatureID of the first feature of the GenClass asosciated with
     * the current NodePartConfiguration (if it exists). The type of the feature
     * should match with the type of the passed GenClass.
     * 
     * @param childGenClass a type of GenClass to match
     * @return the FeatureID as a String if one is found. Return null otherwise.
     */
    public String getFeatureID(GenClass childGenClass)
    {
        if (childGenClass != null && getObject() instanceof ModelObjectConfiguration)
        {
            GenClass genClass = ((ModelObjectConfiguration) getObject()).getGenClass();
            if (genClass != null)
            {
                Iterator it = genClass.getAllGenFeatures().iterator();
                while (it.hasNext())
                {
                    GenFeature genFeature = (GenFeature) it.next();
                    if (genFeature.getTypeGenClass() != null && genFeature.getTypeGenClass().equals(childGenClass))
                    {
                        return genClass.getFeatureID(genFeature);
                    }
                }
            }
        }
        return "NO_FEATURE_FOUND";
    }

} // NodePartConfigurationImpl
