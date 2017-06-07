/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.listeners;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;

/**
 * Domain specific listener for GraphEdge.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class GraphEdgeListener extends GraphElementListener
{
    /**
     * @see org.topcased.modeler.listeners.GraphElementListener#activate(org.eclipse.emf.ecore.EObject)
     */
    public void activate(EObject listenObject)
    {
        super.activate(listenObject);
        if (listenObject instanceof GraphEdge)
        {
            listenToAnchors((GraphEdge) listenObject);
            listenToEdgeObjects((GraphEdge) listenObject);
        }
    }

    /**
     * @see org.topcased.modeler.listeners.GraphElementListener#deactivate(org.eclipse.emf.ecore.EObject)
     */
    public void deactivate(EObject listenObject)
    {
        if (listenObject instanceof GraphEdge)
        {
            unlistenToEdgeObjects((GraphEdge) listenObject);
            unlistenToAnchors((GraphEdge) listenObject);
        }
        super.deactivate(listenObject);
    }

    /**
     * Refresh the listening of anchors
     */
    private void listenToAnchors(GraphEdge edge)
    {
        // Iterates on anchors
        for (Iterator<GraphConnector> it = edge.getAnchor().iterator(); it.hasNext();)
        {
            GraphConnector anchor = it.next();

            // Only listen to anchors that are not yet listened
            if (!anchor.eAdapters().contains(this))
            {
                anchor.eAdapters().add(this);
            }
        }
    }

    /**
     * Stop the listening of anchors
     */
    private void unlistenToAnchors(GraphEdge edge)
    {
        // Iterates on anchors
        for (Iterator<GraphConnector> it = edge.getAnchor().iterator(); it.hasNext();)
        {
            GraphConnector anchor = it.next();
            anchor.eAdapters().remove(this);
        }
    }

    /**
     * Refresh the listening of EdgObjects
     */
    private void listenToEdgeObjects(GraphEdge edge)
    {
        // Iterates on children
        for (Iterator<DiagramElement> it = edge.getContained().iterator(); it.hasNext();)
        {
            DiagramElement element = it.next();

            // Only listen to edge objects that are not yet listened
            if (element instanceof EdgeObject && !element.eAdapters().contains(this))
            {
                element.eAdapters().add(this);
            }
        }
    }

    /**
     * Stop the listening of EdgeObjects
     */
    private void unlistenToEdgeObjects(GraphEdge edge)
    {
        // Iterates on children
        for (Iterator<DiagramElement> it = edge.getContained().iterator(); it.hasNext();)
        {
            DiagramElement element = it.next();

            // Only listen to edge objects that are not yet listened
            if (element instanceof EdgeObject)
            {
                element.eAdapters().remove(this);
            }
        }
    }

    /**
     * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
     */
    protected void safeNotifyChanged(Notification msg)
    {
        super.safeNotifyChanged(msg);

        Object notifier = msg.getNotifier();
        Object newObject = msg.getNewValue();
        Object oldObject = msg.getOldValue();

        if (notifier instanceof GraphElement)
        {
            switch (msg.getFeatureID(GraphElement.class))
            {
                case DiagramInterchangePackage.GRAPH_EDGE__CONTAINED:
                    if (newObject instanceof EdgeObject || oldObject instanceof EdgeObject)
                    {
                        updateEObjectListening(oldObject, newObject);
                        if (newObject != null)
                        {
                            handleEdgeObjectChanged((EdgeObject) newObject);
                        }
                    }
                    break;
                case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                    updateEObjectListening(oldObject, newObject);
                    handleConnectorChanged();
                    break;
                case DiagramInterchangePackage.GRAPH_EDGE__WAYPOINTS:
                    handleWaypointsChanged();
                    break;
            }
        }
        if (notifier instanceof EdgeObject)
        {
            handleEdgeObjectChanged((EdgeObject) notifier);
        }
    }

    /**
     * @see org.topcased.modeler.listeners.GraphElementListener#handleContainmentChanged()
     */
    protected void handleContainmentChanged()
    {
        // Do nothing
    }

    /**
     * @see org.topcased.modeler.listeners.GraphElementListener#handlePresentationChanged()
     */
    protected void handlePresentationChanged()
    {
        // Do nothing
    }

    protected abstract void handleWaypointsChanged();

    protected abstract void handleEdgeObjectChanged(EdgeObject modifiedEdgeObject);

}
