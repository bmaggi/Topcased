/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties;

import org.topcased.tabbedproperties.TabbedPropertiesTypeMapper;

/**
 * The TypeMapper to use with the Eclipse Tabbed Properties View
 * 
 * Creation 5 avr. 2006
 *
 * @author jlescot
 */
public class ModelerTypeMapper extends TabbedPropertiesTypeMapper {

	/**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractTypeMapper#mapType(java.lang.Object)
	 */
    public Class mapType(Object object)
    {
        // Add here other code
        return super.mapType(object);
    }
}
