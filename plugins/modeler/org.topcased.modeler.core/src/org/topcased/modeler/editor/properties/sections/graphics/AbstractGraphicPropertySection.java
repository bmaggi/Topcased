/*******************************************************************************
 * Copyright (c) 2005, 2007 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections.graphics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;

/**
 * An abstract implementation of a section associated with a graphical property
 * in a tab in the tabbed property sheet page for the modeler.
 * 
 * Creation 5 avr. 2006
 * Updated 21 Nov. 2007
 * 
 * @author jlescot
 */
public abstract class AbstractGraphicPropertySection extends AbstractPropertySection
{

    /**
     * The current selected diagram element or the first graphical element in
     * the selection when multiple objects are selected.
     */
    private DiagramElement diagElt;

    /**
     * The list of current selected diagram elements.
     */
    private List<DiagramElement> diagEltList;

    /**
     * The current select EditPart
     */
    private EditPart selectedEditPart;

    /**
     * Listener for the model notifications
     */
    private Adapter modelListener = new EContentAdapter()
    {
        public void notifyChanged(Notification notification)
        {
            super.notifyChanged(notification);
            handleModelChanged(notification);
        }
    };

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
    {
        super.createControls(parent, aTabbedPropertySheetPage);
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void setInput(IWorkbenchPart part, ISelection selection)
    {
        super.setInput(part, selection);
        Assert.isTrue(selection instanceof IStructuredSelection);
        if (((IStructuredSelection) selection).getFirstElement() instanceof EditPart)
        {
            selectedEditPart = (EditPart) ((IStructuredSelection) selection).getFirstElement();
            Object elt = selectedEditPart.getModel();
            if (elt instanceof DiagramElement)
            {
                removeListener();
                diagElt = (DiagramElement) elt;

                diagEltList = new ArrayList<DiagramElement>();
                Iterator<EditPart> iter = ((IStructuredSelection) selection).iterator();
                while (iter.hasNext())
                {
                    EditPart editPart = iter.next();
                    if (editPart.getModel() instanceof DiagramElement)
                    {
                        diagEltList.add((DiagramElement) editPart.getModel());
                    }
                }
                addListener();
            }
        }
    }
    
    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeShown()
     */
    public void aboutToBeShown()
    {
       addListener();
    }
    
    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#aboutToBeHidden()
     */
    public void aboutToBeHidden()
    {
        removeListener();
    }
    
    /**
     * Remove model listener
     */
    protected void removeListener()
    {
        if (diagElt != null && diagElt.eAdapters().contains(getModelListener()))
        {
            diagElt.eAdapters().remove(getModelListener());
        }
    }

    /**
     * Add model listener
     */
    protected void addListener()
    {
        if (diagElt != null && !diagElt.eAdapters().contains(getModelListener()))
        {
            diagElt.eAdapters().add(getModelListener());
        }
    }
    
    /**
     * @return the diagElt
     */
    protected DiagramElement getDiagElt()
    {
        return diagElt;
    }

    /**
     * @return the diagEltList
     */
    protected List<DiagramElement> getDiagEltList()
    {
        return diagEltList;
    }

    /**
     * @return the selectedEditPart
     */
    protected EditPart getSelectedEditPart()
    {
        return selectedEditPart;
    }

    /**
     * Get the model Listener
     * 
     * @return Adapter
     */
    protected Adapter getModelListener()
    {
        return modelListener;
    }
    
    @Override
    public void refresh()
    {
        super.refresh();
        Set<DiagramElement> elements = new HashSet<DiagramElement>();
        if (diagEltList != null)
        {
            elements.addAll(diagEltList);
        }
        if (diagElt != null)
        {
            elements.add(diagElt);
        }
        boolean enabled = true ;
        for (DiagramElement d : elements)
        {
            if (TopcasedAdapterFactoryEditingDomain.isEObjectReadOnly(d))
            {
                enabled = false;
                break ;
            }
        }
        setEnabled(enabled);
        
    }

    /**
     * Make this section enabled or disabled
     * @param b
     */
    protected void setEnabled(boolean enabled)
    {
        
    }

    /**
     * This method is called when an event occured on the model objects
     * 
     * @param msg the event notification
     */
    protected abstract void handleModelChanged(Notification msg);
}