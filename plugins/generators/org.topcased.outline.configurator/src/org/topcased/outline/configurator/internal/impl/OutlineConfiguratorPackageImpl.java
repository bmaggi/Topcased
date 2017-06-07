/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorPackageImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.topcased.outline.configurator.ChildActionType;
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.Menu;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.MenuItem;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorFactory;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OutlineConfiguratorPackageImpl extends EPackageImpl implements OutlineConfiguratorPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass outlineConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass createChildMenuConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass createChildActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass menuEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass menuItemEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass menuGroupEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum childActionTypeEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OutlineConfiguratorPackageImpl()
    {
        super(eNS_URI, OutlineConfiguratorFactory.eINSTANCE);
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
    public static OutlineConfiguratorPackage init()
    {
        if (isInited)
            return (OutlineConfiguratorPackage) EPackage.Registry.INSTANCE.getEPackage(OutlineConfiguratorPackage.eNS_URI);

        // Obtain or create and register package
        OutlineConfiguratorPackageImpl theOutlineConfiguratorPackage = (OutlineConfiguratorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof OutlineConfiguratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
                : new OutlineConfiguratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        GenModelPackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theOutlineConfiguratorPackage.createPackageContents();

        // Initialize created meta-data
        theOutlineConfiguratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOutlineConfiguratorPackage.freeze();

        return theOutlineConfiguratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOutlineConfiguration()
    {
        return outlineConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOutlineConfiguration_CreateChild()
    {
        return (EReference) outlineConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getOutlineConfiguration_Name()
    {
        return (EAttribute) outlineConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getOutlineConfiguration_ProjectName()
    {
        return (EAttribute) outlineConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getOutlineConfiguration_GenPackage()
    {
        return (EReference) outlineConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getOutlineConfiguration_Package()
    {
        return (EAttribute) outlineConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getOutlineConfiguration_PluginClassName()
    {
        return (EAttribute) outlineConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCreateChildMenuConfiguration()
    {
        return createChildMenuConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCreateChildMenuConfiguration_Items()
    {
        return (EReference) createChildMenuConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getCreateChildMenuConfiguration_ClassName()
    {
        return (EAttribute) createChildMenuConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCreateChildAction()
    {
        return createChildActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCreateChildAction_Class()
    {
        return (EReference) createChildActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getCreateChildAction_Type()
    {
        return (EAttribute) createChildActionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMenu()
    {
        return menuEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getMenu_Name()
    {
        return (EAttribute) menuEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMenuItem()
    {
        return menuItemEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getMenuItem_Parent()
    {
        return (EReference) menuItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMenuGroup()
    {
        return menuGroupEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getMenuGroup_Id()
    {
        return (EAttribute) menuGroupEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getMenuGroup_Items()
    {
        return (EReference) menuGroupEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getChildActionType()
    {
        return childActionTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguratorFactory getOutlineConfiguratorFactory()
    {
        return (OutlineConfiguratorFactory) getEFactoryInstance();
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
        outlineConfigurationEClass = createEClass(OUTLINE_CONFIGURATION);
        createEReference(outlineConfigurationEClass, OUTLINE_CONFIGURATION__CREATE_CHILD);
        createEAttribute(outlineConfigurationEClass, OUTLINE_CONFIGURATION__NAME);
        createEAttribute(outlineConfigurationEClass, OUTLINE_CONFIGURATION__PROJECT_NAME);
        createEReference(outlineConfigurationEClass, OUTLINE_CONFIGURATION__GEN_PACKAGE);
        createEAttribute(outlineConfigurationEClass, OUTLINE_CONFIGURATION__PACKAGE);
        createEAttribute(outlineConfigurationEClass, OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME);

        createChildMenuConfigurationEClass = createEClass(CREATE_CHILD_MENU_CONFIGURATION);
        createEReference(createChildMenuConfigurationEClass, CREATE_CHILD_MENU_CONFIGURATION__ITEMS);
        createEAttribute(createChildMenuConfigurationEClass, CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME);

        createChildActionEClass = createEClass(CREATE_CHILD_ACTION);
        createEReference(createChildActionEClass, CREATE_CHILD_ACTION__CLASS);
        createEAttribute(createChildActionEClass, CREATE_CHILD_ACTION__TYPE);

        menuEClass = createEClass(MENU);
        createEAttribute(menuEClass, MENU__NAME);

        menuItemEClass = createEClass(MENU_ITEM);
        createEReference(menuItemEClass, MENU_ITEM__PARENT);

        menuGroupEClass = createEClass(MENU_GROUP);
        createEAttribute(menuGroupEClass, MENU_GROUP__ID);
        createEReference(menuGroupEClass, MENU_GROUP__ITEMS);

        // Create enums
        childActionTypeEEnum = createEEnum(CHILD_ACTION_TYPE);
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
        EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Add supertypes to classes
        createChildActionEClass.getESuperTypes().add(this.getMenuItem());
        menuEClass.getESuperTypes().add(this.getMenuGroup());
        menuGroupEClass.getESuperTypes().add(this.getMenuItem());

        // Initialize classes and features; add operations and parameters
        initEClass(outlineConfigurationEClass, OutlineConfiguration.class, "OutlineConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(
                getOutlineConfiguration_CreateChild(),
                this.getCreateChildMenuConfiguration(),
                null,
                "createChild", null, 0, 1, OutlineConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getOutlineConfiguration_Name(), ecorePackage.getEString(),
                "name", null, 0, 1, OutlineConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getOutlineConfiguration_ProjectName(), ecorePackage.getEString(),
                "projectName", null, 1, 1, OutlineConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOutlineConfiguration_GenPackage(), theGenModelPackage.getGenPackage(), null,
                "genPackage", null, 1, 1, OutlineConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getOutlineConfiguration_Package(), theEcorePackage.getEString(),
                "package", null, 0, 1, OutlineConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getOutlineConfiguration_PluginClassName(), ecorePackage.getEString(),
                "pluginClassName", null, 0, 1, OutlineConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(createChildMenuConfigurationEClass, CreateChildMenuConfiguration.class, "CreateChildMenuConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(
                getCreateChildMenuConfiguration_Items(),
                this.getMenuItem(),
                null,
                "items", null, 0, -1, CreateChildMenuConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCreateChildMenuConfiguration_ClassName(), theEcorePackage.getEString(),
                "className", "CreateChildMenu", 0, 1, CreateChildMenuConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(createChildActionEClass, CreateChildAction.class, "CreateChildAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCreateChildAction_Class(), theGenModelPackage.getGenClass(), null,
                "class", null, 1, 1, CreateChildAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCreateChildAction_Type(), this.getChildActionType(),
                "type", null, 0, 1, CreateChildAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(menuEClass, Menu.class, "Menu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMenu_Name(), ecorePackage.getEString(),
                "name", null, 1, 1, Menu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(menuItemEClass, MenuItem.class, "MenuItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMenuItem_Parent(), this.getMenuGroup(), this.getMenuGroup_Items(),
                "parent", null, 0, 1, MenuItem.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(menuGroupEClass, MenuGroup.class, "MenuGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getMenuGroup_Id(), ecorePackage.getEString(),
                "id", null, 1, 1, MenuGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMenuGroup_Items(), this.getMenuItem(), this.getMenuItem_Parent(),
                "items", null, 0, -1, MenuGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(childActionTypeEEnum, ChildActionType.class, "ChildActionType"); //$NON-NLS-1$
        addEEnumLiteral(childActionTypeEEnum, ChildActionType.EXACT_LITERAL);
        addEEnumLiteral(childActionTypeEEnum, ChildActionType.HIERACHICAL_LITERAL);

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
        String source = "http://www.topcased.org/documentation"; //$NON-NLS-1$		
        addAnnotation(outlineConfigurationEClass, source, new String[] {
                "documentation", "The outline configuration contains all necessary information in order to generate customize outline code. This is the root model object." //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(getOutlineConfiguration_Package(), source, new String[] {
                "documentation", "The package in which the \'Create child\' menu is generated. If empty, it is generated in the root package." //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(createChildMenuConfigurationEClass, source, new String[] {"documentation", "The create child menu configuration contains the \'Create child\' actions to customize" //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(getCreateChildMenuConfiguration_ClassName(), source, new String[] {"documentation", "The class name that is generated. By default, the name is \'CreateChildMenu\'." //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(createChildActionEClass, source, new String[] {"documentation", "A CreateChildAction represents an action to create a given typed child." //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(menuEClass, source, new String[] {"documentation", "A Menu represents a JFace menu manager." //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(menuItemEClass, source, new String[] {"documentation", "A MenuItem represents a JFace contribution item." //$NON-NLS-1$ //$NON-NLS-2$
        });
        addAnnotation(menuGroupEClass, source, new String[] {"documentation", "A MenuGroup represents a JFace separator group." //$NON-NLS-1$ //$NON-NLS-2$
        });
    }

} // OutlineConfiguratorPackageImpl
