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

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;
import org.topcased.modeler.configurator.ConfiguratorFactory;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.DecorationType;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.DiagramReference;
import org.topcased.modeler.configurator.EdgeContainerType;
import org.topcased.modeler.configurator.EdgeObject;
import org.topcased.modeler.configurator.EdgeObjectType;
import org.topcased.modeler.configurator.EdgePartConfiguration;
import org.topcased.modeler.configurator.EditorConfiguration;
import org.topcased.modeler.configurator.LayoutType;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.FigureType;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PaletteCategory;
import org.topcased.modeler.configurator.PaletteConfiguration;
import org.topcased.modeler.configurator.PaletteItem;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.ResizableType;
import org.topcased.modeler.configurator.RouterType;
import org.topcased.modeler.configurator.SimpleObjectConfiguration;
import org.topcased.modeler.configurator.SourceTargetCouple;
import org.topcased.modeler.configurator.ToolType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfiguratorPackageImpl extends EPackageImpl implements ConfiguratorPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass editorConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass objectConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass diagramReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass paletteConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass paletteCategoryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass partConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodePartConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass edgePartConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass edgeObjectEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass paletteItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sourceTargetCoupleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modelObjectConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleObjectConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum edgeContainerTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum resizableTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum layoutTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum decorationTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum routerTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum edgeObjectTypeEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.configurator.ConfiguratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ConfiguratorPackageImpl()
    {
        super(eNS_URI, ConfiguratorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ConfiguratorPackage init()
    {
        if (isInited) return (ConfiguratorPackage)EPackage.Registry.INSTANCE.getEPackage(ConfiguratorPackage.eNS_URI);

        // Obtain or create and register package
        ConfiguratorPackageImpl theConfiguratorPackage = (ConfiguratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ConfiguratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ConfiguratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        GenModelPackageImpl.init();
        EcorePackageImpl.init();

        // Create package meta-data objects
        theConfiguratorPackage.createPackageContents();

        // Initialize created meta-data
        theConfiguratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theConfiguratorPackage.freeze();

        return theConfiguratorPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagramConfiguration()
    {
        return diagramConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramConfiguration_Id()
    {
        return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramConfiguration_Name()
    {
        return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramConfiguration_Package()
    {
        return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramConfiguration_Prefix()
    {
        return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramConfiguration_Palette()
    {
        return (EReference)diagramConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramConfiguration_Parts()
    {
        return (EReference)diagramConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramConfiguration_Layout()
    {
        return (EAttribute)diagramConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEditorConfiguration()
    {
        return editorConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEditorConfiguration_Name()
    {
        return (EAttribute)editorConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEditorConfiguration_ProjectName()
    {
        return (EAttribute)editorConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEditorConfiguration_Prefix()
    {
        return (EAttribute)editorConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEditorConfiguration_Extension()
    {
        return (EAttribute)editorConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEditorConfiguration_ExtensionDiagram()
    {
        return (EAttribute)editorConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEditorConfiguration_GenModel()
    {
        return (EReference)editorConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEditorConfiguration_Diagrams()
    {
        return (EReference)editorConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEditorConfiguration_Objects()
    {
        return (EReference)editorConfigurationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEditorConfiguration_PluginVersion()
    {
        return (EAttribute)editorConfigurationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getObjectConfiguration()
    {
        return objectConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDiagramReference()
    {
        return diagramReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDiagramReference_Diagram()
    {
        return (EReference)diagramReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramReference_LowerBound()
    {
        return (EAttribute)diagramReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDiagramReference_UpperBound()
    {
        return (EAttribute)diagramReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPaletteConfiguration()
    {
        return paletteConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPaletteConfiguration_Name()
    {
        return (EAttribute)paletteConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPaletteConfiguration_PaletteCategories()
    {
        return (EReference)paletteConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPaletteCategory()
    {
        return paletteCategoryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPaletteCategory_Name()
    {
        return (EAttribute)paletteCategoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPaletteCategory_Items()
    {
        return (EReference)paletteCategoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPartConfiguration()
    {
        return partConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPartConfiguration_Object()
    {
        return (EReference)partConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPartConfiguration_DefaultForegroundColor()
    {
        return (EAttribute)partConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPartConfiguration_ForegroundColorChangeable()
    {
        return (EAttribute)partConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPartConfiguration_FontChangeable()
    {
        return (EAttribute)partConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNodePartConfiguration()
    {
        return nodePartConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_Type()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNodePartConfiguration_ChildElements()
    {
        return (EReference)nodePartConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNodePartConfiguration_SuperType()
    {
        return (EReference)nodePartConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_DefaultWidth()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_DefaultHeight()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_MinimumWidth()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_MinimumHeight()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_MaximumWidth()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_MaximumHeight()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_DefaultBackgroundColor()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_BackgroundColorChangeable()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_Resizing()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_Container()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_DirectEditable()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNodePartConfiguration_Layout()
    {
        return (EAttribute)nodePartConfigurationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEdgePartConfiguration()
    {
        return edgePartConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEdgePartConfiguration_SourceTargetCouple()
    {
        return (EReference)edgePartConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEdgePartConfiguration_EdgeObjects()
    {
        return (EReference)edgePartConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgePartConfiguration_SourceDecoration()
    {
        return (EAttribute)edgePartConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgePartConfiguration_TargetDecoration()
    {
        return (EAttribute)edgePartConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgePartConfiguration_DefaultRouter()
    {
        return (EAttribute)edgePartConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEdgePartConfiguration_DirectEditable()
    {
        return (EReference)edgePartConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEdgeObject()
    {
        return edgeObjectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgeObject_Type()
    {
        return (EAttribute)edgeObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEdgeObject_EStructuralFeature()
    {
        return (EReference)edgeObjectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEdgeObject_Id()
    {
        return (EAttribute)edgeObjectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPaletteItem()
    {
        return paletteItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPaletteItem_Name()
    {
        return (EAttribute)paletteItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPaletteItem_Part()
    {
        return (EReference)paletteItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSourceTargetCouple()
    {
        return sourceTargetCoupleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSourceTargetCouple_ContainerType()
    {
        return (EAttribute)sourceTargetCoupleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSourceTargetCouple_Reversible()
    {
        return (EAttribute)sourceTargetCoupleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_ContainerObject()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_SourceNode()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_TargetNode()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSourceTargetCouple_AutoRef()
    {
        return (EAttribute)sourceTargetCoupleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_ContainerRef()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_RefSourceToEdge()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_RefEdgeToSource()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_RefTargetToEdge()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_RefEdgeToTarget()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_RefSourceToTarget()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSourceTargetCouple_RefTargetToSource()
    {
        return (EReference)sourceTargetCoupleEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModelObjectConfiguration()
    {
        return modelObjectConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModelObjectConfiguration_GenClass()
    {
        return (EReference)modelObjectConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModelObjectConfiguration_Diagrams()
    {
        return (EReference)modelObjectConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleObjectConfiguration()
    {
        return simpleObjectConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleObjectConfiguration_Name()
    {
        return (EAttribute)simpleObjectConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getEdgeContainerType()
    {
        return edgeContainerTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getResizableType()
    {
        return resizableTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getLayoutType()
    {
        return layoutTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getDecorationType()
    {
        return decorationTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getRouterType()
    {
        return routerTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getEdgeObjectType()
    {
        return edgeObjectTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfiguratorFactory getConfiguratorFactory()
    {
        return (ConfiguratorFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        editorConfigurationEClass = createEClass(EDITOR_CONFIGURATION);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__NAME);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__PROJECT_NAME);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__PREFIX);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__EXTENSION);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__EXTENSION_DIAGRAM);
        createEReference(editorConfigurationEClass, EDITOR_CONFIGURATION__GEN_MODEL);
        createEReference(editorConfigurationEClass, EDITOR_CONFIGURATION__DIAGRAMS);
        createEReference(editorConfigurationEClass, EDITOR_CONFIGURATION__OBJECTS);
        createEAttribute(editorConfigurationEClass, EDITOR_CONFIGURATION__PLUGIN_VERSION);

        diagramConfigurationEClass = createEClass(DIAGRAM_CONFIGURATION);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__ID);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__NAME);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PACKAGE);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PREFIX);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PALETTE);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PARTS);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__LAYOUT);

        objectConfigurationEClass = createEClass(OBJECT_CONFIGURATION);

        diagramReferenceEClass = createEClass(DIAGRAM_REFERENCE);
        createEReference(diagramReferenceEClass, DIAGRAM_REFERENCE__DIAGRAM);
        createEAttribute(diagramReferenceEClass, DIAGRAM_REFERENCE__LOWER_BOUND);
        createEAttribute(diagramReferenceEClass, DIAGRAM_REFERENCE__UPPER_BOUND);

        paletteConfigurationEClass = createEClass(PALETTE_CONFIGURATION);
        createEAttribute(paletteConfigurationEClass, PALETTE_CONFIGURATION__NAME);
        createEReference(paletteConfigurationEClass, PALETTE_CONFIGURATION__PALETTE_CATEGORIES);

        paletteCategoryEClass = createEClass(PALETTE_CATEGORY);
        createEAttribute(paletteCategoryEClass, PALETTE_CATEGORY__NAME);
        createEReference(paletteCategoryEClass, PALETTE_CATEGORY__ITEMS);

        partConfigurationEClass = createEClass(PART_CONFIGURATION);
        createEReference(partConfigurationEClass, PART_CONFIGURATION__OBJECT);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__FONT_CHANGEABLE);

        nodePartConfigurationEClass = createEClass(NODE_PART_CONFIGURATION);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__TYPE);
        createEReference(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__CHILD_ELEMENTS);
        createEReference(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__SUPER_TYPE);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__RESIZING);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__CONTAINER);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__LAYOUT);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__DIRECT_EDITABLE);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__DEFAULT_WIDTH);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__DEFAULT_HEIGHT);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__MINIMUM_WIDTH);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__MINIMUM_HEIGHT);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__MAXIMUM_WIDTH);
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT);

        edgePartConfigurationEClass = createEClass(EDGE_PART_CONFIGURATION);
        createEReference(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE);
        createEReference(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__EDGE_OBJECTS);
        createEAttribute(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__SOURCE_DECORATION);
        createEAttribute(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__TARGET_DECORATION);
        createEAttribute(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__DEFAULT_ROUTER);
        createEReference(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__DIRECT_EDITABLE);

        edgeObjectEClass = createEClass(EDGE_OBJECT);
        createEAttribute(edgeObjectEClass, EDGE_OBJECT__TYPE);
        createEReference(edgeObjectEClass, EDGE_OBJECT__ESTRUCTURAL_FEATURE);
        createEAttribute(edgeObjectEClass, EDGE_OBJECT__ID);

        paletteItemEClass = createEClass(PALETTE_ITEM);
        createEAttribute(paletteItemEClass, PALETTE_ITEM__NAME);
        createEReference(paletteItemEClass, PALETTE_ITEM__PART);

        sourceTargetCoupleEClass = createEClass(SOURCE_TARGET_COUPLE);
        createEAttribute(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__CONTAINER_TYPE);
        createEAttribute(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__AUTO_REF);
        createEAttribute(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REVERSIBLE);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__CONTAINER_OBJECT);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__SOURCE_NODE);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__TARGET_NODE);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__CONTAINER_REF);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REF_SOURCE_TO_EDGE);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REF_EDGE_TO_SOURCE);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REF_TARGET_TO_EDGE);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REF_EDGE_TO_TARGET);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REF_SOURCE_TO_TARGET);
        createEReference(sourceTargetCoupleEClass, SOURCE_TARGET_COUPLE__REF_TARGET_TO_SOURCE);

        modelObjectConfigurationEClass = createEClass(MODEL_OBJECT_CONFIGURATION);
        createEReference(modelObjectConfigurationEClass, MODEL_OBJECT_CONFIGURATION__GEN_CLASS);
        createEReference(modelObjectConfigurationEClass, MODEL_OBJECT_CONFIGURATION__DIAGRAMS);

        simpleObjectConfigurationEClass = createEClass(SIMPLE_OBJECT_CONFIGURATION);
        createEAttribute(simpleObjectConfigurationEClass, SIMPLE_OBJECT_CONFIGURATION__NAME);

        // Create enums
        edgeContainerTypeEEnum = createEEnum(EDGE_CONTAINER_TYPE);
        resizableTypeEEnum = createEEnum(RESIZABLE_TYPE);
        layoutTypeEEnum = createEEnum(LAYOUT_TYPE);
        decorationTypeEEnum = createEEnum(DECORATION_TYPE);
        routerTypeEEnum = createEEnum(ROUTER_TYPE);
        edgeObjectTypeEEnum = createEEnum(EDGE_OBJECT_TYPE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents()
    {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        GenModelPackageImpl theGenModelPackage = (GenModelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);
        EcorePackageImpl theEcorePackage = (EcorePackageImpl)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Add supertypes to classes
        nodePartConfigurationEClass.getESuperTypes().add(this.getPartConfiguration());
        edgePartConfigurationEClass.getESuperTypes().add(this.getPartConfiguration());
        modelObjectConfigurationEClass.getESuperTypes().add(this.getObjectConfiguration());
        simpleObjectConfigurationEClass.getESuperTypes().add(this.getObjectConfiguration());

        // Initialize classes and features; add operations and parameters
        initEClass(editorConfigurationEClass, EditorConfiguration.class, "EditorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEditorConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEditorConfiguration_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEditorConfiguration_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEditorConfiguration_Extension(), ecorePackage.getEString(), "extension", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEditorConfiguration_ExtensionDiagram(), ecorePackage.getEString(), "extensionDiagram", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getEditorConfiguration_GenModel(), theGenModelPackage.getGenModel(), null, "genModel", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getEditorConfiguration_Diagrams(), this.getDiagramConfiguration(), null, "diagrams", null, 1, -1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
        initEReference(getEditorConfiguration_Objects(), this.getObjectConfiguration(), null, "objects", null, 1, -1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEditorConfiguration_PluginVersion(), ecorePackage.getEString(), "pluginVersion", null, 1, 1, EditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(diagramConfigurationEClass, DiagramConfiguration.class, "DiagramConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getDiagramConfiguration_Id(), ecorePackage.getEString(), "id", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramConfiguration_Package(), ecorePackage.getEString(), "package", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramConfiguration_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagramConfiguration_Palette(), this.getPaletteConfiguration(), null, "palette", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDiagramConfiguration_Parts(), this.getPartConfiguration(), null, "parts", null, 1, -1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramConfiguration_Layout(), this.getLayoutType(), "layout", "XYLayout", 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(objectConfigurationEClass, ObjectConfiguration.class, "ObjectConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        addEOperation(objectConfigurationEClass, ecorePackage.getEString(), "getName"); //$NON-NLS-1$

        initEClass(diagramReferenceEClass, DiagramReference.class, "DiagramReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getDiagramReference_Diagram(), this.getDiagramConfiguration(), null, "diagram", null, 1, 1, DiagramReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramReference_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 0, 1, DiagramReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getDiagramReference_UpperBound(), ecorePackage.getEInt(), "upperBound", "-1", 0, 1, DiagramReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(paletteConfigurationEClass, PaletteConfiguration.class, "PaletteConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPaletteConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, PaletteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPaletteConfiguration_PaletteCategories(), this.getPaletteCategory(), null, "paletteCategories", null, 1, -1, PaletteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(paletteCategoryEClass, PaletteCategory.class, "PaletteCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPaletteCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, PaletteCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPaletteCategory_Items(), this.getPaletteItem(), null, "items", null, 1, -1, PaletteCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(partConfigurationEClass, PartConfiguration.class, "PartConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPartConfiguration_Object(), this.getObjectConfiguration(), null, "object", null, 1, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getPartConfiguration_DefaultForegroundColor(), ecorePackage.getEString(), "defaultForegroundColor", "", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getPartConfiguration_ForegroundColorChangeable(), ecorePackage.getEBoolean(), "foregroundColorChangeable", "true", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getPartConfiguration_FontChangeable(), ecorePackage.getEBoolean(), "fontChangeable", "true", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(nodePartConfigurationEClass, NodePartConfiguration.class, "NodePartConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_Type(), ecorePackage.getEString(), "type", "Figure", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getNodePartConfiguration_ChildElements(), this.getNodePartConfiguration(), null, "childElements", null, 0, -1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getNodePartConfiguration_SuperType(), this.getNodePartConfiguration(), null, "superType", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_DefaultBackgroundColor(), ecorePackage.getEString(), "defaultBackgroundColor", "", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getNodePartConfiguration_BackgroundColorChangeable(), ecorePackage.getEBoolean(), "backgroundColorChangeable", "true", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getNodePartConfiguration_Resizing(), this.getResizableType(), "resizing", "ALL", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getNodePartConfiguration_Container(), ecorePackage.getEBoolean(), "container", "false", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getNodePartConfiguration_Layout(), this.getLayoutType(), "layout", "XYLayout", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getNodePartConfiguration_DirectEditable(), ecorePackage.getEBoolean(), "directEditable", "true", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getNodePartConfiguration_DefaultWidth(), ecorePackage.getEInt(), "defaultWidth", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_DefaultHeight(), ecorePackage.getEInt(), "defaultHeight", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_MinimumWidth(), ecorePackage.getEInt(), "minimumWidth", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_MinimumHeight(), ecorePackage.getEInt(), "minimumHeight", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_MaximumWidth(), ecorePackage.getEInt(), "maximumWidth", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getNodePartConfiguration_MaximumHeight(), ecorePackage.getEInt(), "maximumHeight", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(edgePartConfigurationEClass, EdgePartConfiguration.class, "EdgePartConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getEdgePartConfiguration_SourceTargetCouple(), this.getSourceTargetCouple(), null, "sourceTargetCouple", null, 1, -1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getEdgePartConfiguration_EdgeObjects(), this.getEdgeObject(), null, "edgeObjects", null, 0, -1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEdgePartConfiguration_SourceDecoration(), this.getDecorationType(), "sourceDecoration", "NONE", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getEdgePartConfiguration_TargetDecoration(), this.getDecorationType(), "targetDecoration", "NONE", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getEdgePartConfiguration_DefaultRouter(), this.getRouterType(), "defaultRouter", "ObliqueRouter", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference(getEdgePartConfiguration_DirectEditable(), this.getEdgeObject(), null, "directEditable", "", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(edgeObjectEClass, EdgeObject.class, "EdgeObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getEdgeObject_Type(), this.getEdgeObjectType(), "type", null, 0, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getEdgeObject_EStructuralFeature(), theEcorePackage.getEStructuralFeature(), null, "eStructuralFeature", null, 0, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getEdgeObject_Id(), ecorePackage.getEString(), "id", null, 1, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(paletteItemEClass, PaletteItem.class, "PaletteItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPaletteItem_Name(), ecorePackage.getEString(), "name", null, 1, 1, PaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPaletteItem_Part(), this.getPartConfiguration(), null, "part", null, 1, 1, PaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(sourceTargetCoupleEClass, SourceTargetCouple.class, "SourceTargetCouple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSourceTargetCouple_ContainerType(), this.getEdgeContainerType(), "containerType", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSourceTargetCouple_AutoRef(), ecorePackage.getEBoolean(), "autoRef", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSourceTargetCouple_Reversible(), ecorePackage.getEBoolean(), "reversible", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_ContainerObject(), theGenModelPackage.getGenClass(), null, "containerObject", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_SourceNode(), this.getNodePartConfiguration(), null, "sourceNode", null, 1, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_TargetNode(), this.getNodePartConfiguration(), null, "targetNode", null, 1, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_ContainerRef(), ecorePackage.getEStructuralFeature(), null, "containerRef", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_RefSourceToEdge(), ecorePackage.getEStructuralFeature(), null, "refSourceToEdge", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_RefEdgeToSource(), ecorePackage.getEStructuralFeature(), null, "refEdgeToSource", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_RefTargetToEdge(), ecorePackage.getEStructuralFeature(), null, "refTargetToEdge", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_RefEdgeToTarget(), ecorePackage.getEStructuralFeature(), null, "refEdgeToTarget", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_RefSourceToTarget(), ecorePackage.getEStructuralFeature(), null, "refSourceToTarget", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getSourceTargetCouple_RefTargetToSource(), ecorePackage.getEStructuralFeature(), null, "refTargetToSource", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(modelObjectConfigurationEClass, ModelObjectConfiguration.class, "ModelObjectConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getModelObjectConfiguration_GenClass(), theGenModelPackage.getGenClass(), null, "genClass", null, 1, 1, ModelObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getModelObjectConfiguration_Diagrams(), this.getDiagramReference(), null, "diagrams", null, 0, -1, ModelObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

        addEOperation(modelObjectConfigurationEClass, ecorePackage.getEString(), "getName"); //$NON-NLS-1$

        initEClass(simpleObjectConfigurationEClass, SimpleObjectConfiguration.class, "SimpleObjectConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSimpleObjectConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, SimpleObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(edgeContainerTypeEEnum, EdgeContainerType.class, "EdgeContainerType"); //$NON-NLS-1$
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.NONE_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.SOURCE_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.SOURCE_CONTAINER_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.DIAGRAM_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.TARGET_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.TARGET_CONTAINER_LITERAL);

        initEEnum(resizableTypeEEnum, ResizableType.class, "ResizableType"); //$NON-NLS-1$
        addEEnumLiteral(resizableTypeEEnum, ResizableType.NONE_LITERAL);
        addEEnumLiteral(resizableTypeEEnum, ResizableType.WIDTH_LITERAL);
        addEEnumLiteral(resizableTypeEEnum, ResizableType.HEIGHT_LITERAL);
        addEEnumLiteral(resizableTypeEEnum, ResizableType.ALL_LITERAL);

        initEEnum(layoutTypeEEnum, LayoutType.class, "LayoutType"); //$NON-NLS-1$
        addEEnumLiteral(layoutTypeEEnum, LayoutType.XY_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.CLASS_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.TOOLBAR_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.PORT_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.MULTI_PORT_LAYOUT_LITERAL);

        initEEnum(decorationTypeEEnum, DecorationType.class, "DecorationType"); //$NON-NLS-1$
        addEEnumLiteral(decorationTypeEEnum, DecorationType.NONE_LITERAL);
        addEEnumLiteral(decorationTypeEEnum, DecorationType.ARROW_LITERAL);
        addEEnumLiteral(decorationTypeEEnum, DecorationType.TRIANGLE_LITERAL);
        addEEnumLiteral(decorationTypeEEnum, DecorationType.DIAMOND_LITERAL);

        initEEnum(routerTypeEEnum, RouterType.class, "RouterType"); //$NON-NLS-1$
        addEEnumLiteral(routerTypeEEnum, RouterType.OBLIQUE_ROUTER_LITERAL);
        addEEnumLiteral(routerTypeEEnum, RouterType.RECTILINEAR_ROUTER_LITERAL);
        addEEnumLiteral(routerTypeEEnum, RouterType.TREE_ROUTER_LITERAL);

        initEEnum(edgeObjectTypeEEnum, EdgeObjectType.class, "EdgeObjectType"); //$NON-NLS-1$
        addEEnumLiteral(edgeObjectTypeEEnum, EdgeObjectType.SOURCE_LITERAL);
        addEEnumLiteral(edgeObjectTypeEEnum, EdgeObjectType.MIDDLE_LITERAL);
        addEEnumLiteral(edgeObjectTypeEEnum, EdgeObjectType.TARGET_LITERAL);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.topcased.org/uuid
        createUuidAnnotations();
        // http://www.topcased.org/documentation
        createDocumentationAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.topcased.org/uuid</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createUuidAnnotations()
    {
        String source = "http://www.topcased.org/uuid"; //$NON-NLS-1$		
        addAnnotation
          (this, 
           source, 
           new String[] 
           {
             "uuid", "11319820411770" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (editorConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "11319820411811" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_Name(), 
           source, 
           new String[] 
           {
             "uuid", "11319820411834" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_ProjectName(), 
           source, 
           new String[] 
           {
             "uuid", "11319820411855" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_Prefix(), 
           source, 
           new String[] 
           {
             "uuid", "11319820411856" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_Extension(), 
           source, 
           new String[] 
           {
             "uuid", "11319820411867" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_ExtensionDiagram(), 
           source, 
           new String[] 
           {
             "uuid", "11319820411878" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_GenModel(), 
           source, 
           new String[] 
           {
             "uuid", "11319820411889" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_Diagrams(), 
           source, 
           new String[] 
           {
             "uuid", "113198204118910" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEditorConfiguration_Objects(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119011" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (diagramConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204119012" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Id(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119215" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Name(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119316" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Package(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119317" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Prefix(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119418" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Palette(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119519" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Parts(), 
           source, 
           new String[] 
           {
             "uuid", "113198204119620" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramConfiguration_Layout(), 
           source, 
           new String[] 
           {
             "uuid", "113198204120321" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (objectConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204120422" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (diagramReferenceEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204120423" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramReference_Diagram(), 
           source, 
           new String[] 
           {
             "uuid", "113198204120626" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramReference_LowerBound(), 
           source, 
           new String[] 
           {
             "uuid", "113198204120627" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDiagramReference_UpperBound(), 
           source, 
           new String[] 
           {
             "uuid", "113198204120728" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (paletteConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204120829" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPaletteConfiguration_Name(), 
           source, 
           new String[] 
           {
             "uuid", "113198204120932" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPaletteConfiguration_PaletteCategories(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121033" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (paletteCategoryEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204121134" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPaletteCategory_Name(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121237" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPaletteCategory_Items(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121338" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (partConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204121439" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPartConfiguration_Object(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121542" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPartConfiguration_DefaultForegroundColor(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121643" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPartConfiguration_ForegroundColorChangeable(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121744" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPartConfiguration_FontChangeable(), 
           source, 
           new String[] 
           {
             "uuid", "113198204121945" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (nodePartConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204122046" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_Type(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122149" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_ChildElements(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122250" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_SuperType(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122351" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_DefaultBackgroundColor(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122554" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_BackgroundColorChangeable(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122655" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_Resizing(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122756" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_Container(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122857" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_Layout(), 
           source, 
           new String[] 
           {
             "uuid", "113198204122958" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getNodePartConfiguration_DirectEditable(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123059" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (edgePartConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204123160" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgePartConfiguration_SourceTargetCouple(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123263" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgePartConfiguration_EdgeObjects(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123364" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgePartConfiguration_SourceDecoration(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123465" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgePartConfiguration_TargetDecoration(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123466" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgePartConfiguration_DefaultRouter(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123567" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgePartConfiguration_DirectEditable(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123668" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (edgeObjectEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204123769" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgeObject_Type(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123770" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getEdgeObject_EStructuralFeature(), 
           source, 
           new String[] 
           {
             "uuid", "113198204123871" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (paletteItemEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204123972" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPaletteItem_Name(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124075" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPaletteItem_Part(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124277" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (sourceTargetCoupleEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204124278" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_ContainerType(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124481" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_AutoRef(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124482" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_Reversible(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124583" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_ContainerObject(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124684" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_SourceNode(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124785" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_TargetNode(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124786" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_ContainerRef(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124887" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_RefSourceToEdge(), 
           source, 
           new String[] 
           {
             "uuid", "113198204124988" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_RefEdgeToSource(), 
           source, 
           new String[] 
           {
             "uuid", "113198204125089" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_RefTargetToEdge(), 
           source, 
           new String[] 
           {
             "uuid", "113198204125090" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_RefEdgeToTarget(), 
           source, 
           new String[] 
           {
             "uuid", "113198204125191" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_RefSourceToTarget(), 
           source, 
           new String[] 
           {
             "uuid", "113198204125292" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSourceTargetCouple_RefTargetToSource(), 
           source, 
           new String[] 
           {
             "uuid", "113198204128693" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (modelObjectConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204128694" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getModelObjectConfiguration_GenClass(), 
           source, 
           new String[] 
           {
             "uuid", "113198204128897" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getModelObjectConfiguration_Diagrams(), 
           source, 
           new String[] 
           {
             "uuid", "113198204128898" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (simpleObjectConfigurationEClass, 
           source, 
           new String[] 
           {
             "uuid", "113198204128999" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getSimpleObjectConfiguration_Name(), 
           source, 
           new String[] 
           {
             "uuid", "1131982041291102" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (edgeContainerTypeEEnum, 
           source, 
           new String[] 
           {
             "uuid", "1131982041292103" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "uuid", "1131982041293106" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "uuid", "1131982041294109" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "uuid", "1131982041296112" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(3), 
           source, 
           new String[] 
           {
             "uuid", "1131982041297115" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(4), 
           source, 
           new String[] 
           {
             "uuid", "1131982041298118" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(5), 
           source, 
           new String[] 
           {
             "uuid", "1131982041299121" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (resizableTypeEEnum, 
           source, 
           new String[] 
           {
             "uuid", "1131982041303129" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)resizableTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "uuid", "1131982041304132" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)resizableTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "uuid", "1131982041305133" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)resizableTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "uuid", "1131982041305134" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)resizableTypeEEnum.getELiterals().get(3), 
           source, 
           new String[] 
           {
             "uuid", "1131982041306135" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (layoutTypeEEnum, 
           source, 
           new String[] 
           {
             "uuid", "1131982041307136" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)layoutTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "uuid", "1131982041308139" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)layoutTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "uuid", "1131982041309140" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)layoutTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "uuid", "1131982041309141" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)layoutTypeEEnum.getELiterals().get(3), 
           source, 
           new String[] 
           {
             "uuid", "1131982041314142" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)layoutTypeEEnum.getELiterals().get(4), 
           source, 
           new String[] 
           {
             "uuid", "1131982041315143" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (decorationTypeEEnum, 
           source, 
           new String[] 
           {
             "uuid", "1131982041316144" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)decorationTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "uuid", "1131982041317147" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)decorationTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "uuid", "1131982041318148" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)decorationTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "uuid", "1131982041319149" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)decorationTypeEEnum.getELiterals().get(3), 
           source, 
           new String[] 
           {
             "uuid", "1131982041320150" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (routerTypeEEnum, 
           source, 
           new String[] 
           {
             "uuid", "1131982041320151" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)routerTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "uuid", "1131982041322154" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)routerTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "uuid", "1131982041323155" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)routerTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "uuid", "1131982041323156" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (edgeObjectTypeEEnum, 
           source, 
           new String[] 
           {
             "uuid", "1131982041324157" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)edgeObjectTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "uuid", "1131982041325160" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)edgeObjectTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "uuid", "1131982041326161" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          ((EEnumLiteral)edgeObjectTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "uuid", "1131982041327162" //$NON-NLS-1$ //$NON-NLS-2$
           });
    }

    /**
     * Initializes the annotations for <b>http://www.topcased.org/documentation</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createDocumentationAnnotations()
    {
        String source = "http://www.topcased.org/documentation"; //$NON-NLS-1$			
        addAnnotation
          (editorConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "This is the root model object." //$NON-NLS-1$ //$NON-NLS-2$
           });											
        addAnnotation
          (diagramConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "A DiagramConfiguration contains informations used to generate a Diagram" //$NON-NLS-1$ //$NON-NLS-2$
           });											
        addAnnotation
          (diagramReferenceEClass, 
           source, 
           new String[] 
           {
             "documentation", "A DiagramReference is linked with a DiagramConfiguration" //$NON-NLS-1$ //$NON-NLS-2$
           });						
        addAnnotation
          (paletteConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "This object groups all the PaletteCategories" //$NON-NLS-1$ //$NON-NLS-2$
           });					
        addAnnotation
          (paletteCategoryEClass, 
           source, 
           new String[] 
           {
             "documentation", "A PaletteCategory contains all the PaletteItem that will be displayed" //$NON-NLS-1$ //$NON-NLS-2$
           });					
        addAnnotation
          (partConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "A PartConfiguration will be associated with an EditPart at the generation process." //$NON-NLS-1$ //$NON-NLS-2$
           });							
        addAnnotation
          (nodePartConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "A PartConfiguration will be associated with a NodeEditPart at the generation process." //$NON-NLS-1$ //$NON-NLS-2$
           });												
        addAnnotation
          (edgePartConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "A PartConfiguration will be associated with an EdgeEditPart at the generation process." //$NON-NLS-1$ //$NON-NLS-2$
           });												
        addAnnotation
          (paletteItemEClass, 
           source, 
           new String[] 
           {
             "documentation", "A PaletteItem is necessary associated with an ObjectConfiguration. It will represent an item in a Palette of a given Diagram" //$NON-NLS-1$ //$NON-NLS-2$
           });					
        addAnnotation
          (sourceTargetCoupleEClass, 
           source, 
           new String[] 
           {
             "documentation", "It describes the different Policies to set for an EdgeEditPart" //$NON-NLS-1$ //$NON-NLS-2$
           });																
        addAnnotation
          (modelObjectConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "A ModelObjectConfiguration is associated with a model object through the genClass reference. It is eventually linked to several DiagramReference." //$NON-NLS-1$ //$NON-NLS-2$
           });					
        addAnnotation
          (simpleObjectConfigurationEClass, 
           source, 
           new String[] 
           {
             "documentation", "A SimpleObjectConfiguration is not linked with a model object. It has an attribute name that gives the string that will be used to reference the graphical object." //$NON-NLS-1$ //$NON-NLS-2$
           });				
        addAnnotation
          (edgeContainerTypeEEnum, 
           source, 
           new String[] 
           {
             "documentation", "The different ways where to add the Edge to the model" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(0), 
           source, 
           new String[] 
           {
             "documentation", "The Edge has no model association" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(1), 
           source, 
           new String[] 
           {
             "documentation", "The Source Node is the container of the Edge" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(2), 
           source, 
           new String[] 
           {
             "documentation", "The Source Container Node is the container of the Edge" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(3), 
           source, 
           new String[] 
           {
             "documentation", "The Model object associated with the current Diagram is the container of the Edge" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(4), 
           source, 
           new String[] 
           {
             "documentation", "The Target Node is the container of the Edge" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          ((EEnumLiteral)edgeContainerTypeEEnum.getELiterals().get(5), 
           source, 
           new String[] 
           {
             "documentation", "The Target Container Node is the container of the Edge" //$NON-NLS-1$ //$NON-NLS-2$
           });			
        addAnnotation
          (resizableTypeEEnum, 
           source, 
           new String[] 
           {
             "documentation", "The type of the Resizable EditPolicy" //$NON-NLS-1$ //$NON-NLS-2$
           });							
        addAnnotation
          (layoutTypeEEnum, 
           source, 
           new String[] 
           {
             "documentation", "The type of Layout that it will be used to display children DiagramElement" //$NON-NLS-1$ //$NON-NLS-2$
           });								
        addAnnotation
          (decorationTypeEEnum, 
           source, 
           new String[] 
           {
             "documentation", "Define the type of decoration that are available for a connection EndPoint." //$NON-NLS-1$ //$NON-NLS-2$
           });							
        addAnnotation
          (routerTypeEEnum, 
           source, 
           new String[] 
           {
             "documentation", "The type of Layout that it will be used to display children DiagramElement" //$NON-NLS-1$ //$NON-NLS-2$
           });						
        addAnnotation
          (edgeObjectTypeEEnum, 
           source, 
           new String[] 
           {
             "documentation", "The position that should be used to place the EdgeObject associated with the Edge" //$NON-NLS-1$ //$NON-NLS-2$
           });				
    }

} //ConfiguratorPackageImpl
