//------------------------------------------------
// $Id: SourceTargetCoupleAction.java,v 1.2 2006/10/24 08:31:09 mickael Exp $
// (c) Anyware Technologies 2006    www.anyware-tech.com
//------------------------------------------------
package org.topcased.modeler.diagramconfigurator.internal.wizards;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;

/**
 * 
 * This action is used to launch the new SourceTargetCoupleWizard <br>
 * creation : 4 oct. 06
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class SourceTargetCoupleAction implements IObjectActionDelegate
{
    private EdgePartConfiguration edgePartConfiguration;

    private IWorkbenchPart targetPart;

    /**
     * 
     * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
     *      org.eclipse.ui.IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart)
    {
        this.targetPart = targetPart;
    }

    /**
     * Launch the SourceTargetCouple Wizard
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        IWizard wizard = new SourceTargetCoupleWizard(edgePartConfiguration);
        WizardDialog dialog = new WizardDialog(targetPart.getSite().getShell(), wizard);
        dialog.open();
    }

    /**
     * 
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {

        if (selection instanceof IStructuredSelection)
        {
            Object first = ((IStructuredSelection) selection).getFirstElement();
            if (first instanceof EdgePartConfiguration)
            {
                edgePartConfiguration = (EdgePartConfiguration) first;
                action.setEnabled(true);
            }
        }
    }

}