/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorPackage.java,v 1.3 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.topcased.outline.configurator.OutlineConfiguratorFactory
 * @model kind="package"
 * @generated
 */
public interface OutlineConfiguratorPackage extends EPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "configurator"; //$NON-NLS-1$

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/OutlineConfigurator/1.0"; //$NON-NLS-1$

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "outlineconfigurator"; //$NON-NLS-1$

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    OutlineConfiguratorPackage eINSTANCE = org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl <em>Outline Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getOutlineConfiguration()
     * @generated
     */
    int OUTLINE_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Create Child</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION__CREATE_CHILD = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION__NAME = 1;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION__PROJECT_NAME = 2;

    /**
     * The feature id for the '<em><b>Gen Package</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION__GEN_PACKAGE = 3;

    /**
     * The feature id for the '<em><b>Package</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION__PACKAGE = 4;

    /**
     * The feature id for the '<em><b>Plugin Class Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME = 5;

    /**
     * The number of structural features of the '<em>Outline Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OUTLINE_CONFIGURATION_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.internal.impl.CreateChildMenuConfigurationImpl <em>Create Child Menu Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.internal.impl.CreateChildMenuConfigurationImpl
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getCreateChildMenuConfiguration()
     * @generated
     */
    int CREATE_CHILD_MENU_CONFIGURATION = 1;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_MENU_CONFIGURATION__ITEMS = 0;

    /**
     * The feature id for the '<em><b>Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME = 1;

    /**
     * The number of structural features of the '<em>Create Child Menu Configuration</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_MENU_CONFIGURATION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.internal.impl.MenuItemImpl <em>Menu Item</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.internal.impl.MenuItemImpl
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getMenuItem()
     * @generated
     */
    int MENU_ITEM = 4;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_ITEM__PARENT = 0;

    /**
     * The number of structural features of the '<em>Menu Item</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_ITEM_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.internal.impl.CreateChildActionImpl <em>Create Child Action</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.internal.impl.CreateChildActionImpl
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getCreateChildAction()
     * @generated
     */
    int CREATE_CHILD_ACTION = 2;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_ACTION__PARENT = MENU_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Class</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_ACTION__CLASS = MENU_ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_ACTION__TYPE = MENU_ITEM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Create Child Action</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CREATE_CHILD_ACTION_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.internal.impl.MenuGroupImpl <em>Menu Group</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.internal.impl.MenuGroupImpl
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getMenuGroup()
     * @generated
     */
    int MENU_GROUP = 5;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_GROUP__PARENT = MENU_ITEM__PARENT;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_GROUP__ID = MENU_ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_GROUP__ITEMS = MENU_ITEM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Menu Group</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_GROUP_FEATURE_COUNT = MENU_ITEM_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.internal.impl.MenuImpl <em>Menu</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.internal.impl.MenuImpl
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getMenu()
     * @generated
     */
    int MENU = 3;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU__PARENT = MENU_GROUP__PARENT;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU__ID = MENU_GROUP__ID;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU__ITEMS = MENU_GROUP__ITEMS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU__NAME = MENU_GROUP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Menu</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MENU_FEATURE_COUNT = MENU_GROUP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.outline.configurator.ChildActionType <em>Child Action Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.outline.configurator.ChildActionType
     * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getChildActionType()
     * @generated
     */
    int CHILD_ACTION_TYPE = 6;

    /**
     * Returns the meta object for class '{@link org.topcased.outline.configurator.OutlineConfiguration <em>Outline Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Outline Configuration</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration
     * @generated
     */
    EClass getOutlineConfiguration();

    /**
     * Returns the meta object for the containment reference '{@link org.topcased.outline.configurator.OutlineConfiguration#getCreateChild <em>Create Child</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Create Child</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration#getCreateChild()
     * @see #getOutlineConfiguration()
     * @generated
     */
    EReference getOutlineConfiguration_CreateChild();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.OutlineConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration#getName()
     * @see #getOutlineConfiguration()
     * @generated
     */
    EAttribute getOutlineConfiguration_Name();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.OutlineConfiguration#getProjectName <em>Project Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Project Name</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration#getProjectName()
     * @see #getOutlineConfiguration()
     * @generated
     */
    EAttribute getOutlineConfiguration_ProjectName();

    /**
     * Returns the meta object for the reference '{@link org.topcased.outline.configurator.OutlineConfiguration#getGenPackage <em>Gen Package</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Gen Package</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration#getGenPackage()
     * @see #getOutlineConfiguration()
     * @generated
     */
    EReference getOutlineConfiguration_GenPackage();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.OutlineConfiguration#getPackage <em>Package</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Package</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration#getPackage()
     * @see #getOutlineConfiguration()
     * @generated
     */
    EAttribute getOutlineConfiguration_Package();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.OutlineConfiguration#getPluginClassName <em>Plugin Class Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Plugin Class Name</em>'.
     * @see org.topcased.outline.configurator.OutlineConfiguration#getPluginClassName()
     * @see #getOutlineConfiguration()
     * @generated
     */
    EAttribute getOutlineConfiguration_PluginClassName();

    /**
     * Returns the meta object for class '{@link org.topcased.outline.configurator.CreateChildMenuConfiguration <em>Create Child Menu Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Create Child Menu Configuration</em>'.
     * @see org.topcased.outline.configurator.CreateChildMenuConfiguration
     * @generated
     */
    EClass getCreateChildMenuConfiguration();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.outline.configurator.CreateChildMenuConfiguration#getItems <em>Items</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.topcased.outline.configurator.CreateChildMenuConfiguration#getItems()
     * @see #getCreateChildMenuConfiguration()
     * @generated
     */
    EReference getCreateChildMenuConfiguration_Items();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.CreateChildMenuConfiguration#getClassName <em>Class Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Class Name</em>'.
     * @see org.topcased.outline.configurator.CreateChildMenuConfiguration#getClassName()
     * @see #getCreateChildMenuConfiguration()
     * @generated
     */
    EAttribute getCreateChildMenuConfiguration_ClassName();

    /**
     * Returns the meta object for class '{@link org.topcased.outline.configurator.CreateChildAction <em>Create Child Action</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Create Child Action</em>'.
     * @see org.topcased.outline.configurator.CreateChildAction
     * @generated
     */
    EClass getCreateChildAction();

    /**
     * Returns the meta object for the reference '{@link org.topcased.outline.configurator.CreateChildAction#getClass_ <em>Class</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Class</em>'.
     * @see org.topcased.outline.configurator.CreateChildAction#getClass_()
     * @see #getCreateChildAction()
     * @generated
     */
    EReference getCreateChildAction_Class();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.CreateChildAction#getType <em>Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.topcased.outline.configurator.CreateChildAction#getType()
     * @see #getCreateChildAction()
     * @generated
     */
    EAttribute getCreateChildAction_Type();

    /**
     * Returns the meta object for class '{@link org.topcased.outline.configurator.Menu <em>Menu</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Menu</em>'.
     * @see org.topcased.outline.configurator.Menu
     * @generated
     */
    EClass getMenu();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.Menu#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.outline.configurator.Menu#getName()
     * @see #getMenu()
     * @generated
     */
    EAttribute getMenu_Name();

    /**
     * Returns the meta object for class '{@link org.topcased.outline.configurator.MenuItem <em>Menu Item</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Menu Item</em>'.
     * @see org.topcased.outline.configurator.MenuItem
     * @generated
     */
    EClass getMenuItem();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.outline.configurator.MenuItem#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see org.topcased.outline.configurator.MenuItem#getParent()
     * @see #getMenuItem()
     * @generated
     */
    EReference getMenuItem_Parent();

    /**
     * Returns the meta object for class '{@link org.topcased.outline.configurator.MenuGroup <em>Menu Group</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Menu Group</em>'.
     * @see org.topcased.outline.configurator.MenuGroup
     * @generated
     */
    EClass getMenuGroup();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.outline.configurator.MenuGroup#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.outline.configurator.MenuGroup#getId()
     * @see #getMenuGroup()
     * @generated
     */
    EAttribute getMenuGroup_Id();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.outline.configurator.MenuGroup#getItems <em>Items</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.topcased.outline.configurator.MenuGroup#getItems()
     * @see #getMenuGroup()
     * @generated
     */
    EReference getMenuGroup_Items();

    /**
     * Returns the meta object for enum '{@link org.topcased.outline.configurator.ChildActionType <em>Child Action Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Child Action Type</em>'.
     * @see org.topcased.outline.configurator.ChildActionType
     * @generated
     */
    EEnum getChildActionType();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    OutlineConfiguratorFactory getOutlineConfiguratorFactory();

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
         * The meta object literal for the '{@link org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl <em>Outline Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfigurationImpl
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getOutlineConfiguration()
         * @generated
         */
        EClass OUTLINE_CONFIGURATION = eINSTANCE.getOutlineConfiguration();

        /**
         * The meta object literal for the '<em><b>Create Child</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OUTLINE_CONFIGURATION__CREATE_CHILD = eINSTANCE.getOutlineConfiguration_CreateChild();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute OUTLINE_CONFIGURATION__NAME = eINSTANCE.getOutlineConfiguration_Name();

        /**
         * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute OUTLINE_CONFIGURATION__PROJECT_NAME = eINSTANCE.getOutlineConfiguration_ProjectName();

        /**
         * The meta object literal for the '<em><b>Gen Package</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OUTLINE_CONFIGURATION__GEN_PACKAGE = eINSTANCE.getOutlineConfiguration_GenPackage();

        /**
         * The meta object literal for the '<em><b>Package</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute OUTLINE_CONFIGURATION__PACKAGE = eINSTANCE.getOutlineConfiguration_Package();

        /**
         * The meta object literal for the '<em><b>Plugin Class Name</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME = eINSTANCE.getOutlineConfiguration_PluginClassName();

        /**
         * The meta object literal for the '{@link org.topcased.outline.configurator.internal.impl.CreateChildMenuConfigurationImpl <em>Create Child Menu Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.internal.impl.CreateChildMenuConfigurationImpl
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getCreateChildMenuConfiguration()
         * @generated
         */
        EClass CREATE_CHILD_MENU_CONFIGURATION = eINSTANCE.getCreateChildMenuConfiguration();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CREATE_CHILD_MENU_CONFIGURATION__ITEMS = eINSTANCE.getCreateChildMenuConfiguration_Items();

        /**
         * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CREATE_CHILD_MENU_CONFIGURATION__CLASS_NAME = eINSTANCE.getCreateChildMenuConfiguration_ClassName();

        /**
         * The meta object literal for the '{@link org.topcased.outline.configurator.internal.impl.CreateChildActionImpl <em>Create Child Action</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.internal.impl.CreateChildActionImpl
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getCreateChildAction()
         * @generated
         */
        EClass CREATE_CHILD_ACTION = eINSTANCE.getCreateChildAction();

        /**
         * The meta object literal for the '<em><b>Class</b></em>' reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference CREATE_CHILD_ACTION__CLASS = eINSTANCE.getCreateChildAction_Class();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CREATE_CHILD_ACTION__TYPE = eINSTANCE.getCreateChildAction_Type();

        /**
         * The meta object literal for the '{@link org.topcased.outline.configurator.internal.impl.MenuImpl <em>Menu</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.internal.impl.MenuImpl
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getMenu()
         * @generated
         */
        EClass MENU = eINSTANCE.getMenu();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute MENU__NAME = eINSTANCE.getMenu_Name();

        /**
         * The meta object literal for the '{@link org.topcased.outline.configurator.internal.impl.MenuItemImpl <em>Menu Item</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.internal.impl.MenuItemImpl
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getMenuItem()
         * @generated
         */
        EClass MENU_ITEM = eINSTANCE.getMenuItem();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MENU_ITEM__PARENT = eINSTANCE.getMenuItem_Parent();

        /**
         * The meta object literal for the '{@link org.topcased.outline.configurator.internal.impl.MenuGroupImpl <em>Menu Group</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.internal.impl.MenuGroupImpl
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getMenuGroup()
         * @generated
         */
        EClass MENU_GROUP = eINSTANCE.getMenuGroup();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute MENU_GROUP__ID = eINSTANCE.getMenuGroup_Id();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MENU_GROUP__ITEMS = eINSTANCE.getMenuGroup_Items();

        /**
         * The meta object literal for the '{@link org.topcased.outline.configurator.ChildActionType <em>Child Action Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.outline.configurator.ChildActionType
         * @see org.topcased.outline.configurator.internal.impl.OutlineConfiguratorPackageImpl#getChildActionType()
         * @generated
         */
        EEnum CHILD_ACTION_TYPE = eINSTANCE.getChildActionType();

    }

} // OutlineConfiguratorPackage
