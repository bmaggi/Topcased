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

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.ecore.EObject;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.evaluator.EvaluatorException;
import org.topcased.modeler.evaluator.IEvaluator;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Class that stores the evaluators registered with the <i>evaluators</i>
 * extension point.
 * 
 * Creation 20 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public final class EvaluatorsManager extends AbstractExtensionManager
{

    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    private static final String EVALUATORS_EXTENSION_POINT = "evaluators";

    /** the shared instance */
    private static EvaluatorsManager manager;

    /**
     * A set that will only ever contain EvaluatorDescriptors.
     */
    private SortedSet<EvaluatorDescriptor> evaluators = new TreeSet<EvaluatorDescriptor>(new Comparator<EvaluatorDescriptor>()
    {
        public int compare(EvaluatorDescriptor o1, EvaluatorDescriptor o2)
        {
            String id1 = o1.getId();
            String id2 = o2.getId();

            return id1.compareTo(id2);
        }
    });

    /**
     * Basic constructor
     */
    private EvaluatorsManager()
    {
        super(ModelerPlugin.getId() + "." + EVALUATORS_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the evaluators manager
     */
    public static EvaluatorsManager getInstance()
    {
        if (manager == null)
        {
            manager = new EvaluatorsManager();
        }

        return manager;
    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param id the searched evaluator id
     * @return the evaluator or <code>null</code> if not found
     */
    public EvaluatorDescriptor find(String id)
    {
        Iterator<EvaluatorDescriptor> itr = evaluators.iterator();
        while (itr.hasNext())
        {
            EvaluatorDescriptor desc = itr.next();
            if (id.equals(desc.getId()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Evaluate an EObject along several kind of evaluation (EMF, OCL...)
     * 
     * @param eObject the EObject to validate
     * @param rule a String representing the rule to check
     * @param language the language in which the rule is expressed
     * 
     * @return true if the evaluation passed, false otherwise
     * @throws EvaluatorException the constraint cannot be interpreted by the
     *             engine
     */
    public boolean evaluate(EObject eObject, String rule, String language) throws EvaluatorException
    {
        EvaluatorDescriptor[] descriptors = EvaluatorsManager.getInstance().getEvaluators();

        for (int i = 0; i < descriptors.length; i++)
        {
            if (language.equals(descriptors[i].getLanguage()))
            {
                try
                {
                    IEvaluator evaluator = descriptors[i].getEvaluator();
                    return evaluator.eval(eObject, rule);
                }
                catch (CoreException ce)
                {
                    // Cannot load class, just log and continue
                    ModelerPlugin.log(ce);
                }
            }
        }
        return false;
    }

    /**
     * Get an enumeration of evaluator descriptors.
     * 
     * @return The registered evaluators
     */
    public EvaluatorDescriptor[] getEvaluators()
    {
        return (EvaluatorDescriptor[]) evaluators.toArray(new EvaluatorDescriptor[evaluators.size()]);
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#addExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void addExtension(IExtension extension)
    {

        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int i = 0; i < elements.length; i++)
        {
            IConfigurationElement confElt = elements[i];
            try
            {
                if (EvaluatorDescriptor.TAG_EVALUATOR.equals(confElt.getName()))
                {
                    EvaluatorDescriptor descriptor = new EvaluatorDescriptor(confElt);
                    evaluators.add(descriptor);
                }
            }
            catch (CoreException ce)
            {
                ModelerPlugin.log(ce);
            }
        }
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#removeExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void removeExtension(IExtension extension)
    {

        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int i = 0; i < elements.length; i++)
        {
            IConfigurationElement confElt = elements[i];
            if (EvaluatorDescriptor.TAG_EVALUATOR.equals(confElt.getName()))
            {
                String id = confElt.getAttribute(EvaluatorDescriptor.ATT_ID);
                EvaluatorDescriptor descriptor = find(id);
                evaluators.remove(descriptor);
            }
        }
    }

}
