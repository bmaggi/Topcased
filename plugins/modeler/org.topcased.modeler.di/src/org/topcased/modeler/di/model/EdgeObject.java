/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObject.java,v 1.8 2007/04/12 08:31:45 jako Exp $
 */
package org.topcased.modeler.di.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Edge Object</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.EdgeObject#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObject()
 * @model abstract="true"
 * @generated
 */
public interface EdgeObject extends LeafElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEdgeObject_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.EdgeObject#getId <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // EdgeObject
