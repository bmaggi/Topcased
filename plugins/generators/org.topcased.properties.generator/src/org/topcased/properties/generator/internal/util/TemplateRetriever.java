package org.topcased.properties.generator.internal.util;

import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The default implementation of ITemplateRetriever. There is default templates to use and this class returns the string
 * paths for the standard types
 * 
 * @author alfredo
 * 
 */
public class TemplateRetriever implements ITemplateRetriever
{
    /**
     * @see org.topcased.properties.generator.internal.util.ITemplateRetriever#getTemplate(org.eclipse.emf.codegen.ecore.genmodel.GenFeature)
     */
    public String getTemplate(GenFeature genFeature)
    {
        String template = null;
        EStructuralFeature feature = genFeature.getEcoreFeature();
        EClassifier type = feature.getEType();
        if (feature.isMany())
        {
            template = "template/sectionTemplates/TableSectionClass.javajet"; //$NON-NLS-1$
        }
        // Custom management of Color and Font types
        else if ("org.eclipse.swt.graphics.Color".equals(type.getInstanceClassName())) //$NON-NLS-1$
        {
            template = "template/sectionTemplates/ColorSectionClass.javajet"; //$NON-NLS-1$
        }
        else if ("org.eclipse.swt.graphics.Font".equals(type.getInstanceClassName())) //$NON-NLS-1$
        {
            template = "template/sectionTemplates/FontSectionClass.javajet"; //$NON-NLS-1$
        }
        else if (type instanceof EEnum)
        {
            template = "template/sectionTemplates/EnumerationSectionClass.javajet"; //$NON-NLS-1$
        }
        else if (type instanceof EDataType)
        {
            template = generateSection(type);
        }
        else if (type instanceof EClass)
        {
            template = "template/sectionTemplates/ReferenceSectionClass.javajet"; //$NON-NLS-1$
        }

        return template;
    }

    /**
     * Generates a section class using a the right template following the type code
     * 
     * @param eType Type code
     * @return String
     */
    private String generateSection(EClassifier eType)
    {
        Class<?> clazz = eType.getInstanceClass();
        String template = null;
        if (clazz == int.class || clazz == Integer.class)
        {
            template = "template/sectionTemplates/IntegerSectionClass.javajet"; //$NON-NLS-1$
        }
        else if (clazz == double.class || clazz == Double.class)
        {
            template = "template/sectionTemplates/DoubleSectionClass.javajet"; //$NON-NLS-1$
        }
        else if (clazz == boolean.class || clazz == Boolean.class)
        {
            template = "template/sectionTemplates/BooleanSectionClass.javajet"; //$NON-NLS-1$
        }
        else if (clazz == String.class)
        {
            template = "template/sectionTemplates/StringSectionClass.javajet"; //$NON-NLS-1$
        }
        else if (clazz == Date.class)
        {
            System.out.println(clazz.toString());
        }
        else if (clazz == BigInteger.class)
        {
            template = "template/sectionTemplates/BigIntegerSectionClass.javajet"; //$NON-NLS-1$
        }
        return template;
    }
}
