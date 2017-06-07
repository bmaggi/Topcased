package org.topcased.modeler.export.html;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;

/**
 * Provides a singleton for access to services (GenerationService in particular)
 * 
 */
/**
 * @author ahaugomm
 * 
 */
public class ServicesManager
{
    public static ServicesManager INSTANCE = new ServicesManager();

    /**
     * Extension point to register specific generation services
     */
    private static final String EXTENSION_POINT_ID = "org.topcased.modeler.export.html.specific";

    /**
     * Attribute of the extension point for diagram file extension
     */
    private static final String FILE_EXTENSION_ATTTRIBUTE = "fileExtension";

    /**
     * Attribute of the extension point for specific generation service class
     */
    private static final String SPECIFIC_GENERATION_SERVICE_ATTTRIBUTE = "specificGenerationService";

    private IGenerationService generationService;

    /**
     * Get the Generation Service
     * 
     * @return a IGeneration service :
     *         <ul>
     *         <li>either the default implementation (org.topcased.modeler.export.html.GenerationService)</li>
     *         <li>or new implementations provided in plugins that have register to extension point with iFile extension
     *         </li>
     *         </ul>
     */
    public IGenerationService getGenerationService()
    {
        return generationService;
    }

    /**
     * Initialization of the Generation Service from :
     * <ul>
     * <li>either the default implementation (org.topcased.modeler.export.html.GenerationService)</li>
     * <li>or new implementations provided in plugins that have register to extension point with iFile extension</li>
     * </ul>
     * 
     * Exceptions can be thrown when the generationService cannot be initialized
     * 
     * @param iFile The diagram from which the HTML export generation is launched.
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvalidRegistryObjectException
     * @throws ClassNotFoundException
     */
    public void initGenerationService(IFile iFile) throws InstantiationException, IllegalAccessException, InvalidRegistryObjectException, ClassNotFoundException
    {
        final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
        for (IConfigurationElement config : configElements)
        {
            String extensionAttribute = config.getAttribute(FILE_EXTENSION_ATTTRIBUTE);
            String clazz = config.getAttribute(SPECIFIC_GENERATION_SERVICE_ATTTRIBUTE);
            if (iFile.getFileExtension().equals(extensionAttribute))
            {
                try
                {
                    Class< ? > genServiceClass = ClassLoader.getSystemClassLoader().loadClass(clazz);
                    generationService = (IGenerationService) genServiceClass.newInstance();
                    generationService.setDiagramFile(iFile);
                    return;
                }
                catch (InvalidRegistryObjectException e)
                {
                }
                catch (ClassNotFoundException e)
                {
                    Class< ? > genServiceClass;
                    genServiceClass = Platform.getBundle(config.getContributor().getName()).loadClass(clazz);
                    generationService = (IGenerationService) genServiceClass.newInstance();
                    generationService.setDiagramFile(iFile);
                    return;
                }
                catch (InstantiationException e)
                {
                }
                catch (IllegalAccessException e)
                {
                }
            }
        }
        // Default implementation provided inside this plugin
        generationService = GenerationService.class.newInstance();

    }
}
