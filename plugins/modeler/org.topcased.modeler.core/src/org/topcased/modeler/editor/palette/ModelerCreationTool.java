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

package org.topcased.modeler.editor.palette;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.swt.SWT;
import org.topcased.modeler.commands.IDialogCommand;
import org.topcased.modeler.editor.GraphElementCreationFactory;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.utils.Utils;

/**
 * A CreationTool proper to our Editors.
 * 
 * Creation : 13 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerCreationTool extends CreationTool
{
    /**
     * The constructor
     */
    public ModelerCreationTool()
    {
        super();
    }

    /**
     * Prevent the bug when we display a dialog during the command execution the
     * viewer was set to null.
     * 
     * @see org.eclipse.gef.tools.CreationTool#performCreation(int)
     */
    @Override
    protected void performCreation(int button)
    {
        EditPartViewer viewer = getCurrentViewer();
        calculateOriginalSize();
        executeCurrentCommand();
        setViewer(viewer);
        selectAddedObject();
        performEdition();
    }

    /**
     * 
     */
    private void performEdition()
    {
        final Object model = getCreateRequest().getNewObject();
        if (model == null)
        {
            return;
        }

        EditPartViewer viewer = getCurrentViewer();
        // check if the viewer is not null
        if (viewer != null)
        {
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof EditPart)
            {
                ((EditPart) editpart).performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
            }
        }

    }

    /**
     * This method calculate the original size of the graphical element to
     * create, according to the values of the default and minimum Dimension.
     */
    private void calculateOriginalSize()
    {
        DiagramGraphConf diagGraphConf = ((ModelerGraphicalViewer) getCurrentViewer()).getModelerEditor().getActiveConfiguration().getDiagramGraphConf();
        GraphElementCreationFactory factory = (GraphElementCreationFactory) getFactory();
        NodeGraphConf nodeGraphConf = null;
        if (diagGraphConf != null && factory.getEClass() != null)
        {
            nodeGraphConf = Utils.getNodeGraphConf(diagGraphConf, factory.getNewModelObject(),
                    factory.getPresentation());
        }
        else if (diagGraphConf != null && factory.getType() != null)
        {
            nodeGraphConf = diagGraphConf.getNodeGraphConf(factory.getType(), factory.getPresentation());
        }

        if (nodeGraphConf != null)
        {
            updateRequestSize(nodeGraphConf);
        }

        setCurrentCommand(getCommand());
    }

    /**
     * Update the request dimension with the values defined in the configuration
     * of the given NodeGraphConf
     * 
     * @param nodeGraphConf The Configuration of a node element.
     */
    private void updateRequestSize(NodeGraphConf nodeGraphConf)
    {
        EditPart target = getTargetEditPart();

        if (target instanceof GraphicalEditPart)
        {
            IFigure figure = ((GraphicalEditPart) target).getFigure();
            CreateRequest req = getCreateRequest();
            if (req.getSize() == null)
            {
                Dimension defaultDim = new Dimension(nodeGraphConf.getDefaultWidth(), nodeGraphConf.getDefaultHeight());
                figure.translateToParent(defaultDim);
                figure.translateToAbsolute(defaultDim);
                // the user is performing a creation by just specifying the
                // location
                req.setSize(defaultDim);
            }
            else
            {
                // the user is performing size-on-drop creation
                Dimension dim = req.getSize().getCopy();
                figure.translateToRelative(dim);
                figure.translateFromParent(dim);

                // Check whether the dimension is not smaller than the minimum
                // size
                dim.width = Math.max(dim.width, nodeGraphConf.getMinimumWidth());
                dim.height = Math.max(dim.height, nodeGraphConf.getMinimumHeight());

                // Check whether the dimension is not larger than the maximum
                // size
                if (nodeGraphConf.getMaximumWidth() != 0)
                {
                    dim.width = Math.min(dim.width, nodeGraphConf.getMaximumWidth());
                }
                if (nodeGraphConf.getMaximumHeight() != 0)
                {
                    dim.height = Math.min(dim.height, nodeGraphConf.getMaximumHeight());
                }

                // Initialize with the default size when the figure has not a
                // resizable
                // width
                if (!nodeGraphConf.isIsWidthResizable())
                {
                    dim.width = nodeGraphConf.getDefaultWidth();
                }

                // Initialize with the default size when the figure has not a
                // resizable
                // height
                if (!nodeGraphConf.isIsHeightResizable())
                {
                    dim.height = nodeGraphConf.getDefaultHeight();
                }

                figure.translateToParent(dim);
                figure.translateToAbsolute(dim);
                req.setSize(dim);
            }
        }
    }

    /**
     * @see org.eclipse.gef.tools.AbstractTool#executeCurrentCommand()
     */
    @Override
    protected void executeCurrentCommand()
    {
        boolean ok = true;

        Command curCommand = getCurrentCommand();
        if (curCommand instanceof IDialogCommand)
        {
            ok = ((IDialogCommand) curCommand).openDialog();
        }
        if (ok && curCommand != null && curCommand.canExecute())
        {
            executeCommand(curCommand);
        }
        setCurrentCommand(null);
    }

    /**
     * Add the newly created object to the viewer's selected objects.
     */
    private void selectAddedObject()
    {
        final Object model = getCreateRequest().getNewObject();
        if (model == null)
        {
            return;
        }
        EditPartViewer viewer = getCurrentViewer();
        // check if the viewer is not null
        if (viewer != null)
        {
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof EditPart)
            {
                // Force the new object to get positioned in the viewer.
                viewer.flush();
                viewer.select((EditPart) editpart);
            }
        }
    }
    
    /**
     * Overridden so that the current tool will remain active (locked) if the
     * user is pressing the ctrl key.
     */
    @Override
    protected void handleFinished() {
        // SWT.COMMAND is used as a convenient Mac OS X binding
        if (!getCurrentInput().isModKeyDown(SWT.CONTROL | SWT.COMMAND)) {
            super.handleFinished();
        } else {
            reactivate();
        }
    }
}
