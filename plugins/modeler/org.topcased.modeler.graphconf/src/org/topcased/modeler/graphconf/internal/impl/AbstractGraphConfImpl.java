/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractGraphConfImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.topcased.modeler.graphconf.AbstractGraphConf;
import org.topcased.modeler.graphconf.Bridge;
import org.topcased.modeler.graphconf.Constraint;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.LineStyle;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getPresentation <em>Presentation</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getDefaultFont <em>Default Font</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getLineWidth <em>Line Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getLineStyle <em>Line Style</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getBridge <em>Bridge</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractGraphConfImpl extends EObjectImpl implements AbstractGraphConf
{
    /**
     * The default value of the '{@link #getPresentation() <em>Presentation</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPresentation()
     * @generated
     * @ordered
     */
    protected static final String PRESENTATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPresentation() <em>Presentation</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPresentation()
     * @generated
     * @ordered
     */
    protected String presentation = PRESENTATION_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected static final Color DEFAULT_FOREGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultForegroundColor() <em>Default Foreground Color</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultForegroundColor()
     * @generated
     * @ordered
     */
    protected Color defaultForegroundColor = DEFAULT_FOREGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultFont() <em>Default Font</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultFont()
     * @generated
     * @ordered
     */
    protected static final Font DEFAULT_FONT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDefaultFont() <em>Default Font</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultFont()
     * @generated
     * @ordered
     */
    protected Font defaultFont = DEFAULT_FONT_EDEFAULT;

    /**
     * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLineWidth()
     * @generated
     * @ordered
     */
    protected static final int LINE_WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLineWidth()
     * @generated
     * @ordered
     */
    protected int lineWidth = LINE_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLineStyle()
     * @generated
     * @ordered
     */
    protected static final LineStyle LINE_STYLE_EDEFAULT = LineStyle.SOLID_LITERAL;

    /**
     * The cached value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLineStyle()
     * @generated
     * @ordered
     */
    protected LineStyle lineStyle = LINE_STYLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getBridge() <em>Bridge</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBridge()
     * @generated
     * @ordered
     */
    protected Bridge bridge = null;

    /**
     * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getConstraint()
     * @generated
     * @ordered
     */
    protected EList constraint = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractGraphConfImpl()
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
        return GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPresentation()
    {
        return presentation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPresentation(String newPresentation)
    {
        String oldPresentation = presentation;
        presentation = newPresentation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__PRESENTATION, oldPresentation, presentation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Color getDefaultForegroundColor()
    {
        return defaultForegroundColor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultForegroundColor(Color newDefaultForegroundColor)
    {
        Color oldDefaultForegroundColor = defaultForegroundColor;
        defaultForegroundColor = newDefaultForegroundColor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR, oldDefaultForegroundColor, defaultForegroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Font getDefaultFont()
    {
        return defaultFont;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultFont(Font newDefaultFont)
    {
        Font oldDefaultFont = defaultFont;
        defaultFont = newDefaultFont;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FONT, oldDefaultFont, defaultFont));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getLineWidth()
    {
        return lineWidth;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLineWidth(int newLineWidth)
    {
        int oldLineWidth = lineWidth;
        lineWidth = newLineWidth;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_WIDTH, oldLineWidth, lineWidth));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public LineStyle getLineStyle()
    {
        return lineStyle;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLineStyle(LineStyle newLineStyle)
    {
        LineStyle oldLineStyle = lineStyle;
        lineStyle = newLineStyle == null ? LINE_STYLE_EDEFAULT : newLineStyle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_STYLE, oldLineStyle, lineStyle));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Bridge getBridge()
    {
        return bridge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBridge(Bridge newBridge, NotificationChain msgs)
    {
        Bridge oldBridge = bridge;
        bridge = newBridge;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE, oldBridge, newBridge);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBridge(Bridge newBridge)
    {
        if (newBridge != bridge)
        {
            NotificationChain msgs = null;
            if (bridge != null)
                msgs = ((InternalEObject) bridge).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE, null, msgs);
            if (newBridge != null)
                msgs = ((InternalEObject) newBridge).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE, null, msgs);
            msgs = basicSetBridge(newBridge, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE, newBridge, newBridge));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getConstraint()
    {
        if (constraint == null)
        {
            constraint = new EObjectContainmentEList(Constraint.class, this, GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT);
        }
        return constraint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE:
                return basicSetBridge(null, msgs);
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT:
                return ((InternalEList) getConstraint()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__PRESENTATION:
                return getPresentation();
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FONT:
                return getDefaultFont();
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_WIDTH:
                return new Integer(getLineWidth());
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_STYLE:
                return getLineStyle();
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE:
                return getBridge();
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT:
                return getConstraint();
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
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__PRESENTATION:
                setPresentation((String) newValue);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((Color) newValue);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FONT:
                setDefaultFont((Font) newValue);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_WIDTH:
                setLineWidth(((Integer) newValue).intValue());
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_STYLE:
                setLineStyle((LineStyle) newValue);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE:
                setBridge((Bridge) newValue);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT:
                getConstraint().clear();
                getConstraint().addAll((Collection) newValue);
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
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__PRESENTATION:
                setPresentation(PRESENTATION_EDEFAULT);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FONT:
                setDefaultFont(DEFAULT_FONT_EDEFAULT);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_WIDTH:
                setLineWidth(LINE_WIDTH_EDEFAULT);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_STYLE:
                setLineStyle(LINE_STYLE_EDEFAULT);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE:
                setBridge((Bridge) null);
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT:
                getConstraint().clear();
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
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__PRESENTATION:
                return PRESENTATION_EDEFAULT == null ? presentation != null : !PRESENTATION_EDEFAULT.equals(presentation);
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FONT:
                return DEFAULT_FONT_EDEFAULT == null ? defaultFont != null : !DEFAULT_FONT_EDEFAULT.equals(defaultFont);
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_WIDTH:
                return lineWidth != LINE_WIDTH_EDEFAULT;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_STYLE:
                return lineStyle != LINE_STYLE_EDEFAULT;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE:
                return bridge != null;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT:
                return constraint != null && !constraint.isEmpty();
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
        result.append(" (presentation: ");
        result.append(presentation);
        result.append(", defaultForegroundColor: ");
        result.append(defaultForegroundColor);
        result.append(", defaultFont: ");
        result.append(defaultFont);
        result.append(", lineWidth: ");
        result.append(lineWidth);
        result.append(", lineStyle: ");
        result.append(lineStyle);
        result.append(')');
        return result.toString();
    }

} // AbstractGraphConfImpl
