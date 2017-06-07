package org.topcased.modeler.diagramconfigurator.internal.properties.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.topcased.modeler.diagramconfigurator.provider.DiagramconfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.AbstractSectionLabelProvider;

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
            f.add(new DiagramconfiguratorItemProviderAdapterFactory());
            f.addAll(AbstractTabbedPropertySheetPage.getPrincipalAdapterFactories());
            labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(f));
        }
        return labelProvider;
    }

}
