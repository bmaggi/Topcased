package org.topcased.properties.configurator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class GeneratorUtils
{

    public static String capName(String name)
    {
        if (name == null)
            return name;
        if (name.length() == 0)
            return name;
        else
            return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static String uncapName(String name)
    {
        if (name == null)
            return name;
        if (name.length() == 0)
            return name;
        else
            return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    public static String replaceSpecialCharacters(String string)
    {
        String newString = string.replaceAll("&", "&amp;");
        newString = newString.replaceAll("<", "&lt;");
        newString = newString.replaceAll(">", "&gt;");
        return newString;

    }

    public static String getSectionClassName(String name)
    {
        int i = name.lastIndexOf(".");
        if (i == -1)
        {
            return capName(name);
        }
        else if (i < name.length())
        {
            String className = name.substring(i + 1, name.length());
            return capName(className);
        }
        else
        {
            name = name.substring(0, i - 1);
            return getSectionClassName(name);
        }
    }

    /**
     * Remove special characters that would cause error in an XML file.
     * 
     * @param string
     * @return The string without special characters
     */
    public static String removeSpecialCharacters(String string)
    {
        String newString = string.replaceAll("&", "");
        newString = newString.replaceAll("<", "");
        newString = newString.replaceAll(">", "");
        return newString;

    }

    /**
     * Remove the blanks in the given string
     * 
     * @param string
     * @return The string without blank
     */
    public static String removeSpaces(String string)
    {
        return string.replaceAll(" ", "");
    }

    /**
     * Return a string ID weel formed
     * 
     * @param idMalformed an ID not formated correctly
     * @return The corresponding well formed string
     */
    public static String formatId(String idMalformed)
    {
        return removeSpaces(removeSpecialCharacters(idMalformed)).toLowerCase();
    }

    public static Collection collectContainedObjects(Object object)
    {
        Collection containedObjects = new ArrayList();
        if (object instanceof GenClass)
        {
            GenClass gClass = (GenClass) object;
            Collection genFeatures = collectAllContainmentFeatures(gClass);
            for (Iterator iter = genFeatures.iterator(); iter.hasNext();)
            {
                GenFeature feature = (GenFeature) iter.next();
                containedObjects.addAll(gClass.getChildrenClasses(feature));
            }
        }
        return containedObjects;
    }

    public static Collection collectAllContainmentFeatures(Object object)
    {
        Collection features = new ArrayList();
        if (object instanceof GenClass)
        {
            GenClass gClass = (GenClass) object;
            List genFeatures = gClass.getAllGenFeatures();
            for (Iterator iter = genFeatures.iterator(); iter.hasNext();)
            {
                GenFeature element = (GenFeature) iter.next();
                EStructuralFeature feature = element.getEcoreFeature();
                if (feature instanceof EReference && ((EReference) feature).isContainment())
                {
                    features.add(element);
                }
            }
        }
        return features;
    }

    public static Collection collectAllNonContainmentFeatures(Object object)
    {
        Collection features = new ArrayList();
        if (object instanceof GenClass)
        {
            GenClass gClass = (GenClass) object;
            features.addAll(gClass.getAllGenFeatures());
            features.removeAll(collectAllContainmentFeatures(object));
        }
        return features;
    }
}
