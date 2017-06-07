/***********************************************************************************************************************
 * Copyright (c) 2008 Communication and Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Christophe LE CAMUS (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.modeler.ocl.ocldi;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LazyExtentMap;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.PredefinedType;
import org.topcased.modeler.ocl.ocldi.internal.OCLStandardLibraryImpl;
import org.topcased.modeler.ocl.ocldi.internal.UMLReflectionImpl;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of OCL expressions on instances of Ecore models
 * (i.e., on M0 models).
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public class OcldiEvaluationEnvironment extends AbstractEvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> implements EvaluationEnvironment.Enumerations<EEnumLiteral>
{

    /**
     * Initializes me.
     */
    public OcldiEvaluationEnvironment()
    {
        super();
    }

    /**
     * Initializes me with my parent evaluation environment (nesting scope).
     * 
     * @param parent my parent (nesting scope); must not be <code>null</code>
     */
    public OcldiEvaluationEnvironment(EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent)
    {
        super(parent);
    }

    /**
     * TODO : Add and Define here your own method body.
     * 
     * @see org.eclipse.ocl.AbstractEvaluationEnvironment#callOperation(java.lang.Object, int, java.lang.Object,
     *      java.lang.Object[])
     */
    @Override
    public Object callOperation(EOperation operation, int opcode, Object source, Object[] args) throws IllegalArgumentException
    {
        if (operation.getEAnnotation("OcldiEnvironment") != null)
        {
            // For the SAM Environment some additional methods have been defined for the String type
            // Here are listed the implementation of each added method.
            if ("regexMatch".equals(operation.getName()))
            {
                Pattern pattern = Pattern.compile((String) args[0]);
                String sourceArg = new String();
                Matcher matcher = null;
                if (source != null)
                {
                    sourceArg = (String) source;
                }
                matcher = pattern.matcher(sourceArg);

                return matcher.matches() ? matcher.group() : null;
            }
            else if ("trim".equals(operation.getName()))
            {
                return ((String) source).trim();
            }
            else if ("charAt".equals(operation.getName()))
            {
                return String.valueOf((((String) source).charAt(((Integer) args[0]).intValue())));
            }
            else if ("startsWith".equals(operation.getName()))
            {
                return ((String) source).startsWith((((String) args[0])));
            }
            else if ("endsWith".equals(operation.getName()))
            {
                return ((String) source).endsWith((((String) args[0])));
            }
        }
        return coerceValue(operation, super.callOperation(operation, opcode, source, args), true);
    }

    // implements the inherited specification
    @Override
    protected Method getJavaMethodFor(EOperation operation, Object receiver)
    {
        Method result = null;

        // in the case of infix operators, we need to replace the name with
        // a valid Java name. We will choose the legacy OCL parser names
        // which some clients already depend on
        String operName = operation.getName();
        int opcode = OCLStandardLibraryUtil.getOperationCode(operName);
        switch (opcode)
        {
            case PredefinedType.PLUS:
                operName = "plus"; //$NON-NLS-1$
                break;
            case PredefinedType.MINUS:
                operName = "minus"; //$NON-NLS-1$
                break;
            case PredefinedType.TIMES:
                operName = "times"; //$NON-NLS-1$
                break;
            case PredefinedType.DIVIDE:
                operName = "divide"; //$NON-NLS-1$
                break;
            case PredefinedType.LESS_THAN:
                operName = "lessThan"; //$NON-NLS-1$
                break;
            case PredefinedType.LESS_THAN_EQUAL:
                operName = "lessThanEqual"; //$NON-NLS-1$
                break;
            case PredefinedType.GREATER_THAN:
                operName = "greaterThan"; //$NON-NLS-1$
                break;
            case PredefinedType.GREATER_THAN_EQUAL:
                operName = "greaterThanEqual"; //$NON-NLS-1$
                break;
        }

        // get containing class for the operation
        EClass container = operation.getEContainingClass();

        // get the corresponding java instance class
        Class< ? > containerClass = container.getInstanceClass();

        // get the parameter types as java classes
        EList<EParameter> parms = operation.getEParameters();
        Class< ? >[] javaParms = new Class[parms.size()];
        for (int i = 0, n = parms.size(); i < n; i++)
        {
            EParameter parm = parms.get(i);

            if (parm.isMany())
            {
                javaParms[i] = EList.class; // TODO: EList could be suppressed
            }
            else
            {
                javaParms[i] = parm.getEType().getInstanceClass();
            }
        }

        // lookup the method on the java class
        try
        {
            result = containerClass.getMethod(operName, javaParms);
        }
        catch (NoSuchMethodException e)
        {
            // do nothing
        }

        return result;
    }

    // implements the inherited specification
    @Override
    protected Object getInvalidResult()
    {
        return OCLStandardLibraryImpl.OCL_INVALID;
    }

    // implements the inherited specification
    public Object navigateProperty(EStructuralFeature property, List< ? > qualifiers, Object target) throws IllegalArgumentException
    {

        if (target instanceof EObject)
        {
            EObject etarget = (EObject) target;

            if (etarget.eClass().getEAllStructuralFeatures().contains(property))
            {
                return coerceValue(property, etarget.eGet(property), true);
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Obtains the collection kind appropriate for representing the values of the specified typed element.
     * 
     * @param element a typed element (property, operation, etc.)
     * 
     * @return the collection kind appropriate to the multiplicity, orderedness, and uniqueness of the element, or
     *         <code>null</code> if it is not many
     */
    private static CollectionKind getCollectionKind(ETypedElement element)
    {
        EClassifier oclType = UMLReflectionImpl.INSTANCE.getOCLType(element);

        CollectionKind result = null;

        if (oclType instanceof CollectionType)
        {
            result = ((CollectionType< ? , ? >) oclType).getKind();
            ObjectUtil.dispose(oclType); // we created this object
        }

        return result;
    }

    /**
     * Coerces the value of the specified typed element into the appropriate representation, derived from the supplied
     * <code>value</code> template. The <code>value</code> is coerced to the appropriate collection kind for this
     * element (or scalar if not multi-valued). The original value may either be used as is where possible or,
     * optionally, copied into the new collection (if multi-valued).
     * 
     * @param element a typed element (property, operation, etc.)
     * @param value the computed value of the element
     * @param copy whether to copy the specified value into the resulting collection/scalar value
     * 
     * @return the value, in the appropriate OCL collection type or scalar form as required
     * 
     * @see #getCollectionKind(ETypedElement)
     */
    private Object coerceValue(ETypedElement element, Object value, boolean copy)
    {
        CollectionKind kind = getCollectionKind(element);

        if (kind != null)
        {
            if (value instanceof Collection)
            {
                return copy ? CollectionUtil.createNewCollection(kind, (Collection< ? >) value) : value;
            }
            else
            {
                Collection<Object> result = CollectionUtil.createNewCollection(kind);
                result.add(value);
                return result;
            }
        }
        else
        {
            if (value instanceof Collection)
            {
                Collection< ? > collection = (Collection< ? >) value;
                return collection.isEmpty() ? null : collection.iterator().next();
            }
            else
            {
                return value;
            }
        }
    }

    // implements the inherited specification
    public Object navigateAssociationClass(EClassifier associationClass, EStructuralFeature navigationSource, Object target) throws IllegalArgumentException
    {

        if (target instanceof EObject)
        {
            EObject etarget = (EObject) target;

            EReference ref = getAssociationClassReference(etarget, (EClass) associationClass);

            if (etarget.eClass().getEAllStructuralFeatures().contains(ref))
            {
                return etarget.eGet(ref);
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Retrieves the reference feature in the specified context object that references the specified association class.
     * 
     * @param context the context object
     * @param associationClass the association class that it references
     * @return the reference in question
     */
    private EReference getAssociationClassReference(EObject context, EClass associationClass)
    {
        EReference result = null;

        StringBuffer nameBuf = new StringBuffer(associationClass.getName());
        UnicodeSupport.setCodePointAt(nameBuf, 0, UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(nameBuf, 0)));
        String name = nameBuf.toString();

        for (EReference next : context.eClass().getEAllReferences())
        {
            if (name.equals(next.getName()) && (associationClass == next.getEReferenceType()))
            {
                result = next;
                break;
            }
        }

        return result;
    }

    // implements the inherited specification
    public Tuple<EOperation, EStructuralFeature> createTuple(EClassifier type, Map<EStructuralFeature, Object> values)
    {

        EClass tupleType = (EClass) type;

        EObject tuple = tupleType.getEPackage().getEFactoryInstance().create(tupleType);

        for (Map.Entry<EStructuralFeature, Object> entry : values.entrySet())
        {
            EStructuralFeature property = entry.getKey();
            Object value = entry.getValue();

            if (property.isMany() && (value instanceof Collection))
            {
                @SuppressWarnings("unchecked")
                Collection<Object> coll = (Collection<Object>) tuple.eGet(property);
                coll.addAll((Collection< ? >) value);
            }
            else if ((property.getEType() instanceof CollectionType) && (value instanceof Collection))
            {
                // always copy the collection to the correct type
                @SuppressWarnings("unchecked")
                CollectionType<EClassifier, EOperation> collType = (CollectionType<EClassifier, EOperation>) property.getEType();
                tuple.eSet(property, CollectionUtil.createNewCollection(collType.getKind(), (Collection< ? >) value));
            }
            else
            {
                tuple.eSet(property, value);
            }
        }

        @SuppressWarnings("unchecked")
        Tuple<EOperation, EStructuralFeature> result = (Tuple<EOperation, EStructuralFeature>) tuple;

        return result;
    }

    // implements the inherited specification
    public Map<EClass, Set<EObject>> createExtentMap(Object object)
    {
        if (object instanceof EObject)
        {
            return new LazyExtentMap<EClass, EObject>((EObject) object)
            {

                // implements the inherited specification
                @Override
                protected boolean isInstance(EClass cls, EObject element)
                {
                    return cls.isInstance(element);
                }
            };
        }

        return Collections.emptyMap();
    }

    // implements the inherited specification
    public boolean isKindOf(Object object, EClassifier classifier)
    {
        // special case for Integer/UnlimitedNatural and Real which
        // are not related types in java but are in OCL
        if ((object.getClass() == Integer.class) && (classifier.getInstanceClass() == Double.class))
        {
            return Boolean.TRUE;
        }

        return classifier.isInstance(object);
    }

    // implements the inherited specification
    public boolean isTypeOf(Object object, EClassifier classifier)
    {
        if (classifier instanceof EClass && object instanceof EObject)
        {
            return ((EObject) object).eClass() == classifier;
        }
        else if (!(object instanceof EObject) && !(classifier instanceof EClass))
        {
            return object.getClass() == classifier.getInstanceClass();
        }

        return false;
    }

    // implements the inherited specification
    public EClassifier getType(Object object)
    {
        return OcldiEnvironmentFactory.oclType(object);
    }

    /**
     * Ecore implementation of the enumeration literal value.
     * 
     * @since 1.2
     */
    public Enumerator getValue(EEnumLiteral enumerationLiteral)
    {
        return enumerationLiteral.getInstance();
    }
}