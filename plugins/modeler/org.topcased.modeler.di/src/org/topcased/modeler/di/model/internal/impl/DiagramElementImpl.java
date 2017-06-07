/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramElementImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.Reference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Element</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramElementImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramElementImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramElementImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramElementImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DiagramElementImpl extends EModelElementImpl implements DiagramElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected static final boolean VISIBLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected boolean visible = VISIBLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProperty()
     * @generated
     * @ordered
     */
    protected EList<Property> property;

    /**
     * The cached value of the '{@link #getReference() <em>Reference</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReference()
     * @generated
     * @ordered
     */
    protected EList<Reference> reference;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramElementImpl()
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
        return DiagramInterchangePackage.Literals.DIAGRAM_ELEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean isVisibleGen()
    {
        return visible;
    }

    /**
     * <!-- begin-user-doc --> The diagram element is visible if the property visible is <code>true</code> and if its
     * parent is visible. <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.di.model.DiagramElement#isVisible()
     * @generated NOT
     */
    public boolean isVisible()
    {
        return isVisibleGen() && (getContainer() == null || getContainer().isVisible());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setVisible(boolean newVisible)
    {
        boolean oldVisible = visible;
        visible = newVisible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE, oldVisible, visible));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<Property> getProperty()
    {
        if (property == null)
        {
            property = new EObjectContainmentEList<Property>(Property.class, this, DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY);
        }
        return property;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphElement getContainer()
    {
        if (eContainerFeatureID() != DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER)
            return null;
        return (GraphElement) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContainer(GraphElement newContainer, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject) newContainer, DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setContainer(GraphElement newContainer)
    {
        if (newContainer != eInternalContainer() || (eContainerFeatureID() != DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER && newContainer != null))
        {
            if (EcoreUtil.isAncestor(this, (EObject) newContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContainer != null)
                msgs = ((InternalEObject) newContainer).eInverseAdd(this, DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED, GraphElement.class, msgs);
            msgs = basicSetContainer(newContainer, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER, newContainer, newContainer));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<Reference> getReference()
    {
        if (reference == null)
        {
            reference = new EObjectWithInverseResolvingEList<Reference>(Reference.class, this, DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE, DiagramInterchangePackage.REFERENCE__REFERENCED);
        }
        return reference;
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
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContainer((GraphElement) otherEnd, msgs);
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                return ((InternalEList<InternalEObject>) (InternalEList< ? >) getReference()).basicAdd(otherEnd, msgs);
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
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY:
                return ((InternalEList< ? >) getProperty()).basicRemove(otherEnd, msgs);
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                return basicSetContainer(null, msgs);
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                return ((InternalEList< ? >) getReference()).basicRemove(otherEnd, msgs);
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
        switch (eContainerFeatureID())
        {
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                return eInternalContainer().eInverseRemove(this, DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED, GraphElement.class, msgs);
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
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE:
                return isVisible();
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY:
                return getProperty();
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                return getContainer();
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                return getReference();
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
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE:
                setVisible((Boolean) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY:
                getProperty().clear();
                getProperty().addAll((Collection< ? extends Property>) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                setContainer((GraphElement) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                getReference().clear();
                getReference().addAll((Collection< ? extends Reference>) newValue);
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
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE:
                setVisible(VISIBLE_EDEFAULT);
                return;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY:
                getProperty().clear();
                return;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                setContainer((GraphElement) null);
                return;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                getReference().clear();
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
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE:
                return visible != VISIBLE_EDEFAULT;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY:
                return property != null && !property.isEmpty();
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER:
                return getContainer() != null;
            case DiagramInterchangePackage.DIAGRAM_ELEMENT__REFERENCE:
                return reference != null && !reference.isEmpty();
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
        result.append(" (visible: "); //$NON-NLS-1$
        result.append(visible);
        result.append(')');
        return result.toString();
    }

} // DiagramElementImpl
