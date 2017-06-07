/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertiesConfiguratorPackageImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.topcased.properties.configurator.AbstractSection;
import org.topcased.properties.configurator.AdvancedSection;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.MultipleFeatureSection;
import org.topcased.properties.configurator.PropertiesConfiguratorFactory;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.TabbedView;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PropertiesConfiguratorPackageImpl extends EPackageImpl implements PropertiesConfiguratorPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass tabbedViewEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass tabEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractSectionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass categoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass singleFeatureSectionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass multipleFeatureSectionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass advancedSectionEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PropertiesConfiguratorPackageImpl()
    {
        super(eNS_URI, PropertiesConfiguratorFactory.eINSTANCE);
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
    public static PropertiesConfiguratorPackage init()
    {
        if (isInited)
            return (PropertiesConfiguratorPackage) EPackage.Registry.INSTANCE.getEPackage(PropertiesConfiguratorPackage.eNS_URI);

        // Obtain or create and register package
        PropertiesConfiguratorPackageImpl thePropertiesConfiguratorPackage = (PropertiesConfiguratorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PropertiesConfiguratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
                : new PropertiesConfiguratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();
        GenModelPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        thePropertiesConfiguratorPackage.createPackageContents();

        // Initialize created meta-data
        thePropertiesConfiguratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePropertiesConfiguratorPackage.freeze();

        return thePropertiesConfiguratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTabbedView()
    {
        return tabbedViewEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTabbedView_ProjectName()
    {
        return (EAttribute) tabbedViewEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTabbedView_Id()
    {
        return (EAttribute) tabbedViewEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getTabbedView_Categories()
    {
        return (EReference) tabbedViewEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTabbedView_Name()
    {
        return (EAttribute) tabbedViewEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getTabbedView_GenModel()
    {
        return (EReference) tabbedViewEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTabbedView_BasePackage()
    {
        return (EAttribute) tabbedViewEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTab()
    {
        return tabEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTab_Id()
    {
        return (EAttribute) tabEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTab_Label()
    {
        return (EAttribute) tabEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getTab_Sections()
    {
        return (EReference) tabEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getTab_Category()
    {
        return (EReference) tabEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getTab_AfterTab()
    {
        return (EReference) tabEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getTab_Indented()
    {
        return (EAttribute) tabEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAbstractSection()
    {
        return abstractSectionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractSection_Id()
    {
        return (EAttribute) abstractSectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAbstractSection_Tab()
    {
        return (EReference) abstractSectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAbstractSection_AfterSection()
    {
        return (EReference) abstractSectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractSection_Label()
    {
        return (EAttribute) abstractSectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCategory()
    {
        return categoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getCategory_Name()
    {
        return (EAttribute) categoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCategory_Tabs()
    {
        return (EReference) categoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCategory_Parent()
    {
        return (EReference) categoryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSingleFeatureSection()
    {
        return singleFeatureSectionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSingleFeatureSection_Feature()
    {
        return (EReference) singleFeatureSectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getSingleFeatureSection_Multiline()
    {
        return (EAttribute) singleFeatureSectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMultipleFeatureSection()
    {
        return multipleFeatureSectionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getMultipleFeatureSection_Features()
    {
        return (EReference) multipleFeatureSectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAdvancedSection()
    {
        return advancedSectionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAdvancedSection_Input()
    {
        return (EReference) advancedSectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PropertiesConfiguratorFactory getPropertiesConfiguratorFactory()
    {
        return (PropertiesConfiguratorFactory) getEFactoryInstance();
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
        tabbedViewEClass = createEClass(TABBED_VIEW);
        createEAttribute(tabbedViewEClass, TABBED_VIEW__PROJECT_NAME);
        createEAttribute(tabbedViewEClass, TABBED_VIEW__ID);
        createEReference(tabbedViewEClass, TABBED_VIEW__CATEGORIES);
        createEAttribute(tabbedViewEClass, TABBED_VIEW__NAME);
        createEReference(tabbedViewEClass, TABBED_VIEW__GEN_MODEL);
        createEAttribute(tabbedViewEClass, TABBED_VIEW__BASE_PACKAGE);

        tabEClass = createEClass(TAB);
        createEAttribute(tabEClass, TAB__ID);
        createEAttribute(tabEClass, TAB__LABEL);
        createEReference(tabEClass, TAB__SECTIONS);
        createEReference(tabEClass, TAB__CATEGORY);
        createEReference(tabEClass, TAB__AFTER_TAB);
        createEAttribute(tabEClass, TAB__INDENTED);

        abstractSectionEClass = createEClass(ABSTRACT_SECTION);
        createEAttribute(abstractSectionEClass, ABSTRACT_SECTION__ID);
        createEReference(abstractSectionEClass, ABSTRACT_SECTION__TAB);
        createEReference(abstractSectionEClass, ABSTRACT_SECTION__AFTER_SECTION);
        createEAttribute(abstractSectionEClass, ABSTRACT_SECTION__LABEL);

        categoryEClass = createEClass(CATEGORY);
        createEAttribute(categoryEClass, CATEGORY__NAME);
        createEReference(categoryEClass, CATEGORY__TABS);
        createEReference(categoryEClass, CATEGORY__PARENT);

        singleFeatureSectionEClass = createEClass(SINGLE_FEATURE_SECTION);
        createEReference(singleFeatureSectionEClass, SINGLE_FEATURE_SECTION__FEATURE);
        createEAttribute(singleFeatureSectionEClass, SINGLE_FEATURE_SECTION__MULTILINE);

        multipleFeatureSectionEClass = createEClass(MULTIPLE_FEATURE_SECTION);
        createEReference(multipleFeatureSectionEClass, MULTIPLE_FEATURE_SECTION__FEATURES);

        advancedSectionEClass = createEClass(ADVANCED_SECTION);
        createEReference(advancedSectionEClass, ADVANCED_SECTION__INPUT);
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

        // Add supertypes to classes
        singleFeatureSectionEClass.getESuperTypes().add(this.getAbstractSection());
        multipleFeatureSectionEClass.getESuperTypes().add(this.getAbstractSection());
        advancedSectionEClass.getESuperTypes().add(this.getAbstractSection());

        // Initialize classes and features; add operations and parameters
        initEClass(tabbedViewEClass, TabbedView.class, "TabbedView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTabbedView_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1, TabbedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTabbedView_Id(), ecorePackage.getEString(), "id", null, 1, 1, TabbedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getTabbedView_Categories(), this.getCategory(), this.getCategory_Parent(), "categories", null, 1, -1, TabbedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTabbedView_Name(), ecorePackage.getEString(), "name", null, 1, 1, TabbedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getTabbedView_GenModel(), theGenModelPackage.getGenModel(), null, "genModel", null, 0, 1, TabbedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTabbedView_BasePackage(), ecorePackage.getEString(), "basePackage", null, 0, 1, TabbedView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(tabbedViewEClass, ecorePackage.getEString(), "getProjectNameUnspaced", 0, 1);

        addEOperation(tabbedViewEClass, ecorePackage.getEString(), "getIdUnspaced", 0, 1);

        EOperation op = addEOperation(tabbedViewEClass, ecorePackage.getEString(), "replaceSpaces", 0, 1);
        addEParameter(op, ecorePackage.getEString(), "toReplace", 1, 1);

        initEClass(tabEClass, Tab.class, "Tab", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTab_Id(), ecorePackage.getEString(), "id", "", 1, 1, Tab.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getTab_Label(), ecorePackage.getEString(), "label", null, 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getTab_Sections(), this.getAbstractSection(), this.getAbstractSection_Tab(), "sections", null, 0, -1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTab_Category(), this.getCategory(), this.getCategory_Tabs(), "category", null, 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTab_AfterTab(), this.getTab(), null, "afterTab", null, 0, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTab_Indented(), ecorePackage.getEBoolean(), "indented", null, 1, 1, Tab.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        initEClass(abstractSectionEClass, AbstractSection.class, "AbstractSection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbstractSection_Id(), ecorePackage.getEString(), "id", "", 1, 1, AbstractSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractSection_Tab(), this.getTab(), this.getTab_Sections(), "tab", null, 1, 1, AbstractSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractSection_AfterSection(), this.getAbstractSection(), null, "afterSection", null, 0, 1, AbstractSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractSection_Label(), ecorePackage.getEString(), "label", null, 0, 1, AbstractSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(abstractSectionEClass, ecorePackage.getEString(), "getClassName", 0, 1);

        initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getCategory_Tabs(), this.getTab(), this.getTab_Category(), "tabs", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCategory_Parent(), this.getTabbedView(), this.getTabbedView_Categories(), "parent", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(singleFeatureSectionEClass, SingleFeatureSection.class, "SingleFeatureSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSingleFeatureSection_Feature(), theGenModelPackage.getGenFeature(), null, "feature", null, 1, 1, SingleFeatureSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSingleFeatureSection_Multiline(), ecorePackage.getEBoolean(), "multiline", "false", 0, 1, SingleFeatureSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(multipleFeatureSectionEClass, MultipleFeatureSection.class, "MultipleFeatureSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMultipleFeatureSection_Features(), theGenModelPackage.getGenFeature(), null, "features", null, 1, -1, MultipleFeatureSection.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(advancedSectionEClass, AdvancedSection.class, "AdvancedSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAdvancedSection_Input(), theGenModelPackage.getGenClass(), null, "input", null, 1, -1, AdvancedSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // PropertiesConfiguratorPackageImpl
