/**
 * <copyright>
 * </copyright>
 *
 * $Id: IteratorExpImpl.java,v 1.2 2009/04/20 08:07:07 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.expressions.operations.IteratorExpOperations;
import org.topcased.modeler.ocl.ocldiagrams.IteratorExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Iterator Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class IteratorExpImpl extends LoopExpImpl implements IteratorExp
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IteratorExpImpl()
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
        return OcldiagramsPackage.Literals.ITERATOR_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkBooleanType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IteratorExpOperations.checkBooleanType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkCollectType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IteratorExpOperations.checkCollectType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkSelectRejectType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IteratorExpOperations.checkSelectRejectType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkBooleanBodyType(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return IteratorExpOperations.checkBooleanBodyType(this, diagnostics, context);
    }

} // IteratorExpImpl
