/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsFactoryImpl.java,v 1.3 2007/04/12 08:32:12 jako Exp $
 */
package org.topcased.modeler.diagrams.model.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.topcased.modeler.diagrams.model.*;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.diagrams.model.DiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class DiagramsFactoryImpl extends EFactoryImpl implements DiagramsFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "";

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static DiagramsFactory init()
    {
        try
        {
            DiagramsFactory theDiagramsFactory = (DiagramsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/Diagrams/1.0"); 
            if (theDiagramsFactory != null)
            {
                return theDiagramsFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DiagramsFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramsFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case DiagramsPackage.DIAGRAMS: return createDiagrams();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagrams createDiagrams()
    {
        DiagramsImpl diagrams = new DiagramsImpl();
        return diagrams;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramsPackage getDiagramsPackage()
    {
        return (DiagramsPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DiagramsPackage getPackage()
    {
        return DiagramsPackage.eINSTANCE;
    }

} // DiagramsFactoryImpl
