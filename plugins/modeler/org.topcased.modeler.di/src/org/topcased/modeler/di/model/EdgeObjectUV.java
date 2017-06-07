/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectUV.java,v 1.6 2007/04/12 08:31:47 jako Exp $
 */
package org.topcased.modeler.di.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Edge Object UV</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.EdgeObjectUV#getUDistance <em>UDistance</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.EdgeObjectUV#getVDistance <em>VDistance</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObjectUV()
 * @model
 * @generated
 */
public interface EdgeObjectUV extends EdgeObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>UDistance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>UDistance</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>UDistance</em>' attribute.
     * @see #setUDistance(int)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObjectUV_UDistance()
     * @model
     * @generated
     */
    int getUDistance();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.EdgeObjectUV#getUDistance <em>UDistance</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>UDistance</em>' attribute.
     * @see #getUDistance()
     * @generated
     */
    void setUDistance(int value);

    /**
     * Returns the value of the '<em><b>VDistance</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>VDistance</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>VDistance</em>' attribute.
     * @see #setVDistance(int)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObjectUV_VDistance()
     * @model
     * @generated
     */
    int getVDistance();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.EdgeObjectUV#getVDistance <em>VDistance</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>VDistance</em>' attribute.
     * @see #getVDistance()
     * @generated
     */
    void setVDistance(int value);

} // EdgeObjectUV
