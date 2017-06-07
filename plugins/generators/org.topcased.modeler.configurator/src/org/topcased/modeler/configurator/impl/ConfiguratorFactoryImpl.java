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
package org.topcased.modeler.configurator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.topcased.modeler.configurator.*;

import org.topcased.modeler.configurator.ConfiguratorFactory;
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
import org.topcased.modeler.configurator.ToolType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfiguratorFactoryImpl extends EFactoryImpl implements ConfiguratorFactory
{
    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfiguratorFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case ConfiguratorPackage.EDITOR_CONFIGURATION: return createEditorConfiguration();
            case ConfiguratorPackage.DIAGRAM_CONFIGURATION: return createDiagramConfiguration();
            case ConfiguratorPackage.DIAGRAM_REFERENCE: return createDiagramReference();
            case ConfiguratorPackage.PALETTE_CONFIGURATION: return createPaletteConfiguration();
            case ConfiguratorPackage.PALETTE_CATEGORY: return createPaletteCategory();
            case ConfiguratorPackage.NODE_PART_CONFIGURATION: return createNodePartConfiguration();
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION: return createEdgePartConfiguration();
            case ConfiguratorPackage.EDGE_OBJECT: return createEdgeObject();
            case ConfiguratorPackage.PALETTE_ITEM: return createPaletteItem();
            case ConfiguratorPackage.SOURCE_TARGET_COUPLE: return createSourceTargetCouple();
            case ConfiguratorPackage.MODEL_OBJECT_CONFIGURATION: return createModelObjectConfiguration();
            case ConfiguratorPackage.SIMPLE_OBJECT_CONFIGURATION: return createSimpleObjectConfiguration();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object createFromString(EDataType eDataType, String initialValue)
    {
        switch (eDataType.getClassifierID())
        {
            case ConfiguratorPackage.EDGE_CONTAINER_TYPE:
            {
                EdgeContainerType result = EdgeContainerType.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                return result;
            }
            case ConfiguratorPackage.RESIZABLE_TYPE:
            {
                ResizableType result = ResizableType.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                return result;
            }
            case ConfiguratorPackage.LAYOUT_TYPE:
            {
                LayoutType result = LayoutType.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                return result;
            }
            case ConfiguratorPackage.DECORATION_TYPE:
            {
                DecorationType result = DecorationType.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                return result;
            }
            case ConfiguratorPackage.ROUTER_TYPE:
            {
                RouterType result = RouterType.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                return result;
            }
            case ConfiguratorPackage.EDGE_OBJECT_TYPE:
            {
                EdgeObjectType result = EdgeObjectType.get(initialValue);
                if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                return result;
            }
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertToString(EDataType eDataType, Object instanceValue)
    {
        switch (eDataType.getClassifierID())
        {
            case ConfiguratorPackage.EDGE_CONTAINER_TYPE:
                return instanceValue == null ? null : instanceValue.toString();
            case ConfiguratorPackage.RESIZABLE_TYPE:
                return instanceValue == null ? null : instanceValue.toString();
            case ConfiguratorPackage.LAYOUT_TYPE:
                return instanceValue == null ? null : instanceValue.toString();
            case ConfiguratorPackage.DECORATION_TYPE:
                return instanceValue == null ? null : instanceValue.toString();
            case ConfiguratorPackage.ROUTER_TYPE:
                return instanceValue == null ? null : instanceValue.toString();
            case ConfiguratorPackage.EDGE_OBJECT_TYPE:
                return instanceValue == null ? null : instanceValue.toString();
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramConfiguration createDiagramConfiguration()
    {
        DiagramConfigurationImpl diagramConfiguration = new DiagramConfigurationImpl();
        return diagramConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EditorConfiguration createEditorConfiguration()
    {
        EditorConfigurationImpl editorConfiguration = new EditorConfigurationImpl();
        return editorConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramReference createDiagramReference()
    {
        DiagramReferenceImpl diagramReference = new DiagramReferenceImpl();
        return diagramReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PaletteConfiguration createPaletteConfiguration()
    {
        PaletteConfigurationImpl paletteConfiguration = new PaletteConfigurationImpl();
        return paletteConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PaletteCategory createPaletteCategory()
    {
        PaletteCategoryImpl paletteCategory = new PaletteCategoryImpl();
        return paletteCategory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NodePartConfiguration createNodePartConfiguration()
    {
        NodePartConfigurationImpl nodePartConfiguration = new NodePartConfigurationImpl();
        return nodePartConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgePartConfiguration createEdgePartConfiguration()
    {
        EdgePartConfigurationImpl edgePartConfiguration = new EdgePartConfigurationImpl();
        return edgePartConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgeObject createEdgeObject()
    {
        EdgeObjectImpl edgeObject = new EdgeObjectImpl();
        return edgeObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PaletteItem createPaletteItem()
    {
        PaletteItemImpl paletteItem = new PaletteItemImpl();
        return paletteItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SourceTargetCouple createSourceTargetCouple()
    {
        SourceTargetCoupleImpl sourceTargetCouple = new SourceTargetCoupleImpl();
        return sourceTargetCouple;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelObjectConfiguration createModelObjectConfiguration()
    {
        ModelObjectConfigurationImpl modelObjectConfiguration = new ModelObjectConfigurationImpl();
        return modelObjectConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleObjectConfiguration createSimpleObjectConfiguration()
    {
        SimpleObjectConfigurationImpl simpleObjectConfiguration = new SimpleObjectConfigurationImpl();
        return simpleObjectConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfiguratorPackage getConfiguratorPackage()
    {
        return (ConfiguratorPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    public static ConfiguratorPackage getPackage()
    {
        return ConfiguratorPackage.eINSTANCE;
    }

} //ConfiguratorFactoryImpl
