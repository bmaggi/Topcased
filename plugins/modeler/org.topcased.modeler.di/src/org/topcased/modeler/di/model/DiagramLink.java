/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramLink.java,v 1.8 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram Link</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.DiagramLink#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.DiagramLink#getViewport <em>Viewport</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.DiagramLink#getGraphElement <em>Graph Element</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.DiagramLink#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramLink()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface DiagramLink extends EModelElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zoom</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zoom</em>' attribute.
     * @see #setZoom(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramLink_Zoom()
     * @model
     * @generated
     */
    double getZoom();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.DiagramLink#getZoom <em>Zoom</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Zoom</em>' attribute.
     * @see #getZoom()
     * @generated
     */
    void setZoom(double value);

    /**
     * Returns the value of the '<em><b>Viewport</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Viewport</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Viewport</em>' attribute.
     * @see #setViewport(Point)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramLink_Viewport()
     * @model dataType="org.topcased.modeler.di.model.Point"
     * @generated
     */
    Point getViewport();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.DiagramLink#getViewport <em>Viewport</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Viewport</em>' attribute.
     * @see #getViewport()
     * @generated
     */
    void setViewport(Point value);

    /**
     * Returns the value of the '<em><b>Graph Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.GraphElement#getLink <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Graph Element</em>' container reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Graph Element</em>' container reference.
     * @see #setGraphElement(GraphElement)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramLink_GraphElement()
     * @see org.topcased.modeler.di.model.GraphElement#getLink
     * @model opposite="link" required="true" transient="false"
     * @generated
     */
    GraphElement getGraphElement();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.DiagramLink#getGraphElement <em>Graph Element</em>}' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Graph Element</em>' container reference.
     * @see #getGraphElement()
     * @generated
     */
    void setGraphElement(GraphElement value);

    /**
     * Returns the value of the '<em><b>Diagram</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.Diagram#getDiagramLink <em>Diagram Link</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagram</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diagram</em>' reference.
     * @see #setDiagram(Diagram)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramLink_Diagram()
     * @see org.topcased.modeler.di.model.Diagram#getDiagramLink
     * @model opposite="diagramLink" required="true"
     * @generated
     */
    Diagram getDiagram();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.DiagramLink#getDiagram <em>Diagram</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Diagram</em>' reference.
     * @see #getDiagram()
     * @generated
     */
    void setDiagram(Diagram value);

} // DiagramLink
