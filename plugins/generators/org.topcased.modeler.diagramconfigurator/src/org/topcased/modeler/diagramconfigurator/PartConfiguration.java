/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartConfiguration.java,v 1.10 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Part Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getObject <em>Object</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getPresentation <em>Presentation</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#isForegroundColorChangeable <em>Foreground Color Changeable</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultFont <em>Default Font</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#isFontChangeable <em>Font Changeable</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineWidth <em>Line Width</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineStyle <em>Line Style</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getConstraint <em>Constraint</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration()
 * @model abstract="true" annotation="http://www.topcased.org/documentation documentation='A PartConfiguration will be
 *        associated with an EditPart at the generation process.'"
 * @generated
 */
public interface PartConfiguration extends EObject
{
    /**
     * Returns the value of the '<em><b>Object</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Object</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Object</em>' reference.
     * @see #setObject(ObjectConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_Object()
     * @model required="true"
     * @generated
     */
    ObjectConfiguration getObject();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getObject <em>Object</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Object</em>' reference.
     * @see #getObject()
     * @generated
     */
    void setObject(ObjectConfiguration value);

    /**
     * Returns the value of the '<em><b>Presentation</b></em>' attribute. The default value is
     * <code>"default"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Presentation</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Presentation</em>' attribute.
     * @see #setPresentation(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_Presentation()
     * @model default="default" required="true"
     * @generated
     */
    String getPresentation();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getPresentation <em>Presentation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Presentation</em>' attribute.
     * @see #getPresentation()
     * @generated
     */
    void setPresentation(String value);

    /**
     * Returns the value of the '<em><b>Default Foreground Color</b></em>' attribute. The default value is
     * <code>"0,0,0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Foreground Color</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Foreground Color</em>' attribute.
     * @see #setDefaultForegroundColor(Color)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_DefaultForegroundColor()
     * @model default="0,0,0" dataType="org.topcased.modeler.diagramconfigurator.Color"
     * @generated
     */
    Color getDefaultForegroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Foreground Color</em>' attribute.
     * @see #getDefaultForegroundColor()
     * @generated
     */
    void setDefaultForegroundColor(Color value);

    /**
     * Returns the value of the '<em><b>Foreground Color Changeable</b></em>' attribute. The default value is
     * <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreground Color Changeable</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Foreground Color Changeable</em>' attribute.
     * @see #setForegroundColorChangeable(boolean)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_ForegroundColorChangeable()
     * @model default="true"
     * @generated
     */
    boolean isForegroundColorChangeable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#isForegroundColorChangeable <em>Foreground Color Changeable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Foreground Color Changeable</em>' attribute.
     * @see #isForegroundColorChangeable()
     * @generated
     */
    void setForegroundColorChangeable(boolean value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_DefaultFont()
     * @model dataType="org.topcased.modeler.diagramconfigurator.Font"
     * @generated
     */
    Font getDefaultFont();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getDefaultFont <em>Default Font</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Font</em>' attribute.
     * @see #getDefaultFont()
     * @generated
     */
    void setDefaultFont(Font value);

    /**
     * Returns the value of the '<em><b>Font Changeable</b></em>' attribute. The default value is
     * <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Font Changeable</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Font Changeable</em>' attribute.
     * @see #setFontChangeable(boolean)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_FontChangeable()
     * @model default="true"
     * @generated
     */
    boolean isFontChangeable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#isFontChangeable <em>Font Changeable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Font Changeable</em>' attribute.
     * @see #isFontChangeable()
     * @generated
     */
    void setFontChangeable(boolean value);

    /**
     * Returns the value of the '<em><b>Line Width</b></em>' attribute. The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Width</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Line Width</em>' attribute.
     * @see #setLineWidth(int)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_LineWidth()
     * @model default="1"
     * @generated
     */
    int getLineWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineWidth <em>Line Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Line Width</em>' attribute.
     * @see #getLineWidth()
     * @generated
     */
    void setLineWidth(int value);

    /**
     * Returns the value of the '<em><b>Line Style</b></em>' attribute. The default value is <code>"SOLID"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.diagramconfigurator.LineStyle}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Style</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Line Style</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.LineStyle
     * @see #setLineStyle(LineStyle)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_LineStyle()
     * @model default="SOLID"
     * @generated
     */
    LineStyle getLineStyle();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getLineStyle <em>Line Style</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Line Style</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.LineStyle
     * @see #getLineStyle()
     * @generated
     */
    void setLineStyle(LineStyle value);

    /**
     * Returns the value of the '<em><b>Constraint</b></em>' containment reference list. The list contents are of
     * type {@link org.topcased.modeler.diagramconfigurator.Constraint}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Constraint</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_Constraint()
     * @model containment="true"
     * @generated
     */
    EList<Constraint> getConstraint();

    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_Prefix()
     * @model required="true"
     * @generated
     */
    String getPrefix();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration#getPrefix <em>Prefix</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix(String value);

    /**
     * Returns the value of the '<em><b>Actions</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.diagramconfigurator.PartAction}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Actions</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Actions</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getPartConfiguration_Actions()
     * @model containment="true"
     * @generated
     */
    EList<PartAction> getActions();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    boolean isAbstract();

    /**
     * Get the String value representing the DefaultForegroundColor
     */
    String getDefaultForegroundColorStringValue();

    /**
     * Get the String value representing the DefaultFont
     */
    String getDefaultFontStringValue();

} // PartConfiguration
