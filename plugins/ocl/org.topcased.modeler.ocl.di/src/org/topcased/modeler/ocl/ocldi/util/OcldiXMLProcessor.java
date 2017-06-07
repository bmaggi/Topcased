/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiXMLProcessor.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class OcldiXMLProcessor extends XMLProcessor
{

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiXMLProcessor()
    {
        super((EPackage.Registry.INSTANCE));
        OcldiPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the OcldiResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations()
    {
        if (registrations == null)
        {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new OcldiResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new OcldiResourceFactoryImpl());
        }
        return registrations;
    }

} // OcldiXMLProcessor
