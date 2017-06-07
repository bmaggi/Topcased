/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfFactory.java,v 1.4 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage
 * @generated
 */
public interface GraphconfFactory extends EFactory
{
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    GraphconfFactory eINSTANCE = org.topcased.modeler.graphconf.internal.impl.GraphconfFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Diagram Graph Conf</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Diagram Graph Conf</em>'.
     * @generated
     */
    DiagramGraphConf createDiagramGraphConf();

    /**
     * Returns a new object of class '<em>Node Graph Conf</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Node Graph Conf</em>'.
     * @generated
     */
    NodeGraphConf createNodeGraphConf();

    /**
     * Returns a new object of class '<em>Edge Graph Conf</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Edge Graph Conf</em>'.
     * @generated
     */
    EdgeGraphConf createEdgeGraphConf();

    /**
     * Returns a new object of class '<em>EMF Bridge</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>EMF Bridge</em>'.
     * @generated
     */
    EMFBridge createEMFBridge();

    /**
     * Returns a new object of class '<em>String Bridge</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>String Bridge</em>'.
     * @generated
     */
    StringBridge createStringBridge();

    /**
     * Returns a new object of class '<em>Constraint</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Constraint</em>'.
     * @generated
     */
    Constraint createConstraint();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    GraphconfPackage getGraphconfPackage();

} // GraphconfFactory
