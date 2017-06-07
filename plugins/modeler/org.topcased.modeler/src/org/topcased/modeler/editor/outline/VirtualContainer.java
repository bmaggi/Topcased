/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

/**
 * This interface defines the service a virtual container has to provide
 * @author Tristan FAURE
 *
 */
public interface VirtualContainer
{
    /** The eclass to match for the virtual container  */
    EClass getEClassToMatch() ;
    
    /** The children for the virtual container */
    Collection<EObject> getChildren(EObject eobject);
    
    /** The label to display in outline */
    String getLabel(EObject eobject) ;
    
    /** The icon of the element in the outline*/ 
    Image getIcon(EObject eobject) ;
    
}
