/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangeFactoryImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import java.util.StringTokenizer;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.DiagramLink;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.EdgeObjectOffset;
import org.topcased.modeler.di.model.EdgeObjectUV;
import org.topcased.modeler.di.model.Ellipse;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class DiagramInterchangeFactoryImpl extends EFactoryImpl implements DiagramInterchangeFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static DiagramInterchangeFactory init()
    {
        try
        {
            DiagramInterchangeFactory theDiagramInterchangeFactory = (DiagramInterchangeFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/DI/1.0"); //$NON-NLS-1$ 
            if (theDiagramInterchangeFactory != null)
            {
                return theDiagramInterchangeFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DiagramInterchangeFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangeFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case DiagramInterchangePackage.PROPERTY:
                return (EObject) createProperty();
            case DiagramInterchangePackage.GRAPH_EDGE:
                return (EObject) createGraphEdge();
            case DiagramInterchangePackage.GRAPH_NODE:
                return (EObject) createGraphNode();
            case DiagramInterchangePackage.GRAPH_CONNECTOR:
                return (EObject) createGraphConnector();
            case DiagramInterchangePackage.DIAGRAM:
                return (EObject) createDiagram();
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE:
                return (EObject) createSemanticModelBridge();
            case DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE:
                return (EObject) createEMFSemanticModelBridge();
            case DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT:
                return (EObject) createSimpleSemanticModelElement();
            case DiagramInterchangePackage.DIAGRAM_LINK:
                return (EObject) createDiagramLink();
            case DiagramInterchangePackage.LEAF_ELEMENT:
                return (EObject) createLeafElement();
            case DiagramInterchangePackage.TEXT_ELEMENT:
                return (EObject) createTextElement();
            case DiagramInterchangePackage.IMAGE:
                return (EObject) createImage();
            case DiagramInterchangePackage.GRAPHIC_PRIMITIVE:
                return (EObject) createGraphicPrimitive();
            case DiagramInterchangePackage.REFERENCE:
                return (EObject) createReference();
            case DiagramInterchangePackage.POLYLINE:
                return (EObject) createPolyline();
            case DiagramInterchangePackage.ELLIPSE:
                return (EObject) createEllipse();
            case DiagramInterchangePackage.EDGE_OBJECT_OFFSET:
                return (EObject) createEdgeObjectOffset();
            case DiagramInterchangePackage.EDGE_OBJECT_UV:
                return (EObject) createEdgeObjectUV();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue)
    {
        switch (eDataType.getClassifierID())
        {
            case DiagramInterchangePackage.POINT:
                return createPointFromString(eDataType, initialValue);
            case DiagramInterchangePackage.DIMENSION:
                return createDimensionFromString(eDataType, initialValue);
            case DiagramInterchangePackage.ABSOLUTE_BENDPOINT:
                return createAbsoluteBendpointFromString(eDataType, initialValue);
            case DiagramInterchangePackage.RELATIVE_BENDPOINT:
                return createRelativeBendpointFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue)
    {
        switch (eDataType.getClassifierID())
        {
            case DiagramInterchangePackage.POINT:
                return convertPointToString(eDataType, instanceValue);
            case DiagramInterchangePackage.DIMENSION:
                return convertDimensionToString(eDataType, instanceValue);
            case DiagramInterchangePackage.ABSOLUTE_BENDPOINT:
                return convertAbsoluteBendpointToString(eDataType, instanceValue);
            case DiagramInterchangePackage.RELATIVE_BENDPOINT:
                return convertRelativeBendpointToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Property createProperty()
    {
        PropertyImpl property = new PropertyImpl();
        return property;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphEdge createGraphEdge()
    {
        GraphEdgeImpl graphEdge = new GraphEdgeImpl();
        return graphEdge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphNode createGraphNode()
    {
        GraphNodeImpl graphNode = new GraphNodeImpl();
        return graphNode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphConnector createGraphConnector()
    {
        GraphConnectorImpl graphConnector = new GraphConnectorImpl();
        return graphConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagram createDiagram()
    {
        DiagramImpl diagram = new DiagramImpl();
        return diagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SemanticModelBridge createSemanticModelBridge()
    {
        SemanticModelBridgeImpl semanticModelBridge = new SemanticModelBridgeImpl();
        return semanticModelBridge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EMFSemanticModelBridge createEMFSemanticModelBridge()
    {
        EMFSemanticModelBridgeImpl emfSemanticModelBridge = new EMFSemanticModelBridgeImpl();
        return emfSemanticModelBridge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SimpleSemanticModelElement createSimpleSemanticModelElement()
    {
        SimpleSemanticModelElementImpl simpleSemanticModelElement = new SimpleSemanticModelElementImpl();
        return simpleSemanticModelElement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramLink createDiagramLink()
    {
        DiagramLinkImpl diagramLink = new DiagramLinkImpl();
        return diagramLink;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public LeafElement createLeafElement()
    {
        LeafElementImpl leafElement = new LeafElementImpl();
        return leafElement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public TextElement createTextElement()
    {
        TextElementImpl textElement = new TextElementImpl();
        return textElement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Image createImage()
    {
        ImageImpl image = new ImageImpl();
        return image;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphicPrimitive createGraphicPrimitive()
    {
        GraphicPrimitiveImpl graphicPrimitive = new GraphicPrimitiveImpl();
        return graphicPrimitive;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Reference createReference()
    {
        ReferenceImpl reference = new ReferenceImpl();
        return reference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Polyline createPolyline()
    {
        PolylineImpl polyline = new PolylineImpl();
        return polyline;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Ellipse createEllipse()
    {
        EllipseImpl ellipse = new EllipseImpl();
        return ellipse;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EdgeObjectOffset createEdgeObjectOffset()
    {
        EdgeObjectOffsetImpl edgeObjectOffset = new EdgeObjectOffsetImpl();
        return edgeObjectOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EdgeObjectUV createEdgeObjectUV()
    {
        EdgeObjectUVImpl edgeObjectUV = new EdgeObjectUVImpl();
        return edgeObjectUV;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Point createPointFromString(EDataType eDataType, String initialValue)
    {
        if (initialValue == null || initialValue.length() == 0)
            return new Point();

        initialValue = initialValue.trim();
        StringTokenizer tokenizer = new StringTokenizer(initialValue, ","); //$NON-NLS-1$
        int x = 0, y = 0;
        try
        {
            x = new Integer(tokenizer.nextToken().trim()).intValue();
            y = new Integer(tokenizer.nextToken().trim()).intValue();
        }
        catch (NumberFormatException nfe)
        {
        }
        return new Point(x, y);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertPointToString(EDataType eDataType, Object instanceValue)
    {
        if (instanceValue == null)
            return "0,0";
        Point p = (Point) instanceValue;
        return p.x + "," + p.y;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Dimension createDimensionFromString(EDataType eDataType, String initialValue)
    {
        Point p = createPointFromString(null, initialValue);
        return new Dimension(p.x, p.y);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertDimensionToString(EDataType eDataType, Object instanceValue)
    {
        Dimension d = (Dimension) instanceValue;
        if (d == null)
        {
            d = new Dimension(100, 100);
        }
        return convertPointToString(null, new Point(d.width, d.height));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public AbsoluteBendpoint createAbsoluteBendpointFromString(EDataType eDataType, String initialValue)
    {
        return new AbsoluteBendpoint(createPointFromString(null, initialValue));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertAbsoluteBendpointToString(EDataType eDataType, Object instanceValue)
    {
        Bendpoint bp = (Bendpoint) instanceValue;
        if (bp == null)
        {
            bp = new AbsoluteBendpoint(0, 0);
        }
        return convertPointToString(null, bp.getLocation());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public RelativeBendpoint createRelativeBendpointFromString(EDataType eDataType, String initialValue)
    {
        return new RelativeBendpoint(initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertRelativeBendpointToString(EDataType eDataType, Object instanceValue)
    {
        RelativeBendpoint bp = (RelativeBendpoint) instanceValue;
        if (bp == null)
        {
            bp = new RelativeBendpoint();
        }
        return bp.convertToString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangePackage getDiagramInterchangePackage()
    {
        return (DiagramInterchangePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DiagramInterchangePackage getPackage()
    {
        return DiagramInterchangePackage.eINSTANCE;
    }

} // DiagramInterchangeFactoryImpl
