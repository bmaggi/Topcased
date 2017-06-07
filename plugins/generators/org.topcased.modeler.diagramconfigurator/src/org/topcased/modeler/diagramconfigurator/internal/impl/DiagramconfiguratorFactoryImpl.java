/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorFactoryImpl.java,v 1.5 2007/04/18 12:54:13 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jface.resource.DataFormatException;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
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
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteConfiguration;
import org.topcased.modeler.diagramconfigurator.PaletteItem;
import org.topcased.modeler.diagramconfigurator.PartAction;
import org.topcased.modeler.diagramconfigurator.ResizableType;
import org.topcased.modeler.diagramconfigurator.RouterType;
import org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramconfiguratorFactoryImpl extends EFactoryImpl implements DiagramconfiguratorFactory
{
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static DiagramconfiguratorFactory init()
    {
        try
        {
            DiagramconfiguratorFactory theDiagramconfiguratorFactory = (DiagramconfiguratorFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/diagramconfigurator/0.10");
            if (theDiagramconfiguratorFactory != null)
            {
                return theDiagramconfiguratorFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DiagramconfiguratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramconfiguratorFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION:
                return createDiagramConfiguration();
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE:
                return createDiagramReference();
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION:
                return createPaletteConfiguration();
            case DiagramconfiguratorPackage.PALETTE_CATEGORY:
                return createPaletteCategory();
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION:
                return createNodePartConfiguration();
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION:
                return createEdgePartConfiguration();
            case DiagramconfiguratorPackage.EDGE_OBJECT:
                return createEdgeObject();
            case DiagramconfiguratorPackage.PALETTE_ITEM:
                return createPaletteItem();
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE:
                return createSourceTargetCouple();
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION:
                return createModelObjectConfiguration();
            case DiagramconfiguratorPackage.SIMPLE_OBJECT_CONFIGURATION:
                return createSimpleObjectConfiguration();
            case DiagramconfiguratorPackage.CONSTRAINT:
                return createConstraint();
            case DiagramconfiguratorPackage.PART_ACTION:
                return createPartAction();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue)
    {
        switch (eDataType.getClassifierID())
        {
            case DiagramconfiguratorPackage.EDGE_CONTAINER_TYPE:
                return createEdgeContainerTypeFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.RESIZABLE_TYPE:
                return createResizableTypeFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.LAYOUT_TYPE:
                return createLayoutTypeFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.DECORATION_TYPE:
                return createDecorationTypeFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.ROUTER_TYPE:
                return createRouterTypeFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.EDGE_OBJECT_TYPE:
                return createEdgeObjectTypeFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.LINE_STYLE:
                return createLineStyleFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.COLOR:
                return createColorFromString(eDataType, initialValue);
            case DiagramconfiguratorPackage.FONT:
                return createFontFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue)
    {
        switch (eDataType.getClassifierID())
        {
            case DiagramconfiguratorPackage.EDGE_CONTAINER_TYPE:
                return convertEdgeContainerTypeToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.RESIZABLE_TYPE:
                return convertResizableTypeToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.LAYOUT_TYPE:
                return convertLayoutTypeToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.DECORATION_TYPE:
                return convertDecorationTypeToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.ROUTER_TYPE:
                return convertRouterTypeToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.EDGE_OBJECT_TYPE:
                return convertEdgeObjectTypeToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.LINE_STYLE:
                return convertLineStyleToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.COLOR:
                return convertColorToString(eDataType, instanceValue);
            case DiagramconfiguratorPackage.FONT:
                return convertFontToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramConfiguration createDiagramConfiguration()
    {
        DiagramConfigurationImpl diagramConfiguration = new DiagramConfigurationImpl();
        return diagramConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramReference createDiagramReference()
    {
        DiagramReferenceImpl diagramReference = new DiagramReferenceImpl();
        return diagramReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PaletteConfiguration createPaletteConfiguration()
    {
        PaletteConfigurationImpl paletteConfiguration = new PaletteConfigurationImpl();
        return paletteConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PaletteCategory createPaletteCategory()
    {
        PaletteCategoryImpl paletteCategory = new PaletteCategoryImpl();
        return paletteCategory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NodePartConfiguration createNodePartConfiguration()
    {
        NodePartConfigurationImpl nodePartConfiguration = new NodePartConfigurationImpl();
        return nodePartConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgePartConfiguration createEdgePartConfiguration()
    {
        EdgePartConfigurationImpl edgePartConfiguration = new EdgePartConfigurationImpl();
        return edgePartConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeObject createEdgeObject()
    {
        EdgeObjectImpl edgeObject = new EdgeObjectImpl();
        return edgeObject;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PaletteItem createPaletteItem()
    {
        PaletteItemImpl paletteItem = new PaletteItemImpl();
        return paletteItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SourceTargetCouple createSourceTargetCouple()
    {
        SourceTargetCoupleImpl sourceTargetCouple = new SourceTargetCoupleImpl();
        return sourceTargetCouple;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ModelObjectConfiguration createModelObjectConfiguration()
    {
        ModelObjectConfigurationImpl modelObjectConfiguration = new ModelObjectConfigurationImpl();
        return modelObjectConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimpleObjectConfiguration createSimpleObjectConfiguration()
    {
        SimpleObjectConfigurationImpl simpleObjectConfiguration = new SimpleObjectConfigurationImpl();
        return simpleObjectConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Constraint createConstraint()
    {
        ConstraintImpl constraint = new ConstraintImpl();
        return constraint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartAction createPartAction()
    {
        PartActionImpl partAction = new PartActionImpl();
        return partAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeContainerType createEdgeContainerTypeFromString(EDataType eDataType, String initialValue)
    {
        EdgeContainerType result = EdgeContainerType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertEdgeContainerTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResizableType createResizableTypeFromString(EDataType eDataType, String initialValue)
    {
        ResizableType result = ResizableType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertResizableTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public LayoutType createLayoutTypeFromString(EDataType eDataType, String initialValue)
    {
        LayoutType result = LayoutType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertLayoutTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DecorationType createDecorationTypeFromString(EDataType eDataType, String initialValue)
    {
        DecorationType result = DecorationType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertDecorationTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RouterType createRouterTypeFromString(EDataType eDataType, String initialValue)
    {
        RouterType result = RouterType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertRouterTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeObjectType createEdgeObjectTypeFromString(EDataType eDataType, String initialValue)
    {
        EdgeObjectType result = EdgeObjectType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertEdgeObjectTypeToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public LineStyle createLineStyleFromString(EDataType eDataType, String initialValue)
    {
        LineStyle result = LineStyle.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertLineStyleToString(EDataType eDataType, Object instanceValue)
    {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Color createColorFromString(EDataType eDataType, String initialValue)
    {
        Color color = JFaceResources.getColorRegistry().get("0,0,0");

        try
        {
            RGB rgb = StringConverter.asRGB(initialValue);

            color = JFaceResources.getColorRegistry().get(initialValue);
            if (color == null)
            {
                JFaceResources.getColorRegistry().put(initialValue, rgb);
                color = JFaceResources.getColorRegistry().get(initialValue);
            }
        }
        catch (DataFormatException dfe)
        {
            // DiagramConfiguratorPlugin.log("The color has not the desired format", IStatus.WARNING);
        }

        return color;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertColorToString(EDataType eDataType, Object instanceValue)
    {
        if (instanceValue == null)
        {
            return "0,0,0";
        }
        Color color = (Color) instanceValue;
        return StringConverter.asString(color.getRGB());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Font createFontFromString(EDataType eDataType, String initialValue)
    {
        Font font = JFaceResources.getFontRegistry().defaultFont();

        try
        {
            FontData fontData = StringConverter.asFontData(initialValue);

            if (fontData != null)
            {
                FontData[] fontDataList = new FontData[1];
                fontDataList[0] = fontData;
                JFaceResources.getFontRegistry().put(StringConverter.asString(fontData), fontDataList);
                // the get on a font always return a font even if this font is
                // not registered
                font = JFaceResources.getFontRegistry().get(initialValue);
            }
        }
        catch (DataFormatException dfe)
        {
            // DiagramConfiguratorPlugin.log(dfe.getMessage(), IStatus.WARNING);
        }

        return font;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertFontToString(EDataType eDataType, Object instanceValue)
    {
        if (instanceValue == null)
        {
            return StringConverter.asString(JFaceResources.getFontRegistry().defaultFont().getFontData()[0]);
        }
        Font font = (Font) instanceValue;
        return StringConverter.asString(font.getFontData()[0]);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramconfiguratorPackage getDiagramconfiguratorPackage()
    {
        return (DiagramconfiguratorPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DiagramconfiguratorPackage getPackage()
    {
        return DiagramconfiguratorPackage.eINSTANCE;
    }

} // DiagramconfiguratorFactoryImpl
