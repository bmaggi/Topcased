/**
 * <copyright>
 * </copyright>
 *
 * $Id: SourceTargetCoupleImpl.java,v 1.4 2007/04/18 12:21:09 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeContainerType;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Target Couple</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getContainerType <em>Container Type</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#isAutoRef <em>Auto Ref</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#isReversible <em>Reversible</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getContainerObject <em>Container Object</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getSourceNode <em>Source Node</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getTargetNode <em>Target Node</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getContainerRef <em>Container Ref</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getRefSourceToEdge <em>Ref Source To Edge</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getRefEdgeToSource <em>Ref Edge To Source</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getRefTargetToEdge <em>Ref Target To Edge</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getRefEdgeToTarget <em>Ref Edge To Target</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getRefSourceToTarget <em>Ref Source To Target</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.SourceTargetCoupleImpl#getRefTargetToSource <em>Ref Target To Source</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SourceTargetCoupleImpl extends EObjectImpl implements SourceTargetCouple
{
    /**
     * The default value of the '{@link #getContainerType() <em>Container Type</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getContainerType()
     * @generated
     * @ordered
     */
    protected static final EdgeContainerType CONTAINER_TYPE_EDEFAULT = EdgeContainerType.NONE_LITERAL;

    /**
     * The cached value of the '{@link #getContainerType() <em>Container Type</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getContainerType()
     * @generated
     * @ordered
     */
    protected EdgeContainerType containerType = CONTAINER_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isAutoRef() <em>Auto Ref</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isAutoRef()
     * @generated
     * @ordered
     */
    protected static final boolean AUTO_REF_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAutoRef() <em>Auto Ref</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isAutoRef()
     * @generated
     * @ordered
     */
    protected boolean autoRef = AUTO_REF_EDEFAULT;

    /**
     * The default value of the '{@link #isReversible() <em>Reversible</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isReversible()
     * @generated
     * @ordered
     */
    protected static final boolean REVERSIBLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isReversible() <em>Reversible</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isReversible()
     * @generated
     * @ordered
     */
    protected boolean reversible = REVERSIBLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getContainerObject() <em>Container Object</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getContainerObject()
     * @generated
     * @ordered
     */
    protected GenClass containerObject;

    /**
     * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSourceNode()
     * @generated
     * @ordered
     */
    protected PartConfiguration sourceNode;

    /**
     * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getTargetNode()
     * @generated
     * @ordered
     */
    protected PartConfiguration targetNode;

    /**
     * The cached value of the '{@link #getContainerRef() <em>Container Ref</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getContainerRef()
     * @generated
     * @ordered
     */
    protected EStructuralFeature containerRef;

    /**
     * The cached value of the '{@link #getRefSourceToEdge() <em>Ref Source To Edge</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRefSourceToEdge()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refSourceToEdge;

    /**
     * The cached value of the '{@link #getRefEdgeToSource() <em>Ref Edge To Source</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRefEdgeToSource()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refEdgeToSource;

    /**
     * The cached value of the '{@link #getRefTargetToEdge() <em>Ref Target To Edge</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRefTargetToEdge()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refTargetToEdge;

    /**
     * The cached value of the '{@link #getRefEdgeToTarget() <em>Ref Edge To Target</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRefEdgeToTarget()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refEdgeToTarget;

    /**
     * The cached value of the '{@link #getRefSourceToTarget() <em>Ref Source To Target</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRefSourceToTarget()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refSourceToTarget;

    /**
     * The cached value of the '{@link #getRefTargetToSource() <em>Ref Target To Source</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRefTargetToSource()
     * @generated
     * @ordered
     */
    protected EStructuralFeature refTargetToSource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SourceTargetCoupleImpl()
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
        return DiagramconfiguratorPackage.Literals.SOURCE_TARGET_COUPLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeContainerType getContainerType()
    {
        return containerType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setContainerType(EdgeContainerType newContainerType)
    {
        EdgeContainerType oldContainerType = containerType;
        containerType = newContainerType == null ? CONTAINER_TYPE_EDEFAULT : newContainerType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE, oldContainerType, containerType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isAutoRef()
    {
        return autoRef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAutoRef(boolean newAutoRef)
    {
        boolean oldAutoRef = autoRef;
        autoRef = newAutoRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF, oldAutoRef, autoRef));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isReversible()
    {
        return reversible;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReversible(boolean newReversible)
    {
        boolean oldReversible = reversible;
        reversible = newReversible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE, oldReversible, reversible));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenClass getContainerObject()
    {
        if (containerObject != null && containerObject.eIsProxy())
        {
            InternalEObject oldContainerObject = (InternalEObject) containerObject;
            containerObject = (GenClass) eResolveProxy(oldContainerObject);
            if (containerObject != oldContainerObject)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT, oldContainerObject, containerObject));
            }
        }
        return containerObject;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GenClass basicGetContainerObject()
    {
        return containerObject;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setContainerObject(GenClass newContainerObject)
    {
        GenClass oldContainerObject = containerObject;
        containerObject = newContainerObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT, oldContainerObject, containerObject));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfiguration getSourceNode()
    {
        if (sourceNode != null && sourceNode.eIsProxy())
        {
            InternalEObject oldSourceNode = (InternalEObject) sourceNode;
            sourceNode = (PartConfiguration) eResolveProxy(oldSourceNode);
            if (sourceNode != oldSourceNode)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE, oldSourceNode, sourceNode));
            }
        }
        return sourceNode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfiguration basicGetSourceNode()
    {
        return sourceNode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSourceNode(PartConfiguration newSourceNode)
    {
        PartConfiguration oldSourceNode = sourceNode;
        sourceNode = newSourceNode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE, oldSourceNode, sourceNode));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfiguration getTargetNode()
    {
        if (targetNode != null && targetNode.eIsProxy())
        {
            InternalEObject oldTargetNode = (InternalEObject) targetNode;
            targetNode = (PartConfiguration) eResolveProxy(oldTargetNode);
            if (targetNode != oldTargetNode)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE, oldTargetNode, targetNode));
            }
        }
        return targetNode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfiguration basicGetTargetNode()
    {
        return targetNode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTargetNode(PartConfiguration newTargetNode)
    {
        PartConfiguration oldTargetNode = targetNode;
        targetNode = newTargetNode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE, oldTargetNode, targetNode));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getContainerRef()
    {
        if (containerRef != null && containerRef.eIsProxy())
        {
            InternalEObject oldContainerRef = (InternalEObject) containerRef;
            containerRef = (EStructuralFeature) eResolveProxy(oldContainerRef);
            if (containerRef != oldContainerRef)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF, oldContainerRef, containerRef));
            }
        }
        return containerRef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetContainerRef()
    {
        return containerRef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setContainerRef(EStructuralFeature newContainerRef)
    {
        EStructuralFeature oldContainerRef = containerRef;
        containerRef = newContainerRef;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF, oldContainerRef, containerRef));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getRefSourceToEdge()
    {
        if (refSourceToEdge != null && refSourceToEdge.eIsProxy())
        {
            InternalEObject oldRefSourceToEdge = (InternalEObject) refSourceToEdge;
            refSourceToEdge = (EStructuralFeature) eResolveProxy(oldRefSourceToEdge);
            if (refSourceToEdge != oldRefSourceToEdge)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE, oldRefSourceToEdge, refSourceToEdge));
            }
        }
        return refSourceToEdge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetRefSourceToEdge()
    {
        return refSourceToEdge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRefSourceToEdge(EStructuralFeature newRefSourceToEdge)
    {
        EStructuralFeature oldRefSourceToEdge = refSourceToEdge;
        refSourceToEdge = newRefSourceToEdge;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE, oldRefSourceToEdge, refSourceToEdge));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getRefEdgeToSource()
    {
        if (refEdgeToSource != null && refEdgeToSource.eIsProxy())
        {
            InternalEObject oldRefEdgeToSource = (InternalEObject) refEdgeToSource;
            refEdgeToSource = (EStructuralFeature) eResolveProxy(oldRefEdgeToSource);
            if (refEdgeToSource != oldRefEdgeToSource)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE, oldRefEdgeToSource, refEdgeToSource));
            }
        }
        return refEdgeToSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetRefEdgeToSource()
    {
        return refEdgeToSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRefEdgeToSource(EStructuralFeature newRefEdgeToSource)
    {
        EStructuralFeature oldRefEdgeToSource = refEdgeToSource;
        refEdgeToSource = newRefEdgeToSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE, oldRefEdgeToSource, refEdgeToSource));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getRefTargetToEdge()
    {
        if (refTargetToEdge != null && refTargetToEdge.eIsProxy())
        {
            InternalEObject oldRefTargetToEdge = (InternalEObject) refTargetToEdge;
            refTargetToEdge = (EStructuralFeature) eResolveProxy(oldRefTargetToEdge);
            if (refTargetToEdge != oldRefTargetToEdge)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE, oldRefTargetToEdge, refTargetToEdge));
            }
        }
        return refTargetToEdge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetRefTargetToEdge()
    {
        return refTargetToEdge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRefTargetToEdge(EStructuralFeature newRefTargetToEdge)
    {
        EStructuralFeature oldRefTargetToEdge = refTargetToEdge;
        refTargetToEdge = newRefTargetToEdge;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE, oldRefTargetToEdge, refTargetToEdge));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getRefEdgeToTarget()
    {
        if (refEdgeToTarget != null && refEdgeToTarget.eIsProxy())
        {
            InternalEObject oldRefEdgeToTarget = (InternalEObject) refEdgeToTarget;
            refEdgeToTarget = (EStructuralFeature) eResolveProxy(oldRefEdgeToTarget);
            if (refEdgeToTarget != oldRefEdgeToTarget)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET, oldRefEdgeToTarget, refEdgeToTarget));
            }
        }
        return refEdgeToTarget;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetRefEdgeToTarget()
    {
        return refEdgeToTarget;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRefEdgeToTarget(EStructuralFeature newRefEdgeToTarget)
    {
        EStructuralFeature oldRefEdgeToTarget = refEdgeToTarget;
        refEdgeToTarget = newRefEdgeToTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET, oldRefEdgeToTarget, refEdgeToTarget));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getRefSourceToTarget()
    {
        if (refSourceToTarget != null && refSourceToTarget.eIsProxy())
        {
            InternalEObject oldRefSourceToTarget = (InternalEObject) refSourceToTarget;
            refSourceToTarget = (EStructuralFeature) eResolveProxy(oldRefSourceToTarget);
            if (refSourceToTarget != oldRefSourceToTarget)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET, oldRefSourceToTarget, refSourceToTarget));
            }
        }
        return refSourceToTarget;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetRefSourceToTarget()
    {
        return refSourceToTarget;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRefSourceToTarget(EStructuralFeature newRefSourceToTarget)
    {
        EStructuralFeature oldRefSourceToTarget = refSourceToTarget;
        refSourceToTarget = newRefSourceToTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET, oldRefSourceToTarget, refSourceToTarget));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature getRefTargetToSource()
    {
        if (refTargetToSource != null && refTargetToSource.eIsProxy())
        {
            InternalEObject oldRefTargetToSource = (InternalEObject) refTargetToSource;
            refTargetToSource = (EStructuralFeature) eResolveProxy(oldRefTargetToSource);
            if (refTargetToSource != oldRefTargetToSource)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE, oldRefTargetToSource, refTargetToSource));
            }
        }
        return refTargetToSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EStructuralFeature basicGetRefTargetToSource()
    {
        return refTargetToSource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRefTargetToSource(EStructuralFeature newRefTargetToSource)
    {
        EStructuralFeature oldRefTargetToSource = refTargetToSource;
        refTargetToSource = newRefTargetToSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE, oldRefTargetToSource, refTargetToSource));
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
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                return getContainerType();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                return isAutoRef() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                return isReversible() ? Boolean.TRUE : Boolean.FALSE;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                if (resolve)
                    return getContainerObject();
                return basicGetContainerObject();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                if (resolve)
                    return getSourceNode();
                return basicGetSourceNode();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                if (resolve)
                    return getTargetNode();
                return basicGetTargetNode();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                if (resolve)
                    return getContainerRef();
                return basicGetContainerRef();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                if (resolve)
                    return getRefSourceToEdge();
                return basicGetRefSourceToEdge();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                if (resolve)
                    return getRefEdgeToSource();
                return basicGetRefEdgeToSource();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                if (resolve)
                    return getRefTargetToEdge();
                return basicGetRefTargetToEdge();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                if (resolve)
                    return getRefEdgeToTarget();
                return basicGetRefEdgeToTarget();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                if (resolve)
                    return getRefSourceToTarget();
                return basicGetRefSourceToTarget();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                if (resolve)
                    return getRefTargetToSource();
                return basicGetRefTargetToSource();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                setContainerType((EdgeContainerType) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                setAutoRef(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                setReversible(((Boolean) newValue).booleanValue());
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                setContainerObject((GenClass) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                setSourceNode((PartConfiguration) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                setTargetNode((PartConfiguration) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                setContainerRef((EStructuralFeature) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                setRefSourceToEdge((EStructuralFeature) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                setRefEdgeToSource((EStructuralFeature) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                setRefTargetToEdge((EStructuralFeature) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                setRefEdgeToTarget((EStructuralFeature) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                setRefSourceToTarget((EStructuralFeature) newValue);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                setRefTargetToSource((EStructuralFeature) newValue);
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
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                setContainerType(CONTAINER_TYPE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                setAutoRef(AUTO_REF_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                setReversible(REVERSIBLE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                setContainerObject((GenClass) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                setSourceNode((PartConfiguration) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                setTargetNode((PartConfiguration) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                setContainerRef((EStructuralFeature) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                setRefSourceToEdge((EStructuralFeature) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                setRefEdgeToSource((EStructuralFeature) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                setRefTargetToEdge((EStructuralFeature) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                setRefEdgeToTarget((EStructuralFeature) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                setRefSourceToTarget((EStructuralFeature) null);
                return;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                setRefTargetToSource((EStructuralFeature) null);
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
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_TYPE:
                return containerType != CONTAINER_TYPE_EDEFAULT;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__AUTO_REF:
                return autoRef != AUTO_REF_EDEFAULT;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REVERSIBLE:
                return reversible != REVERSIBLE_EDEFAULT;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_OBJECT:
                return containerObject != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__SOURCE_NODE:
                return sourceNode != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__TARGET_NODE:
                return targetNode != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__CONTAINER_REF:
                return containerRef != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE:
                return refSourceToEdge != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE:
                return refEdgeToSource != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE:
                return refTargetToEdge != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET:
                return refEdgeToTarget != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET:
                return refSourceToTarget != null;
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE:
                return refTargetToSource != null;
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
        result.append(" (containerType: ");
        result.append(containerType);
        result.append(", autoRef: ");
        result.append(autoRef);
        result.append(", reversible: ");
        result.append(reversible);
        result.append(')');
        return result.toString();
    }

} // SourceTargetCoupleImpl
