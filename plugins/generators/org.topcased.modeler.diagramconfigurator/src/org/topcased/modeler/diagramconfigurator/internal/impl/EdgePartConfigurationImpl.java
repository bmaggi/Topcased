/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgePartConfigurationImpl.java,v 1.4 2007/04/18 12:21:17 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.diagramconfigurator.DecorationType;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.RouterType;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge Part Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl#getSourceTargetCouple <em>Source Target Couple</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl#getEdgeObjects <em>Edge Objects</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl#getSourceDecoration <em>Source Decoration</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl#getTargetDecoration <em>Target Decoration</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl#getDefaultRouter <em>Default Router</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.EdgePartConfigurationImpl#getDirectEditable <em>Direct Editable</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EdgePartConfigurationImpl extends PartConfigurationImpl implements EdgePartConfiguration
{
    /**
     * The cached value of the '{@link #getSourceTargetCouple() <em>Source Target Couple</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSourceTargetCouple()
     * @generated
     * @ordered
     */
    protected EList<SourceTargetCouple> sourceTargetCouple;

    /**
     * The cached value of the '{@link #getEdgeObjects() <em>Edge Objects</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEdgeObjects()
     * @generated
     * @ordered
     */
    protected EList<EdgeObject> edgeObjects;

    /**
     * The default value of the '{@link #getSourceDecoration() <em>Source Decoration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSourceDecoration()
     * @generated
     * @ordered
     */
    protected static final DecorationType SOURCE_DECORATION_EDEFAULT = DecorationType.NONE_LITERAL;

    /**
     * The cached value of the '{@link #getSourceDecoration() <em>Source Decoration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSourceDecoration()
     * @generated
     * @ordered
     */
    protected DecorationType sourceDecoration = SOURCE_DECORATION_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetDecoration() <em>Target Decoration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTargetDecoration()
     * @generated
     * @ordered
     */
    protected static final DecorationType TARGET_DECORATION_EDEFAULT = DecorationType.NONE_LITERAL;

    /**
     * The cached value of the '{@link #getTargetDecoration() <em>Target Decoration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTargetDecoration()
     * @generated
     * @ordered
     */
    protected DecorationType targetDecoration = TARGET_DECORATION_EDEFAULT;

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
     * The cached value of the '{@link #getDirectEditable() <em>Direct Editable</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getDirectEditable()
     * @generated
     * @ordered
     */
    protected EdgeObject directEditable;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EdgePartConfigurationImpl()
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
        return DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<SourceTargetCouple> getSourceTargetCouple()
    {
        if (sourceTargetCouple == null)
        {
            sourceTargetCouple = new EObjectContainmentEList<SourceTargetCouple>(SourceTargetCouple.class, this, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE);
        }
        return sourceTargetCouple;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<EdgeObject> getEdgeObjects()
    {
        if (edgeObjects == null)
        {
            edgeObjects = new EObjectContainmentEList<EdgeObject>(EdgeObject.class, this, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS);
        }
        return edgeObjects;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DecorationType getSourceDecoration()
    {
        return sourceDecoration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSourceDecoration(DecorationType newSourceDecoration)
    {
        DecorationType oldSourceDecoration = sourceDecoration;
        sourceDecoration = newSourceDecoration == null ? SOURCE_DECORATION_EDEFAULT : newSourceDecoration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION, oldSourceDecoration, sourceDecoration));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DecorationType getTargetDecoration()
    {
        return targetDecoration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTargetDecoration(DecorationType newTargetDecoration)
    {
        DecorationType oldTargetDecoration = targetDecoration;
        targetDecoration = newTargetDecoration == null ? TARGET_DECORATION_EDEFAULT : newTargetDecoration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION, oldTargetDecoration, targetDecoration));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER, oldDefaultRouter, defaultRouter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeObject getDirectEditable()
    {
        if (directEditable != null && directEditable.eIsProxy())
        {
            InternalEObject oldDirectEditable = (InternalEObject) directEditable;
            directEditable = (EdgeObject) eResolveProxy(oldDirectEditable);
            if (directEditable != oldDirectEditable)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE, oldDirectEditable, directEditable));
            }
        }
        return directEditable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeObject basicGetDirectEditable()
    {
        return directEditable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDirectEditable(EdgeObject newDirectEditable)
    {
        EdgeObject oldDirectEditable = directEditable;
        directEditable = newDirectEditable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE, oldDirectEditable, directEditable));
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
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                return ((InternalEList< ? >) getSourceTargetCouple()).basicRemove(otherEnd, msgs);
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                return ((InternalEList< ? >) getEdgeObjects()).basicRemove(otherEnd, msgs);
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
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                return getSourceTargetCouple();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                return getEdgeObjects();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                return getSourceDecoration();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                return getTargetDecoration();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                return getDefaultRouter();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                if (resolve)
                    return getDirectEditable();
                return basicGetDirectEditable();
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
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                getSourceTargetCouple().clear();
                getSourceTargetCouple().addAll((Collection< ? extends SourceTargetCouple>) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                getEdgeObjects().clear();
                getEdgeObjects().addAll((Collection< ? extends EdgeObject>) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                setSourceDecoration((DecorationType) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                setTargetDecoration((DecorationType) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                setDefaultRouter((RouterType) newValue);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable((EdgeObject) newValue);
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
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                getSourceTargetCouple().clear();
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                getEdgeObjects().clear();
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                setSourceDecoration(SOURCE_DECORATION_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                setTargetDecoration(TARGET_DECORATION_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                setDefaultRouter(DEFAULT_ROUTER_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                setDirectEditable((EdgeObject) null);
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
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
                return sourceTargetCouple != null && !sourceTargetCouple.isEmpty();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                return edgeObjects != null && !edgeObjects.isEmpty();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
                return sourceDecoration != SOURCE_DECORATION_EDEFAULT;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
                return targetDecoration != TARGET_DECORATION_EDEFAULT;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
                return defaultRouter != DEFAULT_ROUTER_EDEFAULT;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                return directEditable != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (sourceDecoration: ");
        result.append(sourceDecoration);
        result.append(", targetDecoration: ");
        result.append(targetDecoration);
        result.append(", defaultRouter: ");
        result.append(defaultRouter);
        result.append(')');
        return result.toString();
    }

} // EdgePartConfigurationImpl
