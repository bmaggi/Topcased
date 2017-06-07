/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiagramsPackageImpl.java,v 1.2 2009/04/20 08:07:07 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.AnyType;
import org.topcased.modeler.ocl.ocldiagrams.AssociationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.BagType;
import org.topcased.modeler.ocl.ocldiagrams.BooleanLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.CallExp;
import org.topcased.modeler.ocl.ocldiagrams.CallOperationAction;
import org.topcased.modeler.ocl.ocldiagrams.CollectionItem;
import org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralPart;
import org.topcased.modeler.ocl.ocldiagrams.CollectionRange;
import org.topcased.modeler.ocl.ocldiagrams.CollectionType;
import org.topcased.modeler.ocl.ocldiagrams.Constraint;
import org.topcased.modeler.ocl.ocldiagrams.ElementType;
import org.topcased.modeler.ocl.ocldiagrams.EnumLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.ExpressionInOCL;
import org.topcased.modeler.ocl.ocldiagrams.FeatureCallExp;
import org.topcased.modeler.ocl.ocldiagrams.IfExp;
import org.topcased.modeler.ocl.ocldiagrams.IntegerLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.InvalidLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.InvalidType;
import org.topcased.modeler.ocl.ocldiagrams.IterateExp;
import org.topcased.modeler.ocl.ocldiagrams.IteratorExp;
import org.topcased.modeler.ocl.ocldiagrams.LetExp;
import org.topcased.modeler.ocl.ocldiagrams.LiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.LoopExp;
import org.topcased.modeler.ocl.ocldiagrams.MessageExp;
import org.topcased.modeler.ocl.ocldiagrams.MessageType;
import org.topcased.modeler.ocl.ocldiagrams.NavigationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.NullLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.NumericLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.OCLExpression;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsFactory;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.OperationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.OrderedSetType;
import org.topcased.modeler.ocl.ocldiagrams.PrimitiveLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.PrimitiveType;
import org.topcased.modeler.ocl.ocldiagrams.PropertyCallExp;
import org.topcased.modeler.ocl.ocldiagrams.RealLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.SendSignalAction;
import org.topcased.modeler.ocl.ocldiagrams.SequenceType;
import org.topcased.modeler.ocl.ocldiagrams.SetType;
import org.topcased.modeler.ocl.ocldiagrams.StateExp;
import org.topcased.modeler.ocl.ocldiagrams.StringLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.TupleLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.TupleLiteralPart;
import org.topcased.modeler.ocl.ocldiagrams.TupleType;
import org.topcased.modeler.ocl.ocldiagrams.TypeExp;
import org.topcased.modeler.ocl.ocldiagrams.TypeType;
import org.topcased.modeler.ocl.ocldiagrams.UnlimitedNaturalLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.UnspecifiedValueExp;
import org.topcased.modeler.ocl.ocldiagrams.Variable;
import org.topcased.modeler.ocl.ocldiagrams.VariableExp;
import org.topcased.modeler.ocl.ocldiagrams.VoidType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OcldiagramsPackageImpl extends EPackageImpl implements OcldiagramsPackage
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass anyTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass bagTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass collectionTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass elementTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass invalidTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass messageTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass orderedSetTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass primitiveTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass sequenceTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass setTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass tupleTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass typeTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass voidTypeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass callOperationActionEClass = null;

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
    private EClass sendSignalActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass expressionInOCLEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass associationCallExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass booleanLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass callExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass collectionItemEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass collectionLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass collectionLiteralPartEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass collectionRangeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass enumLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass featureCallExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass ifExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass integerLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass unlimitedNaturalLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass invalidLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass iterateExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass iteratorExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass letExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass literalExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass loopExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass messageExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass navigationCallExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nullLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass numericLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass oclExpressionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass operationCallExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass primitiveLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass propertyCallExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass realLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stateExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stringLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass tupleLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass tupleLiteralPartEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass typeExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass unspecifiedValueExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass variableEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass variableExpEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass businessTypeEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OcldiagramsPackageImpl()
    {
        super(eNS_URI, OcldiagramsFactory.eINSTANCE);
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
    public static OcldiagramsPackage init()
    {
        if (isInited)
            return (OcldiagramsPackage) EPackage.Registry.INSTANCE.getEPackage(OcldiagramsPackage.eNS_URI);

        // Obtain or create and register package
        OcldiagramsPackageImpl theOcldiagramsPackage = (OcldiagramsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof OcldiagramsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
                : new OcldiagramsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        DiagramsPackage.eINSTANCE.eClass();
        EcorePackage.eINSTANCE.eClass();
        TypesPackage.eINSTANCE.eClass();
        UtilitiesPackage.eINSTANCE.eClass();
        ExpressionsPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theOcldiagramsPackage.createPackageContents();

        // Initialize created meta-data
        theOcldiagramsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOcldiagramsPackage.freeze();

        return theOcldiagramsPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAnyType()
    {
        return anyTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getBagType()
    {
        return bagTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCollectionType()
    {
        return collectionTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getElementType()
    {
        return elementTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInvalidType()
    {
        return invalidTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMessageType()
    {
        return messageTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOrderedSetType()
    {
        return orderedSetTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPrimitiveType()
    {
        return primitiveTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSequenceType()
    {
        return sequenceTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSetType()
    {
        return setTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTupleType()
    {
        return tupleTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTypeType()
    {
        return typeTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getVoidType()
    {
        return voidTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCallOperationAction()
    {
        return callOperationActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getCallOperationAction_Operation()
    {
        return (EReference) callOperationActionEClass.getEStructuralFeatures().get(0);
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
    public EReference getConstraint_Specification()
    {
        return (EReference) constraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getConstraint_ConstrainedElements()
    {
        return (EReference) constraintEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getConstraint_Stereotype()
    {
        return (EAttribute) constraintEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSendSignalAction()
    {
        return sendSignalActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSendSignalAction_Signal()
    {
        return (EReference) sendSignalActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getExpressionInOCL()
    {
        return expressionInOCLEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAssociationCallExp()
    {
        return associationCallExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getBooleanLiteralExp()
    {
        return booleanLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCallExp()
    {
        return callExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCollectionItem()
    {
        return collectionItemEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCollectionLiteralExp()
    {
        return collectionLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCollectionLiteralPart()
    {
        return collectionLiteralPartEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getCollectionRange()
    {
        return collectionRangeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getEnumLiteralExp()
    {
        return enumLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getFeatureCallExp()
    {
        return featureCallExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getIfExp()
    {
        return ifExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getIntegerLiteralExp()
    {
        return integerLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getUnlimitedNaturalLiteralExp()
    {
        return unlimitedNaturalLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getInvalidLiteralExp()
    {
        return invalidLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getIterateExp()
    {
        return iterateExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getIteratorExp()
    {
        return iteratorExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLetExp()
    {
        return letExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLiteralExp()
    {
        return literalExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getLoopExp()
    {
        return loopExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getMessageExp()
    {
        return messageExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNavigationCallExp()
    {
        return navigationCallExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNullLiteralExp()
    {
        return nullLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getNumericLiteralExp()
    {
        return numericLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOCLExpression()
    {
        return oclExpressionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getOperationCallExp()
    {
        return operationCallExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPrimitiveLiteralExp()
    {
        return primitiveLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPropertyCallExp()
    {
        return propertyCallExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getRealLiteralExp()
    {
        return realLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getStateExp()
    {
        return stateExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getStringLiteralExp()
    {
        return stringLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTupleLiteralExp()
    {
        return tupleLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTupleLiteralPart()
    {
        return tupleLiteralPartEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getTypeExp()
    {
        return typeExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getUnspecifiedValueExp()
    {
        return unspecifiedValueExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getVariable()
    {
        return variableEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getVariableExp()
    {
        return variableExpEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getBusinessType()
    {
        return businessTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiagramsFactory getOcldiagramsFactory()
    {
        return (OcldiagramsFactory) getEFactoryInstance();
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
        anyTypeEClass = createEClass(ANY_TYPE);

        bagTypeEClass = createEClass(BAG_TYPE);

        collectionTypeEClass = createEClass(COLLECTION_TYPE);

        elementTypeEClass = createEClass(ELEMENT_TYPE);

        invalidTypeEClass = createEClass(INVALID_TYPE);

        messageTypeEClass = createEClass(MESSAGE_TYPE);

        orderedSetTypeEClass = createEClass(ORDERED_SET_TYPE);

        primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

        sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

        setTypeEClass = createEClass(SET_TYPE);

        tupleTypeEClass = createEClass(TUPLE_TYPE);

        typeTypeEClass = createEClass(TYPE_TYPE);

        voidTypeEClass = createEClass(VOID_TYPE);

        callOperationActionEClass = createEClass(CALL_OPERATION_ACTION);
        createEReference(callOperationActionEClass, CALL_OPERATION_ACTION__OPERATION);

        constraintEClass = createEClass(CONSTRAINT);
        createEReference(constraintEClass, CONSTRAINT__SPECIFICATION);
        createEReference(constraintEClass, CONSTRAINT__CONSTRAINED_ELEMENTS);
        createEAttribute(constraintEClass, CONSTRAINT__STEREOTYPE);

        sendSignalActionEClass = createEClass(SEND_SIGNAL_ACTION);
        createEReference(sendSignalActionEClass, SEND_SIGNAL_ACTION__SIGNAL);

        expressionInOCLEClass = createEClass(EXPRESSION_IN_OCL);

        associationCallExpEClass = createEClass(ASSOCIATION_CALL_EXP);

        booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);

        callExpEClass = createEClass(CALL_EXP);

        collectionItemEClass = createEClass(COLLECTION_ITEM);

        collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);

        collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);

        collectionRangeEClass = createEClass(COLLECTION_RANGE);

        enumLiteralExpEClass = createEClass(ENUM_LITERAL_EXP);

        featureCallExpEClass = createEClass(FEATURE_CALL_EXP);

        ifExpEClass = createEClass(IF_EXP);

        integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);

        unlimitedNaturalLiteralExpEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP);

        invalidLiteralExpEClass = createEClass(INVALID_LITERAL_EXP);

        iterateExpEClass = createEClass(ITERATE_EXP);

        iteratorExpEClass = createEClass(ITERATOR_EXP);

        letExpEClass = createEClass(LET_EXP);

        literalExpEClass = createEClass(LITERAL_EXP);

        loopExpEClass = createEClass(LOOP_EXP);

        messageExpEClass = createEClass(MESSAGE_EXP);

        navigationCallExpEClass = createEClass(NAVIGATION_CALL_EXP);

        nullLiteralExpEClass = createEClass(NULL_LITERAL_EXP);

        numericLiteralExpEClass = createEClass(NUMERIC_LITERAL_EXP);

        oclExpressionEClass = createEClass(OCL_EXPRESSION);

        operationCallExpEClass = createEClass(OPERATION_CALL_EXP);

        primitiveLiteralExpEClass = createEClass(PRIMITIVE_LITERAL_EXP);

        propertyCallExpEClass = createEClass(PROPERTY_CALL_EXP);

        realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);

        stateExpEClass = createEClass(STATE_EXP);

        stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);

        tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);

        tupleLiteralPartEClass = createEClass(TUPLE_LITERAL_PART);

        typeExpEClass = createEClass(TYPE_EXP);

        unspecifiedValueExpEClass = createEClass(UNSPECIFIED_VALUE_EXP);

        variableEClass = createEClass(VARIABLE);

        variableExpEClass = createEClass(VARIABLE_EXP);

        businessTypeEClass = createEClass(BUSINESS_TYPE);
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
        TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage) EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);
        ExpressionsPackage theExpressionsPackage = (ExpressionsPackage) EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
        DiagramsPackage theDiagramsPackage = (DiagramsPackage) EPackage.Registry.INSTANCE.getEPackage(DiagramsPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        EGenericType g1 = createEGenericType(this.getBusinessType());
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getAnyType());
        EGenericType g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getBagType());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage.getEClassifier());
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getCollectionType());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        elementTypeEClass.getESuperTypes().add(this.getBusinessType());
        elementTypeEClass.getESuperTypes().add(theTypesPackage.getElementType());
        g1 = createEGenericType(this.getBusinessType());
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getInvalidType());
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage.getEClass());
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getMessageType());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getOrderedSetType());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage.getEDataType());
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getPrimitiveType());
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getSequenceType());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getSetType());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage.getEClass());
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getTupleType());
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getBusinessType());
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getTypeType());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getBusinessType());
        voidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getVoidType());
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        voidTypeEClass.getEGenericSuperTypes().add(g1);
        constraintEClass.getESuperTypes().add(theEcorePackage.getEClassifier());
        g1 = createEGenericType(theUtilitiesPackage.getExpressionInOCL());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        expressionInOCLEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNavigationCallExp());
        associationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getAssociationClassCallExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        associationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getPrimitiveLiteralExp());
        booleanLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getBooleanLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        booleanLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        callExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getCallExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        callExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionLiteralPart());
        collectionItemEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getCollectionItem());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        collectionItemEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        collectionLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getCollectionLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        collectionLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getCollectionLiteralPart());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        collectionLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionLiteralPart());
        collectionRangeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getCollectionRange());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        collectionRangeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        enumLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getEnumLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEEnumLiteral());
        g1.getETypeArguments().add(g2);
        enumLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCallExp());
        featureCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getFeatureCallExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        featureCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        ifExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getIfExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        ifExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNumericLiteralExp());
        integerLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getIntegerLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        integerLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNumericLiteralExp());
        unlimitedNaturalLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getUnlimitedNaturalLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        unlimitedNaturalLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        invalidLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getInvalidLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        invalidLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLoopExp());
        iterateExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getIterateExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        iterateExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLoopExp());
        iteratorExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getIteratorExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        iteratorExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        letExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getLetExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        letExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        literalExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        literalExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getLoopExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        loopExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCallExp());
        loopExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        messageExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getMessageExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(this.getCallOperationAction());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(this.getSendSignalAction());
        g1.getETypeArguments().add(g2);
        messageExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getFeatureCallExp());
        navigationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getNavigationCallExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        navigationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        nullLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getNullLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        nullLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getPrimitiveLiteralExp());
        numericLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getNumericLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        numericLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getOCLExpression());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        oclExpressionEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getFeatureCallExp());
        operationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getOperationCallExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEOperation());
        g1.getETypeArguments().add(g2);
        operationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getPrimitiveLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        primitiveLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        primitiveLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNavigationCallExp());
        propertyCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getPropertyCallExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        propertyCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNumericLiteralExp());
        realLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getRealLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        realLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        stateExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getStateExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEObject());
        g1.getETypeArguments().add(g2);
        stateExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getPrimitiveLiteralExp());
        stringLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getStringLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        stringLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        tupleLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getTupleLiteralExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        tupleLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getTupleLiteralPart());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        tupleLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        typeExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getTypeExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        typeExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        unspecifiedValueExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getUnspecifiedValueExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        unspecifiedValueExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getVariable());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        variableEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        variableExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theExpressionsPackage.getVariableExp());
        g2 = createEGenericType(this.getBusinessType());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        variableExpEClass.getEGenericSuperTypes().add(g1);
        businessTypeEClass.getESuperTypes().add(theDiagramsPackage.getDiagrams());

        // Initialize classes and features; add operations and parameters
        initEClass(anyTypeEClass, AnyType.class, "AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(bagTypeEClass, BagType.class, "BagType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(invalidTypeEClass, InvalidType.class, "InvalidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(messageTypeEClass, MessageType.class, "MessageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(orderedSetTypeEClass, OrderedSetType.class, "OrderedSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(sequenceTypeEClass, SequenceType.class, "SequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(typeTypeEClass, TypeType.class, "TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(callOperationActionEClass, CallOperationAction.class, "CallOperationAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCallOperationAction_Operation(), theEcorePackage.getEOperation(), null, "operation", null, 1, 1, CallOperationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(theUtilitiesPackage.getExpressionInOCL());
        g2 = createEGenericType(theEcorePackage.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage.getEParameter());
        g1.getETypeArguments().add(g2);
        initEReference(getConstraint_Specification(), g1, null, "specification", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConstraint_ConstrainedElements(), this.getBusinessType(), null, "constrainedElements", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConstraint_Stereotype(), theEcorePackage.getEString(), "stereotype", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sendSignalActionEClass, SendSignalAction.class, "SendSignalAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSendSignalAction_Signal(), this.getBusinessType(), null, "signal", null, 1, 1, SendSignalAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(expressionInOCLEClass, ExpressionInOCL.class, "ExpressionInOCL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(associationCallExpEClass, AssociationCallExp.class, "AssociationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(callExpEClass, CallExp.class, "CallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(collectionItemEClass, CollectionItem.class, "CollectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(collectionLiteralExpEClass, CollectionLiteralExp.class, "CollectionLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(collectionLiteralPartEClass, CollectionLiteralPart.class, "CollectionLiteralPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(collectionRangeEClass, CollectionRange.class, "CollectionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(enumLiteralExpEClass, EnumLiteralExp.class, "EnumLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(featureCallExpEClass, FeatureCallExp.class, "FeatureCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(ifExpEClass, IfExp.class, "IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(integerLiteralExpEClass, IntegerLiteralExp.class, "IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(unlimitedNaturalLiteralExpEClass, UnlimitedNaturalLiteralExp.class, "UnlimitedNaturalLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(invalidLiteralExpEClass, InvalidLiteralExp.class, "InvalidLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(iterateExpEClass, IterateExp.class, "IterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(iteratorExpEClass, IteratorExp.class, "IteratorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(letExpEClass, LetExp.class, "LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(literalExpEClass, LiteralExp.class, "LiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(loopExpEClass, LoopExp.class, "LoopExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(messageExpEClass, MessageExp.class, "MessageExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(navigationCallExpEClass, NavigationCallExp.class, "NavigationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(nullLiteralExpEClass, NullLiteralExp.class, "NullLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(numericLiteralExpEClass, NumericLiteralExp.class, "NumericLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(oclExpressionEClass, OCLExpression.class, "OCLExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(operationCallExpEClass, OperationCallExp.class, "OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(primitiveLiteralExpEClass, PrimitiveLiteralExp.class, "PrimitiveLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(propertyCallExpEClass, PropertyCallExp.class, "PropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(realLiteralExpEClass, RealLiteralExp.class, "RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stateExpEClass, StateExp.class, "StateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tupleLiteralExpEClass, TupleLiteralExp.class, "TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tupleLiteralPartEClass, TupleLiteralPart.class, "TupleLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(typeExpEClass, TypeExp.class, "TypeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(unspecifiedValueExpEClass, UnspecifiedValueExp.class, "UnspecifiedValueExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(variableExpEClass, VariableExp.class, "VariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(businessTypeEClass, BusinessType.class, "BusinessType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} // OcldiagramsPackageImpl
