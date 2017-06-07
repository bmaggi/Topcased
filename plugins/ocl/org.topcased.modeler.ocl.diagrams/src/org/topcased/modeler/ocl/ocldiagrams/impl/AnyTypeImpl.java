/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnyTypeImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.ocl.ocldiagrams.AnyType;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

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
        return OcldiagramsPackage.Literals.ANY_TYPE;
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
            if (this instanceof Diagrams)
            {
                return ((Diagrams) this).getActiveDiagram().getName();
            }
        }
        throw new UnsupportedOperationException("Element Name property not determined.");
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

} // AnyTypeImpl
