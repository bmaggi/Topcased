/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.topcased.draw2d.figures.IContainerFigure;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.modeler.ModelerColorConstants;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.policies.ChangeBackgroundColorEditPolicy;
import org.topcased.modeler.edit.policies.ChangeDiagramPropertiesEditPolicy;
import org.topcased.modeler.edit.policies.ChangeFontEditPolicy;
import org.topcased.modeler.edit.policies.ChangeForegroundColorEditPolicy;
import org.topcased.modeler.edit.policies.DiagramSizeEditPolicy;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.figures.DiagramFigure;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.listeners.DiagramElementListener;
import org.topcased.modeler.listeners.DiagramListener;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageFormat;
import org.topcased.modeler.preferences.PageMargin;
import org.topcased.modeler.utils.LabelHelper;
import org.topcased.modeler.utils.Utils;

/**
 * Basic diagram edit part. <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public abstract class DiagramEditPart extends BaseEditPart implements LayerConstants
{
    // The cached nodeGraphConf
    private DiagramGraphConf diagramGraphConf;

    protected class DiagramEditPartListener extends DiagramListener
    {

        protected void handleSizeChanged()
        {
            // Ignored property
        }

        protected void handlePositionChanged()
        {
            // Ignored property
        }

        protected void handleContainmentChanged()
        {
            refreshChildren();
            refreshVisuals();
        }

        protected void handleConnectorChanged()
        {
            // Ignored property
        }

        protected void handleVisibilityChanged()
        {
            // Ignored property
        }

        /**
         * @see org.topcased.modeler.listeners.GraphElementListener#handlePresentationChanged()
         */
        protected void handlePresentationChanged()
        {
            // Ignored property

        }

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
            if (ModelerPropertyConstants.PAGE_FORMAT_NAME.equals(property.getKey()) || ModelerPropertyConstants.PAGE_WIDTH.equals(property.getKey())
                    || ModelerPropertyConstants.PAGE_HEIGHT.equals(property.getKey()) || ModelerPropertyConstants.PAGE_MARGIN_NAME.equals(property.getKey())
                    || ModelerPropertyConstants.TOP_MARGIN.equals(property.getKey()) || ModelerPropertyConstants.LEFT_MARGIN.equals(property.getKey())
                    || ModelerPropertyConstants.BOTTOM_MARGIN.equals(property.getKey()) || ModelerPropertyConstants.RIGHT_MARGIN.equals(property.getKey())
                    || ModelerPropertyConstants.ORIENTATION.equals(property.getKey()) || ModelerPropertyConstants.PAGE_WIDTH.equals(property.getKey())
                    || ModelerPropertyConstants.PAGE_WIDTH.equals(property.getKey()) || ModelerPropertyConstants.PAGE_WIDTH.equals(property.getKey()))
            {
                refreshDiagramProperties();
            }
        }

        protected void handleNameChanged()
        {
            refreshTextAndFont();
        }
    }

    /** The page figure (visible area) */
    // TODO Determine whether we should keep this or not (for printing issue mainly)
//    private IFigure page;

    /** The body figure (the diagram) */
    private IFigure body;

    private DiagramElementListener listener = new DiagramEditPartListener();

    /**
     * Constructor
     * 
     * @param model the model object
     */
    public DiagramEditPart(Diagram model)
    {
        super(model);
    }

    /**
     * Returns the Diagram
     * 
     * @return the Diagram object
     */
    protected Diagram getDiagram()
    {
        return (Diagram) getModel();
    }

    /**
     * Retrieve the model object
     * 
     * @return the EObject associated with the EMFGraphNodeEditPart
     */
    public EObject getEObject()
    {
        return Utils.getElement((GraphElement) getModel());
    }

    /**
     * Activate the adapters
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
     */
    public void activate()
    {
        super.activate();

        getDiagramElementListener().activate(getDiagram());
        if (getEObject() != null && !getEObject().eAdapters().contains(getModelListener()))
        {
            getEObject().eAdapters().add(getModelListener());
        }
    }

    /**
     * Deactivate the adapters
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
     */
    public void deactivate()
    {
        if (getEObject() != null)
        {
            getEObject().eAdapters().remove(getModelListener());
        }
        getDiagramElementListener().deactivate(getDiagram());

        super.deactivate();
    }

    /**
     * Returns the listener used to listen the graphical mode object
     * 
     * @return the listener
     */
    protected DiagramElementListener getDiagramElementListener()
    {
        return listener;
    }

    /**
     * @see org.topcased.modeler.edit.BaseEditPart#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class key)
    {
        if (key.isInstance(getModel()))
        {
            return getModel();
        }
        return super.getAdapter(key);
    }

    /**
     * Update model and graphics
     * 
     * @param msg the Notification
     */
    protected void handleModelChanged(Notification msg)
    {
        refreshTextAndFont();
        // Call handlePropertyChanged until the remove of the deprecated method
        handlePropertyChanged(msg);
    }

    /**
     * @deprecated use handleModelChanged instead
     */
    protected void handlePropertyChanged(Notification msg)
    {
        // Do nothing
    }

    /**
     * Create the EditPolicies
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies()
    {
        // prevent to delete the root component
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());

        // install the diagram layout edit policy (manage creation, move and
        // resize of children objects)
        installEditPolicy(EditPolicy.LAYOUT_ROLE, getLayoutEditPolicy());

        // display a popup window to manage diagram properties
        installEditPolicy(ModelerEditPolicyConstants.CHANGE_DIAGRAM_PROPERTIES_EDITPOLICY, new ChangeDiagramPropertiesEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.CHANGE_BACKGROUND_COLOR_EDITPOLICY, new ChangeBackgroundColorEditPolicy());
        installEditPolicy(ModelerEditPolicyConstants.CHANGE_FOREGROUND_COLOR_EDITPOLICY, new ChangeForegroundColorEditPolicy());
        installEditPolicy(ModelerEditPolicyConstants.RESIZABLE_EDITPOLICY, new DiagramSizeEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.CHANGE_FONT_EDITPOLICY, new ChangeFontEditPolicy());

        installEditPolicy(ModelerEditPolicyConstants.SNAP_FEEDBACK_EDITPOLICY, new SnapFeedbackPolicy());
    }

    /**
     * Returns the EditPolicy used in this diagram
     * 
     * @return the diagram editPolicy
     */
    protected abstract EditPolicy getLayoutEditPolicy();

    /**
     * Create the diagram figure
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure()
    {
     // TODO Determine whether we should keep this or not (for printing issue mainly)
//        page = createPageFigure();

        body = createBodyFigure();
//        page.add(body);

        refreshDiagramProperties();

//        return page;
        return body;
    }

    /**
     * Create the figure that will represent the page
     * 
     * @return the page figure
     */
    protected IFigure createPageFigure()
    {
        RectangleFigure p = new RectangleFigure();
        p.setLineStyle(Graphics.LINE_DOT);
        p.setLayoutManager(new XYLayout());
        p.setFill(false);

        return p;
    }

    /**
     * Create the figure that will represent the body of the page, the area where the children will be displayed
     * 
     * @return the container figure
     * 
     */
    protected IFigure createBodyFigure()
    {
        DiagramFigure b = new DiagramFigure();
        b.setOpaque(false);

        return b;
    }

    /**
     * The Diagram figure is not selectable (ensure that the Marquee tool is directly accessible)
     * 
     * @return a boolean
     */
    public boolean isSelectable()
    {
        return false;
    }

    /**
     * Return header figure
     * 
     * @return the label
     */
    public ILabel getEditableLabel()
    {
        return ((DiagramFigure) body).getLabel();
    }

    /**
     * Return header figure
     * 
     * @return the label
     */
    public ILabel getLabel()
    {
        return ((DiagramFigure) body).getLabel();
    }

    /**
     * Get the contentPane figure
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getContentPane()
     */
    public IFigure getContentPane()
    {
        IFigure container;
        if (body instanceof IContainerFigure)
        {
            container = ((IContainerFigure) body).getContentPane();
        }
        else
        {
            container = super.getContentPane();
        }
        return container;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     */
    protected void refreshVisuals()
    {
        refreshColors();
        refreshTextAndFont();
        refreshDiagramProperties();
    }

    /**
     * Refresh the background and the foreground Colors of the Diagram
     */
    protected void refreshColors()
    {
        // Refresh the background color of the graphical element
        Color backgroundColor = Utils.getBackgroundColor(getDiagram());
        if (backgroundColor == null)
        {
            backgroundColor = getDefaultBackgroundColor();
        }
        getFigure().setBackgroundColor(backgroundColor);

        // Refresh the foreground color of the graphical element
        Color foregroundColor = Utils.getForegroundColor(getDiagram());
        if (foregroundColor == null)
        {
            foregroundColor = getDefaultForegroundColor();
        }
        getFigure().setForegroundColor(foregroundColor);
    }

    /**
     * Refresh the text to display at the top and the current Font of the Diagram
     */
    protected void refreshTextAndFont()
    {
        // refresh the EPackage properties
        if (getHeaderDiagram() != null)
        {
            getEditableLabel().setText(getHeaderDiagram());
        }

        // Refresh the font of the graphical element
        if (getEditableLabel() != null)
        {
            Font font = Utils.getFont(getDiagram());
            if (font == null)
            {
                font = getDefaultFont();
            }
            getEditableLabel().setFont(font);
        }
    }

    /**
     * Subclasses must implements this methods. It returns the text to display at the top of the diagram
     * 
     * @return a String
     */
    protected String getHeaderDiagram()
    {
        return LabelHelper.INSTANCE.getDiagramPath(getViewer().getEditDomain(), getDiagram());
    }

    /**
     * Get model children
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
     */
    protected List<GraphNode> getModelChildren()
    {
        List<GraphNode> graphNodeChildren = new ArrayList<GraphNode>();
        Iterator<DiagramElement> it = getDiagram().getContained().iterator();
        while (it.hasNext())
        {
            DiagramElement elt = (DiagramElement) it.next();
            if (elt instanceof GraphNode)
            {
                graphNodeChildren.add((GraphNode) elt);
            }
        }
        return graphNodeChildren;
    }

    /**
     * Refresh the diagram properties and set default values if necessary
     */
    protected void refreshDiagramProperties()
    {
        if (DIUtils.getProperty(getDiagram(), ModelerPropertyConstants.PAGE_WIDTH) == null)
        {
            IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();

            // retrieve the default PageFormat
            PageFormat defaultPageFormat = PageFormat.getDefault();

            // retrieve the default PageMargin
            PageMargin defaultPageMargin = PageMargin.getDefault();

            // Set the diagram properties in the diagram file
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.PAGE_FORMAT_NAME, defaultPageFormat.getName());
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.PAGE_WIDTH, StringConverter.asString(defaultPageFormat.getWidth()));
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.PAGE_HEIGHT, StringConverter.asString(defaultPageFormat.getHeight()));

            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.PAGE_MARGIN_NAME, defaultPageMargin.getName());
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.TOP_MARGIN, StringConverter.asString(defaultPageMargin.getTop()));
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.BOTTOM_MARGIN, StringConverter.asString(defaultPageMargin.getBottom()));
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.LEFT_MARGIN, StringConverter.asString(defaultPageMargin.getLeft()));
            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.RIGHT_MARGIN, StringConverter.asString(defaultPageMargin.getRight()));

            DIUtils.setProperty(getDiagram(), ModelerPropertyConstants.ORIENTATION, store.getString(ModelerPreferenceConstants.P_ORIENTATION));
        }

        int pageWidth;
        int pageHeight;

        // get values contained in the Diagram Object
        if (ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.ORIENTATION)))
        {
            // the portrait orientation is selected
            pageWidth = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.PAGE_WIDTH));
            pageHeight = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.PAGE_HEIGHT));
        }
        else
        {
            // the landscape orientation is selected : we inverse the width and
            // the height
            pageWidth = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.PAGE_HEIGHT));
            pageHeight = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.PAGE_WIDTH));
        }
        int topMargin = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.TOP_MARGIN));
        int bottomMargin = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.BOTTOM_MARGIN));
        int leftMargin = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.LEFT_MARGIN));
        int rightMargin = StringConverter.asInt(DIUtils.getPropertyValue(getDiagram(), ModelerPropertyConstants.RIGHT_MARGIN));

        // set the diagram bounds with values contained in the Diagram Object
     // TODO Determine whether we should keep this or not (for printing issue mainly)
//        page.setBounds(new Rectangle(-leftMargin, -topMargin, pageWidth + rightMargin, pageHeight + bottomMargin));
        body.setBounds(new Rectangle(0, 0, pageWidth - leftMargin - rightMargin, pageHeight - topMargin - bottomMargin));

        // revalidate is called to refresh the diagram properties
        body.revalidate();
    }

    /**
     * Return the default foreground color of this type of element
     * 
     * @return Color
     */
    protected Color getDefaultForegroundColor()
    {
        if (getDiagramGraphConf() != null)
        {
            return getDiagramGraphConf().getDefaultForegroundColor();
        }
        return ModelerColorConstants.black;
    }

    /**
     * Return the default foreground color of this type of element
     * 
     * @return Color
     */
    protected Color getDefaultBackgroundColor()
    {
        if (getDiagramGraphConf() != null)
        {
            return getDiagramGraphConf().getDefaultBackgroundColor();
        }
        return ModelerColorConstants.white;
    }

    /**
     * Return the default font of this type of element
     * 
     * @return Font
     */
    protected Font getDefaultFont()
    {
        if (getDiagramGraphConf() != null)
        {
            return getDiagramGraphConf().getDefaultFont();
        }
        return Display.getDefault().getSystemFont();
    }

    /**
     * Return the DiagramGraphConf corresponding to the activeDiagram
     * 
     * @return DiagramGraphConf
     */
    private DiagramGraphConf getDiagramGraphConf()
    {
        if (diagramGraphConf == null)
        {
            diagramGraphConf = ((ModelerGraphicalViewer) getViewer()).getModelerEditor().getActiveConfiguration().getDiagramGraphConf();
        }
        return diagramGraphConf;
    }
}
