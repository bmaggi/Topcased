/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeGraphConfImpl.java,v 1.2 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.RouterType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.internal.impl.EdgeGraphConfImpl#getDefaultRouter <em>Default Router</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EdgeGraphConfImpl extends AbstractGraphConfImpl implements EdgeGraphConf
{
    /**
     * The default value of the '{@link #getDefaultRouter() <em>Default Router</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDefaultRouter()
     * @generated
     * @ordered
     */
    protected static final RouterType DEFAULT_ROUTER_EDEFAULT = RouterType.OBLIQUE_ROUTER_LITERAL;

    /**
     * The cached value of the '{@link #getDefaultRouter() <em>Default Router</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDefaultRouter()
     * @generated
     * @ordered
     */
    protected RouterType defaultRouter = DEFAULT_ROUTER_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EdgeGraphConfImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass()
    {
        return GraphconfPackage.Literals.EDGE_GRAPH_CONF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RouterType getDefaultRouter()
    {
        return defaultRouter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDefaultRouter(RouterType newDefaultRouter)
    {
        RouterType oldDefaultRouter = defaultRouter;
        defaultRouter = newDefaultRouter == null ? DEFAULT_ROUTER_EDEFAULT : newDefaultRouter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphconfPackage.EDGE_GRAPH_CONF__DEFAULT_ROUTER, oldDefaultRouter, defaultRouter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case GraphconfPackage.EDGE_GRAPH_CONF__DEFAULT_ROUTER:
                return getDefaultRouter();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case GraphconfPackage.EDGE_GRAPH_CONF__DEFAULT_ROUTER:
                setDefaultRouter((RouterType) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case GraphconfPackage.EDGE_GRAPH_CONF__DEFAULT_ROUTER:
                setDefaultRouter(DEFAULT_ROUTER_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case GraphconfPackage.EDGE_GRAPH_CONF__DEFAULT_ROUTER:
                return defaultRouter != DEFAULT_ROUTER_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (defaultRouter: ");
        result.append(defaultRouter);
        result.append(')');
        return result.toString();
    }

} // EdgeGraphConfImpl
