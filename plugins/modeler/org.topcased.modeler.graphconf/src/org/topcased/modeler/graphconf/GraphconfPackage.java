/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfPackage.java,v 1.4 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.topcased.modeler.graphconf.GraphconfFactory
 * @model kind="package"
 * @generated
 */
public interface GraphconfPackage extends EPackage
{
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "graphconf";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/1.0/graphconf";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "graphconf";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    GraphconfPackage eINSTANCE = org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl <em>Abstract Graph Conf</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getAbstractGraphConf()
     * @generated
     */
    int ABSTRACT_GRAPH_CONF = 0;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__PRESENTATION = 0;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR = 1;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__DEFAULT_FONT = 2;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__LINE_WIDTH = 3;

    /**
     * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__LINE_STYLE = 4;

    /**
     * The feature id for the '<em><b>Bridge</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__BRIDGE = 5;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF__CONSTRAINT = 6;

    /**
     * The number of structural features of the '<em>Abstract Graph Conf</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_GRAPH_CONF_FEATURE_COUNT = 7;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl <em>Diagram Graph Conf</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getDiagramGraphConf()
     * @generated
     */
    int DIAGRAM_GRAPH_CONF = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF__ID = 0;

    /**
     * The feature id for the '<em><b>Node</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF__NODE = 1;

    /**
     * The feature id for the '<em><b>Edge</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF__EDGE = 2;

    /**
     * The feature id for the '<em><b>Default Background Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR = 3;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR = 4;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF__DEFAULT_FONT = 5;

    /**
     * The number of structural features of the '<em>Diagram Graph Conf</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DIAGRAM_GRAPH_CONF_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl <em>Node Graph Conf</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getNodeGraphConf()
     * @generated
     */
    int NODE_GRAPH_CONF = 2;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__PRESENTATION = ABSTRACT_GRAPH_CONF__PRESENTATION;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR = ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__DEFAULT_FONT = ABSTRACT_GRAPH_CONF__DEFAULT_FONT;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__LINE_WIDTH = ABSTRACT_GRAPH_CONF__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__LINE_STYLE = ABSTRACT_GRAPH_CONF__LINE_STYLE;

    /**
     * The feature id for the '<em><b>Bridge</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__BRIDGE = ABSTRACT_GRAPH_CONF__BRIDGE;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__CONSTRAINT = ABSTRACT_GRAPH_CONF__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Default Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__DEFAULT_WIDTH = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Default Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__DEFAULT_HEIGHT = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Minimum Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__MINIMUM_WIDTH = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Minimum Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__MINIMUM_HEIGHT = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Maximum Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__MAXIMUM_WIDTH = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Maximum Height</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__MAXIMUM_HEIGHT = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Is Width Resizable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Is Height Resizable</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Default Background Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Node Graph Conf</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NODE_GRAPH_CONF_FEATURE_COUNT = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 9;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.EdgeGraphConfImpl <em>Edge Graph Conf</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.EdgeGraphConfImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getEdgeGraphConf()
     * @generated
     */
    int EDGE_GRAPH_CONF = 3;

    /**
     * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__PRESENTATION = ABSTRACT_GRAPH_CONF__PRESENTATION;

    /**
     * The feature id for the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR = ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__DEFAULT_FONT = ABSTRACT_GRAPH_CONF__DEFAULT_FONT;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__LINE_WIDTH = ABSTRACT_GRAPH_CONF__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__LINE_STYLE = ABSTRACT_GRAPH_CONF__LINE_STYLE;

    /**
     * The feature id for the '<em><b>Bridge</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__BRIDGE = ABSTRACT_GRAPH_CONF__BRIDGE;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__CONSTRAINT = ABSTRACT_GRAPH_CONF__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Default Router</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF__DEFAULT_ROUTER = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Edge Graph Conf</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EDGE_GRAPH_CONF_FEATURE_COUNT = ABSTRACT_GRAPH_CONF_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.BridgeImpl <em>Bridge</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.BridgeImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getBridge()
     * @generated
     */
    int BRIDGE = 4;

    /**
     * The number of structural features of the '<em>Bridge</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BRIDGE_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.EMFBridgeImpl <em>EMF Bridge</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.EMFBridgeImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getEMFBridge()
     * @generated
     */
    int EMF_BRIDGE = 5;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EMF_BRIDGE__TYPE = BRIDGE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>EMF Bridge</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EMF_BRIDGE_FEATURE_COUNT = BRIDGE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.StringBridgeImpl <em>String Bridge</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.StringBridgeImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getStringBridge()
     * @generated
     */
    int STRING_BRIDGE = 6;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_BRIDGE__TYPE = BRIDGE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Bridge</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_BRIDGE_FEATURE_COUNT = BRIDGE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.internal.impl.ConstraintImpl <em>Constraint</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.internal.impl.ConstraintImpl
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getConstraint()
     * @generated
     */
    int CONSTRAINT = 7;

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
     * The meta object id for the '{@link org.topcased.modeler.graphconf.LineStyle <em>Line Style</em>}' enum. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.LineStyle
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getLineStyle()
     * @generated
     */
    int LINE_STYLE = 8;

    /**
     * The meta object id for the '{@link org.topcased.modeler.graphconf.RouterType <em>Router Type</em>}' enum. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.graphconf.RouterType
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getRouterType()
     * @generated
     */
    int ROUTER_TYPE = 9;

    /**
     * The meta object id for the '<em>Color</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.swt.graphics.Color
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getColor()
     * @generated
     */
    int COLOR = 10;

    /**
     * The meta object id for the '<em>Font</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.swt.graphics.Font
     * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getFont()
     * @generated
     */
    int FONT = 11;

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.AbstractGraphConf <em>Abstract Graph Conf</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Abstract Graph Conf</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf
     * @generated
     */
    EClass getAbstractGraphConf();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getPresentation <em>Presentation</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Presentation</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getPresentation()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EAttribute getAbstractGraphConf_Presentation();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultForegroundColor <em>Default Foreground Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Foreground Color</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultForegroundColor()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EAttribute getAbstractGraphConf_DefaultForegroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultFont <em>Default Font</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Font</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultFont()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EAttribute getAbstractGraphConf_DefaultFont();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getLineWidth <em>Line Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Line Width</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getLineWidth()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EAttribute getAbstractGraphConf_LineWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getLineStyle <em>Line Style</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Line Style</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getLineStyle()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EAttribute getAbstractGraphConf_LineStyle();

    /**
     * Returns the meta object for the containment reference '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getBridge <em>Bridge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Bridge</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getBridge()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EReference getAbstractGraphConf_Bridge();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getConstraint <em>Constraint</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Constraint</em>'.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf#getConstraint()
     * @see #getAbstractGraphConf()
     * @generated
     */
    EReference getAbstractGraphConf_Constraint();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.DiagramGraphConf <em>Diagram Graph Conf</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Diagram Graph Conf</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf
     * @generated
     */
    EClass getDiagramGraphConf();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getNode <em>Node</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Node</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getNode()
     * @see #getDiagramGraphConf()
     * @generated
     */
    EReference getDiagramGraphConf_Node();

    /**
     * Returns the meta object for the containment reference list '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getEdge <em>Edge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Edge</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getEdge()
     * @see #getDiagramGraphConf()
     * @generated
     */
    EReference getDiagramGraphConf_Edge();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultBackgroundColor <em>Default Background Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Background Color</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultBackgroundColor()
     * @see #getDiagramGraphConf()
     * @generated
     */
    EAttribute getDiagramGraphConf_DefaultBackgroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultForegroundColor <em>Default Foreground Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Foreground Color</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultForegroundColor()
     * @see #getDiagramGraphConf()
     * @generated
     */
    EAttribute getDiagramGraphConf_DefaultForegroundColor();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultFont <em>Default Font</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Font</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getDefaultFont()
     * @see #getDiagramGraphConf()
     * @generated
     */
    EAttribute getDiagramGraphConf_DefaultFont();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.DiagramGraphConf#getId <em>Id</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf#getId()
     * @see #getDiagramGraphConf()
     * @generated
     */
    EAttribute getDiagramGraphConf_Id();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.NodeGraphConf <em>Node Graph Conf</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Node Graph Conf</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf
     * @generated
     */
    EClass getNodeGraphConf();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultWidth <em>Default Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Width</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getDefaultWidth()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_DefaultWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultHeight <em>Default Height</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Height</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getDefaultHeight()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_DefaultHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMinimumWidth <em>Minimum Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Minimum Width</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getMinimumWidth()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_MinimumWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMinimumHeight <em>Minimum Height</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Minimum Height</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getMinimumHeight()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_MinimumHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMaximumWidth <em>Maximum Width</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Maximum Width</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getMaximumWidth()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_MaximumWidth();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMaximumHeight <em>Maximum Height</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Maximum Height</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getMaximumHeight()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_MaximumHeight();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#isIsWidthResizable <em>Is Width Resizable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Is Width Resizable</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#isIsWidthResizable()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_IsWidthResizable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#isIsHeightResizable <em>Is Height Resizable</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Is Height Resizable</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#isIsHeightResizable()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_IsHeightResizable();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultBackgroundColor <em>Default Background Color</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Background Color</em>'.
     * @see org.topcased.modeler.graphconf.NodeGraphConf#getDefaultBackgroundColor()
     * @see #getNodeGraphConf()
     * @generated
     */
    EAttribute getNodeGraphConf_DefaultBackgroundColor();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.EdgeGraphConf <em>Edge Graph Conf</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Edge Graph Conf</em>'.
     * @see org.topcased.modeler.graphconf.EdgeGraphConf
     * @generated
     */
    EClass getEdgeGraphConf();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.EdgeGraphConf#getDefaultRouter <em>Default Router</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Default Router</em>'.
     * @see org.topcased.modeler.graphconf.EdgeGraphConf#getDefaultRouter()
     * @see #getEdgeGraphConf()
     * @generated
     */
    EAttribute getEdgeGraphConf_DefaultRouter();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.Bridge <em>Bridge</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Bridge</em>'.
     * @see org.topcased.modeler.graphconf.Bridge
     * @generated
     */
    EClass getBridge();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.EMFBridge <em>EMF Bridge</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>EMF Bridge</em>'.
     * @see org.topcased.modeler.graphconf.EMFBridge
     * @generated
     */
    EClass getEMFBridge();

    /**
     * Returns the meta object for the reference '{@link org.topcased.modeler.graphconf.EMFBridge#getType <em>Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Type</em>'.
     * @see org.topcased.modeler.graphconf.EMFBridge#getType()
     * @see #getEMFBridge()
     * @generated
     */
    EReference getEMFBridge_Type();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.StringBridge <em>String Bridge</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>String Bridge</em>'.
     * @see org.topcased.modeler.graphconf.StringBridge
     * @generated
     */
    EClass getStringBridge();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.StringBridge#getType <em>Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.topcased.modeler.graphconf.StringBridge#getType()
     * @see #getStringBridge()
     * @generated
     */
    EAttribute getStringBridge_Type();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.graphconf.Constraint <em>Constraint</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Constraint</em>'.
     * @see org.topcased.modeler.graphconf.Constraint
     * @generated
     */
    EClass getConstraint();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.Constraint#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.topcased.modeler.graphconf.Constraint#getLanguage()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Language();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.graphconf.Constraint#getRule <em>Rule</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Rule</em>'.
     * @see org.topcased.modeler.graphconf.Constraint#getRule()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Rule();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.graphconf.LineStyle <em>Line Style</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Line Style</em>'.
     * @see org.topcased.modeler.graphconf.LineStyle
     * @generated
     */
    EEnum getLineStyle();

    /**
     * Returns the meta object for enum '{@link org.topcased.modeler.graphconf.RouterType <em>Router Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Router Type</em>'.
     * @see org.topcased.modeler.graphconf.RouterType
     * @generated
     */
    EEnum getRouterType();

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
    GraphconfFactory getGraphconfFactory();

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
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl <em>Abstract Graph Conf</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.AbstractGraphConfImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getAbstractGraphConf()
         * @generated
         */
        EClass ABSTRACT_GRAPH_CONF = eINSTANCE.getAbstractGraphConf();

        /**
         * The meta object literal for the '<em><b>Presentation</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_GRAPH_CONF__PRESENTATION = eINSTANCE.getAbstractGraphConf_Presentation();

        /**
         * The meta object literal for the '<em><b>Default Foreground Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR = eINSTANCE.getAbstractGraphConf_DefaultForegroundColor();

        /**
         * The meta object literal for the '<em><b>Default Font</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_GRAPH_CONF__DEFAULT_FONT = eINSTANCE.getAbstractGraphConf_DefaultFont();

        /**
         * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_GRAPH_CONF__LINE_WIDTH = eINSTANCE.getAbstractGraphConf_LineWidth();

        /**
         * The meta object literal for the '<em><b>Line Style</b></em>' attribute feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_GRAPH_CONF__LINE_STYLE = eINSTANCE.getAbstractGraphConf_LineStyle();

        /**
         * The meta object literal for the '<em><b>Bridge</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ABSTRACT_GRAPH_CONF__BRIDGE = eINSTANCE.getAbstractGraphConf_Bridge();

        /**
         * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ABSTRACT_GRAPH_CONF__CONSTRAINT = eINSTANCE.getAbstractGraphConf_Constraint();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl <em>Diagram Graph Conf</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.DiagramGraphConfImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getDiagramGraphConf()
         * @generated
         */
        EClass DIAGRAM_GRAPH_CONF = eINSTANCE.getDiagramGraphConf();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_GRAPH_CONF__NODE = eINSTANCE.getDiagramGraphConf_Node();

        /**
         * The meta object literal for the '<em><b>Edge</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DIAGRAM_GRAPH_CONF__EDGE = eINSTANCE.getDiagramGraphConf_Edge();

        /**
         * The meta object literal for the '<em><b>Default Background Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR = eINSTANCE.getDiagramGraphConf_DefaultBackgroundColor();

        /**
         * The meta object literal for the '<em><b>Default Foreground Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR = eINSTANCE.getDiagramGraphConf_DefaultForegroundColor();

        /**
         * The meta object literal for the '<em><b>Default Font</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_GRAPH_CONF__DEFAULT_FONT = eINSTANCE.getDiagramGraphConf_DefaultFont();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute DIAGRAM_GRAPH_CONF__ID = eINSTANCE.getDiagramGraphConf_Id();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl <em>Node Graph Conf</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.NodeGraphConfImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getNodeGraphConf()
         * @generated
         */
        EClass NODE_GRAPH_CONF = eINSTANCE.getNodeGraphConf();

        /**
         * The meta object literal for the '<em><b>Default Width</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__DEFAULT_WIDTH = eINSTANCE.getNodeGraphConf_DefaultWidth();

        /**
         * The meta object literal for the '<em><b>Default Height</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__DEFAULT_HEIGHT = eINSTANCE.getNodeGraphConf_DefaultHeight();

        /**
         * The meta object literal for the '<em><b>Minimum Width</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__MINIMUM_WIDTH = eINSTANCE.getNodeGraphConf_MinimumWidth();

        /**
         * The meta object literal for the '<em><b>Minimum Height</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__MINIMUM_HEIGHT = eINSTANCE.getNodeGraphConf_MinimumHeight();

        /**
         * The meta object literal for the '<em><b>Maximum Width</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__MAXIMUM_WIDTH = eINSTANCE.getNodeGraphConf_MaximumWidth();

        /**
         * The meta object literal for the '<em><b>Maximum Height</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__MAXIMUM_HEIGHT = eINSTANCE.getNodeGraphConf_MaximumHeight();

        /**
         * The meta object literal for the '<em><b>Is Width Resizable</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE = eINSTANCE.getNodeGraphConf_IsWidthResizable();

        /**
         * The meta object literal for the '<em><b>Is Height Resizable</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE = eINSTANCE.getNodeGraphConf_IsHeightResizable();

        /**
         * The meta object literal for the '<em><b>Default Background Color</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR = eINSTANCE.getNodeGraphConf_DefaultBackgroundColor();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.EdgeGraphConfImpl <em>Edge Graph Conf</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.EdgeGraphConfImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getEdgeGraphConf()
         * @generated
         */
        EClass EDGE_GRAPH_CONF = eINSTANCE.getEdgeGraphConf();

        /**
         * The meta object literal for the '<em><b>Default Router</b></em>' attribute feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute EDGE_GRAPH_CONF__DEFAULT_ROUTER = eINSTANCE.getEdgeGraphConf_DefaultRouter();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.BridgeImpl <em>Bridge</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.BridgeImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getBridge()
         * @generated
         */
        EClass BRIDGE = eINSTANCE.getBridge();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.EMFBridgeImpl <em>EMF Bridge</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.EMFBridgeImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getEMFBridge()
         * @generated
         */
        EClass EMF_BRIDGE = eINSTANCE.getEMFBridge();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference EMF_BRIDGE__TYPE = eINSTANCE.getEMFBridge_Type();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.StringBridgeImpl <em>String Bridge</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.StringBridgeImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getStringBridge()
         * @generated
         */
        EClass STRING_BRIDGE = eINSTANCE.getStringBridge();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute STRING_BRIDGE__TYPE = eINSTANCE.getStringBridge_Type();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.internal.impl.ConstraintImpl <em>Constraint</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.internal.impl.ConstraintImpl
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getConstraint()
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
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.LineStyle <em>Line Style</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.LineStyle
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getLineStyle()
         * @generated
         */
        EEnum LINE_STYLE = eINSTANCE.getLineStyle();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.graphconf.RouterType <em>Router Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.graphconf.RouterType
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getRouterType()
         * @generated
         */
        EEnum ROUTER_TYPE = eINSTANCE.getRouterType();

        /**
         * The meta object literal for the '<em>Color</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.swt.graphics.Color
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getColor()
         * @generated
         */
        EDataType COLOR = eINSTANCE.getColor();

        /**
         * The meta object literal for the '<em>Font</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.eclipse.swt.graphics.Font
         * @see org.topcased.modeler.graphconf.internal.impl.GraphconfPackageImpl#getFont()
         * @generated
         */
        EDataType FONT = eINSTANCE.getFont();

    }

} // GraphconfPackage
