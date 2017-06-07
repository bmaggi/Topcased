/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ellipse.java,v 1.7 2007/04/12 08:31:49 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.draw2d.geometry.Point;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ellipse</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.Ellipse#getCenter <em>Center</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Ellipse#getRadiusX <em>Radius X</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Ellipse#getRadiusY <em>Radius Y</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Ellipse#getRotation <em>Rotation</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Ellipse#getStartAngle <em>Start Angle</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Ellipse#getEndAngle <em>End Angle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse()
 * @model
 * @generated
 */
public interface Ellipse extends GraphicPrimitive
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Center</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Center</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Center</em>' attribute.
     * @see #setCenter(Point)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse_Center()
     * @model dataType="org.topcased.modeler.di.model.Point"
     * @generated
     */
    Point getCenter();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Ellipse#getCenter <em>Center</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Center</em>' attribute.
     * @see #getCenter()
     * @generated
     */
    void setCenter(Point value);

    /**
     * Returns the value of the '<em><b>Radius X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Radius X</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Radius X</em>' attribute.
     * @see #setRadiusX(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse_RadiusX()
     * @model
     * @generated
     */
    double getRadiusX();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Ellipse#getRadiusX <em>Radius X</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Radius X</em>' attribute.
     * @see #getRadiusX()
     * @generated
     */
    void setRadiusX(double value);

    /**
     * Returns the value of the '<em><b>Radius Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Radius Y</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Radius Y</em>' attribute.
     * @see #setRadiusY(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse_RadiusY()
     * @model
     * @generated
     */
    double getRadiusY();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Ellipse#getRadiusY <em>Radius Y</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Radius Y</em>' attribute.
     * @see #getRadiusY()
     * @generated
     */
    void setRadiusY(double value);

    /**
     * Returns the value of the '<em><b>Rotation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rotation</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rotation</em>' attribute.
     * @see #setRotation(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse_Rotation()
     * @model
     * @generated
     */
    double getRotation();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Ellipse#getRotation <em>Rotation</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Rotation</em>' attribute.
     * @see #getRotation()
     * @generated
     */
    void setRotation(double value);

    /**
     * Returns the value of the '<em><b>Start Angle</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Angle</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Angle</em>' attribute.
     * @see #setStartAngle(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse_StartAngle()
     * @model
     * @generated
     */
    double getStartAngle();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Ellipse#getStartAngle <em>Start Angle</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Angle</em>' attribute.
     * @see #getStartAngle()
     * @generated
     */
    void setStartAngle(double value);

    /**
     * Returns the value of the '<em><b>End Angle</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Angle</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End Angle</em>' attribute.
     * @see #setEndAngle(double)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEllipse_EndAngle()
     * @model
     * @generated
     */
    double getEndAngle();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Ellipse#getEndAngle <em>End Angle</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>End Angle</em>' attribute.
     * @see #getEndAngle()
     * @generated
     */
    void setEndAngle(double value);

} // Ellipse
