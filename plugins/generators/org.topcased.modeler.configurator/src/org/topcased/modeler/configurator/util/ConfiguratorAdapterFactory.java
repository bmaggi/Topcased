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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.topcased.modeler.configurator.ConfiguratorPackage
 * @generated
 */
public class ConfiguratorAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConfiguratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfiguratorAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = ConfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
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
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch the delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfiguratorSwitch modelSwitch =
        new ConfiguratorSwitch()
        {
            public Object caseEditorConfiguration(EditorConfiguration object)
            {
                return createEditorConfigurationAdapter();
            }
            public Object caseDiagramConfiguration(DiagramConfiguration object)
            {
                return createDiagramConfigurationAdapter();
            }
            public Object caseObjectConfiguration(ObjectConfiguration object)
            {
                return createObjectConfigurationAdapter();
            }
            public Object caseDiagramReference(DiagramReference object)
            {
                return createDiagramReferenceAdapter();
            }
            public Object casePaletteConfiguration(PaletteConfiguration object)
            {
                return createPaletteConfigurationAdapter();
            }
            public Object casePaletteCategory(PaletteCategory object)
            {
                return createPaletteCategoryAdapter();
            }
            public Object casePartConfiguration(PartConfiguration object)
            {
                return createPartConfigurationAdapter();
            }
            public Object caseNodePartConfiguration(NodePartConfiguration object)
            {
                return createNodePartConfigurationAdapter();
            }
            public Object caseEdgePartConfiguration(EdgePartConfiguration object)
            {
                return createEdgePartConfigurationAdapter();
            }
            public Object caseEdgeObject(EdgeObject object)
            {
                return createEdgeObjectAdapter();
            }
            public Object casePaletteItem(PaletteItem object)
            {
                return createPaletteItemAdapter();
            }
            public Object caseSourceTargetCouple(SourceTargetCouple object)
            {
                return createSourceTargetCoupleAdapter();
            }
            public Object caseModelObjectConfiguration(ModelObjectConfiguration object)
            {
                return createModelObjectConfigurationAdapter();
            }
            public Object caseSimpleObjectConfiguration(SimpleObjectConfiguration object)
            {
                return createSimpleObjectConfigurationAdapter();
            }
            public Object defaultCase(EObject object)
            {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    public Adapter createAdapter(Notifier target)
    {
        return (Adapter)modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.DiagramConfiguration <em>Diagram Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.DiagramConfiguration
     * @generated
     */
    public Adapter createDiagramConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.EditorConfiguration <em>Editor Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.EditorConfiguration
     * @generated
     */
    public Adapter createEditorConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.ObjectConfiguration <em>Object Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.ObjectConfiguration
     * @generated
     */
    public Adapter createObjectConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.DiagramReference <em>Diagram Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.DiagramReference
     * @generated
     */
    public Adapter createDiagramReferenceAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.PaletteConfiguration <em>Palette Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.PaletteConfiguration
     * @generated
     */
    public Adapter createPaletteConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.PaletteCategory <em>Palette Category</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.PaletteCategory
     * @generated
     */
    public Adapter createPaletteCategoryAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.PartConfiguration <em>Part Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.PartConfiguration
     * @generated
     */
    public Adapter createPartConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.NodePartConfiguration <em>Node Part Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.NodePartConfiguration
     * @generated
     */
    public Adapter createNodePartConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.EdgePartConfiguration <em>Edge Part Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.EdgePartConfiguration
     * @generated
     */
    public Adapter createEdgePartConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.EdgeObject <em>Edge Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.EdgeObject
     * @generated
     */
    public Adapter createEdgeObjectAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.PaletteItem <em>Palette Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.PaletteItem
     * @generated
     */
    public Adapter createPaletteItemAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.SourceTargetCouple <em>Source Target Couple</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.SourceTargetCouple
     * @generated
     */
    public Adapter createSourceTargetCoupleAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.ModelObjectConfiguration <em>Model Object Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.ModelObjectConfiguration
     * @generated
     */
    public Adapter createModelObjectConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.configurator.SimpleObjectConfiguration <em>Simple Object Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.configurator.SimpleObjectConfiguration
     * @generated
     */
    public Adapter createSimpleObjectConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} //ConfiguratorAdapterFactory
