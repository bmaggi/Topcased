/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertiesConfiguratorPackage.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

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
 * @see org.topcased.properties.configurator.PropertiesConfiguratorFactory
 * @model kind="package"
 * @generated
 */
public interface PropertiesConfiguratorPackage extends EPackage
{
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "configurator";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/PropertiesViewConfiguration/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "propertiesconfigurator";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    PropertiesConfiguratorPackage eINSTANCE = org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl <em>Tabbed View</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.TabbedViewImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getTabbedView()
     * @generated
     */
    int TABBED_VIEW = 0;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW__PROJECT_NAME = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW__ID = 1;

    /**
     * The feature id for the '<em><b>Categories</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW__CATEGORIES = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW__NAME = 3;

    /**
     * The feature id for the '<em><b>Gen Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW__GEN_MODEL = 4;

    /**
     * The feature id for the '<em><b>Base Package</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW__BASE_PACKAGE = 5;

    /**
     * The number of structural features of the '<em>Tabbed View</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TABBED_VIEW_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.TabImpl <em>Tab</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.TabImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getTab()
     * @generated
     */
    int TAB = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB__ID = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB__LABEL = 1;

    /**
     * The feature id for the '<em><b>Sections</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB__SECTIONS = 2;

    /**
     * The feature id for the '<em><b>Category</b></em>' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB__CATEGORY = 3;

    /**
     * The feature id for the '<em><b>After Tab</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB__AFTER_TAB = 4;

    /**
     * The feature id for the '<em><b>Indented</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB__INDENTED = 5;

    /**
     * The number of structural features of the '<em>Tab</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TAB_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.AbstractSectionImpl <em>Abstract Section</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.AbstractSectionImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getAbstractSection()
     * @generated
     */
    int ABSTRACT_SECTION = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_SECTION__ID = 0;

    /**
     * The feature id for the '<em><b>Tab</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_SECTION__TAB = 1;

    /**
     * The feature id for the '<em><b>After Section</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_SECTION__AFTER_SECTION = 2;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_SECTION__LABEL = 3;

    /**
     * The number of structural features of the '<em>Abstract Section</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_SECTION_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.CategoryImpl <em>Category</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.CategoryImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getCategory()
     * @generated
     */
    int CATEGORY = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATEGORY__NAME = 0;

    /**
     * The feature id for the '<em><b>Tabs</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATEGORY__TABS = 1;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CATEGORY__PARENT = 2;

    /**
     * The number of structural features of the '<em>Category</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int CATEGORY_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.SingleFeatureSectionImpl <em>Single Feature Section</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.SingleFeatureSectionImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getSingleFeatureSection()
     * @generated
     */
    int SINGLE_FEATURE_SECTION = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION__ID = ABSTRACT_SECTION__ID;

    /**
     * The feature id for the '<em><b>Tab</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION__TAB = ABSTRACT_SECTION__TAB;

    /**
     * The feature id for the '<em><b>After Section</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION__AFTER_SECTION = ABSTRACT_SECTION__AFTER_SECTION;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION__LABEL = ABSTRACT_SECTION__LABEL;

    /**
     * The feature id for the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION__FEATURE = ABSTRACT_SECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Multiline</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION__MULTILINE = ABSTRACT_SECTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Single Feature Section</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SINGLE_FEATURE_SECTION_FEATURE_COUNT = ABSTRACT_SECTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.MultipleFeatureSectionImpl <em>Multiple Feature Section</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.MultipleFeatureSectionImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getMultipleFeatureSection()
     * @generated
     */
    int MULTIPLE_FEATURE_SECTION = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MULTIPLE_FEATURE_SECTION__ID = ABSTRACT_SECTION__ID;

    /**
     * The feature id for the '<em><b>Tab</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MULTIPLE_FEATURE_SECTION__TAB = ABSTRACT_SECTION__TAB;

    /**
     * The feature id for the '<em><b>After Section</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MULTIPLE_FEATURE_SECTION__AFTER_SECTION = ABSTRACT_SECTION__AFTER_SECTION;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MULTIPLE_FEATURE_SECTION__LABEL = ABSTRACT_SECTION__LABEL;

    /**
     * The feature id for the '<em><b>Features</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MULTIPLE_FEATURE_SECTION__FEATURES = ABSTRACT_SECTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Multiple Feature Section</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MULTIPLE_FEATURE_SECTION_FEATURE_COUNT = ABSTRACT_SECTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.properties.configurator.internal.impl.AdvancedSectionImpl <em>Advanced Section</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.properties.configurator.internal.impl.AdvancedSectionImpl
     * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getAdvancedSection()
     * @generated
     */
    int ADVANCED_SECTION = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADVANCED_SECTION__ID = ABSTRACT_SECTION__ID;

    /**
     * The feature id for the '<em><b>Tab</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ADVANCED_SECTION__TAB = ABSTRACT_SECTION__TAB;

    /**
     * The feature id for the '<em><b>After Section</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ADVANCED_SECTION__AFTER_SECTION = ABSTRACT_SECTION__AFTER_SECTION;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADVANCED_SECTION__LABEL = ABSTRACT_SECTION__LABEL;

    /**
     * The feature id for the '<em><b>Input</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADVANCED_SECTION__INPUT = ABSTRACT_SECTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Advanced Section</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADVANCED_SECTION_FEATURE_COUNT = ABSTRACT_SECTION_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.TabbedView <em>Tabbed View</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tabbed View</em>'.
     * @see org.topcased.properties.configurator.TabbedView
     * @generated
     */
    EClass getTabbedView();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.TabbedView#getProjectName <em>Project Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Project Name</em>'.
     * @see org.topcased.properties.configurator.TabbedView#getProjectName()
     * @see #getTabbedView()
     * @generated
     */
    EAttribute getTabbedView_ProjectName();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.TabbedView#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.properties.configurator.TabbedView#getId()
     * @see #getTabbedView()
     * @generated
     */
    EAttribute getTabbedView_Id();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.properties.configurator.TabbedView#getCategories <em>Categories</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Categories</em>'.
     * @see org.topcased.properties.configurator.TabbedView#getCategories()
     * @see #getTabbedView()
     * @generated
     */
    EReference getTabbedView_Categories();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.TabbedView#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.properties.configurator.TabbedView#getName()
     * @see #getTabbedView()
     * @generated
     */
    EAttribute getTabbedView_Name();

    /**
     * Returns the meta object for the reference '{@link org.topcased.properties.configurator.TabbedView#getGenModel <em>Gen Model</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Gen Model</em>'.
     * @see org.topcased.properties.configurator.TabbedView#getGenModel()
     * @see #getTabbedView()
     * @generated
     */
    EReference getTabbedView_GenModel();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.TabbedView#getBasePackage <em>Base Package</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Base Package</em>'.
     * @see org.topcased.properties.configurator.TabbedView#getBasePackage()
     * @see #getTabbedView()
     * @generated
     */
    EAttribute getTabbedView_BasePackage();

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.Tab <em>Tab</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tab</em>'.
     * @see org.topcased.properties.configurator.Tab
     * @generated
     */
    EClass getTab();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.Tab#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.properties.configurator.Tab#getId()
     * @see #getTab()
     * @generated
     */
    EAttribute getTab_Id();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.Tab#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.topcased.properties.configurator.Tab#getLabel()
     * @see #getTab()
     * @generated
     */
    EAttribute getTab_Label();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.properties.configurator.Tab#getSections <em>Sections</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Sections</em>'.
     * @see org.topcased.properties.configurator.Tab#getSections()
     * @see #getTab()
     * @generated
     */
    EReference getTab_Sections();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.properties.configurator.Tab#getCategory <em>Category</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Category</em>'.
     * @see org.topcased.properties.configurator.Tab#getCategory()
     * @see #getTab()
     * @generated
     */
    EReference getTab_Category();

    /**
     * Returns the meta object for the reference '{@link org.topcased.properties.configurator.Tab#getAfterTab <em>After Tab</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>After Tab</em>'.
     * @see org.topcased.properties.configurator.Tab#getAfterTab()
     * @see #getTab()
     * @generated
     */
    EReference getTab_AfterTab();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.Tab#isIndented <em>Indented</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Indented</em>'.
     * @see org.topcased.properties.configurator.Tab#isIndented()
     * @see #getTab()
     * @generated
     */
    EAttribute getTab_Indented();

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.AbstractSection <em>Abstract Section</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Abstract Section</em>'.
     * @see org.topcased.properties.configurator.AbstractSection
     * @generated
     */
    EClass getAbstractSection();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.AbstractSection#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.properties.configurator.AbstractSection#getId()
     * @see #getAbstractSection()
     * @generated
     */
    EAttribute getAbstractSection_Id();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.properties.configurator.AbstractSection#getTab <em>Tab</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Tab</em>'.
     * @see org.topcased.properties.configurator.AbstractSection#getTab()
     * @see #getAbstractSection()
     * @generated
     */
    EReference getAbstractSection_Tab();

    /**
     * Returns the meta object for the reference '{@link org.topcased.properties.configurator.AbstractSection#getAfterSection <em>After Section</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>After Section</em>'.
     * @see org.topcased.properties.configurator.AbstractSection#getAfterSection()
     * @see #getAbstractSection()
     * @generated
     */
    EReference getAbstractSection_AfterSection();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.AbstractSection#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.topcased.properties.configurator.AbstractSection#getLabel()
     * @see #getAbstractSection()
     * @generated
     */
    EAttribute getAbstractSection_Label();

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.Category <em>Category</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Category</em>'.
     * @see org.topcased.properties.configurator.Category
     * @generated
     */
    EClass getCategory();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.Category#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.properties.configurator.Category#getName()
     * @see #getCategory()
     * @generated
     */
    EAttribute getCategory_Name();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.properties.configurator.Category#getTabs <em>Tabs</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Tabs</em>'.
     * @see org.topcased.properties.configurator.Category#getTabs()
     * @see #getCategory()
     * @generated
     */
    EReference getCategory_Tabs();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.properties.configurator.Category#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see org.topcased.properties.configurator.Category#getParent()
     * @see #getCategory()
     * @generated
     */
    EReference getCategory_Parent();

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.SingleFeatureSection <em>Single Feature Section</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Single Feature Section</em>'.
     * @see org.topcased.properties.configurator.SingleFeatureSection
     * @generated
     */
    EClass getSingleFeatureSection();

    /**
     * Returns the meta object for the reference '{@link org.topcased.properties.configurator.SingleFeatureSection#getFeature <em>Feature</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Feature</em>'.
     * @see org.topcased.properties.configurator.SingleFeatureSection#getFeature()
     * @see #getSingleFeatureSection()
     * @generated
     */
    EReference getSingleFeatureSection_Feature();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.properties.configurator.SingleFeatureSection#isMultiline <em>Multiline</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Multiline</em>'.
     * @see org.topcased.properties.configurator.SingleFeatureSection#isMultiline()
     * @see #getSingleFeatureSection()
     * @generated
     */
    EAttribute getSingleFeatureSection_Multiline();

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.MultipleFeatureSection <em>Multiple Feature Section</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Multiple Feature Section</em>'.
     * @see org.topcased.properties.configurator.MultipleFeatureSection
     * @generated
     */
    EClass getMultipleFeatureSection();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.properties.configurator.MultipleFeatureSection#getFeatures <em>Features</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Features</em>'.
     * @see org.topcased.properties.configurator.MultipleFeatureSection#getFeatures()
     * @see #getMultipleFeatureSection()
     * @generated
     */
    EReference getMultipleFeatureSection_Features();

    /**
     * Returns the meta object for class '{@link org.topcased.properties.configurator.AdvancedSection <em>Advanced Section</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Advanced Section</em>'.
     * @see org.topcased.properties.configurator.AdvancedSection
     * @generated
     */
    EClass getAdvancedSection();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.properties.configurator.AdvancedSection#getInput <em>Input</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Input</em>'.
     * @see org.topcased.properties.configurator.AdvancedSection#getInput()
     * @see #getAdvancedSection()
     * @generated
     */
    EReference getAdvancedSection_Input();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PropertiesConfiguratorFactory getPropertiesConfiguratorFactory();

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
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.TabbedViewImpl <em>Tabbed View</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.TabbedViewImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getTabbedView()
         * @generated
         */
        EClass TABBED_VIEW = eINSTANCE.getTabbedView();

        /**
         * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TABBED_VIEW__PROJECT_NAME = eINSTANCE.getTabbedView_ProjectName();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute TABBED_VIEW__ID = eINSTANCE.getTabbedView_Id();

        /**
         * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TABBED_VIEW__CATEGORIES = eINSTANCE.getTabbedView_Categories();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute TABBED_VIEW__NAME = eINSTANCE.getTabbedView_Name();

        /**
         * The meta object literal for the '<em><b>Gen Model</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TABBED_VIEW__GEN_MODEL = eINSTANCE.getTabbedView_GenModel();

        /**
         * The meta object literal for the '<em><b>Base Package</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TABBED_VIEW__BASE_PACKAGE = eINSTANCE.getTabbedView_BasePackage();

        /**
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.TabImpl <em>Tab</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.TabImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getTab()
         * @generated
         */
        EClass TAB = eINSTANCE.getTab();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute TAB__ID = eINSTANCE.getTab_Id();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute TAB__LABEL = eINSTANCE.getTab_Label();

        /**
         * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TAB__SECTIONS = eINSTANCE.getTab_Sections();

        /**
         * The meta object literal for the '<em><b>Category</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TAB__CATEGORY = eINSTANCE.getTab_Category();

        /**
         * The meta object literal for the '<em><b>After Tab</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TAB__AFTER_TAB = eINSTANCE.getTab_AfterTab();

        /**
         * The meta object literal for the '<em><b>Indented</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute TAB__INDENTED = eINSTANCE.getTab_Indented();

        /**
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.AbstractSectionImpl <em>Abstract Section</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.AbstractSectionImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getAbstractSection()
         * @generated
         */
        EClass ABSTRACT_SECTION = eINSTANCE.getAbstractSection();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_SECTION__ID = eINSTANCE.getAbstractSection_Id();

        /**
         * The meta object literal for the '<em><b>Tab</b></em>' container reference feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ABSTRACT_SECTION__TAB = eINSTANCE.getAbstractSection_Tab();

        /**
         * The meta object literal for the '<em><b>After Section</b></em>' reference feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ABSTRACT_SECTION__AFTER_SECTION = eINSTANCE.getAbstractSection_AfterSection();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_SECTION__LABEL = eINSTANCE.getAbstractSection_Label();

        /**
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.CategoryImpl <em>Category</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.CategoryImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getCategory()
         * @generated
         */
        EClass CATEGORY = eINSTANCE.getCategory();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

        /**
         * The meta object literal for the '<em><b>Tabs</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CATEGORY__TABS = eINSTANCE.getCategory_Tabs();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CATEGORY__PARENT = eINSTANCE.getCategory_Parent();

        /**
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.SingleFeatureSectionImpl <em>Single Feature Section</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.SingleFeatureSectionImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getSingleFeatureSection()
         * @generated
         */
        EClass SINGLE_FEATURE_SECTION = eINSTANCE.getSingleFeatureSection();

        /**
         * The meta object literal for the '<em><b>Feature</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SINGLE_FEATURE_SECTION__FEATURE = eINSTANCE.getSingleFeatureSection_Feature();

        /**
         * The meta object literal for the '<em><b>Multiline</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SINGLE_FEATURE_SECTION__MULTILINE = eINSTANCE.getSingleFeatureSection_Multiline();

        /**
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.MultipleFeatureSectionImpl <em>Multiple Feature Section</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.MultipleFeatureSectionImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getMultipleFeatureSection()
         * @generated
         */
        EClass MULTIPLE_FEATURE_SECTION = eINSTANCE.getMultipleFeatureSection();

        /**
         * The meta object literal for the '<em><b>Features</b></em>' reference list feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MULTIPLE_FEATURE_SECTION__FEATURES = eINSTANCE.getMultipleFeatureSection_Features();

        /**
         * The meta object literal for the '{@link org.topcased.properties.configurator.internal.impl.AdvancedSectionImpl <em>Advanced Section</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.properties.configurator.internal.impl.AdvancedSectionImpl
         * @see org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorPackageImpl#getAdvancedSection()
         * @generated
         */
        EClass ADVANCED_SECTION = eINSTANCE.getAdvancedSection();

        /**
         * The meta object literal for the '<em><b>Input</b></em>' reference list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ADVANCED_SECTION__INPUT = eINSTANCE.getAdvancedSection_Input();

    }

} // PropertiesConfiguratorPackage
