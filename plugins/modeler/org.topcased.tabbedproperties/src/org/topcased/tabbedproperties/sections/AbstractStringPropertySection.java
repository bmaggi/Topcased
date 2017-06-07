/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 *               implementation
 *               Jose Alfredo Serrano (Anyware Technologies) - updated API
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import org.eclipse.swt.widgets.Event;

/**
 * An abstract implementation of a section for a field with a String property value.
 * 
 * Creation 5 apr. 2006 Updated 7 aug. 2006
 * 
 * @author Jacques LESCOT
 * @author Alfredo SERRANO
 */
public abstract class AbstractStringPropertySection extends AbstractTextPropertySection
{

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#verifyField(Event)
     */
    protected void verifyField(Event e)
    {
        // do nothing
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#getFeatureAsString()
     */
    protected String getFeatureAsString()
    {
        String string = getEObject() == null ? null : (String) getEObject().eGet(getFeature());
        if (string == null)
        {
            return "";
        }
        return string;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#getNewFeatureValue(java.lang.String)
     */
    protected Object getNewFeatureValue(String newText)
    {
        return newText;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#getOldFeatureValue()
     */
    protected Object getOldFeatureValue()
    {
        return getFeatureAsString();
    }
}