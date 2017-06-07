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
package org.topcased.modeler.internal.collaboration;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * A two-pages wizard for the export action. The first page allows the user to select the destination resource(s), and
 * the second offers a preview of the cache's content (currently read-only, and only including strictly required
 * elements).
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ExportSubmodelWizard extends Wizard
{
    private static final SemanticDependenciesManager DEPENDENCIES_MANAGER = SemanticDependenciesManager.getInstance();

    /**
     * The modeler which invoked the export action.
     */
    private final Modeler modeler;

    /**
     * The root element of the sub-model to export.
     */
    private final EObject root;

    /**
     * The first page of the wizard, which allows the user to select the name and location of the exported files.
     */
    private SelectTargetFilesWizardPage selectFilesPage;

    /**
     * The specification of what will be put in the cache. The user can review and (partially) edit this in the second
     * page of the wizard.
     */
    private final CacheContentsSpecification cacheSpec;

    public ExportSubmodelWizard(EObject root, Modeler modeler)
    {
        this.root = root;
        this.modeler = modeler;
        Diagrams diagramsRoot = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), root);
        this.cacheSpec = new CacheContentsSpecification(root, diagramsRoot, DEPENDENCIES_MANAGER.getDetectorFor(root));
    }
    
    @Override
    public Image getDefaultPageImage()
    {
        return ModelerImageRegistry.getImage("EXPORT_MODEL_WIZARD");
    }

    @Override
    public void addPages()
    {
        setWindowTitle("Export submodel");

        selectFilesPage = new SelectTargetFilesWizardPage(root.eResource());
        addPage(selectFilesPage);

        IWizardPage previewCachePage = new CachePreviewWizardPage(modeler.getAdapterFactory(), cacheSpec);
        addPage(previewCachePage);
    }

    @Override
    public boolean performFinish()
    {
        URI targetUri = selectFilesPage.getSelectedURI();
        ExportSubmodelCommand cmd = new ExportSubmodelCommand(root, targetUri, cacheSpec, modeler);
        return cmd.execute();
    }
}