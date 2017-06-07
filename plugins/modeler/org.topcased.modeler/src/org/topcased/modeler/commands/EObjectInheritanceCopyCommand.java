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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;

/**
 * The Class EObjectInheritanceCopyCommand. it takes an eobject in parameter and copy all the elements contained in the
 * source to the target and adds the target to the container of the source
 */
public class EObjectInheritanceCopyCommand extends CompoundCommand
{

    private final EObject sourceEObject;

    private final EObject targetEObject;

    private final EditingDomain editingDomain;

    private Collection<Object> alreadyManaged = new LinkedList<Object>();

    public EObjectInheritanceCopyCommand(EObject source, EClass target, EditingDomain domain)
    {
        super("Inheritance copy");
        this.sourceEObject = source;
        this.targetEObject = target.getEPackage().getEFactoryInstance().create(target);
        this.editingDomain = domain;
        if (sourceEObject == null || targetEObject == null || editingDomain == null)
        {
            throw new IllegalArgumentException("Please provide non null arguments");
        }
        init();
        if (sourceEObject.eContainingFeature().isMany())
        {
            append(AddCommand.create(editingDomain, sourceEObject.eContainer(), sourceEObject.eContainingFeature(), Arrays.asList(targetEObject)));
            append(RemoveCommand.create(editingDomain, sourceEObject.eContainer(), sourceEObject.eContainingFeature(), Arrays.asList(sourceEObject)));
        }
        else
        {
            append(new CustomSetCommand(editingDomain, sourceEObject.eContainer(), sourceEObject.eContainingFeature(), targetEObject, sourceEObject, sourceEObject.eContainingFeature()));
            append(DeleteCommand.create(editingDomain, sourceEObject));
        }
    }

    private void init()
    {
        modelCopy(sourceEObject, targetEObject);
        crossReference(sourceEObject, targetEObject);
    }

    /**
     * Model copy, copy the eobject source attributes to target's
     * 
     * @param mixedDomain the mixed domain
     * @param source the source
     * @param target the target
     */
    private void modelCopy(EObject source, EObject target)
    {
        // EClass eclass = getCommonParent(target.eClass(), source.eClass());
        EClass eclass = source.eClass();
        if (eclass != null)
        {
            EList<EStructuralFeature> eAllStructuralFeatures = eclass.getEAllStructuralFeatures();
            for (EStructuralFeature e : eAllStructuralFeatures)
            {
                if (contains(target.eClass(), e) && isCompatible(e.getEType(), target.eClass().getEStructuralFeature(e.getName()).getEType()))
                {
                    manageFeature(source, target, e);
                }
            }
        }
    }

    /**
     * Contains. check if the target eclass contains a estructuralfeature with the same name less rigorous can work for
     * many cases
     * 
     * @param target the target
     * @param e the e
     * 
     * @return true, if successful
     */
    private boolean contains(EClass target, EStructuralFeature e)
    {
        EList<EStructuralFeature> features = target.getEAllStructuralFeatures();
        for (EStructuralFeature f : features)
        {
            if (f.getName().equals(e.getName()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Manage feature for cross.
     * 
     * @param mixedDomain the mixed domain
     * @param theObjectWithCross the the object with cross
     * @param source the source
     * @param target the target
     * @param structuralFeature the structural feature
     */
    private void manageFeatureForCross(EObject theObjectWithCross, EObject source, EObject target, EStructuralFeature structuralFeature)
    {
        boolean compatible = isCompatible(structuralFeature.getEType(), target.eClass());

        if (compatible && structuralFeature.isChangeable() && !structuralFeature.isDerived())
        {
            if (structuralFeature.isMany())
            {
                append(AddCommand.create(editingDomain, theObjectWithCross, structuralFeature, Collections.singleton(target)));
                remove(theObjectWithCross, source, structuralFeature);
            }
            else
            {
                append(SetCommand.create(editingDomain, theObjectWithCross, structuralFeature, target));
            }
        }
        else if (!compatible)
        {
            if (structuralFeature.isMany())
            {
                remove(theObjectWithCross, source, structuralFeature);
            }
            else
            {
                append(SetCommand.create(editingDomain, theObjectWithCross, structuralFeature, null));
            }
        }

    }

    private void remove(EObject owner, Object source, EStructuralFeature structuralFeature)
    {
        if (!alreadyManaged.contains(source))
        {

            if (owner == null && structuralFeature == null)
            {
                append(RemoveCommand.create(editingDomain, source));
            }
            else
            {
                append(RemoveCommand.create(editingDomain, owner, structuralFeature, Collections.singleton(source)));
            }
            alreadyManaged.add(source);
        }
    }

    @Override
    public void undo()
    {
        super.undo();
    }

    /**
     * Cross reference. Manage eobjects referencing the source eobject
     * 
     * @param mixedDomain the mixed domain
     * @param source the source eobject
     * @param target the target eobject
     */
    private void crossReference(EObject source, EObject target)
    {
        Collection<EStructuralFeature.Setting> collection = getUsages(source);
        if (collection != null)
        {
            for (EStructuralFeature.Setting nonNavigableInverseReference : collection)
            {
                EStructuralFeature structuralFeature = nonNavigableInverseReference.getEStructuralFeature();
                if (!(nonNavigableInverseReference.getEObject() instanceof EMFSemanticModelBridge) && !(nonNavigableInverseReference.getEObject() instanceof Diagrams))
                {
                    manageFeatureForCross(nonNavigableInverseReference.getEObject(), source, target, structuralFeature);
                }
                else if (nonNavigableInverseReference.getEObject() instanceof Diagrams)
                {
                    Diagrams di = (Diagrams) nonNavigableInverseReference.getEObject();
                    remove(null, di, null);
                }
            }
        }
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
     * Checks if a type is compatible to another.
     * 
     * @param type the type
     * @param target the target
     * 
     * @return true, if is compatible
     */
    public static boolean isCompatible(EClassifier type, EClassifier target)
    {
        Collection<EClassifier> types = new LinkedList<EClassifier>();
        if (target instanceof EClass)
        {
            EClass eclass = (EClass) target;
            types.addAll(eclass.getEAllSuperTypes());
            types.add(EcorePackage.Literals.EOBJECT);
        }
        if (!types.contains(target))
        {
            types.add(target);
        }
        return types.contains(type);
    }

    /**
     * Manage a feature for the attribute's copy.
     * 
     * @param mixedDomain the mixed domain
     * @param source the source
     * @param target the target
     * @param e the e
     */
    @SuppressWarnings("unchecked")
    private void manageFeature(EObject source, EObject target, EStructuralFeature e)
    {
        EStructuralFeature targetFeature = getFeature(target, e.getName());

        if (e.getUpperBound() <= targetFeature.getUpperBound() && e.getLowerBound() >= targetFeature.getLowerBound())
        {
            if (e.isChangeable() && !e.isDerived())
            {
                Object value = source.eGet(e);
                if (e.isMany() && targetFeature.isMany())
                {
                    Collection<EObject> list = (Collection<EObject>) value;
                    if (list != null && !list.isEmpty())
                    {
                        Collection<EObject> newList = new LinkedList<EObject>();
                        newList.addAll(list);
                        if (e instanceof EReference && !((EReference) e).isContainment())
                        {
                            append(AddCommand.create(editingDomain, target, targetFeature, newList));
                        }
                        else if (e instanceof EReference && ((EReference) e).isContainment())
                        {
                            Collection<Object> toTreat = new LinkedList<Object>();
                            for (Object o : newList)
                            {
                                if (!alreadyManaged.contains(o))
                                {
                                    toTreat.add(o);
                                    alreadyManaged.add(o);
                                }
                            }
                            append(new CustomAddCommand(editingDomain, target, targetFeature, newList, source, e));
                        }
                    }
                }
                else if (!e.isMany() && !targetFeature.isMany())
                {
                    if (value != null)
                    {
                        if (!alreadyManaged.contains(value))
                        {
                            alreadyManaged.add(value);
                            append(new CustomSetCommand(editingDomain, target, targetFeature, value, source, e));
                        }
                    }
                }
            }
        }

    }

    @Override
    public boolean canExecute()
    {
        boolean result = super.canExecute();
        if (editingDomain != null && sourceEObject != null && sourceEObject.eResource() != null)
        {
            result &= !editingDomain.isReadOnly(sourceEObject.eResource());
        }
        return result;
    }

    /**
     * Gets a feature from a name
     * 
     * @param eobject the eobject
     * @param name the name
     * 
     * @return the feature
     */
    private EStructuralFeature getFeature(EObject eobject, String name)
    {
        return eobject.eClass().getEStructuralFeature(name);
    }

    /**
     * Gets the result eobject.
     * 
     * @return the result eobject
     */
    public EObject getResultEobject()
    {
        return targetEObject;
    }

    /**
     * The Class CustomSetCommand. permits to change a value from an eobject to eanother
     */
    private class CustomSetCommand extends SetCommand
    {
        private EObject oldObject = null;

        private EStructuralFeature oldFeature;

        public CustomSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value, EObject old, EStructuralFeature structuralFeature)
        {
            super(domain, owner, feature, value);
            oldObject = old;
            oldFeature = structuralFeature;
        }

        public CustomSetCommand(EditingDomain editingDomain, EObject theObjectWithCross, EStructuralFeature structuralFeature, EObject target)
        {
            super(editingDomain, theObjectWithCross, structuralFeature, target);
        }

        @Override
        public void doUndo()
        {
            super.doUndo();
            oldObject.eSet(oldFeature, value);
        }

    }

    /**
     * The Class CustomSetCommand. permits to change a value from an eobject to eanother
     */
    private class CustomAddCommand extends AddCommand
    {
        private EObject oldObject = null;

        private EStructuralFeature oldFeature;

        public CustomAddCommand(EditingDomain editingDomain, EObject target, EStructuralFeature targetFeature, Collection<EObject> newList, EObject source, EStructuralFeature e)
        {
            super(editingDomain, target, targetFeature, newList);
            oldObject = source;
            oldFeature = e;
        }

        @Override
        public void doUndo()
        {
            // this test permit to avoid modification from other command
            // if getOwner list is empty it will perform error we avoid it
            if (!getOwnerList().isEmpty())
            {
                super.doUndo();
            }
            Collection<Object> collec = (Collection) oldObject.eGet(oldFeature);
            for (Object o : collection)
            {
                if (!collec.contains(o))
                {
                    collec.add(o);
                }
            }
        }
    }
}
