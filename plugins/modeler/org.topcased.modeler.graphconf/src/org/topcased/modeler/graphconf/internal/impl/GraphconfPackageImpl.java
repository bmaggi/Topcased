/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfPackageImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.topcased.modeler.graphconf.AbstractGraphConf;
import org.topcased.modeler.graphconf.Bridge;
import org.topcased.modeler.graphconf.Constraint;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.GraphconfFactory;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.LineStyle;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.graphconf.RouterType;
import org.topcased.modeler.graphconf.StringBridge;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class GraphconfPackageImpl extends EPackageImpl implements GraphconfPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractGraphConfEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass diagramGraphConfEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nodeGraphConfEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass edgeGraphConfEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass bridgeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass emfBridgeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stringBridgeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass constraintEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum lineStyleEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum routerTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType colorEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType fontEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.graphconf.GraphconfPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private GraphconfPackageImpl()
    {
        super(eNS_URI, GraphconfFactory.eINSTANCE);
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
    public static GraphconfPackage init()
    {
        if (isInited)
            return (GraphconfPackage) EPackage.Registry.INSTANCE.getEPackage(GraphconfPackage.eNS_URI);

        // Obtain or create and register package
        GraphconfPackageImpl theGraphconfPackage = (GraphconfPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof GraphconfPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
                : new GraphconfPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theGraphconfPackage.createPackageContents();

        // Initialize created meta-data
        theGraphconfPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theGraphconfPackage.freeze();

        return theGraphconfPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAbstractGraphConf()
    {
        return abstractGraphConfEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractGraphConf_Presentation()
    {
        return (EAttribute) abstractGraphConfEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractGraphConf_DefaultForegroundColor()
    {
        return (EAttribute) abstractGraphConfEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractGraphConf_DefaultFont()
    {
        return (EAttribute) abstractGraphConfEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractGraphConf_LineWidth()
    {
        return (EAttribute) abstractGraphConfEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAbstractGraphConf_LineStyle()
    {
        return (EAttribute) abstractGraphConfEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAbstractGraphConf_Bridge()
    {
        return (EReference) abstractGraphConfEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAbstractGraphConf_Constraint()
    {
        return (EReference) abstractGraphConfEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDiagramGraphConf()
    {
        return diagramGraphConfEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramGraphConf_Id()
    {
        return (EAttribute) diagramGraphConfEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramGraphConf_Node()
    {
        return (EReference) diagramGraphConfEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramGraphConf_Edge()
    {
        return (EReference) diagramGraphConfEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramGraphConf_DefaultBackgroundColor()
    {
        return (EAttribute) diagramGraphConfEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramGraphConf_DefaultForegroundColor()
    {
        return (EAttribute) diagramGraphConfEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramGraphConf_DefaultFont()
    {
        return (EAttribute) diagramGraphConfEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNodeGraphConf()
    {
        return nodeGraphConfEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_DefaultWidth()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_DefaultHeight()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_MinimumWidth()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_MinimumHeight()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_MaximumWidth()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_MaximumHeight()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_IsWidthResizable()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_IsHeightResizable()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodeGraphConf_DefaultBackgroundColor()
    {
        return (EAttribute) nodeGraphConfEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEdgeGraphConf()
    {
        return edgeGraphConfEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEdgeGraphConf_DefaultRouter()
    {
        return (EAttribute) edgeGraphConfEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getBridge()
    {
        return bridgeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEMFBridge()
    {
        return emfBridgeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEMFBridge_Type()
    {
        return (EReference) emfBridgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getStringBridge()
    {
        return stringBridgeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getStringBridge_Type()
    {
        return (EAttribute) stringBridgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getConstraint()
    {
        return constraintEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getConstraint_Language()
    {
        return (EAttribute) constraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getConstraint_Rule()
    {
        return (EAttribute) constraintEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getLineStyle()
    {
        return lineStyleEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getRouterType()
    {
        return routerTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EDataType getColor()
    {
        return colorEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EDataType getFont()
    {
        return fontEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfFactory getGraphconfFactory()
    {
        return (GraphconfFactory) getEFactoryInstance();
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
        abstractGraphConfEClass = createEClass(ABSTRACT_GRAPH_CONF);
        createEAttribute(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__PRESENTATION);
        createEAttribute(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR);
        createEAttribute(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__DEFAULT_FONT);
        createEAttribute(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__LINE_WIDTH);
        createEAttribute(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__LINE_STYLE);
        createEReference(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__BRIDGE);
        createEReference(abstractGraphConfEClass, ABSTRACT_GRAPH_CONF__CONSTRAINT);

        diagramGraphConfEClass = createEClass(DIAGRAM_GRAPH_CONF);
        createEAttribute(diagramGraphConfEClass, DIAGRAM_GRAPH_CONF__ID);
        createEReference(diagramGraphConfEClass, DIAGRAM_GRAPH_CONF__NODE);
        createEReference(diagramGraphConfEClass, DIAGRAM_GRAPH_CONF__EDGE);
        createEAttribute(diagramGraphConfEClass, DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR);
        createEAttribute(diagramGraphConfEClass, DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR);
        createEAttribute(diagramGraphConfEClass, DIAGRAM_GRAPH_CONF__DEFAULT_FONT);

        nodeGraphConfEClass = createEClass(NODE_GRAPH_CONF);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__DEFAULT_WIDTH);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__DEFAULT_HEIGHT);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__MINIMUM_WIDTH);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__MINIMUM_HEIGHT);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__MAXIMUM_WIDTH);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__MAXIMUM_HEIGHT);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE);
        createEAttribute(nodeGraphConfEClass, NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR);

        edgeGraphConfEClass = createEClass(EDGE_GRAPH_CONF);
        createEAttribute(edgeGraphConfEClass, EDGE_GRAPH_CONF__DEFAULT_ROUTER);

        bridgeEClass = createEClass(BRIDGE);

        emfBridgeEClass = createEClass(EMF_BRIDGE);
        createEReference(emfBridgeEClass, EMF_BRIDGE__TYPE);

        stringBridgeEClass = createEClass(STRING_BRIDGE);
        createEAttribute(stringBridgeEClass, STRING_BRIDGE__TYPE);

        constraintEClass = createEClass(CONSTRAINT);
        createEAttribute(constraintEClass, CONSTRAINT__LANGUAGE);
        createEAttribute(constraintEClass, CONSTRAINT__RULE);

        // Create enums
        lineStyleEEnum = createEEnum(LINE_STYLE);
        routerTypeEEnum = createEEnum(ROUTER_TYPE);

        // Create data types
        colorEDataType = createEDataType(COLOR);
        fontEDataType = createEDataType(FONT);
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

        // Add supertypes to classes
        nodeGraphConfEClass.getESuperTypes().add(this.getAbstractGraphConf());
        edgeGraphConfEClass.getESuperTypes().add(this.getAbstractGraphConf());
        emfBridgeEClass.getESuperTypes().add(this.getBridge());
        stringBridgeEClass.getESuperTypes().add(this.getBridge());

        // Initialize classes and features; add operations and parameters
        initEClass(abstractGraphConfEClass, AbstractGraphConf.class, "AbstractGraphConf", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbstractGraphConf_Presentation(), ecorePackage.getEString(), "presentation", null, 0, 1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractGraphConf_DefaultForegroundColor(), this.getColor(), "defaultForegroundColor", null, 0, 1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractGraphConf_DefaultFont(), this.getFont(), "defaultFont", null, 0, 1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractGraphConf_LineWidth(), ecorePackage.getEInt(), "lineWidth", null, 0, 1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractGraphConf_LineStyle(), this.getLineStyle(), "lineStyle", null, 0, 1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractGraphConf_Bridge(), this.getBridge(), null, "bridge", null, 1, 1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractGraphConf_Constraint(), this.getConstraint(), null, "constraint", null, 0, -1, AbstractGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(diagramGraphConfEClass, DiagramGraphConf.class, "DiagramGraphConf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDiagramGraphConf_Id(), ecorePackage.getEString(), "id", null, 0, 1, DiagramGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramGraphConf_Node(), this.getNodeGraphConf(), null, "node", null, 0, -1, DiagramGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramGraphConf_Edge(), this.getEdgeGraphConf(), null, "edge", null, 0, -1, DiagramGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramGraphConf_DefaultBackgroundColor(), this.getColor(), "defaultBackgroundColor", null, 0, 1, DiagramGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramGraphConf_DefaultForegroundColor(), this.getColor(), "defaultForegroundColor", null, 0, 1, DiagramGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramGraphConf_DefaultFont(), this.getFont(), "defaultFont", null, 0, 1, DiagramGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nodeGraphConfEClass, NodeGraphConf.class, "NodeGraphConf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNodeGraphConf_DefaultWidth(), ecorePackage.getEInt(), "defaultWidth", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_DefaultHeight(), ecorePackage.getEInt(), "defaultHeight", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_MinimumWidth(), ecorePackage.getEInt(), "minimumWidth", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_MinimumHeight(), ecorePackage.getEInt(), "minimumHeight", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_MaximumWidth(), ecorePackage.getEInt(), "maximumWidth", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_MaximumHeight(), ecorePackage.getEInt(), "maximumHeight", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_IsWidthResizable(), ecorePackage.getEBoolean(), "isWidthResizable", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_IsHeightResizable(), ecorePackage.getEBoolean(), "isHeightResizable", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodeGraphConf_DefaultBackgroundColor(), this.getColor(), "defaultBackgroundColor", null, 0, 1, NodeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(edgeGraphConfEClass, EdgeGraphConf.class, "EdgeGraphConf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEdgeGraphConf_DefaultRouter(), this.getRouterType(), "defaultRouter", null, 0, 1, EdgeGraphConf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(bridgeEClass, Bridge.class, "Bridge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(emfBridgeEClass, EMFBridge.class, "EMFBridge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEMFBridge_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, EMFBridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(stringBridgeEClass, StringBridge.class, "StringBridge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStringBridge_Type(), ecorePackage.getEString(), "type", null, 1, 1, StringBridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConstraint_Language(), ecorePackage.getEString(), "language", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConstraint_Rule(), ecorePackage.getEString(), "rule", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(lineStyleEEnum, LineStyle.class, "LineStyle");
        addEEnumLiteral(lineStyleEEnum, LineStyle.SOLID_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DASH_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DOT_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DASHDOT_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DASHDOTDOT_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.CUSTOM_LITERAL);

        initEEnum(routerTypeEEnum, RouterType.class, "RouterType");
        addEEnumLiteral(routerTypeEEnum, RouterType.OBLIQUE_ROUTER_LITERAL);
        addEEnumLiteral(routerTypeEEnum, RouterType.RECTILINEAR_ROUTER_LITERAL);
        addEEnumLiteral(routerTypeEEnum, RouterType.TREE_ROUTER_LITERAL);

        // Initialize data types
        initEDataType(colorEDataType, Color.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(fontEDataType, Font.class, "Font", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
        addAnnotation(abstractGraphConfEClass, source, new String[] {"documentation",
                "A DiagramGraphConf is associated with a DiagramConfiguration. It contains informations on the graphical representation of the diagram associated."});
        addAnnotation(diagramGraphConfEClass, source, new String[] {"documentation",
                "A DiagramGraphConf is associated with a DiagramConfiguration. It contains informations on the graphical representation of the diagram associated."});
        addAnnotation(nodeGraphConfEClass, source, new String[] {"documentation", "A NodeGraphConf is associated with a NodePartConfiguration. It gives informations on the graphical element."});
        addAnnotation(edgeGraphConfEClass, source, new String[] {"documentation", "An EdgeGraphConf is associated with an EdgePartConfiguration. It gives informations on the graphical element."});
    }

} // GraphconfPackageImpl
