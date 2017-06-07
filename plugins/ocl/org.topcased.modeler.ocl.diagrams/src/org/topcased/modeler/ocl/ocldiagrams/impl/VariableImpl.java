/**
 * <copyright>
 * </copyright>
 *
 * $Id: VariableImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.Variable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variable</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class VariableImpl extends org.eclipse.ocl.expressions.impl.VariableImpl<BusinessType, EParameter> implements Variable
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected VariableImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return OcldiagramsPackage.Literals.VARIABLE;
    }

} // VariableImpl
