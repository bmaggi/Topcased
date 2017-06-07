package org.topcased.modeler.diagramconfigurator.internal.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelItemProviderAdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.topcased.modeler.diagramconfigurator.provider.DiagramconfiguratorItemProviderAdapterFactory;
import org.topcased.modeler.editorconfigurator.provider.EditorconfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;

/**
 * A property sheet page that provides a tabbed UI.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author <!-- User name here -->
 * @generated
 */
public class DiagramconfiguratorPropertySheetPage extends AbstractTabbedPropertySheetPage
{
    /**
     * create a new tabbed property sheet page.
     * 
     * @param tabbedPropertySheetPageContributor the editor contributor of the property sheet page.
     */
    public DiagramconfiguratorPropertySheetPage(ITabbedPropertySheetPageContributor editor)
    {
        super(editor);
    }

    /**
     * @see org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage#getAdapterFactories()
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected List getAdapterFactories()
    {
        List factories = new ArrayList();
        factories.add(new DiagramconfiguratorItemProviderAdapterFactory());
        factories.add(new EditorconfiguratorItemProviderAdapterFactory());
        factories.addAll(super.getAdapterFactories());

        return factories;
    }
}
