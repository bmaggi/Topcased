/**
 * <copyright>
 * </copyright>
 *
 * $Id: LoopExpImpl.java,v 1.2 2009/04/20 08:10:34 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.LoopExp;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Loop Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class LoopExpImpl extends org.eclipse.ocl.expressions.impl.LoopExpImpl<BusinessType, EParameter> implements LoopExp
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LoopExpImpl()
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
        return OcldiPackage.Literals.LOOP_EXP;
    }

} // LoopExpImpl
