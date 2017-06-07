/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) vincent.hemery@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/

package org.topcased.modeler.extensions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Class SynchronizedModelDiagramRulesManager.
 * 
 * Provides the rules for testing whether an object's representation is synchronized with the model or not. These rules
 * are provided by the org.topcased.modeler.SynchronizedModelDiagramRule extension point.
 * 
 */
public final class SynchronizedModelDiagramRulesManager extends AbstractExtensionManager
{
    
    public static final String SYNCHRONIZED_MODEL_DIAGRAM_RULE_MARKER = "org.topcased.modeler.synchronizedmodeldiagramrule.problem";

    public static final String URI_MARKER_ATTRIBUTE = "uri";
    
    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    /** The Constant CONTAINER_RULES_EXTENSION_POINT. */
    private static final String CONTAINER_RULES_EXTENSION_POINT = "synchronizedModelDiagramRule";

    /** The Constant CREATE_RULE_FOR_GRAPHIC_TYPE. */
    private static final String CREATE_RULE_FOR_GRAPHIC_TYPE = "graphicType";

    /** The Constant CREATE_RULE_FOR_MODEL_TYPE. */
    private static final String CREATE_RULE_FOR_MODEL_TYPE = "modelInterface";

    /** The Constant CREATE_RULE_FROM_CLASS. */
    private static final String CREATE_RULE_FROM_CLASS = "synchronizationRule";

    /** The Constant INTERFACE_USED_FOR_GRAPHIC_TYPE_ERROR for error message. */
    private static final String INTERFACE_USED_FOR_GRAPHIC_TYPE_ERROR = "Attribute " + CREATE_RULE_FOR_GRAPHIC_TYPE + " of extension " + CONTAINER_RULES_EXTENSION_POINT
            + " should not be an interface : %s used.";

    /** The Constant INTERFACE_NOT_USED_FOR_MODEL_TYPE_ERROR for error message. */
    private static final String INTERFACE_NOT_USED_FOR_MODEL_TYPE_ERROR = "Attribute " + CREATE_RULE_FOR_MODEL_TYPE + " of extension " + CONTAINER_RULES_EXTENSION_POINT
            + " should be an interface : %s used.";

    /** The Constant INVALID_CLASS_ERROR for error message. */
    private static final String INVALID_CLASS_ERROR = "Invalid definition of extension " + CONTAINER_RULES_EXTENSION_POINT + " : " + CREATE_RULE_FROM_CLASS + "'s value %s is invalid.";

    /** the shared instance. */
    private static SynchronizedModelDiagramRulesManager manager;

    /** The specific rules. */
    private static Map<String, IConfigurationElement> specificRules = new HashMap<String, IConfigurationElement>();

    /**
     * Basic constructor.
     */
    private SynchronizedModelDiagramRulesManager()
    {
        super(ModelerPlugin.getId() + "." + CONTAINER_RULES_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the diagrams manager
     */
    public static SynchronizedModelDiagramRulesManager getInstance()
    {
        if (manager == null)
        {
            manager = new SynchronizedModelDiagramRulesManager();
        }

        return manager;
    }

    /**
     * Gets the rule tester for an element.
     * 
     * @param pObject the model object
     * @param pEditPart the graphical edit part
     * 
     * @return the rule tester for object
     */
    public SynchronizedModelDiagramRule getRuleTesterForElement(EObject pObject, GraphicalEditPart pEditPart)
    {
        if (pObject == null || pEditPart == null)
        {
            return null;
        }
        Class< ? > lEditPartClass = pEditPart.getClass();
        String lEditPartTypeToApplyRule = "";
        // get the more specific type in hierarchy for which a rule applies.
        while (GraphicalEditPart.class.isAssignableFrom(lEditPartClass) && "".equals(lEditPartTypeToApplyRule))
        {
            if (specificRules.containsKey(lEditPartClass.getCanonicalName()))
            {
                lEditPartTypeToApplyRule = lEditPartClass.getCanonicalName();
            }
            else
            {
                // take parent's rule
                lEditPartClass = lEditPartClass.getSuperclass();
            }
        }

        if (!"".equals(lEditPartTypeToApplyRule))
        {
            IConfigurationElement lConfig = specificRules.get(lEditPartTypeToApplyRule);
            if (checkConfigGraphicClass(lEditPartTypeToApplyRule, pEditPart) && checkConfigModelInterface(lConfig, pObject))
            {
                return createTester(lConfig, lEditPartTypeToApplyRule);
            }
        }
        return null;
    }

    /**
     * Check that the config has a correct edit part class.
     * 
     * @param pEditPartType the edit part type from the configuration
     * @param pEditPart the edit part object
     * 
     * @return true, if successful
     */
    private static boolean checkConfigGraphicClass(String pEditPartType, GraphicalEditPart pEditPart)
    {
        try
        {
            Class< ? > lEditPartClass = Class.forName(pEditPartType, false, pEditPart.getClass().getClassLoader());
            if (lEditPartClass.isInterface())
            {
                String lMsg = String.format(INTERFACE_USED_FOR_GRAPHIC_TYPE_ERROR, pEditPartType);
                ModelerPlugin.log(lMsg, IStatus.ERROR);
            }
            else
            {
                return true;
            }
        }
        catch (ClassNotFoundException lCnfe)
        {
            ModelerPlugin.log(lCnfe);
        }

        return false;
    }

    /**
     * Check that the config has a correct model interface for the model object.
     * 
     * @param pConfig the configuration element to check
     * @param pModelObject the model object
     * 
     * @return true, if successful
     */
    private static boolean checkConfigModelInterface(IConfigurationElement pConfig, EObject pModelObject)
    {
        if (pConfig != null)
        {
            String lRequiredInterfaceName = pConfig.getAttribute(CREATE_RULE_FOR_MODEL_TYPE);
            try
            {
                Class< ? > lRequiredInterface = Class.forName(lRequiredInterfaceName, false, pModelObject.getClass().getClassLoader());
                if (!lRequiredInterface.isInterface())
                {
                    String lMsg = String.format(INTERFACE_NOT_USED_FOR_MODEL_TYPE_ERROR, lRequiredInterfaceName);
                    ModelerPlugin.log(lMsg, IStatus.ERROR);
                }
                if (lRequiredInterface.isAssignableFrom(pModelObject.getClass()))
                {
                    return true;
                }
            }
            catch (ClassNotFoundException lCnfe)
            {
                ModelerPlugin.log(lCnfe);
            }
        }
        return false;
    }

    /**
     * Creates the tester.
     * 
     * @param pConfig the configuration element
     * @param pEditPartType the edit part type
     * 
     * @return the synchronized model diagram rule
     */
    private static SynchronizedModelDiagramRule createTester(IConfigurationElement pConfig, String pEditPartType)
    {
        try
        {
            Object lTester = pConfig.createExecutableExtension(CREATE_RULE_FROM_CLASS);
            if (lTester instanceof SynchronizedModelDiagramRule)
            {
                return (SynchronizedModelDiagramRule) lTester;
            }
            else
            {
                String lMsg = String.format(INVALID_CLASS_ERROR, pConfig.getAttribute(CREATE_RULE_FROM_CLASS));
                throw new CoreException(new Status(IStatus.ERROR, pConfig.getNamespaceIdentifier(), IStatus.OK, lMsg, null));
            }
        }
        catch (CoreException lCe)
        {
            ModelerPlugin.log(lCe);
        }
        return null;
    }

    /**
     * Adds the extension.
     * 
     * @param extension the extension
     * 
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#addExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void addExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for(IConfigurationElement element: elements)
        {
            String type = element.getAttribute(CREATE_RULE_FOR_GRAPHIC_TYPE);
            // the class may not be loadable from here, so I have no way to check that the type really is not an
            // interface now.
            specificRules.put(type, element);
        }
    }

    /**
     * Removes the extension.
     * 
     * @param extension the extension
     * 
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#removeExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void removeExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement element : elements)
        {
            specificRules.remove(element.getAttribute(CREATE_RULE_FOR_MODEL_TYPE));
        }
    }

}
