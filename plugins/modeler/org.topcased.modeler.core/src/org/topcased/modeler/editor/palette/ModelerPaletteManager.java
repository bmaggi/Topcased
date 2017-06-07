/***********************************************************************
 * Copyright (c) 2006, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.editor.palette;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.SharedImages;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.ModelerSimpleObjectConstants;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.editor.IPaletteManager;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * A generic PaletteManager. Add the common tools for all editors. Subclasses should add their own categories.
 * 
 * Creation : 02 jan. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class ModelerPaletteManager implements IPaletteManager
{
    private PaletteRoot root;

    private PaletteStack marqueeStack;

    /**
     * @see org.topcased.modeler.editor.IPaletteManager#getRoot()
     */
    public PaletteRoot getRoot()
    {
        if (root == null)
        {
            createPalette();
        }
        return root;
    }

    /**
     * @see org.topcased.modeler.editor.IPaletteManager#updatePalette()
     */
    public void updatePalette()
    {
        if (root == null)
        {
            createPalette();
        }
        updateCategories();
    }

    /**
     * Creates the PaletteRoot and adds all Palette elements.
     */
    private void createPalette()
    {
        root = new PaletteRoot();
        // add the default ControlGroup
        createControlGroup();
        // add all the other categories
        createCategories();
    }

    /**
     * Creates the container for control objects (selection, marquee...)
     */
    private void createControlGroup()
    {
        PaletteGroup controlGroup = new PaletteGroup("Control Group");

        List<PaletteEntry> entries = new ArrayList<PaletteEntry>();

        ToolEntry tool = new SelectionToolEntry();
        entries.add(tool);

        root.setDefaultEntry(tool);

        marqueeStack = new PaletteStack("Marquee", "Marquee Tool selection", SharedImages.DESC_MARQUEE_TOOL_16);
        PaletteEntry defaultMarquee = new ExtMarqueeToolEntry("Marquee");
        marqueeStack.add(defaultMarquee);
        marqueeStack.add(new MarqueeToolEntry("Full Marquee", "Marquee that selects all the objects"));
        MarqueeToolEntry connMarquee = new MarqueeToolEntry("Connections Marquee");
        connMarquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(
                MarqueeSelectionTool.BEHAVIOR_CONNECTIONS_TOUCHED));
        marqueeStack.add(connMarquee);
        marqueeStack.setActiveEntry(defaultMarquee);
        entries.add(marqueeStack);

        CreationFactory factory = new CreationFactory()
        {
            /**
             * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
             */
            public Object getNewObject()
            {
                GraphNode node = DiagramInterchangeFactory.eINSTANCE.createGraphNode();
                SimpleSemanticModelElement element = DiagramInterchangeFactory.eINSTANCE.createSimpleSemanticModelElement();
                element.setTypeInfo(ModelerSimpleObjectConstants.SIMPLE_OBJECT_NOTE);
                element.setPresentation("default");
                node.setSemanticModel(element);

                org.topcased.modeler.di.model.Property property = DiagramInterchangeFactory.eINSTANCE.createProperty();
                property.setKey(ModelerPropertyConstants.NOTE_VALUE);
                node.getProperty().add(property);

                return node;
            }

            /**
             * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
             */
            public Object getObjectType()
            {
                return null;
            }
        };
        entries.add(new CreationToolEntry("Note", "Note", factory, ModelerImageRegistry.getImageDescriptor("NOTE"),
                ModelerImageRegistry.getImageDescriptor("NOTE")));

        controlGroup.addAll(entries);

        root.add(controlGroup);
    }

    /**
     * @see org.topcased.modeler.editor.IPaletteManager#getMarqueeDragTracker()
     */
    public DragTracker getMarqueeDragTracker()
    {
        DragTracker tracker = null;
        PaletteEntry entry = marqueeStack.getActiveEntry();
        if (entry instanceof ToolEntry)
        {
            Tool entryTool = ((ToolEntry) entry).createTool();
            if (entryTool instanceof DragTracker)
            {
                tracker = (DragTracker) entryTool;
            }
        }
        return tracker;
    }

    /**
     * Creates the main categories of the palette. Subclasses should override this to provide their own categories.
     */
    protected abstract void createCategories();

    /**
     * Update the main categories of the palette. Subclasses should override this to manage their own categories.
     */
    protected abstract void updateCategories();

}
