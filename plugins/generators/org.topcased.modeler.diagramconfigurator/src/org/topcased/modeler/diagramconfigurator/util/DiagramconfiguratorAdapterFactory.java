/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorAdapterFactory.java,v 1.10 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage
 * @generated
 */
public class DiagramconfiguratorAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static DiagramconfiguratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramconfiguratorAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = DiagramconfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This
     * implementation returns <code>true</code> if the object is either the model's package or is an instance object
     * of the model. <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
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
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DiagramconfiguratorSwitch<Adapter> modelSwitch = new DiagramconfiguratorSwitch<Adapter>()
        {
            @Override
            public Adapter caseDiagramConfiguration(DiagramConfiguration object)
            {
                return createDiagramConfigurationAdapter();
            }
            @Override
            public Adapter caseObjectConfiguration(ObjectConfiguration object)
            {
                return createObjectConfigurationAdapter();
            }
            @Override
            public Adapter caseDiagramReference(DiagramReference object)
            {
                return createDiagramReferenceAdapter();
            }
            @Override
            public Adapter casePaletteConfiguration(PaletteConfiguration object)
            {
                return createPaletteConfigurationAdapter();
            }
            @Override
            public Adapter casePaletteCategory(PaletteCategory object)
            {
                return createPaletteCategoryAdapter();
            }
            @Override
            public Adapter casePartConfiguration(PartConfiguration object)
            {
                return createPartConfigurationAdapter();
            }
            @Override
            public Adapter caseNodePartConfiguration(NodePartConfiguration object)
            {
                return createNodePartConfigurationAdapter();
            }
            @Override
            public Adapter caseEdgePartConfiguration(EdgePartConfiguration object)
            {
                return createEdgePartConfigurationAdapter();
            }
            @Override
            public Adapter caseEdgeObject(EdgeObject object)
            {
                return createEdgeObjectAdapter();
            }
            @Override
            public Adapter casePaletteItem(PaletteItem object)
            {
                return createPaletteItemAdapter();
            }
            @Override
            public Adapter caseSourceTargetCouple(SourceTargetCouple object)
            {
                return createSourceTargetCoupleAdapter();
            }
            @Override
            public Adapter caseModelObjectConfiguration(ModelObjectConfiguration object)
            {
                return createModelObjectConfigurationAdapter();
            }
            @Override
            public Adapter caseSimpleObjectConfiguration(SimpleObjectConfiguration object)
            {
                return createSimpleObjectConfigurationAdapter();
            }
            @Override
            public Adapter caseConstraint(Constraint object)
            {
                return createConstraintAdapter();
            }
            @Override
            public Adapter casePartAction(PartAction object)
            {
                return createPartActionAdapter();
            }
            @Override
            public Adapter caseEModelElement(EModelElement object)
            {
                return createEModelElementAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object)
            {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target)
    {
        return modelSwitch.doSwitch((EObject)target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration <em>Diagram Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.DiagramConfiguration
     * @generated
     */
    public Adapter createDiagramConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.ObjectConfiguration <em>Object Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.ObjectConfiguration
     * @generated
     */
    public Adapter createObjectConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.DiagramReference <em>Diagram Reference</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.DiagramReference
     * @generated
     */
    public Adapter createDiagramReferenceAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.PaletteConfiguration <em>Palette Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.PaletteConfiguration
     * @generated
     */
    public Adapter createPaletteConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.PaletteCategory <em>Palette Category</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.PaletteCategory
     * @generated
     */
    public Adapter createPaletteCategoryAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.PartConfiguration <em>Part Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.PartConfiguration
     * @generated
     */
    public Adapter createPartConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration <em>Node Part Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.NodePartConfiguration
     * @generated
     */
    public Adapter createNodePartConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration <em>Edge Part Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.EdgePartConfiguration
     * @generated
     */
    public Adapter createEdgePartConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.EdgeObject <em>Edge Object</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.EdgeObject
     * @generated
     */
    public Adapter createEdgeObjectAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.PaletteItem <em>Palette Item</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.PaletteItem
     * @generated
     */
    public Adapter createPaletteItemAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.SourceTargetCouple <em>Source Target Couple</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.SourceTargetCouple
     * @generated
     */
    public Adapter createSourceTargetCoupleAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration <em>Model Object Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration
     * @generated
     */
    public Adapter createModelObjectConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration <em>Simple Object Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration
     * @generated
     */
    public Adapter createSimpleObjectConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.Constraint
     * @generated
     */
    public Adapter createConstraintAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.modeler.diagramconfigurator.PartAction <em>Part Action</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.topcased.modeler.diagramconfigurator.PartAction
     * @generated
     */
    public Adapter createPartActionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.emf.ecore.EModelElement
     * @generated
     */
    public Adapter createEModelElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc --> This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} // DiagramconfiguratorAdapterFactory
