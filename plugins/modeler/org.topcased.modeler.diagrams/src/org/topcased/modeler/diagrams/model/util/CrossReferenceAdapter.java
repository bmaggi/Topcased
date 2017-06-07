/***********************************************************************
 * Copyright (c) 2009 Obeo
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *    Caroline Bourdeu d'Aguerre (ATOS ORIGIN INTEGRATION) caroline.bourdeudaguerre@atosorigin.com - Fix bug #2804
 **********************************************************************/
package org.topcased.modeler.diagrams.model.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;

/**
 * This adapter that maintains all EMFSemanticModelBridge references to improve
 * diagrams navigation performance.
 */
public class CrossReferenceAdapter extends ECrossReferenceAdapter {

	@Override
	protected void handleCrossReference(EReference reference,
			Notification notification) {
		if (DiagramInterchangePackage.eINSTANCE
				.getEMFSemanticModelBridge_Element().equals(reference)) {
			super.handleCrossReference(reference, notification);
		}
	}

	@Override
	protected void handleContainment(Notification notification) {
		switch (notification.getEventType()) {
		/** Case diagram removed  */
		case Notification.REMOVE: {
			Notifier oldValue = (Notifier) notification.getOldValue();
			if (oldValue != null && oldValue instanceof Diagram) {
				Diagram s = (Diagram) oldValue;
				SemanticModelBridge bridge = s.getSemanticModel();
				if (bridge instanceof EMFSemanticModelBridge) {
					EMFSemanticModelBridge emfBridge = (EMFSemanticModelBridge) bridge;
					EObject element = emfBridge.getElement();
					Collection<Setting> settings = inverseCrossReferencer
							.get(element);
					/** Remove all cross references from inverseCrossReferencer */
					for (Iterator<Setting> i = settings.iterator(); i.hasNext();) {
					    Setting setting = i.next();
						if (setting.getEObject() instanceof EMFSemanticModelBridge) {
							 EMFSemanticModelBridge bridge2 = (EMFSemanticModelBridge)setting.getEObject();
							 GraphElement graphElement = bridge2.getGraphElement();
							 if (graphElement != null && graphElement instanceof Diagram)
							 {
								 Diagram diagram = (Diagram) graphElement;
								 if (diagram == (EObject) oldValue)
								 {
									 /** Remove the cross reference */
									 i.remove();
									 
									 /** Remove the associated adapter */
									 diagram.eAdapters().remove(this);
								 }
							 }
							 else
							 {
							     i.remove();
							 }
						}
						else
						{
						    i.remove();
						}
					}
				}
			}
		}
		default:
			super.handleContainment(notification);
		}
	}
	

	/**
	 * Get all the diagrams referencing the given model object.
	 */
	public List<Diagram> getDiagramsInverseReferences(EObject modelObject) {
		List<Diagram> diagramInverseReferences = new ArrayList<Diagram>();
		Collection<Setting> usages = super.getInverseReferences(modelObject);
		for (Setting usage : usages) {
			if ((usage.getEStructuralFeature()
					.equals(DiagramInterchangePackage.eINSTANCE
							.getEMFSemanticModelBridge_Element()))
					&& (usage.getEObject() instanceof EMFSemanticModelBridge)) {
				EMFSemanticModelBridge semanticModelBridge = (EMFSemanticModelBridge) usage
						.getEObject();
				GraphElement graphElement = semanticModelBridge
						.getGraphElement();
				if (graphElement != null && graphElement instanceof Diagram) {
					Diagram diagram = (Diagram) graphElement;
					diagramInverseReferences.add(diagram);
				}
			}
		}
		return diagramInverseReferences;
	}

	/**
	 * Searches the adapter list of the given Notifier for a
	 * CrossReferenceAdapter. If not found, returns null.
	 * 
	 * @param notifier
	 *            the notifier to search
	 * @return the CrossReferenceAdapter if found, otherwise null
	 */
	public static CrossReferenceAdapter getExistingDiagramsCrossReferenceAdapter(
			Notifier notifier) {
		if (notifier == null) {
			return null;
		}
		for (Adapter a : notifier.eAdapters())
		{
			if (a instanceof CrossReferenceAdapter)
			{
				return (CrossReferenceAdapter) a ;
			}
		}
		if (notifier instanceof Resource)
		{
			CrossReferenceAdapter adapter = getExistingDiagramsCrossReferenceAdapter(((Resource)notifier).getResourceSet());
			if (adapter != null)
			{
				notifier.eAdapters().add(adapter);
				return (CrossReferenceAdapter) adapter;
            }
        }
        else if (notifier instanceof EObject)
        {
            CrossReferenceAdapter adapter = getExistingDiagramsCrossReferenceAdapter(((EObject) notifier).eResource());
            if (adapter != null)
            {
                notifier.eAdapters().add(adapter);
                return (CrossReferenceAdapter) adapter;
            }
        }
        return null;
	}

	public void dispose() {
		inverseCrossReferencer.clear();
		inverseCrossReferencer = null;
	}

}
