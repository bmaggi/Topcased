/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorconfiguratorResourceFactoryImpl.java,v 1.3 2007/04/18 12:54:45 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.editorconfigurator.util.EditorconfiguratorResourceImpl
 * @generated
 */
public class EditorconfiguratorResourceFactoryImpl extends ResourceFactoryImpl
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * Creates an instance of the resource factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorconfiguratorResourceFactoryImpl()
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
        Resource result = new EditorconfiguratorResourceImpl(uri);
        return result;
    }

} // EditorconfiguratorResourceFactoryImpl
