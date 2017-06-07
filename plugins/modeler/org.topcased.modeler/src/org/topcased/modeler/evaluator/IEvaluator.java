/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.evaluator;

import org.eclipse.emf.ecore.EObject;

/**
 * Evaluate an Object
 * 
 * Creation 20 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface IEvaluator
{

    /**
     * Evaluate the specified Object, using a specified context and a given rule
     * (the condition to match)
     * 
     * @param eObject the EObject to evaluate
     * @param rule a String that represent the constraint to evaluate
     * @return the evaluation status
     * @throws EvaluatorException if the engine cannot execute the constraint
     */
    boolean eval(EObject eObject, String rule) throws EvaluatorException;
}
