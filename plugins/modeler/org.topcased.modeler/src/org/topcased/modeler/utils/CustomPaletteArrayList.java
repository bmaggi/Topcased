/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (2009) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteTemplateEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.topcased.modeler.preferences.PaletteConfigurationController;

/**
 * The Class CustomPaletteArrayList.
 */
public class CustomPaletteArrayList extends ArrayList<PaletteEntry> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8717349830179425415L;

	/** The currentdiagram. */
	private String currentdiagram;
	

	/**
	 * Instantiates a new custom palette array list.
	 * 
	 * @param diagram the diagram
	 */
	public CustomPaletteArrayList(String diagram) {
		super();
		currentdiagram = diagram;
	}

	/**
	 * Instantiates a new custom palette array list.
	 * 
	 * @param diagram the diagram
	 * @param arg0 the arg0
	 */
	public CustomPaletteArrayList(String diagram, Collection<? extends PaletteEntry> arg0) {
		super(arg0);
		currentdiagram = diagram;
	}

	/**
	 * Instantiates a new custom palette array list.
	 * 
	 * @param diagram the diagram
	 * @param arg0 the arg0
	 */
	public CustomPaletteArrayList(String diagram, int arg0) {
		super(arg0);
		currentdiagram = diagram;
	}
 
	/* (non-Javadoc)
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(PaletteEntry entry) {

		if (!(entry instanceof PaletteContainer) &&
			!(entry instanceof PaletteSeparator) &&	
			!(entry instanceof PaletteTemplateEntry) &&
				!PaletteConfigurationController.getInstance().isVisible(currentdiagram, entry.getLabel()))
		{
			return true;
		}
		else if (entry instanceof PaletteContainer)
		{
			List<?> childs = ((PaletteContainer)entry).getChildren();
			List<ToolEntry> toRemove = new LinkedList<ToolEntry>();
			for (Object subEntry: childs)
			{
				if (subEntry instanceof ToolEntry)
				{
					if (!PaletteConfigurationController.getInstance().isVisible(currentdiagram, ((ToolEntry)subEntry).getLabel()))
					{
						toRemove.add((ToolEntry)subEntry);
					}
				}
			}
			for (ToolEntry removed: toRemove)
			{
				((PaletteContainer)entry).remove((ToolEntry)removed);
			}
			if (((PaletteContainer) entry).getChildren().size() > 0)
			{
				return super.add(entry);
			}
			else
			{
				return true;
			}
		}
		else
		{
			return super.add(entry);
		}
	}

}
