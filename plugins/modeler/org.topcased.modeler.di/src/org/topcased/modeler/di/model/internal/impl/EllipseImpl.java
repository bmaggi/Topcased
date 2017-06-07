/**
 * <copyright>
 * </copyright>
 *
 * $Id: EllipseImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Ellipse;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ellipse</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl#getCenter <em>Center</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl#getRadiusX <em>Radius X</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl#getRadiusY <em>Radius Y</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl#getRotation <em>Rotation</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl#getStartAngle <em>Start Angle</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EllipseImpl#getEndAngle <em>End Angle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EllipseImpl extends GraphicPrimitiveImpl implements Ellipse
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getCenter() <em>Center</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getCenter()
     * @generated
     * @ordered
     */
    protected static final Point CENTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCenter() <em>Center</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getCenter()
     * @generated
     * @ordered
     */
    protected Point center = CENTER_EDEFAULT;

    /**
     * The default value of the '{@link #getRadiusX() <em>Radius X</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRadiusX()
     * @generated
     * @ordered
     */
    protected static final double RADIUS_X_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getRadiusX() <em>Radius X</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRadiusX()
     * @generated
     * @ordered
     */
    protected double radiusX = RADIUS_X_EDEFAULT;

    /**
     * The default value of the '{@link #getRadiusY() <em>Radius Y</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRadiusY()
     * @generated
     * @ordered
     */
    protected static final double RADIUS_Y_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getRadiusY() <em>Radius Y</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRadiusY()
     * @generated
     * @ordered
     */
    protected double radiusY = RADIUS_Y_EDEFAULT;

    /**
     * The default value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRotation()
     * @generated
     * @ordered
     */
    protected static final double ROTATION_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getRotation()
     * @generated
     * @ordered
     */
    protected double rotation = ROTATION_EDEFAULT;

    /**
     * The default value of the '{@link #getStartAngle() <em>Start Angle</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartAngle()
     * @generated
     * @ordered
     */
    protected static final double START_ANGLE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getStartAngle() <em>Start Angle</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getStartAngle()
     * @generated
     * @ordered
     */
    protected double startAngle = START_ANGLE_EDEFAULT;

    /**
     * The default value of the '{@link #getEndAngle() <em>End Angle</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getEndAngle()
     * @generated
     * @ordered
     */
    protected static final double END_ANGLE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getEndAngle() <em>End Angle</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getEndAngle()
     * @generated
     * @ordered
     */
    protected double endAngle = END_ANGLE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EllipseImpl()
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
        return DiagramInterchangePackage.Literals.ELLIPSE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Point getCenter()
    {
        return center;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setCenter(Point newCenter)
    {
        Point oldCenter = center;
        center = newCenter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.ELLIPSE__CENTER, oldCenter, center));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public double getRadiusX()
    {
        return radiusX;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRadiusX(double newRadiusX)
    {
        double oldRadiusX = radiusX;
        radiusX = newRadiusX;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.ELLIPSE__RADIUS_X, oldRadiusX, radiusX));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public double getRadiusY()
    {
        return radiusY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRadiusY(double newRadiusY)
    {
        double oldRadiusY = radiusY;
        radiusY = newRadiusY;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.ELLIPSE__RADIUS_Y, oldRadiusY, radiusY));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public double getRotation()
    {
        return rotation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRotation(double newRotation)
    {
        double oldRotation = rotation;
        rotation = newRotation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.ELLIPSE__ROTATION, oldRotation, rotation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public double getStartAngle()
    {
        return startAngle;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setStartAngle(double newStartAngle)
    {
        double oldStartAngle = startAngle;
        startAngle = newStartAngle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.ELLIPSE__START_ANGLE, oldStartAngle, startAngle));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public double getEndAngle()
    {
        return endAngle;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setEndAngle(double newEndAngle)
    {
        double oldEndAngle = endAngle;
        endAngle = newEndAngle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.ELLIPSE__END_ANGLE, oldEndAngle, endAngle));
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
            case DiagramInterchangePackage.ELLIPSE__CENTER:
                return getCenter();
            case DiagramInterchangePackage.ELLIPSE__RADIUS_X:
                return getRadiusX();
            case DiagramInterchangePackage.ELLIPSE__RADIUS_Y:
                return getRadiusY();
            case DiagramInterchangePackage.ELLIPSE__ROTATION:
                return getRotation();
            case DiagramInterchangePackage.ELLIPSE__START_ANGLE:
                return getStartAngle();
            case DiagramInterchangePackage.ELLIPSE__END_ANGLE:
                return getEndAngle();
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
            case DiagramInterchangePackage.ELLIPSE__CENTER:
                setCenter((Point) newValue);
                return;
            case DiagramInterchangePackage.ELLIPSE__RADIUS_X:
                setRadiusX((Double) newValue);
                return;
            case DiagramInterchangePackage.ELLIPSE__RADIUS_Y:
                setRadiusY((Double) newValue);
                return;
            case DiagramInterchangePackage.ELLIPSE__ROTATION:
                setRotation((Double) newValue);
                return;
            case DiagramInterchangePackage.ELLIPSE__START_ANGLE:
                setStartAngle((Double) newValue);
                return;
            case DiagramInterchangePackage.ELLIPSE__END_ANGLE:
                setEndAngle((Double) newValue);
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
            case DiagramInterchangePackage.ELLIPSE__CENTER:
                setCenter(CENTER_EDEFAULT);
                return;
            case DiagramInterchangePackage.ELLIPSE__RADIUS_X:
                setRadiusX(RADIUS_X_EDEFAULT);
                return;
            case DiagramInterchangePackage.ELLIPSE__RADIUS_Y:
                setRadiusY(RADIUS_Y_EDEFAULT);
                return;
            case DiagramInterchangePackage.ELLIPSE__ROTATION:
                setRotation(ROTATION_EDEFAULT);
                return;
            case DiagramInterchangePackage.ELLIPSE__START_ANGLE:
                setStartAngle(START_ANGLE_EDEFAULT);
                return;
            case DiagramInterchangePackage.ELLIPSE__END_ANGLE:
                setEndAngle(END_ANGLE_EDEFAULT);
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
            case DiagramInterchangePackage.ELLIPSE__CENTER:
                return CENTER_EDEFAULT == null ? center != null : !CENTER_EDEFAULT.equals(center);
            case DiagramInterchangePackage.ELLIPSE__RADIUS_X:
                return radiusX != RADIUS_X_EDEFAULT;
            case DiagramInterchangePackage.ELLIPSE__RADIUS_Y:
                return radiusY != RADIUS_Y_EDEFAULT;
            case DiagramInterchangePackage.ELLIPSE__ROTATION:
                return rotation != ROTATION_EDEFAULT;
            case DiagramInterchangePackage.ELLIPSE__START_ANGLE:
                return startAngle != START_ANGLE_EDEFAULT;
            case DiagramInterchangePackage.ELLIPSE__END_ANGLE:
                return endAngle != END_ANGLE_EDEFAULT;
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
        result.append(" (center: "); //$NON-NLS-1$
        result.append(center);
        result.append(", radiusX: "); //$NON-NLS-1$
        result.append(radiusX);
        result.append(", radiusY: "); //$NON-NLS-1$
        result.append(radiusY);
        result.append(", rotation: "); //$NON-NLS-1$
        result.append(rotation);
        result.append(", startAngle: "); //$NON-NLS-1$
        result.append(startAngle);
        result.append(", endAngle: "); //$NON-NLS-1$
        result.append(endAngle);
        result.append(')');
        return result.toString();
    }

} // EllipseImpl
