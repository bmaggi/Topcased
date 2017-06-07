/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Reference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.ReferenceImpl#isIsIndividualRepresentation <em>Is Individual Representation</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.ReferenceImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends DiagramElementImpl implements Reference
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #isIsIndividualRepresentation() <em>Is Individual Representation</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #isIsIndividualRepresentation()
     * @generated
     * @ordered
     */
    protected static final boolean IS_INDIVIDUAL_REPRESENTATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsIndividualRepresentation() <em>Is Individual Representation</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #isIsIndividualRepresentation()
     * @generated
     * @ordered
     */
    protected boolean isIndividualRepresentation = IS_INDIVIDUAL_REPRESENTATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getReferenced()
     * @generated
     * @ordered
     */
    protected DiagramElement referenced;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ReferenceImpl()
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
        return DiagramInterchangePackage.Literals.REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsIndividualRepresentation()
    {
        return isIndividualRepresentation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setIsIndividualRepresentation(boolean newIsIndividualRepresentation)
    {
        boolean oldIsIndividualRepresentation = isIndividualRepresentation;
        isIndividualRepresentation = newIsIndividualRepresentation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION, oldIsIndividualRepresentation, isIndividualRepresentation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramElement getReferenced()
    {
        if (referenced != null && ((EObject) referenced).eIsProxy())
        {
            InternalEObject oldReferenced = (InternalEObject) referenced;
            referenced = (DiagramElement) eResolveProxy(oldReferenced);
            if (referenced != oldReferenced)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramInterchangePackage.REFERENCE__REFERENCED, oldReferenced, referenced));
            }
        }
        return referenced;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramElement basicGetReferenced()
    {
        return referenced;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReferenced(DiagramElement newReferenced, NotificationChain msgs)
    {
        DiagramElement oldReferenced = referenced;
        referenced = newReferenced;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.REFERENCE__REFERENCED, oldReferenced, newReferenced);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setReferenced(DiagramElement newReferenced)
    {
        if (newReferenced != referenced)
        {
            NotificationChain msgs = null;
            if (referenced != null)
                msgs = ((InternalEObject) referenced).eInverseRemove(this, DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE, DiagramElement.class, msgs);
            if (newReferenced != null)
                msgs = ((InternalEObject) newReferenced).eInverseAdd(this, DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE, DiagramElement.class, msgs);
            msgs = basicSetReferenced(newReferenced, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.REFERENCE__REFERENCED, newReferenced, newReferenced));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.REFERENCE__REFERENCED:
                if (referenced != null)
                    msgs = ((InternalEObject) referenced).eInverseRemove(this, DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE, DiagramElement.class, msgs);
                return basicSetReferenced((DiagramElement) otherEnd, msgs);
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
            case DiagramInterchangePackage.REFERENCE__REFERENCED:
                return basicSetReferenced(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case DiagramInterchangePackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
                return isIsIndividualRepresentation();
            case DiagramInterchangePackage.REFERENCE__REFERENCED:
                if (resolve)
                    return getReferenced();
                return basicGetReferenced();
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
            case DiagramInterchangePackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
                setIsIndividualRepresentation((Boolean) newValue);
                return;
            case DiagramInterchangePackage.REFERENCE__REFERENCED:
                setReferenced((DiagramElement) newValue);
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
            case DiagramInterchangePackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
                setIsIndividualRepresentation(IS_INDIVIDUAL_REPRESENTATION_EDEFAULT);
                return;
            case DiagramInterchangePackage.REFERENCE__REFERENCED:
                setReferenced((DiagramElement) null);
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
            case DiagramInterchangePackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
                return isIndividualRepresentation != IS_INDIVIDUAL_REPRESENTATION_EDEFAULT;
            case DiagramInterchangePackage.REFERENCE__REFERENCED:
                return referenced != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (isIndividualRepresentation: "); //$NON-NLS-1$
        result.append(isIndividualRepresentation);
        result.append(')');
        return result.toString();
    }

} // ReferenceImpl
