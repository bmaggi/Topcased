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
package org.topcased.tabbedproperties.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.topcased.facilities.dialogs.ChooseDialog;
import org.topcased.tabbedproperties.utils.TypeCacheAdapter;

/**
 * has the same behavior as PropertyDescriptor except for method createPropertyEditor it provides an editor with a
 * button opening a choose dialog
 * 
 * @author tfaure
 * 
 */
public class TopcasedPropertyDescriptor extends PropertyDescriptor
{

    private static final String EXTENSIONS_CUSTOM_PROPERTY_EDITOR_ID = "org.topcased.tabbedproperties.customadvancedproperty";

    private static final IConfigurationElement[] EXTENSIONS_CUSTOM_PROPERTY_EDITOR = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSIONS_CUSTOM_PROPERTY_EDITOR_ID);

    public TopcasedPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor)
    {
        super(object, itemPropertyDescriptor);
    }

    /**
     * Gets the property editor provider to custom property view
     * 
     * @return the property editor provider
     */
    protected IPropertyEditorProvider getPropertyEditorProvider()
    {
        IPropertyEditorProvider provider = null;
        for (IConfigurationElement conf : EXTENSIONS_CUSTOM_PROPERTY_EDITOR)
        {
            try
            {
                String featureId = conf.getAttribute("featureId");
                Class< ? > eclass = Platform.getBundle(conf.getContributor().getName()).loadClass(conf.getAttribute("eclassId"));
                Object genericFeature = itemPropertyDescriptor.getFeature(object);
                if (genericFeature instanceof EStructuralFeature && object instanceof EObject)
                {
                    EObject eobject = (EObject) object;
                    EStructuralFeature objectFeature = (EStructuralFeature) genericFeature;
                    if (eclass.isAssignableFrom(eobject.getClass()) && objectFeature.getName().equals(featureId))
                    {
                        provider = (IPropertyEditorProvider) conf.createExecutableExtension("editorProvider");
                        break;
                    }
                }
            }
            catch (CoreException e)
            {
                e.printStackTrace();
            }
            catch (InvalidRegistryObjectException e)
            {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return provider;
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite)
    {
        if (!itemPropertyDescriptor.canSetProperty(object))
        {
            return null;
        }
        CellEditor result = null;
        final Object genericFeature = itemPropertyDescriptor.getFeature(object);

        // custom advanced property
        final IPropertyEditorProvider editorProvider = getPropertyEditorProvider();
        if (editorProvider != null)
        {
            result = editorProvider.getPropertyEditor(composite, getEditLabelProvider(), itemPropertyDescriptor, object, super.createPropertyEditor(composite));
        }
        // if the feature is a ereference and if it is not many else we apply default behavior
        if (result == null && genericFeature instanceof EReference)
        {
            EReference eReference = (EReference) genericFeature;
            if (!eReference.isMany() && eReference.isChangeable() && !eReference.isDerived())
            {
                final ILabelProvider editLabelProvider = getEditLabelProvider();
                result = new ExtendedDialogCellEditor(composite, editLabelProvider)
                {
                    @Override
                    protected Object openDialogBox(Control cellEditorWindow)
                    {
                        // we get the possible values from the property descriptor
                        List<Object> result = getChoicesOfValue(genericFeature);
                        ChooseDialog dialog = new ChooseDialog(cellEditorWindow.getShell(), result.toArray(), false);
                        dialog.setLabelProvider(editLabelProvider);
                        LabelProviderFactory advancedLabelProviderFactory = AdvancedLabelProvider.getAdvancedLabelProviderFactory4CurrentEditor();
                        if (advancedLabelProviderFactory != null)
                        {
                            dialog.setAdvancedLabelProvider(advancedLabelProviderFactory.createAdapterFactory());
                        }
                        Object toReturn = null;
                        if (dialog.open() == ChooseDialog.OK)
                        {
                            Object[] resultDialog = dialog.getResult();
                            if (resultDialog != null && resultDialog.length > 0)
                            {
                                toReturn = resultDialog[0];
                                if (toReturn instanceof String && ((String) toReturn).length() == 0)
                                {
                                    toReturn = itemPropertyDescriptor.getPropertyValue(null);
                                }
                            }
                        }
                        else
                        {
                            toReturn = itemPropertyDescriptor.getPropertyValue(object);
                        }
                        return toReturn;
                    }
                };
            }
        }
        if (result == null)
        {
            result = super.createPropertyEditor(composite);
        }
        return result;
    }
    
    /**
     * Gets the choices of value.
     * 
     * @param genericFeature
     * 
     * @return the choices of value
     */
    protected List<Object> getChoicesOfValue(final Object genericFeature)
    {
        LinkedList<Object> result = new LinkedList<Object>();
        result.add("");
        if (object instanceof EObject)
        {
            EReference ref = (EReference) genericFeature;
            EObject eobject = (EObject) object;
            result.addAll(TypeCacheAdapter.getExistingTypeCacheAdapter(eobject).getReachableObjectsOfType(eobject, ref.getEType()));
        }
        else
        {
            result.addAll(itemPropertyDescriptor.getChoiceOfValues(object));
        }
        result.remove(null);
        // if an class wants to override mechanism
        // TODO make an extension point ?
        filterValues(result);
        return result;
    }
    
    /**
     * Modify the specified list to filter values
     * @param list
     */
    protected void filterValues(List<Object> list)
    {
        // basically no filter
    }
}
