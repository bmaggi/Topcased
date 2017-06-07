/**
 * <copyright>
 * </copyright>
 *
 * $Id: EMFSemanticModelBridgeImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>EMF Semantic Model Bridge</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EMFSemanticModelBridgeImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFSemanticModelBridgeImpl extends SemanticModelBridgeImpl implements EMFSemanticModelBridge
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getElement()
     * @generated
     * @ordered
     */
    protected EObject element;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EMFSemanticModelBridgeImpl()
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
        return DiagramInterchangePackage.Literals.EMF_SEMANTIC_MODEL_BRIDGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EObject getElement()
    {
        if (element != null && element.eIsProxy())
        {
            InternalEObject oldElement = (InternalEObject) element;
            element = eResolveProxy(oldElement);
            if (element != oldElement)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT, oldElement, element));
            }
        }
        return element;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EObject basicGetElement()
    {
        return element;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setElement(EObject newElement)
    {
        EObject oldElement = element;
        element = newElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT, oldElement, element));
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
            case DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT:
                if (resolve)
                    return getElement();
                return basicGetElement();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT:
                setElement((EObject) newValue);
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
            case DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT:
                setElement((EObject) null);
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
            case DiagramInterchangePackage.EMF_SEMANTIC_MODEL_BRIDGE__ELEMENT:
                return element != null;
        }
        return super.eIsSet(featureID);
    }

} // EMFSemanticModelBridgeImpl
