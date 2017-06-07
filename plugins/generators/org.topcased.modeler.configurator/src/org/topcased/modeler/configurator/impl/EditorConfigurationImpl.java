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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.EditorConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getExtensionDiagram <em>Extension Diagram</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getGenModel <em>Gen Model</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl#getPluginVersion <em>Plugin Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditorConfigurationImpl extends EObjectImpl implements EditorConfiguration
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProjectName()
     * @generated
     * @ordered
     */
    protected static final String PROJECT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProjectName()
     * @generated
     * @ordered
     */
    protected String projectName = PROJECT_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtension()
     * @generated
     * @ordered
     */
    protected static final String EXTENSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtension()
     * @generated
     * @ordered
     */
    protected String extension = EXTENSION_EDEFAULT;

    /**
     * The default value of the '{@link #getExtensionDiagram() <em>Extension Diagram</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensionDiagram()
     * @generated
     * @ordered
     */
    protected static final String EXTENSION_DIAGRAM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExtensionDiagram() <em>Extension Diagram</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensionDiagram()
     * @generated
     * @ordered
     */
    protected String extensionDiagram = EXTENSION_DIAGRAM_EDEFAULT;

    /**
     * The cached value of the '{@link #getGenModel() <em>Gen Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenModel()
     * @generated
     * @ordered
     */
    protected GenModel genModel = null;

    /**
     * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiagrams()
     * @generated
     * @ordered
     */
    protected EList diagrams = null;

    /**
     * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObjects()
     * @generated
     * @ordered
     */
    protected EList objects = null;

    /**
     * The default value of the '{@link #getPluginVersion() <em>Plugin Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginVersion()
     * @generated NOT
     * @ordered
     */
    protected static final String PLUGIN_VERSION_EDEFAULT = (String) ConfiguratorPlugin.getPlugin().getBundle().getHeaders().get(org.osgi.framework.Constants.BUNDLE_VERSION);

    /**
     * The cached value of the '{@link #getPluginVersion() <em>Plugin Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginVersion()
     * @generated
     * @ordered
     */
    protected String pluginVersion = PLUGIN_VERSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EditorConfigurationImpl()
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
        return ConfiguratorPackage.eINSTANCE.getEditorConfiguration();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getProjectName()
    {
        return projectName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProjectName(String newProjectName)
    {
        String oldProjectName = projectName;
        projectName = newProjectName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME, oldProjectName, projectName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPrefix()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrefix(String newPrefix)
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__PREFIX, oldPrefix, prefix));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExtension(String newExtension)
    {
        String oldExtension = extension;
        extension = newExtension;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION, oldExtension, extension));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExtensionDiagram()
    {
        return extensionDiagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExtensionDiagram(String newExtensionDiagram)
    {
        String oldExtensionDiagram = extensionDiagram;
        extensionDiagram = newExtensionDiagram;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION_DIAGRAM, oldExtensionDiagram, extensionDiagram));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenModel getGenModel()
    {
        if (genModel != null && genModel.eIsProxy())
        {
            GenModel oldGenModel = genModel;
            genModel = (GenModel)eResolveProxy((InternalEObject)genModel);
            if (genModel != oldGenModel)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL, oldGenModel, genModel));
            }
        }
        return genModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenModel basicGetGenModel()
    {
        return genModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGenModel(GenModel newGenModel)
    {
        GenModel oldGenModel = genModel;
        genModel = newGenModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL, oldGenModel, genModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getDiagrams()
    {
        if (diagrams == null)
        {
            diagrams = new EObjectContainmentEList(DiagramConfiguration.class, this, ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS);
        }
        return diagrams;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getObjects()
    {
        if (objects == null)
        {
            objects = new EObjectContainmentEList(ObjectConfiguration.class, this, ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS);
        }
        return objects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPluginVersion()
    {
        return pluginVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPluginVersion(String newPluginVersion)
    {
        String oldPluginVersion = pluginVersion;
        pluginVersion = newPluginVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION, oldPluginVersion, pluginVersion));
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
                case ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS:
                    return ((InternalEList)getDiagrams()).basicRemove(otherEnd, msgs);
                case ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS:
                    return ((InternalEList)getObjects()).basicRemove(otherEnd, msgs);
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
            case ConfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                return getName();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                return getProjectName();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PREFIX:
                return getPrefix();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION:
                return getExtension();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION_DIAGRAM:
                return getExtensionDiagram();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                if (resolve) return getGenModel();
                return basicGetGenModel();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS:
                return getDiagrams();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS:
                return getObjects();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                return getPluginVersion();
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
            case ConfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                setName((String)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                setProjectName((String)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PREFIX:
                setPrefix((String)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION:
                setExtension((String)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION_DIAGRAM:
                setExtensionDiagram((String)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                setGenModel((GenModel)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS:
                getDiagrams().clear();
                getDiagrams().addAll((Collection)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS:
                getObjects().clear();
                getObjects().addAll((Collection)newValue);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                setPluginVersion((String)newValue);
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
            case ConfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                setProjectName(PROJECT_NAME_EDEFAULT);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PREFIX:
                setPrefix(PREFIX_EDEFAULT);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION:
                setExtension(EXTENSION_EDEFAULT);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION_DIAGRAM:
                setExtensionDiagram(EXTENSION_DIAGRAM_EDEFAULT);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                setGenModel((GenModel)null);
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS:
                getDiagrams().clear();
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS:
                getObjects().clear();
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                setPluginVersion(PLUGIN_VERSION_EDEFAULT);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * If the plugin version has not been changed, this is valid too
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION:
                return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION_DIAGRAM:
                return EXTENSION_DIAGRAM_EDEFAULT == null ? extensionDiagram != null : !EXTENSION_DIAGRAM_EDEFAULT.equals(extensionDiagram);
            case ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                return genModel != null;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS:
                return diagrams != null && !diagrams.isEmpty();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS:
                return objects != null && !objects.isEmpty();
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                return pluginVersion != null;
//                return PLUGIN_VERSION_EDEFAULT == null ? pluginVersion != null : !PLUGIN_VERSION_EDEFAULT.equals(pluginVersion);
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
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", projectName: "); //$NON-NLS-1$
        result.append(projectName);
        result.append(", prefix: "); //$NON-NLS-1$
        result.append(prefix);
        result.append(", extension: "); //$NON-NLS-1$
        result.append(extension);
        result.append(", extensionDiagram: "); //$NON-NLS-1$
        result.append(extensionDiagram);
        result.append(", pluginVersion: "); //$NON-NLS-1$
        result.append(pluginVersion);
        result.append(')');
        return result.toString();
    }

} //EditorConfigurationImpl
