/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties;

import java.util.ArrayList;
import java.util.List;

import org.topcased.modeler.editor.Modeler;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;

public class ModelerPropertySheetPage extends AbstractTabbedPropertySheetPage {

	/**
	 * The graphical editor.
	 */
	protected Modeler editor;

	/**
	 * Contructor for this property sheet page.
	 * 
	 * @param editor
	 *            the editor contributor of the property sheet page.
	 */
	public ModelerPropertySheetPage(Modeler editor) {
		super(editor);
		this.editor = editor;
	}

	/**
	 * Get the EMF AdapterFactory for this editor.
	 * 
	 * @return the EMF AdapterFactory for this editor.
	 */
	public Modeler getEditor() {
		return editor;
	}

	/**
	 * Get the EMF AdapterFactory for this editor.
	 * 
	 * @return the EMF AdapterFactory for this editor.
	 */
	public List getAdapterFactories() {
        List factories = new ArrayList();
        factories.add(editor.getAdapterFactory());

        factories.addAll(super.getAdapterFactories());

        return factories;
	}
}
