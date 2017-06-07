/*******************************************************************************
 * Copyright (c) 2005, 2009 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 * Thibault Landr� (Atos Origin) - add preference to the graphical properties.
 ******************************************************************************/
package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ForestRouter;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.topcased.draw2d.anchors.TopBottomAnchor;
import org.topcased.draw2d.figures.ComposedLabel;
import org.topcased.draw2d.figures.EditableLabel;
import org.topcased.draw2d.figures.IContainerFigure;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.draw2d.figures.ILabelFigure;
import org.topcased.draw2d.figures.IPortFigure;
import org.topcased.draw2d.layout.PortConstraint;
import org.topcased.modeler.ModelerColorConstants;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.policies.ChangeBackgroundColorEditPolicy;
import org.topcased.modeler.edit.policies.ChangeFontEditPolicy;
import org.topcased.modeler.edit.policies.ChangeForegroundColorEditPolicy;
import org.topcased.modeler.edit.policies.MovePlansEditPolicy;
import org.topcased.modeler.edit.policies.NonResizableEditPolicy;
import org.topcased.modeler.edit.policies.RemovableComponentEditPolicy;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.figures.GraphNodeFigure;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.LineStyle;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.listeners.DiagramElementListener;
import org.topcased.modeler.listeners.GraphNodeListener;
import org.topcased.modeler.utils.Utils;

/**
 * Default edit part for a graph node <br>
 * creation : 3 dec. 2004 O
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class GraphNodeEditPart extends BaseEditPart implements NodeEditPart
{
    // The cached nodeGraphConf
    private NodeGraphConf nodeGraphConf;

    /**
     * Typed listener for a GraphNode
     * 
     * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
     */
    protected class GraphNodeEditPartListener extends GraphNodeListener
    {
        /**
         * @see org.topcased.modeler.listeners.GraphNodeListener#handleSizeChanged()
         */
        @Override
        protected void handleSizeChanged()
        {
            refreshConstraints();
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handlePositionChanged()
         */
        @Override
        protected void handlePositionChanged()
        {
            refreshConstraints();
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handleContainmentChanged()
         */
        @Override
        protected void handleContainmentChanged()
        {
            refreshChildren();
            refreshVisuals();
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handleConnectorChanged()
         */
        @Override
        protected void handleConnectorChanged()
        {
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

            if (ModelerPropertyConstants.BACKGROUND_COLOR.equals(property.getKey()) || ModelerPropertyConstants.FOREGROUND_COLOR.equals(property.getKey()))
            {
                refreshColors();
            }
            if (ModelerPropertyConstants.FONT.equals(property.getKey()))
            {
                refreshTextAndFont();
            }
            if (ModelerPropertyConstants.PORT_POSITION.equals(property.getKey()))
            {
                refreshConstraints();
            }
            // Should be only called for Note elements
            if (ModelerPropertyConstants.NOTE_VALUE.equals(property.getKey()))
            {
                refreshVisuals();
            }
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handlePresentationChanged()
         */
        @Override
        protected void handlePresentationChanged()
        {
            // Ignore property

        }
    }

    /** The DirectEditManager */
    private DirectEditManager manager;

    private DiagramElementListener diagramListener = new GraphNodeEditPartListener();

    /**
     * Constructor
     * 
     * @param obj the mdoel object
     */
    public GraphNodeEditPart(GraphNode obj)
    {
        super(obj);
    }

    /**
     * @see org.topcased.modeler.edit.BaseEditPart#getDiagramElementListener()
     */
    @Override
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

        getDiagramElementListener().activate(getGraphNode());
    }

    /**
     * @see org.eclipse.gef.EditPart#deactivate()
     */
    @Override
    public void deactivate()
    {
        getDiagramElementListener().deactivate(getGraphNode());

        super.deactivate();
    }

    /**
     * @see org.topcased.modeler.edit.BaseEditPart#getAdapter(java.lang.Class)
     */
    @Override
    public Object getAdapter(Class key)
    {
        if (key == GraphNode.class)
        {
            return getGraphNode();
        }
        return super.getAdapter(key);
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    @Override
    protected IFigure createFigure()
    {
        return new GraphNodeFigure();
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    @Override
    protected void createEditPolicies()
    {
        super.createEditPolicies();

        installEditPolicy(ModelerEditPolicyConstants.RESIZABLE_EDITPOLICY, new NonResizableEditPolicy());

        installEditPolicy(EditPolicy.COMPONENT_ROLE, new RemovableComponentEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.CHANGE_BACKGROUND_COLOR_EDITPOLICY, new ChangeBackgroundColorEditPolicy());
        installEditPolicy(ModelerEditPolicyConstants.CHANGE_FOREGROUND_COLOR_EDITPOLICY, new ChangeForegroundColorEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.CHANGE_FONT_EDITPOLICY, new ChangeFontEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.MOVE_PLANS, new MovePlansEditPolicy());
    }

    /**
     * @see org.topcased.modeler.edit.BaseEditPart#handleModelChanged(Notification)
     */
    @Override
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

    /**
     * Get the graphNode model object (DI) associated with the EditPart
     * 
     * @return GraphNode
     */
    protected GraphNode getGraphNode()
    {
        return (GraphNode) getModel();
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
     */
    @Override
    protected List<GraphNode> getModelChildren()
    {
        List<GraphNode> graphNodeChildren = new ArrayList<GraphNode>();
        for (DiagramElement elt : getGraphNode().getContained())
        {
            if (elt instanceof GraphNode)
            {
                graphNodeChildren.add((GraphNode) elt);
            }
        }
        return graphNodeChildren;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
     */
    @Override
    protected List<GraphEdge> getModelSourceConnections()
    {
        List<GraphEdge> srcConnections = new ArrayList<GraphEdge>();
        for (GraphConnector connector : getGraphNode().getAnchorage())
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
        for (GraphConnector connector : getGraphNode().getAnchorage())
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
     * Returns the <code>ConnectionAnchor</code> for the specified <i>target</i> connection.
     * <P>
     * The anchor may be a function of the connection's model, the node's model, a combination of both, or it may not
     * depend on anything all.
     * 
     * @param connection the ConnectionEditPart
     * @return the ConnectionAnchor for the given ConnectionEditPart
     */
    private ConnectionAnchor getConnectionAnchor(ConnectionEditPart connection)
    {
        ConnectionAnchor anchor;
        Connection connectionFigure = (Connection) connection.getFigure();

        if (connectionFigure.getConnectionRouter() instanceof ForestRouter)
        {
            anchor = new TopBottomAnchor(getAnchorableFigure());
        }
        else
        {
            anchor = new SlidableAnchor(getAnchorableFigure());
        }

        return anchor;
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
    {
        return getConnectionAnchor(connection);
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getSourceConnectionAnchor(Request request)
    {
        return new SlidableAnchor(getAnchorableFigure());
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
    {
        return getConnectionAnchor(connection);
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getTargetConnectionAnchor(Request request)
    {
        return new SlidableAnchor(getAnchorableFigure());
    }

    /**
     * Return the Figure on which the Connection Anchors should be attached. By default, we return the global figure of
     * the AbstractGraphicalEditPart.
     * 
     * @return IFigure the Figure on which to attach the Anchors
     */
    protected IFigure getAnchorableFigure()
    {
        return getFigure();
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#registerVisuals()
     */
    @Override
    protected void refreshVisuals()
    {
        super.refreshVisuals();

        refreshConstraints();
        refreshColors();
        refreshTextAndFont();
        refreshVisible();
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

        getFigure().setVisible(getGraphNode().isVisible());
        // refreshSourceConnections();
        // refreshTargetConnections();
        //
        // getParent().refresh();
    }

    /**
     * Refresh the background and the foreground Colors of the GraphNode
     */
    protected void refreshColors()
    {
        // Refresh the background color of the graphical element
        Color backgroundColor = Utils.getBackgroundColor(getGraphNode());
        if (backgroundColor == null)
        {
            backgroundColor = getDefaultBackgroundColor();
        }
        getFigure().setBackgroundColor(backgroundColor);

        // Refresh the foreground color of the graphical element
        Color foregroundColor = Utils.getForegroundColor(getGraphNode());
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
        if (getLabel() != null)
        {
            Font font = Utils.getFont(getGraphNode());
            if (font == null)
            {
                font = getDefaultFont();
            }
            getLabel().setFont(font);
        }
    }

    /**
     * Refresh the constraints of the GraphNode
     */
    protected void refreshConstraints()
    {
        if (getParent() != null)
        {
            Rectangle constraint = new Rectangle(0, 0, getDefaultWidth(), getDefaultHeight());
            if (getGraphNode().getPosition() != null)
            {
                constraint.setLocation(getGraphNode().getPosition());
            }

            if (getGraphNode().getSize() != null)
            {
                constraint.setSize(getGraphNode().getSize());
            }

            // If the model object has a Property PORT_POSITION, this must be
            // added
            // to the constraint
            String attachment = DIUtils.getPropertyValue((GraphElement) getModel(), ModelerPropertyConstants.PORT_POSITION);
            if (!"".equals(attachment)) // the model object must be attached to
            // a
            // border
            {
                PortConstraint portConstraint = new PortConstraint(constraint, StringConverter.asInt(attachment));
                ((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), portConstraint);

                if (getFigure() instanceof IPortFigure)
                {
                    ((IPortFigure) getFigure()).setPosition(StringConverter.asInt(attachment));

                }
            }
            else
            {
                ((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), constraint);
                if (getFigure() instanceof GraphNodeFigure)
                {
                    GraphNodeFigure fig = (GraphNodeFigure) getFigure();
                    fig.setBounds(constraint);
                }
            }
        }
    }

    /**
     * @see org.eclipse.gef.EditPart#performRequest(org.eclipse.gef.Request)
     */
    @Override
    public void performRequest(Request request)
    {
        if (request.getType() == RequestConstants.REQ_DIRECT_EDIT && getEditableLabel() != null)
        {
            if (request instanceof DirectEditRequest && !directEditHitTest(((DirectEditRequest) request).getLocation().getCopy()))
            {
                return;
            }
            performDirectEdit();
        }
    }

    /**
     * Returns the direct edit manager
     * 
     * @return Returns the manager.
     */
    protected DirectEditManager getDirectEditManager()
    {
        return manager;
    }

    /**
     * Changes the direct edit manager
     * 
     * @param m The manager to set.
     */
    protected void setDirectEditManager(DirectEditManager m)
    {
        this.manager = m;
    }

    /**
     * Check if the direct dedit is allowed for the given position
     * 
     * @param requestLoc the current position
     * @return <code>true</code> if the direct edit is allowed
     */
    protected boolean directEditHitTest(Point requestLoc)
    {
        boolean canEdit = false;
        if (getLabel() != null)
        {
            getLabel().translateToRelative(requestLoc);
            canEdit = getLabel().containsPoint(requestLoc);
        }
        return canEdit;
    }

    /**
     * Display the manager used to perform the directEdit action
     */
    protected void performDirectEdit()
    {
        if (manager == null)
        {
            manager = new ModelerLabelDirectEditManager(this, TextCellEditor.class, new LabelCellEditorLocator(getEditableLabel()), getEditableLabel());
        }
        manager.show();
    }

    /**
     * @param value the name change during an edit
     */
    public void handleNameChange(String value)
    {
        // EditableLabel editableLabel = (EditableLabel) getHeader();
        // editableLabel.setVisible(false);static
        // refreshVisuals();
    }

    /**
     * Reverts to existing name in model when exiting from a direct edit (possibly before a commit which will result in
     * a change in the label value)
     */
    public void revertNameChange()
    {
        // EditableLabel editableLabel = (EditableLabel) getHeader();
        // GraphNode graphNode = getGraphNode();
        // editableLabel.setText(graphNode.getName());
        // editableLabel.setVisible(true);
        // refreshVisuals();
    }

    /**
     * Return label header
     * 
     * @return Label
     * @deprecated
     */
    @Deprecated
    public ILabel getHeader()
    {
        ILabel header = null;
        if (getFigure() instanceof ILabelFigure)
        {
            header = ((ILabelFigure) getFigure()).getLabel();
            if (header instanceof ComposedLabel)
            {
                header = ((ComposedLabel) header).getMain();
            }
        }

        return header;
    }

    /**
     * Return the ILabel figure contained in the figure of the graph node
     * 
     * @return the label
     */
    public ILabel getLabel()
    {
        ILabel header = null;
        if (getFigure() instanceof ILabelFigure)
        {
            header = ((ILabelFigure) getFigure()).getLabel();
        }

        return header;
    }

    /**
     * Return the editable part of the label of the figure. The default behaviour is to return the label. If the label
     * is a composed label, then the mai part of it is returned.
     * 
     * This function should be overriden for custum behaviour
     * 
     * @return the editable label
     */
    public ILabel getEditableLabel()
    {
        ILabel header = null;
        if (getFigure() instanceof ILabelFigure)
        {
            header = ((ILabelFigure) getFigure()).getLabel();
            if (header instanceof ComposedLabel)
            {
                header = ((ComposedLabel) header).getMain();
            }
        }
        // Return the Label only whether it is an EditableLabel
        return header instanceof EditableLabel ? header : null;
    }

    /**
     * Handle selection
     * 
     * @param value The value of the selection
     */
    @Override
    public void setSelected(int value)
    {
        super.setSelected(value);
        if (getLabel() instanceof EditableLabel)
        {
            EditableLabel lbl = (EditableLabel) getLabel();
            lbl.setSelected(value != 0);
        }
        else if (getLabel() instanceof ComposedLabel)
        {
            ComposedLabel lbl = (ComposedLabel) getLabel();
            lbl.setSelected(value != 0);
        }
    }

    /**
     * Return the FontData[] associated with the header Figure.
     * 
     * @return FontData[]
     */
    public FontData[] getHeaderFontData()
    {
        if (getLabel() != null)
        {
            return getLabel().getFont().getFontData();
        }
        return null;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getContentPane()
     */
    @Override
    public IFigure getContentPane()
    {
        IFigure container;
        if (getFigure() instanceof IContainerFigure)
        {
            container = ((IContainerFigure) getFigure()).getContentPane();
        }
        else
        {
            container = super.getContentPane();
        }
        return container;
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
        else if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getDefaultForegroundColor();
        }
        return ModelerColorConstants.black;
    }

    /**
     * Return the default background color of this type of element. Return the background color defined in the
     * preference if one exists, otherwise return the graphconf background color if it exists The default implementation
     * returns the black color.
     * 
     * @return Color
     */
    protected Color getDefaultBackgroundColor()
    {
        if (getPreferenceDefaultBackgroundColor() != null)
        {
            return getPreferenceDefaultBackgroundColor();
        }
        else if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getDefaultBackgroundColor();
        }
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
        else if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getDefaultFont();
        }
        return Display.getDefault().getSystemFont();
    }

    /**
     * Return the Font applied to the main label of the Figure improved with the given style. It might be useful for
     * example to enforce using a Bold or Italic style
     * 
     * @param style the style to enforce
     * @return Font the new Font improved with an additional style
     */
    protected Font getStyledFont(int style)
    {
        FontData[] fData = getLabel().getFont().getFontData();
        fData[0].setStyle(fData[0].getStyle() | style);
        String asString = StringConverter.asString(fData);
        if (!JFaceResources.getFontRegistry().hasValueFor(asString))
        {
            JFaceResources.getFontRegistry().put(StringConverter.asString(fData), fData);
        }
        return JFaceResources.getFontRegistry().get(StringConverter.asString(fData));
    }

    /**
     * Return the default width for this object
     * 
     * @return the default width
     */
    protected int getDefaultWidth()
    {
        if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getDefaultWidth();
        }
        return 100;
    }

    /**
     * Return the default height for this object
     * 
     * @return the default height
     */
    protected int getDefaultHeight()
    {
        if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getDefaultHeight();
        }
        return 100;
    }

    /**
     * Return the minimum width for this object
     * 
     * @return the default width
     */
    public int getMinimumWidth()
    {
        if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getMinimumWidth();
        }
        return 50;
    }

    /**
     * Return the minimum height for this object
     * 
     * @return the minimum height
     */
    public int getMinimumHeight()
    {
        if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getMinimumHeight();
        }
        return 50;
    }

    /**
     * Return the line width of the edge
     * 
     * @return int
     */
    protected int getLineWidth()
    {
        if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getLineWidth();
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
        if (getNodeGraphConf() != null)
        {
            return getNodeGraphConf().getLineStyle().getValue();
        }
        return LineStyle.SOLID;
    }

    /**
     * Return the NodeGraphConf corresponding to the activeDiagram and the model object associated with the controller
     * 
     * @return NodeGraphConf
     */
    protected NodeGraphConf getNodeGraphConf()
    {
        if (nodeGraphConf == null)
        {
            DiagramGraphConf diagGraphConf = ((ModelerGraphicalViewer) getViewer()).getModelerEditor().getActiveConfiguration().getDiagramGraphConf();
            if (diagGraphConf != null)
            {
                // REV PRESENTATION : is it normal to use the "default"
                // presentation ?
                if (this instanceof EMFGraphNodeEditPart)
                {
                    nodeGraphConf = Utils.getNodeGraphConf(diagGraphConf, ((EMFGraphNodeEditPart) this).getEObject(), getPresentation());
                }
                else if (((GraphElement) getModel()).getSemanticModel() instanceof SimpleSemanticModelElement)
                {
                    nodeGraphConf = diagGraphConf.getNodeGraphConf(((SimpleSemanticModelElement) ((GraphElement) getModel()).getSemanticModel()).getTypeInfo(), "default");
                }
            }
        }
        return nodeGraphConf;
    }

    /**
     * Get the presentation field of the GraphElement associated with this EditPart. Subclasses may override this method
     * to provide a different presentation field depending on the model element properties for example.
     * 
     * @return String the presentation field. Default value is "default".
     */
    protected String getPresentation()
    {
        return "default";
    }

    /**
     * Set the NodeGraphConf associated with this EditPart
     * 
     * @param ngc the new NodeGraphConf
     */
    protected void setNodeGraphConf(NodeGraphConf ngc)
    {
        this.nodeGraphConf = ngc;
    }

    /**
     * Get the background color defined in the preference page of the node <b>This method has to be override by
     * subclasses to get the preference background color associated with the GraphNodeEditPart.</b> The default
     * implementation returns null.
     * 
     * @return the preference background color defined
     */
    protected Color getPreferenceDefaultBackgroundColor()
    {
        return null;
    }

    /**
     * Get the foreground color defined in the preference page of the node <b>This method has to be override by
     * subclasses to get the preference foreground color associated with the GraphNodeEditPart.</b> The default
     * implementation returns null.
     * 
     * @return the preference foreground color defined
     */
    protected Color getPreferenceDefaultForegroundColor()
    {
        return null;
    }

    /**
     * Get the font defined in the preference page of the node <b>This method has to be override by subclasses to get
     * the preference font associated with the GraphNodeEditPart.</b> The default implementation returns null.
     * 
     * @return the preference font defined
     */
    protected Font getPreferenceDefaultFont()
    {
        return null;
    }

    /**
     * Get the preference store of the graphical node
     * 
     * @return the preference store
     */
    protected IPreferenceStore getPreferenceStore()
    {
        try
        {
            if (getParent() != null && getViewer() instanceof ModelerGraphicalViewer)
            {
                return ((ModelerGraphicalViewer) getViewer()).getModelerEditor().getPreferenceStore();
            }
        }
        catch (NullPointerException e)
        {
            // FIXME Find a way to avoid such a situation: sometimes, the getViewer throws a NullPointerException
            // because getParent().getParent() is null
        }
        // Fallback
        return ModelerPlugin.getDefault().getPreferenceStore();
    }

}