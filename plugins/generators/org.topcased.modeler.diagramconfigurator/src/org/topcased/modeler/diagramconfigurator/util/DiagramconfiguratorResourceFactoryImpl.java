/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorResourceFactoryImpl.java,v 1.7 2007/04/18 12:20:56 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.diagramconfigurator.util.DiagramconfiguratorResourceImpl
 * @generated
 */
public class DiagramconfiguratorResourceFactoryImpl extends ResourceFactoryImpl
{
    /**
     * Creates an instance of the resource factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramconfiguratorResourceFactoryImpl()
    {
        super();
    }

    /**
     * Creates an instance of the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Resource createResource(URI uri)
    {
        Resource result = new DiagramconfiguratorResourceImpl(uri);
        return result;
    }

} // DiagramconfiguratorResourceFactoryImpl
