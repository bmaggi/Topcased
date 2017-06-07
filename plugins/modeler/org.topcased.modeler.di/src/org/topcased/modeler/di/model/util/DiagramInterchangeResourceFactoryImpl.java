/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramInterchangeResourceFactoryImpl.java,v 1.11 2007/04/12 08:31:52 jako Exp $
 */
package org.topcased.modeler.di.model.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * @see org.topcased.modeler.di.model.util.DiagramInterchangeResourceImpl
 * @generated
 */
public class DiagramInterchangeResourceFactoryImpl extends ResourceFactoryImpl
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Creates an instance of the resource factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramInterchangeResourceFactoryImpl()
    {
        super();
    }

    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Resource createResource(URI uri)
    {
        Resource result = new DiagramInterchangeResourceImpl(uri);
        return result;
    }

} // DiagramInterchangeResourceFactoryImpl
