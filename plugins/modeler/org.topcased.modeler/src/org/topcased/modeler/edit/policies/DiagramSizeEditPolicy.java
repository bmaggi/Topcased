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

package org.topcased.modeler.edit.policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramPropertiesCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageFormat;
import org.topcased.modeler.preferences.PageMargin;
import org.topcased.modeler.requests.AutoResizeRequest;

/**
 * This policy handles the AutoLayout request for the diagrams
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DiagramSizeEditPolicy extends ResizableEditPolicy
{
    /**
     * @see org.topcased.modeler.edit.policies.ResizableEditPolicy#getAutoResizeCommand(org.topcased.modeler.requests.AutoResizeRequest)
     */
    protected Command getAutoResizeCommand(AutoResizeRequest request)
    {
        if (request.getContentPaneSize() != null)
        {
            try
            {
                Diagram diag = (Diagram) getHost().getModel();
                Rectangle wishBounds = new Rectangle();
                wishBounds.width = request.getContentPaneSize().width + request.getMargin();
                wishBounds.height = request.getContentPaneSize().height + request.getMargin();

                return createOptimalFormatCommand(diag, wishBounds);
            }
            catch (BoundsFormatException e)
            {
                return UnexecutableCommand.INSTANCE;
            }
        }
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Find the optimal format for the given bounding rectangle
     * 
     * @param diagram the diagram to optimize
     * @param boundingRect the rectangle to display
     * @return The command to change the diagram properties
     * @throws BoundsFormatException if no format can display this bounding
     *             rectangle
     */
    protected Command createOptimalFormatCommand(Diagram diagram, Rectangle boundingRect) throws BoundsFormatException
    {

        // found the optimal format
        String originalOrientation = DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.ORIENTATION);
        PageMargin originalMargin = PageMargin.getPageMargin(DIUtils.getPropertyValue(diagram,
                ModelerPropertyConstants.PAGE_MARGIN_NAME));

        List<PageFormat> workingFormats = new ArrayList<PageFormat>();
        String prefFormats = ModelerPlugin.getDefault().getPreferenceStore().getString(
                ModelerPreferenceConstants.P_PAGE_FORMATS);
        StringTokenizer tokenizerFormats = new StringTokenizer(prefFormats,
                ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);

        // Check formats with the same orientation
        String orientation = originalOrientation;
        int tokenCount = tokenizerFormats.countTokens();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            if (!overflow(originalOrientation, originalMargin, pageFormat, boundingRect))
            {
                workingFormats.add(pageFormat);
            }
        }

        // Try with the other orientation
        tokenizerFormats = new StringTokenizer(prefFormats, ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        if (ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(originalOrientation))
        {
            orientation = ModelerPropertyConstants.LANDSCAPE_ORIENTATION;
        }
        else
        {
            orientation = ModelerPropertyConstants.PORTRAIT_ORIENTATION;
        }

        tokenCount = tokenizerFormats.countTokens();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            if (!overflow(orientation, originalMargin, pageFormat, boundingRect))
            {
                workingFormats.add(pageFormat);
            }
        }

        // Create the command or fail if there is no matching format
        if (workingFormats.isEmpty())
        {
            throw new BoundsFormatException(
                    "Autolayout cannot be performed. There is no format available to display all the objects. Your model may be too big for the current page size. You should choose a greater page size and try again to drag'n drop the whole model from the outline.");
        }

        PageFormat optimalFormat = findOptimalFormat((PageFormat[]) workingFormats.toArray(new PageFormat[workingFormats.size()]));
        orientation = originalOrientation;
        if (overflow(originalOrientation, originalMargin, optimalFormat, boundingRect))
        {
            if (ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(originalOrientation))
            {
                orientation = ModelerPropertyConstants.LANDSCAPE_ORIENTATION;
            }
            else
            {
                orientation = ModelerPropertyConstants.PORTRAIT_ORIENTATION;
            }
        }

        Map<String, String> newProperties = new HashMap<String, String>();
        newProperties.put(ModelerPropertyConstants.PAGE_FORMAT_NAME, optimalFormat.getName());
        newProperties.put(ModelerPropertyConstants.PAGE_WIDTH, String.valueOf(optimalFormat.getWidth()));
        newProperties.put(ModelerPropertyConstants.PAGE_HEIGHT, String.valueOf(optimalFormat.getHeight()));
        newProperties.put(ModelerPropertyConstants.PAGE_MARGIN_NAME, originalMargin.getName());
        newProperties.put(ModelerPropertyConstants.TOP_MARGIN, String.valueOf(originalMargin.getTop()));
        newProperties.put(ModelerPropertyConstants.BOTTOM_MARGIN, String.valueOf(originalMargin.getBottom()));
        newProperties.put(ModelerPropertyConstants.LEFT_MARGIN, String.valueOf(originalMargin.getLeft()));
        newProperties.put(ModelerPropertyConstants.RIGHT_MARGIN, String.valueOf(originalMargin.getRight()));
        newProperties.put(ModelerPropertyConstants.ORIENTATION, orientation);

        return new ChangeDiagramPropertiesCommand(diagram, newProperties);
        // Ask if the user want to change the format
        // if yes, execute the command and add the command to the compound
        // command (the one not executing already executed commands)
        // add the autolayout command to the compund command
    }

    /**
     * Find the format with the smallest area in the given list of formats
     * 
     * @param formats the list of formats
     * @return the optimal one
     */
    private PageFormat findOptimalFormat(PageFormat[] formats)
    {
        PageFormat format = null;

        for (int i = 0; i < formats.length; i++)
        {
            if (format == null || getArea(format) > getArea(formats[i]))
            {
                format = formats[i];
            }
        }

        return format;
    }

    /**
     * Compute the area of the given page format
     * 
     * @param format the page format
     * @return the area
     */
    private int getArea(PageFormat format)
    {
        return format.getHeight() * format.getWidth();
    }

    /**
     * 
     * Check if the given rectangle overflows the given configuration.
     * 
     * @param orientation the Page orientation
     * @param margin tHe margin configuration
     * @param format The Page format
     * @param box the box to check
     * @return <code>true</code> if the bow can be shown with the given
     *         configuration
     */
    private boolean overflow(String orientation, PageMargin margin, PageFormat format, Rectangle box)
    {
        int width = -1;
        int height = -1;
        // get values contained in the Diagram Object
        if (ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(orientation))
        {
            // the portrait orientation is selected
            width = format.getWidth();
            height = format.getHeight();
        }
        else
        {
            // the landscape orientation is selected : we inverse the width and
            // the height
            width = format.getHeight();
            height = format.getWidth();
        }
        Rectangle container = new Rectangle(0, 0, width - margin.getLeft() - margin.getRight(), height
                - margin.getTop() - margin.getBottom());

        return !container.contains(box);
    }
}
