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
package org.topcased.modeler.internal;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;

/**
 * @author tfaure
 *
 */
public class MoveDiagram
{

    private final URI createURI;

    private final IProgressMonitor monitor;

    public MoveDiagram(URI createURI, IProgressMonitor monitor)
    {
        this.createURI = createURI;
        this.monitor = monitor;
    }

    /**
     * Move the diagrams in a controlled resource
     * @return
     */
    public Diagnostic move()
    {
        ResourceSet set = new ResourceSetImpl();
        Set<Resource> resourcesToSave = new HashSet<Resource>();
        BasicDiagnostic rootDiag = new BasicDiagnostic("org.topcased.modeler", 0, "Clean controlled diagrams", new Object[] {null});
        try
        {
            monitor.beginTask("open diagram", 1);
            set.getResource(createURI, true);
            EcoreUtil.resolveAll(set);
            Collection<Diagrams> diagrams = new LinkedList<Diagrams>();
            for (Resource rTmp : set.getResources())
            {
                if (rTmp.getContents() != null && rTmp.getContents().size() > 0 && rTmp.getContents().get(0) instanceof Diagrams)
                {
                    diagrams.add((Diagrams) rTmp.getContents().get(0));
                }
            }
            if (!monitor.isCanceled())
            {
                resourcesToSave.addAll(moveDiagrams(diagrams, rootDiag));
            }
            monitor.beginTask("save", resourcesToSave.size());
            if (!monitor.isCanceled())
            {
                for (Resource rTmp : resourcesToSave)
                {
                    if (rTmp != null && !"pathmap".equals(rTmp.getURI().scheme()))
                    {
                        try
                        {
                            rTmp.save(Collections.EMPTY_MAP);
                        }
                        catch (IOException e)
                        {
                        	e.printStackTrace();
                            rootDiag.add(
                                    new BasicDiagnostic(Diagnostic.ERROR, "org.topcased.modeler", 0, e.getMessage(), new Object[] {null}));
                        }
                    }
                    monitor.worked(1);
                }
            }
        }
        catch (Exception e)
        {
        	e.printStackTrace();
            rootDiag.add(
                    new BasicDiagnostic(Diagnostic.WARNING, "org.topcased.modeler", 0, e.getMessage(), new Object[] {null}));
        }
        finally
        {
            monitor.beginTask("unload", set.getResources().size());
            for (Resource rTmp : set.getResources())
            {
                try
                {
                    rTmp.unload();
                }
                catch (Exception e)
                {
                }
                monitor.worked(1);
            }
        }
        return rootDiag;

    }

    /**
     * Move the discovered diagrams
     * @param diagrams, the list of diagrams to manage
     * @param rootDiag, the diagnostic
     */
    private Collection<Resource> moveDiagrams(Collection<Diagrams> diagrams, DiagnosticChain rootDiag)
    {
        Collection<Resource> result = new LinkedList<Resource>();
        if (diagrams == null || rootDiag == null)
        {
            throw new IllegalArgumentException("moveDiagrams : all the parameters are mandatory");
        }
        monitor.beginTask("move ...", diagrams.size());
        for (Diagrams dis : diagrams)
        {
            if (monitor.isCanceled())
            {
                break;
            }
            List<Diagram> list = new LinkedList<Diagram>();
            for (Iterator<EObject> i = dis.eAllContents(); i.hasNext();)
            {
                EObject next = i.next();
                if (next instanceof Diagram && next.eResource() == dis.eResource())
                {
                    Diagram di = (Diagram) next;
                    list.add(di);
                }
            }
            SubProgressMonitor sub = new SubProgressMonitor(monitor, 1);
            sub.beginTask("move ...", list.size());
            for (Diagram di : list)
            {
                sub.subTask(di.getName());
                // look for the element linked to the diagram
                if (di.getSemanticModel() instanceof EMFSemanticModelBridge)
                {
                    EMFSemanticModelBridge bridge = (EMFSemanticModelBridge) di.getSemanticModel();
                    if (bridge.getElement() != null)
                    {
                        String correspondingURI = getCorrespondingDi(bridge.getElement());
                        if (di.eResource() != null && !correspondingURI.equals(di.eResource().getURI().toString()))
                        {
                            result.addAll(movePhysical(di, bridge.getElement(), rootDiag));
                        }
                    }
                }
                sub.worked(1);
            }
            monitor.worked(1);
        }
        return result ;
    }

    /**
     * Move "physically the diagrams"
     * @param di, the diagram
     * @param eObject, the eobject of the diagram
     * @param rootDiag, the diagnostician
     */
    private Collection<Resource> movePhysical(Diagram di, EObject eObject, DiagnosticChain rootDiag)
    {
        Collection<Resource> result = new LinkedList<Resource>();
        if (di == null || eObject == null || rootDiag == null)
        {
            throw new IllegalArgumentException("move Physical : all the parameters are mandatory");
        }
        Diagrams dis = getCorrespondingDiagrams(eObject);
        if (dis == null)
        {
            String uri = null ;
            if (eObject.eResource() == null)
            {
                if (eObject.eIsProxy())
                {
                    uri =((InternalEObject) eObject).eProxyURI().toString();
                }
                else
                {
                    uri = " {no resource for this object}";
                }
            }
            else
            {
                uri = eObject.eResource().getURI().toString();
            }
            rootDiag.add(
                    new BasicDiagnostic(Diagnostic.WARNING, "org.topcased.modeler", 0, "no diagram found for resource : " + uri
                            + " the diagram is kept in resource  : " + di.eResource().getURI().toString(), new Object[] {eObject}));
        }
        else
        {
            String message = "diagram " + di.getName() + " (" + di.eResource().getURI().toString() + ")" + " is moved to " + dis.eResource().getURI().toString()  ;
            Diagrams container = null ;
            if (di.eContainer() instanceof Diagrams)
            {
                 container = (Diagrams) di.eContainer();
            }
            result.add(di.eResource());
//            Collection<Setting> usages = getUsages(di);
            dis.getDiagrams().add(di);
//            // fix cross references
//            for (Setting s : usages)
//            {
//                s.set(di);
//            }
            result.add(dis.eResource());
            if (container != null)
            {
                if (container.getDiagrams().isEmpty() && container.eContainer() instanceof Diagrams)
                {
                    Diagrams containerOfContaienr = (Diagrams) container.eContainer() ;
                    containerOfContaienr.getSubdiagrams().remove(container);
                }
            }
            rootDiag.add(
                    new BasicDiagnostic(Diagnostic.INFO, "org.topcased.modeler", 0, message, new Object[] {eObject}));
        }
        return result ;
    }
    
    /**
     * Gets the usages.
     * 
     * @param source the source
     * 
     * @return the usages or null if there is no usages
     */
    public static Collection<EStructuralFeature.Setting> getUsages(EObject source)
    {
        Collection<EStructuralFeature.Setting> collection = null;
        ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
        if (crossReferenceAdapter != null)
        {
            collection = crossReferenceAdapter.getNonNavigableInverseReferences(source);
        }
        else
        {
            collection = EcoreUtil.UsageCrossReferencer.find(source, source.eResource().getResourceSet());
        }
        return collection;
    }

    /**
     * Returns the corresponding diagrams of the current eobject
     * @param eObject
     * @return
     */
    private Diagrams getCorrespondingDiagrams(EObject eObject)
    {
        if (eObject != null)
        {
            URI correspondingDiURI = URI.createURI(getCorrespondingDi(eObject));
            Resource eResource = eObject.eResource();
            if (eResource != null)
            {
                Resource r = eResource.getResourceSet().getResource(correspondingDiURI, true);
                if (r.getContents().size() != 0 && r.getContents().get(0) instanceof Diagrams)
                {
                    return getDiagrams(r, eObject);
                }
            }
        }
        return null;
    }
    
    /**
     * Get the diagrams corresponding to the element. if it doesn't exist it adds it at root
     * @param commonDiResource
     * @param activity
     * @return
     */
    private Diagrams getDiagrams(Resource commonDiResource, EObject eobject)
    {
        Diagrams result = null ;
        for (Iterator<EObject> i = commonDiResource.getAllContents() ; i.hasNext() ;)
        {
            EObject next = i.next();
            if (next instanceof Diagrams)
            {
                Diagrams di = (Diagrams) next;
                if (di.eResource() == commonDiResource && eobject.equals(di.getModel()))
                {
                    result = di ;
                }
            }
        }
        if (result == null)
        {
            if (commonDiResource.getContents().get(0) instanceof Diagrams)
            {
                Diagrams di = (Diagrams) commonDiResource.getContents().get(0);
                result = DiagramsFactory.eINSTANCE.createDiagrams();
                result.setModel(eobject);
                di.getSubdiagrams().add(result);
            }
        }
        return result ;
        
    }

    /**
     * @param semanticModel
     * @return
     */
    private String getCorrespondingDi(EObject semanticModel)
    {
        if (semanticModel != null && semanticModel.eResource() != null)
        {
            return semanticModel.eResource().getURI().toString() + "di";
        }
        return "" ;
    }
}
