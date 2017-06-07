/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsResourceFactoryImpl.java,v 1.7 2007/04/12 08:32:15 jako Exp $
 */
package org.topcased.modeler.diagrams.model.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagrams.model.util.DiagramsResourceImpl
 * @generated
 */
public class DiagramsResourceFactoryImpl extends ResourceFactoryImpl
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "";

    /**
     * Creates an instance of the resource factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramsResourceFactoryImpl()
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
        Resource result = new DiagramsResourceImpl(uri);
        return result;
    }

} // DiagramsResourceFactoryImpl
