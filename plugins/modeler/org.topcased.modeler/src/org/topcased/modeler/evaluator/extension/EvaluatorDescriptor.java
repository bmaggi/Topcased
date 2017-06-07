/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies), - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.evaluator.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.topcased.modeler.evaluator.IEvaluator;

/**
 * Class that describes an evaluator
 * 
 * Creation 20 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EvaluatorDescriptor
{

    // Constants

    public static final String TAG_EVALUATOR = "evaluator";

    public static final String ATT_ID = "id";

    public static final String ATT_LANGUAGE = "language";

    public static final String ATT_CLASS = "class";

    public static final String TAG_DESCRIPTION = "description";

    // Values
    private String id;

    private String language;

    private String description;

    private IConfigurationElement configElement;

    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Evaluator
     * @throws CoreException if the xml fragment is not valid
     */
    EvaluatorDescriptor(IConfigurationElement element) throws CoreException
    {
        super();
        configElement = element;

        load();
    }

    private void load() throws CoreException
    {
        id = configElement.getAttribute(ATT_ID);
        language = configElement.getAttribute(ATT_LANGUAGE);
        String clazz = configElement.getAttribute(ATT_CLASS);

        // Sanity check.
        if (id == null || language == null || clazz == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespaceIdentifier(), IStatus.OK,
                    "Invalid extension (missing id, language or class name): " + id, null));
        }

        IConfigurationElement[] desc = configElement.getChildren(TAG_DESCRIPTION);
        if (desc.length > 0)
        {
            description = desc[0].getValue();
        }
    }

    /**
     * Get the evaluator associated with this extension
     * 
     * @return the evaluator or <code>null</code> if the
     * @throws CoreException
     */
    public IEvaluator getEvaluator() throws CoreException
    {
        Object evaluator = configElement.createExecutableExtension(ATT_CLASS);
        if (!(evaluator instanceof IEvaluator))
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespaceIdentifier(), IStatus.OK,
                    "Invalid class name for extension : " + getId(), null));
        }

        return (IEvaluator) evaluator;
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLanguage()
    {
        return language;
    }
}
