/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLFactoryImpl.java,v 1.1 2009/03/19 13:40:49 clecamus Exp $
 */
package org.topcased.modeler.ocl.ocldi.internal;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.topcased.modeler.ocl.ocldi.BagType;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.CollectionType;
import org.topcased.modeler.ocl.ocldi.MessageType;
import org.topcased.modeler.ocl.ocldi.OcldiFactory;
import org.topcased.modeler.ocl.ocldi.OrderedSetType;
import org.topcased.modeler.ocl.ocldi.SequenceType;
import org.topcased.modeler.ocl.ocldi.SetType;
import org.topcased.modeler.ocl.ocldi.TupleType;
import org.topcased.modeler.ocl.ocldi.impl.TypeTypeImpl;

/**
 * Implementation of the {@link OCLFactory} API for the Ecore binding.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("unchecked")
public class OCLFactoryImpl implements OCLFactory
{
    public static OCLFactory INSTANCE = new OCLFactoryImpl();

    private OCLFactoryImpl()
    {
        super();
    }

    public <C, O> org.eclipse.ocl.types.BagType<C, O> createBagType(C elementType)
    {
        BagType result = OcldiFactory.eINSTANCE.createBagType();
        result.setElementType((EClassifier) elementType);

        return (org.eclipse.ocl.types.BagType<C, O>) result;
    }

    public <C, O> org.eclipse.ocl.types.OrderedSetType<C, O> createOrderedSetType(C elementType)
    {
        OrderedSetType result = OcldiFactory.eINSTANCE.createOrderedSetType();
        result.setElementType((EClassifier) elementType);

        return (org.eclipse.ocl.types.OrderedSetType<C, O>) result;
    }

    public <C, O> org.eclipse.ocl.types.SequenceType<C, O> createSequenceType(C elementType)
    {
        SequenceType result = OcldiFactory.eINSTANCE.createSequenceType();
        result.setElementType((EClassifier) elementType);

        return (org.eclipse.ocl.types.SequenceType<C, O>) result;
    }

    public <C, O> org.eclipse.ocl.types.SetType<C, O> createSetType(C elementType)
    {
        SetType result = OcldiFactory.eINSTANCE.createSetType();
        result.setElementType((EClassifier) elementType);

        return (org.eclipse.ocl.types.SetType<C, O>) result;
    }

    public <C, O> org.eclipse.ocl.types.CollectionType<C, O> createCollectionType(C elementType)
    {
        CollectionType result = OcldiFactory.eINSTANCE.createCollectionType();
        result.setElementType((EClassifier) elementType);

        return (org.eclipse.ocl.types.CollectionType<C, O>) result;
    }

    public <C, O> org.eclipse.ocl.types.CollectionType<C, O> createCollectionType(CollectionKind kind, C elementType)
    {
        switch (kind)
        {
            case BAG_LITERAL:
                return createBagType(elementType);
            case SET_LITERAL:
                return createSetType(elementType);
            case SEQUENCE_LITERAL:
                return createSequenceType(elementType);
            case ORDERED_SET_LITERAL:
                return createOrderedSetType(elementType);
            default:
                return createCollectionType(elementType);
        }
    }

    public <C, O, P> org.eclipse.ocl.types.MessageType<C, O, P> createOperationMessageType(O operation)
    {
        MessageType result = OcldiFactory.eINSTANCE.createMessageType();
        result.setReferredOperation((EOperation) operation);
        result.oclProperties(); // ensure that the structural features are created
        return (org.eclipse.ocl.types.MessageType<C, O, P>) result;
    }

    public <C, O, P> org.eclipse.ocl.types.MessageType<C, O, P> createSignalMessageType(C signal)
    {
        MessageType result = OcldiFactory.eINSTANCE.createMessageType();
        result.setReferredSignal((BusinessType) signal);
        result.oclProperties(); // ensure that the structural features are created
        return (org.eclipse.ocl.types.MessageType<C, O, P>) result;
    }

    public <C, O, P> org.eclipse.ocl.types.TupleType<O, P> createTupleType(List< ? extends TypedElement<C>> parts)
    {
        TupleType result = OcldiFactory.eINSTANCE.createTupleType();

        if (!parts.isEmpty())
        {
            Environment< ? , C, O, P, ? , ? , ? , ? , ? , ? , ? , ? > env = Environment.Registry.INSTANCE.getEnvironmentFor(parts.get(0));
            UMLReflection< ? , C, O, P, ? , ? , ? , ? , ? , ? > uml = env.getUMLReflection();

            EList<EStructuralFeature> properties = result.oclProperties();

            for (TypedElement<C> part : parts)
            {
                properties.add((EStructuralFeature) uml.createProperty(part.getName(), part.getType()));
            }
        }

        return (org.eclipse.ocl.types.TupleType<O, P>) result;
    }

    public <C, O> org.eclipse.ocl.types.TypeType<C, O> createTypeType(C type)
    {
        return (org.eclipse.ocl.types.TypeType<C, O>) TypeTypeImpl.createTypeType((EClassifier) type);
    }

    public <C, P> AssociationClassCallExp<C, P> createAssociationClassCallExp()
    {
        // return (AssociationClassCallExp<C, P>)
        // OcldiFactory.eINSTANCE.createAssociationClassCallExp();
        return null;
    }

    public <C> BooleanLiteralExp<C> createBooleanLiteralExp()
    {
        return (BooleanLiteralExp<C>) OcldiFactory.eINSTANCE.createBooleanLiteralExp();
    }

    public <C> CollectionItem<C> createCollectionItem()
    {
        return (CollectionItem<C>) OcldiFactory.eINSTANCE.createCollectionItem();
    }

    public <C> CollectionLiteralExp<C> createCollectionLiteralExp()
    {
        return (CollectionLiteralExp<C>) OcldiFactory.eINSTANCE.createCollectionLiteralExp();
    }

    public <C> CollectionRange<C> createCollectionRange()
    {
        return (CollectionRange<C>) OcldiFactory.eINSTANCE.createCollectionRange();
    }

    public <C, EL> EnumLiteralExp<C, EL> createEnumLiteralExp()
    {
        return (EnumLiteralExp<C, EL>) OcldiFactory.eINSTANCE.createEnumLiteralExp();
    }

    public <C> IfExp<C> createIfExp()
    {
        return (IfExp<C>) OcldiFactory.eINSTANCE.createIfExp();
    }

    public <C> IntegerLiteralExp<C> createIntegerLiteralExp()
    {
        return (IntegerLiteralExp<C>) OcldiFactory.eINSTANCE.createIntegerLiteralExp();
    }

    public <C> InvalidLiteralExp<C> createInvalidLiteralExp()
    {
        return (InvalidLiteralExp<C>) OcldiFactory.eINSTANCE.createInvalidLiteralExp();
    }

    public <C, PM> IterateExp<C, PM> createIterateExp()
    {
        return (IterateExp<C, PM>) OcldiFactory.eINSTANCE.createIterateExp();
    }

    public <C, PM> IteratorExp<C, PM> createIteratorExp()
    {
        return (IteratorExp<C, PM>) OcldiFactory.eINSTANCE.createIteratorExp();
    }

    public <C, PM> LetExp<C, PM> createLetExp()
    {
        return (LetExp<C, PM>) OcldiFactory.eINSTANCE.createLetExp();
    }

    public <C, COA, SSA> MessageExp<C, COA, SSA> createMessageExp()
    {
        return (MessageExp<C, COA, SSA>) OcldiFactory.eINSTANCE.createMessageExp();
    }

    public <C> NullLiteralExp<C> createNullLiteralExp()
    {
        return (NullLiteralExp<C>) OcldiFactory.eINSTANCE.createNullLiteralExp();
    }

    public <C, O> OperationCallExp<C, O> createOperationCallExp()
    {
        return (OperationCallExp<C, O>) OcldiFactory.eINSTANCE.createOperationCallExp();
    }

    public <C, P> PropertyCallExp<C, P> createPropertyCallExp()
    {
        return (PropertyCallExp<C, P>) OcldiFactory.eINSTANCE.createPropertyCallExp();
    }

    public <C> RealLiteralExp<C> createRealLiteralExp()
    {
        return (RealLiteralExp<C>) OcldiFactory.eINSTANCE.createRealLiteralExp();
    }

    public <C, S> StateExp<C, S> createStateExp()
    {
        return (StateExp<C, S>) OcldiFactory.eINSTANCE.createStateExp();
    }

    public <C> StringLiteralExp<C> createStringLiteralExp()
    {
        return (StringLiteralExp<C>) OcldiFactory.eINSTANCE.createStringLiteralExp();
    }

    public <C, P> TupleLiteralExp<C, P> createTupleLiteralExp()
    {
        return (TupleLiteralExp<C, P>) OcldiFactory.eINSTANCE.createTupleLiteralExp();
    }

    public <C, P> TupleLiteralPart<C, P> createTupleLiteralPart()
    {
        return (TupleLiteralPart<C, P>) OcldiFactory.eINSTANCE.createTupleLiteralPart();
    }

    public <C> TypeExp<C> createTypeExp()
    {
        return (TypeExp<C>) OcldiFactory.eINSTANCE.createTypeExp();
    }

    public <C> UnlimitedNaturalLiteralExp<C> createUnlimitedNaturalLiteralExp()
    {
        return (UnlimitedNaturalLiteralExp<C>) OcldiFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
    }

    public <C> UnspecifiedValueExp<C> createUnspecifiedValueExp()
    {
        return (UnspecifiedValueExp<C>) OcldiFactory.eINSTANCE.createUnspecifiedValueExp();
    }

    public <C, PM> Variable<C, PM> createVariable()
    {
        return (Variable<C, PM>) OcldiFactory.eINSTANCE.createVariable();
    }

    public <C, PM> VariableExp<C, PM> createVariableExp()
    {
        return (VariableExp<C, PM>) OcldiFactory.eINSTANCE.createVariableExp();
    }
}
