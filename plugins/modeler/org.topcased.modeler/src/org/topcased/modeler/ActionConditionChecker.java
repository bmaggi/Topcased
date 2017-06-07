/*******************************************************************************
 * Copyright (c) 2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vincent Hemery (Atos Origin) - Initial API and implementation
 *******************************************************************************/
package org.topcased.modeler;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.topcased.modeler.editor.Modeler;

/**
 * This interface is implemented by classes which check whether an action is valid, just after the user has decided to
 * execute it. This check can rely on model information, on a user confirmation...
 * 
 * @author vhemery
 */
public interface ActionConditionChecker
{
    /**
     * Check whether the action is authorized. In case the action is canceled, this method must also inform the user of
     * the reasons if necessary.
     * 
     * @param actionToCheck the action which must be checked.
     * @param modeler the modeler part
     * @param selection the selection on which the action is performed
     * @return true if action is authorized, false if it must be canceled.
     */
    public boolean checkCondition(Action actionToCheck, Modeler modeler, IStructuredSelection selection);

}