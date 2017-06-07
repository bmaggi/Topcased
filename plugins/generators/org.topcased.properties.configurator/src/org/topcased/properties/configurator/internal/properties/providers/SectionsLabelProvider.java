package org.topcased.properties.configurator.internal.properties.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.topcased.properties.configurator.provider.PropertiesConfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.AbstractSectionLabelProvider;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SectionsLabelProvider extends AbstractSectionLabelProvider
{
    /**
     * @generated
     */
    private ILabelProvider labelProvider;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.providers.AbstractSectionLabelProvider#getAdapterFactoryLabelProvider()
     * @generated
     */
    protected ILabelProvider getAdapterFactoryLabelProvider()
    {
        if (labelProvider == null)
        {
            List f = new ArrayList();
            f.add(new PropertiesConfiguratorItemProviderAdapterFactory());
            f.addAll(AbstractTabbedPropertySheetPage.getPrincipalAdapterFactories());
            labelProvider = new TabbedPropertiesLabelProvider(new ComposedAdapterFactory(f));
        }
        return labelProvider;
    }

}
