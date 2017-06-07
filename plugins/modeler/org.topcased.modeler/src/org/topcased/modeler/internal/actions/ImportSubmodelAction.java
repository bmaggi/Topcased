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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.collaboration.ExportUtil;
import org.topcased.modeler.internal.collaboration.ImportSubmodelWizard;
import org.topcased.modeler.l10n.Messages;

/**
 * An action to re-import a sub-model which has been exported using {@link ExportSubmodelAction}, and possibly modified
 * since.
 * <p>
 * The current implementation simply overwrites the controlled sub-model with the version imported, and assumes that all
 * the "frontier" elements required (elements from the parent which refer to the sub-model, or vice-versa) are
 * available.
 * <p>
 * See <a href="http://gforge.enseeiht.fr/tracker/index.php?func=detail&aid=1768&group_id=52&atid=133">Feature Request
 * #1768</a>.
 * 
 * @see ExportSubmodelAction
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ImportSubmodelAction extends CommandActionHandler
{
    /**
     * The modeler invoking the action.
     */
    private Modeler modeler;

    /**
     * The root of the sub-model to replace with the imported version. The sub-model already be under control of a
     * separate resource.
     */
    private EObject eObject;

    /**
     * Creates a new <code>Import</code> action.
     */
    public ImportSubmodelAction(Modeler theModeler)
    {
        super(theModeler.getEditingDomain(), Messages.getString("ImportSubmodelAction.Action.title")); //$NON-NLS-1$
        setDescription(Messages.getString("ImportSubmodelAction.Action.desc")); //$NON-NLS-1$
        setToolTipText(Messages.getString("ImportSubmodelAction.Action.tooltip")); //$NON-NLS-1$
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.ui", "icons/full/etool16/import_wiz.gif")); //$NON-NLS-1$ //$NON-NLS-2$
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
        return AdapterFactoryEditingDomain.isControlled(eObject) && ExportUtil.isExported(eObject.eResource());
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
        if (modeler.isDirty())
        {
            MessageDialog.openError(null, Messages.getString("ImportSubmodelAction.Dialog.error.title"), Messages.getString("ImportSubmodelAction.Dialog.error.msg")); //$NON-NLS-1$ //$NON-NLS-2$
            return;
        }
        Diagrams diagramsRoot = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), eObject);
        Resource diagramsResource = diagramsRoot != null ? diagramsRoot.eResource() : null;
        if (ExportUtil.wasModifiedSinceExported(eObject.eResource(), diagramsResource))
        {
            boolean confirm = MessageDialog.openConfirm(null, Messages.getString("ImportSubmodelAction.Dialog.confirm.title"), //$NON-NLS-1$
                    Messages.getString("ImportSubmodelAction.Dialog.confirm.msg")); //$NON-NLS-1$
            if (!confirm)
            {
                return;
            }
        }
        ImportSubmodelWizard wizard = new ImportSubmodelWizard(eObject, modeler);
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        WizardDialog dlg = new WizardDialog(shell, wizard);
        dlg.open();
    }
}
