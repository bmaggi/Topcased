/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorFactory.java,v 1.7 2007/04/18 12:54:12 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage
 * @generated
 */
public interface DiagramconfiguratorFactory extends EFactory
{
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    DiagramconfiguratorFactory eINSTANCE = org.topcased.modeler.diagramconfigurator.internal.impl.DiagramconfiguratorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Diagram Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Diagram Configuration</em>'.
     * @generated
     */
    DiagramConfiguration createDiagramConfiguration();

    /**
     * Returns a new object of class '<em>Diagram Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Diagram Reference</em>'.
     * @generated
     */
    DiagramReference createDiagramReference();

    /**
     * Returns a new object of class '<em>Palette Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Palette Configuration</em>'.
     * @generated
     */
    PaletteConfiguration createPaletteConfiguration();

    /**
     * Returns a new object of class '<em>Palette Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Palette Category</em>'.
     * @generated
     */
    PaletteCategory createPaletteCategory();

    /**
     * Returns a new object of class '<em>Node Part Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Node Part Configuration</em>'.
     * @generated
     */
    NodePartConfiguration createNodePartConfiguration();

    /**
     * Returns a new object of class '<em>Edge Part Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Edge Part Configuration</em>'.
     * @generated
     */
    EdgePartConfiguration createEdgePartConfiguration();

    /**
     * Returns a new object of class '<em>Edge Object</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Edge Object</em>'.
     * @generated
     */
    EdgeObject createEdgeObject();

    /**
     * Returns a new object of class '<em>Palette Item</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Palette Item</em>'.
     * @generated
     */
    PaletteItem createPaletteItem();

    /**
     * Returns a new object of class '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Source Target Couple</em>'.
     * @generated
     */
    SourceTargetCouple createSourceTargetCouple();

    /**
     * Returns a new object of class '<em>Model Object Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Model Object Configuration</em>'.
     * @generated
     */
    ModelObjectConfiguration createModelObjectConfiguration();

    /**
     * Returns a new object of class '<em>Simple Object Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Simple Object Configuration</em>'.
     * @generated
     */
    SimpleObjectConfiguration createSimpleObjectConfiguration();

    /**
     * Returns a new object of class '<em>Constraint</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Constraint</em>'.
     * @generated
     */
    Constraint createConstraint();

    /**
     * Returns a new object of class '<em>Part Action</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Part Action</em>'.
     * @generated
     */
    PartAction createPartAction();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    DiagramconfiguratorPackage getDiagramconfiguratorPackage();

} // DiagramconfiguratorFactory
