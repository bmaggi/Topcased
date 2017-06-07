/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphElementImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.DiagramLink;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Graph Element</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl#getPosition <em>Position</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl#getAnchorage <em>Anchorage</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl#getSemanticModel <em>Semantic Model</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl#getContained <em>Contained</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphElementImpl#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class GraphElementImpl extends DiagramElementImpl implements GraphElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPosition()
     * @generated
     * @ordered
     */
    protected static final Point POSITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getPosition()
     * @generated
     * @ordered
     */
    protected Point position = POSITION_EDEFAULT;

    /**
     * The cached value of the '{@link #getAnchorage() <em>Anchorage</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAnchorage()
     * @generated
     * @ordered
     */
    protected EList<GraphConnector> anchorage;

    /**
     * The cached value of the '{@link #getSemanticModel() <em>Semantic Model</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSemanticModel()
     * @generated
     * @ordered
     */
    protected SemanticModelBridge semanticModel;

    /**
     * The cached value of the '{@link #getContained() <em>Contained</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getContained()
     * @generated
     * @ordered
     */
    protected EList<DiagramElement> contained;

    /**
     * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLink()
     * @generated
     * @ordered
     */
    protected EList<DiagramLink> link;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected GraphElementImpl()
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
        return DiagramInterchangePackage.Literals.GRAPH_ELEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Point getPosition()
    {
        return position;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPosition(Point newPosition)
    {
        Point oldPosition = position;
        position = newPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.GRAPH_ELEMENT__POSITION, oldPosition, position));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<GraphConnector> getAnchorage()
    {
        if (anchorage == null)
        {
            anchorage = new EObjectContainmentWithInverseEList<GraphConnector>(GraphConnector.class, this, DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE,
                    DiagramInterchangePackage.GRAPH_CONNECTOR__GRAPH_ELEMENT);
        }
        return anchorage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public SemanticModelBridge getSemanticModel()
    {
        return semanticModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSemanticModel(SemanticModelBridge newSemanticModel, NotificationChain msgs)
    {
        SemanticModelBridge oldSemanticModel = semanticModel;
        semanticModel = newSemanticModel;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL, oldSemanticModel, newSemanticModel);
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
    public void setSemanticModel(SemanticModelBridge newSemanticModel)
    {
        if (newSemanticModel != semanticModel)
        {
            NotificationChain msgs = null;
            if (semanticModel != null)
                msgs = ((InternalEObject) semanticModel).eInverseRemove(this, DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT, SemanticModelBridge.class, msgs);
            if (newSemanticModel != null)
                msgs = ((InternalEObject) newSemanticModel).eInverseAdd(this, DiagramInterchangePackage.SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT, SemanticModelBridge.class, msgs);
            msgs = basicSetSemanticModel(newSemanticModel, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL, newSemanticModel, newSemanticModel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<DiagramElement> getContained()
    {
        if (contained == null)
        {
            contained = new EObjectContainmentWithInverseEList<DiagramElement>(DiagramElement.class, this, DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED,
                    DiagramInterchangePackage.DIAGRAM_ELEMENT__CONTAINER);
        }
        return contained;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<DiagramLink> getLink()
    {
        if (link == null)
        {
            link = new EObjectContainmentWithInverseEList<DiagramLink>(DiagramLink.class, this, DiagramInterchangePackage.GRAPH_ELEMENT__LINK, DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT);
        }
        return link;
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
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                return ((InternalEList<InternalEObject>) (InternalEList< ? >) getAnchorage()).basicAdd(otherEnd, msgs);
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                if (semanticModel != null)
                    msgs = ((InternalEObject) semanticModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL, null, msgs);
                return basicSetSemanticModel((SemanticModelBridge) otherEnd, msgs);
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                return ((InternalEList<InternalEObject>) (InternalEList< ? >) getContained()).basicAdd(otherEnd, msgs);
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                return ((InternalEList<InternalEObject>) (InternalEList< ? >) getLink()).basicAdd(otherEnd, msgs);
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
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                return ((InternalEList< ? >) getAnchorage()).basicRemove(otherEnd, msgs);
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                return basicSetSemanticModel(null, msgs);
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                return ((InternalEList< ? >) getContained()).basicRemove(otherEnd, msgs);
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                return ((InternalEList< ? >) getLink()).basicRemove(otherEnd, msgs);
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
            case DiagramInterchangePackage.GRAPH_ELEMENT__POSITION:
                return getPosition();
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                return getAnchorage();
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                return getSemanticModel();
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                return getContained();
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                return getLink();
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
            case DiagramInterchangePackage.GRAPH_ELEMENT__POSITION:
                setPosition((Point) newValue);
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                getAnchorage().clear();
                getAnchorage().addAll((Collection< ? extends GraphConnector>) newValue);
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                setSemanticModel((SemanticModelBridge) newValue);
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                getContained().clear();
                getContained().addAll((Collection< ? extends DiagramElement>) newValue);
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                getLink().clear();
                getLink().addAll((Collection< ? extends DiagramLink>) newValue);
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
            case DiagramInterchangePackage.GRAPH_ELEMENT__POSITION:
                setPosition(POSITION_EDEFAULT);
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                getAnchorage().clear();
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                setSemanticModel((SemanticModelBridge) null);
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                getContained().clear();
                return;
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                getLink().clear();
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
            case DiagramInterchangePackage.GRAPH_ELEMENT__POSITION:
                return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
            case DiagramInterchangePackage.GRAPH_ELEMENT__ANCHORAGE:
                return anchorage != null && !anchorage.isEmpty();
            case DiagramInterchangePackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
                return semanticModel != null;
            case DiagramInterchangePackage.GRAPH_ELEMENT__CONTAINED:
                return contained != null && !contained.isEmpty();
            case DiagramInterchangePackage.GRAPH_ELEMENT__LINK:
                return link != null && !link.isEmpty();
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
        result.append(" (position: "); //$NON-NLS-1$
        result.append(position);
        result.append(')');
        return result.toString();
    }

} // GraphElementImpl
