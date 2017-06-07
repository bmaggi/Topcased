/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiResourceFactoryImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.ocl.ocldi.util.OcldiResourceImpl
 * @generated
 */
public class OcldiResourceFactoryImpl extends ResourceFactoryImpl
{
    /**
     * Creates an instance of the resource factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiResourceFactoryImpl()
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
        XMLResource result = new OcldiResourceImpl(uri);
        result.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
        result.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

        result.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

        result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
        result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);

        result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
        return result;
    }

} // OcldiResourceFactoryImpl
