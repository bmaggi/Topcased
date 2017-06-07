/**
 * <copyright>
 * </copyright>
 *
 * $Id: CreateChildActionImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.outline.configurator.ChildActionType;
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Create Child Action</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.internal.impl.CreateChildActionImpl#getClass_ <em>Class</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.CreateChildActionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CreateChildActionImpl extends MenuItemImpl implements CreateChildAction
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getClass_() <em>Class</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getClass_()
     * @generated
     * @ordered
     */
    protected GenClass class_ = null;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final ChildActionType TYPE_EDEFAULT = ChildActionType.EXACT_LITERAL;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ChildActionType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CreateChildActionImpl()
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
        return OutlineConfiguratorPackage.Literals.CREATE_CHILD_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenClass getClass_()
    {
        if (class_ != null && class_.eIsProxy())
        {
            InternalEObject oldClass = (InternalEObject) class_;
            class_ = (GenClass) eResolveProxy(oldClass);
            if (class_ != oldClass)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OutlineConfiguratorPackage.CREATE_CHILD_ACTION__CLASS, oldClass, class_));
            }
        }
        return class_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenClass basicGetClass()
    {
        return class_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setClass(GenClass newClass)
    {
        GenClass oldClass = class_;
        class_ = newClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.CREATE_CHILD_ACTION__CLASS, oldClass, class_));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ChildActionType getType()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setType(ChildActionType newType)
    {
        ChildActionType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.CREATE_CHILD_ACTION__TYPE, oldType, type));
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
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__CLASS:
                if (resolve)
                    return getClass_();
                return basicGetClass();
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__TYPE:
                return getType();
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
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__CLASS:
                setClass((GenClass) newValue);
                return;
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__TYPE:
                setType((ChildActionType) newValue);
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
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__CLASS:
                setClass((GenClass) null);
                return;
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__TYPE:
                setType(TYPE_EDEFAULT);
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
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__CLASS:
                return class_ != null;
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__TYPE:
                return type != TYPE_EDEFAULT;
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
        result.append(" (type: "); //$NON-NLS-1$
        result.append(type);
        result.append(')');
        return result.toString();
    }

} // CreateChildActionImpl
