/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphEdgeImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Graph Edge</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphEdgeImpl#getWaypoints <em>Waypoints</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.GraphEdgeImpl#getAnchor <em>Anchor</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GraphEdgeImpl extends GraphElementImpl implements GraphEdge
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getWaypoints() <em>Waypoints</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWaypoints()
     * @generated
     * @ordered
     */
    protected EList<RelativeBendpoint> waypoints;

    /**
     * The cached value of the '{@link #getAnchor() <em>Anchor</em>}' reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getAnchor()
     * @generated
     * @ordered
     */
    protected EList<GraphConnector> anchor;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected GraphEdgeImpl()
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
        return DiagramInterchangePackage.Literals.GRAPH_EDGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<RelativeBendpoint> getWaypoints()
    {
        if (waypoints == null)
        {
            waypoints = new EDataTypeUniqueEList<RelativeBendpoint>(RelativeBendpoint.class, this, DiagramInterchangePackage.GRAPH_EDGE__WAYPOINTS);
        }
        return waypoints;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<GraphConnector> getAnchor()
    {
        if (anchor == null)
        {
            anchor = new EObjectWithInverseResolvingEList.ManyInverse<GraphConnector>(GraphConnector.class, this, DiagramInterchangePackage.GRAPH_EDGE__ANCHOR,
                    DiagramInterchangePackage.GRAPH_CONNECTOR__GRAPH_EDGE);
        }
        return anchor;
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
            case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                return ((InternalEList<InternalEObject>) (InternalEList< ? >) getAnchor()).basicAdd(otherEnd, msgs);
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
            case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                return ((InternalEList< ? >) getAnchor()).basicRemove(otherEnd, msgs);
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
            case DiagramInterchangePackage.GRAPH_EDGE__WAYPOINTS:
                return getWaypoints();
            case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                return getAnchor();
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
            case DiagramInterchangePackage.GRAPH_EDGE__WAYPOINTS:
                getWaypoints().clear();
                getWaypoints().addAll((Collection< ? extends RelativeBendpoint>) newValue);
                return;
            case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                getAnchor().clear();
                getAnchor().addAll((Collection< ? extends GraphConnector>) newValue);
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
            case DiagramInterchangePackage.GRAPH_EDGE__WAYPOINTS:
                getWaypoints().clear();
                return;
            case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                getAnchor().clear();
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
            case DiagramInterchangePackage.GRAPH_EDGE__WAYPOINTS:
                return waypoints != null && !waypoints.isEmpty();
            case DiagramInterchangePackage.GRAPH_EDGE__ANCHOR:
                return anchor != null && !anchor.isEmpty();
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
        result.append(" (waypoints: "); //$NON-NLS-1$
        result.append(waypoints);
        result.append(')');
        return result.toString();
    }

    /**
     * An edge is visible is visible if the property visible is <code>true</code> and there is 2 anchors and these
     * anchors are visible
     * 
     * @see org.topcased.modeler.di.model.internal.impl.DiagramElementImpl#isVisible()
     * @generated NOT
     */
    public boolean isVisible()
    {
        return super.isVisible() && (getAnchor().size() == 0 || getAnchor().get(0).isVisible()) && (getAnchor().size() != 2 || getAnchor().get(1).isVisible());
    }

} // GraphEdgeImpl
