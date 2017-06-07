/**
 * <copyright>
 * </copyright>
 *
 * $Id: InvalidTypeImpl.java,v 1.2 2009/04/20 08:10:34 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.topcased.modeler.ocl.ocldi.InvalidType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.internal.OCLStandardLibraryImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Invalid Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class InvalidTypeImpl extends BusinessTypeImpl implements InvalidType
{
    private EList<EOperation> operations;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InvalidTypeImpl()
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
        return OcldiPackage.Literals.INVALID_TYPE;
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
     * @generated NOT
     */
    public EList<EOperation> oclOperations()
    {
        if (operations == null)
        {
            InvalidType prototype = (InvalidType) OCLStandardLibraryImpl.INSTANCE.getInvalid();

            if (prototype == this)
            {
                // I *am* the standard library type!
                operations = OCLStandardLibraryImpl.getExistingOperations((EClassifier) this);
            }
            else
            {
                // the prototype defines my operations for me
                operations = prototype.oclOperations();
            }
        }

        return operations;
    }

} // InvalidTypeImpl
