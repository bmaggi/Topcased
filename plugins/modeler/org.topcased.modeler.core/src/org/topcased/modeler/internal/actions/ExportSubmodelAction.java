/*******************************************************************************
 * Copyright (c) 2008,2009 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.collaboration.ExportSubmodelWizard;
import org.topcased.modeler.l10n.Messages;

/**
 * An action to export a controlled sub-model as a set of autonomous files suitable to send to a sub-contractor.
 * <p>
 * For a controlled sub-model in file <code>M.model</code>, with corresponding diagrams in <code>M.modeldi</code> , the
 * export will create three files:
 * <ul>
 * <li><code>M.part.model</code>: a copy of the contents of <code>M.model</code>;</li>
 * <li><code>M.part.modeldi</code>: a copy of the contents of <code>M.modeldi</code>;</li>
 * <li><code>M.cache.model</code>: a cache with copies of all the dependencies of the sub-model.</li>
 * </ul>
 * <p>
 * These three files taken as a whole are self-contained: the <code>part</code> files only reference the cache, which
 * itself is self-contained (except for references to system resources like meta-models).
 * <p>
 * See <a href="http://gforge.enseeiht.fr/tracker/index.php?func=detail&aid=1768&group_id=52&atid=133">Feature Request
 * #1768</a>.
 * 
 * @see ExportSubmodelWizard
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ExportSubmodelAction extends CommandActionHandler
{
    /**
     * The modeler invoking the action.
     */
    private Modeler modeler;

    /**
     * The root of the sub-model to export. The sub-model must already be under control of a separate resource.
     */
    private EObject eObject;

    /**
     * Creates a new <code>Export</code> action.
     */
    public ExportSubmodelAction(Modeler theModeler)
    {
        super(theModeler.getEditingDomain(), Messages.getString("ExportSubmodelAction.Action.title")); //$NON-NLS-1$
        setDescription(Messages.getString("ExportSubmodelAction.Action.desc")); //$NON-NLS-1$
        setToolTipText(Messages.getString("ExportSubmodelAction.Action.tooltip")); //$NON-NLS-1$
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.ui", "icons/full/etool16/export_wiz.gif")); //$NON-NLS-1$ //$NON-NLS-2$
        this.modeler = theModeler;
    }

    /**
     * This action is only available on model elements which are already under control of a separate resource.
     * 
     * @see ModelerControlAction
     */
    @Override
    public boolean isEnabled()
    {
        return AdapterFactoryEditingDomain.isControlled(eObject);
    }

    /**
     * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public boolean updateSelection(IStructuredSelection theSelection)
    {
        boolean result = false;
        if (theSelection.size() == 1)
        {
            Object object = AdapterFactoryEditingDomain.unwrap(theSelection.getFirstElement());
            result = AdapterFactoryEditingDomain.isControlled(object);
            eObject = result ? (EObject) object : null;
        }
        return result;
    }

    /**
     * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#run()
     */
    @Override
    public void run()
    {
        ExportSubmodelWizard wizard = new ExportSubmodelWizard(eObject, modeler);
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        WizardDialog dlg = new WizardDialog(shell, wizard);
        dlg.open();
    }
}
