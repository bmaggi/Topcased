/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/

package org.topcased.modeler.editor.properties.sections.graphics;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeBoundsCommand;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * The Orientation/Direction section on the graphics tab.
 * 
 * Creation : 21 Nov. 2007
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DiagramElementOrientationPropertySection extends AbstractGraphicPropertySection
{
    /**
     * The Button used to change direction +90° clockwise
     */
    private Button positiveDirectionBtn;

    /**
     * The Button used to change direction -90° clockwise
     */
    private Button negativeDirectionBtn;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        CLabel orientationLabel = getWidgetFactory().createCLabel(composite, "Orientation:");
        positiveDirectionBtn = new Button(composite, SWT.PUSH);
        positiveDirectionBtn.setImage(ModelerImageRegistry.getImage("ARROW_ROTATE_CLOCKWISE"));
        positiveDirectionBtn.setText("+90°");
        positiveDirectionBtn.addSelectionListener(new SelectionListener()
        {
            public void widgetDefaultSelected(SelectionEvent e)
            {
                // TODO Auto-generated method stub
            }

            public void widgetSelected(SelectionEvent e)
            {
                handleDirectionChanged(true);
            }
        });

        negativeDirectionBtn = new Button(composite, SWT.PUSH);
        negativeDirectionBtn.setImage(ModelerImageRegistry.getImage("ARROW_ROTATE_ANTICLOCKWISE"));
        negativeDirectionBtn.setText("-90°");
        negativeDirectionBtn.addSelectionListener(new SelectionListener()
        {
            public void widgetDefaultSelected(SelectionEvent e)
            {
                // TODO Auto-generated method stub
            }

            public void widgetSelected(SelectionEvent e)
            {
                handleDirectionChanged(false);
            }
        });

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
// data.right = new FormAttachment(negativeDirectionBtn, -ITabbedPropertyConstants.HSPACE);
        orientationLabel.setLayoutData(data);

        data = new FormData();
        data.top = new FormAttachment(orientationLabel, 0, SWT.CENTER);
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
// data.right = new FormAttachment(negativeDirectionBtn, -ITabbedPropertyConstants.HSPACE);
        negativeDirectionBtn.setLayoutData(data);

        data = new FormData();
        data.top = new FormAttachment(orientationLabel, 0, SWT.CENTER);
        data.left = new FormAttachment(negativeDirectionBtn, ITabbedPropertyConstants.HSPACE);
        positiveDirectionBtn.setLayoutData(data);
    }

    /**
     * Called when the selected color changes
     * 
     * @param positiveWay indicate whether rotation should be performed 90° clockwise or not
     */
    protected void handleDirectionChanged(boolean positiveWay)
    {
        MixedEditDomain mixedEditDomain = (MixedEditDomain) getPart().getAdapter(MixedEditDomain.class);
        if (getDiagEltList().size() == 1)
        {
            CompoundCommand compoundCommand = new CompoundCommand();
            
            compoundCommand.add(new ChangeDiagramElementPropertyCommand(getDiagElt(), ModelerPropertyConstants.DIRECTION, Integer.toString(getNextDirection(
                    getCurrentDirection(getDiagElt()), positiveWay))));

            int newX = ((GraphNode) getDiagElt()).getPosition().x + ((GraphNode) getDiagElt()).getSize().width / 2 - ((GraphNode) getDiagElt()).getSize().height / 2;
            int newY = ((GraphNode) getDiagElt()).getPosition().y + ((GraphNode) getDiagElt()).getSize().height / 2 - ((GraphNode) getDiagElt()).getSize().width / 2;
            compoundCommand.add(new ChangeBoundsCommand((GraphNode) getDiagElt(), new Rectangle(new Point(newX, newY), ((GraphNode) getDiagElt()).getSize().getTransposed())));

            /* apply the property change to single selected object */
            mixedEditDomain.getCommandStack().execute(compoundCommand);
        }
        else
        {
            CompoundCommand compoundCommand = new CompoundCommand();
            /* apply the property change to all selected elements */
            for (DiagramElement nextObject : getDiagEltList())
            {
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(nextObject, ModelerPropertyConstants.DIRECTION, Integer.toString(getNextDirection(
                        getCurrentDirection(nextObject), positiveWay)));
                compoundCommand.add(command);
            }
            mixedEditDomain.getCommandStack().execute(compoundCommand);
        }
    }

    
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (positiveDirectionBtn != null)
        {
            positiveDirectionBtn.setEnabled(enabled);
        }
        if (negativeDirectionBtn != null)
        {
            negativeDirectionBtn.setEnabled(enabled);
        }
    }

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#handleModelChanged(org.eclipse.emf.common.notify.Notification)
     */
    protected void handleModelChanged(Notification msg)
    {
        // TODO Auto-generated method stub

    }

    private int getCurrentDirection(DiagramElement diagElt)
    {
        Property directionProperty = DIUtils.getProperty(diagElt, ModelerPropertyConstants.DIRECTION);
        return directionProperty == null ? PositionConstants.EAST : Integer.parseInt(directionProperty.getValue());
    }

    /**
     * Depending on the initialDirection and the way the rotate should be performed, return the new direction to apply
     * to the graphical element.
     * 
     * @param initialDir the initial Direction
     * @param positiveWay indicate whether rotation should be performed 90° clockwise or not
     * 
     * @return the new Direction
     */
    private int getNextDirection(int initialDir, boolean positiveWay)
    {
        int nextDir = PositionConstants.EAST;
        if (positiveWay)
        {
            switch (initialDir)
            {
                case PositionConstants.EAST:
                    nextDir = PositionConstants.SOUTH;
                    break;
                case PositionConstants.SOUTH:
                    nextDir = PositionConstants.WEST;
                    break;
                case PositionConstants.WEST:
                    nextDir = PositionConstants.NORTH;
                    break;

                default:
                    break;
            }
        }
        else
        {
            switch (initialDir)
            {
                case PositionConstants.EAST:
                    nextDir = PositionConstants.NORTH;
                    break;
                case PositionConstants.NORTH:
                    nextDir = PositionConstants.WEST;
                    break;
                case PositionConstants.WEST:
                    nextDir = PositionConstants.SOUTH;
                    break;

                default:
                    break;
            }
        }
        return nextDir;
    }

}
