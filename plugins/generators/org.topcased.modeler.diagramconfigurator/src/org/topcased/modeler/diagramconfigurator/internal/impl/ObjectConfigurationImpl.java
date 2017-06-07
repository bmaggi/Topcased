/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectConfigurationImpl.java,v 1.4 2007/04/18 12:21:06 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Object Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class ObjectConfigurationImpl extends EObjectImpl implements ObjectConfiguration
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ObjectConfigurationImpl()
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
        return DiagramconfiguratorPackage.Literals.OBJECT_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getName()
    {
        return "ObjectConfigurationName";
    }

} // ObjectConfigurationImpl
