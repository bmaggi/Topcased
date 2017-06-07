package org.topcased.tabbedproperties.providers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This class provides a service to get advanced label provider (qualified name) for Topcased editors
 * @author tristan.faure@atosorigin.com
 *
 */
public class AdvancedLabelProvider
{
    private static final String EXTENSIONS_QUALIFIED_NAME_ID = "org.topcased.tabbedproperties.advancespropertiesqualifiedname";
    
    private static final IConfigurationElement[] EXTENSIONS_QUALIFIED_NAME = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSIONS_QUALIFIED_NAME_ID);
    
    /**
     * @return the label provider corresponding to the given modeler class
     */
    public static LabelProviderFactory getAdvancedLabelProviderFactory(Class<?> modelerClass)
    {
        LabelProviderFactory provider = null;
        for (IConfigurationElement conf : EXTENSIONS_QUALIFIED_NAME)
        {
            String clazz = conf.getAttribute("editorClass");
            try
            {
                Class<?> clazzClass = Platform.getBundle(conf.getContributor().getName()).loadClass(clazz);
                if (modelerClass.equals(clazzClass))
                {
                    provider = (LabelProviderFactory) conf.createExecutableExtension("labelProvider");
                    break;
                }
            }
            catch (InvalidRegistryObjectException e)
            {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (CoreException e)
            {
                e.printStackTrace();
            }
        }
        return provider;
    }
    
    /**
     * @return the label provider corresponding to the current editor
     */
    public static LabelProviderFactory getAdvancedLabelProviderFactory4CurrentEditor()
    {
        IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench != null)
        {
            IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
            if (activeWorkbenchWindow != null)
            {
                IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
                if (activePage != null && activePage.getActiveEditor() != null)
                {
                    return getAdvancedLabelProviderFactory(activePage.getActiveEditor().getClass());
                }
            }
        }
        return null ;
    }
}
