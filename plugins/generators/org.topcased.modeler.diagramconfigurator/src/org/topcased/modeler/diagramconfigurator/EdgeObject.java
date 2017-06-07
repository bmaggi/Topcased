/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObject.java,v 1.7 2007/04/18 12:20:58 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Edge Object</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getType <em>Type</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getEStructuralFeature <em>EStructural Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgeObject()
 * @model
 * @generated
 */
public interface EdgeObject extends EObject
{
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgeObject_Id()
     * @model required="true"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getId <em>Id</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The default value is <code>"Source"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.diagramconfigurator.EdgeObjectType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObjectType
     * @see #setType(EdgeObjectType)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgeObject_Type()
     * @model default="Source"
     * @generated
     */
    EdgeObjectType getType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getType <em>Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObjectType
     * @see #getType()
     * @generated
     */
    void setType(EdgeObjectType value);

    /**
     * Returns the value of the '<em><b>EStructural Feature</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>EStructural Feature</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>EStructural Feature</em>' reference.
     * @see #setEStructuralFeature(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgeObject_EStructuralFeature()
     * @model
     * @generated
     */
    EStructuralFeature getEStructuralFeature();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgeObject#getEStructuralFeature <em>EStructural Feature</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>EStructural Feature</em>' reference.
     * @see #getEStructuralFeature()
     * @generated
     */
    void setEStructuralFeature(EStructuralFeature value);

} // EdgeObject
