/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter.generator.gmfmap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.mappings.MappingEntry;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * @author Nicolas
 * 
 * @param <T> 
 */
public abstract class MapGenerator<T> extends ObjectGenerator<T>
{
    /**
     * @param mappingEntry 
     * @param partConfiguration 
     */
    protected void setDomainMetaElement(MappingEntry mappingEntry, PartConfiguration partConfiguration)
    {
        EClass domainMetaElement = getEClass(partConfiguration);
        if (domainMetaElement != null)
        {
            mappingEntry.setDomainMetaElement(domainMetaElement);
        }
    }

    /**
     * @param ownerClass 
     * @param referencedClass 
     * @return EReference
     * 
     */
    public EReference getEReference(EClass ownerClass, EClass referencedClass)
    {
        // TODO : Ask user if multiple references are usable.
        if (referencedClass != null && ownerClass != null)
        {
            for (EReference ref : ownerClass.getEAllReferences())
            {
                if ((ref.getEReferenceType().equals(referencedClass) || ref.getEReferenceType().isSuperTypeOf(referencedClass)) && ref.isContainment())
                {
                    return ref;
                }
            }
        }
        return null;
    }

    /**
     * @param referencedClass 
     * @return EReference
     * 
     */
    public EReference getRootEReference(EClass referencedClass)
    {
        return getEReference(MapRegistry.getRootEClass(), referencedClass);
    }

    /**
     * @param PartConfiguration 
     * @return EClass
     * 
     */
    public EClass getEClass(PartConfiguration PartConfiguration)
    {
        ObjectConfiguration objectConfiguration = PartConfiguration.getObject();
        if (objectConfiguration instanceof ModelObjectConfiguration)
        {
            ModelObjectConfiguration modelObjectConfiguration = (ModelObjectConfiguration) objectConfiguration;
            return modelObjectConfiguration.getGenClass().getEcoreClass();
        }
        return null;
    }
}
