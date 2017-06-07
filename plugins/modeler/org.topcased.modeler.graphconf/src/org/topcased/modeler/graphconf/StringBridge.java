/**
 * <copyright>
 * </copyright>
 *
 * $Id: StringBridge.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>String Bridge</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.StringBridge#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getStringBridge()
 * @model
 * @generated
 */
public interface StringBridge extends Bridge
{
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getStringBridge_Type()
     * @model required="true"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.StringBridge#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

} // StringBridge
