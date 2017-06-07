/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorSwitch.java,v 1.10 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.diagramconfigurator.Constraint;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramReference;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteItem;
import org.topcased.modeler.diagramconfigurator.PartAction;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage
 * @generated
 */
public class DiagramconfiguratorSwitch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static DiagramconfiguratorPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramconfiguratorSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = DiagramconfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject)
    {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION:
            {
                DiagramConfiguration diagramConfiguration = (DiagramConfiguration)theEObject;
                T result = caseDiagramConfiguration(diagramConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.OBJECT_CONFIGURATION:
            {
                ObjectConfiguration objectConfiguration = (ObjectConfiguration)theEObject;
                T result = caseObjectConfiguration(objectConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE:
            {
                DiagramReference diagramReference = (DiagramReference)theEObject;
                T result = caseDiagramReference(diagramReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION:
            {
                PaletteConfiguration paletteConfiguration = (PaletteConfiguration)theEObject;
                T result = casePaletteConfiguration(paletteConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.PALETTE_CATEGORY:
            {
                PaletteCategory paletteCategory = (PaletteCategory)theEObject;
                T result = casePaletteCategory(paletteCategory);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.PART_CONFIGURATION:
            {
                PartConfiguration partConfiguration = (PartConfiguration)theEObject;
                T result = casePartConfiguration(partConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION:
            {
                NodePartConfiguration nodePartConfiguration = (NodePartConfiguration)theEObject;
                T result = caseNodePartConfiguration(nodePartConfiguration);
                if (result == null) result = casePartConfiguration(nodePartConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION:
            {
                EdgePartConfiguration edgePartConfiguration = (EdgePartConfiguration)theEObject;
                T result = caseEdgePartConfiguration(edgePartConfiguration);
                if (result == null) result = casePartConfiguration(edgePartConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.EDGE_OBJECT:
            {
                EdgeObject edgeObject = (EdgeObject)theEObject;
                T result = caseEdgeObject(edgeObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.PALETTE_ITEM:
            {
                PaletteItem paletteItem = (PaletteItem)theEObject;
                T result = casePaletteItem(paletteItem);
                if (result == null) result = caseEModelElement(paletteItem);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE:
            {
                SourceTargetCouple sourceTargetCouple = (SourceTargetCouple)theEObject;
                T result = caseSourceTargetCouple(sourceTargetCouple);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION:
            {
                ModelObjectConfiguration modelObjectConfiguration = (ModelObjectConfiguration)theEObject;
                T result = caseModelObjectConfiguration(modelObjectConfiguration);
                if (result == null) result = caseObjectConfiguration(modelObjectConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.SIMPLE_OBJECT_CONFIGURATION:
            {
                SimpleObjectConfiguration simpleObjectConfiguration = (SimpleObjectConfiguration)theEObject;
                T result = caseSimpleObjectConfiguration(simpleObjectConfiguration);
                if (result == null) result = caseObjectConfiguration(simpleObjectConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.CONSTRAINT:
            {
                Constraint constraint = (Constraint)theEObject;
                T result = caseConstraint(constraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DiagramconfiguratorPackage.PART_ACTION:
            {
                PartAction partAction = (PartAction)theEObject;
                T result = casePartAction(partAction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagramConfiguration(DiagramConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Object Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Object Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseObjectConfiguration(ObjectConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Reference</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagramReference(DiagramReference object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Palette Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Palette Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePaletteConfiguration(PaletteConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Palette Category</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Palette Category</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePaletteCategory(PaletteCategory object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Part Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Part Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePartConfiguration(PartConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Node Part Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Node Part Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNodePartConfiguration(NodePartConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Part Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Part Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEdgePartConfiguration(EdgePartConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Object</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEdgeObject(EdgeObject object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Palette Item</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Palette Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePaletteItem(PaletteItem object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Source Target Couple</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Source Target Couple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceTargetCouple(SourceTargetCouple object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Model Object Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Model Object Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModelObjectConfiguration(ModelObjectConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Simple Object Configuration</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Simple Object Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleObjectConfiguration(SimpleObjectConfiguration object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Constraint</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConstraint(Constraint object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Part Action</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Part Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePartAction(PartAction object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EModel Element</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EModel Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEModelElement(EModelElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch, but this is the last
     * case anyway. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object)
    {
        return null;
    }

} // DiagramconfiguratorSwitch
