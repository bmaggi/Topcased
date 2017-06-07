/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectOffset.java,v 1.6 2007/04/12 08:31:47 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Dimension;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Edge Object Offset</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.EdgeObjectOffset#getOffset <em>Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObjectOffset()
 * @model
 * @generated
 */
public interface EdgeObjectOffset extends EdgeObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Offset</b></em>' attribute. The default value is <code>""</code>. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offset</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Offset</em>' attribute.
     * @see #setOffset(Dimension)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObjectOffset_Offset()
     * @model default="" dataType="org.topcased.modeler.di.model.Dimension"
     * @generated
     */
    Dimension getOffset();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.EdgeObjectOffset#getOffset <em>Offset</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Offset</em>' attribute.
     * @see #getOffset()
     * @generated
     */
    void setOffset(Dimension value);

} // EdgeObjectOffset
