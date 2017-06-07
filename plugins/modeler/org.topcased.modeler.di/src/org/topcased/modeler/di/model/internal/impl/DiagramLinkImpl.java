/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramLinkImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.DiagramLink;
import org.topcased.modeler.di.model.GraphElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Link</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl#getZoom <em>Zoom</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl#getViewport <em>Viewport</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl#getGraphElement <em>Graph Element</em>}</li>
 * <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramLinkImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramLinkImpl extends EModelElementImpl implements DiagramLink
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getZoom()
     * @generated
     * @ordered
     */
    protected static final double ZOOM_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getZoom() <em>Zoom</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getZoom()
     * @generated
     * @ordered
     */
    protected double zoom = ZOOM_EDEFAULT;

    /**
     * The default value of the '{@link #getViewport() <em>Viewport</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getViewport()
     * @generated
     * @ordered
     */
    protected static final Point VIEWPORT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getViewport() <em>Viewport</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getViewport()
     * @generated
     * @ordered
     */
    protected Point viewport = VIEWPORT_EDEFAULT;

    /**
     * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDiagram()
     * @generated
     * @ordered
     */
    protected Diagram diagram;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramLinkImpl()
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
        return DiagramInterchangePackage.Literals.DIAGRAM_LINK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public double getZoom()
    {
        return zoom;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setZoom(double newZoom)
    {
        double oldZoom = zoom;
        zoom = newZoom;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_LINK__ZOOM, oldZoom, zoom));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Point getViewport()
    {
        return viewport;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setViewport(Point newViewport)
    {
        Point oldViewport = viewport;
        viewport = newViewport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_LINK__VIEWPORT, oldViewport, viewport));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public GraphElement getGraphElement()
    {
        if (eContainerFeatureID() != DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT)
            return null;
        return (GraphElement) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetGraphElement(GraphElement newGraphElement, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject) newGraphElement, DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setGraphElement(GraphElement newGraphElement)
    {
        if (newGraphElement != eInternalContainer() || (eContainerFeatureID() != DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT && newGraphElement != null))
        {
            if (EcoreUtil.isAncestor(this, (EObject) newGraphElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newGraphElement != null)
                msgs = ((InternalEObject) newGraphElement).eInverseAdd(this, DiagramInterchangePackage.GRAPH_ELEMENT__LINK, GraphElement.class, msgs);
            msgs = basicSetGraphElement(newGraphElement, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT, newGraphElement, newGraphElement));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagram getDiagram()
    {
        if (diagram != null && ((EObject) diagram).eIsProxy())
        {
            InternalEObject oldDiagram = (InternalEObject) diagram;
            diagram = (Diagram) eResolveProxy(oldDiagram);
            if (diagram != oldDiagram)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM, oldDiagram, diagram));
            }
        }
        return diagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Diagram basicGetDiagram()
    {
        return diagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDiagram(Diagram newDiagram, NotificationChain msgs)
    {
        Diagram oldDiagram = diagram;
        diagram = newDiagram;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM, oldDiagram, newDiagram);
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
    public void setDiagram(Diagram newDiagram)
    {
        if (newDiagram != diagram)
        {
            NotificationChain msgs = null;
            if (diagram != null)
                msgs = ((InternalEObject) diagram).eInverseRemove(this, DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK, Diagram.class, msgs);
            if (newDiagram != null)
                msgs = ((InternalEObject) newDiagram).eInverseAdd(this, DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK, Diagram.class, msgs);
            msgs = basicSetDiagram(newDiagram, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM, newDiagram, newDiagram));
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
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetGraphElement((GraphElement) otherEnd, msgs);
            case DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM:
                if (diagram != null)
                    msgs = ((InternalEObject) diagram).eInverseRemove(this, DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK, Diagram.class, msgs);
                return basicSetDiagram((Diagram) otherEnd, msgs);
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
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                return basicSetGraphElement(null, msgs);
            case DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM:
                return basicSetDiagram(null, msgs);
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
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                return eInternalContainer().eInverseRemove(this, DiagramInterchangePackage.GRAPH_ELEMENT__LINK, GraphElement.class, msgs);
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
            case DiagramInterchangePackage.DIAGRAM_LINK__ZOOM:
                return getZoom();
            case DiagramInterchangePackage.DIAGRAM_LINK__VIEWPORT:
                return getViewport();
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                return getGraphElement();
            case DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM:
                if (resolve)
                    return getDiagram();
                return basicGetDiagram();
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
            case DiagramInterchangePackage.DIAGRAM_LINK__ZOOM:
                setZoom((Double) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM_LINK__VIEWPORT:
                setViewport((Point) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                setGraphElement((GraphElement) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM:
                setDiagram((Diagram) newValue);
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
            case DiagramInterchangePackage.DIAGRAM_LINK__ZOOM:
                setZoom(ZOOM_EDEFAULT);
                return;
            case DiagramInterchangePackage.DIAGRAM_LINK__VIEWPORT:
                setViewport(VIEWPORT_EDEFAULT);
                return;
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                setGraphElement((GraphElement) null);
                return;
            case DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM:
                setDiagram((Diagram) null);
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
            case DiagramInterchangePackage.DIAGRAM_LINK__ZOOM:
                return zoom != ZOOM_EDEFAULT;
            case DiagramInterchangePackage.DIAGRAM_LINK__VIEWPORT:
                return VIEWPORT_EDEFAULT == null ? viewport != null : !VIEWPORT_EDEFAULT.equals(viewport);
            case DiagramInterchangePackage.DIAGRAM_LINK__GRAPH_ELEMENT:
                return getGraphElement() != null;
            case DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM:
                return diagram != null;
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
        result.append(" (zoom: "); //$NON-NLS-1$
        result.append(zoom);
        result.append(", viewport: "); //$NON-NLS-1$
        result.append(viewport);
        result.append(')');
        return result.toString();
    }

} // DiagramLinkImpl
