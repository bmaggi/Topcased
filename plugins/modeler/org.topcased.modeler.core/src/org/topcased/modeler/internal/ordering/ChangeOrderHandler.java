/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal.ordering;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.editor.outline.ModelNavigator;
import org.topcased.modeler.internal.ordering.IOrder.OrderException;
import org.topcased.modeler.internal.ordering.OrderManager.Algorithm;
import org.topcased.modeler.utils.CommandAdapter;

/**
 * Execution of change order of an element
 * 
 * @author tfaure
 * 
 */
public class ChangeOrderHandler extends AbstractHandler
{

    public Object execute(final ExecutionEvent event) throws ExecutionException
    {
        boolean oldValue = ModelNavigator.getNoRefresh();
        try
        {
            ModelNavigator.setNoRefresh(true);
            IEditorPart currentEditor = HandlerUtil.getActiveEditor(event);
            if (currentEditor == null)
            {
                if (HandlerUtil.getActivePart(event) instanceof ContentOutline)
                {
                    ContentOutline outline = (ContentOutline) HandlerUtil.getActivePart(event);
                    currentEditor = (IEditorPart) outline.getAdapter(IEditorPart.class);
                }
            }
            if (currentEditor instanceof Modeler)
            {
                final Modeler modeler = (Modeler) currentEditor;
                try
                {
                    final Collection<EObject> allEobjects = new LinkedList<EObject>();
                    new ProgressMonitorDialog(HandlerUtil.getActiveShell(event)).run(false, true, new IRunnableWithProgress()
                    {
                        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
                        {
                            TopcasedAdapterFactoryEditingDomain domain = (TopcasedAdapterFactoryEditingDomain) modeler.getEditingDomain();
                            CompoundCommand compound = new CompoundCommand();
                            compound.append(new CommandAdapter()
                            {

                                @Override
                                public void undo()
                                {
                                    modeler.refreshOutline();
                                }
                            });
                            IStructuredSelection iStructuredSelection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
                            monitor.beginTask("Compute Order", iStructuredSelection.size());
                            for (Iterator< ? > i = iStructuredSelection.iterator(); i.hasNext();)
                            {
                                Object tmp = i.next();
                                if (tmp instanceof EObject)
                                {
                                    EObject eobject = (EObject) tmp;
                                    Command manage = manage(eobject, event, modeler, domain);
                                    if (manage != null)
                                    {
                                        compound.append(manage);
                                        allEobjects.add(eobject);
                                    }
                                }
                                if (monitor.isCanceled())
                                {
                                    throw new InterruptedException("Cancel");
                                }
                                monitor.worked(1);
                            }
                            if (!monitor.isCanceled() && !compound.isEmpty())
                            {
                                monitor.beginTask("Apply Order", 1);
                                compound.append(new CommandAdapter()
                                {

                                    @Override
                                    public void redo()
                                    {
                                        modeler.refreshOutline();
                                    }

                                });
                                domain.getCommandStack().execute(compound);
                                if (monitor.isCanceled())
                                {
                                    throw new InterruptedException("Cancel");
                                }
                            }
                        }
                    });
                    if (!OrderManager.isVirtualOrder())
                    {
                        MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information",
                                "Your outline displays currently the content of an element.\nTo see the result of automatic order applied, the outline displays now virtual order.");
                        OrderManager.setVirtualOrder(true);
                    }
                    modeler.refreshOutline();
                }
                catch (InvocationTargetException e)
                {
                }
                catch (InterruptedException e)
                {
                    if ("Cancel".equals(e.getMessage()))
                    {
                        MessageDialog.openWarning(HandlerUtil.getActiveShell(event), "Warning", "The process has been canceled");
                    }
                }
            }
        }
        finally
        {
            ModelNavigator.setNoRefresh(oldValue);
        }
        return null;
    }

    protected Command manage(EObject selection, ExecutionEvent event, Modeler modeler, TopcasedAdapterFactoryEditingDomain domain)
    {
        List<EObject> initialOrder;
        try
        {
            Algorithm chosen = null;
            List<Algorithm> orders = OrderManager.getMostPrioritariesAlgorithm(selection);
            if (orders.size() == 1)
            {
                chosen = orders.get(0);
            }
            else
            {
                ListDialog dialog = new ListDialog(HandlerUtil.getActiveShell(event));
                dialog.setMessage("Some algorithms have been found to order your selection\nPlease choose the algorithm you want to apply");
                dialog.setTitle("Initial Order Algorithm Selection");
                dialog.setContentProvider(new IStructuredContentProvider()
                {

                    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
                    {
                    }

                    public void dispose()
                    {
                    }

                    public Object[] getElements(Object inputElement)
                    {
                        if (inputElement instanceof Collection< ? >)
                        {
                            return ((Collection) inputElement).toArray();
                        }
                        return null;
                    }
                });
                dialog.setLabelProvider(new ILabelProvider()
                {

                    public void removeListener(ILabelProviderListener listener)
                    {
                    }

                    public boolean isLabelProperty(Object element, String property)
                    {
                        return false;
                    }

                    public void dispose()
                    {

                    }

                    public void addListener(ILabelProviderListener listener)
                    {
                    }

                    public String getText(Object element)
                    {
                        return ((Algorithm) element).getName();
                    }

                    public Image getImage(Object element)
                    {
                        return null;
                    }
                });
                dialog.setInput(orders);
                if (dialog.open() == ListDialog.OK)
                {
                    Object[] result = dialog.getResult();
                    if (result != null && result.length > 0)
                    {
                        chosen = (Algorithm) result[0];
                    }
                }
            }
            if (chosen != null)
            {
                initialOrder = OrderManager.getOrderForAnElementAndElementsNotOrdered(selection, chosen);
                Command command = OrderManager.saveOrder(selection, initialOrder, domain);
                return command;
            }
        }
        catch (OrderException e1)
        {
            MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error", "The order can not be saved :\n" + e1.getMessage());
        }
        return null;
    }

}
