/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 * Thibault Landré (Atos Origin) - add preference to the graphical properties.
 ******************************************************************************/
package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ForestRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.OrthogonalRouter;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.gef.ui.internal.l10n.Cursors;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.ModelerColorConstants;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.RouterConstants;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.di.model.EdgeObjectOffset;
import org.topcased.modeler.di.model.EdgeObjectUV;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.dragtrackers.SelectGraphEdgeEditPartTracker;
import org.topcased.modeler.edit.policies.ChangeBackgroundColorEditPolicy;
import org.topcased.modeler.edit.policies.ChangeFontEditPolicy;
import org.topcased.modeler.edit.policies.ChangeForegroundColorEditPolicy;
import org.topcased.modeler.edit.policies.ChangeRouterEditPolicy;
import org.topcased.modeler.edit.policies.EdgeEditPolicy;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.figures.IEdgeObjectFigure;
import org.topcased.modeler.figures.IEdgeObjectOffsetFigure;
import org.topcased.modeler.figures.IGraphEdgeFigure;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.LineStyle;
import org.topcased.modeler.graphconf.RouterType;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.policies.ConnectorBendpointEditPolicy;
import org.topcased.modeler.internal.policies.ConnectorLineSegEditPolicy;
import org.topcased.modeler.internal.policies.TreeConnectorBendpointEditPolicy;
import org.topcased.modeler.listeners.DiagramElementListener;
import org.topcased.modeler.listeners.GraphEdgeListener;
import org.topcased.modeler.listeners.UIAdapterImpl;
import org.topcased.modeler.utils.Utils;

/**
 * This edit part offers basic methods for edge elements. <br>
 * Edge elements can optionnaly have some edge objects. <br/>
 * Creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class GraphEdgeEditPart extends AbstractConnectionEditPart implements NodeEditPart
{
    // The cached edgeGraphConf
    private EdgeGraphConf edgeGraphConf;

    /**
     * Listener that filters GraphEdge events and handles it : update graphics, connections...
     * 
     * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
     */
    protected class GraphEdgeEditPartListener extends GraphEdgeListener
    {

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handlePositionChanged()
         */
        @Override
        protected void handlePositionChanged()
        {
            // Ignore property
        }

        /**
         * @see org.topcased.modeler.listeners.GraphEdgeListener#handleContainmentChanged()
         */
        @Override
        protected void handleContainmentChanged()
        {
            refreshVisuals();
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handleConnectorChanged()
         */
        @Override
        protected void handleConnectorChanged()
        {
            refreshSourceAnchor();
            refreshTargetAnchor();
            refreshSourceConnections();
            refreshTargetConnections();
        }

        /**
         * @see org.topcased.modeler.listeners.DiagramElementListener#handleVisibilityChanged()
         */
        @Override
        protected void handleVisibilityChanged()
        {
            refreshVisible();
        }

        /**
         * @see org.topcased.modeler.listeners.DiagramElementListener#handlePropertyChanged(org.topcased.modeler.di.model.Property,
         *      org.topcased.modeler.di.model.Property)
         */
        @Override
        protected void handlePropertyChanged(Property oldProperty, Property newProperty)
        {
            Property property = newProperty != null ? newProperty : oldProperty;

            if (ModelerPropertyConstants.FOREGROUND_COLOR.equals(property.getKey()))
            {
                refreshColors();
            }
            if (ModelerPropertyConstants.FONT.equals(property.getKey()))
            {
                refreshTextAndFont();
            }
            if (ModelerPropertyConstants.ROUTER.equals(property.getKey()))
            {
                refreshRouter();
            }
        }

        /**
         * @see org.topcased.modeler.listeners.GraphEdgeListener#handleWaypointsChanged()
         */
        @Override
        protected void handleWaypointsChanged()
        {
            refreshBendpoints();
        }

        /**
         * @see org.topcased.modeler.listeners.GraphEdgeListener#handleEdgeObjectChanged(org.topcased.modeler.di.model.EdgeObject)
         */
        @Override
        protected void handleEdgeObjectChanged(EdgeObject modifiedEdgeObject)
        {
            updateEdgeObject(modifiedEdgeObject);
        }
    }

    /** The list of edge objects */
    private EList<EdgeObject> edgeObjects;

    /** The listeners */
    private Adapter modelListener = new UIAdapterImpl()
    {
        /**
         * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        @Override
        protected void safeNotifyChanged(Notification msg)
        {
            handleModelChanged(msg);
        }
    };

    private DiagramElementListener diagramListener = new GraphEdgeEditPartListener();

    /**
     * Constructor
     * 
     * @param conn the model object
     */
    public GraphEdgeEditPart(GraphEdge conn)
    {
        super();
        setModel(conn);
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getAdapter(java.lang.Class)
     */
    @Override
    public Object getAdapter(Class key)
    {
        if (key == SnapToHelper.class)
        {
            return createSnapToHelper();
        }
        Object adapted = Platform.getAdapterManager().getAdapter(this, key);
        if (adapted == null)
        {
            adapted = super.getAdapter(key);
        }
        return adapted;
    }

    /**
     * Create a SnapToHelper
     * 
     * @return SnapToHelper
     */
    protected SnapToHelper createSnapToHelper()
    {
        List<SnapToHelper> snapStrategies = new ArrayList<SnapToHelper>();
        Boolean val = (Boolean) getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
        if (val != null && val.booleanValue())
        {
            snapStrategies.add(new SnapToGeometry(this));
        }

        val = (Boolean) getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
        if (val != null && val.booleanValue())
        {
            snapStrategies.add(new SnapToGrid(this));
        }

        if (snapStrategies.size() == 0)
        {
            return null;
        }
        if (snapStrategies.size() == 1)
        {
            return snapStrategies.get(0);
        }

        SnapToHelper[] ss = new SnapToHelper[snapStrategies.size()];
        for (int i = 0; i < snapStrategies.size(); i++)
        {
            ss[i] = snapStrategies.get(i);
        }
        return new CompoundSnapToHelper(ss);
    }

    /**
     * Returns the generic model listener
     * 
     * @return the model listener
     */
    protected Adapter getModelListener()
    {
        return modelListener;
    }

    /**
     * Returns the listener used to listen the graphical model object
     * 
     * @return the listener
     */
    protected DiagramElementListener getDiagramElementListener()
    {
        return diagramListener;
    }

    /**
     * @see org.eclipse.gef.EditPart#activate()
     */
    @Override
    public void activate()
    {
        super.activate();

        getDiagramElementListener().activate(getGraphEdge());
    }

    /**
     * @see org.eclipse.gef.EditPart#deactivate()
     */
    @Override
    public void deactivate()
    {
        getDiagramElementListener().deactivate(getGraphEdge());
        // remove decoration edit policies, so they are not refreshed later.
        removeEditPolicy(EditPolicyRoles.DECORATION_ROLE);

        super.deactivate();
    }

    /**
     * @see org.eclipse.gef.EditPart#getDragTracker(org.eclipse.gef.Request)
     */
    @Override
    public DragTracker getDragTracker(Request req)
    {
        return new SelectGraphEdgeEditPartTracker(this);
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    @Override
    protected void createEditPolicies()
    {
        installEditPolicy(EditPolicyRoles.DECORATION_ROLE, new DecorationEditPolicy());

        // handles de deletion of the connection instance
        installEditPolicy(EditPolicy.CONNECTION_ROLE, new EdgeEditPolicy());

        // handles the reconnection of the endpoints of the connection
        installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());

        installBendpointEditPolicy();
        installEditPolicy(ModelerEditPolicyConstants.CHANGE_ROUTER, new ChangeRouterEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.CHANGE_BACKGROUND_COLOR_EDITPOLICY, new ChangeBackgroundColorEditPolicy());
        installEditPolicy(ModelerEditPolicyConstants.CHANGE_FOREGROUND_COLOR_EDITPOLICY, new ChangeForegroundColorEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.CHANGE_FONT_EDITPOLICY, new ChangeFontEditPolicy());
    }

    private void installBendpointEditPolicy()
    {
        if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter)
        {
            // no policy
        }
        else if (getConnectionFigure().getConnectionRouter() instanceof ForestRouter)
        {
            installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new TreeConnectorBendpointEditPolicy());
            getConnectionFigure().setCursor(Cursors.CURSOR_SEG_MOVE);
        }
        else if (getConnectionFigure().getConnectionRouter() instanceof OrthogonalRouter)
        {
            installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ConnectorLineSegEditPolicy());
            getConnectionFigure().setCursor(Cursors.CURSOR_SEG_MOVE);
        }
        else
        {
            installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ConnectorBendpointEditPolicy());
            getConnectionFigure().setCursor(org.eclipse.draw2d.Cursors.HAND);
        }
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    @Override
    protected IFigure createFigure()
    {
        PolylineConnectionEx conn = new PolylineConnectionEx();
        return conn;
    }

    /**
     * @see org.eclipse.gef.EditPart#addNotify()
     */
    @Override
    public void addNotify()
    {
        super.addNotify();
        refreshRouter();
    }

    /**
     * Install a router on the edit part, depending on the <code>Routing Property</code>
     */
    protected void refreshRouter()
    {
        ConnectionLayerEx cLayer = null;
        try
        {
            cLayer = (ConnectionLayerEx) getLayer(LayerConstants.CONNECTION_LAYER);
        }
        catch (NullPointerException e)
        {
            // a NullPointerException can occurs during the closing of an editor
        }

        ConnectionRouter router = getRouter(cLayer);

        if (getConnectionFigure().getConnectionRouter() != router)
        {
            getConnectionFigure().setConnectionRouter(router);
            installBendpointEditPolicy();
        }

        refreshTargetAnchor();
        refreshSourceAnchor();
        refreshBendpoints();
    }

    /**
     * Returns the router for this edge. The default implementation uses the property "router" in the DI or uses the
     * default router.<br>
     * <b>This method can be override by subclasses to define a specific router and if the router can be customize.</b>
     * 
     * @param cLayer the connection layer
     * @return the connection router
     */
    protected ConnectionRouter getRouter(ConnectionLayerEx cLayer)
    {
        if(cLayer == null)
        {
            return null;
        }
        ConnectionRouter router = getDefaultRouter(cLayer);
        String routingType = DIUtils.getPropertyValue(getGraphEdge(), ModelerPropertyConstants.ROUTER);

        if (routingType != null && !"".equals(routingType))
        {
            router = RouterConstants.getRouter(cLayer, routingType);
        }

        return router;
    }

    /**
     * Returns the default router for this edge. Return the router defined in the preference if there is one, otherwise
     * return the router defined in the graphconf if there is one. The default implementation returns the oblique
     * router.<br>
     * <b>This method can be override by subclasses to define an other default router.</b>
     * 
     * @param cLayer the connection layer
     * @return the connection router
     */
    protected ConnectionRouter getDefaultRouter(ConnectionLayerEx cLayer)
    {
        String routingType = getPreferenceDefaultRouter();

        if (routingType != null)
        {
            if (RouterType.OBLIQUE_ROUTER_LITERAL.getName().equals(routingType))
            {
                return cLayer.getObliqueRouter();
            }
            else if (RouterType.RECTILINEAR_ROUTER_LITERAL.getName().equals(routingType))
            {
                return cLayer.getRectilinearRouter();
            }
            else if (RouterType.TREE_ROUTER_LITERAL.getName().equals(routingType))
            {
                return cLayer.getTreeRouter();
            }
        }
        else if (getEdgeGraphConf() != null)
        {
            RouterType type = getEdgeGraphConf().getDefaultRouter();
            switch (type.getValue())
            {
                case RouterType.OBLIQUE_ROUTER:
                    return cLayer.getObliqueRouter();
                case RouterType.RECTILINEAR_ROUTER:
                    return cLayer.getRectilinearRouter();
                case RouterType.TREE_ROUTER:
                    return cLayer.getTreeRouter();
                default:
                    break;
            }
        }
        return cLayer.getObliqueRouter();
    }

    /**
     * Return the GraphEdge
     * 
     * @return GraphEdge
     */
    protected GraphEdge getGraphEdge()
    {
        return (GraphEdge) getModel();
    }

    /**
     * Refresh datas due to a property that has changed
     * 
     * @param msg the Notification message
     */
    protected void handleModelChanged(Notification msg)
    {
        // Do nothing
        // Call handlePropertyChanged until the remove of the deprecated method
        handlePropertyChanged(msg);
    }

    /**
     * @deprecated use handleModelChanged instead
     */
    @Deprecated
    protected void handlePropertyChanged(Notification msg)
    {
        // Do nothing
    }

    /** Invoke the editpart's refresh mechanism. */
    @Override
    public void refresh()
    {
        EditPolicyIterator i = getEditPolicyIterator();
        while (i.hasNext())
        {
            EditPolicy policy = i.next();
            if (policy instanceof GraphicalEditPolicyEx)
            {
                ((GraphicalEditPolicyEx) policy).refresh();
            }
        }
        super.refresh();
    }

    /**
     * Refresh the visuals
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     */
    @Override
    protected void refreshVisuals()
    {
        refreshColors();
        refreshTextAndFont();

        refreshVisible();
        refreshRouter();
        refreshBendpoints();
        refreshEdgeObjects();
    }

    /**
     * Refresh the visbility state of the current object
     */
    protected void refreshVisible()
    {
        for (Iterator itr = getSourceConnections().iterator(); itr.hasNext();)
        {
            ConnectionEditPart conn = (ConnectionEditPart) itr.next();
            conn.refresh();
        }

        for (Iterator itr = getTargetConnections().iterator(); itr.hasNext();)
        {
            ConnectionEditPart conn = (ConnectionEditPart) itr.next();
            conn.refresh();
        }

        getFigure().setVisible(getGraphEdge().isVisible());
    }

    /**
     * Refresh the objects associated to this connection
     */
    protected void refreshEdgeObjects()
    {
        for (EdgeObject edgeObject : getEdgeObjects())
        {
            updateEdgeObject(edgeObject);
        }
    }

    /**
     * Refresh the background and the foreground Colors of the GraphNode
     */
    protected void refreshColors()
    {
        // Refresh the background color of the graphical element
        Color backgroundColor = Utils.getBackgroundColor(getGraphEdge());
        if (backgroundColor == null)
        {
            backgroundColor = getDefaultBackgroundColor();
        }
        getFigure().setBackgroundColor(backgroundColor);

        // Refresh the foreground color of the graphical element
        Color foregroundColor = Utils.getForegroundColor(getGraphEdge());
        if (foregroundColor == null)
        {
            foregroundColor = getDefaultForegroundColor();
        }
        getFigure().setForegroundColor(foregroundColor);
    }

    /**
     * Refresh the text to display at the top and the current Font of the GraphNode
     */
    protected void refreshTextAndFont()
    {
        // Refresh the font of the graphical element
        Font font = Utils.getFont(getGraphEdge());
        if (font == null)
        {
            font = getDefaultFont();
        }
        getFigure().setFont(font);

        refreshEdgeObjects();
    }

    /**
     * refresh the bendpoints owned by the EditPart's <code>Edge</code>
     */
    protected void refreshBendpoints()
    {
        if (getConnectionFigure().getSourceAnchor() != null && getConnectionFigure().getTargetAnchor() != null)
        {
            List<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint> bendpoints = getGraphEdge().getWaypoints();

            List<RelativeBendpoint> figureConstraint = new ArrayList<RelativeBendpoint>();

            Point sourceRefPoint = getConnectionFigure().getSourceAnchor().getReferencePoint();
            Point targetRefPoint = getConnectionFigure().getTargetAnchor().getReferencePoint();

            // Add the source anchor bendpoint
            RelativeBendpoint sourcebp = new RelativeBendpoint(getConnectionFigure());
            Dimension diffSrc = sourceRefPoint.getDifference(targetRefPoint);
            sourcebp.setRelativeDimensions(new Dimension(0, 0), diffSrc);
            sourcebp.setWeight(0);
            figureConstraint.add(sourcebp);

            // Add the custom bendpoints
            for (int i = 0; i < bendpoints.size(); i++)
            {
                org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint wbp = bendpoints.get(i);
                RelativeBendpoint rbp = new RelativeBendpoint(getConnectionFigure());
                rbp.setRelativeDimensions(new Dimension(wbp.getSourceX(), wbp.getSourceY()), new Dimension(wbp.getTargetX(), wbp.getTargetY()));
                figureConstraint.add(rbp);
            }

            // Add the target anchor bendpoint
            RelativeBendpoint targetbp = new RelativeBendpoint(getConnectionFigure());
            Dimension diffTgt = targetRefPoint.getDifference(sourceRefPoint);
            targetbp.setRelativeDimensions(diffTgt, new Dimension(0, 0));
            targetbp.setWeight(1);
            figureConstraint.add(targetbp);

            getConnectionFigure().setRoutingConstraint(figureConstraint);
        }
    }

    /**
     * Return the default foreground color of this type of element. Return the foreground color defined in the
     * preference if one exists, otherwise return the graphconf foreground color if it exists The default implementation
     * returns the black color.
     * 
     * @return Color
     */
    protected Color getDefaultForegroundColor()
    {
        if (getPreferenceDefaultForegroundColor() != null)
        {
            return getPreferenceDefaultForegroundColor();
        }
        else if (getEdgeGraphConf() != null)
        {
            Color color = getEdgeGraphConf().getDefaultForegroundColor();
            return color;
        }
        return ModelerColorConstants.black;
    }

    /**
     * Return the default foreground color of this type of element
     * 
     * @return Color
     * @deprecated should not be used anymore
     */
    @Deprecated
    protected Color getDefaultBackgroundColor()
    {
        return ModelerColorConstants.white;
    }

    /**
     * Return the default font of this type of element. Return the font defined in the preference if one exists,
     * otherwise return the font defined in the graphconf if it exists. The default implementation returns the system
     * font.
     * 
     * @return Font
     */
    protected Font getDefaultFont()
    {
        if (getPreferenceDefaultFont() != null)
        {
            return getPreferenceDefaultFont();
        }
        else if (getEdgeGraphConf() != null)
        {
            return getEdgeGraphConf().getDefaultFont();
        }
        return Display.getDefault().getSystemFont();
    }

    /**
     * Return the line width of the edge
     * 
     * @return int
     */
    protected int getLineWidth()
    {
        if (getEdgeGraphConf() != null)
        {
            return getEdgeGraphConf().getLineWidth();
        }
        return 1;
    }

    /**
     * Return the line style of the edge
     * 
     * @return style
     */
    protected int getLineStyle()
    {
        if (getEdgeGraphConf() != null)
        {
            return getEdgeGraphConf().getLineStyle().getValue();
        }
        return LineStyle.SOLID;
    }

    /**
     * Get the list of edge objects.
     * 
     * @return a list of edge objects
     */
    public EList<EdgeObject> getEdgeObjects()
    {
        if (edgeObjects == null)
        {
            edgeObjects = initEdgeObjectList();
        }

        return edgeObjects;
    }

    /**
     * @return EList of EdgeObject
     */
    private EList<EdgeObject> initEdgeObjectList()
    {
        EList<EdgeObject> list = new BasicEList<EdgeObject>();

        for (DiagramElement element : getGraphEdge().getContained())
        {
            if (element instanceof EdgeObject)
            {
                list.add((EdgeObject) element);
            }
        }

        return list;
    }

    /**
     * Get the edge object figure for the given edge object.<br/>
     * Subclass must implements this method to return the appropriate edge object figure. Default implementation returns
     * <code>null</code>.
     * 
     * @param edgeObject an edge object
     * @return an edge object figure
     */
    public IEdgeObjectFigure getEdgeObjectFigure(EdgeObject edgeObject)
    {
        return null;
    }

    /**
     * A location property of an edge object has changed. Subclass must implements the update behavior. <br/>
     * Default implementation updates the {@link IEdgeObjectFigure} location.
     * 
     * @param edgeObject an updated edge object
     */
    protected void updateEdgeObject(EdgeObject edgeObject)
    {
        // update the visibility of the EdgeObject
        if (edgeObject != null && getEdgeObjectFigure(edgeObject) != null)
        {
            getEdgeObjectFigure(edgeObject).setVisible(edgeObject.isVisible());

            if (edgeObject instanceof EdgeObjectOffset)
            {
                IEdgeObjectOffsetFigure offsetFig = (IEdgeObjectOffsetFigure) getEdgeObjectFigure(edgeObject);
                if (offsetFig != null)
                {
                    offsetFig.setOffset(((EdgeObjectOffset) edgeObject).getOffset());
                }
            }
            else if (edgeObject instanceof EdgeObjectUV && getConnectionFigure() instanceof IGraphEdgeFigure)
            {
                IEdgeObjectFigure edgeObjectFigure = getEdgeObjectFigure(edgeObject);
                Locator locator = ((IGraphEdgeFigure) getConnectionFigure()).getLocator(edgeObjectFigure);
                if (locator instanceof ConnectionEndpointLocator)
                {
                    ConnectionEndpointLocator cep = (ConnectionEndpointLocator) locator;
                    cep.setUDistance(((EdgeObjectUV) edgeObject).getUDistance());
                    cep.setVDistance(((EdgeObjectUV) edgeObject).getVDistance());
                }
            }
        }
    }

    /**
     * Refresh the listening of connectors
     */
    protected void listenToConnectors()
    {
        // Iterates on connectors
        for (GraphConnector connector : getGraphEdge().getAnchorage())
        {
            // Only listen to connectors that are not yet listened
            if (!connector.eAdapters().contains(modelListener))
            {
                connector.eAdapters().add(modelListener);
            }
        }
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
     */
    @Override
    protected List<GraphEdge> getModelSourceConnections()
    {
        List<GraphEdge> srcConnections = new ArrayList<GraphEdge>();
        for (GraphConnector connector : getGraphEdge().getAnchorage())
        {
            for (GraphEdge edge : connector.getGraphEdge())
            {
                if (connector == edge.getAnchor().get(0))
                {
                    srcConnections.add(edge);
                }
            }
        }
        return srcConnections;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
     */
    @Override
    protected List<GraphEdge> getModelTargetConnections()
    {
        List<GraphEdge> tgtConnections = new ArrayList<GraphEdge>();
        for (GraphConnector connector : getGraphEdge().getAnchorage())
        {
            for (GraphEdge edge : connector.getGraphEdge())
            {
                if (edge.getAnchor().size() == 2 && connector == edge.getAnchor().get(1))
                {
                    tgtConnections.add(edge);
                }
            }
        }
        return tgtConnections;
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
    {
        return new SlidableAnchor(getFigure());
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getSourceConnectionAnchor(Request request)
    {
        return new SlidableAnchor(getFigure());
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
    {
        return new SlidableAnchor(getFigure());
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getTargetConnectionAnchor(Request request)
    {
        return new SlidableAnchor(getFigure());
    }

    /**
     * This method updates the listening on added or removed objects
     * 
     * @param oldValue the old Object
     * @param newValue the new Object
     */
    protected void updateModelListening(Object oldValue, Object newValue)
    {
        if (oldValue != newValue)
        {
            if (oldValue != null && oldValue instanceof EObject)
            {
                // stop listening the removed object
                ((EObject) oldValue).eAdapters().remove(getModelListener());
            }
            if (newValue != null && newValue instanceof EObject)
            {
                // Listen the newly created object
                if (!((EObject) newValue).eAdapters().contains(getModelListener()))
                {
                    ((EObject) newValue).eAdapters().add(getModelListener());
                }
            }
        }
    }

    /**
     * Return the EdgeGraphConf corresponding to the activeDiagram and the model object associated with the controller
     * 
     * @return EdgeGraphConf
     */
    private EdgeGraphConf getEdgeGraphConf()
    {
        if (edgeGraphConf == null)
        {
            if (getViewer() instanceof ModelerGraphicalViewer)
            {
                // REV PRESENTATION : is it normal to use the "default" presentation ?
                DiagramGraphConf diagGraphConf = ((ModelerGraphicalViewer) getViewer()).getModelerEditor().getActiveConfiguration().getDiagramGraphConf();
                if (diagGraphConf != null)
                {
                    if (this instanceof EMFGraphEdgeEditPart)
                    {
                        edgeGraphConf = Utils.getEdgeGraphConf(diagGraphConf, ((EMFGraphEdgeEditPart) this).getEObject(), "default");
                    }
                    else if (((GraphElement) getModel()).getSemanticModel() instanceof SimpleSemanticModelElement)
                    {
                        edgeGraphConf = diagGraphConf.getEdgeGraphConf(((SimpleSemanticModelElement) ((GraphElement) getModel()).getSemanticModel()).getTypeInfo(), "default");
                    }
                }
            }
        }
        return edgeGraphConf;
    }

    /**
     * Get the router defined in the preference page of the edge <b>This method has to be override by subclasses to get
     * the preference router associated with the GraphEdgeEditPart.</b> The default implementation returns null.
     * 
     * @return the preference router defined
     */
    protected String getPreferenceDefaultRouter()
    {
        return null;
    }

    /**
     * Get the foreground color defined in the preference page of the edge <b>This method has to be override by
     * subclasses to get the preference foreground color associated with the GraphEdgeEditPart.</b> The default
     * implementation returns null.
     * 
     * @return the preference foreground color defined
     */
    protected Color getPreferenceDefaultForegroundColor()
    {
        return null;
    }

    /**
     * Get the font defined in the preference page of the edge <b>This method has to be override by subclasses to get
     * the preference font associated with the GraphEdgeEditPart.</b> The default implementation returns null.
     * 
     * @return the preference font defined
     */
    protected Font getPreferenceDefaultFont()
    {
        return null;
    }

    /**
     * Get the preference store of the graphical edge
     * 
     * @return the preference store
     */
    protected IPreferenceStore getPreferenceStore()
    {
        if (getParent() != null && getViewer() instanceof ModelerGraphicalViewer)
        {
            return ((ModelerGraphicalViewer) getViewer()).getModelerEditor().getPreferenceStore();
        }
        return ModelerPlugin.getDefault().getPreferenceStore();
    }

    /**
     * @return The Root editpart or NULL if the parent is null
     * @see org.eclipse.gef.editparts.AbstractEditPart#getRoot()
     */
    @Override
    public RootEditPart getRoot()
    {
        if (getParent() != null)
        {
            return super.getRoot();
        }
        else
        {
            return null;
        }
    }

    /**
     * @return The Viewer or NULL if the rootPart is null
     * @see org.eclipse.gef.editparts.AbstractEditPart#getViewer()
     */
    @Override
    public EditPartViewer getViewer()
    {
        RootEditPart rootPart = getRoot();
        if (rootPart != null)
        {
            return rootPart.getViewer();
        }
        else
        {
            return null;
        }
    }

}
