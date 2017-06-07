/**
 * <copyright>
 * </copyright>
 *
 * $Id: SemanticModelBridgeImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Semantic Model Bridge</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.SemanticModelBridgeImpl#getPresentation <em>Presentation</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.SemanticModelBridgeImpl#getGraphElement <em>Graph Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SemanticModelBridgeImpl extends EModelElementImpl implements SemanticModelBridge
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getPresentation() <em>Presentation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPresentation()
     * @generated
     * @ordered
     */
    protected static final String PRESENTATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPresentation() <em>Presentation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPresentation()
     * @generated
     * @ordered
     */
    protected String presentation = PRESENTATION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SemanticModelBridgeImpl()
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
        return DiagramInterchangePackage.Literals.SEMANTIC_MODEL_BRIDGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getPresentation()
    {
        return presentation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPresentation(String newPresentation)
    {
        String oldPresentation = presentation;
        presentation = newPresentation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__PRESENTATION, oldPresentation, presentation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphElement getGraphElement()
    {
        if (eContainerFeatureID() != DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT)
            return null;
        return (GraphElement) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetGraphElement(GraphElement newGraphElement, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject) newGraphElement, DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setGraphElement(GraphElement newGraphElement)
    {
        if (newGraphElement != eInternalContainer() || (eContainerFeatureID() != DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT && newGraphElement != null))
        {
            if (EcoreUtil.isAncestor(this, (EObject) newGraphElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newGraphElement != null)
                msgs = ((InternalEObject) newGraphElement).eInverseAdd(this, DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL, GraphElement.class, msgs);
            msgs = basicSetGraphElement(newGraphElement, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT, newGraphElement, newGraphElement));
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetGraphElement((GraphElement) otherEnd, msgs);
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                return basicSetGraphElement(null, msgs);
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                return eInternalContainer().eInverseRemove(this, DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL, GraphElement.class, msgs);
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
                return getPresentation();
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                return getGraphElement();
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
                setPresentation((String) newValue);
                return;
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                setGraphElement((GraphElement) newValue);
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
                setPresentation(PRESENTATION_EDEFAULT);
                return;
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                setGraphElement((GraphElement) null);
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
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__PRESENTATION:
                return PRESENTATION_EDEFAULT == null ? presentation != null : !PRESENTATION_EDEFAULT.equals(presentation);
            case DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT:
                return getGraphElement() != null;
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
        result.append(" (presentation: "); //$NON-NLS-1$
        result.append(presentation);
        result.append(')');
        return result.toString();
    }

} // SemanticModelBridgeImpl
