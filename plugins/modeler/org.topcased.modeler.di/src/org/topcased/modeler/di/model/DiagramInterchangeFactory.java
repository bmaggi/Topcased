/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangeFactory.java,v 1.13 2007/04/12 08:31:48 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage
 * @generated
 */
public interface DiagramInterchangeFactory extends EFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    DiagramInterchangeFactory eINSTANCE = org.topcased.modeler.di.model.internal.impl.DiagramInterchangeFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Property</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Property</em>'.
     * @generated
     */
    Property createProperty();

    /**
     * Returns a new object of class '<em>Graph Edge</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Graph Edge</em>'.
     * @generated
     */
    GraphEdge createGraphEdge();

    /**
     * Returns a new object of class '<em>Graph Node</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Graph Node</em>'.
     * @generated
     */
    GraphNode createGraphNode();

    /**
     * Returns a new object of class '<em>Graph Connector</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Graph Connector</em>'.
     * @generated
     */
    GraphConnector createGraphConnector();

    /**
     * Returns a new object of class '<em>Diagram</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Diagram</em>'.
     * @generated
     */
    Diagram createDiagram();

    /**
     * Returns a new object of class '<em>Semantic Model Bridge</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Semantic Model Bridge</em>'.
     * @generated
     */
    SemanticModelBridge createSemanticModelBridge();

    /**
     * Returns a new object of class '<em>EMF Semantic Model Bridge</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>EMF Semantic Model Bridge</em>'.
     * @generated
     */
    EMFSemanticModelBridge createEMFSemanticModelBridge();

    /**
     * Returns a new object of class '<em>Simple Semantic Model Element</em>'.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @return a new object of class '<em>Simple Semantic Model Element</em>'.
     * @generated
     */
    SimpleSemanticModelElement createSimpleSemanticModelElement();

    /**
     * Returns a new object of class '<em>Diagram Link</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Diagram Link</em>'.
     * @generated
     */
    DiagramLink createDiagramLink();

    /**
     * Returns a new object of class '<em>Leaf Element</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Leaf Element</em>'.
     * @generated
     */
    LeafElement createLeafElement();

    /**
     * Returns a new object of class '<em>Text Element</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Text Element</em>'.
     * @generated
     */
    TextElement createTextElement();

    /**
     * Returns a new object of class '<em>Image</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Image</em>'.
     * @generated
     */
    Image createImage();

    /**
     * Returns a new object of class '<em>Graphic Primitive</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Graphic Primitive</em>'.
     * @generated
     */
    GraphicPrimitive createGraphicPrimitive();

    /**
     * Returns a new object of class '<em>Reference</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Reference</em>'.
     * @generated
     */
    Reference createReference();

    /**
     * Returns a new object of class '<em>Polyline</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Polyline</em>'.
     * @generated
     */
    Polyline createPolyline();

    /**
     * Returns a new object of class '<em>Ellipse</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Ellipse</em>'.
     * @generated
     */
    Ellipse createEllipse();

    /**
     * Returns a new object of class '<em>Edge Object Offset</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Edge Object Offset</em>'.
     * @generated
     */
    EdgeObjectOffset createEdgeObjectOffset();

    /**
     * Returns a new object of class '<em>Edge Object UV</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Edge Object UV</em>'.
     * @generated
     */
    EdgeObjectUV createEdgeObjectUV();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DiagramInterchangePackage getDiagramInterchangePackage();

} // DiagramInterchangeFactory
