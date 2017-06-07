/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorPackageImpl.java,v 1.6 2008/04/15 10:09:39 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.topcased.modeler.diagramconfigurator.Constraint;
import org.topcased.modeler.diagramconfigurator.DecorationType;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramReference;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeContainerType;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.EdgeObjectType;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.LayoutType;
import org.topcased.modeler.diagramconfigurator.LineStyle;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteItem;
import org.topcased.modeler.diagramconfigurator.PartAction;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.ResizableType;
import org.topcased.modeler.diagramconfigurator.RouterType;
import org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;
import org.topcased.modeler.diagramconfigurator.util.DiagramconfiguratorValidator;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramconfiguratorPackageImpl extends EPackageImpl implements DiagramconfiguratorPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass diagramConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass objectConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass diagramReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass paletteConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass paletteCategoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass partConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nodePartConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass edgePartConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass edgeObjectEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass paletteItemEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass sourceTargetCoupleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modelObjectConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simpleObjectConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass constraintEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass partActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum edgeContainerTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum resizableTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum layoutTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum decorationTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum routerTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum edgeObjectTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum lineStyleEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType colorEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType fontEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DiagramconfiguratorPackageImpl()
    {
        super(eNS_URI, DiagramconfiguratorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else.
     * This method drives initialization for interdependent packages directly, in parallel with this package, itself.
     * <p>
     * Of this package and its interdependencies, all packages which have not yet been registered by their URI values
     * are first created and registered. The packages are then initialized in two steps: meta-model objects for all of
     * the packages are created before any are initialized, since one package's meta-model objects may refer to those of
     * another.
     * <p>
     * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DiagramconfiguratorPackage init()
    {
        if (isInited)
            return (DiagramconfiguratorPackage) EPackage.Registry.INSTANCE.getEPackage(DiagramconfiguratorPackage.eNS_URI);

        // Obtain or create and register package
        DiagramconfiguratorPackageImpl theDiagramconfiguratorPackage = (DiagramconfiguratorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DiagramconfiguratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
                : new DiagramconfiguratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();
        EditorconfiguratorPackage.eINSTANCE.eClass();
        GenModelPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theDiagramconfiguratorPackage.createPackageContents();

        // Initialize created meta-data
        theDiagramconfiguratorPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put(theDiagramconfiguratorPackage, new EValidator.Descriptor()
        {
            public EValidator getEValidator()
            {
                return DiagramconfiguratorValidator.INSTANCE;
            }
        });

        // Mark meta-data to indicate it can't be changed
        theDiagramconfiguratorPackage.freeze();

        return theDiagramconfiguratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDiagramConfiguration()
    {
        return diagramConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_ProjectName()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_Name()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_Package()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_Prefix()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramConfiguration_Palette()
    {
        return (EReference) diagramConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramConfiguration_Parts()
    {
        return (EReference) diagramConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_Layout()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramConfiguration_Objects()
    {
        return (EReference) diagramConfigurationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramConfiguration_GenModel()
    {
        return (EReference) diagramConfigurationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_DefaultBackgroundColor()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_DefaultForegroundColor()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_DefaultFont()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramConfiguration_TemplateRootObject()
    {
        return (EReference) diagramConfigurationEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_ForceOverwrite()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_OverwriteGraphConf()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_OrganizeImports()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramConfiguration_EditorConfigurator()
    {
        return (EReference) diagramConfigurationEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_CopyrightText()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_PluginVersion()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_Provider()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramConfiguration_SamePluginAsEditor()
    {
        return (EAttribute) diagramConfigurationEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getObjectConfiguration()
    {
        return objectConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getDiagramReference()
    {
        return diagramReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getDiagramReference_Diagram()
    {
        return (EReference) diagramReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramReference_LowerBound()
    {
        return (EAttribute) diagramReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getDiagramReference_UpperBound()
    {
        return (EAttribute) diagramReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPaletteConfiguration()
    {
        return paletteConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPaletteConfiguration_Name()
    {
        return (EAttribute) paletteConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPaletteConfiguration_PaletteCategories()
    {
        return (EReference) paletteConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPaletteCategory()
    {
        return paletteCategoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPaletteCategory_Name()
    {
        return (EAttribute) paletteCategoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPaletteCategory_Items()
    {
        return (EReference) paletteCategoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPartConfiguration()
    {
        return partConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPartConfiguration_Object()
    {
        return (EReference) partConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_Presentation()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_DefaultForegroundColor()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_ForegroundColorChangeable()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_DefaultFont()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_FontChangeable()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_LineWidth()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_LineStyle()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPartConfiguration_Constraint()
    {
        return (EReference) partConfigurationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartConfiguration_Prefix()
    {
        return (EAttribute) partConfigurationEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPartConfiguration_Actions()
    {
        return (EReference) partConfigurationEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNodePartConfiguration()
    {
        return nodePartConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_Type()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getNodePartConfiguration_ChildElements()
    {
        return (EReference) nodePartConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getNodePartConfiguration_SuperType()
    {
        return (EReference) nodePartConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_DefaultBackgroundColor()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_BackgroundColorChangeable()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_Resizing()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_Container()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_Layout()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_DirectEditable()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_DefaultWidth()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_DefaultHeight()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_MinimumWidth()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_MinimumHeight()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_MaximumWidth()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_MaximumHeight()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getNodePartConfiguration_AttachedToBorder()
    {
        return (EAttribute) nodePartConfigurationEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEdgePartConfiguration()
    {
        return edgePartConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEdgePartConfiguration_SourceTargetCouple()
    {
        return (EReference) edgePartConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEdgePartConfiguration_EdgeObjects()
    {
        return (EReference) edgePartConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEdgePartConfiguration_SourceDecoration()
    {
        return (EAttribute) edgePartConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEdgePartConfiguration_TargetDecoration()
    {
        return (EAttribute) edgePartConfigurationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEdgePartConfiguration_DefaultRouter()
    {
        return (EAttribute) edgePartConfigurationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEdgePartConfiguration_DirectEditable()
    {
        return (EReference) edgePartConfigurationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEdgeObject()
    {
        return edgeObjectEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEdgeObject_Id()
    {
        return (EAttribute) edgeObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getEdgeObject_Type()
    {
        return (EAttribute) edgeObjectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getEdgeObject_EStructuralFeature()
    {
        return (EReference) edgeObjectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPaletteItem()
    {
        return paletteItemEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPaletteItem_Name()
    {
        return (EAttribute) paletteItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPaletteItem_Part()
    {
        return (EReference) paletteItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSourceTargetCouple()
    {
        return sourceTargetCoupleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getSourceTargetCouple_ContainerType()
    {
        return (EAttribute) sourceTargetCoupleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getSourceTargetCouple_AutoRef()
    {
        return (EAttribute) sourceTargetCoupleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getSourceTargetCouple_Reversible()
    {
        return (EAttribute) sourceTargetCoupleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_ContainerObject()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_SourceNode()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_TargetNode()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_ContainerRef()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_RefSourceToEdge()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_RefEdgeToSource()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_RefTargetToEdge()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_RefEdgeToTarget()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_RefSourceToTarget()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSourceTargetCouple_RefTargetToSource()
    {
        return (EReference) sourceTargetCoupleEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getModelObjectConfiguration()
    {
        return modelObjectConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getModelObjectConfiguration_GenClass()
    {
        return (EReference) modelObjectConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getModelObjectConfiguration_Diagrams()
    {
        return (EReference) modelObjectConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSimpleObjectConfiguration()
    {
        return simpleObjectConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getSimpleObjectConfiguration_Name()
    {
        return (EAttribute) simpleObjectConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getConstraint()
    {
        return constraintEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getConstraint_Language()
    {
        return (EAttribute) constraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getConstraint_Rule()
    {
        return (EAttribute) constraintEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPartAction()
    {
        return partActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartAction_Prefix()
    {
        return (EAttribute) partActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartAction_MenuBarGroup()
    {
        return (EAttribute) partActionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartAction_Label()
    {
        return (EAttribute) partActionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPartAction_Icon()
    {
        return (EAttribute) partActionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getEdgeContainerType()
    {
        return edgeContainerTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getResizableType()
    {
        return resizableTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getLayoutType()
    {
        return layoutTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getDecorationType()
    {
        return decorationTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getRouterType()
    {
        return routerTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getEdgeObjectType()
    {
        return edgeObjectTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EEnum getLineStyle()
    {
        return lineStyleEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EDataType getColor()
    {
        return colorEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EDataType getFont()
    {
        return fontEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramconfiguratorFactory getDiagramconfiguratorFactory()
    {
        return (DiagramconfiguratorFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
     * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        diagramConfigurationEClass = createEClass(DIAGRAM_CONFIGURATION);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PROJECT_NAME);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__NAME);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PACKAGE);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PREFIX);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PALETTE);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PARTS);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__LAYOUT);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__OBJECTS);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__GEN_MODEL);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__DEFAULT_FONT);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__FORCE_OVERWRITE);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS);
        createEReference(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PLUGIN_VERSION);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__PROVIDER);
        createEAttribute(diagramConfigurationEClass, DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR);

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
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__PRESENTATION);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__DEFAULT_FONT);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__FONT_CHANGEABLE);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__LINE_WIDTH);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__LINE_STYLE);
        createEReference(partConfigurationEClass, PART_CONFIGURATION__CONSTRAINT);
        createEAttribute(partConfigurationEClass, PART_CONFIGURATION__PREFIX);
        createEReference(partConfigurationEClass, PART_CONFIGURATION__ACTIONS);

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
        createEAttribute(nodePartConfigurationEClass, NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER);

        edgePartConfigurationEClass = createEClass(EDGE_PART_CONFIGURATION);
        createEReference(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE);
        createEReference(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__EDGE_OBJECTS);
        createEAttribute(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__SOURCE_DECORATION);
        createEAttribute(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__TARGET_DECORATION);
        createEAttribute(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__DEFAULT_ROUTER);
        createEReference(edgePartConfigurationEClass, EDGE_PART_CONFIGURATION__DIRECT_EDITABLE);

        edgeObjectEClass = createEClass(EDGE_OBJECT);
        createEAttribute(edgeObjectEClass, EDGE_OBJECT__ID);
        createEAttribute(edgeObjectEClass, EDGE_OBJECT__TYPE);
        createEReference(edgeObjectEClass, EDGE_OBJECT__ESTRUCTURAL_FEATURE);

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

        constraintEClass = createEClass(CONSTRAINT);
        createEAttribute(constraintEClass, CONSTRAINT__LANGUAGE);
        createEAttribute(constraintEClass, CONSTRAINT__RULE);

        partActionEClass = createEClass(PART_ACTION);
        createEAttribute(partActionEClass, PART_ACTION__PREFIX);
        createEAttribute(partActionEClass, PART_ACTION__MENU_BAR_GROUP);
        createEAttribute(partActionEClass, PART_ACTION__LABEL);
        createEAttribute(partActionEClass, PART_ACTION__ICON);

        // Create enums
        edgeContainerTypeEEnum = createEEnum(EDGE_CONTAINER_TYPE);
        resizableTypeEEnum = createEEnum(RESIZABLE_TYPE);
        layoutTypeEEnum = createEEnum(LAYOUT_TYPE);
        decorationTypeEEnum = createEEnum(DECORATION_TYPE);
        routerTypeEEnum = createEEnum(ROUTER_TYPE);
        edgeObjectTypeEEnum = createEEnum(EDGE_OBJECT_TYPE);
        lineStyleEEnum = createEEnum(LINE_STYLE);

        // Create data types
        colorEDataType = createEDataType(COLOR);
        fontEDataType = createEDataType(FONT);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
     * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents()
    {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        GenModelPackage theGenModelPackage = (GenModelPackage) EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);
        EditorconfiguratorPackage theEditorconfiguratorPackage = (EditorconfiguratorPackage) EPackage.Registry.INSTANCE.getEPackage(EditorconfiguratorPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        nodePartConfigurationEClass.getESuperTypes().add(this.getPartConfiguration());
        edgePartConfigurationEClass.getESuperTypes().add(this.getPartConfiguration());
        paletteItemEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
        modelObjectConfigurationEClass.getESuperTypes().add(this.getObjectConfiguration());
        simpleObjectConfigurationEClass.getESuperTypes().add(this.getObjectConfiguration());

        // Initialize classes and features; add operations and parameters
        initEClass(diagramConfigurationEClass, DiagramConfiguration.class, "DiagramConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDiagramConfiguration_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_Package(), ecorePackage.getEString(), "package", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramConfiguration_Palette(), this.getPaletteConfiguration(), null, "palette", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramConfiguration_Parts(), this.getPartConfiguration(), null, "parts", null, 1, -1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_Layout(), this.getLayoutType(), "layout", "XYLayout", 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramConfiguration_Objects(), this.getObjectConfiguration(), null, "objects", null, 1, -1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramConfiguration_GenModel(), theGenModelPackage.getGenModel(), null, "genModel", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_DefaultBackgroundColor(), this.getColor(), "defaultBackgroundColor", "255,255,255", 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_DefaultForegroundColor(), this.getColor(), "defaultForegroundColor", "0,0,0", 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_DefaultFont(), this.getFont(), "defaultFont", "", 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramConfiguration_TemplateRootObject(), theGenModelPackage.getGenClass(), null, "templateRootObject", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_ForceOverwrite(), ecorePackage.getEBoolean(), "forceOverwrite", "false", 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_OverwriteGraphConf(), ecorePackage.getEBoolean(), "overwriteGraphConf", "true", 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_OrganizeImports(), ecorePackage.getEBoolean(), "organizeImports", "true", 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDiagramConfiguration_EditorConfigurator(), theEditorconfiguratorPackage.getEditorConfiguration(), null, "editorConfigurator", null, 1, 1, DiagramConfiguration.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_CopyrightText(), ecorePackage.getEString(), "copyrightText", null, 0, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_PluginVersion(), ecorePackage.getEString(), "pluginVersion", null, 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_Provider(), ecorePackage.getEString(), "provider", "Topcased", 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramConfiguration_SamePluginAsEditor(), ecorePackage.getEBoolean(), "samePluginAsEditor", "false", 1, 1, DiagramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(diagramConfigurationEClass, ecorePackage.getEString(), "getBasePackage", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(objectConfigurationEClass, ObjectConfiguration.class, "ObjectConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        addEOperation(objectConfigurationEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(diagramReferenceEClass, DiagramReference.class, "DiagramReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDiagramReference_Diagram(), this.getDiagramConfiguration(), null, "diagram", null, 1, 1, DiagramReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDiagramReference_LowerBound(), ecorePackage.getEInt(), "lowerBound", "0", 0, 1, DiagramReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getDiagramReference_UpperBound(), ecorePackage.getEInt(), "upperBound", "-1", 0, 1, DiagramReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(paletteConfigurationEClass, PaletteConfiguration.class, "PaletteConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPaletteConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, PaletteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPaletteConfiguration_PaletteCategories(), this.getPaletteCategory(), null, "paletteCategories", null, 1, -1, PaletteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(paletteCategoryEClass, PaletteCategory.class, "PaletteCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPaletteCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, PaletteCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getPaletteCategory_Items(), this.getPaletteItem(), null, "items", null, 1, -1, PaletteCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(partConfigurationEClass, PartConfiguration.class, "PartConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPartConfiguration_Object(), this.getObjectConfiguration(), null, "object", null, 1, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_Presentation(), ecorePackage.getEString(), "presentation", "default", 1, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_DefaultForegroundColor(), this.getColor(), "defaultForegroundColor", "0,0,0", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_ForegroundColorChangeable(), ecorePackage.getEBoolean(), "foregroundColorChangeable", "true", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_DefaultFont(), this.getFont(), "defaultFont", null, 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_FontChangeable(), ecorePackage.getEBoolean(), "fontChangeable", "true", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_LineWidth(), ecorePackage.getEInt(), "lineWidth", "1", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_LineStyle(), this.getLineStyle(), "lineStyle", "SOLID", 0, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPartConfiguration_Constraint(), this.getConstraint(), null, "constraint", null, 0, -1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartConfiguration_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPartConfiguration_Actions(), this.getPartAction(), null, "actions", null, 0, -1, PartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(partConfigurationEClass, ecorePackage.getEBoolean(), "isAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(nodePartConfigurationEClass, NodePartConfiguration.class, "NodePartConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNodePartConfiguration_Type(), ecorePackage.getEString(), "type", "Figure", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNodePartConfiguration_ChildElements(), this.getNodePartConfiguration(), null, "childElements", null, 0, -1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNodePartConfiguration_SuperType(), this.getNodePartConfiguration(), null, "superType", null, 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_DefaultBackgroundColor(), this.getColor(), "defaultBackgroundColor", "255,255,255", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_BackgroundColorChangeable(), ecorePackage.getEBoolean(), "backgroundColorChangeable", "true", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_Resizing(), this.getResizableType(), "resizing", "ALL", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_Container(), ecorePackage.getEBoolean(), "container", "false", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_Layout(), this.getLayoutType(), "layout", "XYLayout", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_DirectEditable(), ecorePackage.getEBoolean(), "directEditable", "true", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_DefaultWidth(), ecorePackage.getEInt(), "defaultWidth", "50", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_DefaultHeight(), ecorePackage.getEInt(), "defaultHeight", "50", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_MinimumWidth(), ecorePackage.getEInt(), "minimumWidth", "20", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_MinimumHeight(), ecorePackage.getEInt(), "minimumHeight", "20", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_MaximumWidth(), ecorePackage.getEInt(), "maximumWidth", "200", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_MaximumHeight(), ecorePackage.getEInt(), "maximumHeight", "200", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNodePartConfiguration_AttachedToBorder(), ecorePackage.getEBoolean(), "attachedToBorder", "false", 0, 1, NodePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(edgePartConfigurationEClass, EdgePartConfiguration.class, "EdgePartConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEdgePartConfiguration_SourceTargetCouple(), this.getSourceTargetCouple(), null, "sourceTargetCouple", null, 1, -1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEdgePartConfiguration_EdgeObjects(), this.getEdgeObject(), null, "edgeObjects", null, 0, -1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEdgePartConfiguration_SourceDecoration(), this.getDecorationType(), "sourceDecoration", "NONE", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEdgePartConfiguration_TargetDecoration(), this.getDecorationType(), "targetDecoration", "NONE", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEdgePartConfiguration_DefaultRouter(), this.getRouterType(), "defaultRouter", "ObliqueRouter", 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEdgePartConfiguration_DirectEditable(), this.getEdgeObject(), null, "directEditable", null, 0, 1, EdgePartConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(edgeObjectEClass, EdgeObject.class, "EdgeObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEdgeObject_Id(), ecorePackage.getEString(), "id", null, 1, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getEdgeObject_Type(), this.getEdgeObjectType(), "type", "Source", 0, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getEdgeObject_EStructuralFeature(), ecorePackage.getEStructuralFeature(), null, "eStructuralFeature", null, 0, 1, EdgeObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(paletteItemEClass, PaletteItem.class, "PaletteItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPaletteItem_Name(), ecorePackage.getEString(), "name", null, 1, 1, PaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getPaletteItem_Part(), this.getPartConfiguration(), null, "part", null, 1, 1, PaletteItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sourceTargetCoupleEClass, SourceTargetCouple.class, "SourceTargetCouple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSourceTargetCouple_ContainerType(), this.getEdgeContainerType(), "containerType", "NONE", 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSourceTargetCouple_AutoRef(), ecorePackage.getEBoolean(), "autoRef", "false", 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSourceTargetCouple_Reversible(), ecorePackage.getEBoolean(), "reversible", "false", 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_ContainerObject(), theGenModelPackage.getGenClass(), null, "containerObject", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_SourceNode(), this.getPartConfiguration(), null, "sourceNode", null, 1, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_TargetNode(), this.getPartConfiguration(), null, "targetNode", null, 1, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_ContainerRef(), ecorePackage.getEStructuralFeature(), null, "containerRef", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_RefSourceToEdge(), ecorePackage.getEStructuralFeature(), null, "refSourceToEdge", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_RefEdgeToSource(), ecorePackage.getEStructuralFeature(), null, "refEdgeToSource", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_RefTargetToEdge(), ecorePackage.getEStructuralFeature(), null, "refTargetToEdge", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_RefEdgeToTarget(), ecorePackage.getEStructuralFeature(), null, "refEdgeToTarget", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_RefSourceToTarget(), ecorePackage.getEStructuralFeature(), null, "refSourceToTarget", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSourceTargetCouple_RefTargetToSource(), ecorePackage.getEStructuralFeature(), null, "refTargetToSource", null, 0, 1, SourceTargetCouple.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(modelObjectConfigurationEClass, ModelObjectConfiguration.class, "ModelObjectConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getModelObjectConfiguration_GenClass(), theGenModelPackage.getGenClass(), null, "genClass", null, 1, 1, ModelObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModelObjectConfiguration_Diagrams(), this.getDiagramReference(), null, "diagrams", null, 0, -1, ModelObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        addEOperation(modelObjectConfigurationEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(simpleObjectConfigurationEClass, SimpleObjectConfiguration.class, "SimpleObjectConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSimpleObjectConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, SimpleObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConstraint_Language(), ecorePackage.getEString(), "language", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConstraint_Rule(), ecorePackage.getEString(), "rule", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(partActionEClass, PartAction.class, "PartAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPartAction_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, PartAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartAction_MenuBarGroup(), ecorePackage.getEString(), "menuBarGroup", null, 1, 1, PartAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartAction_Label(), ecorePackage.getEString(), "label", null, 1, 1, PartAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPartAction_Icon(), theEcorePackage.getEString(), "icon", null, 0, 1, PartAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(edgeContainerTypeEEnum, EdgeContainerType.class, "EdgeContainerType");
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.NONE_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.SOURCE_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.SOURCE_CONTAINER_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.DIAGRAM_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.TARGET_LITERAL);
        addEEnumLiteral(edgeContainerTypeEEnum, EdgeContainerType.TARGET_CONTAINER_LITERAL);

        initEEnum(resizableTypeEEnum, ResizableType.class, "ResizableType");
        addEEnumLiteral(resizableTypeEEnum, ResizableType.NONE_LITERAL);
        addEEnumLiteral(resizableTypeEEnum, ResizableType.WIDTH_LITERAL);
        addEEnumLiteral(resizableTypeEEnum, ResizableType.HEIGHT_LITERAL);
        addEEnumLiteral(resizableTypeEEnum, ResizableType.ALL_LITERAL);

        initEEnum(layoutTypeEEnum, LayoutType.class, "LayoutType");
        addEEnumLiteral(layoutTypeEEnum, LayoutType.XY_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.CLASS_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.TOOLBAR_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.PORT_LAYOUT_LITERAL);
        addEEnumLiteral(layoutTypeEEnum, LayoutType.MULTI_PORT_LAYOUT_LITERAL);

        initEEnum(decorationTypeEEnum, DecorationType.class, "DecorationType");
        addEEnumLiteral(decorationTypeEEnum, DecorationType.NONE_LITERAL);
        addEEnumLiteral(decorationTypeEEnum, DecorationType.ARROW_LITERAL);
        addEEnumLiteral(decorationTypeEEnum, DecorationType.TRIANGLE_LITERAL);
        addEEnumLiteral(decorationTypeEEnum, DecorationType.DIAMOND_LITERAL);

        initEEnum(routerTypeEEnum, RouterType.class, "RouterType");
        addEEnumLiteral(routerTypeEEnum, RouterType.OBLIQUE_ROUTER_LITERAL);
        addEEnumLiteral(routerTypeEEnum, RouterType.RECTILINEAR_ROUTER_LITERAL);
        addEEnumLiteral(routerTypeEEnum, RouterType.TREE_ROUTER_LITERAL);

        initEEnum(edgeObjectTypeEEnum, EdgeObjectType.class, "EdgeObjectType");
        addEEnumLiteral(edgeObjectTypeEEnum, EdgeObjectType.SOURCE_LITERAL);
        addEEnumLiteral(edgeObjectTypeEEnum, EdgeObjectType.MIDDLE_LITERAL);
        addEEnumLiteral(edgeObjectTypeEEnum, EdgeObjectType.TARGET_LITERAL);

        initEEnum(lineStyleEEnum, LineStyle.class, "LineStyle");
        addEEnumLiteral(lineStyleEEnum, LineStyle.SOLID_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DASH_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DOT_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DASHDOT_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.DASHDOTDOT_LITERAL);
        addEEnumLiteral(lineStyleEEnum, LineStyle.CUSTOM_LITERAL);

        // Initialize data types
        initEDataType(colorEDataType, Color.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(fontEDataType, Font.class, "Font", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.topcased.org/documentation
        createDocumentationAnnotations();
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.topcased.org/documentation</b>. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void createDocumentationAnnotations()
    {
        String source = "http://www.topcased.org/documentation";
        addAnnotation(diagramConfigurationEClass, source, new String[] {"documentation", "A DiagramConfiguration contains informations used to generate a Diagram"});
        addAnnotation(diagramReferenceEClass, source, new String[] {"documentation", "A DiagramReference is linked with a DiagramConfiguration"});
        addAnnotation(paletteConfigurationEClass, source, new String[] {"documentation", "This object groups all the PaletteCategories"});
        addAnnotation(paletteCategoryEClass, source, new String[] {"documentation", "A PaletteCategory contains all the PaletteItem that will be displayed"});
        addAnnotation(partConfigurationEClass, source, new String[] {"documentation", "A PartConfiguration will be associated with an EditPart at the generation process."});
        addAnnotation(nodePartConfigurationEClass, source, new String[] {"documentation", "A PartConfiguration will be associated with a NodeEditPart at the generation process."});
        addAnnotation(edgePartConfigurationEClass, source, new String[] {"documentation", "A PartConfiguration will be associated with an EdgeEditPart at the generation process."});
        addAnnotation(paletteItemEClass, source, new String[] {"documentation",
                "A PaletteItem is necessary associated with an ObjectConfiguration. It will represent an item in a Palette of a given Diagram"});
        addAnnotation(sourceTargetCoupleEClass, source, new String[] {"documentation", "It describes the different Policies to set for an EdgeEditPart"});
        addAnnotation(modelObjectConfigurationEClass, source, new String[] {"documentation",
                "A ModelObjectConfiguration is associated with a model object through the genClass reference. It is eventually linked to several DiagramReference."});
        addAnnotation(simpleObjectConfigurationEClass, source, new String[] {"documentation",
                "A SimpleObjectConfiguration is not linked with a model object. It has an attribute name that gives the string that will be used to reference the graphical object."});
        addAnnotation(partActionEClass, source, new String[] {"documentation",
                "A PartAction contains information to generate an action on a part (a graphical element).\r\nThe UI source code is fully generated, but only the stub of the command is generated."});
        addAnnotation(edgeContainerTypeEEnum, source, new String[] {"documentation", "The different ways where to add the Edge to the model"});
        addAnnotation(edgeContainerTypeEEnum.getELiterals().get(0), source, new String[] {"documentation", "The Edge has no model association"});
        addAnnotation(edgeContainerTypeEEnum.getELiterals().get(1), source, new String[] {"documentation", "The Source Node is the container of the Edge"});
        addAnnotation(edgeContainerTypeEEnum.getELiterals().get(2), source, new String[] {"documentation", "The Source Container Node is the container of the Edge"});
        addAnnotation(edgeContainerTypeEEnum.getELiterals().get(3), source, new String[] {"documentation", "The Model object associated with the current Diagram is the container of the Edge"});
        addAnnotation(edgeContainerTypeEEnum.getELiterals().get(4), source, new String[] {"documentation", "The Target Node is the container of the Edge"});
        addAnnotation(edgeContainerTypeEEnum.getELiterals().get(5), source, new String[] {"documentation", "The Target Container Node is the container of the Edge"});
        addAnnotation(resizableTypeEEnum, source, new String[] {"documentation", "The type of the Resizable EditPolicy"});
        addAnnotation(layoutTypeEEnum, source, new String[] {"documentation", "The type of Layout that it will be used to display children DiagramElement"});
        addAnnotation(decorationTypeEEnum, source, new String[] {"documentation", "Define the type of decoration that are available for a connection EndPoint."});
        addAnnotation(routerTypeEEnum, source, new String[] {"documentation", "The type of Layout that it will be used to display children DiagramElement"});
        addAnnotation(edgeObjectTypeEEnum, source, new String[] {"documentation", "The position that should be used to place the EdgeObject associated with the Edge"});
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void createEcoreAnnotations()
    {
        String source = "http://www.eclipse.org/emf/2002/Ecore";
        addAnnotation(diagramConfigurationEClass, source, new String[] {"constraints", "Prefix Package PartsPrefixUnicity ObjectsNameUnicity"});
        addAnnotation(paletteCategoryEClass, source, new String[] {"constraints", "Name PaletteItemsNameUnicity"});
        addAnnotation(nodePartConfigurationEClass, source, new String[] {"constraints", "Container"});
        addAnnotation(edgePartConfigurationEClass, source, new String[] {"constraints", "DirectEditable"});
        addAnnotation(edgeObjectEClass, source, new String[] {"constraints", "Id EStructuralFeature"});
        addAnnotation(sourceTargetCoupleEClass, source, new String[] {"constraints",
                "SourceNode TargetNode ContainerType ContainerObject ContainerRef RefSourceToEdge RefEdgeToSource RefTargetToEdge RefEdgeToTarget RefSourceToTarget RefTargetToSource RefConstraint"});
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createExtendedMetaDataAnnotations()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
        addAnnotation(getDiagramConfiguration_ProjectName(), source, new String[] {"name", "id", "kind", "attribute"});
    }

} // DiagramconfiguratorPackageImpl
