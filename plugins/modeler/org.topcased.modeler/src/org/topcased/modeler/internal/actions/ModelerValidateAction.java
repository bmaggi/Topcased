/*******************************************************************************
 * Copyright (c) 2005,2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.validation.ui.actions.ValidateAction;

/**
 * Validate a list of EObjects with the constraints from the metamodel. <br>
 * Creation : 11 January 2010<br>
 * Updated : 21 January 2010<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ModelerValidateAction extends WorkbenchPartAction
{

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public ModelerValidateAction(IWorkbenchPart part)
    {
        super(part);
    }

    /**
     * Validates a list of EObjects
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    @Override
    public void run()
    {
        IWorkbenchPart part = getWorkbenchPart();
        if (part instanceof Modeler)
        {
            Modeler modeler = (Modeler) part;
            IFileEditorInput input = (IFileEditorInput) modeler.getEditorInput();
            IAction action = new ValidateAction(input.getFile(), modeler.getDiagrams().getModel(), modeler.getDiagrams());
            action.run();
        }
    }

    /**
     * Determines if the action must appear in the context menu
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    @Override
    protected boolean calculateEnabled()
    {
        return true;
    }

    /**
     * Initializes the check live action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    @Override
    protected void init()
    {
        setId(ModelerActionConstants.VALIDATE);
        setText("Model validation");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("VALIDATE"));
    }

}
