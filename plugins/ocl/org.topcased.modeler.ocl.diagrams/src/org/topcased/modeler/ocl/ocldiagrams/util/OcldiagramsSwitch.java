/**
 * <copyright>
 * </copyright>
 *
 * $Id: OcldiagramsSwitch.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;
import org.topcased.modeler.diagrams.model.Diagrams;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage
 * @generated
 */
public class OcldiagramsSwitch<T>
{
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static OcldiagramsPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OcldiagramsSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = OcldiagramsPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject)
    {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject)
    {
        if (theEClass.eContainer() == modelPackage)
        {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else
        {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case OcldiagramsPackage.ANY_TYPE: {
                AnyType anyType = (AnyType) theEObject;
                T result = caseAnyType(anyType);
                if (result == null)
                    result = caseBusinessType(anyType);
                if (result == null)
                    result = caseAnyType_1(anyType);
                if (result == null)
                    result = caseDiagrams(anyType);
                if (result == null)
                    result = casePredefinedType(anyType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.BAG_TYPE: {
                BagType bagType = (BagType) theEObject;
                T result = caseBagType(bagType);
                if (result == null)
                    result = caseCollectionType(bagType);
                if (result == null)
                    result = caseBagType_1(bagType);
                if (result == null)
                    result = caseEClassifier(bagType);
                if (result == null)
                    result = caseCollectionType_1(bagType);
                if (result == null)
                    result = caseENamedElement(bagType);
                if (result == null)
                    result = casePredefinedType(bagType);
                if (result == null)
                    result = caseTypedASTNode(bagType);
                if (result == null)
                    result = caseEModelElement(bagType);
                if (result == null)
                    result = caseASTNode(bagType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.COLLECTION_TYPE: {
                CollectionType collectionType = (CollectionType) theEObject;
                T result = caseCollectionType(collectionType);
                if (result == null)
                    result = caseEClassifier(collectionType);
                if (result == null)
                    result = caseCollectionType_1(collectionType);
                if (result == null)
                    result = caseENamedElement(collectionType);
                if (result == null)
                    result = casePredefinedType(collectionType);
                if (result == null)
                    result = caseTypedASTNode(collectionType);
                if (result == null)
                    result = caseEModelElement(collectionType);
                if (result == null)
                    result = caseASTNode(collectionType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.ELEMENT_TYPE: {
                ElementType elementType = (ElementType) theEObject;
                T result = caseElementType(elementType);
                if (result == null)
                    result = caseBusinessType(elementType);
                if (result == null)
                    result = caseElementType_1(elementType);
                if (result == null)
                    result = caseDiagrams(elementType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.INVALID_TYPE: {
                InvalidType invalidType = (InvalidType) theEObject;
                T result = caseInvalidType(invalidType);
                if (result == null)
                    result = caseBusinessType(invalidType);
                if (result == null)
                    result = caseInvalidType_1(invalidType);
                if (result == null)
                    result = caseDiagrams(invalidType);
                if (result == null)
                    result = casePredefinedType(invalidType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.MESSAGE_TYPE: {
                MessageType messageType = (MessageType) theEObject;
                T result = caseMessageType(messageType);
                if (result == null)
                    result = caseEClass(messageType);
                if (result == null)
                    result = caseMessageType_1(messageType);
                if (result == null)
                    result = caseEClassifier(messageType);
                if (result == null)
                    result = casePredefinedType(messageType);
                if (result == null)
                    result = caseENamedElement(messageType);
                if (result == null)
                    result = caseEModelElement(messageType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.ORDERED_SET_TYPE: {
                OrderedSetType orderedSetType = (OrderedSetType) theEObject;
                T result = caseOrderedSetType(orderedSetType);
                if (result == null)
                    result = caseCollectionType(orderedSetType);
                if (result == null)
                    result = caseOrderedSetType_1(orderedSetType);
                if (result == null)
                    result = caseEClassifier(orderedSetType);
                if (result == null)
                    result = caseCollectionType_1(orderedSetType);
                if (result == null)
                    result = caseENamedElement(orderedSetType);
                if (result == null)
                    result = casePredefinedType(orderedSetType);
                if (result == null)
                    result = caseTypedASTNode(orderedSetType);
                if (result == null)
                    result = caseEModelElement(orderedSetType);
                if (result == null)
                    result = caseASTNode(orderedSetType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.PRIMITIVE_TYPE: {
                PrimitiveType primitiveType = (PrimitiveType) theEObject;
                T result = casePrimitiveType(primitiveType);
                if (result == null)
                    result = caseEDataType(primitiveType);
                if (result == null)
                    result = casePrimitiveType_1(primitiveType);
                if (result == null)
                    result = caseEClassifier(primitiveType);
                if (result == null)
                    result = casePredefinedType(primitiveType);
                if (result == null)
                    result = caseENamedElement(primitiveType);
                if (result == null)
                    result = caseEModelElement(primitiveType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.SEQUENCE_TYPE: {
                SequenceType sequenceType = (SequenceType) theEObject;
                T result = caseSequenceType(sequenceType);
                if (result == null)
                    result = caseCollectionType(sequenceType);
                if (result == null)
                    result = caseSequenceType_1(sequenceType);
                if (result == null)
                    result = caseEClassifier(sequenceType);
                if (result == null)
                    result = caseCollectionType_1(sequenceType);
                if (result == null)
                    result = caseENamedElement(sequenceType);
                if (result == null)
                    result = casePredefinedType(sequenceType);
                if (result == null)
                    result = caseTypedASTNode(sequenceType);
                if (result == null)
                    result = caseEModelElement(sequenceType);
                if (result == null)
                    result = caseASTNode(sequenceType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.SET_TYPE: {
                SetType setType = (SetType) theEObject;
                T result = caseSetType(setType);
                if (result == null)
                    result = caseCollectionType(setType);
                if (result == null)
                    result = caseSetType_1(setType);
                if (result == null)
                    result = caseEClassifier(setType);
                if (result == null)
                    result = caseCollectionType_1(setType);
                if (result == null)
                    result = caseENamedElement(setType);
                if (result == null)
                    result = casePredefinedType(setType);
                if (result == null)
                    result = caseTypedASTNode(setType);
                if (result == null)
                    result = caseEModelElement(setType);
                if (result == null)
                    result = caseASTNode(setType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.TUPLE_TYPE: {
                TupleType tupleType = (TupleType) theEObject;
                T result = caseTupleType(tupleType);
                if (result == null)
                    result = caseEClass(tupleType);
                if (result == null)
                    result = caseTupleType_1(tupleType);
                if (result == null)
                    result = caseEClassifier(tupleType);
                if (result == null)
                    result = casePredefinedType(tupleType);
                if (result == null)
                    result = caseENamedElement(tupleType);
                if (result == null)
                    result = caseEModelElement(tupleType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.TYPE_TYPE: {
                TypeType typeType = (TypeType) theEObject;
                T result = caseTypeType(typeType);
                if (result == null)
                    result = caseBusinessType(typeType);
                if (result == null)
                    result = caseTypeType_1(typeType);
                if (result == null)
                    result = caseDiagrams(typeType);
                if (result == null)
                    result = casePredefinedType(typeType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.VOID_TYPE: {
                VoidType voidType = (VoidType) theEObject;
                T result = caseVoidType(voidType);
                if (result == null)
                    result = caseBusinessType(voidType);
                if (result == null)
                    result = caseVoidType_1(voidType);
                if (result == null)
                    result = caseDiagrams(voidType);
                if (result == null)
                    result = casePredefinedType(voidType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.CALL_OPERATION_ACTION: {
                CallOperationAction callOperationAction = (CallOperationAction) theEObject;
                T result = caseCallOperationAction(callOperationAction);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.CONSTRAINT: {
                Constraint constraint = (Constraint) theEObject;
                T result = caseConstraint(constraint);
                if (result == null)
                    result = caseEClassifier(constraint);
                if (result == null)
                    result = caseENamedElement(constraint);
                if (result == null)
                    result = caseEModelElement(constraint);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.SEND_SIGNAL_ACTION: {
                SendSignalAction sendSignalAction = (SendSignalAction) theEObject;
                T result = caseSendSignalAction(sendSignalAction);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.EXPRESSION_IN_OCL: {
                ExpressionInOCL expressionInOCL = (ExpressionInOCL) theEObject;
                T result = caseExpressionInOCL(expressionInOCL);
                if (result == null)
                    result = caseExpressionInOCL_1(expressionInOCL);
                if (result == null)
                    result = caseVisitable(expressionInOCL);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.ASSOCIATION_CALL_EXP: {
                AssociationCallExp associationCallExp = (AssociationCallExp) theEObject;
                T result = caseAssociationCallExp(associationCallExp);
                if (result == null)
                    result = caseNavigationCallExp(associationCallExp);
                if (result == null)
                    result = caseAssociationClassCallExp(associationCallExp);
                if (result == null)
                    result = caseFeatureCallExp(associationCallExp);
                if (result == null)
                    result = caseNavigationCallExp_1(associationCallExp);
                if (result == null)
                    result = caseCallExp(associationCallExp);
                if (result == null)
                    result = caseFeatureCallExp_1(associationCallExp);
                if (result == null)
                    result = caseOCLExpression(associationCallExp);
                if (result == null)
                    result = caseCallExp_1(associationCallExp);
                if (result == null)
                    result = caseOCLExpression_1(associationCallExp);
                if (result == null)
                    result = caseCallingASTNode(associationCallExp);
                if (result == null)
                    result = caseTypedElement(associationCallExp);
                if (result == null)
                    result = caseVisitable(associationCallExp);
                if (result == null)
                    result = caseASTNode(associationCallExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.BOOLEAN_LITERAL_EXP: {
                BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp) theEObject;
                T result = caseBooleanLiteralExp(booleanLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp(booleanLiteralExp);
                if (result == null)
                    result = caseBooleanLiteralExp_1(booleanLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(booleanLiteralExp);
                if (result == null)
                    result = caseLiteralExp(booleanLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(booleanLiteralExp);
                if (result == null)
                    result = caseOCLExpression(booleanLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(booleanLiteralExp);
                if (result == null)
                    result = caseTypedElement(booleanLiteralExp);
                if (result == null)
                    result = caseVisitable(booleanLiteralExp);
                if (result == null)
                    result = caseASTNode(booleanLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.CALL_EXP: {
                CallExp callExp = (CallExp) theEObject;
                T result = caseCallExp(callExp);
                if (result == null)
                    result = caseOCLExpression(callExp);
                if (result == null)
                    result = caseCallExp_1(callExp);
                if (result == null)
                    result = caseOCLExpression_1(callExp);
                if (result == null)
                    result = caseCallingASTNode(callExp);
                if (result == null)
                    result = caseTypedElement(callExp);
                if (result == null)
                    result = caseVisitable(callExp);
                if (result == null)
                    result = caseASTNode(callExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.COLLECTION_ITEM: {
                CollectionItem collectionItem = (CollectionItem) theEObject;
                T result = caseCollectionItem(collectionItem);
                if (result == null)
                    result = caseCollectionLiteralPart(collectionItem);
                if (result == null)
                    result = caseCollectionItem_1(collectionItem);
                if (result == null)
                    result = caseCollectionLiteralPart_1(collectionItem);
                if (result == null)
                    result = caseTypedElement(collectionItem);
                if (result == null)
                    result = caseVisitable(collectionItem);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.COLLECTION_LITERAL_EXP: {
                CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp) theEObject;
                T result = caseCollectionLiteralExp(collectionLiteralExp);
                if (result == null)
                    result = caseLiteralExp(collectionLiteralExp);
                if (result == null)
                    result = caseCollectionLiteralExp_1(collectionLiteralExp);
                if (result == null)
                    result = caseOCLExpression(collectionLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(collectionLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(collectionLiteralExp);
                if (result == null)
                    result = caseTypedElement(collectionLiteralExp);
                if (result == null)
                    result = caseVisitable(collectionLiteralExp);
                if (result == null)
                    result = caseASTNode(collectionLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.COLLECTION_LITERAL_PART: {
                CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart) theEObject;
                T result = caseCollectionLiteralPart(collectionLiteralPart);
                if (result == null)
                    result = caseCollectionLiteralPart_1(collectionLiteralPart);
                if (result == null)
                    result = caseTypedElement(collectionLiteralPart);
                if (result == null)
                    result = caseVisitable(collectionLiteralPart);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.COLLECTION_RANGE: {
                CollectionRange collectionRange = (CollectionRange) theEObject;
                T result = caseCollectionRange(collectionRange);
                if (result == null)
                    result = caseCollectionLiteralPart(collectionRange);
                if (result == null)
                    result = caseCollectionRange_1(collectionRange);
                if (result == null)
                    result = caseCollectionLiteralPart_1(collectionRange);
                if (result == null)
                    result = caseTypedElement(collectionRange);
                if (result == null)
                    result = caseVisitable(collectionRange);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.ENUM_LITERAL_EXP: {
                EnumLiteralExp enumLiteralExp = (EnumLiteralExp) theEObject;
                T result = caseEnumLiteralExp(enumLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(enumLiteralExp);
                if (result == null)
                    result = caseEnumLiteralExp_1(enumLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(enumLiteralExp);
                if (result == null)
                    result = caseTypedElement(enumLiteralExp);
                if (result == null)
                    result = caseVisitable(enumLiteralExp);
                if (result == null)
                    result = caseASTNode(enumLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.FEATURE_CALL_EXP: {
                FeatureCallExp featureCallExp = (FeatureCallExp) theEObject;
                T result = caseFeatureCallExp(featureCallExp);
                if (result == null)
                    result = caseCallExp(featureCallExp);
                if (result == null)
                    result = caseFeatureCallExp_1(featureCallExp);
                if (result == null)
                    result = caseOCLExpression(featureCallExp);
                if (result == null)
                    result = caseCallExp_1(featureCallExp);
                if (result == null)
                    result = caseOCLExpression_1(featureCallExp);
                if (result == null)
                    result = caseCallingASTNode(featureCallExp);
                if (result == null)
                    result = caseTypedElement(featureCallExp);
                if (result == null)
                    result = caseVisitable(featureCallExp);
                if (result == null)
                    result = caseASTNode(featureCallExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.IF_EXP: {
                IfExp ifExp = (IfExp) theEObject;
                T result = caseIfExp(ifExp);
                if (result == null)
                    result = caseOCLExpression(ifExp);
                if (result == null)
                    result = caseIfExp_1(ifExp);
                if (result == null)
                    result = caseOCLExpression_1(ifExp);
                if (result == null)
                    result = caseTypedElement(ifExp);
                if (result == null)
                    result = caseVisitable(ifExp);
                if (result == null)
                    result = caseASTNode(ifExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.INTEGER_LITERAL_EXP: {
                IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp) theEObject;
                T result = caseIntegerLiteralExp(integerLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp(integerLiteralExp);
                if (result == null)
                    result = caseIntegerLiteralExp_1(integerLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp(integerLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp_1(integerLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(integerLiteralExp);
                if (result == null)
                    result = caseLiteralExp(integerLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(integerLiteralExp);
                if (result == null)
                    result = caseOCLExpression(integerLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(integerLiteralExp);
                if (result == null)
                    result = caseTypedElement(integerLiteralExp);
                if (result == null)
                    result = caseVisitable(integerLiteralExp);
                if (result == null)
                    result = caseASTNode(integerLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.UNLIMITED_NATURAL_LITERAL_EXP: {
                UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp = (UnlimitedNaturalLiteralExp) theEObject;
                T result = caseUnlimitedNaturalLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseUnlimitedNaturalLiteralExp_1(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp_1(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseLiteralExp(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseOCLExpression(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseTypedElement(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseVisitable(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = caseASTNode(unlimitedNaturalLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.INVALID_LITERAL_EXP: {
                InvalidLiteralExp invalidLiteralExp = (InvalidLiteralExp) theEObject;
                T result = caseInvalidLiteralExp(invalidLiteralExp);
                if (result == null)
                    result = caseLiteralExp(invalidLiteralExp);
                if (result == null)
                    result = caseInvalidLiteralExp_1(invalidLiteralExp);
                if (result == null)
                    result = caseOCLExpression(invalidLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(invalidLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(invalidLiteralExp);
                if (result == null)
                    result = caseTypedElement(invalidLiteralExp);
                if (result == null)
                    result = caseVisitable(invalidLiteralExp);
                if (result == null)
                    result = caseASTNode(invalidLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.ITERATE_EXP: {
                IterateExp iterateExp = (IterateExp) theEObject;
                T result = caseIterateExp(iterateExp);
                if (result == null)
                    result = caseLoopExp(iterateExp);
                if (result == null)
                    result = caseIterateExp_1(iterateExp);
                if (result == null)
                    result = caseLoopExp_1(iterateExp);
                if (result == null)
                    result = caseCallExp(iterateExp);
                if (result == null)
                    result = caseCallExp_1(iterateExp);
                if (result == null)
                    result = caseOCLExpression(iterateExp);
                if (result == null)
                    result = caseOCLExpression_1(iterateExp);
                if (result == null)
                    result = caseCallingASTNode(iterateExp);
                if (result == null)
                    result = caseTypedElement(iterateExp);
                if (result == null)
                    result = caseVisitable(iterateExp);
                if (result == null)
                    result = caseASTNode(iterateExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.ITERATOR_EXP: {
                IteratorExp iteratorExp = (IteratorExp) theEObject;
                T result = caseIteratorExp(iteratorExp);
                if (result == null)
                    result = caseLoopExp(iteratorExp);
                if (result == null)
                    result = caseIteratorExp_1(iteratorExp);
                if (result == null)
                    result = caseLoopExp_1(iteratorExp);
                if (result == null)
                    result = caseCallExp(iteratorExp);
                if (result == null)
                    result = caseCallExp_1(iteratorExp);
                if (result == null)
                    result = caseOCLExpression(iteratorExp);
                if (result == null)
                    result = caseOCLExpression_1(iteratorExp);
                if (result == null)
                    result = caseCallingASTNode(iteratorExp);
                if (result == null)
                    result = caseTypedElement(iteratorExp);
                if (result == null)
                    result = caseVisitable(iteratorExp);
                if (result == null)
                    result = caseASTNode(iteratorExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.LET_EXP: {
                LetExp letExp = (LetExp) theEObject;
                T result = caseLetExp(letExp);
                if (result == null)
                    result = caseOCLExpression(letExp);
                if (result == null)
                    result = caseLetExp_1(letExp);
                if (result == null)
                    result = caseOCLExpression_1(letExp);
                if (result == null)
                    result = caseTypedElement(letExp);
                if (result == null)
                    result = caseVisitable(letExp);
                if (result == null)
                    result = caseASTNode(letExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.LITERAL_EXP: {
                LiteralExp literalExp = (LiteralExp) theEObject;
                T result = caseLiteralExp(literalExp);
                if (result == null)
                    result = caseOCLExpression(literalExp);
                if (result == null)
                    result = caseLiteralExp_1(literalExp);
                if (result == null)
                    result = caseOCLExpression_1(literalExp);
                if (result == null)
                    result = caseTypedElement(literalExp);
                if (result == null)
                    result = caseVisitable(literalExp);
                if (result == null)
                    result = caseASTNode(literalExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.LOOP_EXP: {
                LoopExp loopExp = (LoopExp) theEObject;
                T result = caseLoopExp(loopExp);
                if (result == null)
                    result = caseLoopExp_1(loopExp);
                if (result == null)
                    result = caseCallExp(loopExp);
                if (result == null)
                    result = caseCallExp_1(loopExp);
                if (result == null)
                    result = caseOCLExpression(loopExp);
                if (result == null)
                    result = caseOCLExpression_1(loopExp);
                if (result == null)
                    result = caseCallingASTNode(loopExp);
                if (result == null)
                    result = caseTypedElement(loopExp);
                if (result == null)
                    result = caseVisitable(loopExp);
                if (result == null)
                    result = caseASTNode(loopExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.MESSAGE_EXP: {
                MessageExp messageExp = (MessageExp) theEObject;
                T result = caseMessageExp(messageExp);
                if (result == null)
                    result = caseOCLExpression(messageExp);
                if (result == null)
                    result = caseMessageExp_1(messageExp);
                if (result == null)
                    result = caseOCLExpression_1(messageExp);
                if (result == null)
                    result = caseCallingASTNode(messageExp);
                if (result == null)
                    result = caseTypedElement(messageExp);
                if (result == null)
                    result = caseVisitable(messageExp);
                if (result == null)
                    result = caseASTNode(messageExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.NAVIGATION_CALL_EXP: {
                NavigationCallExp navigationCallExp = (NavigationCallExp) theEObject;
                T result = caseNavigationCallExp(navigationCallExp);
                if (result == null)
                    result = caseFeatureCallExp(navigationCallExp);
                if (result == null)
                    result = caseNavigationCallExp_1(navigationCallExp);
                if (result == null)
                    result = caseCallExp(navigationCallExp);
                if (result == null)
                    result = caseFeatureCallExp_1(navigationCallExp);
                if (result == null)
                    result = caseOCLExpression(navigationCallExp);
                if (result == null)
                    result = caseCallExp_1(navigationCallExp);
                if (result == null)
                    result = caseOCLExpression_1(navigationCallExp);
                if (result == null)
                    result = caseCallingASTNode(navigationCallExp);
                if (result == null)
                    result = caseTypedElement(navigationCallExp);
                if (result == null)
                    result = caseVisitable(navigationCallExp);
                if (result == null)
                    result = caseASTNode(navigationCallExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.NULL_LITERAL_EXP: {
                NullLiteralExp nullLiteralExp = (NullLiteralExp) theEObject;
                T result = caseNullLiteralExp(nullLiteralExp);
                if (result == null)
                    result = caseLiteralExp(nullLiteralExp);
                if (result == null)
                    result = caseNullLiteralExp_1(nullLiteralExp);
                if (result == null)
                    result = caseOCLExpression(nullLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(nullLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(nullLiteralExp);
                if (result == null)
                    result = caseTypedElement(nullLiteralExp);
                if (result == null)
                    result = caseVisitable(nullLiteralExp);
                if (result == null)
                    result = caseASTNode(nullLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.NUMERIC_LITERAL_EXP: {
                NumericLiteralExp numericLiteralExp = (NumericLiteralExp) theEObject;
                T result = caseNumericLiteralExp(numericLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp(numericLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp_1(numericLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(numericLiteralExp);
                if (result == null)
                    result = caseLiteralExp(numericLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(numericLiteralExp);
                if (result == null)
                    result = caseOCLExpression(numericLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(numericLiteralExp);
                if (result == null)
                    result = caseTypedElement(numericLiteralExp);
                if (result == null)
                    result = caseVisitable(numericLiteralExp);
                if (result == null)
                    result = caseASTNode(numericLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.OCL_EXPRESSION: {
                OCLExpression oclExpression = (OCLExpression) theEObject;
                T result = caseOCLExpression(oclExpression);
                if (result == null)
                    result = caseOCLExpression_1(oclExpression);
                if (result == null)
                    result = caseTypedElement(oclExpression);
                if (result == null)
                    result = caseVisitable(oclExpression);
                if (result == null)
                    result = caseASTNode(oclExpression);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.OPERATION_CALL_EXP: {
                OperationCallExp operationCallExp = (OperationCallExp) theEObject;
                T result = caseOperationCallExp(operationCallExp);
                if (result == null)
                    result = caseFeatureCallExp(operationCallExp);
                if (result == null)
                    result = caseOperationCallExp_1(operationCallExp);
                if (result == null)
                    result = caseCallExp(operationCallExp);
                if (result == null)
                    result = caseFeatureCallExp_1(operationCallExp);
                if (result == null)
                    result = caseOCLExpression(operationCallExp);
                if (result == null)
                    result = caseCallExp_1(operationCallExp);
                if (result == null)
                    result = caseOCLExpression_1(operationCallExp);
                if (result == null)
                    result = caseCallingASTNode(operationCallExp);
                if (result == null)
                    result = caseTypedElement(operationCallExp);
                if (result == null)
                    result = caseVisitable(operationCallExp);
                if (result == null)
                    result = caseASTNode(operationCallExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.PRIMITIVE_LITERAL_EXP: {
                PrimitiveLiteralExp primitiveLiteralExp = (PrimitiveLiteralExp) theEObject;
                T result = casePrimitiveLiteralExp(primitiveLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(primitiveLiteralExp);
                if (result == null)
                    result = caseLiteralExp(primitiveLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(primitiveLiteralExp);
                if (result == null)
                    result = caseOCLExpression(primitiveLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(primitiveLiteralExp);
                if (result == null)
                    result = caseTypedElement(primitiveLiteralExp);
                if (result == null)
                    result = caseVisitable(primitiveLiteralExp);
                if (result == null)
                    result = caseASTNode(primitiveLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.PROPERTY_CALL_EXP: {
                PropertyCallExp propertyCallExp = (PropertyCallExp) theEObject;
                T result = casePropertyCallExp(propertyCallExp);
                if (result == null)
                    result = caseNavigationCallExp(propertyCallExp);
                if (result == null)
                    result = casePropertyCallExp_1(propertyCallExp);
                if (result == null)
                    result = caseFeatureCallExp(propertyCallExp);
                if (result == null)
                    result = caseNavigationCallExp_1(propertyCallExp);
                if (result == null)
                    result = caseCallExp(propertyCallExp);
                if (result == null)
                    result = caseFeatureCallExp_1(propertyCallExp);
                if (result == null)
                    result = caseOCLExpression(propertyCallExp);
                if (result == null)
                    result = caseCallExp_1(propertyCallExp);
                if (result == null)
                    result = caseOCLExpression_1(propertyCallExp);
                if (result == null)
                    result = caseCallingASTNode(propertyCallExp);
                if (result == null)
                    result = caseTypedElement(propertyCallExp);
                if (result == null)
                    result = caseVisitable(propertyCallExp);
                if (result == null)
                    result = caseASTNode(propertyCallExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.REAL_LITERAL_EXP: {
                RealLiteralExp realLiteralExp = (RealLiteralExp) theEObject;
                T result = caseRealLiteralExp(realLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp(realLiteralExp);
                if (result == null)
                    result = caseRealLiteralExp_1(realLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp(realLiteralExp);
                if (result == null)
                    result = caseNumericLiteralExp_1(realLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(realLiteralExp);
                if (result == null)
                    result = caseLiteralExp(realLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(realLiteralExp);
                if (result == null)
                    result = caseOCLExpression(realLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(realLiteralExp);
                if (result == null)
                    result = caseTypedElement(realLiteralExp);
                if (result == null)
                    result = caseVisitable(realLiteralExp);
                if (result == null)
                    result = caseASTNode(realLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.STATE_EXP: {
                StateExp stateExp = (StateExp) theEObject;
                T result = caseStateExp(stateExp);
                if (result == null)
                    result = caseOCLExpression(stateExp);
                if (result == null)
                    result = caseStateExp_1(stateExp);
                if (result == null)
                    result = caseOCLExpression_1(stateExp);
                if (result == null)
                    result = caseTypedElement(stateExp);
                if (result == null)
                    result = caseVisitable(stateExp);
                if (result == null)
                    result = caseASTNode(stateExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.STRING_LITERAL_EXP: {
                StringLiteralExp stringLiteralExp = (StringLiteralExp) theEObject;
                T result = caseStringLiteralExp(stringLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp(stringLiteralExp);
                if (result == null)
                    result = caseStringLiteralExp_1(stringLiteralExp);
                if (result == null)
                    result = casePrimitiveLiteralExp_1(stringLiteralExp);
                if (result == null)
                    result = caseLiteralExp(stringLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(stringLiteralExp);
                if (result == null)
                    result = caseOCLExpression(stringLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(stringLiteralExp);
                if (result == null)
                    result = caseTypedElement(stringLiteralExp);
                if (result == null)
                    result = caseVisitable(stringLiteralExp);
                if (result == null)
                    result = caseASTNode(stringLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.TUPLE_LITERAL_EXP: {
                TupleLiteralExp tupleLiteralExp = (TupleLiteralExp) theEObject;
                T result = caseTupleLiteralExp(tupleLiteralExp);
                if (result == null)
                    result = caseLiteralExp(tupleLiteralExp);
                if (result == null)
                    result = caseTupleLiteralExp_1(tupleLiteralExp);
                if (result == null)
                    result = caseOCLExpression(tupleLiteralExp);
                if (result == null)
                    result = caseLiteralExp_1(tupleLiteralExp);
                if (result == null)
                    result = caseOCLExpression_1(tupleLiteralExp);
                if (result == null)
                    result = caseTypedElement(tupleLiteralExp);
                if (result == null)
                    result = caseVisitable(tupleLiteralExp);
                if (result == null)
                    result = caseASTNode(tupleLiteralExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.TUPLE_LITERAL_PART: {
                TupleLiteralPart tupleLiteralPart = (TupleLiteralPart) theEObject;
                T result = caseTupleLiteralPart(tupleLiteralPart);
                if (result == null)
                    result = caseTupleLiteralPart_1(tupleLiteralPart);
                if (result == null)
                    result = caseTypedElement(tupleLiteralPart);
                if (result == null)
                    result = caseVisitable(tupleLiteralPart);
                if (result == null)
                    result = caseTypedASTNode(tupleLiteralPart);
                if (result == null)
                    result = caseASTNode(tupleLiteralPart);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.TYPE_EXP: {
                TypeExp typeExp = (TypeExp) theEObject;
                T result = caseTypeExp(typeExp);
                if (result == null)
                    result = caseOCLExpression(typeExp);
                if (result == null)
                    result = caseTypeExp_1(typeExp);
                if (result == null)
                    result = caseOCLExpression_1(typeExp);
                if (result == null)
                    result = caseTypedElement(typeExp);
                if (result == null)
                    result = caseVisitable(typeExp);
                if (result == null)
                    result = caseASTNode(typeExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.UNSPECIFIED_VALUE_EXP: {
                UnspecifiedValueExp unspecifiedValueExp = (UnspecifiedValueExp) theEObject;
                T result = caseUnspecifiedValueExp(unspecifiedValueExp);
                if (result == null)
                    result = caseOCLExpression(unspecifiedValueExp);
                if (result == null)
                    result = caseUnspecifiedValueExp_1(unspecifiedValueExp);
                if (result == null)
                    result = caseOCLExpression_1(unspecifiedValueExp);
                if (result == null)
                    result = caseTypedASTNode(unspecifiedValueExp);
                if (result == null)
                    result = caseTypedElement(unspecifiedValueExp);
                if (result == null)
                    result = caseVisitable(unspecifiedValueExp);
                if (result == null)
                    result = caseASTNode(unspecifiedValueExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.VARIABLE: {
                Variable variable = (Variable) theEObject;
                T result = caseVariable(variable);
                if (result == null)
                    result = caseVariable_1(variable);
                if (result == null)
                    result = caseTypedElement(variable);
                if (result == null)
                    result = caseVisitable(variable);
                if (result == null)
                    result = caseTypedASTNode(variable);
                if (result == null)
                    result = caseASTNode(variable);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.VARIABLE_EXP: {
                VariableExp variableExp = (VariableExp) theEObject;
                T result = caseVariableExp(variableExp);
                if (result == null)
                    result = caseOCLExpression(variableExp);
                if (result == null)
                    result = caseVariableExp_1(variableExp);
                if (result == null)
                    result = caseOCLExpression_1(variableExp);
                if (result == null)
                    result = caseTypedElement(variableExp);
                if (result == null)
                    result = caseVisitable(variableExp);
                if (result == null)
                    result = caseASTNode(variableExp);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            case OcldiagramsPackage.BUSINESS_TYPE: {
                BusinessType businessType = (BusinessType) theEObject;
                T result = caseBusinessType(businessType);
                if (result == null)
                    result = caseDiagrams(businessType);
                if (result == null)
                    result = defaultCase(theEObject);
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAnyType(AnyType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBagType(BagType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionType(CollectionType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElementType(ElementType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInvalidType(InvalidType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessageType(MessageType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOrderedSetType(OrderedSetType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveType(PrimitiveType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSequenceType(SequenceType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSetType(SetType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTupleType(TupleType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeType(TypeType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVoidType(VoidType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call Operation Action</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Operation Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallOperationAction(CallOperationAction object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConstraint(Constraint object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Send Signal Action</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Send Signal Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSendSignalAction(SendSignalAction object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExpressionInOCL(ExpressionInOCL object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Association Call Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssociationCallExp(AssociationCallExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBooleanLiteralExp(BooleanLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallExp(CallExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionItem(CollectionItem object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionLiteralExp(CollectionLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionLiteralPart(CollectionLiteralPart object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionRange(CollectionRange object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnumLiteralExp(EnumLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFeatureCallExp(FeatureCallExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIfExp(IfExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntegerLiteralExp(IntegerLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInvalidLiteralExp(InvalidLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIterateExp(IterateExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIteratorExp(IteratorExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLetExp(LetExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLiteralExp(LiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoopExp(LoopExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessageExp(MessageExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNavigationCallExp(NavigationCallExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNullLiteralExp(NullLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNumericLiteralExp(NumericLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOCLExpression(OCLExpression object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationCallExp(OperationCallExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveLiteralExp(PrimitiveLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePropertyCallExp(PropertyCallExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRealLiteralExp(RealLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>State Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>State Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStateExp(StateExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringLiteralExp(StringLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTupleLiteralExp(TupleLiteralExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTupleLiteralPart(TupleLiteralPart object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeExp(TypeExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnspecifiedValueExp(UnspecifiedValueExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariable(Variable object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariableExp(VariableExp object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Business Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBusinessType(BusinessType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Diagrams</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Diagrams</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDiagrams(Diagrams object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Predefined Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T casePredefinedType(PredefinedType<O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T caseAnyType_1(org.eclipse.ocl.types.AnyType<O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEModelElement(EModelElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>ENamed Element</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseENamedElement(ENamedElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EClassifier</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EClassifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEClassifier(EClassifier object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseASTNode(ASTNode object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Typed AST Node</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypedASTNode(TypedASTNode object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseCollectionType_1(org.eclipse.ocl.types.CollectionType<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseBagType_1(org.eclipse.ocl.types.BagType<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElementType_1(org.eclipse.ocl.types.ElementType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T caseInvalidType_1(org.eclipse.ocl.types.InvalidType<O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EClass</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EClass</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEClass(EClass object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O, P> T caseMessageType_1(org.eclipse.ocl.types.MessageType<C, O, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseOrderedSetType_1(org.eclipse.ocl.types.OrderedSetType<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EData Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EData Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEDataType(EDataType object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T casePrimitiveType_1(org.eclipse.ocl.types.PrimitiveType<O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseSequenceType_1(org.eclipse.ocl.types.SequenceType<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseSetType_1(org.eclipse.ocl.types.SetType<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O, P> T caseTupleType_1(org.eclipse.ocl.types.TupleType<O, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseTypeType_1(org.eclipse.ocl.types.TypeType<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T caseVoidType_1(org.eclipse.ocl.types.VoidType<O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVisitable(Visitable object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseExpressionInOCL_1(org.eclipse.ocl.utilities.ExpressionInOCL<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseTypedElement(TypedElement<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseOCLExpression_1(org.eclipse.ocl.expressions.OCLExpression<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Calling AST Node</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallingASTNode(CallingASTNode object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseCallExp_1(org.eclipse.ocl.expressions.CallExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseFeatureCallExp_1(org.eclipse.ocl.expressions.FeatureCallExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, P> T caseNavigationCallExp_1(org.eclipse.ocl.expressions.NavigationCallExp<C, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association Class Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, P> T caseAssociationClassCallExp(AssociationClassCallExp<C, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseLiteralExp_1(org.eclipse.ocl.expressions.LiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T casePrimitiveLiteralExp_1(org.eclipse.ocl.expressions.PrimitiveLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseBooleanLiteralExp_1(org.eclipse.ocl.expressions.BooleanLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseCollectionLiteralPart_1(org.eclipse.ocl.expressions.CollectionLiteralPart<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Item</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseCollectionItem_1(org.eclipse.ocl.expressions.CollectionItem<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseCollectionLiteralExp_1(org.eclipse.ocl.expressions.CollectionLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Collection Range</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Range</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseCollectionRange_1(org.eclipse.ocl.expressions.CollectionRange<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, EL> T caseEnumLiteralExp_1(org.eclipse.ocl.expressions.EnumLiteralExp<C, EL> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseIfExp_1(org.eclipse.ocl.expressions.IfExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Numeric Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseNumericLiteralExp_1(org.eclipse.ocl.expressions.NumericLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseIntegerLiteralExp_1(org.eclipse.ocl.expressions.IntegerLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseUnlimitedNaturalLiteralExp_1(org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseInvalidLiteralExp_1(org.eclipse.ocl.expressions.InvalidLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseLoopExp_1(org.eclipse.ocl.expressions.LoopExp<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Iterate Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterate Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseIterateExp_1(org.eclipse.ocl.expressions.IterateExp<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseIteratorExp_1(org.eclipse.ocl.expressions.IteratorExp<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseLetExp_1(org.eclipse.ocl.expressions.LetExp<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, COA, SSA> T caseMessageExp_1(org.eclipse.ocl.expressions.MessageExp<C, COA, SSA> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseNullLiteralExp_1(org.eclipse.ocl.expressions.NullLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseOperationCallExp_1(org.eclipse.ocl.expressions.OperationCallExp<C, O> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, P> T casePropertyCallExp_1(org.eclipse.ocl.expressions.PropertyCallExp<C, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseRealLiteralExp_1(org.eclipse.ocl.expressions.RealLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>State Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>State Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, S> T caseStateExp_1(org.eclipse.ocl.expressions.StateExp<C, S> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseStringLiteralExp_1(org.eclipse.ocl.expressions.StringLiteralExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, P> T caseTupleLiteralExp_1(org.eclipse.ocl.expressions.TupleLiteralExp<C, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, P> T caseTupleLiteralPart_1(org.eclipse.ocl.expressions.TupleLiteralPart<C, P> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseTypeExp_1(org.eclipse.ocl.expressions.TypeExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unspecified Value Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C> T caseUnspecifiedValueExp_1(org.eclipse.ocl.expressions.UnspecifiedValueExp<C> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseVariable_1(org.eclipse.ocl.expressions.Variable<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseVariableExp_1(org.eclipse.ocl.expressions.VariableExp<C, PM> object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
     * anyway. <!-- end-user-doc -->
     * 
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object)
    {
        return null;
    }

} // OcldiagramsSwitch
