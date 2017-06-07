/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * This Content Provider displays contents of model and diagrams. For the model, this provider delegates contents
 * computing to the model content provider. <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class ModelContentProvider implements ITreeContentProvider
{
    private static final String EXTENSION_POINT_VIRTUAL_CONTAINER = "org.topcased.modeler.OutlineVirtualContainer";

    private Map<EClass, List<VirtualContainer>> containers = getVirtualContainers();

    private static final Object[] NO_CHILDREN = new Object[0];

    private ITreeContentProvider delegatedModelProvider;

    private Modeler editor;

    private AdditionalResources resources;

    /**
     * Constructor
     * 
     * @param modeler the editor
     * @param delegatedProvider the delegated content provider
     */
    public ModelContentProvider(Modeler modeler, ITreeContentProvider delegatedProvider)
    {
        delegatedModelProvider = delegatedProvider;
        editor = modeler;

        resources = new AdditionalResources(editor);
    }

    /**
     * Retrieves if the preference is not set the virtual containers
     */
    private Map<EClass, List<VirtualContainer>> getVirtualContainers()
    {
        Map<EClass, List<VirtualContainer>> containers = new HashMap<EClass, List<VirtualContainer>>();
        if (Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_OUTLINE_DISPLAY_VIRTUAL_CONTAINERS))
        {
            for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_VIRTUAL_CONTAINER))
            {
                try
                {
                    VirtualContainer cont = (VirtualContainer) element.createExecutableExtension("virtualContainer");
                    EClass toMatch = cont.getEClassToMatch();
                    add(toMatch, cont, containers);
                }
                catch (CoreException e)
                {
                }
            }
        }
        return containers;

    }

    /**
     * Add virtual cotnainer in the map
     */
    private void add(EClass toMatch, VirtualContainer cont, Map<EClass, List<VirtualContainer>> containers)
    {
        List<VirtualContainer> list = containers.get(toMatch);
        if (list == null)
        {
            list = new LinkedList<VirtualContainer>();
            containers.put(toMatch, list);
        }
        list.add(cont);
    }

    /**
     * Returns the additional resources node
     * 
     * @return the node
     */
    protected AdditionalResources getAdditionalResources()
    {
        return resources;
    }

    /**
     * Returns the editor
     * 
     * @return the modeler
     */
    protected Modeler getModeler()
    {
        return editor;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement)
    {
        // Return the edited root model object as root element
        if (parentElement instanceof Diagrams)
        {
            return new Object[] {EcoreUtil.getRootContainer(((Diagrams) parentElement).getModel()), resources};
        }
        // Only display diagram (no graphNodes or graphEdges)
        if (parentElement instanceof Diagram)
        {
            return NO_CHILDREN;
        }
        if (parentElement instanceof AdditionalResources)
        {
            return ((AdditionalResources) parentElement).getResources().toArray();
        }
        if (parentElement instanceof VirtualContainerInstance)
        {
            return ((VirtualContainerInstance) parentElement).getChildren().toArray();
        }
        // Model children and filter uuid annotation
        List children = new ArrayList();
        Object[] modelChildren = delegatedModelProvider.getChildren(parentElement);
        // children = Arrays.asList(modelChildren);
        for (int i = 0; i < modelChildren.length; i++)
        {
            Object child = modelChildren[i];
            if (child instanceof EAnnotation)
            {
                if (!IAnnotationConstants.UUID_SOURCE.equals(((EAnnotation) child).getSource()))
                {
                    children.add(child);
                }
            }
            else
            {
                children.add(child);
            }
        }
        // at the end look for virtual containers
        if (parentElement instanceof EObject)
        {
            EObject eobject = (EObject) parentElement ;
            List<EClass> superTypes = eobject.eClass().getEAllSuperTypes() ;
            List<EClass> eclasses = new ArrayList<EClass>(superTypes.size() + 1);
            eclasses.addAll(superTypes);
            eclasses.add(eobject.eClass());
            for (EClass e : eclasses)
            {
                if (containers.containsKey(e))
                {
                    List<VirtualContainer> list = containers.get(e);
                    if (list != null)
                    {
                        for (VirtualContainer v : list)
                        {
                            if (!v.getChildren((EObject) parentElement).isEmpty())
                            {
                                children.add(new VirtualContainerInstance(v, (EObject) parentElement));
                            }
                        }
                    }
                }
            }
        }

        // For the model objects, retrieves model children and merges result
        // with diagrams associated with this element

        if (parentElement instanceof EObject || parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry)
        {
            children.addAll(DiagramsUtils.findAllExistingDiagram(editor.getDiagrams(), (EObject) AdapterFactoryEditingDomain.unwrap(parentElement)));
        }

        return children.toArray();
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element)
    {
        // The parent of a diagram is the model object that contains it.
        if (element instanceof Diagram)
        {
            SemanticModelBridge bridge = ((Diagram) element).getSemanticModel();
            if (bridge instanceof EMFSemanticModelBridge)
            {
                return ((EMFSemanticModelBridge) bridge).getElement();
            }

            return null;
        }

        // Delegates
        if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject)
        {
            return delegatedModelProvider.getParent(element);
        }

        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element)
    {
        if (element instanceof Diagram)
        {
            return false;
        }

        return getChildren(element).length > 0;
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement)
    {
        return getChildren(inputElement);
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose()
    {
        delegatedModelProvider.dispose();
        resources = null ;
        editor = null ;
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
     *      java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
        delegatedModelProvider.inputChanged(viewer, oldInput, newInput);
    }

}