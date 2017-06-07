/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorAction.java,v 1.1 2007/04/18 12:54:49 jako Exp $
 */
package org.topcased.modeler.editorconfigurator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editor Action</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorAction#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorAction#getMenuBarGroup <em>Menu Bar Group</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorAction#getLabel <em>Label</em>}</li>
 * <li>{@link org.topcased.modeler.editorconfigurator.EditorAction#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorAction()
 * @model
 * @generated
 */
public interface EditorAction extends EObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "";

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
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorAction_Prefix()
     * @model required="true"
     * @generated
     */
    String getPrefix();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorAction#getPrefix <em>Prefix</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix(String value);

    /**
     * Returns the value of the '<em><b>Menu Bar Group</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Menu Bar Group</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Menu Bar Group</em>' attribute.
     * @see #setMenuBarGroup(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorAction_MenuBarGroup()
     * @model required="true"
     * @generated
     */
    String getMenuBarGroup();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorAction#getMenuBarGroup <em>Menu Bar Group</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Menu Bar Group</em>' attribute.
     * @see #getMenuBarGroup()
     * @generated
     */
    void setMenuBarGroup(String value);

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorAction_Label()
     * @model required="true"
     * @generated
     */
    String getLabel();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorAction#getLabel <em>Label</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel(String value);

    /**
     * Returns the value of the '<em><b>Icon</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Icon</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Icon</em>' attribute.
     * @see #setIcon(String)
     * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage#getEditorAction_Icon()
     * @model
     * @generated
     */
    String getIcon();

    /**
     * Sets the value of the '{@link org.topcased.modeler.editorconfigurator.EditorAction#getIcon <em>Icon</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Icon</em>' attribute.
     * @see #getIcon()
     * @generated
     */
    void setIcon(String value);

} // EditorAction
