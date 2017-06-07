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

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * A two-pages wizard for the import action. The first page allows the user to select the sub-model to import. The
 * second assists the user in the matching/merging process for the parts which can not be imported automatically.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ImportSubmodelWizard extends Wizard
{
    /**
     * The first page of the wizard, which allows the user to select the sub-model to import.
     */
    private SelectSourceFileWizardPage selectSourceFilePage;

    /**
     * The root of the sub-model to replace with the imported version. The sub-model already be under control of a
     * separate resource.
     */
    private EObject controlledModelRoot;

    /**
     * The root of the diagrams to replace with the imported versions.
     */
    private Diagrams controlledDiagramsRoot;

    /**
     * The configuration information presented to the user and edited by him.
     */
    private ImportConfiguration importConfiguration;

    /**
     * The modeler which invoked the import action.
     */
    private Modeler modeler;

    public ImportSubmodelWizard(EObject root, Modeler modeler)
    {
        this.controlledModelRoot = root;
        this.controlledDiagramsRoot = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), root);
        this.modeler = modeler;
    }
    
    @Override
    public Image getDefaultPageImage()
    {
        return ModelerImageRegistry.getImage("IMPORT_MODEL_WIZARD");
    }
    
    @Override
    public void addPages()
    {
        setWindowTitle("Import submodel");

        selectSourceFilePage = new SelectSourceFileWizardPage(controlledModelRoot.eResource().getURI());
        addPage(selectSourceFilePage);
        addPage(new OutboundReferencesConfigurationPage());
        addPage(new InboundReferencesConfigurationPage());
    }

    @Override
    public boolean performFinish()
    {
        ImportSubmodelCommand cmd = new ImportSubmodelCommand(modeler, getImportConfiguration());
        cmd.execute();
        return true;
    }

    ImportConfiguration getImportConfiguration()
    {
        URI selectedUri = selectSourceFilePage.getPartURI();
        if (selectedUri == null)
        {
            selectedUri = ExportUtil.getExportedModelURI(controlledModelRoot.eResource());
        }

        if (importConfiguration == null)
        {
            importConfiguration = new ImportConfiguration(controlledModelRoot, controlledDiagramsRoot, selectedUri, modeler.getEditingDomain());
        }
        else if (!importConfiguration.getExportedModelUri().equals(selectedUri))
        {
            importConfiguration.dispose();
            importConfiguration = new ImportConfiguration(controlledModelRoot, controlledDiagramsRoot, selectedUri, modeler.getEditingDomain());
        }

        return importConfiguration;
    }
    
    private class OutboundReferencesConfigurationPage extends ReferencesConfigurationPage
    {
        public OutboundReferencesConfigurationPage()
        {
            super("outboundReferences", modeler.getAdapterFactory());
            setTitle("Configure outbound references");
            setDescription("Configure how to update the references from the main model to the sub-model");
        }

        @Override
        protected String getMiddleMessage()
        {
            return "The selected element is currently used by the following objects from the main model:";
        }

        @Override
        protected String getTopMessage()
        {
            return "Review and configure how the elements of the current controlled model are replaced by elements from the imported model:";
        }

        @Override
        protected String[] getColumnNames()
        {
            return new String[] {"Current (from controlled model)", "Replacement (from imported model)"};
        }

        @Override
        protected Set<FrontierElement> getFrontierElements()
        {
            return getImportConfiguration().getOutboundFrontierElements();
        }
    }
    
    private class InboundReferencesConfigurationPage extends ReferencesConfigurationPage
    {
        public InboundReferencesConfigurationPage()
        {
            super("inboundReferences", modeler.getAdapterFactory());
            setTitle("Configure inbound references");
            setDescription("Configure how to update the references from the new sub-model to the main model");
        }

        @Override
        protected String getMiddleMessage()
        {
            return "The selected element is currently used by the following objects from the new sub-model:";
        }

        @Override
        protected String getTopMessage()
        {
            return "Review and configure how the elements of the external cache are replaced by elements from the main model:";
        }

        @Override
        protected String[] getColumnNames()
        {
            return new String[] {"Current (from external cache)", "Replacement (from main model)"};
        }

        @Override
        protected Set<FrontierElement> getFrontierElements()
        {
            return getImportConfiguration().getInboundFrontierElements();
        }
    }
}
