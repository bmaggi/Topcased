/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgePartConfiguration.java,v 1.9 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Edge Part Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceTargetCouple <em>Source Target Couple</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getEdgeObjects <em>Edge Objects</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceDecoration <em>Source Decoration</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getTargetDecoration <em>Target Decoration</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDefaultRouter <em>Default Router</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDirectEditable <em>Direct Editable</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A PartConfiguration will be associated with
 *        an EdgeEditPart at the generation process.'" annotation="http://www.eclipse.org/emf/2002/Ecore
 *        constraints='DirectEditable'"
 * @generated
 */
public interface EdgePartConfiguration extends PartConfiguration
{
    /**
     * Returns the value of the '<em><b>Source Target Couple</b></em>' containment reference list. The list
     * contents are of type {@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Source Target Couple</em>' containment reference list isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Target Couple</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration_SourceTargetCouple()
     * @model containment="true" required="true"
     * @generated
     */
    EList<SourceTargetCouple> getSourceTargetCouple();

    /**
     * Returns the value of the '<em><b>Edge Objects</b></em>' containment reference list. The list contents are of
     * type {@link org.topcased.modeler.diagramconfigurator.EdgeObject}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Edge Objects</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Edge Objects</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration_EdgeObjects()
     * @model containment="true"
     * @generated
     */
    EList<EdgeObject> getEdgeObjects();

    /**
     * Returns the value of the '<em><b>Source Decoration</b></em>' attribute. The default value is
     * <code>"NONE"</code>. The literals are from the enumeration
     * {@link org.topcased.modeler.diagramconfigurator.DecorationType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Decoration</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Decoration</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.DecorationType
     * @see #setSourceDecoration(DecorationType)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration_SourceDecoration()
     * @model default="NONE"
     * @generated
     */
    DecorationType getSourceDecoration();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getSourceDecoration <em>Source Decoration</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Source Decoration</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.DecorationType
     * @see #getSourceDecoration()
     * @generated
     */
    void setSourceDecoration(DecorationType value);

    /**
     * Returns the value of the '<em><b>Target Decoration</b></em>' attribute. The default value is
     * <code>"NONE"</code>. The literals are from the enumeration
     * {@link org.topcased.modeler.diagramconfigurator.DecorationType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Decoration</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target Decoration</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.DecorationType
     * @see #setTargetDecoration(DecorationType)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration_TargetDecoration()
     * @model default="NONE"
     * @generated
     */
    DecorationType getTargetDecoration();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getTargetDecoration <em>Target Decoration</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Target Decoration</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.DecorationType
     * @see #getTargetDecoration()
     * @generated
     */
    void setTargetDecoration(DecorationType value);

    /**
     * Returns the value of the '<em><b>Default Router</b></em>' attribute. The default value is
     * <code>"ObliqueRouter"</code>. The literals are from the enumeration
     * {@link org.topcased.modeler.diagramconfigurator.RouterType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Router</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Router</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.RouterType
     * @see #setDefaultRouter(RouterType)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration_DefaultRouter()
     * @model default="ObliqueRouter"
     * @generated
     */
    RouterType getDefaultRouter();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDefaultRouter <em>Default Router</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Router</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.RouterType
     * @see #getDefaultRouter()
     * @generated
     */
    void setDefaultRouter(RouterType value);

    /**
     * Returns the value of the '<em><b>Direct Editable</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Direct Editable</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Direct Editable</em>' reference.
     * @see #setDirectEditable(EdgeObject)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getEdgePartConfiguration_DirectEditable()
     * @model
     * @generated
     */
    EdgeObject getDirectEditable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration#getDirectEditable <em>Direct Editable</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Direct Editable</em>' reference.
     * @see #getDirectEditable()
     * @generated
     */
    void setDirectEditable(EdgeObject value);

} // EdgePartConfiguration
