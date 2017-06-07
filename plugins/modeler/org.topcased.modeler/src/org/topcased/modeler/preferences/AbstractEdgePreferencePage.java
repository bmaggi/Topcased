/*****************************************************************************
 * 
 * AbstractEdgePreferencePage.java
 * 
 * Copyright (c) 2005-2008 TOPCASED consortium.
 *
 * Contributors:
 *  Thibault Landré (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/

package org.topcased.modeler.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.topcased.facilities.preferences.AbstractTopcasedPreferencePage;
import org.topcased.modeler.RouterConstants;

/**
 * An abstract implementation of a Topcased Preference Page for an edge object. This class defines the page displayed
 * with the graphics preferences that can be store in the preference store : Font, Foreground color, Router, visibility
 * of EdgeObject associated with the edge. Clients must implements <code>getEdgeRouter()</code>,
 * <code>getEdgeFont()</code>, <code>getEdgeForegroundColor()</code>, <code>getVisibleElements()</code>,
 * <code>getDefaultVisibleElements()</code>, <code>getHiddenElements()</code>,
 * <code>getDefaultHiddenElements()</code>
 * <code>storeEdgeObjectVisibility(List)</code>
 */
public abstract class AbstractEdgePreferencePage extends AbstractTopcasedPreferencePage
{

    private Button hideButton;

    private Button showButton;

    private TableViewer visibleElementsTableViewer;

    private TableViewer hiddenElementsTableViewer;

    private ColorFieldEditor foregroundColorFieldEditor;

    private FontFieldEditor fontFieldEditor;

    private ComboFieldEditor routerFieldEditor;

    /**
     * Initializes this preference page for the given workbench.
     * 
     * @param workbench the workbench
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     * 
     */
    public void init(IWorkbench workbench)
    {
        // Do nothing
    }

    /**
     * Creates and returns the SWT control for the customized body of this preference page under the given parent
     * composite.
     * 
     * @param parent the parent composite
     * 
     * @return the new control
     * 
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected Control createContents(Composite parent)
    {

        // Create the container composite
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout containerLayout = new GridLayout();
        containerLayout.marginWidth = 0;
        containerLayout.marginHeight = 0;
        container.setLayout(containerLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        createDisplay(container);

        visibleElementsTableViewer.addDoubleClickListener(visibleElementsTableDoubleClickListener);
        hiddenElementsTableViewer.addDoubleClickListener(hiddenElementsTableDoubleClickListener);

        hideButton.addSelectionListener(hideButtonSelectionAdapter);
        showButton.addSelectionListener(showButtonSelectionAdapter);

        loadPreferences();

        return container;

    }

    private void createDisplay(Composite parent)
    {
        Group group = new Group(parent, SWT.SHADOW_ETCHED_OUT);
        group.setText("Edge");
        group.setLayout(new GridLayout());
        group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Composite compoRouterGlobal = new Composite(group, SWT.NONE);
        compoRouterGlobal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        String[][] routers = new String[][] { {RouterConstants.FOREST, "TreeRouter"}, {RouterConstants.OBLIQUE, "ObliqueRouter"}, {RouterConstants.RECTILINEAR, "RectilinearRouter"}};
        routerFieldEditor = new ComboFieldEditor(getEdgeRouter(), "Router :", routers, compoRouterGlobal);
        routerFieldEditor.setPreferenceStore(getPreferenceStore());

        Composite compoFontGlobal = new Composite(group, SWT.NONE);
        compoFontGlobal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        fontFieldEditor = new FontFieldEditor(getEdgeFont(), "Font:", compoFontGlobal);
        fontFieldEditor.setPreferenceStore(getPreferenceStore());

        Composite compoForegroundColorGlobal = new Composite(group, SWT.NONE);

        foregroundColorFieldEditor = new ColorFieldEditor(getEdgeForegroundColor(), "ForegroundColor: ", compoForegroundColorGlobal);
        foregroundColorFieldEditor.setPreferenceStore(getPreferenceStore());

        Group groupEdge = new Group(parent, SWT.SHADOW_ETCHED_OUT);
        groupEdge.setText("Edge Objects");
        groupEdge.setLayout(new GridLayout(3, false));
        groupEdge.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Composite choiceComposite = new Composite(groupEdge, SWT.NONE);
        choiceComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        choiceComposite.setLayout(new GridLayout());

        Label choiceLabel = new Label(choiceComposite, SWT.NONE);
        choiceLabel.setText("Visible Elements");
        choiceLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Table choiceTable = new Table(choiceComposite, SWT.MULTI | SWT.BORDER);
        choiceTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        visibleElementsTableViewer = new TableViewer(choiceTable);

        Composite controlButtons = new Composite(groupEdge, SWT.NONE);
        controlButtons.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        GridLayout controlsButtonGridLayout = new GridLayout();
        controlButtons.setLayout(controlsButtonGridLayout);

        new Label(controlButtons, SWT.NONE);

        hideButton = new Button(controlButtons, SWT.PUSH);
        hideButton.setText("Hide >");
        hideButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        showButton = new Button(controlButtons, SWT.PUSH);
        showButton.setText("< Show");
        showButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        Label spaceLabel = new Label(controlButtons, SWT.NONE);
        GridData spaceLabelGridData = new GridData();
        spaceLabelGridData.verticalSpan = 2;
        spaceLabel.setLayoutData(spaceLabelGridData);

        Composite featureComposite = new Composite(groupEdge, SWT.NONE);
        featureComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        featureComposite.setLayout(new GridLayout());

        Label featureLabel = new Label(featureComposite, SWT.NONE);
        featureLabel.setText("Hidden Elements");
        featureLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        Table featureTable = new Table(featureComposite, SWT.MULTI | SWT.BORDER);
        featureTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        hiddenElementsTableViewer = new TableViewer(featureTable);

    }

    /**
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     * @generated
     */
    public boolean performOk()
    {
        storePreferences();
        return super.performOk();
    }

    /**
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     * @generated
     */
    protected void performDefaults()
    {
        loadDefaultPreferences();
        super.performDefaults();
    }

    /**
     * Stores the HMI values into the preference store.
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private void storePreferences()
    {
        foregroundColorFieldEditor.store();
        fontFieldEditor.store();
        routerFieldEditor.store();

        storeEdgeObjectVisibility((List<String>) visibleElementsTableViewer.getInput());
    }

    /**
     * Initializes the HMI with preference values.
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private void loadPreferences()
    {
        foregroundColorFieldEditor.load();
        fontFieldEditor.load();
        routerFieldEditor.load();

        visibleElementsTableViewer.setContentProvider(new ArrayContentProvider());
        visibleElementsTableViewer.setInput(getVisibleElements());

        hiddenElementsTableViewer.setContentProvider(new ArrayContentProvider());
        hiddenElementsTableViewer.setInput(getHiddenElements());

    }

    /**
     * Initializes the HMI with default preference values.
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private void loadDefaultPreferences()
    {
        foregroundColorFieldEditor.loadDefault();
        fontFieldEditor.loadDefault();
        routerFieldEditor.loadDefault();

        visibleElementsTableViewer.setContentProvider(new ArrayContentProvider());
        visibleElementsTableViewer.setInput(getDefaultVisibleElements());

        hiddenElementsTableViewer.setContentProvider(new ArrayContentProvider());
        hiddenElementsTableViewer.setInput(getDefaultHiddenElements());
    }

    private IDoubleClickListener visibleElementsTableDoubleClickListener = new IDoubleClickListener()
    {
        public void doubleClick(DoubleClickEvent event)
        {
            if (hideButton.isEnabled())
            {
                hideButton.notifyListeners(SWT.Selection, null);
            }
        }
    };

    private IDoubleClickListener hiddenElementsTableDoubleClickListener = new IDoubleClickListener()
    {
        public void doubleClick(DoubleClickEvent event)
        {
            if (showButton.isEnabled())
            {
                showButton.notifyListeners(SWT.Selection, null);
            }
        }
    };

    private SelectionAdapter hideButtonSelectionAdapter = new SelectionAdapter()
    {
        // event is null when availableElementsTableViewer is double clicked
        public void widgetSelected(SelectionEvent event)
        {
            if (visibleElementsTableViewer != null)
            {
                final List<String> newElementIDs = new ArrayList<String>();
                IStructuredSelection selection = (IStructuredSelection) visibleElementsTableViewer.getSelection();
                for (Iterator i = selection.iterator(); i.hasNext();)
                {
                    Object value = i.next();

                    if (!((List<String>) hiddenElementsTableViewer.getInput()).contains(value))
                    {
                        ((List<String>) hiddenElementsTableViewer.getInput()).add((String) value);
                    }
                    ((List<String>) visibleElementsTableViewer.getInput()).remove(value);
                    newElementIDs.add((String) value);
                }
                // Force table to be refreshed
                hiddenElementsTableViewer.refresh();
                visibleElementsTableViewer.refresh();
            }
        }
    };

    private SelectionAdapter showButtonSelectionAdapter = new SelectionAdapter()
    {
        // event is null when selectedElementsTableViewer is double clicked
        public void widgetSelected(SelectionEvent event)
        {
            final List<String> newElementIDs = new ArrayList<String>();
            IStructuredSelection selection = (IStructuredSelection) hiddenElementsTableViewer.getSelection();
            for (Iterator i = selection.iterator(); i.hasNext();)
            {
                Object value = i.next();
                if (!((List<String>) visibleElementsTableViewer.getInput()).contains(value))
                {
                    ((List<String>) visibleElementsTableViewer.getInput()).add((String) value);
                }
                ((List<String>) hiddenElementsTableViewer.getInput()).remove(value);
                newElementIDs.add((String) value);
            }
            // Force table to be refreshed
            hiddenElementsTableViewer.refresh();
            visibleElementsTableViewer.refresh();
        }
    };

    /**
     * Get the constant representing the edge router preference in the preference store
     * 
     * @return the constant
     */
    protected abstract String getEdgeRouter();

    /**
     * Get the constant representing the edge font preference in the preference store
     * 
     * @return the constant
     */
    protected abstract String getEdgeFont();

    /**
     * Get the constant representing the edge foreground color preference in the preference store
     * 
     * @return the constant
     */
    protected abstract String getEdgeForegroundColor();

    /**
     * Get the list of visible EdgeObject IDs for the current selected GraphElement.
     * 
     * @return List the list of EdgeObject IDs that are visible
     */
    protected abstract List<String> getVisibleElements();

    /**
     * Get the default list of visible EdgeObject IDs for the current selected GraphElement.
     * 
     * @return List the list of EdgeObject IDs that are visible
     */
    protected abstract List<String> getDefaultVisibleElements();

    /**
     * Get the list of EdgeObject IDs contained by the current selected GraphElement which are hidden.
     * 
     * @return List the list of EdgeObject IDs that are not visible
     */
    protected abstract List<String> getHiddenElements();

    /**
     * Get the default list of EdgeObject IDs contained by the current selected GraphElement which are hidden.
     * 
     * @return List the list of EdgeObject IDs that are not visible
     */
    protected abstract List<String> getDefaultHiddenElements();

    /**
     * Store the EdgeObject visibility in the preference store according to the list they belong to. Only the list of
     * visible element is passed in argument. If the edgeObject is not contained in this list, it is considered as an
     * hidden element.
     * 
     * @param visibleElement the list of visible edgeObject of the graphEdge
     */
    protected abstract void storeEdgeObjectVisibility(List<String> visibleElement);

}
