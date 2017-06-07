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
package org.topcased.modeler.configurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Part Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getChildElements <em>Child Elements</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#isBackgroundColorChangeable <em>Background Color Changeable</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getResizing <em>Resizing</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#isContainer <em>Container</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#isDirectEditable <em>Direct Editable</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultWidth <em>Default Width</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultHeight <em>Default Height</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getMinimumWidth <em>Minimum Width</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getMinimumHeight <em>Minimum Height</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getMaximumWidth <em>Maximum Width</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.NodePartConfiguration#getMaximumHeight <em>Maximum Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A PartConfiguration will be associated with a NodeEditPart at the generation process.'"
 *        annotation="http://www.topcased.org/uuid uuid='113198204122046'"
 * @generated
 */
public interface NodePartConfiguration extends PartConfiguration{
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The default value is <code>"Figure"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_Type()
     * @model default="Figure"
     *        annotation="http://www.topcased.org/uuid uuid='113198204122149'"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Child Elements</b></em>' reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.NodePartConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Elements</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Elements</em>' reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_ChildElements()
     * @model type="org.topcased.modeler.configurator.NodePartConfiguration"
     *        annotation="http://www.topcased.org/uuid uuid='113198204122250'"
     * @generated
     */
    EList getChildElements();

    /**
     * Returns the value of the '<em><b>Super Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Super Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Super Type</em>' reference.
     * @see #setSuperType(NodePartConfiguration)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_SuperType()
     * @model annotation="http://www.topcased.org/uuid uuid='113198204122351'"
     * @generated
     */
    NodePartConfiguration getSuperType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getSuperType <em>Super Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Super Type</em>' reference.
     * @see #getSuperType()
     * @generated
     */
    void setSuperType(NodePartConfiguration value);

    /**
     * Returns the value of the '<em><b>Default Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Width</em>' attribute.
     * @see #setDefaultWidth(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_DefaultWidth()
     * @model
     * @generated
     */
    int getDefaultWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultWidth <em>Default Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Width</em>' attribute.
     * @see #getDefaultWidth()
     * @generated
     */
    void setDefaultWidth(int value);

    /**
     * Returns the value of the '<em><b>Default Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Height</em>' attribute.
     * @see #setDefaultHeight(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_DefaultHeight()
     * @model
     * @generated
     */
    int getDefaultHeight();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultHeight <em>Default Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Height</em>' attribute.
     * @see #getDefaultHeight()
     * @generated
     */
    void setDefaultHeight(int value);

    /**
     * Returns the value of the '<em><b>Minimum Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum Width</em>' attribute.
     * @see #setMinimumWidth(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_MinimumWidth()
     * @model
     * @generated
     */
    int getMinimumWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMinimumWidth <em>Minimum Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum Width</em>' attribute.
     * @see #getMinimumWidth()
     * @generated
     */
    void setMinimumWidth(int value);

    /**
     * Returns the value of the '<em><b>Minimum Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum Height</em>' attribute.
     * @see #setMinimumHeight(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_MinimumHeight()
     * @model
     * @generated
     */
    int getMinimumHeight();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMinimumHeight <em>Minimum Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum Height</em>' attribute.
     * @see #getMinimumHeight()
     * @generated
     */
    void setMinimumHeight(int value);

    /**
     * Returns the value of the '<em><b>Maximum Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum Width</em>' attribute.
     * @see #setMaximumWidth(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_MaximumWidth()
     * @model
     * @generated
     */
    int getMaximumWidth();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMaximumWidth <em>Maximum Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum Width</em>' attribute.
     * @see #getMaximumWidth()
     * @generated
     */
    void setMaximumWidth(int value);

    /**
     * Returns the value of the '<em><b>Maximum Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum Height</em>' attribute.
     * @see #setMaximumHeight(int)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_MaximumHeight()
     * @model
     * @generated
     */
    int getMaximumHeight();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getMaximumHeight <em>Maximum Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum Height</em>' attribute.
     * @see #getMaximumHeight()
     * @generated
     */
    void setMaximumHeight(int value);

    /**
     * Returns the value of the '<em><b>Default Background Color</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Background Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Background Color</em>' attribute.
     * @see #setDefaultBackgroundColor(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_DefaultBackgroundColor()
     * @model default=""
     *        annotation="http://www.topcased.org/uuid uuid='113198204122554'"
     * @generated
     */
    String getDefaultBackgroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Background Color</em>' attribute.
     * @see #getDefaultBackgroundColor()
     * @generated
     */
    void setDefaultBackgroundColor(String value);

    /**
     * Returns the value of the '<em><b>Background Color Changeable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background Color Changeable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background Color Changeable</em>' attribute.
     * @see #setBackgroundColorChangeable(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_BackgroundColorChangeable()
     * @model default="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204122655'"
     * @generated
     */
    boolean isBackgroundColorChangeable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#isBackgroundColorChangeable <em>Background Color Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Color Changeable</em>' attribute.
     * @see #isBackgroundColorChangeable()
     * @generated
     */
    void setBackgroundColorChangeable(boolean value);

    /**
     * Returns the value of the '<em><b>Resizing</b></em>' attribute.
     * The default value is <code>"ALL"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.ResizableType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resizing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resizing</em>' attribute.
     * @see org.topcased.modeler.configurator.ResizableType
     * @see #setResizing(ResizableType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_Resizing()
     * @model default="ALL"
     *        annotation="http://www.topcased.org/uuid uuid='113198204122756'"
     * @generated
     */
    ResizableType getResizing();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getResizing <em>Resizing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Resizing</em>' attribute.
     * @see org.topcased.modeler.configurator.ResizableType
     * @see #getResizing()
     * @generated
     */
    void setResizing(ResizableType value);

    /**
     * Returns the value of the '<em><b>Container</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' attribute.
     * @see #setContainer(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_Container()
     * @model default="false"
     *        annotation="http://www.topcased.org/uuid uuid='113198204122857'"
     * @generated
     */
    boolean isContainer();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#isContainer <em>Container</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' attribute.
     * @see #isContainer()
     * @generated
     */
    void setContainer(boolean value);

    /**
     * Returns the value of the '<em><b>Direct Editable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Direct Editable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Direct Editable</em>' attribute.
     * @see #setDirectEditable(boolean)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_DirectEditable()
     * @model default="true"
     *        annotation="http://www.topcased.org/uuid uuid='113198204123059'"
     * @generated
     */
    boolean isDirectEditable();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#isDirectEditable <em>Direct Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Direct Editable</em>' attribute.
     * @see #isDirectEditable()
     * @generated
     */
    void setDirectEditable(boolean value);

    /**
     * Returns the value of the '<em><b>Layout</b></em>' attribute.
     * The default value is <code>"XYLayout"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.configurator.LayoutType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Layout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Layout</em>' attribute.
     * @see org.topcased.modeler.configurator.LayoutType
     * @see #setLayout(LayoutType)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getNodePartConfiguration_Layout()
     * @model default="XYLayout"
     *        annotation="http://www.topcased.org/uuid uuid='113198204122958'"
     * @generated
     */
    LayoutType getLayout();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.NodePartConfiguration#getLayout <em>Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Layout</em>' attribute.
     * @see org.topcased.modeler.configurator.LayoutType
     * @see #getLayout()
     * @generated
     */
    void setLayout(LayoutType value);

    /**
     * Check if a nodePartConfiguration is connectable in a diagram
     * 
     * @return true if at least one edge may be connected to the
     *         nodePartConfiguration
     */
    boolean isConnectable();
    
    /**
     * Get the FeatureID of the first feature of the GenClass asosciated with
     * the current NodePartConfiguration (if it exists). The type of the feature
     * should match with the type of the passed GenClass.
     * 
     * @param childGenClass a type of GenClass to match
     * @return the FeatureID as a String if one is found. Return null otherwise.
     */
    String getFeatureID(GenClass childGenClass);
    
} // NodePartConfiguration
