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
package org.topcased.modeler.configurator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage
 * @generated
 */
public interface ConfiguratorFactory extends EFactory{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConfiguratorFactory eINSTANCE = new org.topcased.modeler.configurator.impl.ConfiguratorFactoryImpl();

    /**
     * Returns a new object of class '<em>Diagram Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Diagram Configuration</em>'.
     * @generated
     */
    DiagramConfiguration createDiagramConfiguration();

    /**
     * Returns a new object of class '<em>Editor Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Editor Configuration</em>'.
     * @generated
     */
    EditorConfiguration createEditorConfiguration();

    /**
     * Returns a new object of class '<em>Diagram Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Diagram Reference</em>'.
     * @generated
     */
    DiagramReference createDiagramReference();

    /**
     * Returns a new object of class '<em>Palette Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Palette Configuration</em>'.
     * @generated
     */
    PaletteConfiguration createPaletteConfiguration();

    /**
     * Returns a new object of class '<em>Palette Category</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Palette Category</em>'.
     * @generated
     */
    PaletteCategory createPaletteCategory();

    /**
     * Returns a new object of class '<em>Node Part Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Node Part Configuration</em>'.
     * @generated
     */
    NodePartConfiguration createNodePartConfiguration();

    /**
     * Returns a new object of class '<em>Edge Part Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Edge Part Configuration</em>'.
     * @generated
     */
    EdgePartConfiguration createEdgePartConfiguration();

    /**
     * Returns a new object of class '<em>Edge Object</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Edge Object</em>'.
     * @generated
     */
    EdgeObject createEdgeObject();

    /**
     * Returns a new object of class '<em>Palette Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Palette Item</em>'.
     * @generated
     */
    PaletteItem createPaletteItem();

    /**
     * Returns a new object of class '<em>Source Target Couple</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Source Target Couple</em>'.
     * @generated
     */
    SourceTargetCouple createSourceTargetCouple();

    /**
     * Returns a new object of class '<em>Model Object Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Model Object Configuration</em>'.
     * @generated
     */
    ModelObjectConfiguration createModelObjectConfiguration();

    /**
     * Returns a new object of class '<em>Simple Object Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Object Configuration</em>'.
     * @generated
     */
    SimpleObjectConfiguration createSimpleObjectConfiguration();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ConfiguratorPackage getConfiguratorPackage();

} //ConfiguratorFactory
