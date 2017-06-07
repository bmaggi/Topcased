/*******************************************************************************
 * Copyright (c) 2011 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tristan FAURE - tristan.faure@atosorigin.com (Atos Origin Integration)
 *******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.topcased.modeler.dialogs.InformationDialog;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.utils.CommandAdapter;

/**
 * Update a cache reexported
 * 
 * @author tfaure
 * 
 */
public class UpdateCacheAction extends CommandActionHandler
{

    private final Modeler modeler;

    public UpdateCacheAction(Modeler modeler)
    {
        super(modeler.getEditingDomain(), "Update Cache");
        this.modeler = modeler;
    }

    @Override
    public boolean isEnabled()
    {
        return getCaches() != null && getCaches().size() > 0;
    }

    /**
     * get all the resources with uri containing cache
     * 
     * @return a list of cache
     */
    public List<Resource> getCaches()
    {
        List<Resource> resources = new LinkedList<Resource>();
        for (int i = 0; i < modeler.getResourceSet().getResources().size(); i++)
        {
            Resource resource = modeler.getResourceSet().getResources().get(i);
            String lastSegment = resource.getURI().lastSegment();
            if (lastSegment != null && lastSegment.contains(".cache."))
            {
                resources.add(resource);
            }
        }
        return resources;
    }

    @Override
    public Command createCommand(Collection< ? > selection)
    {
        return super.createCommand(selection);
    }

    @Override
    public void run()
    {
        Resource cache = null;
        List<Resource> caches = getCaches();
        if (caches != null && caches.size() == 1)
        {
            cache = caches.get(0);
        }
        if (cache == null)
        {
            ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
            adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
            ElementTreeSelectionDialog dialogTree = new ElementTreeSelectionDialog(modeler.getEditorSite().getShell(), new AdapterFactoryLabelProvider(adapterFactory),
                    new AdapterFactoryContentProvider(adapterFactory)
                    {
                        @Override
                        public boolean hasChildren(Object object)
                        {
                            return false;
                        }
                    });
            dialogTree.setInput(modeler.getResourceSet());
            dialogTree.setTitle("Choose the cache you want to update");
            dialogTree.setAllowMultiple(false);
            if (dialogTree.open() == ElementTreeSelectionDialog.OK)
            {
                Object[] result = dialogTree.getResult();
                if (result != null && result.length > 0)
                {
                    cache = (Resource) result[0];
                }
            }
        }
        if (cache != null)
        {
            ResourceDialog dialog = new ResourceDialog(modeler.getEditorSite().getShell(), "Select new Cache", SWT.OPEN);
            if (dialog.open() == ResourceDialog.OK)
            {
                URI uri = URI.createURI(dialog.getURIText());
                String oldURI = cache.getURI().toString();
                ResourceSet resourceSet = cache.getResourceSet();
                final ResourceSet newResSet = new ResourceSetImpl();
                Resource newCache = newResSet.getResource(uri, true);
                command = new CompoundCommand();
                updateCache(cache, newCache);

                // DIs
                Resource cacheDi = resourceSet.getResource(URI.createURI(oldURI + "di"), true);
                Resource newCacheDi = newResSet.getResource(URI.createURI(uri.toString() + "di"), true);
                if (cacheDi != null && newCacheDi != null)
                {
                    updateCache(cacheDi, newCacheDi);
                }

                // unload
                ((CompoundCommand) command).append(new CommandAdapter()
                {

                    @Override
                    public void execute()
                    {
                        for (Resource r : newResSet.getResources())
                        {
                            r.unload();
                        }
                        newResSet.getResources().clear();
                    }
                });

            }
        }
        super.run();
    }

    /**
     * Update the cache from newCache to cache
     * 
     * @param cache
     * @param newCache
     */
    private void updateCache(final Resource cache, final Resource newCache)
    {
        if (!checkConflicts(cache, newCache))
        {
            ((CompoundCommand) command).append(new CommandAdapter()
            {
                URI newCacheUri = null;

                @Override
                public void execute()
                {
                    super.execute();
                    newCacheUri = newCache.getURI();
                    ResourceSet set = modeler.getResourceSet();
                    set.getResources().remove(cache);
                    URI uri = cache.getURI();
                    cache.setURI(URI.createURI(uri.toString() + (".bak")));
                    try
                    {
                        cache.save(Collections.EMPTY_MAP);
                        newCache.setURI(uri);
                        newCache.save(Collections.EMPTY_MAP);
                        newCache.unload();
                        Resource newCacheInNewRS = set.getResource(newCache.getURI(), true);
                        reload(set);
                        // cache.delete(Collections.EMPTY_MAP);
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                private void reload(ResourceSet set)
                {
                    try
                    {
                        set.eSetDeliver(false);
                        for (Resource r : set.getResources())
                        {
                            r.eSetDeliver(false);
                            r.unload();
                            r.eSetDeliver(true);
                        }
                        for (Resource r : set.getResources())
                        {
                            r.load(Collections.EMPTY_MAP);
                        }
                        set.eSetDeliver(true);
                    }
                    catch (IOException e)
                    {
                    }
                }

                @Override
                public void undo()
                {
                    super.undo();
                    ResourceSet set = modeler.getResourceSet();
                    Resource newCacheInNewRS = set.getResource(newCache.getURI(), false);
                    set.getResources().remove(newCacheInNewRS);
                    URI uri = cache.getURI();
                    Resource bak = set.getResource(URI.createURI(uri.toString()), true);
                    bak.setURI(URI.createURI(uri.toString().substring(0, uri.toString().lastIndexOf(".bak"))));
                    try
                    {
                        bak.save(Collections.EMPTY_MAP);
                        reload(set);
                        // cache.delete(Collections.EMPTY_MAP);
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                @Override
                public void redo()
                {
                    super.redo();
                    ResourceSet set = modeler.getResourceSet();
                    for (Iterator<Resource> i = set.getResources().iterator(); i.hasNext();)
                    {
                        Resource r = i.next();
                        if (r != null && r.getURI() != null && r.getURI().equals(newCache.getURI()))
                        {
                            i.remove();
                        }
                    }
                    URI uri = newCache.getURI();
                    try
                    {
                        Resource newCacheInNewRS = set.getResource(newCacheUri, true);
                        if (newCacheInNewRS != null)
                        {
                            newCacheInNewRS.setURI(uri);
                            newCacheInNewRS.save(Collections.EMPTY_MAP);
                            reload(set);
                        }
                        // cache.delete(Collections.EMPTY_MAP);
                    }
                    catch (IOException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            });

            // for (EObject eobject : cache.getContents())
            // {
            // String id = eobject.eResource().getURIFragment(eobject);
            // if (newCache.getEObject(id) == null)
            // {
            // ((CompoundCommand)command).append(new RemoveCommand(domain, cache.getContents(), cache.getEObject(id)));
            // }
            // }
            // for (final EObject eobject : newCache.getContents())
            // {
            // final String id = eobject.eResource().getURIFragment(eobject);
            // if (cache.getEObject(id) != null)
            // {
            // ((CompoundCommand)command).append(new RemoveCommand(domain, cache.getContents(), cache.getEObject(id)));
            // }
            // ((CompoundCommand)command).append(new AddCommand(domain, cache.getContents(), eobject));
            // ((CompoundCommand)command).append(new CommandAdapter()
            // {
            // @Override
            // public void execute()
            // {
            // super.execute();
            // if (cache instanceof XMLResource)
            // {
            // XMLResource xml = (XMLResource) cache;
            // xml.setID(eobject, id);
            // }
            // }
            // });
            // }
            // if (((CompoundCommand)command).getCommandList().size() > 0)
            // {
            // ((CompoundCommand)command).append(new CommandAdapter(){
            //
            // @Override
            // public void execute()
            // {
            // super.execute();
            // ((TopcasedAdapterFactoryEditingDomain)domain).getResourceToReadOnlyMap().put(cache, false);
            // }
            //
            // @Override
            // public void undo()
            // {
            // super.undo();
            // ((TopcasedAdapterFactoryEditingDomain)domain).getResourceToReadOnlyMap().put(cache, true);
            // }
            //
            // @Override
            // public void redo()
            // {
            // execute();
            // }
            // });
            // }
        }

    }

    /**
     * Check if a conflict exist the old cache and the new one
     * 
     * @param cache
     * @param newCache
     * @return
     */
    private boolean checkConflicts(Resource cache, Resource newCache)
    {
        List<EObject> conflictObjects = new LinkedList<EObject>();
        List<EObject> deletedObjects = new LinkedList<EObject>();
        for (Iterator<EObject> i = cache.getAllContents(); i.hasNext();)
        {
            EObject eobject = i.next();
            if (newCache.getEObject(eobject.eResource().getURIFragment(eobject)) == null)
            {
                deletedObjects.add(eobject);
            }
        }
        if (deletedObjects.size() > 0)
        {
            for (EObject e : deletedObjects)
            {
                Collection<Setting> references = getInverses(e);
                if (references != null && references.size() > 0)
                {
                    for (Setting s : references)
                    {
                        conflictObjects.add(s.getEObject());
                    }
                }
            }
            if (conflictObjects.size() > 0)
            {
                String string = "Some objects in the cache have been deleted.\nPlease take in account these modifications before updating the cache:\n";
                AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(modeler.getAdapterFactory());
                for (EObject e : conflictObjects)
                {
                    string += adapterFactoryLabelProvider.getText(e) + "\n";
                }
                InformationDialog.openWarning(Display.getDefault().getActiveShell(), "Warning", string);
                return true;
            }
        }
        return false;
    }

    /**
     * Get inverse references from an eobject
     * 
     * @param e
     * @return
     */
    public Collection<Setting> getInverses(EObject e)
    {
        ECrossReferenceAdapter referencer = ECrossReferenceAdapter.getCrossReferenceAdapter(e);
        Collection<Setting> references = null;
        if (referencer != null)
        {
            references = referencer.getInverseReferences(e);
        }
        else
        {
            references = EcoreUtil.UsageCrossReferencer.find(e, e.eResource().getResourceSet());
        }
        return references;
    }

}
