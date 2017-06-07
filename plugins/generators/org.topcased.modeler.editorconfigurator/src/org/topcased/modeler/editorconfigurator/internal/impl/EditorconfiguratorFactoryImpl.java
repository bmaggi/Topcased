/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorconfiguratorFactoryImpl.java,v 1.4 2007/04/18 12:54:46 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.topcased.modeler.editorconfigurator.EditorAction;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorFactory;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorconfiguratorFactoryImpl extends EFactoryImpl implements EditorconfiguratorFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static EditorconfiguratorFactory init()
    {
        try
        {
            EditorconfiguratorFactory theEditorconfiguratorFactory = (EditorconfiguratorFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/editorconfigurator/0.10");
            if (theEditorconfiguratorFactory != null)
            {
                return theEditorconfiguratorFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EditorconfiguratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorconfiguratorFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION:
                return createEditorConfiguration();
            case EditorconfiguratorPackage.EDITOR_ACTION:
                return createEditorAction();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorConfiguration createEditorConfiguration()
    {
        EditorConfigurationImpl editorConfiguration = new EditorConfigurationImpl();
        return editorConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorAction createEditorAction()
    {
        EditorActionImpl editorAction = new EditorActionImpl();
        return editorAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorconfiguratorPackage getEditorconfiguratorPackage()
    {
        return (EditorconfiguratorPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EditorconfiguratorPackage getPackage()
    {
        return EditorconfiguratorPackage.eINSTANCE;
    }

} // EditorconfiguratorFactoryImpl
