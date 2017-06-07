/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangeAdapterFactory.java,v 1.16 2009/07/02 16:42:42 jako Exp $
 */
package org.topcased.modeler.di.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage
 * @generated
 */
public class DiagramInterchangeAdapterFactory extends AdapterFactoryImpl
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The cached model package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static DiagramInterchangePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangeAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = DiagramInterchangePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This
     * implementation returns <code>true</code> if the object is either the model's package or is an instance object
     * of the model. <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object)
    {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramInterchangeSwitch<Adapter> modelSwitch = new DiagramInterchangeSwitch<Adapter>()
    {
        @Override
        public Adapter caseProperty(Property object)
        {
            return createPropertyAdapter();
        }

        @Override
        public Adapter caseDiagramElement(DiagramElement object)
        {
            return createDiagramElementAdapter();
        }

        @Override
        public Adapter caseGraphElement(GraphElement object)
        {
            return createGraphElementAdapter();
        }

        @Override
        public Adapter caseGraphEdge(GraphEdge object)
        {
            return createGraphEdgeAdapter();
        }

        @Override
        public Adapter caseGraphNode(GraphNode object)
        {
            return createGraphNodeAdapter();
        }

        @Override
        public Adapter caseGraphConnector(GraphConnector object)
        {
            return createGraphConnectorAdapter();
        }

        @Override
        public Adapter caseDiagram(Diagram object)
        {
            return createDiagramAdapter();
        }

        @Override
        public Adapter caseSemanticModelBridge(SemanticModelBridge object)
        {
            return createSemanticModelBridgeAdapter();
        }

        @Override
        public Adapter caseEMFSemanticModelBridge(EMFSemanticModelBridge object)
        {
            return createEMFSemanticModelBridgeAdapter();
        }

        @Override
        public Adapter caseSimpleSemanticModelElement(SimpleSemanticModelElement object)
        {
            return createSimpleSemanticModelElementAdapter();
        }

        @Override
        public Adapter caseDiagramLink(DiagramLink object)
        {
            return createDiagramLinkAdapter();
        }

        @Override
        public Adapter caseLeafElement(LeafElement object)
        {
            return createLeafElementAdapter();
        }

        @Override
        public Adapter caseTextElement(TextElement object)
        {
            return createTextElementAdapter();
        }

        @Override
        public Adapter caseImage(Image object)
        {
            return createImageAdapter();
        }

        @Override
        public Adapter caseGraphicPrimitive(GraphicPrimitive object)
        {
            return createGraphicPrimitiveAdapter();
        }

        @Override
        public Adapter caseReference(Reference object)
        {
            return createReferenceAdapter();
        }

        @Override
        public Adapter casePolyline(Polyline object)
        {
            return createPolylineAdapter();
        }

        @Override
        public Adapter caseEllipse(Ellipse object)
        {
            return createEllipseAdapter();
        }

        @Override
        public Adapter caseEdgeObject(EdgeObject object)
        {
            return createEdgeObjectAdapter();
        }

        @Override
        public Adapter caseEdgeObjectOffset(EdgeObjectOffset object)
        {
            return createEdgeObjectOffsetAdapter();
        }

        @Override
        public Adapter caseEdgeObjectUV(EdgeObjectUV object)
        {
            return createEdgeObjectUVAdapter();
        }

		@Override
		public Adapter caseEModelElement(EModelElement object) {
			return createEModelElementAdapter();
		}

        @Override
        public Adapter defaultCase(EObject object)
        {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target)
    {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.Property <em>Property</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.Property
     * @generated
     */
    public Adapter createPropertyAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.DiagramElement <em>Diagram Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.DiagramElement
     * @generated
     */
    public Adapter createDiagramElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.GraphElement <em>Graph Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.GraphElement
     * @generated
     */
    public Adapter createGraphElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.GraphEdge <em>Graph Edge</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.GraphEdge
     * @generated
     */
    public Adapter createGraphEdgeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.GraphNode <em>Graph Node</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.GraphNode
     * @generated
     */
    public Adapter createGraphNodeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.GraphConnector <em>Graph Connector</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.GraphConnector
     * @generated
     */
    public Adapter createGraphConnectorAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.Diagram <em>Diagram</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.Diagram
     * @generated
     */
    public Adapter createDiagramAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.SemanticModelBridge <em>Semantic Model Bridge</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.SemanticModelBridge
     * @generated
     */
    public Adapter createSemanticModelBridgeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.EMFSemanticModelBridge <em>EMF Semantic Model Bridge</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.EMFSemanticModelBridge
     * @generated
     */
    public Adapter createEMFSemanticModelBridgeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.SimpleSemanticModelElement <em>Simple Semantic Model Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.SimpleSemanticModelElement
     * @generated
     */
    public Adapter createSimpleSemanticModelElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.DiagramLink <em>Diagram Link</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.DiagramLink
     * @generated
     */
    public Adapter createDiagramLinkAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.LeafElement <em>Leaf Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.LeafElement
     * @generated
     */
    public Adapter createLeafElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.TextElement <em>Text Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.TextElement
     * @generated
     */
    public Adapter createTextElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.Image <em>Image</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.Image
     * @generated
     */
    public Adapter createImageAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.GraphicPrimitive <em>Graphic Primitive</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.GraphicPrimitive
     * @generated
     */
    public Adapter createGraphicPrimitiveAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.Reference <em>Reference</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.Reference
     * @generated
     */
    public Adapter createReferenceAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.Polyline <em>Polyline</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.Polyline
     * @generated
     */
    public Adapter createPolylineAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.Ellipse <em>Ellipse</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.Ellipse
     * @generated
     */
    public Adapter createEllipseAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.EdgeObject <em>Edge Object</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.EdgeObject
     * @generated
     */
    public Adapter createEdgeObjectAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.EdgeObjectOffset <em>Edge Object Offset</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.EdgeObjectOffset
     * @generated
     */
    public Adapter createEdgeObjectOffsetAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.di.model.EdgeObjectUV <em>Edge Object UV</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.di.model.EdgeObjectUV
     * @generated
     */
    public Adapter createEdgeObjectUVAdapter()
    {
        return null;
    }

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EModelElement
	 * @generated
	 */
	public Adapter createEModelElementAdapter() {
		return null;
	}

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc --> This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} // DiagramInterchangeAdapterFactory
