/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeGraphConf.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Edge Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.EdgeGraphConf#getDefaultRouter <em>Default Router</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getEdgeGraphConf()
 * @model annotation="http://www.topcased.org/documentation documentation='An EdgeGraphConf is associated with an
 *        EdgePartConfiguration. It gives informations on the graphical element.'"
 * @generated
 */
public interface EdgeGraphConf extends AbstractGraphConf
{
    /**
     * Returns the value of the '<em><b>Default Router</b></em>' attribute. The literals are from the enumeration
     * {@link org.topcased.modeler.graphconf.RouterType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Router</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Router</em>' attribute.
     * @see org.topcased.modeler.graphconf.RouterType
     * @see #setDefaultRouter(RouterType)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getEdgeGraphConf_DefaultRouter()
     * @model
     * @generated
     */
    RouterType getDefaultRouter();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.EdgeGraphConf#getDefaultRouter <em>Default Router</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Router</em>' attribute.
     * @see org.topcased.modeler.graphconf.RouterType
     * @see #getDefaultRouter()
     * @generated
     */
    void setDefaultRouter(RouterType value);

} // EdgeGraphConf
