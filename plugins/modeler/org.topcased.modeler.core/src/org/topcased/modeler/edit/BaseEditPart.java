/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.listeners.DiagramElementListener;
import org.topcased.modeler.listeners.UIAdapterImpl;

/**
 * Provides infrastructure for model-listening.
 * 
 * <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public abstract class BaseEditPart extends AbstractGraphicalEditPart
{

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
     */
    @Override
    public void deactivate()
    {
        // remove decoration edit policies, so they are not refreshed later.
        removeEditPolicy(EditPolicyRoles.DECORATION_ROLE);
        super.deactivate();
    }

    /**
     * Listener for the model notifications
     */
    private Adapter modelListener = new UIAdapterImpl()
    {
        /**
         * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        @Override
        protected void safeNotifyChanged(Notification msg)
        {
            handleModelChanged(msg);
        }
    };

    /**
     * Constructor
     * 
     * @param obj the model object
     */
    public BaseEditPart(EObject obj)
    {
        super();
        setModel(obj);
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getAdapter(java.lang.Class)
     */
    @Override
    public Object getAdapter(Class key)
    {
        if (key == SnapToHelper.class)
        {
            return createSnapToHelper();
        }
        return super.getAdapter(key);
    }

    protected SnapToHelper createSnapToHelper()
    {
        List<SnapToHelper> snapStrategies = new ArrayList<SnapToHelper>();
        Boolean val = (Boolean) getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
        if (val != null && val.booleanValue())
        {
            snapStrategies.add(new SnapToGeometry(this));
        }

        val = (Boolean) getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
        if (val != null && val.booleanValue())
        {
            snapStrategies.add(new SnapToGrid(this));
        }

        if (snapStrategies.size() == 0)
        {
            return null;
        }
        if (snapStrategies.size() == 1)
        {
            return (SnapToHelper) snapStrategies.get(0);
        }

        SnapToHelper[] ss = new SnapToHelper[snapStrategies.size()];
        for (int i = 0; i < snapStrategies.size(); i++)
        {
            ss[i] = (SnapToHelper) snapStrategies.get(i);
        }
        return new CompoundSnapToHelper(ss);
    }

    /**
     * Returns the generic model listener
     * 
     * @return the model listener
     */
    protected Adapter getModelListener()
    {
        return modelListener;
    }

    /**
     * Returns the listener used to listen the graphical mode object
     * 
     * @return the listener
     */
    protected abstract DiagramElementListener getDiagramElementListener();

    /**
     * This method is called when an event occured on the model objects
     * 
     * @param msg the event notification
     */
    protected abstract void handleModelChanged(Notification msg);

    /**
     * This method updates the listening on added or removed objects
     * 
     * @param oldValue the old Object
     * @param newValue the new Object
     */
    protected void updateModelListening(Object oldValue, Object newValue)
    {
        if (oldValue != newValue)
        {
            if (oldValue != null && oldValue instanceof Notifier)
            {
                // stop listening the removed object
                ((Notifier) oldValue).eAdapters().remove(getModelListener());
            }
            if (newValue != null && newValue instanceof Notifier)
            {
                // Listen the newly created object
                if (!((Notifier) newValue).eAdapters().contains(getModelListener()))
                {
                    ((Notifier) newValue).eAdapters().add(getModelListener());
                }
            }
        }
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    @Override
    protected void createEditPolicies()
    {
        installEditPolicy(EditPolicyRoles.DECORATION_ROLE, new DecorationEditPolicy());
    }

    /** Invoke the editpart's refresh mechanism. */
    @Override
    public void refresh()
    {
        refreshGraphicalEditPolicies();
        super.refresh();
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     */
    @Override
    protected void refreshVisuals()
    {
        super.refreshVisuals();
        refreshGraphicalEditPolicies();
    }

    /**
     * Refresh the graphical edit policies installed on the edit part.
     */
    protected void refreshGraphicalEditPolicies()
    {
        EditPolicyIterator i = getEditPolicyIterator();
        while (i.hasNext())
        {
            EditPolicy policy = i.next();
            if (policy instanceof GraphicalEditPolicyEx)
            {
                ((GraphicalEditPolicyEx) policy).refresh();
            }
        }
    }

    /**
     * @return The Root editpart or NULL if the parent is null
     * @see org.eclipse.gef.editparts.AbstractEditPart#getRoot()
     */
    @Override
    public RootEditPart getRoot()
    {
        if (getParent() != null)
        {
            return super.getRoot();
        }
        else
        {
            return null;
        }
    }

    /**
     * @return The Viewer or NULL if the rootPart is null
     * @see org.eclipse.gef.editparts.AbstractEditPart#getViewer()
     */
    @Override
    public EditPartViewer getViewer()
    {
        RootEditPart rootPart = getRoot();
        if (rootPart != null)
        {
            return rootPart.getViewer();
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Gets the modeler used by this edit part.
     * 
     * @return the modeler used.
     */
    protected Modeler getModeler()
    {
        if (getViewer() instanceof ModelerGraphicalViewer)
        {
            return ((ModelerGraphicalViewer) getViewer()).getModelerEditor();
        }
        return null;
    }
}
