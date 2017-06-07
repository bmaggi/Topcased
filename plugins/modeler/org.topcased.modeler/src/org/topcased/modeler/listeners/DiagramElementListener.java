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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;

/**
 * Domain specific listener for DiagramElement.<br>
 * Listens the DiagramElement and its contained Properties.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class DiagramElementListener extends UIAdapterImpl
{
    /**
     * Install the listener on the given object and on some children
     * 
     * @param listenObject the object to listen
     */
    public void activate(EObject listenObject)
    {
        if (listenObject instanceof DiagramElement)
        {
            if (!listenObject.eAdapters().contains(this))
            {
                listenObject.eAdapters().add(this);
            }
            listenToProperties((DiagramElement) listenObject);
        }
    }

    /**
     * Remove the listener on the given object and on some children
     * 
     * @param listenObject the object to unlisten
     */
    public void deactivate(EObject listenObject)
    {
        if (listenObject instanceof DiagramElement)
        {
            unlistenToProperties((DiagramElement) listenObject);
            listenObject.eAdapters().remove(this);
        }
    }

    /**
     * This method updates the listening on added or removed objects
     * 
     * @param oldValue the old Object
     * @param newValue the new Object
     */
    protected void updateEObjectListening(Object oldValue, Object newValue)
    {
        if (oldValue != newValue)
        {
            if (newValue != null && newValue instanceof EObject)
            {
                // Listen the newly created object
                if (!((EObject) newValue).eAdapters().contains(this))
                {
                    ((EObject) newValue).eAdapters().add(this);
                }
            }
            if (oldValue != null && oldValue instanceof EObject)
            {
                // unlisten the removed object
                ((EObject) oldValue).eAdapters().remove(this);
            }
        }
    }

    /**
     * Refresh the listening of properties
     */
    private void listenToProperties(DiagramElement element)
    {
        for (Property prop : element.getProperty())
        {
            // Only listen to connectors that are not yet listened
            if (!prop.eAdapters().contains(this))
            {
                prop.eAdapters().add(this);
            }
        }
    }

    /**
     * Stop the listening of properties
     */
    private void unlistenToProperties(DiagramElement element)
    {
        for (Property prop : element.getProperty())
        {
            // Only stop listening to connectors that are not yet listened
            if (prop.eAdapters().contains(this))
            {
                prop.eAdapters().remove(this);
            }
        }
    }

    /**
     * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
     */
    @SuppressWarnings("unchecked")
    protected void safeNotifyChanged(Notification msg)
    {
        Object notifier = msg.getNotifier();
        Object newObject = msg.getNewValue();
        Object oldObject = msg.getOldValue();

        if (notifier instanceof DiagramElement)
        {

            switch (msg.getFeatureID(DiagramElement.class))
            {
                case DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE:
                    handleVisibilityChanged();
                    break;
                case DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY:
                    if (newObject instanceof List< ? >)
                    {
                        for (Property property : (List<Property>) newObject)
                        {
                            updateEObjectListening(null, property);
                            handlePropertyChanged(null, property);
                        }
                    }
                    else if (oldObject instanceof List< ? >)
                    {
                        for (Property property : (List<Property>) oldObject)
                        {
                            updateEObjectListening(property, null);
                            handlePropertyChanged(property, null);
                        }
                    }
                    else
                    {
                        updateEObjectListening(oldObject, newObject);
                        handlePropertyChanged((Property) oldObject, (Property) newObject);
                    }
                    break;
                case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                    // Do nothing
                    // Perhaps handle these modifications later
                    break;
            }
        }
        else if (notifier instanceof Property)
        {
            switch (msg.getFeatureID(Property.class))
            {
                case DiagramInterchangePackage.PROPERTY__KEY:
                case DiagramInterchangePackage.PROPERTY__VALUE:
                    handlePropertyChanged(null, (Property) notifier);
                    break;
                default:
                    break;
            }
        }
    }

    protected abstract void handleVisibilityChanged();

    /**
     * @param modifiedProperty
     * @deprecated Use the method handlePropertyChanged(Property, Property) instead
     */
    protected void handlePropertyChanged(Property modifiedProperty)
    {
        // Do nothing
    }

    protected void handlePropertyChanged(Property oldProperty, Property newProperty)
    {
        handlePropertyChanged(newProperty);
    }
}
