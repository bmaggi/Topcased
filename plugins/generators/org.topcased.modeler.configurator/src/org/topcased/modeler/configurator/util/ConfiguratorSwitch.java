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
package org.topcased.modeler.configurator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.configurator.*;

import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.DiagramReference;
import org.topcased.modeler.configurator.EdgePartConfiguration;
import org.topcased.modeler.configurator.EditorConfiguration;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PaletteCategory;
import org.topcased.modeler.configurator.PaletteConfiguration;
import org.topcased.modeler.configurator.PaletteItem;
import org.topcased.modeler.configurator.PartConfiguration;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage
 * @generated
 */
public class ConfiguratorSwitch {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConfiguratorPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfiguratorSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = ConfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public Object doSwitch(EObject theEObject)
    {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch((EClass)eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case ConfiguratorPackage.EDITOR_CONFIGURATION:
            {
                EditorConfiguration editorConfiguration = (EditorConfiguration)theEObject;
                Object result = caseEditorConfiguration(editorConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION:
            {
                DiagramConfiguration diagramConfiguration = (DiagramConfiguration)theEObject;
                Object result = caseDiagramConfiguration(diagramConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.OBJECT_CONFIGURATION:
            {
                ObjectConfiguration objectConfiguration = (ObjectConfiguration)theEObject;
                Object result = caseObjectConfiguration(objectConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.DIAGRAM_REFERENCE:
            {
                DiagramReference diagramReference = (DiagramReference)theEObject;
                Object result = caseDiagramReference(diagramReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.PALETTE_CONFIGURATION:
            {
                PaletteConfiguration paletteConfiguration = (PaletteConfiguration)theEObject;
                Object result = casePaletteConfiguration(paletteConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.PALETTE_CATEGORY:
            {
                PaletteCategory paletteCategory = (PaletteCategory)theEObject;
                Object result = casePaletteCategory(paletteCategory);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.PART_CONFIGURATION:
            {
                PartConfiguration partConfiguration = (PartConfiguration)theEObject;
                Object result = casePartConfiguration(partConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.NODE_PART_CONFIGURATION:
            {
                NodePartConfiguration nodePartConfiguration = (NodePartConfiguration)theEObject;
                Object result = caseNodePartConfiguration(nodePartConfiguration);
                if (result == null) result = casePartConfiguration(nodePartConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION:
            {
                EdgePartConfiguration edgePartConfiguration = (EdgePartConfiguration)theEObject;
                Object result = caseEdgePartConfiguration(edgePartConfiguration);
                if (result == null) result = casePartConfiguration(edgePartConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.EDGE_OBJECT:
            {
                EdgeObject edgeObject = (EdgeObject)theEObject;
                Object result = caseEdgeObject(edgeObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.PALETTE_ITEM:
            {
                PaletteItem paletteItem = (PaletteItem)theEObject;
                Object result = casePaletteItem(paletteItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE:
            {
                SourceTargetCouple sourceTargetCouple = (SourceTargetCouple)theEObject;
                Object result = caseSourceTargetCouple(sourceTargetCouple);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION:
            {
                ModelObjectConfiguration modelObjectConfiguration = (ModelObjectConfiguration)theEObject;
                Object result = caseModelObjectConfiguration(modelObjectConfiguration);
                if (result == null) result = caseObjectConfiguration(modelObjectConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ConfiguratorPackage.SIMPLE_OBJECT_CONFIGURATION:
            {
                SimpleObjectConfiguration simpleObjectConfiguration = (SimpleObjectConfiguration)theEObject;
                Object result = caseSimpleObjectConfiguration(simpleObjectConfiguration);
                if (result == null) result = caseObjectConfiguration(simpleObjectConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDiagramConfiguration(DiagramConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Editor Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Editor Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEditorConfiguration(EditorConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Object Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Object Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseObjectConfiguration(ObjectConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDiagramReference(DiagramReference object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Palette Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Palette Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePaletteConfiguration(PaletteConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Palette Category</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Palette Category</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePaletteCategory(PaletteCategory object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Part Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Part Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePartConfiguration(PartConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Node Part Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Node Part Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseNodePartConfiguration(NodePartConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Part Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Part Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEdgePartConfiguration(EdgePartConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEdgeObject(EdgeObject object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Palette Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Palette Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePaletteItem(PaletteItem object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Source Target Couple</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Source Target Couple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSourceTargetCouple(SourceTargetCouple object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Model Object Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Model Object Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseModelObjectConfiguration(ModelObjectConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Simple Object Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Simple Object Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSimpleObjectConfiguration(SimpleObjectConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public Object defaultCase(EObject object)
    {
        return null;
    }

} //ConfiguratorSwitch
