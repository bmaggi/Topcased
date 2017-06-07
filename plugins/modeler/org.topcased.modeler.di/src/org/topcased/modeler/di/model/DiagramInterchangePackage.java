/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangePackage.java,v 1.15 2009/07/02 16:42:42 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.topcased.modeler.di.model.DiagramInterchangeFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramInterchangePackage extends EPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The package name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "model"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/DI/1.0"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "di"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    DiagramInterchangePackage eINSTANCE = org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.PropertyImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getProperty()
     * @generated
     */
    int PROPERTY = 0;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Property</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.DiagramElementImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDiagramElement()
     * @generated
     */
    int DIAGRAM_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__VISIBLE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__PROPERTY = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__CONTAINER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__REFERENCE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Diagram Element</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl <em>Graph Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.GraphElementImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphElement()
     * @generated
     */
    int GRAPH_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__EANNOTATIONS = DIAGRAM_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__VISIBLE = DIAGRAM_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__PROPERTY = DIAGRAM_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__CONTAINER = DIAGRAM_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__REFERENCE = DIAGRAM_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Position</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__POSITION = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Anchorage</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__ANCHORAGE = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Semantic Model</b></em>' containment reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__SEMANTIC_MODEL = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Contained</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__CONTAINED = DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Link</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT__LINK = DIAGRAM_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Graph Element</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_ELEMENT_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.GraphEdgeImpl <em>Graph Edge</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.GraphEdgeImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphEdge()
     * @generated
     */
    int GRAPH_EDGE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__EANNOTATIONS = GRAPH_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__VISIBLE = GRAPH_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__PROPERTY = GRAPH_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__CONTAINER = GRAPH_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__REFERENCE = GRAPH_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Position</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__POSITION = GRAPH_ELEMENT__POSITION;

    /**
     * The feature id for the '<em><b>Anchorage</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__ANCHORAGE = GRAPH_ELEMENT__ANCHORAGE;

    /**
     * The feature id for the '<em><b>Semantic Model</b></em>' containment reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__SEMANTIC_MODEL = GRAPH_ELEMENT__SEMANTIC_MODEL;

    /**
     * The feature id for the '<em><b>Contained</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__CONTAINED = GRAPH_ELEMENT__CONTAINED;

    /**
     * The feature id for the '<em><b>Link</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__LINK = GRAPH_ELEMENT__LINK;

    /**
     * The feature id for the '<em><b>Waypoints</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__WAYPOINTS = GRAPH_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Anchor</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int GRAPH_EDGE__ANCHOR = GRAPH_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Graph Edge</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_EDGE_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.GraphNodeImpl <em>Graph Node</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.GraphNodeImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphNode()
     * @generated
     */
    int GRAPH_NODE = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__EANNOTATIONS = GRAPH_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__VISIBLE = GRAPH_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__PROPERTY = GRAPH_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__CONTAINER = GRAPH_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int GRAPH_NODE__REFERENCE = GRAPH_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Position</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__POSITION = GRAPH_ELEMENT__POSITION;

    /**
     * The feature id for the '<em><b>Anchorage</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__ANCHORAGE = GRAPH_ELEMENT__ANCHORAGE;

    /**
     * The feature id for the '<em><b>Semantic Model</b></em>' containment reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__SEMANTIC_MODEL = GRAPH_ELEMENT__SEMANTIC_MODEL;

    /**
     * The feature id for the '<em><b>Contained</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__CONTAINED = GRAPH_ELEMENT__CONTAINED;

    /**
     * The feature id for the '<em><b>Link</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__LINK = GRAPH_ELEMENT__LINK;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE__SIZE = GRAPH_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Graph Node</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_NODE_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.GraphConnectorImpl <em>Graph Connector</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.GraphConnectorImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphConnector()
     * @generated
     */
    int GRAPH_CONNECTOR = 5;

    /**
     * The feature id for the '<em><b>Position</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_CONNECTOR__POSITION = 0;

    /**
     * The feature id for the '<em><b>Graph Edge</b></em>' reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_CONNECTOR__GRAPH_EDGE = 1;

    /**
     * The feature id for the '<em><b>Graph Element</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_CONNECTOR__GRAPH_ELEMENT = 2;

    /**
     * The number of structural features of the '<em>Graph Connector</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPH_CONNECTOR_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.DiagramImpl <em>Diagram</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.DiagramImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDiagram()
     * @generated
     */
    int DIAGRAM = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__EANNOTATIONS = GRAPH_NODE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__VISIBLE = GRAPH_NODE__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__PROPERTY = GRAPH_NODE__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__CONTAINER = GRAPH_NODE__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM__REFERENCE = GRAPH_NODE__REFERENCE;

    /**
     * The feature id for the '<em><b>Position</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__POSITION = GRAPH_NODE__POSITION;

    /**
     * The feature id for the '<em><b>Anchorage</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__ANCHORAGE = GRAPH_NODE__ANCHORAGE;

    /**
     * The feature id for the '<em><b>Semantic Model</b></em>' containment reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__SEMANTIC_MODEL = GRAPH_NODE__SEMANTIC_MODEL;

    /**
     * The feature id for the '<em><b>Contained</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__CONTAINED = GRAPH_NODE__CONTAINED;

    /**
     * The feature id for the '<em><b>Link</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__LINK = GRAPH_NODE__LINK;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__SIZE = GRAPH_NODE__SIZE;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__NAME = GRAPH_NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__ZOOM = GRAPH_NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Viewport</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__VIEWPORT = GRAPH_NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Diagram Link</b></em>' reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM__DIAGRAM_LINK = GRAPH_NODE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Diagram</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_FEATURE_COUNT = GRAPH_NODE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.SemanticModelBridgeImpl <em>Semantic Model Bridge</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.SemanticModelBridgeImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getSemanticModelBridge()
     * @generated
     */
    int SEMANTIC_MODEL_BRIDGE = 7;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SEMANTIC_MODEL_BRIDGE__PRESENTATION = 0;

    /**
     * The feature id for the '<em><b>Graph Element</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = 1;

    /**
     * The number of structural features of the '<em>Semantic Model Bridge</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.EMFSemanticModelBridgeImpl <em>EMF Semantic Model Bridge</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.EMFSemanticModelBridgeImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEMFSemanticModelBridge()
     * @generated
     */
    int EMF_SEMANTIC_MODEL_BRIDGE = 8;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EMF_SEMANTIC_MODEL_BRIDGE__PRESENTATION = SEMANTIC_MODEL_BRIDGE__PRESENTATION;

    /**
     * The feature id for the '<em><b>Graph Element</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT;

    /**
     * The feature id for the '<em><b>Element</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>EMF Semantic Model Bridge</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.SimpleSemanticModelElementImpl <em>Simple Semantic Model Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.SimpleSemanticModelElementImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getSimpleSemanticModelElement()
     * @generated
     */
    int SIMPLE_SEMANTIC_MODEL_ELEMENT = 9;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SIMPLE_SEMANTIC_MODEL_ELEMENT__PRESENTATION = SEMANTIC_MODEL_BRIDGE__PRESENTATION;

    /**
     * The feature id for the '<em><b>Graph Element</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_SEMANTIC_MODEL_ELEMENT__GRAPH_ELEMENT = SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT;

    /**
     * The feature id for the '<em><b>Type Info</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Simple Semantic Model Element</em>' class.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_SEMANTIC_MODEL_ELEMENT_FEATURE_COUNT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl <em>Diagram Link</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDiagramLink()
     * @generated
     */
    int DIAGRAM_LINK = 10;

    /**
     * The feature id for the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_LINK__ZOOM = 0;

    /**
     * The feature id for the '<em><b>Viewport</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_LINK__VIEWPORT = 1;

    /**
     * The feature id for the '<em><b>Graph Element</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_LINK__GRAPH_ELEMENT = 2;

    /**
     * The feature id for the '<em><b>Diagram</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_LINK__DIAGRAM = 3;

    /**
     * The number of structural features of the '<em>Diagram Link</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int DIAGRAM_LINK_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.LeafElementImpl <em>Leaf Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.LeafElementImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getLeafElement()
     * @generated
     */
    int LEAF_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__EANNOTATIONS = DIAGRAM_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEAF_ELEMENT__VISIBLE = DIAGRAM_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int LEAF_ELEMENT__PROPERTY = DIAGRAM_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int LEAF_ELEMENT__CONTAINER = DIAGRAM_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int LEAF_ELEMENT__REFERENCE = DIAGRAM_ELEMENT__REFERENCE;

    /**
     * The number of structural features of the '<em>Leaf Element</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int LEAF_ELEMENT_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.TextElementImpl <em>Text Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.TextElementImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getTextElement()
     * @generated
     */
    int TEXT_ELEMENT = 12;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__EANNOTATIONS = LEAF_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ELEMENT__VISIBLE = LEAF_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ELEMENT__PROPERTY = LEAF_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ELEMENT__CONTAINER = LEAF_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TEXT_ELEMENT__REFERENCE = LEAF_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ELEMENT__TEXT = LEAF_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Text Element</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_ELEMENT_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.ImageImpl <em>Image</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.ImageImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getImage()
     * @generated
     */
    int IMAGE = 13;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__EANNOTATIONS = LEAF_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__VISIBLE = LEAF_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__PROPERTY = LEAF_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__CONTAINER = LEAF_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int IMAGE__REFERENCE = LEAF_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__URI = LEAF_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Mime Type</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__MIME_TYPE = LEAF_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Image</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int IMAGE_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.GraphicPrimitiveImpl <em>Graphic Primitive</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.GraphicPrimitiveImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphicPrimitive()
     * @generated
     */
    int GRAPHIC_PRIMITIVE = 14;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__EANNOTATIONS = LEAF_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHIC_PRIMITIVE__VISIBLE = LEAF_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHIC_PRIMITIVE__PROPERTY = LEAF_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHIC_PRIMITIVE__CONTAINER = LEAF_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int GRAPHIC_PRIMITIVE__REFERENCE = LEAF_ELEMENT__REFERENCE;

    /**
     * The number of structural features of the '<em>Graphic Primitive</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int GRAPHIC_PRIMITIVE_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.ReferenceImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getReference()
     * @generated
     */
    int REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__EANNOTATIONS = DIAGRAM_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__VISIBLE = DIAGRAM_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__PROPERTY = DIAGRAM_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__CONTAINER = DIAGRAM_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int REFERENCE__REFERENCE = DIAGRAM_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Is Individual Representation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__IS_INDIVIDUAL_REPRESENTATION = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Referenced</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__REFERENCED = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Reference</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.PolylineImpl <em>Polyline</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.PolylineImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getPolyline()
     * @generated
     */
    int POLYLINE = 16;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__EANNOTATIONS = GRAPHIC_PRIMITIVE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYLINE__VISIBLE = GRAPHIC_PRIMITIVE__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYLINE__PROPERTY = GRAPHIC_PRIMITIVE__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYLINE__CONTAINER = GRAPHIC_PRIMITIVE__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int POLYLINE__REFERENCE = GRAPHIC_PRIMITIVE__REFERENCE;

    /**
     * The feature id for the '<em><b>Waypoints</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int POLYLINE__WAYPOINTS = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Closed</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYLINE__CLOSED = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Polyline</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int POLYLINE_FEATURE_COUNT = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl <em>Ellipse</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.EllipseImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEllipse()
     * @generated
     */
    int ELLIPSE = 17;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__EANNOTATIONS = GRAPHIC_PRIMITIVE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__VISIBLE = GRAPHIC_PRIMITIVE__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__PROPERTY = GRAPHIC_PRIMITIVE__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__CONTAINER = GRAPHIC_PRIMITIVE__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ELLIPSE__REFERENCE = GRAPHIC_PRIMITIVE__REFERENCE;

    /**
     * The feature id for the '<em><b>Center</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__CENTER = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Radius X</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__RADIUS_X = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Radius Y</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__RADIUS_Y = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Rotation</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ROTATION = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Start Angle</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ELLIPSE__START_ANGLE = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>End Angle</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__END_ANGLE = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Ellipse</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ELLIPSE_FEATURE_COUNT = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectImpl <em>Edge Object</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.EdgeObjectImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEdgeObject()
     * @generated
     */
    int EDGE_OBJECT = 18;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OBJECT__EANNOTATIONS = LEAF_ELEMENT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__VISIBLE = LEAF_ELEMENT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__PROPERTY = LEAF_ELEMENT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__CONTAINER = LEAF_ELEMENT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__REFERENCE = LEAF_ELEMENT__REFERENCE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT__ID = LEAF_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Edge Object</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectOffsetImpl <em>Edge Object Offset</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.EdgeObjectOffsetImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEdgeObjectOffset()
     * @generated
     */
    int EDGE_OBJECT_OFFSET = 19;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OBJECT_OFFSET__EANNOTATIONS = EDGE_OBJECT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET__VISIBLE = EDGE_OBJECT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET__PROPERTY = EDGE_OBJECT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET__CONTAINER = EDGE_OBJECT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET__REFERENCE = EDGE_OBJECT__REFERENCE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET__ID = EDGE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET__OFFSET = EDGE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Edge Object Offset</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_OFFSET_FEATURE_COUNT = EDGE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectUVImpl <em>Edge Object UV</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.topcased.modeler.di.model.internal.impl.EdgeObjectUVImpl
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEdgeObjectUV()
     * @generated
     */
    int EDGE_OBJECT_UV = 20;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OBJECT_UV__EANNOTATIONS = EDGE_OBJECT__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__VISIBLE = EDGE_OBJECT__VISIBLE;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__PROPERTY = EDGE_OBJECT__PROPERTY;

    /**
     * The feature id for the '<em><b>Container</b></em>' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__CONTAINER = EDGE_OBJECT__CONTAINER;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__REFERENCE = EDGE_OBJECT__REFERENCE;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__ID = EDGE_OBJECT__ID;

    /**
     * The feature id for the '<em><b>UDistance</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__UDISTANCE = EDGE_OBJECT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>VDistance</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV__VDISTANCE = EDGE_OBJECT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Edge Object UV</em>' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    int EDGE_OBJECT_UV_FEATURE_COUNT = EDGE_OBJECT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '<em>Point</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.draw2d.geometry.Point
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getPoint()
     * @generated
     */
    int POINT = 21;

    /**
     * The meta object id for the '<em>Dimension</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.draw2d.geometry.Dimension
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDimension()
     * @generated
     */
    int DIMENSION = 22;

    /**
     * The meta object id for the '<em>Absolute Bendpoint</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.draw2d.AbsoluteBendpoint
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getAbsoluteBendpoint()
     * @generated
     */
    int ABSOLUTE_BENDPOINT = 23;

    /**
     * The meta object id for the '<em>Relative Bendpoint</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint
     * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getRelativeBendpoint()
     * @generated
     */
    int RELATIVE_BENDPOINT = 24;

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.Property <em>Property</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Property</em>'.
     * @see org.topcased.modeler.di.model.Property
     * @generated
     */
    EClass getProperty();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Property#getKey <em>Key</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.topcased.modeler.di.model.Property#getKey()
     * @see #getProperty()
     * @generated
     */
    EAttribute getProperty_Key();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Property#getValue <em>Value</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.topcased.modeler.di.model.Property#getValue()
     * @see #getProperty()
     * @generated
     */
    EAttribute getProperty_Value();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.DiagramElement <em>Diagram Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Diagram Element</em>'.
     * @see org.topcased.modeler.di.model.DiagramElement
     * @generated
     */
    EClass getDiagramElement();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.DiagramElement#isVisible <em>Visible</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visible</em>'.
     * @see org.topcased.modeler.di.model.DiagramElement#isVisible()
     * @see #getDiagramElement()
     * @generated
     */
    EAttribute getDiagramElement_Visible();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.di.model.DiagramElement#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property</em>'.
     * @see org.topcased.modeler.di.model.DiagramElement#getProperty()
     * @see #getDiagramElement()
     * @generated
     */
    EReference getDiagramElement_Property();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.modeler.di.model.DiagramElement#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Container</em>'.
     * @see org.topcased.modeler.di.model.DiagramElement#getContainer()
     * @see #getDiagramElement()
     * @generated
     */
    EReference getDiagramElement_Container();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.modeler.di.model.DiagramElement#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Reference</em>'.
     * @see org.topcased.modeler.di.model.DiagramElement#getReference()
     * @see #getDiagramElement()
     * @generated
     */
    EReference getDiagramElement_Reference();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.GraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Graph Element</em>'.
     * @see org.topcased.modeler.di.model.GraphElement
     * @generated
     */
    EClass getGraphElement();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.GraphElement#getPosition <em>Position</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Position</em>'.
     * @see org.topcased.modeler.di.model.GraphElement#getPosition()
     * @see #getGraphElement()
     * @generated
     */
    EAttribute getGraphElement_Position();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.di.model.GraphElement#getAnchorage <em>Anchorage</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Anchorage</em>'.
     * @see org.topcased.modeler.di.model.GraphElement#getAnchorage()
     * @see #getGraphElement()
     * @generated
     */
    EReference getGraphElement_Anchorage();

    /**
     * Returns the meta object for the containment reference '{@link org.topcased.modeler.di.model.GraphElement#getSemanticModel <em>Semantic Model</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Semantic Model</em>'.
     * @see org.topcased.modeler.di.model.GraphElement#getSemanticModel()
     * @see #getGraphElement()
     * @generated
     */
    EReference getGraphElement_SemanticModel();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.di.model.GraphElement#getContained <em>Contained</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Contained</em>'.
     * @see org.topcased.modeler.di.model.GraphElement#getContained()
     * @see #getGraphElement()
     * @generated
     */
    EReference getGraphElement_Contained();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.di.model.GraphElement#getLink <em>Link</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Link</em>'.
     * @see org.topcased.modeler.di.model.GraphElement#getLink()
     * @see #getGraphElement()
     * @generated
     */
    EReference getGraphElement_Link();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.GraphEdge <em>Graph Edge</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Graph Edge</em>'.
     * @see org.topcased.modeler.di.model.GraphEdge
     * @generated
     */
    EClass getGraphEdge();

    /**
     * Returns the meta object for the attribute list '{@link org.topcased.modeler.di.model.GraphEdge#getWaypoints <em>Waypoints</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Waypoints</em>'.
     * @see org.topcased.modeler.di.model.GraphEdge#getWaypoints()
     * @see #getGraphEdge()
     * @generated
     */
    EAttribute getGraphEdge_Waypoints();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.modeler.di.model.GraphEdge#getAnchor <em>Anchor</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Anchor</em>'.
     * @see org.topcased.modeler.di.model.GraphEdge#getAnchor()
     * @see #getGraphEdge()
     * @generated
     */
    EReference getGraphEdge_Anchor();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.GraphNode <em>Graph Node</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Graph Node</em>'.
     * @see org.topcased.modeler.di.model.GraphNode
     * @generated
     */
    EClass getGraphNode();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.GraphNode#getSize <em>Size</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size</em>'.
     * @see org.topcased.modeler.di.model.GraphNode#getSize()
     * @see #getGraphNode()
     * @generated
     */
    EAttribute getGraphNode_Size();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.GraphConnector <em>Graph Connector</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Graph Connector</em>'.
     * @see org.topcased.modeler.di.model.GraphConnector
     * @generated
     */
    EClass getGraphConnector();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.GraphConnector#getPosition <em>Position</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Position</em>'.
     * @see org.topcased.modeler.di.model.GraphConnector#getPosition()
     * @see #getGraphConnector()
     * @generated
     */
    EAttribute getGraphConnector_Position();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.modeler.di.model.GraphConnector#getGraphEdge <em>Graph Edge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Graph Edge</em>'.
     * @see org.topcased.modeler.di.model.GraphConnector#getGraphEdge()
     * @see #getGraphConnector()
     * @generated
     */
    EReference getGraphConnector_GraphEdge();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.modeler.di.model.GraphConnector#getGraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Graph Element</em>'.
     * @see org.topcased.modeler.di.model.GraphConnector#getGraphElement()
     * @see #getGraphConnector()
     * @generated
     */
    EReference getGraphConnector_GraphElement();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.Diagram <em>Diagram</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Diagram</em>'.
     * @see org.topcased.modeler.di.model.Diagram
     * @generated
     */
    EClass getDiagram();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Diagram#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.topcased.modeler.di.model.Diagram#getName()
     * @see #getDiagram()
     * @generated
     */
    EAttribute getDiagram_Name();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Diagram#getZoom <em>Zoom</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Zoom</em>'.
     * @see org.topcased.modeler.di.model.Diagram#getZoom()
     * @see #getDiagram()
     * @generated
     */
    EAttribute getDiagram_Zoom();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Diagram#getViewport <em>Viewport</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Viewport</em>'.
     * @see org.topcased.modeler.di.model.Diagram#getViewport()
     * @see #getDiagram()
     * @generated
     */
    EAttribute getDiagram_Viewport();

    /**
     * Returns the meta object for the reference list '{@link org.topcased.modeler.di.model.Diagram#getDiagramLink <em>Diagram Link</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Diagram Link</em>'.
     * @see org.topcased.modeler.di.model.Diagram#getDiagramLink()
     * @see #getDiagram()
     * @generated
     */
    EReference getDiagram_DiagramLink();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.SemanticModelBridge <em>Semantic Model Bridge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Semantic Model Bridge</em>'.
     * @see org.topcased.modeler.di.model.SemanticModelBridge
     * @generated
     */
    EClass getSemanticModelBridge();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.SemanticModelBridge#getPresentation <em>Presentation</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Presentation</em>'.
     * @see org.topcased.modeler.di.model.SemanticModelBridge#getPresentation()
     * @see #getSemanticModelBridge()
     * @generated
     */
    EAttribute getSemanticModelBridge_Presentation();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.modeler.di.model.SemanticModelBridge#getGraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Graph Element</em>'.
     * @see org.topcased.modeler.di.model.SemanticModelBridge#getGraphElement()
     * @see #getSemanticModelBridge()
     * @generated
     */
    EReference getSemanticModelBridge_GraphElement();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.EMFSemanticModelBridge <em>EMF Semantic Model Bridge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>EMF Semantic Model Bridge</em>'.
     * @see org.topcased.modeler.di.model.EMFSemanticModelBridge
     * @generated
     */
    EClass getEMFSemanticModelBridge();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.di.model.EMFSemanticModelBridge#getElement <em>Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Element</em>'.
     * @see org.topcased.modeler.di.model.EMFSemanticModelBridge#getElement()
     * @see #getEMFSemanticModelBridge()
     * @generated
     */
    EReference getEMFSemanticModelBridge_Element();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.SimpleSemanticModelElement <em>Simple Semantic Model Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Semantic Model Element</em>'.
     * @see org.topcased.modeler.di.model.SimpleSemanticModelElement
     * @generated
     */
    EClass getSimpleSemanticModelElement();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.SimpleSemanticModelElement#getTypeInfo <em>Type Info</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Info</em>'.
     * @see org.topcased.modeler.di.model.SimpleSemanticModelElement#getTypeInfo()
     * @see #getSimpleSemanticModelElement()
     * @generated
     */
    EAttribute getSimpleSemanticModelElement_TypeInfo();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.DiagramLink <em>Diagram Link</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Diagram Link</em>'.
     * @see org.topcased.modeler.di.model.DiagramLink
     * @generated
     */
    EClass getDiagramLink();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.DiagramLink#getZoom <em>Zoom</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Zoom</em>'.
     * @see org.topcased.modeler.di.model.DiagramLink#getZoom()
     * @see #getDiagramLink()
     * @generated
     */
    EAttribute getDiagramLink_Zoom();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.DiagramLink#getViewport <em>Viewport</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Viewport</em>'.
     * @see org.topcased.modeler.di.model.DiagramLink#getViewport()
     * @see #getDiagramLink()
     * @generated
     */
    EAttribute getDiagramLink_Viewport();

    /**
     * Returns the meta object for the container reference '{@link org.topcased.modeler.di.model.DiagramLink#getGraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Graph Element</em>'.
     * @see org.topcased.modeler.di.model.DiagramLink#getGraphElement()
     * @see #getDiagramLink()
     * @generated
     */
    EReference getDiagramLink_GraphElement();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.di.model.DiagramLink#getDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Diagram</em>'.
     * @see org.topcased.modeler.di.model.DiagramLink#getDiagram()
     * @see #getDiagramLink()
     * @generated
     */
    EReference getDiagramLink_Diagram();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.LeafElement <em>Leaf Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Leaf Element</em>'.
     * @see org.topcased.modeler.di.model.LeafElement
     * @generated
     */
    EClass getLeafElement();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.TextElement <em>Text Element</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Element</em>'.
     * @see org.topcased.modeler.di.model.TextElement
     * @generated
     */
    EClass getTextElement();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.TextElement#getText <em>Text</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see org.topcased.modeler.di.model.TextElement#getText()
     * @see #getTextElement()
     * @generated
     */
    EAttribute getTextElement_Text();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.Image <em>Image</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Image</em>'.
     * @see org.topcased.modeler.di.model.Image
     * @generated
     */
    EClass getImage();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Image#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.topcased.modeler.di.model.Image#getUri()
     * @see #getImage()
     * @generated
     */
    EAttribute getImage_Uri();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Image#getMimeType <em>Mime Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mime Type</em>'.
     * @see org.topcased.modeler.di.model.Image#getMimeType()
     * @see #getImage()
     * @generated
     */
    EAttribute getImage_MimeType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.GraphicPrimitive <em>Graphic Primitive</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Graphic Primitive</em>'.
     * @see org.topcased.modeler.di.model.GraphicPrimitive
     * @generated
     */
    EClass getGraphicPrimitive();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.Reference <em>Reference</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Reference</em>'.
     * @see org.topcased.modeler.di.model.Reference
     * @generated
     */
    EClass getReference();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Reference#isIsIndividualRepresentation <em>Is Individual Representation</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Individual Representation</em>'.
     * @see org.topcased.modeler.di.model.Reference#isIsIndividualRepresentation()
     * @see #getReference()
     * @generated
     */
    EAttribute getReference_IsIndividualRepresentation();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.di.model.Reference#getReferenced <em>Referenced</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referenced</em>'.
     * @see org.topcased.modeler.di.model.Reference#getReferenced()
     * @see #getReference()
     * @generated
     */
    EReference getReference_Referenced();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.Polyline <em>Polyline</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Polyline</em>'.
     * @see org.topcased.modeler.di.model.Polyline
     * @generated
     */
    EClass getPolyline();

    /**
     * Returns the meta object for the attribute list '{@link org.topcased.modeler.di.model.Polyline#getWaypoints <em>Waypoints</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Waypoints</em>'.
     * @see org.topcased.modeler.di.model.Polyline#getWaypoints()
     * @see #getPolyline()
     * @generated
     */
    EAttribute getPolyline_Waypoints();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Polyline#isClosed <em>Closed</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Closed</em>'.
     * @see org.topcased.modeler.di.model.Polyline#isClosed()
     * @see #getPolyline()
     * @generated
     */
    EAttribute getPolyline_Closed();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.Ellipse <em>Ellipse</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Ellipse</em>'.
     * @see org.topcased.modeler.di.model.Ellipse
     * @generated
     */
    EClass getEllipse();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Ellipse#getCenter <em>Center</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Center</em>'.
     * @see org.topcased.modeler.di.model.Ellipse#getCenter()
     * @see #getEllipse()
     * @generated
     */
    EAttribute getEllipse_Center();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Ellipse#getRadiusX <em>Radius X</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Radius X</em>'.
     * @see org.topcased.modeler.di.model.Ellipse#getRadiusX()
     * @see #getEllipse()
     * @generated
     */
    EAttribute getEllipse_RadiusX();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Ellipse#getRadiusY <em>Radius Y</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Radius Y</em>'.
     * @see org.topcased.modeler.di.model.Ellipse#getRadiusY()
     * @see #getEllipse()
     * @generated
     */
    EAttribute getEllipse_RadiusY();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Ellipse#getRotation <em>Rotation</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rotation</em>'.
     * @see org.topcased.modeler.di.model.Ellipse#getRotation()
     * @see #getEllipse()
     * @generated
     */
    EAttribute getEllipse_Rotation();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Ellipse#getStartAngle <em>Start Angle</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start Angle</em>'.
     * @see org.topcased.modeler.di.model.Ellipse#getStartAngle()
     * @see #getEllipse()
     * @generated
     */
    EAttribute getEllipse_StartAngle();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.Ellipse#getEndAngle <em>End Angle</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>End Angle</em>'.
     * @see org.topcased.modeler.di.model.Ellipse#getEndAngle()
     * @see #getEllipse()
     * @generated
     */
    EAttribute getEllipse_EndAngle();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.EdgeObject <em>Edge Object</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Edge Object</em>'.
     * @see org.topcased.modeler.di.model.EdgeObject
     * @generated
     */
    EClass getEdgeObject();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.EdgeObject#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.modeler.di.model.EdgeObject#getId()
     * @see #getEdgeObject()
     * @generated
     */
    EAttribute getEdgeObject_Id();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.EdgeObjectOffset <em>Edge Object Offset</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Edge Object Offset</em>'.
     * @see org.topcased.modeler.di.model.EdgeObjectOffset
     * @generated
     */
    EClass getEdgeObjectOffset();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.EdgeObjectOffset#getOffset <em>Offset</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Offset</em>'.
     * @see org.topcased.modeler.di.model.EdgeObjectOffset#getOffset()
     * @see #getEdgeObjectOffset()
     * @generated
     */
    EAttribute getEdgeObjectOffset_Offset();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.di.model.EdgeObjectUV <em>Edge Object UV</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for class '<em>Edge Object UV</em>'.
     * @see org.topcased.modeler.di.model.EdgeObjectUV
     * @generated
     */
    EClass getEdgeObjectUV();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.EdgeObjectUV#getUDistance <em>UDistance</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>UDistance</em>'.
     * @see org.topcased.modeler.di.model.EdgeObjectUV#getUDistance()
     * @see #getEdgeObjectUV()
     * @generated
     */
    EAttribute getEdgeObjectUV_UDistance();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.di.model.EdgeObjectUV#getVDistance <em>VDistance</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>VDistance</em>'.
     * @see org.topcased.modeler.di.model.EdgeObjectUV#getVDistance()
     * @see #getEdgeObjectUV()
     * @generated
     */
    EAttribute getEdgeObjectUV_VDistance();

    /**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Point <em>Point</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>Point</em>'.
     * @see org.eclipse.draw2d.geometry.Point
     * @model instanceClass="org.eclipse.draw2d.geometry.Point"
     * @generated
     */
    EDataType getPoint();

    /**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Dimension <em>Dimension</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for data type '<em>Dimension</em>'.
     * @see org.eclipse.draw2d.geometry.Dimension
     * @model instanceClass="org.eclipse.draw2d.geometry.Dimension"
     * @generated
     */
    EDataType getDimension();

    /**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.AbsoluteBendpoint <em>Absolute Bendpoint</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for data type '<em>Absolute Bendpoint</em>'.
     * @see org.eclipse.draw2d.AbsoluteBendpoint
     * @model instanceClass="org.eclipse.draw2d.AbsoluteBendpoint"
     * @generated
     */
    EDataType getAbsoluteBendpoint();

    /**
     * Returns the meta object for data type '{@link org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint <em>Relative Bendpoint</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the meta object for data type '<em>Relative Bendpoint</em>'.
     * @see org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint
     * @model instanceClass="org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"
     * @generated
     */
    EDataType getRelativeBendpoint();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DiagramInterchangeFactory getDiagramInterchangeFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.PropertyImpl <em>Property</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.PropertyImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getProperty()
         * @generated
         */
        EClass PROPERTY = eINSTANCE.getProperty();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY__KEY = eINSTANCE.getProperty_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.DiagramElementImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDiagramElement()
         * @generated
         */
        EClass DIAGRAM_ELEMENT = eINSTANCE.getDiagramElement();

        /**
         * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM_ELEMENT__VISIBLE = eINSTANCE.getDiagramElement_Visible();

        /**
         * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_ELEMENT__PROPERTY = eINSTANCE.getDiagramElement_Property();

        /**
         * The meta object literal for the '<em><b>Container</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_ELEMENT__CONTAINER = eINSTANCE.getDiagramElement_Container();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @generated
         */
        EReference DIAGRAM_ELEMENT__REFERENCE = eINSTANCE.getDiagramElement_Reference();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl <em>Graph Element</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.GraphElementImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphElement()
         * @generated
         */
        EClass GRAPH_ELEMENT = eINSTANCE.getGraphElement();

        /**
         * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPH_ELEMENT__POSITION = eINSTANCE.getGraphElement_Position();

        /**
         * The meta object literal for the '<em><b>Anchorage</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference GRAPH_ELEMENT__ANCHORAGE = eINSTANCE.getGraphElement_Anchorage();

        /**
         * The meta object literal for the '<em><b>Semantic Model</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference GRAPH_ELEMENT__SEMANTIC_MODEL = eINSTANCE.getGraphElement_SemanticModel();

        /**
         * The meta object literal for the '<em><b>Contained</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference GRAPH_ELEMENT__CONTAINED = eINSTANCE.getGraphElement_Contained();

        /**
         * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference GRAPH_ELEMENT__LINK = eINSTANCE.getGraphElement_Link();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.GraphEdgeImpl <em>Graph Edge</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.GraphEdgeImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphEdge()
         * @generated
         */
        EClass GRAPH_EDGE = eINSTANCE.getGraphEdge();

        /**
         * The meta object literal for the '<em><b>Waypoints</b></em>' attribute list feature.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPH_EDGE__WAYPOINTS = eINSTANCE.getGraphEdge_Waypoints();

        /**
         * The meta object literal for the '<em><b>Anchor</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GRAPH_EDGE__ANCHOR = eINSTANCE.getGraphEdge_Anchor();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.GraphNodeImpl <em>Graph Node</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.GraphNodeImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphNode()
         * @generated
         */
        EClass GRAPH_NODE = eINSTANCE.getGraphNode();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute GRAPH_NODE__SIZE = eINSTANCE.getGraphNode_Size();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.GraphConnectorImpl <em>Graph Connector</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.GraphConnectorImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphConnector()
         * @generated
         */
        EClass GRAPH_CONNECTOR = eINSTANCE.getGraphConnector();

        /**
         * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRAPH_CONNECTOR__POSITION = eINSTANCE.getGraphConnector_Position();

        /**
         * The meta object literal for the '<em><b>Graph Edge</b></em>' reference list feature.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @generated
         */
        EReference GRAPH_CONNECTOR__GRAPH_EDGE = eINSTANCE.getGraphConnector_GraphEdge();

        /**
         * The meta object literal for the '<em><b>Graph Element</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference GRAPH_CONNECTOR__GRAPH_ELEMENT = eINSTANCE.getGraphConnector_GraphElement();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.DiagramImpl <em>Diagram</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.DiagramImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDiagram()
         * @generated
         */
        EClass DIAGRAM = eINSTANCE.getDiagram();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM__NAME = eINSTANCE.getDiagram_Name();

        /**
         * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM__ZOOM = eINSTANCE.getDiagram_Zoom();

        /**
         * The meta object literal for the '<em><b>Viewport</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM__VIEWPORT = eINSTANCE.getDiagram_Viewport();

        /**
         * The meta object literal for the '<em><b>Diagram Link</b></em>' reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM__DIAGRAM_LINK = eINSTANCE.getDiagram_DiagramLink();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.SemanticModelBridgeImpl <em>Semantic Model Bridge</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.SemanticModelBridgeImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getSemanticModelBridge()
         * @generated
         */
        EClass SEMANTIC_MODEL_BRIDGE = eINSTANCE.getSemanticModelBridge();

        /**
         * The meta object literal for the '<em><b>Presentation</b></em>' attribute feature.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @generated
         */
        EAttribute SEMANTIC_MODEL_BRIDGE__PRESENTATION = eINSTANCE.getSemanticModelBridge_Presentation();

        /**
         * The meta object literal for the '<em><b>Graph Element</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = eINSTANCE.getSemanticModelBridge_GraphElement();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.EMFSemanticModelBridgeImpl <em>EMF Semantic Model Bridge</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.EMFSemanticModelBridgeImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEMFSemanticModelBridge()
         * @generated
         */
        EClass EMF_SEMANTIC_MODEL_BRIDGE = eINSTANCE.getEMFSemanticModelBridge();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT = eINSTANCE.getEMFSemanticModelBridge_Element();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.SimpleSemanticModelElementImpl <em>Simple Semantic Model Element</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.SimpleSemanticModelElementImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getSimpleSemanticModelElement()
         * @generated
         */
        EClass SIMPLE_SEMANTIC_MODEL_ELEMENT = eINSTANCE.getSimpleSemanticModelElement();

        /**
         * The meta object literal for the '<em><b>Type Info</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO = eINSTANCE.getSimpleSemanticModelElement_TypeInfo();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl <em>Diagram Link</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDiagramLink()
         * @generated
         */
        EClass DIAGRAM_LINK = eINSTANCE.getDiagramLink();

        /**
         * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM_LINK__ZOOM = eINSTANCE.getDiagramLink_Zoom();

        /**
         * The meta object literal for the '<em><b>Viewport</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIAGRAM_LINK__VIEWPORT = eINSTANCE.getDiagramLink_Viewport();

        /**
         * The meta object literal for the '<em><b>Graph Element</b></em>' container reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_LINK__GRAPH_ELEMENT = eINSTANCE.getDiagramLink_GraphElement();

        /**
         * The meta object literal for the '<em><b>Diagram</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DIAGRAM_LINK__DIAGRAM = eINSTANCE.getDiagramLink_Diagram();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.LeafElementImpl <em>Leaf Element</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.LeafElementImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getLeafElement()
         * @generated
         */
        EClass LEAF_ELEMENT = eINSTANCE.getLeafElement();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.TextElementImpl <em>Text Element</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.TextElementImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getTextElement()
         * @generated
         */
        EClass TEXT_ELEMENT = eINSTANCE.getTextElement();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute TEXT_ELEMENT__TEXT = eINSTANCE.getTextElement_Text();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.ImageImpl <em>Image</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.ImageImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getImage()
         * @generated
         */
        EClass IMAGE = eINSTANCE.getImage();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute IMAGE__URI = eINSTANCE.getImage_Uri();

        /**
         * The meta object literal for the '<em><b>Mime Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE__MIME_TYPE = eINSTANCE.getImage_MimeType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.GraphicPrimitiveImpl <em>Graphic Primitive</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.GraphicPrimitiveImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getGraphicPrimitive()
         * @generated
         */
        EClass GRAPHIC_PRIMITIVE = eINSTANCE.getGraphicPrimitive();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.ReferenceImpl <em>Reference</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.ReferenceImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getReference()
         * @generated
         */
        EClass REFERENCE = eINSTANCE.getReference();

        /**
         * The meta object literal for the '<em><b>Is Individual Representation</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute REFERENCE__IS_INDIVIDUAL_REPRESENTATION = eINSTANCE.getReference_IsIndividualRepresentation();

        /**
         * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE__REFERENCED = eINSTANCE.getReference_Referenced();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.PolylineImpl <em>Polyline</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.PolylineImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getPolyline()
         * @generated
         */
        EClass POLYLINE = eINSTANCE.getPolyline();

        /**
         * The meta object literal for the '<em><b>Waypoints</b></em>' attribute list feature.
         * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * @generated
         */
        EAttribute POLYLINE__WAYPOINTS = eINSTANCE.getPolyline_Waypoints();

        /**
         * The meta object literal for the '<em><b>Closed</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute POLYLINE__CLOSED = eINSTANCE.getPolyline_Closed();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl <em>Ellipse</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.EllipseImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEllipse()
         * @generated
         */
        EClass ELLIPSE = eINSTANCE.getEllipse();

        /**
         * The meta object literal for the '<em><b>Center</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute ELLIPSE__CENTER = eINSTANCE.getEllipse_Center();

        /**
         * The meta object literal for the '<em><b>Radius X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELLIPSE__RADIUS_X = eINSTANCE.getEllipse_RadiusX();

        /**
         * The meta object literal for the '<em><b>Radius Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELLIPSE__RADIUS_Y = eINSTANCE.getEllipse_RadiusY();

        /**
         * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELLIPSE__ROTATION = eINSTANCE.getEllipse_Rotation();

        /**
         * The meta object literal for the '<em><b>Start Angle</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELLIPSE__START_ANGLE = eINSTANCE.getEllipse_StartAngle();

        /**
         * The meta object literal for the '<em><b>End Angle</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ELLIPSE__END_ANGLE = eINSTANCE.getEllipse_EndAngle();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectImpl <em>Edge Object</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.EdgeObjectImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEdgeObject()
         * @generated
         */
        EClass EDGE_OBJECT = eINSTANCE.getEdgeObject();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute EDGE_OBJECT__ID = eINSTANCE.getEdgeObject_Id();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectOffsetImpl <em>Edge Object Offset</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.EdgeObjectOffsetImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEdgeObjectOffset()
         * @generated
         */
        EClass EDGE_OBJECT_OFFSET = eINSTANCE.getEdgeObjectOffset();

        /**
         * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @generated
         */
        EAttribute EDGE_OBJECT_OFFSET__OFFSET = eINSTANCE.getEdgeObjectOffset_Offset();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectUVImpl <em>Edge Object UV</em>}' class.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.topcased.modeler.di.model.internal.impl.EdgeObjectUVImpl
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getEdgeObjectUV()
         * @generated
         */
        EClass EDGE_OBJECT_UV = eINSTANCE.getEdgeObjectUV();

        /**
         * The meta object literal for the '<em><b>UDistance</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EDGE_OBJECT_UV__UDISTANCE = eINSTANCE.getEdgeObjectUV_UDistance();

        /**
         * The meta object literal for the '<em><b>VDistance</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EDGE_OBJECT_UV__VDISTANCE = eINSTANCE.getEdgeObjectUV_VDistance();

        /**
         * The meta object literal for the '<em>Point</em>' data type.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
         * @see org.eclipse.draw2d.geometry.Point
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getPoint()
         * @generated
         */
        EDataType POINT = eINSTANCE.getPoint();

        /**
         * The meta object literal for the '<em>Dimension</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see org.eclipse.draw2d.geometry.Dimension
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getDimension()
         * @generated
         */
        EDataType DIMENSION = eINSTANCE.getDimension();

        /**
         * The meta object literal for the '<em>Absolute Bendpoint</em>' data type.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @see org.eclipse.draw2d.AbsoluteBendpoint
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getAbsoluteBendpoint()
         * @generated
         */
        EDataType ABSOLUTE_BENDPOINT = eINSTANCE.getAbsoluteBendpoint();

        /**
         * The meta object literal for the '<em>Relative Bendpoint</em>' data type.
         * <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * @see org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint
         * @see org.topcased.modeler.di.model.internal.impl.DiagramInterchangePackageImpl#getRelativeBendpoint()
         * @generated
         */
        EDataType RELATIVE_BENDPOINT = eINSTANCE.getRelativeBendpoint();

    }

} // DiagramInterchangePackage
