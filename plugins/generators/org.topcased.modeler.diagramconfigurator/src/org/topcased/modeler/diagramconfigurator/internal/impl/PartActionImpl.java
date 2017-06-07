/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartActionImpl.java,v 1.1 2007/04/18 12:54:14 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.PartAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Part Action</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl#getMenuBarGroup <em>Menu Bar Group</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl#getLabel <em>Label</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PartActionImpl extends EObjectImpl implements PartAction
{
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
     * The default value of the '{@link #getMenuBarGroup() <em>Menu Bar Group</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getMenuBarGroup()
     * @generated
     * @ordered
     */
    protected static final String MENU_BAR_GROUP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMenuBarGroup() <em>Menu Bar Group</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMenuBarGroup()
     * @generated
     * @ordered
     */
    protected String menuBarGroup = MENU_BAR_GROUP_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getIcon()
     * @generated
     * @ordered
     */
    protected static final String ICON_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getIcon()
     * @generated
     * @ordered
     */
    protected String icon = ICON_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PartActionImpl()
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
        return DiagramconfiguratorPackage.Literals.PART_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPrefix()
    {
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_ACTION__PREFIX, oldPrefix, prefix));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getMenuBarGroup()
    {
        return menuBarGroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setMenuBarGroup(String newMenuBarGroup)
    {
        String oldMenuBarGroup = menuBarGroup;
        menuBarGroup = newMenuBarGroup;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_ACTION__MENU_BAR_GROUP, oldMenuBarGroup, menuBarGroup));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLabel(String newLabel)
    {
        String oldLabel = label;
        label = newLabel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_ACTION__LABEL, oldLabel, label));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getIcon()
    {
        return icon;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setIcon(String newIcon)
    {
        String oldIcon = icon;
        icon = newIcon;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PART_ACTION__ICON, oldIcon, icon));
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
            case DiagramconfiguratorPackage.PART_ACTION__PREFIX:
                return getPrefix();
            case DiagramconfiguratorPackage.PART_ACTION__MENU_BAR_GROUP:
                return getMenuBarGroup();
            case DiagramconfiguratorPackage.PART_ACTION__LABEL:
                return getLabel();
            case DiagramconfiguratorPackage.PART_ACTION__ICON:
                return getIcon();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.PART_ACTION__PREFIX:
                setPrefix((String) newValue);
                return;
            case DiagramconfiguratorPackage.PART_ACTION__MENU_BAR_GROUP:
                setMenuBarGroup((String) newValue);
                return;
            case DiagramconfiguratorPackage.PART_ACTION__LABEL:
                setLabel((String) newValue);
                return;
            case DiagramconfiguratorPackage.PART_ACTION__ICON:
                setIcon((String) newValue);
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
            case DiagramconfiguratorPackage.PART_ACTION__PREFIX:
                setPrefix(PREFIX_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_ACTION__MENU_BAR_GROUP:
                setMenuBarGroup(MENU_BAR_GROUP_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_ACTION__LABEL:
                setLabel(LABEL_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PART_ACTION__ICON:
                setIcon(ICON_EDEFAULT);
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
            case DiagramconfiguratorPackage.PART_ACTION__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
            case DiagramconfiguratorPackage.PART_ACTION__MENU_BAR_GROUP:
                return MENU_BAR_GROUP_EDEFAULT == null ? menuBarGroup != null : !MENU_BAR_GROUP_EDEFAULT.equals(menuBarGroup);
            case DiagramconfiguratorPackage.PART_ACTION__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
            case DiagramconfiguratorPackage.PART_ACTION__ICON:
                return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
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
        result.append(" (prefix: ");
        result.append(prefix);
        result.append(", menuBarGroup: ");
        result.append(menuBarGroup);
        result.append(", label: ");
        result.append(label);
        result.append(", icon: ");
        result.append(icon);
        result.append(')');
        return result.toString();
    }

} // PartActionImpl
