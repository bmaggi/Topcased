/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiagramsPackage.java,v 1.2 2009/04/20 08:07:07 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.topcased.modeler.diagrams.model.DiagramsPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsFactory
 * @model kind="package"
 * @generated
 */
public interface OcldiagramsPackage extends EPackage
{
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "ocldiagrams";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/ocl/1.0/OCLDiagrams";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "ocl.diagrams";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    OcldiagramsPackage eINSTANCE = org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl.init();

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.BusinessTypeImpl
     * <em>Business Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.BusinessTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getBusinessType()
     * @generated
     */
    int BUSINESS_TYPE = 52;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BUSINESS_TYPE__MODEL = DiagramsPackage.DIAGRAMS__MODEL;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BUSINESS_TYPE__DIAGRAMS = DiagramsPackage.DIAGRAMS__DIAGRAMS;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BUSINESS_TYPE__ACTIVE_DIAGRAM = DiagramsPackage.DIAGRAMS__ACTIVE_DIAGRAM;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BUSINESS_TYPE__SUBDIAGRAMS = DiagramsPackage.DIAGRAMS__SUBDIAGRAMS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BUSINESS_TYPE__PARENT = DiagramsPackage.DIAGRAMS__PARENT;

    /**
     * The number of structural features of the '<em>Business Type</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BUSINESS_TYPE_FEATURE_COUNT = DiagramsPackage.DIAGRAMS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.AnyTypeImpl <em>Any Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.AnyTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getAnyType()
     * @generated
     */
    int ANY_TYPE = 0;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ANY_TYPE__MODEL = BUSINESS_TYPE__MODEL;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ANY_TYPE__DIAGRAMS = BUSINESS_TYPE__DIAGRAMS;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ANY_TYPE__ACTIVE_DIAGRAM = BUSINESS_TYPE__ACTIVE_DIAGRAM;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ANY_TYPE__SUBDIAGRAMS = BUSINESS_TYPE__SUBDIAGRAMS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ANY_TYPE__PARENT = BUSINESS_TYPE__PARENT;

    /**
     * The number of structural features of the '<em>Any Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ANY_TYPE_FEATURE_COUNT = BUSINESS_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionTypeImpl
     * <em>Collection Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionType()
     * @generated
     */
    int COLLECTION_TYPE = 2;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__NAME = EcorePackage.ECLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__INSTANCE_TYPE_NAME = EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ETYPE_PARAMETERS = EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__START_POSITION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__END_POSITION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TYPE_START_POSITION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__TYPE_END_POSITION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__ELEMENT_TYPE = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE__KIND = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Collection Type</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_TYPE_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.BagTypeImpl <em>Bag Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.BagTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getBagType()
     * @generated
     */
    int BAG_TYPE = 1;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Bag Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.ElementTypeImpl
     * <em>Element Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.ElementTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getElementType()
     * @generated
     */
    int ELEMENT_TYPE = 3;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__MODEL = BUSINESS_TYPE__MODEL;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__DIAGRAMS = BUSINESS_TYPE__DIAGRAMS;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__ACTIVE_DIAGRAM = BUSINESS_TYPE__ACTIVE_DIAGRAM;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__SUBDIAGRAMS = BUSINESS_TYPE__SUBDIAGRAMS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE__PARENT = BUSINESS_TYPE__PARENT;

    /**
     * The number of structural features of the '<em>Element Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ELEMENT_TYPE_FEATURE_COUNT = BUSINESS_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.InvalidTypeImpl
     * <em>Invalid Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.InvalidTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getInvalidType()
     * @generated
     */
    int INVALID_TYPE = 4;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_TYPE__MODEL = BUSINESS_TYPE__MODEL;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_TYPE__DIAGRAMS = BUSINESS_TYPE__DIAGRAMS;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_TYPE__ACTIVE_DIAGRAM = BUSINESS_TYPE__ACTIVE_DIAGRAM;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_TYPE__SUBDIAGRAMS = BUSINESS_TYPE__SUBDIAGRAMS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_TYPE__PARENT = BUSINESS_TYPE__PARENT;

    /**
     * The number of structural features of the '<em>Invalid Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_TYPE_FEATURE_COUNT = BUSINESS_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.MessageTypeImpl
     * <em>Message Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.MessageTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getMessageType()
     * @generated
     */
    int MESSAGE_TYPE = 5;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__NAME = EcorePackage.ECLASS__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

    /**
     * The feature id for the '<em><b>Interface</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__INTERFACE = EcorePackage.ECLASS__INTERFACE;

    /**
     * The feature id for the '<em><b>ESuper Types</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

    /**
     * The feature id for the '<em><b>EOperations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Attributes</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll References</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

    /**
     * The feature id for the '<em><b>EReferences</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

    /**
     * The feature id for the '<em><b>EAttributes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll Containments</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

    /**
     * The feature id for the '<em><b>EAll Operations</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EAll Super Types</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EID Attribute</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REFERRED_OPERATION = EcorePackage.ECLASS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Referred Signal</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE__REFERRED_SIGNAL = EcorePackage.ECLASS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Message Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_TYPE_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.OrderedSetTypeImpl
     * <em>Ordered Set Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OrderedSetTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getOrderedSetType()
     * @generated
     */
    int ORDERED_SET_TYPE = 6;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Ordered Set Type</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveTypeImpl
     * <em>Primitive Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getPrimitiveType()
     * @generated
     */
    int PRIMITIVE_TYPE = 7;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__EANNOTATIONS = EcorePackage.EDATA_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__NAME = EcorePackage.EDATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INSTANCE_CLASS_NAME = EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INSTANCE_CLASS = EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__DEFAULT_VALUE = EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__INSTANCE_TYPE_NAME = EcorePackage.EDATA_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__EPACKAGE = EcorePackage.EDATA_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__ETYPE_PARAMETERS = EcorePackage.EDATA_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Serializable</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE__SERIALIZABLE = EcorePackage.EDATA_TYPE__SERIALIZABLE;

    /**
     * The number of structural features of the '<em>Primitive Type</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_TYPE_FEATURE_COUNT = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.SequenceTypeImpl
     * <em>Sequence Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.SequenceTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getSequenceType()
     * @generated
     */
    int SEQUENCE_TYPE = 8;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Sequence Type</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.SetTypeImpl <em>Set Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.SetTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getSetType()
     * @generated
     */
    int SET_TYPE = 9;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__INSTANCE_TYPE_NAME = COLLECTION_TYPE__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__ETYPE_PARAMETERS = COLLECTION_TYPE__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE__KIND = COLLECTION_TYPE__KIND;

    /**
     * The number of structural features of the '<em>Set Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TupleTypeImpl <em>Tuple Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.TupleTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTupleType()
     * @generated
     */
    int TUPLE_TYPE = 10;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__NAME = EcorePackage.ECLASS__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

    /**
     * The feature id for the '<em><b>Interface</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__INTERFACE = EcorePackage.ECLASS__INTERFACE;

    /**
     * The feature id for the '<em><b>ESuper Types</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

    /**
     * The feature id for the '<em><b>EOperations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Attributes</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll References</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

    /**
     * The feature id for the '<em><b>EReferences</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

    /**
     * The feature id for the '<em><b>EAttributes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

    /**
     * The feature id for the '<em><b>EAll Containments</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

    /**
     * The feature id for the '<em><b>EAll Operations</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

    /**
     * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EAll Super Types</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EID Attribute</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

    /**
     * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

    /**
     * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

    /**
     * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

    /**
     * The number of structural features of the '<em>Tuple Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_TYPE_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TypeTypeImpl <em>Type Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.TypeTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTypeType()
     * @generated
     */
    int TYPE_TYPE = 11;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE__MODEL = BUSINESS_TYPE__MODEL;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE__DIAGRAMS = BUSINESS_TYPE__DIAGRAMS;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE__ACTIVE_DIAGRAM = BUSINESS_TYPE__ACTIVE_DIAGRAM;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE__SUBDIAGRAMS = BUSINESS_TYPE__SUBDIAGRAMS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE__PARENT = BUSINESS_TYPE__PARENT;

    /**
     * The feature id for the '<em><b>Referred Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE__REFERRED_TYPE = BUSINESS_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_TYPE_FEATURE_COUNT = BUSINESS_TYPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.VoidTypeImpl <em>Void Type</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.VoidTypeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getVoidType()
     * @generated
     */
    int VOID_TYPE = 12;

    /**
     * The feature id for the '<em><b>Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VOID_TYPE__MODEL = BUSINESS_TYPE__MODEL;

    /**
     * The feature id for the '<em><b>Diagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VOID_TYPE__DIAGRAMS = BUSINESS_TYPE__DIAGRAMS;

    /**
     * The feature id for the '<em><b>Active Diagram</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VOID_TYPE__ACTIVE_DIAGRAM = BUSINESS_TYPE__ACTIVE_DIAGRAM;

    /**
     * The feature id for the '<em><b>Subdiagrams</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VOID_TYPE__SUBDIAGRAMS = BUSINESS_TYPE__SUBDIAGRAMS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int VOID_TYPE__PARENT = BUSINESS_TYPE__PARENT;

    /**
     * The number of structural features of the '<em>Void Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int VOID_TYPE_FEATURE_COUNT = BUSINESS_TYPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CallOperationActionImpl
     * <em>Call Operation Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CallOperationActionImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCallOperationAction()
     * @generated
     */
    int CALL_OPERATION_ACTION = 13;

    /**
     * The feature id for the '<em><b>Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_OPERATION_ACTION__OPERATION = 0;

    /**
     * The number of structural features of the '<em>Call Operation Action</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_OPERATION_ACTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl <em>Constraint</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getConstraint()
     * @generated
     */
    int CONSTRAINT = 14;

    /**
     * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__NAME = EcorePackage.ECLASSIFIER__NAME;

    /**
     * The feature id for the '<em><b>Instance Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

    /**
     * The feature id for the '<em><b>Instance Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

    /**
     * The feature id for the '<em><b>Instance Type Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__INSTANCE_TYPE_NAME = EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

    /**
     * The feature id for the '<em><b>EPackage</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

    /**
     * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__ETYPE_PARAMETERS = EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

    /**
     * The feature id for the '<em><b>Specification</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__SPECIFICATION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Constrained Elements</b></em>' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__CONSTRAINED_ELEMENTS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT__STEREOTYPE = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Constraint</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int CONSTRAINT_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.SendSignalActionImpl
     * <em>Send Signal Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.SendSignalActionImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getSendSignalAction()
     * @generated
     */
    int SEND_SIGNAL_ACTION = 15;

    /**
     * The feature id for the '<em><b>Signal</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEND_SIGNAL_ACTION__SIGNAL = 0;

    /**
     * The number of structural features of the '<em>Send Signal Action</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SEND_SIGNAL_ACTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.ExpressionInOCLImpl
     * <em>Expression In OCL</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.ExpressionInOCLImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getExpressionInOCL()
     * @generated
     */
    int EXPRESSION_IN_OCL = 16;

    /**
     * The feature id for the '<em><b>Body Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__BODY_EXPRESSION = UtilitiesPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION;

    /**
     * The feature id for the '<em><b>Context Variable</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__CONTEXT_VARIABLE = UtilitiesPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE;

    /**
     * The feature id for the '<em><b>Result Variable</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__RESULT_VARIABLE = UtilitiesPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE;

    /**
     * The feature id for the '<em><b>Parameter Variable</b></em>' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL__PARAMETER_VARIABLE = UtilitiesPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE;

    /**
     * The number of structural features of the '<em>Expression In OCL</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EXPRESSION_IN_OCL_FEATURE_COUNT = UtilitiesPackage.EXPRESSION_IN_OCL_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.OCLExpressionImpl
     * <em>OCL Expression</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OCLExpressionImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getOCLExpression()
     * @generated
     */
    int OCL_EXPRESSION = 39;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OCL_EXPRESSION__START_POSITION = ExpressionsPackage.OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OCL_EXPRESSION__END_POSITION = ExpressionsPackage.OCL_EXPRESSION__END_POSITION;

    /**
     * The number of structural features of the '<em>OCL Expression</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OCL_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CallExpImpl <em>Call Exp</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CallExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCallExp()
     * @generated
     */
    int CALL_EXP = 19;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Call Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.FeatureCallExpImpl
     * <em>Feature Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.FeatureCallExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getFeatureCallExp()
     * @generated
     */
    int FEATURE_CALL_EXP = 25;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP__START_POSITION = CALL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP__END_POSITION = CALL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP__PROPERTY_START_POSITION = CALL_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP__PROPERTY_END_POSITION = CALL_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP__MARKED_PRE = CALL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Feature Call Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FEATURE_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.NavigationCallExpImpl
     * <em>Navigation Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.NavigationCallExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getNavigationCallExp()
     * @generated
     */
    int NAVIGATION_CALL_EXP = 36;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

    /**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__QUALIFIER = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP__NAVIGATION_SOURCE = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Navigation Call Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NAVIGATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.AssociationCallExpImpl
     * <em>Association Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.AssociationCallExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getAssociationCallExp()
     * @generated
     */
    int ASSOCIATION_CALL_EXP = 17;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

    /**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

    /**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

    /**
     * The feature id for the '<em><b>Referred Association Class</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP__REFERRED_ASSOCIATION_CLASS = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Association Call Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ASSOCIATION_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveLiteralExpImpl
     * <em>Primitive Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getPrimitiveLiteralExp()
     * @generated
     */
    int PRIMITIVE_LITERAL_EXP = 41;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_LITERAL_EXP__START_POSITION = ExpressionsPackage.PRIMITIVE_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_LITERAL_EXP__END_POSITION = ExpressionsPackage.PRIMITIVE_LITERAL_EXP__END_POSITION;

    /**
     * The number of structural features of the '<em>Primitive Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PRIMITIVE_LITERAL_EXP_FEATURE_COUNT = ExpressionsPackage.PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.BooleanLiteralExpImpl
     * <em>Boolean Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.BooleanLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getBooleanLiteralExp()
     * @generated
     */
    int BOOLEAN_LITERAL_EXP = 18;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Boolean Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralPartImpl
     * <em>Collection Literal Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralPartImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionLiteralPart()
     * @generated
     */
    int COLLECTION_LITERAL_PART = 22;

    /**
     * The number of structural features of the '<em>Collection Literal Part</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_PART_FEATURE_COUNT = ExpressionsPackage.COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionItemImpl
     * <em>Collection Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionItemImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionItem()
     * @generated
     */
    int COLLECTION_ITEM = 20;

    /**
     * The feature id for the '<em><b>Item</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Collection Item</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.LiteralExpImpl <em>Literal Exp</em>}
     * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.LiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getLiteralExp()
     * @generated
     */
    int LITERAL_EXP = 33;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LITERAL_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LITERAL_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The number of structural features of the '<em>Literal Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralExpImpl
     * <em>Collection Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionLiteralExp()
     * @generated
     */
    int COLLECTION_LITERAL_EXP = 21;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Part</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Simple Range</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_EXP__SIMPLE_RANGE = LITERAL_EXP_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Collection Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionRangeImpl
     * <em>Collection Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionRangeImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionRange()
     * @generated
     */
    int COLLECTION_RANGE = 23;

    /**
     * The feature id for the '<em><b>First</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Last</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Collection Range</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.EnumLiteralExpImpl
     * <em>Enum Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.EnumLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getEnumLiteralExp()
     * @generated
     */
    int ENUM_LITERAL_EXP = 24;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_LITERAL_EXP__START_POSITION = ExpressionsPackage.LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_LITERAL_EXP__END_POSITION = ExpressionsPackage.LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = ExpressionsPackage.LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Enum Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_LITERAL_EXP_FEATURE_COUNT = ExpressionsPackage.LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl <em>If Exp</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIfExp()
     * @generated
     */
    int IF_EXP = 26;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IF_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IF_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Then Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Else Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>If Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.NumericLiteralExpImpl
     * <em>Numeric Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.NumericLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getNumericLiteralExp()
     * @generated
     */
    int NUMERIC_LITERAL_EXP = 38;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NUMERIC_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NUMERIC_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

    /**
     * The number of structural features of the '<em>Numeric Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NUMERIC_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IntegerLiteralExpImpl
     * <em>Integer Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.IntegerLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIntegerLiteralExp()
     * @generated
     */
    int INTEGER_LITERAL_EXP = 27;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Integer Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.UnlimitedNaturalLiteralExpImpl
     * <em>Unlimited Natural Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.UnlimitedNaturalLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getUnlimitedNaturalLiteralExp()
     * @generated
     */
    int UNLIMITED_NATURAL_LITERAL_EXP = 28;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Integer Symbol</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Unlimited</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Unlimited Natural Literal Exp</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNLIMITED_NATURAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.InvalidLiteralExpImpl
     * <em>Invalid Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.InvalidLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getInvalidLiteralExp()
     * @generated
     */
    int INVALID_LITERAL_EXP = 29;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

    /**
     * The number of structural features of the '<em>Invalid Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INVALID_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.LoopExpImpl <em>Loop Exp</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.LoopExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getLoopExp()
     * @generated
     */
    int LOOP_EXP = 34;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__START_POSITION = ExpressionsPackage.LOOP_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__END_POSITION = ExpressionsPackage.LOOP_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__PROPERTY_START_POSITION = ExpressionsPackage.LOOP_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__PROPERTY_END_POSITION = ExpressionsPackage.LOOP_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__SOURCE = ExpressionsPackage.LOOP_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__BODY = ExpressionsPackage.LOOP_EXP__BODY;

    /**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP__ITERATOR = ExpressionsPackage.LOOP_EXP__ITERATOR;

    /**
     * The number of structural features of the '<em>Loop Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LOOP_EXP_FEATURE_COUNT = ExpressionsPackage.LOOP_EXP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IterateExpImpl <em>Iterate Exp</em>}
     * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.IterateExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIterateExp()
     * @generated
     */
    int ITERATE_EXP = 30;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__START_POSITION = LOOP_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__END_POSITION = LOOP_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__BODY = LOOP_EXP__BODY;

    /**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__ITERATOR = LOOP_EXP__ITERATOR;

    /**
     * The feature id for the '<em><b>Result</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Iterate Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IteratorExpImpl
     * <em>Iterator Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.IteratorExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIteratorExp()
     * @generated
     */
    int ITERATOR_EXP = 31;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__START_POSITION = LOOP_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__END_POSITION = LOOP_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__PROPERTY_START_POSITION = LOOP_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__PROPERTY_END_POSITION = LOOP_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Body</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

    /**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP__ITERATOR = LOOP_EXP__ITERATOR;

    /**
     * The number of structural features of the '<em>Iterator Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.LetExpImpl <em>Let Exp</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.LetExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getLetExp()
     * @generated
     */
    int LET_EXP = 32;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LET_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LET_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>In</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Variable</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Let Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.MessageExpImpl <em>Message Exp</em>}
     * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.MessageExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getMessageExp()
     * @generated
     */
    int MESSAGE_EXP = 35;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__PROPERTY_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__PROPERTY_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Target</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Argument</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__ARGUMENT = OCL_EXPRESSION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Called Operation</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__CALLED_OPERATION = OCL_EXPRESSION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Sent Signal</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP__SENT_SIGNAL = OCL_EXPRESSION_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Message Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.NullLiteralExpImpl
     * <em>Null Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.NullLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getNullLiteralExp()
     * @generated
     */
    int NULL_LITERAL_EXP = 37;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NULL_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NULL_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

    /**
     * The number of structural features of the '<em>Null Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NULL_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl
     * <em>Operation Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getOperationCallExp()
     * @generated
     */
    int OPERATION_CALL_EXP = 40;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__START_POSITION = FEATURE_CALL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__END_POSITION = FEATURE_CALL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__PROPERTY_START_POSITION = FEATURE_CALL_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__PROPERTY_END_POSITION = FEATURE_CALL_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__SOURCE = FEATURE_CALL_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__MARKED_PRE = FEATURE_CALL_EXP__MARKED_PRE;

    /**
     * The feature id for the '<em><b>Argument</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__ARGUMENT = FEATURE_CALL_EXP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__REFERRED_OPERATION = FEATURE_CALL_EXP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Operation Code</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP__OPERATION_CODE = FEATURE_CALL_EXP_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Operation Call Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int OPERATION_CALL_EXP_FEATURE_COUNT = FEATURE_CALL_EXP_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.PropertyCallExpImpl
     * <em>Property Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.PropertyCallExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getPropertyCallExp()
     * @generated
     */
    int PROPERTY_CALL_EXP = 42;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__START_POSITION = NAVIGATION_CALL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__END_POSITION = NAVIGATION_CALL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Property Start Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__PROPERTY_START_POSITION = NAVIGATION_CALL_EXP__PROPERTY_START_POSITION;

    /**
     * The feature id for the '<em><b>Property End Position</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__PROPERTY_END_POSITION = NAVIGATION_CALL_EXP__PROPERTY_END_POSITION;

    /**
     * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__SOURCE = NAVIGATION_CALL_EXP__SOURCE;

    /**
     * The feature id for the '<em><b>Marked Pre</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__MARKED_PRE = NAVIGATION_CALL_EXP__MARKED_PRE;

    /**
     * The feature id for the '<em><b>Qualifier</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__QUALIFIER = NAVIGATION_CALL_EXP__QUALIFIER;

    /**
     * The feature id for the '<em><b>Navigation Source</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__NAVIGATION_SOURCE = NAVIGATION_CALL_EXP__NAVIGATION_SOURCE;

    /**
     * The feature id for the '<em><b>Referred Property</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP__REFERRED_PROPERTY = NAVIGATION_CALL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Property Call Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTY_CALL_EXP_FEATURE_COUNT = NAVIGATION_CALL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.RealLiteralExpImpl
     * <em>Real Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.RealLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getRealLiteralExp()
     * @generated
     */
    int REAL_LITERAL_EXP = 43;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int REAL_LITERAL_EXP__START_POSITION = NUMERIC_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int REAL_LITERAL_EXP__END_POSITION = NUMERIC_LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Real Symbol</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Real Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERIC_LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.StateExpImpl <em>State Exp</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.StateExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getStateExp()
     * @generated
     */
    int STATE_EXP = 44;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STATE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STATE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Referred State</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STATE_EXP__REFERRED_STATE = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>State Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int STATE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.StringLiteralExpImpl
     * <em>String Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.StringLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getStringLiteralExp()
     * @generated
     */
    int STRING_LITERAL_EXP = 45;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_LITERAL_EXP__START_POSITION = PRIMITIVE_LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_LITERAL_EXP__END_POSITION = PRIMITIVE_LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>String Symbol</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_LITERAL_EXP__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_LITERAL_EXP_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralExpImpl
     * <em>Tuple Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTupleLiteralExp()
     * @generated
     */
    int TUPLE_LITERAL_EXP = 46;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_EXP__START_POSITION = LITERAL_EXP__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_EXP__END_POSITION = LITERAL_EXP__END_POSITION;

    /**
     * The feature id for the '<em><b>Part</b></em>' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_EXP__PART = LITERAL_EXP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Tuple Literal Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralPartImpl
     * <em>Tuple Literal Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralPartImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTupleLiteralPart()
     * @generated
     */
    int TUPLE_LITERAL_PART = 47;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART__START_POSITION = ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART__END_POSITION = ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART__TYPE_START_POSITION = ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART__TYPE_END_POSITION = ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Value</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART__VALUE = ExpressionsPackage.TUPLE_LITERAL_PART__VALUE;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART__ATTRIBUTE = ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE;

    /**
     * The number of structural features of the '<em>Tuple Literal Part</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TUPLE_LITERAL_PART_FEATURE_COUNT = ExpressionsPackage.TUPLE_LITERAL_PART_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TypeExpImpl <em>Type Exp</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.TypeExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTypeExp()
     * @generated
     */
    int TYPE_EXP = 48;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Referred Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_EXP__REFERRED_TYPE = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Type Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int TYPE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.UnspecifiedValueExpImpl
     * <em>Unspecified Value Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.UnspecifiedValueExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getUnspecifiedValueExp()
     * @generated
     */
    int UNSPECIFIED_VALUE_EXP = 49;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNSPECIFIED_VALUE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNSPECIFIED_VALUE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Unspecified Value Exp</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.VariableImpl <em>Variable</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.VariableImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getVariable()
     * @generated
     */
    int VARIABLE = 50;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE__START_POSITION = ExpressionsPackage.VARIABLE__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE__END_POSITION = ExpressionsPackage.VARIABLE__END_POSITION;

    /**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE__TYPE_START_POSITION = ExpressionsPackage.VARIABLE__TYPE_START_POSITION;

    /**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE__TYPE_END_POSITION = ExpressionsPackage.VARIABLE__TYPE_END_POSITION;

    /**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE__INIT_EXPRESSION = ExpressionsPackage.VARIABLE__INIT_EXPRESSION;

    /**
     * The feature id for the '<em><b>Represented Parameter</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE__REPRESENTED_PARAMETER = ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER;

    /**
     * The number of structural features of the '<em>Variable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_FEATURE_COUNT = ExpressionsPackage.VARIABLE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.VariableExpImpl
     * <em>Variable Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.VariableExpImpl
     * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getVariableExp()
     * @generated
     */
    int VARIABLE_EXP = 51;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_EXP__START_POSITION = OCL_EXPRESSION__START_POSITION;

    /**
     * The feature id for the '<em><b>End Position</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_EXP__END_POSITION = OCL_EXPRESSION__END_POSITION;

    /**
     * The feature id for the '<em><b>Referred Variable</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Variable Exp</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.AnyType <em>Any Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Any Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.AnyType
     * @generated
     */
    EClass getAnyType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.BagType <em>Bag Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Bag Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.BagType
     * @generated
     */
    EClass getBagType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CollectionType
     * <em>Collection Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Collection Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CollectionType
     * @generated
     */
    EClass getCollectionType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.ElementType <em>Element Type</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Element Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.ElementType
     * @generated
     */
    EClass getElementType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.InvalidType <em>Invalid Type</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Invalid Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.InvalidType
     * @generated
     */
    EClass getInvalidType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.MessageType <em>Message Type</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Message Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.MessageType
     * @generated
     */
    EClass getMessageType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.OrderedSetType
     * <em>Ordered Set Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Ordered Set Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.OrderedSetType
     * @generated
     */
    EClass getOrderedSetType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.PrimitiveType
     * <em>Primitive Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Primitive Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.PrimitiveType
     * @generated
     */
    EClass getPrimitiveType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.SequenceType
     * <em>Sequence Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Sequence Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.SequenceType
     * @generated
     */
    EClass getSequenceType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.SetType <em>Set Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Set Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.SetType
     * @generated
     */
    EClass getSetType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.TupleType <em>Tuple Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tuple Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.TupleType
     * @generated
     */
    EClass getTupleType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.TypeType <em>Type Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Type Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.TypeType
     * @generated
     */
    EClass getTypeType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.VoidType <em>Void Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Void Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.VoidType
     * @generated
     */
    EClass getVoidType();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CallOperationAction
     * <em>Call Operation Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Call Operation Action</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CallOperationAction
     * @generated
     */
    EClass getCallOperationAction();

    /**
     * Returns the meta object for the reference '
     * {@link org.topcased.modeler.ocl.ocldiagrams.CallOperationAction#getOperation <em>Operation</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Operation</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CallOperationAction#getOperation()
     * @see #getCallOperationAction()
     * @generated
     */
    EReference getCallOperationAction_Operation();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.Constraint <em>Constraint</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Constraint</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.Constraint
     * @generated
     */
    EClass getConstraint();

    /**
     * Returns the meta object for the containment reference '
     * {@link org.topcased.modeler.ocl.ocldiagrams.Constraint#getSpecification <em>Specification</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Specification</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.Constraint#getSpecification()
     * @see #getConstraint()
     * @generated
     */
    EReference getConstraint_Specification();

    /**
     * Returns the meta object for the reference list '
     * {@link org.topcased.modeler.ocl.ocldiagrams.Constraint#getConstrainedElements <em>Constrained Elements</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Constrained Elements</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.Constraint#getConstrainedElements()
     * @see #getConstraint()
     * @generated
     */
    EReference getConstraint_ConstrainedElements();

    /**
     * Returns the meta object for the attribute '{@link org.topcased.modeler.ocl.ocldiagrams.Constraint#getStereotype
     * <em>Stereotype</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Stereotype</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.Constraint#getStereotype()
     * @see #getConstraint()
     * @generated
     */
    EAttribute getConstraint_Stereotype();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.SendSignalAction
     * <em>Send Signal Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Send Signal Action</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.SendSignalAction
     * @generated
     */
    EClass getSendSignalAction();

    /**
     * Returns the meta object for the reference '
     * {@link org.topcased.modeler.ocl.ocldiagrams.SendSignalAction#getSignal <em>Signal</em>}'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Signal</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.SendSignalAction#getSignal()
     * @see #getSendSignalAction()
     * @generated
     */
    EReference getSendSignalAction_Signal();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.ExpressionInOCL
     * <em>Expression In OCL</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Expression In OCL</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.ExpressionInOCL
     * @generated
     */
    EClass getExpressionInOCL();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.AssociationCallExp
     * <em>Association Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Association Call Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.AssociationCallExp
     * @generated
     */
    EClass getAssociationCallExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.BooleanLiteralExp
     * <em>Boolean Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Boolean Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.BooleanLiteralExp
     * @generated
     */
    EClass getBooleanLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CallExp <em>Call Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Call Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CallExp
     * @generated
     */
    EClass getCallExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CollectionItem
     * <em>Collection Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Collection Item</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CollectionItem
     * @generated
     */
    EClass getCollectionItem();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralExp
     * <em>Collection Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Collection Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralExp
     * @generated
     */
    EClass getCollectionLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralPart
     * <em>Collection Literal Part</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Collection Literal Part</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralPart
     * @generated
     */
    EClass getCollectionLiteralPart();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.CollectionRange
     * <em>Collection Range</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Collection Range</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.CollectionRange
     * @generated
     */
    EClass getCollectionRange();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.EnumLiteralExp
     * <em>Enum Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Enum Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.EnumLiteralExp
     * @generated
     */
    EClass getEnumLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.FeatureCallExp
     * <em>Feature Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Feature Call Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.FeatureCallExp
     * @generated
     */
    EClass getFeatureCallExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.IfExp <em>If Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>If Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.IfExp
     * @generated
     */
    EClass getIfExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.IntegerLiteralExp
     * <em>Integer Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Integer Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.IntegerLiteralExp
     * @generated
     */
    EClass getIntegerLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.UnlimitedNaturalLiteralExp
     * <em>Unlimited Natural Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Unlimited Natural Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.UnlimitedNaturalLiteralExp
     * @generated
     */
    EClass getUnlimitedNaturalLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.InvalidLiteralExp
     * <em>Invalid Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Invalid Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.InvalidLiteralExp
     * @generated
     */
    EClass getInvalidLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.IterateExp <em>Iterate Exp</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Iterate Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.IterateExp
     * @generated
     */
    EClass getIterateExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.IteratorExp <em>Iterator Exp</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Iterator Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.IteratorExp
     * @generated
     */
    EClass getIteratorExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.LetExp <em>Let Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Let Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.LetExp
     * @generated
     */
    EClass getLetExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.LiteralExp <em>Literal Exp</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.LiteralExp
     * @generated
     */
    EClass getLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.LoopExp <em>Loop Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Loop Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.LoopExp
     * @generated
     */
    EClass getLoopExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.MessageExp <em>Message Exp</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Message Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.MessageExp
     * @generated
     */
    EClass getMessageExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.NavigationCallExp
     * <em>Navigation Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Navigation Call Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.NavigationCallExp
     * @generated
     */
    EClass getNavigationCallExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.NullLiteralExp
     * <em>Null Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Null Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.NullLiteralExp
     * @generated
     */
    EClass getNullLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.NumericLiteralExp
     * <em>Numeric Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Numeric Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.NumericLiteralExp
     * @generated
     */
    EClass getNumericLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.OCLExpression
     * <em>OCL Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>OCL Expression</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.OCLExpression
     * @generated
     */
    EClass getOCLExpression();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.OperationCallExp
     * <em>Operation Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Operation Call Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.OperationCallExp
     * @generated
     */
    EClass getOperationCallExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.PrimitiveLiteralExp
     * <em>Primitive Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Primitive Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.PrimitiveLiteralExp
     * @generated
     */
    EClass getPrimitiveLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.PropertyCallExp
     * <em>Property Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Property Call Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.PropertyCallExp
     * @generated
     */
    EClass getPropertyCallExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.RealLiteralExp
     * <em>Real Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Real Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.RealLiteralExp
     * @generated
     */
    EClass getRealLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.StateExp <em>State Exp</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>State Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.StateExp
     * @generated
     */
    EClass getStateExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.StringLiteralExp
     * <em>String Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>String Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.StringLiteralExp
     * @generated
     */
    EClass getStringLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.TupleLiteralExp
     * <em>Tuple Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tuple Literal Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.TupleLiteralExp
     * @generated
     */
    EClass getTupleLiteralExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.TupleLiteralPart
     * <em>Tuple Literal Part</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Tuple Literal Part</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.TupleLiteralPart
     * @generated
     */
    EClass getTupleLiteralPart();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.TypeExp <em>Type Exp</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Type Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.TypeExp
     * @generated
     */
    EClass getTypeExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.UnspecifiedValueExp
     * <em>Unspecified Value Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Unspecified Value Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.UnspecifiedValueExp
     * @generated
     */
    EClass getUnspecifiedValueExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.Variable <em>Variable</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Variable</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.Variable
     * @generated
     */
    EClass getVariable();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.VariableExp <em>Variable Exp</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Variable Exp</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.VariableExp
     * @generated
     */
    EClass getVariableExp();

    /**
     * Returns the meta object for class '{@link org.topcased.modeler.ocl.ocldiagrams.BusinessType
     * <em>Business Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Business Type</em>'.
     * @see org.topcased.modeler.ocl.ocldiagrams.BusinessType
     * @generated
     */
    EClass getBusinessType();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    OcldiagramsFactory getOcldiagramsFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.AnyTypeImpl
         * <em>Any Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.AnyTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getAnyType()
         * @generated
         */
        EClass ANY_TYPE = eINSTANCE.getAnyType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.BagTypeImpl
         * <em>Bag Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.BagTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getBagType()
         * @generated
         */
        EClass BAG_TYPE = eINSTANCE.getBagType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionTypeImpl
         * <em>Collection Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionType()
         * @generated
         */
        EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.ElementTypeImpl
         * <em>Element Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.ElementTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getElementType()
         * @generated
         */
        EClass ELEMENT_TYPE = eINSTANCE.getElementType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.InvalidTypeImpl
         * <em>Invalid Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.InvalidTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getInvalidType()
         * @generated
         */
        EClass INVALID_TYPE = eINSTANCE.getInvalidType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.MessageTypeImpl
         * <em>Message Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.MessageTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getMessageType()
         * @generated
         */
        EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.OrderedSetTypeImpl
         * <em>Ordered Set Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OrderedSetTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getOrderedSetType()
         * @generated
         */
        EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveTypeImpl
         * <em>Primitive Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getPrimitiveType()
         * @generated
         */
        EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.SequenceTypeImpl
         * <em>Sequence Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.SequenceTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getSequenceType()
         * @generated
         */
        EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.SetTypeImpl
         * <em>Set Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.SetTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getSetType()
         * @generated
         */
        EClass SET_TYPE = eINSTANCE.getSetType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TupleTypeImpl
         * <em>Tuple Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.TupleTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTupleType()
         * @generated
         */
        EClass TUPLE_TYPE = eINSTANCE.getTupleType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TypeTypeImpl
         * <em>Type Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.TypeTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTypeType()
         * @generated
         */
        EClass TYPE_TYPE = eINSTANCE.getTypeType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.VoidTypeImpl
         * <em>Void Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.VoidTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getVoidType()
         * @generated
         */
        EClass VOID_TYPE = eINSTANCE.getVoidType();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CallOperationActionImpl
         * <em>Call Operation Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CallOperationActionImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCallOperationAction()
         * @generated
         */
        EClass CALL_OPERATION_ACTION = eINSTANCE.getCallOperationAction();

        /**
         * The meta object literal for the '<em><b>Operation</b></em>' reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference CALL_OPERATION_ACTION__OPERATION = eINSTANCE.getCallOperationAction_Operation();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl
         * <em>Constraint</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getConstraint()
         * @generated
         */
        EClass CONSTRAINT = eINSTANCE.getConstraint();

        /**
         * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSTRAINT__SPECIFICATION = eINSTANCE.getConstraint_Specification();

        /**
         * The meta object literal for the '<em><b>Constrained Elements</b></em>' reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONSTRAINT__CONSTRAINED_ELEMENTS = eINSTANCE.getConstraint_ConstrainedElements();

        /**
         * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONSTRAINT__STEREOTYPE = eINSTANCE.getConstraint_Stereotype();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.SendSignalActionImpl
         * <em>Send Signal Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.SendSignalActionImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getSendSignalAction()
         * @generated
         */
        EClass SEND_SIGNAL_ACTION = eINSTANCE.getSendSignalAction();

        /**
         * The meta object literal for the '<em><b>Signal</b></em>' reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference SEND_SIGNAL_ACTION__SIGNAL = eINSTANCE.getSendSignalAction_Signal();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.ExpressionInOCLImpl
         * <em>Expression In OCL</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.ExpressionInOCLImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getExpressionInOCL()
         * @generated
         */
        EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.AssociationCallExpImpl
         * <em>Association Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.AssociationCallExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getAssociationCallExp()
         * @generated
         */
        EClass ASSOCIATION_CALL_EXP = eINSTANCE.getAssociationCallExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.BooleanLiteralExpImpl
         * <em>Boolean Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.BooleanLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getBooleanLiteralExp()
         * @generated
         */
        EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CallExpImpl
         * <em>Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CallExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCallExp()
         * @generated
         */
        EClass CALL_EXP = eINSTANCE.getCallExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionItemImpl
         * <em>Collection Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionItemImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionItem()
         * @generated
         */
        EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralExpImpl
         * <em>Collection Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionLiteralExp()
         * @generated
         */
        EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralPartImpl
         * <em>Collection Literal Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionLiteralPartImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionLiteralPart()
         * @generated
         */
        EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.CollectionRangeImpl
         * <em>Collection Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.CollectionRangeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getCollectionRange()
         * @generated
         */
        EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.EnumLiteralExpImpl
         * <em>Enum Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.EnumLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getEnumLiteralExp()
         * @generated
         */
        EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.FeatureCallExpImpl
         * <em>Feature Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.FeatureCallExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getFeatureCallExp()
         * @generated
         */
        EClass FEATURE_CALL_EXP = eINSTANCE.getFeatureCallExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl <em>If Exp</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.IfExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIfExp()
         * @generated
         */
        EClass IF_EXP = eINSTANCE.getIfExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IntegerLiteralExpImpl
         * <em>Integer Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.IntegerLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIntegerLiteralExp()
         * @generated
         */
        EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

        /**
         * The meta object literal for the '
         * {@link org.topcased.modeler.ocl.ocldiagrams.impl.UnlimitedNaturalLiteralExpImpl
         * <em>Unlimited Natural Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.UnlimitedNaturalLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getUnlimitedNaturalLiteralExp()
         * @generated
         */
        EClass UNLIMITED_NATURAL_LITERAL_EXP = eINSTANCE.getUnlimitedNaturalLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.InvalidLiteralExpImpl
         * <em>Invalid Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.InvalidLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getInvalidLiteralExp()
         * @generated
         */
        EClass INVALID_LITERAL_EXP = eINSTANCE.getInvalidLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IterateExpImpl
         * <em>Iterate Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.IterateExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIterateExp()
         * @generated
         */
        EClass ITERATE_EXP = eINSTANCE.getIterateExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.IteratorExpImpl
         * <em>Iterator Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.IteratorExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getIteratorExp()
         * @generated
         */
        EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.LetExpImpl
         * <em>Let Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.LetExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getLetExp()
         * @generated
         */
        EClass LET_EXP = eINSTANCE.getLetExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.LiteralExpImpl
         * <em>Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.LiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getLiteralExp()
         * @generated
         */
        EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.LoopExpImpl
         * <em>Loop Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.LoopExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getLoopExp()
         * @generated
         */
        EClass LOOP_EXP = eINSTANCE.getLoopExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.MessageExpImpl
         * <em>Message Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.MessageExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getMessageExp()
         * @generated
         */
        EClass MESSAGE_EXP = eINSTANCE.getMessageExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.NavigationCallExpImpl
         * <em>Navigation Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.NavigationCallExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getNavigationCallExp()
         * @generated
         */
        EClass NAVIGATION_CALL_EXP = eINSTANCE.getNavigationCallExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.NullLiteralExpImpl
         * <em>Null Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.NullLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getNullLiteralExp()
         * @generated
         */
        EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.NumericLiteralExpImpl
         * <em>Numeric Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.NumericLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getNumericLiteralExp()
         * @generated
         */
        EClass NUMERIC_LITERAL_EXP = eINSTANCE.getNumericLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.OCLExpressionImpl
         * <em>OCL Expression</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OCLExpressionImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getOCLExpression()
         * @generated
         */
        EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl
         * <em>Operation Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OperationCallExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getOperationCallExp()
         * @generated
         */
        EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveLiteralExpImpl
         * <em>Primitive Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.PrimitiveLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getPrimitiveLiteralExp()
         * @generated
         */
        EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.PropertyCallExpImpl
         * <em>Property Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.PropertyCallExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getPropertyCallExp()
         * @generated
         */
        EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.RealLiteralExpImpl
         * <em>Real Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.RealLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getRealLiteralExp()
         * @generated
         */
        EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.StateExpImpl
         * <em>State Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.StateExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getStateExp()
         * @generated
         */
        EClass STATE_EXP = eINSTANCE.getStateExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.StringLiteralExpImpl
         * <em>String Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.StringLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getStringLiteralExp()
         * @generated
         */
        EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralExpImpl
         * <em>Tuple Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTupleLiteralExp()
         * @generated
         */
        EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralPartImpl
         * <em>Tuple Literal Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.TupleLiteralPartImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTupleLiteralPart()
         * @generated
         */
        EClass TUPLE_LITERAL_PART = eINSTANCE.getTupleLiteralPart();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.TypeExpImpl
         * <em>Type Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.TypeExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getTypeExp()
         * @generated
         */
        EClass TYPE_EXP = eINSTANCE.getTypeExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.UnspecifiedValueExpImpl
         * <em>Unspecified Value Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.UnspecifiedValueExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getUnspecifiedValueExp()
         * @generated
         */
        EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.VariableImpl
         * <em>Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.VariableImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getVariable()
         * @generated
         */
        EClass VARIABLE = eINSTANCE.getVariable();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.VariableExpImpl
         * <em>Variable Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.VariableExpImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getVariableExp()
         * @generated
         */
        EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

        /**
         * The meta object literal for the '{@link org.topcased.modeler.ocl.ocldiagrams.impl.BusinessTypeImpl
         * <em>Business Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.BusinessTypeImpl
         * @see org.topcased.modeler.ocl.ocldiagrams.impl.OcldiagramsPackageImpl#getBusinessType()
         * @generated
         */
        EClass BUSINESS_TYPE = eINSTANCE.getBusinessType();

    }

} // OcldiagramsPackage
