/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.documentation.view.topcased;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.papyrus.documentation.IDocumentationManager;
import org.eclipse.papyrus.documentation.eannotation.EAnnotationDocumentationManager;
import org.eclipse.papyrus.documentation.view.IDocumentationPartHandler;
import org.eclipse.papyrus.documentation.view.SelectResourceDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.PageBookView;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.editor.outline.ModelContentProvider;


public class TopcasedDocumentationPartHandler implements IDocumentationPartHandler {

	public boolean canHandlePart(IWorkbenchPart part) {
		if (part != null) {
			IEditorPart adaptedEditor = (IEditorPart)part.getAdapter(IEditorPart.class);
			if (part instanceof Modeler || adaptedEditor instanceof Modeler) {
				return true;
			}
		}
		return false;
	}

	public IDocumentationManager getDocumentationManager() {
		return EAnnotationDocumentationManager.getInstance();
	}

	public void executeCommand(IWorkbenchPart part, Command cmd) {
		EditingDomain editingDomain = getEditingDomain(part);

		if(editingDomain != null) {
			CommandStack commandStack = editingDomain.getCommandStack();
			if(commandStack != null) {
				commandStack.execute(cmd);
			}
		}
	}

	public EObject getAssociatedDiagram(IWorkbenchPart part, EObject eObject) {
		if (part instanceof Modeler) {
			Modeler modeler = (Modeler)part;
			Diagram diagram = modeler.getActiveDiagram();
			SemanticModelBridge semanticBridge = diagram.getSemanticModel();
			if (semanticBridge instanceof EMFSemanticModelBridge) {
				EObject element = ((EMFSemanticModelBridge)semanticBridge).getElement();
				if (element != null && element.equals(eObject)) {
					return diagram;
				}
			}
		}
		return null;
	}

	private EditingDomain getEditingDomain(IWorkbenchPart part) {
		if(part.getAdapter(EditingDomain.class) != null) {
			return (EditingDomain)part.getAdapter(EditingDomain.class);
		}

		if(part instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider)part).getEditingDomain();
		}

		if(part.getAdapter(IEditingDomainProvider.class) != null) {
			return ((IEditingDomainProvider)part.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
		}

		if(part instanceof PageBookView) {
			IPage page = ((PageBookView)part).getCurrentPage();
			if(page instanceof IEditingDomainProvider) {
				return ((IEditingDomainProvider)page).getEditingDomain();
			}
		}

		return null;
	}

	public void openElement(IWorkbenchPart part, URI elementUri) {
		if (part instanceof Modeler) {
			Modeler modeler = (Modeler)part;
			EObject eObject = modeler.getResourceSet().getEObject(elementUri, false);

			if (eObject instanceof Diagram && modeler.getActiveDiagram() != eObject)
			{
				modeler.setActiveDiagram((Diagram) eObject);
			}
			else if (AdapterFactoryEditingDomain.unwrap(eObject) instanceof EObject)
			{
				modeler.gotoEObject((EObject) AdapterFactoryEditingDomain.unwrap(eObject));
			}
		}
	}


	public EObject openElementSelectionDialog(IWorkbenchPart part) {
		if (part instanceof Modeler)
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

			Modeler modeler = (Modeler)part;
			AdapterFactoryContentProvider adapterFactoryContentProvider = new AdapterFactoryContentProvider(
				new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			ModelContentProvider contentProvider = new ModelContentProvider(modeler, adapterFactoryContentProvider);
			Object selection = SelectResourceDialog.openElementSelection(modeler.getDiagrams(), null, contentProvider, validator, null, true);
			if (selection instanceof EObject) {
				return (EObject)selection;
			}
		}
		return null;
	}

	public boolean isReadOnly(IWorkbenchPart part, EObject eObject) {
      EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
      if (editingDomain instanceof TopcasedAdapterFactoryEditingDomain)
      {
          TopcasedAdapterFactoryEditingDomain topDomain = (TopcasedAdapterFactoryEditingDomain) editingDomain;
          return topDomain.isReadOnly(eObject.eResource());
      }
      return false;
	}

}
