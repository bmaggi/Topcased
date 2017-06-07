/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorconfiguratorPackage.java,v 1.8 2007/04/18 12:54:48 jako Exp $
 */
package org.topcased.modeler.editorconfigurator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorFactory
 * @model kind="package"
 * @generated
 */
public interface EditorconfiguratorPackage extends EPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "";

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "editorconfigurator";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/editorconfigurator/0.10";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "editorconfigurator";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EditorconfiguratorPackage eINSTANCE = org.topcased.modeler.editorconfigurator.internal.impl.EditorconfiguratorPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl <em>Editor Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl
     * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorconfiguratorPackageImpl#getEditorConfiguration()
     * @generated
     */
    int EDITOR_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__PROJECT_NAME = 1;

    /**
     * The feature id for the '<em><b>Gen Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__GEN_MODEL = 2;

    /**
     * The feature id for the '<em><b>Plugin Version</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__PLUGIN_VERSION = 3;

    /**
     * The feature id for the '<em><b>Provider</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__PROVIDER = 4;

    /**
     * The feature id for the '<em><b>Force Overwrite</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__FORCE_OVERWRITE = 5;

    /**
     * The feature id for the '<em><b>Organize Imports</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__ORGANIZE_IMPORTS = 6;

    /**
     * The feature id for the '<em><b>Copyright Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__COPYRIGHT_TEXT = 7;

    /**
     * The feature id for the '<em><b>Actions</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__ACTIONS = 8;

    /**
     * The number of structural features of the '<em>Editor Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION_FEATURE_COUNT = 9;

    /**
     * The meta object id for the '{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorActionImpl <em>Editor Action</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorActionImpl
     * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorconfiguratorPackageImpl#getEditorAction()
     * @generated
     */
    int EDITOR_ACTION = 1;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_ACTION__PREFIX = 0;

    /**
     * The feature id for the '<em><b>Menu Bar Group</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_ACTION__MENU_BAR_GROUP = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_ACTION__LABEL = 2;

    /**
     * The feature id for the '<em><b>Icon</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_ACTION__ICON = 3;

    /**
     * The number of structural features of the '<em>Editor Action</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDITOR_ACTION_FEATURE_COUNT = 4;

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration <em>Editor Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Editor Configuration</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration
     * @generated
     */
    EClass getEditorConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getName()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_Name();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getProjectName <em>Project Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Project Name</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getProjectName()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_ProjectName();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getGenModel <em>Gen Model</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Gen Model</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getGenModel()
     * @see #getEditorConfiguration()
     * @generated
     */
    EReference getEditorConfiguration_GenModel();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getPluginVersion <em>Plugin Version</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Plugin Version</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getPluginVersion()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_PluginVersion();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getProvider <em>Provider</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Provider</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getProvider()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_Provider();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#isForceOverwrite <em>Force Overwrite</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Force Overwrite</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#isForceOverwrite()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_ForceOverwrite();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#isOrganizeImports <em>Organize Imports</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Organize Imports</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#isOrganizeImports()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_OrganizeImports();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getCopyrightText <em>Copyright Text</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Copyright Text</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getCopyrightText()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_CopyrightText();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getActions <em>Actions</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Actions</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorConfiguration#getActions()
     * @see #getEditorConfiguration()
     * @generated
     */
    EReference getEditorConfiguration_Actions();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.editorconfigurator.EditorAction <em>Editor Action</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Editor Action</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorAction
     * @generated
     */
    EClass getEditorAction();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorAction#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorAction#getPrefix()
     * @see #getEditorAction()
     * @generated
     */
    EAttribute getEditorAction_Prefix();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorAction#getMenuBarGroup <em>Menu Bar Group</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Menu Bar Group</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorAction#getMenuBarGroup()
     * @see #getEditorAction()
     * @generated
     */
    EAttribute getEditorAction_MenuBarGroup();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorAction#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorAction#getLabel()
     * @see #getEditorAction()
     * @generated
     */
    EAttribute getEditorAction_Label();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.editorconfigurator.EditorAction#getIcon <em>Icon</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Icon</em>'.
     * @see org.topcased.modeler.editorconfigurator.EditorAction#getIcon()
     * @see #getEditorAction()
     * @generated
     */
    EAttribute getEditorAction_Icon();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    EditorconfiguratorFactory getEditorconfiguratorFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl <em>Editor Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorConfigurationImpl
         * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorconfiguratorPackageImpl#getEditorConfiguration()
         * @generated
         */
        EClass EDITOR_CONFIGURATION = eINSTANCE.getEditorConfiguration();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__NAME = eINSTANCE.getEditorConfiguration_Name();

        /**
         * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__PROJECT_NAME = eINSTANCE.getEditorConfiguration_ProjectName();

        /**
         * The meta object literal for the '<em><b>Gen Model</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EDITOR_CONFIGURATION__GEN_MODEL = eINSTANCE.getEditorConfiguration_GenModel();

        /**
         * The meta object literal for the '<em><b>Plugin Version</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__PLUGIN_VERSION = eINSTANCE.getEditorConfiguration_PluginVersion();

        /**
         * The meta object literal for the '<em><b>Provider</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__PROVIDER = eINSTANCE.getEditorConfiguration_Provider();

        /**
         * The meta object literal for the '<em><b>Force Overwrite</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__FORCE_OVERWRITE = eINSTANCE.getEditorConfiguration_ForceOverwrite();

        /**
         * The meta object literal for the '<em><b>Organize Imports</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__ORGANIZE_IMPORTS = eINSTANCE.getEditorConfiguration_OrganizeImports();

        /**
         * The meta object literal for the '<em><b>Copyright Text</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_CONFIGURATION__COPYRIGHT_TEXT = eINSTANCE.getEditorConfiguration_CopyrightText();

        /**
         * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EDITOR_CONFIGURATION__ACTIONS = eINSTANCE.getEditorConfiguration_Actions();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.editorconfigurator.internal.impl.EditorActionImpl <em>Editor Action</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorActionImpl
         * @see org.topcased.modeler.editorconfigurator.internal.impl.EditorconfiguratorPackageImpl#getEditorAction()
         * @generated
         */
        EClass EDITOR_ACTION = eINSTANCE.getEditorAction();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_ACTION__PREFIX = eINSTANCE.getEditorAction_Prefix();

        /**
         * The meta object literal for the '<em><b>Menu Bar Group</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_ACTION__MENU_BAR_GROUP = eINSTANCE.getEditorAction_MenuBarGroup();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_ACTION__LABEL = eINSTANCE.getEditorAction_Label();

        /**
         * The meta object literal for the '<em><b>Icon</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDITOR_ACTION__ICON = eINSTANCE.getEditorAction_Icon();

    }

} // EditorconfiguratorPackage
