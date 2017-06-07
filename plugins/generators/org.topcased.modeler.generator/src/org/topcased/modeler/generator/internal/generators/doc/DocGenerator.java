/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.generator.internal.generators.doc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.topcased.modeler.generator.internal.GeneratorPlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <br>
 * creation : 20 avril 2005
 * 
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu GARCIA</a>
 */
public abstract class DocGenerator
{

    /** String representation of root tag */
    public static final String ROOT_TAG = "documentation";

    /** String representation of epackage tag */
    public static final String EPACKAGE_TAG = "epackage";

    /** String representation of edatatypes tag */
    public static final String EDATATYPES_TAG = "edatatypes";

    /** String representation of edatatype tag */
    public static final String EDATATYPE_TAG = "edatatype";

    /** String representation of etype tag */
    public static final String ETYPE_TAG = "etype";

    /** String representation of instance class name tag */
    public static final String INSTANCE_CLASS_NAME_TAG = "instance-class-name";

    /** String representation of eenumdatatype tag */
    public static final String EENUMDATATYPES_TAG = "eenums";

    /** String representation of eenumdatatype tag */
    public static final String EENUMDATATYPE_TAG = "eenum";

    /** String representation of eannotations tag */
    public static final String EANNOTATIONS_TAG = "eannotations";

    /** String representation of eannotation tag */
    public static final String EANNOTATION_TAG = "eannotation";

    /** String representation of eclasses tag */
    public static final String ECLASSES_TAG = "eclasses";

    /** String representation of eclass tag */
    public static final String ECLASS_TAG = "eclass";

    public static final String EREFERENCE_TAG = "ereference";
    
    public static final String EREFERENCES_TAG = "ereferences";    
    
    /** String representation of eoperations tag */
    public static final String EOPERATIONS_TAG = "eoperations";

    /** String representation of eoperation tag */
    public static final String EOPERATION_TAG = "eoperation";

    /** String representation of eattributes tag */
    public static final String EATTRIBUTES_TAG = "eattributes";

    /** String representation of eattribute tag */
    public static final String EATTRIBUTE_TAG = "eattribute";

    /** String representation of eparameters tag */
    public static final String EPARAMETERS_TAG = "eparameters";

    /** String representation of eparameter tag */
    public static final String EPARAMETER_TAG = "eparameter";

    /** String representation of lower bound tag */
    public static final String LOWER_BOUND_TAG = "lower-bound";

    /** String representation of upper bound tag */
    public static final String UPPER_BOUND_TAG = "upper-bound";

    /** String representation of name attribute */
    public static final String NAME_ATTRIBUTE = "name";

    /** String representation of isOrdered attribute */
    public static final String ISORDERED_ATTRIBUTE = "isOrdered";

    /** String representation of isUnique attribute */
    public static final String ISUNIQUE_ATTRIBUTE = "isUnique";

    /** String representation of isChangeable attribute */
    public static final String ISCHANGEABLE_ATTRIBUTE = "isChangeable";

    /** String representation of isVolatile attribute */
    public static final String ISVOLATILE_ATTRIBUTE = "isVolatile";

    /** String representation of isTransient attribute */
    public static final String ISTRANSIENT_ATTRIBUTE = "isTransient";

    /** String representation of isUnsettable attribute */
    public static final String ISUNSETTABLE_ATTRIBUTE = "isUnsettable";

    /** String representation of isDerived attribute */
    public static final String ISDERIVED_ATTRIBUTE = "isDerived";

    /** String representation of isAbstract attribute */
    public static final String ISABSTRACT_ATTRIBUTE = "isAbstract";

    /** String representation of isInterface attribute */
    public static final String ISINTERFACE_ATTRIBUTE = "isInterface";

    /** Model root element */
    private EPackage ePackage;

    /** XML Document */
    private Document document;

    /**
     * The Constructor
     * 
     * @param epackage emf model root
     */
    public DocGenerator(EPackage epackage)
    {
        ePackage = epackage;
    }

    /**
     * Get classifiers that match a given class type
     * 
     * @param epackage root element
     * @param clazz class to match
     * @return Collection of Classifiers
     */
    private Collection getClassifiers(EPackage epackage, Class clazz)
    {
        ArrayList result = new ArrayList();
        for (Iterator it = epackage.getEClassifiers().iterator(); it.hasNext();)
        {
            Object current = it.next();
            if (clazz.isInstance(current))
            {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Create text nodes on a given element. Node names are keys of the map, texts are values of the map
     * 
     * @param children
     * @param parent
     */
    private void addChildren(Map children, Element parent)
    {
        for (Iterator itKey = children.keySet().iterator(); itKey.hasNext();)
        {
            String key = (String) itKey.next();
            String value = (String) children.get(key);
            if (value == null)
            {
                value = "";
            }
            Element element = createElement(key, parent);
            element.appendChild(document.createTextNode(value));
        }
    }

    /**
     * Create attributes on a given element. Attribute names are keys of the map, texts are values of the map
     * 
     * @param attributes
     * @param parent
     */
    private void addAttributes(Map attributes, Element parent)
    {
        for (Iterator itKey = attributes.keySet().iterator(); itKey.hasNext();)
        {
            String key = (String) itKey.next();
            String value = (String) attributes.get(key);
            if (value == null)
            {
                value = "";
            }
            parent.setAttribute(key, value);
        }
    }

    /**
     * Create an XML tag with a name attribute and add it on a given parent element
     * 
     * @param tag name of the tag
     * @param name value of the name attribute
     * @param parent parent element
     * @return the element that has been created
     */
    private Element createNamedElement(String tag, String name, Element parent)
    {
        Element element = document.createElement(tag);
        element.setAttribute(NAME_ATTRIBUTE, name);
        parent.appendChild(element);
        return element;
    }

    /**
     * Create an XML tag and add it on a given parent element
     * 
     * @param tag name of the tag
     * @param parent parent element
     * @return the element that has been created
     */
    private Element createElement(String tag, Element parent)
    {
        Element element = document.createElement(tag);
        parent.appendChild(element);
        return element;
    }

    /**
     * Create annotations node
     * 
     * @param annotations collection of annotations
     * @param parent xml element where annotations have to be added
     */
    private void addAnnotations(EList annotations, Element parent)
    {
        if (!annotations.isEmpty())
        {
            Element annotationsElement = createElement(EANNOTATIONS_TAG, parent);
            for (Iterator itAnnot = annotations.iterator(); itAnnot.hasNext();)
            {
                EMap details = ((EAnnotation) itAnnot.next()).getDetails();
                for (Iterator itKey = details.keySet().iterator(); itKey.hasNext();)
                {
                    String key = (String) itKey.next();
                    String value = (String) details.get(key);
                    Element annotationElement = createNamedElement(EANNOTATION_TAG, key, annotationsElement);
                    annotationElement.appendChild(document.createTextNode(value));
                }
            }
        }
    }

    /**
     * Generate documentation about EDataTypes for a given epackage. XML tree is update from the given parent element
     * 
     * @param epackage
     * @param parent
     */
    private void generateEDataTypes(EPackage epackage, Element parent)
    {
        Collection types = getClassifiers(epackage, EDataType.class);
        if (!types.isEmpty())
        {
            Element typesElement = createElement(EDATATYPES_TAG, parent);
            Iterator it = types.iterator();
            while (it.hasNext())
            {
                EDataType etype = (EDataType) it.next();
                Element typeElement = createNamedElement(EDATATYPE_TAG, etype.getName(), typesElement);

                HashMap children = new HashMap();
                children.put(INSTANCE_CLASS_NAME_TAG, etype.getInstanceClassName());
                addChildren(children, typeElement);

                if (etype instanceof EEnum)
                {
                    Element enumsElement = createElement(EENUMDATATYPES_TAG, typeElement);
                    for (Iterator itLit = ((EEnum) etype).getELiterals().iterator(); itLit.hasNext();)
                    {
                        createNamedElement(EENUMDATATYPE_TAG, ((EEnumLiteral) itLit.next()).getName(), enumsElement);
                    }
                }
                addAnnotations(etype.getEAnnotations(), typeElement);
            }
        }
    }

    /**
     * Generate documentation about EClasses for a given epackage. XML tree is update from the given parent element
     * 
     * @param epackage
     * @param parent
     */
    private void generateEClasses(EPackage epackage, Element parent)
    {
        Collection classes = getClassifiers(epackage, EClass.class);
        HashMap details = null;
        if (!classes.isEmpty())
        {
            Element classesElement = createElement(ECLASSES_TAG, parent);
            Iterator it = classes.iterator();
            while (it.hasNext())
            {
                EClass eclass = (EClass) it.next();
                Element classElement = createNamedElement(ECLASS_TAG, eclass.getName(), classesElement);

                details = new HashMap();
                details.put("isAbstract", String.valueOf(eclass.isAbstract()));
                details.put("isInterface", String.valueOf(eclass.isInterface()));
                addAttributes(details, classElement);

                details = new HashMap();
                details.put(INSTANCE_CLASS_NAME_TAG, eclass.getInstanceClassName());
                addChildren(details, classElement);

                Element attributesElement = createElement(EATTRIBUTES_TAG, classElement);
                for (Iterator itAtt = eclass.getEAttributes().iterator(); itAtt.hasNext();)
                {
                    EAttribute eattribute = (EAttribute) itAtt.next();
                    Element attributeElement = createNamedElement(EATTRIBUTE_TAG, eattribute.getName(), attributesElement);

                    details = new HashMap();
                    details.put(ISORDERED_ATTRIBUTE, String.valueOf(eattribute.isOrdered()));
                    details.put(ISUNIQUE_ATTRIBUTE, String.valueOf(eattribute.isUnique()));
                    details.put(ISCHANGEABLE_ATTRIBUTE, String.valueOf(eattribute.isChangeable()));
                    details.put(ISVOLATILE_ATTRIBUTE, String.valueOf(eattribute.isVolatile()));
                    details.put(ISTRANSIENT_ATTRIBUTE, String.valueOf(eattribute.isTransient()));
                    details.put(ISUNSETTABLE_ATTRIBUTE, String.valueOf(eattribute.isUnsettable()));
                    details.put(ISDERIVED_ATTRIBUTE, String.valueOf(eattribute.isDerived()));
                    addAttributes(details, attributeElement);

                    details = new HashMap();
                    details.put(LOWER_BOUND_TAG, String.valueOf(eattribute.getLowerBound()));
                    details.put(UPPER_BOUND_TAG, String.valueOf(eattribute.getUpperBound()));
                    String typeName = "";
                    if (eattribute.getEType() != null)
                    {
                        typeName = eattribute.getEType().getName();
                    }
                    details.put(ETYPE_TAG, typeName);
                    addChildren(details, attributeElement);

                    addAnnotations(eattribute.getEAnnotations(), attributeElement);
                }
                
                Element referencesElement = createElement(EREFERENCES_TAG, classElement);
                for (Iterator itRef = eclass.getEReferences().iterator(); itRef.hasNext();)
                {
                	EReference eref = (EReference) itRef.next();
                    Element referenceElement = createNamedElement(EREFERENCE_TAG, eref.getName(), referencesElement);
                    details = new HashMap();
                    details.put(LOWER_BOUND_TAG, String.valueOf(eref.getLowerBound()));
                    details.put(UPPER_BOUND_TAG, String.valueOf(eref.getUpperBound()));
                    String typeName = "";
                    if (eref.getEType() != null)
                    {
                        typeName = eref.getEType().getName();
                    }
                    details.put(ETYPE_TAG, typeName);
                    addChildren(details, referenceElement);
                    addAnnotations(eref.getEAnnotations(), referenceElement);
                }

                Element operationsElement = createElement(EOPERATIONS_TAG, classElement);
                for (Iterator itOp = eclass.getEOperations().iterator(); itOp.hasNext();)
                {
                    EOperation eoperation = (EOperation) itOp.next();
                    Element operationElement = createNamedElement(EOPERATION_TAG, eoperation.getName(), operationsElement);

                    Element parametersElement = createElement(EPARAMETERS_TAG, operationElement);
                    for (Iterator itParam = eoperation.getEParameters().iterator(); itParam.hasNext();)
                    {
                        EParameter eparameter = (EParameter) itParam.next();
                        Element parameterElement = createNamedElement(EPARAMETER_TAG, eparameter.getName(), parametersElement);
                        String typeName = "";
                        if (eparameter.getEType() != null)
                        {
                            typeName = eparameter.getEType().getName();
                        }
                        details = new HashMap();
                        details.put(ETYPE_TAG, typeName);
                        addChildren(details, parameterElement);
                    }
                    String typeName = "";
                    if (eoperation.getEType() != null)
                    {
                        typeName = eoperation.getEType().getName();
                    }
                    details = new HashMap();
                    details.put(ETYPE_TAG, typeName);
                    addChildren(details, operationElement);

                    addAnnotations(eoperation.getEAnnotations(), operationElement);
                }

                addAnnotations(eclass.getEAnnotations(), classElement);
            }
        }
    }

    /**
     * Generation documentation for a given epackage. XML tree is updated from the given parent element
     * 
     * @param epackage
     * @param parent
     */
    private void generatePackage(EPackage epackage, Element parent)
    {

        Element epackageElement = createNamedElement(EPACKAGE_TAG, epackage.getName(), parent);
        addAnnotations(epackage.getEAnnotations(), epackageElement);
        generateEDataTypes(epackage, epackageElement);
        generateEClasses(epackage, epackageElement);
        for (Iterator it = epackage.getESubpackages().iterator(); it.hasNext();)
        {
            generatePackage((EPackage) it.next(), epackageElement);
        }
    }

    /**
     * Main generate action. Call this method to generate documentation
     * 
     * @param monitor
     * @throws CoreException
     */
    public void generate(IProgressMonitor monitor) throws CoreException
    {
        monitor.subTask("Project creation");
        initializeXMLDocument();
        generatePackage(ePackage, initializeXMLDocument());
        serialize(monitor);
    }

    /**
     * Prepare XML document
     * 
     * @return XML root element
     */
    private Element initializeXMLDocument()
    {
        Element rootElement = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
            rootElement = document.createElement(ROOT_TAG);
            rootElement.setAttribute("metamodel", ePackage.getName());
            document.appendChild(rootElement);
        }
        catch (ParserConfigurationException e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.log("Unable to initialize XML document", IStatus.ERROR);
        }
        return rootElement;
    }

    /**
     * @return Document
     */
    protected Document getDocument()
    {
        return document;
    }

    /**
     * Serialize produced XML document
     * 
     * @param monitor
     * @throws CoreException
     */
    protected abstract void serialize(IProgressMonitor monitor) throws CoreException;

    /**
     * Get the EPackage model object on which the generation has been invoked
     * 
     * @return The root model Object
     */
    protected EPackage getEPackage()
    {
        return ePackage;
    }
}
