/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeGraphConfImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.graphics.Color;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.NodeGraphConf;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getDefaultWidth <em>Default Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getDefaultHeight <em>Default Height</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getMinimumWidth <em>Minimum Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getMinimumHeight <em>Minimum Height</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getMaximumWidth <em>Maximum Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getMaximumHeight <em>Maximum Height</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#isIsWidthResizable <em>Is Width Resizable</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#isIsHeightResizable <em>Is Height Resizable</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NodeGraphConfImpl extends AbstractGraphConfImpl implements NodeGraphConf
{
    /**
     * The default value of the '{@link #getDefaultWidth() <em>Default Width</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultWidth()
     * @generated
     * @ordered
     */
    protected static final int DEFAULT_WIDTH_EDEFAULT = 0;

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
    protected static final int DEFAULT_HEIGHT_EDEFAULT = 0;

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
    protected static final int MINIMUM_WIDTH_EDEFAULT = 0;

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
    protected static final int MINIMUM_HEIGHT_EDEFAULT = 0;

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
    protected static final int MAXIMUM_WIDTH_EDEFAULT = 0;

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
    protected static final int MAXIMUM_HEIGHT_EDEFAULT = 0;

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
     * The default value of the '{@link #isIsWidthResizable() <em>Is Width Resizable</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isIsWidthResizable()
     * @generated
     * @ordered
     */
    protected static final boolean IS_WIDTH_RESIZABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsWidthResizable() <em>Is Width Resizable</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isIsWidthResizable()
     * @generated
     * @ordered
     */
    protected boolean isWidthResizable = IS_WIDTH_RESIZABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isIsHeightResizable() <em>Is Height Resizable</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isIsHeightResizable()
     * @generated
     * @ordered
     */
    protected static final boolean IS_HEIGHT_RESIZABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsHeightResizable() <em>Is Height Resizable</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isIsHeightResizable()
     * @generated
     * @ordered
     */
    protected boolean isHeightResizable = IS_HEIGHT_RESIZABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultBackgroundColor() <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_BACKGROUND_COLOR_EDEFAULT = null;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NodeGraphConfImpl()
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
        return GraphconfPackage.Literals.NODE_GRAPH_CONF;
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_WIDTH, oldDefaultWidth, defaultWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_HEIGHT, oldDefaultHeight, defaultHeight));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_WIDTH, oldMinimumWidth, minimumWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_HEIGHT, oldMinimumHeight, minimumHeight));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_WIDTH, oldMaximumWidth, maximumWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_HEIGHT, oldMaximumHeight, maximumHeight));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isIsWidthResizable()
    {
        return isWidthResizable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIsWidthResizable(boolean newIsWidthResizable)
    {
        boolean oldIsWidthResizable = isWidthResizable;
        isWidthResizable = newIsWidthResizable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE, oldIsWidthResizable, isWidthResizable));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isIsHeightResizable()
    {
        return isHeightResizable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIsHeightResizable(boolean newIsHeightResizable)
    {
        boolean oldIsHeightResizable = isHeightResizable;
        isHeightResizable = newIsHeightResizable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE, oldIsHeightResizable, isHeightResizable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR, oldDefaultBackgroundColor, defaultBackgroundColor));
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
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_WIDTH:
                return new Integer(getDefaultWidth());
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_HEIGHT:
                return new Integer(getDefaultHeight());
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_WIDTH:
                return new Integer(getMinimumWidth());
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_HEIGHT:
                return new Integer(getMinimumHeight());
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_WIDTH:
                return new Integer(getMaximumWidth());
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_HEIGHT:
                return new Integer(getMaximumHeight());
            case GraphconfPackage.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE:
                return isIsWidthResizable() ? Boolean.TRUE : Boolean.FALSE;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE:
                return isIsHeightResizable() ? Boolean.TRUE : Boolean.FALSE;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                return getDefaultBackgroundColor();
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
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_WIDTH:
                setDefaultWidth(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_HEIGHT:
                setDefaultHeight(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_WIDTH:
                setMinimumWidth(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_HEIGHT:
                setMinimumHeight(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_WIDTH:
                setMaximumWidth(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_HEIGHT:
                setMaximumHeight(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE:
                setIsWidthResizable(((Boolean) newValue).booleanValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE:
                setIsHeightResizable(((Boolean) newValue).booleanValue());
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor((Color) newValue);
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
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_WIDTH:
                setDefaultWidth(DEFAULT_WIDTH_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_HEIGHT:
                setDefaultHeight(DEFAULT_HEIGHT_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_WIDTH:
                setMinimumWidth(MINIMUM_WIDTH_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_HEIGHT:
                setMinimumHeight(MINIMUM_HEIGHT_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_WIDTH:
                setMaximumWidth(MAXIMUM_WIDTH_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_HEIGHT:
                setMaximumHeight(MAXIMUM_HEIGHT_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE:
                setIsWidthResizable(IS_WIDTH_RESIZABLE_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE:
                setIsHeightResizable(IS_HEIGHT_RESIZABLE_EDEFAULT);
                return;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                setDefaultBackgroundColor(DEFAULT_BACKGROUND_COLOR_EDEFAULT);
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
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_WIDTH:
                return defaultWidth != DEFAULT_WIDTH_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_HEIGHT:
                return defaultHeight != DEFAULT_HEIGHT_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_WIDTH:
                return minimumWidth != MINIMUM_WIDTH_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_HEIGHT:
                return minimumHeight != MINIMUM_HEIGHT_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_WIDTH:
                return maximumWidth != MAXIMUM_WIDTH_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_HEIGHT:
                return maximumHeight != MAXIMUM_HEIGHT_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE:
                return isWidthResizable != IS_WIDTH_RESIZABLE_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE:
                return isHeightResizable != IS_HEIGHT_RESIZABLE_EDEFAULT;
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
                return DEFAULT_BACKGROUND_COLOR_EDEFAULT == null ? defaultBackgroundColor != null : !DEFAULT_BACKGROUND_COLOR_EDEFAULT.equals(defaultBackgroundColor);
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
        result.append(" (defaultWidth: ");
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
        result.append(", isWidthResizable: ");
        result.append(isWidthResizable);
        result.append(", isHeightResizable: ");
        result.append(isHeightResizable);
        result.append(", defaultBackgroundColor: ");
        result.append(defaultBackgroundColor);
        result.append(')');
        return result.toString();
    }

} // NodeGraphConfImpl
