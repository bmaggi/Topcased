/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleObjectConfiguration.java,v 1.6 2007/04/18 12:21:02 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Simple Object Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSimpleObjectConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A SimpleObjectConfiguration is not linked
 *        with a model object. It has an attribute name that gives the string that will be used to reference the
 *        graphical object.'"
 * @generated
 */
public interface SimpleObjectConfiguration extends ObjectConfiguration
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSimpleObjectConfiguration_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // SimpleObjectConfiguration
