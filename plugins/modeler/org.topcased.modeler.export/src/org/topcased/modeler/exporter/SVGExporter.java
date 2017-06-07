/*******************************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.exporter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.render.awt.internal.svg.export.GraphicsSVG;
import org.topcased.modeler.export.ExportException;

/**
 * This class exports a figure into a svg file
 *
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public final class SVGExporter extends AbstractImageExporter
{
	private static final String XML_ENCODING = "UTF-8";

	protected GraphicsSVG graphicsSVG;

	@Override
	protected Graphics createGraphics(int width, int height) {
		graphicsSVG = GraphicsSVG.getInstance(new Rectangle(0, 0, width, height));
		return graphicsSVG;
	}

	public void export(EditPart diagramEditPart, List<GraphicalEditPart> editParts, OutputStream os, boolean includeRelatedConnections) throws ExportException {
		try {
			renderToGraphics(diagramEditPart, editParts, includeRelatedConnections);
			save(os);
		} finally {
			dispose();
		}
	}

	protected void dispose() {
		graphicsSVG.dispose();
	}

	protected void save(OutputStream os) throws ExportException {
		// Sets the XML encoding
		OutputFormat format = new OutputFormat();
		format.setEncoding(XML_ENCODING);
		format.setIndenting(true);
		format.setStandalone(true);

		// Serializes the document
		XMLSerializer serializer = new XMLSerializer(os, format);
		try
		{
			serializer.serialize(graphicsSVG.getRoot());
		}
		catch (IOException e)
		{
			throw new ExportException("Error during the SVG export", e);
		}
	}
}
