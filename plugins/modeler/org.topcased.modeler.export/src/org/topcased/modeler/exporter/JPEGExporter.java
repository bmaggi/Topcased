/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.exporter;

import org.eclipse.swt.SWT;

/**
 * Export a diagram into a JPEG file
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="tristan.faure@atosorigin.com">Tristan Faure</a>
 * Fix bug #3754 now {@link JPEGExporter} inherits from SWT Image Exporter
 */
public final class JPEGExporter extends AbstractSWTImageExporter
{

	@Override
	protected int getSWTFormat() {
		return SWT.IMAGE_JPEG;
	}
}
