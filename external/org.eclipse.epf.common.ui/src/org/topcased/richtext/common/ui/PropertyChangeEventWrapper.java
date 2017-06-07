package org.topcased.richtext.common.ui;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.topcased.richtext.common.preferences.IPropertyChangeEventWrapper;

/**
 * wrapper class for property change event
 * 
 * @author Jinhua Xi
 * @since 1.5
 *
 */
public class PropertyChangeEventWrapper implements IPropertyChangeEventWrapper {

	private PropertyChangeEvent event;
	public PropertyChangeEventWrapper(PropertyChangeEvent event) {
		this.event = event;
	}
	
	   /**
     * Returns the new value of the property.
     *
     * @return the new value, or <code>null</code> if not known
     *  or not relevant (for instance if the property was removed).
     */
    public Object getNewValue() {
        return this.event.getNewValue();
    }

    /**
     * Returns the old value of the property.
     *
     * @return the old value, or <code>null</code> if not known
     *  or not relevant (for instance if the property was just
     *  added and there was no old value).
     */
    public Object getOldValue() {
        return this.event.getOldValue();
    }

    /**
     * Returns the name of the property that changed.
     * <p>
     * Warning: there is no guarantee that the property name returned
     * is a constant string.  Callers must compare property names using
     * equals, not ==.
     * </p>
     *
     * @return the name of the property that changed
     */
    public String getProperty() {
        return this.event.getProperty();
    }
    
}
