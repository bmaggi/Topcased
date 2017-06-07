/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorConfiguration.java,v 1.8 2007/04/18 12:54:48 jako Exp $
 */
package org.topcased.modeler.editorconfigurator;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editor Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getGenModel <em>Gen Model</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getPluginVersion <em>Plugin Version</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getProvider <em>Provider</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#isForceOverwrite <em>Force Overwrite</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#isOrganizeImports <em>Organize Imports</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getCopyrightText <em>Copyright Text</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='This is the root model object.'"
 * @generated
 */
public interface EditorConfiguration extends EObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "";

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Project Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Project Name</em>' attribute.
     * @see #setProjectName(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_ProjectName()
     * @model required="true"
     * @generated
     */
    String getProjectName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getProjectName <em>Project Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Project Name</em>' attribute.
     * @see #getProjectName()
     * @generated
     */
    void setProjectName(String value);

    /**
     * Returns the value of the '<em><b>Gen Model</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Model</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Gen Model</em>' reference.
     * @see #setGenModel(GenModel)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_GenModel()
     * @model required="true"
     * @generated
     */
    GenModel getGenModel();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getGenModel <em>Gen Model</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Gen Model</em>' reference.
     * @see #getGenModel()
     * @generated
     */
    void setGenModel(GenModel value);

    /**
     * Returns the value of the '<em><b>Plugin Version</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin Version</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Plugin Version</em>' attribute.
     * @see #setPluginVersion(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_PluginVersion()
     * @model required="true"
     * @generated
     */
    String getPluginVersion();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getPluginVersion <em>Plugin Version</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Plugin Version</em>' attribute.
     * @see #getPluginVersion()
     * @generated
     */
    void setPluginVersion(String value);

    /**
     * Returns the value of the '<em><b>Provider</b></em>' attribute. The default value is <code>"Topcased"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Provider</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Provider</em>' attribute.
     * @see #setProvider(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_Provider()
     * @model default="Topcased" required="true"
     * @generated
     */
    String getProvider();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getProvider <em>Provider</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Provider</em>' attribute.
     * @see #getProvider()
     * @generated
     */
    void setProvider(String value);

    /**
     * Returns the value of the '<em><b>Force Overwrite</b></em>' attribute. The default value is
     * <code>"false"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Force Overwrite</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Force Overwrite</em>' attribute.
     * @see #setForceOverwrite(boolean)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_ForceOverwrite()
     * @model default="false" required="true"
     * @generated
     */
    boolean isForceOverwrite();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#isForceOverwrite <em>Force Overwrite</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Force Overwrite</em>' attribute.
     * @see #isForceOverwrite()
     * @generated
     */
    void setForceOverwrite(boolean value);

    /**
     * Returns the value of the '<em><b>Organize Imports</b></em>' attribute. The default value is
     * <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Organize Imports</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Organize Imports</em>' attribute.
     * @see #setOrganizeImports(boolean)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_OrganizeImports()
     * @model default="true" required="true"
     * @generated
     */
    boolean isOrganizeImports();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#isOrganizeImports <em>Organize Imports</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Organize Imports</em>' attribute.
     * @see #isOrganizeImports()
     * @generated
     */
    void setOrganizeImports(boolean value);

    /**
     * Returns the value of the '<em><b>Copyright Text</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Copyright Text</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Copyright Text</em>' attribute.
     * @see #setCopyrightText(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_CopyrightText()
     * @model
     * @generated
     */
    String getCopyrightText();

    /**
     * Return the copyright as the Java format. The corresponding <code>*</code> characters are added.
     * 
     * @return String the copyright that could be directly added in a java file
     */
    String getJavaCopyrightText();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorConfiguration#getCopyrightText <em>Copyright Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Copyright Text</em>' attribute.
     * @see #getCopyrightText()
     * @generated
     */
    void setCopyrightText(String value);

    /**
     * Returns the value of the '<em><b>Actions</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.editorconfigurator.EditorAction}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Actions</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Actions</em>' containment reference list.
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorConfiguration_Actions()
     * @model type="org.topcased.modeler.editorconfigurator.EditorAction" containment="true"
     * @generated
     */
    EList<EditorAction> getActions();

    // -------------------------------------------------------------
    // These methods ensure compatibility with the old configurator
    // -------------------------------------------------------------

    /**
     * Return the Prefix to use for the generated classes
     * 
     * @return String the prefix
     */
    String getPrefix();

    /**
     * Return the extension to use for the model file in the editor
     * 
     * @return String the extension of the model file
     */
    String getExtension();

    /**
     * Return the extension to use for the diagram file in the editor
     * 
     * @return String the extension of the diagram file
     */
    String getExtensionDiagram();

    /**
     * Retrieve the EditorID from the projectName and the prefix.
     * 
     * @return String the editorID
     */
    String getEditorId();

} // EditorConfiguration
