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

import static org.topcased.modeler.internal.collaboration.ModelUtil.getXmiId;
import static org.topcased.modeler.internal.collaboration.ModelUtil.updateProperReferences;
import static org.topcased.modeler.internal.collaboration.ModelUtil.updateReferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.commands.CommandStack;
import org.topcased.modeler.SemanticDependenciesDetector;
import org.topcased.modeler.SemanticDependenciesHandler;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;

/**
 * This class encapsulate the code which actually performs the import, once all the parameters have been determined and
 * accepted by the user. Despite its name, this is not a real {@link Command} (yet?).
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class ImportSubmodelCommand
{
    /**
     * The modeler which invoked the import command.
     */
    private final Modeler modeler;

    /**
     * The configuration data for the import process.
     */
    private final ImportConfiguration importConfiguration;

    /**
     * The resource containing the controlled sub-model to be replaced by the imported version.
     */
    private final Resource controlledModelResource;

    /**
     * The resource containing the controlled diagrams to be replaced by the imported version.
     */
    private final Resource controlledDiagramsResource;

    public ImportSubmodelCommand(Modeler modeler, ImportConfiguration importConfig)
    {
        this.modeler = modeler;
        this.controlledModelResource = importConfig.getControlledModelResource();
        this.controlledDiagramsResource = importConfig.getControlledDiagramsResource();
        this.importConfiguration = importConfig;
    }

    public void execute()
    {
        applyPreProcessing();
        Map<String, Diagrams> controlledDiagramIdToParent = getControlledDiagramsParents(controlledDiagramsResource);

        // Update the exported objects to point back to the originals instead of the cache.
        updateReferences(importConfiguration.getExportedResources(), FrontierElement.getReplacementMapping(importConfiguration.getInboundFrontierElements()));

        // Update references which point to the controlled resource to point to the elements being imported.
        updateProperReferences(importConfiguration.getMainModelResources(), FrontierElement.getReplacementMapping(importConfiguration.getOutboundFrontierElements()));

        // Replace the controlled resources contents with the imported elements.
        replaceContents(controlledModelResource, importConfiguration.getExportedModelResource());
        replaceContents(controlledDiagramsResource, importConfiguration.getExportedDiagramsResource());

        // Reconnect the newly imported diagrams to their parents
        connectImportedDiagrams(controlledDiagramsResource, controlledDiagramIdToParent);

        applyPostProcessing();
        
        // This removes the imported resources from the modeler's resource-set. This makes sure the changes we made to
        // these resources are not saved back on disk (so the import does not modify the ".part" and ".cache"
        // resources).
        importConfiguration.dispose();

        updateResourcesStatus();
    }

    private void applyPreProcessing()
    {
        for (SemanticDependenciesHandler handler : getApplyingHandlers())
        {
            handler.beforeImport(controlledModelResource, importConfiguration.getExportedModelResource());
        }
    }
    
    private void applyPostProcessing()
    {
        for (SemanticDependenciesHandler handler : getApplyingHandlers())
        {
            handler.afterImport(controlledModelResource);
        }
    }
    
    private List<SemanticDependenciesHandler> getApplyingHandlers()
    {
        List<SemanticDependenciesHandler> result = new ArrayList<SemanticDependenciesHandler>();
        Set<String> metamodelIds = new HashSet<String>();
        for (EObject root : controlledModelResource.getContents())
        {
            metamodelIds.add(root.eClass().getEPackage().getNsURI());
        }
        for (EObject root : importConfiguration.getExportedModelResource().getContents())
        {
            metamodelIds.add(root.eClass().getEPackage().getNsURI());
        }
        SemanticDependenciesManager dependenciesManager = SemanticDependenciesManager.getInstance();
        for (String id : metamodelIds)
        {
            SemanticDependenciesDetector detector = dependenciesManager.getDetectorFor(id);
            if (detector instanceof SemanticDependenciesHandler)
            {
                result.add((SemanticDependenciesHandler) detector);
            }
        }
        return result;
    }

    /**
     * Update the status of the controlled resources after a successful import. They are put back in read-write mode and
     * the "status" file is removed.
     */
    private void updateResourcesStatus()
    {
        AdapterFactoryEditingDomain domain = (AdapterFactoryEditingDomain) modeler.getEditingDomain();
        domain.getResourceToReadOnlyMap().remove(controlledModelResource);
        domain.getResourceToReadOnlyMap().remove(controlledDiagramsResource);
        ExportUtil.removeExportedDate(controlledModelResource);
    }

    private void replaceContents(Resource dest, Resource src)
    {
        for (EObject root : new ArrayList<EObject>(dest.getContents()))
        {
            execute(new RemoveCommand(modeler.getEditingDomain(), dest.getContents(), root));
        }
        execute(new AddCommand(modeler.getEditingDomain(), dest.getContents(), src.getContents()));
    }

    private Map<String, Diagrams> getControlledDiagramsParents(Resource diagramsRes)
    {
        Map<String, Diagrams> diagramsToParent = new HashMap<String, Diagrams>();
        for (EObject obj : diagramsRes.getContents())
        {
            if (obj instanceof Diagrams)
            {
                Diagrams diagrams = (Diagrams) obj;
                String id = getXmiId(diagrams);
                if (id != null)
                {
                    diagramsToParent.put(id, diagrams.getParent());
                }
            }
        }
        return diagramsToParent;
    }

    private void connectImportedDiagrams(Resource diagramsRes, Map<String, Diagrams> diagramsToParent)
    {
        for (EObject obj : diagramsRes.getContents())
        {
            if (obj instanceof Diagrams)
            {
                Diagrams diagrams = (Diagrams) obj;
                String id = getXmiId(diagrams);
                if (id != null && diagramsToParent.containsKey(id))
                {
                    diagrams.setParent(diagramsToParent.get(id));
                }
                else
                {
                    // TODO Find a "default" parent and put it there
                }
            }
        }
    }

    private void execute(Command cmd)
    {
        CommandStack stack = ((IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class)).getGEFCommandStack();
        stack.execute(new EMFtoGEFCommandWrapper(cmd));
    }
}
