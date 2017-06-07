/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections.graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.commands.RecordingChangeCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * The EdgeObject visibility section on the graphics tab. Here you can choose to show/hide an EdgeObject
 * 
 * Creation 13 Feb. 07 Updated 08 Jan. 08
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EdgeObjectVisibilityPropertySection extends AbstractGraphicPropertySection
{
    private ILabelProvider labelProvider;

    private TableViewer visibleElementsTableViewer;

    private TableViewer hiddenElementsTableViewer;

    private Button hideButton;

    private Button showButton;

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

                Command cmd = new RecordingChangeCommand(getDiagElt().eResource())
                {
                    /**
                     * @see org.topcased.modeler.commands.RecordingChangeCommand#doExecute()
                     */
                    protected void doExecute()
                    {
                        // Iterate on all the selected elements
                        for (DiagramElement currentSelectedElt : getDiagEltList())
                        {
                            // Search then the corresponding EdgeObjects
                            for (DiagramElement diagElt : ((GraphElement) currentSelectedElt).getContained())
                            {
                                if (diagElt instanceof EdgeObject && ((EdgeObject) diagElt).isVisible() && newElementIDs.contains(((EdgeObject) diagElt).getId()))
                                {
                                    ((EdgeObject) diagElt).setVisible(false);
                                }
                            }
                        }
                    }
                };

                if (cmd != null && cmd.canExecute())
                {
                    ((CommandStack) ((Modeler) getPart().getAdapter(Modeler.class)).getAdapter(CommandStack.class)).execute(cmd);
                }
            }
        }
    };
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (visibleElementsTableViewer != null && visibleElementsTableViewer.getControl() != null)
        {
            visibleElementsTableViewer.getControl().setEnabled(enabled);
        }
        if (hiddenElementsTableViewer != null && hiddenElementsTableViewer.getControl() != null)
        {
            hiddenElementsTableViewer.getControl().setEnabled(enabled);
        }
        if (hideButton != null)
        {
            hideButton.setEnabled(enabled);
        }
        if (showButton != null)
        {
            showButton.setEnabled(enabled);
        }
    }

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

            Command cmd = new RecordingChangeCommand(getDiagElt().eResource())
            {
                /**
                 * @see org.topcased.modeler.commands.RecordingChangeCommand#doExecute()
                 */
                protected void doExecute()
                {
                    // Iterate on all the selected elements
                    for (DiagramElement currentSelectedElt : getDiagEltList())
                    {
                        // Search then the corresponding EdgeObjects
                        for (DiagramElement diagElt : ((GraphElement) currentSelectedElt).getContained())
                        {
                            if (diagElt instanceof EdgeObject && !((EdgeObject) diagElt).isVisible() && newElementIDs.contains(((EdgeObject) diagElt).getId()))
                            {
                                ((EdgeObject) diagElt).setVisible(true);
                            }
                        }
                    }
                }
            };

            if (cmd != null && cmd.canExecute())
            {
                ((CommandStack) ((Modeler) getPart().getAdapter(Modeler.class)).getAdapter(CommandStack.class)).execute(cmd);
            }
        }
    };

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
    {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        composite.setLayout(new GridLayout(3, false));

        Composite choiceComposite = getWidgetFactory().createComposite(composite, SWT.NONE);
        choiceComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        choiceComposite.setLayout(new GridLayout());

        Label choiceLabel = getWidgetFactory().createLabel(choiceComposite, "Visible Elements", SWT.NONE);
        choiceLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final Table choiceTable = getWidgetFactory().createTable(choiceComposite, SWT.MULTI | SWT.BORDER);
        choiceTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        visibleElementsTableViewer = new TableViewer(choiceTable);

        Composite controlButtons = getWidgetFactory().createComposite(composite, SWT.NONE);
        controlButtons.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        GridLayout controlsButtonGridLayout = new GridLayout();
        controlButtons.setLayout(controlsButtonGridLayout);

        new Label(controlButtons, SWT.NONE);

        hideButton = getWidgetFactory().createButton(controlButtons, "Hide >", SWT.PUSH);
        hideButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        showButton = getWidgetFactory().createButton(controlButtons, "< Show", SWT.PUSH);
        showButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        Label spaceLabel = new Label(controlButtons, SWT.NONE);
        GridData spaceLabelGridData = new GridData();
        spaceLabelGridData.verticalSpan = 2;
        spaceLabel.setLayoutData(spaceLabelGridData);

        Composite featureComposite = getWidgetFactory().createComposite(composite, SWT.NONE);
        featureComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        featureComposite.setLayout(new GridLayout());

        Label featureLabel = getWidgetFactory().createLabel(featureComposite, "Hidden Elements", SWT.NONE);
        featureLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        final Table featureTable = getWidgetFactory().createTable(featureComposite, SWT.MULTI | SWT.BORDER);
        featureTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        hiddenElementsTableViewer = new TableViewer(featureTable);
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void setInput(IWorkbenchPart part, ISelection selection)
    {
        super.setInput(part, selection);

        visibleElementsTableViewer.setLabelProvider(getLabelProvider());
        visibleElementsTableViewer.setContentProvider(new ArrayContentProvider());
        visibleElementsTableViewer.setInput(getVisibleElements());

        hiddenElementsTableViewer.setLabelProvider(getLabelProvider());
        hiddenElementsTableViewer.setContentProvider(new ArrayContentProvider());
        hiddenElementsTableViewer.setInput(getHiddenElements());
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#aboutToBeShown()
     */
    public void aboutToBeShown()
    {
        super.aboutToBeShown();

        visibleElementsTableViewer.addDoubleClickListener(visibleElementsTableDoubleClickListener);
        hiddenElementsTableViewer.addDoubleClickListener(hiddenElementsTableDoubleClickListener);

        hideButton.addSelectionListener(hideButtonSelectionAdapter);
        showButton.addSelectionListener(showButtonSelectionAdapter);
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeHidden()
     */
    public void aboutToBeHidden()
    {
        super.aboutToBeHidden();

        visibleElementsTableViewer.removeDoubleClickListener(visibleElementsTableDoubleClickListener);
        hiddenElementsTableViewer.removeDoubleClickListener(hiddenElementsTableDoubleClickListener);

        if (!hideButton.isDisposed())
        {
            hideButton.removeSelectionListener(hideButtonSelectionAdapter);
            showButton.removeSelectionListener(showButtonSelectionAdapter);
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
     */
    public boolean shouldUseExtraSpace()
    {
        return true;
    }

    /**
     * Get the LabelProvider to use to display the Object
     * 
     * @return ILabelProvider
     */
    protected ILabelProvider getLabelProvider()
    {
        if (labelProvider == null)
        {
            labelProvider = new LabelProvider()
            {
                /** @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object) */
                public Image getImage(Object element)
                {
                    return ModelerImageRegistry.getImage("EDGE_OBJECT");
                }
            };
        }

        return labelProvider;
    }

    /**
     * Get the list of visible EdgeObject IDs for the current selected GraphElement.
     * 
     * @return List the list of EdgeObject IDs that are visible
     */
    protected List<String> getVisibleElements()
    {
        List<String> choiceOfValues = new ArrayList<String>();

        for (DiagramElement currentSelectedElt : getDiagEltList())
        {
            for (DiagramElement diagElt : ((GraphElement) currentSelectedElt).getContained())
            {
                if (diagElt instanceof EdgeObject && ((EdgeObject) diagElt).isVisible() && !choiceOfValues.contains(((EdgeObject) diagElt).getId()))
                {
                    // Fix #809
                    if (EdgeObjectBehavior.getInstance().edgeObjectsBehavior((EdgeObject) diagElt))
                    // EndFix #809
                    {
                        choiceOfValues.add(((EdgeObject) diagElt).getId());
                    }
                }
            }
        }
        return choiceOfValues;
    }

    /**
     * Get the list of EdgeObject IDs contained by the current selected GraphElement which are hidden.
     * 
     * @return List the list of EdgeObject IDs that are not visible
     */
    protected List<String> getHiddenElements()
    {
        List<String> choiceOfValues = new ArrayList<String>();

        for (DiagramElement currentSelectedElt : getDiagEltList())
        {
            for (DiagramElement diagElt : ((GraphElement) currentSelectedElt).getContained())
            {
                if (diagElt instanceof EdgeObject && !((EdgeObject) diagElt).isVisible() && !choiceOfValues.contains(((EdgeObject) diagElt).getId()))
                {
                    // Fix #809
                    if (EdgeObjectBehavior.getInstance().edgeObjectsBehavior((EdgeObject) diagElt))
                    // EndFix #809
                    {
                    choiceOfValues.add(((EdgeObject) diagElt).getId());
                    }
                    
                }
            }
        }
        return choiceOfValues;
    }

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#handleModelChanged(org.eclipse.emf.common.notify.Notification)
     */
    protected void handleModelChanged(Notification msg)
    {
        // Do nothing

    }

}
