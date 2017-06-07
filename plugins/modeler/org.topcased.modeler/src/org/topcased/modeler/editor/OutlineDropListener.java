/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Emmanuel Rochefort (Atos Origin) - add drop actions mechanism
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Emilien Perico (Atos Origin) - add behavior for drag&drop with ctrl key
 *******************************************************************************/
package org.topcased.modeler.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.topcased.modeler.DropActionAdapter;
import org.topcased.modeler.edit.DynamicInstanceEditPartController;
import org.topcased.modeler.editor.outline.OutlineToDiagramTransfer;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.tools.Importer;

/**
 * Listener that manage the outline to diagram dragging. <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class OutlineDropListener extends AbstractTransferDropTargetListener
{
    private static final String EXTENSION_CLASS_PROPERTY = "class";

    private Modeler modeler;

    private DropFactory factory;

    private Importer importer;

    private static final String EXTENSION_POINT_NAMESPACE = "org.topcased.modeler";
    private static final String EXTENSION_POINT_NAME = "dropactions";
    private List<DropActionAdapter> dropActionAdapters;
    
    /**
     * Constructor
     * 
     * @param viewer the GraphicalViewer of the editing window
     * @param mod the Topcased editor
     */
    public OutlineDropListener(GraphicalViewer viewer, Modeler mod)
    {
        super(viewer, OutlineToDiagramTransfer.getInstance());
        this.modeler = mod;
        
        // Adding all contributions on DropAction extension point
        dropActionAdapters = new ArrayList<DropActionAdapter>();
        IConfigurationElement[] contributions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_NAMESPACE, EXTENSION_POINT_NAME);
        
        IConfigurationElement dropActionExtension = null;
        for (int i = 0; i < contributions.length; i++) 
        {
           dropActionExtension = contributions[i];
           if(dropActionExtension != null) {
               try {
                  DropActionAdapter dropAction =
                     (DropActionAdapter)dropActionExtension.createExecutableExtension(EXTENSION_CLASS_PROPERTY);
                  dropActionAdapters.add(dropAction);
               } catch (CoreException e) {
                   ModelerPlugin.displayDialog("Extension failure", "Error occurs on the extension point: "+ EXTENSION_POINT_NAME, IStatus.WARNING);
               }
            }
        }
    }

    /**
     * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#getTargetRequest()
     */
    protected Request getTargetRequest()
    {
        List transfer = (List) ((OutlineToDiagramTransfer) getTransfer()).getObject();
        importer = new Importer(modeler, transfer);
        return importer.getCreateRequest();
    }

    /**
     * Called whenever the User drags over the target. By default, the target
     * Request and target EditPart are updated, feedback is shown, and
     * auto-expose occurs.
     * 
     * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#handleDragOver()
     */
    protected void handleDragOver()
    {
        getCurrentEvent().detail = DND.DROP_COPY;
        super.handleDragOver();
    }

    /**
     * Gets the drag object.
     * 
     * @param transfer the transfer
     * 
     * @return a list of EObject containing in the draged objects
     */
    public static List<?> getDragObject(Transfer transfer)
    {
        List<?> objects = new ArrayList<Object>();

        if (transfer instanceof OutlineToDiagramTransfer)
        {
            Object dragObject = ((OutlineToDiagramTransfer) transfer).getObject();
            if (dragObject instanceof List<?>)
            {
                objects = (List<?>) dragObject;

                // We delete all not usable object
                for (Object obj : objects)
                {
                    if (!(obj instanceof EObject))
                    {
                        objects.remove(obj);
                    }
                }
            }
        }
        return objects;
    }
    
    /**
     * Overridden to select the created object.
     * 
     * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#handleDrop()
     */
    protected void handleDrop()
    {
        if (getTargetEditPart() instanceof GraphicalEditPart)
        {
        	// Search Enable and Exclusive DropActionAdapters
        	boolean bExclusiveDropMode = false;
        	List<DropActionAdapter> enabledAdapters = new ArrayList<DropActionAdapter>();
        	
        	for(DropActionAdapter dropAction : dropActionAdapters)
            {
        		// We use all Adapter in the no exclusive mode or only exclusive adapters
        		if((bExclusiveDropMode == false) || (dropAction.isExclusiveDropAction()))
        		{
        			if(dropAction.isEnable(null, getTransfer(), getTargetEditPart()))
        			{
        				if(dropAction.isExclusiveDropAction())
        				{
        					if(bExclusiveDropMode == false)
        					{
        						// The previous added adapters was not exclusive
        						// we do not used them
        						enabledAdapters.clear();

        						bExclusiveDropMode = true;
        					}
        				}
    					enabledAdapters.add(dropAction);
        			}
        		}
            }        	       
        	
            try
            {
            	if(bExclusiveDropMode == false)
            	{
            	    importer.setCtrlKeyDown(getCurrentEvent().detail == DND.DROP_COPY);
            		importer.setLocation(getDropLocation());
            		importer.setTargetEditPart((GraphicalEditPart) getTargetEditPart());
            		importer.run(new NullProgressMonitor());
            		
            		// We applying all Drop actions
            		for(DropActionAdapter dropAction : enabledAdapters)
            		{  
            			dropAction.handleDrop(modeler, getTransfer(), getTargetEditPart());
            		}
            	}
            	else
            	{
            		// Only one adapter, we apply his action
            		if(enabledAdapters.size() == 1)
            		{
            			enabledAdapters.get(0).handleDrop(modeler, getTransfer(), getTargetEditPart());
            		}

            		// Many DropAdapter can be apply, we must confirm the applying dropAction 
            		else
            		{
            			for(DropActionAdapter dropAction : enabledAdapters)
            			{
            				if(MessageDialog.openConfirm(ModelerPlugin.getActiveWorkbenchShell(), "DropAction",
            				"Apply the action ?"))
            				{
            					dropAction.handleDrop(modeler, getTransfer(), getTargetEditPart());
            				}
            			}
            		}
            	}
            }
            catch (BoundsFormatException bfe)
            {
                ModelerPlugin.displayDialog("Drag'n Drop Bounds Problem", "A problem occured during drag'n drop :\n"
                        + bfe.getMessage(), IStatus.ERROR);
            }
            catch (InterruptedException ie)
            {
                ModelerPlugin.displayDialog("Operation Canceled", "The import was stopped.", IStatus.INFO);
            }
            catch (Exception e)
            {
                ModelerPlugin.displayDialog("Drag'n Drop Problem", "A problem occured during drag'n drop :\n"
                        + e.getMessage(), IStatus.ERROR);
            }
        }
    }

    /**
     * Over-ridden so that the cursor can be updated to "disallow" when the
     * command is not executable
     * 
     * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#isEnabled(org.eclipse.swt.dnd.DropTargetEvent)
     */
    public boolean isEnabled(DropTargetEvent event)
    {
        boolean result = super.isEnabled(event);
        
        // Use to dran'n drop custom element defined in 
        // the extension point org.topcased.modeler.customEditPart 
        updateTargetEditPart();
        result &= !DynamicInstanceEditPartController.instance.isNotDropable(getTransfer(), getTargetEditPart());
        
        if (result)
        {
            updateTargetRequest();
            updateTargetEditPart();
            Command cmd = getCommand();
            result = cmd != null && cmd.canExecute();
        }

        // Update the DropTargetEvent value for each adapters
        for(DropActionAdapter dropAction : dropActionAdapters)
        {                   
        	dropAction.updateDropTargetEvent(event);            
        }        
        
        // Ask to each dropActionAdapter if the drop action is enabled
        // At least once is enough to say that one or more drop action is authorized 
        for(DropActionAdapter dropAction : dropActionAdapters)
        {                   
        	if(dropAction.isEnable(event, getTransfer(), getTargetEditPart()))
            {
        	    result = true;
            }     
        }       
        if (!result)
        {
        	// Use to dragn'n drop custom element defined in 
        	// the extension point org.topcased.modeler.customEditPart 
            result = DynamicInstanceEditPartController.instance.isDropable(getTransfer(), getTargetEditPart());
            if (result)
            {
                updateTargetRequest();
                updateTargetEditPart();
            }
        }
        return result;
    }

    /**
     * Update the Request
     * 
     * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#updateTargetRequest()
     */
    protected void updateTargetRequest()
    {
        CreateRequest req = (CreateRequest) getTargetRequest();
        req.setLocation(getDropLocation());
    }
}
