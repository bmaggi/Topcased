/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.configurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Target Couple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerType <em>Container Type</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#isAutoRef <em>Auto Ref</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#isReversible <em>Reversible</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerObject <em>Container Object</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerRef <em>Container Ref</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToEdge <em>Ref Source To Edge</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToSource <em>Ref Edge To Source</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToEdge <em>Ref Target To Edge</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToTarget <em>Ref Edge To Target</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToTarget <em>Ref Source To Target</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToSource <em>Ref Target To Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple()
 * @model annotation="http://www.topcased.org/documentation documentation='It describes the different Policies to set for an EdgeEditPart'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204124278'"
 * @generated
 */
public interface SourceTargetCouple extends EObject{
    /**
     * Returns the value of the '<em><b>Container Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.EdgeContainerType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container Type</em>' attribute.
     * @see org.topcased.modeler.configurator.EdgeContainerType
     * @see #setContainerType(EdgeContainerType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_ContainerType()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204124481'"
     * @generated
     */
    EdgeContainerType getContainerType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerType <em>Container Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container Type</em>' attribute.
     * @see org.topcased.modeler.configurator.EdgeContainerType
     * @see #getContainerType()
     * @generated
     */
    void setContainerType(EdgeContainerType value);

    /**
     * Returns the value of the '<em><b>Reversible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reversible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reversible</em>' attribute.
     * @see #setReversible(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_Reversible()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204124583'"
     * @generated
     */
    boolean isReversible();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#isReversible <em>Reversible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reversible</em>' attribute.
     * @see #isReversible()
     * @generated
     */
    void setReversible(boolean value);

    /**
     * Returns the value of the '<em><b>Container Object</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container Object</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container Object</em>' reference.
     * @see #setContainerObject(GenClass)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_ContainerObject()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204124684'"
     * @generated
     */
    GenClass getContainerObject();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerObject <em>Container Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container Object</em>' reference.
     * @see #getContainerObject()
     * @generated
     */
    void setContainerObject(GenClass value);

    /**
     * Returns the value of the '<em><b>Source Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Node</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Node</em>' reference.
     * @see #setSourceNode(NodePartConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_SourceNode()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204124785'"
     * @generated
     */
    NodePartConfiguration getSourceNode();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getSourceNode <em>Source Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Node</em>' reference.
     * @see #getSourceNode()
     * @generated
     */
    void setSourceNode(NodePartConfiguration value);

    /**
     * Returns the value of the '<em><b>Target Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Node</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Node</em>' reference.
     * @see #setTargetNode(NodePartConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_TargetNode()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204124786'"
     * @generated
     */
    NodePartConfiguration getTargetNode();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getTargetNode <em>Target Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Node</em>' reference.
     * @see #getTargetNode()
     * @generated
     */
    void setTargetNode(NodePartConfiguration value);

    /**
     * Returns the value of the '<em><b>Auto Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Ref</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Auto Ref</em>' attribute.
     * @see #setAutoRef(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_AutoRef()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204124482'"
     * @generated
     */
    boolean isAutoRef();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#isAutoRef <em>Auto Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Auto Ref</em>' attribute.
     * @see #isAutoRef()
     * @generated
     */
    void setAutoRef(boolean value);

    /**
     * Returns the value of the '<em><b>Container Ref</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container Ref</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container Ref</em>' reference.
     * @see #setContainerRef(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_ContainerRef()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204124887'"
     * @generated
     */
    EStructuralFeature getContainerRef();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getContainerRef <em>Container Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container Ref</em>' reference.
     * @see #getContainerRef()
     * @generated
     */
    void setContainerRef(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Source To Edge</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Source To Edge</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Source To Edge</em>' reference.
     * @see #setRefSourceToEdge(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_RefSourceToEdge()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204124988'"
     * @generated
     */
    EStructuralFeature getRefSourceToEdge();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToEdge <em>Ref Source To Edge</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Source To Edge</em>' reference.
     * @see #getRefSourceToEdge()
     * @generated
     */
    void setRefSourceToEdge(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Edge To Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Edge To Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Edge To Source</em>' reference.
     * @see #setRefEdgeToSource(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_RefEdgeToSource()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204125089'"
     * @generated
     */
    EStructuralFeature getRefEdgeToSource();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToSource <em>Ref Edge To Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Edge To Source</em>' reference.
     * @see #getRefEdgeToSource()
     * @generated
     */
    void setRefEdgeToSource(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Target To Edge</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Target To Edge</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Target To Edge</em>' reference.
     * @see #setRefTargetToEdge(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_RefTargetToEdge()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204125090'"
     * @generated
     */
    EStructuralFeature getRefTargetToEdge();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToEdge <em>Ref Target To Edge</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Target To Edge</em>' reference.
     * @see #getRefTargetToEdge()
     * @generated
     */
    void setRefTargetToEdge(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Edge To Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Edge To Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Edge To Target</em>' reference.
     * @see #setRefEdgeToTarget(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_RefEdgeToTarget()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204125191'"
     * @generated
     */
    EStructuralFeature getRefEdgeToTarget();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefEdgeToTarget <em>Ref Edge To Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Edge To Target</em>' reference.
     * @see #getRefEdgeToTarget()
     * @generated
     */
    void setRefEdgeToTarget(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Source To Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Source To Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Source To Target</em>' reference.
     * @see #setRefSourceToTarget(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_RefSourceToTarget()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204125292'"
     * @generated
     */
    EStructuralFeature getRefSourceToTarget();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefSourceToTarget <em>Ref Source To Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Source To Target</em>' reference.
     * @see #getRefSourceToTarget()
     * @generated
     */
    void setRefSourceToTarget(EStructuralFeature value);

    /**
     * Returns the value of the '<em><b>Ref Target To Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ref Target To Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Target To Source</em>' reference.
     * @see #setRefTargetToSource(EStructuralFeature)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getSourceTargetCouple_RefTargetToSource()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204128693'"
     * @generated
     */
    EStructuralFeature getRefTargetToSource();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.SourceTargetCouple#getRefTargetToSource <em>Ref Target To Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Target To Source</em>' reference.
     * @see #getRefTargetToSource()
     * @generated
     */
    void setRefTargetToSource(EStructuralFeature value);

} // SourceTargetCouple
