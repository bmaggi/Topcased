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

import java.io.OutputStream;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.export.ExportException;

/**
 * This abstract class defines basic actions for exporters that uses SWT classes to make the conversion.<br>
 * <br>
 * Some methods are copied from {@link org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil}
 * 
 * @see org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class AbstractSWTImageExporter extends AbstractImageExporter
{
	protected Image image;

	protected GC gc;

	protected SWTGraphics swtGraphics;

	protected void dispose() {
		if (swtGraphics != null) {
			swtGraphics.dispose();
		}

		if (image != null && !image.isDisposed()) {
			image.dispose();
		}

		if (gc != null && !gc.isDisposed()) {
			gc.dispose();
		}
	}

	protected Graphics createGraphics(int width, int height) {
		image = new Image(getDisplay(), new org.eclipse.swt.graphics.Rectangle(0, 0, width, height));
		gc = new GC(image);
		swtGraphics = new SWTGraphics(gc);
		swtGraphics.setAdvanced(true);
		swtGraphics.setAntialias(SWT.ON);

		return swtGraphics;
	}

	/**
	 * @see org.topcased.modeler.export.IImageExporter#export(org.eclipse.draw2d.IFigure, java.io.OutputStream)
	 */
	public void export(EditPart diagramEditPart, List<GraphicalEditPart> editParts, OutputStream os, boolean includeRelatedConnections) throws ExportException
	{
		try {
			renderToGraphics(diagramEditPart, editParts, includeRelatedConnections);
			save(os);
		} finally {
			dispose();
		}
	}

	/**
	 * Save the SWT image into the given output stream using the SWT format defined by subclass
	 * 
	 * @param os the output stream
	 * @param image the SWT image
	 */
	protected void save(OutputStream os)
	{
		ImageData imageData = createImageData(image);

		ImageLoader imageLoader = new ImageLoader();
		imageLoader.data = new ImageData[] {imageData};
		imageLoader.logicalScreenHeight = image.getBounds().width;
		imageLoader.logicalScreenHeight = image.getBounds().height;
		imageLoader.save(os, getSWTFormat());
	}

	/**
	 * Defines the export format of the image.
	 * 
	 * @return The image format : one of the constant values defined in the {@link SWT} class (ex : SWT.IMAGE_GIF)
	 */
	protected abstract int getSWTFormat();

	/**
	 * Retrieve the image data for the image, using a palette of at most 256 colours.
	 * 
	 * @param image the SWT image.
	 * @return new image data.
	 */
	protected ImageData createImageData(Image image)
	{

		ImageData imageData = image.getImageData();

		/**
		 * If the image depth is 8 bits or less, then we can use the existing image data.
		 */
		if (imageData.depth <= 8)
		{
			return imageData;
		}

		/**
		 * get an 8 bit imageData for the image
		 */
		ImageData newImageData = get8BitPaletteImageData(imageData);

		/**
		 * if newImageData is null, it has more than 256 colours. Use the web safe pallette to get an 8 bit image data
		 * for the image.
		 */
		if (newImageData == null)
		{
			newImageData = getWebSafePalletteImageData(imageData);
		}

		return newImageData;
	}

	/**
	 * Retrieve an image data with an 8 bit palette for an image. We assume that the image has less than 256 colours.
	 * 
	 * @param imageData the imageData for the image.
	 * @return the new 8 bit imageData or null if the image has more than 256 colours.
	 */
	protected ImageData get8BitPaletteImageData(ImageData imageData)
	{
		PaletteData palette = imageData.palette;
		RGB[] colours = new RGB[256];
		PaletteData newPaletteData = new PaletteData(colours);
		ImageData newImageData = new ImageData(imageData.width, imageData.height, 8, newPaletteData);

		int lastPixel = -1;
		int newPixel = -1;
		for (int i = 0; i < imageData.width; ++i)
		{
			for (int j = 0; j < imageData.height; ++j)
			{
				int pixel = imageData.getPixel(i, j);

				if (pixel != lastPixel)
				{
					lastPixel = pixel;

					RGB colour = palette.getRGB(pixel);
					for (newPixel = 0; newPixel < 256; ++newPixel)
					{
						if (colours[newPixel] == null)
						{
							colours[newPixel] = colour;
							break;
						}
						if (colours[newPixel].equals(colour))
						{
							break;
						}
					}

					if (newPixel >= 256)
					{
						/**
						 * Diagram has more than 256 colors, return null
						 */
						return null;
					}
				}

				newImageData.setPixel(i, j, newPixel);
			}
		}

		RGB colour = new RGB(0, 0, 0);
		for (int k = 0; k < 256; ++k)
		{
			if (colours[k] == null)
			{
				colours[k] = colour;
			}
		}

		return newImageData;
	}

	/**
	 * Retrieves a web safe pallette. Our palette will be 216 web safe colours and the remaining filled with white.
	 * 
	 * @return array of 256 colours.
	 */
	protected RGB[] getWebSafePallette()
	{
		RGB[] colours = new RGB[256];
		int i = 0;
		for (int red = 0; red <= 255; red = red + 51)
		{
			for (int green = 0; green <= 255; green = green + 51)
			{
				for (int blue = 0; blue <= 255; blue = blue + 51)
				{
					RGB colour = new RGB(red, green, blue);
					colours[i++] = colour;
				}
			}
		}

		RGB colour = new RGB(0, 0, 0);
		for (int k = 0; k < 256; ++k)
		{
			if (colours[k] == null)
			{
				colours[k] = colour;
			}
		}

		return colours;
	}

	/**
	 * If the image has less than 256 colours, simply create a new 8 bit palette and map the colours to the new palatte.
	 * 
	 * @param imageData the basic image data
	 * @return the converted image data
	 */
	protected ImageData getWebSafePalletteImageData(ImageData imageData)
	{
		PaletteData palette = imageData.palette;
		RGB[] webSafePallette = getWebSafePallette();
		PaletteData newPaletteData = new PaletteData(webSafePallette);
		ImageData newImageData = new ImageData(imageData.width, imageData.height, 8, newPaletteData);

		int lastPixel = -1;
		int newPixel = -1;
		for (int i = 0; i < imageData.width; ++i)
		{
			for (int j = 0; j < imageData.height; ++j)
			{
				int pixel = imageData.getPixel(i, j);

				if (pixel != lastPixel)
				{
					lastPixel = pixel;

					RGB colour = palette.getRGB(pixel);
					RGB webSafeColour = getWebSafeColour(colour);
					for (newPixel = 0; newPixel < 216; ++newPixel)
					{
						if (webSafePallette[newPixel].equals(webSafeColour))
						{
							break;
						}
					}

					assert newPixel < 216;
				}
				newImageData.setPixel(i, j, newPixel);
			}
		}

		return newImageData;
	}

	/**
	 * Retrieves a web safe colour that closely matches the provided colour.
	 * 
	 * @param colour a colour.
	 * @return the web safe colour.
	 */
	protected RGB getWebSafeColour(RGB colour)
	{
		int red = Math.round((colour.red + 25) / 51) * 51;
		int green = Math.round((colour.green + 25) / 51) * 51;
		int blue = Math.round((colour.blue + 25) / 51) * 51;
		return new RGB(red, green, blue);
	}

	/**
	 * Returns a non-null instance of Display object. Tries to find the Display
	 * object for the current thread first and if it fails tries to get:
	 * <li> Workbench display if the workbench running
	 * <li> Default display object
	 * 
	 * @return non-null Display object
	 */
	public static Display getDisplay() {
		Display display = Display.getCurrent();
		if (display == null && PlatformUI.isWorkbenchRunning()) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		return display != null ? display : Display.getDefault();
	}
}
