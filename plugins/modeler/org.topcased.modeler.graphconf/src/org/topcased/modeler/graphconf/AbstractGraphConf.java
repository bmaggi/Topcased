/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractGraphConf.java,v 1.4 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getPresentation <em>Presentation</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultFont <em>Default Font</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getLineWidth <em>Line Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getLineStyle <em>Line Style</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getBridge <em>Bridge</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.AbstractGraphConf#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf()
 * @model abstract="true" annotation="http://www.topcased.org/documentation documentation='A DiagramGraphConf is
 *        associated with a DiagramConfiguration. It contains informations on the graphical representation of the
 *        diagram associated.'"
 * @generated
 */
public interface AbstractGraphConf extends EObject
{
    /**
     * Returns the value of the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Presentation</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Presentation</em>' attribute.
     * @see #setPresentation(String)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_Presentation()
     * @model
     * @generated
     */
    String getPresentation();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getPresentation <em>Presentation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Presentation</em>' attribute.
     * @see #getPresentation()
     * @generated
     */
    void setPresentation(String value);

    /**
     * Returns the value of the '<em><b>Default Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Foreground Color</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Foreground Color</em>' attribute.
     * @see #setDefaultForegroundColor(Color)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_DefaultForegroundColor()
     * @model dataType="org.topcased.modeler.graphconf.Color"
     * @generated
     */
    Color getDefaultForegroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultForegroundColor <em>Default Foreground Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Foreground Color</em>' attribute.
     * @see #getDefaultForegroundColor()
     * @generated
     */
    void setDefaultForegroundColor(Color value);

    /**
     * Returns the value of the '<em><b>Default Font</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Font</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Font</em>' attribute.
     * @see #setDefaultFont(Font)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_DefaultFont()
     * @model dataType="org.topcased.modeler.graphconf.Font"
     * @generated
     */
    Font getDefaultFont();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getDefaultFont <em>Default Font</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Font</em>' attribute.
     * @see #getDefaultFont()
     * @generated
     */
    void setDefaultFont(Font value);

    /**
     * Returns the value of the '<em><b>Line Width</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Width</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Line Width</em>' attribute.
     * @see #setLineWidth(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_LineWidth()
     * @model
     * @generated
     */
    int getLineWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getLineWidth <em>Line Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Line Width</em>' attribute.
     * @see #getLineWidth()
     * @generated
     */
    void setLineWidth(int value);

    /**
     * Returns the value of the '<em><b>Line Style</b></em>' attribute. The literals are from the enumeration
     * {@link org.topcased.modeler.graphconf.LineStyle}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Style</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Line Style</em>' attribute.
     * @see org.topcased.modeler.graphconf.LineStyle
     * @see #setLineStyle(LineStyle)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_LineStyle()
     * @model
     * @generated
     */
    LineStyle getLineStyle();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getLineStyle <em>Line Style</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Line Style</em>' attribute.
     * @see org.topcased.modeler.graphconf.LineStyle
     * @see #getLineStyle()
     * @generated
     */
    void setLineStyle(LineStyle value);

    /**
     * Returns the value of the '<em><b>Bridge</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bridge</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Bridge</em>' containment reference.
     * @see #setBridge(Bridge)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_Bridge()
     * @model containment="true" required="true"
     * @generated
     */
    Bridge getBridge();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.AbstractGraphConf#getBridge <em>Bridge</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Bridge</em>' containment reference.
     * @see #getBridge()
     * @generated
     */
    void setBridge(Bridge value);

    /**
     * Returns the value of the '<em><b>Constraint</b></em>' containment reference list. The list contents are of
     * type {@link org.topcased.modeler.graphconf.Constraint}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Constraint</em>' containment reference list.
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getAbstractGraphConf_Constraint()
     * @model type="org.topcased.modeler.graphconf.Constraint" containment="true"
     * @generated
     */
    EList getConstraint();

} // AbstractGraphConf
