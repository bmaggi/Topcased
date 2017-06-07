/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartConfigurationImpl.java,v 1.6 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

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
import org.topcased.modeler.diagramconfigurator.Constraint;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.LineStyle;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PartAction;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Part Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getObject <em>Object</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getPresentation <em>Presentation</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#isForegroundColorChangeable <em>Foreground Color Changeable</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getDefaultFont <em>Default Font</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#isFontChangeable <em>Font Changeable</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getLineWidth <em>Line Width</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getLineStyle <em>Line Style</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getConstraint <em>Constraint</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class PartConfigurationImpl extends EObjectImpl implements PartConfiguration
{
    /**
     * The cached value of the '{@link #getObject() <em>Object</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getObject()
     * @generated
     * @ordered
     */
    protected ObjectConfiguration object;

    /**
     * The default value of the '{@link #getPresentation() <em>Presentation</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPresentation()
     * @generated
     * @ordered
     */
    protected static final String PRESENTATION_EDEFAULT = "default";

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
    protected static final Color DEFAULT_FOREGROUND_COLOR_EDEFAULT = (Color) DiagramconfiguratorFactory.eINSTANCE.createFromString(DiagramconfiguratorPackage.eINSTANCE.getColor(), "0,0,0");

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
     * The default value of the '{@link #isForegroundColorChangeable() <em>Foreground Color Changeable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isForegroundColorChangeable()
     * @generated
     * @ordered
     */
    protected static final boolean FOREGROUND_COLOR_CHANGEABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isForegroundColorChangeable() <em>Foreground Color Changeable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isForegroundColorChangeable()
     * @generated
     * @ordered
     */
    protected boolean foregroundColorChangeable = FOREGROUND_COLOR_CHANGEABLE_EDEFAULT;

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
     * The default value of the '{@link #isFontChangeable() <em>Font Changeable</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isFontChangeable()
     * @generated
     * @ordered
     */
    protected static final boolean FONT_CHANGEABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isFontChangeable() <em>Font Changeable</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isFontChangeable()
     * @generated
     * @ordered
     */
    protected boolean fontChangeable = FONT_CHANGEABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLineWidth()
     * @generated
     * @ordered
     */
    protected static final int LINE_WIDTH_EDEFAULT = 1;

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
     * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getConstraint()
     * @generated
     * @ordered
     */
    protected EList<Constraint> constraint;

    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getActions()
     * @generated
     * @ordered
     */
    protected EList<PartAction> actions;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PartConfigurationImpl()
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
        return DiagramconfiguratorPackage.Literals.PART_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ObjectConfiguration getObject()
    {
        if (object != null && object.eIsProxy())
        {
            InternalEObject oldObject = (InternalEObject) object;
            object = (ObjectConfiguration) eResolveProxy(oldObject);
            if (object != oldObject)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT, oldObject, object));
            }
        }
        return object;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ObjectConfiguration basicGetObject()
    {
        return object;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setObject(ObjectConfiguration newObject)
    {
        ObjectConfiguration oldObject = object;
        object = newObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT, oldObject, object));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__PRESENTATION, oldPresentation, presentation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR, oldDefaultForegroundColor, defaultForegroundColor));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isForegroundColorChangeable()
    {
        return foregroundColorChangeable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setForegroundColorChangeable(boolean newForegroundColorChangeable)
    {
        boolean oldForegroundColorChangeable = foregroundColorChangeable;
        foregroundColorChangeable = newForegroundColorChangeable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE, oldForegroundColorChangeable, foregroundColorChangeable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FONT, oldDefaultFont, defaultFont));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isFontChangeable()
    {
        return fontChangeable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFontChangeable(boolean newFontChangeable)
    {
        boolean oldFontChangeable = fontChangeable;
        fontChangeable = newFontChangeable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE, oldFontChangeable, fontChangeable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_WIDTH, oldLineWidth, lineWidth));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_STYLE, oldLineStyle, lineStyle));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Constraint> getConstraint()
    {
        if (constraint == null)
        {
            constraint = new EObjectContainmentEList<Constraint>(Constraint.class, this, DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT);
        }
        return constraint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getPrefix()
    {
        // initialize the prefix with the name of the ObjectConfiguration
        if (prefix == null && getObject() != null)
        {
            return getObject().getName();
        }
        return prefix;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPrefix(String newPrefix)
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_CONFIGURATION__PREFIX, oldPrefix, prefix));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<PartAction> getActions()
    {
        if (actions == null)
        {
            actions = new EObjectContainmentEList<PartAction>(PartAction.class, this, DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS);
        }
        return actions;
    }

    /**
     * <!-- begin-user-doc -->
     * A NodePartConfiguration is abstract when it is associated with a domain element (instance of ModelObjectConfiguration) and that the metaclass is abstract.
     * <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl#isAbstract()
     * @generated NOT
     */
    public boolean isAbstract()
    {
        return getObject() instanceof ModelObjectConfiguration && ((ModelObjectConfiguration) getObject()).getGenClass().isAbstract();
    }

    

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT:
                return ((InternalEList< ? >) getConstraint()).basicRemove(otherEnd, msgs);
            case DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS:
                return ((InternalEList< ? >) getActions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT:
                if (resolve)
                    return getObject();
                return basicGetObject();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PRESENTATION:
                return getPresentation();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return getDefaultForegroundColor();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return isForegroundColorChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FONT:
                return getDefaultFont();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                return isFontChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_WIDTH:
                return new Integer(getLineWidth());
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_STYLE:
                return getLineStyle();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT:
                return getConstraint();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PREFIX:
                return getPrefix();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS:
                return getActions();
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
            case DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PRESENTATION:
                setPresentation((String) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor((Color) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FONT:
                setDefaultFont((Font) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_WIDTH:
                setLineWidth(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_STYLE:
                setLineStyle((LineStyle) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT:
                getConstraint().clear();
                getConstraint().addAll((Collection< ? extends Constraint>) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PREFIX:
                setPrefix((String) newValue);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS:
                getActions().clear();
                getActions().addAll((Collection< ? extends PartAction>) newValue);
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
            case DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT:
                setObject((ObjectConfiguration) null);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PRESENTATION:
                setPresentation(PRESENTATION_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                setForegroundColorChangeable(FOREGROUND_COLOR_CHANGEABLE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FONT:
                setDefaultFont(DEFAULT_FONT_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                setFontChangeable(FONT_CHANGEABLE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_WIDTH:
                setLineWidth(LINE_WIDTH_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_STYLE:
                setLineStyle(LINE_STYLE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT:
                getConstraint().clear();
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PREFIX:
                setPrefix(PREFIX_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS:
                getActions().clear();
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
            case DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT:
                return object != null;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PRESENTATION:
                return PRESENTATION_EDEFAULT == null ? presentation != null : !PRESENTATION_EDEFAULT.equals(presentation);
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
                return DEFAULT_FOREGROUND_COLOR_EDEFAULT == null ? defaultForegroundColor != null : !DEFAULT_FOREGROUND_COLOR_EDEFAULT.equals(defaultForegroundColor);
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
                return foregroundColorChangeable != FOREGROUND_COLOR_CHANGEABLE_EDEFAULT;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FONT:
                return DEFAULT_FONT_EDEFAULT == null ? defaultFont != null : !DEFAULT_FONT_EDEFAULT.equals(defaultFont);
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
                return fontChangeable != FONT_CHANGEABLE_EDEFAULT;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_WIDTH:
                return lineWidth != LINE_WIDTH_EDEFAULT;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_STYLE:
                return lineStyle != LINE_STYLE_EDEFAULT;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT:
                return constraint != null && !constraint.isEmpty();
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
            case DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS:
                return actions != null && !actions.isEmpty();
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
        result.append(" (presentation: ");
        result.append(presentation);
        result.append(", defaultForegroundColor: ");
        result.append(defaultForegroundColor);
        result.append(", foregroundColorChangeable: ");
        result.append(foregroundColorChangeable);
        result.append(", defaultFont: ");
        result.append(defaultFont);
        result.append(", fontChangeable: ");
        result.append(fontChangeable);
        result.append(", lineWidth: ");
        result.append(lineWidth);
        result.append(", lineStyle: ");
        result.append(lineStyle);
        result.append(", prefix: ");
        result.append(prefix);
        result.append(')');
        return result.toString();
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultForegroundColorStringValue()
     */
    public String getDefaultForegroundColorStringValue()
    {
        return DiagramconfiguratorFactory.eINSTANCE.convertToString(DiagramconfiguratorPackage.eINSTANCE.getColor(), getDefaultForegroundColor());
    }

    /**
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultFontStringValue()
     */
    public String getDefaultFontStringValue()
    {
        return DiagramconfiguratorFactory.eINSTANCE.convertToString(DiagramconfiguratorPackage.eINSTANCE.getFont(), getDefaultFont());
    }

} // PartConfigurationImpl
