/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfigurationImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Outline Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl#getCreateChild <em>Create Child</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl#getGenPackage <em>Gen Package</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl#getPackage <em>Package</em>}</li>
 * <li>{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl#getPluginClassName <em>Plugin Class Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OutlineConfigurationImpl extends EObjectImpl implements OutlineConfiguration
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getCreateChild() <em>Create Child</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCreateChild()
     * @generated
     * @ordered
     */
    protected CreateChildMenuConfiguration createChild = null;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getProjectName()
     * @generated
     * @ordered
     */
    protected static final String PROJECT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getProjectName()
     * @generated
     * @ordered
     */
    protected String projectName = PROJECT_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getGenPackage() <em>Gen Package</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getGenPackage()
     * @generated
     * @ordered
     */
    protected GenPackage genPackage = null;

    /**
     * The default value of the '{@link #getPackage() <em>Package</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected String package_ = PACKAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getPluginClassName() <em>Plugin Class Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPluginClassName()
     * @generated
     * @ordered
     */
    protected static final String PLUGIN_CLASS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPluginClassName() <em>Plugin Class Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPluginClassName()
     * @generated
     * @ordered
     */
    protected String pluginClassName = PLUGIN_CLASS_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OutlineConfigurationImpl()
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
        return OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CreateChildMenuConfiguration getCreateChild()
    {
        return createChild;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCreateChild(CreateChildMenuConfiguration newCreateChild, NotificationChain msgs)
    {
        CreateChildMenuConfiguration oldCreateChild = createChild;
        createChild = newCreateChild;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD, oldCreateChild, newCreateChild);
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
    public void setCreateChild(CreateChildMenuConfiguration newCreateChild)
    {
        if (newCreateChild != createChild)
        {
            NotificationChain msgs = null;
            if (createChild != null)
                msgs = ((InternalEObject) createChild).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD, null, msgs);
            if (newCreateChild != null)
                msgs = ((InternalEObject) newCreateChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD, null, msgs);
            msgs = basicSetCreateChild(newCreateChild, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD, newCreateChild, newCreateChild));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getProjectName()
    {
        return projectName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProjectName(String newProjectName)
    {
        String oldProjectName = projectName;
        projectName = newProjectName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PROJECT_NAME, oldProjectName, projectName));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenPackage getGenPackage()
    {
        if (genPackage != null && genPackage.eIsProxy())
        {
            InternalEObject oldGenPackage = (InternalEObject) genPackage;
            genPackage = (GenPackage) eResolveProxy(oldGenPackage);
            if (genPackage != oldGenPackage)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__GEN_PACKAGE, oldGenPackage, genPackage));
            }
        }
        return genPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenPackage basicGetGenPackage()
    {
        return genPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGenPackage(GenPackage newGenPackage)
    {
        GenPackage oldGenPackage = genPackage;
        genPackage = newGenPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__GEN_PACKAGE, oldGenPackage, genPackage));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getPackage()
    {
        if (package_ == null || package_.length() == 0)
        {
            package_ = getProjectName();
        }
        return package_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPackage(String newPackage)
    {
        String oldPackage = package_;
        package_ = newPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PACKAGE, oldPackage, package_));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPluginClassName()
    {
        return pluginClassName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPluginClassName(String newPluginClassName)
    {
        String oldPluginClassName = pluginClassName;
        pluginClassName = newPluginClassName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME, oldPluginClassName, pluginClassName));
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
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD:
                return basicSetCreateChild(null, msgs);
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
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD:
                return getCreateChild();
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__NAME:
                return getName();
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PROJECT_NAME:
                return getProjectName();
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__GEN_PACKAGE:
                if (resolve)
                    return getGenPackage();
                return basicGetGenPackage();
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PACKAGE:
                return getPackage();
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME:
                return getPluginClassName();
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
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD:
                setCreateChild((CreateChildMenuConfiguration) newValue);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__NAME:
                setName((String) newValue);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PROJECT_NAME:
                setProjectName((String) newValue);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__GEN_PACKAGE:
                setGenPackage((GenPackage) newValue);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PACKAGE:
                setPackage((String) newValue);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME:
                setPluginClassName((String) newValue);
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
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD:
                setCreateChild((CreateChildMenuConfiguration) null);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PROJECT_NAME:
                setProjectName(PROJECT_NAME_EDEFAULT);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__GEN_PACKAGE:
                setGenPackage((GenPackage) null);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PACKAGE:
                setPackage(PACKAGE_EDEFAULT);
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME:
                setPluginClassName(PLUGIN_CLASS_NAME_EDEFAULT);
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
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD:
                return createChild != null;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PROJECT_NAME:
                return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__GEN_PACKAGE:
                return genPackage != null;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PACKAGE:
                return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME:
                return PLUGIN_CLASS_NAME_EDEFAULT == null ? pluginClassName != null : !PLUGIN_CLASS_NAME_EDEFAULT.equals(pluginClassName);
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
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", projectName: "); //$NON-NLS-1$
        result.append(projectName);
        result.append(", package: "); //$NON-NLS-1$
        result.append(package_);
        result.append(", pluginClassName: "); //$NON-NLS-1$
        result.append(pluginClassName);
        result.append(')');
        return result.toString();
    }


	//---
	//------
	//---------
	//------------
	// CODE CUSTOM
	//------------
	//---------
	//------
	//---

    public String getUtilitiesPackageName()
    {
        return getPackage() + ".util";
    }

} // OutlineConfigurationImpl
