/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 * Thibault Landr� (Atos Origin) - Fix #772
 * Tristan FAURE - Custom filter
 ******************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IViewerNotification;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.HelpEvent;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.IPageSite;
import org.topcased.modeler.actions.DuplicateDiagramAction;
import org.topcased.modeler.actions.DuplicateSubTreeAction;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.dialogs.HelpDialog;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.outline.filters.actions.FiltersAction;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.extensions.OutlineManager;
import org.topcased.modeler.extensions.OutlineManager.CreateChildMenuConfiguration;
import org.topcased.modeler.extensions.OutlineManager.FilterConfiguration;
import org.topcased.modeler.extensions.RegisteredModelMenu;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.CreateDiagramAction;
import org.topcased.modeler.internal.actions.DeleteAction;
import org.topcased.modeler.internal.actions.DisableExportedStatusAction;
import org.topcased.modeler.internal.actions.ExportSubmodelAction;
import org.topcased.modeler.internal.actions.ImportFromModelAction;
import org.topcased.modeler.internal.actions.ImportSubmodelAction;
import org.topcased.modeler.internal.actions.ModelerControlAction;
import org.topcased.modeler.internal.actions.ModelerUncontrolAction;
import org.topcased.modeler.internal.actions.UpdateCacheAction;
import org.topcased.modeler.internal.collaboration.ExportUtil;
import org.topcased.modeler.internal.ordering.IOrder.OrderException;
import org.topcased.modeler.internal.ordering.OrderManager;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.ForwardingLabelDecorator;
import org.topcased.modeler.utils.ResourceUtils;
import org.topcased.modeler.utils.Utils;

/**
 * <b>Model navigator :</b><br>
 * Display the model as a tree and fill the contextual menu with diagrams and EMF actions. <br>
 * creation : 30 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ModelNavigator extends Composite implements IMenuListener
{

    private static final String EANNOTATION_TO_HIDE_IN_OUTLINE = "org.topcased.modeler.eannotationToHideInOutline";

    private Modeler modeler;

    private TreeViewer viewer;

    private IPageSite site;

    private IMenuManager loadMenu;

    private ModelerControlAction controlAction;

    private ModelerUncontrolAction uncontrolAction;

    private ExportSubmodelAction exportAction;

    private ImportSubmodelAction importAction;

    private ImportFromModelAction importFromModelAction;

    private UpdateCacheAction updateCacheAction;

    private DisableExportedStatusAction disableExportStatusAction;

    private static Set<String> eannotationsSourcesToHide = getSourcesToHide();

    private static AtomicBoolean noRefresh = new AtomicBoolean(false);

    /**
     * In some cases we want to disable the viewer refresh, this method can.
     * To use with precaution
     * 
     * @param value
     */
    public static void setNoRefresh(boolean value)
    {
        noRefresh.set(value);
    }

    public static boolean getNoRefresh()
    {
        return noRefresh.get();
    }

    private static final ViewerFilter staticEannotationFilter = new ViewerFilter()
    {

        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element)
        {
            if (Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_DISPLAY_HIDDEN_EANNOTATION))
            {
                return true;
            }
            if (element instanceof EAnnotation)
            {
                EAnnotation eannotation = (EAnnotation) element;
                return !eannotationsSourcesToHide.contains(eannotation.getSource());
            }
            return true;
        }
    };

    private Adapter modelListener = new AdapterImpl()
    {
        /**
         * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        @Override
        public void notifyChanged(Notification msg)
        {
            refreshViewer(true);
        }
    };

    private CustomSearchFilter customSearchFilter;

    private boolean searchField = true;

    private HistoryContentAssistTextField autoCompletionTextField;

    private ModelContentProvider modelContentProvider;

    private boolean displayedOnce = false;

    /**
     * This content provider filters the event from graphical object to only refresh when it's needed.
     * 
     * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
     */
    protected class NavigatorAdapterFactoryContentProvider extends AdapterFactoryContentProvider
    {
        /**
         * Constructor
         * 
         * @param adapterFactory the factory
         */
        public NavigatorAdapterFactoryContentProvider(AdapterFactory adapterFactory)
        {
            super(adapterFactory);
        }

        /**
         * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#notifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        @Override
        public void notifyChanged(Notification notification)
        {
            if (noRefresh.get())
            {
                return;
            }
            if (notification instanceof IViewerNotification)
            {
                Object element = ((IViewerNotification) notification).getElement();
                if (element instanceof Diagrams)
                {
                    // A diagram or a Diagrams is added or removed : refresh the
                    // whole tree
                    refreshViewer((Diagrams) element, true);
                    refreshViewer(((Diagrams) element).getModel(), true);
                }
                else if (!(element instanceof DiagramElement))
                {
                    super.notifyChanged(notification);
                }
                else if (element instanceof Diagram && ((IViewerNotification) notification).isLabelUpdate())
                {
                    // it s just a label update so we just refresh diagram
                    refreshViewer(Utils.getElement((GraphElement) element), true);
                    EObject container = ((Diagram) element).eContainer();
                    if (container != null)
                    {
                        refreshViewer(container, true);
                    }

                }
                else if (element instanceof Diagram && ((IViewerNotification) notification).isContentRefresh())
                {
                    // A diagram or a Diagrams is added or removed : refresh the
                    // whole tree
                    refreshViewer(true);
                }
            }
            else
            {
                super.notifyChanged(notification);
            }
        }

        @Override
        public Object[] getChildren(Object object)
        {
            Object[] initialResult = super.getChildren(object);
            if (object instanceof EObject)
            {
                try
                {
                    if (OrderManager.isVirtualOrder())
                    {
                        List<EObject> orderForAnElement = OrderManager.getOrderForAnElementAndElementsNotOrdered((EObject) object);
                        if (orderForAnElement != null)
                        {
                            return orderForAnElement.toArray();
                        }
                    }
                }
                catch (OrderException e)
                {
                }
            }
            return initialResult;
        }

    }

    /**
     * Constructor
     * 
     * @param parent the parent composite
     * @param editor the modeler to edit as tree
     * @param pageSite the site
     */
    public ModelNavigator(Composite parent, Modeler editor, IPageSite pageSite, boolean searchField)
    {
        super(parent, SWT.BORDER);
        modeler = editor;
        site = pageSite;
        GridLayout gl = new GridLayout(2, false);
        gl.marginHeight = 0;
        gl.marginWidth = 0;
        setLayout(gl);
        this.searchField = searchField;
        createContents(this);
        displayedOnce  = true;
    }

    private static Set<String> getSourcesToHide()
    {
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EANNOTATION_TO_HIDE_IN_OUTLINE);
        Set<String> result = new HashSet<String>(elements.length);
        for (IConfigurationElement c : elements)
        {
            result.add(c.getAttribute("source"));
        }
        return result;
    }

    /**
     * Constructor
     * 
     * @param parent the parent composite
     * @param editor the modeler to edit as tree
     * @param pageSite the site
     */
    public ModelNavigator(Composite parent, Modeler editor, IPageSite pageSite)
    {
        this(parent, editor, pageSite, true);
    }

    /**
     * Returns the modeler
     * 
     * @return the modeler
     */
    protected Modeler getModeler()
    {
        return modeler;
    }

    /**
     * Returns the TreeViewer used as navigator
     * 
     * @return the navigable tree
     */
    public TreeViewer getTreeViewer()
    {
        return viewer;
    }

    /**
     * Create the contents of the widget
     * 
     * @param parent the current widget
     */
    protected void createContents(Composite parent)
    {
        viewer = new TreeViewer(parent, SWT.MULTI)
        {

            @Override
            protected void handleDispose(DisposeEvent event)
            {
                if (modelContentProvider != null && viewer != null)
                {
                    viewer.setSelection(new StructuredSelection(modelContentProvider.getAdditionalResources()));
                }
                super.handleDispose(event);
            }

        };
        viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        viewer.setUseHashlookup(true);
        initDragAndDrop();
        initProviders();
        initFilters();
        hookListeners();
        hookKeyListeners();

        // Add our custom ElementComparer that unwrap model objects before the
        // comparison
        viewer.setComparer(new ModelElementComparer());
        viewer.setInput(modeler.getDiagrams());
        createContextMenu(viewer);

        // create filter area
        createFilterArea(parent);
        refreshViewer();
    }

    protected void createFilterArea(Composite parent)
    {
        if (!searchField)
        {
            return;
        }
        final Text text = new Text(parent, SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        autoCompletionTextField = new HistoryContentAssistTextField(text, new TextContentAdapter());
        // final Text text = autoCompletionTextField.getText();
        text.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                if (e.character == SWT.CR || e.character == SWT.KEYPAD_CR)
                {
                    if (text.getText() != null && text.getText().length() > 0)
                    {
                        autoCompletionTextField.addString(text.getText());
                    }
                }
                else
                {
                    autoCompletionTextField.refreshProposals(text.getText());
                }
            }
        });
        customSearchFilter = new CustomSearchFilter(viewer, text);
        text.addKeyListener(customSearchFilter);
        text.addSelectionListener(new SelectionAdapter()
        {
            public void widgetDefaultSelected(SelectionEvent e)
            {
                if (e.detail == SWT.CANCEL)
                {
                    customSearchFilter.clear();
                }
            }
        });
        text.setToolTipText("press F1 in the text field to have help for this component");
        text.addHelpListener(new HelpListener()
        {
            public void helpRequested(HelpEvent e)
            {
                String description = "<form>" + "This component allows you to filter the outline on specific criteria:"
                        + "<p><b>text</b>: the outline displays all the elements containing an attribute containing the text</p>"
                        + "<p><b>:type</b>: the outline displays all the elements typed with the given type</p>"
                        + "<p><b>?attribute1:text</b>: the outline displays all the elements where the attribute {attribute1} contains the given text</p>"
                        + "<p><b>?attribute1,attribute2:text</b>: the outline displays all the elements where the attribute {attribute1} or {attribute2} contains the given text</p>"
                        + "<p><b>#text</b>: the outline displays all the elements with uri fragment equals to the given text</p>" + "<p>To enable the search please press Carriage Return</p>"
                        + "<p>To disable the filter erase your text and press Carriage Return</p>" + "</form>";
                HelpDialog dialog = new HelpDialog(new Shell(Display.getDefault()), text.toDisplay(text.getCaretLocation()), "Help", description);
                dialog.open();
            }
        });
        viewer.addFilter(customSearchFilter.getFilter());
        text.setMessage("search ...");
        text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        final Button caseSensitive = new Button(parent, SWT.CHECK);
        caseSensitive.setText("case sensitive");
        caseSensitive.addSelectionListener(new SelectionListener()
        {
            public void widgetSelected(SelectionEvent e)
            {
                customSearchFilter.setCaseSensitive(caseSensitive.getSelection());
            }

            public void widgetDefaultSelected(SelectionEvent e)
            {
            }
        });
    }

    /**
     * Add drag and drop ability between the outline to the editor and inside the outline This method should be overiden
     * by subclasses to define new policy of Drop and Drag support
     */
    protected void initDragAndDrop()
    {
        Transfer[] transfers = new Transfer[] {OutlineToDiagramTransfer.getInstance(), LocalTransfer.getInstance()};
        int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
        viewer.addDragSupport(dndOperations, transfers, getOutlineDragAdapter(viewer));

        int dndOperationsOutline = DND.DROP_MOVE | DND.DROP_LINK;
        viewer.addDropSupport(dndOperationsOutline, transfers, getOutlineToOutlineDropAdapter(modeler, viewer));

    }

    protected OutlineDragAdapter getOutlineDragAdapter(TreeViewer viewer)
    {
        return new OutlineDragAdapter(viewer);
    }

    protected OutlineToOutlineDropAdapter getOutlineToOutlineDropAdapter(Modeler modeler, TreeViewer viewer)
    {
        return new OutlineToOutlineDropAdapter(modeler, viewer);
    }

    protected static class ModelLabelDecorator extends ForwardingLabelDecorator
    {
        public ModelLabelDecorator(ILabelDecorator delegate)
        {
            super(delegate);
        }

        @Override
        public String decorateText(String text, Object element)
        {
            if (element instanceof EObject)
            {
                EObject obj = (EObject) element;
                if (AdapterFactoryEditingDomain.isControlled(obj) && ExportUtil.isExported(obj.eResource()))
                {
                    return super.decorateText(text, element) + " [exported]";
                }
            }
            return super.decorateText(text, element);
        }

    }

    /**
     * Set the tree providers for the outline
     */
    protected void initProviders()
    {
        AdapterFactoryContentProvider adapterContentProvider = new NavigatorAdapterFactoryContentProvider(modeler.getAdapterFactory());
        adapterContentProvider.inputChanged(viewer, null, null);
        modelContentProvider = new ModelContentProvider(modeler, adapterContentProvider);
        viewer.setContentProvider(modelContentProvider);

        ModelLabelProvider labelProvider = new ModelLabelProvider(new AdapterFactoryLabelProvider(modeler.getAdapterFactory()), modeler.getEditingDomain());
        ILabelDecorator labelDecorator = ModelerPlugin.getDefault().getWorkbench().getDecoratorManager().getLabelDecorator();
        ILabelProvider fullLabelProvider = new DecoratingLabelProvider(labelProvider, new ModelLabelDecorator(labelDecorator));
        viewer.setLabelProvider(fullLabelProvider);
    }

    /**
     * Set the tree filters for the outline
     * 
     */
    protected void initFilters()
    {
        IPreferenceStore ps = modeler.getPreferenceStore();
        Collection<FilterConfiguration> configs = FiltersAction.getFilterConfigurations(ps != null ? ps.getString(ModelerPreferenceConstants.FILTERS_PREF) : "");

        for (Iterator<FilterConfiguration> it = configs.iterator(); it.hasNext();)
        {
            FilterConfiguration config = it.next();
            viewer.addFilter(config.getFilter());
        }
        addAll(viewer, getStaticFilters());

    }

    public static void addAll(TreeViewer viewer, List<ViewerFilter> filters)
    {
        for (ViewerFilter f : filters)
        {
            viewer.addFilter(f);
        }
    }

    /**
     * A list of filter always used. If you remove all the filters please add these
     * 
     * @return
     */
    public static List<ViewerFilter> getStaticFilters()
    {
        List<ViewerFilter> result = new LinkedList<ViewerFilter>();
        result.add(staticEannotationFilter);
        return result;
    }

    /**
     * Add listeners : <br>
     * - on the model<br>
     */
    protected void hookListeners()
    {
        modeler.getResourceSet().eAdapters().add(modelListener);
    }

    /**
     * Remove listeners
     */
    protected void unhookListeners()
    {
        modeler.getResourceSet().eAdapters().remove(modelListener);
    }

    /**
     * Add a key listener to the tree control. When a key is released, the DELETE key is filtered to fire the action.
     */
    protected void hookKeyListeners()
    {
        KeyListener keyListener = new KeyListener()
        {

            public void keyPressed(KeyEvent e)
            {
                // Do nothing
            }

            public void keyReleased(KeyEvent e)
            {
                if (e.keyCode == SWT.DEL)
                {
                    IAction deleteAction = createDeleteAction();
                    deleteAction.run();
                }
            }

        };
        viewer.getControl().addKeyListener(keyListener);
    }

    /**
     * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
     * 
     * @param sViewer the tree viewer
     */
    protected void createContextMenu(StructuredViewer sViewer)
    {
        MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
        contextMenu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
        contextMenu.setRemoveAllWhenShown(true);
        contextMenu.addMenuListener(this);
        Menu menu = contextMenu.createContextMenu(viewer.getControl());
        sViewer.getControl().setMenu(menu);
        site.registerContextMenu(getClass().getName(), contextMenu, viewer);
    }

    /**
     * Get the resource associated with the given selected object
     * 
     * @param selection the selected object
     * @return the EMF resource
     */
    private Resource getResourceFromSelection(Object selection)
    {
        Resource resource = null;

        if (selection instanceof EObject)
        {
            resource = ((EObject) selection).eResource();
        }
        else if (selection instanceof Resource)
        {
            resource = (Resource) selection;
        }
        else if (selection instanceof IWrapperItemProvider || selection instanceof FeatureMap.Entry)
        {
            resource = ((EObject) AdapterFactoryEditingDomain.unwrap(selection)).eResource();
        }

        return resource;
    }

    /**
     * This implements {@link org.eclipse.jface.action.IMenuListener}to help fill the context menus with contributions
     * from the Edit menu.
     * 
     * @param menuManager the menu to fill
     */
    public void menuAboutToShow(IMenuManager menuManager)
    {

        // Add our standard marker.
        //
        menuManager.add(new Separator(IOutlineMenuConstants.NEW_GROUP));
        menuManager.add(new Separator(IOutlineMenuConstants.EDIT_GROUP));
        menuManager.add(new Separator(IOutlineMenuConstants.ADDITIONS_GROUP));
        menuManager.add(new Separator(IOutlineMenuConstants.PROPERTIES_GROUP));
        menuManager.add(new Separator(IOutlineMenuConstants.ADDITIONS_END_GROUP));

        IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();

        Object currentSel = sel.getFirstElement();
        Resource resource = getResourceFromSelection(currentSel);

        // Create context menu if the resource associated to the current
        // selection is writable.
        if (currentSel instanceof AdditionalResources || resource != null && !ResourceUtils.isReadOnly(resource))
        {
            if (sel.size() == 1)
            {
                Object selection = sel.getFirstElement();
                createSingleSelectionMenu(menuManager, selection);
            }

            createMultiSelectionMenu(menuManager, sel);
        }

        if (loadMenu == null)
        {
            IMixedEditDomain domain = (IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class);
            String metamodelURI = modeler.getDiagrams().getModel().eClass().getEPackage().getNsURI();
            loadMenu = new RegisteredModelMenu("Load", domain.getEMFEditingDomain(), metamodelURI);
        }
        menuManager.add(loadMenu);
    }

    /**
     * Add to the MenuManager the actions for a multiple selection.
     * 
     * @param manager The menu to fill
     * @param selection the selection
     */
    protected void createMultiSelectionMenu(IMenuManager manager, IStructuredSelection selection)
    {

        IMixedEditDomain domain = (IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class);
        if (domain != null)
        {
            // Add the delete from model action
            DeleteAction deleteAction = new DeleteAction(domain, modeler.getDiagrams(), selection);
            manager.appendToGroup(IOutlineMenuConstants.EDIT_GROUP, deleteAction);

            // Add load resource action
            LoadResourceAction loadAction = new LoadResourceAction(domain.getEMFEditingDomain());
            manager.appendToGroup(IOutlineMenuConstants.ADDITIONS_GROUP, loadAction);
        }
    }

    /**
     * Add to the MenuManager the actions for a single object.
     * 
     * @param manager The menu to fill
     * @param selection the selected object
     */
    protected void createSingleSelectionMenu(IMenuManager manager, Object selection)
    {
        EObject selectedObject = null;

        if (selection instanceof EObject)
        {
            selectedObject = (EObject) selection;
        }
        else if (selection instanceof IWrapperItemProvider || selection instanceof FeatureMap.Entry)
        {
            selectedObject = (EObject) AdapterFactoryEditingDomain.unwrap(selection);
        }

        // The following menu are disable for the diagram objects
        if (selectedObject != null && !(selectedObject instanceof DiagramElement))
        {
            createEMFMenu(manager, selectedObject);
            createDiagramsMenu(manager, selectedObject);
            createControlActions(manager);
            createDuplicateSubtreeAction(manager, selectedObject);
        }
        else if (selectedObject instanceof Diagram)
        {
            createManageDiagramMenu(manager, (Diagram) selectedObject);
        }

    }

    /**
     * Add the menu for duplicate subtree action
     */
    private void createDuplicateSubtreeAction(IMenuManager manager, EObject selectedObject)
    {
        if (selectedObject.eContainer() != null)
        {
            DuplicateSubTreeAction duplicateSubTreeAction = new DuplicateSubTreeAction(modeler, selectedObject);
            manager.appendToGroup(IOutlineMenuConstants.EDIT_GROUP, duplicateSubTreeAction);
        }
    }

    /**
     * Compute the actions that should be present when a Diagram is selected in the outline
     * 
     * @param manager the menu manager associated with the outline
     * @param selectedDiagram the current selected Diagram
     */
    protected void createManageDiagramMenu(IMenuManager manager, Diagram selectedDiagram)
    {
        DuplicateDiagramAction duplicateDiagramAction = new DuplicateDiagramAction((IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class), selectedDiagram);
        manager.appendToGroup(IOutlineMenuConstants.EDIT_GROUP, duplicateDiagramAction);
    }

    private void createDiagramsMenu(IMenuManager manager, EObject selectedObject)
    {
        if (!isDiagramsMenuEnabledFor(selectedObject))
        {
            return;
        }
        MenuManager submenuManager = new MenuManager("Add diagram");

        DiagramDescriptor[] diagramDescriptors = DiagramsManager.getInstance().getDiagrams();
        for (int i = 0; i < diagramDescriptors.length; i++)
        {
            if (diagramDescriptors[i].canCreateDiagramOn(selectedObject, modeler.getId()))
            {
                CreateDiagramAction action = new CreateDiagramAction(modeler, selectedObject, diagramDescriptors[i]);
                submenuManager.add(action);
            }
        }

        manager.appendToGroup(IOutlineMenuConstants.NEW_GROUP, submenuManager);
    }

    private void createEMFMenu(IMenuManager manager, EObject selectedObject)
    {

        if (!isEMFMenuEnabledFor(selectedObject))
        {
            return;
        }

        IMixedEditDomain domain = (IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class);

        if (domain != null)
        {
            IPreferenceStore ps = modeler.getPreferenceStore();
            if (ps != null)
            {
                String id = ps.getString(ModelerPreferenceConstants.CREATE_CHILD_MENU_PREF);
                CreateChildMenuConfiguration config = OutlineManager.getInstance().getCreateChildMenuConfiguration(id);
                IMenuManager createChildMenu = null;
                if (config != null)
                {
                    createChildMenu = config.getMenu();
                }
                if (createChildMenu == null)
                {
                    createChildMenu = new DefaultCreateChildMenu();
                }

                if (createChildMenu instanceof ICreateChildMenu && domain instanceof MixedEditDomain)
                {
                    ICreateChildMenu menuManager = (ICreateChildMenu) createChildMenu;
                    menuManager.removeAll();
                    menuManager.setMixedEditDomain((MixedEditDomain) domain);
                    menuManager.setSelectedEObject(selectedObject);
                    menuManager.createMenuContents();
                }
                else if (createChildMenu instanceof IMixedCreateChildMenu)
                {
                    IMixedCreateChildMenu menuManager = (IMixedCreateChildMenu) createChildMenu;
                    menuManager.removeAll();
                    menuManager.setMixedEditDomain(domain);
                    menuManager.setSelectedEObject(selectedObject);
                    menuManager.createMenuContents();
                }

                manager.appendToGroup(IOutlineMenuConstants.NEW_GROUP, createChildMenu);
            }
        }
    }

    /**
     * Subclasses should override this method to control enabling/disabling the Diagrams menu for the current selection.
     * 
     * Default returns true.
     * 
     * @param selection
     * @return wether the control action is enabled for the current selection or not.
     */
    protected boolean isDiagramsMenuEnabledFor(EObject selectedObject)
    {
        return true;
    }

    /**
     * Subclasses should override this method to control enabling/disabling the EMF menu for the current selection.
     * 
     * Default returns true.
     * 
     * @param selection
     * @return wether the control action is enabled for the current selection or not.
     */
    protected boolean isEMFMenuEnabledFor(EObject selectedObject)
    {
        return true;
    }

    /**
     * Subclasses should override this method to control enabling/disabling the control action for the current
     * selection.
     * 
     * Default returns true.
     * 
     * @param selection
     * @return wether the control action is enabled for the current selection or not.
     */
    protected boolean isControlActionEnabledFor(EObject selectedObject)
    {
        return true;
    }

    private void createControlActions(IMenuManager manager)
    {
        EObject selectedObject = null;
        Object sel = getTreeViewer().getSelection();
        Object selection = null;
        if (sel instanceof IStructuredSelection)
        {
            if (!((IStructuredSelection) sel).isEmpty())
            {
                selection = ((IStructuredSelection) sel).getFirstElement();
            }
        }

        if (selection instanceof EObject)
        {
            selectedObject = (EObject) selection;
        }
        else if (selection instanceof IWrapperItemProvider || selection instanceof FeatureMap.Entry)
        {
            selectedObject = (EObject) AdapterFactoryEditingDomain.unwrap(selection);
        }

        if (!isControlActionEnabledFor(selectedObject))
        {
            return;
        }
        if (controlAction == null)
        {
            controlAction = new ModelerControlAction(modeler);
        }
        controlAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (controlAction.isEnabled())
        {
            manager.add(controlAction);
        }

        if (uncontrolAction == null)
        {
            uncontrolAction = new ModelerUncontrolAction(modeler);
        }
        uncontrolAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (uncontrolAction.isEnabled())
        {
            manager.add(uncontrolAction);
        }
        if (exportAction == null)
        {
            exportAction = new ExportSubmodelAction(modeler);
        }
        exportAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (exportAction.isEnabled())
        {
            manager.add(exportAction);
        }
        if (updateCacheAction == null)
        {
            updateCacheAction = new UpdateCacheAction(modeler);
        }
        updateCacheAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (updateCacheAction.isEnabled())
        {
            manager.add(updateCacheAction);
        }
        if (importAction == null)
        {
            importAction = new ImportSubmodelAction(modeler);
        }
        importAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (importAction.isEnabled())
        {
            manager.add(importAction);
        }
        if (importFromModelAction == null)
        {
            importFromModelAction = new ImportFromModelAction(modeler);
        }
        importFromModelAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (importFromModelAction.isEnabled())
        {
            manager.add(importFromModelAction);
        }
        if (disableExportStatusAction == null)
        {
            disableExportStatusAction = new DisableExportedStatusAction(modeler);
        }
        disableExportStatusAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        if (disableExportStatusAction.isEnabled())
        {
            manager.add(disableExportStatusAction);
        }

    }

    /**
     * Rfersh the treeviewer in the UI thread if we are in a different thread
     */
    protected final void refreshViewer()
    {
        refreshViewer(false);
    }

    /**
     * Refresh the treeviewer in the UI thread if we are in a different thread
     * 
     * @param updateLabel <code>true</code> if the label must be refreshed
     */
    protected final void refreshViewer(final boolean updateLabel)
    {
        refreshViewer(null, updateLabel);
    }

    /**
     * Refresh the treeviewer in the UI thread if we are in a different thread
     * 
     * @param updateLabel <code>true</code> if the label must be refreshed
     */
    protected final void refreshViewer(final Object objectToRefresh, final boolean updateLabel)
    {
        if (viewer != null && !viewer.getTree().isDisposed())
        {
            if (Display.getCurrent() != Display.getDefault())
            {
                syncRefreshViewer(objectToRefresh, updateLabel);
            }
            else
            {
                if (objectToRefresh == null)
                {
                    viewer.refresh(updateLabel);
                }
                else
                {
                    viewer.refresh(objectToRefresh, updateLabel);
                }
            }
        }
    }

    /**
     * Refesh the tree viewer in the UI thread
     * 
     * @param updateLabel <code>true</code> if the label must be refreshed
     */
    private void syncRefreshViewer(final Object objectToRefresh, final boolean updateLabel)
    {
        if (displayedOnce)
        {
            viewer.getControl().getDisplay().syncExec(new Runnable()
            {
                public void run()
                {
                    if (objectToRefresh == null)
                    {
                        viewer.refresh(updateLabel);
                    }
                    else
                    {
                        viewer.refresh(objectToRefresh, updateLabel);
                    }
                }
            });
        }
        /*
         * Otherwise, viewer is already busy performing initial display (through refresh method). We won't perform a
         * useless additional refresh here, because all it can do is cause a deadlock (especially if working with
         * transactionnal editing domain)
         */
    }

    /**
     * @see org.eclipse.swt.widgets.Widget#dispose()
     */
    @Override
    public void dispose()
    {
        unhookListeners();
        if (customSearchFilter != null)
        {
            customSearchFilter.dispose();
        }
        if (autoCompletionTextField != null)
        {
            autoCompletionTextField.saveHistory();
        }
        viewer.getControl().dispose();
        if (modelContentProvider != null)
        {
            modelContentProvider.dispose();
        }
        OutlineToDiagramTransfer.getInstance().setObject(null);
        super.dispose();
    }

    /**
     * Since {@link DeleteAction} is internal, added this as a way for subclasses to hook different key listeners for
     * the delete action.
     * 
     * @return
     */
    protected IAction createDeleteAction()
    {
        assert modeler != null && modeler.getDiagrams() != null && viewer != null && viewer.getSelection() != null;
        IMixedEditDomain domain = (IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class);
        IAction deleteAction = new DeleteAction(domain, modeler.getDiagrams(), viewer.getSelection());
        return deleteAction;
    }

}
