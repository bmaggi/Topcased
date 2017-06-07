/***********************************************************************
 * Copyright (c) 2008 Obeo and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Laurent Redor (Obeo) - initial API and implementation
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    David Sciamma (Anyware Technologies) - Workaround for an EMF bug with EFS URI
 *    Gilles Cannenterre (Anyware Technologies) - provide a shared Clipboard
 **********************************************************************/
package org.topcased.modeler.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.commands.CreateGraphEdgeCommand;
import org.topcased.modeler.commands.CreateGraphNodeCommand;
import org.topcased.modeler.commands.GEFtoEMFCommandStackWrapper;
import org.topcased.modeler.commands.GEFtoEMFCommandWrapper;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.collaboration.ExportUtil;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * Extends the classic AdapterFactoryEditingDomain to define a shared clipboard and manage the problem of resource
 * modify in multiple editors - Bug #1405<br>
 * 
 * Creation : 19 juin 2008.
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class TopcasedAdapterFactoryEditingDomain extends AdapterFactoryEditingDomain
{

    /** This is the current clipboard. */
    protected static Collection<Object> staticClipboard;

    /**
     * List of the resources that are already opened in another editor (with the names of the other editors).
     */
    private final Map<Resource, List<String>> alreadyOpenedResources = new HashMap<Resource, List<String>>();

    /** The first resource which is loaded by this EditingDomain. */
    private URI initialResourceURI;

    /**
     * This attribute means the editing domain makes all the resources read only
     */
    private boolean totalReadOnly = false;

    private List<Runnable> refreshRunnables = new LinkedList<Runnable>();

    /**
     * The Constructor.
     * 
     * @param adapterFactory the adapter factory
     * @param commandStack the command stack
     * @param resourceToReadOnlyMap the resource to read only map
     */
    public TopcasedAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, Map<Resource, Boolean> resourceToReadOnlyMap)
    {
        super(adapterFactory, commandStack, resourceToReadOnlyMap);
        this.resourceSet = new TopcasedAdapterFactoryEditingDomainResourceSet();

        this.commandStack.addCommandStackListener(new CommandStackListener()
        {
            public void commandStackChanged(EventObject event)
            {
                CommandStack eventCommandStack = getCommandStack();
                AbstractCommand command = (AbstractCommand) eventCommandStack.getMostRecentCommand();
                EObject modelObject = getModelObjectFromAbstractCommand(command);
                if (modelObject != null)
                {
                    createAuthorEannotation(modelObject);
                }
                if (command instanceof CreateChildCommand && modelObject != null)
                {
                    EStructuralFeature nameFeature = TopcasedAdapterFactoryLabeler.getInstance().getLabelFeature(modelObject);
                    // we need a Topcased command stack to know the state, label
                    // creation only on execute not undo and redo
                    org.topcased.modeler.commands.CommandStack stack = null;
                    if (eventCommandStack instanceof GEFtoEMFCommandStackWrapper)
                    {
                        org.eclipse.gef.commands.CommandStack gefStack = ((GEFtoEMFCommandStackWrapper) eventCommandStack).getGEFCommandStack();
                        if (gefStack instanceof org.topcased.modeler.commands.CommandStack)
                        {
                            stack = (org.topcased.modeler.commands.CommandStack) gefStack;
                        }
                    }
                    if (eventCommandStack instanceof org.topcased.modeler.commands.CommandStack)
                    {
                        stack = (org.topcased.modeler.commands.CommandStack) eventCommandStack;
                    }
                    if (stack != null)
                    {
                        if (nameFeature != null)
                        {
                            switch (stack.getState())
                            {
                                case org.topcased.modeler.commands.CommandStack.PRE_EXECUTE:
                                    String defaultName = getDefaultName(modelObject);
                                    modelObject.eSet(nameFeature, defaultName);
                                    break;
                                default:
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * Gets the default name.
     * 
     * @param modelObject the model object
     * 
     * @return the default name
     */
    public static String getDefaultName(EObject modelObject)
    {
        String className = modelObject.eClass().getName();
        String defaultName = className + "1";
        // do the algorithm only if the container does not contain only
        // modelObject
        if (modelObject.eContainer() != null && modelObject.eContainer().eContents().size() > 1)
        {
            boolean nameAlreadyUsed = false;
            for (EObject object : modelObject.eContainer().eContents())
            {
                EStructuralFeature labelFeature = TopcasedAdapterFactoryLabeler.getInstance().getLabelFeature(object);
                if (labelFeature != null && String.class.equals(labelFeature.getEType().getInstanceClass()))
                {
                    String label = (String) object.eGet(labelFeature);
                    if (defaultName.equals(label))
                    {
                        nameAlreadyUsed = true;
                        break;
                    }
                }
            }
            if (nameAlreadyUsed)
            {
                Pattern pattern = Pattern.compile(className + "((\\d)*)");
                SortedSet<String> matchingNames = new TreeSet<String>(new EObjectNameComparator(pattern));
                for (EObject object : modelObject.eContainer().eContents())
                {
                    EStructuralFeature labelFeature = TopcasedAdapterFactoryLabeler.getInstance().getLabelFeature(object);
                    if (labelFeature != null && String.class.equals(labelFeature.getEType().getInstanceClass()))
                    {
                        String label = (String) object.eGet(labelFeature);
                        if (label != null && pattern.matcher(label).matches())
                        {
                            matchingNames.add(label);
                        }
                    }
                }
                if (!matchingNames.isEmpty())
                {
                    String lastName = matchingNames.last();
                    Matcher matcher = pattern.matcher(lastName);
                    matcher.matches();
                    String suffix = "1";
                    if (matcher.groupCount() > 1)
                    {
                        try
                        {
                            suffix = String.valueOf(Integer.parseInt(matcher.group(1)) + 1);
                        }
                        catch (NumberFormatException e)
                        {
                            // do nothing
                        }
                    }
                    defaultName = className + suffix;
                }
            }
        }
        return defaultName;
    }

    /**
     * The Constructor.
     * 
     * @param adapterFactory the adapter factory
     * @param commandStack the command stack
     */
    public TopcasedAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack)
    {
        super(adapterFactory, commandStack);
        this.resourceSet = new AdapterFactoryEditingDomainResourceSet();
    }

    /**
     * The Constructor.
     * 
     * @param adapterFactory the adapter factory
     * @param commandStack the command stack
     * @param resourceSet the resource set
     */
    public TopcasedAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, ResourceSet resourceSet)
    {
        super(adapterFactory, commandStack, resourceSet);
    }

    /**
     * Gets the model object depending on the command.
     * 
     * @param command the specified abstract command
     * 
     * @return the model object from the command
     */
    private EObject getModelObjectFromAbstractCommand(AbstractCommand command)
    {
        EObject modelObject = null;

        // create object from the editor
        if (command instanceof GEFtoEMFCommandWrapper)
        {
            modelObject = getModelObjectFromCommand(((GEFtoEMFCommandWrapper) command).getGefCommand());
        }

        // create object from the outline
        else if (command instanceof CreateChildCommand)
        {
            modelObject = (EObject) ((List< ? >) command.getAffectedObjects()).get(0);
        }
        return modelObject;
    }

    /**
     * Gets the model object from command searching recursively.
     * 
     * @param command the specified command
     * 
     * @return the model object from command
     */
    private EObject getModelObjectFromCommand(Command command)
    {
        EObject modelObject = null;
        if (command instanceof CreateGraphNodeCommand)
        {
            modelObject = ((CreateGraphNodeCommand) command).getChildEObject();
        }
        else if (command instanceof CreateGraphEdgeCommand)
        {
            modelObject = Utils.getElement(((CreateGraphEdgeCommand) command).getEdge());
        }
        else if (command instanceof CompoundCommand)
        {
            for (Object c : ((CompoundCommand) command).getCommands())
            {
                if (c instanceof Command)
                {
                    EObject object = getModelObjectFromCommand((Command) c);
                    if (object != null)
                    {
                        return object;
                    }
                }
            }
        }
        return modelObject;
    }

    /**
     * Creates the author eannotation from preferences if needed.
     * 
     * @param object the object
     */
    private void createAuthorEannotation(EObject object)
    {
        boolean createAuthorAnnotation = ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_CREATE_AUTHOR_ANNOTATION);

        if (object instanceof EModelElement && createAuthorAnnotation)
        {
            EModelElement modelObject = (EModelElement) object;
            EAnnotation authorAnnotation = modelObject.getEAnnotation(IAnnotationConstants.AUTHOR_SOURCE);
            String author = ModelerPlugin.getDefault().getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_AUTHOR);

            // creates EAnnotation if needed
            if (authorAnnotation == null && !"".equals(author))
            {
                Utils.createAuthorEAnnotation(modelObject, author);
            }
        }
    }

    /**
     * The Class TopcasedAdapterFactoryLabeler. This class is set 'public' but should be accessed outside the
     * TopcasedAdapterFactoryEditingDomain.
     */
    public static class TopcasedAdapterFactoryLabeler
    {

        /** The uris map. */
        private final Map<String, String> urisMap = new HashMap<String, String>();

        /** The instance. */
        private static TopcasedAdapterFactoryLabeler instance;

        /**
         * Instantiates a new topcased adapter factory labeler.
         */
        private TopcasedAdapterFactoryLabeler()
        {
            readExtensionPoint();
        }

        /**
         * Gets the single instance of TopcasedAdapterFactoryLabeler.
         * 
         * @return single instance of TopcasedAdapterFactoryLabeler
         */
        public static TopcasedAdapterFactoryLabeler getInstance()
        {
            if (instance == null)
            {
                instance = new TopcasedAdapterFactoryLabeler();
            }
            return instance;
        }

        /**
         * Gets the label attribute.
         * 
         * @param uri the uri
         * 
         * @return the label attribute
         */
        public String getLabelAttribute(String uri)
        {
            return urisMap.containsKey(uri) ? urisMap.get(uri) : "";
        }

        /**
         * Gets the label feature.
         * 
         * @param object the object
         * 
         * @return the label feature
         */
        public EStructuralFeature getLabelFeature(EObject object)
        {
            String labelField = getLabelAttribute(object.eClass().getEPackage().getNsURI());
            for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures())
            {
                if (!feature.isMany() && feature.getEType().getInstanceClass().equals(String.class) && labelField.equals(feature.getName()))
                {
                    return feature;
                }
            }
            return null;
        }

        /**
         * Read the extension point 'defaultName'.
         */
        private void readExtensionPoint()
        {
            final String extPointName = "defaultName";
            final String uri = "URI";
            final String label = "label";
            IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ModelerPlugin.getId(), extPointName);
            for (IConfigurationElement element : elements)
            {
                String declaredUri = element.getAttribute(uri);
                String declaredLabel = element.getAttribute(label);
                if (!isStringEmpty(declaredUri) && !isStringEmpty(declaredLabel))
                {
                    urisMap.put(declaredUri, declaredLabel);
                }
            }
        }

        /**
         * Checks if is string empty.
         * 
         * @param theString the the string
         * 
         * @return true, if is string empty
         */
        private boolean isStringEmpty(String theString)
        {
            return theString == null || theString.length() == 0;
        }
    }

    /**
     * This is an implementation of a context that knows about this editing domain. It is used to help implement
     * {@link #getEditingDomainFor(java.lang.Object) getEditingDomainFor(Object)} and
     * {@link #getEditingDomainFor(org.eclipse.emf.ecore.EObject) getEditingDomainFor(EObject)} An instance of this is
     * created if needed in the constructor.
     */
    protected class TopcasedAdapterFactoryEditingDomainResourceSet extends ResourceSetImpl implements IEditingDomainProvider
    {

        /**
         * Constructor.
         */
        public TopcasedAdapterFactoryEditingDomainResourceSet()
        {
            super();
        }

        /**
         * Gets the editing domain.
         * 
         * @return the editing domain
         * 
         * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
         */
        public EditingDomain getEditingDomain()
        {
            return TopcasedAdapterFactoryEditingDomain.this;
        }

        /**
         * Gets the resource.
         * 
         * @param uri the uri
         * @param loadOnDemand the load on demand
         * 
         * @return the resource
         * 
         * @see org.eclipse.emf.ecore.resource.impl.ResourceSetImpl#getResource(org.eclipse.emf.common.util.URI,
         *      boolean) <br>
         *      We consider all the resources that is already loaded in write access mode in other editor like readonly
         */
        public Resource getResource(URI uri, boolean loadOnDemand)
        {
            if (initialResourceURI == null)
            {
                initialResourceURI = uri;
            }
            Resource resource = super.getResource(uri, loadOnDemand);
            if (resource != null)
            {
                checkResource(resource);
            }
            return resource;
        }

        /**
         * analyse and determines if the resource is already opened in write mode
         * 
         * @param resource
         */
        public void checkResource(Resource resource)
        {
            if (resource == null)
            {
                return;
            }
            URI uri = resource.getURI();
            if (getResources().size() > 1 || (!initialResourceURI.equals(resource.getURI())))
            {
                boolean enabled = !ModelerPlugin.getDefault().getStateLocation().append("allowConcurrentAcces").toFile().exists();
                if (enabled)
                {
                    String editorName = isToConsiderReadOnly(resource);
                    if (editorName != null)
                    {
                        List<String> editors = alreadyOpenedResources.get(resource);
                        if (editors == null)
                        {
                            editors = new ArrayList<String>();
                        }
                        if (!editors.contains(editorName))
                        {
                            editors.add(editorName);
                        }
                        alreadyOpenedResources.put(resource, editors);
                    }
                    else
                    {
                        if (alreadyOpenedResources.containsKey(resource))
                        {
                            alreadyOpenedResources.put(resource, null);
                        }
                    }
                }
            }
            boolean toCheck = Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY);
            if (ExportUtil.isExported(resource) || ExportUtil.isCacheUri(uri) || (isInOpenedResource(resource) && toCheck))
            {
                getResourceToReadOnlyMap().put(resource, Boolean.TRUE);
            }
        }

        /**
         * A resource is considered as readonly if it is already loaded in write access mode in other editor.
         * 
         * @param resource The resource to test
         * 
         * @return null if resource isn't already open, the name of the editor which has already loaded this resource in
         *         access mode otherwise
         */
        private String isToConsiderReadOnly(Resource resource)
        {
            if (resource != null && !resource.getURI().equals(initialResourceURI))
            {
                // Test if the resource is already loaded for write in other
                // editor (Topcased modeler editor or EMF
                // editor)
                IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
                for (IWorkbenchWindow workbenchWindow : workbenchWindows)
                {
                    IWorkbenchPage[] workbenchPages = workbenchWindow.getPages();
                    for (IWorkbenchPage workbenchPage : workbenchPages)
                    {
                        IEditorReference[] editorReferences = workbenchPage.getEditorReferences();
                        for (IEditorReference editorReference : editorReferences)
                        {
                            IEditorPart editorPart = editorReference.getEditor(false);
                            if (editorPart != null)
                            {
                                if (editorPart instanceof Modeler)
                                {
                                    // The editor is an topcased modeler editor
                                    Modeler modeler = (Modeler) editorPart;
                                    if (!modeler.getResourceSet().equals(TopcasedAdapterFactoryEditingDomainResourceSet.this))
                                    {
                                        // This modeler is not the current
                                        // modeler (the modeler of the initial
                                        // resource)
                                        Resource correspondingResourceInModeler = getCorrespondingResource(modeler.getEditingDomain().getResourceSet().getResources(), resource);
                                        if (correspondingResourceInModeler != null && !modeler.getEditingDomain().isReadOnly(correspondingResourceInModeler))
                                        {
                                            return modeler.getTitle();
                                        }
                                    }
                                }
                                else if (editorPart instanceof IEditingDomainProvider)
                                {
                                    IEditingDomainProvider editorEMF = (IEditingDomainProvider) editorPart;
                                    if (editorEMF.getEditingDomain() instanceof AdapterFactoryEditingDomain)
                                    {
                                        // The editor is an emf editor
                                        Resource correspondingResourceInEditorEMF = getCorrespondingResource(editorEMF.getEditingDomain().getResourceSet().getResources(), resource);
                                        if (correspondingResourceInEditorEMF != null && !editorEMF.getEditingDomain().isReadOnly(correspondingResourceInEditorEMF))
                                        {
                                            return editorPart.getTitle();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }

        /**
         * Search a resource in a resources list by the URI.
         * 
         * @param resourcesList A list of resources
         * @param resource The resource to search
         * 
         * @return the resource with the same URI of resource in the resources list, null otherwise
         */
        private Resource getCorrespondingResource(EList<Resource> resourcesList, Resource resource)
        {
            for (Resource resourceTemp : resourcesList)
            {
                if (resourceTemp.getURI().equals(resource.getURI()))
                {
                    return resourceTemp;
                }
            }
            return null;
        }
    }

    /**
     * Test if this resource is already opened in other editor.
     * 
     * @param resource he resource to test
     * 
     * @return true if it is already open, false otherwise
     */
    public boolean isAlreadyOpened(Resource resource)
    {
        return getAlreadyOpenedEditors(resource) != null;
    }

    /**
     * Gets the already opened editors.
     * 
     * @param resource The resource
     * 
     * @return The names of the editors in which this resource is already opened
     */
    public List<String> getAlreadyOpenedEditors(Resource resource)
    {
        return alreadyOpenedResources.get(resource);
    }

    /**
     * Check if the eObject is read only
     * 
     * @param eObject
     * @return true if is read only
     */
    public static boolean isEObjectReadOnly(EObject eObject)
    {
        boolean result = false;
        if (eObject != null && eObject.eResource() != null)
        {
            EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
            if (domain != null)
            {
                result = domain.isReadOnly(eObject.eResource());
            }
        }
        return result;
    }

    /**
     * This returns whether the resource is read only.
     * 
     * @param resource the resource
     * 
     * @return true, if checks if is read only
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#isReadOnly(org.eclipse.emf.ecore.resource.Resource)
     */
    public boolean isReadOnly(Resource resource)
    {
        if (totalReadOnly)
        {
            return true;
        }
        if (resource == null)
        {
            return false;
        }
        if (resourceToReadOnlyMap == null)
        {
            return false;
        }
        else
        {
            Boolean result = resourceToReadOnlyMap.get(resource);
            if (result == null && resource != null)
            {
                result = isReadOnlyAccordingToAttribute(resource);
                resourceToReadOnlyMap.put(resource, result);
            }
            return Boolean.TRUE.equals(result);
        }
    }

    /**
     * Checks the isRead Only attribute of the element
     * 
     * @param resource
     * @return
     */
    public Boolean isReadOnlyAccordingToAttribute(Resource resource)
    {
        Boolean result = false;
        URIConverter converter = (resource.getResourceSet() == null ? resourceSet : resource.getResourceSet()).getURIConverter();

        URI uri = converter.normalize(resource.getURI());
        Map<String, ? > attributes = converter.getAttributes(uri, null);

        result = (Boolean) attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);
        if (result == null)
        {
            result = false;
        }
        return result;
    }

    /**
     * Refresh the list of opened resources and their corresponding editor name
     * 
     * @param resolveAll true to refresh on all resources, even if never explored
     */
    public void refreshOpenedResources(boolean resolveAll)
    {
        Set<Resource> collection = new HashSet<Resource>(alreadyOpenedResources.keySet());
        if (resolveAll)
        {
            EList<Resource> resources = getResourceSet().getResources();
            collection.addAll(resources);
        }
        for (Resource r : collection)
        {
            ResourceSet aResourceSet = r.getResourceSet();
            if (aResourceSet instanceof TopcasedAdapterFactoryEditingDomainResourceSet)
            {
                ((TopcasedAdapterFactoryEditingDomainResourceSet) aResourceSet).checkResource(r);
            }
        }
    }

    /**
     * Refresh the list of opened resources and their corresponding editor name
     */
    public void refreshOpenedResources()
    {
        refreshOpenedResources(false);
    }

    /**
     * Refresh the read only resources in the map
     */
    public void refreshReadOnlyResources()
    {
        refreshReadOnlyResources(false);
    }

    /**
     * Refresh the read only resources in the map
     * 
     * @param computeDifferences true if a popup shall be displayed to warn if read-only resources list has changed
     * @return if computeDifferences is false, empty map, otherwise, a map with the names of newly read-only resources
     *         for True key and the names of no longer read-only resources for False key.
     */
    public Map<Boolean, List<String>> refreshReadOnlyResources(boolean computeDifferences)
    {
        refreshOpenedResources();
        for (Runnable r : refreshRunnables)
        {
            r.run();
        }
        // initialize map which will contains changes in read-only files list
        Map<Boolean, List<String>> mapOfChanges;
        if (computeDifferences)
        {
            mapOfChanges = new HashMap<Boolean, List<String>>();
            mapOfChanges.put(Boolean.TRUE, new ArrayList<String>());
            mapOfChanges.put(Boolean.FALSE, new ArrayList<String>());
        }
        else
        {
            mapOfChanges = Collections.emptyMap();
        }

        if (resourceToReadOnlyMap != null)
        {
            Map<Resource, Boolean> tmp = new HashMap<Resource, Boolean>(resourceToReadOnlyMap);
            boolean toCheck = Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY);
            for (Resource r : tmp.keySet())
            {
                // for read only we don't need to change properties of other
                // cases and we don't have other ways to
                // determine old read only resources (with attributes)
                if (!(ExportUtil.isExported(r) || ExportUtil.isCacheUri(r.getURI())))
                {
                    boolean readOnly = (isInOpenedResource(r) && toCheck) || isReadOnlyAccordingToAttribute(r);
                    if (computeDifferences)
                    {
                        // register differences
                        if (readOnly != resourceToReadOnlyMap.get(r))
                        {
                            mapOfChanges.get(readOnly).add(r.getURI().lastSegment());
                        }
                    }
                    resourceToReadOnlyMap.put(r, readOnly);
                }
            }
        }
        return mapOfChanges;
    }

    /**
     * Gets the clipboard.
     * 
     * @return the clipboard
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#getClipboard()
     */
    @Override
    public Collection<Object> getClipboard()
    {
        return staticClipboard;
    }

    /**
     * Sets the clipboard.
     * 
     * @param clipboard the clipboard
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#setClipboard(java.util.Collection)
     */
    @Override
    public void setClipboard(Collection<Object> clipboard)
    {
        staticClipboard = clipboard;
    }

    /**
     * Returns the URI of the first opened resource
     */
    public URI getInitialResourceURI()
    {
        return initialResourceURI;
    }

    /**
     * Check if element is not directly contained by the main opened resource, but is in dependent resources.
     * 
     * @param element element to check
     * @return true if element is not directly contained by the main resource, but in a child resource
     */
    public boolean isInOpenedResource(EObject element)
    {
        URI initialURI = getInitialResourceURI();
        if (initialURI != null && element.eResource() != null)
        {
            return isInOpenedResource(element.eResource());
        }
        return false;
    }

    /**
     * Check if resource is not directly the main opened resource, but is a dependent resource.
     * 
     * @param resource resource to check
     * @return true if resource is not the main resource, but is a child resource
     */
    public boolean isInOpenedResource(Resource resource)
    {
        URI initialURI = getInitialResourceURI();
        if (initialURI != null && resource != null && resource.getURI() != null)
        {
            if (resource.getURI().toString().endsWith("di"))
            {
                return !initialURI.equals(resource.getURI());
            }
            else
            {
                String initialURIString = initialURI.toString();
                return !(resource.getURI().equals(URI.createURI(initialURIString.substring(0, initialURIString.length() - 2))));
            }
        }
        return false;
    }

    /**
     * Makes the editing domain read only
     * 
     * @param totalReadOnly
     */
    public void setTotalReadOnly(boolean totalReadOnly)
    {
        this.totalReadOnly = totalReadOnly;
    }

    /**
     * Determines if the editing domain is in read only mode
     * 
     * @return
     */
    public boolean isTotalReadOnly()
    {
        return totalReadOnly;
    }

    /**
     * public static class comparing two string according to a specific pattern grouping numeric characters
     * */
    public static class EObjectNameComparator implements Comparator<String>
    {

        private final Pattern pattern;

        public EObjectNameComparator(Pattern pattern)
        {
            this.pattern = pattern;
        }

        public int compare(String o1, String o2)
        {
            if (o1 == null)
            {
                o1 = "";
            }
            if (o2 == null)
            {
                o2 = "";
            }
            Matcher m1 = pattern.matcher(o1);
            Matcher m2 = pattern.matcher(o2);
            Integer val1 = -1;
            Integer val2 = -1;
            if (m1.matches() && m1.groupCount() > 0)
            {
                try
                {
                    val1 = Integer.valueOf(m1.group(1));
                }
                catch (NumberFormatException e)
                {
                }
            }
            if (m2.matches() && m2.groupCount() > 0)
            {
                try
                {
                    val2 = Integer.valueOf(m2.group(1));
                }
                catch (NumberFormatException e)
                {
                }

            }
            return val1.compareTo(val2);
        }

    }

    /**
     * Add a runnable run during refresh
     * 
     * @param r , the runnable
     */
    public void addRefreshRunnable(Runnable r)
    {
        refreshRunnables.add(r);
    }

    /**
     * Release all the resources
     */
    public void dispose()
    {
        refreshRunnables.clear();
        alreadyOpenedResources.clear();
    }

}
