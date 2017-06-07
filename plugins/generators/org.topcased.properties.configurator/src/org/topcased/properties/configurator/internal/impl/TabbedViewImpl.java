/**
 * <copyright>
 * </copyright>
 *
 * $Id: TabbedViewImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.TabbedView;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tabbed View</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl#getCategories <em>Categories</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl#getGenModel <em>Gen Model</em>}</li>
 * <li>{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl#getBasePackage <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TabbedViewImpl extends EObjectImpl implements TabbedView
{
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
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCategories()
     * @generated
     * @ordered
     */
    protected EList categories = null;

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
     * The cached value of the '{@link #getGenModel() <em>Gen Model</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getGenModel()
     * @generated
     * @ordered
     */
    protected GenModel genModel = null;

    /**
     * The default value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBasePackage()
     * @generated
     * @ordered
     */
    protected static final String BASE_PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBasePackage()
     * @generated
     * @ordered
     */
    protected String basePackage = BASE_PACKAGE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TabbedViewImpl()
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
        return PropertiesConfiguratorPackage.Literals.TABBED_VIEW;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TABBED_VIEW__PROJECT_NAME, oldProjectName, projectName));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getId()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setId(String newId)
    {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TABBED_VIEW__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getCategories()
    {
        if (categories == null)
        {
            categories = new EObjectContainmentWithInverseEList(Category.class, this, PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES, PropertiesConfiguratorPackage.CATEGORY__PARENT);
        }
        return categories;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TABBED_VIEW__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenModel getGenModel()
    {
        if (genModel != null && genModel.eIsProxy())
        {
            InternalEObject oldGenModel = (InternalEObject) genModel;
            genModel = (GenModel) eResolveProxy(oldGenModel);
            if (genModel != oldGenModel)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropertiesConfiguratorPackage.TABBED_VIEW__GEN_MODEL, oldGenModel, genModel));
            }
        }
        return genModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenModel basicGetGenModel()
    {
        return genModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGenModel(GenModel newGenModel)
    {
        GenModel oldGenModel = genModel;
        genModel = newGenModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TABBED_VIEW__GEN_MODEL, oldGenModel, genModel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getBasePackage()
    {
        return basePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setBasePackage(String newBasePackage)
    {
        String oldBasePackage = basePackage;
        basePackage = newBasePackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PropertiesConfiguratorPackage.TABBED_VIEW__BASE_PACKAGE, oldBasePackage, basePackage));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getProjectNameUnspaced()
    {
        return replaceSpaces(getProjectName());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getIdUnspaced()
    {
        return replaceSpaces(getId());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String replaceSpaces(String toReplace)
    {
        return toReplace.replaceAll(" ", "_");
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                return ((InternalEList) getCategories()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
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
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                return ((InternalEList) getCategories()).basicRemove(otherEnd, msgs);
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
            case PropertiesConfiguratorPackage.TABBED_VIEW__PROJECT_NAME:
                return getProjectName();
            case PropertiesConfiguratorPackage.TABBED_VIEW__ID:
                return getId();
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                return getCategories();
            case PropertiesConfiguratorPackage.TABBED_VIEW__NAME:
                return getName();
            case PropertiesConfiguratorPackage.TABBED_VIEW__GEN_MODEL:
                if (resolve)
                    return getGenModel();
                return basicGetGenModel();
            case PropertiesConfiguratorPackage.TABBED_VIEW__BASE_PACKAGE:
                return getBasePackage();
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
            case PropertiesConfiguratorPackage.TABBED_VIEW__PROJECT_NAME:
                setProjectName((String) newValue);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__ID:
                setId((String) newValue);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                getCategories().clear();
                getCategories().addAll((Collection) newValue);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__NAME:
                setName((String) newValue);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__GEN_MODEL:
                setGenModel((GenModel) newValue);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__BASE_PACKAGE:
                setBasePackage((String) newValue);
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
            case PropertiesConfiguratorPackage.TABBED_VIEW__PROJECT_NAME:
                setProjectName(PROJECT_NAME_EDEFAULT);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__ID:
                setId(ID_EDEFAULT);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                getCategories().clear();
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__GEN_MODEL:
                setGenModel((GenModel) null);
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__BASE_PACKAGE:
                setBasePackage(BASE_PACKAGE_EDEFAULT);
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
            case PropertiesConfiguratorPackage.TABBED_VIEW__PROJECT_NAME:
                return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
            case PropertiesConfiguratorPackage.TABBED_VIEW__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                return categories != null && !categories.isEmpty();
            case PropertiesConfiguratorPackage.TABBED_VIEW__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PropertiesConfiguratorPackage.TABBED_VIEW__GEN_MODEL:
                return genModel != null;
            case PropertiesConfiguratorPackage.TABBED_VIEW__BASE_PACKAGE:
                return BASE_PACKAGE_EDEFAULT == null ? basePackage != null : !BASE_PACKAGE_EDEFAULT.equals(basePackage);
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
        result.append(" (projectName: ");
        result.append(projectName);
        result.append(", id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(", basePackage: ");
        result.append(basePackage);
        result.append(')');
        return result.toString();
    }

} // TabbedViewImpl
