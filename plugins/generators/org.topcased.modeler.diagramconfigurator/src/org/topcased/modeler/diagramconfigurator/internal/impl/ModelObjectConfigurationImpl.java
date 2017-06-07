/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelObjectConfigurationImpl.java,v 1.4 2007/04/18 12:21:14 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.diagramconfigurator.DiagramReference;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Object Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.ModelObjectConfigurationImpl#getGenClass <em>Gen Class</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.ModelObjectConfigurationImpl#getDiagrams <em>Diagrams</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelObjectConfigurationImpl extends ObjectConfigurationImpl implements ModelObjectConfiguration
{
    /**
     * The cached value of the '{@link #getGenClass() <em>Gen Class</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getGenClass()
     * @generated
     * @ordered
     */
    protected GenClass genClass;

    /**
     * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDiagrams()
     * @generated
     * @ordered
     */
    protected EList<DiagramReference> diagrams;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ModelObjectConfigurationImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramconfiguratorPackage.Literals.MODEL_OBJECT_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenClass getGenClass()
    {
        if (genClass != null && genClass.eIsProxy())
        {
            InternalEObject oldGenClass = (InternalEObject) genClass;
            genClass = (GenClass) eResolveProxy(oldGenClass);
            if (genClass != oldGenClass)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS, oldGenClass, genClass));
            }
        }
        return genClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenClass basicGetGenClass()
    {
        return genClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setGenClass(GenClass newGenClass)
    {
        GenClass oldGenClass = genClass;
        genClass = newGenClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS, oldGenClass, genClass));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<DiagramReference> getDiagrams()
    {
        if (diagrams == null)
        {
            diagrams = new EObjectContainmentEList<DiagramReference>(DiagramReference.class, this, DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS);
        }
        return diagrams;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                return ((InternalEList< ? >) getDiagrams()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                if (resolve)
                    return getGenClass();
                return basicGetGenClass();
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                return getDiagrams();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                setGenClass((GenClass) newValue);
                return;
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                getDiagrams().clear();
                getDiagrams().addAll((Collection< ? extends DiagramReference>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                setGenClass((GenClass) null);
                return;
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                getDiagrams().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__GEN_CLASS:
                return genClass != null;
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION__DIAGRAMS:
                return diagrams != null && !diagrams.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    // ---
    // ------
    // ---------
    // ------------
    // CODE CUSTOM
    // ------------
    // ---------
    // ------
    // ---

    /**
     * @see org.topcased.modeler.diagramconfigurator.impl.ObjectConfigurationImpl#getName()
     */
    public String getName()
    {
        if (getGenClass() != null && getGenClass().getName() != null)
        {
            return getGenClass().getName();
        }
        return "ModelObjectConfigurationName";
    }

} // ModelObjectConfigurationImpl
