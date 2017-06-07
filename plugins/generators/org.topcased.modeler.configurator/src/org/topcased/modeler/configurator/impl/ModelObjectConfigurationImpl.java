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
package org.topcased.modeler.configurator.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.DiagramReference;
import org.topcased.modeler.configurator.ModelObjectConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Object Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.ModelObjectConfigurationImpl#getGenClass <em>Gen Class</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.ModelObjectConfigurationImpl#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelObjectConfigurationImpl extends ObjectConfigurationImpl implements ModelObjectConfiguration
{
    /**
     * The cached value of the '{@link #getGenClass() <em>Gen Class</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGenClass()
     * @generated
     * @ordered
     */
    protected GenClass genClass = null;

    /**
     * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiagrams()
     * @generated
     * @ordered
     */
    protected EList diagrams = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModelObjectConfigurationImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass()
    {
        return ConfiguratorPackage.eINSTANCE.getModelObjectConfiguration();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenClass getGenClass()
    {
        if (genClass != null && genClass.eIsProxy())
        {
            GenClass oldGenClass = genClass;
            genClass = (GenClass)eResolveProxy((InternalEObject)genClass);
            if (genClass != oldGenClass)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS, oldGenClass, genClass));
            }
        }
        return genClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenClass basicGetGenClass()
    {
        return genClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGenClass(GenClass newGenClass)
    {
        GenClass oldGenClass = genClass;
        genClass = newGenClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS, oldGenClass, genClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getDiagrams()
    {
        if (diagrams == null)
        {
            diagrams = new EObjectContainmentEList(DiagramReference.class, this, ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS);
        }
        return diagrams;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getName()
    {
        if (getGenClass() != null && getGenClass().getName() != null)
        {
            return getGenClass().getName();
        }
        return "ModelObjectConfigurationName";
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
    {
        if (featureID >= 0)
        {
            switch (eDerivedStructuralFeatureID(featureID, baseClass))
            {
                case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                    return ((InternalEList)getDiagrams()).basicRemove(otherEnd, msgs);
                default:
                    return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
            }
        }
        return eBasicSetContainer(null, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                if (resolve) return getGenClass();
                return basicGetGenClass();
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                return getDiagrams();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                setGenClass((GenClass)newValue);
                return;
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                getDiagrams().clear();
                getDiagrams().addAll((Collection)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                setGenClass((GenClass)null);
                return;
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                getDiagrams().clear();
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                return genClass != null;
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                return diagrams != null && !diagrams.isEmpty();
        }
        return eDynamicIsSet(eFeature);
    }

} //ModelObjectConfigurationImpl
