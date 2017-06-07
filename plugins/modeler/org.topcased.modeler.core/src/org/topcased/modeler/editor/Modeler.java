/***********************************************************************
 * Copyright (c) 2005, 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Thibault Landre (Atos Origin) - Fix #772
 *    Gilles Cannenterre (Anyware Technologies) - Fix bugs #1161 and #1247
 *    Vincent Hemery (Atos Origin) - Fix #783
 *    Sebastien Gabel (CS) - Fix #1973 and co
 **********************************************************************/
package org.topcased.modeler.editor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightAction;
import org.eclipse.gef.ui.actions.MatchWidthAction;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.PaletteContextMenuProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gmf.runtime.common.ui.util.PartListenerAdapter;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.services.IDisposable;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.builders.TodoNoteBuilder;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.internal.DiagramsPlugin;
import org.topcased.modeler.diagrams.model.util.CrossReferenceAdapter;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.dialogs.ChooseGraphElementDialog;
import org.topcased.modeler.dialogs.InformationDialog;
import org.topcased.modeler.dialogs.ReadOnlyResourcesDialog;
import org.topcased.modeler.edit.DiagramsRootEditPart;
import org.topcased.modeler.editor.outline.DiagramsOutlinePage;
import org.topcased.modeler.editor.properties.ModelerPropertySheetPage;
import org.topcased.modeler.extensions.SynchronizedModelDiagramRulesManager;
import org.topcased.modeler.internal.IntegrityChecker;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.AutoResizeAction;
import org.topcased.modeler.internal.actions.AutoResizePageAction;
import org.topcased.modeler.internal.actions.ChangeBackgroundColorAction;
import org.topcased.modeler.internal.actions.ChangeDiagramPropertiesAction;
import org.topcased.modeler.internal.actions.ChangeFontAction;
import org.topcased.modeler.internal.actions.ChangeForegroundColorAction;
import org.topcased.modeler.internal.actions.ChangeRouterAction;
import org.topcased.modeler.internal.actions.CopyAction;
import org.topcased.modeler.internal.actions.CutAction;
import org.topcased.modeler.internal.actions.DeleteGraphElementAction;
import org.topcased.modeler.internal.actions.DeleteModelObjectAction;
import org.topcased.modeler.internal.actions.EnableWriteAction;
import org.topcased.modeler.internal.actions.GoToRootDiagramAction;
import org.topcased.modeler.internal.actions.ModelerValidateAction;
import org.topcased.modeler.internal.actions.MoveBackwardAction;
import org.topcased.modeler.internal.actions.MoveForwardAction;
import org.topcased.modeler.internal.actions.MoveToBackAction;
import org.topcased.modeler.internal.actions.MoveToFrontAction;
import org.topcased.modeler.internal.actions.NextDiagramAction;
import org.topcased.modeler.internal.actions.OpenParentDiagramAction;
import org.topcased.modeler.internal.actions.PasteAction;
import org.topcased.modeler.internal.actions.PreviousDiagramAction;
import org.topcased.modeler.internal.actions.RefreshAction;
import org.topcased.modeler.internal.actions.RestoreConnectionsAction;
import org.topcased.modeler.internal.actions.SelectAllConnectionsAction;
import org.topcased.modeler.internal.actions.SelectAllNodesAction;
import org.topcased.modeler.internal.actions.SelectAllTopcasedAction;
import org.topcased.modeler.internal.actions.ShowDocViewAction;
import org.topcased.modeler.internal.actions.ShowPropertiesViewAction;
import org.topcased.modeler.internal.actions.SynchronizedModelDiagramReportAction;
import org.topcased.modeler.internal.editor.palette.PaletteStateRecorder;
import org.topcased.modeler.internal.exceptions.IntegrityException;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.ResourceUtils;
import org.topcased.modeler.utils.Utils;
import org.topcased.tabbedproperties.utils.ITypeCacheAdapter;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * Basic EMF modeler. <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 * @author <a href="mailto:tristan.faure@atosorigin.com">Tristan FAURE </a>
 */
public abstract class Modeler extends GraphicalEditorWithPalette implements ISelectionProvider, IEditingDomainProvider, IGotoMarker, ITabbedPropertySheetPageContributor
{
    /** use to get the currentIFile (the selected element in the current editor) */
    private static IFile currentIFile;

    /** by default a popup is displayed when read only mode is enbled */
    private static boolean displayReadOnlyMessage = true;

    /** A shared variable to temporarily disable popups on read only resources */
    private static boolean displayReadOnlyResourcesMessage = true;

    /**
     * The global edited diagrams model
     */
    private Resource diResource;

    /**
     * The currently edited diagram
     */
    protected Diagram activeDiagram;

    /** The class that manage the navigation through the different diagrams */
    private NavigationManager navigation;

    private ModelerConfigurationManager configurationManager;

    private TabbedPropertySheetPage propertySheetPage;

    /** by default read only is to false */
    private boolean readOnly = false;

    private IContentOutlinePage diagramOutlinePage = null;

    /** List of resources which have been dirtied by another editor. These would need reloading. */
    private Set<URI> outdatedResources = new HashSet<URI>();

    /**
     * This listens for editor activation to refresh read-only resources information
     */
    private final IPartListener partListener = new PartListenerAdapter()
    {
        /**
         * Refresh read-only resources list when the modeler part is activated
         * 
         * @param part the activated part
         */
        @Override
        public void partActivated(IWorkbenchPart part)
        {
            if (part == Modeler.this)
            {
                if (Modeler.this.getEditingDomain() instanceof TopcasedAdapterFactoryEditingDomain)
                {
                    // compute new read only resources and inform of the difference
                    TopcasedAdapterFactoryEditingDomain topcasedDomain = (TopcasedAdapterFactoryEditingDomain) Modeler.this.getEditingDomain();
                    Map<Boolean, List<String>> diff = topcasedDomain.refreshReadOnlyResources(true);
                    ReadOnlyResourcesDialog dialog = new ReadOnlyResourcesDialog(ModelerPlugin.getActiveWorkbenchShell(), diff);
                    dialog.open();
                }
                refreshOutline();
            }
        }
    };

    /**
     * This listens for workspace changes (to close the modeler on a renaming or detect a modified resource).
     */
    private final IResourceChangeListener resourceChangeListener = new IResourceChangeListener()
    {
        public void resourceChanged(IResourceChangeEvent event)
        {
            IResourceDelta delta = event.getDelta();
            try
            {
                class ResourceDeltaVisitor implements IResourceDeltaVisitor
                {
                    private final ResourceSet resourceSet = diResource.getResourceSet();

                    private final Collection<Resource> removedResources = new ArrayList<Resource>();

                    private final Collection<URI> modifiedResourcesURI = new ArrayList<URI>();

                    public boolean visit(IResourceDelta resourceDelta)
                    {
                        if (resourceDelta.getResource().getType() == IResource.FILE && resourceDelta.getKind() == IResourceDelta.REMOVED)
                        {
                            Resource resource = resourceSet.getResource(URI.createURI(resourceDelta.getFullPath().toString(), true), false);
                            if (resource != null)
                            {
                                if (resourceDelta.getKind() == IResourceDelta.REMOVED)
                                {
                                    removedResources.add(resource);
                                }
                            }
                        }
                        else if (resourceDelta.getResource().getType() == IResource.FILE && resourceDelta.getKind() == IResourceDelta.CHANGED)
                        {
                            Resource resource = resourceSet.getResource(URI.createURI(resourceDelta.getFullPath().toString(), true), false);
                            if (resource != null)
                            {
                                if (resourceDelta.getKind() == IResourceDelta.CHANGED)
                                {
                                    modifiedResourcesURI.add(resource.getURI());
                                }
                            }
                        }
                        return true;
                    }

                    public Collection<Resource> getRemovedResources()
                    {
                        return removedResources;
                    }

                    public Collection<URI> getModifiedResourcesURI()
                    {
                        return modifiedResourcesURI;
                    }
                }
                ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
                delta.accept(visitor);
                if (!visitor.getRemovedResources().isEmpty() && !isDirty())
                {
                    close(false);
                }
                if (!visitor.getModifiedResourcesURI().isEmpty())
                {
                    outdatedResources.addAll(visitor.getModifiedResourcesURI());
                }
            }
            catch (CoreException exception)
            {
                ModelerPlugin.log(exception);
            }
        }
    };

    /**
     * Constructor. Set the edit domain.
     */
    public Modeler()
    {
        super();
        navigation = new NavigationManager(this);
    }

    /**
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#dispose()
     */
    public void dispose()
    {
        super.dispose();
        if (getEditingDomain() instanceof TopcasedAdapterFactoryEditingDomain)
        {
            TopcasedAdapterFactoryEditingDomain editing = (TopcasedAdapterFactoryEditingDomain) getEditingDomain();
            editing.dispose();
        }
        outdatedResources.clear();
        diResource = null;
        currentIFile = null;
        getSite().getPage().removePartListener(partListener);
        if (propertySheetPage != null)
        {
            propertySheetPage.dispose();
        }
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
        // dispose adapter factories
        for (AdapterFactory a : getAdapterFactories())
        {
            if (a instanceof IDisposable)
            {
                IDisposable disposable = (IDisposable) a;
                disposable.dispose();
            }
        }
        navigation = null;
        // dispose adapters
        if (diagramOutlinePage != null)
        {
            diagramOutlinePage.setSelection(null);
            diagramOutlinePage.dispose();
        }
        if (modelerNeedsUnload())
        {
            UnloadJob job = new UnloadJob(getResourceSet());
            job.setUser(true);
            job.schedule();
        }
        if (getEditDomain() instanceof MixedEditDomain)
        {
            ((MixedEditDomain) getEditDomain()).dispose();
        }

    }

    /**
     * Determine if the modeler needs to do unload job at the end of the process By default true
     * 
     * @return true if the unload has to be run
     */
    protected boolean modelerNeedsUnload()
    {
        return true;
    }

    /**
     * Check whether some resources needs to be reloaded as they have been modified by other editors.
     * 
     * @return true if a reload is necessary.
     */
    public List<String> getOutdatedResourcesAsString()
    {
        List<String> outdatedResourcesAsString = new ArrayList<String>();
        for (URI r : outdatedResources)
        {
            outdatedResourcesAsString.add(r.lastSegment());
        }
        return outdatedResourcesAsString;
    }

    /**
     * Switch from the write mode to the read mode
     * 
     * @return true if read mode is active at the end (either action succeeded, either it was already in read mode)
     */
    public boolean switchToReadMode()
    {
        setIsReadOnly(true, false);
        return !isReadOnly();
    }

    /**
     * Switch from the read mode to the write mode
     * 
     * @return true if write mode is active at the end (either action succeeded, either it was already in write mode)
     */
    public boolean switchToWriteMode()
    {
        // Test if there are already opened resources
        ((TopcasedAdapterFactoryEditingDomain) getEditingDomain()).refreshOpenedResources();
        if (!checkOpenedResources())
        {
            setIsReadOnly(false, false);
        }
        else
        {

            Map<String, List<String>> alreadyOpennedResources = getAlreadyOpenedResources(getResourceSet().getResources(), diResource);
            if (!alreadyOpennedResources.isEmpty())
            {
                String entryFormat = Messages.getString("Modeler.WriteOnlyEditorsOpened.Entry");//$NON-NLS-1$
                StringBuffer message = new StringBuffer(Messages.getString("Modeler.WriteOnlyEditorsOpened.Message"));//$NON-NLS-1$
                List<String> handledEditors = new ArrayList<String>();
                for (String resourceName : alreadyOpennedResources.keySet())
                {
                    for (String editorName : alreadyOpennedResources.get(resourceName))
                    {
                        if (!handledEditors.contains(editorName))
                        {
                            message.append(System.getProperty("line.separator"));
                            String entry = NLS.bind(entryFormat, editorName);
                            message.append(entry);
                            handledEditors.add(editorName);
                        }
                    }
                }
                MessageDialog.openInformation(ModelerPlugin.getActiveWorkbenchShell(), Messages.getString("Modeler.WriteOnlyEditorsOpened.Title"), message.toString());//$NON-NLS-1$
            }
        }
        return !isReadOnly();
    }

    /**
     * Reload the resources which have been modified outside of this modeler to make sure all information is up to date
     * 
     * @return the new editing modeler or null
     */
    public Modeler reloadResources()
    {
        if (!outdatedResources.isEmpty())
        {
            return doReloadResources();
        }
        return this;
    }

    /**
     * Reload the resources to their last saved state
     * 
     * @return the new editing modeler or null
     */
    public Modeler rejectModifications()
    {
        return doReloadResources();
    }

    /**
     * Reload the resources (modified or not) to make sure all information is up to date
     * 
     * @return the new editing modeler or null
     */
    private Modeler doReloadResources()
    {
        // backup currently active diagram information
        IFile openedFile = null;
        URI resURI = diResource.getURI();
        resURI = diResource.getResourceSet().getURIConverter().normalize(resURI);
        String scheme = resURI.scheme();
        if ("platform".equals(scheme) && resURI.segmentCount() > 1 && "resource".equals(resURI.segment(0)))
        {
            StringBuffer platformResourcePath = new StringBuffer();
            for (int j = 1, size = resURI.segmentCount(); j < size; ++j)
            {
                platformResourcePath.append('/');
                platformResourcePath.append(resURI.segment(j));
            }
            // pass by a java.net.URI to convert "%20" as " "
            java.net.URI uri = java.net.URI.create(platformResourcePath.toString());
            openedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.getPath()));
        }
        URI diagramURI = null;
        if (activeDiagram != null)
        {
            Resource diagRes = activeDiagram.eResource();
            URI diagResURI = diagRes.getURI();
            String diagURIFrag = diagRes.getURIFragment(activeDiagram);
            diagramURI = diagResURI.appendFragment(diagURIFrag);
        }
        // unload by closing
        getSite().getPage().closeEditor(Modeler.this, false);

        Modeler newModeler = null;

        // load from scratch
        if (openedFile != null)
        {
            // temporarily disable messages for read-only resources
            boolean display = isDisplayReadOnlyResourcesMessage();
            setDisplayReadOnlyResourcesMessage(false);

            IEditorInput input = new FileEditorInput(openedFile);
            try
            {
                IEditorPart editor = getSite().getPage().openEditor(input, getId());
                // restore active diagram
                if (editor instanceof Modeler && ((Modeler) editor).diResource != null && diagramURI != null)
                {
                    newModeler = (Modeler) editor;
                    EObject diagram = ((Modeler) editor).diResource.getResourceSet().getEObject(diagramURI, true);
                    if (diagram instanceof Diagram)
                    {
                        ((Modeler) editor).setActiveDiagram((Diagram) diagram);
                    }
                }
            }
            catch (PartInitException exception)
            {
                MessageDialog.openError(getSite().getShell(), DiagramsPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
            }
            // restore read-only message display
            setDisplayReadOnlyResourcesMessage(display);
        }
        outdatedResources.clear();
        return newModeler;
    }

    /**
     * @see org.eclipse.gef.commands.CommandStackListener#commandStackChanged(java.util.EventObject)
     */
    public void commandStackChanged(final EventObject event)
    {
        if (Display.getCurrent() != Display.getDefault())
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    safeCommandStackChanged(event);
                }
            });
        }
        else
        {
            safeCommandStackChanged(event);
        }
    }

    /**
     * Handle the event in the UI thread
     * 
     * @param event the command stack event
     */
    protected void safeCommandStackChanged(EventObject event)
    {
        // if currentMode is read only the editor should not be notify about change
        if (!readOnly)
        {
            firePropertyChange(PROP_DIRTY);
            super.commandStackChanged(event);
        }
    }

    /**
     * Creates the GraphicalViewer on the specified <code>Composite</code>.
     * 
     * @param parent the parent composite
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#createGraphicalViewer(org.eclipse.swt.widgets.Composite)
     */
    protected void createGraphicalViewer(Composite parent)
    {
        GraphicalViewer viewer = new ModelerGraphicalViewer();
        viewer.createControl(parent);
        setGraphicalViewer(viewer);
        configureGraphicalViewer();
        hookGraphicalViewer();
        initializeGraphicalViewer();
    }

    /**
     * Overridden to extend method visibility.
     * 
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#getGraphicalViewer()
     */
    @Override
    public GraphicalViewer getGraphicalViewer()
    {
        return super.getGraphicalViewer();
    }

    /**
     * Subclass should override this method to instantiate their own ContextMenu
     * 
     * @param viewer the GraphicalViewer
     * @return the ContextMenuProvider
     */
    protected ContextMenuProvider getContextMenuProvider(ModelerGraphicalViewer viewer)
    {
        return new ModelerContextMenuProvider(viewer, getActionRegistry());
    }

    /**
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
     */
    protected void configureGraphicalViewer()
    {
        super.configureGraphicalViewer();
        final ModelerGraphicalViewer viewer = (ModelerGraphicalViewer) getGraphicalViewer();

        // configure the EditPartViewer
        ScalableFreeformRootEditPart root = new DiagramsRootEditPart();
        viewer.setModelerEditor(this);
        viewer.setRootEditPart(root);

        // set the ContextMenuProvider
        ContextMenuProvider provider = getContextMenuProvider(viewer);
        viewer.setContextMenu(provider);
        ((IEditorSite) getSite()).registerContextMenu("org.topcased.modeler", provider, viewer, false);

        // Begin : Deal with keys
        KeyHandler keyHandler = new ModelerKeyHandler(this);
        keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
        viewer.setKeyHandler(keyHandler);
        // End : Deal with keys

        // Zoom
        List<String> zoomLevels = new ArrayList<String>();
        zoomLevels.add(ZoomManager.FIT_ALL);
        zoomLevels.add(ZoomManager.FIT_WIDTH);
        zoomLevels.add(ZoomManager.FIT_HEIGHT);
        root.getZoomManager().setZoomLevelContributions(zoomLevels);

        IAction zoomIn = new ZoomInAction(root.getZoomManager());
        IAction zoomOut = new ZoomOutAction(root.getZoomManager());
        getActionRegistry().registerAction(zoomIn);
        getActionRegistry().registerAction(zoomOut);
        getSite().getKeyBindingService().registerAction(zoomIn);
        getSite().getKeyBindingService().registerAction(zoomOut);

        IAction snapAction = new ToggleSnapToGeometryAction(getGraphicalViewer());
        getActionRegistry().registerAction(snapAction);

        IAction showGrid = new ToggleGridAction(getGraphicalViewer());
        getActionRegistry().registerAction(showGrid);

        // Scroll-wheel Zoom
        getGraphicalViewer().setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL), MouseWheelZoomHandler.SINGLETON);

        registerSelectionChangedActions(viewer);
    }

    /**
     * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#configurePaletteViewer()
     */
    protected void configurePaletteViewer()
    {
        getPaletteViewer().setContextMenu(new PaletteContextMenuProvider(getPaletteViewer()));

        // TODO also create our own PaletteCustomizer
    }

    /**
     * Register actions that listen to selection
     * 
     * @param viewer the graphical viewer : emitter of the selection changed events
     */
    protected void registerSelectionChangedActions(GraphicalViewer viewer)
    {
        // ---------------------------------------
        // register selection change with actions
        // ---------------------------------------

        IAction copyAction = getActionRegistry().getAction(ActionFactory.COPY.getId());
        viewer.addSelectionChangedListener((ISelectionChangedListener) copyAction);

        IAction cutAction = getActionRegistry().getAction(ActionFactory.CUT.getId());
        viewer.addSelectionChangedListener((ISelectionChangedListener) cutAction);

        IAction changeBackGroundColorAction = getActionRegistry().getAction(ModelerActionConstants.CHANGE_BACKGROUND_COLOR);
        viewer.addSelectionChangedListener((ISelectionChangedListener) changeBackGroundColorAction);

        IAction changeForeGroundColorAction = getActionRegistry().getAction(ModelerActionConstants.CHANGE_FOREGROUND_COLOR);
        viewer.addSelectionChangedListener((ISelectionChangedListener) changeForeGroundColorAction);

        IAction changeRouterAction = getActionRegistry().getAction(ModelerActionConstants.CHANGE_ROUTER);
        viewer.addSelectionChangedListener((ISelectionChangedListener) changeRouterAction);

        IAction changeFontAction = getActionRegistry().getAction(ModelerActionConstants.CHANGE_FONT);
        viewer.addSelectionChangedListener((ISelectionChangedListener) changeFontAction);

        IAction changeDiagramPropertiesAction = getActionRegistry().getAction(ModelerActionConstants.CHANGE_DIAGRAM_PROPERTIES);
        viewer.addSelectionChangedListener((ISelectionChangedListener) changeDiagramPropertiesAction);

        IAction deleteModelObjectAction = getActionRegistry().getAction(ModelerActionConstants.DELETE_MODEL_OBJECT);
        viewer.addSelectionChangedListener((ISelectionChangedListener) deleteModelObjectAction);

        IAction moveForwardAction = getActionRegistry().getAction(ModelerActionConstants.MOVE_FORWARD);
        viewer.addSelectionChangedListener((ISelectionChangedListener) moveForwardAction);

        IAction moveBackwardAction = getActionRegistry().getAction(ModelerActionConstants.MOVE_BACKWARD);
        viewer.addSelectionChangedListener((ISelectionChangedListener) moveBackwardAction);

        IAction moveToFrontAction = getActionRegistry().getAction(ModelerActionConstants.MOVE_TO_FRONT);
        viewer.addSelectionChangedListener((ISelectionChangedListener) moveToFrontAction);

        IAction moveToBackAction = getActionRegistry().getAction(ModelerActionConstants.MOVE_TO_BACK);
        viewer.addSelectionChangedListener((ISelectionChangedListener) moveToBackAction);

        IAction autoResizeAction = getActionRegistry().getAction(ModelerActionConstants.AUTO_RESIZE);
        viewer.addSelectionChangedListener((ISelectionChangedListener) autoResizeAction);

        IAction restoreConnAction = getActionRegistry().getAction(ModelerActionConstants.RESTORE_CONNECTIONS);
        viewer.addSelectionChangedListener((ISelectionChangedListener) restoreConnAction);

        IAction selectAllAction = getActionRegistry().getAction(ModelerActionConstants.SELECT_ALL);
        viewer.addSelectionChangedListener((ISelectionChangedListener) selectAllAction);

        IAction selectAllShapesAction = getActionRegistry().getAction(ModelerActionConstants.SELECT_ALL_NODES);
        viewer.addSelectionChangedListener((ISelectionChangedListener) selectAllShapesAction);

        IAction selectAllEdgesAction = getActionRegistry().getAction(ModelerActionConstants.SELECT_ALL_CONNECTIONS);
        viewer.addSelectionChangedListener((ISelectionChangedListener) selectAllEdgesAction);

        IAction autoResizeDiagramPageFormat = getActionRegistry().getAction(ModelerActionConstants.AUTO_RESIZE_PAGE);
        viewer.addSelectionChangedListener((ISelectionChangedListener) autoResizeDiagramPageFormat);
    }

    /**
     * Creates actions for the modeler.
     * 
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#createActions()
     */
    protected void createActions()
    {
        super.createActions();

        ActionRegistry registry = getActionRegistry();
        IAction action;

        action = new DeleteGraphElementAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new DirectEditAction((IWorkbenchPart) this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        // Add Copy/Cut/Paste actions
        action = new CopyAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());
        getSite().getKeyBindingService().registerAction(action);

        action = new CutAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());
        getSite().getKeyBindingService().registerAction(action);

        action = new PasteAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());
        getSite().getKeyBindingService().registerAction(action);

        action = new ChangeRouterAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new ChangeBackgroundColorAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new ChangeForegroundColorAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new ChangeFontAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new ChangeDiagramPropertiesAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AutoResizeAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new DeleteModelObjectAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new RestoreConnectionsAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        // Alignment Actions
        action = new AlignmentAction((IWorkbenchPart) this, PositionConstants.LEFT);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AlignmentAction((IWorkbenchPart) this, PositionConstants.RIGHT);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AlignmentAction((IWorkbenchPart) this, PositionConstants.TOP);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AlignmentAction((IWorkbenchPart) this, PositionConstants.BOTTOM);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AlignmentAction((IWorkbenchPart) this, PositionConstants.CENTER);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AlignmentAction((IWorkbenchPart) this, PositionConstants.MIDDLE);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        // Size Actions
        action = new MatchWidthAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new MatchHeightAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new AutoResizeAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new ShowPropertiesViewAction(this);
        registry.registerAction(action);

        action = new ShowDocViewAction(this);
        registry.registerAction(action);

        // Refresh action
        action = new RefreshAction(this);
        registry.registerAction(action);

        // Previous and next navigation Action
        action = new PreviousDiagramAction(this);
        registry.registerAction(action);

        action = new NextDiagramAction(this);
        registry.registerAction(action);

        // Diagram navigation Action
        action = new OpenParentDiagramAction(this);
        registry.registerAction(action);

        action = new GoToRootDiagramAction(this);
        registry.registerAction(action);

        // Change diagram plans actions
        action = new MoveForwardAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new MoveBackwardAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new MoveToFrontAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        action = new MoveToBackAction(this);
        registry.registerAction(action);
        getSelectionActions().add(action.getId());

        // Validation action
        action = new ModelerValidateAction(this);
        registry.registerAction(action);

        // Report of synchronization problems between model and diagram action
        action = new SynchronizedModelDiagramReportAction(this);
        registry.registerAction(action);

        action = new SelectAllTopcasedAction(this);
        registry.registerAction(action);

        action = new SelectAllNodesAction(this);
        registry.registerAction(action);

        action = new SelectAllConnectionsAction(this);
        registry.registerAction(action);

        action = new AutoResizePageAction(this);
        registry.registerAction(action);

        // enable write action
        action = new EnableWriteAction(this);
        registry.registerAction(action);
    }

    /**
     * This method creates the list of factories used by the editor. <br>
     * Resource, DI, Diagrams and Reflexive factories are added here. <br>
     * <b>This method could be overridden to added specific factories before those. </b> <br>
     * 
     * @return the factories' list
     */
    protected List<AdapterFactory> getAdapterFactories()
    {
        List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
        factories.add(new org.topcased.modeler.di.model.provider.DiagramInterchangeItemProviderAdapterFactory());
        factories.add(new org.topcased.modeler.diagrams.model.provider.DiagramsItemProviderAdapterFactory());
        factories.add(new ResourceItemProviderAdapterFactory());
        factories.add(new ReflectiveItemProviderAdapterFactory());

        return factories;
    }

    /**
     * This method creates the ComposedAdapterFactory that groups all the factories used by the editor. <br>
     * <br>
     * 
     * @return the multi-factory
     */
    protected ComposedAdapterFactory createAdapterFactory()
    {
        // Create an adapter factory that yields item providers.

        return new ComposedAdapterFactory(getAdapterFactories());
    }

    /**
     * Returns the global adapter factory used by the editor
     * 
     * @return the composed adapter factory
     */
    public AdapterFactory getAdapterFactory()
    {
        if (getEditDomain() instanceof MixedEditDomain)
        {
            MixedEditDomain editDomain = (MixedEditDomain) getEditDomain();
            if (editDomain.getAdapterFactory() == null)
            {
                editDomain.setAdapterFactory(createAdapterFactory());
            }

            return editDomain.getAdapterFactory();
        }

        return createAdapterFactory();
    }

    /**
     * Returns the active diagram configuration, given by the configuration manager.
     * 
     * @return the active configuration
     */
    public IConfiguration getActiveConfiguration()
    {
        return getConfigurationManager().getActiveConfiguration();
    }

    /**
     * Returns the global edited model.
     * 
     * @return the diagrams model
     */
    public Diagrams getDiagrams()
    {
        return (Diagrams) diResource.getContents().get(0);
    }

    /**
     * Increase the access to the action registry to public
     * 
     * @return the action registry
     */
    public ActionRegistry getPublicActionRegistry()
    {
        // TODO see if the method could not be deleted
        return getActionRegistry();
    }

    /**
     * Returns the main edit part of the editor
     * 
     * @return the root edit part
     */
    public RootEditPart getRootEditPart()
    {
        return getGraphicalViewer().getRootEditPart();
    }

    /**
     * The modeler can be adapted into a IPropertySheetPage or a IContentOutline.
     * 
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class type)
    {
        // use to get the currentIFile (the selected element in the current editor)
        if (getEditorInput() instanceof IFileEditorInput)
        {
            currentIFile = ((IFileEditorInput) getEditorInput()).getFile();
        }
        if (type == IPropertySheetPage.class)
        {
            return getPropertySheetPage();
        }
        if (type == IContentOutlinePage.class)
        {
            diagramOutlinePage = createOutlinePage();
            return diagramOutlinePage;
        }
        if (type == DefaultEditDomain.class || type == EditDomain.class)
        {
            return getEditDomain();
        }
        if (type == MixedEditDomain.class)
        {
            DefaultEditDomain editDomain = getEditDomain();
            if (editDomain instanceof MixedEditDomain)
            {
                return editDomain;
            }
        }
        if (type == EditingDomain.class)
        {
            DefaultEditDomain editDomain = getEditDomain();
            if (editDomain instanceof MixedEditDomain)
            {
                return ((MixedEditDomain) editDomain).getEMFEditingDomain();
            }
        }
        if (type == ZoomManager.class)
        {
            return getGraphicalViewer().getProperty(ZoomManager.class.toString());
        }
        if (type == EditPartViewer.class)
        {
            return getGraphicalViewer();
        }
        return super.getAdapter(type);
    }

    private IPropertySheetPage getPropertySheetPage()
    {
        if (propertySheetPage == null)
        {
            propertySheetPage = new ModelerPropertySheetPage(this);
        }
        return propertySheetPage;

        // PropertySheetPage page = new PropertySheetPage()
        // {
        // /**
        // * @see
        // org.eclipse.ui.views.properties.PropertySheetPage#setActionBars(org.eclipse.ui.IActionBars)
        // */
        // public void setActionBars(IActionBars actionBars)
        // {
        // super.setActionBars(actionBars);
        // actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
        // getActionRegistry().getAction(ActionFactory.UNDO.getId()));
        // actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
        // getActionRegistry().getAction(ActionFactory.REDO.getId()));
        // }
        // };
        // page.setPropertySourceProvider(new
        // GEFPropertySourceProvider(getAdapterFactory()));
        // return page;
    }

    /**
     * Create the outline for this editor.<br>
     * <b>This method can be overridden by subclasses to customize the outline</b>
     * 
     * @return the outline
     */
    protected IContentOutlinePage createOutlinePage()
    {
        return new DiagramsOutlinePage(this);
    }

    /**
     * Returns the current palette root.
     * 
     * @see org.eclipse.gef.ui.parts.GraphicalEditorWithPalette#getPaletteRoot()
     */
    protected PaletteRoot getPaletteRoot()
    {
        if (getActiveConfiguration() != null)
        {
            return getActiveConfiguration().getPaletteManager().getRoot();
        }

        return null;
    }

    @Override
    public boolean isSaveOnCloseNeeded()
    {
        return super.isSaveOnCloseNeeded() && !readOnly;
    }

    /**
     * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void doSave(IProgressMonitor monitor)
    {
        if (readOnly)
        {
            ModelerPlugin.displayDialog("Read only", "You are in read only mode you can not save your diagram", IStatus.WARNING);
            return;
        }
        // Do the work within an operation because this is a long running
        // activity that modifies the workbench.
        //
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
        {
            public void execute(IProgressMonitor mon) throws CoreException
            {
                try
                {
                    asyncSave(mon);
                }
                catch (IntegrityException ie)
                {
                    throw new CoreException(new Status(IStatus.ERROR, ModelerPlugin.getId(), IStatus.ERROR, ie.getMessage(), ie));
                }
                catch (IOException ioe)
                {
                    throw new CoreException(new Status(IStatus.ERROR, ModelerPlugin.getId(), IStatus.ERROR, ioe.getMessage(), ioe));
                }
            }
        };

        try
        {
            // This runs the options, and shows progress.
            //
            new ProgressMonitorDialog(getSite().getShell()).run(false, false, operation);

            // resources have just been saved, hence, they have been modified. Yet we are up to date.
            outdatedResources.clear();

            getCommandStack().markSaveLocation();
        }
        catch (InvocationTargetException ite)
        {
            Throwable t = ite.getCause();
            if (t instanceof CoreException)
            {
                CoreException ce = (CoreException) t;
                ErrorDialog.openError(getSite().getShell(), "Unable to save", ce.getStatus().getMessage(), ce.getStatus());
            }
            else
            {
                ModelerPlugin.log(t);
                ModelerPlugin.displayDialog("Unable to save", "An error occurred during save.\nSee error logs for more details.", IStatus.ERROR);
            }
        }
        catch (InterruptedException ie)
        {
            // Ignore cancel
        }
        finally
        {
            monitor.done();
        }
    }

    /**
     * Effective save action : <br>
     * <ol>
     * <li>Save the diagram state
     * <li>Save the palette state
     * <li>Save the active diagram
     * <li>Check the model integrity
     * <li>Save the models in the right files
     * </ol>
     * If one of these tasks fails, the save is cancelled and a message is send to the user.
     * 
     * @param monitor
     * @throws IntegrityException The model is not valid
     * @throws IOException An error occurred during save
     */
    protected void asyncSave(IProgressMonitor monitor) throws IntegrityException, IOException
    {
        monitor.beginTask("Save the diagrams", 5);

        // Step 1 : Save current states
        monitor.subTask("Save current state");
        saveDiagramSettings();
        savePaletteState();
        saveActiveDiagram();
        monitor.worked(1);
        // End Step 1

        // Step 2 : Check integrity
        if (needCheckIntegrity())
        {
            monitor.subTask("Check model integrity");
            IFile file = ((IFileEditorInput) getEditorInput()).getFile();
            try
            {
                IntegrityChecker.checkModelIntegrity(file, getResourceSet(), new SubProgressMonitor(monitor, 1));
            }
            catch (IOException ioe)
            {
                ModelerPlugin.log("The integrity check cannot be processed", IStatus.WARNING);
                ModelerPlugin.log(ioe);
            }
        }
        monitor.worked(1);
        // End Step 2

        // Step 3 : save resources
        monitor.subTask("Save files");
        saveResources(new SubProgressMonitor(monitor, 3));
        monitor.worked(3);
        // End Step 3
    }

    /**
     * Check whether it is necessary to check the model integrity on the ResourceSet.
     * 
     * @return <code>true</code> if the integrity check is necessary
     */
    protected boolean needCheckIntegrity()
    {
        return ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_CHECK_INTEGRITY);
    }

    /**
     * Save the resources from the current ResourceSet and add UUIDs if the preference is set
     * 
     * @param monitor The progress monitor
     * 
     * @throws IOException throws if a resource cannot be saved
     */
    protected void saveResources(IProgressMonitor monitor) throws IOException
    {
        monitor.beginTask("Save resources", getResourceSet().getResources().size());

        Map<String, String> options = getDefaultSaveOptions();

        // Save resources
        for (Resource resource : getResourceSet().getResources())
        {
            if (!ResourceUtils.isReadOnly(resource) && !getEditingDomain().isReadOnly(resource))
            {
                saveResource(resource, options);
            }
            monitor.worked(1);
        }

        monitor.done();
    }

    public void saveResource(Resource resource) throws IOException
    {
        saveResource(resource, getDefaultSaveOptions());
    }

    public void saveResource(Resource resource, Map< ? , ? > options) throws IOException
    {
        if (!readOnly)
        {
            if (ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_USE_UUID) && ResourceUtils.isModelResource(resource))
            {
                ResourceUtils.addUUID(resource.getContents().get(0));
            }
            resource.save(options);
        }
    }

    private Map<String, String> getDefaultSaveOptions()
    {
        Map<String, String> options = new HashMap<String, String>();
        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
        options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
        return options;
    }

    /**
     * @see org.eclipse.ui.part.EditorPart#doSaveAs()
     */
    public void doSaveAs()
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
     */
    protected void initializeGraphicalViewer()
    {
        restoreActiveDiagram();
        getGraphicalViewer().addDropTargetListener(new OutlineDropListener(getGraphicalViewer(), this));
        getGraphicalViewer().addDropTargetListener(new PaletteDropListener(getGraphicalViewer()));
    }

    /**
     * Update the palette contents with objects of the model that can be displayed in the current diagram.
     */
    protected void updatePaletteRoot()
    {
        if (getActiveConfiguration() != null)
        {
            PaletteRoot oldRoot = getEditDomain().getPaletteViewer().getPaletteRoot();
            getActiveConfiguration().getPaletteManager().updatePalette();
            PaletteRoot newRoot = getActiveConfiguration().getPaletteManager().getRoot();

            if (oldRoot != newRoot)
            {
                // Deselect previous active tool
                if (oldRoot != null)
                {
                    oldRoot.setDefaultEntry(null);
                    getEditDomain().getPaletteViewer().setActiveTool(null);
                }

                getEditDomain().setPaletteRoot(newRoot);
            }
        }
    }

    /**
     * Update the EditPartFactory used by the viewer to map Model element with edit parts.
     */
    protected void updateEditPartFactory()
    {
        if (getActiveConfiguration() != null)
        {
            EditPartFactory factory = getActiveConfiguration().getEditPartFactory();
            if (factory != null)
            {
                // Change the factory to the new one (specific to the active
                // diagram)
                getGraphicalViewer().setEditPartFactory(factory);
            }
        }
    }

    /**
     * Notify the configuration manager that the active diagram changed.
     */
    protected void updateConfiguration()
    {
        getConfigurationManager().setActiveDiagram(getActiveDiagram());
    }

    /**
     * Set the currently edited diagram
     * 
     * @param diagram the diagram to edit
     */
    public void setActiveDiagram(final Diagram diagram)
    {
        setActiveDiagram(null, null, diagram);
    }

    /**
     * Set the currently edited diagram
     * 
     * @param previousModeler the old modeler (containing the previous active diagram)
     * @param previousDiagram the previous active diagram
     * @param diagram the diagram to edit
     */
    public void setActiveDiagram(final Modeler previousModeler, final Diagram previousDiagram, final Diagram diagram)
    {
        if (Display.getCurrent() != Display.getDefault())
        {
            final Modeler currentModeler = this;
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    if (previousModeler == null && previousDiagram == null)
                    {
                        navigation.set(diagram);
                    }
                    else
                    {
                        navigation.set(previousModeler, previousDiagram, currentModeler, diagram);
                    }
                }
            });
        }
        else
        {
            if (previousModeler == null && previousDiagram == null)
            {
                navigation.set(diagram);
            }
            else
            {
                navigation.set(previousModeler, previousDiagram, this, diagram);
            }
        }
    }

    /**
     * Returns the diagram navigation
     * 
     * @return the navigation
     */
    public NavigationManager getNavigationManager()
    {
        return navigation;
    }

    /**
     * Save the active diagram in the Diagrams model
     */
    protected void saveActiveDiagram()
    {
        getDiagrams().setActiveDiagram(activeDiagram);
    }

    /**
     * Restore the active diagram stored the Diagrams model
     */
    protected void restoreActiveDiagram()
    {
        Diagram lastDiagram = getDiagrams().getActiveDiagram();
        if (lastDiagram == null)
        {
            lastDiagram = DiagramsUtils.getRootDiagram(getDiagrams());
        }
        setActiveDiagram(lastDiagram);
    }

    /**
     * Save the settings (viewport, zoom...) for the current diagram
     */
    protected void saveDiagramSettings()
    {
        if (activeDiagram != null && !readOnly)
        {
            // We do not use command because these modifications are
            // non-dirtying and non undoable
            RootEditPart root = getGraphicalViewer().getRootEditPart();
            if (root instanceof ScalableFreeformRootEditPart)
            {
                ScalableFreeformRootEditPart scalableRoot = (ScalableFreeformRootEditPart) root;
                // Save viewport
                Viewport viewPort = (Viewport) scalableRoot.getFigure();
                Point viewLoc = viewPort.getViewLocation();
                activeDiagram.setViewport(viewLoc);

                // Save Zoom
                ZoomManager zoomManager = scalableRoot.getZoomManager();
                double zoomLevel = zoomManager.getZoom();
                activeDiagram.setZoom(zoomLevel);
            }
        }
    }

    /**
     * Save the state of the diagram palette (pinned, expanded...)
     */
    protected void savePaletteState()
    {
        if (activeDiagram != null)
        {
            PaletteStateRecorder recorder = new PaletteStateRecorder();
            recorder.saveState(activeDiagram.getSemanticModel().getPresentation(), getPaletteViewer());
        }
    }

    /**
     * Restore the state of the diagram palette (pinned, expanded...)
     */
    protected void restorePaletteState()
    {
        if (activeDiagram != null)
        {
            PaletteStateRecorder recorder = new PaletteStateRecorder();
            recorder.restoreState(activeDiagram.getSemanticModel().getPresentation(), getPaletteViewer());
        }
    }

    /**
     * Restore the settings (viewport, zoom...) for the current diagram
     */
    protected void restoreDiagramSettings()
    {
        if (activeDiagram != null)
        {
            // We do not use command because these modifications are
            // non-dirtying and non undoable
            RootEditPart root = getGraphicalViewer().getRootEditPart();
            if (root instanceof ScalableFreeformRootEditPart)
            {
                ScalableFreeformRootEditPart scalableRoot = (ScalableFreeformRootEditPart) root;

                // Restore Zoom
                double zoomLevel = activeDiagram.getZoom();
                ZoomManager zoomManager = scalableRoot.getZoomManager();
                zoomManager.setZoom(zoomLevel);

                // Restore viewport
                Point viewLoc = activeDiagram.getViewport();
                if (viewLoc == null)
                {
                    viewLoc = new Point(0, 0);
                }
                Viewport viewPort = (Viewport) scalableRoot.getFigure();
                viewPort.setViewLocation(viewLoc);
            }
        }
    }

    /**
     * Change the current diagram
     * 
     * @param diagram the new current diagram
     */
    void changeActiveDiagram(Diagram diagram)
    {
        if (diagram != null && diagram.getSemanticModel() == null)
        {
            // diagram = n;
            // error case we set var to null to enable specific behavior
            // semantic model equals to null is the same as diagram equals to null
            // the sytem can manage diagram to null
            diagram = null;
        }
        saveDiagramSettings();
        savePaletteState();

        activeDiagram = diagram;

        // Update the active diagram configuration
        updateConfiguration();

        // Update the palette
        updatePaletteRoot();
        // Update the edit part factory
        updateEditPartFactory();
        // Update the GEF viewer
        getGraphicalViewer().setContents(diagram);

        restoreDiagramSettings();
        restorePaletteState();

        EditPart diagEP = (EditPart) getGraphicalViewer().getEditPartRegistry().get(diagram);
        if (diagEP != null)
        {
            getGraphicalViewer().select(diagEP);
        }
    }

    /**
     * Returns the currently edited diagram.
     * 
     * @return the edited diagram
     */
    public Diagram getActiveDiagram()
    {
        return activeDiagram;
    }

    /**
     * @see org.eclipse.ui.ISaveablePart#isDirty()
     */
    public boolean isDirty()
    {
        // delegate to the command stack
        return getCommandStack().isDirty();
    }

    /**
     * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
     */
    public boolean isSaveAsAllowed()
    {
        return false;
    }

    /**
     * Get the ResourceSet
     * 
     * @return ResourceSet
     */
    public ResourceSet getResourceSet()
    {
        ResourceSet resourceSet = null;
        if (getEditDomain() instanceof MixedEditDomain)
        {
            resourceSet = ((MixedEditDomain) getEditDomain()).getEMFEditingDomain().getResourceSet();
        }

        return resourceSet;
    }

    /**
     * Return the EObject root of a File
     * 
     * @param file the file to read
     * @return the root EObject the root object
     */
    protected EObject openFile(IFile file)
    {
        return openFile(file, true);
    }

    /**
     * Return the EObject root of a File
     * 
     * @param file the file to read
     * @param resolve indicates that all the references must be resolved
     * @return the root EObject the root object
     */
    protected EObject openFile(IFile file, boolean resolve)
    {
        ResourceSet resourceSet = getResourceSet();
        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        Resource resource = resourceSet.getResource(uri, true);
        if (resolve)
        {
            EcoreUtil.resolveAll(resourceSet);
        }
        return resource.getContents().get(0);
    }

    CrossReferenceAdapter crossReferenceAdapter = null;

    TypeCacheAdapter typeCacheAdapter = null;

    /**
     * Create and initialize the GEF-EMF EditDomain
     * 
     * @return the modeler EditDomain
     */
    protected MixedEditDomain createEditDomain()
    {
        MixedEditDomain mixedEditDomain = new MixedEditDomain(this);
        mixedEditDomain.setAdapterFactory(createAdapterFactory());
        // add adapters
        ResourceSet resourceSet = mixedEditDomain.getEMFEditingDomain().getResourceSet();
        if (CrossReferenceAdapter.getExistingDiagramsCrossReferenceAdapter(resourceSet) == null)
        {
            this.crossReferenceAdapter = new CrossReferenceAdapter();
            resourceSet.eAdapters().add(crossReferenceAdapter);
        }
        ITypeCacheAdapter existingTypeCacheAdapter = TypeCacheAdapter.getExistingTypeCacheAdapter(resourceSet);
        if (existingTypeCacheAdapter == null || !(existingTypeCacheAdapter instanceof TypeCacheAdapter))
        {
            this.typeCacheAdapter = new TypeCacheAdapter();
            resourceSet.eAdapters().add(typeCacheAdapter);
        }
        return mixedEditDomain;
    }

    /**
     * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
     */
    protected void setInput(IEditorInput input)
    {
        try
        {
            MixedEditDomain editDomain = createEditDomain();
            setEditDomain(editDomain);

            IFile file = ((IFileEditorInput) input).getFile();
            // currentFile is directly set at creation
            if (currentIFile == null)
            {
                currentIFile = file;
            }
            EObject modelInput = openFile(file);

            if (modelInput instanceof Diagrams)
            {
                // DiagramsUtils.updateDI((Diagrams) modelInput);

                diResource = modelInput.eResource();
                setPartName(file.getName());
                setContentDescription(file.getFullPath().toString());
                doSetInput(input);
            }
            else
            {
                ModelerPlugin.displayDialog("Topcased Editor open error", "The input is not a diagrams model.", IStatus.ERROR);
            }
        }
        catch (Exception e)
        {
            ModelerPlugin.displayDialog("Topcased Editor open error", "Unable to open editor. Please, check your input model.", IStatus.ERROR);
            ModelerPlugin.log(e);
        }
    }

    /**
     * Update the part name with correct read/write information
     * 
     * @param fileName the name of the edited file
     */
    protected void setPartName(String fileName)
    {
        String format;
        if (readOnly)
        {
            format = Messages.getString("Modeler.ReadEditorName");//$NON-NLS-1$
        }
        else
        {
            format = Messages.getString("Modeler.WriteEditorName");//$NON-NLS-1$
        }
        String correctPartName = NLS.bind(format, fileName);
        if (!correctPartName.equals(getPartName()))
        {
            super.setPartName(correctPartName);
        }
    }

    /**
     * @param input the IEditorInput
     * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
     */
    protected void doSetInput(IEditorInput input)
    {
        super.setInput(input);
    }

    /**
     * Sets the Diagrams model
     * 
     * @param diag the model object Diagrams
     */
    protected void setDiagrams(Diagrams diag)
    {
        this.diResource = diag.eResource();
    }

    /**
     * Close the editor
     * 
     * @param save
     */
    public void close(final boolean save)
    {
        Display display = getSite().getShell().getDisplay();
        display.asyncExec(new Runnable()
        {
            public void run()
            {
                getSite().getPage().closeEditor(Modeler.this, save);
            }
        });
    }

    /**
     * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    public void createPartControl(Composite parent)
    {
        try
        {
            super.createPartControl(parent);
        }
        catch (Throwable e)
        {
            ModelerPlugin.log(e);
            close(false);
            ModelerPlugin.displayDialog("Topcased Error", "Unable to open editor. Please check the input model.", IStatus.ERROR);

        }
    }

    /**
     * Delegates the method to the graphical viewer
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.
     *      ISelectionChangedListener)
     */
    public void addSelectionChangedListener(ISelectionChangedListener listener)
    {
        getGraphicalViewer().addSelectionChangedListener(listener);
    }

    /**
     * Delegates the method to the graphical viewer
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
     */
    public ISelection getSelection()
    {
        return getGraphicalViewer().getSelection();
    }

    /**
     * Delegates the method to the graphical viewer
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.
     *      ISelectionChangedListener)
     */
    public void removeSelectionChangedListener(ISelectionChangedListener listener)
    {
        getGraphicalViewer().removeSelectionChangedListener(listener);
    }

    /**
     * Delegates the method to the graphical viewer
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
     */
    public void setSelection(ISelection selection)
    {
        getGraphicalViewer().setSelection(selection);
    }

    /**
     * Gets the selected element in the outline.
     * 
     * @see DiagramsOutlinePage#getSelection()
     */
    public ISelection getOutlineSelection()
    {
        return diagramOutlinePage.getSelection();
    }

    /**
     * Sets the selection in the outline
     * 
     * @see DiagramsOutlinePage#setSelection(ISelection)
     */
    public void setOutlineSelection(ISelection selection)
    {
        diagramOutlinePage.setSelection(selection);
    }

    /**
     * Update the given element in the outline.
     * 
     * @param target
     * @see DiagramsOutlinePage#updateElement(Object)
     */
    public void updateOutlineElement(Object target)
    {
        if (diagramOutlinePage instanceof DiagramsOutlinePage)
        {
            ((DiagramsOutlinePage) diagramOutlinePage).updateElement(target);
        }
    }

    /**
     * Refresh the given element in the outline.
     * 
     * @param target
     * @see DiagramsOutlinePage#updateElement(Object)
     */
    public void refreshOutlineElement(Object target)
    {
        if (diagramOutlinePage instanceof DiagramsOutlinePage)
        {
            ((DiagramsOutlinePage) diagramOutlinePage).refreshElement(target);
        }
    }

    /**
     * Refresh the outline completely
     */
    public void refreshOutline()
    {
        if (diagramOutlinePage instanceof DiagramsOutlinePage)
        {
            ((DiagramsOutlinePage) diagramOutlinePage).refreshOutline();
        }
    }

    /**
     * Sets the selection in the property view.
     * 
     * @param selection the selected object
     * @see TabbedPropertySheetPage#selectionChanged(IWorkbenchPart, ISelection)
     */
    public void setPropertySelection(ISelection selection)
    {
        propertySheetPage.selectionChanged(this, selection);
    }

    /**
     * Get the preference store to use for this modeler.<br>
     * Clients should overrides this method to provide their specific modeler plugin preference store.<br>
     * The given preference store is used to store commons preferences as the 'Snap to geometry' , the 'Outline
     * sorters', the 'Outline filters', the 'Delete actions' options.<br>
     * Default implementation returns <code>null</code>.<br>
     * Constants to access this preferences can be accessed by the interface
     * {@link org.topcased.modeler.preferences.ModelerPreferenceConstants}.<br>
     * 
     * @return this modeler preference store.
     */
    public IPreferenceStore getPreferenceStore()
    {
        return null;
    }

    /**
     * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
     */
    public EditingDomain getEditingDomain()
    {
        EditingDomain emfEditingDomain = null;

        if (getEditDomain() instanceof MixedEditDomain)
        {
            emfEditingDomain = ((MixedEditDomain) getEditDomain()).getEMFEditingDomain();
        }

        return emfEditingDomain;
    }

    /**
     * @see org.eclipse.ui.ide.IGotoMarker#gotoMarker(org.eclipse.core.resources.IMarker)
     */
    public void gotoMarker(IMarker marker)
    {
        try
        {
            if (EValidator.MARKER.equals(marker.getType()))
            {
                String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
                if (uriAttribute != null)
                {
                    URI uri = URI.createURI(uriAttribute);
                    EObject eObject = getResourceSet().getEObject(uri, true);
                    if (eObject != null)
                    {
                        gotoEObject(eObject);
                    }
                }
            }
            else if (SynchronizedModelDiagramRulesManager.SYNCHRONIZED_MODEL_DIAGRAM_RULE_MARKER.equals(marker.getType()))
            {
                String uriAttribute = marker.getAttribute(SynchronizedModelDiagramRulesManager.URI_MARKER_ATTRIBUTE, null);
                if (uriAttribute != null)
                {
                    URI uri = URI.createURI(uriAttribute);
                    EObject graphObject = getResourceSet().getEObject(uri, true);
                    if (graphObject != null && graphObject instanceof GraphElement)
                    {
                        gotoGraphElement((GraphElement) graphObject);
                    }
                }
            }
            else if (TodoNoteBuilder.MARKER_TYPE.equals(marker.getType()))
            {
                String uriAttribute = marker.getAttribute(TodoNoteBuilder.URI_MARKER_ATTRIBUTE, null);
                if (uriAttribute != null)
                {
                    URI uri = URI.createURI(uriAttribute);
                    EObject eObject = getResourceSet().getEObject(uri, true);
                    if (eObject != null && eObject instanceof Property)
                    {
                        EObject container = ((Property) eObject).eContainer();
                        if (container instanceof GraphElement)
                        {
                            gotoGraphElement((GraphElement) container);
                        }
                    }
                }
            }
        }
        catch (CoreException exception)
        {
            ModelerPlugin.log(exception);
        }
    }

    /**
     * Sets the selection state for an editor to reveal the position of the given EObject.<br>
     * It searches in the different diagrams the occurrences of the EObject and ask the user to select the destination
     * if the given EObject has several graphical representation.
     * 
     * @param eObject the EObject to select
     */
    public void gotoEObject(EObject eObject)
    {
        List<EObject> arrayList = new ArrayList<EObject>(1);
        arrayList.add(eObject);
        gotoEObjects(arrayList,true);
    }
    
    /**
     * Sets the selection state for an editor to reveal the position of the given EObject.<br>
     * It searches in the different diagrams the occurrences of the EObject and ask the user to select the destination
     * if the given EObject has several graphical representation.
     * 
     * @param eObject the EObject to select
     */
    public void gotoEObjects(List<EObject> eobjects, boolean reveal)
    {
        List<GraphElement> elements = new ArrayList<GraphElement>(eobjects.size());
        Diagrams chosenDiagrams = null ;
        for (EObject eObject : eobjects)
        {
            if (eObject != null)
            {
                GraphElement[] elts;
                
                // Is the EObject a graphical node itself ?
                if (eObject instanceof GraphElement)
                {
                    elts = new GraphElement[1];
                    elts[0] = (GraphElement) eObject;
                }
                else
                {
                    if (chosenDiagrams == null)
                    {
                        elts = Utils.getGraphElements(getDiagrams(), eObject);
                    }
                    else
                    {
                        elts = Utils.getGraphElements(chosenDiagrams, eObject);
                    }
                }
                
                if (elts.length > 0)
                {
                    GraphElement graphElt = null;
                    if (chosenDiagrams == null)
                    {
                        graphElt = chooseGraphElement(elts);
                        chosenDiagrams = getDiagrams(graphElt);
                    }
                    else
                    {
                        for (GraphElement g : elts)
                        {
                            if (getDiagrams(g) == chosenDiagrams)
                            {
                                graphElt = g ;
                                break ;
                            }
                        }
                    }
                    elements.add(graphElt);
                }
                // Do not try to display a GraphElement in the outline
                // as it is not represented there
                else if (!(eObject instanceof GraphElement) && (diagramOutlinePage != null))
                {
                    diagramOutlinePage.setFocus();
                }
            }
        }
        if (reveal)
        {
            gotoGraphElements(elements);
        }
        diagramOutlinePage.setSelection(new StructuredSelection(eobjects.toArray()));
    }

    private Diagrams getDiagrams(GraphElement graphElt)
    {
        EObject tmp = graphElt ;
        while (tmp != null && !(tmp instanceof Diagrams))
        {
            tmp = tmp.eContainer();
        }
        return (Diagrams) tmp;
    }

    /**
     * Sets the selection state for an editor to reveal the position of the given GraphElement.<br>
     * It searches in the different diagrams the occurrences of the GraphElement and select the graphical
     * representation.
     * 
     * @param pGraphElt the GraphElement to select
     */
    protected final void gotoGraphElements(List<GraphElement> pGraphElts)
    {
        int i = 0 ;
        for (GraphElement pGraphElt : pGraphElts)
        {
            if (pGraphElt != null)
            {
                if (pGraphElt instanceof Diagram)
                {
                    if (i == 0)
                    {
                        setActiveDiagram((Diagram) pGraphElt);
                    }
                }
                else
                {
                    if (i == 0)
                    {
                        setActiveDiagram(Utils.getDiagram(pGraphElt.getContainer()));
                    }
                }
                EditPart editPart = (EditPart) getGraphicalViewer().getEditPartRegistry().get(pGraphElt);
                if (editPart != null)
                {
                    // BUGFIX #344 Scroll to the selected object
                    ((GraphicalEditPart) getGraphicalViewer().getRootEditPart()).getFigure().validate();
                    if (i == 0)
                    {
                        getGraphicalViewer().reveal(editPart);
                        getGraphicalViewer().select(editPart);
                    }
                    else
                    {
                        getGraphicalViewer().appendSelection(editPart);
                    }
                }
            }
            i++;
        }
    }
    
    /**
     * Sets the selection state for an editor to reveal the position of the given GraphElement.<br>
     * It searches in the different diagrams the occurrences of the GraphElement and select the graphical
     * representation.
     * 
     * @param pGraphElt the GraphElement to select
     */
    protected final void gotoGraphElement(GraphElement pGraphElt)
    {
        List<GraphElement> arrayList = new ArrayList<GraphElement>(1);
        arrayList.add(pGraphElt);
        gotoGraphElements(arrayList);
    }

    /**
     * Returns the destination GraphElement from a choices list
     * 
     * @param elements the list of available GraphElements
     * @return the selected GraphElement
     */
    private GraphElement chooseGraphElement(GraphElement[] elements)
    {
        GraphElement chosenElt = null;
        if (elements.length == 1)
        {
            chosenElt = elements[0];
        }
        else
        {
            ChooseGraphElementDialog dialog = new ChooseGraphElementDialog(getSite().getShell(), getEditDomain(), elements);

            if (dialog.open() == Window.OK)
            {
                Object[] selection = dialog.getResult();

                if (selection != null && selection.length > 0)
                {
                    chosenElt = (GraphElement) selection[0];
                }
            }
        }

        return chosenElt;
    }

    /**
     * Returns the manager for the different diagram configurations.
     * 
     * @return the manager
     */
    protected ModelerConfigurationManager getConfigurationManager()
    {
        if (configurationManager == null)
        {
            configurationManager = new ModelerConfigurationManager();
        }
        return configurationManager;
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
     */
    public String getContributorId()
    {
        return "org.topcased.modeler.editor.Modeler";
    }

    /**
     * Return the selected file in the current editor
     * 
     * @return IFile
     */
    public static IFile getCurrentIFile()
    {
        return currentIFile;
    }

    /**
     * Return the editorID associated with this Topcased modeler. This ID is the same given in the editor extension.
     * 
     * @return String an ID identifying the editor
     */
    public abstract String getId();

    @Override
    public void setFocus()
    {
        super.setFocus();
    }

    /**
     * @see org.eclipse.gef.ui.parts.GraphicalEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException
    {
        super.init(site, input);
        // Test if the editorInput is in the workspace
        if (!(input instanceof IFileEditorInput))
        {
            throw new PartInitException("Cannot open file. The file must be in the workspace");
        }

        /*
         * Read only resources
         */
        checkReadOnlyResources();
        // add listener to refresh read-only resources list very often
        getSite().getPage().addPartListener(partListener);

        /*
         * Resources opened in write mode
         */
        ((TopcasedAdapterFactoryEditingDomain) getEditingDomain()).refreshOpenedResources(true);
        if (checkOpenedResources())
        {
            // New feature read only mode
            setIsReadOnly(true, true);
        }
        // End Fix #1405
        ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
        if (getEditingDomain() instanceof TopcasedAdapterFactoryEditingDomain)
        {
            TopcasedAdapterFactoryEditingDomain domain = (TopcasedAdapterFactoryEditingDomain) getEditingDomain();
            domain.addRefreshRunnable(new Runnable()
            {
                public void run()
                {
                    if (checkOpenedResources())
                    {
                        // read only mode
                        setIsReadOnly(true, true);
                    }
                }
            });
        }
    }

    /**
     * Ensure read-only status of resources is correctly cached and inform the user if there are some read-only files.
     */
    private void checkReadOnlyResources()
    {
        // ensure read-only status of all resources is correctly cached.
        List<String> readOnlyResources = new ArrayList<String>();
        for (Resource resource : getResourceSet().getResources())
        {
            if (resource.getURI().isPlatformResource() && ((TopcasedAdapterFactoryEditingDomain) getEditingDomain()).isReadOnly(resource))
            {
                if (resource.getURI().lastSegment() != null)
                {
                    readOnlyResources.add(resource.getURI().lastSegment());
                }
            }
        }
        if (isDisplayReadOnlyResourcesMessage())
        {
            // display information popup if at least one resource is read only
            ReadOnlyResourcesDialog dialog = new ReadOnlyResourcesDialog(ModelerPlugin.getActiveWorkbenchShell(), readOnlyResources);
            dialog.open();
        }
    }

    /**
     * Check whether some used resources are already opened in a writing editor.
     * 
     * @return true if some resources are already written
     */
    private boolean checkOpenedResources()
    {
        // Fix #1405
        // Test if there are already opened resources
        Map<String, List<String>> alreadyOpennedResources = getAlreadyOpenedResources(getResourceSet().getResources(), diResource);
        if (!alreadyOpennedResources.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Set the read mode or write mode.
     * 
     * @param newReadOnly true for read mode
     * @param printUserMessages true for displaying messages to the user
     */
    protected void setIsReadOnly(boolean newReadOnly, boolean printUserMessages)
    {
        boolean wasReadOnly = readOnly;
        readOnly = newReadOnly;
        if (readOnly != wasReadOnly && readOnly)
        {
            // empty command stack to disable redo
            getCommandStack().flush();
        }
        if (getEditingDomain() instanceof TopcasedAdapterFactoryEditingDomain)
        {
            TopcasedAdapterFactoryEditingDomain domain = (TopcasedAdapterFactoryEditingDomain) getEditingDomain();
            domain.setTotalReadOnly(newReadOnly);
        }
        // update part name with correct read/write information
        setPartName(getEditorInput().getName());

        if (printUserMessages && !wasReadOnly && readOnly && isDisplayReadOnlyMessage())
        {
            String title = Messages.getString("Modeler.ReadModeDialog.Title");//$NON-NLS-1$
            String message = Messages.getString("Modeler.ReadModeDialog.Message");//$NON-NLS-1$
            message = NLS.bind(message, System.getProperty("line.separator"));//$NON-NLS-1$
            InformationDialog dialog = new InformationDialog(getSite().getShell(), title, message, ModelerPlugin.getDefault().getPreferenceStore(), ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY);
            dialog.open();
        }
    }

    /**
     * Set the read mode or write mode (no message is printed to the user).
     * 
     * @param newReadOnly true for read mode
     */
    protected void setIsReadOnly(boolean newReadOnly)
    {
        setIsReadOnly(newReadOnly, false);
    }

    // Fix #772
    /**
     * Refresh the graphical viewer of the active diagram.
     */
    public void refreshActiveDiagram()
    {
        // Update the GEF viewer
        getGraphicalViewer().setContents(getActiveDiagram());
    }

    // EndFix #772

    /**
     * @param resources The resources list
     * @param diResource2
     * @return The readonly resource
     */
    private Map<String, List<String>> getAlreadyOpenedResources(EList<Resource> resources, Resource current)
    {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        for (Resource resource : resources)
        {
            if (((TopcasedAdapterFactoryEditingDomain) getEditingDomain()).isAlreadyOpened(resource) && resource != current)
            {
                result.put(resource.getURI().toString(), ((TopcasedAdapterFactoryEditingDomain) getEditingDomain()).getAlreadyOpenedEditors(resource));
            }
        }
        return result;
    }

    public boolean isReadOnly()
    {
        return readOnly;
    }

    /**
     * Determine if a popup will be displayed when an editor will be opened in read only mode
     * 
     * @param iDisplayReadOnlyMessage
     */
    public static void setDisplayReadOnlyMessage(boolean iDisplayReadOnlyMessage)
    {
        displayReadOnlyMessage = iDisplayReadOnlyMessage;
    }

    public static boolean isDisplayReadOnlyMessage()
    {
        return displayReadOnlyMessage;
    }

    /**
     * Determine if a popup will be displayed when an editor will be opened with read only resources
     * 
     * @param isMessageDisplayed true to display message
     */
    public static void setDisplayReadOnlyResourcesMessage(boolean isMessageDisplayed)
    {
        displayReadOnlyResourcesMessage = isMessageDisplayed;
    }

    /**
     * Check whether read only resources message is displayed or temporarily disabled
     * 
     * @return true if message shall be displayed
     */
    public static boolean isDisplayReadOnlyResourcesMessage()
    {
        return displayReadOnlyResourcesMessage;
    }

    /**
     * Class to unload resource in a resource set
     */
    private class UnloadJob extends Job
    {

        private ResourceSet resSet = null;

        public UnloadJob(ResourceSet set)
        {
            super("Unload Model");
            resSet = set;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor)
        {
            if (monitor == null)
            {
                monitor = new NullProgressMonitor();
            }
            try
            {
                if (resSet != null)
                {
                    monitor.beginTask("unload ...", resSet.getResources().size());
                    for (Resource r : resSet.getResources())
                    {
                        try
                        {
                            r.unload();
                        }
                        catch (Exception e)
                        {
                            ModelerPlugin.log(e);
                        }

                        monitor.worked(1);

                    }
                    try
                    {
                        // FIXME the catch of the Exception does not ensure that the list of adapters is correctly
                        // cleared
                        resSet.eAdapters().clear();
                    }
                    catch (Exception e)
                    {
                        ModelerPlugin.log(new Status(IStatus.WARNING, ModelerPlugin.getId(), e.getMessage(), e));
                    }
                    if (crossReferenceAdapter != null)
                    {
                        crossReferenceAdapter.dispose();
                    }
                    if (typeCacheAdapter != null)
                    {
                        typeCacheAdapter.dispose();
                    }
                    System.gc();
                }
            }
            finally
            {
                monitor.done();
            }
            return Status.OK_STATUS;
        }

    }
}