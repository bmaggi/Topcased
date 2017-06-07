/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphNode.java,v 1.11 2007/04/12 08:31:45 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Dimension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Graph Node</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.GraphNode#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphNode()
 * @model
 * @generated
 */
public interface GraphNode extends GraphElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Size</em>' attribute.
     * @see #setSize(Dimension)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getGraphNode_Size()
     * @model dataType="org.topcased.modeler.di.model.Dimension"
     * @generated
     */
    Dimension getSize();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.GraphNode#getSize <em>Size</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Size</em>' attribute.
     * @see #getSize()
     * @generated
     */
    void setSize(Dimension value);

} // GraphNode
