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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.topcased.modeler.editor.outline.ModelLabelProvider;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.collaboration.FrontierElement.Usage;

/**
 * Abstract base class use by the two import configuration pages.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public abstract class ReferencesConfigurationPage extends WizardPage
{
    private TableViewer mappingViewer;

    private TableViewer usageViewer;

    private final ILabelProvider baseLabelProvider;

    private ComboBoxCellEditor replacementChooser;

    public ReferencesConfigurationPage(String pageName, AdapterFactory adapterFactory)
    {
        super(pageName);
        baseLabelProvider = new DecoratingLabelProvider(new ModelLabelProvider(new AdapterFactoryLabelProvider(adapterFactory)),
                ModelerPlugin.getDefault().getWorkbench().getDecoratorManager().getLabelDecorator());
    }

    protected abstract String getTopMessage();

    protected abstract String getMiddleMessage();

    protected abstract String[] getColumnNames();

    protected abstract Set<FrontierElement> getFrontierElements();

    public void createControl(Composite parent)
    {
        SashForm form = new SashForm(parent, SWT.VERTICAL);
        
        Composite contents = new Composite(form, SWT.NONE);
        contents.setLayout(new GridLayout(1, true));

        Label topLabel = new Label(contents, SWT.WRAP);
        topLabel.setText(getTopMessage());
        topLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        mappingViewer = createTableViewer(contents, getColumnNames());
        mappingViewer.setLabelProvider(new MappingLabelProvider());
        mappingViewer.setContentProvider(new MappingContentProvider());
        mappingViewer.setColumnProperties(new String[] {"original", "replacement"});
        mappingViewer.setCellModifier(new MappingCellModifier());
        replacementChooser = new ComboBoxCellEditor(mappingViewer.getTable(), new String[0], SWT.FLAT | SWT.DROP_DOWN | SWT.READ_ONLY);
        mappingViewer.setCellEditors(new CellEditor[] {null, replacementChooser});

        contents = new Composite(form, SWT.NONE);
        contents.setLayout(new GridLayout(1, true));
        Label middleLabel = new Label(contents, SWT.WRAP);
        middleLabel.setText(getMiddleMessage());
        middleLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        usageViewer = createTableViewer(contents, "Object", "Relation");
        usageViewer.setLabelProvider(new ReferenceLabelProvider());
        usageViewer.setContentProvider(new ReferenceUsageContentProvider());

        // Bind the input of the bottom table to the current selection in the top one.
        mappingViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                ISelection sel = event.getSelection();
                if (sel instanceof IStructuredSelection)
                {
                    FrontierElement elt = (FrontierElement) ((IStructuredSelection) sel).getFirstElement();
                    List<EObject> choices = elt.getCandidates();
                    String[] choiceNames = new String[choices.size()];
                    for (int i = 0; i < choiceNames.length; i++)
                    {
                        choiceNames[i] = baseLabelProvider.getText(choices.get(i));
                    }
                    replacementChooser.setItems(choiceNames);
                    usageViewer.setInput(elt);
                }
                else
                {
                    usageViewer.setInput(null);
                }
            }
        });

        form.setSashWidth(5);
        form.setWeights(new int[] { 2, 1 });
        setControl(form);
    }

    private class MappingCellModifier implements ICellModifier
    {
        public boolean canModify(Object element, String property)
        {
            if ("replacement".equals(property))
            {
            	FrontierElement fe = (FrontierElement) element;
            	return !(fe.isPerfectMatch() && (fe.getCandidates().size() == 1));
            }
            else
            {
            	return false;
            }
        }

        public Object getValue(Object element, String property)
        {
            if (element instanceof Item)
            {
                element = ((Item) element).getData();
            }
            if ("replacement".equals(property))
            {
                FrontierElement fe = (FrontierElement) element;
                EObject replacement = fe.getReplacement();
                return fe.getCandidates().indexOf(replacement);
            }
            else
            {
                return null;
            }
        }

        public void modify(Object element, String property, Object value)
        {
            if (element instanceof Item)
            {
                element = ((Item) element).getData();
            }
            if ("replacement".equals(property))
            {
                FrontierElement fe = (FrontierElement) element;
                int index = ((Integer) value).intValue();
                if (index != -1)
                {
                    EObject replacement = fe.getCandidates().get(index);
                    fe.setReplacement(replacement);
                }
                mappingViewer.refresh();
            }
        }
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (visible)
        {
            mappingViewer.setInput(getFrontierElements());
        }
        super.setVisible(visible);
    }

    private TableViewer createTableViewer(Composite parent, String... columns)
    {
        TableViewer viewer = new TableViewer(parent, SWT.BORDER);
        Table table = viewer.getTable();
        TableLayout layout = new TableLayout();
        table.setLayout(layout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setLayoutData(new GridData(GridData.FILL_BOTH));

        for (String column : columns)
        {
            TableColumn sourceCol = new TableColumn(table, SWT.LEFT);
            sourceCol.setText(column);
            layout.addColumnData(new ColumnWeightData(1, 100, true));
        }
        return viewer;
    }

    /**
     * A content provider to show all the elements for which a replacement must be selected.
     */
    private static class MappingContentProvider implements IStructuredContentProvider
    {
        @SuppressWarnings("unchecked")
        public Object[] getElements(Object inputElement)
        {
            if (inputElement instanceof Set)
            {
                Set<FrontierElement> elements = (Set<FrontierElement>) inputElement;
                return elements.toArray();
            }
            return null;
        }

        public void dispose()
        {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
        {
        }
    }

    /**
     * A label provider to show the mapping between current elements (left) and replacements (right) in columns.
     */
    private class MappingLabelProvider implements ITableLabelProvider, IColorProvider
    {
        private static final int CURRENT_COLUMN = 0;

        private static final int REPLACEMENT_COLUMN = 1;

        private List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

        public Image getColumnImage(Object element, int columnIndex)
        {
            FrontierElement fe = (FrontierElement) element;
            switch (columnIndex)
            {
                case CURRENT_COLUMN:
                    return baseLabelProvider.getImage(fe.getElement());
                case REPLACEMENT_COLUMN:
                    return baseLabelProvider.getImage(fe.getReplacement());
                default:
                    return null;
            }
        }

        public String getColumnText(Object element, int columnIndex)
        {
            FrontierElement fe = (FrontierElement) element;
            switch (columnIndex)
            {
                case CURRENT_COLUMN:
                    return baseLabelProvider.getText(fe.getElement());
                case REPLACEMENT_COLUMN:
                    return baseLabelProvider.getText(fe.getReplacement());
                default:
                    return null;
            }
        }
        
        public Color getBackground(Object element) {
        	return null;
        }
        
        public Color getForeground(Object element) {
        	FrontierElement fe = (FrontierElement) element;
        	if (!fe.isPerfectMatch())
        	{
        		return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
        	}
        	else
        	{
        		return null;
        	}
        }

        public void dispose()
        {
        }

        public boolean isLabelProperty(Object element, String property)
        {
            return true;
        }

        public void addListener(ILabelProviderListener listener)
        {
            listeners.add(listener);
        }

        public void removeListener(ILabelProviderListener listener)
        {
            listeners.remove(listener);
        }
    }

    /**
     * A content provider to show all the references which point to a given element. Given an EObject as input, the
     * content it provides is the set of References (obtained using the parent's getAllReferences()) which initially
     * point to the EObject.
     */
    private class ReferenceUsageContentProvider implements IStructuredContentProvider
    {
        public Object[] getElements(Object inputElement)
        {
            if (inputElement instanceof FrontierElement)
            {
                return ((FrontierElement) inputElement).getUsages().toArray();
            }
            else
            {
                return null;
            }
        }

        public void dispose()
        {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
        {
        }
    }

    /**
     * A label provide to show the different fields of a {@link Usage} in columns.
     */
    private class ReferenceLabelProvider implements ITableLabelProvider
    {
        private static final int SOURCE_COLUMN = 0;

        private static final int RELATION_COLUMN = 1;

        private List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

        public Image getColumnImage(Object element, int columnIndex)
        {
            Usage ref = (Usage) element;
            switch (columnIndex)
            {
                case SOURCE_COLUMN:
                    return baseLabelProvider.getImage(ref.getSource());
                case RELATION_COLUMN:
                    return null;
                default:
                    return null;
            }
        }

        public String getColumnText(Object element, int columnIndex)
        {
            Usage ref = (Usage) element;
            switch (columnIndex)
            {
                case SOURCE_COLUMN:
                    return baseLabelProvider.getText(ref.getSource());
                case RELATION_COLUMN:
                    return ref.getRelation();
                default:
                    return null;
            }
        }

        public void dispose()
        {
        }

        public boolean isLabelProperty(Object element, String property)
        {
            return true;
        }

        public void addListener(ILabelProviderListener listener)
        {
            listeners.add(listener);
        }

        public void removeListener(ILabelProviderListener listener)
        {
            listeners.remove(listener);
        }
    }
}
