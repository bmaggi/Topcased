/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiagramsFactoryImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.topcased.modeler.ocl.ocldiagrams.AnyType;
import org.topcased.modeler.ocl.ocldiagrams.AssociationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.BagType;
import org.topcased.modeler.ocl.ocldiagrams.BooleanLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.CallOperationAction;
import org.topcased.modeler.ocl.ocldiagrams.CollectionItem;
import org.topcased.modeler.ocl.ocldiagrams.CollectionLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.CollectionRange;
import org.topcased.modeler.ocl.ocldiagrams.CollectionType;
import org.topcased.modeler.ocl.ocldiagrams.Constraint;
import org.topcased.modeler.ocl.ocldiagrams.ElementType;
import org.topcased.modeler.ocl.ocldiagrams.EnumLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.ExpressionInOCL;
import org.topcased.modeler.ocl.ocldiagrams.IfExp;
import org.topcased.modeler.ocl.ocldiagrams.IntegerLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.InvalidLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.InvalidType;
import org.topcased.modeler.ocl.ocldiagrams.IterateExp;
import org.topcased.modeler.ocl.ocldiagrams.IteratorExp;
import org.topcased.modeler.ocl.ocldiagrams.LetExp;
import org.topcased.modeler.ocl.ocldiagrams.MessageExp;
import org.topcased.modeler.ocl.ocldiagrams.MessageType;
import org.topcased.modeler.ocl.ocldiagrams.NullLiteralExp;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsFactory;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.OperationCallExp;
import org.topcased.modeler.ocl.ocldiagrams.OrderedSetType;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OcldiagramsFactoryImpl extends EFactoryImpl implements OcldiagramsFactory
{
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static OcldiagramsFactory init()
    {
        try
        {
            OcldiagramsFactory theOcldiagramsFactory = (OcldiagramsFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/ocl/1.0/OCLDiagrams");
            if (theOcldiagramsFactory != null)
            {
                return theOcldiagramsFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OcldiagramsFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiagramsFactoryImpl()
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
            case OcldiagramsPackage.ANY_TYPE:
                return createAnyType();
            case OcldiagramsPackage.BAG_TYPE:
                return createBagType();
            case OcldiagramsPackage.COLLECTION_TYPE:
                return createCollectionType();
            case OcldiagramsPackage.ELEMENT_TYPE:
                return createElementType();
            case OcldiagramsPackage.INVALID_TYPE:
                return createInvalidType();
            case OcldiagramsPackage.MESSAGE_TYPE:
                return createMessageType();
            case OcldiagramsPackage.ORDERED_SET_TYPE:
                return createOrderedSetType();
            case OcldiagramsPackage.PRIMITIVE_TYPE:
                return createPrimitiveType();
            case OcldiagramsPackage.SEQUENCE_TYPE:
                return createSequenceType();
            case OcldiagramsPackage.SET_TYPE:
                return createSetType();
            case OcldiagramsPackage.TUPLE_TYPE:
                return createTupleType();
            case OcldiagramsPackage.TYPE_TYPE:
                return createTypeType();
            case OcldiagramsPackage.VOID_TYPE:
                return createVoidType();
            case OcldiagramsPackage.CALL_OPERATION_ACTION:
                return createCallOperationAction();
            case OcldiagramsPackage.CONSTRAINT:
                return createConstraint();
            case OcldiagramsPackage.SEND_SIGNAL_ACTION:
                return createSendSignalAction();
            case OcldiagramsPackage.EXPRESSION_IN_OCL:
                return createExpressionInOCL();
            case OcldiagramsPackage.ASSOCIATION_CALL_EXP:
                return createAssociationCallExp();
            case OcldiagramsPackage.BOOLEAN_LITERAL_EXP:
                return createBooleanLiteralExp();
            case OcldiagramsPackage.COLLECTION_ITEM:
                return createCollectionItem();
            case OcldiagramsPackage.COLLECTION_LITERAL_EXP:
                return createCollectionLiteralExp();
            case OcldiagramsPackage.COLLECTION_RANGE:
                return createCollectionRange();
            case OcldiagramsPackage.ENUM_LITERAL_EXP:
                return createEnumLiteralExp();
            case OcldiagramsPackage.IF_EXP:
                return createIfExp();
            case OcldiagramsPackage.INTEGER_LITERAL_EXP:
                return createIntegerLiteralExp();
            case OcldiagramsPackage.UNLIMITED_NATURAL_LITERAL_EXP:
                return createUnlimitedNaturalLiteralExp();
            case OcldiagramsPackage.INVALID_LITERAL_EXP:
                return createInvalidLiteralExp();
            case OcldiagramsPackage.ITERATE_EXP:
                return createIterateExp();
            case OcldiagramsPackage.ITERATOR_EXP:
                return createIteratorExp();
            case OcldiagramsPackage.LET_EXP:
                return createLetExp();
            case OcldiagramsPackage.MESSAGE_EXP:
                return createMessageExp();
            case OcldiagramsPackage.NULL_LITERAL_EXP:
                return createNullLiteralExp();
            case OcldiagramsPackage.OPERATION_CALL_EXP:
                return createOperationCallExp();
            case OcldiagramsPackage.PROPERTY_CALL_EXP:
                return createPropertyCallExp();
            case OcldiagramsPackage.REAL_LITERAL_EXP:
                return createRealLiteralExp();
            case OcldiagramsPackage.STATE_EXP:
                return createStateExp();
            case OcldiagramsPackage.STRING_LITERAL_EXP:
                return createStringLiteralExp();
            case OcldiagramsPackage.TUPLE_LITERAL_EXP:
                return createTupleLiteralExp();
            case OcldiagramsPackage.TUPLE_LITERAL_PART:
                return createTupleLiteralPart();
            case OcldiagramsPackage.TYPE_EXP:
                return createTypeExp();
            case OcldiagramsPackage.UNSPECIFIED_VALUE_EXP:
                return createUnspecifiedValueExp();
            case OcldiagramsPackage.VARIABLE:
                return createVariable();
            case OcldiagramsPackage.VARIABLE_EXP:
                return createVariableExp();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AnyType createAnyType()
    {
        AnyTypeImpl anyType = new AnyTypeImpl();
        return anyType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BagType createBagType()
    {
        BagTypeImpl bagType = new BagTypeImpl();
        return bagType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CollectionType createCollectionType()
    {
        CollectionTypeImpl collectionType = new CollectionTypeImpl();
        return collectionType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ElementType createElementType()
    {
        ElementTypeImpl elementType = new ElementTypeImpl();
        return elementType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InvalidType createInvalidType()
    {
        InvalidTypeImpl invalidType = new InvalidTypeImpl();
        return invalidType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MessageType createMessageType()
    {
        MessageTypeImpl messageType = new MessageTypeImpl();
        return messageType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OrderedSetType createOrderedSetType()
    {
        OrderedSetTypeImpl orderedSetType = new OrderedSetTypeImpl();
        return orderedSetType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PrimitiveType createPrimitiveType()
    {
        PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SequenceType createSequenceType()
    {
        SequenceTypeImpl sequenceType = new SequenceTypeImpl();
        return sequenceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SetType createSetType()
    {
        SetTypeImpl setType = new SetTypeImpl();
        return setType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TupleType createTupleType()
    {
        TupleTypeImpl tupleType = new TupleTypeImpl();
        return tupleType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TypeType createTypeType()
    {
        TypeTypeImpl typeType = new TypeTypeImpl();
        return typeType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VoidType createVoidType()
    {
        VoidTypeImpl voidType = new VoidTypeImpl();
        return voidType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CallOperationAction createCallOperationAction()
    {
        CallOperationActionImpl callOperationAction = new CallOperationActionImpl();
        return callOperationAction;
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
    public SendSignalAction createSendSignalAction()
    {
        SendSignalActionImpl sendSignalAction = new SendSignalActionImpl();
        return sendSignalAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ExpressionInOCL createExpressionInOCL()
    {
        ExpressionInOCLImpl expressionInOCL = new ExpressionInOCLImpl();
        return expressionInOCL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssociationCallExp createAssociationCallExp()
    {
        AssociationCallExpImpl associationCallExp = new AssociationCallExpImpl();
        return associationCallExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BooleanLiteralExp createBooleanLiteralExp()
    {
        BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
        return booleanLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CollectionItem createCollectionItem()
    {
        CollectionItemImpl collectionItem = new CollectionItemImpl();
        return collectionItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CollectionLiteralExp createCollectionLiteralExp()
    {
        CollectionLiteralExpImpl collectionLiteralExp = new CollectionLiteralExpImpl();
        return collectionLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CollectionRange createCollectionRange()
    {
        CollectionRangeImpl collectionRange = new CollectionRangeImpl();
        return collectionRange;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EnumLiteralExp createEnumLiteralExp()
    {
        EnumLiteralExpImpl enumLiteralExp = new EnumLiteralExpImpl();
        return enumLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IfExp createIfExp()
    {
        IfExpImpl ifExp = new IfExpImpl();
        return ifExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IntegerLiteralExp createIntegerLiteralExp()
    {
        IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
        return integerLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp()
    {
        UnlimitedNaturalLiteralExpImpl unlimitedNaturalLiteralExp = new UnlimitedNaturalLiteralExpImpl();
        return unlimitedNaturalLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InvalidLiteralExp createInvalidLiteralExp()
    {
        InvalidLiteralExpImpl invalidLiteralExp = new InvalidLiteralExpImpl();
        return invalidLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IterateExp createIterateExp()
    {
        IterateExpImpl iterateExp = new IterateExpImpl();
        return iterateExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IteratorExp createIteratorExp()
    {
        IteratorExpImpl iteratorExp = new IteratorExpImpl();
        return iteratorExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public LetExp createLetExp()
    {
        LetExpImpl letExp = new LetExpImpl();
        return letExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MessageExp createMessageExp()
    {
        MessageExpImpl messageExp = new MessageExpImpl();
        return messageExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NullLiteralExp createNullLiteralExp()
    {
        NullLiteralExpImpl nullLiteralExp = new NullLiteralExpImpl();
        return nullLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OperationCallExp createOperationCallExp()
    {
        OperationCallExpImpl operationCallExp = new OperationCallExpImpl();
        return operationCallExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PropertyCallExp createPropertyCallExp()
    {
        PropertyCallExpImpl propertyCallExp = new PropertyCallExpImpl();
        return propertyCallExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RealLiteralExp createRealLiteralExp()
    {
        RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
        return realLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public StateExp createStateExp()
    {
        StateExpImpl stateExp = new StateExpImpl();
        return stateExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public StringLiteralExp createStringLiteralExp()
    {
        StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
        return stringLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TupleLiteralExp createTupleLiteralExp()
    {
        TupleLiteralExpImpl tupleLiteralExp = new TupleLiteralExpImpl();
        return tupleLiteralExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TupleLiteralPart createTupleLiteralPart()
    {
        TupleLiteralPartImpl tupleLiteralPart = new TupleLiteralPartImpl();
        return tupleLiteralPart;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TypeExp createTypeExp()
    {
        TypeExpImpl typeExp = new TypeExpImpl();
        return typeExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public UnspecifiedValueExp createUnspecifiedValueExp()
    {
        UnspecifiedValueExpImpl unspecifiedValueExp = new UnspecifiedValueExpImpl();
        return unspecifiedValueExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Variable createVariable()
    {
        VariableImpl variable = new VariableImpl();
        return variable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VariableExp createVariableExp()
    {
        VariableExpImpl variableExp = new VariableExpImpl();
        return variableExp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiagramsPackage getOcldiagramsPackage()
    {
        return (OcldiagramsPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static OcldiagramsPackage getPackage()
    {
        return OcldiagramsPackage.eINSTANCE;
    }

} // OcldiagramsFactoryImpl
