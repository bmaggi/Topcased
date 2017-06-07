/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnyTypeImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.ocl.ocldi.AnyType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.internal.OCLStandardLibraryImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Any Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class AnyTypeImpl extends BusinessTypeImpl implements AnyType
{
    private EList<EOperation> operations;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AnyTypeImpl()
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
        return OcldiPackage.Literals.ANY_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getName()
    {
        if (this instanceof ENamedElement)
        {
            return ((ENamedElement) this).getName();
        }
        else
        {
            if (this instanceof Diagram)
            {
                return ((Diagram) this).getName();
            }
        }
        throw new UnsupportedOperationException("Element Name property not determined.");
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
            AnyType prototype = (AnyType) OCLStandardLibraryImpl.INSTANCE.getOclAny();

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

} // AnyTypeImpl
