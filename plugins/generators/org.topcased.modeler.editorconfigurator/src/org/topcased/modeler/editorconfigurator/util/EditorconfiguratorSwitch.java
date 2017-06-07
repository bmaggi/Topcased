/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorconfiguratorSwitch.java,v 1.6 2007/04/18 12:54:45 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.editorconfigurator.EditorAction;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage
 * @generated
 */
public class EditorconfiguratorSwitch<T>
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static EditorconfiguratorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorconfiguratorSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = EditorconfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject)
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
    protected T doSwitch(EClass theEClass, EObject theEObject)
    {
        if (theEClass.eContainer() == modelPackage)
        {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else
        {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION: {
                EditorConfiguration editorConfiguration = (EditorConfiguration) theEObject;
                T result = caseEditorConfiguration(editorConfiguration);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case EditorconfiguratorPackage.EDITOR_ACTION: {
                EditorAction editorAction = (EditorAction) theEObject;
                T result = caseEditorAction(editorAction);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Editor Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Editor Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEditorConfiguration(EditorConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Editor Action</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Editor Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEditorAction(EditorAction object)
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
    public T defaultCase(EObject object)
    {
        return null;
    }

} // EditorconfiguratorSwitch
