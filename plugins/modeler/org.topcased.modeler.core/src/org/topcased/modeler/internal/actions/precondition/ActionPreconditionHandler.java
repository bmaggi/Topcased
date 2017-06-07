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
package org.topcased.modeler.internal.actions.precondition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.topcased.modeler.ActionConditionChecker;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.actions.DeleteAction;
import org.topcased.modeler.internal.actions.DeleteGraphElementAction;
import org.topcased.modeler.internal.actions.DeleteModelObjectAction;

/**
 * Handles the check of preconditions before executing actions. Preconditions are registered through the
 * org.topcased.modeler.actionPrecondition extension point.
 * 
 * @author vhemery
 */
public class ActionPreconditionHandler
{
    /**
     * The list of actions for which preconditions can be defined. This list's textual values are the same as the ones
     * used in the org.topcased.modeler.actionPrecondition extension point.
     */
    private enum ACTION {
        /**
         * Action to delete from the outline
         * 
         * @see org.topcased.modeler.internal.actions.DeleteAction
         */
        Delete,
        /**
         * Action to delete from model from the graphical editor
         * 
         * @see org.topcased.modeler.internal.actions.DeleteModelObjectAction
         */
        DeleteModel,
        /**
         * Action to delete from diagram from the graphical editor
         * 
         * @see org.topcased.modeler.internal.actions.DeleteGraphElementAction
         */
        DeleteGraph;

        /**
         * Get the correct enum value for the action.
         * 
         * @param uiAction the action to get the value for
         * @return enum value or null if none correspond
         */
        public static ACTION getValueForAction(Action uiAction)
        {
            if (uiAction instanceof DeleteGraphElementAction)
            {
                return DeleteGraph;
            }
            else if (uiAction instanceof DeleteModelObjectAction)
            {
                return DeleteModel;
            }
            else if (uiAction instanceof DeleteAction)
            {
                return Delete;
            }
            return null;
        }
    }

    /**
     * The list of priorities with which preconditions can be defined. This list's textual values are the same as the
     * ones used in the org.topcased.modeler.actionPrecondition extension point.
     */
    private enum PRIORITY {
        /** High priority to check conditions first */
        Highest,
        /** Low priority, default value */
        Low;

        /**
         * Get safely the value from a string
         * 
         * @param arg0 the string value corresponding to one of enum values
         * @return the corresponding enum value
         */
        public static PRIORITY getValue(String arg0)
        {
            PRIORITY res = valueOf(arg0);
            if (res instanceof PRIORITY)
            {
                return res;
            }
            return PRIORITY.Low;
        }
    }

    /** The name of the action precondition extension point */
    private static final String EXT_POINT = "org.topcased.modeler.actionPrecondition";

    /** The attribute to recover the checker executable class */
    private static final String CLASS_ATT = "checker";

    /** The attribute to recover the action on which precondition is checked */
    private static final String ACTION_ATT = "action";

    /** The attribute to recover the condition's priority */
    private static final String PRIORITY_ATT = "priority";

    /** the singleton instance */
    private static ActionPreconditionHandler instance;

    /** The list of preconditions to check for each action */
    private HashMap<ACTION, List<ActionConditionChecker>> preconditions;

    /**
     * Private constructor. Initializes the preconditions from the extension point.
     */
    private ActionPreconditionHandler()
    {
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_POINT);
        // initialize preconditions map
        preconditions = new HashMap<ACTION, List<ActionConditionChecker>>();
        for (ACTION action : ACTION.values())
        {
            preconditions.put(action, new ArrayList<ActionConditionChecker>(elements.length));
        }
        // fill preconditions map
        for (IConfigurationElement e : elements)
        {
            try
            {
                ACTION action = ACTION.valueOf(e.getAttribute(ACTION_ATT));
                if (action != null)
                {
                    Object checker = e.createExecutableExtension(CLASS_ATT);
                    if (checker instanceof ActionConditionChecker)
                    {
                        PRIORITY priority = PRIORITY.getValue(e.getAttribute(PRIORITY_ATT));
                        switch (priority)
                        {
                            case Highest:
                                preconditions.get(action).add(0, (ActionConditionChecker) checker);
                                break;
                            case Low:
                            default:
                                preconditions.get(action).add((ActionConditionChecker) checker);
                                break;
                        }
                    }
                }

            }
            catch (CoreException e1)
            {
                // ignore faulting extension
            }

        }
        instance = this;
    }

    /**
     * Check whether action can be performed, against defined preconditions.
     * 
     * @param actionToCheck action for which conditions must be checked. This must be one of checkable actions :
     *        {@link DeleteAction}, {@link DeleteGraphElementAction} or {@link DeleteModelObjectAction}
     * @param modeler the modeler part
     * @param selection the selection on which the action is performed
     * @return true if conditions are met
     */
    public boolean executePreconditions(Action actionToCheck, Modeler modeler, IStructuredSelection selection)
    {
        ACTION actionType = ACTION.getValueForAction(actionToCheck);
        if (actionType != null)
        {
            for (ActionConditionChecker condition : preconditions.get(actionType))
            {
                if (!condition.checkCondition(actionToCheck, modeler, selection))
                {
                    // condition failed. Stop right now.
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the singleton
     * 
     * @return the only instance
     */
    public static ActionPreconditionHandler getInstance()
    {
        if (instance == null)
        {
            instance = new ActionPreconditionHandler();
        }
        return instance;
    }
}
