/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorConfigurationImpl.java,v 1.5 2007/04/18 12:54:46 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.editorconfigurator.EditorAction;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.modeler.editorconfigurator.internal.EditorConfiguratorPlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Editor Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getGenModel <em>Gen Model</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getPluginVersion <em>Plugin Version</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getProvider <em>Provider</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#isForceOverwrite <em>Force Overwrite</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#isOrganizeImports <em>Organize Imports</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getCopyrightText <em>Copyright Text</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EditorConfigurationImpl extends EObjectImpl implements EditorConfiguration
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

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
     * The cached value of the '{@link #getGenModel() <em>Gen Model</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getGenModel()
     * @generated
     * @ordered
     */
    protected GenModel genModel;

    /**
     * The default value of the '{@link #getPluginVersion() <em>Plugin Version</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getPluginVersion()
     * @generated NOT
     * @ordered
     */
    protected static final String PLUGIN_VERSION_EDEFAULT = (String) EditorConfiguratorPlugin.getPlugin().getBundle().getHeaders().get(org.osgi.framework.Constants.BUNDLE_VERSION);

    /**
     * The cached value of the '{@link #getPluginVersion() <em>Plugin Version</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getPluginVersion()
     * @generated
     * @ordered
     */
    protected String pluginVersion = PLUGIN_VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProvider()
     * @generated
     * @ordered
     */
    protected static final String PROVIDER_EDEFAULT = "Topcased";

    /**
     * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProvider()
     * @generated
     * @ordered
     */
    protected String provider = PROVIDER_EDEFAULT;

    /**
     * The default value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isForceOverwrite()
     * @generated
     * @ordered
     */
    protected static final boolean FORCE_OVERWRITE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForceOverwrite() <em>Force Overwrite</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isForceOverwrite()
     * @generated
     * @ordered
     */
    protected boolean forceOverwrite = FORCE_OVERWRITE_EDEFAULT;

    /**
     * The default value of the '{@link #isOrganizeImports() <em>Organize Imports</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isOrganizeImports()
     * @generated
     * @ordered
     */
    protected static final boolean ORGANIZE_IMPORTS_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isOrganizeImports() <em>Organize Imports</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isOrganizeImports()
     * @generated
     * @ordered
     */
    protected boolean organizeImports = ORGANIZE_IMPORTS_EDEFAULT;

    /**
     * The default value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getCopyrightText()
     * @generated
     * @ordered
     */
    protected static final String COPYRIGHT_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCopyrightText() <em>Copyright Text</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getCopyrightText()
     * @generated
     * @ordered
     */
    protected String copyrightText = COPYRIGHT_TEXT_EDEFAULT;

    /**
     * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getActions()
     * @generated
     * @ordered
     */
    protected EList<EditorAction> actions;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EditorConfigurationImpl()
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
        return EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME, oldProjectName, projectName));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL, oldGenModel, genModel));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL, oldGenModel, genModel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getPluginVersion()
    {
        return pluginVersion;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setPluginVersion(String newPluginVersion)
    {
        String oldPluginVersion = pluginVersion;
        pluginVersion = newPluginVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION, oldPluginVersion, pluginVersion));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getProvider()
    {
        return provider;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProvider(String newProvider)
    {
        String oldProvider = provider;
        provider = newProvider;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROVIDER, oldProvider, provider));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isForceOverwrite()
    {
        return forceOverwrite;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setForceOverwrite(boolean newForceOverwrite)
    {
        boolean oldForceOverwrite = forceOverwrite;
        forceOverwrite = newForceOverwrite;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__FORCE_OVERWRITE, oldForceOverwrite, forceOverwrite));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isOrganizeImports()
    {
        return organizeImports;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOrganizeImports(boolean newOrganizeImports)
    {
        boolean oldOrganizeImports = organizeImports;
        organizeImports = newOrganizeImports;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS, oldOrganizeImports, organizeImports));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getCopyrightText()
    {
        return copyrightText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setCopyrightText(String newCopyrightText)
    {
        String oldCopyrightText = copyrightText;
        copyrightText = newCopyrightText;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EditorconfiguratorPackage.EDITOR_CONFIGURATION__COPYRIGHT_TEXT, oldCopyrightText, copyrightText));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<EditorAction> getActions()
    {
        if (actions == null)
        {
            actions = new EObjectContainmentEList<EditorAction>(EditorAction.class, this, EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS);
        }
        return actions;
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
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS:
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
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                return getName();
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                return getProjectName();
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                if (resolve)
                    return getGenModel();
                return basicGetGenModel();
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                return getPluginVersion();
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROVIDER:
                return getProvider();
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__FORCE_OVERWRITE:
                return isForceOverwrite() ? Boolean.TRUE : Boolean.FALSE;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS:
                return isOrganizeImports() ? Boolean.TRUE : Boolean.FALSE;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__COPYRIGHT_TEXT:
                return getCopyrightText();
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS:
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
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                setName((String) newValue);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                setProjectName((String) newValue);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                setGenModel((GenModel) newValue);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                setPluginVersion((String) newValue);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROVIDER:
                setProvider((String) newValue);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__FORCE_OVERWRITE:
                setForceOverwrite(((Boolean) newValue).booleanValue());
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS:
                setOrganizeImports(((Boolean) newValue).booleanValue());
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__COPYRIGHT_TEXT:
                setCopyrightText((String) newValue);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS:
                getActions().clear();
                getActions().addAll((Collection< ? extends EditorAction>) newValue);
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
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                setProjectName(PROJECT_NAME_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                setGenModel((GenModel) null);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                setPluginVersion(PLUGIN_VERSION_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROVIDER:
                setProvider(PROVIDER_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__FORCE_OVERWRITE:
                setForceOverwrite(FORCE_OVERWRITE_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS:
                setOrganizeImports(ORGANIZE_IMPORTS_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__COPYRIGHT_TEXT:
                setCopyrightText(COPYRIGHT_TEXT_EDEFAULT);
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS:
                getActions().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> If the plugin version has not been changed, this is valid too :
     * <code>return pluginVersion != null;</code> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
                return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
                return genModel != null;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                return PLUGIN_VERSION_EDEFAULT == null ? pluginVersion != null : !PLUGIN_VERSION_EDEFAULT.equals(pluginVersion);
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROVIDER:
                return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__FORCE_OVERWRITE:
                return forceOverwrite != FORCE_OVERWRITE_EDEFAULT;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS:
                return organizeImports != ORGANIZE_IMPORTS_EDEFAULT;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__COPYRIGHT_TEXT:
                return COPYRIGHT_TEXT_EDEFAULT == null ? copyrightText != null : !COPYRIGHT_TEXT_EDEFAULT.equals(copyrightText);
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS:
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
        result.append(" (name: ");
        result.append(name);
        result.append(", projectName: ");
        result.append(projectName);
        result.append(", pluginVersion: ");
        result.append(pluginVersion);
        result.append(", provider: ");
        result.append(provider);
        result.append(", forceOverwrite: ");
        result.append(forceOverwrite);
        result.append(", organizeImports: ");
        result.append(organizeImports);
        result.append(", copyrightText: ");
        result.append(copyrightText);
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
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getJavaCopyrightText()
     */
    public String getJavaCopyrightText()
    {
        final String LINE_SEPARATOR = String.valueOf((char) Character.LETTER_NUMBER);

        String start = "/*******************************************************************************";
        String end = " ******************************************************************************/";
        String result = "";

        String[] copyrightLines = getCopyrightText() == null ? new String[] {"No CopyrightText Defined in the configurator file."} : getCopyrightText().split(LINE_SEPARATOR);

        result = result.concat(start).concat(LINE_SEPARATOR);
        for (int cpt = 0; cpt < copyrightLines.length; cpt++)
        {
            result = result.concat(" * ").concat(copyrightLines[cpt]).concat(LINE_SEPARATOR);
        }
        result = result.concat(end);

        return result;
    }

    // -------------------------------------------------------------
    // These methods ensure compatibility with the old configurator
    // -------------------------------------------------------------

    /**
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getPrefix()
     */
    public String getPrefix()
    {
        return ((GenPackage) getGenModel().getGenPackages().get(0)).getPrefix();
    }

    /**
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getExtension()
     */
    public String getExtension()
    {
        return ((GenPackage) getGenModel().getGenPackages().get(0)).getPrefix().toLowerCase();
    }

    /**
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getExtensionDiagram()
     */
    public String getExtensionDiagram()
    {
        return getExtension().concat("di");
    }

    /**
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getEditorId()
     */
    public String getEditorId()
    {
        return getProjectName().concat(".editor.").concat(getPrefix()).concat("Editor");
    }

} // EditorConfigurationImpl
