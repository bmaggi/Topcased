/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertiesConfiguratorSwitch.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.topcased.properties.configurator.AbstractSection;
import org.topcased.properties.configurator.AdvancedSection;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.MultipleFeatureSection;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.TabbedView;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage
 * @generated
 */
public class PropertiesConfiguratorSwitch
{
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static PropertiesConfiguratorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PropertiesConfiguratorSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = PropertiesConfiguratorPackage.eINSTANCE;
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
            case PropertiesConfiguratorPackage.TABBED_VIEW: {
                TabbedView tabbedView = (TabbedView) theEObject;
                Object result = caseTabbedView(tabbedView);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case PropertiesConfiguratorPackage.TAB: {
                Tab tab = (Tab) theEObject;
                Object result = caseTab(tab);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case PropertiesConfiguratorPackage.ABSTRACT_SECTION: {
                AbstractSection abstractSection = (AbstractSection) theEObject;
                Object result = caseAbstractSection(abstractSection);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case PropertiesConfiguratorPackage.CATEGORY: {
                Category category = (Category) theEObject;
                Object result = caseCategory(category);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION: {
                SingleFeatureSection singleFeatureSection = (SingleFeatureSection) theEObject;
                Object result = caseSingleFeatureSection(singleFeatureSection);
                if (result == null)
                    result = caseAbstractSection(singleFeatureSection);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION: {
                MultipleFeatureSection multipleFeatureSection = (MultipleFeatureSection) theEObject;
                Object result = caseMultipleFeatureSection(multipleFeatureSection);
                if (result == null)
                    result = caseAbstractSection(multipleFeatureSection);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case PropertiesConfiguratorPackage.ADVANCED_SECTION: {
                AdvancedSection advancedSection = (AdvancedSection) theEObject;
                Object result = caseAdvancedSection(advancedSection);
                if (result == null)
                    result = caseAbstractSection(advancedSection);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Tabbed View</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Tabbed View</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseTabbedView(TabbedView object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Tab</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Tab</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseTab(Tab object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Abstract Section</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Abstract Section</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAbstractSection(AbstractSection object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Category</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Category</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseCategory(Category object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Single Feature Section</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Single Feature Section</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSingleFeatureSection(SingleFeatureSection object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Multiple Feature Section</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Multiple Feature Section</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseMultipleFeatureSection(MultipleFeatureSection object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Advanced Section</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Advanced Section</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAdvancedSection(AdvancedSection object)
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

} // PropertiesConfiguratorSwitch
