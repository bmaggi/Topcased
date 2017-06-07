/*******************************************************************************
 * Copyright (c) 2005,2009 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thibault Landre (Atos Origin) - Fix #772
 *    Sebastien Gabel (CS) - warning corrections, modification dragSetData() method
 *******************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.topcased.modeler.di.model.GraphElement;

/**
 * This Adapter listens to dragging operations and fill or clean the clipboard with filtered data.<br>
 * 
 * Creation : 6 dec. 2004<br>
 * Update : 4 september 2009<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class OutlineDragAdapter extends DragSourceAdapter
{
    private Viewer viewer;

    /**
     * Constructs a new drag adapter.
     * 
     * @param Viewer the viewer that provide the selected object
     */
    public OutlineDragAdapter(Viewer pViewer)
    {
        viewer = pViewer;
    }

    /**
     * Erases data from the clipboard object
     * 
     * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragFinished(DragSourceEvent event)
    {
        OutlineToDiagramTransfer.getInstance().setObject(null);
    }

    /**
     * @see org.eclipse.swt.dnd.DragSourceAdapter#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragSetData(DragSourceEvent event)
    {
        if (LocalTransfer.getInstance().isSupportedType(event.dataType))
        {
            event.data = viewer.getSelection();
        }
        else if (OutlineToDiagramTransfer.getInstance().isSupportedType(event.dataType))
        {
            event.data = getSelection();
        }
    }
    
    /**
     * Puts selection on the clipboard object
     * 
     * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragStart(DragSourceEvent event)
    {
        List<Object> data = getSelection();
        if (data.isEmpty())
        {
            // cancel drag
            event.doit = false;
        }
        OutlineToDiagramTransfer.getInstance().setObject(data);
        
    }
    
    /**
     * Computes the outline selection : filter on selection, only model elements (displayed as GraphNode) can be
     * dragged.
     * 
     * @return the list of selected wrapped model elements.
     */
    protected List<Object> getSelection()
    {
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        List<Object> transferData = new ArrayList<Object>();
        for (Iterator< ? > it = selection.iterator(); it.hasNext();)
        {
            Object sel = it.next();

            // Ignore diagram objects
            boolean checkGraphElement = checkGraphElement(sel);
            if (sel instanceof IWrapperItemProvider || sel instanceof FeatureMap.Entry || sel instanceof EObject)
            {
                if (sel instanceof GraphElement && checkGraphElement)
                {
                    transferData.add(AdapterFactoryEditingDomain.unwrap(sel));
                }
                else if (!(sel instanceof GraphElement))
                {
                    transferData.add(AdapterFactoryEditingDomain.unwrap(sel));
                }
            }
        }
        return transferData;
    }

    protected boolean checkGraphElement(Object sel)
    {
        return !(sel instanceof GraphElement);
    }

}
