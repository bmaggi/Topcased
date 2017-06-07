/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorconfiguratorFactory.java,v 1.4 2007/04/18 12:54:49 jako Exp $
 */
package org.topcased.modeler.editorconfigurator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage
 * @generated
 */
public interface EditorconfiguratorFactory extends EFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "";

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EditorconfiguratorFactory eINSTANCE = org.topcased.modeler.editorconfigurator.internal.impl.EditorconfiguratorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Editor Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Editor Configuration</em>'.
     * @generated
     */
    EditorConfiguration createEditorConfiguration();

    /**
     * Returns a new object of class '<em>Editor Action</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Editor Action</em>'.
     * @generated
     */
    EditorAction createEditorAction();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    EditorconfiguratorPackage getEditorconfiguratorPackage();

} // EditorconfiguratorFactory
