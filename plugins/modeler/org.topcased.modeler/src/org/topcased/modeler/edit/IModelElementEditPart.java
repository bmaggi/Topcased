/***********************************************************************************************************************
 * Copyright (c) 2010 Communication & Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.modeler.edit;

import org.eclipse.emf.ecore.EObject;

/**
 * The edit part implementing this interface is closely linked to an EMF model element.<br>
 * 
 * Creation : 11 February 2010<br>
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 3.3.0
 * 
 * @see {@link EMFGraphNodeEditPart}
 * @see {@link EMFGraphEdgeEditPart}
 */
public interface IModelElementEditPart
{
    /**
     * Retrieve the model object encapsulated into the edit part.
     * 
     * @return the EObject associated with this edit part
     */
    EObject getEObject();
}
