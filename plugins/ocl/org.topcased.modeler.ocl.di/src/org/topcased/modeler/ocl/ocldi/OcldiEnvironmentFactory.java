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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.topcased.modeler.ocl.ocldi.internal.OCLStandardLibraryImpl;
import org.topcased.modeler.ocl.ocldi.internal.UMLReflectionImpl;

/**
 * Implementation of the {@link EnvironmentFactory} for parsing OCL expressions on Ecore models.
 * 
 * @author Christian W. Damus (cdamus)
 */

public class OcldiEnvironmentFactory extends EcoreEnvironmentFactory
{

    public static OcldiEnvironmentFactory INSTANCE = new OcldiEnvironmentFactory();

    private final EPackage.Registry registry;

    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     */
    public OcldiEnvironmentFactory()
    {
        this(EPackage.Registry.INSTANCE);
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages.
     * 
     * @param reg my package registry (must not be <code>null</code>)
     */
    public OcldiEnvironmentFactory(EPackage.Registry reg)
    {
        super();
        this.registry = reg;
    }

    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent)
    {
        if (!(parent instanceof OcldiEnvironment))
        {
            throw new IllegalArgumentException("Parent environment must be Sam environment: " + parent);
        }

        OcldiEnvironment result = new OcldiEnvironment((OcldiEnvironment) parent);
        result.setFactory(this);
        return result;
    }

    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment()
    {
        OcldiEnvironment result = new OcldiEnvironment(getEPackageRegistry());
        result.setFactory(this);
        return result;
    }

    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment()
    {
        return new OcldiEvaluationEnvironment();
    }

    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent)
    {
        return new OcldiEvaluationEnvironment(parent);
    }

    static EClassifier oclType(Object object)
    {
        EClassifier result = null;

        if (object instanceof EObject)
        {
            result = ((EObject) object).eClass();
        }
        else
        {
            // maybe it's an instance of an Ecore data type?
            for (EClassifier next : EcorePackage.eINSTANCE.getEClassifiers())
            {
                if ((next != EcorePackage.Literals.EJAVA_OBJECT) && (next.isInstance(object)))
                {
                    result = UMLReflectionImpl.INSTANCE.asOCLType(next);
                    break;
                }
            }

            if (result == null)
            {
                // it's just some weirdo object that we don't understand
                result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
            }
        }

        return result;
    }

    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> loadEnvironment(
            Resource resource)
    {
        OcldiEnvironment result = new OcldiEnvironment(registry, resource);
        result.setFactory(this);
        return result;
    }

}