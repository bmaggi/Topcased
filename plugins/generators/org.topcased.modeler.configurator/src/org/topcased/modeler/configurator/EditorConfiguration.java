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

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getExtensionDiagram <em>Extension Diagram</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getGenModel <em>Gen Model</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.EditorConfiguration#getPluginVersion <em>Plugin Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='This is the root model object.'"
 *        annotation="http://www.topcased.org/uuid uuid='11319820411811'"
 * @generated
 */
public interface EditorConfiguration extends EObject{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_Name()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='11319820411834'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Project Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Project Name</em>' attribute.
     * @see #setProjectName(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_ProjectName()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='11319820411855'"
     * @generated
     */
    String getProjectName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getProjectName <em>Project Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Project Name</em>' attribute.
     * @see #getProjectName()
     * @generated
     */
    void setProjectName(String value);

    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_Prefix()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='11319820411856'"
     * @generated
     */
    String getPrefix();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getPrefix <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix(String value);

    /**
     * Returns the value of the '<em><b>Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extension</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Extension</em>' attribute.
     * @see #setExtension(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_Extension()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='11319820411867'"
     * @generated
     */
    String getExtension();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getExtension <em>Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Extension</em>' attribute.
     * @see #getExtension()
     * @generated
     */
    void setExtension(String value);

    /**
     * Returns the value of the '<em><b>Extension Diagram</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extension Diagram</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Extension Diagram</em>' attribute.
     * @see #setExtensionDiagram(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_ExtensionDiagram()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='11319820411878'"
     * @generated
     */
    String getExtensionDiagram();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getExtensionDiagram <em>Extension Diagram</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Extension Diagram</em>' attribute.
     * @see #getExtensionDiagram()
     * @generated
     */
    void setExtensionDiagram(String value);

    /**
     * Returns the value of the '<em><b>Gen Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gen Model</em>' reference.
     * @see #setGenModel(GenModel)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_GenModel()
     * @model required="true"
     *        annotation="http://www.topcased.org/uuid uuid='11319820411889'"
     * @generated
     */
    GenModel getGenModel();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getGenModel <em>Gen Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gen Model</em>' reference.
     * @see #getGenModel()
     * @generated
     */
    void setGenModel(GenModel value);

    /**
     * Returns the value of the '<em><b>Diagrams</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.DiagramConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagrams</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diagrams</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_Diagrams()
     * @model type="org.topcased.modeler.configurator.DiagramConfiguration" containment="true" required="true" ordered="false"
     *        annotation="http://www.topcased.org/uuid uuid='113198204118910'"
     * @generated
     */
    EList getDiagrams();

    /**
     * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
     * The list contents are of type {@link org.topcased.modeler.configurator.ObjectConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Objects</em>' containment reference list.
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_Objects()
     * @model type="org.topcased.modeler.configurator.ObjectConfiguration" containment="true" required="true" ordered="false"
     *        annotation="http://www.topcased.org/uuid uuid='113198204119011'"
     * @generated
     */
    EList getObjects();

    /**
     * Returns the value of the '<em><b>Plugin Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plugin Version</em>' attribute.
     * @see #setPluginVersion(String)
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#getEditorConfiguration_PluginVersion()
     * @model required="true"
     * @generated
     */
    String getPluginVersion();

    /**
     * Sets the value of the '{@link org.topcased.modeler.configurator.EditorConfiguration#getPluginVersion <em>Plugin Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plugin Version</em>' attribute.
     * @see #getPluginVersion()
     * @generated
     */
    void setPluginVersion(String value);

} // EditorConfiguration
