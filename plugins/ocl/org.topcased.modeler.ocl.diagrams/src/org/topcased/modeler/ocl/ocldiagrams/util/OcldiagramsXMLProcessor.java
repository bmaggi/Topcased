/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiagramsXMLProcessor.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class OcldiagramsXMLProcessor extends XMLProcessor
{

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiagramsXMLProcessor()
    {
        super((EPackage.Registry.INSTANCE));
        OcldiagramsPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the OcldiagramsResourceFactoryImpl factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations()
    {
        if (registrations == null)
        {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new OcldiagramsResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new OcldiagramsResourceFactoryImpl());
        }
        return registrations;
    }

} // OcldiagramsXMLProcessor
