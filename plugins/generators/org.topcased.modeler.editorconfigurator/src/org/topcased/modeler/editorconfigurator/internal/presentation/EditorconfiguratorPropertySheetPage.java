package org.topcased.modeler.editorconfigurator.internal.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.topcased.modeler.editorconfigurator.util.EditorconfiguratorAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;

/**
 * A property sheet page that provides a tabbed UI.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @author <!-- User name here -->
 * @generated
 */
public class EditorconfiguratorPropertySheetPage extends AbstractTabbedPropertySheetPage
{
    /**
     * create a new tabbed property sheet page.
     * 
     * @param tabbedPropertySheetPageContributor the editor contributor of the property sheet page.
     */
    public EditorconfiguratorPropertySheetPage(ITabbedPropertySheetPageContributor editor)
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
        factories.add(new EditorconfiguratorAdapterFactory());

        factories.addAll(super.getAdapterFactories());

        return factories;
    }
}
