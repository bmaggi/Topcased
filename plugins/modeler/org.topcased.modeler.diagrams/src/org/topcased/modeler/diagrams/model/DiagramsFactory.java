/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsFactory.java,v 1.7 2007/04/12 08:32:17 jako Exp $
 */
package org.topcased.modeler.diagrams.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagrams.model.DiagramsPackage
 * @generated
 */
public interface DiagramsFactory extends EFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "";

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    DiagramsFactory eINSTANCE = org.topcased.modeler.diagrams.model.internal.impl.DiagramsFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Diagrams</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return a new object of class '<em>Diagrams</em>'.
     * @generated
     */
    Diagrams createDiagrams();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DiagramsPackage getDiagramsPackage();

} // DiagramsFactory
