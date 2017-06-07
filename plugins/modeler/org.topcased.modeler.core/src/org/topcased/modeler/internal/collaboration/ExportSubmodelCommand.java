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

import static org.topcased.modeler.internal.collaboration.ExportUtil.setExportedDate;
import static org.topcased.modeler.internal.collaboration.ModelUtil.updateProperReferences;
import static org.topcased.modeler.internal.collaboration.ModelUtil.updateReferences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.CommandStack;
import org.topcased.modeler.SemanticDependenciesDetector;
import org.topcased.modeler.SemanticDependenciesHandler;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This class encapsulate the code which actually performs the export, once all the parameters have been determined and
 * accepted by the user. Despite its name, this is not a real {@link Command} (yet?).
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class ExportSubmodelCommand
{
    /**
     * A specialized copier which changes the meta-model of of the copied element to be a (supplied) copy of the
     * original's meta-model.
     */
    @SuppressWarnings("serial")
    private final class MetamodelMappingCopier extends Copier
    {
        /**
         * A map from original objects to their copies, which should include the EClasses to consider for the meta-model
         * mapping during the copy.
         */
        private final Map<EObject, EObject> originalToCopy;

        private MetamodelMappingCopier(Map<EObject, EObject> originalToCopy)
        {
            this.originalToCopy = originalToCopy;
        }

        @Override
        protected EClass getTarget(EClass klass)
        {

            if (originalToCopy.containsKey(klass))
            {
                // If the meta-class of the object being copied has itself been copied, the object's copy should be
                // considered an instance of the meta-class's copy.
                return (EClass) originalToCopy.get(klass);
            }
            else
            {
                return super.getTarget(klass);
            }
        }

        @Override
        protected EStructuralFeature getTarget(EStructuralFeature structuralFeature)
        {
            EClass eclass = structuralFeature.getEContainingClass();
            if (originalToCopy.containsKey(eclass))
            {
                // If the copied object has been made an instance of the meta-model's copy, use the appropriate features
                // from that meta-model instead of the originals.
                int id = structuralFeature.getFeatureID();
                EClass copyEClass = (EClass) originalToCopy.get(eclass);
                return copyEClass.getEStructuralFeature(id);
            }
            else
            {
                return super.getTarget(structuralFeature);
            }
        }
    }

    /**
     * The modeler which invoked the export action.
     */
    private final Modeler modeler;

    /**
     * The root element of the sub-model to export.
     */
    private final EObject exportedModelRoot;

    /**
     * The diagrams corresponding to the sub-model root, which is also exported.
     */
    private final Diagrams diagramsRoot;

    /**
     * The resource containing the controlled sub-model to export.
     */
    private final Resource controlledModelResource;

    /**
     * The specification of what to put in the cache.
     */
    private final CacheContentsSpecification cacheSpec;

    /**
     * The URI chosen by the user for the main exported resource.
     */
    private final URI exportedModelUri;

    /**
     * The resource which will contain a copy of the sub-model.
     */
    private Resource exportedModelResource;

    /**
     * The resource which will contain a copy of the sub-model's diagrams.
     */
    private Resource exportedDiagramsResource;

    /**
     * The main cache resource, which will contain copies of all the dependencies of the sub-model and its diagrams.
     */
    private Resource cachedModelResource;

    /**
     * The cache resource for diagram elements with copies of the sub-diagrams from models which were controlled
     * sub-models of the original model.
     */
    private Resource cachedDiagramsResource;

    /**
     * A mapping from original elements of the sub-model to their copies in <code>partRes</code>.
     */
    private Map<EObject, EObject> exportedModelCopies;

    /**
     * A mapping from original elements of the sub-model's diagrams to their copies in <code>dipartRes</code>.
     */
    private Map<EObject, EObject> exportedDiagramsCopies;

    /**
     * A map from a Diagrams instance to its parent. This is filled before the export and used to restore the original
     * relationships afterwards, as in some circumstances (e.g. multiple levels of controls) the export process changes
     * these relations as an unwanted side-effect.
     */
    private Map<Diagrams, Diagrams> diagramsParents;

    private Collection<Resource> originalResources;

    public ExportSubmodelCommand(EObject submodelRoot, URI partUri, CacheContentsSpecification cacheSpec, Modeler modeler)
    {
        this.exportedModelRoot = submodelRoot;
        this.exportedModelUri = partUri;
        this.cacheSpec = cacheSpec;
        this.controlledModelResource = submodelRoot.eResource();
        this.modeler = modeler;
        this.diagramsRoot = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), submodelRoot);
        this.originalResources = new ArrayList<Resource>(modeler.getResourceSet().getResources());
    }

    /**
     * Performs the export.
     */
    public boolean execute()
    {
        storeDiagramsParents();
        createTargetResources();
        populateParts();
        populateCache();
        applyPostProcessing();
        try
        {
            // First we make sure the newly created resources containing the exported model are stored on disk.
            saveExportedResources();
            // Fix unwanted side-effects on the original models and diagrams.
            fixSubmodelReferences();
            fixDiagramsParents();
            // We can now remove the exported resources from the resource set. This has two effects: (1) the new
            // resources do not appear in the outline in "Additional resources" and (2) the potential side-effects of
            // the fixes above on the exported models are not saved.
            forgetExportedResources();
            setExportedDate(controlledModelResource, new Date());
            setControlledResourcesReadOnly();
            return true;
        }
        catch (IOException e)
        {
            ModelerPlugin.log(e);
            return false;
        }
    }

    /**
     * Remember the original relationships between diagrams so we can restore them afterwards.
     */
    private void storeDiagramsParents()
    {
        this.diagramsParents = new HashMap<Diagrams, Diagrams>();
        storeDiagramsParents(diagramsRoot);
    }

    private void storeDiagramsParents(Diagrams diagrams)
    {
        diagramsParents.put(diagrams, diagrams.getParent());
        for (Diagrams subdiagrams : diagrams.getSubdiagrams())
        {
            storeDiagramsParents(subdiagrams);
        }
    }

    /**
     * Make sure the original resources do not reference the exported models. This can happen when we populate the
     * exported models with copies of the originals, through automatic updating of reverse references. In particular,
     * without this phase the diagrams of controlled models below the exported ones point to the exported version of
     * their parent.
     */
    private void fixSubmodelReferences()
    {
        Map<EObject, EObject> restoreMap = reverse(exportedModelCopies);
        restoreMap.putAll(reverse(exportedDiagramsCopies));
        Collection<Resource> exportedResources = Arrays.asList(exportedModelResource, exportedDiagramsResource, cachedModelResource, cachedDiagramsResource);
        for (Resource res : modeler.getResourceSet().getResources())
        {
            if (!exportedResources.contains(res))
            {
                updateProperReferences(res, restoreMap);
            }
        }
    }

    /**
     * Restore the relationships between diagrams which may have been modified as an unwanted side-effect of the export
     * process.
     */
    private void fixDiagramsParents()
    {
        for (Map.Entry<Diagrams, Diagrams> entry : diagramsParents.entrySet())
        {
            Diagrams diagrams = entry.getKey();
            Diagrams parent = entry.getValue();
            if (diagrams.getParent() != parent)
            {
                diagrams.setParent(parent);
            }
        }
    }

    private <K, V> Map<V, K> reverse(Map<K, V> map)
    {
        Map<V, K> result = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet())
        {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
    
    private void applyPostProcessing()
    {
        Set<String> metamodelIds = new HashSet<String>();
        for (EObject root : exportedModelResource.getContents())
        {
            metamodelIds.add(root.eClass().getEPackage().getNsURI());
        }
        for (EObject root : cachedModelResource.getContents())
        {
            metamodelIds.add(root.eClass().getEPackage().getNsURI());
        }
        SemanticDependenciesManager dependenciesManager = SemanticDependenciesManager.getInstance();
        for (String id : metamodelIds)
        {
            SemanticDependenciesDetector detector = dependenciesManager.getDetectorFor(id);
            if (detector instanceof SemanticDependenciesHandler)
            {
                ((SemanticDependenciesHandler) detector).afterExport(exportedModelResource, cachedModelResource);
            }
        }
    }

    /**
     * Saves the newly created resources containing the exported model and cache.
     */
    private void saveExportedResources() throws IOException
    {
        modeler.saveResource(exportedModelResource);
        modeler.saveResource(exportedDiagramsResource);
        modeler.saveResource(cachedModelResource);
        modeler.saveResource(cachedDiagramsResource);
    }

    /**
     * Removes the resources created during the export from the modeler's resource-set so that they do not appear in the
     * outline's "Additional resources" category.
     */
    private void forgetExportedResources()
    {
        for (Iterator<Resource> iter = modeler.getResourceSet().getResources().iterator(); iter.hasNext();)
        {
            Resource res = iter.next();
            if (!originalResources.contains(res))
            {
                iter.remove();
            }
        }
    }

    /**
     * Create the three resources which will contain the exported sub-model, its diagrams and their dependencies. The
     * resources are created in the editing domain's resource set, but the corresponding files will not be created until
     * the user explicitly saves the model (after the export).
     */
    private void createTargetResources()
    {
        EditingDomain domain = modeler.getEditingDomain();
        exportedModelResource = domain.createResource(exportedModelUri.toString());
        exportedDiagramsResource = domain.createResource(ExportUtil.getExportedDiagramsURI(exportedModelUri).toString());
        cachedModelResource = domain.createResource(ExportUtil.getCacheURI(exportedModelUri).toString());
        cachedDiagramsResource = domain.createResource(ExportUtil.getCacheURI(exportedDiagramsResource.getURI()).toString());
    }

    /**
     * Populate the "part" resources (model & diagram) with copies of the controlled elements. If the controlled
     * resource being exported itself contains other controlled sub-models, those are not copied. The copied diagrams
     * are updated to reference the copied elements, not the originals.
     */
    private void populateParts()
    {
        exportedModelCopies = copyProperSubModel(exportedModelRoot, exportedModelResource);
        exportedDiagramsCopies = copyProperSubModel(diagramsRoot, exportedDiagramsResource);
    }

    private boolean isDiagramElement(EObject obj)
    {
        if (obj.eClass().getEPackage().equals(DiagramInterchangePackage.eINSTANCE))
        {
            return true;
        }
        else if (obj.eClass().getEPackage().equals(DiagramsPackage.eINSTANCE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Populate the cache resource with copies of the parts' dependencies and make the parts point to the cached copies.
     */
    private void populateCache()
    {
        // Copy all the dependencies into the cache and remember to copy mapping
        Map<EObject, EObject> originalToCachedCopy = new HashMap<EObject, EObject>();

        // Phase 1: copy all elements except those whose meta-model is itself planned for copying (those are put in
        // skipped). We need to have all the meta-models themselves copied first to properly handle these elements,
        // which is done in the second phase below.
        Set<EObject> skipped = new HashSet<EObject>();
        for (EObject root : cacheSpec.getAllDependencyRoots())
        {
            Resource target = isDiagramElement(root) ? cachedDiagramsResource : cachedModelResource;
            if (target == cachedModelResource)
            {
                EPackage metaModel = root.eClass().getEPackage();
                if (EcoreUtil.isAncestor(cacheSpec.getAllDependencyRoots(), metaModel))
                {
                    // Skip objects whose meta-model has been marked to be copied into the cache.
                    skipped.add(root);
                    continue;
                }
            }
            Copier copier = new Copier();
            EObject copy = copier.copy(root);
            copier.copyReferences();
            target.getContents().add(copy);
            markCopies(copier);
            Map<EObject, EObject> copies = copier;
            originalToCachedCopy.putAll(copies);
        }

        // Phase 2: copy the elements skipped in the first phase, but make sure the copy's meta-model is the
        // meta-model's copy, using a MetamodelMappingCopier.
//        Map<URI, URI> uriMap = new HashMap<URI, URI>();
        for (EObject root : skipped)
        {
            Resource target = cachedModelResource;

//            EClass originalEClass = root.eClass();
//            EPackage metaModel = originalEClass.getEPackage();
//            String originalURI = metaModel.eResource().getURI() + "#" + metaModel.eResource().getURIFragment(metaModel);
//            String cachedVersionURI = cachedModelResource.getURI() + "#" + metaModel.eResource().getURIFragment(metaModel);
//            uriMap.put(URI.createURI(originalURI), URI.createURI(cachedVersionURI));

            Copier copier = new MetamodelMappingCopier(originalToCachedCopy);
            EObject copy = copier.copy(root);
            copier.copyReferences();
            target.getContents().add(copy);
            markCopies(copier);
            Map<EObject, EObject> copies = copier; // copySubModel(root, target);
            originalToCachedCopy.putAll(copies);
        }

        // These copies may have (indirectly) included elements from the original controlled resources.
        // Fix references to those to point to the versions in the exported resources.
        Map<EObject, EObject> fixupMapping = createFixupMapping(originalToCachedCopy);
        updateProperReferences(exportedModelResource, fixupMapping);
        updateProperReferences(exportedDiagramsResource, fixupMapping);
        updateReferences(cachedModelResource, fixupMapping);
        updateReferences(cachedDiagramsResource, fixupMapping);

        // Make sure everything in the exported resources points to the cached/exported copies.
        Map<EObject, EObject> allExportedCopies = new HashMap<EObject, EObject>();
        allExportedCopies.putAll(exportedModelCopies);
        allExportedCopies.putAll(exportedDiagramsCopies);
        allExportedCopies.putAll(originalToCachedCopy);
        updateProperReferences(exportedModelResource, allExportedCopies);
        updateProperReferences(exportedDiagramsResource, allExportedCopies);
        updateReferences(cachedModelResource, allExportedCopies);
        updateReferences(cachedDiagramsResource, allExportedCopies);

//        ModelProperties mp = new ModelProperties(controlledModelResource);
//        mp.setProperty("export.uriMap", uriMap.toString());
    }

    private Map<EObject, EObject> createFixupMapping(Map<EObject, EObject> originalToCachedCopy)
    {
        Map<EObject, EObject> fixMapping = new HashMap<EObject, EObject>();
        Map<EObject, EObject> exportedCopies = new HashMap<EObject, EObject>();
        exportedCopies.putAll(exportedModelCopies);
        exportedCopies.putAll(exportedDiagramsCopies);
        for (EObject original : originalToCachedCopy.keySet())
        {
            Resource originalRes = original.eResource();
            if (originalRes != null && (originalRes.equals(controlledModelResource) || originalRes.equals(diagramsRoot.eResource())))
            {
                EObject spuriousCopy = originalToCachedCopy.get(original);
                EObject exportedCopy = exportedCopies.get(originalRes);
                fixMapping.put(spuriousCopy, exportedCopy);
            }
        }
        return fixMapping;
    }

    private void setControlledResourcesReadOnly()
    {
        EditingDomain domain = modeler.getEditingDomain();
        if (domain instanceof AdapterFactoryEditingDomain)
        {
            AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) domain;
            afed.getResourceToReadOnlyMap().put(controlledModelResource, Boolean.TRUE);
            afed.getResourceToReadOnlyMap().put(diagramsRoot.eResource(), Boolean.TRUE);
        }
    }

    /**
     * Copy the complete sub-model rooted at the given <code>EObject</code> into the specified target resource.
     * 
     * @param obj the root of the sub-model to copy.
     * @param targetRes the resource to put the copy into (as a top-level element).
     * @return a mapping from the original objects in the source sub-model to their copies in the target resource.
     */
    private Map<EObject, EObject> copySubModel(EObject obj, Resource targetRes)
    {
        CopyCommand.Helper helper = new CopyCommand.Helper();
        CopyCommand cmd = new CopyCommand(modeler.getEditingDomain(), obj, helper);
        execute(cmd);
        execute(new AddCommand(modeler.getEditingDomain(), targetRes.getContents(), cmd.getResult()));
        markCopies(helper);
        return helper;
    }

    /**
     * Mark all the copied objects in the map so that their original can be retrieved later.
     */
    private void markCopies(Map<EObject, EObject> originalToCopy)
    {
        for (Map.Entry<EObject, EObject> entry : originalToCopy.entrySet())
        {
            EObject original = entry.getKey();
            EObject copy = entry.getValue();
            markCopy(copy, original);
        }
    }

    /**
     * Mark a copied object so that it can be retrieved later.
     */
    private void markCopy(EObject copy, EObject original)
    {
        XMLResource originalResource = (XMLResource) original.eResource();
        XMLResource copyResource = (XMLResource) copy.eResource();
        if (originalResource != null && copyResource != null)
        {
            String id = originalResource.getID(original);
            copyResource.setID(copy, id);
        }
    }

    /**
     * Copy the <em>proper</em> sub-model rooted at the given <code>EObject</code> into the specified target resource.
     * this method differs from {@link #copySubModel(EObject, Resource)} in that the copy will not include elements
     * which are not in the same resource as the root element (i.e. it will not cross resource boundaries, excluding
     * controlled sub-sub-models from the copy).
     * 
     * @param obj the root of the sub-model to copy.
     * @param targetRes the resource to put the copy into (as a top-level element).
     * @return a mapping from the original objects in the source sub-model to their copies in the target resource.
     */
    private Map<EObject, EObject> copyProperSubModel(EObject obj, Resource targetRes)
    {
        // FIXME This implementation is highly sub-optimal, but a bug in EMF makes it more difficult that it
        // should be to do it the "right" way (by customizing CopyCommand). This may be revised in the future.

        // 1. Do a full copy, including controlled sub-resources.
        Map<EObject, EObject> originaltToCopy = copySubModel(obj, targetRes);

        // 2. Fix the copy to point back to the original objects for objects in controlled sub-resources.
        Map<EObject, EObject> fixMapping = new HashMap<EObject, EObject>();
        for (EObject original : originaltToCopy.keySet())
        {
            if (!obj.eResource().equals(original.eResource()))
            {
                EObject copy = originaltToCopy.get(original);
                fixMapping.put(copy, original);
            }
        }
        updateProperReferences(targetRes, fixMapping);

        return originaltToCopy;
    }

    /**
     * Execute a command using the appropriate CommandStack.
     */
    private void execute(Command cmd)
    {
        CommandStack stack = ((MixedEditDomain) modeler.getAdapter(MixedEditDomain.class)).getCommandStack();
        stack.execute(new EMFtoGEFCommandWrapper(cmd));
    }
}
