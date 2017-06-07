/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.converter.util.ConverterUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.topcased.modeler.dialogs.InformationDialog;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Class GenericTransformAction. construct a menu with a set of eclasses candidates to a transformation
 */
public class GenericTransformAction extends CompoundContributionItem
{
    private AbstractGraphicalEditPart selection = null;

    private EObject selectionEObject = null;

    public GenericTransformAction()
    {
        super();
    }
    

    @Override
    public void dispose()
    {
        super.dispose();
        GenericTransformer.dispose();
        selectionEObject = null;
        selection = null;
    }

    public GenericTransformAction(String id)
    {
        super(id);
    }

    @Override
    protected IContributionItem[] getContributionItems()
    {
        ISelection currentSelection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
        if (currentSelection instanceof IStructuredSelection)
        {
            IStructuredSelection selec = (IStructuredSelection) currentSelection;
            if (selec.getFirstElement() instanceof AbstractGraphicalEditPart)
            {
                selection = (AbstractGraphicalEditPart) selec.getFirstElement();
                return fillContributionItems();
            }
            else if (selec.getFirstElement() instanceof EObject)
            {
                selectionEObject = (EObject) selec.getFirstElement();
                return fillContributionItems();
            }
        }
        return null;
    }

    private IContributionItem[] fillContributionItems()
    {
        Collection<IContributionItem> items = new LinkedList<IContributionItem>();
        items.add(new GenericTransformerContributionItem());
        return items.toArray(new IContributionItem[0]);
    }

    /**
     * The Class GenericTransformerContributionItem.
     */
    /**
     * @author tfaure
     *
     */
    private class GenericTransformerContributionItem extends ContributionItem
    {
        private Map<String, AdapterFactory> factories = new HashMap<String, AdapterFactory>();

        private Set<EClassifier> eClassifiers = new HashSet<EClassifier>();

        @Override
        public boolean isVisible()
        {
            return true;
        }

        public void fill(Menu menu, int index)
        {
            if (selection != null && selectionEObject == null)
            {
                if (selection instanceof EMFGraphNodeEditPart)
                {
                    EMFGraphNodeEditPart part = (EMFGraphNodeEditPart) selection;
                    selectionEObject = part.getEObject();
                }
                else if (selection instanceof EMFGraphEdgeEditPart)
                {
                    EMFGraphEdgeEditPart part = (EMFGraphEdgeEditPart) selection;
                    selectionEObject = part.getEObject();

                }
            }
            fillEClassifiers(selectionEObject);
            EStructuralFeature containingFeature = selectionEObject.eContainingFeature();
            if (containingFeature != null && containingFeature.getEType() instanceof EClass)
            {
                createMenu(menu, containingFeature);
            }
        }

        
        /**
         * from an eobject we get the epackage corresponding to the resource extension of the file
         * and get the imported epackage correspondant 
         * fix FR#2417
         * @param selectionEObject
         */
        private void fillEClassifiers(EObject selectionEObject)
        {
            Resource r = selectionEObject.eResource();
            URI uri = r.getURI();
            String extension = uri.fileExtension();
            for (Object p : EPackage.Registry.INSTANCE.values())
            {
                if (p instanceof EPackage)
                {
                    EPackage pack = (EPackage) p;
                    if (pack.getNsPrefix() != null && extension.toLowerCase().equals(pack.getNsPrefix().toLowerCase()))
                    {
                        addClassifiers(pack, eClassifiers);
                        factories.put(pack.getNsURI(), GenericTransformer.getFactory(pack.getNsURI()));
                        List<EPackage> packages = ConverterUtil.computeRequiredPackages(pack);
                        for (EPackage pTmp : packages)
                        {
                            addClassifiers(pTmp, eClassifiers);
                            factories.put(pTmp.getNsURI(), GenericTransformer.getFactory(pTmp.getNsURI()));
                        }
                    }
                }
            }
            // r.getContents().get(0)

        }

        /**
         * Creates the menu. from the containing feature
         * 
         * @param menu the menu
         * @param containingFeature the containing feature
         */
        private void createMenu(Menu menu, EStructuralFeature containingFeature)
        {
            EClass containgType = (EClass) containingFeature.getEType();
            List<EClassifier> allEClassifiers = getEClassifiers();
            Collections.sort(allEClassifiers, new Comparator<EClassifier>()
            {
                public int compare(EClassifier o1, EClassifier o2)
                {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for (EClassifier c : allEClassifiers)
            {
                if (c instanceof EClass)
                {
                    EClass eclass = (EClass) c;
                    // to be candidate an eclass have to have a common parent, to not be the selection
                    // and to not be abstract
                    if ((GenericTransformer.getAllSuperTypes(eclass).contains(containgType) || EcoreUtil.equals(eclass, containgType)) && !eclass.equals(selectionEObject.eClass())
                            && !eclass.isAbstract())
                    {
                        MenuItem item = new MenuItem(menu, SWT.NONE);
                        item.setText(c.getName());
                        item.addSelectionListener(new GenericSelectionListener(selectionEObject, eclass));
                        AdapterFactory adapterFactory = factories.get(eclass.getEPackage().getNsURI());
                        if (adapterFactory != null)
                        {
                            EObject tmpEobject = c.getEPackage().getEFactoryInstance().create(eclass);
                            IItemLabelProvider provider = (IItemLabelProvider) adapterFactory.adapt(tmpEobject, IItemLabelProvider.class);
                            item.setImage(ExtendedImageRegistry.INSTANCE.getImage(provider.getImage(tmpEobject)));
                        }
                    }
                }
            }
        }

        /**
         * Gets all the classifiers from one package and dependants.
         * 
         * @param pack the pack
         * 
         * @return the e classifiers
         */
        private List<EClassifier> getEClassifiers()
        {
            return new ArrayList<EClassifier>(eClassifiers);
        }

        private void addClassifiers(EPackage pack, Set<EClassifier> result)
        {
            for (EClassifier c : pack.getEClassifiers())
            {
                result.add(c);
            }
        }
    }

    /**
     * The listener interface for receiving genericSelection events. The class that is interested in processing a
     * genericSelection event implements this interface, and the object created with that class is registered with a
     * component using the component's <code>addGenericSelectionListener</code> method. When the genericSelection event
     * occurs, that object's appropriate method is invoked.
     * 
     * @see GenericSelectionEvent
     */
    private class GenericSelectionListener implements SelectionListener
    {

        private final EClass eclass;
        private final EObject elementToTransform;

        public GenericSelectionListener(EObject elementToTransform, EClass c)
        {
        	this.elementToTransform = elementToTransform;
            this.eclass = c;
        }

        public void widgetDefaultSelected(SelectionEvent e)
        {
        }

        public void widgetSelected(SelectionEvent e)
        {
            String message = String.format(
                    "You are trying to transform an element typed %s into %s.\nThis operation will copy all the common elements between the two eclasses.\nDo you want to continue ?",
                    GenericTransformAction.this.selectionEObject.eClass().getName(), eclass.getName());
            InformationDialog dialog = new InformationDialog(Display.getDefault().getActiveShell(), "Warning", message, ModelerPlugin.getDefault().getPreferenceStore(),
                    "ShowWarningForGenericTransformation", SWT.YES | SWT.NO, MessageDialog.INFORMATION, new String[] {IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL});
            int result = dialog.open();
            if (result == SWT.YES || result == Window.OK)
            {
                GenericTransformer transformer = new GenericTransformer(elementToTransform);
                MultiStatus messages = transformer.isTransformationPossible(eclass);
                if (messages != null && messages.getChildren().length == 0)
                {
                    transformer.transform(eclass);
                }
                else
                {
                    ErrorDialog errorDialog = new ErrorDialog(Display.getDefault().getActiveShell(), "Impossible to continue transformation.", "The transformation can not continue.\n"
                            + "Some objects referencing your selection could not be able to reference the result of the transformation.\n"
                            + "For UML and SysML, applied stereotypes could not be applicable on the result of the transformation.\n"
                            + "Before performing the transformation please delete or unapply the elements listed bellow.", messages, IStatus.WARNING);
                    errorDialog.open();
                }
            }
        }

    }

}
