/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangeSwitch.java,v 1.17 2009/07/02 16:42:42 jako Exp $
 */
package org.topcased.modeler.di.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage
 * @generated
 */
public class DiagramInterchangeSwitch<T>
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static DiagramInterchangePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangeSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = DiagramInterchangePackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject)
    {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject)
    {
        if (theEClass.eContainer() == modelPackage)
        {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else
        {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case DiagramInterchangePackage.PROPERTY: {
                Property property = (Property) theEObject;
                T result = caseProperty(property);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.DIAGRAM_ELEMENT: {
                DiagramElement diagramElement = (DiagramElement) theEObject;
                T result = caseDiagramElement(diagramElement);
			if (result == null)
				result = caseEModelElement(diagramElement);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.GRAPH_ELEMENT: {
                GraphElement graphElement = (GraphElement) theEObject;
                T result = caseGraphElement(graphElement);
                if (result == null)
                    result = caseDiagramElement(graphElement);
			if (result == null)
				result = caseEModelElement(graphElement);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.GRAPH_EDGE: {
                GraphEdge graphEdge = (GraphEdge) theEObject;
                T result = caseGraphEdge(graphEdge);
                if (result == null)
                    result = caseGraphElement(graphEdge);
                if (result == null)
                    result = caseDiagramElement(graphEdge);
                if (result == null)
                	result = caseEModelElement(graphEdge);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.GRAPH_NODE: {
                GraphNode graphNode = (GraphNode) theEObject;
                T result = caseGraphNode(graphNode);
                if (result == null)
                    result = caseGraphElement(graphNode);
                if (result == null)
                    result = caseDiagramElement(graphNode);
                if (result == null)
                	result = caseEModelElement(graphNode);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.GRAPH_CONNECTOR: {
                GraphConnector graphConnector = (GraphConnector) theEObject;
                T result = caseGraphConnector(graphConnector);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.DIAGRAM: {
                Diagram diagram = (Diagram) theEObject;
                T result = caseDiagram(diagram);
                if (result == null)
                    result = caseGraphNode(diagram);
                if (result == null)
                    result = caseGraphElement(diagram);
                if (result == null)
                    result = caseDiagramElement(diagram);
				if (result == null)
					result = caseEModelElement(diagram);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE: {
                SemanticModelBridge semanticModelBridge = (SemanticModelBridge) theEObject;
                T result = caseSemanticModelBridge(semanticModelBridge);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE: {
                EMFSemanticModelBridge emfSemanticModelBridge = (EMFSemanticModelBridge) theEObject;
                T result = caseEMFSemanticModelBridge(emfSemanticModelBridge);
                if (result == null)
                    result = caseSemanticModelBridge(emfSemanticModelBridge);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT: {
                SimpleSemanticModelElement simpleSemanticModelElement = (SimpleSemanticModelElement) theEObject;
                T result = caseSimpleSemanticModelElement(simpleSemanticModelElement);
                if (result == null)
                    result = caseSemanticModelBridge(simpleSemanticModelElement);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.DIAGRAM_LINK: {
                DiagramLink diagramLink = (DiagramLink) theEObject;
                T result = caseDiagramLink(diagramLink);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.LEAF_ELEMENT: {
                LeafElement leafElement = (LeafElement) theEObject;
                T result = caseLeafElement(leafElement);
                if (result == null)
                    result = caseDiagramElement(leafElement);
				if (result == null)
					result = caseEModelElement(leafElement);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.TEXT_ELEMENT: {
                TextElement textElement = (TextElement) theEObject;
                T result = caseTextElement(textElement);
                if (result == null)
                    result = caseLeafElement(textElement);
                if (result == null)
                    result = caseDiagramElement(textElement);
				if (result == null)
					result = caseEModelElement(textElement);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.IMAGE: {
                Image image = (Image) theEObject;
                T result = caseImage(image);
                if (result == null)
                    result = caseLeafElement(image);
                if (result == null)
                    result = caseDiagramElement(image);
				if (result == null)
					result = caseEModelElement(image);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.GRAPHIC_PRIMITIVE: {
                GraphicPrimitive graphicPrimitive = (GraphicPrimitive) theEObject;
                T result = caseGraphicPrimitive(graphicPrimitive);
                if (result == null)
                    result = caseLeafElement(graphicPrimitive);
                if (result == null)
                    result = caseDiagramElement(graphicPrimitive);
				if (result == null)
					result = caseEModelElement(graphicPrimitive);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.REFERENCE: {
                Reference reference = (Reference) theEObject;
                T result = caseReference(reference);
                if (result == null)
                    result = caseDiagramElement(reference);
				if (result == null)
					result = caseEModelElement(reference);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.POLYLINE: {
                Polyline polyline = (Polyline) theEObject;
                T result = casePolyline(polyline);
                if (result == null)
                    result = caseGraphicPrimitive(polyline);
                if (result == null)
                    result = caseLeafElement(polyline);
                if (result == null)
                    result = caseDiagramElement(polyline);
				if (result == null)
					result = caseEModelElement(polyline);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.ELLIPSE: {
                Ellipse ellipse = (Ellipse) theEObject;
                T result = caseEllipse(ellipse);
                if (result == null)
                    result = caseGraphicPrimitive(ellipse);
                if (result == null)
                    result = caseLeafElement(ellipse);
                if (result == null)
                    result = caseDiagramElement(ellipse);
				if (result == null)
					result = caseEModelElement(ellipse);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.EDGE_OBJECT: {
                EdgeObject edgeObject = (EdgeObject) theEObject;
                T result = caseEdgeObject(edgeObject);
                if (result == null)
                    result = caseLeafElement(edgeObject);
                if (result == null)
                    result = caseDiagramElement(edgeObject);
				if (result == null)
					result = caseEModelElement(edgeObject);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.EDGE_OBJECT_OFFSET: {
                EdgeObjectOffset edgeObjectOffset = (EdgeObjectOffset) theEObject;
                T result = caseEdgeObjectOffset(edgeObjectOffset);
                if (result == null)
                    result = caseEdgeObject(edgeObjectOffset);
                if (result == null)
                    result = caseLeafElement(edgeObjectOffset);
                if (result == null)
                    result = caseDiagramElement(edgeObjectOffset);
				if (result == null)
					result = caseEModelElement(edgeObjectOffset);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case DiagramInterchangePackage.EDGE_OBJECT_UV: {
                EdgeObjectUV edgeObjectUV = (EdgeObjectUV) theEObject;
                T result = caseEdgeObjectUV(edgeObjectUV);
                if (result == null)
                    result = caseEdgeObject(edgeObjectUV);
                if (result == null)
                    result = caseLeafElement(edgeObjectUV);
                if (result == null)
                    result = caseDiagramElement(edgeObjectUV);
				if (result == null)
					result = caseEModelElement(edgeObjectUV);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProperty(Property object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Element</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagramElement(DiagramElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Graph Element</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Graph Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGraphElement(GraphElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Graph Edge</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Graph Edge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGraphEdge(GraphEdge object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Graph Node</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Graph Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGraphNode(GraphNode object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Graph Connector</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Graph Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGraphConnector(GraphConnector object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagram(Diagram object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Semantic Model Bridge</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Semantic Model Bridge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSemanticModelBridge(SemanticModelBridge object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EMF Semantic Model Bridge</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EMF Semantic Model Bridge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEMFSemanticModelBridge(EMFSemanticModelBridge object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple Semantic Model Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Semantic Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleSemanticModelElement(SimpleSemanticModelElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Link</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagramLink(DiagramLink object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Leaf Element</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Leaf Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLeafElement(LeafElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Text Element</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Text Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextElement(TextElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Image</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseImage(Image object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Graphic Primitive</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Graphic Primitive</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGraphicPrimitive(GraphicPrimitive object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Reference</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReference(Reference object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Polyline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Polyline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePolyline(Polyline object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ellipse</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ellipse</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEllipse(Ellipse object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Object</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEdgeObject(EdgeObject object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Object Offset</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Object Offset</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEdgeObjectOffset(EdgeObjectOffset object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Object UV</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Object UV</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEdgeObjectUV(EdgeObjectUV object)
    {
        return null;
    }

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch, but this is the last
     * case anyway. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object)
    {
        return null;
    }

} // DiagramInterchangeSwitch
