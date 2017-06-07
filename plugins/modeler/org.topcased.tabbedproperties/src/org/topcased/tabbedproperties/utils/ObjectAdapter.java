package org.topcased.tabbedproperties.utils;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;

/**
 * Provides a single static method to adapt a given object in an EObject
 * 
 * Creation 19 sept. 06
 * 
 * @author alfredo
 * 
 */
public final class ObjectAdapter
{

    private ObjectAdapter()
    {
        // Instantiation forbidden
    }

    /**
     * Returns the EObject associated with the given object. Returns <code>null</code> if no such object can be found.
     * 
     * 
     * @param object The object to look up its associated EObject
     * @return the EObject associated to the given object, or <code>null</code> if this object does not have any.
     */
    public static EObject adaptObject(Object object)
    {
        if (object == null)
        {
            return null;
        }
        else if (object instanceof EObject)
        {
            return (EObject) object;
        }
        else if (object instanceof IAdaptable)
        {
            // Try IAdaptable
            IAdaptable adapted = (IAdaptable) object;
            Object eObject = adapted.getAdapter(EObject.class);
            if (eObject != null)
            {
                return (EObject) eObject;
            }
        }
        else
        {
            // Try registered adapter
            Object adapted = Platform.getAdapterManager().getAdapter(object, EObject.class);
            if (adapted != null)
            {
                return (EObject) adapted;
            }
        }
        return null;
    }
}
