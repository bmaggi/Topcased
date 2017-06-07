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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;

/**
 * Domain specific listener for GraphElement.<br>
 * Listens the GraphElement and its contained Connectors.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class GraphElementListener extends DiagramElementListener
{
    /**
     * @see org.topcased.modeler.listeners.DiagramElementListener#activate(org.eclipse.emf.ecore.EObject)
     */
    public void activate(EObject listenObject)
    {
        super.activate(listenObject);
        if (listenObject instanceof GraphElement)
        {
            listenToConnectors((GraphElement) listenObject);
            listenToSemanticModel((GraphElement) listenObject);
        }
    }

    /**
     * @see org.topcased.modeler.listeners.DiagramElementListener#deactivate(org.eclipse.emf.ecore.EObject)
     */
    public void deactivate(EObject listenObject)
    {
        if (listenObject instanceof GraphElement)
        {
            unlistenToSemanticModel((GraphElement) listenObject);
            unlistenToConnectors((GraphElement) listenObject);
        }
        super.deactivate(listenObject);
    }

    /**
     * Refresh the listening of connectors
     * 
     * @param element the GraphElement
     */
    private void listenToConnectors(GraphElement element)
    {
        // Iterates on connectors
        for (GraphConnector connector : element.getAnchorage())
        {
            // Only listen to connectors that are not yet listened
            if (!connector.eAdapters().contains(this))
            {
                connector.eAdapters().add(this);
            }
        }
    }

    /**
     * Stop the listening of connectors
     * 
     * @param element the GraphElement
     */
    private void unlistenToConnectors(GraphElement element)
    {
        // Iterates on connectors
        for (GraphConnector connector : element.getAnchorage())
        {
            connector.eAdapters().remove(this);
        }
    }

    /**
     * Refresh the listening of the SemanticModelBridge
     * 
     * @param element the GraphElement
     */
    private void listenToSemanticModel(GraphElement element)
    {
        if (!element.getSemanticModel().eAdapters().contains(this))
        {
            element.getSemanticModel().eAdapters().add(this);
        }
    }

    /**
     * Stop the listening of the SemanticModelBridge
     * 
     * @param element the GraphElement
     */
    private void unlistenToSemanticModel(GraphElement element)
    {
        if (element.getSemanticModel().eAdapters().contains(this))
        {
            element.getSemanticModel().eAdapters().remove(this);
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
                case DiagramInterchangePackage.GRAPH_ELEMENT__POSITION:
                    handlePositionChanged();
                    break;
                case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                    handleContainmentChanged();
                    break;
                case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                    updateEObjectListening(oldObject, newObject);
                    break;
                case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                    updateEObjectListening(oldObject, newObject);
                    break;
                case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                    // Do nothing
                    // Perhaps handle these modifications later
                    break;
            }
        }
        else if (msg.getNotifier() instanceof GraphConnector)
        {
            switch (msg.getFeatureID(GraphConnector.class))
            {
                case DiagramInterchangePackage.GRAPH_CONNECTOR__GRAPH_EDGE:
                case DiagramInterchangePackage.GRAPH_CONNECTOR__GRAPH_ELEMENT:
                case DiagramInterchangePackage.GRAPH_CONNECTOR__POSITION:
                    handleConnectorChanged();
                    break;
            }
        }
        else if (msg.getNotifier() instanceof SemanticModelBridge)
        {
            switch (msg.getFeatureID(SemanticModelBridge.class))
            {
                case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
                    handlePresentationChanged();
                    break;
            }
        }
    }

    protected abstract void handlePositionChanged();

    protected abstract void handleContainmentChanged();

    protected abstract void handleConnectorChanged();

    protected abstract void handlePresentationChanged();

}
