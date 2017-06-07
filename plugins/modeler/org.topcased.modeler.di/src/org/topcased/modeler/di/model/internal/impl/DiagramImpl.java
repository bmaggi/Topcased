/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.DiagramLink;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramImpl#getZoom <em>Zoom</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramImpl#getViewport <em>Viewport</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.DiagramImpl#getDiagramLink <em>Diagram Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends GraphNodeImpl implements Diagram
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getZoom()
     * @generated
     * @ordered
     */
    protected static final double ZOOM_EDEFAULT = 1.0;

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
     * The cached value of the '{@link #getDiagramLink() <em>Diagram Link</em>}' reference list.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getDiagramLink()
     * @generated
     * @ordered
     */
    protected EList<DiagramLink> diagramLink;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramImpl()
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
        return DiagramInterchangePackage.Literals.DIAGRAM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM__ZOOM, oldZoom, zoom));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM__VIEWPORT, oldViewport, viewport));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<DiagramLink> getDiagramLink()
    {
        if (diagramLink == null)
        {
            diagramLink = new EObjectWithInverseResolvingEList<DiagramLink>(DiagramLink.class, this, DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK, DiagramInterchangePackage.DIAGRAM_LINK__DIAGRAM);
        }
        return diagramLink;
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
            case DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK:
                return ((InternalEList<InternalEObject>) (InternalEList< ? >) getDiagramLink()).basicAdd(otherEnd, msgs);
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
            case DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK:
                return ((InternalEList< ? >) getDiagramLink()).basicRemove(otherEnd, msgs);
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
            case DiagramInterchangePackage.DIAGRAM__NAME:
                return getName();
            case DiagramInterchangePackage.DIAGRAM__ZOOM:
                return getZoom();
            case DiagramInterchangePackage.DIAGRAM__VIEWPORT:
                return getViewport();
            case DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK:
                return getDiagramLink();
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
            case DiagramInterchangePackage.DIAGRAM__NAME:
                setName((String) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM__ZOOM:
                setZoom((Double) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM__VIEWPORT:
                setViewport((Point) newValue);
                return;
            case DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK:
                getDiagramLink().clear();
                getDiagramLink().addAll((Collection< ? extends DiagramLink>) newValue);
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
            case DiagramInterchangePackage.DIAGRAM__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DiagramInterchangePackage.DIAGRAM__ZOOM:
                setZoom(ZOOM_EDEFAULT);
                return;
            case DiagramInterchangePackage.DIAGRAM__VIEWPORT:
                setViewport(VIEWPORT_EDEFAULT);
                return;
            case DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK:
                getDiagramLink().clear();
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
            case DiagramInterchangePackage.DIAGRAM__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DiagramInterchangePackage.DIAGRAM__ZOOM:
                return zoom != ZOOM_EDEFAULT;
            case DiagramInterchangePackage.DIAGRAM__VIEWPORT:
                return VIEWPORT_EDEFAULT == null ? viewport != null : !VIEWPORT_EDEFAULT.equals(viewport);
            case DiagramInterchangePackage.DIAGRAM__DIAGRAM_LINK:
                return diagramLink != null && !diagramLink.isEmpty();
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
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(", zoom: "); //$NON-NLS-1$
        result.append(zoom);
        result.append(", viewport: "); //$NON-NLS-1$
        result.append(viewport);
        result.append(')');
        return result.toString();
    }

} // DiagramImpl
