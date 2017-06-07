/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
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
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.collaboration.ExportUtil;

public class DisableExportedStatusAction extends CommandActionHandler
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
    public DisableExportedStatusAction(Modeler theModeler)
    {
        super(theModeler.getEditingDomain(), "Revert exported status");
        this.modeler = theModeler;
    }

    /**
     * This action is only available on model elements which are already under control of a separate resource.
     * 
     * @see ModelerControlAction
     */
    public boolean isEnabled()
    {
        return AdapterFactoryEditingDomain.isControlled(eObject) && ExportUtil.isExported(eObject.eResource());
    }

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

    @Override
    public void run()
    {
        if (MessageDialog.openConfirm(null, "Confirm",
                "This sub-model is currently marked as exported.\nReverting this mark and changing the model may make it impossible to re-import a new version.\nAre you sure you want to revert the exported status?"))
        {
            AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) modeler.getEditingDomain();
            afed.getResourceToReadOnlyMap().remove(eObject.eResource());
            Diagrams diagramsRoot = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), eObject);
            Resource diagramsResource = diagramsRoot != null ? diagramsRoot.eResource() : null;
            if (diagramsResource != null)
            {
                afed.getResourceToReadOnlyMap().remove(diagramsResource);
            }
            ExportUtil.removeExportedDate(eObject.eResource());
        }
    }
}
