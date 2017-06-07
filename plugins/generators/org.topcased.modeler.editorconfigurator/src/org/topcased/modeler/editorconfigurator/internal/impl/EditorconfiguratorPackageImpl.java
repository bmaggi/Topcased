/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorconfiguratorPackageImpl.java,v 1.4 2007/04/18 12:54:46 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.topcased.modeler.editorconfigurator.EditorAction;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorFactory;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorconfiguratorPackageImpl extends EPackageImpl implements EditorconfiguratorPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass editorConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass editorActionEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private EditorconfiguratorPackageImpl()
    {
        super(eNS_URI, EditorconfiguratorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else.
     * This method drives initialization for interdependent packages directly, in parallel with this package, itself.
     * <p>
     * Of this package and its interdependencies, all packages which have not yet been registered by their URI values
     * are first created and registered. The packages are then initialized in two steps: meta-model objects for all of
     * the packages are created before any are initialized, since one package's meta-model objects may refer to those of
     * another.
     * <p>
     * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static EditorconfiguratorPackage init()
    {
        if (isInited)
            return (EditorconfiguratorPackage) EPackage.Registry.INSTANCE.getEPackage(EditorconfiguratorPackage.eNS_URI);

        // Obtain or create and register package
        EditorconfiguratorPackageImpl theEditorconfiguratorPackage = (EditorconfiguratorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EditorconfiguratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
                : new EditorconfiguratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();
        GenModelPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theEditorconfiguratorPackage.createPackageContents();

        // Initialize created meta-data
        theEditorconfiguratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEditorconfiguratorPackage.freeze();

        return theEditorconfiguratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEditorConfiguration()
    {
        return editorConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_Name()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_ProjectName()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEditorConfiguration_GenModel()
    {
        return (EReference) editorConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_PluginVersion()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_Provider()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_ForceOverwrite()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_OrganizeImports()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorConfiguration_CopyrightText()
    {
        return (EAttribute) editorConfigurationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEditorConfiguration_Actions()
    {
        return (EReference) editorConfigurationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEditorAction()
    {
        return editorActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorAction_Prefix()
    {
        return (EAttribute) editorActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorAction_MenuBarGroup()
    {
        return (EAttribute) editorActionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorAction_Label()
    {
        return (EAttribute) editorActionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEditorAction_Icon()
    {
        return (EAttribute) editorActionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorconfiguratorFactory getEditorconfiguratorFactory()
    {
        return (EditorconfiguratorFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
     * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        editorConfigurationEClass = createEClass(EDITOR_CONFIGURATION);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__NAME);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__PROJECT_NAME);
        createEReference(editorConfigurationEClass, EDITOR_CONFIGURATION__GEN_MODEL);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__PLUGIN_VERSION);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__PROVIDER);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__FORCE_OVERWRITE);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__ORGANIZE_IMPORTS);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__COPYRIGHT_TEXT);
        createEReference(editorConfigurationEClass, EDITOR_CONFIGURATION__ACTIONS);

        editorActionEClass = createEClass(EDITOR_ACTION);
        createEAttribute(editorActionEClass, EDITOR_ACTION__PREFIX);
        createEAttribute(editorActionEClass, EDITOR_ACTION__MENU_BAR_GROUP);
        createEAttribute(editorActionEClass, EDITOR_ACTION__LABEL);
        createEAttribute(editorActionEClass, EDITOR_ACTION__ICON);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
     * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents()
    {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        GenModelPackage theGenModelPackage = (GenModelPackage) EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(editorConfigurationEClass, EditorConfiguration.class, "EditorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEditorConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorConfiguration_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEditorConfiguration_GenModel(), theGenModelPackage.getGenModel(), null, "genModel", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorConfiguration_PluginVersion(), ecorePackage.getEString(), "pluginVersion", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorConfiguration_Provider(), ecorePackage.getEString(), "provider", "Topcased", 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorConfiguration_ForceOverwrite(), ecorePackage.getEBoolean(), "forceOverwrite", "false", 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorConfiguration_OrganizeImports(), ecorePackage.getEBoolean(), "organizeImports", "true", 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorConfiguration_CopyrightText(), ecorePackage.getEString(), "copyrightText", null, 0, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEditorConfiguration_Actions(), this.getEditorAction(), null, "actions", null, 0, -1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(editorActionEClass, EditorAction.class, "EditorAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEditorAction_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, EditorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorAction_MenuBarGroup(), ecorePackage.getEString(), "menuBarGroup", null, 1, 1, EditorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorAction_Label(), ecorePackage.getEString(), "label", null, 1, 1, EditorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEditorAction_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, EditorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.topcased.org/documentation
        createDocumentationAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.topcased.org/documentation</b>. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void createDocumentationAnnotations()
    {
        String source = "http://www.topcased.org/documentation";
        addAnnotation(editorConfigurationEClass, source, new String[] {"documentation", "This is the root model object."});
    }

} // EditorconfiguratorPackageImpl
