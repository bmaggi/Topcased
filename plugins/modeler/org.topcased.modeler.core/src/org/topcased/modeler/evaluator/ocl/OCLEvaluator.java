/*******************************************************************************
 * Copyright (c) 2006,2010 Anyware Technologies. 
 * 
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies), - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.evaluator.ocl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.options.ParsingOptions;
import org.topcased.modeler.evaluator.IEvaluator;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Validate an EObject with the EMF basic validation <br>
 * 
 * Creation : 16 January 2006<br>
 * Update : 16 January 2010<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class OCLEvaluator implements IEvaluator
{

    private static OCL< ? , EClassifier, ? , ? , ? , ? , ? , ? , ? , Constraint, EClass, EObject> ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

    private static OCLHelper<EClassifier, ? , ? , Constraint> helper = ocl.createOCLHelper();
    
    static {
    	ParsingOptions.setOption(ocl.getEnvironment(),
    			ParsingOptions.implicitRootClass(ocl.getEnvironment()),
    			EcorePackage.Literals.EOBJECT);
    }

    /**
     * @see org.topcased.modeler.evaluator.IEvaluator#eval(org.eclipse.emf.ecore.EObject, java.lang.String)
     */
    public boolean eval(EObject eObject, String rule)
    {
        boolean valid = false;

        try
        {
            helper.setContext(eObject.eClass());
            Constraint invariant = helper.createInvariant(rule);
            Query<EClassifier, EClass, EObject> constraintEval = ocl.createQuery(invariant);
            valid = constraintEval.check(eObject);
        }
        catch (ParserException e)
        {
            ModelerPlugin.log(e.getLocalizedMessage(), IStatus.ERROR);
        }

        return valid;
    }

}
