/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfAdapterFactory.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage
 * @generated
 */
public class GraphconfAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static GraphconfPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = GraphconfPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
     * implementation returns <code>true</code> if the object is either the model's package or is an instance object
     * of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    public boolean isFactoryForType(Object object)
    {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch the delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected GraphconfSwitch modelSwitch = new GraphconfSwitch()
    {
        public Object caseAbstractGraphConf(AbstractGraphConf object)
        {
            return createAbstractGraphConfAdapter();
        }

        public Object caseDiagramGraphConf(DiagramGraphConf object)
        {
            return createDiagramGraphConfAdapter();
        }

        public Object caseNodeGraphConf(NodeGraphConf object)
        {
            return createNodeGraphConfAdapter();
        }

        public Object caseEdgeGraphConf(EdgeGraphConf object)
        {
            return createEdgeGraphConfAdapter();
        }

        public Object caseBridge(Bridge object)
        {
            return createBridgeAdapter();
        }

        public Object caseEMFBridge(EMFBridge object)
        {
            return createEMFBridgeAdapter();
        }

        public Object caseStringBridge(StringBridge object)
        {
            return createStringBridgeAdapter();
        }

        public Object caseConstraint(Constraint object)
        {
            return createConstraintAdapter();
        }

        public Object defaultCase(EObject object)
        {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    public Adapter createAdapter(Notifier target)
    {
        return (Adapter) modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.AbstractGraphConf <em>Abstract Graph Conf</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.AbstractGraphConf
     * @generated
     */
    public Adapter createAbstractGraphConfAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.DiagramGraphConf <em>Diagram Graph Conf</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.DiagramGraphConf
     * @generated
     */
    public Adapter createDiagramGraphConfAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.NodeGraphConf <em>Node Graph Conf</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.NodeGraphConf
     * @generated
     */
    public Adapter createNodeGraphConfAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.EdgeGraphConf <em>Edge Graph Conf</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.EdgeGraphConf
     * @generated
     */
    public Adapter createEdgeGraphConfAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.Bridge <em>Bridge</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.Bridge
     * @generated
     */
    public Adapter createBridgeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.EMFBridge <em>EMF Bridge</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.EMFBridge
     * @generated
     */
    public Adapter createEMFBridgeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.StringBridge <em>String Bridge</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.StringBridge
     * @generated
     */
    public Adapter createStringBridgeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.graphconf.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.modeler.graphconf.Constraint
     * @generated
     */
    public Adapter createConstraintAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} // GraphconfAdapterFactory
