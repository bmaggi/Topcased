/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeGraphConf.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import org.eclipse.swt.graphics.Color;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Node Graph Conf</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultWidth <em>Default Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultHeight <em>Default Height</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getMinimumWidth <em>Minimum Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getMinimumHeight <em>Minimum Height</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getMaximumWidth <em>Maximum Width</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getMaximumHeight <em>Maximum Height</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#isIsWidthResizable <em>Is Width Resizable</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#isIsHeightResizable <em>Is Height Resizable</em>}</li>
 * <li>{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf()
 * @model annotation="http://www.topcased.org/documentation documentation='A NodeGraphConf is associated with a
 *        NodePartConfiguration. It gives informations on the graphical element.'"
 * @generated
 */
public interface NodeGraphConf extends AbstractGraphConf
{
    /**
     * Returns the value of the '<em><b>Default Width</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Width</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Width</em>' attribute.
     * @see #setDefaultWidth(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_DefaultWidth()
     * @model
     * @generated
     */
    int getDefaultWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultWidth <em>Default Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Width</em>' attribute.
     * @see #getDefaultWidth()
     * @generated
     */
    void setDefaultWidth(int value);

    /**
     * Returns the value of the '<em><b>Default Height</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Height</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Height</em>' attribute.
     * @see #setDefaultHeight(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_DefaultHeight()
     * @model
     * @generated
     */
    int getDefaultHeight();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultHeight <em>Default Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Height</em>' attribute.
     * @see #getDefaultHeight()
     * @generated
     */
    void setDefaultHeight(int value);

    /**
     * Returns the value of the '<em><b>Minimum Width</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum Width</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Minimum Width</em>' attribute.
     * @see #setMinimumWidth(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_MinimumWidth()
     * @model
     * @generated
     */
    int getMinimumWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMinimumWidth <em>Minimum Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Minimum Width</em>' attribute.
     * @see #getMinimumWidth()
     * @generated
     */
    void setMinimumWidth(int value);

    /**
     * Returns the value of the '<em><b>Minimum Height</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum Height</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Minimum Height</em>' attribute.
     * @see #setMinimumHeight(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_MinimumHeight()
     * @model
     * @generated
     */
    int getMinimumHeight();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMinimumHeight <em>Minimum Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Minimum Height</em>' attribute.
     * @see #getMinimumHeight()
     * @generated
     */
    void setMinimumHeight(int value);

    /**
     * Returns the value of the '<em><b>Maximum Width</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Width</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Maximum Width</em>' attribute.
     * @see #setMaximumWidth(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_MaximumWidth()
     * @model
     * @generated
     */
    int getMaximumWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMaximumWidth <em>Maximum Width</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Maximum Width</em>' attribute.
     * @see #getMaximumWidth()
     * @generated
     */
    void setMaximumWidth(int value);

    /**
     * Returns the value of the '<em><b>Maximum Height</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Height</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Maximum Height</em>' attribute.
     * @see #setMaximumHeight(int)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_MaximumHeight()
     * @model
     * @generated
     */
    int getMaximumHeight();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getMaximumHeight <em>Maximum Height</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Maximum Height</em>' attribute.
     * @see #getMaximumHeight()
     * @generated
     */
    void setMaximumHeight(int value);

    /**
     * Returns the value of the '<em><b>Is Width Resizable</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Width Resizable</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Is Width Resizable</em>' attribute.
     * @see #setIsWidthResizable(boolean)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_IsWidthResizable()
     * @model
     * @generated
     */
    boolean isIsWidthResizable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#isIsWidthResizable <em>Is Width Resizable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Is Width Resizable</em>' attribute.
     * @see #isIsWidthResizable()
     * @generated
     */
    void setIsWidthResizable(boolean value);

    /**
     * Returns the value of the '<em><b>Is Height Resizable</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Height Resizable</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Is Height Resizable</em>' attribute.
     * @see #setIsHeightResizable(boolean)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_IsHeightResizable()
     * @model
     * @generated
     */
    boolean isIsHeightResizable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#isIsHeightResizable <em>Is Height Resizable</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Is Height Resizable</em>' attribute.
     * @see #isIsHeightResizable()
     * @generated
     */
    void setIsHeightResizable(boolean value);

    /**
     * Returns the value of the '<em><b>Default Background Color</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Background Color</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Background Color</em>' attribute.
     * @see #setDefaultBackgroundColor(Color)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getNodeGraphConf_DefaultBackgroundColor()
     * @model dataType="org.topcased.modeler.graphconf.Color"
     * @generated
     */
    Color getDefaultBackgroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.NodeGraphConf#getDefaultBackgroundColor <em>Default Background Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Background Color</em>' attribute.
     * @see #getDefaultBackgroundColor()
     * @generated
     */
    void setDefaultBackgroundColor(Color value);

} // NodeGraphConf
