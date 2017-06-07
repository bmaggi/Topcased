/***********************************************************************************************************************
 * Copyright (c) 2008 Communication and Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Christophe LE CAMUS (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.modeler.ocl.ocldi;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.topcased.modeler.ocl.ocldi.internal.OCLStandardLibraryImpl;

/**
 * Implementation of the {@link Environment} for parsing OCL expressions on Ecore models. The
 * <code>EcoreEnvironment</code> uses a client-supplied package registry (or the global registry) to look up
 * {@link EPackage}s by qualified name.
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @author <a href="mailto:christophe.lecamus@c-s.fr">Christophe LE CAMUS</a>
 */
public class OcldiEnvironment extends EcoreEnvironment
{

    private static final String NS_URI = "http://www.eclipse.org/oclsam/stdlib/1.1"; //$NON-NLS-1$

    /**
     * Initializes me with a package registry for package look-ups.
     * 
     * @param reg a package registry
     */
    protected OcldiEnvironment(EPackage.Registry reg)
    {
        super(reg);
        defineCustomOperations();
    }

    /**
     * Initializes me with a parent environment, from which I inherit such things as a package registry and a resource.
     * 
     * @param parent my parent environment
     */
    protected OcldiEnvironment(OcldiEnvironment parent)
    {
        super(parent);
    }

    /**
     * Initializes me with a package registry and a resource in which I am persisted (and from which I load myself if it
     * already has content).
     * 
     * @param reg a package registry
     * @param resource a resource, which may or may not already have content
     */

    protected OcldiEnvironment(EPackage.Registry reg, Resource resource)
    {
        super(reg, resource);
    }

    /**
     * @see org.eclipse.ocl.ecore.EcoreEnvironment#setFactory(org.eclipse.ocl.EnvironmentFactory)
     */
    @Override
    protected void setFactory(
            EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> factory)
    {
        super.setFactory(factory);
    }

    // use the AbstractEnvironment's mechanism for defining "additional operations"
    // to add our custom operation to OCL's String primitive type
    /**
     * Defines a set of custom operations for the SAM language and register them in the operation helper.
     */
    private void defineCustomOperations()
    {
        // Get the oclstdlib.ecore contained in its plug-in
        Resource resource = new ResourceSetImpl().getResource(URI.createURI(NS_URI), true);
        EPackage root = (EPackage) resource.getContents().get(0);
        for (EClassifier aClassifier : root.getEClassifiers())
        {
            if (aClassifier instanceof EClass)
            {
                EClass aClass = (EClass) aClassifier;
                BasicEList<EOperation> myList = new BasicEList<EOperation>(aClass.getEOperations());
                for (EOperation toCopy : myList)
                {
                    EOperation operationtoAdd = createOperation(toCopy);
                    Constraint existing = getDefinition(operationtoAdd);
                    if (existing == null)
                    {
                        EClassifier resolvedClassifier = OCLStandardLibraryImpl.getRealClassifier(aClass);
                        if (resolvedClassifier != null)
                        {
                            if (resolvedClassifier instanceof PrimitiveType)
                            {
                                if (resolvedClassifier.getName().equals("String"))
                                {
                                    addHelperOperation(getOCLStandardLibrary().getString(), operationtoAdd);
                                }
                                if (resolvedClassifier.getName().equals("Boolean"))
                                {
                                    addHelperOperation(getOCLStandardLibrary().getBoolean(), operationtoAdd);
                                }
                                if (resolvedClassifier.getName().equals("Integer"))
                                {
                                    addHelperOperation(getOCLStandardLibrary().getInteger(), operationtoAdd);
                                }
                                if (resolvedClassifier.getName().equals("UnlimitedNatural"))
                                {
                                    addHelperOperation(getOCLStandardLibrary().getUnlimitedNatural(), operationtoAdd);
                                }
                                if (resolvedClassifier.getName().equals("Real"))
                                {
                                    addHelperOperation(getOCLStandardLibrary().getReal(), operationtoAdd);
                                }
                            }
                            if (resolvedClassifier.getName().equals("OclAny"))
                            {
                                addHelperOperation(getOCLStandardLibrary().getOclAny(), operationtoAdd);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Creates an EOperation in order to add it in the OCL Helper
     * 
     * @param sourceOp The source operation to create
     * @return The EOperation created for this purpose
     */
    private EOperation createOperation(EOperation sourceOp)
    {
        EOperation opToBeDefined = EcoreFactory.eINSTANCE.createEOperation();
        opToBeDefined.setName(sourceOp.getName());
        opToBeDefined.setEType(sourceOp.getEType());

        for (EParameter parameter : sourceOp.getEParameters())
        {
            EParameter parm = EcoreFactory.eINSTANCE.createEParameter();
            parm.setName(parameter.getName());
            parm.setEType(parameter.getEType());
            opToBeDefined.getEParameters().add(parm);
        }
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource("OcldiEnvironment");
        opToBeDefined.getEAnnotations().add(annotation);

        return opToBeDefined;
    }
}
