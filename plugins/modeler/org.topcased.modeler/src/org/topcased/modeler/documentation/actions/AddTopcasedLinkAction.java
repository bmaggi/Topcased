//------------------------------------------------------------------------------
// Copyright (c) 2009 Anyware Technologies and others
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
//      Anyware Technologies - initial API and implementation
//------------------------------------------------------------------------------
package org.topcased.modeler.documentation.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.outline.ModelContentProvider;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.dialogs.SelectResourceDialog;
import org.topcased.richtext.IRichText;
import org.topcased.richtext.RichTextCommand;
import org.topcased.richtext.RichTextImages;
import org.topcased.richtext.actions.RichTextAction;

/**
 * Adds a link to a topcased model element.
 * 
 * @author Jose Alfredo Serrano
 */
public class AddTopcasedLinkAction extends RichTextAction {

	/**
	 * Creates a new instance.
	 */
	public AddTopcasedLinkAction(IRichText richText) {
		super(richText, IAction.AS_PUSH_BUTTON);
		setImageDescriptor(ModelerImageRegistry.getImageDescriptor("MODEL_LINK"));
		setDisabledImageDescriptor(RichTextImages.DISABLED_IMG_DESC_ADD_LINK);
		setToolTipText("Link to Element");
	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *            a rich text control
	 */
	public void execute(IRichText richText)
	{
		if (richText != null)
		{
			String linkURL = createURL();
			if (linkURL != null && linkURL.length() > 0) {
				richText.executeCommand(RichTextCommand.ADD_LINK, linkURL);
			}
		}
	}
	
	public boolean disableInSourceMode() {
		return false;
	}

	private String createURL()
	{
		ISelectionStatusValidator validator = new ISelectionStatusValidator() {
			
			public IStatus validate(Object[] selectedElements) {
				boolean enableOK = false;
				String msg = "Only one EObject can be selected";
				if (selectedElements.length == 1 && selectedElements[0] instanceof EObject)
				{
					enableOK = true;
					msg = "";
				}

				return enableOK ? new Status(IStatus.OK, "org.eclipse.emf.common.ui",
						0, msg, null) : new Status(IStatus.ERROR,
						"org.eclipse.emf.common.ui", 0, msg, null);
			}
		};
		
		EObject selection = null;
		IEditorPart activeEditor = ModelerPlugin.getActivePage().getActiveEditor();
		if (activeEditor instanceof Modeler)
		{
			Modeler modeler = (Modeler) activeEditor;
			AdapterFactoryContentProvider adapterFactoryContentProvider = new AdapterFactoryContentProvider(
					new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			ITreeContentProvider contentProvider = new ModelContentProvider(modeler, adapterFactoryContentProvider);
			selection = SelectResourceDialog.openElementSelection(modeler.getDiagrams(), null, contentProvider, validator, null, true);
		}
		
		
		if (selection != null)
		{
			// XXX : HACK Extreme hacking on... 
			// there should be a proper way to handle with spaces and URIs.
			String uri = EcoreUtil.getURI(selection).toString();
			return "http://" + uri.replace(" ", "%20");
		}
		
		return null;
	}
}