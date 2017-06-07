package org.topcased.modeler.exporter;

import java.awt.Point;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.topcased.modeler.export.IImageExporter;

public abstract class AbstractImageExporter implements IImageExporter {
	protected IFigure printableLayer;

	private static final int DEFAULT_IMAGE_MARGIN_PIXELS = 10;

	private static final int DEFAULT_EMPTY_IMAGE_SIZE_PIXELS = 100;

	/**
	 * This method will be called with the correct size by renderToGraphics 
	 * when a Graphics needs to be created to draw on it.
	 * The subclasses are responsible of the created Graphics :
	 * they should dispose it when used.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	protected abstract Graphics createGraphics(int width, int height);

	public Graphics renderToGraphics(EditPart diagramEditPart, List<GraphicalEditPart> editParts, boolean includeRelatedConnections)
	{
		Graphics graphics = null;
		if (diagramEditPart != null) {
			printableLayer = LayerManager.Helper.find(diagramEditPart).getLayer(LayerConstants.PRINTABLE_LAYERS);

			if (editParts == null || editParts.isEmpty()) {
				Rectangle rect = printableLayer.getBounds();
				if (printableLayer instanceof FreeformFigure) {
					rect = ((FreeformFigure) printableLayer).getFreeformExtent();
				}

				graphics = createGraphics(rect.width, rect.height);
				printableLayer.paint(graphics);
			} else {
				Dimension emptyImageSize = new Dimension(DEFAULT_EMPTY_IMAGE_SIZE_PIXELS, DEFAULT_EMPTY_IMAGE_SIZE_PIXELS);

				Rectangle rect = calculateImageRectangle(editParts, DEFAULT_IMAGE_MARGIN_PIXELS, emptyImageSize, printableLayer);

				graphics = createGraphics(rect.width, rect.height);

				renderEPsToGraphics(graphics, new Point(rect.x, rect.y), editParts, includeRelatedConnections);
			}
		}

		return graphics;
	}

	/**
	 * This method is used to obtain the list of child edit parts for shape
	 * compartments.
	 * 
	 * @param childEditPart
	 *            base edit part to get the list of children editparts
	 * @param editParts
	 *            list of nested shape edit parts
	 */
	protected void getNestedEditParts(GraphicalEditPart baseEditPart,
			Collection<GraphicalEditPart> editParts) {

		for (Object child : baseEditPart.getChildren()) {
			if (child instanceof GraphicalEditPart) {
				GraphicalEditPart childEP = (GraphicalEditPart)child;
				editParts.add(childEP);
				getNestedEditParts(childEP, editParts);
			}
		}
	}

	/**
	 * Returns all connections orginating from a given editpart. All means that
	 * connections originating from connections that have a source given
	 * editpart will be included
	 * 
	 * @param ep the editpart 
	 * @return all source connections
	 */
	protected List<ConnectionEditPart> getAllConnectionsFrom(GraphicalEditPart ep) {
		LinkedList<ConnectionEditPart> connections = new LinkedList<ConnectionEditPart>();
		for (Object sourceConnObj: ep.getSourceConnections()) {
			if (sourceConnObj instanceof ConnectionEditPart) {
				ConnectionEditPart sourceConn = (ConnectionEditPart) sourceConnObj;
				connections.add(sourceConn);
				connections.addAll(getAllConnectionsFrom(sourceConn));
			}
		}
		return connections;
	}

	/**
	 * Collects all connections contained within the given edit part
	 * 
	 * @param editPart the container editpart
	 * @return connections within it
	 */
	protected Collection<ConnectionEditPart> findConnectionsToPaint(GraphicalEditPart editPart, List<GraphicalEditPart> relatedEditParts) {
		/*
		 * Set of node editparts contained within the given editpart
		 */
		HashSet<GraphicalEditPart> editParts = new HashSet<GraphicalEditPart>();

		/*
		 * All connection editparts that have a source contained within the given editpart
		 */
		HashSet<ConnectionEditPart> connectionEPs = new HashSet<ConnectionEditPart>();

		/*
		 * Connections contained within the given editpart (or just the connections to paint
		 */
		HashSet<ConnectionEditPart> connectionsToPaint = new HashSet<ConnectionEditPart>();

		/*
		 * Populate the set of node editparts
		 */
		getNestedEditParts(editPart, editParts);

		/*
		 * Populate the set of connections whose source is within the given editpart
		 */
		for (GraphicalEditPart gep : editParts) {
			connectionEPs.addAll(getAllConnectionsFrom(gep));
		}
		
		/*
		 * Populate the set of connections whose source is the given editpart
		 */
		connectionEPs.addAll(getAllConnectionsFrom(editPart));

		/*
		 * Create a set of connections constained within the given editpart
		 */
		while (!connectionEPs.isEmpty()) {
			/*
			 * Take the first connection and check whethe there is a path
			 * through that connection that leads to the target contained within
			 * the given editpart
			 */
			Stack<ConnectionEditPart> connectionsPath = new Stack<ConnectionEditPart>();
			ConnectionEditPart conn = connectionEPs.iterator().next();
			connectionEPs.remove(conn);
			connectionsPath.add(conn);

			/*
			 * Initialize the target for the current path
			 */
			EditPart target = conn.getTarget();
			while(connectionEPs.contains(target)) {
				/*
				 * If the target end is a connection, check if it's one of the
				 * connection's whose target is a connection and within the
				 * given editpart. Append it to the path if it is. Otherwise
				 * check if the target is within the actual connections or nodes
				 * contained within the given editpart
				 */
				ConnectionEditPart targetConn = (ConnectionEditPart) target;
				connectionEPs.remove(targetConn);
				connectionsPath.add(targetConn);

				/*
				 * Update the target for the new path
				 */
				target = targetConn.getTarget();
			}

			/*
			 * The path is built, check if it's target is a node or a connection
			 * contained within the given editpart
			 */
			if (editParts.contains(target) || connectionsToPaint.contains(target) || relatedEditParts.contains(target)) {
				connectionsToPaint.addAll(connectionsPath);
			}
		}
		return connectionsToPaint;
	}

	protected void renderEPsToGraphics(Graphics graphics, Point translateOffset, List<GraphicalEditPart> editParts, boolean includeRelatedConnections) {

		//		List sortedEditparts = sortSelection(editparts);

		graphics.translate((-translateOffset.x), (-translateOffset.y));
		graphics.pushState();

		List<GraphicalEditPart> connectionsToPaint = new LinkedList<GraphicalEditPart>();

		for (GraphicalEditPart editPart : editParts) {
			// do not paint selected connection part
			if (editPart instanceof ConnectionEditPart) {
				connectionsToPaint.add(editPart);
			} else {
				List<GraphicalEditPart> relatedEditParts = Collections.emptyList();
				if (includeRelatedConnections) {
					relatedEditParts = editParts;
				}
				connectionsToPaint.addAll(findConnectionsToPaint(editPart, relatedEditParts));
				// paint shape figure
				IFigure figure = editPart.getFigure();
				paintFigure(graphics, figure);
			}
		}

		for (GraphicalEditPart connectionEP : connectionsToPaint) {
			IFigure figure = connectionEP.getFigure();
			paintFigure(graphics, figure);
		}
	}

	/**
	 * This method is used when a figure needs to be painted to the graphics.
	 * The figure will be translated based on its absolute positioning.
	 * 
	 * @param graphics
	 *            Graphics object to render figure
	 * @param figure
	 *            the figure to be rendered
	 */
	protected void paintFigure(Graphics graphics, IFigure figure) {

		if (!figure.isVisible() || figure.getBounds().isEmpty())
			return;

		// Calculate the Relative bounds and absolute bounds
		Rectangle relBounds = figure.getBounds().getCopy();

		Rectangle abBounds = relBounds.getCopy();
		translateTo(abBounds, figure, printableLayer);

		// Calculate the difference
		int transX = abBounds.x - relBounds.x;
		int transY = abBounds.y - relBounds.y;

		// Paint the figure
		graphics.pushState();
		graphics.translate(transX, transY);
		figure.paint(graphics);
		graphics.popState();
		graphics.restoreState();
	}

	/**
	 * Translates <code>t</code> from one figure coordinate system to its ancestor figure coordinate system 
	 * 
	 * @param t the value to translate
	 * @param translateFrom initial figure
	 * @param translateTo some ancestor figure
	 * @return translated <code>t</code>
	 */
	protected Translatable translateTo(Translatable t,
			IFigure translateFrom, IFigure translateTo) {
		for (IFigure walker = translateFrom; walker != null
				&& walker != translateTo; walker = walker.getParent()) {
			walker.translateToParent(t);
		}
		return t;
	}

	/**
	 * Calculates the bounding box around given editparts. The bounding box is relative to printable layer
	 * 
	 * @param editparts given editparts
	 * @param frameSize frame around the bounding box
	 * @param defaultSize if there are no editparts, the size of the bounding box will be the default one.
	 * @return the editparts bounding box
	 */
	protected Rectangle calculateImageRectangle(List<GraphicalEditPart> editparts, double frameSize, Dimension defaultSize, IFigure printableLayer) {
		double minX = editparts.isEmpty() ? 0 : Double.MAX_VALUE;
		double maxX = editparts.isEmpty() ? 0 : Double.MIN_VALUE;
		double minY = editparts.isEmpty() ? 0 : Double.MAX_VALUE;
		double maxY = editparts.isEmpty() ? 0 : Double.MIN_VALUE;

		for (GraphicalEditPart editPart : editparts) {
			IFigure figure = editPart.getFigure();
			Rectangle bounds = figure.getBounds().getCopy();
			translateTo(bounds, figure, printableLayer);

			minX = Math.min(minX, bounds.preciseX());
			maxX = Math.max(maxX, bounds.preciseX() + bounds.preciseWidth());
			minY = Math.min(minY, bounds.preciseY());
			maxY = Math.max(maxY, bounds.preciseY() + bounds.preciseHeight());
		}

		PrecisionRectangle rect = new PrecisionRectangle();
		rect.preciseWidth = maxX - minX;
		rect.preciseHeight = maxY - minY;

		if (defaultSize != null) {
			if (rect.preciseHeight <= 0) {
				rect.preciseHeight = defaultSize.preciseWidth();
			}
			if (rect.preciseHeight <= 0) {
				rect.preciseHeight = defaultSize.preciseHeight();
			}
		}

		rect.preciseX = minX - frameSize;
		rect.preciseY = minY - frameSize;
		rect.preciseWidth += 2 * frameSize;
		rect.preciseHeight += 2 * frameSize;
		rect.updateInts();
		return rect;
	}
}
