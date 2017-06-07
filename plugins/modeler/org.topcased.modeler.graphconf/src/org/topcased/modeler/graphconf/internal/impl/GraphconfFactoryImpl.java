/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphconfFactoryImpl.java,v 1.3 2006/12/18 15:21:43 jako Exp $
 */
package org.topcased.modeler.graphconf.internal.impl;

import org.eclipse.core.runtime.IStatus;
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
import org.topcased.modeler.graphconf.Constraint;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.GraphconfFactory;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.LineStyle;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.graphconf.RouterType;
import org.topcased.modeler.graphconf.StringBridge;
import org.topcased.modeler.graphconf.internal.GraphConfPlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class GraphconfFactoryImpl extends EFactoryImpl implements GraphconfFactory
{
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static GraphconfFactory init()
    {
        try
        {
            GraphconfFactory theGraphconfFactory = (GraphconfFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/1.0/graphconf");
            if (theGraphconfFactory != null)
            {
                return theGraphconfFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new GraphconfFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF:
                return createDiagramGraphConf();
            case GraphconfPackage.NODE_GRAPH_CONF:
                return createNodeGraphConf();
            case GraphconfPackage.EDGE_GRAPH_CONF:
                return createEdgeGraphConf();
            case GraphconfPackage.EMF_BRIDGE:
                return createEMFBridge();
            case GraphconfPackage.STRING_BRIDGE:
                return createStringBridge();
            case GraphconfPackage.CONSTRAINT:
                return createConstraint();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object createFromString(EDataType eDataType, String initialValue)
    {
        switch (eDataType.getClassifierID())
        {
            case GraphconfPackage.LINE_STYLE:
                return createLineStyleFromString(eDataType, initialValue);
            case GraphconfPackage.ROUTER_TYPE:
                return createRouterTypeFromString(eDataType, initialValue);
            case GraphconfPackage.COLOR:
                return createColorFromString(eDataType, initialValue);
            case GraphconfPackage.FONT:
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
    public String convertToString(EDataType eDataType, Object instanceValue)
    {
        switch (eDataType.getClassifierID())
        {
            case GraphconfPackage.LINE_STYLE:
                return convertLineStyleToString(eDataType, instanceValue);
            case GraphconfPackage.ROUTER_TYPE:
                return convertRouterTypeToString(eDataType, instanceValue);
            case GraphconfPackage.COLOR:
                return convertColorToString(eDataType, instanceValue);
            case GraphconfPackage.FONT:
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
    public DiagramGraphConf createDiagramGraphConf()
    {
        DiagramGraphConfImpl diagramGraphConf = new DiagramGraphConfImpl();
        return diagramGraphConf;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NodeGraphConf createNodeGraphConf()
    {
        NodeGraphConfImpl nodeGraphConf = new NodeGraphConfImpl();
        return nodeGraphConf;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeGraphConf createEdgeGraphConf()
    {
        EdgeGraphConfImpl edgeGraphConf = new EdgeGraphConfImpl();
        return edgeGraphConf;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EMFBridge createEMFBridge()
    {
        EMFBridgeImpl emfBridge = new EMFBridgeImpl();
        return emfBridge;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public StringBridge createStringBridge()
    {
        StringBridgeImpl stringBridge = new StringBridgeImpl();
        return stringBridge;
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
     * @generated NOT
     */
    public Color createColorFromString(EDataType eDataType, String initialValue)
    {
        if (initialValue == null || initialValue.length() == 0)
            return JFaceResources.getColorRegistry().get("0,0,0");

        try
        {
            RGB rgb = StringConverter.asRGB(initialValue);

            Color color = JFaceResources.getColorRegistry().get(initialValue);
            if (color == null)
            {
                JFaceResources.getColorRegistry().put(initialValue, rgb);
                color = JFaceResources.getColorRegistry().get(initialValue);
            }

            return color;
        }
        catch (DataFormatException dfe)
        {
            GraphConfPlugin.log("The color has not the desired format", IStatus.WARNING);
            return JFaceResources.getColorRegistry().get("0,0,0");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String convertColorToString(EDataType eDataType, Object instanceValue)
    {
        if (instanceValue == null)
            return "0,0,0";
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
                // the get on a font always return a font even if this font is not registered
                font = JFaceResources.getFontRegistry().get(initialValue);
            }
        }
        catch (DataFormatException dfe)
        {
            GraphConfPlugin.log(dfe.getMessage(), IStatus.WARNING);
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
            return StringConverter.asString(JFaceResources.getFontRegistry().defaultFont().getFontData()[0]);
        Font font = (Font) instanceValue;
        return StringConverter.asString(font.getFontData()[0]);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphconfPackage getGraphconfPackage()
    {
        return (GraphconfPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    public static GraphconfPackage getPackage()
    {
        return GraphconfPackage.eINSTANCE;
    }

} // GraphconfFactoryImpl
