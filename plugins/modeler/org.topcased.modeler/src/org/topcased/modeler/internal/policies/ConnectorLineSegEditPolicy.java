/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.policies;

import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;


/*
 * @canBeSeenBy org.eclipse.gmf.runtime.diagram.ui.*
 */
public class ConnectorLineSegEditPolicy
	extends ConnectorBendpointEditPolicy {

	/**
	 * @param lineSegMode
	 */
	public ConnectorLineSegEditPolicy() {
		super(LineMode.ORTHOGONAL_FREE);
	}
}
