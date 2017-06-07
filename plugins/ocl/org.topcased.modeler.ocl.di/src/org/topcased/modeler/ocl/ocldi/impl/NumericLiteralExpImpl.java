/**
 * <copyright>
 * </copyright>
 *
 * $Id: NumericLiteralExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.ecore.EClass;
import org.topcased.modeler.ocl.ocldi.NumericLiteralExp;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Numeric Literal Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class NumericLiteralExpImpl extends PrimitiveLiteralExpImpl implements NumericLiteralExp
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NumericLiteralExpImpl()
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
        return OcldiPackage.Literals.NUMERIC_LITERAL_EXP;
    }

} // NumericLiteralExpImpl
