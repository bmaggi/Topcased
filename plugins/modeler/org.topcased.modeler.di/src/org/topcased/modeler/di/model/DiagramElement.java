/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramElement.java,v 1.10 2008/12/05 13:53:53 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram Element</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.DiagramElement#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.DiagramElement#getProperty <em>Property</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.DiagramElement#getContainer <em>Container</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.DiagramElement#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramElement()
 * @model abstract="true"
 * @extends EModelElement
 * @generated
 */
public interface DiagramElement extends EModelElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Visible</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visible</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visible</em>' attribute.
     * @see #setVisible(boolean)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramElement_Visible()
     * @model default="true"
     * @generated
     */
    boolean isVisible();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.DiagramElement#isVisible <em>Visible</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Visible</em>' attribute.
     * @see #isVisible()
     * @generated
     */
    void setVisible(boolean value);

    /**
     * Returns the value of the '<em><b>Property</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property</em>' containment reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramElement_Property()
     * @model containment="true"
     * @generated
     */
    EList<Property> getProperty();

    /**
     * Returns the value of the '<em><b>Container</b></em>' container reference. It is bidirectional and its
     * opposite is '{@link org.topcased.modeler.di.model.GraphElement#getContained <em>Contained</em>}'. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' container reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Container</em>' container reference.
     * @see #setContainer(GraphElement)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramElement_Container()
     * @see org.topcased.modeler.di.model.GraphElement#getContained
     * @model opposite="contained"
     * @generated
     */
    GraphElement getContainer();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.DiagramElement#getContainer <em>Container</em>}' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' container reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer(GraphElement value);

    /**
     * Returns the value of the '<em><b>Reference</b></em>' reference list.
     * The list contents are of type {@link org.topcased.modeler.di.model.Reference}.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.Reference#getReferenced <em>Referenced</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference</em>' reference list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' reference list.
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getDiagramElement_Reference()
     * @see org.topcased.modeler.di.model.Reference#getReferenced
     * @model opposite="referenced"
     * @generated
     */
    EList<Reference> getReference();

} // DiagramElement
