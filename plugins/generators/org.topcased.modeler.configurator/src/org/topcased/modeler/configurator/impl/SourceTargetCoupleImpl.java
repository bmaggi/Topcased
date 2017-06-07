/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.configurator.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.EdgeContainerType;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.SourceTargetCouple;

import org.topcased.modeler.configurator.Target;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Target Couple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getContainerType <em>Container Type</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#isAutoRef <em>Auto Ref</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#isReversible <em>Reversible</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getContainerObject <em>Container Object</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getContainerRef <em>Container Ref</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getRefSourceToEdge <em>Ref Source To Edge</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getRefEdgeToSource <em>Ref Edge To Source</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getRefTargetToEdge <em>Ref Target To Edge</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getRefEdgeToTarget <em>Ref Edge To Target</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getRefSourceToTarget <em>Ref Source To Target</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.SourceTargetCoupleImpl#getRefTargetToSource <em>Ref Target To Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceTargetCoupleImpl extends EObjectImpl implements SourceTargetCouple
{
    /**
     * The default value of the '{@link #getContainerType() <em>Container Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContainerType()
     * @generated
     * @ordered
     */
    protected static final EdgeContainerType CONTAINER_TYPE_EDEFAULT = EdgeContainerType.NONE_LITERAL;

    /**
     * The cached value of the '{@link #getContainerType() <em>Container Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContainerType()
     * @generated
     * @ordered
     */
    protected EdgeContainerType containerType = CONTAINER_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isAutoRef() <em>Auto Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutoRef()
     * @generated
     * @ordered
     */
    protected static final boolean AUTO_REF_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAutoRef() <em>Auto Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutoRef()
     * @generated
     * @ordered
     */
    protected boolean autoRef = AUTO_REF_EDEFAULT;

    /**
     * The default value of the '{@link #isReversible() <em>Reversible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReversible()
     * @generated
     * @ordered
     */
    protected static final boolean REVERSIBLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isReversible() <em>Reversible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReversible()
     * @generated
     * @ordered
     */
    protected boolean reversible = REVERSIBLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getContainerObject() <em>Container Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContainerObject()
     * @generated
     * @ordered
     */
    protected GenClass containerObject = null;

    /**
     * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceNode()
     * @generated
     * @ordered
     */
    protected NodePartConfiguration sourceNode = null;

    /**
     * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetNode()
     * @generated
     * @ordered
     */
    protected NodePartConfiguration targetNode = null;

    /**
     * The cached value of the '{@link #getContainerRef() <em>Container Ref</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContainerRef()
     * @generated
     * @ordered
     */
    protected EStructuralFeature containerRef = null;

    /**
     * The cached value of the '{@link #getRefSourceToEdge() <em>Ref Source To Edge</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRefSourceToEdge()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refSourceToEdge = null;

    /**
     * The cached value of the '{@link #getRefEdgeToSource() <em>Ref Edge To Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRefEdgeToSource()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refEdgeToSource = null;

    /**
     * The cached value of the '{@link #getRefTargetToEdge() <em>Ref Target To Edge</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRefTargetToEdge()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refTargetToEdge = null;

    /**
     * The cached value of the '{@link #getRefEdgeToTarget() <em>Ref Edge To Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRefEdgeToTarget()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refEdgeToTarget = null;

    /**
     * The cached value of the '{@link #getRefSourceToTarget() <em>Ref Source To Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRefSourceToTarget()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refSourceToTarget = null;

    /**
     * The cached value of the '{@link #getRefTargetToSource() <em>Ref Target To Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRefTargetToSource()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refTargetToSource = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SourceTargetCoupleImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass()
    {
        return ConfiguratorPackage.eINSTANCE.getSourceTargetCouple();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgeContainerType getContainerType()
    {
        return containerType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainerType(EdgeContainerType newContainerType)
    {
        EdgeContainerType oldContainerType = containerType;
        containerType = newContainerType == null ? CONTAINER_TYPE_EDEFAULT : newContainerType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE, oldContainerType, containerType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReversible()
    {
        return reversible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReversible(boolean newReversible)
    {
        boolean oldReversible = reversible;
        reversible = newReversible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE, oldReversible, reversible));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenClass getContainerObject()
    {
        if (containerObject != null && containerObject.eIsProxy())
        {
            GenClass oldContainerObject = containerObject;
            containerObject = (GenClass)eResolveProxy((InternalEObject)containerObject);
            if (containerObject != oldContainerObject)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT, oldContainerObject, containerObject));
            }
        }
        return containerObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenClass basicGetContainerObject()
    {
        return containerObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainerObject(GenClass newContainerObject)
    {
        GenClass oldContainerObject = containerObject;
        containerObject = newContainerObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT, oldContainerObject, containerObject));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NodePartConfiguration getSourceNode()
    {
        if (sourceNode != null && sourceNode.eIsProxy())
        {
            NodePartConfiguration oldSourceNode = sourceNode;
            sourceNode = (NodePartConfiguration)eResolveProxy((InternalEObject)sourceNode);
            if (sourceNode != oldSourceNode)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE, oldSourceNode, sourceNode));
            }
        }
        return sourceNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NodePartConfiguration basicGetSourceNode()
    {
        return sourceNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceNode(NodePartConfiguration newSourceNode)
    {
        NodePartConfiguration oldSourceNode = sourceNode;
        sourceNode = newSourceNode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE, oldSourceNode, sourceNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NodePartConfiguration getTargetNode()
    {
        if (targetNode != null && targetNode.eIsProxy())
        {
            NodePartConfiguration oldTargetNode = targetNode;
            targetNode = (NodePartConfiguration)eResolveProxy((InternalEObject)targetNode);
            if (targetNode != oldTargetNode)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE, oldTargetNode, targetNode));
            }
        }
        return targetNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NodePartConfiguration basicGetTargetNode()
    {
        return targetNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetNode(NodePartConfiguration newTargetNode)
    {
        NodePartConfiguration oldTargetNode = targetNode;
        targetNode = newTargetNode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE, oldTargetNode, targetNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAutoRef()
    {
        return autoRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAutoRef(boolean newAutoRef)
    {
        boolean oldAutoRef = autoRef;
        autoRef = newAutoRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF, oldAutoRef, autoRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getContainerRef()
    {
        if (containerRef != null && containerRef.eIsProxy())
        {
            EStructuralFeature oldContainerRef = containerRef;
            containerRef = (EStructuralFeature)eResolveProxy((InternalEObject)containerRef);
            if (containerRef != oldContainerRef)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF, oldContainerRef, containerRef));
            }
        }
        return containerRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetContainerRef()
    {
        return containerRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainerRef(EStructuralFeature newContainerRef)
    {
        EStructuralFeature oldContainerRef = containerRef;
        containerRef = newContainerRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF, oldContainerRef, containerRef));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getRefSourceToEdge()
    {
        if (refSourceToEdge != null && refSourceToEdge.eIsProxy())
        {
            EStructuralFeature oldRefSourceToEdge = refSourceToEdge;
            refSourceToEdge = (EStructuralFeature)eResolveProxy((InternalEObject)refSourceToEdge);
            if (refSourceToEdge != oldRefSourceToEdge)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE, oldRefSourceToEdge, refSourceToEdge));
            }
        }
        return refSourceToEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetRefSourceToEdge()
    {
        return refSourceToEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefSourceToEdge(EStructuralFeature newRefSourceToEdge)
    {
        EStructuralFeature oldRefSourceToEdge = refSourceToEdge;
        refSourceToEdge = newRefSourceToEdge;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE, oldRefSourceToEdge, refSourceToEdge));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getRefEdgeToSource()
    {
        if (refEdgeToSource != null && refEdgeToSource.eIsProxy())
        {
            EStructuralFeature oldRefEdgeToSource = refEdgeToSource;
            refEdgeToSource = (EStructuralFeature)eResolveProxy((InternalEObject)refEdgeToSource);
            if (refEdgeToSource != oldRefEdgeToSource)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE, oldRefEdgeToSource, refEdgeToSource));
            }
        }
        return refEdgeToSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetRefEdgeToSource()
    {
        return refEdgeToSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefEdgeToSource(EStructuralFeature newRefEdgeToSource)
    {
        EStructuralFeature oldRefEdgeToSource = refEdgeToSource;
        refEdgeToSource = newRefEdgeToSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE, oldRefEdgeToSource, refEdgeToSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getRefTargetToEdge()
    {
        if (refTargetToEdge != null && refTargetToEdge.eIsProxy())
        {
            EStructuralFeature oldRefTargetToEdge = refTargetToEdge;
            refTargetToEdge = (EStructuralFeature)eResolveProxy((InternalEObject)refTargetToEdge);
            if (refTargetToEdge != oldRefTargetToEdge)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE, oldRefTargetToEdge, refTargetToEdge));
            }
        }
        return refTargetToEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetRefTargetToEdge()
    {
        return refTargetToEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefTargetToEdge(EStructuralFeature newRefTargetToEdge)
    {
        EStructuralFeature oldRefTargetToEdge = refTargetToEdge;
        refTargetToEdge = newRefTargetToEdge;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE, oldRefTargetToEdge, refTargetToEdge));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getRefEdgeToTarget()
    {
        if (refEdgeToTarget != null && refEdgeToTarget.eIsProxy())
        {
            EStructuralFeature oldRefEdgeToTarget = refEdgeToTarget;
            refEdgeToTarget = (EStructuralFeature)eResolveProxy((InternalEObject)refEdgeToTarget);
            if (refEdgeToTarget != oldRefEdgeToTarget)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET, oldRefEdgeToTarget, refEdgeToTarget));
            }
        }
        return refEdgeToTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetRefEdgeToTarget()
    {
        return refEdgeToTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefEdgeToTarget(EStructuralFeature newRefEdgeToTarget)
    {
        EStructuralFeature oldRefEdgeToTarget = refEdgeToTarget;
        refEdgeToTarget = newRefEdgeToTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET, oldRefEdgeToTarget, refEdgeToTarget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getRefSourceToTarget()
    {
        if (refSourceToTarget != null && refSourceToTarget.eIsProxy())
        {
            EStructuralFeature oldRefSourceToTarget = refSourceToTarget;
            refSourceToTarget = (EStructuralFeature)eResolveProxy((InternalEObject)refSourceToTarget);
            if (refSourceToTarget != oldRefSourceToTarget)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET, oldRefSourceToTarget, refSourceToTarget));
            }
        }
        return refSourceToTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetRefSourceToTarget()
    {
        return refSourceToTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefSourceToTarget(EStructuralFeature newRefSourceToTarget)
    {
        EStructuralFeature oldRefSourceToTarget = refSourceToTarget;
        refSourceToTarget = newRefSourceToTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET, oldRefSourceToTarget, refSourceToTarget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature getRefTargetToSource()
    {
        if (refTargetToSource != null && refTargetToSource.eIsProxy())
        {
            EStructuralFeature oldRefTargetToSource = refTargetToSource;
            refTargetToSource = (EStructuralFeature)eResolveProxy((InternalEObject)refTargetToSource);
            if (refTargetToSource != oldRefTargetToSource)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE, oldRefTargetToSource, refTargetToSource));
            }
        }
        return refTargetToSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature basicGetRefTargetToSource()
    {
        return refTargetToSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRefTargetToSource(EStructuralFeature newRefTargetToSource)
    {
        EStructuralFeature oldRefTargetToSource = refTargetToSource;
        refTargetToSource = newRefTargetToSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE, oldRefTargetToSource, refTargetToSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                return getContainerType();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                return isAutoRef() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                return isReversible() ? Boolean.TRUE : Boolean.FALSE;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                if (resolve) return getContainerObject();
                return basicGetContainerObject();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                if (resolve) return getSourceNode();
                return basicGetSourceNode();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                if (resolve) return getTargetNode();
                return basicGetTargetNode();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                if (resolve) return getContainerRef();
                return basicGetContainerRef();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                if (resolve) return getRefSourceToEdge();
                return basicGetRefSourceToEdge();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                if (resolve) return getRefEdgeToSource();
                return basicGetRefEdgeToSource();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                if (resolve) return getRefTargetToEdge();
                return basicGetRefTargetToEdge();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                if (resolve) return getRefEdgeToTarget();
                return basicGetRefEdgeToTarget();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                if (resolve) return getRefSourceToTarget();
                return basicGetRefSourceToTarget();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                if (resolve) return getRefTargetToSource();
                return basicGetRefTargetToSource();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                setContainerType((EdgeContainerType)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                setAutoRef(((Boolean)newValue).booleanValue());
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                setReversible(((Boolean)newValue).booleanValue());
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                setContainerObject((GenClass)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                setSourceNode((NodePartConfiguration)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                setTargetNode((NodePartConfiguration)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                setContainerRef((EStructuralFeature)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                setRefSourceToEdge((EStructuralFeature)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                setRefEdgeToSource((EStructuralFeature)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                setRefTargetToEdge((EStructuralFeature)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                setRefEdgeToTarget((EStructuralFeature)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                setRefSourceToTarget((EStructuralFeature)newValue);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                setRefTargetToSource((EStructuralFeature)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                setContainerType(CONTAINER_TYPE_EDEFAULT);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                setAutoRef(AUTO_REF_EDEFAULT);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                setReversible(REVERSIBLE_EDEFAULT);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                setContainerObject((GenClass)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                setSourceNode((NodePartConfiguration)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                setTargetNode((NodePartConfiguration)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                setContainerRef((EStructuralFeature)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                setRefSourceToEdge((EStructuralFeature)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                setRefEdgeToSource((EStructuralFeature)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                setRefTargetToEdge((EStructuralFeature)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                setRefEdgeToTarget((EStructuralFeature)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                setRefSourceToTarget((EStructuralFeature)null);
                return;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                setRefTargetToSource((EStructuralFeature)null);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                return containerType != CONTAINER_TYPE_EDEFAULT;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                return autoRef != AUTO_REF_EDEFAULT;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                return reversible != REVERSIBLE_EDEFAULT;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                return containerObject != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                return sourceNode != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                return targetNode != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                return containerRef != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                return refSourceToEdge != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                return refEdgeToSource != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                return refTargetToEdge != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                return refEdgeToTarget != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                return refSourceToTarget != null;
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                return refTargetToSource != null;
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (containerType: "); //$NON-NLS-1$
        result.append(containerType);
        result.append(", autoRef: "); //$NON-NLS-1$
        result.append(autoRef);
        result.append(", reversible: "); //$NON-NLS-1$
        result.append(reversible);
        result.append(')');
        return result.toString();
    }

} //SourceTargetCoupleImpl
