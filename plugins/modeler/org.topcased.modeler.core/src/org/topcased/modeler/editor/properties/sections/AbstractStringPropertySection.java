/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections;

/**
 * An abstract implementation of a section for a field with a String property
 * value.
 * 
 * @author Jacques LESCOT
 */
public abstract class AbstractStringPropertySection extends AbstractTextPropertySection
{

    /**
     * @see org.topcased.modeler.editor.properties.sections.AbstractTextPropertySection#isEqual(java.lang.String)
     */
    protected boolean isEqual(String newText)
    {
        return getFeatureAsText().equals(newText);
    }

    /**
     * @see org.topcased.modeler.editor.properties.sections.AbstractTextPropertySection#getFeatureAsText()
     */
    protected String getFeatureAsText()
    {
        String string = (String) eObject.eGet(getFeature());
        if (string == null)
        {
            return "";
        }
        return string;
    }

    /**
     * @see org.topcased.modeler.editor.properties.sections.AbstractTextPropertySection#getFeatureValue(java.lang.String)
     */
    protected Object getFeatureValue(String newText)
    {
        return newText;
    }
}