/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessTypeImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.ecore.EClass;
import org.topcased.modeler.di.model.internal.impl.DiagramElementImpl;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Business Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class BusinessTypeImpl extends DiagramElementImpl implements BusinessType
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BusinessTypeImpl()
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
        return OcldiPackage.Literals.BUSINESS_TYPE;
    }

} // BusinessTypeImpl
