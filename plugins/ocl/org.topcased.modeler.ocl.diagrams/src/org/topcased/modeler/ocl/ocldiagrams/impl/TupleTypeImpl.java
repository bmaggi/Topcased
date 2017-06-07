/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleTypeImpl.java,v 1.2 2009/04/20 08:07:07 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.types.operations.TupleTypeOperations;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.TupleType;
import org.topcased.modeler.ocl.ocldiagrams.internal.OCLStandardLibraryImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tuple Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class TupleTypeImpl extends EClassImpl implements TupleType
{
    private EList<EOperation> operations;

    private EList<EStructuralFeature> properties;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TupleTypeImpl()
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
        return OcldiagramsPackage.Literals.TUPLE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkTupleTypeName(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return TupleTypeOperations.checkTupleTypeName(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkPartNamesUnique(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return TupleTypeOperations.checkPartNamesUnique(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkFeaturesOnlyProperties(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return TupleTypeOperations.checkFeaturesOnlyProperties(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<EStructuralFeature> oclProperties()
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
            operations = ((AnyType) OCLStandardLibraryImpl.INSTANCE.getOclAny()).oclOperations();
        }

        return operations;
    }

} // TupleTypeImpl
