/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfResourceFactoryImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.graphconf.util.GraphconfResourceImpl
 * @generated
 */
public class GraphconfResourceFactoryImpl extends ResourceFactoryImpl
{
    /**
     * Creates an instance of the resource factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfResourceFactoryImpl()
    {
        super();
    }

    /**
     * Creates an instance of the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Resource createResource(URI uri)
    {
        Resource result = new GraphconfResourceImpl(uri);
        return result;
    }

} // GraphconfResourceFactoryImpl
