/**
 * <copyright>
 * </copyright>
 *
 * $Id: Diagram.java,v 1.14 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.Diagram#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Diagram#getZoom <em>Zoom</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Diagram#getViewport <em>Viewport</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Diagram#getDiagramLink <em>Diagram Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends GraphNode
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagram_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Diagram#getName <em>Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Zoom</b></em>' attribute. The default value is <code>"1.0"</code>. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zoom</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Zoom</em>' attribute.
     * @see #setZoom(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagram_Zoom()
     * @model default="1.0"
     * @generated
     */
    double getZoom();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Diagram#getZoom <em>Zoom</em>}' attribute. <!--
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
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagram_Viewport()
     * @model dataType="org.topcased.modeler.di.model.Point"
     * @generated
     */
    Point getViewport();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Diagram#getViewport <em>Viewport</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Viewport</em>' attribute.
     * @see #getViewport()
     * @generated
     */
    void setViewport(Point value);

    /**
     * Returns the value of the '<em><b>Diagram Link</b></em>' reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.DiagramLink}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.DiagramLink#getDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagram Link</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diagram Link</em>' reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagram_DiagramLink()
     * @see org.topcased.modeler.di.model.DiagramLink#getDiagram
     * @model opposite="diagram"
     * @generated
     */
    EList<DiagramLink> getDiagramLink();

} // Diagram
