/**
 * <copyright>
 * </copyright>
 *
 * $Id: VoidTypeImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.VoidType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Void Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class VoidTypeImpl extends BusinessTypeImpl implements VoidType
{
    private EList<EOperation> operations;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected VoidTypeImpl()
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
        return OcldiagramsPackage.Literals.VOID_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<EOperation> oclOperations()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

} // VoidTypeImpl
