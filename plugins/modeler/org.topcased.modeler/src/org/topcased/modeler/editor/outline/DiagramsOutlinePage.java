/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * 
 * eperico (atos origin) - manage resolve mechanism for the control mode
 ******************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.editor.DiagramOutlinePageBehavior;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.outline.filters.actions.FiltersAction;
import org.topcased.modeler.extensions.OutlineManager;
import org.topcased.modeler.extensions.OutlineManager.CreateChildMenuConfiguration;
import org.topcased.modeler.extensions.OutlineManager.SorterConfiguration;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * <b>Outline of the modeler editor </b> <br>
 * The outline displays the model tree and the diagrams associated with the model objects. <br>
 * Double-clicking on a diagram change the active diagram edited by the modeler. <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class DiagramsOutlinePage extends Page implements IContentOutlinePage, ISelectionChangedListener, IAdaptable
{

    /** extension point ID to resolve resources. */
    public static final String EXTENSION_POINT_ID_FOR_RESOLVE = "org.topcased.modeler.openingResolve";

    /** attribute ID for the specified behavior class. */
    public static final String ATTRIBUTE_EXTENSION_POINT_ID_FOR_RESOLVE = "openingBehavior";

    /** attribute ID for the editor type. */
    public static final String EDITOR_TYPE_EXTENSION_POINT_ID_FOR_RESOLVE = "editorType";

    private Map<String, DiagramOutlinePageBehavior> behaviors = getBehaviors();

    /** Flag set during selection modification */
    private boolean isDispatching = false;

    private Modeler editor;

    private ModelNavigator navigator;

    private Composite overview;

    private SashForm sashComp;

    /** Actions */
    private IAction showTreeAction;

    private IAction showOverviewAction;

    private IAction showAllAction;

    /** Action to expand tree viewer */
    private IAction expandAction;

    /** Action to collapse tree viewer */
    private IAction collapseAction;

    /** Action to filter tree elements */
    private IAction filtersAction;

    /**
     * Constructor
     * 
     * @param modeler the editor
     */
    public DiagramsOutlinePage(Modeler modeler)
    {
        editor = modeler;
    }

    private Map<String, DiagramOutlinePageBehavior> getBehaviors()
    {
        Map<String, DiagramOutlinePageBehavior> result = new HashMap<String, DiagramOutlinePageBehavior>();
        IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID_FOR_RESOLVE);
        for (IConfigurationElement e : extensions)
        {
            try
            {
                String editorType = e.getAttribute(EDITOR_TYPE_EXTENSION_POINT_ID_FOR_RESOLVE);
                DiagramOutlinePageBehavior behavior = (DiagramOutlinePageBehavior) e.createExecutableExtension(ATTRIBUTE_EXTENSION_POINT_ID_FOR_RESOLVE);
                result.put(editorType, behavior);
            }
            catch (CoreException exception)
            {
                exception.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
     */
    public void addSelectionChangedListener(ISelectionChangedListener listener)
    {
        if (navigator != null && !navigator.isDisposed())
        {
            navigator.getTreeViewer().addSelectionChangedListener(listener);
        }
    }

    /**
     * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
     */
    public void removeSelectionChangedListener(ISelectionChangedListener listener)
    {
        if (navigator != null && !navigator.isDisposed())
        {
            navigator.getTreeViewer().removeSelectionChangedListener(listener);
        }
    }

    /**
     * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
     */
    public ISelection getSelection()
    {
        return navigator.getTreeViewer().getSelection();
    }

    /**
     * Update the representation of the given element in the viewer.
     * 
     * @param element the element to update
     * @see ColumnViewer#update(Object, String[])
     */
    public void refreshElement(Object element)
    {
        navigator.getTreeViewer().refresh(element);
    }

    /**
     * Update the representation of the given element in the viewer.
     * 
     * @param element the element to update
     * @see ColumnViewer#update(Object, String[])
     */
    public void updateElement(Object element)
    {
        navigator.getTreeViewer().update(element, null);
    }

    /**
     * refresh completely the outline
     */
    public void refreshOutline()
    {
        if (navigator != null && navigator.getTreeViewer() != null)
        {
            navigator.getTreeViewer().refresh(true);
        }
    }

    /**
     * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
     */
    public void setSelection(ISelection selection)
    {
        if (navigator != null && navigator.getTreeViewer() != null)
        {
            navigator.getTreeViewer().setSelection(selection, selection != null);
        }
    }

    /**
     * Add listeners on the tree :
     * <ul>
     * <li>Listen to double-click</li>
     * </ul>
     */
    protected void hookListeners()
    {
        navigator.getTreeViewer().addDoubleClickListener(new IDoubleClickListener()
        {
            public void doubleClick(DoubleClickEvent event)
            {
                handleDoubleClickEvent();
            }
        });

        editor.addSelectionChangedListener(this);
    }

    /**
     * Handles a double click on the outline tree : if the selected element is a diagram, the currently edited diagram
     * is switch in the editor.
     */
    protected void handleDoubleClickEvent()
    {
        IStructuredSelection selection = (IStructuredSelection) navigator.getTreeViewer().getSelection();
        Object selectedObject = selection.getFirstElement();

        if (selectedObject instanceof Diagram && editor.getActiveDiagram() != (Diagram) selectedObject)
        {
            editor.setActiveDiagram((Diagram) selectedObject);
        }
        else if (AdapterFactoryEditingDomain.unwrap(selectedObject) instanceof EObject)
        {
            editor.gotoEObject((EObject) AdapterFactoryEditingDomain.unwrap(selectedObject));
        }
    }

    /**
     * Creates the contents of the outline
     * 
     * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent)
    {

        // SashForm
        sashComp = new SashForm(parent, SWT.VERTICAL);
        sashComp.setLayoutData(new GridData(GridData.FILL_BOTH));

        RootEditPart rootEditPart = editor.getRootEditPart();
        if (rootEditPart instanceof ScalableFreeformRootEditPart)
        {
            overview = createOverview(sashComp, (ScalableFreeformRootEditPart) rootEditPart);
            overview.setLayoutData(new GridData(GridData.FILL_BOTH));
        }

        navigator = createNavigator(sashComp, editor, getSite());

        sashComp.setWeights(new int[] {30, 70});

        getSite().setSelectionProvider(navigator.getTreeViewer());

        createActions();
        hookListeners();
    }

    /**
     * Create the composite that shows an overview of the model
     * 
     * @param parent the parent
     * @param rootEditPart the root edit part
     * @return the overview composite
     */
    protected Composite createOverview(Composite parent, ScalableFreeformRootEditPart rootEditPart)
    {
        return new OverviewComposite(parent, rootEditPart);
    }

    /**
     * Create the composite that shows a tree view of the model
     * 
     * @param parent the parent
     * @return the navigation composite
     */
    protected ModelNavigator createNavigator(Composite parent, Modeler editor, IPageSite pageSite)
    {
        return new ModelNavigator(sashComp, editor, getSite());
    }

    /**
     * Add the actions to the view toolbar
     */
    protected void createActions()
    {
        IToolBarManager tbm = getSite().getActionBars().getToolBarManager();

        createSorterActions(tbm);

        filtersAction = new FiltersAction(navigator.getTreeViewer(), editor);
        tbm.add(filtersAction);

        createExpandCollapseActions(tbm);

        tbm.add(new Separator());

        createShowOutlineActions(tbm);

        fillDropDownMenu(getSite().getActionBars().getMenuManager());
    }

    /**
     * Create the show outline actions int hte given tool bar manager.
     * 
     * @param tbm the outline tool bar manager
     */
    private void createShowOutlineActions(IToolBarManager tbm)
    {
        final IPreferenceStore ps = editor.getPreferenceStore();
        showTreeAction = new Action("Show Navigator", IAction.AS_RADIO_BUTTON)
        {
            public void run()
            {
                if (navigator != null && !navigator.isDisposed())
                {
                    performShowAction(navigator, ps, 1);
                }
            }
        };
        showTreeAction.setToolTipText(showTreeAction.getText());
        showTreeAction.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_TREE"));
        tbm.add(showTreeAction);

        showOverviewAction = new Action("Show Overview", IAction.AS_RADIO_BUTTON)
        {
            public void run()
            {
                if (overview != null && !overview.isDisposed())
                {
                    performShowAction(overview, ps, 2);
                }
            }
        };
        showOverviewAction.setToolTipText(showOverviewAction.getText());
        showOverviewAction.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_OVERVIEW"));
        tbm.add(showOverviewAction);

        showAllAction = new Action("Show both", IAction.AS_RADIO_BUTTON)
        {
            public void run()
            {
                if (sashComp != null && !sashComp.isDisposed())
                {
                    performShowAction(null, ps, 0);
                }
            }
        };
        showAllAction.setToolTipText(showAllAction.getText());
        showAllAction.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_ALL"));
        tbm.add(showAllAction);

        if (ps != null)
        {
            int showAction = ps.getInt(ModelerPreferenceConstants.OUTLINE_SHOW_ACTION_PREF);
            Control control = null;
            switch (showAction)
            {
                case 1:
                    control = navigator;
                    showTreeAction.setChecked(true);
                    break;

                case 2:
                    control = overview;
                    showOverviewAction.setChecked(true);
                    break;

                default:
                    control = null;
                    showAllAction.setChecked(true);
            }
            performShowAction(control, ps, showAction);
        }
        else
        {
            showAllAction.setChecked(true);
            performShowAction(null, ps, 0);
        }

    }

    /**
     * Creates the sorter actions in the given tool bar manager.
     * 
     * @param tbm the outline tool bar manager
     */
    private void createSorterActions(IToolBarManager tbm)
    {
        final IPreferenceStore ps = editor.getPreferenceStore();
        final List<IAction> sorterActions = new ArrayList<IAction>();

        // Get all extended sorters
        Collection<SorterConfiguration> sorters = OutlineManager.getInstance().getSorters(editor.getSite().getId());
        // Get the actual sorter id from the preference store
        String sorterId = ps != null ? ps.getString(ModelerPreferenceConstants.OUTLINE_SORTER_PREF) : null;
        for (Iterator<SorterConfiguration> it = sorters.iterator(); it.hasNext();)
        {
            final SorterConfiguration config = it.next();
            // Create an action for each sorter configuration
            IAction sorterAction = new Action(config.getName(), IAction.AS_CHECK_BOX)
            {
                public void run()
                {
                    navigator.getTreeViewer().setSorter(isChecked() ? config.getSorter() : null);
                    for (Iterator<IAction> it2 = sorterActions.iterator(); it2.hasNext();)
                    {
                        IAction action = it2.next();
                        if (action != this)
                        {
                            action.setChecked(false);
                        }
                    }
                    // Store the selected sorter in the preference store
                    if (ps != null)
                    {
                        ps.setValue(ModelerPreferenceConstants.OUTLINE_SORTER_PREF, isChecked() ? config.getId() : "");
                    }
                }

            };
            // Add the newly created action in the actions cache
            sorterActions.add(sorterAction);

            // Configure the newly created action
            sorterAction.setChecked(config.getId().equals(sorterId));
            sorterAction.setImageDescriptor(config.getIcon());
            sorterAction.setToolTipText(config.getName());

            // Set the actual sorter
            if (config.getId().equals(sorterId))
            {
                navigator.getTreeViewer().setSorter(config.getSorter());
            }

            tbm.add(sorterAction);
        }

    }

    /**
     * Creates the expand and collapse actions in the given tool bar manager.
     * 
     * @param tbm the outline tool bar manager
     */
    private void createExpandCollapseActions(IToolBarManager tbm)
    {
        if (navigator != null && !navigator.isDisposed())
        {

        }
        // expand the tree viewer action
        expandAction = new Action(Messages.getString("ExpandAction.Label"), IAction.AS_PUSH_BUTTON)// $NON-NLS-1$
        {
            public void run()
            {
                if (navigator != null && !navigator.isDisposed())
                {
                    TreeViewer treeViewer = navigator.getTreeViewer();
                    ISelection selection = treeViewer.getSelection();
                    if (selection != null && selection.isEmpty())
                    {
                        treeViewer.expandAll();
                    }
                    else if (selection != null && selection instanceof IStructuredSelection)
                    {
                        Iterator< ? > iterator = ((IStructuredSelection) selection).iterator();
                        while (iterator.hasNext())
                        {
                            Object selectedElt = iterator.next();
                            treeViewer.expandToLevel(selectedElt, TreeViewer.ALL_LEVELS);
                        }
                    }
                }
            }
        };
        expandAction.setToolTipText(expandAction.getText());
        expandAction.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_EXPAND"));// $NON-NLS-1$
        tbm.add(expandAction);
        // collapse the tree viewer action
        collapseAction = new Action(Messages.getString("CollapseAction.Label"), IAction.AS_PUSH_BUTTON)// $NON-NLS-1$
        {
            public void run()
            {
                if (navigator != null && !navigator.isDisposed())
                {
                    TreeViewer treeViewer = navigator.getTreeViewer();
                    ISelection selection = treeViewer.getSelection();
                    if (selection != null && selection.isEmpty())
                    {
                        treeViewer.collapseAll();
                    }
                    else if (selection != null && selection instanceof IStructuredSelection)
                    {
                        Iterator< ? > iterator = ((IStructuredSelection) selection).iterator();
                        while (iterator.hasNext())
                        {
                            Object selectedElt = iterator.next();
                            treeViewer.collapseToLevel(selectedElt, TreeViewer.ALL_LEVELS);
                        }
                    }
                }
            }
        };
        collapseAction.setToolTipText(collapseAction.getText());
        collapseAction.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_COLLAPSE"));// $NON-NLS-1$
        tbm.add(collapseAction);
    }

    private void performShowAction(Control control, IPreferenceStore ps, int pref)
    {
        refreshActionsEnablement(control);
        sashComp.setMaximizedControl(control);
        if (ps != null)
        {
            ps.setValue(ModelerPreferenceConstants.OUTLINE_SHOW_ACTION_PREF, pref);
        }
    }

    /**
     * Enable and disable actions, based on whether they shall have an effect on the displayed control
     * 
     * @param control navigator, overview or null if both are shown
     */
    private void refreshActionsEnablement(Control control)
    {
        if (control != null && control != navigator)
        {
            // disable navigator actions
            filtersAction.setEnabled(false);
            expandAction.setEnabled(false);
            collapseAction.setEnabled(false);
        }
        else
        {
            // enable navigator actions
            filtersAction.setEnabled(true);
            expandAction.setEnabled(true);
            collapseAction.setEnabled(true);
        }

    }

    private void fillDropDownMenu(IMenuManager menu)
    {
        Collection<CreateChildMenuConfiguration> configs = OutlineManager.getInstance().getCreateChildMenus(editor.getSite().getId());
        final IPreferenceStore ps = editor.getPreferenceStore();
        if (configs.size() > 1 && ps != null)
        {
            IMenuManager createChildMenu = new MenuManager("Create child menu");
            menu.add(createChildMenu);

            for (Iterator<CreateChildMenuConfiguration> it = configs.iterator(); it.hasNext();)
            {
                final CreateChildMenuConfiguration config = it.next();
                IAction action = new Action(config.getName(), IAction.AS_RADIO_BUTTON)
                {
                    public void run()
                    {
                        ps.setValue(ModelerPreferenceConstants.CREATE_CHILD_MENU_PREF, config.getId());
                    }
                };
                action.setChecked(ps.getString(ModelerPreferenceConstants.CREATE_CHILD_MENU_PREF).equals(config.getId()));

                createChildMenu.add(action);
            }
        }

        menu.add(new Separator());

        // menu.add(new FiltersAction(navigator.getTreeViewer(), editor));
    }

    /**
     * @see org.eclipse.ui.part.IPage#getControl()
     */
    public Control getControl()
    {
        return sashComp;
    }

    /**
     * @see org.eclipse.ui.part.Page#init(org.eclipse.ui.part.IPageSite)
     */
    public void init(IPageSite pageSite)
    {
        super.init(pageSite);

        IActionBars bars = pageSite.getActionBars();
        String id = ActionFactory.UNDO.getId();
        bars.setGlobalActionHandler(id, editor.getPublicActionRegistry().getAction(id));
        id = ActionFactory.REDO.getId();
        bars.setGlobalActionHandler(id, editor.getPublicActionRegistry().getAction(id));
        bars.updateActionBars();
    }

    /**
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class adapter)
    {
        return editor.getAdapter(adapter);
    }

    /**
     * @see org.eclipse.ui.part.IPage#setFocus()
     */
    public void setFocus()
    {
        getControl().setFocus();
    }

    /**
     * Called when the selection changed in the editor
     * 
     * @param event
     */
    public void selectionChanged(SelectionChangedEvent event)
    {
        if (isDispatching)
        {
            return;
        }

        ISelection selection = event.getSelection();
        syncSelection(selection);
    }

    /**
     * Synchronize the outline with the given selection. It also filters the
     * 
     * @param selection
     */
    @SuppressWarnings("unchecked")
    private void syncSelection(ISelection selection)
    {
        isDispatching = true;

        List newSelection = new ArrayList();
        if (selection instanceof IStructuredSelection)
        {
            Iterator it = ((IStructuredSelection) selection).iterator();
            while (it.hasNext())
            {
                // improve performance
                // according to eclipse discussion http://dev.eclipse.org/newslists/news.eclipse.tools.emf/msg40423.html
                // we will not manage wrapper to have better performance
                Object selectedObject = it.next();
                if (selectedObject instanceof EMFGraphNodeEditPart)
                {
                    newSelection.add(((EMFGraphNodeEditPart) selectedObject).getEObject());
                }
                else if (selectedObject instanceof EMFGraphEdgeEditPart)
                {
                    newSelection.add(((EMFGraphEdgeEditPart) selectedObject).getEObject());
                }
                else if (selectedObject instanceof GraphElement)
                {
                    EObject model = Utils.getElement((GraphElement) selectedObject);
                    if (model != null)
                    {
                        newSelection.add(model);
                    }
                }
                else if (selectedObject instanceof EObject)
                {
                    newSelection.add(selectedObject);
                }
                else if (selectedObject instanceof DiagramEditPart)
                {
                    newSelection.add(((DiagramEditPart) selectedObject).getModel());

                    int selected = ((DiagramEditPart) selectedObject).getSelected();
                    // we apply diagram resolving/refreshing only when the diagram is opening (elements selected)
                    if (selected > EditPart.SELECTED_NONE)
                    {
                        // call extension point to manage control mode
                        DiagramOutlinePageBehavior behavior = behaviors.get(editor.getClass().getName());
                        if (behavior != null && behavior.resolveEobject(((DiagramEditPart) selectedObject).getEObject()))
                        {
                            Display.getDefault().syncExec(new Runnable()
                            {
                                public void run()
                                {
                                    editor.refreshActiveDiagram();
                                }
                            });
                        }
                    }
                }
            }
        }
        setSelection(getSelection(newSelection));

        isDispatching = false;
    }

    /**
     * Returns a Tree Selection from the list of elements
     * 
     * @param newSelection
     * @return
     */
    private ISelection getSelection(List newSelection)
    {
        List<TreePath> paths = new ArrayList<TreePath>(newSelection.size());
        for (Object selec : newSelection)
        {
            TreePath treePath = getTreePath(selec);
            if (treePath != null)
            {
                paths.add(treePath);
            }
        }
        return new TreeSelection(paths.toArray(new TreePath[] {}));
    }

    /**
     * Returns a tree path from an object. If it is an eobject it checks all the hierarchy to create the path
     * 
     * @param selec
     * @return
     */
    private TreePath getTreePath(Object selec)
    {
        if (selec instanceof EObject)
        {
            EObject eobject = (EObject) selec;
            List<Object> path = new LinkedList<Object>();
            path.add(eobject);
            while (eobject.eContainer() != null)
            {
                path.add(0, eobject.eContainer());
                eobject = eobject.eContainer();
            }
            return new TreePath(path.toArray());
        }
        return null;
    }

    /**
     * Releases the objects
     * 
     * @see org.eclipse.ui.part.IPage#dispose()
     */
    public void dispose()
    {
        super.dispose();
    	unhookListeners();
    	if (getSite() != null)
		{
    		if (getSite().getActionBars() != null)
    		{
    			if (getSite().getActionBars().getMenuManager() != null)
    			{
    				getSite().getActionBars().getMenuManager().dispose();
    			}
    			if (getSite().getActionBars().getToolBarManager() != null)
    			{
    				getSite().getActionBars().getToolBarManager().removeAll(); 
    			}
    			getSite().getActionBars().clearGlobalActionHandlers();
    		}
		}
    	if (getSite() != null)
    	{
    		getSite().setSelectionProvider(null);
    	}
    	if (overview != null)
    	{
    		overview.dispose();
    	}
    	if (navigator != null)
    	{
    		navigator.dispose();
    	}
        editor = null ;
        
    }

    /**
     * Stop all the listeners
     */
    protected void unhookListeners()
    {
    	if (editor != null)
    	{
    		editor.removeSelectionChangedListener(this);
    	}
    }
}
