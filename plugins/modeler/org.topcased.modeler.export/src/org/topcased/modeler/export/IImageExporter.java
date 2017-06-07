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

package org.topcased.modeler.export;

import java.io.OutputStream;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

/**
 * Interface that describes an Image exporter.<br>
 * An image exporter can convert a GEF figure into a image stream.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public interface IImageExporter
{
    /**
     * Thus method creates an image stream from a GEF figure
     * 
     * @param figure the gef figure
     * @param os the output stream where the image is serialized
     * @throws ExportException Thrown if an error occured during the conversion
     */
	void export(EditPart diagramEditPart, List<GraphicalEditPart> editParts, OutputStream os, boolean includeRelatedConnections) throws ExportException;

}