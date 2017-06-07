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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.RegistryToggleState;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ordering.IOrder.OrderException;
import org.topcased.modeler.utils.PriorityUtils;
import org.topcased.modeler.utils.Utils;

/**
 * The class providing services to load and retrieve order for an element
 * 
 * @author tfaure
 * 
 */
public class OrderManager
{
    

    private static String extensionPointId = "org.topcased.modeler.orderSerialization";
    
    private static String commandVirtualOrderId = "org.topcased.modeler.virtualorder"; 

    private static List<Algorithm> algorithms = null;

    private static List<IOrder> allOrders = null;

    static
    {
        readExtensionPoint();
    }

    /**
     * Returns true if the outline is in Virtual Order mode
     * @param checkCurrentModeler, check if the current Editor is a Modeler
     * @return
     */
    public static boolean isVirtualOrder(boolean checkCurrentModeler)
    {
        Modeler m = Utils.getCurrentModeler();
        if (m == null && checkCurrentModeler)
        {
            return false;
        }
        ICommandService cs = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        org.eclipse.core.commands.Command cmd = cs.getCommand(commandVirtualOrderId);
        return cmd.getState(RegistryToggleState.STATE_ID).getValue().equals(true) ;
    }
    
    /**
     * Returns true if the outline is in Virtual Order mode
     * @return
     */
    public static boolean isVirtualOrder()
    {
        return isVirtualOrder(false);
    }
    
    public static void setVirtualOrder (boolean value)
    {
        ICommandService cs = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        org.eclipse.core.commands.Command cmd = cs.getCommand(commandVirtualOrderId);
        cmd.getState(RegistryToggleState.STATE_ID).setValue(value);
    }

    private static void readExtensionPoint()
    {
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointId);
        final Map<IOrder, Integer> priorities = new HashMap<IOrder, Integer>();
        final Map<Algorithm, Integer> prioritiesAlgo = new HashMap<Algorithm, Integer>();
        allOrders = new ArrayList<IOrder>(elements.length);
        algorithms = new ArrayList<Algorithm>(elements.length);
        for (IConfigurationElement e : elements)
        {
            try
            {
                if ("Order".equals(e.getName()))
                {
                    Integer priority = PriorityUtils.getPriority(e.getAttribute("priority"));
                    IOrder createExecutableExtension = (IOrder) e.createExecutableExtension("instance");
                    allOrders.add(createExecutableExtension);
                    priorities.put(createExecutableExtension, priority);
                }
                else if ("OrderAlgorithm".equals(e.getName()))
                {
                    Integer priority = PriorityUtils.getPriority(e.getAttribute("priority"));
                    Algorithm a = new Algorithm();
                    a.setAlgo((IOrderAlgorithm) e.createExecutableExtension("algorithm"));
                    algorithms.add(a);
                    prioritiesAlgo.put(a, priority);
                    a.setPriority(priority);
                    a.setName(e.getAttribute("name"));
                }
            }
            catch (CoreException e1)
            {
            }
        }
        PriorityUtils.sort(allOrders,priorities);
        PriorityUtils.sort(algorithms,prioritiesAlgo);
    }

    /**
     * Returns a user defined order for an element, this order is saved in the model
     * This method can return less elements than the content of e
     * @param e, the eobject concerning by the order
     * @return a list of eobject, return null if no orders have been found. If the collection is empty it mean the order
     *         specifies no elements
     * @throws OrderException
     */
    public static List<EObject> getOrderForAnElement(EObject e) throws OrderException
    {
        IOrder order = getOrder(e);
        if (order != null)
        {
            try
            {
                List<EObject> orderedElements = order.getOrderedElements(e);
                return orderedElements;
            }
            catch (Exception ex)
            {
                // if a extension crashes it is not needed to quit the current process
                ex.printStackTrace();
                return null;
            }
        }
        else
        {
            throw new OrderException("The order of the element " + e + "can not be retrieve, the object is not recognized");
        }
    }

    /**
     * Returns a user defined order for an element
     * This call ensures the whole content of the element is returned
     * @param e, the eobject concerning by the order
     * @return a list of eobject, return null if no orders have been found. If the collection is empty it mean the order
     *         specifies no elements
     * @throws OrderException
     */
    public static List<EObject> getOrderForAnElementAndElementsNotOrdered(EObject e) throws OrderException
    {
        List<EObject> result = getOrderForAnElement(e);
        if (result != null)
        {
            if (result.size() != e.eContents().size())
            {
                Set<EObject> set = new HashSet<EObject>(result);
                for (EObject tmp : e.eContents())
                {
                    if (!set.contains(tmp))
                    {
                        result.add(tmp);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a user defined order for an element, this order is saved in the model
     * The order is computed using the algorithm in parameter
     * This call ensures the whole content of the element is returned
     * @param e, the eobject concerning by the order
     * @param alg, the algorithm to use
     * @return a list of eobject, return null if no orders have been found. If the collection is empty it mean the order
     *         specifies no elements
     */
    public static List<EObject> getOrderForAnElementAndElementsNotOrdered(EObject e, Algorithm alg)
    {
        if (e == null || alg == null)
        {
            return null ;
        }
        List<EObject> result = alg.getAlgo().sortChildren(e);
        if (result != null)
        {
            if (result.size() != e.eContents().size())
            {
                Set<EObject> set = new HashSet<EObject>(result);
                for (EObject tmp : e.eContents())
                {
                    if (!set.contains(tmp))
                    {
                        result.add(tmp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns a command able to save the order given in parameter 
     * the developer can execute it to save the order
     * 
     * @param context, the element concerned by the order
     * @param elementsOrdered, the list of ordered elements
     * @param domain, the editing domain to use
     * @throws OrderException
     */
    public static Command saveOrder(EObject context, List<EObject> elementsOrdered, EditingDomain domain) throws OrderException
    {
        IOrder order = getOrder(context);
        if (order != null)
        {
            Command command = order.save(context, elementsOrdered, domain);
            return command;
        }
        else
        {
            throw new OrderException("The order of the element " + context + "can not be saved");
        }
    }

    /**
     * Retrieve an {@link IOrder} for an eobject
     * IOrder provides operations to retrieve order for an element and save it
     * 
     * @param e, the context object
     * @return
     */
    public static IOrder getOrder(EObject e)
    {
        IOrder order = null;
        for (IOrder tmp : allOrders)
        {
            if (tmp.canOrder(e))
            {
                order = tmp;
                break;
            }
        }
        return order;
    }

    /**
     * Get algorithms with the same priority (most important)
     * example for an eobject e, the algorithms able to handle e are :
     * alg1 (HIGH), alg2 (HIGH), alg3 (MIDDLE)
     * The result will be alg1,alg2 
     * @param eobject, the context
     * @return a list of algorithms able to compute an order
     */
    public static List<Algorithm> getMostPrioritariesAlgorithm (EObject eobject)
    {
        if (eobject == null)
        {
            return null;
        }
        List<Algorithm> result = new LinkedList<OrderManager.Algorithm>();
        try
        {
            int priorityOk = -1;
            for (Algorithm a : algorithms)
            {
                if (a.getAlgo().canOrder(eobject))
                {
                    if (priorityOk == -1 || priorityOk == a.getPriority())
                    {
                        result.add(a);
                        priorityOk = a.getPriority();
                    }
                    else if (a.getPriority() > priorityOk)
                    {
                        break ;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Returns a list of contained element of the eobject in parameter this method uses the extension point
     * org.topcased.modeler.orderSerialization.OrderAlgorithm to retrieve the order or returns null
     * The algorithm chosen for the resolution is the first found with the highest priority 
     * @param eobject
     * @return a list of eobject corresponding to the content of the eobject sorted
     */
    public static List<EObject> getFirstComputedOrder(EObject eobject)
    {
        if (eobject == null)
        {
            return null;
        }
        List<EObject> result = null;
        try
        {
            for (Algorithm a : algorithms)
            {
                if (a.getAlgo().canOrder(eobject))
                {
                    result = a.getAlgo().sortChildren(eobject);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            // if a extension crashes it is not needed to quit the current process
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method always returns a list
     * <ol>
     * <li>checks if an order is saved in the model</li>
     * <li>otherwise it returns the econtents of the eobject</li>
     * </ol>
     * 
     * @param e, the eobject for content
     * @return
     */
    public static List<EObject> getOrderStoredOrEContents(EObject e)
    {
        if (e == null)
        {
            return null;
        }
        List<EObject> result = null;
        try
        {
            result = getOrderForAnElement(e);
        }
        catch (OrderException e1)
        {
        }
        if (result == null)
        {
            result = e.eContents();
        }
        return result;
    }
    
    /**
     * This method always returns a list
     * <ol>
     * <li>checks if an order is saved in the model</li>
     * <li>checks if an algorithm can be computed (the order is not saved)</li>
     * <li>otherwise it returns the econtents of the eobject</li>
     * </ol>
     * 
     * @param e, the eobject for content
     * @return
     */
    public static List<EObject> getOrderComputedOrStoredOrEContents(EObject e)
    {
        if (e == null)
        {
            return null;
        }
        List<EObject> result = null;
        try
        {
            result = getOrderForAnElement(e);
        }
        catch (OrderException e1)
        {
        }
        if (result == null)
        {
            result = getFirstComputedOrder(e);
        }
        if (result == null)
        {
            result = e.eContents();
        }
        return result;
    }

    
    /**
     * A representation of an algorithm
     * @author tfaure
     *
     */
    public static class Algorithm 
    {
        private String name;
        private int priority ;
        private IOrderAlgorithm algo ;
        public void setName(String name)
        {
            this.name = name;
        }
        public String getName()
        {
            return name;
        }
        public void setPriority(int priority)
        {
            this.priority = priority;
        }
        public int getPriority()
        {
            return priority;
        }
        public void setAlgo(IOrderAlgorithm algo)
        {
            this.algo = algo;
        }
        public IOrderAlgorithm getAlgo()
        {
            return algo;
        }
    }

}
