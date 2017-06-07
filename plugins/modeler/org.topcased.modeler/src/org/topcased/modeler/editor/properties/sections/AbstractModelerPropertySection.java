/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.editor.properties.ModelerPropertySheetPage;
import org.topcased.modeler.utils.Utils;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * An abstract implementation of a section in a tab in the tabbed property sheet
 * page for the modeler.
 * 
 * Creation 5 avr. 2006
 * 
 * @author jlescot
 */
public abstract class AbstractModelerPropertySection extends AbstractPropertySection
{

    /**
     * The property sheet page for this section.
     */
    protected ModelerPropertySheetPage propertySheetPage;

    /**
     * The current selected object or the first object in the selection when
     * multiple objects are selected.
     */
    protected EObject eObject;

    /**
     * The list of current selected objects.
     */
    protected List<EObject> eObjectList;

    /**
     * The current select EditPart
     */
    protected EditPart selectedEditPart;
    
    /**
     * Get the standard label width when labels for sections line up on the left
     * hand side of the composite. We line up to a fixed position, but if a
     * string is wider than the fixed position, then we use that widest string.
     * 
     * @param parent The parent composite used to create a GC.
     * @param labels The list of labels.
     * @return the standard label width.
     */
    protected int getStandardLabelWidth(Composite parent, String[] labels)
    {
        int standardLabelWidth = STANDARD_LABEL_WIDTH;
        GC gc = new GC(parent);
        int indent = gc.textExtent("XXX").x; //$NON-NLS-1$
        for (int i = 0; i < labels.length; i++)
        {
            int width = gc.textExtent(labels[i]).x;
            if (width + indent > standardLabelWidth)
            {
                standardLabelWidth = width + indent;
            }
        }
        gc.dispose();
        return standardLabelWidth;
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
    {
        super.createControls(parent, aTabbedPropertySheetPage);
        this.propertySheetPage = (ModelerPropertySheetPage) aTabbedPropertySheetPage;
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void setInput(IWorkbenchPart part, ISelection selection)
    {
        super.setInput(part, selection);
        Assert.isTrue(selection instanceof IStructuredSelection);
        if (((IStructuredSelection) selection).getFirstElement() instanceof EObject)
        {
            eObject = (EObject) ((IStructuredSelection) selection).getFirstElement();
            eObjectList = ((IStructuredSelection) selection).toList();
        }
        else if (((IStructuredSelection) selection).getFirstElement() instanceof EditPart)
        {
            selectedEditPart = (EditPart) ((IStructuredSelection) selection).getFirstElement();
            Object model = selectedEditPart.getModel();
            if (Utils.getElement((GraphElement) model) != null)
            {
                eObject = Utils.getElement((GraphElement) model);

                eObjectList = new ArrayList<EObject>();
                Iterator iter = ((IStructuredSelection) selection).iterator();
                while (iter.hasNext())
                {
                    EditPart editPart = (EditPart) iter.next();
                    if (editPart.getModel() instanceof GraphElement
                            && Utils.getElement((GraphElement) editPart.getModel()) != null)
                    {
                        eObjectList.add(Utils.getElement((GraphElement) editPart.getModel()));
                    }
                }
            }
        }
    }
    
    /**
     * TODO comment this method
     * @param object
     * @param type
     * @return
     */
    protected Object[] getChoices(EObject object, EClassifier type)
    {
        List<Object> choices = new ArrayList<Object>();
        choices.add("");
        choices.addAll(TypeCacheAdapter.getExistingTypeCacheAdapter(eObject).getReachableObjectsOfType(eObject, type));

        return choices.toArray();
    }

    @Override
    public void refresh()
    {
        super.refresh();
        boolean isEnabled = true ;
        if (eObjectList != null)
        {
            Collection<EObject> eobjects = new ArrayList<EObject>(eObjectList.size() + 1);
            eobjects.addAll(eObjectList);
            eobjects.add(eObject);
            eobjects.remove(null);
            for (EObject e : eobjects)
            {
                EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(e);
                if (domain != null)
                {
                    isEnabled &= !domain.isReadOnly(e.eResource()); 
                }
            }
        }
        setEnabled(isEnabled);
        
    }

    protected void setEnabled(boolean isEnabled)
    {
        
    }
    
    
}