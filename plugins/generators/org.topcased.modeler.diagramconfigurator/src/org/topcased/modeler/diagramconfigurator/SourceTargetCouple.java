/**
 * <copyright>
 * </copyright>
 *
 * $Id: SourceTargetCouple.java,v 1.9 2007/04/18 12:54:12 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Source Target Couple</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerType <em>Container Type</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isAutoRef <em>Auto Ref</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isReversible <em>Reversible</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerObject <em>Container Object</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getSourceNode <em>Source Node</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getTargetNode <em>Target Node</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerRef <em>Container Ref</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToEdge <em>Ref Source To Edge</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToSource <em>Ref Edge To Source</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToEdge <em>Ref Target To Edge</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToTarget <em>Ref Edge To Target</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToTarget <em>Ref Source To Target</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToSource <em>Ref Target To Source</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple()
 * @model annotation="http://www.topcased.org/documentation documentation='It describes the different Policies to set
 *        for an EdgeEditPart'" annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourceNode TargetNode
 *        ContainerType ContainerObject ContainerRef RefSourceToEdge RefEdgeToSource RefTargetToEdge RefEdgeToTarget
 *        RefSourceToTarget RefTargetToSource RefConstraint'"
 * @generated
 */
public interface SourceTargetCouple extends EObject
{
    /**
     * Returns the value of the '<em><b>Container Type</b></em>' attribute. The default value is
     * <code>"NONE"</code>. The literals are from the enumeration
     * {@link org.topcased.modeler.diagramconfigurator.EdgeContainerType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container Type</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Container Type</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.EdgeContainerType
     * @see #setContainerType(EdgeContainerType)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_ContainerType()
     * @model default="NONE"
     * @generated
     */
    EdgeContainerType getContainerType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerType <em>Container Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Container Type</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.EdgeContainerType
     * @see #getContainerType()
     * @generated
     */
    void setContainerType(EdgeContainerType value);

    /**
     * Returns the value of the '<em><b>Auto Ref</b></em>' attribute. The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Ref</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Auto Ref</em>' attribute.
     * @see #setAutoRef(boolean)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_AutoRef()
     * @model default="false"
     * @generated
     */
    boolean isAutoRef();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isAutoRef <em>Auto Ref</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Auto Ref</em>' attribute.
     * @see #isAutoRef()
     * @generated
     */
    void setAutoRef(boolean value);

    /**
     * Returns the value of the '<em><b>Reversible</b></em>' attribute. The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reversible</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Reversible</em>' attribute.
     * @see #setReversible(boolean)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_Reversible()
     * @model default="false"
     * @generated
     */
    boolean isReversible();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#isReversible <em>Reversible</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Reversible</em>' attribute.
     * @see #isReversible()
     * @generated
     */
    void setReversible(boolean value);

    /**
     * Returns the value of the '<em><b>Container Object</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container Object</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Container Object</em>' reference.
     * @see #setContainerObject(GenClass)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_ContainerObject()
     * @model
     * @generated
     */
    GenClass getContainerObject();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerObject <em>Container Object</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Container Object</em>' reference.
     * @see #getContainerObject()
     * @generated
     */
    void setContainerObject(GenClass value);

    /**
     * Returns the value of the '<em><b>Source Node</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Node</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Source Node</em>' reference.
     * @see #setSourceNode(PartConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_SourceNode()
     * @model required="true"
     * @generated
     */
    PartConfiguration getSourceNode();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getSourceNode <em>Source Node</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Source Node</em>' reference.
     * @see #getSourceNode()
     * @generated
     */
    void setSourceNode(PartConfiguration value);

    /**
     * Returns the value of the '<em><b>Target Node</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Node</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target Node</em>' reference.
     * @see #setTargetNode(PartConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_TargetNode()
     * @model required="true"
     * @generated
     */
    PartConfiguration getTargetNode();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getTargetNode <em>Target Node</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Target Node</em>' reference.
     * @see #getTargetNode()
     * @generated
     */
    void setTargetNode(PartConfiguration value);

    /**
     * Returns the value of the '<em><b>Container Ref</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container Ref</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Container Ref</em>' reference.
     * @see #setContainerRef(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_ContainerRef()
     * @model
     * @generated
     */
    EStructuralFeature getContainerRef();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getContainerRef <em>Container Ref</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Container Ref</em>' reference.
     * @see #getContainerRef()
     * @generated
     */
    void setContainerRef(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Source To Edge</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Source To Edge</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref Source To Edge</em>' reference.
     * @see #setRefSourceToEdge(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_RefSourceToEdge()
     * @model
     * @generated
     */
    EStructuralFeature getRefSourceToEdge();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToEdge <em>Ref Source To Edge</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ref Source To Edge</em>' reference.
     * @see #getRefSourceToEdge()
     * @generated
     */
    void setRefSourceToEdge(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Edge To Source</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Edge To Source</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref Edge To Source</em>' reference.
     * @see #setRefEdgeToSource(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_RefEdgeToSource()
     * @model
     * @generated
     */
    EStructuralFeature getRefEdgeToSource();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToSource <em>Ref Edge To Source</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ref Edge To Source</em>' reference.
     * @see #getRefEdgeToSource()
     * @generated
     */
    void setRefEdgeToSource(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Target To Edge</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Target To Edge</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref Target To Edge</em>' reference.
     * @see #setRefTargetToEdge(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_RefTargetToEdge()
     * @model
     * @generated
     */
    EStructuralFeature getRefTargetToEdge();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToEdge <em>Ref Target To Edge</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ref Target To Edge</em>' reference.
     * @see #getRefTargetToEdge()
     * @generated
     */
    void setRefTargetToEdge(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Edge To Target</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Edge To Target</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref Edge To Target</em>' reference.
     * @see #setRefEdgeToTarget(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_RefEdgeToTarget()
     * @model
     * @generated
     */
    EStructuralFeature getRefEdgeToTarget();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefEdgeToTarget <em>Ref Edge To Target</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ref Edge To Target</em>' reference.
     * @see #getRefEdgeToTarget()
     * @generated
     */
    void setRefEdgeToTarget(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Source To Target</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Source To Target</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref Source To Target</em>' reference.
     * @see #setRefSourceToTarget(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_RefSourceToTarget()
     * @model
     * @generated
     */
    EStructuralFeature getRefSourceToTarget();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefSourceToTarget <em>Ref Source To Target</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ref Source To Target</em>' reference.
     * @see #getRefSourceToTarget()
     * @generated
     */
    void setRefSourceToTarget(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Target To Source</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Target To Source</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref Target To Source</em>' reference.
     * @see #setRefTargetToSource(EStructuralFeature)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getSourceTargetCouple_RefTargetToSource()
     * @model
     * @generated
     */
    EStructuralFeature getRefTargetToSource();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple#getRefTargetToSource <em>Ref Target To Source</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ref Target To Source</em>' reference.
     * @see #getRefTargetToSource()
     * @generated
     */
    void setRefTargetToSource(EStructuralFeature value);

} // SourceTargetCouple
