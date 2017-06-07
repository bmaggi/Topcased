/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsImpl.java,v 1.3 2007/04/12 08:32:12 jako Exp $
 */
package org.topcased.modeler.diagrams.model.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagrams</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl#getActiveDiagram <em>Active Diagram</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl#getSubdiagrams <em>Subdiagrams</em>}</li>
 *   <li>{@link org.topcased.modeler.diagrams.model.internal.impl.DiagramsImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramsImpl extends EObjectImpl implements Diagrams
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "";

    /**
     * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getModel()
     * @generated
     * @ordered
     */
    protected EObject model;

    /**
     * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDiagrams()
     * @generated
     * @ordered
     */
    protected EList<Diagram> diagrams;

    /**
     * The cached value of the '{@link #getActiveDiagram() <em>Active Diagram</em>}' reference.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getActiveDiagram()
     * @generated
     * @ordered
     */
    protected Diagram activeDiagram;

    /**
     * The cached value of the '{@link #getSubdiagrams() <em>Subdiagrams</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSubdiagrams()
     * @generated
     * @ordered
     */
    protected EList<Diagrams> subdiagrams;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramsImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramsPackage.Literals.DIAGRAMS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EObject getModel()
    {
        if (model != null && model.eIsProxy())
        {
            InternalEObject oldModel = (InternalEObject)model;
            model = eResolveProxy(oldModel);
            if (model != oldModel)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramsPackage.DIAGRAMS__MODEL, oldModel, model));
            }
        }
        return model;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EObject basicGetModel()
    {
        return model;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setModel(EObject newModel)
    {
        EObject oldModel = model;
        model = newModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramsPackage.DIAGRAMS__MODEL, oldModel, model));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<Diagram> getDiagrams()
    {
        if (diagrams == null)
        {
            diagrams = new EObjectContainmentEList<Diagram>(Diagram.class, this, DiagramsPackage.DIAGRAMS__DIAGRAMS);
        }
        return diagrams;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagram getActiveDiagram()
    {
        if (activeDiagram != null && ((EObject)activeDiagram).eIsProxy())
        {
            InternalEObject oldActiveDiagram = (InternalEObject)activeDiagram;
            activeDiagram = (Diagram)eResolveProxy(oldActiveDiagram);
            if (activeDiagram != oldActiveDiagram)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM, oldActiveDiagram, activeDiagram));
            }
        }
        return activeDiagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagram basicGetActiveDiagram()
    {
        return activeDiagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setActiveDiagram(Diagram newActiveDiagram)
    {
        Diagram oldActiveDiagram = activeDiagram;
        activeDiagram = newActiveDiagram;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM, oldActiveDiagram, activeDiagram));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<Diagrams> getSubdiagrams()
    {
        if (subdiagrams == null)
        {
            subdiagrams = new EObjectContainmentWithInverseEList.Resolving<Diagrams>(Diagrams.class, this, DiagramsPackage.DIAGRAMS__SUBDIAGRAMS, DiagramsPackage.DIAGRAMS__PARENT);
        }
        return subdiagrams;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagrams getParent()
    {
        if (eContainerFeatureID != DiagramsPackage.DIAGRAMS__PARENT) return null;
        return (Diagrams)eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagrams basicGetParent()
    {
        if (eContainerFeatureID != DiagramsPackage.DIAGRAMS__PARENT) return null;
        return (Diagrams)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParent(Diagrams newParent, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject)newParent, DiagramsPackage.DIAGRAMS__PARENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setParent(Diagrams newParent)
    {
        if (newParent != eInternalContainer() || (eContainerFeatureID != DiagramsPackage.DIAGRAMS__PARENT && newParent != null))
        {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject)newParent).eInverseAdd(this, DiagramsPackage.DIAGRAMS__SUBDIAGRAMS, Diagrams.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramsPackage.DIAGRAMS__PARENT, newParent, newParent));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case DiagramsPackage.DIAGRAMS__SUBDIAGRAMS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubdiagrams()).basicAdd(otherEnd, msgs);
            case DiagramsPackage.DIAGRAMS__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((Diagrams)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case DiagramsPackage.DIAGRAMS__DIAGRAMS:
                return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
            case DiagramsPackage.DIAGRAMS__SUBDIAGRAMS:
                return ((InternalEList<?>)getSubdiagrams()).basicRemove(otherEnd, msgs);
            case DiagramsPackage.DIAGRAMS__PARENT:
                return basicSetParent(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
    {
        switch (eContainerFeatureID)
        {
            case DiagramsPackage.DIAGRAMS__PARENT:
                return eInternalContainer().eInverseRemove(this, DiagramsPackage.DIAGRAMS__SUBDIAGRAMS, Diagrams.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramsPackage.DIAGRAMS__MODEL:
                if (resolve) return getModel();
                return basicGetModel();
            case DiagramsPackage.DIAGRAMS__DIAGRAMS:
                return getDiagrams();
            case DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM:
                if (resolve) return getActiveDiagram();
                return basicGetActiveDiagram();
            case DiagramsPackage.DIAGRAMS__SUBDIAGRAMS:
                return getSubdiagrams();
            case DiagramsPackage.DIAGRAMS__PARENT:
                if (resolve) return getParent();
                return basicGetParent();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramsPackage.DIAGRAMS__MODEL:
                setModel((EObject)newValue);
                return;
            case DiagramsPackage.DIAGRAMS__DIAGRAMS:
                getDiagrams().clear();
                getDiagrams().addAll((Collection<? extends Diagram>)newValue);
                return;
            case DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM:
                setActiveDiagram((Diagram)newValue);
                return;
            case DiagramsPackage.DIAGRAMS__SUBDIAGRAMS:
                getSubdiagrams().clear();
                getSubdiagrams().addAll((Collection<? extends Diagrams>)newValue);
                return;
            case DiagramsPackage.DIAGRAMS__PARENT:
                setParent((Diagrams)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramsPackage.DIAGRAMS__MODEL:
                setModel((EObject)null);
                return;
            case DiagramsPackage.DIAGRAMS__DIAGRAMS:
                getDiagrams().clear();
                return;
            case DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM:
                setActiveDiagram((Diagram)null);
                return;
            case DiagramsPackage.DIAGRAMS__SUBDIAGRAMS:
                getSubdiagrams().clear();
                return;
            case DiagramsPackage.DIAGRAMS__PARENT:
                setParent((Diagrams)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramsPackage.DIAGRAMS__MODEL:
                return model != null;
            case DiagramsPackage.DIAGRAMS__DIAGRAMS:
                return diagrams != null && !diagrams.isEmpty();
            case DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM:
                return activeDiagram != null;
            case DiagramsPackage.DIAGRAMS__SUBDIAGRAMS:
                return subdiagrams != null && !subdiagrams.isEmpty();
            case DiagramsPackage.DIAGRAMS__PARENT:
                return basicGetParent() != null;
        }
        return super.eIsSet(featureID);
    }

} // DiagramsImpl
