/**
 * <copyright>
 * </copyright>
 *
 * $Id: Constraint.java,v 1.5 2007/04/18 12:21:01 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Constraint</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.Constraint#getLanguage <em>Language</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.Constraint#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject
{
    /**
     * Returns the value of the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Language</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Language</em>' attribute.
     * @see #setLanguage(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getConstraint_Language()
     * @model required="true"
     * @generated
     */
    String getLanguage();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.Constraint#getLanguage <em>Language</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Language</em>' attribute.
     * @see #getLanguage()
     * @generated
     */
    void setLanguage(String value);

    /**
     * Returns the value of the '<em><b>Rule</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rule</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Rule</em>' attribute.
     * @see #setRule(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getConstraint_Rule()
     * @model required="true"
     * @generated
     */
    String getRule();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.Constraint#getRule <em>Rule</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Rule</em>' attribute.
     * @see #getRule()
     * @generated
     */
    void setRule(String value);

} // Constraint
