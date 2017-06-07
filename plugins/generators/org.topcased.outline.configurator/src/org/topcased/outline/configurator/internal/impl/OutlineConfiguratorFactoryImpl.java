/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorFactoryImpl.java,v 1.1 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.topcased.outline.configurator.ChildActionType;
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.Menu;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorFactory;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OutlineConfiguratorFactoryImpl extends EFactoryImpl implements OutlineConfiguratorFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static OutlineConfiguratorFactory init()
    {
        try
        {
            OutlineConfiguratorFactory theOutlineConfiguratorFactory = (OutlineConfiguratorFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/OutlineConfigurator/1.0"); //$NON-NLS-1$ 
            if (theOutlineConfiguratorFactory != null)
            {
                return theOutlineConfiguratorFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OutlineConfiguratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguratorFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION:
                return createOutlineConfiguration();
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION:
                return createCreateChildMenuConfiguration();
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION:
                return createCreateChildAction();
            case OutlineConfiguratorPackage.MENU:
                return createMenu();
            case OutlineConfiguratorPackage.MENU_GROUP:
                return createMenuGroup();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object createFromString(EDataType eDataType, String initialValue)
    {
        switch (eDataType.getClassifierID())
        {
            case OutlineConfiguratorPackage.CHILD_ACTION_TYPE:
                return createChildActionTypeFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertToString(EDataType eDataType, Object instanceValue)
    {
        switch (eDataType.getClassifierID())
        {
            case OutlineConfiguratorPackage.CHILD_ACTION_TYPE:
                return convertChildActionTypeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguration createOutlineConfiguration()
    {
        OutlineConfigurationImpl outlineConfiguration = new OutlineConfigurationImpl();
        return outlineConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CreateChildMenuConfiguration createCreateChildMenuConfiguration()
    {
        CreateChildMenuConfigurationImpl createChildMenuConfiguration = new CreateChildMenuConfigurationImpl();
        return createChildMenuConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CreateChildAction createCreateChildAction()
    {
        CreateChildActionImpl createChildAction = new CreateChildActionImpl();
        return createChildAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Menu createMenu()
    {
        MenuImpl menu = new MenuImpl();
        return menu;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MenuGroup createMenuGroup()
    {
        MenuGroupImpl menuGroup = new MenuGroupImpl();
        return menuGroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ChildActionType createChildActionTypeFromString(EDataType eDataType, String initialValue)
    {
        ChildActionType result = ChildActionType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertChildActionTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguratorPackage getOutlineConfiguratorPackage()
    {
        return (OutlineConfiguratorPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    public static OutlineConfiguratorPackage getPackage()
    {
        return OutlineConfiguratorPackage.eINSTANCE;
    }

} // OutlineConfiguratorFactoryImpl
