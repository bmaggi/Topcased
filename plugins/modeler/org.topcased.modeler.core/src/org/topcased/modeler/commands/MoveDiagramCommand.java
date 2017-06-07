/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Class MoveDiagramComman move the diagram linked to a source element to the diagrams linked to a target element
 */
public class MoveDiagramCommand extends CompoundCommand
{
    
    /**
     * Move the corresponding diagrams of objectDrag to the corresponding diagrams of target
     * @param objectDrag
     * @param target
     * @param domain
     */
    public MoveDiagramCommand(EObject objectDrag, EObject target, EditingDomain domain)
    {
        URI sourceDIURI = getDiURI(objectDrag);
        URI targetDIRUI = getDiURI(target);
        Resource diTargetResource = objectDrag.eResource().getResourceSet().getResource(targetDIRUI, true);
        if (diTargetResource != null && !diTargetResource.getContents().isEmpty())
        {
            Diagrams diTargetDiagrams = getTargetDiagrams(target, diTargetResource);
            List<Diagrams> diagrams = getDiagrams(objectDrag,objectDrag.eResource().getResourceSet().getResource(sourceDIURI, true));
            if (diagrams != null && diagrams.size() > 0 && diTargetDiagrams != null)
            {
                for (Diagrams d : diagrams)
                {
                    manageDiagram(domain, diTargetDiagrams, d);
                    manageContainers(domain, d);
                }
            }
        }
        else
        {
            ModelerPlugin.log(String.format("Diagram corresponding to %s can't be moved, there is no diagrams in the target resource %s", objectDrag.toString(),targetDIRUI.toString()), IStatus.ERROR);
        }
        
    }

    /**
     * get the diagrams in the target resource to contain the source diagrams 
     * @param target
     * @param eResource
     * @return
     */
    protected Diagrams getTargetDiagrams (EObject target, Resource eResource)
    {
        if (eResource != null && !eResource.getContents().isEmpty() && eResource.getContents().get(0) instanceof Diagrams)
        {
            Diagrams root = (Diagrams) eResource.getContents().get(0);
            Diagrams nearest = DiagramsUtils.findNearestContainerDiagrams(root, target);
            if (nearest != null)
            {
                return nearest ;
            }
            else
            {
                for (TreeIterator<EObject> i = eResource.getAllContents() ; i.hasNext() ;)
                {
                    EObject next = i.next();
                    if (next instanceof Diagram)
                    {
                        i.prune();
                    }
                    else if (next instanceof Diagrams)
                    {
                        if (next == null || EcoreUtil.isAncestor(((Diagrams) next).getModel(), target))
                        {
                            if (EcoreUtil.isAncestor(nearest, next))
                            {
                                nearest = (Diagrams) next ;
                            }
                        }
                    }
                }
                return nearest ;
            }
        }
        return null ;
    }
    
    
    /**
     * If the diagrams moved is alone we delete the container
     * @param domain
     * @param element
     */
    protected void manageContainers(EditingDomain domain, Diagrams element)
    {
        if (element.eContainer() instanceof Diagrams)
        {
            if (((Diagrams)element.eContainer()).getSubdiagrams().size() == 1)
            {
                if (((Diagrams)element.eContainer()).eContainer() != null)
                {
                    append(DeleteCommand.create(domain, element));
                }
            }
        }
        
    }

    /**
     * get the diagrams corresponding to the element and its hierarchy
     * @param search
     * @param eResource
     * @return
     */
    protected List<Diagrams> getDiagrams(EObject search, Resource eResource)
    {
        List<Diagrams> dis = new ArrayList<Diagrams>();
        for (TreeIterator<EObject> i = eResource.getAllContents() ; i.hasNext() ;)
        {
            EObject next = i.next();
            if (next instanceof Diagrams)   
            {
                Diagrams di = (Diagrams) next;
                // if a child of the element moved has a diagrams
                if (di.getModel() == search || (EcoreUtil.isAncestor(search, di.getModel()) && !containsAncestor(dis,di)))
                {
                    dis.add(di);
                    for (Iterator<Diagrams> i2 = dis.iterator() ; i2.hasNext() ;)
                    {
                        Diagrams d2 = i2.next() ;
                        if (EcoreUtil.isAncestor(di, d2) && di != d2)
                        {
                            i2.remove();
                        }
                    }
                }
            }
            else if (next instanceof Diagram)
            {
                i.prune();
            }
        }
        return dis ;
    }


    /**
     * Check if in the dis list there is already an ancestor of di
     * @param dis
     * @param di
     * @return
     */
    protected boolean containsAncestor(List<Diagrams> dis, Diagrams di)
    {
        for (Diagrams d : dis)
        {
            if (EcoreUtil.isAncestor(d, di))
            {
                return true ;
            }
        }
        return false;
    }

    /**
     * Append the command to move the diagram
     * @param domain
     * @param diTargetDiagrams
     * @param source
     */
    protected void manageDiagram(EditingDomain domain, Diagrams diTargetDiagrams, Diagrams source)
    {
        if (source.eContainer() instanceof Diagrams)
        {
            append(RemoveCommand.create(domain, source.eContainer(), DiagramsPackage.Literals.DIAGRAMS__SUBDIAGRAMS, source));
            append(AddCommand.create(domain, diTargetDiagrams, DiagramsPackage.Literals.DIAGRAMS__SUBDIAGRAMS, source, 0));
            
        }
        else if (source.eContainer() instanceof Resource)
        {
            append(DeleteCommand.create(domain, source));
            append(AddCommand.create(domain, diTargetDiagrams, DiagramsPackage.Literals.DIAGRAMS__SUBDIAGRAMS, source, 0));
        }
            
    }

    /**
     * get the uri of di file
     * @param eobject
     * @return
     */
    protected URI getDiURI(EObject eobject)
    {
        return URI.createURI(eobject.eResource().getURI().toString() + "di");
    }
    
}
