/*****************************************************************************
 * 
 * FilterSelectionDialog.java
 * 
 * Copyright (c) 2008 Atos Origin.
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com
 *  Sebatien Gabel (CS) - API modifications 
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.editor.outline.filters.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.topcased.modeler.editor.outline.filters.AdditionalResourcesFilter;
import org.topcased.modeler.editor.outline.filters.DiagramFilter;
import org.topcased.modeler.editor.outline.filters.GenericMetamodelFilter;
import org.topcased.modeler.editor.outline.filters.OnlyDiagramsFilter;
import org.topcased.modeler.editor.outline.filters.actions.FiltersLabelProvider;
import org.topcased.modeler.editor.outline.filters.actions.MetamodelFiltersLabelProvider;
import org.topcased.modeler.editor.outline.filters.files.UserFilterFile;
import org.topcased.modeler.extensions.OutlineManager.FilterConfiguration;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;

/**
 * This class is the main dialog for the filter mechanism. It permits to select the filters to apply to the outline It
 * also gives the possibility to the end-user to deal with its own filters
 * 
 * This dialog returns two types of results :
 * <ul>
 * <li>a table of object containing the extension filters</li>
 * <li>a map of UserFilterFile and a boolean to deal with end-users filters</li>
 * </ul>
 */
public class FilterSelectionDialog extends SelectionDialog
{
    protected GenericMetamodelFilter metamodelFilter = null;

    private Composite parentComposite;

    private Group diagramFilterGroup;

    private Group additionalResourceFilterGroup;

    private Group extensionFilterGroup;

    private Group customUserFiltersGroup;

    private Button diagramShowButton;

    private Button diagramOnlyButton;

    private Button diagramHideButton;

    private Button additionalResourceShowButton;

    private Button additionalResourceHideButton;

    private CheckboxTableViewer extensionFilterListViewer;

    private CheckboxTableViewer customUserListViewer;

    private Button customUserFilterNewFilterButton;

    private Button customUserFilterRemoveFilterButton;

    private Button customUserFilterImportFilterButton;

    private Button customUserFilterUpdateFilterButton;

    private ILabelProvider labelProvider;

    private IStructuredContentProvider contentProvider;

    private Collection<Object> listInputElement;

    private List<Object> filterResult;

    private Map<UserFilterFile, Boolean> filterUserResult;

    private FilterConfiguration diagramFilterConfiguration;

    private FilterConfiguration onlyDiagramsFilterConfiguration;

    private FilterConfiguration additionalResourcesFilterConfiguration;

    private List<Object> listFileFilterElement;

    private List<Object> initialUserFilterSelection;

    /**
     * Default constructor
     * 
     * @param inputElement The filter configuration
     * @param inputFileFilterElement The input file filter
     */
    public FilterSelectionDialog(Collection<FilterConfiguration> inputElement, List<Object> inputFileFilterElement)
    {
        this(ModelerPlugin.getActiveWorkbenchShell(), new ArrayContentProvider(), new FiltersLabelProvider(), inputElement, inputFileFilterElement);
    }

    protected FilterSelectionDialog(Shell parentShell, IStructuredContentProvider cntProvider, ILabelProvider lblProvider, Collection<FilterConfiguration> inputElement,
            List<Object> inputFileFilterElement)
    {
        super(parentShell);
        contentProvider = cntProvider;
        labelProvider = lblProvider;
        listInputElement = getNonGenericFilter(inputElement);
        listFileFilterElement = inputFileFilterElement;
        filterResult = new ArrayList<Object>();
        filterUserResult = new HashMap<UserFilterFile, Boolean>();
        initialUserFilterSelection = new ArrayList<Object>();
    }

    /**
     * Get the initial user filter selection
     * 
     * @return a list of object representing the initial user filter selection
     */
    private List<Object> getInitialUserFilterSelection()
    {
        return initialUserFilterSelection;
    }

    /**
     * Set the initial user filter selection
     * 
     * @param initialUserFilterSelection a list of object representing the initial user filter selection
     */
    public void setInitialUserFilterSelection(List<Object> initialUserFilterSelection)
    {
        this.initialUserFilterSelection = initialUserFilterSelection;
    }

    /**
     * @see org.eclipse.ui.dialogs.SelectionDialog#isResizable()
     */
    @Override
    protected boolean isResizable()
    {
        return true;
    }

    /**
     * @see org.eclipse.ui.dialogs.SelectionDialog#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell shell)
    {
        super.configureShell(shell);
        shell.setMinimumSize(400, 500);
        shell.setSize(400, 500);
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent)
    {
        parentComposite = (Composite) super.createDialogArea(parent);

        diagramFilterGroup = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        diagramFilterGroup.setText(Messages.getString("FilterSelectionDialog.DiagramFilterGroup"));
        diagramFilterGroup.setLayout(new GridLayout(3, false));
        diagramFilterGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        createDiagramFilterGroup(diagramFilterGroup);

        additionalResourceFilterGroup = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        additionalResourceFilterGroup.setText(Messages.getString("FilterSelectionDialog.AdditionalResourceFilterGroup"));
        additionalResourceFilterGroup.setLayout(new GridLayout(2, false));
        additionalResourceFilterGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        createAdditionalResourceGroup(additionalResourceFilterGroup);

        extensionFilterGroup = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        extensionFilterGroup.setText(Messages.getString("FilterSelectionDialog.ExtensionFilterGroup"));
        extensionFilterGroup.setLayout(new GridLayout(2, false));
        extensionFilterGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
        createExtensionFilterGroup(extensionFilterGroup);

        customUserFiltersGroup = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        customUserFiltersGroup.setText(Messages.getString("FilterSelectionDialog.UserFilterGroup"));
        customUserFiltersGroup.setLayout(new GridLayout(2, false));
        customUserFiltersGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
        createCustomUserFilterGroup(customUserFiltersGroup);

        createButtonsListener();

        initializeWidgets();

        return parentComposite;
    }

    private void createDiagramFilterGroup(Group parentGroup)
    {
        diagramShowButton = new Button(parentGroup, SWT.RADIO);
        diagramShowButton.setText(Messages.getString("FilterSelectionDialog.ShowButton"));

        diagramOnlyButton = new Button(parentGroup, SWT.RADIO);
        diagramOnlyButton.setText(Messages.getString("FilterSelectionDialog.ShowOnlyButton"));

        diagramHideButton = new Button(parentGroup, SWT.RADIO);
        diagramHideButton.setText(Messages.getString("FilterSelectionDialog.HideButton"));
    }

    private void createAdditionalResourceGroup(Group parentGroup)
    {
        additionalResourceShowButton = new Button(parentGroup, SWT.RADIO);
        additionalResourceShowButton.setText(Messages.getString("FilterSelectionDialog.ShowButton"));

        additionalResourceHideButton = new Button(parentGroup, SWT.RADIO);
        additionalResourceHideButton.setText(Messages.getString("FilterSelectionDialog.HideButton"));
    }

    private void createExtensionFilterGroup(Group parentGroup)
    {
        extensionFilterListViewer = CheckboxTableViewer.newCheckList(parentGroup, SWT.BORDER);
        extensionFilterListViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    private void createCustomUserFilterGroup(Group parentGroup)
    {
        customUserListViewer = CheckboxTableViewer.newCheckList(parentGroup, SWT.BORDER);
        customUserListViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

        Composite menuCompo = new Composite(parentGroup, SWT.NONE);
        menuCompo.setLayout(new GridLayout(1, false));
        menuCompo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

        customUserFilterNewFilterButton = new Button(menuCompo, SWT.PUSH);
        customUserFilterNewFilterButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        customUserFilterNewFilterButton.setText(Messages.getString("FilterSelectionDialog.NewFilterButton"));
        customUserFilterNewFilterButton.setToolTipText(Messages.getString("FilterSelectionDialog.NewFilterButtonTooltip"));

        customUserFilterImportFilterButton = new Button(menuCompo, SWT.PUSH);
        customUserFilterImportFilterButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        customUserFilterImportFilterButton.setText(Messages.getString("FilterSelectionDialog.ImportFilterButton"));
        customUserFilterImportFilterButton.setToolTipText(Messages.getString("FilterSelectionDialog.ImportFilterButtonTooltip"));

        customUserFilterUpdateFilterButton = new Button(menuCompo, SWT.PUSH);
        customUserFilterUpdateFilterButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        customUserFilterUpdateFilterButton.setText(Messages.getString("FilterSelectionDialog.UpdateFilterButton"));
        customUserFilterUpdateFilterButton.setToolTipText(Messages.getString("FilterSelectionDialog.UpdateFilterButtonTooltip"));

        customUserFilterRemoveFilterButton = new Button(menuCompo, SWT.PUSH);
        customUserFilterRemoveFilterButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        customUserFilterRemoveFilterButton.setText(Messages.getString("FilterSelectionDialog.RemoveFilterButton"));
        customUserFilterRemoveFilterButton.setToolTipText(Messages.getString("FilterSelectionDialog.RemoveFilterButtonTooltip"));

    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed()
    {
        // Build a list of selected children.
        for (Object object : contentProvider.getElements(listInputElement))
        {
            if (extensionFilterListViewer.getChecked(object))
            {
                filterResult.add(object);
            }
        }
        setResult(filterResult);

        for (Object object : contentProvider.getElements(listFileFilterElement))
        {
            if (customUserListViewer.getChecked(object))
            {
                filterUserResult.put((UserFilterFile) object, Boolean.TRUE);
            }
            else
            {
                filterUserResult.put((UserFilterFile) object, Boolean.FALSE);
            }
        }
        super.okPressed();
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
     */
    @Override
    protected void cancelPressed()
    {
        filterUserResult = null;
        super.cancelPressed();
    }

    /**
     * Return the result of the user's defined filter.
     * 
     * @return a map with the key the UserFilterFile and the value a Boolean. The boolean is set to TRUE if the
     *         UserFilterFile is selected.
     */
    public Map<UserFilterFile, Boolean> getUserFilterResult()
    {
        return filterUserResult;
    }

    /**
     * Create the different button's listener
     */
    private void createButtonsListener()
    {

        // Diagrams Button
        diagramShowButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (filterResult.contains(diagramFilterConfiguration))
                {
                    filterResult.remove(diagramFilterConfiguration);
                }
                if (filterResult.contains(onlyDiagramsFilterConfiguration))
                {
                    filterResult.remove(onlyDiagramsFilterConfiguration);
                }
            }
        });

        diagramOnlyButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (filterResult.contains(diagramFilterConfiguration))
                {
                    filterResult.remove(diagramFilterConfiguration);
                }
                if (!(filterResult.contains(onlyDiagramsFilterConfiguration)))
                {
                    filterResult.add(onlyDiagramsFilterConfiguration);
                }
            }
        });

        diagramHideButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (filterResult.contains(onlyDiagramsFilterConfiguration))
                {
                    filterResult.remove(onlyDiagramsFilterConfiguration);
                }
                if (!(filterResult.contains(diagramFilterConfiguration)))
                {
                    filterResult.add(diagramFilterConfiguration);
                }
            }
        });

        // Additional Resources Button
        additionalResourceShowButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (filterResult.contains(additionalResourcesFilterConfiguration))
                {
                    filterResult.remove(additionalResourcesFilterConfiguration);
                }
            }
        });

        additionalResourceHideButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (!(filterResult.contains(additionalResourcesFilterConfiguration)))
                {
                    filterResult.add(additionalResourcesFilterConfiguration);
                }
            }
        });

        // User Filter Button
        customUserFilterNewFilterButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (metamodelFilterExist())
                {
                    NewFilterDialog newFilterDialog = new NewFilterDialog(getShell(), getMetamodelElements().toArray(), new ArrayContentProvider(), new MetamodelFiltersLabelProvider(), null);
                    newFilterDialog.setTitle(Messages.getString("FilterSelectionDialog.NewFilterDialog"));
                    newFilterDialog.open();
                    if (newFilterDialog.getResult() != null)
                    {
                        listFileFilterElement.addAll(Arrays.asList(newFilterDialog.getResult()));
                        refreshCustomUserListViewer();
                    }
                }

            }
        });

        customUserFilterImportFilterButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                FileDialog fileDialog = new FileDialog(getShell());
                String[] filterExtension = new String[] {Messages.getString("FilterSelectionDialog.MultiplicityChar") + UserFilterFile.EXTENSION};
                fileDialog.setFilterExtensions(filterExtension);
                String path = fileDialog.open();

                if (path != null && path.length() != 0)
                {
                    UserFilterFile userFilterFile = new UserFilterFile(path);
                    if (!listFileFilterElement.contains(userFilterFile))
                    {
                        listFileFilterElement.add(userFilterFile);
                        refreshCustomUserListViewer();
                    }
                }
            }
        });

        customUserFilterUpdateFilterButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (metamodelFilterExist())
                {
                    StructuredSelection selection = (StructuredSelection) customUserListViewer.getSelection();
                    if (selection.getFirstElement() instanceof UserFilterFile)
                    {
                        UserFilterFile userFilterFile = (UserFilterFile) selection.getFirstElement();
                        NewFilterDialog newFilterDialog = new NewFilterDialog(getShell(), getMetamodelElements().toArray(), new ArrayContentProvider(), new MetamodelFiltersLabelProvider(),
                                userFilterFile);
                        newFilterDialog.setTitle(Messages.getString("FilterSelectionDialog.UpdateNewFilterDialog"));

                        newFilterDialog.setInitialElementSelections(userFilterFile.getElements());
                        newFilterDialog.open();
                    }
                }
            }
        });

        customUserFilterRemoveFilterButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (customUserListViewer.getSelection() instanceof StructuredSelection)
                {
                    StructuredSelection selection = (StructuredSelection) customUserListViewer.getSelection();
                    if (selection.getFirstElement() instanceof UserFilterFile)
                    {
                        listFileFilterElement.remove((UserFilterFile) selection.getFirstElement());
                        refreshCustomUserListViewer();
                    }
                }
            }
        });

        customUserListViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                customUserFilterRemoveFilterButton.setEnabled(true);
                customUserFilterUpdateFilterButton.setEnabled(true);
            }
        });

    }

    /**
     * Initialize the widgets
     */
    private void initializeWidgets()
    {
        // Initialize extension's filters
        List< ? > initialSelection = getInitialElementSelections();

        extensionFilterListViewer.setLabelProvider(labelProvider);
        extensionFilterListViewer.setContentProvider(contentProvider);
        extensionFilterListViewer.setInput(listInputElement);
        for (Object element : listInputElement)
        {
            if (initialSelection.contains(element))
            {
                extensionFilterListViewer.setChecked(element, true);
            }
        }

        // Initialize diagram's radio button
        if (initialSelection.contains(diagramFilterConfiguration))
        {
            filterResult.add(diagramFilterConfiguration);
            diagramHideButton.setSelection(true);
        }
        else if (initialSelection.contains(onlyDiagramsFilterConfiguration))
        {
            filterResult.add(onlyDiagramsFilterConfiguration);
            diagramOnlyButton.setSelection(true);
        }
        else
        {
            diagramShowButton.setSelection(true);
        }

        // Initialize AdditionalResources radio button
        if (initialSelection.contains(additionalResourcesFilterConfiguration))
        {
            filterResult.add(additionalResourcesFilterConfiguration);
            additionalResourceHideButton.setSelection(true);
        }
        else
        {
            additionalResourceShowButton.setSelection(true);
        }

        // Initialize user's filters
        List<Object> initialUserSelection = getInitialUserFilterSelection();
        customUserListViewer.setLabelProvider(labelProvider);
        customUserListViewer.setContentProvider(contentProvider);
        customUserListViewer.setInput(listFileFilterElement);
        for (Object element : listFileFilterElement)
        {
            if (initialUserSelection.contains(element))
            {
                customUserListViewer.setChecked(element, true);
            }
        }

        // Those two buttons need an element selected in the customUserListViewer to work.
        // So they are disable (no element is selected yet)
        customUserFilterUpdateFilterButton.setEnabled(false);
        customUserFilterRemoveFilterButton.setEnabled(false);

    }

    /**
     * Set the metamodelFilter used by this dialog
     * 
     * @param the metamodelFilter used by this dialog
     */
    public void setMetamodelFilter(GenericMetamodelFilter metamodelFilter)
    {
        this.metamodelFilter = metamodelFilter;
    }

    /**
     * Return a collection without generic filter from the list of filter extension
     * 
     * @return a collection of FilterConfiguration without generic extension filters
     */
    private Collection<Object> getNonGenericFilter(Collection<FilterConfiguration> allFilter)
    {
        List<Object> nonGenericFilter = new ArrayList<Object>();
        for (FilterConfiguration filterCfg : allFilter)
        {
            if (filterCfg.getFilter() instanceof DiagramFilter)
            {
                diagramFilterConfiguration = filterCfg;
            }
            else if (filterCfg.getFilter() instanceof OnlyDiagramsFilter)
            {
                onlyDiagramsFilterConfiguration = filterCfg;
            }
            else if (filterCfg.getFilter() instanceof AdditionalResourcesFilter)
            {
                additionalResourcesFilterConfiguration = filterCfg;
            }
            else
            {
                nonGenericFilter.add(filterCfg);
            }
        }
        return nonGenericFilter;
    }

    /**
     * Disable the update and remove button of the CustomUserListViewer if there is no element displayed in the
     * CustomUserListViewer.
     */
    private void refreshCustomUserListViewer()
    {
        customUserListViewer.refresh();
        if (listFileFilterElement.isEmpty())
        {
            customUserFilterRemoveFilterButton.setEnabled(false);
            customUserFilterUpdateFilterButton.setEnabled(false);
        }
    }

    /**
     * Get the instance type name
     * 
     * @return a list of String
     */
    private List<String> getMetamodelElements()
    {
        List<String> metamodelInstanceTypeName = new ArrayList<String>();

        for (ENamedElement namedElt : metamodelFilter.getMetamodelElements())
        {
            if (namedElt instanceof EClassifier)
            {
                metamodelInstanceTypeName.add(((EClassifier) namedElt).getInstanceTypeName());    
            }
            else
            {
                metamodelInstanceTypeName.add(namedElt.getName());
            }
            
        }
        Collections.sort(metamodelInstanceTypeName);
        return metamodelInstanceTypeName;
    }

    /**
     * Check if the metamodelFilter exists. Otherwise open an error dialog.
     * 
     * @return true if the metamodelFilter exists, false if not.
     */
    private boolean metamodelFilterExist()
    {
        if (metamodelFilter != null)
        {
            return true;
        }
        ModelerPlugin.displayDialog(Messages.getString("FilterSelectionDialog.ErrorDialogTitle"), Messages.getString("FilterSelectionDialog.ErrorDialogMessage"), IStatus.ERROR);
        return false;
    }

}
