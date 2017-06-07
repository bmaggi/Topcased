/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangePackageImpl.java,v 1.7 2009/07/02 16:42:42 jako Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.DiagramLink;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.di.model.EdgeObjectOffset;
import org.topcased.modeler.di.model.EdgeObjectUV;
import org.topcased.modeler.di.model.Ellipse;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.GraphicPrimitive;
import org.topcased.modeler.di.model.Image;
import org.topcased.modeler.di.model.LeafElement;
import org.topcased.modeler.di.model.Polyline;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.Reference;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.TextElement;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class DiagramInterchangePackageImpl extends EPackageImpl implements DiagramInterchangePackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass propertyEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass graphElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass graphEdgeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass graphNodeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass graphConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass semanticModelBridgeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass emfSemanticModelBridgeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleSemanticModelElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramLinkEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass leafElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass textElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass imageEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass graphicPrimitiveEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass referenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass polylineEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass ellipseEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass edgeObjectEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass edgeObjectOffsetEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EClass edgeObjectUVEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EDataType pointEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EDataType dimensionEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EDataType absoluteBendpointEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private EDataType relativeBendpointEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DiagramInterchangePackageImpl()
    {
        super(eNS_URI, DiagramInterchangeFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DiagramInterchangePackage init()
    {
        if (isInited)
            return (DiagramInterchangePackage) EPackage.Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI);

        // Obtain or create and register package
        DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiagramInterchangePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new DiagramInterchangePackageImpl());

        isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theDiagramInterchangePackage.createPackageContents();

        // Initialize created meta-data
        theDiagramInterchangePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theDiagramInterchangePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagramInterchangePackage.eNS_URI, theDiagramInterchangePackage);
        return theDiagramInterchangePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getProperty()
    {
        return propertyEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProperty_Key()
    {
        return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProperty_Value()
    {
        return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagramElement()
    {
        return diagramElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramElement_Visible()
    {
        return (EAttribute) diagramElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramElement_Property()
    {
        return (EReference) diagramElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramElement_Container()
    {
        return (EReference) diagramElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramElement_Reference()
    {
        return (EReference) diagramElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getGraphElement()
    {
        return graphElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphElement_Position()
    {
        return (EAttribute) graphElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphElement_Anchorage()
    {
        return (EReference) graphElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphElement_SemanticModel()
    {
        return (EReference) graphElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphElement_Contained()
    {
        return (EReference) graphElementEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphElement_Link()
    {
        return (EReference) graphElementEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getGraphEdge()
    {
        return graphEdgeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphEdge_Waypoints()
    {
        return (EAttribute) graphEdgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphEdge_Anchor()
    {
        return (EReference) graphEdgeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getGraphNode()
    {
        return graphNodeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphNode_Size()
    {
        return (EAttribute) graphNodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getGraphConnector()
    {
        return graphConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGraphConnector_Position()
    {
        return (EAttribute) graphConnectorEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphConnector_GraphEdge()
    {
        return (EReference) graphConnectorEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getGraphConnector_GraphElement()
    {
        return (EReference) graphConnectorEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagram()
    {
        return diagramEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagram_Name()
    {
        return (EAttribute) diagramEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagram_Zoom()
    {
        return (EAttribute) diagramEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagram_Viewport()
    {
        return (EAttribute) diagramEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagram_DiagramLink()
    {
        return (EReference) diagramEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getSemanticModelBridge()
    {
        return semanticModelBridgeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSemanticModelBridge_Presentation()
    {
        return (EAttribute) semanticModelBridgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getSemanticModelBridge_GraphElement()
    {
        return (EReference) semanticModelBridgeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getEMFSemanticModelBridge()
    {
        return emfSemanticModelBridgeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getEMFSemanticModelBridge_Element()
    {
        return (EReference) emfSemanticModelBridgeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleSemanticModelElement()
    {
        return simpleSemanticModelElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleSemanticModelElement_TypeInfo()
    {
        return (EAttribute) simpleSemanticModelElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagramLink()
    {
        return diagramLinkEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramLink_Zoom()
    {
        return (EAttribute) diagramLinkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramLink_Viewport()
    {
        return (EAttribute) diagramLinkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramLink_GraphElement()
    {
        return (EReference) diagramLinkEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramLink_Diagram()
    {
        return (EReference) diagramLinkEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getLeafElement()
    {
        return leafElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextElement()
    {
        return textElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextElement_Text()
    {
        return (EAttribute) textElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getImage()
    {
        return imageEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getImage_Uri()
    {
        return (EAttribute) imageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getImage_MimeType()
    {
        return (EAttribute) imageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getGraphicPrimitive()
    {
        return graphicPrimitiveEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getReference()
    {
        return referenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_IsIndividualRepresentation()
    {
        return (EAttribute) referenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EReference getReference_Referenced()
    {
        return (EReference) referenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getPolyline()
    {
        return polylineEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPolyline_Waypoints()
    {
        return (EAttribute) polylineEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPolyline_Closed()
    {
        return (EAttribute) polylineEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getEllipse()
    {
        return ellipseEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEllipse_Center()
    {
        return (EAttribute) ellipseEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEllipse_RadiusX()
    {
        return (EAttribute) ellipseEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEllipse_RadiusY()
    {
        return (EAttribute) ellipseEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEllipse_Rotation()
    {
        return (EAttribute) ellipseEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEllipse_StartAngle()
    {
        return (EAttribute) ellipseEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEllipse_EndAngle()
    {
        return (EAttribute) ellipseEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getEdgeObject()
    {
        return edgeObjectEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgeObject_Id()
    {
        return (EAttribute) edgeObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getEdgeObjectOffset()
    {
        return edgeObjectOffsetEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgeObjectOffset_Offset()
    {
        return (EAttribute) edgeObjectOffsetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EClass getEdgeObjectUV()
    {
        return edgeObjectUVEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgeObjectUV_UDistance()
    {
        return (EAttribute) edgeObjectUVEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgeObjectUV_VDistance()
    {
        return (EAttribute) edgeObjectUVEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPoint()
    {
        return pointEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EDataType getDimension()
    {
        return dimensionEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EDataType getAbsoluteBendpoint()
    {
        return absoluteBendpointEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRelativeBendpoint()
    {
        return relativeBendpointEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangeFactory getDiagramInterchangeFactory()
    {
        return (DiagramInterchangeFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        propertyEClass = createEClass(PROPERTY);
        createEAttribute(propertyEClass, PROPERTY__KEY);
        createEAttribute(propertyEClass, PROPERTY__VALUE);

        diagramElementEClass = createEClass(DIAGRAM_ELEMENT);
        createEAttribute(diagramElementEClass, DIAGRAM_ELEMENT__VISIBLE);
        createEReference(diagramElementEClass, DIAGRAM_ELEMENT__PROPERTY);
        createEReference(diagramElementEClass, DIAGRAM_ELEMENT__CONTAINER);
        createEReference(diagramElementEClass, DIAGRAM_ELEMENT__REFERENCE);

        graphElementEClass = createEClass(GRAPH_ELEMENT);
        createEAttribute(graphElementEClass, GRAPH_ELEMENT__POSITION);
        createEReference(graphElementEClass, GRAPH_ELEMENT__ANCHORAGE);
        createEReference(graphElementEClass, GRAPH_ELEMENT__SEMANTIC_MODEL);
        createEReference(graphElementEClass, GRAPH_ELEMENT__CONTAINED);
        createEReference(graphElementEClass, GRAPH_ELEMENT__LINK);

        graphEdgeEClass = createEClass(GRAPH_EDGE);
        createEAttribute(graphEdgeEClass, GRAPH_EDGE__WAYPOINTS);
        createEReference(graphEdgeEClass, GRAPH_EDGE__ANCHOR);

        graphNodeEClass = createEClass(GRAPH_NODE);
        createEAttribute(graphNodeEClass, GRAPH_NODE__SIZE);

        graphConnectorEClass = createEClass(GRAPH_CONNECTOR);
        createEAttribute(graphConnectorEClass, GRAPH_CONNECTOR__POSITION);
        createEReference(graphConnectorEClass, GRAPH_CONNECTOR__GRAPH_EDGE);
        createEReference(graphConnectorEClass, GRAPH_CONNECTOR__GRAPH_ELEMENT);

        diagramEClass = createEClass(DIAGRAM);
        createEAttribute(diagramEClass, DIAGRAM__NAME);
        createEAttribute(diagramEClass, DIAGRAM__ZOOM);
        createEAttribute(diagramEClass, DIAGRAM__VIEWPORT);
        createEReference(diagramEClass, DIAGRAM__DIAGRAM_LINK);

        semanticModelBridgeEClass = createEClass(SEMANTIC_MODEL_BRIDGE);
        createEAttribute(semanticModelBridgeEClass, SEMANTIC_MODEL_BRIDGE__PRESENTATION);
        createEReference(semanticModelBridgeEClass, SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT);

        emfSemanticModelBridgeEClass = createEClass(EMF_SEMANTIC_MODEL_BRIDGE);
        createEReference(emfSemanticModelBridgeEClass, EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT);

        simpleSemanticModelElementEClass = createEClass(SIMPLE_SEMANTIC_MODEL_ELEMENT);
        createEAttribute(simpleSemanticModelElementEClass, SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO);

        diagramLinkEClass = createEClass(DIAGRAM_LINK);
        createEAttribute(diagramLinkEClass, DIAGRAM_LINK__ZOOM);
        createEAttribute(diagramLinkEClass, DIAGRAM_LINK__VIEWPORT);
        createEReference(diagramLinkEClass, DIAGRAM_LINK__GRAPH_ELEMENT);
        createEReference(diagramLinkEClass, DIAGRAM_LINK__DIAGRAM);

        leafElementEClass = createEClass(LEAF_ELEMENT);

        textElementEClass = createEClass(TEXT_ELEMENT);
        createEAttribute(textElementEClass, TEXT_ELEMENT__TEXT);

        imageEClass = createEClass(IMAGE);
        createEAttribute(imageEClass, IMAGE__URI);
        createEAttribute(imageEClass, IMAGE__MIME_TYPE);

        graphicPrimitiveEClass = createEClass(GRAPHIC_PRIMITIVE);

        referenceEClass = createEClass(REFERENCE);
        createEAttribute(referenceEClass, REFERENCE__IS_INDIVIDUAL_REPRESENTATION);
        createEReference(referenceEClass, REFERENCE__REFERENCED);

        polylineEClass = createEClass(POLYLINE);
        createEAttribute(polylineEClass, POLYLINE__WAYPOINTS);
        createEAttribute(polylineEClass, POLYLINE__CLOSED);

        ellipseEClass = createEClass(ELLIPSE);
        createEAttribute(ellipseEClass, ELLIPSE__CENTER);
        createEAttribute(ellipseEClass, ELLIPSE__RADIUS_X);
        createEAttribute(ellipseEClass, ELLIPSE__RADIUS_Y);
        createEAttribute(ellipseEClass, ELLIPSE__ROTATION);
        createEAttribute(ellipseEClass, ELLIPSE__START_ANGLE);
        createEAttribute(ellipseEClass, ELLIPSE__END_ANGLE);

        edgeObjectEClass = createEClass(EDGE_OBJECT);
        createEAttribute(edgeObjectEClass, EDGE_OBJECT__ID);

        edgeObjectOffsetEClass = createEClass(EDGE_OBJECT_OFFSET);
        createEAttribute(edgeObjectOffsetEClass, EDGE_OBJECT_OFFSET__OFFSET);

        edgeObjectUVEClass = createEClass(EDGE_OBJECT_UV);
        createEAttribute(edgeObjectUVEClass, EDGE_OBJECT_UV__UDISTANCE);
        createEAttribute(edgeObjectUVEClass, EDGE_OBJECT_UV__VDISTANCE);

        // Create data types
        pointEDataType = createEDataType(POINT);
        dimensionEDataType = createEDataType(DIMENSION);
        absoluteBendpointEDataType = createEDataType(ABSOLUTE_BENDPOINT);
        relativeBendpointEDataType = createEDataType(RELATIVE_BENDPOINT);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
		diagramElementEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
        graphElementEClass.getESuperTypes().add(this.getDiagramElement());
        graphEdgeEClass.getESuperTypes().add(this.getGraphElement());
        graphNodeEClass.getESuperTypes().add(this.getGraphElement());
        diagramEClass.getESuperTypes().add(this.getGraphNode());
        emfSemanticModelBridgeEClass.getESuperTypes().add(this.getSemanticModelBridge());
        simpleSemanticModelElementEClass.getESuperTypes().add(this.getSemanticModelBridge());
        leafElementEClass.getESuperTypes().add(this.getDiagramElement());
        textElementEClass.getESuperTypes().add(this.getLeafElement());
        imageEClass.getESuperTypes().add(this.getLeafElement());
        graphicPrimitiveEClass.getESuperTypes().add(this.getLeafElement());
        referenceEClass.getESuperTypes().add(this.getDiagramElement());
        polylineEClass.getESuperTypes().add(this.getGraphicPrimitive());
        ellipseEClass.getESuperTypes().add(this.getGraphicPrimitive());
        edgeObjectEClass.getESuperTypes().add(this.getLeafElement());
        edgeObjectOffsetEClass.getESuperTypes().add(this.getEdgeObject());
        edgeObjectUVEClass.getESuperTypes().add(this.getEdgeObject());

        // Initialize classes and features; add operations and parameters
        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getProperty_Key(), ecorePackage.getEString(),
                "key", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getProperty_Value(), ecorePackage.getEString(),
                "value", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(diagramElementEClass, DiagramElement.class, "DiagramElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDiagramElement_Visible(), ecorePackage.getEBoolean(),
                "visible", "true", 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getDiagramElement_Property(), this.getProperty(), null,
                "property", null, 0, -1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagramElement_Container(), this.getGraphElement(), this.getGraphElement_Contained(),
                "container", null, 0, 1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagramElement_Reference(), this.getReference(), this.getReference_Referenced(),
                "reference", null, 0, -1, DiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(graphElementEClass, GraphElement.class, "GraphElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGraphElement_Position(), this.getPoint(),
                "position", null, 0, 1, GraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphElement_Anchorage(), this.getGraphConnector(), this.getGraphConnector_GraphElement(),
                "anchorage", null, 0, -1, GraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphElement_SemanticModel(), this.getSemanticModelBridge(), this.getSemanticModelBridge_GraphElement(),
                "semanticModel", null, 1, 1, GraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphElement_Contained(), this.getDiagramElement(), this.getDiagramElement_Container(),
                "contained", null, 0, -1, GraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphElement_Link(), this.getDiagramLink(), this.getDiagramLink_GraphElement(),
                "link", null, 0, -1, GraphElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(graphEdgeEClass, GraphEdge.class, "GraphEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGraphEdge_Waypoints(), this.getRelativeBendpoint(),
                "waypoints", null, 0, -1, GraphEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphEdge_Anchor(), this.getGraphConnector(), this.getGraphConnector_GraphEdge(),
                "anchor", null, 2, 2, GraphEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(graphNodeEClass, GraphNode.class, "GraphNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGraphNode_Size(), this.getDimension(),
                "size", null, 0, 1, GraphNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(graphConnectorEClass, GraphConnector.class, "GraphConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getGraphConnector_Position(), this.getPoint(),
                "position", null, 0, 1, GraphConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphConnector_GraphEdge(), this.getGraphEdge(), this.getGraphEdge_Anchor(),
                "graphEdge", null, 0, -1, GraphConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getGraphConnector_GraphElement(), this.getGraphElement(), this.getGraphElement_Anchorage(),
                "graphElement", null, 1, 1, GraphConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        addEOperation(graphConnectorEClass, ecorePackage.getEBoolean(), "isVisible", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDiagram_Name(), ecorePackage.getEString(),
                "name", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagram_Zoom(), ecorePackage.getEDouble(),
                "zoom", "1.0", 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getDiagram_Viewport(), this.getPoint(),
                "viewport", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagram_DiagramLink(), this.getDiagramLink(), this.getDiagramLink_Diagram(),
                "diagramLink", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(semanticModelBridgeEClass, SemanticModelBridge.class, "SemanticModelBridge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSemanticModelBridge_Presentation(), ecorePackage.getEString(),
                "presentation", null, 0, 1, SemanticModelBridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(
                getSemanticModelBridge_GraphElement(),
                this.getGraphElement(),
                this.getGraphElement_SemanticModel(),
                "graphElement", null, 1, 1, SemanticModelBridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(emfSemanticModelBridgeEClass, EMFSemanticModelBridge.class, "EMFSemanticModelBridge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getEMFSemanticModelBridge_Element(), ecorePackage.getEObject(), null,
                "element", null, 1, 1, EMFSemanticModelBridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(simpleSemanticModelElementEClass, SimpleSemanticModelElement.class, "SimpleSemanticModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSimpleSemanticModelElement_TypeInfo(), ecorePackage.getEString(),
                "typeInfo", null, 0, 1, SimpleSemanticModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(diagramLinkEClass, DiagramLink.class, "DiagramLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDiagramLink_Zoom(), ecorePackage.getEDouble(),
                "zoom", null, 0, 1, DiagramLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramLink_Viewport(), this.getPoint(),
                "viewport", null, 0, 1, DiagramLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagramLink_GraphElement(), this.getGraphElement(), this.getGraphElement_Link(),
                "graphElement", null, 1, 1, DiagramLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagramLink_Diagram(), this.getDiagram(), this.getDiagram_DiagramLink(),
                "diagram", null, 1, 1, DiagramLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(leafElementEClass, LeafElement.class, "LeafElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(textElementEClass, TextElement.class, "TextElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTextElement_Text(), ecorePackage.getEString(),
                "text", null, 0, 1, TextElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getImage_Uri(), ecorePackage.getEString(),
                "uri", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getImage_MimeType(), ecorePackage.getEString(),
                "mimeType", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(graphicPrimitiveEClass, GraphicPrimitive.class, "GraphicPrimitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getReference_IsIndividualRepresentation(), ecorePackage.getEBoolean(),
                "isIndividualRepresentation", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getReference_Referenced(), this.getDiagramElement(), this.getDiagramElement_Reference(),
                "referenced", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(polylineEClass, Polyline.class, "Polyline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPolyline_Waypoints(), this.getPoint(),
                "waypoints", null, 2, -1, Polyline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPolyline_Closed(), ecorePackage.getEBoolean(),
                "closed", null, 0, 1, Polyline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(ellipseEClass, Ellipse.class, "Ellipse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEllipse_Center(), this.getPoint(),
                "center", null, 0, 1, Ellipse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEllipse_RadiusX(), ecorePackage.getEDouble(),
                "radiusX", null, 0, 1, Ellipse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEllipse_RadiusY(), ecorePackage.getEDouble(),
                "radiusY", null, 0, 1, Ellipse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEllipse_Rotation(), ecorePackage.getEDouble(),
                "rotation", null, 0, 1, Ellipse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEllipse_StartAngle(), ecorePackage.getEDouble(),
                "startAngle", null, 0, 1, Ellipse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEllipse_EndAngle(), ecorePackage.getEDouble(),
                "endAngle", null, 0, 1, Ellipse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(edgeObjectEClass, EdgeObject.class, "EdgeObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEdgeObject_Id(), ecorePackage.getEString(),
                "id", null, 1, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(edgeObjectOffsetEClass, EdgeObjectOffset.class, "EdgeObjectOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEdgeObjectOffset_Offset(), this.getDimension(),
                "offset", "", 0, 1, EdgeObjectOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(edgeObjectUVEClass, EdgeObjectUV.class, "EdgeObjectUV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEdgeObjectUV_UDistance(), ecorePackage.getEInt(),
                "uDistance", null, 0, 1, EdgeObjectUV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEdgeObjectUV_VDistance(), ecorePackage.getEInt(),
                "vDistance", null, 0, 1, EdgeObjectUV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize data types
        initEDataType(pointEDataType, Point.class, "Point", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(dimensionEDataType, Dimension.class, "Dimension", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(absoluteBendpointEDataType, AbsoluteBendpoint.class, "AbsoluteBendpoint", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEDataType(relativeBendpointEDataType, RelativeBendpoint.class, "RelativeBendpoint", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} // DiagramInterchangePackageImpl
