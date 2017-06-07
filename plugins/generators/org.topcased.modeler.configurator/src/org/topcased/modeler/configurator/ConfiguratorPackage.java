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
package org.topcased.modeler.configurator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorFactory
 * @model kind="package"
 * @generated
 */
public interface ConfiguratorPackage extends EPackage{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "configurator"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/configurator/1.0"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "configurator"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConfiguratorPackage eINSTANCE = org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.DiagramConfigurationImpl <em>Diagram Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.DiagramConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getDiagramConfiguration()
     * @generated
     */
    int DIAGRAM_CONFIGURATION = 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.EditorConfigurationImpl <em>Editor Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.EditorConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getEditorConfiguration()
     * @generated
     */
    int EDITOR_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__PROJECT_NAME = 1;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__PREFIX = 2;

    /**
     * The feature id for the '<em><b>Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__EXTENSION = 3;

    /**
     * The feature id for the '<em><b>Extension Diagram</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__EXTENSION_DIAGRAM = 4;

    /**
     * The feature id for the '<em><b>Gen Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__GEN_MODEL = 5;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__DIAGRAMS = 6;

    /**
     * The feature id for the '<em><b>Objects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__OBJECTS = 7;

    /**
     * The feature id for the '<em><b>Plugin Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION__PLUGIN_VERSION = 8;

    /**
     * The number of structural features of the the '<em>Editor Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDITOR_CONFIGURATION_FEATURE_COUNT = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__NAME = 1;

    /**
     * The feature id for the '<em><b>Package</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PACKAGE = 2;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PREFIX = 3;

    /**
     * The feature id for the '<em><b>Palette</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PALETTE = 4;

    /**
     * The feature id for the '<em><b>Parts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PARTS = 5;

    /**
     * The feature id for the '<em><b>Layout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__LAYOUT = 6;

    /**
     * The number of structural features of the the '<em>Diagram Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION_FEATURE_COUNT = 7;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.ObjectConfigurationImpl <em>Object Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.ObjectConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getObjectConfiguration()
     * @generated
     */
    int OBJECT_CONFIGURATION = 2;

    /**
     * The number of structural features of the the '<em>Object Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OBJECT_CONFIGURATION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.DiagramReferenceImpl <em>Diagram Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.DiagramReferenceImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getDiagramReference()
     * @generated
     */
    int DIAGRAM_REFERENCE = 3;

    /**
     * The feature id for the '<em><b>Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE__DIAGRAM = 0;

    /**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE__LOWER_BOUND = 1;

    /**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE__UPPER_BOUND = 2;

    /**
     * The number of structural features of the the '<em>Diagram Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.PaletteConfigurationImpl <em>Palette Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.PaletteConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getPaletteConfiguration()
     * @generated
     */
    int PALETTE_CONFIGURATION = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_CONFIGURATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Palette Categories</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_CONFIGURATION__PALETTE_CATEGORIES = 1;

    /**
     * The number of structural features of the the '<em>Palette Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_CONFIGURATION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.PaletteCategoryImpl <em>Palette Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.PaletteCategoryImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getPaletteCategory()
     * @generated
     */
    int PALETTE_CATEGORY = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_CATEGORY__NAME = 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_CATEGORY__ITEMS = 1;

    /**
     * The number of structural features of the the '<em>Palette Category</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_CATEGORY_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.PartConfigurationImpl <em>Part Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.PartConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getPartConfiguration()
     * @generated
     */
    int PART_CONFIGURATION = 6;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__OBJECT = 0;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = 1;

    /**
     * The feature id for the '<em><b>Foreground Color Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = 2;

    /**
     * The feature id for the '<em><b>Font Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__FONT_CHANGEABLE = 3;

    /**
     * The number of structural features of the the '<em>Part Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.NodePartConfigurationImpl <em>Node Part Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.NodePartConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getNodePartConfiguration()
     * @generated
     */
    int NODE_PART_CONFIGURATION = 7;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__OBJECT = PART_CONFIGURATION__OBJECT;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Foreground Color Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Font Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__FONT_CHANGEABLE = PART_CONFIGURATION__FONT_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__TYPE = PART_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Child Elements</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__CHILD_ELEMENTS = PART_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__SUPER_TYPE = PART_CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Default Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR = PART_CONFIGURATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Background Color Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE = PART_CONFIGURATION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Resizing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__RESIZING = PART_CONFIGURATION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Container</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__CONTAINER = PART_CONFIGURATION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Layout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__LAYOUT = PART_CONFIGURATION_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Direct Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DIRECT_EDITABLE = PART_CONFIGURATION_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Default Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_WIDTH = PART_CONFIGURATION_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Default Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_HEIGHT = PART_CONFIGURATION_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Minimum Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MINIMUM_WIDTH = PART_CONFIGURATION_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Minimum Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MINIMUM_HEIGHT = PART_CONFIGURATION_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Maximum Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MAXIMUM_WIDTH = PART_CONFIGURATION_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Maximum Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT = PART_CONFIGURATION_FEATURE_COUNT + 14;

    /**
     * The number of structural features of the the '<em>Node Part Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION_FEATURE_COUNT = PART_CONFIGURATION_FEATURE_COUNT + 15;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl <em>Edge Part Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.EdgePartConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getEdgePartConfiguration()
     * @generated
     */
    int EDGE_PART_CONFIGURATION = 8;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__OBJECT = PART_CONFIGURATION__OBJECT;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Foreground Color Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Font Changeable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__FONT_CHANGEABLE = PART_CONFIGURATION__FONT_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Source Target Couple</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE = PART_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Edge Objects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__EDGE_OBJECTS = PART_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Source Decoration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__SOURCE_DECORATION = PART_CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Target Decoration</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__TARGET_DECORATION = PART_CONFIGURATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Default Router</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DEFAULT_ROUTER = PART_CONFIGURATION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Direct Editable</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DIRECT_EDITABLE = PART_CONFIGURATION_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the the '<em>Edge Part Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION_FEATURE_COUNT = PART_CONFIGURATION_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.EdgeObjectImpl <em>Edge Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.EdgeObjectImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getEdgeObject()
     * @generated
     */
    int EDGE_OBJECT = 9;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__TYPE = 0;

    /**
     * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__ESTRUCTURAL_FEATURE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__ID = 2;

    /**
     * The number of structural features of the the '<em>Edge Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.PaletteItemImpl <em>Palette Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.PaletteItemImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getPaletteItem()
     * @generated
     */
    int PALETTE_ITEM = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_ITEM__NAME = 0;

    /**
     * The feature id for the '<em><b>Part</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_ITEM__PART = 1;

    /**
     * The number of structural features of the the '<em>Palette Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PALETTE_ITEM_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl <em>Source Target Couple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getSourceTargetCouple()
     * @generated
     */
    int SOURCE_TARGET_COUPLE = 11;

    /**
     * The feature id for the '<em><b>Container Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__CONTAINER_TYPE = 0;

    /**
     * The feature id for the '<em><b>Auto Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__AUTO_REF = 1;

    /**
     * The feature id for the '<em><b>Reversible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REVERSIBLE = 2;

    /**
     * The feature id for the '<em><b>Container Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__CONTAINER_OBJECT = 3;

    /**
     * The feature id for the '<em><b>Source Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__SOURCE_NODE = 4;

    /**
     * The feature id for the '<em><b>Target Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__TARGET_NODE = 5;

    /**
     * The feature id for the '<em><b>Container Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__CONTAINER_REF = 6;

    /**
     * The feature id for the '<em><b>Ref Source To Edge</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE = 7;

    /**
     * The feature id for the '<em><b>Ref Edge To Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE = 8;

    /**
     * The feature id for the '<em><b>Ref Target To Edge</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE = 9;

    /**
     * The feature id for the '<em><b>Ref Edge To Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET = 10;

    /**
     * The feature id for the '<em><b>Ref Source To Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET = 11;

    /**
     * The feature id for the '<em><b>Ref Target To Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE = 12;

    /**
     * The number of structural features of the the '<em>Source Target Couple</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE_FEATURE_COUNT = 13;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.ModelObjectConfigurationImpl <em>Model Object Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.ModelObjectConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getModelObjectConfiguration()
     * @generated
     */
    int MODEL_OBJECT_CONFIGURATION = 12;

    /**
     * The feature id for the '<em><b>Gen Class</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_OBJECT_CONFIGURATION__GEN_CLASS = OBJECT_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_OBJECT_CONFIGURATION__DIAGRAMS = OBJECT_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the the '<em>Model Object Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODEL_OBJECT_CONFIGURATION_FEATURE_COUNT = OBJECT_CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.impl.SimpleObjectConfigurationImpl <em>Simple Object Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.impl.SimpleObjectConfigurationImpl
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getSimpleObjectConfiguration()
     * @generated
     */
    int SIMPLE_OBJECT_CONFIGURATION = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_OBJECT_CONFIGURATION__NAME = OBJECT_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the the '<em>Simple Object Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_OBJECT_CONFIGURATION_FEATURE_COUNT = OBJECT_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.EdgeContainerType <em>Edge Container Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.EdgeContainerType
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getEdgeContainerType()
     * @generated
     */
    int EDGE_CONTAINER_TYPE = 14;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.ResizableType <em>Resizable Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.ResizableType
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getResizableType()
     * @generated
     */
    int RESIZABLE_TYPE = 15;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.LayoutType <em>Layout Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.LayoutType
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getLayoutType()
     * @generated
     */
    int LAYOUT_TYPE = 16;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.DecorationType <em>Decoration Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.DecorationType
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getDecorationType()
     * @generated
     */
    int DECORATION_TYPE = 17;

    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.RouterType <em>Router Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.RouterType
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getRouterType()
     * @generated
     */
    int ROUTER_TYPE = 18;


    /**
     * The meta object id for the '{@link org.topcased.modeler.configurator.EdgeObjectType <em>Edge Object Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.topcased.modeler.configurator.EdgeObjectType
     * @see org.topcased.modeler.configurator.impl.ConfiguratorPackageImpl#getEdgeObjectType()
     * @generated
     */
    int EDGE_OBJECT_TYPE = 19;


    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.DiagramConfiguration <em>Diagram Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Diagram Configuration</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration
     * @generated
     */
    EClass getDiagramConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramConfiguration#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getId()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Id();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getName()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Name();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramConfiguration#getPackage <em>Package</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Package</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getPackage()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Package();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramConfiguration#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getPrefix()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Prefix();

    /**
     * Returns the meta object for the containment reference '{@link org.topcased.modeler.configurator.DiagramConfiguration#getPalette <em>Palette</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Palette</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getPalette()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_Palette();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.DiagramConfiguration#getParts <em>Parts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parts</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getParts()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_Parts();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramConfiguration#getLayout <em>Layout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Layout</em>'.
     * @see org.topcased.modeler.configurator.DiagramConfiguration#getLayout()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Layout();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.EditorConfiguration <em>Editor Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Editor Configuration</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration
     * @generated
     */
    EClass getEditorConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EditorConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getName()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_Name();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EditorConfiguration#getProjectName <em>Project Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Project Name</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getProjectName()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_ProjectName();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EditorConfiguration#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getPrefix()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_Prefix();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EditorConfiguration#getExtension <em>Extension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extension</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getExtension()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_Extension();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EditorConfiguration#getExtensionDiagram <em>Extension Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extension Diagram</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getExtensionDiagram()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_ExtensionDiagram();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.EditorConfiguration#getGenModel <em>Gen Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Gen Model</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getGenModel()
     * @see #getEditorConfiguration()
     * @generated
     */
    EReference getEditorConfiguration_GenModel();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.EditorConfiguration#getDiagrams <em>Diagrams</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Diagrams</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getDiagrams()
     * @see #getEditorConfiguration()
     * @generated
     */
    EReference getEditorConfiguration_Diagrams();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.EditorConfiguration#getObjects <em>Objects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Objects</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getObjects()
     * @see #getEditorConfiguration()
     * @generated
     */
    EReference getEditorConfiguration_Objects();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EditorConfiguration#getPluginVersion <em>Plugin Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Plugin Version</em>'.
     * @see org.topcased.modeler.configurator.EditorConfiguration#getPluginVersion()
     * @see #getEditorConfiguration()
     * @generated
     */
    EAttribute getEditorConfiguration_PluginVersion();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.ObjectConfiguration <em>Object Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object Configuration</em>'.
     * @see org.topcased.modeler.configurator.ObjectConfiguration
     * @generated
     */
    EClass getObjectConfiguration();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.DiagramReference <em>Diagram Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Diagram Reference</em>'.
     * @see org.topcased.modeler.configurator.DiagramReference
     * @generated
     */
    EClass getDiagramReference();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.DiagramReference#getDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Diagram</em>'.
     * @see org.topcased.modeler.configurator.DiagramReference#getDiagram()
     * @see #getDiagramReference()
     * @generated
     */
    EReference getDiagramReference_Diagram();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramReference#getLowerBound <em>Lower Bound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lower Bound</em>'.
     * @see org.topcased.modeler.configurator.DiagramReference#getLowerBound()
     * @see #getDiagramReference()
     * @generated
     */
    EAttribute getDiagramReference_LowerBound();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.DiagramReference#getUpperBound <em>Upper Bound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Upper Bound</em>'.
     * @see org.topcased.modeler.configurator.DiagramReference#getUpperBound()
     * @see #getDiagramReference()
     * @generated
     */
    EAttribute getDiagramReference_UpperBound();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.PaletteConfiguration <em>Palette Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Palette Configuration</em>'.
     * @see org.topcased.modeler.configurator.PaletteConfiguration
     * @generated
     */
    EClass getPaletteConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.PaletteConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.configurator.PaletteConfiguration#getName()
     * @see #getPaletteConfiguration()
     * @generated
     */
    EAttribute getPaletteConfiguration_Name();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.PaletteConfiguration#getPaletteCategories <em>Palette Categories</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Palette Categories</em>'.
     * @see org.topcased.modeler.configurator.PaletteConfiguration#getPaletteCategories()
     * @see #getPaletteConfiguration()
     * @generated
     */
    EReference getPaletteConfiguration_PaletteCategories();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.PaletteCategory <em>Palette Category</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Palette Category</em>'.
     * @see org.topcased.modeler.configurator.PaletteCategory
     * @generated
     */
    EClass getPaletteCategory();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.PaletteCategory#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.configurator.PaletteCategory#getName()
     * @see #getPaletteCategory()
     * @generated
     */
    EAttribute getPaletteCategory_Name();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.PaletteCategory#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.topcased.modeler.configurator.PaletteCategory#getItems()
     * @see #getPaletteCategory()
     * @generated
     */
    EReference getPaletteCategory_Items();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.PartConfiguration <em>Part Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Part Configuration</em>'.
     * @see org.topcased.modeler.configurator.PartConfiguration
     * @generated
     */
    EClass getPartConfiguration();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.PartConfiguration#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Object</em>'.
     * @see org.topcased.modeler.configurator.PartConfiguration#getObject()
     * @see #getPartConfiguration()
     * @generated
     */
    EReference getPartConfiguration_Object();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.PartConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Foreground Color</em>'.
     * @see org.topcased.modeler.configurator.PartConfiguration#getDefaultForegroundColor()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_DefaultForegroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.PartConfiguration#isForegroundColorChangeable <em>Foreground Color Changeable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Foreground Color Changeable</em>'.
     * @see org.topcased.modeler.configurator.PartConfiguration#isForegroundColorChangeable()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_ForegroundColorChangeable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.PartConfiguration#isFontChangeable <em>Font Changeable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Changeable</em>'.
     * @see org.topcased.modeler.configurator.PartConfiguration#isFontChangeable()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_FontChangeable();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.NodePartConfiguration <em>Node Part Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node Part Configuration</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration
     * @generated
     */
    EClass getNodePartConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getType()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Type();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.modeler.configurator.NodePartConfiguration#getChildElements <em>Child Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Child Elements</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getChildElements()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EReference getNodePartConfiguration_ChildElements();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.NodePartConfiguration#getSuperType <em>Super Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super Type</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getSuperType()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EReference getNodePartConfiguration_SuperType();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultWidth <em>Default Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Width</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getDefaultWidth()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DefaultWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultHeight <em>Default Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Height</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getDefaultHeight()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DefaultHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMinimumWidth <em>Minimum Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum Width</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getMinimumWidth()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MinimumWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMinimumHeight <em>Minimum Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum Height</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getMinimumHeight()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MinimumHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMaximumWidth <em>Maximum Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum Width</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getMaximumWidth()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MaximumWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMaximumHeight <em>Maximum Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum Height</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getMaximumHeight()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MaximumHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Background Color</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getDefaultBackgroundColor()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DefaultBackgroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#isBackgroundColorChangeable <em>Background Color Changeable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Color Changeable</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#isBackgroundColorChangeable()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_BackgroundColorChangeable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getResizing <em>Resizing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Resizing</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getResizing()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Resizing();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#isContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Container</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#isContainer()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Container();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#isDirectEditable <em>Direct Editable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Direct Editable</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#isDirectEditable()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DirectEditable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.NodePartConfiguration#getLayout <em>Layout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Layout</em>'.
     * @see org.topcased.modeler.configurator.NodePartConfiguration#getLayout()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Layout();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.EdgePartConfiguration <em>Edge Part Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Edge Part Configuration</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration
     * @generated
     */
    EClass getEdgePartConfiguration();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getSourceTargetCouple <em>Source Target Couple</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Source Target Couple</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration#getSourceTargetCouple()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EReference getEdgePartConfiguration_SourceTargetCouple();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getEdgeObjects <em>Edge Objects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Edge Objects</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration#getEdgeObjects()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EReference getEdgePartConfiguration_EdgeObjects();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getSourceDecoration <em>Source Decoration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Decoration</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration#getSourceDecoration()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EAttribute getEdgePartConfiguration_SourceDecoration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getTargetDecoration <em>Target Decoration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Decoration</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration#getTargetDecoration()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EAttribute getEdgePartConfiguration_TargetDecoration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getDefaultRouter <em>Default Router</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Router</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration#getDefaultRouter()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EAttribute getEdgePartConfiguration_DefaultRouter();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.EdgePartConfiguration#getDirectEditable <em>Direct Editable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Direct Editable</em>'.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration#getDirectEditable()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EReference getEdgePartConfiguration_DirectEditable();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.EdgeObject <em>Edge Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Edge Object</em>'.
     * @see org.topcased.modeler.configurator.EdgeObject
     * @generated
     */
    EClass getEdgeObject();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EdgeObject#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.topcased.modeler.configurator.EdgeObject#getType()
     * @see #getEdgeObject()
     * @generated
     */
    EAttribute getEdgeObject_Type();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.EdgeObject#getEStructuralFeature <em>EStructural Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>EStructural Feature</em>'.
     * @see org.topcased.modeler.configurator.EdgeObject#getEStructuralFeature()
     * @see #getEdgeObject()
     * @generated
     */
    EReference getEdgeObject_EStructuralFeature();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.EdgeObject#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.modeler.configurator.EdgeObject#getId()
     * @see #getEdgeObject()
     * @generated
     */
    EAttribute getEdgeObject_Id();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.PaletteItem <em>Palette Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Palette Item</em>'.
     * @see org.topcased.modeler.configurator.PaletteItem
     * @generated
     */
    EClass getPaletteItem();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.PaletteItem#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.configurator.PaletteItem#getName()
     * @see #getPaletteItem()
     * @generated
     */
    EAttribute getPaletteItem_Name();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.PaletteItem#getPart <em>Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Part</em>'.
     * @see org.topcased.modeler.configurator.PaletteItem#getPart()
     * @see #getPaletteItem()
     * @generated
     */
    EReference getPaletteItem_Part();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.SourceTargetCouple <em>Source Target Couple</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Source Target Couple</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple
     * @generated
     */
    EClass getSourceTargetCouple();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerType <em>Container Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Container Type</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getContainerType()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EAttribute getSourceTargetCouple_ContainerType();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.SourceTargetCouple#isReversible <em>Reversible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reversible</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#isReversible()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EAttribute getSourceTargetCouple_Reversible();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerObject <em>Container Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Container Object</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getContainerObject()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_ContainerObject();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getSourceNode <em>Source Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source Node</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getSourceNode()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_SourceNode();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getTargetNode <em>Target Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Node</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getTargetNode()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_TargetNode();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.SourceTargetCouple#isAutoRef <em>Auto Ref</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Auto Ref</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#isAutoRef()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EAttribute getSourceTargetCouple_AutoRef();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerRef <em>Container Ref</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Container Ref</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getContainerRef()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_ContainerRef();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToEdge <em>Ref Source To Edge</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ref Source To Edge</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToEdge()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefSourceToEdge();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToSource <em>Ref Edge To Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ref Edge To Source</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToSource()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefEdgeToSource();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToEdge <em>Ref Target To Edge</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ref Target To Edge</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToEdge()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefTargetToEdge();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToTarget <em>Ref Edge To Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ref Edge To Target</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToTarget()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefEdgeToTarget();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToTarget <em>Ref Source To Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ref Source To Target</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToTarget()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefSourceToTarget();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToSource <em>Ref Target To Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Ref Target To Source</em>'.
     * @see org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToSource()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefTargetToSource();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.ModelObjectConfiguration <em>Model Object Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Model Object Configuration</em>'.
     * @see org.topcased.modeler.configurator.ModelObjectConfiguration
     * @generated
     */
    EClass getModelObjectConfiguration();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.configurator.ModelObjectConfiguration#getGenClass <em>Gen Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Gen Class</em>'.
     * @see org.topcased.modeler.configurator.ModelObjectConfiguration#getGenClass()
     * @see #getModelObjectConfiguration()
     * @generated
     */
    EReference getModelObjectConfiguration_GenClass();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.configurator.ModelObjectConfiguration#getDiagrams <em>Diagrams</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Diagrams</em>'.
     * @see org.topcased.modeler.configurator.ModelObjectConfiguration#getDiagrams()
     * @see #getModelObjectConfiguration()
     * @generated
     */
    EReference getModelObjectConfiguration_Diagrams();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.configurator.SimpleObjectConfiguration <em>Simple Object Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Object Configuration</em>'.
     * @see org.topcased.modeler.configurator.SimpleObjectConfiguration
     * @generated
     */
    EClass getSimpleObjectConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.configurator.SimpleObjectConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.configurator.SimpleObjectConfiguration#getName()
     * @see #getSimpleObjectConfiguration()
     * @generated
     */
    EAttribute getSimpleObjectConfiguration_Name();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.configurator.EdgeContainerType <em>Edge Container Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Edge Container Type</em>'.
     * @see org.topcased.modeler.configurator.EdgeContainerType
     * @generated
     */
    EEnum getEdgeContainerType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.configurator.ResizableType <em>Resizable Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Resizable Type</em>'.
     * @see org.topcased.modeler.configurator.ResizableType
     * @generated
     */
    EEnum getResizableType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.configurator.LayoutType <em>Layout Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Layout Type</em>'.
     * @see org.topcased.modeler.configurator.LayoutType
     * @generated
     */
    EEnum getLayoutType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.configurator.DecorationType <em>Decoration Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Decoration Type</em>'.
     * @see org.topcased.modeler.configurator.DecorationType
     * @generated
     */
    EEnum getDecorationType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.configurator.RouterType <em>Router Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Router Type</em>'.
     * @see org.topcased.modeler.configurator.RouterType
     * @generated
     */
    EEnum getRouterType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.configurator.EdgeObjectType <em>Edge Object Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Edge Object Type</em>'.
     * @see org.topcased.modeler.configurator.EdgeObjectType
     * @generated
     */
    EEnum getEdgeObjectType();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ConfiguratorFactory getConfiguratorFactory();

} //ConfiguratorPackage
