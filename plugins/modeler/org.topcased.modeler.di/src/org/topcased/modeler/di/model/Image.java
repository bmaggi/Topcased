/**
 * <copyright>
 * </copyright>
 *
 * $Id: Image.java,v 1.7 2007/04/12 08:31:52 jako Exp $
 */
package org.topcased.modeler.di.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Image</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.Image#getUri <em>Uri</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Image#getMimeType <em>Mime Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getImage()
 * @model
 * @generated
 */
public interface Image extends LeafElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getImage_Uri()
     * @model
     * @generated
     */
    String getUri();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Image#getUri <em>Uri</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri(String value);

    /**
     * Returns the value of the '<em><b>Mime Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mime Type</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mime Type</em>' attribute.
     * @see #setMimeType(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getImage_MimeType()
     * @model
     * @generated
     */
    String getMimeType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Image#getMimeType <em>Mime Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Mime Type</em>' attribute.
     * @see #getMimeType()
     * @generated
     */
    void setMimeType(String value);

} // Image
