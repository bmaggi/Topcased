/*******************************************************************************
 * Copyright (c) 2006 Ecliptical Software Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ecliptical Software Inc. - initial API and implementation
 *******************************************************************************/
package ca.ecliptical.emf.jaxen;

import java.util.List;

import org.jaxen.Context;
import org.jaxen.ContextSupport;
import org.jaxen.Function;
import org.jaxen.FunctionCallException;
import org.jaxen.emf.EMFXPath;

public class Current implements Function {

	public Object call(Context context, List args) throws FunctionCallException {
		ContextSupport support = context.getContextSupport();
		if (support instanceof EMFXPath.RootContextSupport) {
			Context root = ((EMFXPath.RootContextSupport) support).getRootContext();
			if (root == null)
				return null;
			
			List nodeSet = root.getNodeSet();
			int position = root.getPosition();
			if (position < nodeSet.size())
				return nodeSet.get(position);
		}
		
		return null;
	}
}
