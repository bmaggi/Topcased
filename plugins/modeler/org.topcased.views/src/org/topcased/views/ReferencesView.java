/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * Copyright (c) 2012 Airbus
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Pierre Gaufillet (Airbus) - General purpose references view
 *
 * $Id: ReferencesView.java,v 1.4 2012/07/26 05:38:10 gaufille Exp $
 **********************************************************************/

package org.topcased.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.progress.WorkbenchJob;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.utils.Utils;
import org.topcased.views.EModelElementContentProvider.WrappedEModelElement;
import org.topcased.views.internal.Messages;

/**
 * This class displays all the references to an EModelElement
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ReferencesView extends AnalysisView
{

    /**
     * The ID of the view
     */
    public static final String VIEW_ID = "org.topcased.views.ReferencesView"; //$NON-NLS-1$

    private TreeViewer referencesTree;

    /**
     * The job used to refresh the tree.
     */
    private Job refreshJob;

    /**
     * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createPartControl(Composite parent)
    {

        super.createPartControl(parent);
        referencesTree = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);

        referencesTree.setContentProvider(new EModelElementContentProvider());
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

        referencesTree.setLabelProvider(new ReferencesLabelProvider(new AdapterFactoryLabelProvider(adapterFactory)));

        referencesTree.getControl().addDisposeListener(new DisposeListener()
        {

            /**
             * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
             */
            public void widgetDisposed(DisposeEvent e)
            {
                if (refreshJob != null)
                {
                    refreshJob.cancel();
                }
            }
        });
        referencesTree.addDoubleClickListener(new IDoubleClickListener()
        {
            public void doubleClick(DoubleClickEvent event)
            {
                handleDoubleClickEvent();
            }
        });
    }

    protected void handleDoubleClickEvent()
    {

        IStructuredSelection selection = (IStructuredSelection) referencesTree.getSelection();
        Object selectedObject = ((WrappedEModelElement) selection.getFirstElement()).getWrappedEModelElement();
        Modeler topcasedEditor = Utils.getCurrentModeler();
        // TODO Take care of various common editors: MDT Papyrus, EMF tree editors, GMF editors, etc.

        if (topcasedEditor != null)
        {
            if (selectedObject instanceof Diagram && topcasedEditor.getActiveDiagram() != (Diagram) selectedObject)
            {
                topcasedEditor.setActiveDiagram((Diagram) selectedObject);
            }
            else if (selectedObject instanceof EObject)
            {
                topcasedEditor.gotoEObject((EObject) selectedObject);
            }
        }

    }

    /**
     * @see org.topcased.views.AnalysisView#refresh(org.eclipse.emf.ecore.EObject)
     */
    @Override
    protected void refresh(EObject object)
    {
        // cancel currently running job first, to prevent unnecessary redraw
        if (refreshJob != null)
        {
            refreshJob.cancel();
        }

        if (object instanceof EModelElement)
        {
            EModelElement selectedEModelElement = (EModelElement) object;
            refreshJob = createRefreshJob(selectedEModelElement);
            refreshJob.schedule(200);
            // // TODO see whether we want to refresh the view even if the
            // selected element is not an EModelElement
            // } else {
            // referencesTree.setInput(object);
        }
    }

    private Job createRefreshJob(final EModelElement selection)
    {
        Job job = new WorkbenchJob(Messages.ReferencesView_RefreshReferences)
        {

            /**
             * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
             */
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor)
            {
                if (referencesTree.getControl().isDisposed())
                {
                    return Status.CANCEL_STATUS;
                }
                try
                {
                    referencesTree.getControl().setRedraw(false);

                    referencesTree.setInput(selection);
                    referencesTree.expandAll();
                }
                finally
                {
                    // done updating the tree - set redraw back to true
                    referencesTree.getControl().setRedraw(true);
                }
                return Status.OK_STATUS;
            }

        };
        job.setSystem(true);

        return job;
    }
}
