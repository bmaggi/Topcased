/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfSwitch.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.graphconf.AbstractGraphConf;
import org.topcased.modeler.graphconf.Bridge;
import org.topcased.modeler.graphconf.Constraint;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.graphconf.StringBridge;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage
 * @generated
 */
public class GraphconfSwitch
{
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static GraphconfPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = GraphconfPackage.eINSTANCE;
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
            case GraphconfPackage.ABSTRACT_GRAPH_CONF: {
                AbstractGraphConf abstractGraphConf = (AbstractGraphConf) theEObject;
                Object result = caseAbstractGraphConf(abstractGraphConf);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.DIAGRAM_GRAPH_CONF: {
                DiagramGraphConf diagramGraphConf = (DiagramGraphConf) theEObject;
                Object result = caseDiagramGraphConf(diagramGraphConf);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.NODE_GRAPH_CONF: {
                NodeGraphConf nodeGraphConf = (NodeGraphConf) theEObject;
                Object result = caseNodeGraphConf(nodeGraphConf);
                if (result == null)
                    result = caseAbstractGraphConf(nodeGraphConf);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.EDGE_GRAPH_CONF: {
                EdgeGraphConf edgeGraphConf = (EdgeGraphConf) theEObject;
                Object result = caseEdgeGraphConf(edgeGraphConf);
                if (result == null)
                    result = caseAbstractGraphConf(edgeGraphConf);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.BRIDGE: {
                Bridge bridge = (Bridge) theEObject;
                Object result = caseBridge(bridge);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.EMF_BRIDGE: {
                EMFBridge emfBridge = (EMFBridge) theEObject;
                Object result = caseEMFBridge(emfBridge);
                if (result == null)
                    result = caseBridge(emfBridge);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.STRING_BRIDGE: {
                StringBridge stringBridge = (StringBridge) theEObject;
                Object result = caseStringBridge(stringBridge);
                if (result == null)
                    result = caseBridge(stringBridge);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case GraphconfPackage.CONSTRAINT: {
                Constraint constraint = (Constraint) theEObject;
                Object result = caseConstraint(constraint);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Abstract Graph Conf</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Abstract Graph Conf</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAbstractGraphConf(AbstractGraphConf object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Diagram Graph Conf</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Diagram Graph Conf</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDiagramGraphConf(DiagramGraphConf object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Node Graph Conf</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Node Graph Conf</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseNodeGraphConf(NodeGraphConf object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Edge Graph Conf</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Edge Graph Conf</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEdgeGraphConf(EdgeGraphConf object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Bridge</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Bridge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseBridge(Bridge object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EMF Bridge</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EMF Bridge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEMFBridge(EMFBridge object)
    {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>String Bridge</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>String Bridge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseStringBridge(StringBridge object)
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
    public Object caseConstraint(Constraint object)
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

} // GraphconfSwitch
