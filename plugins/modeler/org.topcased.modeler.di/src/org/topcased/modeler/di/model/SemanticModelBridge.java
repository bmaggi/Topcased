/**
 * <copyright>
 * </copyright>
 *
 * $Id: SemanticModelBridge.java,v 1.11 2007/04/12 08:31:45 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Semantic Model Bridge</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.SemanticModelBridge#getPresentation <em>Presentation</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.SemanticModelBridge#getGraphElement <em>Graph Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getSemanticModelBridge()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface SemanticModelBridge extends EModelElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Presentation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Presentation</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Presentation</em>' attribute.
     * @see #setPresentation(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getSemanticModelBridge_Presentation()
     * @model
     * @generated
     */
    String getPresentation();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.SemanticModelBridge#getPresentation <em>Presentation</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Presentation</em>' attribute.
     * @see #getPresentation()
     * @generated
     */
    void setPresentation(String value);

    /**
     * Returns the value of the '<em><b>Graph Element</b></em>' container reference. It is bidirectional and its
     * opposite is '{@link org.topcased.modeler.di.model.GraphElement#getSemanticModel <em>Semantic Model</em>}'. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Graph Element</em>' container reference isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Graph Element</em>' container reference.
     * @see #setGraphElement(GraphElement)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getSemanticModelBridge_GraphElement()
     * @see org.topcased.modeler.di.model.GraphElement#getSemanticModel
     * @model opposite="semanticModel" required="true"
     * @generated
     */
    GraphElement getGraphElement();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.SemanticModelBridge#getGraphElement <em>Graph Element</em>}' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Graph Element</em>' container reference.
     * @see #getGraphElement()
     * @generated
     */
    void setGraphElement(GraphElement value);

} // SemanticModelBridge
