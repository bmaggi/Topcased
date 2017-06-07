/**
 * <copyright>
 * </copyright>
 *
 * $Id: Constraint.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.utilities.ExpressionInOCL;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Constraint</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.Constraint#getSpecification <em>Specification</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.Constraint#getConstrainedElements <em>Constrained Elements</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.Constraint#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.ocl.ocldi.OcldiPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EClassifier
{
    /**
     * Returns the value of the '<em><b>Specification</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specification</em>' containment reference isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Specification</em>' containment reference.
     * @see #setSpecification(ExpressionInOCL)
     * @see org.topcased.modeler.ocl.ocldi.OcldiPackage#getConstraint_Specification()
     * @model containment="true" required="true"
     * @generated
     */
    ExpressionInOCL<EClassifier, EParameter> getSpecification();

    /**
     * Sets the value of the '{@link org.topcased.modeler.ocl.ocldi.Constraint#getSpecification <em>Specification</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Specification</em>' containment reference.
     * @see #getSpecification()
     * @generated
     */
    void setSpecification(ExpressionInOCL<EClassifier, EParameter> value);

    /**
     * Returns the value of the '<em><b>Constrained Elements</b></em>' reference list. The list contents are of type
     * {@link org.topcased.modeler.ocl.ocldi.BusinessType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constrained Elements</em>' reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Constrained Elements</em>' reference list.
     * @see org.topcased.modeler.ocl.ocldi.OcldiPackage#getConstraint_ConstrainedElements()
     * @model
     * @generated
     */
    EList<BusinessType> getConstrainedElements();

    /**
     * Returns the value of the '<em><b>Stereotype</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stereotype</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Stereotype</em>' attribute.
     * @see #setStereotype(String)
     * @see org.topcased.modeler.ocl.ocldi.OcldiPackage#getConstraint_Stereotype()
     * @model
     * @generated
     */
    String getStereotype();

    /**
     * Sets the value of the '{@link org.topcased.modeler.ocl.ocldi.Constraint#getStereotype <em>Stereotype</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Stereotype</em>' attribute.
     * @see #getStereotype()
     * @generated
     */
    void setStereotype(String value);

} // Constraint
