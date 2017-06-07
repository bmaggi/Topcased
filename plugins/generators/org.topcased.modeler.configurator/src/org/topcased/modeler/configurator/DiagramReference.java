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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.DiagramReference#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramReference#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.DiagramReference#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramReference()
 * @model annotation="http://www.topcased.org/documentation documentation='A DiagramReference is linked with a DiagramConfiguration'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204120423'"
 * @generated
 */
public interface DiagramReference extends EObject{
    /**
     * Returns the value of the '<em><b>Diagram</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagram</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diagram</em>' reference.
     * @see #setDiagram(DiagramConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramReference_Diagram()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204120626'"
     * @generated
     */
    DiagramConfiguration getDiagram();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramReference#getDiagram <em>Diagram</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Diagram</em>' reference.
     * @see #getDiagram()
     * @generated
     */
    void setDiagram(DiagramConfiguration value);

    /**
     * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lower Bound</em>' attribute.
     * @see #setLowerBound(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramReference_LowerBound()
     * @model ordered="false"
     *        annotation="http://www.topcased.org/uuid uuid='113198204120627'"
     * @generated
     */
    int getLowerBound();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramReference#getLowerBound <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lower Bound</em>' attribute.
     * @see #getLowerBound()
     * @generated
     */
    void setLowerBound(int value);

    /**
     * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Upper Bound</em>' attribute.
     * @see #setUpperBound(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getDiagramReference_UpperBound()
     * @model default="-1" ordered="false"
     *        annotation="http://www.topcased.org/uuid uuid='113198204120728'"
     * @generated
     */
    int getUpperBound();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.DiagramReference#getUpperBound <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Upper Bound</em>' attribute.
     * @see #getUpperBound()
     * @generated
     */
    void setUpperBound(int value);

} // DiagramReference
