/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.topcased.modeler.IAnnotationConstants;

/**
 * This Helper class is used to handle the uuid of a model object
 * 
 * Created 27 May 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class UuidHelper
{

    /**
     * The Constructor
     */
    public UuidHelper()
    {
        // does nothing
    }

    /**
     * Assign an uuid to the EModelElement.
     * 
     * @param elt the EModelElement
     */
    public void initUUID(EModelElement elt)
    {
        initUUID(elt, String.valueOf(new Date().getTime()));
    }

    /**
     * Set the uuid to the EModelElement. The uuid must be unique.
     * 
     * @param elt the EModelElement
     * @param uuid the String of the uuid
     */
    public void initUUID(EModelElement elt, String uuid)
    {
        if (elt.getEAnnotation(IAnnotationConstants.UUID_SOURCE) == null)
        {
            // the EAnnotation is not present, we have to create it
            EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
            EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE.create(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
            entry.setTypedKey(IAnnotationConstants.UUID_KEY);
            entry.setTypedValue(uuid);
            eAnnotation.getDetails().add(entry);
            eAnnotation.setSource(IAnnotationConstants.UUID_SOURCE);
            eAnnotation.setEModelElement(elt);
            elt.getEAnnotations().add(eAnnotation);
        }
        else
        {
            // the source EAnnotation already exists.
            EAnnotation eAnnotation = elt.getEAnnotation(IAnnotationConstants.UUID_SOURCE);
            if (!eAnnotation.getDetails().containsKey(IAnnotationConstants.UUID_KEY))
            {
                EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) EcoreFactory.eINSTANCE.create(EcorePackage.eINSTANCE.getEStringToStringMapEntry());
                entry.setTypedKey(IAnnotationConstants.UUID_KEY);
                entry.setTypedValue(uuid);
                eAnnotation.getDetails().add(entry);
            }

        }
    }

    /**
     * Returns the UUID of a EModelElement
     * 
     * @param elt the EModelElement
     * @return the uuid or null if no uuid is present
     */
    public String getUUID(EModelElement elt)
    {
        EAnnotation eAnnotation = elt.getEAnnotation(IAnnotationConstants.UUID_SOURCE);
        if (eAnnotation != null)
        {
            EMap<String, String> details = eAnnotation.getDetails();
            for (Iterator<Map.Entry<String, String>> i = details.iterator(); i.hasNext();)
            {
                EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) i.next();
                if (IAnnotationConstants.UUID_KEY.equals(entry.getTypedKey()))
                {
                    return entry.getTypedValue();
                }
            }
        }
        return null;
    }

}
