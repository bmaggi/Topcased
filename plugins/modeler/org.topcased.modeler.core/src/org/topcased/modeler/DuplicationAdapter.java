/*****************************************************************************
 * Copyright (c) 2008 TOPCASED consortium.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.topcased.modeler.actions.DuplicateSubTreeAction;

/**
 * An interface that extensions can implement to customize the behavior of {@link DuplicateSubTreeAction} for a given
 * meta-model/language. See the extension point <code>org.topcased.modeler.duplicationAdapter</code>.
 */
public interface DuplicationAdapter
{
    /**
     * This method is invoked once before the copy is executed, passing the target element of the action as a parameter.
     * The elements it returns are additional semantic elements (not diagrams) outside of the target element's subtree
     * which must also be copied. Those additional elements will be copied (including their subtrees) during the main
     * copy, and their copies references to the original main elements will be updated to point to the copies of the
     * main elements.
     * 
     * @param original the target element of the "Duplication subtree" action.
     * @return additional elements which are not part of <code>target</code> subtree but which must also be copied.
     *         These elements must not contain or be contained, directly or indirectly, any elements from the main
     *         copied subtree; otherwise the behavior of the duplication is not specified.
     */
    Collection<EObject> getAdditionalObjects(EObject original);

    /**
     * This method is invoked once after the copy to determine meta-model specific customizations on the result.
     * 
     * @param editingDomain the EditingDomain to use to create the command
     * @param original the original target element on which the "Duplication subtree" action has been invoked.
     * @param mainMapping a mapping from every original element of the copied subtree to its copy.
     * @param additionMapping a mapping from every original element of the {@link #getAdditionalObjects(EObject)
     *        additional elements} copied subtrees to its copy.
     * @return the EMF command to execute to apply any required post-processing.
     */
    Command getPostProcessingCommand(EditingDomain editingDomain, EObject original, Map<EObject, EObject> mainMapping, Map<EObject, EObject> additionalMapping);
}
