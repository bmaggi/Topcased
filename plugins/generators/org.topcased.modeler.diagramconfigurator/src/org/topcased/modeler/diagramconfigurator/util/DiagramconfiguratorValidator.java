/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramconfiguratorValidator.java,v 1.11 2008/04/17 08:33:03 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.topcased.modeler.diagramconfigurator.Constraint;
import org.topcased.modeler.diagramconfigurator.DecorationType;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramReference;
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
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage
 * @generated
 */
public class DiagramconfiguratorValidator extends EObjectValidator
{
    public final static String CLASS_NAME_CONSTRAINT_ERROR = "_UI_JavaClassName_Constraint_Error_diagnostic";

    public final static String CLASS_NAME_CONSTRAINT_WARNING = "_UI_JavaClassName_Constraint_Warning_diagnostic";

    public final static String FIELD_NAME_CONSTRAINT_WARNING = "_UI_JavaFieldName_Constraint_Warning_diagnostic";

    public final static String FIELD_NAME_CONSTRAINT_ERROR = "_UI_JavaFieldName_Constraint_Error_diagnostic";

    public final static String PACKAGE_NAME_CONSTRAINT_ERROR = "_UI_JavaPackageName_Constraint_Error_diagnostic";

    public final static String METHOD_NAME_CONSTRAINT_ERROR = "_UI_JavaMethodName_Constraint_Error_diagnostic";

    public final static String NON_NULL_CONSTRAINT_ERROR = "_UI_Empty_Constraint_Error_diagnostic";

    public final static String PART_CONFIGURATION_PREFIX_UNICITY_ERROR = "_UI_PartConfigurationPrefix_Unicity_Constraint_Error_diagnostic";

    public final static String OBJECT_CONFIGURATION_NAME_UNICITY_ERROR = "_UI_ObjectConfigurationName_Unicity_Constraint_Error_diagnostic";

    public final static String PALETTE_ITEM_NAME_UNICITY_ERROR = "_UI_PaletteItemName_Unicity_Constraint_Error_diagnostic";

    public final static String NODE_PART_CONTAINER_CONSTRAINT_WARNING = "_UI_NodePartConfiguration_Container_Constraint_Error_diagnostic";

    public final static String NODE_PART_CHILD_CONSTRAINT_WARNING = "_UI_NodePartConfiguration_Child_Constraint_Error_diagnostic";

    public final static String EDGE_PART_DIRECT_EDITABLE_CONSTRAINT_ERROR = "_UI_EdgePartConfiguration_DirectEditable_Constraint_Error_diagnostic";

    public final static String EDGE_OBJECT_NULL_OBJECTCONFIGURATION_CONSTRAINT_ERROR = "_UI_EdgeObject_Null_ObjectConfiguration_Constraint_Error_diagnostic";

    public final static String EDGE_OBJECT_NOT_LINK_TO_MODELOBJECTCONFIGURATION_ERROR = "_UI_EdgeObject_Not_Link_to_ModelObjectConfiguration_Constraint_Error_diagnostic";

    public final static String EDGE_OBJECT_STRUCTURAL_FEATURE_UNBOUND_CONSTRAINT_ERROR = "_UI_EdgeObject_Structural_feature_unbound_Constraint_Error_diagnostic";

    public final static String STC_CONTAINERTYPE_SIMPLEOBJCETCONFIGURATION_CONSTRAINT_ERROR = "_UI_Stc_ContainerType_SimpleObectConfiguration_Constraint_Error_diagnostic";

    public final static String STC_CONTAINERTYPE_MODELOBJCETCONFIGURATION_CONSTRAINT_ERROR = "_UI_Stc_ContainerType_ModelObectConfiguration_Constraint_Error_diagnostic";

    public final static String STC_CONTAINEROBJECT_CONTAINER_REF_NULL_CONSTRAINT_ERROR = "_UI_Stc_ContainerObject_Null_Constraint_Error_diagnostic";

    public final static String STC_CONTAINEROBJECT_CONTAINER_UNBOUND_SOURCE_CONSTRAINT_ERROR = "_UI_Stc_ContainerObject_Source_unbound_Constraint_Error_diagnostic";

    public final static String STC_CONTAINEROBJECT_CONTAINER_UNBOUND_TARGET_CONSTRAINT_ERROR = "_UI_Stc_ContainerObject_Target_unbound_Constraint_Error_diagnostic";

    public final static String STC_CONTAINERREF_NULL_CONSTRAINT_ERROR = "_UI_Stc_ContainerRef_Null_Constraint_Error_diagnostic";

    public final static String STC_CONTAINERREF_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_ContainerRef_unbound_Constraint_Error_diagnostic";

    public final static String STC_REFSOURCE2TARGET_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_RefSource2Target_unbound_Constraint_Error_diagnostic";

    public final static String STC_REFTARGET2SOURCE_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_RefTarget2Source_unbound_Constraint_Error_diagnostic";

    public final static String STC_REFTARGET2EDGE_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_RefTarget2Edge_unbound_Constraint_Error_diagnostic";

    public final static String STC_REFSOURCE2EDGE_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_RefSource2Edge_unbound_Constraint_Error_diagnostic";

    public final static String STC_REFEDGE2TARGET_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_RefEdge2Target_unbound_Constraint_Error_diagnostic";

    public final static String STC_REFEDGE2SOURCE_UNBOUND_CONSTRAINT_ERROR = "_UI_Stc_RefEdge2Source_unbound_Constraint_Error_diagnostic";

    public final static String STC_SIMPLEOBJECTCONFIGURATION_REFNULL_CONSTRAINT_WARNING = "_UI_Stc_SimpleObjectConfiguration_RefNull_Constraint_Warning_diagnostic";

    public final static String STC_SOURCENODE_CONSTRAINT_ERROR = "_UI_Stc_SourceNode_Constraint_Error_diagnostic";

    public final static String STC_TARGETNODE_CONSTRAINT_ERROR = "_UI_Stc_TargetNode_Constraint_Error_diagnostic";

    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final DiagramconfiguratorValidator INSTANCE = new DiagramconfiguratorValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.topcased.modeler.diagramconfigurator";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramconfiguratorValidator()
    {
        super();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage()
    {
      return DiagramconfiguratorPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        switch (classifierID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION:
                return validateDiagramConfiguration((DiagramConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.OBJECT_CONFIGURATION:
                return validateObjectConfiguration((ObjectConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE:
                return validateDiagramReference((DiagramReference)value, diagnostics, context);
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION:
                return validatePaletteConfiguration((PaletteConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.PALETTE_CATEGORY:
                return validatePaletteCategory((PaletteCategory)value, diagnostics, context);
            case DiagramconfiguratorPackage.PART_CONFIGURATION:
                return validatePartConfiguration((PartConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION:
                return validateNodePartConfiguration((NodePartConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION:
                return validateEdgePartConfiguration((EdgePartConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.EDGE_OBJECT:
                return validateEdgeObject((EdgeObject)value, diagnostics, context);
            case DiagramconfiguratorPackage.PALETTE_ITEM:
                return validatePaletteItem((PaletteItem)value, diagnostics, context);
            case DiagramconfiguratorPackage.SOURCE_TARGET_COUPLE:
                return validateSourceTargetCouple((SourceTargetCouple)value, diagnostics, context);
            case DiagramconfiguratorPackage.MODEL_OBJECT_CONFIGURATION:
                return validateModelObjectConfiguration((ModelObjectConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.SIMPLE_OBJECT_CONFIGURATION:
                return validateSimpleObjectConfiguration((SimpleObjectConfiguration)value, diagnostics, context);
            case DiagramconfiguratorPackage.CONSTRAINT:
                return validateConstraint((Constraint)value, diagnostics, context);
            case DiagramconfiguratorPackage.PART_ACTION:
                return validatePartAction((PartAction)value, diagnostics, context);
            case DiagramconfiguratorPackage.EDGE_CONTAINER_TYPE:
                return validateEdgeContainerType((EdgeContainerType)value, diagnostics, context);
            case DiagramconfiguratorPackage.RESIZABLE_TYPE:
                return validateResizableType((ResizableType)value, diagnostics, context);
            case DiagramconfiguratorPackage.LAYOUT_TYPE:
                return validateLayoutType((LayoutType)value, diagnostics, context);
            case DiagramconfiguratorPackage.DECORATION_TYPE:
                return validateDecorationType((DecorationType)value, diagnostics, context);
            case DiagramconfiguratorPackage.ROUTER_TYPE:
                return validateRouterType((RouterType)value, diagnostics, context);
            case DiagramconfiguratorPackage.EDGE_OBJECT_TYPE:
                return validateEdgeObjectType((EdgeObjectType)value, diagnostics, context);
            case DiagramconfiguratorPackage.LINE_STYLE:
                return validateLineStyle((LineStyle)value, diagnostics, context);
            case DiagramconfiguratorPackage.COLOR:
                return validateColor((Color)value, diagnostics, context);
            case DiagramconfiguratorPackage.FONT:
                return validateFont((Font)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDiagramConfiguration(DiagramConfiguration diagramConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        boolean result = validate_EveryMultiplicityConforms(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validateDiagramConfiguration_Prefix(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validateDiagramConfiguration_Package(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validateDiagramConfiguration_PartsPrefixUnicity(diagramConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validateDiagramConfiguration_ObjectsNameUnicity(diagramConfiguration, diagnostics, context);
        return result;
    }

    /**
     * Validates the Prefix constraint of '<em>Diagram Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateDiagramConfiguration_Prefix(DiagramConfiguration diagramConfiguration, DiagnosticChain diagnostics, Map context)
    {
        boolean errors = false;
        String code = "";

        // EMPTY
        if (diagramConfiguration.getPrefix() == null || diagramConfiguration.getPrefix().trim().length() == 0)
        {
            errors = true;
            code = NON_NULL_CONSTRAINT_ERROR;
        }

        // JAVA
        if (!errors && !JavaConventions.validateIdentifier(diagramConfiguration.getPrefix()).isOK())
        {
            errors = true;
            code = CLASS_NAME_CONSTRAINT_ERROR;
        }
        String conventionJavaClassNameStartRegex = "^($|_|[A-Z]).*";
        if (!errors && !diagramConfiguration.getPrefix().matches(conventionJavaClassNameStartRegex))
        {
            errors = true;
            // add warning
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(CLASS_NAME_CONSTRAINT_WARNING, new Object[] {"Prefix",
                        getObjectLabel(diagramConfiguration, context)}), new Object[] {diagramConfiguration}));
                return false;
            }
        }

        if (errors)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"Prefix",
                        getObjectLabel(diagramConfiguration, context)}), new Object[] {diagramConfiguration}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the Package constraint of '<em>Diagram Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateDiagramConfiguration_Package(DiagramConfiguration diagramConfiguration, DiagnosticChain diagnostics, Map context)
    {

        boolean errors = false;
        String code = "";

        // EMPTY
        if (diagramConfiguration.getPackage() == null || diagramConfiguration.getPackage().trim().length() == 0)
        {
            errors = true;
            code = NON_NULL_CONSTRAINT_ERROR;
        }

        // JAVA
        if (!errors && !JavaConventions.validatePackageName(diagramConfiguration.getPackage()).isOK())
        {
            errors = true;
            code = PACKAGE_NAME_CONSTRAINT_ERROR;
        }
        if (errors)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"Package",
                        getObjectLabel(diagramConfiguration, context)}), new Object[] {diagramConfiguration}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the PartsPrefixUnicity constraint of '<em>Diagram Configuration</em>'. Test the unicity off the
     * PartConfiguration Prefix <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateDiagramConfiguration_PartsPrefixUnicity(DiagramConfiguration diagramConfiguration, DiagnosticChain diagnostics, Map context)
    {

        boolean errors = false;
        List partsName = null;

        if (diagramConfiguration.getParts() != null && !diagramConfiguration.getParts().isEmpty())
        {
            partsName = new ArrayList();
            PartConfiguration part = null;
            for (Iterator it = diagramConfiguration.getParts().iterator(); it.hasNext();)
            {
                part = (PartConfiguration) it.next();
                // PartConfiguiration prefix attribute will be test in the
                // validatePartConfiguration
                if (part.getPrefix() != null && part.getPrefix().trim().length() > 0)
                {
                    if (partsName.contains(part.getPrefix()))
                    {
                        errors = true;
                        break;
                    }
                    partsName.add(part.getPrefix());

                }
            }
        }

        if (errors)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(PART_CONFIGURATION_PREFIX_UNICITY_ERROR,
                        new Object[] {getObjectLabel(diagramConfiguration, context)}), new Object[] {diagramConfiguration}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ObjectsNameUnicity constraint of '<em>Diagram Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateDiagramConfiguration_ObjectsNameUnicity(DiagramConfiguration diagramConfiguration, DiagnosticChain diagnostics, Map context)
    {
        boolean errors = false;
        List partsName = null;

        if (diagramConfiguration.getObjects() != null && !diagramConfiguration.getObjects().isEmpty())
        {
            partsName = new ArrayList();
            ObjectConfiguration obj = null;
            for (Iterator it = diagramConfiguration.getObjects().iterator(); it.hasNext();)
            {
                obj = (ObjectConfiguration) it.next();
                // ObjectConfiguiration prefix attribute will be test in the
                // validateObjectConfiguration
                if (obj.getName() != null && obj.getName().trim().length() > 0)
                {
                    if (partsName.contains(obj.getName()))
                    {
                        errors = true;
                        break;
                    }
                    partsName.add(obj.getName());

                }
            }
        }

        if (errors)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(OBJECT_CONFIGURATION_NAME_UNICITY_ERROR,
                        new Object[] {getObjectLabel(diagramConfiguration, context)}), new Object[] {diagramConfiguration}));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateObjectConfiguration(ObjectConfiguration objectConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(objectConfiguration, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDiagramReference(DiagramReference diagramReference, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(diagramReference, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePaletteConfiguration(PaletteConfiguration paletteConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(paletteConfiguration, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePaletteCategory(PaletteCategory paletteCategory, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        boolean result = validate_EveryMultiplicityConforms(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePaletteCategory_Name(paletteCategory, diagnostics, context);
        if (result || diagnostics != null) result &= validatePaletteCategory_PaletteItemsNameUnicity(paletteCategory, diagnostics, context);
        return result;
    }

    /**
     * Validates the Name constraint of '<em>Palette Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validatePaletteCategory_Name(PaletteCategory paletteCategory, DiagnosticChain diagnostics, Map context)
    {
        boolean errors = false;
        String code = "";

        // EMPTY
        if (paletteCategory.getName() == null || paletteCategory.getName().trim().length() == 0)
        {
            errors = true;
            code = NON_NULL_CONSTRAINT_ERROR;
        }

        // JAVA
        if (!errors && !JavaConventions.validateFieldName(paletteCategory.getName()).isOK())
        {
            errors = true;
            code = FIELD_NAME_CONSTRAINT_ERROR;
        }

        // PaletteCategory name could start with a UpperCase without sending a warning message. The character is
        // uncapitalized during the generation process.
        // String conventionJavaClassVariableStartRegex = "^($|[a-z]).*";
        // if (!errors && !paletteCategory.getName().matches(conventionJavaClassVariableStartRegex))
        // {
        // errors = true;
        // // add warning
        // if (diagnostics != null)
        // {
        // diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0,
        // DiagramConfiguratorPlugin.INSTANCE.getString(FIELD_NAME_CONSTRAINT_WARNING, new Object[] {
        // "Name", getObjectLabel(paletteCategory, context)}), new Object[] {paletteCategory}));
        // return false;
        // }
        // }

        if (errors)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"Name",
                        getObjectLabel(paletteCategory, context)}), new Object[] {paletteCategory}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the PaletteItemsNameUnicity constraint of '<em>Palette Category</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validatePaletteCategory_PaletteItemsNameUnicity(PaletteCategory paletteCategory, DiagnosticChain diagnostics, Map context)
    {
        boolean errors = false;
        List itemsName = null;

        if (paletteCategory.getItems() != null && !paletteCategory.getItems().isEmpty())
        {
            itemsName = new ArrayList();
            PaletteItem obj = null;
            for (Iterator it = paletteCategory.getItems().iterator(); it.hasNext();)
            {
                obj = (PaletteItem) it.next();
                // ObjectConfiguiration prefix attribute will be test in the
                // validateObjectConfiguration
                if (obj.getName() != null && obj.getName().trim().length() > 0)
                {
                    if (itemsName.contains(obj.getName()))
                    {
                        errors = true;
                        break;
                    }
                    itemsName.add(obj.getName());

                }
            }
        }

        if (errors)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(PALETTE_ITEM_NAME_UNICITY_ERROR, new Object[] {getObjectLabel(
                        paletteCategory, context)}), new Object[] {paletteCategory}));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePartConfiguration(PartConfiguration partConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(partConfiguration, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNodePartConfiguration(NodePartConfiguration nodePartConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        boolean result = validate_EveryMultiplicityConforms(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(nodePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validateNodePartConfiguration_Container(nodePartConfiguration, diagnostics, context);
        return result;
    }

    /**
     * Validates the Container constraint of '<em>Node Part Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateNodePartConfiguration_Container(NodePartConfiguration nodePartConfiguration, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (nodePartConfiguration.getChildElements() == null || nodePartConfiguration.getChildElements().isEmpty())
        {
            if (nodePartConfiguration.isContainer())
            {
                error = true;
                code = NODE_PART_CONTAINER_CONSTRAINT_WARNING;
            }
        }
        else
        {
            if (!nodePartConfiguration.isContainer())
            {
                error = true;
                code = NODE_PART_CHILD_CONSTRAINT_WARNING;
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {getObjectLabel(nodePartConfiguration,
                        context)}), new Object[] {nodePartConfiguration}));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEdgePartConfiguration(EdgePartConfiguration edgePartConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        boolean result = validate_EveryMultiplicityConforms(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(edgePartConfiguration, diagnostics, context);
        if (result || diagnostics != null) result &= validateEdgePartConfiguration_DirectEditable(edgePartConfiguration, diagnostics, context);
        return result;
    }

    /**
     * Validates the DirectEditable constraint of '<em>Edge Part Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateEdgePartConfiguration_DirectEditable(EdgePartConfiguration edgePartConfiguration, DiagnosticChain diagnostics, Map context)
    {

        boolean error = false;
        String code = "";

        if (edgePartConfiguration.getDirectEditable() != null)
        {
            if (edgePartConfiguration.getEdgeObjects() == null || edgePartConfiguration.getEdgeObjects().isEmpty()
                    || !edgePartConfiguration.getEdgeObjects().contains(edgePartConfiguration.getDirectEditable()))
            {
                error = true;
                code = EDGE_PART_DIRECT_EDITABLE_CONSTRAINT_ERROR;
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {getObjectLabel(edgePartConfiguration,
                        context)}), new Object[] {edgePartConfiguration}));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEdgeObject(EdgeObject edgeObject, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        boolean result = validate_EveryMultiplicityConforms(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validateEdgeObject_Id(edgeObject, diagnostics, context);
        if (result || diagnostics != null) result &= validateEdgeObject_EStructuralFeature(edgeObject, diagnostics, context);
        return result;
    }

    /**
     * Validates the Id constraint of '<em>Edge Object</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateEdgeObject_Id(EdgeObject edgeObject, DiagnosticChain diagnostics, Map context)
    {

        boolean error = false;
        String code = "";
        // EMPTY
        if (edgeObject.getId() == null || edgeObject.getId().trim().length() == 0)
        {
            error = true;
            code = NON_NULL_CONSTRAINT_ERROR;
        }

        // JAVA
        if (!error && !JavaConventions.validateMethodName(edgeObject.getId()).isOK())
        {
            error = true;
            code = METHOD_NAME_CONSTRAINT_ERROR;
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
                        DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"Id", getObjectLabel(edgeObject, context)}), new Object[] {edgeObject}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the EStructuralFeature constraint of '<em>Edge Object</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateEdgeObject_EStructuralFeature(EdgeObject edgeObject, DiagnosticChain diagnostics, Map context)
    {

        boolean error = false;
        String code = "";

        EStructuralFeature feature = edgeObject.getEStructuralFeature();
        if (feature != null)
        {
            // The ObjectConfiguration cannot be null
            ObjectConfiguration object = ((EdgePartConfiguration) edgeObject.eContainer()).getObject();
            if (object == null)
            {
                error = true;
                code = EDGE_OBJECT_NULL_OBJECTCONFIGURATION_CONSTRAINT_ERROR;
            }
            // The ObjectConfiguration must be a ModelObjectConfiguration
            else if (!(object instanceof ModelObjectConfiguration))
            {
                error = true;
                code = EDGE_OBJECT_NOT_LINK_TO_MODELOBJECTCONFIGURATION_ERROR;
            }
            else
            {
                // Check whether the eStructural feature is one of the ModelObject linked
                if (!((ModelObjectConfiguration) object).getGenClass().getEcoreClass().getEAllStructuralFeatures().contains(feature))
                {
                    error = true;
                    code = EDGE_OBJECT_STRUCTURAL_FEATURE_UNBOUND_CONSTRAINT_ERROR;
                }
            }
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {getObjectLabel(edgeObject, context)}),
                        new Object[] {edgeObject}));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePaletteItem(PaletteItem paletteItem, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(paletteItem, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSourceTargetCouple(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        boolean result = validate_EveryMultiplicityConforms(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_SourceNode(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_TargetNode(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_ContainerType(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_ContainerObject(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_ContainerRef(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefSourceToEdge(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefEdgeToSource(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefTargetToEdge(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefEdgeToTarget(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefSourceToTarget(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefTargetToSource(sourceTargetCouple, diagnostics, context);
        if (result || diagnostics != null) result &= validateSourceTargetCouple_RefConstraint(sourceTargetCouple, diagnostics, context);
        return result;
    }

    /**
     * Validates the SourceNode constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_SourceNode(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";
        if (sourceTargetCouple.getSourceNode() != null)
        {
            PartConfiguration node = sourceTargetCouple.getSourceNode();
            if (node instanceof EdgePartConfiguration && !(((EdgePartConfiguration) node).getObject() instanceof ModelObjectConfiguration))
            {
                error = true;
                code = STC_SOURCENODE_CONSTRAINT_ERROR;
            }
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"SourceNode",
                        getObjectLabel(sourceTargetCouple, context)}), new Object[] {sourceTargetCouple}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the TargetNode constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_TargetNode(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";
        if (sourceTargetCouple.getTargetNode() != null)
        {
            PartConfiguration node = sourceTargetCouple.getTargetNode();
            if (node instanceof EdgePartConfiguration && !(((EdgePartConfiguration) node).getObject() instanceof ModelObjectConfiguration))
            {
                error = true;
                code = STC_TARGETNODE_CONSTRAINT_ERROR;
            }
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"TargetNode",
                        getObjectLabel(sourceTargetCouple, context)}), new Object[] {sourceTargetCouple}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ContainerType constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_ContainerType(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (sourceTargetCouple != null && sourceTargetCouple.getContainerType() != null)
        {
            if (sourceTargetCouple.eContainer() != null)
            {
                EdgePartConfiguration part = (EdgePartConfiguration) sourceTargetCouple.eContainer();
                // Error if Object type is SimpleObjectConfiguration and
                // ContainerType != NONE
                if (part.getObject() instanceof SimpleObjectConfiguration && !sourceTargetCouple.getContainerType().equals(EdgeContainerType.NONE_LITERAL))
                {
                    error = true;
                    code = STC_CONTAINERTYPE_SIMPLEOBJCETCONFIGURATION_CONSTRAINT_ERROR;
                }
                else if (part.getObject() instanceof ModelObjectConfiguration && sourceTargetCouple.getContainerType().equals(EdgeContainerType.NONE_LITERAL))
                {
                    error = true;
                    code = STC_CONTAINERTYPE_MODELOBJCETCONFIGURATION_CONSTRAINT_ERROR;
                }
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"ContainerType",
                        getObjectLabel(sourceTargetCouple, context)}), new Object[] {sourceTargetCouple}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ContainerObject constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_ContainerObject(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";
        if (sourceTargetCouple != null && ((EdgePartConfiguration) sourceTargetCouple.eContainer()).getObject() instanceof ModelObjectConfiguration)
        {
            if (sourceTargetCouple.getSourceNode() != null && sourceTargetCouple.getTargetNode() != null)
            {
                // IF Container object is null
                if (sourceTargetCouple.getContainerObject() == null)
                {
                    error = true;
                    code = STC_CONTAINEROBJECT_CONTAINER_REF_NULL_CONSTRAINT_ERROR;
                }
                else
                {
                    if (sourceTargetCouple.getContainerType() != null)
                    {
                        if (sourceTargetCouple.getContainerType().equals(EdgeContainerType.SOURCE_LITERAL))
                        {
                            if (sourceTargetCouple.getSourceNode() != null)
                            {
                                // genclass sourceNode != ContainerObject
                                Object sourceNodeGenClass = ((ModelObjectConfiguration) sourceTargetCouple.getSourceNode().getObject()).getGenClass();
                                if (!sourceNodeGenClass.equals(sourceTargetCouple.getContainerObject()))
                                {
                                    error = true;
                                    code = STC_CONTAINEROBJECT_CONTAINER_UNBOUND_SOURCE_CONSTRAINT_ERROR;
                                }
                            }
                        }
                        else if (sourceTargetCouple.getContainerType().equals(EdgeContainerType.TARGET_LITERAL))
                        {
                            if (sourceTargetCouple.getTargetNode() != null)
                            {
                                // genclass targetnode != ContainerObject
                                GenClass targetNodeGenClass = ((ModelObjectConfiguration) sourceTargetCouple.getTargetNode().getObject()).getGenClass();
                                if (!targetNodeGenClass.equals(sourceTargetCouple.getContainerObject()))
                                {
                                    error = true;
                                    code = STC_CONTAINEROBJECT_CONTAINER_UNBOUND_TARGET_CONSTRAINT_ERROR;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"ContainerObject",
                        getObjectLabel(sourceTargetCouple, context)}), new Object[] {sourceTargetCouple}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ContainerRef constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_ContainerRef(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (sourceTargetCouple != null && ((EdgePartConfiguration) sourceTargetCouple.eContainer()).getObject() instanceof ModelObjectConfiguration)
        {
            if (sourceTargetCouple.getContainerObject() != null)
            {
                // ContainerRef cannot be null is ContainerObject filled
                if (sourceTargetCouple.getContainerRef() == null)
                {
                    error = true;
                    code = STC_CONTAINERREF_NULL_CONSTRAINT_ERROR;
                }
                else
                {
                    GenClass containerObj = sourceTargetCouple.getContainerObject();
                    List containerReferences = new ArrayList();
                    if (containerObj != null)
                    {
                        // retrieve all the StructuralFeatures of the genclass
                        // selected in the containerObject
                        List structuredFeatures = containerObj.getEcoreClass().getEAllStructuralFeatures();
                        GenClass edgeGenClass = ((ModelObjectConfiguration) ((EdgePartConfiguration) sourceTargetCouple.eContainer()).getObject()).getGenClass();
                        for (Iterator it = structuredFeatures.iterator(); it.hasNext();)
                        {
                            EStructuralFeature eStructuralFeature = (EStructuralFeature) it.next();
                            if (eStructuralFeature.getEType() instanceof EClass)
                            {
                                if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(edgeGenClass.getEcoreClass()))
                                {
                                    containerReferences.add(eStructuralFeature);
                                }
                            }

                        }
                    }

                    // If the ContainerRef is not in the list -> ERROR
                    if (!containerReferences.contains(sourceTargetCouple.getContainerRef()))
                    {
                        error = true;
                        code = STC_CONTAINERREF_UNBOUND_CONSTRAINT_ERROR;
                    }
                }
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"ContainerRef",
                        getObjectLabel(sourceTargetCouple, context)}), new Object[] {sourceTargetCouple}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the RefSourceToEdge constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefSourceToEdge(SourceTargetCouple stc, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (stc != null)
        {
            if (((PartConfiguration) stc.eContainer()).getObject() instanceof ModelObjectConfiguration)
            {
                if (stc.getRefSourceToEdge() != null)
                {
                    // Test that the refSourceToTarget is feature of the
                    // container and has the good type
                    EStructuralFeature refFeature = stc.getRefSourceToEdge();
                    // Case SimpleObjectConfiguration cannot occure
                    if (stc.getSourceNode().getObject() instanceof ModelObjectConfiguration)
                    {
                        EClass expectedClass = ((ModelObjectConfiguration) ((PartConfiguration) stc.eContainer()).getObject()).getGenClass().getEcoreClass();
                        EClass containerClass = ((ModelObjectConfiguration) stc.getSourceNode().getObject()).getGenClass().getEcoreClass();
                        if (!isSourceTargetCouple_RefSourceTargetEdgeOk(refFeature, expectedClass, containerClass))
                        {
                            error = true;
                            code = STC_REFSOURCE2EDGE_UNBOUND_CONSTRAINT_ERROR;
                        }
                    }
                }
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"RefSourceToEdge",
                        getObjectLabel(stc, context)}), new Object[] {stc}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the RefEdgeToSource constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefEdgeToSource(SourceTargetCouple stc, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (stc != null)
        {
            if (((PartConfiguration) stc.eContainer()).getObject() instanceof ModelObjectConfiguration)
            {
                if (stc.getRefEdgeToSource() != null)
                {
                    // Test that the refSourceToTarget is feature of the
                    // container and has the good type
                    EStructuralFeature refFeature = stc.getRefEdgeToSource();
                    // Case SimpleObjectConfiguration cannot occure
                    if (stc.getSourceNode().getObject() instanceof ModelObjectConfiguration)
                    {
                        EClass containerClass = ((ModelObjectConfiguration) ((PartConfiguration) stc.eContainer()).getObject()).getGenClass().getEcoreClass();
                        EClass expectedClass = ((ModelObjectConfiguration) stc.getSourceNode().getObject()).getGenClass().getEcoreClass();
                        if (!isSourceTargetCouple_RefSourceTargetEdgeOk(refFeature, expectedClass, containerClass))
                        {
                            error = true;
                            code = STC_REFEDGE2SOURCE_UNBOUND_CONSTRAINT_ERROR;
                        }
                    }
                }
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"RefEdgeToSource",
                        getObjectLabel(stc, context)}), new Object[] {stc}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the RefTargetToEdge constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefTargetToEdge(SourceTargetCouple stc, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (stc != null)
        {
            if (((PartConfiguration) stc.eContainer()).getObject() instanceof ModelObjectConfiguration)
            {
                if (stc.getRefTargetToEdge() != null)
                {
                    // Test that the refSourceToTarget is feature of the
                    // container and has the good type
                    EStructuralFeature refFeature = stc.getRefTargetToEdge();
                    // Case SimpleObjectConfiguration cannot occure
                    if (stc.getTargetNode().getObject() instanceof ModelObjectConfiguration)
                    {
                        EClass expectedClass = ((ModelObjectConfiguration) ((PartConfiguration) stc.eContainer()).getObject()).getGenClass().getEcoreClass();
                        EClass containerClass = ((ModelObjectConfiguration) stc.getTargetNode().getObject()).getGenClass().getEcoreClass();
                        if (!isSourceTargetCouple_RefSourceTargetEdgeOk(refFeature, expectedClass, containerClass))
                        {
                            error = true;
                            code = STC_REFTARGET2EDGE_UNBOUND_CONSTRAINT_ERROR;
                        }
                    }
                }
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"RefTargetToEdge",
                        getObjectLabel(stc, context)}), new Object[] {stc}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the RefEdgeToTarget constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefEdgeToTarget(SourceTargetCouple stc, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (stc != null)
        {
            if (((PartConfiguration) stc.eContainer()).getObject() instanceof ModelObjectConfiguration)
            {
                if (stc.getRefEdgeToTarget() != null)
                {
                    // Test that the refSourceToTarget is feature of the
                    // container and has the good type
                    EStructuralFeature refFeature = stc.getRefEdgeToTarget();
                    // Case SimpleObjectConfiguration cannot occure
                    if (stc.getTargetNode().getObject() instanceof ModelObjectConfiguration)
                    {
                        EClass containerClass = ((ModelObjectConfiguration) ((PartConfiguration) stc.eContainer()).getObject()).getGenClass().getEcoreClass();
                        EClass expectedClass = ((ModelObjectConfiguration) stc.getTargetNode().getObject()).getGenClass().getEcoreClass();
                        if (!isSourceTargetCouple_RefSourceTargetEdgeOk(refFeature, expectedClass, containerClass))
                        {
                            error = true;
                            code = STC_REFEDGE2TARGET_UNBOUND_CONSTRAINT_ERROR;
                        }
                    }
                }
            }
        }
        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"RefEdgeToTarget",
                        getObjectLabel(stc, context)}), new Object[] {stc}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the RefSourceToTarget constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefSourceToTarget(SourceTargetCouple stc, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (stc != null)
        {
            if (stc.getRefSourceToTarget() != null)
            {
                // Test that the refSourceToTarget is feature of the container
                // and has the good type
                EStructuralFeature refSrc2Target = stc.getRefSourceToTarget();
                // Case SimpleObjectConfiguration cannot occure
                if (stc.getTargetNode().getObject() instanceof ModelObjectConfiguration)
                {
                    EClass targetClass = ((ModelObjectConfiguration) stc.getTargetNode().getObject()).getGenClass().getEcoreClass();
                    EClass sourceClass = ((ModelObjectConfiguration) stc.getSourceNode().getObject()).getGenClass().getEcoreClass();
                    if (!isSourceTargetCouple_RefSourceTargetEdgeOk(refSrc2Target, targetClass, sourceClass))
                    {
                        error = true;
                        code = STC_REFSOURCE2TARGET_UNBOUND_CONSTRAINT_ERROR;
                    }
                }
            }
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"RefSourceToTarget",
                        getObjectLabel(stc, context)}), new Object[] {stc}));
            }
            return false;
        }
        return true;
    }

    /**
     * Test that the refFeature is type of the expectedFeatureClass and also that the refFeature is one of the
     * containerClass features
     * 
     * @param refFeature feature set in the model
     * @param expectedFeatureClass Expected Class of the feature.
     * @param containerClass EClass that must contain the reference
     * @return
     */
    private boolean isSourceTargetCouple_RefSourceTargetEdgeOk(EStructuralFeature refFeature, EClass expectedClass, EClass containerClass)
    {
        boolean error = true;
        if (!(refFeature.getEType() instanceof EClass) || !((EClass) refFeature.getEType()).isSuperTypeOf(expectedClass))
        {
            error = false;
        }
        if (!containerClass.getEAllStructuralFeatures().contains(refFeature))
        {
            error = false;
        }
        return error;
    }

    /**
     * Validates the RefTargetToSource constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefTargetToSource(SourceTargetCouple stc, DiagnosticChain diagnostics, Map context)
    {
        boolean error = false;
        String code = "";

        if (stc != null)
        {
            if (stc.getRefTargetToSource() != null)
            {
                // Test that the refSourceToTarget is feature of the container
                // and has the good type
                EStructuralFeature refTarget2Src = stc.getRefTargetToSource();
                // Case SimpleObjectConfiguration cannot occure
                if (stc.getSourceNode().getObject() instanceof ModelObjectConfiguration)
                {
                    EClass sourceClass = ((ModelObjectConfiguration) stc.getSourceNode().getObject()).getGenClass().getEcoreClass();
                    EClass targetClass = ((ModelObjectConfiguration) stc.getTargetNode().getObject()).getGenClass().getEcoreClass();
                    if (!isSourceTargetCouple_RefSourceTargetEdgeOk(refTarget2Src, sourceClass, targetClass))
                    {
                        error = true;
                        code = STC_REFTARGET2SOURCE_UNBOUND_CONSTRAINT_ERROR;
                    }
                }
            }
        }

        if (error)
        {
            if (diagnostics != null)
            {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(code, new Object[] {"RefTargetToSource",
                        getObjectLabel(stc, context)}), new Object[] {stc}));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the RefConstraint constraint of '<em>Source Target Couple</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validateSourceTargetCouple_RefConstraint(SourceTargetCouple sourceTargetCouple, DiagnosticChain diagnostics, Map context)
    {
        if (sourceTargetCouple != null && ((PartConfiguration) sourceTargetCouple.eContainer()).getObject() instanceof SimpleObjectConfiguration)
        {
            if (sourceTargetCouple.getRefSourceToTarget() == null && sourceTargetCouple.getRefTargetToSource() == null)
            {
                if (diagnostics != null)
                {
                    diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, 0, DiagramConfiguratorPlugin.INSTANCE.getString(
                            STC_SIMPLEOBJECTCONFIGURATION_REFNULL_CONSTRAINT_WARNING, new Object[] {getObjectLabel(sourceTargetCouple, context)}), new Object[] {sourceTargetCouple}));
                }
                return false;
            }
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateModelObjectConfiguration(ModelObjectConfiguration modelObjectConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(modelObjectConfiguration, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSimpleObjectConfiguration(SimpleObjectConfiguration simpleObjectConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(simpleObjectConfiguration, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(constraint, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePartAction(PartAction partAction, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return validate_EveryDefaultConstraint(partAction, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEdgeContainerType(EdgeContainerType edgeContainerType, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateResizableType(ResizableType resizableType, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLayoutType(LayoutType layoutType, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDecorationType(DecorationType decorationType, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRouterType(RouterType routerType, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEdgeObjectType(EdgeObjectType edgeObjectType, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLineStyle(LineStyle lineStyle, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateColor(Color color, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFont(Font font, DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator()
    {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} // DiagramconfiguratorValidator
