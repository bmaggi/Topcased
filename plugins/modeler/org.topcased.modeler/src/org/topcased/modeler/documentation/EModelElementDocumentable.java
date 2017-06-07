/*******************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tristan FAURE - ATOS ORIGIN
 *******************************************************************************/
package org.topcased.modeler.documentation;

import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.topcased.modeler.IAnnotationConstants;

public class EModelElementDocumentable implements IDocumentable
{

    public String getDocumentation(EObject eobject)
    {
        if (eobject instanceof EModelElement)
        {
            StringBuilder buffer = new StringBuilder();
            EModelElement emodelElement = (EModelElement) eobject;
            EAnnotation annotation = emodelElement.getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
            if (annotation != null)
            {
                int i = 0 ;
                for (String key : annotation.getDetails().keySet())
                {
                    if (key.equalsIgnoreCase(IAnnotationConstants.DOCUMENTATION_KEY))
                    {
                        buffer.append(annotation.getDetails().get(key));
                    }
                    if (i != 0)
                    {
                        buffer.append("\n");
                        i++;                        
                    }
                }
            }
            return buffer.toString();
        }
        return null;
    }

    public Command setDocumentation(EditingDomain domain, EObject eobject, String documentation)
    {
        CompoundCommand result = new CompoundCommand();
        if (eobject instanceof EModelElement && documentation != null && documentation.length() != 0) {
            EModelElement modelElement = (EModelElement) eobject ;
            EAnnotation annotation = modelElement.getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
            if (annotation != null)
            {
                result.append(RemoveCommand.create(domain, Collections.singleton(annotation)));
            }
            annotation = EcoreFactory.eINSTANCE.createEAnnotation();
            annotation.setSource(IAnnotationConstants.DOCUMENTATION_SOURCE);
            result.append(AddCommand.create(domain, modelElement, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, Collections.singleton(annotation)));
            annotation.getDetails().put(IAnnotationConstants.DOCUMENTATION_KEY, documentation);         
        }
        return result;
    }

    public boolean canManage(EObject eobject)
    {
        return eobject instanceof EModelElement;
    }

}
