/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Thibault Landré (Atos Origin) - Implemented FR1026
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections.graphics;

import java.util.regex.Pattern;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.commands.ChangeBoundsCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.editor.MixedEditDomain;

/**
 * The Size section on the graphics tab.
 * 
 * Creation 31 mars 2006
 * 
 * @author jlescot
 */
public class SizePropertySection extends AbstractGraphicPropertySection
{
    private static final int WIDTH_MODIFIED = 0;

    private static final int HEIGHT_MODIFIED = 1;

    // The pattern to match for the width and height Text
    private static Pattern pattern = Pattern.compile("-??\\d*");

    private Text width;

    private Text height;

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        // The Width of the GraphNode
        CLabel widthLabel = getWidgetFactory().createCLabel(composite, "Width:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        widthLabel.setLayoutData(data);

        width = getWidgetFactory().createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.right = new FormAttachment(50, -ITabbedPropertyConstants.HSPACE);
        width.setLayoutData(data);

        width.addSelectionListener(new SelectionAdapter()
        {

            public void widgetDefaultSelected(SelectionEvent e)
            {
                handleSizeChanged(WIDTH_MODIFIED);
            }

        });

        // The YPosition of the GraphElement
        CLabel heightLabel = getWidgetFactory().createCLabel(composite, "Height:");
        data = new FormData();
        data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        heightLabel.setLayoutData(data);

        height = getWidgetFactory().createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(50, STANDARD_LABEL_WIDTH);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.right = new FormAttachment(100, 0);
        height.setLayoutData(data);

        height.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetDefaultSelected(SelectionEvent e)
            {
                handleSizeChanged(HEIGHT_MODIFIED);
            }
        });
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        if (getDiagElt() != null && getDiagElt() instanceof GraphNode)
        {
            GraphNode graphNode = (GraphNode) getDiagElt();
            if (graphNode.getSize() != null)
            {
                String widthValue = String.valueOf(graphNode.getSize().width);
                String heightValue = String.valueOf(graphNode.getSize().height);
                
                width.setText(widthValue);
                height.setText(heightValue);

                // disable the Text if the value is -1
                width.setEnabled(isTextEnabled(widthValue));
                height.setEnabled(isTextEnabled(heightValue));
            }
        }
    }

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (height != null)
        {
            height.setEnabled(enabled);
        }
        if (width != null)
        {
            width.setEnabled(enabled);
        }
    }

    /**
     * Test if the value is different from -1
     * 
     * @param value the value to test
     * @return true if it is different, false otherwise
     */
    private boolean isTextEnabled(String value)
    {
        if ("-1".equals(value)) //$NON-NLS-1$
        {
            return false;
        }
        return true;
    }

    /**
     * Called when the selected size changes. It will create and execute the command to change the size of the
     * graphNodes selected.
     */
    private void handleSizeChanged(int mode)
    {
        String pWidth = width.getText();
        String pHeight = height.getText();

        if (isValidText(pWidth) && isValidText(pHeight))
        {
            MixedEditDomain mixedEditDomain = (MixedEditDomain) getPart().getAdapter(MixedEditDomain.class);

            if (getDiagEltList().size() == 1 && getDiagEltList().get(0) instanceof GraphNode)
            {
                GraphNode graphnode = (GraphNode) getDiagEltList().get(0);

                Dimension dimension = new Dimension(Integer.parseInt(pWidth), Integer.parseInt(pHeight));
                Rectangle rectangle = new Rectangle(graphnode.getPosition(), dimension);

                ChangeBoundsCommand changeBoundsCommand = new ChangeBoundsCommand(graphnode, rectangle);

                mixedEditDomain.getCommandStack().execute(changeBoundsCommand);

            }
            else
            {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (DiagramElement diagElt : getDiagEltList())
                {
                    if (diagElt instanceof GraphNode)
                    {
                        GraphNode graphnode = (GraphNode) diagElt;
                        Dimension dimension;
                        if (mode == HEIGHT_MODIFIED)
                        {
                            dimension = new Dimension(graphnode.getSize().width, Integer.parseInt(pHeight));
                        }
                        else
                        {
                            dimension = new Dimension(Integer.parseInt(pWidth), graphnode.getSize().height);
                        }
                        Rectangle rectangle = new Rectangle(graphnode.getPosition(), dimension);

                        ChangeBoundsCommand changeBoundsCommand = new ChangeBoundsCommand(graphnode, rectangle);
                        compoundCommand.add(changeBoundsCommand);

                    }
                }
                mixedEditDomain.getCommandStack().execute(compoundCommand);
            }
            refresh();
        }
    }

    /**
     * Verify if the string is not empty and matches the pattern defined in this class
     * 
     * @param string the string to test.
     * @return true if it is not empty and if it matches.
     */
    private boolean isValidText(String string)
    {
        return string.length() != 0 && pattern.matcher(string).matches();
    }

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#handleModelChanged(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleModelChanged(Notification msg)
    {
        Object notifier = msg.getNotifier();
        if (notifier.equals(getDiagElt()))
        {
            if (msg.getFeatureID(getDiagElt().getClass()) == DiagramInterchangePackage.DIAGRAM__SIZE)
            {
                refresh();
            }
        }

    }

}