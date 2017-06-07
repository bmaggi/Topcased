/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API
 ******************************************************************************/
package org.topcased.tabbedproperties.internal.utils;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * This class returns String labels taken from the properties of each model class. This switch supports four class from the model's inheritance hierarchy:
 * <ul>
 * <li><b>GenModel</b></li>
 * <li><b>GenPackage</b></li>
 * <li><b>GenClass</b></li>
 * <li><b>GenFeature</b></li>
 * </ul>
 * Other model classes will be added in future implementations
 * 
 * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch;
 * 
 * Creation 29 août 06
 * 
 * @author <a href="alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 */
public class GenModelLabelSwitch extends GenModelSwitch<String>
{
    /**
     * Return the model's name.
     * 
     * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch#caseGenModel(GenModel)
     */
    public String caseGenModel(GenModel object)
    {
        return object.getModelName();
    }

    /**
     * Returns the package's name
     * 
     * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch#caseGenPackage(GenPackage)
     */
    public String caseGenPackage(GenPackage object)
    {
        return object.getPackageName();
    }

    /**
     * Returns the interface's name
     * 
     * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch#caseGenClass(GenClass)
     */
    public String caseGenClass(GenClass object)
    {
        return object.getInterfaceName();
    }

    /**
     * Returns a String with the following information: <i>EcoreFeature</i> : <i>Container class</i> - <i>GenModel</i>
     * 
     * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch#caseGenFeature(GenFeature)
     */
    public String caseGenFeature(GenFeature object)
    {
        if (object.eContainer() != null)
        {
            String clazz = object.getGenClass().getInterfaceName();
            String result = object.getGenModel().getModelName();
            return object.getEcoreFeature().getName() + " : " + clazz + " - " + result;
        }
        return "";
    }

    /**
     * Returns the default string
     * 
     * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelSwitch#defaultCase(EObject)
     */
    public String defaultCase(EObject object)
    {
        String result = null;
        List<Adapter> adapters = object.eAdapters();
        for (Adapter adapter : adapters)
        {
            if (adapter instanceof IItemLabelProvider)
            {
                result = ((IItemLabelProvider) adapter).getText(object);
            }
        }
        return result;
    }
}
