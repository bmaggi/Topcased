/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfXMLProcessor.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.topcased.modeler.graphconf.GraphconfPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class GraphconfXMLProcessor extends XMLProcessor
{

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfXMLProcessor()
    {
        super((EPackage.Registry.INSTANCE));
        GraphconfPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the GraphconfResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected Map getRegistrations()
    {
        if (registrations == null)
        {
            super.getRegistrations();
            registrations.put(XML_EXTENSION, new GraphconfResourceFactoryImpl());
            registrations.put(STAR_EXTENSION, new GraphconfResourceFactoryImpl());
        }
        return registrations;
    }

} // GraphconfXMLProcessor
