/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiFactoryImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.topcased.modeler.ocl.ocldi.AnyType;
import org.topcased.modeler.ocl.ocldi.AssociationCallExp;
import org.topcased.modeler.ocl.ocldi.BagType;
import org.topcased.modeler.ocl.ocldi.BooleanLiteralExp;
import org.topcased.modeler.ocl.ocldi.CallOperationAction;
import org.topcased.modeler.ocl.ocldi.CollectionItem;
import org.topcased.modeler.ocl.ocldi.CollectionLiteralExp;
import org.topcased.modeler.ocl.ocldi.CollectionRange;
import org.topcased.modeler.ocl.ocldi.CollectionType;
import org.topcased.modeler.ocl.ocldi.Constraint;
import org.topcased.modeler.ocl.ocldi.ElementType;
import org.topcased.modeler.ocl.ocldi.EnumLiteralExp;
import org.topcased.modeler.ocl.ocldi.ExpressionInOCL;
import org.topcased.modeler.ocl.ocldi.IfExp;
import org.topcased.modeler.ocl.ocldi.IntegerLiteralExp;
import org.topcased.modeler.ocl.ocldi.InvalidLiteralExp;
import org.topcased.modeler.ocl.ocldi.InvalidType;
import org.topcased.modeler.ocl.ocldi.IterateExp;
import org.topcased.modeler.ocl.ocldi.IteratorExp;
import org.topcased.modeler.ocl.ocldi.LetExp;
import org.topcased.modeler.ocl.ocldi.MessageExp;
import org.topcased.modeler.ocl.ocldi.MessageType;
import org.topcased.modeler.ocl.ocldi.NullLiteralExp;
import org.topcased.modeler.ocl.ocldi.OcldiFactory;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.OperationCallExp;
import org.topcased.modeler.ocl.ocldi.OrderedSetType;
import org.topcased.modeler.ocl.ocldi.PrimitiveType;
import org.topcased.modeler.ocl.ocldi.PropertyCallExp;
import org.topcased.modeler.ocl.ocldi.RealLiteralExp;
import org.topcased.modeler.ocl.ocldi.SendSignalAction;
import org.topcased.modeler.ocl.ocldi.SequenceType;
import org.topcased.modeler.ocl.ocldi.SetType;
import org.topcased.modeler.ocl.ocldi.StateExp;
import org.topcased.modeler.ocl.ocldi.StringLiteralExp;
import org.topcased.modeler.ocl.ocldi.TupleLiteralExp;
import org.topcased.modeler.ocl.ocldi.TupleLiteralPart;
import org.topcased.modeler.ocl.ocldi.TupleType;
import org.topcased.modeler.ocl.ocldi.TypeExp;
import org.topcased.modeler.ocl.ocldi.TypeType;
import org.topcased.modeler.ocl.ocldi.UnlimitedNaturalLiteralExp;
import org.topcased.modeler.ocl.ocldi.UnspecifiedValueExp;
import org.topcased.modeler.ocl.ocldi.Variable;
import org.topcased.modeler.ocl.ocldi.VariableExp;
import org.topcased.modeler.ocl.ocldi.VoidType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OcldiFactoryImpl extends EFactoryImpl implements OcldiFactory
{
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static OcldiFactory init()
    {
        try
        {
            OcldiFactory theOcldiFactory = (OcldiFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/ocl/1.0/OCLDi");
            if (theOcldiFactory != null)
            {
                return theOcldiFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OcldiFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiFactoryImpl()
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
            case OcldiPackage.ANY_TYPE:
                return createAnyType();
            case OcldiPackage.BAG_TYPE:
                return createBagType();
            case OcldiPackage.COLLECTION_TYPE:
                return createCollectionType();
            case OcldiPackage.ELEMENT_TYPE:
                return createElementType();
            case OcldiPackage.INVALID_TYPE:
                return createInvalidType();
            case OcldiPackage.MESSAGE_TYPE:
                return createMessageType();
            case OcldiPackage.ORDERED_SET_TYPE:
                return createOrderedSetType();
            case OcldiPackage.PRIMITIVE_TYPE:
                return createPrimitiveType();
            case OcldiPackage.SEQUENCE_TYPE:
                return createSequenceType();
            case OcldiPackage.SET_TYPE:
                return createSetType();
            case OcldiPackage.TUPLE_TYPE:
                return createTupleType();
            case OcldiPackage.TYPE_TYPE:
                return createTypeType();
            case OcldiPackage.VOID_TYPE:
                return createVoidType();
            case OcldiPackage.CALL_OPERATION_ACTION:
                return createCallOperationAction();
            case OcldiPackage.CONSTRAINT:
                return createConstraint();
            case OcldiPackage.SEND_SIGNAL_ACTION:
                return createSendSignalAction();
            case OcldiPackage.EXPRESSION_IN_OCL:
                return createExpressionInOCL();
            case OcldiPackage.ASSOCIATION_CALL_EXP:
                return createAssociationCallExp();
            case OcldiPackage.BOOLEAN_LITERAL_EXP:
                return createBooleanLiteralExp();
            case OcldiPackage.COLLECTION_ITEM:
                return createCollectionItem();
            case OcldiPackage.COLLECTION_LITERAL_EXP:
                return createCollectionLiteralExp();
            case OcldiPackage.COLLECTION_RANGE:
                return createCollectionRange();
            case OcldiPackage.ENUM_LITERAL_EXP:
                return createEnumLiteralExp();
            case OcldiPackage.IF_EXP:
                return createIfExp();
            case OcldiPackage.INTEGER_LITERAL_EXP:
                return createIntegerLiteralExp();
            case OcldiPackage.UNLIMITED_NATURAL_LITERAL_EXP:
                return createUnlimitedNaturalLiteralExp();
            case OcldiPackage.INVALID_LITERAL_EXP:
                return createInvalidLiteralExp();
            case OcldiPackage.ITERATE_EXP:
                return createIterateExp();
            case OcldiPackage.ITERATOR_EXP:
                return createIteratorExp();
            case OcldiPackage.LET_EXP:
                return createLetExp();
            case OcldiPackage.MESSAGE_EXP:
                return createMessageExp();
            case OcldiPackage.NULL_LITERAL_EXP:
                return createNullLiteralExp();
            case OcldiPackage.OPERATION_CALL_EXP:
                return createOperationCallExp();
            case OcldiPackage.PROPERTY_CALL_EXP:
                return createPropertyCallExp();
            case OcldiPackage.REAL_LITERAL_EXP:
                return createRealLiteralExp();
            case OcldiPackage.STATE_EXP:
                return createStateExp();
            case OcldiPackage.STRING_LITERAL_EXP:
                return createStringLiteralExp();
            case OcldiPackage.TUPLE_LITERAL_EXP:
                return createTupleLiteralExp();
            case OcldiPackage.TUPLE_LITERAL_PART:
                return createTupleLiteralPart();
            case OcldiPackage.TYPE_EXP:
                return createTypeExp();
            case OcldiPackage.UNSPECIFIED_VALUE_EXP:
                return createUnspecifiedValueExp();
            case OcldiPackage.VARIABLE:
                return createVariable();
            case OcldiPackage.VARIABLE_EXP:
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
    public OcldiPackage getOcldiPackage()
    {
        return (OcldiPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static OcldiPackage getPackage()
    {
        return OcldiPackage.eINSTANCE;
    }

} // OcldiFactoryImpl
