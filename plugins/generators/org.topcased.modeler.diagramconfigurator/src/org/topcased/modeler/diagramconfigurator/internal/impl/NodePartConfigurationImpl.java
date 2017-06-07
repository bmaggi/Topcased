/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodePartConfigurationImpl.java,v 1.5 2007/04/18 12:21:19 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.swt.graphics.Color;
import org.topcased.draw2d.figures.ContainerFigure;
import org.topcased.draw2d.figures.IContainerFigure;
import org.topcased.draw2d.figures.ILabelFigure;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.LayoutType;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.ResizableType;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;
import org.topcased.modeler.diagramconfigurator.extension.FigureDeclarationsManager;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node Part Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getType <em>Type</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getChildElements <em>Child Elements</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getSuperType <em>Super Type</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#isBackgroundColorChangeable <em>Background Color Changeable</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getResizing <em>Resizing</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#isContainer <em>Container</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getLayout <em>Layout</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#isDirectEditable <em>Direct Editable</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getDefaultWidth <em>Default Width</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getDefaultHeight <em>Default Height</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getMinimumWidth <em>Minimum Width</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getMinimumHeight <em>Minimum Height</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getMaximumWidth <em>Maximum Width</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#getMaximumHeight <em>Maximum Height</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl#isAttachedToBorder <em>Attached To Border</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NodePartConfigurationImpl extends PartConfigurationImpl implements NodePartConfiguration
{
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = "Figure";

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getChildElements() <em>Child Elements</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getChildElements()
     * @generated
     * @ordered
     */
    protected EList<NodePartConfiguration> childElements;

    /**
     * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSuperType()
     * @generated
     * @ordered
     */
    protected NodePartConfiguration superType;

    /**
     * The default value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_BACKGROUND_COLOR_EDEFAULT = (Color) DiagramconfiguratorFactory.eINSTANCE.createFromString(DiagramconfiguratorPackage.eINSTANCE.getColor(), "255,255,255");

    /**
     * The cached value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected Color defaultBackgroundColor = DEFAULT_BACKGROUND_COLOR_EDEFAULT;

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
     * The default value of the '{@link #getResizing() <em>Resizing</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResizing()
     * @generated
     * @ordered
     */
    protected static final ResizableType RESIZING_EDEFAULT = ResizableType.ALL_LITERAL;

    /**
     * The cached value of the '{@link #getResizing() <em>Resizing</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResizing()
     * @generated
     * @ordered
     */
    protected ResizableType resizing = RESIZING_EDEFAULT;

    /**
     * The default value of the '{@link #isContainer() <em>Container</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isContainer()
     * @generated
     * @ordered
     */
    protected static final boolean CONTAINER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isContainer() <em>Container</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isContainer()
     * @generated
     * @ordered
     */
    protected boolean container = CONTAINER_EDEFAULT;

    /**
     * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected static final LayoutType LAYOUT_EDEFAULT = LayoutType.XY_LAYOUT_LITERAL;

    /**
     * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLayout()
     * @generated
     * @ordered
     */
    protected LayoutType layout = LAYOUT_EDEFAULT;

    /**
     * The default value of the '{@link #isDirectEditable() <em>Direct Editable</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isDirectEditable()
     * @generated
     * @ordered
     */
    protected static final boolean DIRECT_EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isDirectEditable() <em>Direct Editable</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isDirectEditable()
     * @generated
     * @ordered
     */
    protected boolean directEditable = DIRECT_EDITABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultWidth() <em>Default Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultWidth()
     * @generated
     * @ordered
     */
    protected static final int DEFAULT_WIDTH_EDEFAULT = 50;

    /**
     * The cached value of the '{@link #getDefaultWidth() <em>Default Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultWidth()
     * @generated
     * @ordered
     */
    protected int defaultWidth = DEFAULT_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultHeight() <em>Default Height</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDefaultHeight()
     * @generated
     * @ordered
     */
    protected static final int DEFAULT_HEIGHT_EDEFAULT = 50;

    /**
     * The cached value of the '{@link #getDefaultHeight() <em>Default Height</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDefaultHeight()
     * @generated
     * @ordered
     */
    protected int defaultHeight = DEFAULT_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getMinimumWidth() <em>Minimum Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMinimumWidth()
     * @generated
     * @ordered
     */
    protected static final int MINIMUM_WIDTH_EDEFAULT = 20;

    /**
     * The cached value of the '{@link #getMinimumWidth() <em>Minimum Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMinimumWidth()
     * @generated
     * @ordered
     */
    protected int minimumWidth = MINIMUM_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMinimumHeight() <em>Minimum Height</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMinimumHeight()
     * @generated
     * @ordered
     */
    protected static final int MINIMUM_HEIGHT_EDEFAULT = 20;

    /**
     * The cached value of the '{@link #getMinimumHeight() <em>Minimum Height</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMinimumHeight()
     * @generated
     * @ordered
     */
    protected int minimumHeight = MINIMUM_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximumWidth() <em>Maximum Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMaximumWidth()
     * @generated
     * @ordered
     */
    protected static final int MAXIMUM_WIDTH_EDEFAULT = 200;

    /**
     * The cached value of the '{@link #getMaximumWidth() <em>Maximum Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMaximumWidth()
     * @generated
     * @ordered
     */
    protected int maximumWidth = MAXIMUM_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximumHeight() <em>Maximum Height</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMaximumHeight()
     * @generated
     * @ordered
     */
    protected static final int MAXIMUM_HEIGHT_EDEFAULT = 200;

    /**
     * The cached value of the '{@link #getMaximumHeight() <em>Maximum Height</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMaximumHeight()
     * @generated
     * @ordered
     */
    protected int maximumHeight = MAXIMUM_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #isAttachedToBorder() <em>Attached To Border</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isAttachedToBorder()
     * @generated
     * @ordered
     */
    protected static final boolean ATTACHED_TO_BORDER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAttachedToBorder() <em>Attached To Border</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isAttachedToBorder()
     * @generated
     * @ordered
     */
    protected boolean attachedToBorder = ATTACHED_TO_BORDER_EDEFAULT;

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
    @Override
    protected EClass eStaticClass()
    {
        return DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<NodePartConfiguration> getChildElements()
    {
        if (childElements == null)
        {
            childElements = new EObjectResolvingEList<NodePartConfiguration>(NodePartConfiguration.class, this, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS);
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
            InternalEObject oldSuperType = (InternalEObject) superType;
            superType = (NodePartConfiguration) eResolveProxy(oldSuperType);
            if (superType != oldSuperType)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE, oldSuperType, superType));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE, oldSuperType, superType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Color getDefaultBackgroundColor()
    {
        return defaultBackgroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultBackgroundColor(Color newDefaultBackgroundColor)
    {
        Color oldDefaultBackgroundColor = defaultBackgroundColor;
        defaultBackgroundColor = newDefaultBackgroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR, oldDefaultBackgroundColor, defaultBackgroundColor));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE, oldBackgroundColorChangeable,
                    backgroundColorChangeable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING, oldResizing, resizing));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER, oldContainer, container));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT, oldLayout, layout));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE, oldDirectEditable, directEditable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH, oldDefaultWidth, defaultWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT, oldDefaultHeight, defaultHeight));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH, oldMinimumWidth, minimumWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT, oldMinimumHeight, minimumHeight));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH, oldMaximumWidth, maximumWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT, oldMaximumHeight, maximumHeight));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isAttachedToBorder()
    {
        return attachedToBorder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAttachedToBorder(boolean newAttachedToBorder)
    {
        boolean oldAttachedToBorder = attachedToBorder;
        attachedToBorder = newAttachedToBorder;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER, oldAttachedToBorder, attachedToBorder));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                return getType();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                return getChildElements();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                if (resolve)
                    return getSuperType();
                return basicGetSuperType();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                return getDefaultBackgroundColor();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                return isBackgroundColorChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                return getResizing();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                return isContainer() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                return getLayout();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                return isDirectEditable() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                return new Integer(getDefaultWidth());
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                return new Integer(getDefaultHeight());
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                return new Integer(getMinimumWidth());
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                return new Integer(getMinimumHeight());
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                return new Integer(getMaximumWidth());
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                return new Integer(getMaximumHeight());
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER:
                return isAttachedToBorder() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                setType((String) newValue);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                getChildElements().clear();
                getChildElements().addAll((Collection< ? extends NodePartConfiguration>) newValue);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                setSuperType((NodePartConfiguration) newValue);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor((Color) newValue);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                setBackgroundColorChangeable(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                setResizing((ResizableType) newValue);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                setContainer(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                setLayout((LayoutType) newValue);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                setDefaultWidth(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                setDefaultHeight(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                setMinimumWidth(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                setMinimumHeight(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                setMaximumWidth(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                setMaximumHeight(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER:
                setAttachedToBorder(((Boolean) newValue).booleanValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                getChildElements().clear();
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                setSuperType((NodePartConfiguration) null);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor(DEFAULT_BACKGROUND_COLOR_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                setBackgroundColorChangeable(BACKGROUND_COLOR_CHANGEABLE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                setResizing(RESIZING_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                setContainer(CONTAINER_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                setLayout(LAYOUT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable(DIRECT_EDITABLE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                setDefaultWidth(DEFAULT_WIDTH_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                setDefaultHeight(DEFAULT_HEIGHT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                setMinimumWidth(MINIMUM_WIDTH_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                setMinimumHeight(MINIMUM_HEIGHT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                setMaximumWidth(MAXIMUM_WIDTH_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                setMaximumHeight(MAXIMUM_HEIGHT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER:
                setAttachedToBorder(ATTACHED_TO_BORDER_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
                return childElements != null && !childElements.isEmpty();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
                return superType != null;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
                return DEFAULT_BACKGROUND_COLOR_EDEFAULT == null ? defaultBackgroundColor != null : !DEFAULT_BACKGROUND_COLOR_EDEFAULT.equals(defaultBackgroundColor);
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
                return backgroundColorChangeable != BACKGROUND_COLOR_CHANGEABLE_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
                return resizing != RESIZING_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
                return container != CONTAINER_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
                return layout != LAYOUT_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
                return directEditable != DIRECT_EDITABLE_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
                return defaultWidth != DEFAULT_WIDTH_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
                return defaultHeight != DEFAULT_HEIGHT_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
                return minimumWidth != MINIMUM_WIDTH_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
                return minimumHeight != MINIMUM_HEIGHT_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
                return maximumWidth != MAXIMUM_WIDTH_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                return maximumHeight != MAXIMUM_HEIGHT_EDEFAULT;
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER:
                return attachedToBorder != ATTACHED_TO_BORDER_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (type: ");
        result.append(type);
        result.append(", defaultBackgroundColor: ");
        result.append(defaultBackgroundColor);
        result.append(", backgroundColorChangeable: ");
        result.append(backgroundColorChangeable);
        result.append(", resizing: ");
        result.append(resizing);
        result.append(", container: ");
        result.append(container);
        result.append(", layout: ");
        result.append(layout);
        result.append(", directEditable: ");
        result.append(directEditable);
        result.append(", defaultWidth: ");
        result.append(defaultWidth);
        result.append(", defaultHeight: ");
        result.append(defaultHeight);
        result.append(", minimumWidth: ");
        result.append(minimumWidth);
        result.append(", minimumHeight: ");
        result.append(minimumHeight);
        result.append(", maximumWidth: ");
        result.append(maximumWidth);
        result.append(", maximumHeight: ");
        result.append(maximumHeight);
        result.append(", attachedToBorder: ");
        result.append(attachedToBorder);
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
     * Check if a nodePartConfiguration is connectable in a diagram
     * 
     * @return true if at least one edge may be connected to the nodePartConfiguration
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
     * Get the FeatureID of the first feature of the GenClass asosciated with the current NodePartConfiguration (if it
     * exists). The type of the feature should match with the type of the passed GenClass.
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

    /**
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getExtendedFigure()
     */
    public IFigure getExtendedFigure()
    {
        try
        {
            return FigureDeclarationsManager.getInstance().find(getType()).getFigure();
        }
        catch (CoreException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#alreadyExtendContainerFigure()
     */
    public boolean alreadyExtendContainerFigure()
    {
        return getExtendedFigure() instanceof ContainerFigure;
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#shouldImplementIContainerFigure()
     */
    public boolean shouldImplementIContainerFigure()
    {
        return isContainer() && !(getExtendedFigure() instanceof IContainerFigure);
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#shouldImplementILabelFigure()
     */
    public boolean shouldImplementILabelFigure()
    {
        return isDirectEditable() && !(getExtendedFigure() instanceof ILabelFigure);
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultBackgroundColorStringValue()
     */
    public String getDefaultBackgroundColorStringValue()
    {
        return DiagramconfiguratorFactory.eINSTANCE.convertToString(DiagramconfiguratorPackage.eINSTANCE.getColor(), getDefaultBackgroundColor());
    }

} // NodePartConfigurationImpl
