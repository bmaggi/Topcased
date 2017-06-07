/**
 * <copyright> </copyright>
 * 
 * $Id: DiagramConfiguration.java,v 1.19 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Diagram Configuration</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPackage <em>Package</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPalette <em>Palette</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getParts <em>Parts</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getLayout <em>Layout</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getObjects <em>Objects</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getGenModel <em>Gen Model</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultFont <em>Default Font</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getTemplateRootObject <em>Template Root Object</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isForceOverwrite <em>Force Overwrite</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOverwriteGraphConf <em>Overwrite Graph Conf</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOrganizeImports <em>Organize Imports</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getEditorConfigurator <em>Editor Configurator</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getCopyrightText <em>Copyright Text</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPluginVersion <em>Plugin Version</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProvider <em>Provider</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isSamePluginAsEditor <em>Same Plugin As Editor</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='A DiagramConfiguration contains informations
 *        used to generate a Diagram'" annotation="http://www.eclipse.org/emf/2002/Ecore constraints='Prefix Package
 *        PartsPrefixUnicity ObjectsNameUnicity'"
 * @generated
 */
public interface DiagramConfiguration extends EObject
{
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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_ProjectName()
     * @model required="true" extendedMetaData="name='id' kind='attribute'"
     * @generated
     */
    String getProjectName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProjectName <em>Project Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Project Name</em>' attribute.
     * @see #getProjectName()
     * @generated
     */
    void setProjectName(String value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Package</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Package</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Package</em>' attribute.
     * @see #setPackage(String)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Package()
     * @model required="true"
     * @generated
     */
    String getPackage();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPackage <em>Package</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Package</em>' attribute.
     * @see #getPackage()
     * @generated
     */
    void setPackage(String value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Prefix()
     * @model required="true"
     * @generated
     */
    String getPrefix();

    /**
     * Return the prefix of the Plugin.java file that should be associated with the diagram. If the diagram is generated
     * in the same plugin as the editor, then the Activator class is the one provided by the editor, and so the prefix
     * is retrieved from the editor configuration.
     * 
     * @return String
     */
    String getPluginPrefix();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPrefix <em>Prefix</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix(String value);

    /**
     * Returns the value of the '<em><b>Palette</b></em>' containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Palette</em>' containment reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Palette</em>' containment reference.
     * @see #setPalette(PaletteConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Palette()
     * @model containment="true" required="true"
     * @generated
     */
    PaletteConfiguration getPalette();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPalette <em>Palette</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Palette</em>' containment reference.
     * @see #getPalette()
     * @generated
     */
    void setPalette(PaletteConfiguration value);

    /**
     * Returns the value of the '<em><b>Parts</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.diagramconfigurator.PartConfiguration}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parts</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parts</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Parts()
     * @model containment="true" required="true"
     * @generated
     */
    EList<PartConfiguration> getParts();

    /**
     * Returns the value of the '<em><b>Layout</b></em>' attribute. The default value is <code>"XYLayout"</code>.
     * The literals are from the enumeration {@link org.topcased.modeler.diagramconfigurator.LayoutType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Layout</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Layout</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.LayoutType
     * @see #setLayout(LayoutType)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Layout()
     * @model default="XYLayout"
     * @generated
     */
    LayoutType getLayout();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getLayout <em>Layout</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Layout</em>' attribute.
     * @see org.topcased.modeler.diagramconfigurator.LayoutType
     * @see #getLayout()
     * @generated
     */
    void setLayout(LayoutType value);

    /**
     * Returns the value of the '<em><b>Objects</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.modeler.diagramconfigurator.ObjectConfiguration}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Objects</em>' containment reference list isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Objects</em>' containment reference list.
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Objects()
     * @model containment="true" required="true"
     * @generated
     */
    EList<ObjectConfiguration> getObjects();

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_GenModel()
     * @model required="true"
     * @generated
     */
    GenModel getGenModel();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getGenModel <em>Gen Model</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Gen Model</em>' reference.
     * @see #getGenModel()
     * @generated
     */
    void setGenModel(GenModel value);

    /**
     * Returns the value of the '<em><b>Default Background Color</b></em>' attribute. The default value is
     * <code>"255,255,255"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Background Color</em>' attribute isn't clear, there really should be more
     * of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Background Color</em>' attribute.
     * @see #setDefaultBackgroundColor(Color)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_DefaultBackgroundColor()
     * @model default="255,255,255" dataType="org.topcased.modeler.diagramconfigurator.Color"
     * @generated
     */
    Color getDefaultBackgroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultBackgroundColor <em>Default Background Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Background Color</em>' attribute.
     * @see #getDefaultBackgroundColor()
     * @generated
     */
    void setDefaultBackgroundColor(Color value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_DefaultForegroundColor()
     * @model default="0,0,0" dataType="org.topcased.modeler.diagramconfigurator.Color"
     * @generated
     */
    Color getDefaultForegroundColor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultForegroundColor <em>Default Foreground Color</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Foreground Color</em>' attribute.
     * @see #getDefaultForegroundColor()
     * @generated
     */
    void setDefaultForegroundColor(Color value);

    /**
     * Returns the value of the '<em><b>Default Font</b></em>' attribute. The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Font</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Font</em>' attribute.
     * @see #setDefaultFont(Font)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_DefaultFont()
     * @model default="" dataType="org.topcased.modeler.diagramconfigurator.Font"
     * @generated
     */
    Font getDefaultFont();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getDefaultFont <em>Default Font</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Default Font</em>' attribute.
     * @see #getDefaultFont()
     * @generated
     */
    void setDefaultFont(Font value);

    /**
     * Returns the value of the '<em><b>Template Root Object</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template Root Object</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Template Root Object</em>' reference.
     * @see #setTemplateRootObject(GenClass)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_TemplateRootObject()
     * @model required="true"
     * @generated
     */
    GenClass getTemplateRootObject();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getTemplateRootObject <em>Template Root Object</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Template Root Object</em>' reference.
     * @see #getTemplateRootObject()
     * @generated
     */
    void setTemplateRootObject(GenClass value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_ForceOverwrite()
     * @model default="false" required="true"
     * @generated
     */
    boolean isForceOverwrite();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isForceOverwrite <em>Force Overwrite</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Force Overwrite</em>' attribute.
     * @see #isForceOverwrite()
     * @generated
     */
    void setForceOverwrite(boolean value);

    /**
     * Returns the value of the '<em><b>Overwrite Graph Conf</b></em>' attribute. The default value is
     * <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Overwrite Graph Conf</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Overwrite Graph Conf</em>' attribute.
     * @see #setOverwriteGraphConf(boolean)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_OverwriteGraphConf()
     * @model default="true" required="true"
     * @generated
     */
    boolean isOverwriteGraphConf();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOverwriteGraphConf <em>Overwrite Graph Conf</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Overwrite Graph Conf</em>' attribute.
     * @see #isOverwriteGraphConf()
     * @generated
     */
    void setOverwriteGraphConf(boolean value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_OrganizeImports()
     * @model default="true" required="true"
     * @generated
     */
    boolean isOrganizeImports();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isOrganizeImports <em>Organize Imports</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Organize Imports</em>' attribute.
     * @see #isOrganizeImports()
     * @generated
     */
    void setOrganizeImports(boolean value);

    /**
     * Returns the value of the '<em><b>Editor Configurator</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Editor Configurator</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Editor Configurator</em>' reference.
     * @see #setEditorConfigurator(EditorConfiguration)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_EditorConfigurator()
     * @model required="true"
     * @generated
     */
    EditorConfiguration getEditorConfigurator();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getEditorConfigurator <em>Editor Configurator</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editor Configurator</em>' reference.
     * @see #getEditorConfigurator()
     * @generated
     */
    void setEditorConfigurator(EditorConfiguration value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_CopyrightText()
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
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getCopyrightText <em>Copyright Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Copyright Text</em>' attribute.
     * @see #getCopyrightText()
     * @generated
     */
    void setCopyrightText(String value);

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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_PluginVersion()
     * @model required="true"
     * @generated
     */
    String getPluginVersion();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getPluginVersion <em>Plugin Version</em>}'
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
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_Provider()
     * @model default="Topcased" required="true"
     * @generated
     */
    String getProvider();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#getProvider <em>Provider</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Provider</em>' attribute.
     * @see #getProvider()
     * @generated
     */
    void setProvider(String value);

    /**
     * Returns the value of the '<em><b>Same Plugin As Editor</b></em>' attribute. The default value is
     * <code>"false"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Same Plugin As Editor</em>' attribute isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Same Plugin As Editor</em>' attribute.
     * @see #setSamePluginAsEditor(boolean)
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#getDiagramConfiguration_SamePluginAsEditor()
     * @model default="false" required="true"
     * @generated
     */
    boolean isSamePluginAsEditor();

    /**
     * Sets the value of the '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration#isSamePluginAsEditor <em>Same Plugin As Editor</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Same Plugin As Editor</em>' attribute.
     * @see #isSamePluginAsEditor()
     * @generated
     */
    void setSamePluginAsEditor(boolean value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     * @generated
     */
    String getBasePackage();

    // -------------------------------------------------------------
    // These methods ensure compatibility with the old configurator
    // -------------------------------------------------------------

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
     * Return the String that represent the IPath of the diagram.graphconf relative to the Plugin
     * 
     * @return String the IPath string value to retrieve the diagram.graphconf file
     */
    String getGraphConfIPath();

    // ------------------------------------------------------------
    // Utilities methods. These methods are used in the templates.
    // ------------------------------------------------------------

    /**
     * Get the list of all the model objects that are referenced by Parts.
     * 
     * @param nodeFilter Specify whether the NodePartConfiguration should be included
     * @param edgeFilter Specify whether the EdgePartConfiguration should be included
     * 
     * @return the list of Unique ModelObjectConfiguration that are referenced among the different Parts of the Diagram
     */
    List<ModelObjectConfiguration> getUniqueModelObjectConfList(boolean nodeFilter, boolean edgeFilter);

    /**
     * Get the list of all the model objects referenced by the different PaletteItem of the PaletteConfiguration.
     * 
     * @param nodeFilter Specify whether the NodePartConfiguration should be included
     * @param edgeFilter Specify whether the EdgePartConfiguration should be included
     * 
     * @return the list of Unique ModelObjectConfiguration that are referenced among the different PaletteItem of the
     *         PaletteConfiguration of the Diagram.
     */
    List<ModelObjectConfiguration> getUniqueModelObjectConfListFromPalette(boolean nodeFilter, boolean edgeFilter);

    /**
     * Get the String value representing the DefaultBackgroundColor
     */
    String getDefaultBackgroundColorStringValue();

    /**
     * Get the String value representing the DefaultForegroundColor
     */
    String getDefaultForegroundColorStringValue();

    /**
     * Get the String value representing the DefaultFont
     */
    String getDefaultFontStringValue();

    /**
     * Get the list of all the actions that are defined in the PartConfiguration elements of this DiagramConfiguration
     * 
     * @return the list of PartActions defined in this Diagram
     */
    List<PartAction> getPartActions();

} // DiagramConfiguration
