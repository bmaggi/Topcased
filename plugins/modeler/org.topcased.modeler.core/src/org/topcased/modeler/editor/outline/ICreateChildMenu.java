/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.topcased.modeler.editor.MixedEditDomain;

/**
 * This interface is used to defined a contributor for the outline context menu.<br>
 * See the <code>org.topcased.modeler.outline</code> extension point.<br>
 * <br>
 * Creation : 24 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public interface ICreateChildMenu extends IMenuManager
{
    /**
     * Set the EditDomain to use in the actions
     * @param domain the edit domain
     */
    void setMixedEditDomain(MixedEditDomain domain);

    /**
     * Set the current selected objects
     * @param object the current EObject
     */
    void setSelectedEObject(EObject object);

    /**
     * Creates the actions and puts it in the context menu
     */
    void createMenuContents();
}
