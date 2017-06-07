package org.topcased.modeler.internal.actions;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.dialogs.ReadOnlyResourcesDialog;
import org.topcased.modeler.editor.INavigationListener;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This action refresh the current diagram.
 * 
 * Created : 15 Feb. 2010 Updated : 16 Feb. 2010
 * 
 * @author jbelmude
 */
public class RefreshAction extends WorkbenchPartAction implements INavigationListener
{
    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    @SuppressWarnings("deprecation")
    public RefreshAction(IWorkbenchPart part)
    {
        super(part);
        setActionDefinitionId("org.topcased.modeler.refresh");
        part.getSite().getKeyBindingService().registerAction(this);
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#dispose()
     */
    public void dispose()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        modeler.getNavigationManager().removeNavigationListener(this);
        super.dispose();
    }

    /**
     * @see org.topcased.modeler.editor.INavigationListener#diagramChanged(org.topcased.modeler.di.model.Diagram)
     */
    public void diagramChanged(Diagram newDiagram)
    {
        refresh();
    }

    /**
     * Always return true
     * 
     * @return <code>true</code>
     */
    protected boolean calculateEnabled()
    {
        return true;
    }

    /**
     * Initializes the action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.REFRESH);
        setText("Refresh the current diagram");
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        if (modeler.getEditingDomain() instanceof TopcasedAdapterFactoryEditingDomain)
        {
            // compute new read only resources and inform of the difference
            AdapterFactoryEditingDomain domain = (AdapterFactoryEditingDomain) modeler.getEditingDomain();
            EditingDomainHelper helper = EditingDomainHelper.getInstance(domain);
            Map<Boolean, List<String>> diff = helper.refreshReadOnlyResources(true);
            ReadOnlyResourcesDialog dialog = new ReadOnlyResourcesDialog(ModelerPlugin.getActiveWorkbenchShell(), diff);
            dialog.open();
        }
        modeler.refreshOutline();
        modeler.refreshActiveDiagram();
    }
}
