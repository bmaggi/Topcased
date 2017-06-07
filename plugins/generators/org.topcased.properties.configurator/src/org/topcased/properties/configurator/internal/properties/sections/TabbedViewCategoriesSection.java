package org.topcased.properties.configurator.internal.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.TabbedView;
import org.topcased.properties.configurator.provider.PropertiesConfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.sections.AbstractListPropertySection;

/**
 * A section which displays the multi features.<br>
 * The section features a table with two buttons letting the user to<br>
 * add or remove items from the selected object.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TabbedViewCategoriesSection extends AbstractListPropertySection
{

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "Categories:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return PropertiesConfiguratorPackage.eINSTANCE.getTabbedView_Categories();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractListPropertySection#getListValues()
     * @generated
     */
    protected Object getListValues()
    {
        return ((TabbedView) getEObject()).getCategories();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractListPropertySection#getLabelProvider()
     * @generated
     */
    protected IBaseLabelProvider getLabelProvider()
    {
        if (getFeature() instanceof EReference)
        {
            List f = new ArrayList();
            f.add(new PropertiesConfiguratorItemProviderAdapterFactory());
            f.addAll(AbstractTabbedPropertySheetPage.getPrincipalAdapterFactories());
            return new TabbedPropertiesLabelProvider(new ComposedAdapterFactory(f));
        }
        return null;
    }
}