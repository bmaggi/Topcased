/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorPackage.java,v 1.12 2007/04/18 12:54:12 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramconfiguratorPackage extends EPackage
{
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "diagramconfigurator";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/diagramconfigurator/0.10";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "diagramconfigurator";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    DiagramconfiguratorPackage eINSTANCE = org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl <em>Diagram Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getDiagramConfiguration()
     * @generated
     */
    int DIAGRAM_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PROJECT_NAME = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__NAME = 1;

    /**
     * The feature id for the '<em><b>Package</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PACKAGE = 2;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PREFIX = 3;

    /**
     * The feature id for the '<em><b>Palette</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PALETTE = 4;

    /**
     * The feature id for the '<em><b>Parts</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PARTS = 5;

    /**
     * The feature id for the '<em><b>Layout</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__LAYOUT = 6;

    /**
     * The feature id for the '<em><b>Objects</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__OBJECTS = 7;

    /**
     * The feature id for the '<em><b>Gen Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__GEN_MODEL = 8;

    /**
     * The feature id for the '<em><b>Default Background Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR = 9;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = 10;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__DEFAULT_FONT = 11;

    /**
     * The feature id for the '<em><b>Template Root Object</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT = 12;

    /**
     * The feature id for the '<em><b>Force Overwrite</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__FORCE_OVERWRITE = 13;

    /**
     * The feature id for the '<em><b>Overwrite Graph Conf</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF = 14;

    /**
     * The feature id for the '<em><b>Organize Imports</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS = 15;

    /**
     * The feature id for the '<em><b>Editor Configurator</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR = 16;

    /**
     * The feature id for the '<em><b>Copyright Text</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT = 17;

    /**
     * The feature id for the '<em><b>Plugin Version</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PLUGIN_VERSION = 18;

    /**
     * The feature id for the '<em><b>Provider</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__PROVIDER = 19;

    /**
     * The feature id for the '<em><b>Same Plugin As Editor</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR = 20;

    /**
     * The number of structural features of the '<em>Diagram Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_CONFIGURATION_FEATURE_COUNT = 21;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.ObjectConfigurationImpl <em>Object Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.ObjectConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getObjectConfiguration()
     * @generated
     */
    int OBJECT_CONFIGURATION = 1;

    /**
     * The number of structural features of the '<em>Object Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OBJECT_CONFIGURATION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl <em>Diagram Reference</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getDiagramReference()
     * @generated
     */
    int DIAGRAM_REFERENCE = 2;

    /**
     * The feature id for the '<em><b>Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE__DIAGRAM = 0;

    /**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE__LOWER_BOUND = 1;

    /**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE__UPPER_BOUND = 2;

    /**
     * The number of structural features of the '<em>Diagram Reference</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_REFERENCE_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteConfigurationImpl <em>Palette Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.PaletteConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPaletteConfiguration()
     * @generated
     */
    int PALETTE_CONFIGURATION = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_CONFIGURATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Palette Categories</b></em>' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_CONFIGURATION__PALETTE_CATEGORIES = 1;

    /**
     * The number of structural features of the '<em>Palette Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_CONFIGURATION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteCategoryImpl <em>Palette Category</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.PaletteCategoryImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPaletteCategory()
     * @generated
     */
    int PALETTE_CATEGORY = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_CATEGORY__NAME = 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_CATEGORY__ITEMS = 1;

    /**
     * The number of structural features of the '<em>Palette Category</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_CATEGORY_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl <em>Part Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPartConfiguration()
     * @generated
     */
    int PART_CONFIGURATION = 5;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__OBJECT = 0;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__PRESENTATION = 1;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = 2;

    /**
     * The feature id for the '<em><b>Foreground Color Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = 3;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__DEFAULT_FONT = 4;

    /**
     * The feature id for the '<em><b>Font Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__FONT_CHANGEABLE = 5;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__LINE_WIDTH = 6;

    /**
     * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__LINE_STYLE = 7;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__CONSTRAINT = 8;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__PREFIX = 9;

    /**
     * The feature id for the '<em><b>Actions</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION__ACTIONS = 10;

    /**
     * The number of structural features of the '<em>Part Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_CONFIGURATION_FEATURE_COUNT = 11;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl <em>Node Part Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getNodePartConfiguration()
     * @generated
     */
    int NODE_PART_CONFIGURATION = 6;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__OBJECT = PART_CONFIGURATION__OBJECT;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__PRESENTATION = PART_CONFIGURATION__PRESENTATION;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Foreground Color Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_FONT = PART_CONFIGURATION__DEFAULT_FONT;

    /**
     * The feature id for the '<em><b>Font Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__FONT_CHANGEABLE = PART_CONFIGURATION__FONT_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__LINE_WIDTH = PART_CONFIGURATION__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__LINE_STYLE = PART_CONFIGURATION__LINE_STYLE;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__CONSTRAINT = PART_CONFIGURATION__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__PREFIX = PART_CONFIGURATION__PREFIX;

    /**
     * The feature id for the '<em><b>Actions</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__ACTIONS = PART_CONFIGURATION__ACTIONS;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__TYPE = PART_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Child Elements</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__CHILD_ELEMENTS = PART_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Super Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__SUPER_TYPE = PART_CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Default Background Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR = PART_CONFIGURATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Background Color Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE = PART_CONFIGURATION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Resizing</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__RESIZING = PART_CONFIGURATION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Container</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__CONTAINER = PART_CONFIGURATION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Layout</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__LAYOUT = PART_CONFIGURATION_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Direct Editable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DIRECT_EDITABLE = PART_CONFIGURATION_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Default Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_WIDTH = PART_CONFIGURATION_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Default Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__DEFAULT_HEIGHT = PART_CONFIGURATION_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Minimum Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MINIMUM_WIDTH = PART_CONFIGURATION_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Minimum Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MINIMUM_HEIGHT = PART_CONFIGURATION_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Maximum Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MAXIMUM_WIDTH = PART_CONFIGURATION_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Maximum Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT = PART_CONFIGURATION_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>Attached To Border</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER = PART_CONFIGURATION_FEATURE_COUNT + 15;

    /**
     * The number of structural features of the '<em>Node Part Configuration</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_PART_CONFIGURATION_FEATURE_COUNT = PART_CONFIGURATION_FEATURE_COUNT + 16;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl <em>Edge Part Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgePartConfiguration()
     * @generated
     */
    int EDGE_PART_CONFIGURATION = 7;

    /**
     * The feature id for the '<em><b>Object</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__OBJECT = PART_CONFIGURATION__OBJECT;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__PRESENTATION = PART_CONFIGURATION__PRESENTATION;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Foreground Color Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DEFAULT_FONT = PART_CONFIGURATION__DEFAULT_FONT;

    /**
     * The feature id for the '<em><b>Font Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__FONT_CHANGEABLE = PART_CONFIGURATION__FONT_CHANGEABLE;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__LINE_WIDTH = PART_CONFIGURATION__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__LINE_STYLE = PART_CONFIGURATION__LINE_STYLE;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__CONSTRAINT = PART_CONFIGURATION__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__PREFIX = PART_CONFIGURATION__PREFIX;

    /**
     * The feature id for the '<em><b>Actions</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__ACTIONS = PART_CONFIGURATION__ACTIONS;

    /**
     * The feature id for the '<em><b>Source Target Couple</b></em>' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE = PART_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Edge Objects</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__EDGE_OBJECTS = PART_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Source Decoration</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__SOURCE_DECORATION = PART_CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Target Decoration</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__TARGET_DECORATION = PART_CONFIGURATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Default Router</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DEFAULT_ROUTER = PART_CONFIGURATION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Direct Editable</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION__DIRECT_EDITABLE = PART_CONFIGURATION_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Edge Part Configuration</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_PART_CONFIGURATION_FEATURE_COUNT = PART_CONFIGURATION_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl <em>Edge Object</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgeObject()
     * @generated
     */
    int EDGE_OBJECT = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__ID = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__TYPE = 1;

    /**
     * The feature id for the '<em><b>EStructural Feature</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__ESTRUCTURAL_FEATURE = 2;

    /**
     * The number of structural features of the '<em>Edge Object</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteItemImpl <em>Palette Item</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.PaletteItemImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPaletteItem()
     * @generated
     */
    int PALETTE_ITEM = 9;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_ITEM__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_ITEM__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Part</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_ITEM__PART = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Palette Item</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PALETTE_ITEM_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl <em>Source Target Couple</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getSourceTargetCouple()
     * @generated
     */
    int SOURCE_TARGET_COUPLE = 10;

    /**
     * The feature id for the '<em><b>Container Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__CONTAINER_TYPE = 0;

    /**
     * The feature id for the '<em><b>Auto Ref</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__AUTO_REF = 1;

    /**
     * The feature id for the '<em><b>Reversible</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REVERSIBLE = 2;

    /**
     * The feature id for the '<em><b>Container Object</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__CONTAINER_OBJECT = 3;

    /**
     * The feature id for the '<em><b>Source Node</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__SOURCE_NODE = 4;

    /**
     * The feature id for the '<em><b>Target Node</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__TARGET_NODE = 5;

    /**
     * The feature id for the '<em><b>Container Ref</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__CONTAINER_REF = 6;

    /**
     * The feature id for the '<em><b>Ref Source To Edge</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE = 7;

    /**
     * The feature id for the '<em><b>Ref Edge To Source</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE = 8;

    /**
     * The feature id for the '<em><b>Ref Target To Edge</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE = 9;

    /**
     * The feature id for the '<em><b>Ref Edge To Target</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET = 10;

    /**
     * The feature id for the '<em><b>Ref Source To Target</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET = 11;

    /**
     * The feature id for the '<em><b>Ref Target To Source</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE = 12;

    /**
     * The number of structural features of the '<em>Source Target Couple</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SOURCE_TARGET_COUPLE_FEATURE_COUNT = 13;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.ModelObjectConfigurationImpl <em>Model Object Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.ModelObjectConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getModelObjectConfiguration()
     * @generated
     */
    int MODEL_OBJECT_CONFIGURATION = 11;

    /**
     * The feature id for the '<em><b>Gen Class</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODEL_OBJECT_CONFIGURATION__GEN_CLASS = OBJECT_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODEL_OBJECT_CONFIGURATION__DIAGRAMS = OBJECT_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Model Object Configuration</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODEL_OBJECT_CONFIGURATION_FEATURE_COUNT = OBJECT_CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.SimpleObjectConfigurationImpl <em>Simple Object Configuration</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.SimpleObjectConfigurationImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getSimpleObjectConfiguration()
     * @generated
     */
    int SIMPLE_OBJECT_CONFIGURATION = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SIMPLE_OBJECT_CONFIGURATION__NAME = OBJECT_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Simple Object Configuration</em>' class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SIMPLE_OBJECT_CONFIGURATION_FEATURE_COUNT = OBJECT_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.ConstraintImpl <em>Constraint</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.ConstraintImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getConstraint()
     * @generated
     */
    int CONSTRAINT = 13;

    /**
     * The feature id for the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__LANGUAGE = 0;

    /**
     * The feature id for the '<em><b>Rule</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__RULE = 1;

    /**
     * The number of structural features of the '<em>Constraint</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl <em>Part Action</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPartAction()
     * @generated
     */
    int PART_ACTION = 14;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_ACTION__PREFIX = 0;

    /**
     * The feature id for the '<em><b>Menu Bar Group</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PART_ACTION__MENU_BAR_GROUP = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_ACTION__LABEL = 2;

    /**
     * The feature id for the '<em><b>Icon</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_ACTION__ICON = 3;

    /**
     * The number of structural features of the '<em>Part Action</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PART_ACTION_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.EdgeContainerType <em>Edge Container Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.EdgeContainerType
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgeContainerType()
     * @generated
     */
    int EDGE_CONTAINER_TYPE = 15;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.ResizableType <em>Resizable Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.ResizableType
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getResizableType()
     * @generated
     */
    int RESIZABLE_TYPE = 16;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.LayoutType <em>Layout Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.LayoutType
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getLayoutType()
     * @generated
     */
    int LAYOUT_TYPE = 17;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.DecorationType <em>Decoration Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.DecorationType
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getDecorationType()
     * @generated
     */
    int DECORATION_TYPE = 18;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.RouterType <em>Router Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.RouterType
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getRouterType()
     * @generated
     */
    int ROUTER_TYPE = 19;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.EdgeObjectType <em>Edge Object Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.EdgeObjectType
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgeObjectType()
     * @generated
     */
    int EDGE_OBJECT_TYPE = 20;

    /**
     * The meta object id for the '{@link org.topcased.modeler.diagramconfigurator.LineStyle <em>Line Style</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.diagramconfigurator.LineStyle
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getLineStyle()
     * @generated
     */
    int LINE_STYLE = 21;

    /**
     * The meta object id for the '<em>Color</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.swt.graphics.Color
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getColor()
     * @generated
     */
    int COLOR = 22;

    /**
     * The meta object id for the '<em>Font</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.swt.graphics.Font
     * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getFont()
     * @generated
     */
    int FONT = 23;

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration <em>Diagram Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Diagram Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration
     * @generated
     */
    EClass getDiagramConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProjectName <em>Project Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Project Name</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProjectName()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_ProjectName();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getName()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Name();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPackage <em>Package</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Package</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPackage()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Package();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPrefix()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Prefix();

    /**
     * Returns the meta object for the containment reference '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPalette <em>Palette</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Palette</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPalette()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_Palette();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getParts <em>Parts</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Parts</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getParts()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_Parts();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getLayout <em>Layout</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Layout</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getLayout()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Layout();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getObjects <em>Objects</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Objects</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getObjects()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_Objects();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getGenModel <em>Gen Model</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Gen Model</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getGenModel()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_GenModel();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Background Color</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultBackgroundColor()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_DefaultBackgroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Foreground Color</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultForegroundColor()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_DefaultForegroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultFont <em>Default Font</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Font</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultFont()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_DefaultFont();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getTemplateRootObject <em>Template Root Object</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Template Root Object</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getTemplateRootObject()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_TemplateRootObject();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isForceOverwrite <em>Force Overwrite</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Force Overwrite</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isForceOverwrite()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_ForceOverwrite();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOverwriteGraphConf <em>Overwrite Graph Conf</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Overwrite Graph Conf</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOverwriteGraphConf()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_OverwriteGraphConf();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOrganizeImports <em>Organize Imports</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Organize Imports</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOrganizeImports()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_OrganizeImports();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getEditorConfigurator <em>Editor Configurator</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Editor Configurator</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getEditorConfigurator()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EReference getDiagramConfiguration_EditorConfigurator();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getCopyrightText <em>Copyright Text</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Copyright Text</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getCopyrightText()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_CopyrightText();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPluginVersion <em>Plugin Version</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Plugin Version</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPluginVersion()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_PluginVersion();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProvider <em>Provider</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Provider</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProvider()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_Provider();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isSamePluginAsEditor <em>Same Plugin As Editor</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Same Plugin As Editor</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isSamePluginAsEditor()
     * @see #getDiagramConfiguration()
     * @generated
     */
    EAttribute getDiagramConfiguration_SamePluginAsEditor();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.ObjectConfiguration <em>Object Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Object Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.ObjectConfiguration
     * @generated
     */
    EClass getObjectConfiguration();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.DiagramReference <em>Diagram Reference</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Diagram Reference</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramReference
     * @generated
     */
    EClass getDiagramReference();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Diagram</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramReference#getDiagram()
     * @see #getDiagramReference()
     * @generated
     */
    EReference getDiagramReference_Diagram();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getLowerBound <em>Lower Bound</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Lower Bound</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramReference#getLowerBound()
     * @see #getDiagramReference()
     * @generated
     */
    EAttribute getDiagramReference_LowerBound();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.DiagramReference#getUpperBound <em>Upper Bound</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Upper Bound</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DiagramReference#getUpperBound()
     * @see #getDiagramReference()
     * @generated
     */
    EAttribute getDiagramReference_UpperBound();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration <em>Palette Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Palette Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteConfiguration
     * @generated
     */
    EClass getPaletteConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getName()
     * @see #getPaletteConfiguration()
     * @generated
     */
    EAttribute getPaletteConfiguration_Name();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getPaletteCategories <em>Palette Categories</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Palette Categories</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteConfiguration#getPaletteCategories()
     * @see #getPaletteConfiguration()
     * @generated
     */
    EReference getPaletteConfiguration_PaletteCategories();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.PaletteCategory <em>Palette Category</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Palette Category</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteCategory
     * @generated
     */
    EClass getPaletteCategory();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PaletteCategory#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteCategory#getName()
     * @see #getPaletteCategory()
     * @generated
     */
    EAttribute getPaletteCategory_Name();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.PaletteCategory#getItems <em>Items</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteCategory#getItems()
     * @see #getPaletteCategory()
     * @generated
     */
    EReference getPaletteCategory_Items();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration <em>Part Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Part Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration
     * @generated
     */
    EClass getPartConfiguration();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getObject <em>Object</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Object</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getObject()
     * @see #getPartConfiguration()
     * @generated
     */
    EReference getPartConfiguration_Object();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getPresentation <em>Presentation</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Presentation</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getPresentation()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_Presentation();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Foreground Color</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultForegroundColor()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_DefaultForegroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#isForegroundColorChangeable <em>Foreground Color Changeable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Foreground Color Changeable</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#isForegroundColorChangeable()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_ForegroundColorChangeable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultFont <em>Default Font</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Font</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultFont()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_DefaultFont();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#isFontChangeable <em>Font Changeable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Font Changeable</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#isFontChangeable()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_FontChangeable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineWidth <em>Line Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Line Width</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineWidth()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_LineWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineStyle <em>Line Style</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Line Style</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineStyle()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_LineStyle();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getConstraint <em>Constraint</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Constraint</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getConstraint()
     * @see #getPartConfiguration()
     * @generated
     */
    EReference getPartConfiguration_Constraint();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getPrefix()
     * @see #getPartConfiguration()
     * @generated
     */
    EAttribute getPartConfiguration_Prefix();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getActions <em>Actions</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Actions</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration#getActions()
     * @see #getPartConfiguration()
     * @generated
     */
    EReference getPartConfiguration_Actions();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration <em>Node Part Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Node Part Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration
     * @generated
     */
    EClass getNodePartConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getType <em>Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getType()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Type();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getChildElements <em>Child Elements</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Child Elements</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getChildElements()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EReference getNodePartConfiguration_ChildElements();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getSuperType <em>Super Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Super Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getSuperType()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EReference getNodePartConfiguration_SuperType();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Background Color</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultBackgroundColor()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DefaultBackgroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isBackgroundColorChangeable <em>Background Color Changeable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Background Color Changeable</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isBackgroundColorChangeable()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_BackgroundColorChangeable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getResizing <em>Resizing</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Resizing</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getResizing()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Resizing();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isContainer <em>Container</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Container</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isContainer()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Container();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getLayout <em>Layout</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Layout</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getLayout()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_Layout();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isDirectEditable <em>Direct Editable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Direct Editable</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isDirectEditable()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DirectEditable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultWidth <em>Default Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Width</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultWidth()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DefaultWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultHeight <em>Default Height</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Height</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getDefaultHeight()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_DefaultHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMinimumWidth <em>Minimum Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Minimum Width</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMinimumWidth()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MinimumWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMinimumHeight <em>Minimum Height</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Minimum Height</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMinimumHeight()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MinimumHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMaximumWidth <em>Maximum Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Maximum Width</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMaximumWidth()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MaximumWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMaximumHeight <em>Maximum Height</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Maximum Height</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#getMaximumHeight()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_MaximumHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isAttachedToBorder <em>Attached To Border</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Attached To Border</em>'.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration#isAttachedToBorder()
     * @see #getNodePartConfiguration()
     * @generated
     */
    EAttribute getNodePartConfiguration_AttachedToBorder();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration <em>Edge Part Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Edge Part Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration
     * @generated
     */
    EClass getEdgePartConfiguration();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceTargetCouple <em>Source Target Couple</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Source Target Couple</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceTargetCouple()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EReference getEdgePartConfiguration_SourceTargetCouple();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getEdgeObjects <em>Edge Objects</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Edge Objects</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getEdgeObjects()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EReference getEdgePartConfiguration_EdgeObjects();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceDecoration <em>Source Decoration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Source Decoration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceDecoration()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EAttribute getEdgePartConfiguration_SourceDecoration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getTargetDecoration <em>Target Decoration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Target Decoration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getTargetDecoration()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EAttribute getEdgePartConfiguration_TargetDecoration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDefaultRouter <em>Default Router</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Router</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDefaultRouter()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EAttribute getEdgePartConfiguration_DefaultRouter();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDirectEditable <em>Direct Editable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Direct Editable</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDirectEditable()
     * @see #getEdgePartConfiguration()
     * @generated
     */
    EReference getEdgePartConfiguration_DirectEditable();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.EdgeObject <em>Edge Object</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Edge Object</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObject
     * @generated
     */
    EClass getEdgeObject();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObject#getId()
     * @see #getEdgeObject()
     * @generated
     */
    EAttribute getEdgeObject_Id();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getType <em>Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObject#getType()
     * @see #getEdgeObject()
     * @generated
     */
    EAttribute getEdgeObject_Type();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getEStructuralFeature <em>EStructural Feature</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>EStructural Feature</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObject#getEStructuralFeature()
     * @see #getEdgeObject()
     * @generated
     */
    EReference getEdgeObject_EStructuralFeature();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.PaletteItem <em>Palette Item</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Palette Item</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteItem
     * @generated
     */
    EClass getPaletteItem();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PaletteItem#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteItem#getName()
     * @see #getPaletteItem()
     * @generated
     */
    EAttribute getPaletteItem_Name();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.PaletteItem#getPart <em>Part</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Part</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PaletteItem#getPart()
     * @see #getPaletteItem()
     * @generated
     */
    EReference getPaletteItem_Part();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple <em>Source Target Couple</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Source Target Couple</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple
     * @generated
     */
    EClass getSourceTargetCouple();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerType <em>Container Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Container Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerType()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EAttribute getSourceTargetCouple_ContainerType();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isAutoRef <em>Auto Ref</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Auto Ref</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isAutoRef()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EAttribute getSourceTargetCouple_AutoRef();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isReversible <em>Reversible</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Reversible</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isReversible()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EAttribute getSourceTargetCouple_Reversible();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerObject <em>Container Object</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Container Object</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerObject()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_ContainerObject();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getSourceNode <em>Source Node</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Source Node</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getSourceNode()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_SourceNode();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getTargetNode <em>Target Node</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Target Node</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getTargetNode()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_TargetNode();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerRef <em>Container Ref</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Container Ref</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerRef()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_ContainerRef();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToEdge <em>Ref Source To Edge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Ref Source To Edge</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToEdge()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefSourceToEdge();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToSource <em>Ref Edge To Source</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Ref Edge To Source</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToSource()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefEdgeToSource();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToEdge <em>Ref Target To Edge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Ref Target To Edge</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToEdge()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefTargetToEdge();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToTarget <em>Ref Edge To Target</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Ref Edge To Target</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToTarget()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefEdgeToTarget();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToTarget <em>Ref Source To Target</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Ref Source To Target</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToTarget()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefSourceToTarget();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToSource <em>Ref Target To Source</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Ref Target To Source</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToSource()
     * @see #getSourceTargetCouple()
     * @generated
     */
    EReference getSourceTargetCouple_RefTargetToSource();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration <em>Model Object Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Model Object Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration
     * @generated
     */
    EClass getModelObjectConfiguration();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getGenClass <em>Gen Class</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Gen Class</em>'.
     * @see org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getGenClass()
     * @see #getModelObjectConfiguration()
     * @generated
     */
    EReference getModelObjectConfiguration_GenClass();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getDiagrams <em>Diagrams</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Diagrams</em>'.
     * @see org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration#getDiagrams()
     * @see #getModelObjectConfiguration()
     * @generated
     */
    EReference getModelObjectConfiguration_Diagrams();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration <em>Simple Object Configuration</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Simple Object Configuration</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration
     * @generated
     */
    EClass getSimpleObjectConfiguration();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration#getName()
     * @see #getSimpleObjectConfiguration()
     * @generated
     */
    EAttribute getSimpleObjectConfiguration_Name();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Constraint</em>'.
     * @see org.topcased.modeler.diagramconfigurator.Constraint
     * @generated
     */
    EClass getConstraint();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.Constraint#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.topcased.modeler.diagramconfigurator.Constraint#getLanguage()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Language();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.Constraint#getRule <em>Rule</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Rule</em>'.
     * @see org.topcased.modeler.diagramconfigurator.Constraint#getRule()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Rule();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.diagramconfigurator.PartAction <em>Part Action</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Part Action</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartAction
     * @generated
     */
    EClass getPartAction();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartAction#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartAction#getPrefix()
     * @see #getPartAction()
     * @generated
     */
    EAttribute getPartAction_Prefix();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartAction#getMenuBarGroup <em>Menu Bar Group</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Menu Bar Group</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartAction#getMenuBarGroup()
     * @see #getPartAction()
     * @generated
     */
    EAttribute getPartAction_MenuBarGroup();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartAction#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartAction#getLabel()
     * @see #getPartAction()
     * @generated
     */
    EAttribute getPartAction_Label();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.diagramconfigurator.PartAction#getIcon <em>Icon</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Icon</em>'.
     * @see org.topcased.modeler.diagramconfigurator.PartAction#getIcon()
     * @see #getPartAction()
     * @generated
     */
    EAttribute getPartAction_Icon();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.EdgeContainerType <em>Edge Container Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Edge Container Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgeContainerType
     * @generated
     */
    EEnum getEdgeContainerType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.ResizableType <em>Resizable Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Resizable Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.ResizableType
     * @generated
     */
    EEnum getResizableType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.LayoutType <em>Layout Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Layout Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.LayoutType
     * @generated
     */
    EEnum getLayoutType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.DecorationType <em>Decoration Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Decoration Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.DecorationType
     * @generated
     */
    EEnum getDecorationType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.RouterType <em>Router Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Router Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.RouterType
     * @generated
     */
    EEnum getRouterType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.EdgeObjectType <em>Edge Object Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Edge Object Type</em>'.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObjectType
     * @generated
     */
    EEnum getEdgeObjectType();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.diagramconfigurator.LineStyle <em>Line Style</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Line Style</em>'.
     * @see org.topcased.modeler.diagramconfigurator.LineStyle
     * @generated
     */
    EEnum getLineStyle();

    /**
     * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Color <em>Color</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>Color</em>'.
     * @see org.eclipse.swt.graphics.Color
     * @model instanceClass="org.eclipse.swt.graphics.Color"
     * @generated
     */
    EDataType getColor();

    /**
     * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Font <em>Font</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>Font</em>'.
     * @see org.eclipse.swt.graphics.Font
     * @model instanceClass="org.eclipse.swt.graphics.Font"
     * @generated
     */
    EDataType getFont();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DiagramconfiguratorFactory getDiagramconfiguratorFactory();

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
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl <em>Diagram Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getDiagramConfiguration()
         * @generated
         */
        EClass DIAGRAM_CONFIGURATION = eINSTANCE.getDiagramConfiguration();

        /**
         * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__PROJECT_NAME = eINSTANCE.getDiagramConfiguration_ProjectName();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__NAME = eINSTANCE.getDiagramConfiguration_Name();

        /**
         * The meta object literal for the '<em><b>Package</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__PACKAGE = eINSTANCE.getDiagramConfiguration_Package();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__PREFIX = eINSTANCE.getDiagramConfiguration_Prefix();

        /**
         * The meta object literal for the '<em><b>Palette</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_CONFIGURATION__PALETTE = eINSTANCE.getDiagramConfiguration_Palette();

        /**
         * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_CONFIGURATION__PARTS = eINSTANCE.getDiagramConfiguration_Parts();

        /**
         * The meta object literal for the '<em><b>Layout</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__LAYOUT = eINSTANCE.getDiagramConfiguration_Layout();

        /**
         * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_CONFIGURATION__OBJECTS = eINSTANCE.getDiagramConfiguration_Objects();

        /**
         * The meta object literal for the '<em><b>Gen Model</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_CONFIGURATION__GEN_MODEL = eINSTANCE.getDiagramConfiguration_GenModel();

        /**
         * The meta object literal for the '<em><b>Default Background Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR = eINSTANCE.getDiagramConfiguration_DefaultBackgroundColor();

        /**
         * The meta object literal for the '<em><b>Default Foreground Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = eINSTANCE.getDiagramConfiguration_DefaultForegroundColor();

        /**
         * The meta object literal for the '<em><b>Default Font</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__DEFAULT_FONT = eINSTANCE.getDiagramConfiguration_DefaultFont();

        /**
         * The meta object literal for the '<em><b>Template Root Object</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT = eINSTANCE.getDiagramConfiguration_TemplateRootObject();

        /**
         * The meta object literal for the '<em><b>Force Overwrite</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__FORCE_OVERWRITE = eINSTANCE.getDiagramConfiguration_ForceOverwrite();

        /**
         * The meta object literal for the '<em><b>Overwrite Graph Conf</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF = eINSTANCE.getDiagramConfiguration_OverwriteGraphConf();

        /**
         * The meta object literal for the '<em><b>Organize Imports</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS = eINSTANCE.getDiagramConfiguration_OrganizeImports();

        /**
         * The meta object literal for the '<em><b>Editor Configurator</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR = eINSTANCE.getDiagramConfiguration_EditorConfigurator();

        /**
         * The meta object literal for the '<em><b>Copyright Text</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT = eINSTANCE.getDiagramConfiguration_CopyrightText();

        /**
         * The meta object literal for the '<em><b>Plugin Version</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__PLUGIN_VERSION = eINSTANCE.getDiagramConfiguration_PluginVersion();

        /**
         * The meta object literal for the '<em><b>Provider</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__PROVIDER = eINSTANCE.getDiagramConfiguration_Provider();

        /**
         * The meta object literal for the '<em><b>Same Plugin As Editor</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR = eINSTANCE.getDiagramConfiguration_SamePluginAsEditor();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.ObjectConfigurationImpl <em>Object Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.ObjectConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getObjectConfiguration()
         * @generated
         */
        EClass OBJECT_CONFIGURATION = eINSTANCE.getObjectConfiguration();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl <em>Diagram Reference</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getDiagramReference()
         * @generated
         */
        EClass DIAGRAM_REFERENCE = eINSTANCE.getDiagramReference();

        /**
         * The meta object literal for the '<em><b>Diagram</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_REFERENCE__DIAGRAM = eINSTANCE.getDiagramReference_Diagram();

        /**
         * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_REFERENCE__LOWER_BOUND = eINSTANCE.getDiagramReference_LowerBound();

        /**
         * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_REFERENCE__UPPER_BOUND = eINSTANCE.getDiagramReference_UpperBound();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteConfigurationImpl <em>Palette Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.PaletteConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPaletteConfiguration()
         * @generated
         */
        EClass PALETTE_CONFIGURATION = eINSTANCE.getPaletteConfiguration();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PALETTE_CONFIGURATION__NAME = eINSTANCE.getPaletteConfiguration_Name();

        /**
         * The meta object literal for the '<em><b>Palette Categories</b></em>' containment reference list feature.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PALETTE_CONFIGURATION__PALETTE_CATEGORIES = eINSTANCE.getPaletteConfiguration_PaletteCategories();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteCategoryImpl <em>Palette Category</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.PaletteCategoryImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPaletteCategory()
         * @generated
         */
        EClass PALETTE_CATEGORY = eINSTANCE.getPaletteCategory();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PALETTE_CATEGORY__NAME = eINSTANCE.getPaletteCategory_Name();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PALETTE_CATEGORY__ITEMS = eINSTANCE.getPaletteCategory_Items();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl <em>Part Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.PartConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPartConfiguration()
         * @generated
         */
        EClass PART_CONFIGURATION = eINSTANCE.getPartConfiguration();

        /**
         * The meta object literal for the '<em><b>Object</b></em>' reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference PART_CONFIGURATION__OBJECT = eINSTANCE.getPartConfiguration_Object();

        /**
         * The meta object literal for the '<em><b>Presentation</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__PRESENTATION = eINSTANCE.getPartConfiguration_Presentation();

        /**
         * The meta object literal for the '<em><b>Default Foreground Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR = eINSTANCE.getPartConfiguration_DefaultForegroundColor();

        /**
         * The meta object literal for the '<em><b>Foreground Color Changeable</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE = eINSTANCE.getPartConfiguration_ForegroundColorChangeable();

        /**
         * The meta object literal for the '<em><b>Default Font</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__DEFAULT_FONT = eINSTANCE.getPartConfiguration_DefaultFont();

        /**
         * The meta object literal for the '<em><b>Font Changeable</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__FONT_CHANGEABLE = eINSTANCE.getPartConfiguration_FontChangeable();

        /**
         * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__LINE_WIDTH = eINSTANCE.getPartConfiguration_LineWidth();

        /**
         * The meta object literal for the '<em><b>Line Style</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__LINE_STYLE = eINSTANCE.getPartConfiguration_LineStyle();

        /**
         * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PART_CONFIGURATION__CONSTRAINT = eINSTANCE.getPartConfiguration_Constraint();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_CONFIGURATION__PREFIX = eINSTANCE.getPartConfiguration_Prefix();

        /**
         * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PART_CONFIGURATION__ACTIONS = eINSTANCE.getPartConfiguration_Actions();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl <em>Node Part Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.NodePartConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getNodePartConfiguration()
         * @generated
         */
        EClass NODE_PART_CONFIGURATION = eINSTANCE.getNodePartConfiguration();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__TYPE = eINSTANCE.getNodePartConfiguration_Type();

        /**
         * The meta object literal for the '<em><b>Child Elements</b></em>' reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference NODE_PART_CONFIGURATION__CHILD_ELEMENTS = eINSTANCE.getNodePartConfiguration_ChildElements();

        /**
         * The meta object literal for the '<em><b>Super Type</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference NODE_PART_CONFIGURATION__SUPER_TYPE = eINSTANCE.getNodePartConfiguration_SuperType();

        /**
         * The meta object literal for the '<em><b>Default Background Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR = eINSTANCE.getNodePartConfiguration_DefaultBackgroundColor();

        /**
         * The meta object literal for the '<em><b>Background Color Changeable</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE = eINSTANCE.getNodePartConfiguration_BackgroundColorChangeable();

        /**
         * The meta object literal for the '<em><b>Resizing</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__RESIZING = eINSTANCE.getNodePartConfiguration_Resizing();

        /**
         * The meta object literal for the '<em><b>Container</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__CONTAINER = eINSTANCE.getNodePartConfiguration_Container();

        /**
         * The meta object literal for the '<em><b>Layout</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__LAYOUT = eINSTANCE.getNodePartConfiguration_Layout();

        /**
         * The meta object literal for the '<em><b>Direct Editable</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__DIRECT_EDITABLE = eINSTANCE.getNodePartConfiguration_DirectEditable();

        /**
         * The meta object literal for the '<em><b>Default Width</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__DEFAULT_WIDTH = eINSTANCE.getNodePartConfiguration_DefaultWidth();

        /**
         * The meta object literal for the '<em><b>Default Height</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__DEFAULT_HEIGHT = eINSTANCE.getNodePartConfiguration_DefaultHeight();

        /**
         * The meta object literal for the '<em><b>Minimum Width</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__MINIMUM_WIDTH = eINSTANCE.getNodePartConfiguration_MinimumWidth();

        /**
         * The meta object literal for the '<em><b>Minimum Height</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__MINIMUM_HEIGHT = eINSTANCE.getNodePartConfiguration_MinimumHeight();

        /**
         * The meta object literal for the '<em><b>Maximum Width</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__MAXIMUM_WIDTH = eINSTANCE.getNodePartConfiguration_MaximumWidth();

        /**
         * The meta object literal for the '<em><b>Maximum Height</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT = eINSTANCE.getNodePartConfiguration_MaximumHeight();

        /**
         * The meta object literal for the '<em><b>Attached To Border</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER = eINSTANCE.getNodePartConfiguration_AttachedToBorder();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl <em>Edge Part Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgePartConfiguration()
         * @generated
         */
        EClass EDGE_PART_CONFIGURATION = eINSTANCE.getEdgePartConfiguration();

        /**
         * The meta object literal for the '<em><b>Source Target Couple</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE = eINSTANCE.getEdgePartConfiguration_SourceTargetCouple();

        /**
         * The meta object literal for the '<em><b>Edge Objects</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EDGE_PART_CONFIGURATION__EDGE_OBJECTS = eINSTANCE.getEdgePartConfiguration_EdgeObjects();

        /**
         * The meta object literal for the '<em><b>Source Decoration</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDGE_PART_CONFIGURATION__SOURCE_DECORATION = eINSTANCE.getEdgePartConfiguration_SourceDecoration();

        /**
         * The meta object literal for the '<em><b>Target Decoration</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDGE_PART_CONFIGURATION__TARGET_DECORATION = eINSTANCE.getEdgePartConfiguration_TargetDecoration();

        /**
         * The meta object literal for the '<em><b>Default Router</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDGE_PART_CONFIGURATION__DEFAULT_ROUTER = eINSTANCE.getEdgePartConfiguration_DefaultRouter();

        /**
         * The meta object literal for the '<em><b>Direct Editable</b></em>' reference feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EDGE_PART_CONFIGURATION__DIRECT_EDITABLE = eINSTANCE.getEdgePartConfiguration_DirectEditable();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl <em>Edge Object</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.EdgeObjectImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgeObject()
         * @generated
         */
        EClass EDGE_OBJECT = eINSTANCE.getEdgeObject();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDGE_OBJECT__ID = eINSTANCE.getEdgeObject_Id();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDGE_OBJECT__TYPE = eINSTANCE.getEdgeObject_Type();

        /**
         * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EDGE_OBJECT__ESTRUCTURAL_FEATURE = eINSTANCE.getEdgeObject_EStructuralFeature();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteItemImpl <em>Palette Item</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.PaletteItemImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPaletteItem()
         * @generated
         */
        EClass PALETTE_ITEM = eINSTANCE.getPaletteItem();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PALETTE_ITEM__NAME = eINSTANCE.getPaletteItem_Name();

        /**
         * The meta object literal for the '<em><b>Part</b></em>' reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference PALETTE_ITEM__PART = eINSTANCE.getPaletteItem_Part();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl <em>Source Target Couple</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getSourceTargetCouple()
         * @generated
         */
        EClass SOURCE_TARGET_COUPLE = eINSTANCE.getSourceTargetCouple();

        /**
         * The meta object literal for the '<em><b>Container Type</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SOURCE_TARGET_COUPLE__CONTAINER_TYPE = eINSTANCE.getSourceTargetCouple_ContainerType();

        /**
         * The meta object literal for the '<em><b>Auto Ref</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SOURCE_TARGET_COUPLE__AUTO_REF = eINSTANCE.getSourceTargetCouple_AutoRef();

        /**
         * The meta object literal for the '<em><b>Reversible</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SOURCE_TARGET_COUPLE__REVERSIBLE = eINSTANCE.getSourceTargetCouple_Reversible();

        /**
         * The meta object literal for the '<em><b>Container Object</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__CONTAINER_OBJECT = eINSTANCE.getSourceTargetCouple_ContainerObject();

        /**
         * The meta object literal for the '<em><b>Source Node</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__SOURCE_NODE = eINSTANCE.getSourceTargetCouple_SourceNode();

        /**
         * The meta object literal for the '<em><b>Target Node</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__TARGET_NODE = eINSTANCE.getSourceTargetCouple_TargetNode();

        /**
         * The meta object literal for the '<em><b>Container Ref</b></em>' reference feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__CONTAINER_REF = eINSTANCE.getSourceTargetCouple_ContainerRef();

        /**
         * The meta object literal for the '<em><b>Ref Source To Edge</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE = eINSTANCE.getSourceTargetCouple_RefSourceToEdge();

        /**
         * The meta object literal for the '<em><b>Ref Edge To Source</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE = eINSTANCE.getSourceTargetCouple_RefEdgeToSource();

        /**
         * The meta object literal for the '<em><b>Ref Target To Edge</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE = eINSTANCE.getSourceTargetCouple_RefTargetToEdge();

        /**
         * The meta object literal for the '<em><b>Ref Edge To Target</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET = eINSTANCE.getSourceTargetCouple_RefEdgeToTarget();

        /**
         * The meta object literal for the '<em><b>Ref Source To Target</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET = eINSTANCE.getSourceTargetCouple_RefSourceToTarget();

        /**
         * The meta object literal for the '<em><b>Ref Target To Source</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE = eINSTANCE.getSourceTargetCouple_RefTargetToSource();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.ModelObjectConfigurationImpl <em>Model Object Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.ModelObjectConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getModelObjectConfiguration()
         * @generated
         */
        EClass MODEL_OBJECT_CONFIGURATION = eINSTANCE.getModelObjectConfiguration();

        /**
         * The meta object literal for the '<em><b>Gen Class</b></em>' reference feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MODEL_OBJECT_CONFIGURATION__GEN_CLASS = eINSTANCE.getModelObjectConfiguration_GenClass();

        /**
         * The meta object literal for the '<em><b>Diagrams</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MODEL_OBJECT_CONFIGURATION__DIAGRAMS = eINSTANCE.getModelObjectConfiguration_Diagrams();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.SimpleObjectConfigurationImpl <em>Simple Object Configuration</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.SimpleObjectConfigurationImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getSimpleObjectConfiguration()
         * @generated
         */
        EClass SIMPLE_OBJECT_CONFIGURATION = eINSTANCE.getSimpleObjectConfiguration();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute SIMPLE_OBJECT_CONFIGURATION__NAME = eINSTANCE.getSimpleObjectConfiguration_Name();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.ConstraintImpl <em>Constraint</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.ConstraintImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getConstraint()
         * @generated
         */
        EClass CONSTRAINT = eINSTANCE.getConstraint();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSTRAINT__LANGUAGE = eINSTANCE.getConstraint_Language();

        /**
         * The meta object literal for the '<em><b>Rule</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSTRAINT__RULE = eINSTANCE.getConstraint_Rule();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl <em>Part Action</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.PartActionImpl
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getPartAction()
         * @generated
         */
        EClass PART_ACTION = eINSTANCE.getPartAction();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_ACTION__PREFIX = eINSTANCE.getPartAction_Prefix();

        /**
         * The meta object literal for the '<em><b>Menu Bar Group</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_ACTION__MENU_BAR_GROUP = eINSTANCE.getPartAction_MenuBarGroup();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_ACTION__LABEL = eINSTANCE.getPartAction_Label();

        /**
         * The meta object literal for the '<em><b>Icon</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PART_ACTION__ICON = eINSTANCE.getPartAction_Icon();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.EdgeContainerType <em>Edge Container Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.EdgeContainerType
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgeContainerType()
         * @generated
         */
        EEnum EDGE_CONTAINER_TYPE = eINSTANCE.getEdgeContainerType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.ResizableType <em>Resizable Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.ResizableType
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getResizableType()
         * @generated
         */
        EEnum RESIZABLE_TYPE = eINSTANCE.getResizableType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.LayoutType <em>Layout Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.LayoutType
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getLayoutType()
         * @generated
         */
        EEnum LAYOUT_TYPE = eINSTANCE.getLayoutType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.DecorationType <em>Decoration Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.DecorationType
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getDecorationType()
         * @generated
         */
        EEnum DECORATION_TYPE = eINSTANCE.getDecorationType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.RouterType <em>Router Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.RouterType
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getRouterType()
         * @generated
         */
        EEnum ROUTER_TYPE = eINSTANCE.getRouterType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.EdgeObjectType <em>Edge Object Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.EdgeObjectType
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getEdgeObjectType()
         * @generated
         */
        EEnum EDGE_OBJECT_TYPE = eINSTANCE.getEdgeObjectType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.diagramconfigurator.LineStyle <em>Line Style</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.diagramconfigurator.LineStyle
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getLineStyle()
         * @generated
         */
        EEnum LINE_STYLE = eINSTANCE.getLineStyle();

        /**
         * The meta object literal for the '<em>Color</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.swt.graphics.Color
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getColor()
         * @generated
         */
        EDataType COLOR = eINSTANCE.getColor();

        /**
         * The meta object literal for the '<em>Font</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.swt.graphics.Font
         * @see org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorPackageImpl#getFont()
         * @generated
         */
        EDataType FONT = eINSTANCE.getFont();

    }

} // DiagramconfiguratorPackage
