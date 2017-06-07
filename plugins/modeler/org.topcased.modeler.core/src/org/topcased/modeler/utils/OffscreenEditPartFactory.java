/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.RootEditPart;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.prefs.BackingStoreException;
import org.topcased.modeler.commands.CommandStack;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.CrossReferenceAdapter;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.edit.DiagramsRootEditPart;
import org.topcased.modeler.editor.IConfiguration;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerConfigurationManager;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * @author tfaure
 * 
 *         Utility class to generate editpart containment offscreen without creating an editor.
 */
public class OffscreenEditPartFactory
{

    private static OffscreenEditPartFactory INSTANCE = new OffscreenEditPartFactory();

    // * gives access to the singleton instance of <code>OffscreenEditPartFactory</code>
    public static OffscreenEditPartFactory getInstance()
    {
        return INSTANCE;
    }

    /**
     * collection to manage resources
     */
    private Collection<Modeler> allModelers = new LinkedList<Modeler>();

    private ModelerConfigurationManager configurationManager = null;

    private ModelerGraphicalViewer customViewer = null;

    private CrossReferenceAdapter crossReferenceAdapter = null;

    private TypeCacheAdapter typeCacheAdapter = null;

    private Modeler potentialEditor = null;

    private DiagramsRootEditPart rootEP;

    private CommandStack stack;

    private Diagram theDiagram;

    private Shell shellTodispose = null;

    // * Creates a <code>DiagramEditPart</code> given the <code>Diagram</code>
    public DiagramEditPart createDiagramEditPart(Diagram diagram)
    {
        return createDiagramEditPart(diagram, new Shell());
    }

    protected AdapterFactory getAdapterFactory()
    {
        return potentialEditor.getAdapterFactory();
    }

    public DiagramEditPart createDiagramEditPart(Diagram diagram, boolean batchMode)
    {
        if (batchMode)
        {
            return createDiagramEditPart(diagram, null);
        }
        else
        {
            return createDiagramEditPart(diagram, Display.getDefault().getActiveShell());
        }
    }

    /**
     * Creates a <code>DiagramEditPart</code> given the <code>Diagram</code>
     * 
     * @param diagram, the diagram object be carrefule the URI has to be a file URI. file:/
     * @param shell
     * @return
     */
    public DiagramEditPart createDiagramEditPart(Diagram diagram, Shell shell)
    {
        if (PlatformUI.getWorkbench() == null)
        {
            String message = "your environment does not have a workbench";
            ModelerPlugin.log(message, IStatus.ERROR);
            return null;
        }
        if (shell == null)
        {
            shell = new Shell();
            shellTodispose = shell;
        }
        if (diagram == null)
        {
            ModelerPlugin.log("please provide diagram object", IStatus.WARNING);
            return null;
        }
        theDiagram = diagram;
        if (theDiagram.eResource() == null)
        {
            ModelerPlugin.log("not managed " + theDiagram.getName(), IStatus.WARNING);
            return null;
        }
        potentialEditor = getPotentialEditor(theDiagram.eResource().getURI().fileExtension());
        if (potentialEditor == null)
        {
            ModelerPlugin.log("no editor founded for " + theDiagram.eResource().getURI().toString(), IStatus.WARNING);
            return null;
        }
        getConfigurationManager().setActiveDiagram(theDiagram);
        customViewer = new ModelerGraphicalViewer();
        if (customViewer.getControl() == null || customViewer.getControl().isDisposed())
        {
            customViewer.createControl(shell);
        }
        CustomModeler modeler = new CustomModeler(potentialEditor, theDiagram.eResource().getURI());
        allModelers.add(modeler);
        customViewer.setModelerEditor(modeler);
        modeler.setActiveDiagram(theDiagram);
        // get Ifile
        MixedEditDomain mixedEditDomain = new MixedEditDomain(null);
        stack = new CommandStack();
        mixedEditDomain.setCommandStack(stack);
        mixedEditDomain.setAdapterFactory(getAdapterFactory());
        customViewer.setEditDomain(mixedEditDomain);
        // hook in preferences
        rootEP = new DiagramsRootEditPart();

        customViewer.setRootEditPart(rootEP);

        customViewer.setEditPartFactory(getActiveConfiguration().getEditPartFactory());
        // DiagramEventBroker.startListening(TransactionUtil.getEditingDomain(diagram));
        customViewer.setContents(theDiagram);
        customViewer.flush();

        Assert.isTrue(customViewer.getContents() instanceof DiagramEditPart);

        /*
         * We need to flush all the deferred updates.
         */
        while (shell.getDisplay().readAndDispatch())
            ;
        return (DiagramEditPart) customViewer.getContents();

    }

    private Modeler getPotentialEditor(String fileExtension)
    {
        if (fileExtension == null)
        {
            return null;
        }
        String extensionPOintID = "org.eclipse.ui.editors";
        IConfigurationElement[] conf = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPOintID);
        for (IConfigurationElement c : conf)
        {
            String editorExtension = c.getAttribute("extensions");
            if (fileExtension.equals(editorExtension))
            {
                try
                {
                    return (Modeler) c.createExecutableExtension("class");
                }
                catch (CoreException e)
                {
                }
            }
        }
        return null;
    }

    public IConfiguration getActiveConfiguration()
    {
        return getConfigurationManager().getActiveConfiguration();
    }

    protected ModelerConfigurationManager getConfigurationManager()
    {
        if (configurationManager == null)
        {
            configurationManager = new ModelerConfigurationManager();
        }
        return configurationManager;
    }

    public RootEditPart getRootEditPart()
    {
        return rootEP;
    }

    public org.eclipse.gef.commands.CommandStack getCommandStack()
    {
        return stack;
    }

    public void disposeIteration()
    {
        if (shellTodispose != null)
        {
            shellTodispose.dispose();
        }
        if (customViewer != null && customViewer.getControl() != null)
        {
            customViewer.getControl().dispose();
        }
        if (customViewer != null)
        {
            customViewer = null;
        }
        // ImageRegistry.getInstance().handleDisplayDispose();
    }

    public void dispose()
    {
        if (stack != null)
        {
            stack.dispose();
        }
        if (potentialEditor != null)
        {
            potentialEditor = null;
        }
        if (crossReferenceAdapter != null)
        {
            crossReferenceAdapter.dispose();
        }
        if (customViewer != null && customViewer.getControl() != null)
        {
            customViewer.getControl().dispose();
        }
        if (customViewer != null)
        {
            customViewer = null;
        }
        if (typeCacheAdapter != null)
        {
            typeCacheAdapter.dispose();
        }
        if (rootEP != null)
        {
            rootEP = null;
        }
        for (Modeler m : allModelers)
        {
            try
            {
                m.dispose();
            }
            catch (NullPointerException e)
            {
                // Modeler created have some null field that can
                // throw an NullPointerException
            }

        }
        allModelers.clear();
    }

    /**
     * This modeler is created in an OffscreenEditPartFactory context
     * @author tfaure
     *
     */
    public class CustomModeler extends Modeler
    {
        private final String extensionPointForPluginReplacement = "org.topcased.modeler.pluginPreferenceStoreForOffscreen";

        private Modeler theModeler;

        private URI diagram;

        private Map<IProject, IPreferenceStore> cacheStores = new HashMap<IProject, IPreferenceStore>();

        private Map<URI, IFile> cacheIfiles = new HashMap<URI, IFile>();

        AbstractUIPlugin plugin = null;
        
        private boolean needsUnload = false ;

        public CustomModeler(Modeler m, URI uri)
        {
            theModeler = m;
            diagram = uri;
            plugin = getPluginToUse((AbstractUIPlugin) Platform.getPlugin(FrameworkUtil.getBundle(theModeler.getClass()).getSymbolicName()));
            setEditDomain(createEditDomain());
        }

        @Override
        public void dispose()
        {
            super.dispose();
            cacheIfiles.clear();
            cacheStores.clear();
        }

        @Override
        public void setActiveDiagram(Diagram diagram)
        {
            activeDiagram = diagram;
        }

        @Override
        public String getId()
        {
            return theModeler.getId();
        }
        
		@Override
		protected boolean modelerNeedsUnload() {
			return needsUnload;
		}

		@Override
        public IWorkbenchPartSite getSite()
        {
            try
            {
                if (PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService() != null
                        && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart() != null
                        && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart().getSite() != null)
                {
                    return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart().getSite();
                }
            }
            catch (IllegalStateException e)
            {
                // normal for batch mode
            }
            return new IWorkbenchPartSite()
            {

                public boolean hasService(Class api)
                {
                    return false;
                }

                public Object getService(Class api)
                {
                    return null;
                }

                public Object getAdapter(Class adapter)
                {
                    return null;
                }

                public void setSelectionProvider(ISelectionProvider provider)
                {

                }

                public IWorkbenchWindow getWorkbenchWindow()
                {
                    return null;
                }

                public Shell getShell()
                {
                    return null;
                }

                public ISelectionProvider getSelectionProvider()
                {
                    return null;
                }

                public IWorkbenchPage getPage()
                {
                    return null;
                }

                public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider)
                {

                }

                public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider)
                {

                }

                public String getRegisteredName()
                {
                    return "";
                }

                public String getPluginId()
                {
                    return "";
                }

                public IWorkbenchPart getPart()
                {
                    // TODO Auto-generated method stub
                    return null;
                }

                public IKeyBindingService getKeyBindingService()
                {
                    // TODO Auto-generated method stub
                    return null;
                }

                public String getId()
                {
                    return "Topcased";
                }
            };
        }

        @Override
        public Diagrams getDiagrams()
        {
            if (theDiagram != null && theDiagram.eResource() != null && theDiagram.eResource().getContents() != null && !theDiagram.eResource().getContents().isEmpty())
            {
                return (Diagrams) theDiagram.eResource().getContents().get(0);
            }
            return null;
        }

        @Override
        public IConfiguration getActiveConfiguration()
        {
            IConfiguration result = null;
            if (configurationManager != null)
            {
                result = configurationManager.getActiveConfiguration();
            }
            return result;
        }

        @Override
        public IPreferenceStore getPreferenceStore()
        {
            IFile file = cacheIfiles.get(diagram);
            if (file == null)
            {
                IWorkspace workspace = ResourcesPlugin.getWorkspace();
                IWorkspaceRoot rootWS = workspace.getRoot();
                URI uriWorkspace = URI.createURI(rootWS.getLocationURI().toString());
                URI finalUri = URI.createURI(diagram.toString().replace(uriWorkspace.toString(), ""));
                file = rootWS.getFile(new Path(finalUri.toString()));
                if (!file.exists())
                {
                    // Test if the file is out of the workspace
                    String[] segments = diagram.segments();
                    int i = segments.length - 1;
                    String path = segments[i];
                    IResource member = rootWS.findMember(new Path(path));
                    for (i = segments.length - 2; member == null && i >= 0; i--)
                    {
                        path = segments[i] + "/" + path;
                        member = rootWS.findMember(new Path(path));
                    }
                    if (member instanceof IFile)
                    {
                        file = (IFile) member;
                    }
                }
                if (file.exists())
                {
                    cacheIfiles.put(diagram, file);
                }
            }
            if (file.exists())
            {
                IProject project = file.getProject();
                if (project.exists())
                {
                    IEclipsePreferences root = Platform.getPreferencesService().getRootNode();
                    try
                    {
                        if (root.node(ProjectScope.SCOPE).node(project.getName()).nodeExists(plugin.getBundle().getSymbolicName()))
                        {
                            IPreferenceStore store = cacheStores.get(project);
                            if (store == null)
                            {
                                store = new ScopedPreferenceStore(new ProjectScope(project), plugin.getBundle().getSymbolicName());
                                cacheStores.put(project, store);
                            }
                            return store;
                        }
                    }
                    catch (BackingStoreException e)
                    {
                    }
                }
            }
            return plugin.getPreferenceStore();
        }

        /**
         * Search if the plugin of the current modeler has to be replaced by another plugin
         * 
         * @param abstractUIPlugin
         * @return
         */
        private AbstractUIPlugin getPluginToUse(AbstractUIPlugin abstractUIPlugin)
        {
            if (abstractUIPlugin != null)
            {
                IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointForPluginReplacement);
                for (IConfigurationElement e : configurationElements)
                {
                    String classToReplace = e.getAttribute("classToReplace");
                    if (classToReplace.equals(abstractUIPlugin.getClass().getName()))
                    {
                        Class theClass;
                        try
                        {
                            theClass = Platform.getBundle(e.getContributor().getName()).loadClass(e.getAttribute("newClass"));
                            return (AbstractUIPlugin) Platform.getPlugin(FrameworkUtil.getBundle(theClass).getSymbolicName());
                        }
                        catch (InvalidRegistryObjectException e1)
                        {
                            e1.printStackTrace();
                        }
                        catch (ClassNotFoundException e1)
                        {
                            e1.printStackTrace();
                        }
                    }
                }
            }
            return abstractUIPlugin;
        }

		/**
		 * Determine if the modeler needs to be unloaded at the end of the process
		 * @param needsUnload
		 */
		public void setNeedsUnload(boolean needsUnload) {
			this.needsUnload = needsUnload;
		}
    }
}
