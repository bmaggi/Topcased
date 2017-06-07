/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorSwitch.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.Menu;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.MenuItem;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage
 * @generated
 */
public class OutlineConfiguratorSwitch
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static OutlineConfiguratorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguratorSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = OutlineConfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public Object doSwitch(EObject theEObject)
    {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(EClass theEClass, EObject theEObject)
    {
        if (theEClass.eContainer() == modelPackage)
        {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else
        {
            List eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION: {
                OutlineConfiguration outlineConfiguration = (OutlineConfiguration) theEObject;
                Object result = caseOutlineConfiguration(outlineConfiguration);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OutlineConfiguratorPackage.CREATE_CHILD_MENU_CONFIGURATION: {
                CreateChildMenuConfiguration createChildMenuConfiguration = (CreateChildMenuConfiguration) theEObject;
                Object result = caseCreateChildMenuConfiguration(createChildMenuConfiguration);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION: {
                CreateChildAction createChildAction = (CreateChildAction) theEObject;
                Object result = caseCreateChildAction(createChildAction);
                if (result == null)
                    result = caseMenuItem(createChildAction);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OutlineConfiguratorPackage.MENU: {
                Menu menu = (Menu) theEObject;
                Object result = caseMenu(menu);
                if (result == null)
                    result = caseMenuGroup(menu);
                if (result == null)
                    result = caseMenuItem(menu);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OutlineConfiguratorPackage.MENU_ITEM: {
                MenuItem menuItem = (MenuItem) theEObject;
                Object result = caseMenuItem(menuItem);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OutlineConfiguratorPackage.MENU_GROUP: {
                MenuGroup menuGroup = (MenuGroup) theEObject;
                Object result = caseMenuGroup(menuGroup);
                if (result == null)
                    result = caseMenuItem(menuGroup);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Outline Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Outline Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseOutlineConfiguration(OutlineConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Create Child Menu Configuration</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Create Child Menu Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseCreateChildMenuConfiguration(CreateChildMenuConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Create Child Action</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Create Child Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseCreateChildAction(CreateChildAction object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Menu</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Menu</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseMenu(Menu object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Menu Item</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Menu Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseMenuItem(MenuItem object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Menu Group</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Menu Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseMenuGroup(MenuGroup object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch, but this is the last
     * case anyway. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public Object defaultCase(EObject object)
    {
        return null;
    }

} // OutlineConfiguratorSwitch
